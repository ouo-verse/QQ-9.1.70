package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CKV_LikeInfo extends JceStruct {
    public long iTotal;

    public CKV_LikeInfo() {
        this.iTotal = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iTotal = jceInputStream.read(this.iTotal, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iTotal, 0);
    }

    public CKV_LikeInfo(long j3) {
        this.iTotal = j3;
    }
}
