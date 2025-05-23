package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class REPORT_INFO extends JceStruct {
    static ArrayList<Map<String, String>> cache_info = new ArrayList<>();
    public ArrayList<Map<String, String>> info;
    public int subtable;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("", "");
        cache_info.add(hashMap);
    }

    public REPORT_INFO() {
        this.subtable = 0;
        this.info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.subtable = jceInputStream.read(this.subtable, 0, false);
        this.info = (ArrayList) jceInputStream.read((JceInputStream) cache_info, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.subtable, 0);
        ArrayList<Map<String, String>> arrayList = this.info;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public REPORT_INFO(int i3, ArrayList<Map<String, String>> arrayList) {
        this.subtable = i3;
        this.info = arrayList;
    }
}
