package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class eu {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ITroopMemberInfoService.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f307752a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f307753b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f307754c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f307755d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String[] f307756e;

        a(String str, String str2, int i3, int i16, String[] strArr) {
            this.f307752a = str;
            this.f307753b = str2;
            this.f307754c = i3;
            this.f307755d = i16;
            this.f307756e = strArr;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
        public void a(TroopMemberInfo troopMemberInfo) {
            String str = this.f307752a;
            String str2 = this.f307753b;
            int i3 = this.f307754c;
            int i16 = this.f307755d;
            String[] strArr = this.f307756e;
            eu.g("Grp_edu", str, str2, i3, i16, this.f307756e[0], eu.a(troopMemberInfo), strArr[2], strArr[3]);
        }
    }

    public static String a(TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo == null) {
            return "";
        }
        switch (troopMemberInfo.titleId) {
            case 332:
                return "classteacher";
            case 333:
                return "teacher";
            case 334:
                return HippyNestedScrollComponent.PRIORITY_PARENT;
            case 335:
                return "student";
            default:
                return "";
        }
    }

    private static String b(int i3, String... strArr) {
        if (strArr != null && strArr.length > i3) {
            return strArr[i3];
        }
        return "";
    }

    public static String c(TroopInfoData troopInfoData) {
        if (troopInfoData == null) {
            return "";
        }
        if (troopInfoData.bOwner) {
            return "0";
        }
        if (troopInfoData.bAdmin) {
            return "1";
        }
        if (!troopInfoData.isMember) {
            return "";
        }
        return "2";
    }

    public static String d(AppRuntime appRuntime, String str) {
        if (appRuntime == null || TextUtils.isEmpty(str)) {
            return "";
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo != null) {
            if (findTroopInfo.isTroopOwner(appRuntime.getCurrentAccountUin())) {
                return "0";
            }
            if (findTroopInfo.isOwnerOrAdmin()) {
                return "1";
            }
            return "2";
        }
        return "2";
    }

    public static String[] e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String[] strArr = {"", "", "", ""};
        try {
            if (jSONObject.has("r1")) {
                strArr[0] = jSONObject.getString("r1");
            }
            if (jSONObject.has("r2")) {
                strArr[1] = jSONObject.getString("r2");
            }
            if (jSONObject.has("r3")) {
                strArr[2] = jSONObject.getString("r3");
            }
            if (jSONObject.has("r4")) {
                strArr[3] = jSONObject.getString("r4");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return strArr;
    }

    public static void f(String str, int i3, int i16, int i17) {
        String valueOf = String.valueOf(i17);
        if (TextUtils.isEmpty(valueOf)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopReportor", 2, "reportAddGroupSource");
        }
        if (i3 == 0) {
            if (i16 == 1) {
                g("Grp_set_new", "recommend", "exp_new", 0, 0, str, valueOf);
                return;
            } else {
                if (i16 == 0) {
                    g("Grp_set_new", "recommend", "clkjoin_new", 0, 0, str, valueOf);
                    return;
                }
                return;
            }
        }
        if (i3 == 1) {
            if (i16 == 1) {
                g("Grp_join_new", "person_data", "exp_new", 0, 0, str, valueOf);
                return;
            } else {
                if (i16 == 0) {
                    g("Grp_join_new", "recommend", "clkjoin_new", 0, 0, str, valueOf);
                    return;
                }
                return;
            }
        }
        if (i3 == 2) {
            g("Grp_send_suc_new", "recommend", "exp_new", 0, 0, str, valueOf);
        }
    }

    public static void g(String str, String str2, String str3, int i3, int i16, String... strArr) {
        try {
            if (hd0.c.q()) {
                hd0.c.p("TroopReportor", "[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), b(0, strArr), b(1, strArr), b(2, strArr), b(3, strArr));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopReportor", 2, e16, new Object[0]);
            }
        }
        ReportController.o(null, "dc00899", str, "", str2, str3, i3, i16, b(0, strArr), b(1, strArr), b(2, strArr), b(3, strArr));
    }

    public static void h(AppRuntime appRuntime, String str, String str2, String str3, int i3, int i16, String... strArr) {
        if (appRuntime != null && strArr != null && strArr.length >= 4) {
            ((ITroopMemberInfoService) appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(str, appRuntime.getAccount(), "TroopReportor", new a(str2, str3, i3, i16, strArr));
        }
    }

    public static final void j(String str, String str2, String str3, String str4, String str5, String str6) {
        ReportController.o(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00899", "Grp_tech_report", "", str, str2, 0, 0, str3, str4, str5, str6);
        if (QLog.isColorLevel()) {
            QLog.d("ReportTech", 2, "opType=" + str + ", opName=" + str2 + ", r1=" + str3 + ", r2=" + str4 + ",r3=" + str5 + ", r4" + str6);
        }
    }

    public static void k(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(PreDownloadConstants.RPORT_KEY_BUSINESS_DEPARTMENT);
            String string2 = jSONObject.getString("opType");
            String string3 = jSONObject.getString("opName");
            int i3 = jSONObject.getInt("opIn");
            int i16 = jSONObject.getInt("opResult");
            String[] e16 = e(jSONObject.getJSONObject("remains"));
            if (e16 != null && e16.length >= 4) {
                g(string, string2, string3, i3, i16, e16[0], e16[1], e16[2], e16[3]);
            }
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }

    public static void i(String str, int i3, int i16, int i17) {
    }
}
