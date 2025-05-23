package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoBanner extends JceStruct {
    static ArrayList<OneVideoInfo> cache_videos = new ArrayList<>();
    public String nick;
    public long uUin;
    public ArrayList<OneVideoInfo> videos;

    static {
        cache_videos.add(new OneVideoInfo());
    }

    public VideoBanner() {
        this.uUin = 0L;
        this.videos = null;
        this.nick = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uUin = jceInputStream.read(this.uUin, 0, false);
        this.videos = (ArrayList) jceInputStream.read((JceInputStream) cache_videos, 1, false);
        this.nick = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uUin, 0);
        ArrayList<OneVideoInfo> arrayList = this.videos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public VideoBanner(long j3, ArrayList<OneVideoInfo> arrayList, String str) {
        this.uUin = j3;
        this.videos = arrayList;
        this.nick = str;
    }
}
