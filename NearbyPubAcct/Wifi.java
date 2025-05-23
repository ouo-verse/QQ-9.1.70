package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Wifi extends JceStruct {
    public long lMac;
    public short shRssi;

    public Wifi() {
        this.lMac = -1L;
        this.shRssi = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lMac = jceInputStream.read(this.lMac, 0, true);
        this.shRssi = jceInputStream.read(this.shRssi, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lMac, 0);
        jceOutputStream.write(this.shRssi, 1);
    }

    public Wifi(long j3, short s16) {
        this.lMac = j3;
        this.shRssi = s16;
    }
}
