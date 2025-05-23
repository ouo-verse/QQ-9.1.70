package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAlbumCommShareKeyReq extends JceStruct {
    static Map<String, String> cache_ins;
    static int cache_scene;
    public Map<String, String> ins;
    public int scene;
    public long uin;

    static {
        HashMap hashMap = new HashMap();
        cache_ins = hashMap;
        hashMap.put("", "");
    }

    public GetAlbumCommShareKeyReq() {
        this.uin = 0L;
        this.scene = 0;
        this.ins = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.scene = jceInputStream.read(this.scene, 1, false);
        this.ins = (Map) jceInputStream.read((JceInputStream) cache_ins, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.scene, 1);
        Map<String, String> map = this.ins;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
    }

    public GetAlbumCommShareKeyReq(long j3, int i3, Map<String, String> map) {
        this.uin = j3;
        this.scene = i3;
        this.ins = map;
    }
}
