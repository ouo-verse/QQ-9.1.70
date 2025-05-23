package a15;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.openpay.data.pay.PayApi;
import com.tencent.mobileqq.openpay.data.pay.PayApiV2;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.vivo.push.PushClientConstants;
import cooperation.qwallet.open.data.AppPayExt;
import cooperation.qwallet.open.data.PayInfo;
import cooperation.qwallet.open.data.PayInfoBase;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006H\u0007\u00a8\u0006\u0015"}, d2 = {"La15/a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "apiName", "Lcooperation/qwallet/open/data/PayInfo;", "a", "b", "c", ark.ARKMETADATA_JSON, "callbackSn", "e", "d", "payJson", "", "f", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f25352a = new a();

    a() {
    }

    @JvmStatic
    @Nullable
    public static final PayInfo a(@NotNull Context context, @NotNull Intent intent, @NotNull String apiName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (TextUtils.equals(OpenConstants.ApiName.PAY, apiName)) {
            return f25352a.b(context, intent, apiName);
        }
        if (TextUtils.equals(OpenConstants.ApiName.PAY_V2, apiName)) {
            return f25352a.c(context, intent, apiName);
        }
        return null;
    }

    private final PayInfo b(Context context, Intent intent, String apiName) {
        PayApi payApi = new PayApi();
        payApi.fromBundle(intent.getExtras());
        return new PayInfo(apiName, payApi.appId, payApi.bargainorId, payApi.tokenId, payApi.nonce, Long.valueOf(payApi.timeStamp), null, payApi.sig, payApi.sigType, null, null, payApi.serialNumber, payApi.callbackScheme, new PayInfoBase(1, 4, 1, 1, ah.Q(context), null, 32, null), AppPayExt.INSTANCE.a(context, intent), 512, null);
    }

    private final PayInfo c(Context context, Intent intent, String apiName) {
        PayApiV2 payApiV2 = new PayApiV2();
        Bundle extras = intent.getExtras();
        payApiV2.fromBundle(extras);
        payApiV2.fromQQSignBundle(extras);
        String str = payApiV2.appId;
        String str2 = payApiV2.partnerId;
        String str3 = payApiV2.prepayId;
        String str4 = payApiV2.nonceStr;
        String str5 = payApiV2.timeStamp;
        Intrinsics.checkNotNullExpressionValue(str5, "payApi.timeStamp");
        return new PayInfo(apiName, str, str2, str3, str4, Long.valueOf(Long.parseLong(str5)), payApiV2.packageValue, payApiV2.sign, payApiV2.signType, null, payApiV2.extData, payApiV2.transaction, payApiV2.callbackScheme, new PayInfoBase(1, 4, 1, 1, ah.Q(context), null, 32, null), AppPayExt.INSTANCE.b(context, intent, payApiV2), 512, null);
    }

    @JvmStatic
    @NotNull
    public static final PayInfo d(@Nullable Context context, @NotNull String json) {
        String str;
        String str2;
        String str3;
        String str4;
        Long l3;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        JSONObject optJSONObject = jSONObject.optJSONObject("action");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("application");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("params");
        String str8 = null;
        if (optJSONObject2 != null) {
            str = optJSONObject2.optString("appId");
        } else {
            str = null;
        }
        if (optJSONObject3 != null) {
            str2 = optJSONObject3.optString("bargainorId");
        } else {
            str2 = null;
        }
        if (optJSONObject3 != null) {
            str3 = optJSONObject3.optString("tokenId");
        } else {
            str3 = null;
        }
        if (optJSONObject3 != null) {
            str4 = optJSONObject3.optString("nonce");
        } else {
            str4 = null;
        }
        if (optJSONObject3 != null) {
            l3 = Long.valueOf(optJSONObject3.optLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY));
        } else {
            l3 = null;
        }
        if (optJSONObject3 != null) {
            str5 = optJSONObject3.optString(PreloadTRTCPlayerParams.KEY_SIG);
        } else {
            str5 = null;
        }
        if (optJSONObject != null) {
            str6 = optJSONObject.optString(IECDtReport.ACTION_IDENTIFIER);
        } else {
            str6 = null;
        }
        if (optJSONObject2 != null) {
            str7 = optJSONObject2.optString("urlScheme");
        } else {
            str7 = null;
        }
        PayInfoBase payInfoBase = new PayInfoBase(1, 4, 3, 2, ah.Q(context), null, 32, null);
        if (optJSONObject2 != null) {
            str8 = optJSONObject2.optString(PushClientConstants.TAG_PKG_NAME);
        }
        return new PayInfo(OpenConstants.ApiName.PAY, str, str2, str3, str4, l3, null, str5, "HMAC-SHA1", null, null, str6, str7, payInfoBase, new AppPayExt(null, null, null, str8, null, null, 55, null), 1536, null);
    }

    @JvmStatic
    @NotNull
    public static final PayInfo e(@Nullable Context context, @NotNull String json, @Nullable String callbackSn) {
        int i3;
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        String optString = jSONObject.optString("tradeType", "JSAPI");
        String optString2 = jSONObject.optString("appId");
        String optString3 = jSONObject.optString("prepayId");
        String optString4 = jSONObject.optString(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY);
        Long valueOf = Long.valueOf(jSONObject.optLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY));
        String optString5 = jSONObject.optString("package");
        String optString6 = jSONObject.optString(PayProxy.Source.PAY_REQUEST_PAY_SIGN_KEY);
        String optString7 = jSONObject.optString(PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY);
        if (Intrinsics.areEqual(optString, "MWEB")) {
            i3 = 10;
        } else {
            i3 = 1;
        }
        return new PayInfo(OpenConstants.ApiName.PAY_V2, optString2, null, optString3, optString4, valueOf, optString5, optString6, optString7, optString, null, callbackSn, null, new PayInfoBase(1, i3, 2, 0, ah.Q(context), null, 40, null), new AppPayExt(null, null, null, null, null, null, 63, null), 1024, null);
    }

    @JvmStatic
    public static final boolean f(@NotNull String payJson) {
        Intrinsics.checkNotNullParameter(payJson, "payJson");
        if (new JSONObject(payJson).optInt(PayProxy.Source.PAY_REQUEST_PAY_VERSION_KEY) == 1) {
            return true;
        }
        return false;
    }
}
