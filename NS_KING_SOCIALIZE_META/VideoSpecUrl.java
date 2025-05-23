package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoSpecUrl extends JceStruct {
    static Map<String, String> cache_externInfo;
    static stMetaUgcImage cache_staticCover;
    public String url = "";
    public long size = 0;
    public int hardorsoft = 0;
    public int recommendSpec = 0;
    public int haveWatermark = 0;
    public int width = 0;
    public int height = 0;
    public int videoCoding = 0;
    public int videoQuality = 0;
    public Map<String, String> externInfo = null;
    public stMetaUgcImage staticCover = null;
    public double fps = 0.0d;

    static {
        HashMap hashMap = new HashMap();
        cache_externInfo = hashMap;
        hashMap.put("", "");
        cache_staticCover = new stMetaUgcImage();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, false);
        this.size = jceInputStream.read(this.size, 1, false);
        this.hardorsoft = jceInputStream.read(this.hardorsoft, 2, false);
        this.recommendSpec = jceInputStream.read(this.recommendSpec, 3, false);
        this.haveWatermark = jceInputStream.read(this.haveWatermark, 4, false);
        this.width = jceInputStream.read(this.width, 5, false);
        this.height = jceInputStream.read(this.height, 6, false);
        this.videoCoding = jceInputStream.read(this.videoCoding, 7, false);
        this.videoQuality = jceInputStream.read(this.videoQuality, 8, false);
        this.externInfo = (Map) jceInputStream.read((JceInputStream) cache_externInfo, 9, false);
        this.staticCover = (stMetaUgcImage) jceInputStream.read((JceStruct) cache_staticCover, 10, false);
        this.fps = jceInputStream.read(this.fps, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.size, 1);
        jceOutputStream.write(this.hardorsoft, 2);
        jceOutputStream.write(this.recommendSpec, 3);
        jceOutputStream.write(this.haveWatermark, 4);
        jceOutputStream.write(this.width, 5);
        jceOutputStream.write(this.height, 6);
        jceOutputStream.write(this.videoCoding, 7);
        jceOutputStream.write(this.videoQuality, 8);
        Map<String, String> map = this.externInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
        stMetaUgcImage stmetaugcimage = this.staticCover;
        if (stmetaugcimage != null) {
            jceOutputStream.write((JceStruct) stmetaugcimage, 10);
        }
        jceOutputStream.write(this.fps, 11);
    }
}
