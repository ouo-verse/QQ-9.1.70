package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMetaUgcImage extends JceStruct {
    public String format;
    public int height;
    public String photo_rgb;
    public int priority;
    public int sprite_height;
    public int sprite_span;
    public int sprite_width;
    public int type;
    public String url;
    public int width;

    public stMetaUgcImage() {
        this.url = "";
        this.width = 0;
        this.height = 0;
        this.type = 0;
        this.sprite_width = 0;
        this.sprite_height = 0;
        this.sprite_span = 0;
        this.priority = 0;
        this.photo_rgb = "";
        this.format = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, false);
        this.width = jceInputStream.read(this.width, 1, false);
        this.height = jceInputStream.read(this.height, 2, false);
        this.type = jceInputStream.read(this.type, 3, false);
        this.sprite_width = jceInputStream.read(this.sprite_width, 4, false);
        this.sprite_height = jceInputStream.read(this.sprite_height, 5, false);
        this.sprite_span = jceInputStream.read(this.sprite_span, 6, false);
        this.priority = jceInputStream.read(this.priority, 7, false);
        this.photo_rgb = jceInputStream.readString(8, false);
        this.format = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.width, 1);
        jceOutputStream.write(this.height, 2);
        jceOutputStream.write(this.type, 3);
        jceOutputStream.write(this.sprite_width, 4);
        jceOutputStream.write(this.sprite_height, 5);
        jceOutputStream.write(this.sprite_span, 6);
        jceOutputStream.write(this.priority, 7);
        String str2 = this.photo_rgb;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        String str3 = this.format;
        if (str3 != null) {
            jceOutputStream.write(str3, 9);
        }
    }

    public stMetaUgcImage(String str, int i3, int i16, int i17, int i18, int i19, int i26, int i27, String str2, String str3) {
        this.url = str;
        this.width = i3;
        this.height = i16;
        this.type = i17;
        this.sprite_width = i18;
        this.sprite_height = i19;
        this.sprite_span = i26;
        this.priority = i27;
        this.photo_rgb = str2;
        this.format = str3;
    }
}
