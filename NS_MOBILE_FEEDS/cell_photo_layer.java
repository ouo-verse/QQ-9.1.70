package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_photo_layer extends JceStruct {
    public String button_text;
    public String layer_text;
    public String layer_title;
    public int opmask;

    public cell_photo_layer() {
        this.layer_title = "";
        this.layer_text = "";
        this.button_text = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.opmask = jceInputStream.read(this.opmask, 0, false);
        this.layer_title = jceInputStream.readString(1, false);
        this.layer_text = jceInputStream.readString(2, false);
        this.button_text = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.opmask, 0);
        String str = this.layer_title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.layer_text;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.button_text;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public cell_photo_layer(int i3, String str, String str2, String str3) {
        this.opmask = i3;
        this.layer_title = str;
        this.layer_text = str2;
        this.button_text = str3;
    }
}
