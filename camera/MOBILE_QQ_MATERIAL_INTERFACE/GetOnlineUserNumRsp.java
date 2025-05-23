package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetOnlineUserNumRsp extends JceStruct {
    public int Code;
    public int OnlineUserNum;

    public GetOnlineUserNumRsp() {
        this.Code = 0;
        this.OnlineUserNum = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.OnlineUserNum = jceInputStream.read(this.OnlineUserNum, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        jceOutputStream.write(this.OnlineUserNum, 1);
    }

    public GetOnlineUserNumRsp(int i3, int i16) {
        this.Code = i3;
        this.OnlineUserNum = i16;
    }
}
