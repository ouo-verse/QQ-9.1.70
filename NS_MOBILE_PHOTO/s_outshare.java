package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_arkshare;
import NS_MOBILE_FEEDS.s_picurl;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_outshare extends JceStruct {
    static s_arkshare cache_ark_sharedata;
    static Map<Integer, s_picurl> cache_photourl = new HashMap();
    public int album_right;
    public s_arkshare ark_sharedata;
    public String buffer;
    public String md5;
    public int opmask;
    public Map<Integer, s_picurl> photourl;
    public String qq_url;
    public int space_right;
    public String summary;
    public String title;
    public String weixin_url;
    public String xcx_name;
    public String xcx_share_path;

    static {
        cache_photourl.put(0, new s_picurl());
        cache_ark_sharedata = new s_arkshare();
    }

    public s_outshare() {
        this.weixin_url = "";
        this.qq_url = "";
        this.title = "";
        this.summary = "";
        this.photourl = null;
        this.space_right = 0;
        this.album_right = 0;
        this.xcx_share_path = "";
        this.xcx_name = "";
        this.md5 = "";
        this.buffer = "";
        this.opmask = 0;
        this.ark_sharedata = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.weixin_url = jceInputStream.readString(0, false);
        this.qq_url = jceInputStream.readString(1, false);
        this.title = jceInputStream.readString(2, false);
        this.summary = jceInputStream.readString(3, false);
        this.photourl = (Map) jceInputStream.read((JceInputStream) cache_photourl, 4, false);
        this.space_right = jceInputStream.read(this.space_right, 5, false);
        this.album_right = jceInputStream.read(this.album_right, 6, false);
        this.xcx_share_path = jceInputStream.readString(7, false);
        this.xcx_name = jceInputStream.readString(8, false);
        this.md5 = jceInputStream.readString(9, false);
        this.buffer = jceInputStream.readString(10, false);
        this.opmask = jceInputStream.read(this.opmask, 11, false);
        this.ark_sharedata = (s_arkshare) jceInputStream.read((JceStruct) cache_ark_sharedata, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.weixin_url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.qq_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.title;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.summary;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        Map<Integer, s_picurl> map = this.photourl;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        jceOutputStream.write(this.space_right, 5);
        jceOutputStream.write(this.album_right, 6);
        String str5 = this.xcx_share_path;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.xcx_name;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        String str7 = this.md5;
        if (str7 != null) {
            jceOutputStream.write(str7, 9);
        }
        String str8 = this.buffer;
        if (str8 != null) {
            jceOutputStream.write(str8, 10);
        }
        jceOutputStream.write(this.opmask, 11);
        s_arkshare s_arkshareVar = this.ark_sharedata;
        if (s_arkshareVar != null) {
            jceOutputStream.write((JceStruct) s_arkshareVar, 12);
        }
    }

    public s_outshare(String str, String str2, String str3, String str4, Map<Integer, s_picurl> map, int i3, int i16, String str5, String str6, String str7, String str8, int i17, s_arkshare s_arkshareVar) {
        this.weixin_url = str;
        this.qq_url = str2;
        this.title = str3;
        this.summary = str4;
        this.photourl = map;
        this.space_right = i3;
        this.album_right = i16;
        this.xcx_share_path = str5;
        this.xcx_name = str6;
        this.md5 = str7;
        this.buffer = str8;
        this.opmask = i17;
        this.ark_sharedata = s_arkshareVar;
    }
}
