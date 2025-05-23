package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CustomCover extends JceStruct {
    public String imageUrl;
    public String thumbUrl;

    public CustomCover() {
        this.thumbUrl = "";
        this.imageUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.thumbUrl = jceInputStream.readString(0, false);
        this.imageUrl = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.thumbUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.imageUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
    }

    public CustomCover(String str, String str2) {
        this.thumbUrl = str;
        this.imageUrl = str2;
    }
}
