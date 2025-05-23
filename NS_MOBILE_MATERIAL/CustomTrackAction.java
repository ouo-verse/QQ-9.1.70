package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomTrackAction extends JceStruct {
    static Map<String, String> cache_ExtendInfo;
    public String Button;
    public Map<String, String> ExtendInfo;
    public String ID;
    public String Name;
    public int Type;
    public String Url;
    public int is_block;

    static {
        HashMap hashMap = new HashMap();
        cache_ExtendInfo = hashMap;
        hashMap.put("", "");
    }

    public CustomTrackAction() {
        this.ID = "";
        this.Type = 0;
        this.Name = "";
        this.is_block = 0;
        this.Url = "";
        this.Button = "";
        this.ExtendInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ID = jceInputStream.readString(0, false);
        this.Type = jceInputStream.read(this.Type, 1, false);
        this.Name = jceInputStream.readString(2, false);
        this.is_block = jceInputStream.read(this.is_block, 3, false);
        this.Url = jceInputStream.readString(4, false);
        this.Button = jceInputStream.readString(5, false);
        this.ExtendInfo = (Map) jceInputStream.read((JceInputStream) cache_ExtendInfo, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.Type, 1);
        String str2 = this.Name;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.is_block, 3);
        String str3 = this.Url;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.Button;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        Map<String, String> map = this.ExtendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 6);
        }
    }

    public CustomTrackAction(String str, int i3, String str2, int i16, String str3, String str4, Map<String, String> map) {
        this.ID = str;
        this.Type = i3;
        this.Name = str2;
        this.is_block = i16;
        this.Url = str3;
        this.Button = str4;
        this.ExtendInfo = map;
    }
}
