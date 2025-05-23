package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VAResourcesRsp extends JceStruct {
    static LhLogoInfo cache_lhLogoInfo = new LhLogoInfo();
    public int iSyncFreq;
    public LhLogoInfo lhLogoInfo;

    public VAResourcesRsp() {
        this.iSyncFreq = -1;
        this.lhLogoInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iSyncFreq = jceInputStream.read(this.iSyncFreq, 0, false);
        this.lhLogoInfo = (LhLogoInfo) jceInputStream.read((JceStruct) cache_lhLogoInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iSyncFreq, 0);
        LhLogoInfo lhLogoInfo = this.lhLogoInfo;
        if (lhLogoInfo != null) {
            jceOutputStream.write((JceStruct) lhLogoInfo, 1);
        }
    }

    public VAResourcesRsp(int i3, LhLogoInfo lhLogoInfo) {
        this.iSyncFreq = i3;
        this.lhLogoInfo = lhLogoInfo;
    }
}
