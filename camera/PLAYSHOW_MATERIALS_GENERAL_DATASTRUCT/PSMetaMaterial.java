package camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PSMetaMaterial extends JceStruct {
    static Map<String, String> cache_additionalFields;
    public Map<String, String> additionalFields;

    /* renamed from: id, reason: collision with root package name */
    public String f30531id;
    public String name;
    public String packageMd5;
    public String packageUrl;
    public String thumbMd5;
    public String thumbUrl;
    public int type;
    public int updateTime;

    static {
        HashMap hashMap = new HashMap();
        cache_additionalFields = hashMap;
        hashMap.put("", "");
    }

    public PSMetaMaterial() {
        this.f30531id = "";
        this.name = "";
        this.type = 0;
        this.thumbUrl = "";
        this.thumbMd5 = "";
        this.packageUrl = "";
        this.packageMd5 = "";
        this.additionalFields = null;
        this.updateTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f30531id = jceInputStream.readString(0, false);
        this.name = jceInputStream.readString(1, false);
        this.type = jceInputStream.read(this.type, 2, false);
        this.thumbUrl = jceInputStream.readString(3, false);
        this.thumbMd5 = jceInputStream.readString(4, false);
        this.packageUrl = jceInputStream.readString(5, false);
        this.packageMd5 = jceInputStream.readString(6, false);
        this.additionalFields = (Map) jceInputStream.read((JceInputStream) cache_additionalFields, 7, false);
        this.updateTime = jceInputStream.read(this.updateTime, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.f30531id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.name;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.type, 2);
        String str3 = this.thumbUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.thumbMd5;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.packageUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.packageMd5;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        Map<String, String> map = this.additionalFields;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
        jceOutputStream.write(this.updateTime, 8);
    }

    public PSMetaMaterial(String str, String str2, int i3, String str3, String str4, String str5, String str6, Map<String, String> map, int i16) {
        this.f30531id = str;
        this.name = str2;
        this.type = i3;
        this.thumbUrl = str3;
        this.thumbMd5 = str4;
        this.packageUrl = str5;
        this.packageMd5 = str6;
        this.additionalFields = map;
        this.updateTime = i16;
    }
}
