package NS_MOBILE_BITMAP_4TH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class bmp4_set_rsp extends JceStruct {
    public String errmsg;
    public int retCode;

    public bmp4_set_rsp() {
        this.retCode = 0;
        this.errmsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.retCode = jceInputStream.read(this.retCode, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.retCode, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public bmp4_set_rsp(int i3, String str) {
        this.retCode = i3;
        this.errmsg = str;
    }
}
