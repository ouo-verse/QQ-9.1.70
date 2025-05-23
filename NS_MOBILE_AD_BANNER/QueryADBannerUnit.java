package NS_MOBILE_AD_BANNER;

import TianShuJce.AdPlacementInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QueryADBannerUnit extends JceStruct {
    static int cache_eAdType;
    static Map<String, String> cache_extendinfo;
    static AdPlacementInfo cache_tianshuAdPlacementInfo;
    static ArrayList<VideoBanner> cache_videobanners;
    public String DynBannerJsonData;
    public String btnText;
    public String description;
    public int detail_info;
    public int duration;
    public int eAdType;
    public Map<String, String> extendinfo;
    public long iAdID;
    public long iStoreID;
    public long iTraceID;
    public long iUin;
    public ArrayList<MultiBanner> multibanner;
    public String nick;
    public int noCloseButton;
    public int pattern_id;
    public int priority;
    public int reopenHours;
    public String report_info;
    public String roomId;
    public TimeRange sShowTimeRange;
    public String strJmpUrl;
    public String strPicMD5;
    public String strPicUrl;
    public String strSchemeUrl;
    public String strStoreUrl;
    public String strTraceInfo;
    public AdPlacementInfo tianshuAdPlacementInfo;
    public int type;
    public String videoUrl;
    public ArrayList<VideoBanner> videobanners;
    static TimeRange cache_sShowTimeRange = new TimeRange();
    static ArrayList<MultiBanner> cache_multibanner = new ArrayList<>();

    static {
        cache_multibanner.add(new MultiBanner());
        cache_videobanners = new ArrayList<>();
        cache_videobanners.add(new VideoBanner());
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
        cache_tianshuAdPlacementInfo = new AdPlacementInfo();
    }

    public QueryADBannerUnit() {
        this.strPicUrl = "";
        this.strJmpUrl = "";
        this.iAdID = 0L;
        this.iTraceID = 0L;
        this.eAdType = 0;
        this.sShowTimeRange = null;
        this.strStoreUrl = "";
        this.iStoreID = 0L;
        this.strSchemeUrl = "";
        this.detail_info = 0;
        this.noCloseButton = 0;
        this.reopenHours = 0;
        this.priority = 0;
        this.duration = 0;
        this.report_info = "";
        this.strPicMD5 = "";
        this.type = 0;
        this.description = "";
        this.btnText = "";
        this.strTraceInfo = "";
        this.iUin = 0L;
        this.roomId = "";
        this.nick = "";
        this.multibanner = null;
        this.videobanners = null;
        this.extendinfo = null;
        this.DynBannerJsonData = "";
        this.videoUrl = "";
        this.pattern_id = 0;
        this.tianshuAdPlacementInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strPicUrl = jceInputStream.readString(0, true);
        this.strJmpUrl = jceInputStream.readString(1, true);
        this.iAdID = jceInputStream.read(this.iAdID, 2, true);
        this.iTraceID = jceInputStream.read(this.iTraceID, 3, true);
        this.eAdType = jceInputStream.read(this.eAdType, 4, true);
        this.sShowTimeRange = (TimeRange) jceInputStream.read((JceStruct) cache_sShowTimeRange, 5, false);
        this.strStoreUrl = jceInputStream.readString(6, false);
        this.iStoreID = jceInputStream.read(this.iStoreID, 7, false);
        this.strSchemeUrl = jceInputStream.readString(8, false);
        this.detail_info = jceInputStream.read(this.detail_info, 9, false);
        this.noCloseButton = jceInputStream.read(this.noCloseButton, 10, false);
        this.reopenHours = jceInputStream.read(this.reopenHours, 11, false);
        this.priority = jceInputStream.read(this.priority, 12, false);
        this.duration = jceInputStream.read(this.duration, 13, false);
        this.report_info = jceInputStream.readString(14, false);
        this.strPicMD5 = jceInputStream.readString(15, false);
        this.type = jceInputStream.read(this.type, 16, false);
        this.description = jceInputStream.readString(17, false);
        this.btnText = jceInputStream.readString(18, false);
        this.strTraceInfo = jceInputStream.readString(19, false);
        this.iUin = jceInputStream.read(this.iUin, 20, false);
        this.roomId = jceInputStream.readString(21, false);
        this.nick = jceInputStream.readString(22, false);
        this.multibanner = (ArrayList) jceInputStream.read((JceInputStream) cache_multibanner, 23, false);
        this.videobanners = (ArrayList) jceInputStream.read((JceInputStream) cache_videobanners, 24, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 25, false);
        this.DynBannerJsonData = jceInputStream.readString(26, false);
        this.videoUrl = jceInputStream.readString(27, false);
        this.pattern_id = jceInputStream.read(this.pattern_id, 28, false);
        this.tianshuAdPlacementInfo = (AdPlacementInfo) jceInputStream.read((JceStruct) cache_tianshuAdPlacementInfo, 29, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strPicUrl, 0);
        jceOutputStream.write(this.strJmpUrl, 1);
        jceOutputStream.write(this.iAdID, 2);
        jceOutputStream.write(this.iTraceID, 3);
        jceOutputStream.write(this.eAdType, 4);
        TimeRange timeRange = this.sShowTimeRange;
        if (timeRange != null) {
            jceOutputStream.write((JceStruct) timeRange, 5);
        }
        String str = this.strStoreUrl;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        jceOutputStream.write(this.iStoreID, 7);
        String str2 = this.strSchemeUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        jceOutputStream.write(this.detail_info, 9);
        jceOutputStream.write(this.noCloseButton, 10);
        jceOutputStream.write(this.reopenHours, 11);
        jceOutputStream.write(this.priority, 12);
        jceOutputStream.write(this.duration, 13);
        String str3 = this.report_info;
        if (str3 != null) {
            jceOutputStream.write(str3, 14);
        }
        String str4 = this.strPicMD5;
        if (str4 != null) {
            jceOutputStream.write(str4, 15);
        }
        jceOutputStream.write(this.type, 16);
        String str5 = this.description;
        if (str5 != null) {
            jceOutputStream.write(str5, 17);
        }
        String str6 = this.btnText;
        if (str6 != null) {
            jceOutputStream.write(str6, 18);
        }
        String str7 = this.strTraceInfo;
        if (str7 != null) {
            jceOutputStream.write(str7, 19);
        }
        jceOutputStream.write(this.iUin, 20);
        String str8 = this.roomId;
        if (str8 != null) {
            jceOutputStream.write(str8, 21);
        }
        String str9 = this.nick;
        if (str9 != null) {
            jceOutputStream.write(str9, 22);
        }
        ArrayList<MultiBanner> arrayList = this.multibanner;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 23);
        }
        ArrayList<VideoBanner> arrayList2 = this.videobanners;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 24);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 25);
        }
        String str10 = this.DynBannerJsonData;
        if (str10 != null) {
            jceOutputStream.write(str10, 26);
        }
        String str11 = this.videoUrl;
        if (str11 != null) {
            jceOutputStream.write(str11, 27);
        }
        jceOutputStream.write(this.pattern_id, 28);
        AdPlacementInfo adPlacementInfo = this.tianshuAdPlacementInfo;
        if (adPlacementInfo != null) {
            jceOutputStream.write((JceStruct) adPlacementInfo, 29);
        }
    }

    public QueryADBannerUnit(String str, String str2, long j3, long j16, int i3, TimeRange timeRange, String str3, long j17, String str4, int i16, int i17, int i18, int i19, int i26, String str5, String str6, int i27, String str7, String str8, String str9, long j18, String str10, String str11, ArrayList<MultiBanner> arrayList, ArrayList<VideoBanner> arrayList2, Map<String, String> map, String str12, String str13, int i28, AdPlacementInfo adPlacementInfo) {
        this.strPicUrl = str;
        this.strJmpUrl = str2;
        this.iAdID = j3;
        this.iTraceID = j16;
        this.eAdType = i3;
        this.sShowTimeRange = timeRange;
        this.strStoreUrl = str3;
        this.iStoreID = j17;
        this.strSchemeUrl = str4;
        this.detail_info = i16;
        this.noCloseButton = i17;
        this.reopenHours = i18;
        this.priority = i19;
        this.duration = i26;
        this.report_info = str5;
        this.strPicMD5 = str6;
        this.type = i27;
        this.description = str7;
        this.btnText = str8;
        this.strTraceInfo = str9;
        this.iUin = j18;
        this.roomId = str10;
        this.nick = str11;
        this.multibanner = arrayList;
        this.videobanners = arrayList2;
        this.extendinfo = map;
        this.DynBannerJsonData = str12;
        this.videoUrl = str13;
        this.pattern_id = i28;
        this.tianshuAdPlacementInfo = adPlacementInfo;
    }
}
