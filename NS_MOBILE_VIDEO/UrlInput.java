package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UrlInput extends JceStruct {
    public String url_detail;
    public int url_type;

    public UrlInput() {
        this.url_detail = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url_type = jceInputStream.read(this.url_type, 0, false);
        this.url_detail = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.url_type, 0);
        String str = this.url_detail;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public UrlInput(int i3, String str) {
        this.url_type = i3;
        this.url_detail = str;
    }
}
