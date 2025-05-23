package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_DC01691 implements LpReportInfo {
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 4;
    public static final int NET_TYPE_5G = 5;
    public static final int NET_TYPE_UNKNOWN = 0;
    public static final int NET_TYPE_WIFI = 1;
    private static String TAG = "LpReport.LpReportInfo_DC01691";
    public static String deviceId;
    public int actionType;
    public int feedsType;
    public String feedsid;
    public String latitude;
    public String longitude;
    public int networkType;
    public int reserves;
    public int subactionType;
    public long toUin;
    public String appId = "0";
    public String referId = "";
    public long time = 0;
    public String info = "";
    public String extraInfo = "";
    public int tabletype = 11;
    public String domain_type = "2";
    public String sourceType = "";
    public String sourceFrom = "";
    public String sourceTo = "";

    public LpReportInfo_DC01691(int i3, int i16, int i17, long j3, String str, int i18, String str2, String str3) {
        this.actionType = i3;
        this.subactionType = i16;
        this.reserves = i17;
        this.toUin = j3;
        this.feedsid = str;
        this.feedsType = i18;
        this.latitude = str2;
        this.longitude = str3;
        int i19 = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getnetworkType();
        this.networkType = i19;
        if (i19 == 1) {
            this.networkType = 1;
            return;
        }
        if (i19 == 2) {
            this.networkType = 2;
            return;
        }
        if (i19 == 3) {
            this.networkType = 3;
            return;
        }
        if (i19 == 4) {
            this.networkType = 4;
        } else if (i19 == 5) {
            this.networkType = 5;
        } else {
            this.networkType = 9;
        }
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "DC01691:" + this.actionType + "," + this.subactionType + "," + this.reserves;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        hashMap.put("to_uin", String.valueOf(this.toUin));
        hashMap.put("network_type", String.valueOf(this.networkType));
        hashMap.put("tabletype", String.valueOf(this.tabletype));
        hashMap.put("actiontype", String.valueOf(this.actionType));
        hashMap.put("subactiontype", String.valueOf(this.subactionType));
        LpReportUtils.safePut(hashMap, "domain_type", this.domain_type);
        hashMap.put("reserves", String.valueOf(this.reserves));
        LpReportUtils.safePut(hashMap, QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, this.sourceType);
        LpReportUtils.safePut(hashMap, "source_from", this.sourceFrom);
        LpReportUtils.safePut(hashMap, "source_to", this.sourceTo);
        LpReportUtils.safePut(hashMap, "feedsid", this.feedsid);
        hashMap.put("feeds_type", String.valueOf(this.feedsType));
        hashMap.put("mobile_type", DeviceInfoMonitor.getModel());
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getIMEI();
        }
        if (!TextUtils.isEmpty(deviceId)) {
            hashMap.put("imei", deviceId);
        }
        LpReportUtils.safePut(hashMap, "uin_lbs_x", this.longitude);
        LpReportUtils.safePut(hashMap, "uin_lbs_y", this.latitude);
        try {
            if (!TextUtils.isEmpty(this.extraInfo)) {
                jSONObject = new JSONObject(this.extraInfo);
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject.length() > 0) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    String string = jSONObject.getString(str);
                    if (!TextUtils.isEmpty(string)) {
                        hashMap.put(str, string);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return hashMap;
    }
}
