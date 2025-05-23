package l6;

import TianShuJce.AdItem;
import android.text.TextUtils;
import com.qzone.util.ak;
import com.qzone.util.am;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d {
    public static JSONObject c(int i3, i6.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (aVar != null && !am.h(aVar.l())) {
            try {
                if (i3 == 1) {
                    jSONObject = new JSONObject(aVar.l());
                } else if (i3 == 2) {
                    jSONObject = new JSONObject(aVar.m());
                } else if (i3 == 3) {
                    jSONObject = new JSONObject(aVar.m());
                }
                jSONObject2 = jSONObject;
            } catch (Throwable th5) {
                QLog.e("BigCardGameHelper", 1, th5, new Object[0]);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("BigCardGameHelper", 1, "getExtraInfo index=" + i3 + ",result=" + jSONObject2);
        }
        return jSONObject2;
    }

    public static List<String> e(i6.a aVar) {
        ArrayList arrayList = new ArrayList();
        if (aVar == null) {
            return arrayList;
        }
        JSONArray optJSONArray = d(aVar).optJSONArray("game_labels");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("BigCardGameHelper", 2, "getGameLabels size: " + arrayList.size());
        }
        return arrayList;
    }

    public static int f(i6.a aVar, String str) {
        return d(aVar).optInt(str);
    }

    public static String g(i6.a aVar, String str) {
        return d(aVar).optString(str);
    }

    public static void j(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        QLog.d("BigCardGameHelper", 4, "reportDC87 appId=" + str + ",operId=" + str2 + ",ext7=" + str3 + ",ext2=" + str4 + ",ext4=" + str5 + ",ext6=" + str6 + ",ext9=" + str7 + ",ext25=" + str8 + ",channelId=" + str9);
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087);
        wadlReportBuilder.setBussinessId("5").setPageId("1092").setOperModule("9404").setModuleType("940401");
        if ("205992".equals(str2)) {
            wadlReportBuilder.setExtSubModule("940401");
        }
        wadlReportBuilder.setGameAppId(str).setOperId(str2);
        wadlReportBuilder.setExt(2, str4).setExt(4, str5).setExt(6, str6).setExt(9, str7).setExt(25, str8).setExt(45, str9);
        wadlReportBuilder.setExt(7, str3);
        wadlReportBuilder.report();
    }

    public static JSONObject d(i6.a aVar) {
        return c(1, aVar);
    }

    public static String b(i6.a aVar) {
        if (aVar == null) {
            return "";
        }
        String j3 = aVar.j();
        if (QLog.isColorLevel()) {
            QLog.i("BigCardGameHelper", 2, "getDefaultJumpUrl: " + j3);
        }
        return j3;
    }

    public static boolean h(i6.a aVar) {
        return aVar != null && "2".equals(aVar.e());
    }

    public static String a(int i3) {
        if (i3 == 1) {
            return "10035116";
        }
        if (i3 == 2) {
            return "10411121";
        }
        return "";
    }

    public static void k(AdItem adItem, int i3, String str) {
        if (adItem == null) {
            QLog.w("BigCardGameHelper", 1, "tianShuReportBanner adItem is null");
        } else {
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.c(i3, String.valueOf(adItem.iAdId), adItem.traceinfo, str, str));
        }
    }

    public static boolean i(i6.a aVar) {
        if (aVar == null) {
            return false;
        }
        String m3 = aVar.m();
        QLog.i("BigCardGameHelper", 1, "isClickClose extra2=" + m3);
        if (!TextUtils.isEmpty(m3)) {
            try {
                return new JSONObject(m3).optInt("clickClose", 0) == 1;
            } catch (JSONException e16) {
                QLog.e("BigCardGameHelper", 1, "isClickClose exception", e16);
            }
        }
        return false;
    }
}
