package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class yellow_info extends JceStruct {
    public int iYellowLevel;
    public int iYellowType;
    public byte isAnnualVip;

    public yellow_info() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iYellowType = jceInputStream.read(this.iYellowType, 0, false);
        this.iYellowLevel = jceInputStream.read(this.iYellowLevel, 1, false);
        this.isAnnualVip = jceInputStream.read(this.isAnnualVip, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iYellowType, 0);
        jceOutputStream.write(this.iYellowLevel, 1);
        jceOutputStream.write(this.isAnnualVip, 2);
    }

    public yellow_info(int i3, int i16, byte b16) {
        this.iYellowType = i3;
        this.iYellowLevel = i16;
        this.isAnnualVip = b16;
    }
}
