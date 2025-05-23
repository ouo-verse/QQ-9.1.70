package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VipOpenInfo extends JceStruct {
    public boolean bOpen;
    public int iVipFlag;
    public int iVipLevel;
    public int iVipType;
    public long lNameplateId;

    public VipOpenInfo() {
        this.bOpen = false;
        this.iVipType = -1;
        this.iVipLevel = -1;
        this.iVipFlag = 0;
        this.lNameplateId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.bOpen = jceInputStream.read(this.bOpen, 0, true);
        this.iVipType = jceInputStream.read(this.iVipType, 1, true);
        this.iVipLevel = jceInputStream.read(this.iVipLevel, 2, true);
        this.iVipFlag = jceInputStream.read(this.iVipFlag, 3, false);
        this.lNameplateId = jceInputStream.read(this.lNameplateId, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.bOpen, 0);
        jceOutputStream.write(this.iVipType, 1);
        jceOutputStream.write(this.iVipLevel, 2);
        jceOutputStream.write(this.iVipFlag, 3);
        jceOutputStream.write(this.lNameplateId, 4);
    }

    public VipOpenInfo(boolean z16, int i3, int i16, int i17, long j3) {
        this.bOpen = z16;
        this.iVipType = i3;
        this.iVipLevel = i16;
        this.iVipFlag = i17;
        this.lNameplateId = j3;
    }
}
