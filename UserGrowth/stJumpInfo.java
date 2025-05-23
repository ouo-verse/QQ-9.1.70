package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stJumpInfo extends JceStruct {
    static Map<String, String> cache_mapExt;
    public String h5url;

    /* renamed from: id, reason: collision with root package name */
    public int f25121id;
    public int index;
    public Map<String, String> mapExt;
    public String schema_url;
    public String text;
    public String trace_id;
    public String url;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
    }

    public stJumpInfo() {
        this.index = 0;
        this.url = "";
        this.text = "";
        this.mapExt = null;
        this.f25121id = 0;
        this.h5url = "";
        this.schema_url = "";
        this.trace_id = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.index = jceInputStream.read(this.index, 0, false);
        this.url = jceInputStream.readString(1, false);
        this.text = jceInputStream.readString(2, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 3, false);
        this.f25121id = jceInputStream.read(this.f25121id, 4, false);
        this.h5url = jceInputStream.readString(5, false);
        this.schema_url = jceInputStream.readString(6, false);
        this.trace_id = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.index, 0);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.text;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.f25121id, 4);
        String str3 = this.h5url;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.schema_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.trace_id;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
    }

    public stJumpInfo(int i3, String str, String str2, Map<String, String> map, int i16, String str3, String str4, String str5) {
        this.index = i3;
        this.url = str;
        this.text = str2;
        this.mapExt = map;
        this.f25121id = i16;
        this.h5url = str3;
        this.schema_url = str4;
        this.trace_id = str5;
    }
}
