package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MaterialInfo extends JceStruct {
    static CoinInfo[] cache_CoinInfo = new CoinInfo[1];
    public CoinInfo[] CoinInfo;
    public boolean IsDiscount;
    public boolean IsHave;
    public int ItemID;
    public String ItemIcon;

    static {
        cache_CoinInfo[0] = new CoinInfo();
    }

    public MaterialInfo() {
        this.ItemID = 0;
        this.ItemIcon = "";
        this.IsHave = true;
        this.IsDiscount = true;
        this.CoinInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ItemID = jceInputStream.read(this.ItemID, 0, false);
        this.ItemIcon = jceInputStream.readString(1, false);
        this.IsHave = jceInputStream.read(this.IsHave, 2, false);
        this.IsDiscount = jceInputStream.read(this.IsDiscount, 3, false);
        this.CoinInfo = (CoinInfo[]) jceInputStream.read((JceStruct[]) cache_CoinInfo, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ItemID, 0);
        String str = this.ItemIcon;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.IsHave, 2);
        jceOutputStream.write(this.IsDiscount, 3);
        CoinInfo[] coinInfoArr = this.CoinInfo;
        if (coinInfoArr != null) {
            jceOutputStream.write((Object[]) coinInfoArr, 4);
        }
    }

    public MaterialInfo(int i3, String str, boolean z16, boolean z17, CoinInfo[] coinInfoArr) {
        this.ItemID = i3;
        this.ItemIcon = str;
        this.IsHave = z16;
        this.IsDiscount = z17;
        this.CoinInfo = coinInfoArr;
    }
}
