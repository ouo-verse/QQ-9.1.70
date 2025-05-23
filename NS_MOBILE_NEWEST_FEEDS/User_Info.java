package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class User_Info extends JceStruct {
    static Map<String, String> cache_extendInfo;
    public int eStarState;
    public Map<String, String> extendInfo;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
    }

    public User_Info() {
        this.eStarState = 0;
        this.extendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eStarState = jceInputStream.read(this.eStarState, 0, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eStarState, 0);
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public User_Info(int i3, Map<String, String> map) {
        this.eStarState = i3;
        this.extendInfo = map;
    }
}
