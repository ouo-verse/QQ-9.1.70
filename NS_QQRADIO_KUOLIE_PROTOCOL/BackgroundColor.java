package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BackgroundColor extends JceStruct {
    public int beginVal;
    public int endVal;

    public BackgroundColor() {
        this.beginVal = 0;
        this.endVal = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.beginVal = jceInputStream.read(this.beginVal, 0, false);
        this.endVal = jceInputStream.read(this.endVal, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.beginVal, 0);
        jceOutputStream.write(this.endVal, 1);
    }

    public BackgroundColor(int i3, int i16) {
        this.beginVal = i3;
        this.endVal = i16;
    }
}
