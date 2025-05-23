package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class OneVideoInfo extends JceStruct {
    static Map<String, String> cache_extendinfo;
    public int actiontype;
    public String actionurl;
    public String clientkey;
    public int commentCount;
    public String coverurl;
    public long createtime;
    public Map<String, String> extendinfo;
    public int filetype;
    public int height;
    public int ifLiked;
    public String likeKey;
    public int likeNum;
    public String lloc;
    public byte playtype;
    public String qqUrl;
    public String shuoid;
    public String sloc;
    public String toast;
    public String ugckey;
    public String videoid;
    public int videostatus;
    public long videotime;
    public byte videotype;
    public String videourl;
    public String weixinUrl;
    public int width;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public OneVideoInfo() {
        this.videoid = "";
        this.videourl = "";
        this.coverurl = "";
        this.actiontype = 0;
        this.actionurl = "";
        this.clientkey = "";
        this.filetype = 0;
        this.videotype = (byte) 0;
        this.videotime = 0L;
        this.createtime = 0L;
        this.playtype = (byte) 0;
        this.videostatus = 0;
        this.toast = "";
        this.extendinfo = null;
        this.sloc = "";
        this.lloc = "";
        this.width = 0;
        this.height = 0;
        this.shuoid = "";
        this.likeNum = 0;
        this.weixinUrl = "";
        this.qqUrl = "";
        this.ifLiked = 0;
        this.commentCount = 0;
        this.likeKey = "";
        this.ugckey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.videoid = jceInputStream.readString(0, false);
        this.videourl = jceInputStream.readString(1, false);
        this.coverurl = jceInputStream.readString(2, false);
        this.actiontype = jceInputStream.read(this.actiontype, 3, false);
        this.actionurl = jceInputStream.readString(4, false);
        this.clientkey = jceInputStream.readString(5, false);
        this.filetype = jceInputStream.read(this.filetype, 6, false);
        this.videotype = jceInputStream.read(this.videotype, 7, false);
        this.videotime = jceInputStream.read(this.videotime, 8, false);
        this.createtime = jceInputStream.read(this.createtime, 9, false);
        this.playtype = jceInputStream.read(this.playtype, 10, false);
        this.videostatus = jceInputStream.read(this.videostatus, 11, false);
        this.toast = jceInputStream.readString(12, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 13, false);
        this.sloc = jceInputStream.readString(14, false);
        this.lloc = jceInputStream.readString(15, false);
        this.width = jceInputStream.read(this.width, 16, false);
        this.height = jceInputStream.read(this.height, 17, false);
        this.shuoid = jceInputStream.readString(18, false);
        this.likeNum = jceInputStream.read(this.likeNum, 19, false);
        this.weixinUrl = jceInputStream.readString(20, false);
        this.qqUrl = jceInputStream.readString(21, false);
        this.ifLiked = jceInputStream.read(this.ifLiked, 22, false);
        this.commentCount = jceInputStream.read(this.commentCount, 23, false);
        this.likeKey = jceInputStream.readString(24, false);
        this.ugckey = jceInputStream.readString(25, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.videoid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.videourl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.coverurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.actiontype, 3);
        String str4 = this.actionurl;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.clientkey;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.filetype, 6);
        jceOutputStream.write(this.videotype, 7);
        jceOutputStream.write(this.videotime, 8);
        jceOutputStream.write(this.createtime, 9);
        jceOutputStream.write(this.playtype, 10);
        jceOutputStream.write(this.videostatus, 11);
        String str6 = this.toast;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
        String str7 = this.sloc;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        String str8 = this.lloc;
        if (str8 != null) {
            jceOutputStream.write(str8, 15);
        }
        jceOutputStream.write(this.width, 16);
        jceOutputStream.write(this.height, 17);
        String str9 = this.shuoid;
        if (str9 != null) {
            jceOutputStream.write(str9, 18);
        }
        jceOutputStream.write(this.likeNum, 19);
        String str10 = this.weixinUrl;
        if (str10 != null) {
            jceOutputStream.write(str10, 20);
        }
        String str11 = this.qqUrl;
        if (str11 != null) {
            jceOutputStream.write(str11, 21);
        }
        jceOutputStream.write(this.ifLiked, 22);
        jceOutputStream.write(this.commentCount, 23);
        String str12 = this.likeKey;
        if (str12 != null) {
            jceOutputStream.write(str12, 24);
        }
        String str13 = this.ugckey;
        if (str13 != null) {
            jceOutputStream.write(str13, 25);
        }
    }

    public OneVideoInfo(String str, String str2, String str3, int i3, String str4, String str5, int i16, byte b16, long j3, long j16, byte b17, int i17, String str6, Map<String, String> map, String str7, String str8, int i18, int i19, String str9, int i26, String str10, String str11, int i27, int i28, String str12, String str13) {
        this.videoid = str;
        this.videourl = str2;
        this.coverurl = str3;
        this.actiontype = i3;
        this.actionurl = str4;
        this.clientkey = str5;
        this.filetype = i16;
        this.videotype = b16;
        this.videotime = j3;
        this.createtime = j16;
        this.playtype = b17;
        this.videostatus = i17;
        this.toast = str6;
        this.extendinfo = map;
        this.sloc = str7;
        this.lloc = str8;
        this.width = i18;
        this.height = i19;
        this.shuoid = str9;
        this.likeNum = i26;
        this.weixinUrl = str10;
        this.qqUrl = str11;
        this.ifLiked = i27;
        this.commentCount = i28;
        this.likeKey = str12;
        this.ugckey = str13;
    }
}
