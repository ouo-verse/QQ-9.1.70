package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetTextValidStatusRsp extends JceStruct {
    public int Code;
    public int ValidStatus;

    public GetTextValidStatusRsp() {
        this.Code = 0;
        this.ValidStatus = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.ValidStatus = jceInputStream.read(this.ValidStatus, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        jceOutputStream.write(this.ValidStatus, 1);
    }

    public GetTextValidStatusRsp(int i3, int i16) {
        this.Code = i3;
        this.ValidStatus = i16;
    }
}
