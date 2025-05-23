package com.tencent.mobileqq.pushnotice.proxy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiver;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import cooperation.vip.ad.w;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class XiaomiPushProcessor extends ThirdPushProcessorImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f261393f;

    /* loaded from: classes16.dex */
    public static class XiaomiPushMsgReceiverImpl extends PushMessageReceiver {
        static IPatchRedirector $redirector_;

        public XiaomiPushMsgReceiverImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private void exposeReport(String str) {
            String str2;
            String str3;
            try {
                String optString = new JSONObject(str).optString("trigger_info");
                if (!TextUtils.isEmpty(optString)) {
                    String optString2 = new JSONObject(optString).optString("oac_triggle");
                    String pushIdFromOacTrigger = getPushIdFromOacTrigger(optString2);
                    str2 = getNotifyIdFromOacTrigger(optString2);
                    str3 = pushIdFromOacTrigger;
                } else {
                    str2 = "";
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str2)) {
                    OnlineModulePushReceiver.Companion companion = OnlineModulePushReceiver.INSTANCE;
                    if (!companion.d(companion.g(str2))) {
                        return;
                    } else {
                        companion.o(companion.g(str2));
                    }
                }
                w.h(117, str3, 1, optString, "vab_push", "vab_push");
            } catch (JSONException e16) {
                QLog.e("XIAOMIPUSH", 1, "exposeReport report: exception.", e16);
            }
        }

        private String getMessageLogString(@NonNull MiPushMessage miPushMessage) {
            return "messageId={" + miPushMessage.getMessageId() + "},passThrough={" + miPushMessage.getPassThrough() + "},alias={" + miPushMessage.getAlias() + "},topic={" + miPushMessage.getTopic() + "},userAccount={" + miPushMessage.getUserAccount() + "},content={" + miPushMessage.getContent() + "},isNotified={" + miPushMessage.isNotified() + "},notifyId={" + miPushMessage.getNotifyId() + "},notifyType={" + miPushMessage.getNotifyType() + "}, category={" + miPushMessage.getCategory() + "}, extra={" + miPushMessage.getExtra() + "}";
        }

        private String getNotifyIdFromOacTrigger(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                if (str2.contains("nid=")) {
                    return str2.replace("nid=", "");
                }
            }
            return "";
        }

        private String getPushIdFromOacTrigger(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                if (str2.contains("ad_id=")) {
                    return str2.replace("ad_id=", "");
                }
            }
            return "";
        }

        private void setToken(MiPushCommandMessage miPushCommandMessage) {
            String str;
            String command = miPushCommandMessage.getCommand();
            List<String> commandArguments = miPushCommandMessage.getCommandArguments();
            if (commandArguments != null && commandArguments.size() > 0) {
                str = commandArguments.get(0);
            } else {
                str = null;
            }
            if ("register".equals(command) && miPushCommandMessage.getResultCode() == 0) {
                QLog.d("XIAOMIPUSH", 1, "setToken success:" + str);
                if (!TextUtils.isEmpty(str)) {
                    ThirdPushManager.getInstance().setToken(str);
                }
            }
        }

        @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
        public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) miPushCommandMessage);
                return;
            }
            QLog.d("XIAOMIPUSH", 1, "onCommandResult is called. " + miPushCommandMessage.toString());
            setToken(miPushCommandMessage);
        }

        @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
        public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) miPushMessage);
                return;
            }
            QLog.d("XIAOMIPUSH", 1, "onNotificationMessageArrived is called. " + getMessageLogString(miPushMessage));
            if (miPushMessage.getExtra() != null) {
                str = miPushMessage.getExtra().get("client_data");
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String optString = new JSONObject(str).optString("report_data");
                if (!TextUtils.isEmpty(optString)) {
                    exposeReport(optString);
                }
            } catch (JSONException e16) {
                QLog.e("XIAOMIPUSH", 1, "onNotificationMessageArrived report: exception.", e16);
            }
        }

        @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
        public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) miPushMessage);
                return;
            }
            QLog.d("XIAOMIPUSH", 1, "onNotificationMessageClicked is called. " + miPushMessage.toString());
            if (miPushMessage.getExtra() != null) {
                str = miPushMessage.getExtra().get("client_data");
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    intent.putExtra(str2, jSONObject.optString(str2));
                }
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (JSONException e16) {
                QLog.e("XIAOMIPUSH", 1, "onNotificationMessageClicked report: exception.", e16);
            }
        }

        @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
        public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) miPushCommandMessage);
                return;
            }
            QLog.d("XIAOMIPUSH", 1, "onReceiveRegisterResult is called. " + miPushCommandMessage.toString());
            setToken(miPushCommandMessage);
        }
    }

    public XiaomiPushProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f261393f = p();
        }
    }

    private boolean p() {
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null || MobileQQ.sProcessId != 1 || (runtime = application.getRuntime()) == null) {
            return false;
        }
        return ((IFeatureRuntimeService) runtime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("xiaomi_push_switch_869111799", true);
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            super.a(str);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        } else {
            super.b(context);
            MiPushClient.r(context, 0);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.f261393f) {
            super.d();
            return;
        }
        try {
            MiPushClient.K(BaseApplication.getContext(), "2882303761517135937", "5281713515937");
        } catch (Exception e16) {
            QLog.e("XIAOMIPUSH", 1, "init error! ", e16);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl
    public String k() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!this.f261393f) {
            return super.k();
        }
        try {
            str = MiPushClient.E(BaseApplication.getContext());
        } catch (Exception e16) {
            QLog.e("XIAOMIPUSH", 1, "getToken error! ", e16);
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.f261389a = str;
        }
        QLog.d("XIAOMIPUSH", 1, "getToken success:" + this.f261389a);
        return this.f261389a;
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl
    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }
}
