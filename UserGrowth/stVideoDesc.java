package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stVideoDesc extends JceStruct {
    public boolean isOpVideo;

    public stVideoDesc() {
        this.isOpVideo = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isOpVideo = jceInputStream.read(this.isOpVideo, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isOpVideo, 0);
    }

    public stVideoDesc(boolean z16) {
        this.isOpVideo = z16;
    }
}
