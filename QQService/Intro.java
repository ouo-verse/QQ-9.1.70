package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Intro extends JceStruct {
    static byte[] cache_vContent;
    public short shType;
    public byte[] vContent;

    public Intro() {
        this.shType = (short) 0;
        this.vContent = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shType = jceInputStream.read(this.shType, 0, true);
        if (cache_vContent == null) {
            cache_vContent = r0;
            byte[] bArr = {0};
        }
        this.vContent = jceInputStream.read(cache_vContent, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shType, 0);
        jceOutputStream.write(this.vContent, 1);
    }

    public Intro(short s16, byte[] bArr) {
        this.shType = s16;
        this.vContent = bArr;
    }
}
