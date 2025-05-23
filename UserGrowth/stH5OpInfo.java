package UserGrowth;

import NS_KING_SOCIALIZE_META.stMetaTag;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stH5OpInfo extends JceStruct {
    static Map<String, String> cache_exp;
    static stMetaTag cache_tag = new stMetaTag();
    public Map<String, String> exp;
    public String h5Url;

    /* renamed from: id, reason: collision with root package name */
    public int f25120id;
    public String maskImgUrl;
    public String scheme_url;
    public stMetaTag tag;
    public String text;
    public int type;

    static {
        HashMap hashMap = new HashMap();
        cache_exp = hashMap;
        hashMap.put("", "");
    }

    public stH5OpInfo() {
        this.f25120id = 0;
        this.h5Url = "";
        this.tag = null;
        this.text = "";
        this.type = 0;
        this.scheme_url = "";
        this.maskImgUrl = "";
        this.exp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25120id = jceInputStream.read(this.f25120id, 0, false);
        this.h5Url = jceInputStream.readString(1, false);
        this.tag = (stMetaTag) jceInputStream.read((JceStruct) cache_tag, 2, false);
        this.text = jceInputStream.readString(3, false);
        this.type = jceInputStream.read(this.type, 4, false);
        this.scheme_url = jceInputStream.readString(5, false);
        this.maskImgUrl = jceInputStream.readString(6, false);
        this.exp = (Map) jceInputStream.read((JceInputStream) cache_exp, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25120id, 0);
        String str = this.h5Url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        stMetaTag stmetatag = this.tag;
        if (stmetatag != null) {
            jceOutputStream.write((JceStruct) stmetatag, 2);
        }
        String str2 = this.text;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.type, 4);
        String str3 = this.scheme_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.maskImgUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        Map<String, String> map = this.exp;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
    }

    public stH5OpInfo(int i3, String str, stMetaTag stmetatag, String str2, int i16, String str3, String str4, Map<String, String> map) {
        this.f25120id = i3;
        this.h5Url = str;
        this.tag = stmetatag;
        this.text = str2;
        this.type = i16;
        this.scheme_url = str3;
        this.maskImgUrl = str4;
        this.exp = map;
    }
}
