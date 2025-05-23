package lr2;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f415466a = "";

    /* renamed from: b, reason: collision with root package name */
    private static JSONObject f415467b = new JSONObject();

    /* renamed from: c, reason: collision with root package name */
    private static String[] f415468c = new String[2];

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, Long> f415469d = new HashMap<>();

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(parse.getQueryParameter("showDiscuss"))) {
            return str;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.appendQueryParameter("showDiscuss", "true");
        return buildUpon.toString();
    }

    public static long b(String str) {
        Long remove = f415469d.remove(str);
        if (remove != null) {
            return SystemClock.elapsedRealtime() - remove.longValue();
        }
        return 0L;
    }

    private static void c(String[] strArr, String str, String str2, String str3, String str4) {
        try {
            f415467b.put("trace", str);
            f415467b.put("value", str2);
            f415467b.put("extra1", str3);
            f415467b.put("extra2", str4);
            String jSONObject = f415467b.toString();
            int length = jSONObject.length();
            int i3 = length / 2;
            strArr[0] = jSONObject.substring(0, i3);
            strArr[1] = jSONObject.substring(i3, length);
        } catch (JSONException e16) {
            QLog.e("TenDocLogReportHelper", 2, "report fail", e16);
        }
    }

    public static String d(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str.hashCode() + "_" + System.currentTimeMillis();
        }
        f415466a = str2;
        QLog.d("TenDocLogReportHelper", 2, "init trace id: " + f415466a);
        return f415466a;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.contains(ITeamWorkHandler.DOCS_DOMAIN) && !str.contains("docx.qq.com")) {
            return false;
        }
        return true;
    }

    private static boolean f(String str) {
        String cookie = CookieManager.getInstance().getCookie(str);
        if (TextUtils.isEmpty(cookie)) {
            return false;
        }
        for (String str2 : cookie.split(";")) {
            if (str2 != null && str2.contains("p_skey")) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str).getQueryParameter("xiaolv_wy_tdoc_tid");
    }

    public static String h(String str) {
        String g16 = g(str);
        if (!TextUtils.isEmpty(g16)) {
            return g16;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static void i(AppInterface appInterface, String str, String str2, String str3, String str4, String str5) {
        c(f415468c, str, str3, str4, str5);
        String[] strArr = f415468c;
        ReportController.o(appInterface, "dc00898", "", "", str2, str2, 0, 0, "", "", strArr[0], strArr[1]);
        if (QLog.isColorLevel()) {
            QLog.d("TenDocLogReportHelper", 2, "reportTDW: traceId=" + str + " T=" + str2 + " value=" + str3 + " extra1=" + str4 + " extra2=" + str5);
        }
    }

    public static void j(AppInterface appInterface, String str) {
        ReportController.o(appInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    public static void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f415469d.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public static void l(String str, String str2, String str3) {
        QLog.d(str, 2, "tencentdoc log:" + str2 + " - " + str3);
    }

    public static void m(String str, String str2, String str3, String str4) {
        QLog.d(str, 2, "tencentdoc log:" + str2 + " - " + str3 + " - " + str4);
    }

    public static void n(String str, String str2, String str3) {
        if (e(str)) {
            String str4 = "ps_key:" + f(str);
            String g16 = g(str);
            if (TextUtils.isEmpty(g16)) {
                l(str2, str3, str4);
            } else {
                m(str2, str3, str4, g16);
            }
        }
    }

    public static void o(String str, String str2, String str3, String str4) {
        if (e(str)) {
            String g16 = g(str);
            if (TextUtils.isEmpty(g16)) {
                l(str2, str3, str4);
            } else {
                m(str2, str3, str4, g16);
            }
        }
    }

    public static void p(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(teamWorkFileImportInfo.X)) {
            teamWorkFileImportInfo.X = d(teamWorkFileImportInfo.f292074f);
            return;
        }
        QLog.d("TenDocLogReportHelper", 2, "has setted trace Id: " + teamWorkFileImportInfo.X);
    }

    public static String q(String str, String str2) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(parse.getQueryParameter("xiaolv_wy_tdoc_tid"))) {
            return str;
        }
        QLog.d("TenDocLogReportHelper", 2, "trace url: " + str + ",traceId: " + str2);
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.appendQueryParameter("xiaolv_wy_tdoc_tid", str2);
        return buildUpon.toString();
    }
}
