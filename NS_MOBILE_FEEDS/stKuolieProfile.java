package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class stKuolieProfile extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static s_user cache_user = new s_user();
    public int CommOpmask2;
    public int CommOpmask3;
    public int FeedsCount;
    public Map<String, String> extendinfo;
    public s_user user;

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
    }

    public stKuolieProfile() {
        this.user = null;
        this.CommOpmask2 = 0;
        this.FeedsCount = 0;
        this.extendinfo = null;
        this.CommOpmask3 = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 0, false);
        this.CommOpmask2 = jceInputStream.read(this.CommOpmask2, 1, false);
        this.FeedsCount = jceInputStream.read(this.FeedsCount, 2, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 3, false);
        this.CommOpmask3 = jceInputStream.read(this.CommOpmask3, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        jceOutputStream.write(this.CommOpmask2, 1);
        jceOutputStream.write(this.FeedsCount, 2);
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.CommOpmask3, 4);
    }

    public stKuolieProfile(s_user s_userVar, int i3, int i16, Map<String, String> map, int i17) {
        this.user = s_userVar;
        this.CommOpmask2 = i3;
        this.FeedsCount = i16;
        this.extendinfo = map;
        this.CommOpmask3 = i17;
    }
}
