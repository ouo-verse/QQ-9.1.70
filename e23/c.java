package e23;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.mobileqq.vip.api.h;
import com.tencent.mobileqq.vip.api.k;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Le23/c;", "", "Le23/a;", "payData", "", "type", "", "a", "Le23/b;", "payMouthData", "Lcom/tencent/mobileqq/vip/api/k;", "callBackVip", "c", "", "userId", "aid", "itemId", "Lcom/tencent/mobileqq/vip/api/h;", "b", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Le23/c$a;", "", "Le23/b;", "payMouthData", "", "a", "Le23/a;", "payData", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e23.c$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0096 A[Catch: JSONException -> 0x00a1, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00a1, blocks: (B:3:0x000c, B:5:0x008a, B:10:0x0096), top: B:2:0x000c }] */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String a(@NotNull MonthlyPayData payMouthData) {
            String productId;
            boolean z16;
            Intrinsics.checkNotNullParameter(payMouthData, "payMouthData");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, payMouthData.getProvideUin());
                jSONObject.put("autoPay", payMouthData.getAutoPay());
                jSONObject.put("serviceCode", payMouthData.getServiceCode());
                jSONObject.put("saveValue", payMouthData.getSaveValue());
                jSONObject.put(AdParam.PF, payMouthData.getPf());
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, payMouthData.getProvideType());
                jSONObject.put("offerId", payMouthData.getOfferId());
                jSONObject.put("remark", payMouthData.getRemark());
                jSONObject.put("serviceName", payMouthData.getServiceName());
                jSONObject.put("aid", payMouthData.getAid());
                jSONObject.put("userId", payMouthData.getUserId());
                jSONObject.put("isCanChange", payMouthData.getIsCanChange());
                productId = payMouthData.getProductId();
            } catch (JSONException e16) {
                QLog.e(IVipPayApi.PAY_TAG, 1, " getMouthJsonString put error " + e16);
            }
            if (productId != null && productId.length() != 0) {
                z16 = false;
                if (!z16) {
                    jSONObject.put("productId", payMouthData.getProductId());
                }
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                return jSONObject2;
            }
            z16 = true;
            if (!z16) {
            }
            String jSONObject22 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject22, "jsonObject.toString()");
            return jSONObject22;
        }

        @NotNull
        public final String b(@NotNull a payData) {
            String str;
            boolean z16;
            Intrinsics.checkNotNullParameter(payData, "payData");
            String str2 = "https://pay.qq.com/h5/index.shtml?aid=" + payData.getAid() + "&appid=" + payData.getOfferId() + "&as=" + payData.getAsParma() + "&c=" + payData.getCParma() + "&client=" + payData.getPayType() + "&cmn=" + payData.getCmn() + "&continousmonth=" + payData.getContinuousMonth() + "&groupid=" + payData.getGroupid() + "&m=" + payData.getMParma() + "&n=" + payData.getNParma() + "&sandbox=" + payData.getSandbox() + "&sdkpay=" + payData.getSdkpay() + "&service=" + payData.getServiceCode() + "&service_name=" + URLEncoder.encode(payData.getServiceName()) + "&u=" + payData.getUinParam() + "&m=buy";
            String g16 = payData.g();
            if (!TextUtils.isEmpty(g16)) {
                str = (str2 + "&drm_info=" + g16) + "&pf=qq_m_qq-2001-android-2011-" + payData.getReportData();
            } else {
                str = str2 + "&pf=" + payData.getPf();
            }
            if (!TextUtils.isEmpty(payData.getContinuousMonthType())) {
                str = str + "&continuous_month_type=" + payData.getContinuousMonthType();
            }
            if (!TextUtils.isEmpty(payData.getMpid())) {
                str = str + "&mpid=" + payData.getMpid();
            }
            String productId = payData.getProductId();
            if (productId != null && productId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                str = str + "&productId=" + payData.getProductId();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put("target", 1);
                jSONObject.put("animation", 1);
                jSONObject.put("style", 1);
            } catch (Exception e16) {
                QLog.e(IVipPayApi.PAY_TAG, 1, "parse error " + e16);
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        }

        Companion() {
        }
    }

    public c(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    public final void a(@NotNull a payData, int type) {
        Intrinsics.checkNotNullParameter(payData, "payData");
        if (type == 1) {
            payData.v("subscribe");
            payData.w("wechat");
        }
        String b16 = INSTANCE.b(payData);
        if (QLog.isColorLevel()) {
            QLog.i(IVipPayApi.PAY_TAG, 2, "openUrl:" + b16);
        }
        VasInjectApi.getInstance().openUrl(this.activity, b16);
    }

    public final void b(@NotNull String userId, @NotNull String aid, @NotNull String itemId, @Nullable h callBackVip) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        VasInjectApi.getInstance().itemLyPay(userId, aid, itemId, this.activity, callBackVip);
    }

    public final void c(@NotNull MonthlyPayData payMouthData, @Nullable k callBackVip) {
        Intrinsics.checkNotNullParameter(payMouthData, "payMouthData");
        ((IVipPayApi) QRoute.api(IVipPayApi.class)).newPay(INSTANCE.a(payMouthData), 14, "vip.qq.com", IVipPayApi.METHOD_PAY_SUBSCRIBE, this.activity, callBackVip);
    }
}
