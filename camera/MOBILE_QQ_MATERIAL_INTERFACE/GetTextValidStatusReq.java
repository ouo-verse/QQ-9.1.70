package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetTextValidStatusReq extends JceStruct {
    public String EmoText;

    public GetTextValidStatusReq() {
        this.EmoText = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.EmoText = jceInputStream.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.EmoText;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
    }

    public GetTextValidStatusReq(String str) {
        this.EmoText = str;
    }
}
