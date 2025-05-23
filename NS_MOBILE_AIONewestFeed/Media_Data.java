package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Media_Data extends JceStruct {
    static Map<String, String> cache_extendInfo;
    public Map<String, String> extendInfo;
    public String strImgUrl;
    public int uType;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
    }

    public Media_Data() {
        this.strImgUrl = "";
        this.uType = 0;
        this.extendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strImgUrl = jceInputStream.readString(0, false);
        this.uType = jceInputStream.read(this.uType, 1, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strImgUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.uType, 1);
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public Media_Data(String str, int i3, Map<String, String> map) {
        this.strImgUrl = str;
        this.uType = i3;
        this.extendInfo = map;
    }
}
