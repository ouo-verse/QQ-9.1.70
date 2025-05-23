package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class event_photo extends JceStruct {
    static Map<String, String> cache_ext;
    static lbs_info cache_lbs = new lbs_info();
    static byte[] cache_longTag;
    public Map<String, String> ext;
    public lbs_info lbs;
    public byte[] longTag;
    public long modifytime;
    public String picid;
    public long shoottime;
    public long tag;

    static {
        HashMap hashMap = new HashMap();
        cache_ext = hashMap;
        hashMap.put("", "");
        cache_longTag = r0;
        byte[] bArr = {0};
    }

    public event_photo() {
        this.picid = "";
        this.shoottime = 0L;
        this.lbs = null;
        this.tag = 0L;
        this.ext = null;
        this.modifytime = 0L;
        this.longTag = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picid = jceInputStream.readString(0, false);
        this.shoottime = jceInputStream.read(this.shoottime, 1, true);
        this.lbs = (lbs_info) jceInputStream.read((JceStruct) cache_lbs, 2, true);
        this.tag = jceInputStream.read(this.tag, 3, false);
        this.ext = (Map) jceInputStream.read((JceInputStream) cache_ext, 4, false);
        this.modifytime = jceInputStream.read(this.modifytime, 5, false);
        this.longTag = jceInputStream.read(cache_longTag, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.picid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.shoottime, 1);
        jceOutputStream.write((JceStruct) this.lbs, 2);
        jceOutputStream.write(this.tag, 3);
        Map<String, String> map = this.ext;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        jceOutputStream.write(this.modifytime, 5);
        byte[] bArr = this.longTag;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
    }

    public event_photo(String str, long j3, lbs_info lbs_infoVar, long j16, Map<String, String> map, long j17, byte[] bArr) {
        this.picid = str;
        this.shoottime = j3;
        this.lbs = lbs_infoVar;
        this.tag = j16;
        this.ext = map;
        this.modifytime = j17;
        this.longTag = bArr;
    }
}
