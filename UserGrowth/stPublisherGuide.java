package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPublisherGuide extends JceStruct {
    public String btnText;
    public String desc;
    public int imageType;
    public String imageUrl;

    public stPublisherGuide() {
        this.imageUrl = "";
        this.btnText = "";
        this.desc = "";
        this.imageType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imageUrl = jceInputStream.readString(0, false);
        this.btnText = jceInputStream.readString(1, false);
        this.desc = jceInputStream.readString(2, false);
        this.imageType = jceInputStream.read(this.imageType, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.imageUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.btnText;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.desc;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        jceOutputStream.write(this.imageType, 3);
    }

    public stPublisherGuide(String str, String str2, String str3, int i3) {
        this.imageUrl = str;
        this.btnText = str2;
        this.desc = str3;
        this.imageType = i3;
    }
}
