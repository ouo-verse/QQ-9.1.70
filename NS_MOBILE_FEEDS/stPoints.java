package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPoints extends JceStruct {

    /* renamed from: x, reason: collision with root package name */
    public int f24997x;

    /* renamed from: y, reason: collision with root package name */
    public int f24998y;

    public stPoints() {
        this.f24997x = 0;
        this.f24998y = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24997x = jceInputStream.read(this.f24997x, 0, false);
        this.f24998y = jceInputStream.read(this.f24998y, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f24997x, 0);
        jceOutputStream.write(this.f24998y, 1);
    }

    public stPoints(int i3, int i16) {
        this.f24997x = i3;
        this.f24998y = i16;
    }
}
