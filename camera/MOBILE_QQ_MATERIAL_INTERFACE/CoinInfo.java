package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CoinInfo extends JceStruct {
    static int cache_CoinType;
    public int CoinPrice;
    public int CoinType;

    public CoinInfo() {
        this.CoinType = 0;
        this.CoinPrice = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.CoinType = jceInputStream.read(this.CoinType, 0, false);
        this.CoinPrice = jceInputStream.read(this.CoinPrice, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.CoinType, 0);
        jceOutputStream.write(this.CoinPrice, 1);
    }

    public CoinInfo(int i3, int i16) {
        this.CoinType = i3;
        this.CoinPrice = i16;
    }
}
