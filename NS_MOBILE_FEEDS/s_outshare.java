package NS_MOBILE_FEEDS;

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
    public String action_url;
    public s_arkshare ark_sharedata;
    public Map<Integer, s_picurl> photourl;
    public String summary;
    public String title;

    static {
        cache_photourl.put(0, new s_picurl());
        cache_ark_sharedata = new s_arkshare();
    }

    public s_outshare() {
        this.title = "";
        this.summary = "";
        this.photourl = null;
        this.ark_sharedata = null;
        this.action_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(0, false);
        this.summary = jceInputStream.readString(1, false);
        this.photourl = (Map) jceInputStream.read((JceInputStream) cache_photourl, 2, false);
        this.ark_sharedata = (s_arkshare) jceInputStream.read((JceStruct) cache_ark_sharedata, 3, false);
        this.action_url = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        Map<Integer, s_picurl> map = this.photourl;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        s_arkshare s_arkshareVar = this.ark_sharedata;
        if (s_arkshareVar != null) {
            jceOutputStream.write((JceStruct) s_arkshareVar, 3);
        }
        String str3 = this.action_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public s_outshare(String str, String str2, Map<Integer, s_picurl> map, s_arkshare s_arkshareVar, String str3) {
        this.title = str;
        this.summary = str2;
        this.photourl = map;
        this.ark_sharedata = s_arkshareVar;
        this.action_url = str3;
    }
}
