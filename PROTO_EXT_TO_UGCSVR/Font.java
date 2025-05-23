package PROTO_EXT_TO_UGCSVR;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Font extends JceStruct {
    static int cache_font_size;
    static int cache_hideFlag;
    public int font_size;
    public int hideFlag;

    public Font() {
        this.font_size = 0;
        this.hideFlag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.font_size = jceInputStream.read(this.font_size, 0, false);
        this.hideFlag = jceInputStream.read(this.hideFlag, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.font_size, 0);
        jceOutputStream.write(this.hideFlag, 1);
    }

    public Font(int i3, int i16) {
        this.font_size = i3;
        this.hideFlag = i16;
    }
}
