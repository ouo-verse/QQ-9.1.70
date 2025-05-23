package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stIntimateSpaceInfo extends JceStruct {
    static Map<String, String> cache_entranceExtInfo;
    static Map<Integer, byte[]> cache_mapOptData;
    public Map<String, String> entranceExtInfo;
    public String iconUrl;
    public String jumpUrl;
    public Map<Integer, byte[]> mapOptData;
    public String rightText;
    public String text;
    public boolean update;

    static {
        HashMap hashMap = new HashMap();
        cache_entranceExtInfo = hashMap;
        hashMap.put("", "");
        cache_mapOptData = new HashMap();
        cache_mapOptData.put(0, new byte[]{0});
    }

    public stIntimateSpaceInfo() {
        this.iconUrl = "";
        this.jumpUrl = "";
        this.text = "";
        this.rightText = "";
        this.entranceExtInfo = null;
        this.update = false;
        this.mapOptData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iconUrl = jceInputStream.readString(0, true);
        this.jumpUrl = jceInputStream.readString(1, true);
        this.text = jceInputStream.readString(2, true);
        this.rightText = jceInputStream.readString(3, false);
        this.entranceExtInfo = (Map) jceInputStream.read((JceInputStream) cache_entranceExtInfo, 4, false);
        this.update = jceInputStream.read(this.update, 5, false);
        this.mapOptData = (Map) jceInputStream.read((JceInputStream) cache_mapOptData, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iconUrl, 0);
        jceOutputStream.write(this.jumpUrl, 1);
        jceOutputStream.write(this.text, 2);
        String str = this.rightText;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        Map<String, String> map = this.entranceExtInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        jceOutputStream.write(this.update, 5);
        Map<Integer, byte[]> map2 = this.mapOptData;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 6);
        }
    }

    public stIntimateSpaceInfo(String str, String str2, String str3, String str4, Map<String, String> map, boolean z16, Map<Integer, byte[]> map2) {
        this.iconUrl = str;
        this.jumpUrl = str2;
        this.text = str3;
        this.rightText = str4;
        this.entranceExtInfo = map;
        this.update = z16;
        this.mapOptData = map2;
    }
}
