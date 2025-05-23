package com.tenpay.sdk.net.sso;

import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.fh;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.client.INetClient;
import com.tenpay.sdk.net.core.comm.SessionKey;
import com.tenpay.sdk.net.core.encrypt.DecryptResult;
import com.tenpay.sdk.net.core.processor.EncryptProcessor;
import com.tenpay.sdk.net.core.processor.PsKeyProcessor;
import com.tenpay.sdk.net.core.task.NetTask;
import com.tenpay.sdk.net.sso.PaySsoCmd;
import com.tenpay.sdk.net.utils.ErrorCodeFormat;
import com.tenpay.sdk.net.utils.PayNetMockUtil;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pl2.o;
import pl2.p;
import tencent.im.qqwallet.QWalletHbPreGrab$QQHBReply;
import tencent.im.qqwallet.QWalletHbPreGrab$QQHBRequest;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0004JR\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0013H\u0002J6\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0013H\u0002J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u0003J(\u0010\u001e\u001a\u00020\b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tenpay/sdk/net/sso/HbProxyNetClient;", "Lcom/tenpay/sdk/net/core/client/INetClient;", "Lcom/tenpay/sdk/net/sso/PaySsoTask;", "Lcom/tenpay/sdk/net/sso/PaySsoResult;", "()V", "encryptProcessor", "Lcom/tenpay/sdk/net/core/processor/EncryptProcessor;", "onRequestSuccess", "", "rspMsg", "", "retCode", "rspBodyText", "netTask", "sessionKey", "Lcom/tenpay/sdk/net/core/comm/SessionKey;", "encryptResult", "Lcom/tenpay/sdk/net/core/processor/EncryptProcessor$ProcessResult;", "callback", "Lkotlin/Function1;", "onSsoRequestFail", "task", "", "exception", "", "processResponse", "isSuccessful", "", "decryptContent", "result", "sendRequest", "Lcom/tenpay/sdk/net/core/task/NetTask;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HbProxyNetClient implements INetClient<PaySsoTask, PaySsoResult> {

    @NotNull
    private static final String TAG = "QWalletHttp-HbProxy";

    @NotNull
    private final EncryptProcessor encryptProcessor = new EncryptProcessor();

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestSuccess(String rspMsg, String retCode, String rspBodyText, PaySsoTask netTask, SessionKey sessionKey, EncryptProcessor.ProcessResult encryptResult, Function1<? super PaySsoResult, Unit> callback) {
        String str;
        try {
            DecryptResult processDecrypt = this.encryptProcessor.processDecrypt(true, netTask.getSsoRequest().getIsEcdhEncrypt(), sessionKey, encryptResult.getEncryptResult(), netTask.getStatisticInfo(), rspBodyText);
            PaySsoResult buildResult = netTask.buildResult();
            if (processDecrypt != null) {
                str = processDecrypt.getDecodedPlain();
            } else {
                str = null;
            }
            processResponse(true, str, buildResult);
            callback.invoke(buildResult);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "decrypt fail: " + rspBodyText, th5);
            onSsoRequestFail(netTask, -3001, th5, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSsoRequestFail(PaySsoTask task, int retCode, Throwable exception, Function1<? super PaySsoResult, Unit> callback) {
        JSONObject createErrorJson = ErrorCodeFormat.INSTANCE.createErrorJson(null, exception, retCode);
        PaySsoResult buildResult = task.buildResult();
        buildResult.setConnectSucceed(true);
        buildResult.setBizSucceed(false);
        buildResult.setBizResponse(createErrorJson);
        buildResult.setThrowable(exception);
        callback.invoke(buildResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075 A[Catch: JSONException -> 0x001f, TryCatch #0 {JSONException -> 0x001f, blocks: (B:20:0x0016, B:7:0x0024, B:10:0x0036, B:12:0x003c, B:13:0x0071, B:16:0x0040, B:17:0x0075, B:18:0x007d), top: B:19:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024 A[Catch: JSONException -> 0x001f, TryCatch #0 {JSONException -> 0x001f, blocks: (B:20:0x0016, B:7:0x0024, B:10:0x0036, B:12:0x003c, B:13:0x0071, B:16:0x0040, B:17:0x0075, B:18:0x007d), top: B:19:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void processResponse(boolean isSuccessful, @Nullable String decryptContent, @NotNull PaySsoResult result) throws IllegalArgumentException {
        boolean z16;
        Intrinsics.checkNotNullParameter(result, "result");
        result.setConnectSucceed(isSuccessful);
        if (isSuccessful) {
            if (decryptContent != null) {
                try {
                    if (decryptContent.length() != 0) {
                        z16 = false;
                        if (z16) {
                            JSONObject jSONObject = new JSONObject(decryptContent);
                            JSONObject tryMockCgiData = PayNetMockUtil.INSTANCE.tryMockCgiData(result.getUrl());
                            if (tryMockCgiData != null) {
                                jSONObject = tryMockCgiData;
                            }
                            int optInt = jSONObject.optInt("retcode");
                            if (optInt == 0) {
                                result.setBizSucceed(true);
                            } else {
                                result.setBizSucceed(false);
                                jSONObject.put("retcode", ErrorCodeFormat.INSTANCE.formatErrCode(null, null, optInt));
                                QLog.w(TAG, 1, "request biz fail: retCode=" + optInt + ", retMsg=" + jSONObject.optString("retmsg"));
                            }
                            result.setBizResponse(jSONObject);
                            return;
                        }
                        throw new JSONException("bodyData is empty");
                    }
                } catch (JSONException e16) {
                    QLog.w(TAG, 1, "parse rsp fail content not JSONObject: " + decryptContent);
                    result.setThrowable(e16);
                    result.setBizResponse(ErrorCodeFormat.INSTANCE.createErrorJson(null, e16, -2001));
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
        } else {
            QLog.w(TAG, 1, "rsp biz fail, http code = -1");
            result.setBizResponse(ErrorCodeFormat.INSTANCE.createErrorJson(null, result.getThrowable(), -1));
        }
    }

    @Override // com.tenpay.sdk.net.core.client.INetClient
    public void sendRequest(@NotNull final NetTask<?> netTask, @NotNull final Function1<? super PaySsoResult, Unit> callback) {
        String substringAfterLast$default;
        String substringBefore$default;
        final String str;
        String str2;
        int i3;
        int i16;
        String str3;
        String joinToString$default;
        PaySsoCmd.HbProxy hbProxy;
        Intrinsics.checkNotNullParameter(netTask, "netTask");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(netTask instanceof PaySsoTask)) {
            return;
        }
        PaySsoTask paySsoTask = (PaySsoTask) netTask;
        String originUrl = paySsoTask.getSsoRequest().getOriginUrl();
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(originUrl, '/', (String) null, 2, (Object) null);
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(substringAfterLast$default, '.', (String) null, 2, (Object) null);
        Map<String, String> paramMap = paySsoTask.getSsoRequest().getParamMap();
        if (paramMap == null) {
            paramMap = new LinkedHashMap<>();
        }
        Map<String, String> map = paramMap;
        boolean isEncrypt = paySsoTask.getSsoRequest().getIsEncrypt();
        boolean isEcdhEncrypt = paySsoTask.getSsoRequest().getIsEcdhEncrypt();
        try {
            final SessionKey sessionKey = new SessionKey(substringBefore$default, PsKeyProcessor.INSTANCE.getPsKey(originUrl), ((PaySsoTask) netTask).getSsoRequest().getAccount());
            final EncryptProcessor.ProcessResult processEncrypt = this.encryptProcessor.processEncrypt(originUrl, sessionKey, map, isEncrypt, isEcdhEncrypt, netTask.getStatisticInfo());
            if (isEcdhEncrypt) {
                str3 = "ecdh";
            } else {
                str3 = SecretUtils.DES;
            }
            QLog.d(TAG, 2, "after " + str3 + " encrypt: " + processEncrypt.getBodyData());
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(processEncrypt.getBodyData().entrySet(), ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<Map.Entry<String, String>, CharSequence>() { // from class: com.tenpay.sdk.net.sso.HbProxyNetClient$sendRequest$bodyString$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull Map.Entry<String, String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((Object) it.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(it.getValue(), "UTF-8");
                }
            }, 30, null);
            PaySsoCmd paySsoCmd = ((PaySsoTask) netTask).getSsoRequest().getPaySsoCmd();
            if (paySsoCmd instanceof PaySsoCmd.HbProxy) {
                try {
                    hbProxy = (PaySsoCmd.HbProxy) paySsoCmd;
                } catch (Exception e16) {
                    e = e16;
                    str = substringBefore$default;
                    str2 = TAG;
                    i16 = -3001;
                    i3 = 1;
                    onSsoRequestFail(paySsoTask, i16, e, callback);
                    QLog.w(str2, i3, "send sso " + str + " fail", e);
                }
            } else {
                hbProxy = null;
            }
            if (hbProxy == null) {
                QLog.w(TAG, 1, "paySsoCmd is not hbproxy: " + ((PaySsoTask) netTask).getSsoRequest().getPaySsoCmd());
                try {
                    onSsoRequestFail((PaySsoTask) netTask, -3001, null, callback);
                    return;
                } catch (Exception e17) {
                    e = e17;
                    i16 = -3001;
                    str = substringBefore$default;
                    str2 = TAG;
                    i3 = 1;
                    onSsoRequestFail(paySsoTask, i16, e, callback);
                    QLog.w(str2, i3, "send sso " + str + " fail", e);
                }
            }
            try {
                QLog.i(TAG, 1, "send sso " + hbProxy + " " + joinToString$default);
                QWalletHbPreGrab$QQHBRequest qWalletHbPreGrab$QQHBRequest = new QWalletHbPreGrab$QQHBRequest();
                try {
                    qWalletHbPreGrab$QQHBRequest.cgiName.set(hbProxy.getCgiName());
                    qWalletHbPreGrab$QQHBRequest.reqBody.set(ByteStringMicro.copyFromUtf8(joinToString$default));
                    str2 = TAG;
                    i3 = 1;
                    str = substringBefore$default;
                    try {
                        final o<QWalletHbPreGrab$QQHBReply> oVar = new o<QWalletHbPreGrab$QQHBReply>() { // from class: com.tenpay.sdk.net.sso.HbProxyNetClient$sendRequest$ssoCallback$1
                            @Override // pl2.k
                            public void onFail(int errCode, @NotNull String errMsg) {
                                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                                HbProxyNetClient.this.onSsoRequestFail((PaySsoTask) netTask, -3001, null, callback);
                                QLog.w("QWalletHttp-HbProxy", 1, "send sso " + str + " fail: " + errMsg);
                            }

                            @Override // pl2.k
                            public void onSuccess(@NotNull QWalletHbPreGrab$QQHBReply rsp) {
                                Intrinsics.checkNotNullParameter(rsp, "rsp");
                                HbProxyNetClient.this.onRequestSuccess(rsp.retMsg.get(), rsp.retCode.get(), rsp.rspBody.get().toStringUtf8(), (PaySsoTask) netTask, sessionKey, processEncrypt, callback);
                            }
                        };
                        p.Companion companion = p.INSTANCE;
                        String cmd = hbProxy.getCmd();
                        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=" + cmd + " callback: " + oVar + TokenParser.SP);
                        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
                        newIntent.putExtra("cmd", cmd);
                        newIntent.putExtra("data", fh.b(qWalletHbPreGrab$QQHBRequest.toByteArray()));
                        newIntent.putExtra("timeout", 30000L);
                        newIntent.setObserver(new BusinessObserver() { // from class: com.tenpay.sdk.net.sso.HbProxyNetClient$sendRequest$$inlined$sendRequest$default$1
                            @Override // mqq.observer.BusinessObserver
                            public final void onReceive(int i17, boolean z16, Bundle bundle) {
                                int i18;
                                String str4;
                                if (bundle != null) {
                                    i18 = bundle.getInt("rsp_code");
                                } else {
                                    i18 = 1001;
                                }
                                if (bundle != null) {
                                    str4 = bundle.getString("rsp_msg");
                                } else {
                                    str4 = null;
                                }
                                if (z16) {
                                    try {
                                        MessageMicro rsp = ((MessageMicro) QWalletHbPreGrab$QQHBReply.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                                        o oVar2 = o.this;
                                        if (oVar2 != null) {
                                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                                            oVar2.onSuccess((o) rsp);
                                            return;
                                        }
                                        return;
                                    } catch (Exception unused) {
                                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + QWalletHbPreGrab$QQHBReply.class + " failed.");
                                        o oVar3 = o.this;
                                        if (oVar3 != null) {
                                            oVar3.onFail(i18, p.INSTANCE.a());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                o oVar4 = o.this;
                                if (oVar4 != null) {
                                    if (str4 == null) {
                                        str4 = "empty bundle";
                                    }
                                    oVar4.onFail(i18, str4);
                                }
                            }
                        });
                        waitAppRuntime.startServlet(newIntent);
                    } catch (Exception e18) {
                        e = e18;
                        i16 = -3001;
                        onSsoRequestFail(paySsoTask, i16, e, callback);
                        QLog.w(str2, i3, "send sso " + str + " fail", e);
                    }
                } catch (Exception e19) {
                    e = e19;
                    str = substringBefore$default;
                    str2 = TAG;
                    i3 = 1;
                    i16 = -3001;
                    onSsoRequestFail(paySsoTask, i16, e, callback);
                    QLog.w(str2, i3, "send sso " + str + " fail", e);
                }
            } catch (Exception e26) {
                e = e26;
                str = substringBefore$default;
                str2 = TAG;
                i3 = 1;
            }
        } catch (Exception e27) {
            e = e27;
            str = substringBefore$default;
            str2 = TAG;
            i3 = 1;
        }
    }
}
