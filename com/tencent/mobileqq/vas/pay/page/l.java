package com.tencent.mobileqq.vas.pay.page;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002JB\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J.\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/l;", "", "", "payInfoType", "month", "", "a", "module", "itemId", "action", "busiInfo", "", "b", "vipType", "userVipState", "vipLevel", "d", "userStatus", "c", "clmParams", "aid", "zhengzhiStrategy", "payType", "f", "e", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f310417a = new l();

    l() {
    }

    private final String a(int payInfoType, int month) {
        if (payInfoType != 1) {
            if (payInfoType != 2) {
                if (payInfoType != 3) {
                    if (payInfoType != 5) {
                        return "";
                    }
                } else {
                    return month + "month";
                }
            }
            return month + "month";
        }
        return "baoyue";
    }

    private final void b(String module, String itemId, int action, String busiInfo) {
        try {
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction("cuifei_payment", "vip_payment", module, "", itemId, "", "", action, 0, 0, "", busiInfo, "");
        } catch (Exception e16) {
            com.tencent.xaction.log.b.d("QVipRenewalReport", 1, "report exception", e16);
        }
    }

    public static /* synthetic */ void g(l lVar, int i3, String str, String str2, String str3, String str4, int i16, int i17, int i18, Object obj) {
        int i19;
        int i26;
        if ((i18 & 32) != 0) {
            i19 = -1;
        } else {
            i19 = i16;
        }
        if ((i18 & 64) != 0) {
            i26 = -1;
        } else {
            i26 = i17;
        }
        lVar.f(i3, str, str2, str3, str4, i19, i26);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        if (r5 != 2) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(int action, int userStatus) {
        String str;
        if (action == 111) {
            str = "";
        } else {
            str = QCircleAlphaUserReporter.KEY_USER;
        }
        int i3 = 0;
        if (userStatus != 0) {
            int i16 = 1;
            if (userStatus != 1) {
                i16 = 2;
            }
            i3 = i16;
        }
        JSONObject jSONObject = new JSONObject();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        jSONObject.put("user_status", sb5.toString());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026tus)\n        }.toString()");
        b("user_info", str, action, jSONObject2);
    }

    public final void d(int vipType, int userVipState, int vipLevel) {
        String str = "no_vip";
        if (userVipState != 0 && userVipState != 1 && userVipState == 2) {
            str = vipType != 2 ? vipType != 3 ? "" : "svip" : "vip";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("user_status", str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(vipLevel);
        jSONObject.put("vip_level", sb5.toString());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026vel)\n        }.toString()");
        b("", "", 100, jSONObject2);
    }

    public final void e(int action, @NotNull String clmParams, @NotNull String aid, @NotNull String zhengzhiStrategy, @NotNull String payType) {
        String str;
        Intrinsics.checkNotNullParameter(clmParams, "clmParams");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(zhengzhiStrategy, "zhengzhiStrategy");
        Intrinsics.checkNotNullParameter(payType, "payType");
        if (action == 111) {
            str = "";
        } else {
            str = "pay_button";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", aid);
        jSONObject.put("clm_params", clmParams);
        jSONObject.put("zhengzhi_strategy", zhengzhiStrategy);
        jSONObject.put(DefaultTVKDataProvider.KEY_PAY_TYPE, payType);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ype)\n        }.toString()");
        b("pay_bottom", str, action, jSONObject2);
    }

    public final void f(int action, @NotNull String clmParams, @NotNull String aid, @NotNull String zhengzhiStrategy, @NotNull String payType, int payInfoType, int month) {
        Intrinsics.checkNotNullParameter(clmParams, "clmParams");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(zhengzhiStrategy, "zhengzhiStrategy");
        Intrinsics.checkNotNullParameter(payType, "payType");
        String a16 = a(payInfoType, month);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", aid);
        jSONObject.put("clm_params", clmParams);
        jSONObject.put("zhengzhi_strategy", zhengzhiStrategy);
        jSONObject.put(DefaultTVKDataProvider.KEY_PAY_TYPE, payType);
        jSONObject.put("item_id", a16);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026mId)\n        }.toString()");
        b("pay_month", a16, action, jSONObject2);
    }
}
