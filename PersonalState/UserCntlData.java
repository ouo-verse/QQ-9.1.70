package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserCntlData extends JceStruct {
    public long lLastPos;
    public int nVersion;

    public UserCntlData() {
        this.nVersion = 0;
        this.lLastPos = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.nVersion = jceInputStream.read(this.nVersion, 0, false);
        this.lLastPos = jceInputStream.read(this.lLastPos, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.nVersion, 0);
        jceOutputStream.write(this.lLastPos, 1);
    }

    public UserCntlData(int i3, long j3) {
        this.nVersion = i3;
        this.lLastPos = j3;
    }
}
