package com.tencent.mobileqq.vas.pay.newcustomer;

import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$GetExperienceSvipInfoRsp;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$MonthInfo;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$PayInfo;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$TextInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J8\u0010\u0018\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001a\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001c\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u001d\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0002J\u0018\u0010\u001e\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0002J \u0010 \u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\tJ\u0016\u0010$\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"J\u0016\u0010%\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"J\u0016\u0010&\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"J\u0016\u0010'\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"J\u001e\u0010(\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\t\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/c;", "", "", "module", "itemId", "itemType", "", "action", "busiInfo", "", "e", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$MonthInfo;", "monthInfo", "c", "b", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$GetExperienceSvipInfoRsp;", "rsp", "Lorg/json/JSONObject;", "d", "clmParams", "aid", "zhengzhiStrategy", "payType", TransferConfig.ExtendParamFloats.KEY_RULE, "a", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "o", ReportConstant.COSTREPORT_PREFIX, "r", "isSuccess", "t", "l", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$PayInfo;", "payInfo", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "i", "j", "g", "f", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f310291a = new c();

    c() {
    }

    private final JSONObject a(ExperienceSvipServerPB$MonthInfo monthInfo, String clmParams, String aid, String zhengzhiStrategy, String payType, String rule) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("action_value", monthInfo.price.get());
        jSONObject.put("aid", aid);
        jSONObject.put("clm_params", clmParams);
        jSONObject.put("zengzhi_strategy", zhengzhiStrategy);
        jSONObject.put("rule_id", rule);
        jSONObject.put(DefaultTVKDataProvider.KEY_PAY_TYPE, payType);
        return jSONObject;
    }

    private final String b() {
        try {
            IVasRecentData iVasRecentData = (IVasRecentData) QRoute.api(IVasRecentData.class);
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
            IVasRecentData.FriendsVipData friendsVipData = iVasRecentData.getFriendsVipData(currentAccountUin);
            if (friendsVipData.getGrayNameplateFlag() > 0) {
                return "0";
            }
            if (friendsVipData.getVipType() > 0) {
                return "1";
            }
            return "-1";
        } catch (Exception e16) {
            com.tencent.xaction.log.b.f("NewCustomerReport", 1, "getNamePlateStatus", e16);
            return "-1";
        }
    }

    private final String c(ExperienceSvipServerPB$MonthInfo monthInfo) {
        if (monthInfo.type.get() == 1) {
            return "baoyue";
        }
        return monthInfo.month.get() + "month";
    }

    private final JSONObject d(ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp) {
        int i3;
        ExperienceSvipServerPB$TextInfo experienceSvipServerPB$TextInfo;
        PBEnumField pBEnumField;
        JSONObject jSONObject = new JSONObject();
        if (rsp != null && (experienceSvipServerPB$TextInfo = rsp.text_info) != null && (pBEnumField = experienceSvipServerPB$TextInfo.text_type) != null) {
            i3 = pBEnumField.get();
        } else {
            i3 = 0;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        jSONObject.put("user_status", sb5.toString());
        jSONObject.put("pin_status", f310291a.b());
        return jSONObject;
    }

    private final void e(String module, String itemId, String itemType, int action, String busiInfo) {
        try {
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction("pg_qqviptrace_native", "svip_experience", module, "", itemId, "", itemType, action, 0, 0, "", busiInfo, "");
        } catch (Exception e16) {
            com.tencent.xaction.log.b.d("NewCustomerReport", 1, "report exception", e16);
        }
    }

    public final void f() {
        e("bottom", "gwbutton", "4", 102, "");
    }

    public final void g() {
        e("bottom", "gwbutton", "4", 101, "");
    }

    public final void h(@Nullable ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp) {
        int i3;
        ExperienceSvipServerPB$TextInfo experienceSvipServerPB$TextInfo;
        PBEnumField pBEnumField;
        JSONObject jSONObject = new JSONObject();
        if (rsp != null && (experienceSvipServerPB$TextInfo = rsp.text_info) != null && (pBEnumField = experienceSvipServerPB$TextInfo.text_type) != null) {
            i3 = pBEnumField.get();
        } else {
            i3 = 0;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        jSONObject.put("user_status", sb5.toString());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026 0))\n        }.toString()");
        e("", "", "", 100, jSONObject2);
    }

    public final void i(@NotNull ExperienceSvipServerPB$MonthInfo monthInfo, @NotNull ExperienceSvipServerPB$PayInfo payInfo) {
        Intrinsics.checkNotNullParameter(monthInfo, "monthInfo");
        Intrinsics.checkNotNullParameter(payInfo, "payInfo");
        String str = monthInfo.pay_aid.get();
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.pay_aid.get()");
        int i3 = monthInfo.month.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String sb6 = sb5.toString();
        String str2 = payInfo.rule.get();
        Intrinsics.checkNotNullExpressionValue(str2, "payInfo.rule.get()");
        String jSONObject = a(monthInfo, "", str, "", sb6, str2).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "reportJson.toString()");
        e(OpenConstants.ApiName.PAY, "paybutton", "4", 102, jSONObject);
    }

    public final void j(@NotNull ExperienceSvipServerPB$MonthInfo monthInfo, @NotNull ExperienceSvipServerPB$PayInfo payInfo, int isSuccess) {
        Intrinsics.checkNotNullParameter(monthInfo, "monthInfo");
        Intrinsics.checkNotNullParameter(payInfo, "payInfo");
        String str = monthInfo.pay_aid.get();
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.pay_aid.get()");
        int i3 = monthInfo.month.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String sb6 = sb5.toString();
        String str2 = payInfo.rule.get();
        Intrinsics.checkNotNullExpressionValue(str2, "payInfo.rule.get()");
        JSONObject a16 = a(monthInfo, "", str, "", sb6, str2);
        a16.put(VRReportDefine$ReportParam.IS_SUCCESS, isSuccess);
        String jSONObject = a16.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "reportJson.toString()");
        e(OpenConstants.ApiName.PAY, "paybutton", "4", 110, jSONObject);
    }

    public final void k(@NotNull ExperienceSvipServerPB$MonthInfo monthInfo, @NotNull ExperienceSvipServerPB$PayInfo payInfo) {
        Intrinsics.checkNotNullParameter(monthInfo, "monthInfo");
        Intrinsics.checkNotNullParameter(payInfo, "payInfo");
        String str = monthInfo.pay_aid.get();
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.pay_aid.get()");
        int i3 = monthInfo.month.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String sb6 = sb5.toString();
        String str2 = payInfo.rule.get();
        Intrinsics.checkNotNullExpressionValue(str2, "payInfo.rule.get()");
        String jSONObject = a(monthInfo, "", str, "", sb6, str2).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "reportJson.toString()");
        e(OpenConstants.ApiName.PAY, "paybutton", "4", 101, jSONObject);
    }

    public final void l() {
        e(OpenConstants.ApiName.PAY, "", "", 110, "");
    }

    public final void m(@NotNull ExperienceSvipServerPB$MonthInfo monthInfo, @NotNull ExperienceSvipServerPB$PayInfo payInfo) {
        Intrinsics.checkNotNullParameter(monthInfo, "monthInfo");
        Intrinsics.checkNotNullParameter(payInfo, "payInfo");
        String c16 = c(monthInfo);
        String str = monthInfo.pay_aid.get();
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.pay_aid.get()");
        int i3 = monthInfo.month.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String sb6 = sb5.toString();
        String str2 = payInfo.rule.get();
        Intrinsics.checkNotNullExpressionValue(str2, "payInfo.rule.get()");
        String jSONObject = a(monthInfo, "", str, "", sb6, str2).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "reportJson.toString()");
        e(OpenConstants.ApiName.PAY, c16, "4", 102, jSONObject);
    }

    public final void n(@NotNull ExperienceSvipServerPB$MonthInfo monthInfo, @NotNull ExperienceSvipServerPB$PayInfo payInfo) {
        Intrinsics.checkNotNullParameter(monthInfo, "monthInfo");
        Intrinsics.checkNotNullParameter(payInfo, "payInfo");
        String c16 = c(monthInfo);
        String str = monthInfo.pay_aid.get();
        Intrinsics.checkNotNullExpressionValue(str, "monthInfo.pay_aid.get()");
        int i3 = monthInfo.month.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String sb6 = sb5.toString();
        String str2 = payInfo.rule.get();
        Intrinsics.checkNotNullExpressionValue(str2, "payInfo.rule.get()");
        String jSONObject = a(monthInfo, "", str, "", sb6, str2).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "reportJson.toString()");
        e(OpenConstants.ApiName.PAY, c16, "4", 101, jSONObject);
    }

    public final void o(@Nullable ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp) {
        String jSONObject = d(rsp).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "getUserInfoFromRsp(rsp).toString()");
        e("user_info", "expbutton", "4", 102, jSONObject);
    }

    public final void p(@Nullable ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp) {
        String jSONObject = d(rsp).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "getUserInfoFromRsp(rsp).toString()");
        e("user_info", "expbutton", "4", 101, jSONObject);
    }

    public final void q(@Nullable ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp) {
        String jSONObject = d(rsp).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "getUserInfoFromRsp(rsp).toString()");
        e("user_info", "", "", 111, jSONObject);
    }

    public final void r(@Nullable ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp, @NotNull String aid) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        JSONObject d16 = d(rsp);
        d16.put("aid", aid);
        Unit unit = Unit.INSTANCE;
        String jSONObject = d16.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "getUserInfoFromRsp(rsp).\u2026\n            }.toString()");
        e("user_info", "paybutton", "4", 102, jSONObject);
    }

    public final void s(@Nullable ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp, @NotNull String aid) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        JSONObject d16 = d(rsp);
        d16.put("aid", aid);
        Unit unit = Unit.INSTANCE;
        String jSONObject = d16.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "getUserInfoFromRsp(rsp).\u2026\n            }.toString()");
        e("user_info", "paybutton", "4", 101, jSONObject);
    }

    public final void t(@Nullable ExperienceSvipServerPB$GetExperienceSvipInfoRsp rsp, @NotNull String aid, int isSuccess) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        JSONObject d16 = d(rsp);
        d16.put("aid", aid);
        d16.put(VRReportDefine$ReportParam.IS_SUCCESS, isSuccess);
        Unit unit = Unit.INSTANCE;
        String jSONObject = d16.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "getUserInfoFromRsp(rsp).\u2026\n            }.toString()");
        e("user_info", "paybutton", "4", 110, jSONObject);
    }
}
