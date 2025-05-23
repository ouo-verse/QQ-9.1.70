package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DefineAvatarInfo extends JceStruct {
    public byte cImgFmt;
    public byte cImgStyle;

    public DefineAvatarInfo() {
        this.cImgStyle = (byte) 0;
        this.cImgFmt = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cImgStyle = jceInputStream.read(this.cImgStyle, 0, true);
        this.cImgFmt = jceInputStream.read(this.cImgFmt, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cImgStyle, 0);
        jceOutputStream.write(this.cImgFmt, 1);
    }

    public DefineAvatarInfo(byte b16, byte b17) {
        this.cImgStyle = b16;
        this.cImgFmt = b17;
    }
}
