package com.tenpay.sdk.net.core.actions;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tenpay.ErrorCode;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.core.result.NetResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/DomainSettingAction;", "Lcom/tenpay/sdk/net/core/actions/IByPassAction;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "()V", "getSp", "Landroid/content/SharedPreferences;", "onBeforeCallback", "", "url", "", "result", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class DomainSettingAction implements IByPassAction<NetResult> {

    @NotNull
    public static final String SP_KEY_WALLET_DOMAIN = "wallet_domain";

    private final SharedPreferences getSp() {
        return MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences("qb_tenpay_addr", 0);
    }

    @Override // com.tenpay.sdk.net.core.actions.IByPassAction
    public void onBeforeCallback(@NotNull String url, @NotNull NetResult result) {
        JSONObject jSONObject;
        boolean contains$default;
        SharedPreferences sp5;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        boolean contains$default2;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor remove;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        Object bizResponse = result.getBizResponse();
        if (bizResponse instanceof JSONObject) {
            jSONObject = (JSONObject) bizResponse;
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("retcode");
        Intrinsics.checkNotNullExpressionValue(optString, "bizJSON.optString(NetParams.RET_CODE)");
        if (Intrinsics.areEqual(ErrorCode.ERR_RET_DATA, optString)) {
            Cgi.wallet_domain = null;
            SharedPreferences sp6 = getSp();
            if (sp6 != null && (edit2 = sp6.edit()) != null && (remove = edit2.remove(SP_KEY_WALLET_DOMAIN)) != null) {
                remove.apply();
                return;
            }
            return;
        }
        String URL_WALLET_GATE = Cgi.URL_WALLET_GATE;
        Intrinsics.checkNotNullExpressionValue(URL_WALLET_GATE, "URL_WALLET_GATE");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) URL_WALLET_GATE, false, 2, (Object) null);
        if (!contains$default) {
            String URI_PAY_GATE = Cgi.URI_PAY_GATE;
            Intrinsics.checkNotNullExpressionValue(URI_PAY_GATE, "URI_PAY_GATE");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) URI_PAY_GATE, false, 2, (Object) null);
            if (!contains$default2) {
                return;
            }
        }
        String optString2 = jSONObject.optString("domain_name");
        Cgi.wallet_domain = optString2;
        if (!TextUtils.isEmpty(optString2) && (sp5 = getSp()) != null && (edit = sp5.edit()) != null && (putString = edit.putString(SP_KEY_WALLET_DOMAIN, Cgi.wallet_domain)) != null) {
            putString.apply();
        }
    }
}
