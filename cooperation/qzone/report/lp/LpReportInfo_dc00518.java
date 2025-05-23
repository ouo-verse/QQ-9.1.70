package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc00518 implements LpReportInfo {
    public int actiontype;
    public String extraInfo;
    public Map<String, String> infos;
    public int network_type;
    public String qua;
    public int reserves;
    public int subactiontype;
    public long uin;

    public LpReportInfo_dc00518() {
    }

    public static void report(int i3, int i16, int i17) {
        LpReportManager.getInstance().reportToDC00518(new LpReportInfo_dc00518(i3, i16, i17), false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc00518:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
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
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("device", "2");
        return hashMap;
    }

    public LpReportInfo_dc00518(int i3, int i16, int i17) {
        this.actiontype = i3;
        this.subactiontype = i16;
        this.reserves = i17;
    }

    public static void report(int i3, int i16, int i17, boolean z16, boolean z17) {
        LpReportManager.getInstance().reportToDC00518(new LpReportInfo_dc00518(i3, i16, i17), z16, z17);
    }

    public LpReportInfo_dc00518(int i3, int i16, int i17, Map<String, String> map) {
        this.actiontype = i3;
        this.subactiontype = i16;
        this.reserves = i17;
        this.infos = map;
    }
}
