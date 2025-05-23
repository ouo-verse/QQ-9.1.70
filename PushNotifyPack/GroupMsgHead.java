package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupMsgHead extends JceStruct {
    public byte cCurPkg;
    public byte cTotalPkg;
    public long dwReserved;
    public int usCmdType;
    public int usPkgSeq;

    public GroupMsgHead() {
        this.usCmdType = 0;
        this.cTotalPkg = (byte) 0;
        this.cCurPkg = (byte) 0;
        this.usPkgSeq = 0;
        this.dwReserved = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.usCmdType = jceInputStream.read(this.usCmdType, 0, true);
        this.cTotalPkg = jceInputStream.read(this.cTotalPkg, 1, true);
        this.cCurPkg = jceInputStream.read(this.cCurPkg, 2, true);
        this.usPkgSeq = jceInputStream.read(this.usPkgSeq, 3, true);
        this.dwReserved = jceInputStream.read(this.dwReserved, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.usCmdType, 0);
        jceOutputStream.write(this.cTotalPkg, 1);
        jceOutputStream.write(this.cCurPkg, 2);
        jceOutputStream.write(this.usPkgSeq, 3);
        jceOutputStream.write(this.dwReserved, 4);
    }

    public GroupMsgHead(int i3, byte b16, byte b17, int i16, long j3) {
        this.usCmdType = i3;
        this.cTotalPkg = b16;
        this.cCurPkg = b17;
        this.usPkgSeq = i16;
        this.dwReserved = j3;
    }
}
