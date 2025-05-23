package acs;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqGetCooperateCms extends JceStruct {
    public int cmsType;
    public long preTime;

    public ReqGetCooperateCms() {
        this.cmsType = 0;
        this.preTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cmsType = jceInputStream.read(this.cmsType, 0, true);
        this.preTime = jceInputStream.read(this.preTime, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cmsType, 0);
        jceOutputStream.write(this.preTime, 1);
    }

    public ReqGetCooperateCms(int i3, long j3) {
        this.cmsType = i3;
        this.preTime = j3;
    }
}
