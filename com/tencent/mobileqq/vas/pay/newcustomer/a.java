package com.tencent.mobileqq.vas.pay.newcustomer;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$GetExperienceSvipInfoRsp;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$MonthInfo;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$PayInfo;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$Service;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$SvipInfo;
import com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$Tianxuan;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/a;", "", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/newcustomer/a$a;", "", "", "d", "c", "", "a", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "b", "e", "Lcom/tencent/trpcprotocol/qqva/experience_svip_server/experience_svip_server/ExperienceSvipServerPB$GetExperienceSvipInfoRsp;", "f", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.pay.newcustomer.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            IConfigProxy iConfigProxy = VasLongToggle.VAS_NEW_CUSTOMER_CONFIG;
            if (!iConfigProxy.isEnable(true)) {
                return 1100;
            }
            try {
                int i3 = iConfigProxy.getJson().getInt("hippy_height");
                QLog.i("ConfigToRsp", 1, "hippy height: " + i3);
                return i3;
            } catch (Exception e16) {
                QLog.i("ConfigToRsp", 1, "getHippyHeight error: " + e16.getMessage());
                return 1100;
            }
        }

        @Nullable
        public final OpenHippyInfo b() {
            IConfigProxy iConfigProxy = VasLongToggle.VAS_NEW_CUSTOMER_CONFIG;
            if (!iConfigProxy.isEnable(true)) {
                return null;
            }
            try {
                JSONObject jSONObject = iConfigProxy.getJson().getJSONObject("openParams");
                String string = jSONObject.getString("url");
                String string2 = jSONObject.getString(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
                String string3 = jSONObject.getString("bundleName");
                String string4 = jSONObject.getString("domain");
                OpenHippyInfo openHippyInfo = new OpenHippyInfo();
                openHippyInfo.errorUrl = string2;
                openHippyInfo.domain = string4;
                openHippyInfo.url = string;
                openHippyInfo.bundleName = string3;
                return openHippyInfo;
            } catch (Exception e16) {
                QLog.i("ConfigToRsp", 1, "getHippyInfo error: " + e16.getMessage());
                return null;
            }
        }

        @NotNull
        public final String c() {
            IConfigProxy iConfigProxy = VasLongToggle.VAS_NEW_CUSTOMER_CONFIG;
            if (!iConfigProxy.isEnable(true)) {
                return "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&_wvx=10&_proxy=1";
            }
            try {
                String webUrl = iConfigProxy.getJson().getString("official_web");
                QLog.i("ConfigToRsp", 1, "webUrl: " + webUrl);
                Intrinsics.checkNotNullExpressionValue(webUrl, "webUrl");
                return webUrl;
            } catch (Exception e16) {
                QLog.i("ConfigToRsp", 1, "getOfficialWeb error: " + e16.getMessage());
                return "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&_wvx=10&_proxy=1";
            }
        }

        @NotNull
        public final String d() {
            IConfigProxy iConfigProxy = VasLongToggle.VAS_NEW_CUSTOMER_CONFIG;
            if (!iConfigProxy.isEnable(true)) {
                return "\u4f60\u5df2\u7ecf\u8d2d\u4e70\u8fc7\u4e86";
            }
            try {
                String limitToast = iConfigProxy.getJson().getString("out_limit_toast");
                QLog.i("ConfigToRsp", 1, "limitToast: " + limitToast);
                Intrinsics.checkNotNullExpressionValue(limitToast, "limitToast");
                return limitToast;
            } catch (Exception e16) {
                QLog.i("ConfigToRsp", 1, "getOfficialWeb error: " + e16.getMessage());
                return "\u4f60\u5df2\u7ecf\u8d2d\u4e70\u8fc7\u4e86";
            }
        }

        @NotNull
        public final String e() {
            IConfigProxy iConfigProxy = VasLongToggle.VAS_NEW_CUSTOMER_CONFIG;
            if (!iConfigProxy.isEnable(true)) {
                return "";
            }
            JSONObject json = iConfigProxy.getJson();
            if (VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip()) {
                JSONObject optJSONObject = json.optJSONObject("svip");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("pay_list_title");
                    Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"pay_list_title\")");
                    return optString;
                }
            } else {
                JSONObject optJSONObject2 = json.optJSONObject("no_svip");
                if (optJSONObject2 != null) {
                    String optString2 = optJSONObject2.optString("pay_list_title");
                    Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"pay_list_title\")");
                    return optString2;
                }
            }
            return "";
        }

        @Nullable
        public final ExperienceSvipServerPB$GetExperienceSvipInfoRsp f() {
            IConfigProxy iConfigProxy = VasLongToggle.VAS_NEW_CUSTOMER_CONFIG;
            if (!iConfigProxy.isEnable(true)) {
                return null;
            }
            ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp = new ExperienceSvipServerPB$GetExperienceSvipInfoRsp();
            JSONObject json = iConfigProxy.getJson();
            if (VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip()) {
                JSONObject optJSONObject = json.optJSONObject("svip");
                if (optJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"svip\")");
                    experienceSvipServerPB$GetExperienceSvipInfoRsp.experience_svip_info.buy_btn_title.set(optJSONObject.optString("pay_btn"));
                }
            } else {
                JSONObject optJSONObject2 = json.optJSONObject("no_svip");
                if (optJSONObject2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(\"no_svip\")");
                    experienceSvipServerPB$GetExperienceSvipInfoRsp.experience_svip_info.buy_btn_title.set(optJSONObject2.optString("pay_btn"));
                }
            }
            ExperienceSvipServerPB$SvipInfo experienceSvipServerPB$SvipInfo = new ExperienceSvipServerPB$SvipInfo();
            experienceSvipServerPB$SvipInfo.is_svip.set(VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip());
            experienceSvipServerPB$GetExperienceSvipInfoRsp.experience_svip_info = experienceSvipServerPB$SvipInfo;
            ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo = experienceSvipServerPB$GetExperienceSvipInfoRsp.pay_info;
            ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo2 = new ExperienceSvipServerPB$PayInfo();
            JSONArray jSONArray = json.getJSONArray("default");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("aid");
                int optInt = jSONObject.optInt("type");
                String optString2 = jSONObject.optString("title");
                int optInt2 = jSONObject.optInt("index");
                int optInt3 = jSONObject.optInt("discount_price");
                int optInt4 = jSONObject.optInt("ori_price");
                String optString3 = jSONObject.optString("active_img");
                String optString4 = jSONObject.optString("inactive_img");
                JSONArray jSONArray2 = jSONArray;
                String optString5 = jSONObject.optString("black_inactive_img");
                int i16 = length;
                int optInt5 = jSONObject.optInt("month");
                ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp2 = experienceSvipServerPB$GetExperienceSvipInfoRsp;
                JSONObject jSONObject2 = jSONObject.getJSONObject("service");
                ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo3 = experienceSvipServerPB$PayInfo;
                String optString6 = jSONObject2.optString("service_type");
                ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo4 = experienceSvipServerPB$PayInfo2;
                String optString7 = jSONObject2.optString("offer_id");
                int i17 = i3;
                String optString8 = jSONObject2.optString(ReportDataBuilder.KEY_PRODUCT_ID);
                ArrayList arrayList2 = arrayList;
                String optString9 = jSONObject2.optString("qq_product_name");
                JSONObject jSONObject3 = jSONObject.getJSONObject("tianxuan");
                int optInt6 = jSONObject3.optInt("buy_num");
                String optString10 = jSONObject3.optString("item_id");
                String optString11 = jSONObject3.optString("card_id");
                ExperienceSvipServerPB$MonthInfo experienceSvipServerPB$MonthInfo = new ExperienceSvipServerPB$MonthInfo();
                experienceSvipServerPB$MonthInfo.title.set(optString2);
                experienceSvipServerPB$MonthInfo.price.set(optInt3);
                experienceSvipServerPB$MonthInfo.ori_price.set(optInt4);
                experienceSvipServerPB$MonthInfo.index.set(optInt2);
                experienceSvipServerPB$MonthInfo.type.set(optInt);
                experienceSvipServerPB$MonthInfo.pay_aid.set(optString);
                experienceSvipServerPB$MonthInfo.active_img.set(optString3);
                experienceSvipServerPB$MonthInfo.inactive_img.set(optString4);
                experienceSvipServerPB$MonthInfo.black_inactive_img.set(optString5);
                experienceSvipServerPB$MonthInfo.month.set(optInt5);
                ExperienceSvipServerPB$Service experienceSvipServerPB$Service = new ExperienceSvipServerPB$Service();
                experienceSvipServerPB$Service.service_type.set(optString6);
                experienceSvipServerPB$Service.offer_id.set(optString7);
                experienceSvipServerPB$Service.product_id.set(optString8);
                experienceSvipServerPB$Service.qq_product_name.set(optString9);
                experienceSvipServerPB$MonthInfo.service = experienceSvipServerPB$Service;
                ExperienceSvipServerPB$Tianxuan experienceSvipServerPB$Tianxuan = new ExperienceSvipServerPB$Tianxuan();
                experienceSvipServerPB$Tianxuan.item_id.set(optString10);
                experienceSvipServerPB$Tianxuan.buy_num.set(optInt6);
                experienceSvipServerPB$Tianxuan.card_id.set(optString11);
                experienceSvipServerPB$MonthInfo.tianxuan = experienceSvipServerPB$Tianxuan;
                arrayList2.add(experienceSvipServerPB$MonthInfo);
                i3 = i17 + 1;
                arrayList = arrayList2;
                jSONArray = jSONArray2;
                length = i16;
                experienceSvipServerPB$GetExperienceSvipInfoRsp = experienceSvipServerPB$GetExperienceSvipInfoRsp2;
                experienceSvipServerPB$PayInfo = experienceSvipServerPB$PayInfo3;
                experienceSvipServerPB$PayInfo2 = experienceSvipServerPB$PayInfo4;
            }
            ExperienceSvipServerPB$GetExperienceSvipInfoRsp experienceSvipServerPB$GetExperienceSvipInfoRsp3 = experienceSvipServerPB$GetExperienceSvipInfoRsp;
            ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo5 = experienceSvipServerPB$PayInfo;
            ExperienceSvipServerPB$PayInfo experienceSvipServerPB$PayInfo6 = experienceSvipServerPB$PayInfo2;
            experienceSvipServerPB$PayInfo6.month_info.set(arrayList);
            experienceSvipServerPB$PayInfo5.set(experienceSvipServerPB$PayInfo6);
            return experienceSvipServerPB$GetExperienceSvipInfoRsp3;
        }

        Companion() {
        }
    }
}
