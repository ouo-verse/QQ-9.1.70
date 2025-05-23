package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MovGroupMem extends JceStruct {
    public byte Ver;
    public byte cGroupid;
    public long dwUin;
    public short wReqLen;
    public short wReserveLen;

    public MovGroupMem() {
        this.Ver = (byte) 0;
        this.wReqLen = (short) 0;
        this.dwUin = 0L;
        this.cGroupid = (byte) 0;
        this.wReserveLen = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Ver = jceInputStream.read(this.Ver, 0, true);
        this.wReqLen = jceInputStream.read(this.wReqLen, 1, true);
        this.dwUin = jceInputStream.read(this.dwUin, 2, true);
        this.cGroupid = jceInputStream.read(this.cGroupid, 3, true);
        this.wReserveLen = jceInputStream.read(this.wReserveLen, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Ver, 0);
        jceOutputStream.write(this.wReqLen, 1);
        jceOutputStream.write(this.dwUin, 2);
        jceOutputStream.write(this.cGroupid, 3);
        jceOutputStream.write(this.wReserveLen, 4);
    }

    public MovGroupMem(byte b16, short s16, long j3, byte b17, short s17) {
        this.Ver = b16;
        this.wReqLen = s16;
        this.dwUin = j3;
        this.cGroupid = b17;
        this.wReserveLen = s17;
    }
}
