package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EmotionMallBitRes extends JceStruct {
    public byte cEmotionMall;

    public EmotionMallBitRes() {
        this.cEmotionMall = (byte) -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cEmotionMall = jceInputStream.read(this.cEmotionMall, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cEmotionMall, 0);
    }

    public EmotionMallBitRes(byte b16) {
        this.cEmotionMall = b16;
    }
}
