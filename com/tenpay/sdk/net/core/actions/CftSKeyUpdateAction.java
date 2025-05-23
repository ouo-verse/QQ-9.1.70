package com.tenpay.sdk.net.core.actions;

import com.tenpay.ErrorCode;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.net.core.comm.CftSKey;
import com.tenpay.sdk.net.core.comm.CftSKeyCacheUtils;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.result.NetResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/CftSKeyUpdateAction;", "Lcom/tenpay/sdk/net/core/actions/IByPassAction;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "()V", "onBeforeCallback", "", "url", "", "result", "updateCftSKey", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class CftSKeyUpdateAction implements IByPassAction<NetResult> {

    @NotNull
    private static final String KEY_IS_UPDATE_CFT_SKEY = "is_update_cft_skey";

    @NotNull
    public static final String TAG = "QWalletHttp-CftSKeyUpdateAction";

    private final void updateCftSKey(NetResult result) {
        String str;
        boolean z16;
        Map mutableMapOf;
        Map<String, String> paramMap = result.getRequest().getParamMap();
        if (paramMap != null) {
            str = paramMap.get(KEY_IS_UPDATE_CFT_SKEY);
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "1")) {
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, TAG, "ignored update cftSKey action in same request", null, 4, null);
            return;
        }
        ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, TAG, "start updateCftSKey", null, 4, null);
        String account = result.getRequest().getAccount();
        if (account.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            account = com.tencent.mobileqq.base.a.c();
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("uin", account), new Pair(KEY_IS_UPDATE_CFT_SKEY, "1"));
        NetSender.with(null, Cgi.URL_WALLET_GATE, mutableMapOf, account).encrypt(true).request(null);
    }

    @Override // com.tenpay.sdk.net.core.actions.IByPassAction
    public void onBeforeCallback(@NotNull String url, @NotNull NetResult result) {
        JSONObject jSONObject;
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        Object bizResponse = result.getBizResponse();
        String str = null;
        if (bizResponse instanceof JSONObject) {
            jSONObject = (JSONObject) bizResponse;
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("retcode");
        Intrinsics.checkNotNullExpressionValue(optString, "bizRsp.optString(NetParams.RET_CODE)");
        if (!Intrinsics.areEqual(ErrorCode.ERR_RET_DATA, optString) && !Intrinsics.areEqual(ErrorCode.ERR_TIME_OUT, optString)) {
            if (!result.getIsBizSucceed() && Intrinsics.areEqual("66201001", optString) && !CftSKeyCacheUtils.hasCftSKey(result.getRequest().getAccount())) {
                updateCftSKey(result);
                return;
            }
            String account = result.getRequest().getAccount();
            String optString2 = jSONObject.optString("skey");
            long j3 = -1;
            long optLong = jSONObject.optLong("skey_expire", -1L);
            int optInt = jSONObject.optInt("trans_seq", -1);
            if (optLong <= 0) {
                CftSKey cftSKey = CftSKeyCacheUtils.INSTANCE.getCftSKey(account);
                if (cftSKey != null) {
                    str = cftSKey.getSkey();
                }
                if (Intrinsics.areEqual(str, optString2)) {
                    if (cftSKey != null) {
                        j3 = cftSKey.getExpireTime();
                    }
                    ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, TAG, "use last expireTime: " + j3, null, 4, null);
                    optLong = j3;
                }
            }
            if (optString2 != null && optString2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && optLong > 0 && optInt >= 0) {
                CftSKeyCacheUtils.INSTANCE.saveCftSKey(account, optString2, Long.valueOf(optLong), Integer.valueOf(optInt));
                return;
            }
            return;
        }
        CftSKeyCacheUtils.INSTANCE.clearCftSKey(result.getRequest().getAccount());
        updateCftSKey(result);
    }
}
