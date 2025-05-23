package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetFontDataReq extends JceStruct {
    public String Content;
    public String FontName;

    public GetFontDataReq() {
        this.FontName = "";
        this.Content = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.FontName = jceInputStream.readString(0, false);
        this.Content = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.FontName;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.Content;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public GetFontDataReq(String str, String str2) {
        this.FontName = str;
        this.Content = str2;
    }
}
