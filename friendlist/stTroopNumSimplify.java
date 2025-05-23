package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class stTroopNumSimplify extends JceStruct {
    public long GroupCode;
    public long dwGroupFlagExt;
    public long dwGroupInfoExtSeq;
    public long dwGroupInfoSeq;
    public long dwGroupRankSeq;

    public stTroopNumSimplify() {
        this.GroupCode = 0L;
        this.dwGroupInfoSeq = 0L;
        this.dwGroupFlagExt = 0L;
        this.dwGroupRankSeq = 0L;
        this.dwGroupInfoExtSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.GroupCode = jceInputStream.read(this.GroupCode, 0, true);
        this.dwGroupInfoSeq = jceInputStream.read(this.dwGroupInfoSeq, 1, false);
        this.dwGroupFlagExt = jceInputStream.read(this.dwGroupFlagExt, 2, false);
        this.dwGroupRankSeq = jceInputStream.read(this.dwGroupRankSeq, 3, false);
        this.dwGroupInfoExtSeq = jceInputStream.read(this.dwGroupInfoExtSeq, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.GroupCode, 0);
        jceOutputStream.write(this.dwGroupInfoSeq, 1);
        jceOutputStream.write(this.dwGroupFlagExt, 2);
        jceOutputStream.write(this.dwGroupRankSeq, 3);
        jceOutputStream.write(this.dwGroupInfoExtSeq, 4);
    }

    public stTroopNumSimplify(long j3, long j16, long j17, long j18, long j19) {
        this.GroupCode = j3;
        this.dwGroupInfoSeq = j16;
        this.dwGroupFlagExt = j17;
        this.dwGroupRankSeq = j18;
        this.dwGroupInfoExtSeq = j19;
    }
}
