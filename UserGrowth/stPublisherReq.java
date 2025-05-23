package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPublisherReq extends JceStruct {
    public int nothing;

    public stPublisherReq() {
        this.nothing = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nothing = jceInputStream.read(this.nothing, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nothing, 0);
    }

    public stPublisherReq(int i3) {
        this.nothing = i3;
    }
}
