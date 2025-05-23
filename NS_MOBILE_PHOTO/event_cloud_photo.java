package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picurl;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class event_cloud_photo extends JceStruct {
    static Map<Integer, s_picurl> cache_specUrls = new HashMap();
    public String albumid;
    public String lloc;
    public long owner;
    public Map<Integer, s_picurl> specUrls;
    public int type;
    public long uploadTime;

    static {
        cache_specUrls.put(0, new s_picurl());
    }

    public event_cloud_photo() {
        this.owner = 0L;
        this.albumid = "";
        this.lloc = "";
        this.uploadTime = 0L;
        this.type = 0;
        this.specUrls = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.owner = jceInputStream.read(this.owner, 0, true);
        this.albumid = jceInputStream.readString(1, true);
        this.lloc = jceInputStream.readString(2, true);
        this.uploadTime = jceInputStream.read(this.uploadTime, 5, true);
        this.type = jceInputStream.read(this.type, 10, false);
        this.specUrls = (Map) jceInputStream.read((JceInputStream) cache_specUrls, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.owner, 0);
        jceOutputStream.write(this.albumid, 1);
        jceOutputStream.write(this.lloc, 2);
        jceOutputStream.write(this.uploadTime, 5);
        jceOutputStream.write(this.type, 10);
        Map<Integer, s_picurl> map = this.specUrls;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
    }

    public event_cloud_photo(long j3, String str, String str2, long j16, int i3, Map<Integer, s_picurl> map) {
        this.owner = j3;
        this.albumid = str;
        this.lloc = str2;
        this.uploadTime = j16;
        this.type = i3;
        this.specUrls = map;
    }
}
