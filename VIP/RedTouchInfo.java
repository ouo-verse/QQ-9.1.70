package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RedTouchInfo extends JceStruct {
    public boolean hasRed;

    public RedTouchInfo() {
        this.hasRed = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasRed = jceInputStream.read(this.hasRed, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasRed, 0);
    }

    public RedTouchInfo(boolean z16) {
        this.hasRed = z16;
    }
}
