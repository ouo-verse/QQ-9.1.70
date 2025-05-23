package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PhotoWall extends JceStruct {
    static Map<Integer, String> cache_photoUrls;
    public long ctime;
    public String photoId;
    public Map<Integer, String> photoUrls;

    public PhotoWall() {
        this.photoId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photoId = jceInputStream.readString(0, true);
        this.ctime = jceInputStream.read(this.ctime, 1, false);
        if (cache_photoUrls == null) {
            cache_photoUrls = new HashMap();
            cache_photoUrls.put(0, "");
        }
        this.photoUrls = (Map) jceInputStream.read((JceInputStream) cache_photoUrls, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.photoId, 0);
        jceOutputStream.write(this.ctime, 1);
        Map<Integer, String> map = this.photoUrls;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public PhotoWall(String str, long j3, Map<Integer, String> map) {
        this.photoId = str;
        this.ctime = j3;
        this.photoUrls = map;
    }
}
