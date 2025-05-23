package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class TotalPriceInfo extends JceStruct {
    static int cache_PriceShowType;
    static CoinInfo[] cache_TotalPrice = new CoinInfo[1];
    public boolean NeedShow;
    public int PriceShowType;
    public CoinInfo[] TotalPrice;

    static {
        cache_TotalPrice[0] = new CoinInfo();
        cache_PriceShowType = 0;
    }

    public TotalPriceInfo() {
        this.TotalPrice = null;
        this.NeedShow = true;
        this.PriceShowType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.TotalPrice = (CoinInfo[]) jceInputStream.read((JceStruct[]) cache_TotalPrice, 0, false);
        this.NeedShow = jceInputStream.read(this.NeedShow, 1, false);
        this.PriceShowType = jceInputStream.read(this.PriceShowType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CoinInfo[] coinInfoArr = this.TotalPrice;
        if (coinInfoArr != null) {
            jceOutputStream.write((Object[]) coinInfoArr, 0);
        }
        jceOutputStream.write(this.NeedShow, 1);
        jceOutputStream.write(this.PriceShowType, 2);
    }

    public TotalPriceInfo(CoinInfo[] coinInfoArr, boolean z16, int i3) {
        this.TotalPrice = coinInfoArr;
        this.NeedShow = z16;
        this.PriceShowType = i3;
    }
}
