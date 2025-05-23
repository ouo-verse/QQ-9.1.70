package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_publishmood_req extends JceStruct {
    static Map<String, String> cache_extend_info;
    static LbsInfo cache_hidden_poi;
    static Map<String, byte[]> cache_proto_extend_info;
    static NS_MOBILE_COMM.UgcRightInfo cache_right_info;
    static ShootInfo cache_shootInfo;
    static Map<String, String> cache_stored_extend_info;
    public Map<Integer, String> busi_param;
    public String clientkey;
    public String content;
    public Map<String, String> extend_info;
    public short frames;
    public LbsInfo hidden_poi;
    public int isWinPhone;
    public boolean issynctoweibo;
    public boolean isverified;
    public LbsInfo lbsinfo;
    public long lock_days;
    public int mediaSubType;
    public int mediabittype;
    public MediaInfo mediainfo;
    public int mediatype;
    public int modifyflag;
    public String open_appid;
    public Map<String, byte[]> proto_extend_info;
    public long publishTime;
    public String richtype;
    public String richval;
    public NS_MOBILE_COMM.UgcRightInfo right_info;
    public long seal_id;
    public ShootInfo shootInfo;
    public Source source;
    public String sourceName;
    public String srcid;
    public Map<String, String> stored_extend_info;
    public long uin;
    public String weibourl;
    static MediaInfo cache_mediainfo = new MediaInfo();
    static LbsInfo cache_lbsinfo = new LbsInfo();
    static Source cache_source = new Source();
    static Map<Integer, String> cache_busi_param = new HashMap();

    static {
        cache_busi_param.put(0, "");
        cache_right_info = new NS_MOBILE_COMM.UgcRightInfo();
        cache_shootInfo = new ShootInfo();
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
        cache_hidden_poi = new LbsInfo();
        HashMap hashMap2 = new HashMap();
        cache_stored_extend_info = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        cache_proto_extend_info = hashMap3;
        hashMap3.put("", new byte[]{0});
    }

    public operation_publishmood_req() {
        this.uin = 0L;
        this.content = "";
        this.isverified = true;
        this.issynctoweibo = true;
        this.weibourl = "";
        this.mediatype = 0;
        this.mediainfo = null;
        this.lbsinfo = null;
        this.source = null;
        this.mediabittype = 0;
        this.busi_param = null;
        this.clientkey = "";
        this.open_appid = "";
        this.right_info = null;
        this.shootInfo = null;
        this.publishTime = 0L;
        this.mediaSubType = 0;
        this.srcid = "";
        this.modifyflag = 0;
        this.extend_info = null;
        this.richtype = "";
        this.richval = "";
        this.isWinPhone = 0;
        this.sourceName = "";
        this.hidden_poi = null;
        this.seal_id = 0L;
        this.frames = (short) 0;
        this.lock_days = 0L;
        this.stored_extend_info = null;
        this.proto_extend_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.content = jceInputStream.readString(1, false);
        this.isverified = jceInputStream.read(this.isverified, 2, false);
        this.issynctoweibo = jceInputStream.read(this.issynctoweibo, 3, false);
        this.weibourl = jceInputStream.readString(4, false);
        this.mediatype = jceInputStream.read(this.mediatype, 5, false);
        this.mediainfo = (MediaInfo) jceInputStream.read((JceStruct) cache_mediainfo, 6, false);
        this.lbsinfo = (LbsInfo) jceInputStream.read((JceStruct) cache_lbsinfo, 7, false);
        this.source = (Source) jceInputStream.read((JceStruct) cache_source, 8, false);
        this.mediabittype = jceInputStream.read(this.mediabittype, 9, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 10, false);
        this.clientkey = jceInputStream.readString(11, false);
        this.open_appid = jceInputStream.readString(12, false);
        this.right_info = (NS_MOBILE_COMM.UgcRightInfo) jceInputStream.read((JceStruct) cache_right_info, 13, false);
        this.shootInfo = (ShootInfo) jceInputStream.read((JceStruct) cache_shootInfo, 14, false);
        this.publishTime = jceInputStream.read(this.publishTime, 15, false);
        this.mediaSubType = jceInputStream.read(this.mediaSubType, 16, false);
        this.srcid = jceInputStream.readString(17, false);
        this.modifyflag = jceInputStream.read(this.modifyflag, 18, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 19, false);
        this.richtype = jceInputStream.readString(20, false);
        this.richval = jceInputStream.readString(21, false);
        this.isWinPhone = jceInputStream.read(this.isWinPhone, 22, false);
        this.sourceName = jceInputStream.readString(23, false);
        this.hidden_poi = (LbsInfo) jceInputStream.read((JceStruct) cache_hidden_poi, 24, false);
        this.seal_id = jceInputStream.read(this.seal_id, 25, false);
        this.frames = jceInputStream.read(this.frames, 26, false);
        this.lock_days = jceInputStream.read(this.lock_days, 27, false);
        this.stored_extend_info = (Map) jceInputStream.read((JceInputStream) cache_stored_extend_info, 28, false);
        this.proto_extend_info = (Map) jceInputStream.read((JceInputStream) cache_proto_extend_info, 29, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.content;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.isverified, 2);
        jceOutputStream.write(this.issynctoweibo, 3);
        String str2 = this.weibourl;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.mediatype, 5);
        MediaInfo mediaInfo = this.mediainfo;
        if (mediaInfo != null) {
            jceOutputStream.write((JceStruct) mediaInfo, 6);
        }
        LbsInfo lbsInfo = this.lbsinfo;
        if (lbsInfo != null) {
            jceOutputStream.write((JceStruct) lbsInfo, 7);
        }
        Source source = this.source;
        if (source != null) {
            jceOutputStream.write((JceStruct) source, 8);
        }
        jceOutputStream.write(this.mediabittype, 9);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
        String str3 = this.clientkey;
        if (str3 != null) {
            jceOutputStream.write(str3, 11);
        }
        String str4 = this.open_appid;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        NS_MOBILE_COMM.UgcRightInfo ugcRightInfo = this.right_info;
        if (ugcRightInfo != null) {
            jceOutputStream.write((JceStruct) ugcRightInfo, 13);
        }
        ShootInfo shootInfo = this.shootInfo;
        if (shootInfo != null) {
            jceOutputStream.write((JceStruct) shootInfo, 14);
        }
        jceOutputStream.write(this.publishTime, 15);
        jceOutputStream.write(this.mediaSubType, 16);
        String str5 = this.srcid;
        if (str5 != null) {
            jceOutputStream.write(str5, 17);
        }
        jceOutputStream.write(this.modifyflag, 18);
        Map<String, String> map2 = this.extend_info;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 19);
        }
        String str6 = this.richtype;
        if (str6 != null) {
            jceOutputStream.write(str6, 20);
        }
        String str7 = this.richval;
        if (str7 != null) {
            jceOutputStream.write(str7, 21);
        }
        jceOutputStream.write(this.isWinPhone, 22);
        String str8 = this.sourceName;
        if (str8 != null) {
            jceOutputStream.write(str8, 23);
        }
        LbsInfo lbsInfo2 = this.hidden_poi;
        if (lbsInfo2 != null) {
            jceOutputStream.write((JceStruct) lbsInfo2, 24);
        }
        jceOutputStream.write(this.seal_id, 25);
        jceOutputStream.write(this.frames, 26);
        jceOutputStream.write(this.lock_days, 27);
        Map<String, String> map3 = this.stored_extend_info;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 28);
        }
        Map<String, byte[]> map4 = this.proto_extend_info;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 29);
        }
    }

    public operation_publishmood_req(long j3, String str, boolean z16, boolean z17, String str2, int i3, MediaInfo mediaInfo, LbsInfo lbsInfo, Source source, int i16, Map<Integer, String> map, String str3, String str4, NS_MOBILE_COMM.UgcRightInfo ugcRightInfo, ShootInfo shootInfo, long j16, int i17, String str5, int i18, Map<String, String> map2, String str6, String str7, int i19, String str8, LbsInfo lbsInfo2, long j17, short s16, long j18, Map<String, String> map3, Map<String, byte[]> map4) {
        this.uin = j3;
        this.content = str;
        this.isverified = z16;
        this.issynctoweibo = z17;
        this.weibourl = str2;
        this.mediatype = i3;
        this.mediainfo = mediaInfo;
        this.lbsinfo = lbsInfo;
        this.source = source;
        this.mediabittype = i16;
        this.busi_param = map;
        this.clientkey = str3;
        this.open_appid = str4;
        this.right_info = ugcRightInfo;
        this.shootInfo = shootInfo;
        this.publishTime = j16;
        this.mediaSubType = i17;
        this.srcid = str5;
        this.modifyflag = i18;
        this.extend_info = map2;
        this.richtype = str6;
        this.richval = str7;
        this.isWinPhone = i19;
        this.sourceName = str8;
        this.hidden_poi = lbsInfo2;
        this.seal_id = j17;
        this.frames = s16;
        this.lock_days = j18;
        this.stored_extend_info = map3;
        this.proto_extend_info = map4;
    }
}
