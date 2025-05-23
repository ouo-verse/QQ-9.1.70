package camera.SHADOW_BACKEND_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetIsUserPublishedReq extends JceStruct {
    public String Uin;

    public GetIsUserPublishedReq() {
        this.Uin = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Uin = jceInputStream.readString(0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Uin, 0);
    }

    public GetIsUserPublishedReq(String str) {
        this.Uin = str;
    }
}
