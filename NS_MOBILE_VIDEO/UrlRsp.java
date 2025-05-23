package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UrlRsp extends JceStruct {
    public int code;
    public String url;
    public int url_type;

    public UrlRsp() {
        this.url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.url = jceInputStream.readString(1, false);
        this.url_type = jceInputStream.read(this.url_type, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.url_type, 2);
    }

    public UrlRsp(int i3, String str, int i16) {
        this.code = i3;
        this.url = str;
        this.url_type = i16;
    }
}
