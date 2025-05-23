package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class stFavoriteGroup extends JceStruct {
    public long dwGroupCode;
    public long dwOpenTimestamp;
    public long dwSnsFlag;
    public long dwTimestamp;

    public stFavoriteGroup() {
        this.dwGroupCode = 0L;
        this.dwTimestamp = 0L;
        this.dwSnsFlag = 1L;
        this.dwOpenTimestamp = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwGroupCode = jceInputStream.read(this.dwGroupCode, 0, true);
        this.dwTimestamp = jceInputStream.read(this.dwTimestamp, 1, false);
        this.dwSnsFlag = jceInputStream.read(this.dwSnsFlag, 2, false);
        this.dwOpenTimestamp = jceInputStream.read(this.dwOpenTimestamp, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwGroupCode, 0);
        jceOutputStream.write(this.dwTimestamp, 1);
        jceOutputStream.write(this.dwSnsFlag, 2);
        jceOutputStream.write(this.dwOpenTimestamp, 3);
    }

    public stFavoriteGroup(long j3, long j16, long j17, long j18) {
        this.dwGroupCode = j3;
        this.dwTimestamp = j16;
        this.dwSnsFlag = j17;
        this.dwOpenTimestamp = j18;
    }
}
