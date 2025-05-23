package NeighborComm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EctFragmentation extends JceStruct {
    public int iSelfIndex;
    public int iTotalNum;

    public EctFragmentation() {
        this.iTotalNum = 0;
        this.iSelfIndex = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTotalNum = jceInputStream.read(this.iTotalNum, 0, true);
        this.iSelfIndex = jceInputStream.read(this.iSelfIndex, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTotalNum, 0);
        jceOutputStream.write(this.iSelfIndex, 1);
    }

    public EctFragmentation(int i3, int i16) {
        this.iTotalNum = i3;
        this.iSelfIndex = i16;
    }
}
