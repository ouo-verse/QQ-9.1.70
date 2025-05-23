package camera.MOBILE_QQ_MATERIAL_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ZplanFaceStyle extends JceStruct {
    static CoinInfo[] cache_TotalPrice = new CoinInfo[1];
    static TotalPriceInfo cache_TotalPriceInfo;
    public String Description;
    public String PtaData;
    public String StyleID;
    public String StyleName;
    public String ThumbnailURL;
    public CoinInfo[] TotalPrice;
    public TotalPriceInfo TotalPriceInfo;

    static {
        cache_TotalPrice[0] = new CoinInfo();
        cache_TotalPriceInfo = new TotalPriceInfo();
    }

    public ZplanFaceStyle() {
        this.ThumbnailURL = "";
        this.Description = "";
        this.PtaData = "";
        this.StyleID = "";
        this.StyleName = "";
        this.TotalPrice = null;
        this.TotalPriceInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ThumbnailURL = jceInputStream.readString(0, false);
        this.Description = jceInputStream.readString(1, false);
        this.PtaData = jceInputStream.readString(2, false);
        this.StyleID = jceInputStream.readString(3, false);
        this.StyleName = jceInputStream.readString(4, false);
        this.TotalPrice = (CoinInfo[]) jceInputStream.read((JceStruct[]) cache_TotalPrice, 5, false);
        this.TotalPriceInfo = (TotalPriceInfo) jceInputStream.read((JceStruct) cache_TotalPriceInfo, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ThumbnailURL;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.Description;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.PtaData;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.StyleID;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.StyleName;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        CoinInfo[] coinInfoArr = this.TotalPrice;
        if (coinInfoArr != null) {
            jceOutputStream.write((Object[]) coinInfoArr, 5);
        }
        TotalPriceInfo totalPriceInfo = this.TotalPriceInfo;
        if (totalPriceInfo != null) {
            jceOutputStream.write((JceStruct) totalPriceInfo, 6);
        }
    }

    public ZplanFaceStyle(String str, String str2, String str3, String str4, String str5, CoinInfo[] coinInfoArr, TotalPriceInfo totalPriceInfo) {
        this.ThumbnailURL = str;
        this.Description = str2;
        this.PtaData = str3;
        this.StyleID = str4;
        this.StyleName = str5;
        this.TotalPrice = coinInfoArr;
        this.TotalPriceInfo = totalPriceInfo;
    }
}
