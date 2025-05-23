package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class OneVideoPlayInfo extends JceStruct {
    public int definition;
    public String url;
    public int vbitrate;
    public int vheight;
    public int vwidth;

    public OneVideoPlayInfo() {
        this.url = "";
        this.definition = 0;
        this.vbitrate = 0;
        this.vheight = 0;
        this.vwidth = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.url = jceInputStream.readString(0, false);
        this.definition = jceInputStream.read(this.definition, 1, false);
        this.vbitrate = jceInputStream.read(this.vbitrate, 2, false);
        this.vheight = jceInputStream.read(this.vheight, 3, false);
        this.vwidth = jceInputStream.read(this.vwidth, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.url;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.definition, 1);
        jceOutputStream.write(this.vbitrate, 2);
        jceOutputStream.write(this.vheight, 3);
        jceOutputStream.write(this.vwidth, 4);
    }

    public OneVideoPlayInfo(String str, int i3, int i16, int i17, int i18) {
        this.url = str;
        this.definition = i3;
        this.vbitrate = i16;
        this.vheight = i17;
        this.vwidth = i18;
    }
}
