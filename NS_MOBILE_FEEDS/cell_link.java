package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_link extends JceStruct {
    public String data;
    public String post;
    public String url;

    public cell_link() {
        this.data = "";
        this.url = "";
        this.post = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.data = jceInputStream.readString(0, false);
        this.url = jceInputStream.readString(1, false);
        this.post = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.data;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.post;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public cell_link(String str, String str2, String str3) {
        this.data = str;
        this.url = str2;
        this.post = str3;
    }
}
