package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.vivo.push.PushClientConstants;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f37387a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");

    /* renamed from: b, reason: collision with root package name */
    public Context f37388b;

    /* renamed from: c, reason: collision with root package name */
    public HuaweiApi<Api.ApiOptions.NoOptions> f37389c;

    public HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.f37388b = context;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(context, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, new PushClientBuilder());
        this.f37389c = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        HmsMessaging hmsMessaging;
        synchronized (HmsMessaging.class) {
            hmsMessaging = new HmsMessaging(context);
        }
        return hmsMessaging;
    }

    public final Task<Void> a(String str, String str2) {
        String reportEntry = PushBiUtil.reportEntry(this.f37388b, PushNaming.SUBSCRIBE);
        if (str != null && f37387a.matcher(str).matches()) {
            if (ProxyCenter.getProxy() != null) {
                HMSLog.i("HmsMessaging", "use proxy subscribe.");
                return TextUtils.equals(str2, "Sub") ? ProxyCenter.getProxy().subscribe(this.f37388b, str, reportEntry) : ProxyCenter.getProxy().unsubscribe(this.f37388b, str, reportEntry);
            }
            try {
                ErrorEnum a16 = d.a(this.f37388b);
                if (a16 == ErrorEnum.SUCCESS) {
                    if (NetWorkUtil.getNetworkType(this.f37388b) != 0) {
                        SubscribeReq subscribeReq = new SubscribeReq(this.f37388b, str2, str);
                        subscribeReq.setToken(BaseUtils.getLocalToken(this.f37388b, null));
                        if (s.b()) {
                            return this.f37389c.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                        }
                        return this.f37389c.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                    }
                    HMSLog.e("HmsMessaging", RaffleJsPlugin.ERROR_REPORT_NO_NETWORK);
                    throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
                }
                throw a16.toApiException();
            } catch (ApiException e16) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setException(e16);
                PushBiUtil.reportExit(this.f37388b, PushNaming.SUBSCRIBE, reportEntry, e16.getStatusCode());
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
                taskCompletionSource2.setException(errorEnum.toApiException());
                PushBiUtil.reportExit(this.f37388b, PushNaming.SUBSCRIBE, reportEntry, errorEnum);
                return taskCompletionSource2.getTask();
            }
        }
        PushBiUtil.reportExit(this.f37388b, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f37388b);
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getProxy() == null) {
            HMSLog.i("HmsMessaging", "send upstream message");
            a(remoteMessage);
        } else {
            HMSLog.e("HmsMessaging", "Operation(send) unsupported");
            throw new UnsupportedOperationException("Operation(send) unsupported");
        }
    }

    public void setAutoInitEnabled(boolean z16) {
        AutoInitHelper.setAutoInitEnabled(this.f37388b, z16);
    }

    public Task<Void> subscribe(String str) {
        HMSLog.i("HmsMessaging", "invoke subscribe");
        return a(str, "Sub");
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn off for proxy");
            return ProxyCenter.getProxy().turnOff(this.f37388b, null);
        }
        HMSLog.i("HmsMessaging", "invoke turnOffPush");
        return a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn on for proxy");
            return ProxyCenter.getProxy().turnOn(this.f37388b, null);
        }
        HMSLog.i("HmsMessaging", "invoke turnOnPush");
        return a(true);
    }

    public Task<Void> unsubscribe(String str) {
        HMSLog.i("HmsMessaging", "invoke unsubscribe");
        return a(str, "UnSub");
    }

    public final void a(RemoteMessage remoteMessage) {
        String reportEntry = PushBiUtil.reportEntry(this.f37388b, PushNaming.UPSEND_MSG);
        ErrorEnum a16 = d.a(this.f37388b);
        if (a16 == ErrorEnum.SUCCESS) {
            if (!TextUtils.isEmpty(remoteMessage.getTo())) {
                if (!TextUtils.isEmpty(remoteMessage.getMessageId())) {
                    if (!TextUtils.isEmpty(remoteMessage.getData())) {
                        UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
                        upSendMsgReq.setPackageName(this.f37388b.getPackageName());
                        upSendMsgReq.setMessageId(remoteMessage.getMessageId());
                        upSendMsgReq.setTo(remoteMessage.getTo());
                        upSendMsgReq.setData(remoteMessage.getData());
                        upSendMsgReq.setMessageType(remoteMessage.getMessageType());
                        upSendMsgReq.setTtl(remoteMessage.getTtl());
                        upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
                        upSendMsgReq.setSendMode(remoteMessage.getSendMode());
                        upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
                        if (s.b()) {
                            this.f37389c.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), reportEntry));
                            return;
                        } else {
                            a(upSendMsgReq, reportEntry);
                            return;
                        }
                    }
                    HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
                    PushBiUtil.reportExit(this.f37388b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                    throw new IllegalArgumentException("Mandatory parameter 'data' missing");
                }
                HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
                PushBiUtil.reportExit(this.f37388b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
            }
            HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
            PushBiUtil.reportExit(this.f37388b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        }
        HMSLog.e("HmsMessaging", "Message sent failed:" + a16.getExternalCode() + ':' + a16.getMessage());
        PushBiUtil.reportExit(this.f37388b, PushNaming.UPSEND_MSG, reportEntry, a16);
        throw new UnsupportedOperationException(a16.getMessage());
    }

    public final Task<Void> a(boolean z16) {
        String reportEntry = PushBiUtil.reportEntry(this.f37388b, PushNaming.SET_NOTIFY_FLAG);
        if (s.d(this.f37388b) && !s.b()) {
            if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
                HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                ErrorEnum errorEnum = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED;
                taskCompletionSource.setException(errorEnum.toApiException());
                PushBiUtil.reportExit(this.f37388b, PushNaming.SET_NOTIFY_FLAG, reportEntry, errorEnum);
                return taskCompletionSource.getTask();
            }
            if (s.b(this.f37388b) < 90101310) {
                HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
                Intent putExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(this.f37388b, this.f37388b.getPackageName() + "#" + z16));
                putExtra.setPackage("android");
                return Tasks.callInBackground(new IntentCallable(this.f37388b, putExtra, reportEntry));
            }
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
            new PushPreferences(this.f37388b, "push_notify_flag").saveBoolean("notify_msg_enable", !z16);
            Uri parse = Uri.parse("content://" + this.f37388b.getPackageName() + ".huawei.push.provider/push_notify_flag.xml");
            Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
            intent.putExtra("type", "enalbeFlag");
            intent.putExtra(PushClientConstants.TAG_PKG_NAME, this.f37388b.getPackageName());
            intent.putExtra("url", parse);
            intent.setPackage("android");
            return Tasks.callInBackground(new IntentCallable(this.f37388b, intent, reportEntry));
        }
        HMSLog.i("HmsMessaging", "turn on/off with AIDL");
        EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
        enableNotifyReq.setPackageName(this.f37388b.getPackageName());
        enableNotifyReq.setEnable(z16);
        return this.f37389c.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), reportEntry));
    }

    public final void a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(BaseUtils.getLocalToken(this.f37388b, null));
        try {
            this.f37389c.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e16) {
            if (e16.getCause() instanceof ApiException) {
                PushBiUtil.reportExit(this.f37388b, PushNaming.UPSEND_MSG, str, ((ApiException) e16.getCause()).getStatusCode());
            } else {
                PushBiUtil.reportExit(this.f37388b, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
