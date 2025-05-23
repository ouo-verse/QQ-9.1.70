package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GroupSort extends JceStruct {
    public long dwGroupID;
    public long dwSortID;

    public GroupSort() {
        this.dwGroupID = 0L;
        this.dwSortID = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwGroupID = jceInputStream.read(this.dwGroupID, 0, false);
        this.dwSortID = jceInputStream.read(this.dwSortID, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwGroupID, 0);
        jceOutputStream.write(this.dwSortID, 1);
    }

    public GroupSort(long j3, long j16) {
        this.dwGroupID = j3;
        this.dwSortID = j16;
    }
}
