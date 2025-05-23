package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_left_thumb extends JceStruct {
    static Map<String, String> cache_mapExt;
    static s_picdata cache_picdata = new s_picdata();
    static s_user cache_user = new s_user();
    public String actionturl;
    public int actiontype;
    public Map<String, String> mapExt;
    public int mediatype;
    public int pic_actiontype;
    public String pic_actionurl;
    public s_picdata picdata;
    public String postparams;
    public String remark;
    public String summary;
    public String title;
    public byte usepost;
    public s_user user;
    public int user_actiontype;
    public String user_actionurl;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public cell_left_thumb() {
        this.mediatype = 0;
        this.picdata = null;
        this.summary = "";
        this.title = "";
        this.actiontype = 0;
        this.actionturl = "";
        this.remark = "";
        this.postparams = "";
        this.usepost = (byte) 0;
        this.user = null;
        this.pic_actiontype = -1;
        this.pic_actionurl = "";
        this.user_actiontype = 5;
        this.user_actionurl = "";
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mediatype = jceInputStream.read(this.mediatype, 0, false);
        this.picdata = (s_picdata) jceInputStream.read((JceStruct) cache_picdata, 1, false);
        this.summary = jceInputStream.readString(2, false);
        this.title = jceInputStream.readString(3, false);
        this.actiontype = jceInputStream.read(this.actiontype, 4, false);
        this.actionturl = jceInputStream.readString(5, false);
        this.remark = jceInputStream.readString(6, false);
        this.postparams = jceInputStream.readString(7, false);
        this.usepost = jceInputStream.read(this.usepost, 8, false);
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 9, false);
        this.pic_actiontype = jceInputStream.read(this.pic_actiontype, 10, false);
        this.pic_actionurl = jceInputStream.readString(11, false);
        this.user_actiontype = jceInputStream.read(this.user_actiontype, 12, false);
        this.user_actionurl = jceInputStream.readString(13, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mediatype, 0);
        s_picdata s_picdataVar = this.picdata;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 1);
        }
        String str = this.summary;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.actiontype, 4);
        String str3 = this.actionturl;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.remark;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.postparams;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.usepost, 8);
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 9);
        }
        jceOutputStream.write(this.pic_actiontype, 10);
        String str6 = this.pic_actionurl;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        jceOutputStream.write(this.user_actiontype, 12);
        String str7 = this.user_actionurl;
        if (str7 != null) {
            jceOutputStream.write(str7, 13);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 14);
        }
    }

    public cell_left_thumb(int i3, s_picdata s_picdataVar, String str, String str2, int i16, String str3, String str4, String str5, byte b16, s_user s_userVar, int i17, String str6, int i18, String str7, Map<String, String> map) {
        this.mediatype = i3;
        this.picdata = s_picdataVar;
        this.summary = str;
        this.title = str2;
        this.actiontype = i16;
        this.actionturl = str3;
        this.remark = str4;
        this.postparams = str5;
        this.usepost = b16;
        this.user = s_userVar;
        this.pic_actiontype = i17;
        this.pic_actionurl = str6;
        this.user_actiontype = i18;
        this.user_actionurl = str7;
        this.mapExt = map;
    }
}
