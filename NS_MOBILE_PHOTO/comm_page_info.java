package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class comm_page_info extends JceStruct {
    public boolean has_more;
    public String page_str;

    public comm_page_info() {
        this.page_str = "";
        this.has_more = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.page_str = jceInputStream.readString(0, false);
        this.has_more = jceInputStream.read(this.has_more, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.page_str;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.has_more, 1);
    }

    public comm_page_info(String str, boolean z16) {
        this.page_str = str;
        this.has_more = z16;
    }
}
