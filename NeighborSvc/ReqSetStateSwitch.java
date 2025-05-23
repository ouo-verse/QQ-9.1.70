package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSetStateSwitch extends JceStruct {
    static ReqHeader cache_stHeader;
    public byte bIsOpen;
    public ReqHeader stHeader;

    public ReqSetStateSwitch() {
        this.stHeader = null;
        this.bIsOpen = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHeader();
        }
        this.stHeader = (ReqHeader) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.bIsOpen = jceInputStream.read(this.bIsOpen, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.bIsOpen, 1);
    }

    public ReqSetStateSwitch(ReqHeader reqHeader, byte b16) {
        this.stHeader = reqHeader;
        this.bIsOpen = b16;
    }
}
