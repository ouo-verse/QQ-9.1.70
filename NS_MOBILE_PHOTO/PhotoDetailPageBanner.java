package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public class PhotoDetailPageBanner extends JceStruct {
    public String desc;
    public boolean is_visible;

    public PhotoDetailPageBanner() {
        this.is_visible = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.is_visible = jceInputStream.read(this.is_visible, 0, false);
        this.desc = jceInputStream.read(this.desc, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.is_visible, 0);
        String str = this.desc;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public PhotoDetailPageBanner(boolean z16, String str) {
        this.is_visible = z16;
        this.desc = str;
    }
}
