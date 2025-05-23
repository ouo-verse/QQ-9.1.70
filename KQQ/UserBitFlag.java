package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserBitFlag extends JceStruct {
    public byte cEmotionMall;
    public byte cSyncShuoShuo;

    public UserBitFlag() {
        this.cEmotionMall = (byte) -1;
        this.cSyncShuoShuo = (byte) -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cEmotionMall = jceInputStream.read(this.cEmotionMall, 0, false);
        this.cSyncShuoShuo = jceInputStream.read(this.cSyncShuoShuo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cEmotionMall, 0);
        jceOutputStream.write(this.cSyncShuoShuo, 1);
    }

    public UserBitFlag(byte b16, byte b17) {
        this.cEmotionMall = b16;
        this.cSyncShuoShuo = b17;
    }
}
