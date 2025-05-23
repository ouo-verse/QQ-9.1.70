package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class IconInfo extends JceStruct {
    static Map<String, String> cache_mapExtendInfo;
    public Map<String, String> commonMapExtendInfo;
    public int iHigh;
    public int iWidth;
    public Map<String, String> mapExtendInfo;
    public String strUrl;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExtendInfo = hashMap;
        hashMap.put("", "");
    }

    public IconInfo() {
        this.strUrl = "";
        this.iWidth = 0;
        this.iHigh = 0;
        this.mapExtendInfo = null;
        this.commonMapExtendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strUrl = jceInputStream.readString(0, false);
        this.iWidth = jceInputStream.read(this.iWidth, 1, false);
        this.iHigh = jceInputStream.read(this.iHigh, 2, false);
        this.mapExtendInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtendInfo, 3, false);
        this.commonMapExtendInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtendInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iWidth, 1);
        jceOutputStream.write(this.iHigh, 2);
        Map<String, String> map = this.mapExtendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        Map<String, String> map2 = this.commonMapExtendInfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 4);
        }
    }

    public IconInfo(String str, int i3, int i16, Map<String, String> map, Map<String, String> map2) {
        this.strUrl = str;
        this.iWidth = i3;
        this.iHigh = i16;
        this.mapExtendInfo = map;
        this.commonMapExtendInfo = map2;
    }
}
