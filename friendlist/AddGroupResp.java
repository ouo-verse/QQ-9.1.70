package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AddGroupResp extends JceStruct {
    public byte cGroupId;
    public byte cSortId;
    public long dwSequence;
    public long dwToUin;

    public AddGroupResp() {
        this.dwToUin = 0L;
        this.dwSequence = 0L;
        this.cGroupId = (byte) 0;
        this.cSortId = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwToUin = jceInputStream.read(this.dwToUin, 0, true);
        this.dwSequence = jceInputStream.read(this.dwSequence, 1, true);
        this.cGroupId = jceInputStream.read(this.cGroupId, 2, true);
        this.cSortId = jceInputStream.read(this.cSortId, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwToUin, 0);
        jceOutputStream.write(this.dwSequence, 1);
        jceOutputStream.write(this.cGroupId, 2);
        jceOutputStream.write(this.cSortId, 3);
    }

    public AddGroupResp(long j3, long j16, byte b16, byte b17) {
        this.dwToUin = j3;
        this.dwSequence = j16;
        this.cGroupId = b16;
        this.cSortId = b17;
    }
}
