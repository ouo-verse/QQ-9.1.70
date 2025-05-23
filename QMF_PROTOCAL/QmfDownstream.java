package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QmfDownstream extends JceStruct {
    static byte[] cache_BusiBuff;
    static byte[] cache_Extra;
    public short BizCode;
    public byte[] BusiBuff;
    public byte[] Extra;
    public int Seq;
    public String ServiceCmd;
    public long Uin;
    public short WnsCode;

    public QmfDownstream() {
        this.ServiceCmd = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Seq = jceInputStream.read(this.Seq, 0, true);
        this.Uin = jceInputStream.read(this.Uin, 1, true);
        this.WnsCode = jceInputStream.read(this.WnsCode, 2, true);
        this.BizCode = jceInputStream.read(this.BizCode, 3, true);
        this.ServiceCmd = jceInputStream.readString(4, true);
        if (cache_BusiBuff == null) {
            cache_BusiBuff = r0;
            byte[] bArr = {0};
        }
        this.BusiBuff = jceInputStream.read(cache_BusiBuff, 5, true);
        if (cache_Extra == null) {
            cache_Extra = r0;
            byte[] bArr2 = {0};
        }
        this.Extra = jceInputStream.read(cache_Extra, 6, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Seq, 0);
        jceOutputStream.write(this.Uin, 1);
        jceOutputStream.write(this.WnsCode, 2);
        jceOutputStream.write(this.BizCode, 3);
        jceOutputStream.write(this.ServiceCmd, 4);
        jceOutputStream.write(this.BusiBuff, 5);
        jceOutputStream.write(this.Extra, 6);
    }

    public QmfDownstream(int i3, long j3, short s16, short s17, String str, byte[] bArr, byte[] bArr2) {
        this.Seq = i3;
        this.Uin = j3;
        this.WnsCode = s16;
        this.BizCode = s17;
        this.ServiceCmd = str;
        this.BusiBuff = bArr;
        this.Extra = bArr2;
    }
}
