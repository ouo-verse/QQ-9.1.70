package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupInfo extends JceStruct implements Cloneable {
    public long lGroupCode = 0;
    public long lGroupSeq = 0;
    public long lMemberSeq = 0;
    public long lMask = 0;
    public long lRedPackTime = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 0, true);
        this.lGroupSeq = jceInputStream.read(this.lGroupSeq, 1, true);
        this.lMemberSeq = jceInputStream.read(this.lMemberSeq, 2, true);
        this.lMask = jceInputStream.read(this.lMask, 3, false);
        this.lRedPackTime = jceInputStream.read(this.lRedPackTime, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lGroupCode, 0);
        jceOutputStream.write(this.lGroupSeq, 1);
        jceOutputStream.write(this.lMemberSeq, 2);
        jceOutputStream.write(this.lMask, 3);
        jceOutputStream.write(this.lRedPackTime, 4);
    }
}
