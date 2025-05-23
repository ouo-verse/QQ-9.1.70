package cooperation.qzone.report.lp;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.util.QZLog;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc02880 implements LpReportInfo {
    public static String TAG = "LpReport.LpReportInfo_dc02880";
    public int actiontype;
    public String item_type;
    public String qua;
    public String reserves1;
    public String reserves2;
    public String reserves3;
    public String reserves6;
    public String reserves8;
    public int subactiontype;
    public long uin;
    public String url;

    public LpReportInfo_dc02880(int i3, int i16) {
        this.actiontype = i3;
        this.subactiontype = i16;
    }

    public static void report(String str, String str2) {
        LpReportManager.getInstance().reportToDC02880(new LpReportInfo_dc02880(str, str2), false, false);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return null;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String valueOf;
        HashMap hashMap = new HashMap();
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        long j3 = this.uin;
        if (j3 == 0) {
            valueOf = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        } else {
            valueOf = String.valueOf(j3);
        }
        hashMap.put("uin", valueOf);
        hashMap.put("actiontype", String.valueOf(this.actiontype));
        hashMap.put("subactiontype", String.valueOf(this.subactiontype));
        LpReportUtils.safePut(hashMap, "item_type", this.item_type);
        LpReportUtils.safePut(hashMap, "reserves1", this.reserves1);
        LpReportUtils.safePut(hashMap, "reserves2", this.reserves2);
        LpReportUtils.safePut(hashMap, "reserves3", this.reserves3);
        LpReportUtils.safePut(hashMap, "reserves6", this.reserves6);
        LpReportUtils.safePut(hashMap, "reserves8", this.reserves8);
        if (!TextUtils.isEmpty(this.url)) {
            hashMap.put("url", URLEncoder.encode(this.url));
        }
        return hashMap;
    }

    public static void report(String str, String str2, String str3) {
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(str, str2);
        lpReportInfo_dc02880.reserves6 = str3;
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, false, false);
    }

    public LpReportInfo_dc02880(String str, String str2) {
        this(2, 2, str, str2);
    }

    public LpReportInfo_dc02880(int i3, int i16, String str, String str2) {
        this.actiontype = i3;
        this.subactiontype = i16;
        this.url = str;
        this.item_type = str2;
    }

    public static void report(int i3, int i16, String str, String str2, boolean z16, boolean z17) {
        LpReportManager.getInstance().reportToDC02880(new LpReportInfo_dc02880(i3, i16, str, str2), z16, z17);
    }

    public static void report(int i3, int i16, String str, String str2, boolean z16, boolean z17, String str3) {
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(i3, i16, str, str2);
        lpReportInfo_dc02880.reserves6 = str3;
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, z16, z17);
    }

    public static void report(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("hydtgzh");
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            report(str, queryParameter, parse.getQueryParameter("reserves6"));
            QZoneLoginReportHelper.reportLoginFromMQQPublicAccount(queryParameter);
        } catch (Exception e16) {
            QZLog.e(TAG, "", e16);
        }
    }
}
