package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShootInfo extends JceStruct {
    static LbsInfo cache_shootLbs;
    public LbsInfo shootLbs;
    public long shootTime;

    public ShootInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_shootLbs == null) {
            cache_shootLbs = new LbsInfo();
        }
        this.shootLbs = (LbsInfo) jceInputStream.read((JceStruct) cache_shootLbs, 0, false);
        this.shootTime = jceInputStream.read(this.shootTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LbsInfo lbsInfo = this.shootLbs;
        if (lbsInfo != null) {
            jceOutputStream.write((JceStruct) lbsInfo, 0);
        }
        jceOutputStream.write(this.shootTime, 1);
    }

    public ShootInfo(LbsInfo lbsInfo, long j3) {
        this.shootLbs = lbsInfo;
        this.shootTime = j3;
    }
}
