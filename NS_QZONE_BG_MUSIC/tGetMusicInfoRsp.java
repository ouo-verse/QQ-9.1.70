package NS_QZONE_BG_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class tGetMusicInfoRsp extends JceStruct {
    static Map<String, MusicInfo> cache_mapMusic = new HashMap();
    public Map<String, MusicInfo> mapMusic;

    static {
        cache_mapMusic.put("", new MusicInfo());
    }

    public tGetMusicInfoRsp() {
        this.mapMusic = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapMusic = (Map) jceInputStream.read((JceInputStream) cache_mapMusic, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<String, MusicInfo> map = this.mapMusic;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
    }

    public tGetMusicInfoRsp(Map<String, MusicInfo> map) {
        this.mapMusic = map;
    }
}
