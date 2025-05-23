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
public final class cell_funny_tread_space extends JceStruct {
    static ArrayList<String> cache_actions;
    static Map<String, String> cache_extendInfo;
    public ArrayList<String> actions;
    public Map<String, String> extendInfo;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_actions = arrayList;
        arrayList.add("");
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
    }

    public cell_funny_tread_space() {
        this.actions = null;
        this.extendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.actions = (ArrayList) jceInputStream.read((JceInputStream) cache_actions, 0, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.actions;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public cell_funny_tread_space(ArrayList<String> arrayList, Map<String, String> map) {
        this.actions = arrayList;
        this.extendInfo = map;
    }
}
