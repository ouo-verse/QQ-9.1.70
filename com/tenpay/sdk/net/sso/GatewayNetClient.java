package com.tenpay.sdk.net.sso;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$OriginCgiReq;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$OriginCgiRsp;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$TransInfo;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.client.INetClient;
import com.tenpay.sdk.net.core.comm.SessionKey;
import com.tenpay.sdk.net.core.encrypt.DecryptResult;
import com.tenpay.sdk.net.core.processor.EncryptProcessor;
import com.tenpay.sdk.net.core.processor.PsKeyProcessor;
import com.tenpay.sdk.net.core.task.NetTask;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import com.tenpay.sdk.net.sso.PaySsoCmd;
import com.tenpay.sdk.net.utils.ErrorCodeFormat;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0004J>\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0011H\u0002J6\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0011H\u0002J \u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0003J(\u0010\u001d\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tenpay/sdk/net/sso/GatewayNetClient;", "Lcom/tenpay/sdk/net/core/client/INetClient;", "Lcom/tenpay/sdk/net/sso/PaySsoTask;", "Lcom/tenpay/sdk/net/sso/PaySsoResult;", "()V", "encryptProcessor", "Lcom/tenpay/sdk/net/core/processor/EncryptProcessor;", "onRequestSuccess", "", "rspBodyText", "", "netTask", "sessionKey", "Lcom/tenpay/sdk/net/core/comm/SessionKey;", "encryptResult", "Lcom/tenpay/sdk/net/core/processor/EncryptProcessor$ProcessResult;", "callback", "Lkotlin/Function1;", "onSsoRequestFail", "task", "retCode", "", "exception", "", "processResponse", "isSuccessful", "", "decryptContent", "result", "sendRequest", "Lcom/tenpay/sdk/net/core/task/NetTask;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class GatewayNetClient implements INetClient<PaySsoTask, PaySsoResult> {

    @NotNull
    private static final String TAG = "QWalletHttp-GatewayCgi";

    @NotNull
    private final EncryptProcessor encryptProcessor = new EncryptProcessor();

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestSuccess(String rspBodyText, PaySsoTask netTask, SessionKey sessionKey, EncryptProcessor.ProcessResult encryptResult, Function1<? super PaySsoResult, Unit> callback) {
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[Catch: JSONException -> 0x001f, TryCatch #0 {JSONException -> 0x001f, blocks: (B:17:0x0016, B:7:0x0024, B:9:0x002f, B:10:0x0064, B:13:0x0033, B:14:0x0068, B:15:0x0070), top: B:16:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024 A[Catch: JSONException -> 0x001f, TryCatch #0 {JSONException -> 0x001f, blocks: (B:17:0x0016, B:7:0x0024, B:9:0x002f, B:10:0x0064, B:13:0x0033, B:14:0x0068, B:15:0x0070), top: B:16:0x0016 }] */
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
    public void sendRequest(@NotNull NetTask<?> netTask, @NotNull Function1<? super PaySsoResult, Unit> callback) {
        String substringAfterLast$default;
        String substringBefore$default;
        String str;
        int i3;
        String joinToString$default;
        PaySsoCmd.Gateway gateway;
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
        try {
            SessionKey sessionKey = new SessionKey(substringBefore$default, PsKeyProcessor.INSTANCE.getPsKey(originUrl), ((PaySsoTask) netTask).getSsoRequest().getAccount());
            try {
                EncryptProcessor.ProcessResult processEncrypt = this.encryptProcessor.processEncrypt(originUrl, sessionKey, map, false, true, netTask.getStatisticInfo());
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(processEncrypt.getBodyData().entrySet(), ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<Map.Entry<String, String>, CharSequence>() { // from class: com.tenpay.sdk.net.sso.GatewayNetClient$sendRequest$bodyString$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull Map.Entry<String, String> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return ((Object) it.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(it.getValue(), "UTF-8");
                    }
                }, 30, null);
                PaySsoCmd paySsoCmd = ((PaySsoTask) netTask).getSsoRequest().getPaySsoCmd();
                if (paySsoCmd instanceof PaySsoCmd.Gateway) {
                    gateway = (PaySsoCmd.Gateway) paySsoCmd;
                } else {
                    gateway = null;
                }
                try {
                    if (gateway == null) {
                        QLog.w(TAG, 1, "paySsoCmd is not gateway: " + ((PaySsoTask) netTask).getSsoRequest().getPaySsoCmd());
                        onSsoRequestFail((PaySsoTask) netTask, -3001, null, callback);
                        return;
                    }
                    QLog.i(TAG, 1, "send sso " + gateway + " " + joinToString$default);
                    PayGatewayProto$OriginCgiReq payGatewayProto$OriginCgiReq = new PayGatewayProto$OriginCgiReq();
                    payGatewayProto$OriginCgiReq.data.set(ByteStringMicro.copyFromUtf8(joinToString$default));
                    str = substringBefore$default;
                    i3 = -3001;
                    PaySsoCmd.Gateway gateway2 = gateway;
                    try {
                        GatewayNetClient$sendRequest$ssoCallback$1 gatewayNetClient$sendRequest$ssoCallback$1 = new GatewayNetClient$sendRequest$ssoCallback$1(netTask, this, sessionKey, processEncrypt, callback, str, originUrl);
                        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
                        String service = gateway2.getService();
                        String method = gateway2.getMethod();
                        boolean isEncrypt = ((PaySsoTask) netTask).getSsoRequest().getIsEncrypt();
                        List<PayGatewayProto$TransInfo> loadForRequest = PaySsoCookie.INSTANCE.loadForRequest(originUrl);
                        Object newInstance = PayGatewayProto$OriginCgiRsp.class.newInstance();
                        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
                        qWalletGatewayServlet.sendRequest(service, method, payGatewayProto$OriginCgiReq, (MessageMicro) newInstance, isEncrypt, true, false, loadForRequest, gatewayNetClient$sendRequest$ssoCallback$1);
                    } catch (Exception e16) {
                        e = e16;
                        onSsoRequestFail(paySsoTask, i3, e, callback);
                        QLog.w(TAG, 1, "send sso " + str + " fail", e);
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = substringBefore$default;
                    i3 = 1;
                }
            } catch (Exception e18) {
                e = e18;
                str = substringBefore$default;
                i3 = -3001;
            }
        } catch (Exception e19) {
            e = e19;
            str = substringBefore$default;
            i3 = -3001;
        }
    }
}
