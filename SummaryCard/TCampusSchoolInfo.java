package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TCampusSchoolInfo extends JceStruct {
    public int iIsValidForCertified;
    public long uSchoolId;
    public long uTimestamp;

    public TCampusSchoolInfo() {
        this.uTimestamp = 0L;
        this.uSchoolId = 0L;
        this.iIsValidForCertified = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uTimestamp = jceInputStream.read(this.uTimestamp, 0, false);
        this.uSchoolId = jceInputStream.read(this.uSchoolId, 1, false);
        this.iIsValidForCertified = jceInputStream.read(this.iIsValidForCertified, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uTimestamp, 0);
        jceOutputStream.write(this.uSchoolId, 1);
        jceOutputStream.write(this.iIsValidForCertified, 2);
    }

    public TCampusSchoolInfo(long j3, long j16, int i3) {
        this.uTimestamp = j3;
        this.uSchoolId = j16;
        this.iIsValidForCertified = i3;
    }
}
