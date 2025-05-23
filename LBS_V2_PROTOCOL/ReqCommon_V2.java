package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqCommon_V2 extends JceStruct {
    public int iAppId;
    public int iDeviceType;

    public ReqCommon_V2() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppId = jceInputStream.read(this.iAppId, 0, true);
        this.iDeviceType = jceInputStream.read(this.iDeviceType, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppId, 0);
        jceOutputStream.write(this.iDeviceType, 1);
    }

    public ReqCommon_V2(int i3, int i16) {
        this.iAppId = i3;
        this.iDeviceType = i16;
    }
}
