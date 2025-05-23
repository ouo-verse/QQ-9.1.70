package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VideoSpec extends JceStruct {
    public long uiDuration;
    public long uiHeight;
    public long uiSize;
    public long uiWidth;

    public VideoSpec() {
        this.uiWidth = 0L;
        this.uiHeight = 0L;
        this.uiDuration = 0L;
        this.uiSize = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uiWidth = jceInputStream.read(this.uiWidth, 0, false);
        this.uiHeight = jceInputStream.read(this.uiHeight, 1, false);
        this.uiDuration = jceInputStream.read(this.uiDuration, 2, false);
        this.uiSize = jceInputStream.read(this.uiSize, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uiWidth, 0);
        jceOutputStream.write(this.uiHeight, 1);
        jceOutputStream.write(this.uiDuration, 2);
        jceOutputStream.write(this.uiSize, 3);
    }

    public VideoSpec(long j3, long j16, long j17, long j18) {
        this.uiWidth = j3;
        this.uiHeight = j16;
        this.uiDuration = j17;
        this.uiSize = j18;
    }
}
