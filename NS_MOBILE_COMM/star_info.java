package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class star_info extends JceStruct {
    public int iStarLevel;
    public int iStarStatus;
    public byte isAnnualVip;
    public byte isHighStarVip;

    public star_info() {
        this.iStarStatus = 0;
        this.iStarLevel = 0;
        this.isAnnualVip = (byte) 0;
        this.isHighStarVip = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iStarStatus = jceInputStream.read(this.iStarStatus, 0, false);
        this.iStarLevel = jceInputStream.read(this.iStarLevel, 1, false);
        this.isAnnualVip = jceInputStream.read(this.isAnnualVip, 2, false);
        this.isHighStarVip = jceInputStream.read(this.isHighStarVip, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iStarStatus, 0);
        jceOutputStream.write(this.iStarLevel, 1);
        jceOutputStream.write(this.isAnnualVip, 2);
        jceOutputStream.write(this.isHighStarVip, 3);
    }

    public star_info(int i3, int i16, byte b16, byte b17) {
        this.iStarStatus = i3;
        this.iStarLevel = i16;
        this.isAnnualVip = b16;
        this.isHighStarVip = b17;
    }
}
