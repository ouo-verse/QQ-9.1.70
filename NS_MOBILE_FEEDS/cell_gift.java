package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_gift extends JceStruct {
    static int cache_giftactiontype;
    static Map<Integer, String> cache_gifturl = new HashMap();
    public String actionurl;
    public int giftactiontype;
    public String giftbackid;
    public String giftdesc;
    public String giftid;
    public String giftname;
    public String gifttype;
    public Map<Integer, String> gifturl;

    static {
        cache_gifturl.put(0, "");
        cache_giftactiontype = 0;
    }

    public cell_gift() {
        this.giftname = "";
        this.gifttype = "";
        this.giftid = "";
        this.gifturl = null;
        this.giftdesc = "";
        this.giftbackid = "";
        this.giftactiontype = 1;
        this.actionurl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.giftname = jceInputStream.readString(0, false);
        this.gifttype = jceInputStream.readString(1, false);
        this.giftid = jceInputStream.readString(2, false);
        this.gifturl = (Map) jceInputStream.read((JceInputStream) cache_gifturl, 3, false);
        this.giftdesc = jceInputStream.readString(4, false);
        this.giftbackid = jceInputStream.readString(5, false);
        this.giftactiontype = jceInputStream.read(this.giftactiontype, 6, false);
        this.actionurl = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.giftname;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.gifttype;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.giftid;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        Map<Integer, String> map = this.gifturl;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        String str4 = this.giftdesc;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.giftbackid;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.giftactiontype, 6);
        String str6 = this.actionurl;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
    }

    public cell_gift(String str, String str2, String str3, Map<Integer, String> map, String str4, String str5, int i3, String str6) {
        this.giftname = str;
        this.gifttype = str2;
        this.giftid = str3;
        this.gifturl = map;
        this.giftdesc = str4;
        this.giftbackid = str5;
        this.giftactiontype = i3;
        this.actionurl = str6;
    }
}
