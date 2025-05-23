package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomTrackUgcDeco extends JceStruct {
    static UgcCustomTrack cache_stUgcCustomTrack = new UgcCustomTrack();
    public UgcCustomTrack stUgcCustomTrack;

    public CustomTrackUgcDeco() {
        this.stUgcCustomTrack = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stUgcCustomTrack = (UgcCustomTrack) jceInputStream.read((JceStruct) cache_stUgcCustomTrack, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        UgcCustomTrack ugcCustomTrack = this.stUgcCustomTrack;
        if (ugcCustomTrack != null) {
            jceOutputStream.write((JceStruct) ugcCustomTrack, 0);
        }
    }

    public CustomTrackUgcDeco(UgcCustomTrack ugcCustomTrack) {
        this.stUgcCustomTrack = ugcCustomTrack;
    }
}
