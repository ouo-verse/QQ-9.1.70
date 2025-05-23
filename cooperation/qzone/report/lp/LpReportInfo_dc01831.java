package cooperation.qzone.report.lp;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc01831 implements LpReportInfo {
    public static final int DC00321_NETWORK_TYPE_2G = 2;
    public static final int DC00321_NETWORK_TYPE_3G = 3;
    public static final int DC00321_NETWORK_TYPE_4G = 4;
    public static final int DC00321_NETWORK_TYPE_5G = 5;
    public static final int DC00321_NETWORK_TYPE_CABLE = 6;
    public static final int DC00321_NETWORK_TYPE_UNKNOWN = 9;
    public static final int DC00321_NETWORK_TYPE_WIFI = 1;
    public long actiontype;
    public long app_id;
    public long device;
    public String extraInfo;
    public String gateway_ip;
    public String imei;
    public Map<String, String> infos;
    public int network_type;
    public String os_version;
    public String qua;
    public long reserves;
    public long subactiontype;
    public long touin;
    public long uin;

    public LpReportInfo_dc01831() {
    }

    public static void report(int i3, int i16, int i17) {
        LpReportManager.getInstance().reportToDC001831(new LpReportInfo_dc01831(i3, i16, i17), false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc01831:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        int networkType;
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.infos;
        if (map != null) {
            for (String str : map.keySet()) {
                String str2 = this.infos.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put(str, str2);
                }
            }
        }
        try {
            if (!TextUtils.isEmpty(this.extraInfo)) {
                jSONObject = new JSONObject(this.extraInfo);
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject.length() > 0) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.optString(str3));
                }
            }
        } catch (Exception unused) {
        }
        if (!hashMap.containsKey("actiontype")) {
            hashMap.put("actiontype", String.valueOf(this.actiontype));
        }
        if (!hashMap.containsKey("subactiontype")) {
            hashMap.put("subactiontype", String.valueOf(this.subactiontype));
        }
        if (!hashMap.containsKey("reserves")) {
            hashMap.put("reserves", String.valueOf(this.reserves));
        }
        if (!hashMap.containsKey("uin")) {
            hashMap.put("uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        }
        if (!hashMap.containsKey("touin")) {
            hashMap.put("touin", String.valueOf(this.touin));
        }
        if (hashMap.containsKey("network_type")) {
            try {
                networkType = Integer.parseInt((String) hashMap.get("network_type"));
            } catch (Exception unused2) {
                networkType = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getNetworkType();
            }
        } else {
            networkType = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getNetworkType();
        }
        hashMap.put("network_type", String.valueOf(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).convertNetworkTypeToFitInDc00518(networkType)));
        hashMap.put("app_id", String.valueOf(AppSetting.f()));
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("device", "1");
        hashMap.put("os_version", "android_" + Build.VERSION.RELEASE);
        hashMap.put("imei", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getIMEI());
        return hashMap;
    }

    public LpReportInfo_dc01831(int i3, int i16, int i17) {
        this.actiontype = i3;
        this.subactiontype = i16;
        this.reserves = i17;
    }

    public static void report(int i3, int i16, int i17, boolean z16, boolean z17) {
        LpReportManager.getInstance().reportToDC001831(new LpReportInfo_dc01831(i3, i16, i17), z16, z17);
    }

    public static void report(int i3, int i16, int i17, Map<String, String> map) {
        LpReportManager.getInstance().reportToDC001831(new LpReportInfo_dc01831(i3, i16, i17, map), false, true);
    }

    public LpReportInfo_dc01831(int i3, int i16, int i17, long j3) {
        this.actiontype = i3;
        this.subactiontype = i16;
        this.reserves = i17;
        this.touin = j3;
    }

    public LpReportInfo_dc01831(int i3, int i16, int i17, Map<String, String> map) {
        this.actiontype = i3;
        this.subactiontype = i16;
        this.reserves = i17;
        this.infos = map;
    }
}
