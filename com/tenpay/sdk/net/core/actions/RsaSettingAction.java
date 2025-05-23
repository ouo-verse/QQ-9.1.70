package com.tenpay.sdk.net.core.actions;

import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.ToolPool;
import com.tenpay.sdk.net.core.result.NetResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/RsaSettingAction;", "Lcom/tenpay/sdk/net/core/actions/IByPassAction;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "()V", "onBeforeCallback", "", "url", "", "result", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class RsaSettingAction implements IByPassAction<NetResult> {

    @NotNull
    public static final String TAG = "QWalletHttp-RsaSettingAction";

    @Override // com.tenpay.sdk.net.core.actions.IByPassAction
    public void onBeforeCallback(@NotNull String url, @NotNull NetResult result) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        Object bizResponse = result.getBizResponse();
        if (bizResponse instanceof JSONObject) {
            jSONObject = (JSONObject) bizResponse;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null && ToolPool.instance().isRSASettingUrl(url)) {
            ToolPool.instance().setPwdEncryptType(jSONObject.optString("pwd_encrypt_type"));
            ToolPool.instance().setParamsEncryptType(jSONObject.optString("params_encrypt_type"));
            QLog.i(TAG, 2, ToolPool.instance().getPwdEncryptType() + " " + ToolPool.instance().getParamsEncryptType());
        }
    }
}
