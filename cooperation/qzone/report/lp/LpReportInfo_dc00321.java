package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.LbsDataV2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc00321 implements LpReportInfo {
    public static final int DC00321_NETWORK_TYPE_2G = 2;
    public static final int DC00321_NETWORK_TYPE_3G = 3;
    public static final int DC00321_NETWORK_TYPE_4G = 4;
    public static final int DC00321_NETWORK_TYPE_5G = 5;
    public static final int DC00321_NETWORK_TYPE_CABLE = 6;
    public static final int DC00321_NETWORK_TYPE_UNKNOWN = 9;
    public static final int DC00321_NETWORK_TYPE_WIFI = 1;
    public static final int VIDEO_PLAY_SCENE_WEISHI = 29;
    public int actiontype;
    public long author_uin;
    public long client_video_play_time;
    public long client_video_solo_time;
    public int device;
    public long emotion_use_time;
    public String extraInfo;
    public int feeds_type;
    public String feeds_url;
    public String gateway_ip;
    public String gift_id;
    public int gift_num;
    public int gift_to_type;
    public String h265_url;
    public int height;
    public String imei;
    public Map<String, String> infos;
    public int is_auto_play;
    public int is_original;
    public long is_video_seek;
    public String latitude;
    public String like_id;
    public String live_name;
    public long live_online_time;
    public int live_page;
    public int live_source;
    public int live_state;
    public int live_user_type;
    public String longitude;
    public String mobile_type;
    public int network_type;
    public int photocubage;
    public String play_id;
    public String qua;
    public String refer;
    public long repost_uin;
    public int reserves;
    public String reserves2;
    public String reserves3;
    public String reserves4;
    public String reserves5;
    public String reserves6;
    public String s_vid;
    public long seq;
    public String shuoshuoid;
    public long stay_time;
    public int subactiontype;
    public String tag;
    public long to_uin;
    public long uin;
    public int upway;
    public String vid;
    public long vid_play_id;
    public long video_equipment;
    public int video_floating_from_scenes;
    public int video_floating_from_types;
    public int video_play_scene;
    public int video_play_source;
    public long video_play_time;
    public long video_solo_time;
    public int video_sources;
    public long video_total_time;
    public int width;
    public int write_from;

    public LpReportInfo_dc00321(LbsDataV2.GpsInfo gpsInfo) {
        this.longitude = "";
        this.latitude = "";
        if (gpsInfo != null) {
            this.longitude = String.valueOf((gpsInfo.lat * 1.0d) / 1000000.0d);
            this.latitude = String.valueOf((gpsInfo.lon * 1.0d) / 1000000.0d);
        }
    }

    public static void report(int i3, int i16, int i17, LbsDataV2.GpsInfo gpsInfo) {
        LpReportManager.getInstance().reportToDC00321(new LpReportInfo_dc00321(i3, i16, i17, gpsInfo), false, true);
    }

    public static void weishiReport(int i3, int i16, int i17, int i18) {
        LpReportInfo_dc00321 lpReportInfo_dc00321 = new LpReportInfo_dc00321(i3, i16, i17, null);
        lpReportInfo_dc00321.reserves3 = Integer.toString(i18);
        lpReportInfo_dc00321.video_play_scene = 29;
        LpReportManager.getInstance().reportToDC00321(lpReportInfo_dc00321, false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc00321:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
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
        hashMap.put("p_x", this.longitude);
        hashMap.put("p_y", this.latitude);
        return hashMap;
    }

    public static void report(int i3, int i16, int i17, boolean z16, boolean z17, LbsDataV2.GpsInfo gpsInfo) {
        LpReportManager.getInstance().reportToDC00321(new LpReportInfo_dc00321(i3, i16, i17, gpsInfo), z16, z17);
    }

    public static void report(int i3, int i16, int i17, int i18, boolean z16, boolean z17, LbsDataV2.GpsInfo gpsInfo) {
        LpReportInfo_dc00321 lpReportInfo_dc00321 = new LpReportInfo_dc00321(i3, i16, i17, gpsInfo);
        lpReportInfo_dc00321.reserves3 = Integer.toString(i18);
        LpReportManager.getInstance().reportToDC00321(lpReportInfo_dc00321, z16, z17);
    }

    public LpReportInfo_dc00321(int i3, int i16, int i17, LbsDataV2.GpsInfo gpsInfo) {
        this.longitude = "";
        this.latitude = "";
        this.actiontype = i3;
        this.subactiontype = i16;
        this.reserves = i17;
        if (gpsInfo != null) {
            this.longitude = String.valueOf((gpsInfo.lat * 1.0d) / 1000000.0d);
            this.latitude = String.valueOf((gpsInfo.lon * 1.0d) / 1000000.0d);
        }
    }

    public static void report(int i3, int i16, int i17, Map<String, String> map, LbsDataV2.GpsInfo gpsInfo) {
        LpReportManager.getInstance().reportToDC00321(new LpReportInfo_dc00321(i3, i16, i17, map, gpsInfo), false, true);
    }

    public LpReportInfo_dc00321(int i3, int i16, int i17, Map<String, String> map, LbsDataV2.GpsInfo gpsInfo) {
        this.longitude = "";
        this.latitude = "";
        this.actiontype = i3;
        this.subactiontype = i16;
        this.reserves = i17;
        this.infos = map;
        if (gpsInfo != null) {
            this.longitude = String.valueOf((gpsInfo.lat * 1.0d) / 1000000.0d);
            this.latitude = String.valueOf((gpsInfo.lon * 1.0d) / 1000000.0d);
        }
    }
}
