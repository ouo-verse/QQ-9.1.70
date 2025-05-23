package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RenameGroupResp extends JceStruct {
    public byte cLen;
    public long dwSequence;
    public long dwToUin;
    public String sGroupName;

    public RenameGroupResp() {
        this.dwToUin = 0L;
        this.dwSequence = 0L;
        this.cLen = (byte) 0;
        this.sGroupName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwToUin = jceInputStream.read(this.dwToUin, 0, true);
        this.dwSequence = jceInputStream.read(this.dwSequence, 1, true);
        this.cLen = jceInputStream.read(this.cLen, 2, true);
        this.sGroupName = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwToUin, 0);
        jceOutputStream.write(this.dwSequence, 1);
        jceOutputStream.write(this.cLen, 2);
        jceOutputStream.write(this.sGroupName, 3);
    }

    public RenameGroupResp(long j3, long j16, byte b16, String str) {
        this.dwToUin = j3;
        this.dwSequence = j16;
        this.cLen = b16;
        this.sGroupName = str;
    }
}
