package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFeedIconOpConf extends JceStruct {
    public int duringTime;
    public int first;
    public int second;
    public int startTime;
    public int third;

    public stFeedIconOpConf() {
        this.startTime = 0;
        this.duringTime = 0;
        this.first = 0;
        this.second = 0;
        this.third = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.startTime = jceInputStream.read(this.startTime, 0, false);
        this.duringTime = jceInputStream.read(this.duringTime, 1, false);
        this.first = jceInputStream.read(this.first, 2, false);
        this.second = jceInputStream.read(this.second, 3, false);
        this.third = jceInputStream.read(this.third, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.startTime, 0);
        jceOutputStream.write(this.duringTime, 1);
        jceOutputStream.write(this.first, 2);
        jceOutputStream.write(this.second, 3);
        jceOutputStream.write(this.third, 4);
    }

    public stFeedIconOpConf(int i3, int i16, int i17, int i18, int i19) {
        this.startTime = i3;
        this.duringTime = i16;
        this.first = i17;
        this.second = i18;
        this.third = i19;
    }
}
