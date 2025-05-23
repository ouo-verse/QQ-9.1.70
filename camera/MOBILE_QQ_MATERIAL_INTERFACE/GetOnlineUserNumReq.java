package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetOnlineUserNumReq extends JceStruct {
    public String Nothing;

    public GetOnlineUserNumReq() {
        this.Nothing = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Nothing = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.Nothing;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public GetOnlineUserNumReq(String str) {
        this.Nothing = str;
    }
}
