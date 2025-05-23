package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Switch extends JceStruct {
    static int cache_type;
    public byte is_open;
    public int type;

    public Switch() {
        this.type = 0;
        this.is_open = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, true);
        this.is_open = jceInputStream.read(this.is_open, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.is_open, 1);
    }

    public Switch(int i3, byte b16) {
        this.type = i3;
        this.is_open = b16;
    }
}
