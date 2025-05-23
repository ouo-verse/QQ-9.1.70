package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNewsRedDot extends JceStruct {
    public int newsCount;

    public stNewsRedDot() {
        this.newsCount = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.newsCount = jceInputStream.read(this.newsCount, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.newsCount, 0);
    }

    public stNewsRedDot(int i3) {
        this.newsCount = i3;
    }
}
