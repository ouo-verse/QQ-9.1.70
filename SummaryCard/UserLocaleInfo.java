package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserLocaleInfo extends JceStruct {
    public long lLatitude;
    public long lLongitude;

    public UserLocaleInfo() {
        this.lLongitude = 0L;
        this.lLatitude = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lLongitude = jceInputStream.read(this.lLongitude, 1, false);
        this.lLatitude = jceInputStream.read(this.lLatitude, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lLongitude, 1);
        jceOutputStream.write(this.lLatitude, 2);
    }

    public UserLocaleInfo(long j3, long j16) {
        this.lLongitude = j3;
        this.lLatitude = j16;
    }
}
