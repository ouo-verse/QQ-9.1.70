package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VAResourcesReq extends JceStruct {
    public long lastVisitTime;
    public int resourcesFlag;
    public String sUin;

    public VAResourcesReq() {
        this.sUin = "";
        this.lastVisitTime = 0L;
        this.resourcesFlag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sUin = jceInputStream.readString(0, true);
        this.lastVisitTime = jceInputStream.read(this.lastVisitTime, 1, false);
        this.resourcesFlag = jceInputStream.read(this.resourcesFlag, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sUin, 0);
        jceOutputStream.write(this.lastVisitTime, 1);
        jceOutputStream.write(this.resourcesFlag, 2);
    }

    public VAResourcesReq(String str, long j3, int i3) {
        this.sUin = str;
        this.lastVisitTime = j3;
        this.resourcesFlag = i3;
    }
}
