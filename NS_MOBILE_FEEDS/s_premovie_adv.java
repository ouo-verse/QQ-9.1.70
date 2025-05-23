package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_premovie_adv extends JceStruct {
    static Map<Integer, String> cache_report_cookie;
    public Map<Integer, String> busi_param;
    public s_premovie_item premovie;
    public Map<Integer, String> report_cookie;
    static s_premovie_item cache_premovie = new s_premovie_item();
    static Map<Integer, String> cache_busi_param = new HashMap();

    static {
        cache_busi_param.put(0, "");
        cache_report_cookie = new HashMap();
        cache_report_cookie.put(0, "");
    }

    public s_premovie_adv() {
        this.premovie = null;
        this.busi_param = null;
        this.report_cookie = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.premovie = (s_premovie_item) jceInputStream.read((JceStruct) cache_premovie, 0, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 1, false);
        this.report_cookie = (Map) jceInputStream.read((JceInputStream) cache_report_cookie, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_premovie_item s_premovie_itemVar = this.premovie;
        if (s_premovie_itemVar != null) {
            jceOutputStream.write((JceStruct) s_premovie_itemVar, 0);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
        Map<Integer, String> map2 = this.report_cookie;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 2);
        }
    }

    public s_premovie_adv(s_premovie_item s_premovie_itemVar, Map<Integer, String> map, Map<Integer, String> map2) {
        this.premovie = s_premovie_itemVar;
        this.busi_param = map;
        this.report_cookie = map2;
    }
}
