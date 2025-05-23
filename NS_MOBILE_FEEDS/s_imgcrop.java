package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_imgcrop extends JceStruct {
    public long centerx_scale;
    public long centery_scale;

    public s_imgcrop() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.centerx_scale = jceInputStream.read(this.centerx_scale, 0, false);
        this.centery_scale = jceInputStream.read(this.centery_scale, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.centerx_scale, 0);
        jceOutputStream.write(this.centery_scale, 1);
    }

    public s_imgcrop(long j3, long j16) {
        this.centerx_scale = j3;
        this.centery_scale = j16;
    }
}
