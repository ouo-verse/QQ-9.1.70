package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetUserDiyFontRsp extends JceStruct {
    public int ret;
    public String url;

    public GetUserDiyFontRsp() {
        this.ret = 0;
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.url = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public GetUserDiyFontRsp(int i3, String str) {
        this.ret = i3;
        this.url = str;
    }
}
