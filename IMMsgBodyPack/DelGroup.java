package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DelGroup extends JceStruct {
    public long dwGroupID;

    public DelGroup() {
        this.dwGroupID = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwGroupID = jceInputStream.read(this.dwGroupID, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwGroupID, 0);
    }

    public DelGroup(long j3) {
        this.dwGroupID = j3;
    }
}
