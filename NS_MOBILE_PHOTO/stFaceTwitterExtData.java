package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFaceTwitterExtData extends JceStruct {
    public long owneruin;
    public String tid;

    public stFaceTwitterExtData() {
        this.tid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.tid = jceInputStream.readString(0, true);
        this.owneruin = jceInputStream.read(this.owneruin, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.tid, 0);
        jceOutputStream.write(this.owneruin, 1);
    }

    public stFaceTwitterExtData(String str, long j3) {
        this.tid = str;
        this.owneruin = j3;
    }
}
