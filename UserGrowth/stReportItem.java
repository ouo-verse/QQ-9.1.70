package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stReportItem extends JceStruct {
    static stDevice cache_device;
    static Map<String, String> cache_ext_map;
    static Map<String, String> cache_feed_map_ext;
    static Map<Integer, byte[]> cache_map_pass_back = new HashMap();
    public String authorid;
    public String authorname;
    public int card_type;
    public String cate;
    public int cid;
    public String city;
    public int comment_loctaion;
    public stDevice device;
    public String dislike_reason;
    public String downloadscene;
    public int exist_weishi;
    public Map<String, String> ext_map;
    public Map<String, String> feed_map_ext;
    public String feedid;
    public long imp_date;

    /* renamed from: ip, reason: collision with root package name */
    public String f25124ip;
    public boolean isFullSpan;
    public String jubao_reason;
    public Map<Integer, byte[]> map_pass_back;
    public String network_type;
    public int op_location;
    public int optype;
    public String originImgUrl;

    /* renamed from: os, reason: collision with root package name */
    public String f25125os;
    public int pagetype;
    public String personid;
    public int play_time;
    public int policy_type;
    public int pool_type;
    public String pushid;
    public String qua;
    public int ratioH;
    public int ratioW;
    public int shareto;
    public String tag;
    public String title;
    public String traceId;
    public long uin;
    public int upos;
    public String vendor;
    public int video_time;
    public int video_type;
    public int windowsid;

    static {
        cache_map_pass_back.put(0, new byte[]{0});
        HashMap hashMap = new HashMap();
        cache_ext_map = hashMap;
        hashMap.put("", "");
        cache_device = new stDevice();
        HashMap hashMap2 = new HashMap();
        cache_feed_map_ext = hashMap2;
        hashMap2.put("", "");
    }

    public stReportItem() {
        this.imp_date = 0L;
        this.personid = "";
        this.uin = 0L;
        this.feedid = "";
        this.pagetype = 0;
        this.optype = 0;
        this.play_time = 0;
        this.video_time = 0;
        this.authorid = "";
        this.authorname = "";
        this.title = "";
        this.upos = 0;
        this.dislike_reason = "";
        this.jubao_reason = "";
        this.shareto = 0;
        this.cate = "";
        this.tag = "";
        this.network_type = "";
        this.f25125os = "";
        this.city = "";
        this.f25124ip = "";
        this.map_pass_back = null;
        this.windowsid = 0;
        this.ext_map = null;
        this.cid = 0;
        this.video_type = 0;
        this.qua = "";
        this.vendor = "";
        this.downloadscene = "";
        this.device = null;
        this.pushid = "";
        this.exist_weishi = 0;
        this.policy_type = 0;
        this.op_location = 0;
        this.card_type = 0;
        this.pool_type = 0;
        this.ratioH = 0;
        this.ratioW = 0;
        this.isFullSpan = true;
        this.originImgUrl = "";
        this.comment_loctaion = 0;
        this.traceId = "";
        this.feed_map_ext = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imp_date = jceInputStream.read(this.imp_date, 0, false);
        this.personid = jceInputStream.readString(1, false);
        this.uin = jceInputStream.read(this.uin, 2, false);
        this.feedid = jceInputStream.readString(3, false);
        this.pagetype = jceInputStream.read(this.pagetype, 4, false);
        this.optype = jceInputStream.read(this.optype, 5, false);
        this.play_time = jceInputStream.read(this.play_time, 6, false);
        this.video_time = jceInputStream.read(this.video_time, 7, false);
        this.authorid = jceInputStream.readString(8, false);
        this.authorname = jceInputStream.readString(9, false);
        this.title = jceInputStream.readString(10, false);
        this.upos = jceInputStream.read(this.upos, 11, false);
        this.dislike_reason = jceInputStream.readString(12, false);
        this.jubao_reason = jceInputStream.readString(13, false);
        this.shareto = jceInputStream.read(this.shareto, 14, false);
        this.cate = jceInputStream.readString(15, false);
        this.tag = jceInputStream.readString(16, false);
        this.network_type = jceInputStream.readString(17, false);
        this.f25125os = jceInputStream.readString(18, false);
        this.city = jceInputStream.readString(19, false);
        this.f25124ip = jceInputStream.readString(20, false);
        this.map_pass_back = (Map) jceInputStream.read((JceInputStream) cache_map_pass_back, 21, false);
        this.windowsid = jceInputStream.read(this.windowsid, 22, false);
        this.ext_map = (Map) jceInputStream.read((JceInputStream) cache_ext_map, 23, false);
        this.cid = jceInputStream.read(this.cid, 24, false);
        this.video_type = jceInputStream.read(this.video_type, 25, false);
        this.qua = jceInputStream.readString(26, false);
        this.vendor = jceInputStream.readString(27, false);
        this.downloadscene = jceInputStream.readString(28, false);
        this.device = (stDevice) jceInputStream.read((JceStruct) cache_device, 29, false);
        this.pushid = jceInputStream.readString(30, false);
        this.exist_weishi = jceInputStream.read(this.exist_weishi, 31, false);
        this.policy_type = jceInputStream.read(this.policy_type, 32, false);
        this.op_location = jceInputStream.read(this.op_location, 33, false);
        this.card_type = jceInputStream.read(this.card_type, 34, false);
        this.pool_type = jceInputStream.read(this.pool_type, 35, false);
        this.ratioH = jceInputStream.read(this.ratioH, 36, false);
        this.ratioW = jceInputStream.read(this.ratioW, 37, false);
        this.isFullSpan = jceInputStream.read(this.isFullSpan, 38, false);
        this.originImgUrl = jceInputStream.readString(39, false);
        this.comment_loctaion = jceInputStream.read(this.comment_loctaion, 40, false);
        this.traceId = jceInputStream.readString(41, false);
        this.feed_map_ext = (Map) jceInputStream.read((JceInputStream) cache_feed_map_ext, 42, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stReportItem{imp_date=" + this.imp_date + ", personid='" + this.personid + "', uin=" + this.uin + ", feedid='" + this.feedid + "', pagetype=" + this.pagetype + ", optype=" + this.optype + ", play_time=" + this.play_time + ", video_time=" + this.video_time + ", authorid='" + this.authorid + "', authorname='" + this.authorname + "', title='" + this.title + "', upos=" + this.upos + ", dislike_reason='" + this.dislike_reason + "', jubao_reason='" + this.jubao_reason + "', shareto=" + this.shareto + ", cate='" + this.cate + "', tag='" + this.tag + "', network_type='" + this.network_type + "', os='" + this.f25125os + "', city='" + this.city + "', ip='" + this.f25124ip + "', map_pass_back=" + this.map_pass_back + ", windowsid=" + this.windowsid + ", ext_map=" + this.ext_map + ", cid=" + this.cid + ", video_type=" + this.video_type + ", qua='" + this.qua + "', vendor='" + this.vendor + "', downloadscene='" + this.downloadscene + "', device=" + this.device + ", pushid='" + this.pushid + "', exist_weishi=" + this.exist_weishi + ", policy_type=" + this.policy_type + ", op_location=" + this.op_location + ", card_type=" + this.card_type + ", pool_type=" + this.pool_type + ", ratioH=" + this.ratioH + ", ratioW=" + this.ratioW + ", isFullSpan=" + this.isFullSpan + ", originImgUrl='" + this.originImgUrl + "', comment_loctaion=" + this.comment_loctaion + ", traceId='" + this.traceId + "', feed_map_ext=" + this.feed_map_ext + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.imp_date, 0);
        String str = this.personid;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.uin, 2);
        String str2 = this.feedid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.pagetype, 4);
        jceOutputStream.write(this.optype, 5);
        jceOutputStream.write(this.play_time, 6);
        jceOutputStream.write(this.video_time, 7);
        String str3 = this.authorid;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.authorname;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        String str5 = this.title;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        jceOutputStream.write(this.upos, 11);
        String str6 = this.dislike_reason;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        String str7 = this.jubao_reason;
        if (str7 != null) {
            jceOutputStream.write(str7, 13);
        }
        jceOutputStream.write(this.shareto, 14);
        String str8 = this.cate;
        if (str8 != null) {
            jceOutputStream.write(str8, 15);
        }
        String str9 = this.tag;
        if (str9 != null) {
            jceOutputStream.write(str9, 16);
        }
        String str10 = this.network_type;
        if (str10 != null) {
            jceOutputStream.write(str10, 17);
        }
        String str11 = this.f25125os;
        if (str11 != null) {
            jceOutputStream.write(str11, 18);
        }
        String str12 = this.city;
        if (str12 != null) {
            jceOutputStream.write(str12, 19);
        }
        String str13 = this.f25124ip;
        if (str13 != null) {
            jceOutputStream.write(str13, 20);
        }
        Map<Integer, byte[]> map = this.map_pass_back;
        if (map != null) {
            jceOutputStream.write((Map) map, 21);
        }
        jceOutputStream.write(this.windowsid, 22);
        Map<String, String> map2 = this.ext_map;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 23);
        }
        jceOutputStream.write(this.cid, 24);
        jceOutputStream.write(this.video_type, 25);
        String str14 = this.qua;
        if (str14 != null) {
            jceOutputStream.write(str14, 26);
        }
        String str15 = this.vendor;
        if (str15 != null) {
            jceOutputStream.write(str15, 27);
        }
        String str16 = this.downloadscene;
        if (str16 != null) {
            jceOutputStream.write(str16, 28);
        }
        stDevice stdevice = this.device;
        if (stdevice != null) {
            jceOutputStream.write((JceStruct) stdevice, 29);
        }
        String str17 = this.pushid;
        if (str17 != null) {
            jceOutputStream.write(str17, 30);
        }
        jceOutputStream.write(this.exist_weishi, 31);
        jceOutputStream.write(this.policy_type, 32);
        jceOutputStream.write(this.op_location, 33);
        jceOutputStream.write(this.card_type, 34);
        jceOutputStream.write(this.pool_type, 35);
        jceOutputStream.write(this.ratioH, 36);
        jceOutputStream.write(this.ratioW, 37);
        jceOutputStream.write(this.isFullSpan, 38);
        String str18 = this.originImgUrl;
        if (str18 != null) {
            jceOutputStream.write(str18, 39);
        }
        jceOutputStream.write(this.comment_loctaion, 40);
        String str19 = this.traceId;
        if (str19 != null) {
            jceOutputStream.write(str19, 41);
        }
        Map<String, String> map3 = this.feed_map_ext;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 42);
        }
    }

    public stReportItem(long j3, String str, long j16, String str2, int i3, int i16, int i17, int i18, String str3, String str4, String str5, int i19, String str6, String str7, int i26, String str8, String str9, String str10, String str11, String str12, String str13, Map<Integer, byte[]> map, int i27, Map<String, String> map2, int i28, int i29, String str14, String str15, String str16, stDevice stdevice, String str17, int i36, int i37, int i38, int i39, int i46, int i47, int i48, boolean z16, String str18, int i49, String str19, Map<String, String> map3) {
        this.imp_date = j3;
        this.personid = str;
        this.uin = j16;
        this.feedid = str2;
        this.pagetype = i3;
        this.optype = i16;
        this.play_time = i17;
        this.video_time = i18;
        this.authorid = str3;
        this.authorname = str4;
        this.title = str5;
        this.upos = i19;
        this.dislike_reason = str6;
        this.jubao_reason = str7;
        this.shareto = i26;
        this.cate = str8;
        this.tag = str9;
        this.network_type = str10;
        this.f25125os = str11;
        this.city = str12;
        this.f25124ip = str13;
        this.map_pass_back = map;
        this.windowsid = i27;
        this.ext_map = map2;
        this.cid = i28;
        this.video_type = i29;
        this.qua = str14;
        this.vendor = str15;
        this.downloadscene = str16;
        this.device = stdevice;
        this.pushid = str17;
        this.exist_weishi = i36;
        this.policy_type = i37;
        this.op_location = i38;
        this.card_type = i39;
        this.pool_type = i46;
        this.ratioH = i47;
        this.ratioW = i48;
        this.isFullSpan = z16;
        this.originImgUrl = str18;
        this.comment_loctaion = i49;
        this.traceId = str19;
        this.feed_map_ext = map3;
    }
}
