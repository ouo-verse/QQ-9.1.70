package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class st_prefetch extends JceStruct {
    static Map<String, String> cache_mapExt;
    static ArrayList<String> cache_vecPicUrl;
    public Map<String, String> mapExt;
    public String sExtendInfo;
    public ArrayList<String> vecPicUrl;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vecPicUrl = arrayList;
        arrayList.add("");
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public st_prefetch() {
        this.sExtendInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecPicUrl = (ArrayList) jceInputStream.read((JceInputStream) cache_vecPicUrl, 0, false);
        this.sExtendInfo = jceInputStream.readString(1, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.vecPicUrl;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.sExtendInfo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public st_prefetch(ArrayList<String> arrayList, String str, Map<String, String> map) {
        this.vecPicUrl = arrayList;
        this.sExtendInfo = str;
        this.mapExt = map;
    }
}
