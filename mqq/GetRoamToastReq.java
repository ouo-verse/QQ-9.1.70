package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetRoamToastReq extends JceStruct {
    public String sKey;
    public long uUin;

    public GetRoamToastReq() {
        this.uUin = 0L;
        this.sKey = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uUin = jceInputStream.read(this.uUin, 0, true);
        this.sKey = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uUin, 0);
        jceOutputStream.write(this.sKey, 1);
    }

    public GetRoamToastReq(long j3, String str) {
        this.uUin = j3;
        this.sKey = str;
    }
}
