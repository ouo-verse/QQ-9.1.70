package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PublicShareData extends JceStruct {
    public String cover;
    public String desc;
    public String h5url;
    public String schema;

    public PublicShareData() {
        this.cover = "";
        this.desc = "";
        this.h5url = "";
        this.schema = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cover = jceInputStream.readString(0, false);
        this.desc = jceInputStream.readString(1, false);
        this.h5url = jceInputStream.readString(2, false);
        this.schema = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.cover;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.h5url;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.schema;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public PublicShareData(String str, String str2, String str3, String str4) {
        this.cover = str;
        this.desc = str2;
        this.h5url = str3;
        this.schema = str4;
    }
}
