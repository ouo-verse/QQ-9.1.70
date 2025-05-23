package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stImgReplacement extends JceStruct {
    public String format;
    public int height;
    public String img;
    public int imgType;
    public String photo_rgb;
    public int width;

    public stImgReplacement() {
        this.imgType = 0;
        this.img = "";
        this.width = 0;
        this.height = 0;
        this.photo_rgb = "";
        this.format = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imgType = jceInputStream.read(this.imgType, 0, false);
        this.img = jceInputStream.readString(1, false);
        this.width = jceInputStream.read(this.width, 2, false);
        this.height = jceInputStream.read(this.height, 3, false);
        this.photo_rgb = jceInputStream.readString(4, false);
        this.format = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.imgType, 0);
        String str = this.img;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.width, 2);
        jceOutputStream.write(this.height, 3);
        String str2 = this.photo_rgb;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.format;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public stImgReplacement(int i3, String str, int i16, int i17, String str2, String str3) {
        this.imgType = i3;
        this.img = str;
        this.width = i16;
        this.height = i17;
        this.photo_rgb = str2;
        this.format = str3;
    }
}
