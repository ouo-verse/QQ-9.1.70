package com.tenpay.sdk.net.http.response;

import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.task.NetTask;
import com.tenpay.sdk.net.http.result.HttpResult;
import com.tenpay.sdk.net.utils.ErrorCodeFormat;
import com.tenpay.sdk.net.utils.PayNetMockUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/net/http/response/PayCgiRspProcessor;", "Lcom/tenpay/sdk/net/core/task/NetTask$ResponseProcessor;", "Lokhttp3/Response;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "()V", "processResponse", "", "response", "result", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayCgiRspProcessor implements NetTask.ResponseProcessor<Response, HttpResult> {

    @NotNull
    public static final String TAG = "QWalletHttp-ResponseProcessor";

    @Override // com.tenpay.sdk.net.core.task.NetTask.ResponseProcessor
    public void processResponse(@Nullable Response response, @NotNull HttpResult result) {
        ResponseBody body;
        Intrinsics.checkNotNullParameter(result, "result");
        boolean z16 = response != null && response.isSuccessful();
        result.setConnectSucceed(z16);
        result.setResponseHeaders(response != null ? response.headers() : null);
        if (z16) {
            String string = (response == null || (body = response.body()) == null) ? null : body.string();
            try {
                if (string != null) {
                    JSONObject jSONObject = new JSONObject(string);
                    JSONObject tryMockCgiData = PayNetMockUtil.INSTANCE.tryMockCgiData(result.getHttpRequest().getRequestUrl());
                    if (tryMockCgiData != null) {
                        jSONObject = tryMockCgiData;
                    }
                    int optInt = jSONObject.optInt("retcode");
                    if (optInt == 0) {
                        result.setBizSucceed(true);
                    } else {
                        result.setBizSucceed(false);
                        jSONObject.put("retcode", ErrorCodeFormat.INSTANCE.formatErrCode(result.getHttpRequest(), null, optInt));
                        QLog.w(TAG, 1, "request biz fail: retCode=" + optInt + ", retMsg=" + jSONObject.optString("retmsg"));
                    }
                    result.setBizResponse(jSONObject);
                    return;
                }
                throw new JSONException("bodyData is empty");
            } catch (JSONException e16) {
                QLog.w(TAG, 1, "parse rsp fail content not JSONObject: " + string);
                result.setThrowable(e16);
                result.setBizResponse(ErrorCodeFormat.INSTANCE.createErrorJson(result.getHttpRequest(), null, -2001));
                return;
            }
        }
        int code = response != null ? response.code() : -1;
        QLog.w(TAG, 1, "rsp biz fail, http code = " + code);
        result.setBizResponse(ErrorCodeFormat.INSTANCE.createErrorJson(result.getHttpRequest(), result.getThrowable(), code));
    }
}
