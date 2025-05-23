package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaReportDataItem extends JceStruct {
    static Map<String, String> cache_strData;
    public Map<String, String> strData;

    static {
        HashMap hashMap = new HashMap();
        cache_strData = hashMap;
        hashMap.put("", "");
    }

    public stMetaReportDataItem() {
        this.strData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strData = (Map) jceInputStream.read((JceInputStream) cache_strData, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.strData, 0);
    }

    public stMetaReportDataItem(Map<String, String> map) {
        this.strData = map;
    }
}
