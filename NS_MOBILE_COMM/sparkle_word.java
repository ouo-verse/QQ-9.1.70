package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class sparkle_word extends JceStruct {
    static Map<String, String> cache_extend_info;
    static ArrayList<String> cache_sparkle_color;
    public Map<String, String> extend_info;
    public long span_time;
    public ArrayList<String> sparkle_color;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_sparkle_color = arrayList;
        arrayList.add("");
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public sparkle_word() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sparkle_color = (ArrayList) jceInputStream.read((JceInputStream) cache_sparkle_color, 0, false);
        this.span_time = jceInputStream.read(this.span_time, 1, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<String> arrayList = this.sparkle_color;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.span_time, 1);
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public sparkle_word(ArrayList<String> arrayList, long j3, Map<String, String> map) {
        this.sparkle_color = arrayList;
        this.span_time = j3;
        this.extend_info = map;
    }
}
