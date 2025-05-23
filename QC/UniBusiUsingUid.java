package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiUsingUid extends JceStruct {
    public int locationtype;
    public long uid;

    public UniBusiUsingUid() {
        this.uid = 0L;
        this.locationtype = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uid = jceInputStream.read(this.uid, 0, false);
        this.locationtype = jceInputStream.read(this.locationtype, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uid, 0);
        jceOutputStream.write(this.locationtype, 1);
    }

    public UniBusiUsingUid(long j3, int i3) {
        this.uid = j3;
        this.locationtype = i3;
    }
}
