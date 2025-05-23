package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserBitFlagReq extends JceStruct {
    public byte cAccout2Dis;
    public byte cEmotionMall;
    public byte cMyWallet;
    public byte cPtt2Text;

    public UserBitFlagReq() {
        this.cEmotionMall = (byte) -1;
        this.cMyWallet = (byte) -1;
        this.cPtt2Text = (byte) -1;
        this.cAccout2Dis = (byte) -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cEmotionMall = jceInputStream.read(this.cEmotionMall, 0, false);
        this.cMyWallet = jceInputStream.read(this.cMyWallet, 1, false);
        this.cPtt2Text = jceInputStream.read(this.cPtt2Text, 2, false);
        this.cAccout2Dis = jceInputStream.read(this.cAccout2Dis, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cEmotionMall, 0);
        jceOutputStream.write(this.cMyWallet, 1);
        jceOutputStream.write(this.cPtt2Text, 2);
        jceOutputStream.write(this.cAccout2Dis, 3);
    }

    public UserBitFlagReq(byte b16, byte b17, byte b18, byte b19) {
        this.cEmotionMall = b16;
        this.cMyWallet = b17;
        this.cPtt2Text = b18;
        this.cAccout2Dis = b19;
    }
}
