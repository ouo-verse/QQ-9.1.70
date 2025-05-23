package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class combine_diamond_info extends JceStruct {
    public int iShowType;
    public int iVipLevel;
    public byte isAnnualVip;
    public byte isAnnualVipEver;

    public combine_diamond_info() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iShowType = jceInputStream.read(this.iShowType, 0, false);
        this.iVipLevel = jceInputStream.read(this.iVipLevel, 1, false);
        this.isAnnualVip = jceInputStream.read(this.isAnnualVip, 2, false);
        this.isAnnualVipEver = jceInputStream.read(this.isAnnualVipEver, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iShowType, 0);
        jceOutputStream.write(this.iVipLevel, 1);
        jceOutputStream.write(this.isAnnualVip, 2);
        jceOutputStream.write(this.isAnnualVipEver, 3);
    }

    public combine_diamond_info(int i3, int i16, byte b16, byte b17) {
        this.iShowType = i3;
        this.iVipLevel = i16;
        this.isAnnualVip = b16;
        this.isAnnualVipEver = b17;
    }
}
