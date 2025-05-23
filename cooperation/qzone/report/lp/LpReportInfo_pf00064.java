package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_pf00064 implements LpReportInfo {
    private static String TAG = "LpReport.LpReportInfo_pf00064";
    public int actionType;
    public String appId;
    public String domain_type;
    public String extraInfo;
    public String info;
    public boolean isTemp;
    private Map<String, String> mapReportInfo;
    public int mergenum;
    public int networkType;
    public String pushstatkey;
    public String readSource;
    public String referId;
    public int reserves;
    public String reserves10;
    public String reserves11;
    public String reserves2;
    public String reserves3;
    public String reserves4;
    public String reserves5;
    public String reserves6;
    public String reserves7;
    public String reserves8;
    public String reserves9;
    public ArrayList<String> reservesArray;
    public ArrayList<String> reservesExt;
    public String sourceFrom;
    public String sourceTo;
    public String sourceType;
    public int subactionType;
    public int tabletype;
    public long time;
    public long toUin;
    private boolean useMapMode;

    public LpReportInfo_pf00064(int i3, int i16, int i17) {
        this();
        this.actionType = i3;
        this.subactionType = i16;
        this.reserves = i17;
    }

    public static void allReport(int i3, int i16, String str) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves4 = str;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, true, false);
    }

    public static void report(int i3, int i16) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, true, false);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "pf00064:" + this.actionType + "," + this.subactionType + "," + this.reserves;
    }

    public void reportImediately() {
        LpReportManager.getInstance().reportToPF00064(this, false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        hashMap.put(LpReportInfo.KEY_NEW_FEED, String.valueOf(1));
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("device_info", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getDeviceInfor());
        if (!TextUtils.isEmpty(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount())) {
            hashMap.put("uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        } else {
            hashMap.put("uin", "0");
            QLog.e(TAG, 1, "uin=0 actiontype=" + this.actionType + " subactiontype=" + this.subactionType);
        }
        hashMap.put("touin", String.valueOf(this.toUin));
        hashMap.put("network_type", String.valueOf(this.networkType));
        hashMap.put("tabletype", String.valueOf(this.tabletype));
        if (this.useMapMode) {
            Map<String, String> map = this.mapReportInfo;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : this.mapReportInfo.entrySet()) {
                    LpReportUtils.safePut(hashMap, entry.getKey(), entry.getValue());
                }
            }
        } else {
            if (!hashMap.containsKey("refer")) {
                hashMap.put("refer", this.referId);
            }
            hashMap.put("actiontype", String.valueOf(this.actionType));
            hashMap.put("subactiontype", String.valueOf(this.subactionType));
            hashMap.put("tabletype", String.valueOf(this.tabletype));
            LpReportUtils.safePut(hashMap, "domain_type", this.domain_type);
            hashMap.put("reserves", String.valueOf(this.reserves));
            LpReportUtils.safePut(hashMap, QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, this.sourceType);
            LpReportUtils.safePut(hashMap, "source_from", this.sourceFrom);
            LpReportUtils.safePut(hashMap, "source_to", this.sourceTo);
            LpReportUtils.safePut(hashMap, "reserves2", this.reserves2);
            LpReportUtils.safePut(hashMap, "reserves3", this.reserves3);
            LpReportUtils.safePut(hashMap, "reserves4", this.reserves4);
            LpReportUtils.safePut(hashMap, "reserves5", this.reserves5);
            LpReportUtils.safePut(hashMap, "reserves6", this.reserves6);
            LpReportUtils.safePut(hashMap, "reserves7", this.reserves7);
            LpReportUtils.safePut(hashMap, "reserves8", this.reserves8);
            LpReportUtils.safePut(hashMap, "reserves9", this.reserves9);
            LpReportUtils.safePut(hashMap, "reserves10", this.reserves10);
            LpReportUtils.safePut(hashMap, "reserves11", this.reserves11);
            hashMap.put("mergenum", String.valueOf(this.mergenum));
            ArrayList<String> arrayList = this.reservesExt;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    String str = this.reservesExt.get(i3);
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("reserves" + (i3 + 2), str);
                    }
                }
            }
        }
        LpReportUtils.safePut(hashMap, "read_source", this.readSource);
        hashMap.put("time", String.valueOf(this.time));
        LpReportUtils.safePut(hashMap, "info", this.info);
        LpReportUtils.safePut(hashMap, "pushstatkey", this.pushstatkey);
        try {
            if (!TextUtils.isEmpty(this.extraInfo)) {
                jSONObject = new JSONObject(this.extraInfo);
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject.length() > 0) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    String string = jSONObject.getString(str2);
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(str2, string);
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return hashMap;
    }

    public LpReportInfo_pf00064(int i3, int i16, int i17, long j3) {
        this();
        this.actionType = i3;
        this.subactionType = i16;
        this.reserves = i17;
        this.toUin = j3;
    }

    public static void report(int i3, int i16, int i17) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, true, false);
    }

    public static void allReport(int i3, int i16) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    public LpReportInfo_pf00064(int i3, int i16, long j3) {
        this();
        this.actionType = i3;
        this.subactionType = i16;
        this.toUin = j3;
    }

    public static void allReport(int i3, int i16, int i17) {
        allReport(i3, i16, i17, (String) null);
    }

    public static void report(int i3, int i16, int i17, String str, String str2, String str3) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        lpReportInfo_pf00064.reserves4 = str;
        lpReportInfo_pf00064.reserves6 = str2;
        lpReportInfo_pf00064.reserves7 = str3;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    public static void allReport(int i3, int i16, int i17, long j3) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        lpReportInfo_pf00064.toUin = j3;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    public LpReportInfo_pf00064(String str, String str2, String str3, String str4) {
        this();
        this.actionType = Integer.parseInt(str);
        this.subactionType = Integer.parseInt(str2);
        this.reserves = Integer.parseInt(str3);
        this.reserves5 = str4;
    }

    public static void allReport(int i3, int i16, int i17, String str, long j3) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        lpReportInfo_pf00064.reserves2 = str;
        lpReportInfo_pf00064.toUin = j3;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    public static void report(int i3, int i16, int i17, String str) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        lpReportInfo_pf00064.reserves2 = str;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, true, false);
    }

    public LpReportInfo_pf00064(String str, String str2, int i3, String str3, String str4) {
        this();
        this.actionType = Integer.parseInt(str);
        this.subactionType = Integer.parseInt(str2);
        this.reserves = i3;
        this.reserves2 = str3;
        this.reserves3 = str4;
    }

    public static void allReport(int i3, int i16, int i17, String str, String str2, long j3) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        lpReportInfo_pf00064.reserves2 = str;
        lpReportInfo_pf00064.reserves6 = str2;
        lpReportInfo_pf00064.toUin = j3;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    public static void report(int i3, String str) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.reserves10 = str;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    public LpReportInfo_pf00064(String str, String str2) {
        this();
        this.actionType = Integer.parseInt(str);
        this.subactionType = Integer.parseInt(str2);
    }

    public LpReportInfo_pf00064(long j3, String str, Map<String, String> map) {
        this();
        this.toUin = j3;
        this.appId = str;
        this.useMapMode = true;
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.mapReportInfo = hashMap;
            hashMap.putAll(map);
        }
    }

    public static void report(int i3, int i16, int i17, String str, String str2) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        lpReportInfo_pf00064.reserves2 = str;
        lpReportInfo_pf00064.reserves3 = str2;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, true, false);
    }

    public static void allReport(int i3, int i16, int i17, String str) {
        allReport(i3, i16, i17, str, (String) null);
    }

    public static void allReport(int i3, int i16, int i17, String str, String str2) {
        allReport(i3, i16, i17, str, str2, (String) null);
    }

    public LpReportInfo_pf00064(long j3, int i3, String str, Map<String, String> map) {
        this();
        this.toUin = j3;
        this.appId = str;
        this.tabletype = i3;
        this.useMapMode = true;
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.mapReportInfo = hashMap;
            hashMap.putAll(map);
        }
    }

    public static void allReport(int i3, int i16, int i17, String str, String str2, String str3) {
        allReport(i3, i16, i17, str, str2, str3, 0L);
    }

    public static void allReport(int i3, int i16, int i17, String str, String str2, String str3, String str4) {
        allReport(i3, i16, i17, str, str2, str3, str4, (String) null, 0L);
    }

    public static void allReport(int i3, int i16, int i17, String str, String str2, String str3, long j3) {
        allReport(i3, i16, i17, str, str2, str3, (String) null, (String) null, j3);
    }

    public static void allReport(int i3, int i16, int i17, String str, String str2, String str3, String str4, String str5, long j3) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        if (i3 == 309 && "com.tencent.mobileqq".equals(MobileQQ.processName)) {
            lpReportInfo_pf00064.reserves9 = "1";
        }
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        if (!TextUtils.isEmpty(str)) {
            lpReportInfo_pf00064.reserves2 = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            lpReportInfo_pf00064.reserves3 = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            lpReportInfo_pf00064.reserves4 = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            lpReportInfo_pf00064.reserves5 = str4;
        }
        if (!TextUtils.isEmpty(str5)) {
            lpReportInfo_pf00064.reserves7 = str5;
        }
        lpReportInfo_pf00064.toUin = j3;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    public LpReportInfo_pf00064() {
        this.toUin = 0L;
        this.appId = "0";
        this.referId = "";
        this.readSource = "0";
        this.isTemp = false;
        this.time = 0L;
        this.info = "";
        this.extraInfo = "";
        this.tabletype = 0;
        this.domain_type = "2";
        this.useMapMode = false;
        this.pushstatkey = "";
        this.sourceType = "";
        this.sourceFrom = "";
        this.sourceTo = "";
        this.reserves2 = "";
        this.reserves3 = "";
        this.reserves4 = "";
        this.reserves5 = "";
        this.reserves6 = "";
        this.reserves7 = "";
        this.reserves8 = "";
        this.reserves9 = "";
        this.reserves10 = "";
        this.reserves11 = "";
        this.mergenum = 0;
        this.reservesArray = new ArrayList<>();
        this.networkType = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getnetworkType();
        this.time = System.currentTimeMillis();
    }

    public static void allReport(int i3, int i16, int i17, boolean z16) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, z16);
    }

    public static void allReport(int i3, int i16, int i17, String str, String str2, String str3, String str4, String str5, String str6) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        if (!TextUtils.isEmpty(str)) {
            lpReportInfo_pf00064.reserves2 = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            lpReportInfo_pf00064.reserves3 = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            lpReportInfo_pf00064.reserves4 = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            lpReportInfo_pf00064.reserves5 = str4;
        }
        if (!TextUtils.isEmpty(str5)) {
            lpReportInfo_pf00064.reserves6 = str5;
        }
        if (!TextUtils.isEmpty(str6)) {
            lpReportInfo_pf00064.reserves7 = str6;
        }
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }
}
