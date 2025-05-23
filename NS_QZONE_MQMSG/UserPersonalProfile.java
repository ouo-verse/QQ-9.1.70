package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class UserPersonalProfile extends JceStruct {
    static byte[] cache_vecBuff;
    public int isAnnualVip;
    public int isLoversVip;
    public byte[] vecBuff;
    public int vip;
    public int vipLevel;

    static {
        cache_vecBuff = r0;
        byte[] bArr = {0};
    }

    public UserPersonalProfile() {
        this.vip = 0;
        this.vipLevel = 0;
        this.isAnnualVip = 0;
        this.isLoversVip = 0;
        this.vecBuff = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vip = jceInputStream.read(this.vip, 0, false);
        this.vipLevel = jceInputStream.read(this.vipLevel, 1, false);
        this.isAnnualVip = jceInputStream.read(this.isAnnualVip, 2, false);
        this.isLoversVip = jceInputStream.read(this.isLoversVip, 3, false);
        this.vecBuff = jceInputStream.read(cache_vecBuff, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vip, 0);
        jceOutputStream.write(this.vipLevel, 1);
        jceOutputStream.write(this.isAnnualVip, 2);
        jceOutputStream.write(this.isLoversVip, 3);
        byte[] bArr = this.vecBuff;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
    }

    public UserPersonalProfile(int i3, int i16, int i17, int i18, byte[] bArr) {
        this.vip = i3;
        this.vipLevel = i16;
        this.isAnnualVip = i17;
        this.isLoversVip = i18;
        this.vecBuff = bArr;
    }
}
