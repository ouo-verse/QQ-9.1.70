package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiSimpleItemDetail extends JceStruct {
    public int appId;
    public int feeType;
    public String image;
    public String itemBgColor;
    public int itemId;
    public String name;
    public UniBusiCommItemAidInfo stAidInfo;
    public UniBusiSimpleFontItem stFontItem;
    public UniBusiSimpleSigItem stSigItem;
    static UniBusiCommItemAidInfo cache_stAidInfo = new UniBusiCommItemAidInfo();
    static UniBusiSimpleSigItem cache_stSigItem = new UniBusiSimpleSigItem();
    static UniBusiSimpleFontItem cache_stFontItem = new UniBusiSimpleFontItem();

    public UniBusiSimpleItemDetail() {
        this.appId = 0;
        this.itemId = 0;
        this.name = "";
        this.feeType = 0;
        this.image = "";
        this.itemBgColor = "";
        this.stAidInfo = null;
        this.stSigItem = null;
        this.stFontItem = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.itemId = jceInputStream.read(this.itemId, 1, false);
        this.name = jceInputStream.readString(2, false);
        this.feeType = jceInputStream.read(this.feeType, 3, false);
        this.image = jceInputStream.readString(4, false);
        this.itemBgColor = jceInputStream.readString(5, false);
        this.stAidInfo = (UniBusiCommItemAidInfo) jceInputStream.read((JceStruct) cache_stAidInfo, 6, false);
        this.stSigItem = (UniBusiSimpleSigItem) jceInputStream.read((JceStruct) cache_stSigItem, 7, false);
        this.stFontItem = (UniBusiSimpleFontItem) jceInputStream.read((JceStruct) cache_stFontItem, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appId, 0);
        jceOutputStream.write(this.itemId, 1);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.feeType, 3);
        String str2 = this.image;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.itemBgColor;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        UniBusiCommItemAidInfo uniBusiCommItemAidInfo = this.stAidInfo;
        if (uniBusiCommItemAidInfo != null) {
            jceOutputStream.write((JceStruct) uniBusiCommItemAidInfo, 6);
        }
        UniBusiSimpleSigItem uniBusiSimpleSigItem = this.stSigItem;
        if (uniBusiSimpleSigItem != null) {
            jceOutputStream.write((JceStruct) uniBusiSimpleSigItem, 7);
        }
        UniBusiSimpleFontItem uniBusiSimpleFontItem = this.stFontItem;
        if (uniBusiSimpleFontItem != null) {
            jceOutputStream.write((JceStruct) uniBusiSimpleFontItem, 8);
        }
    }

    public UniBusiSimpleItemDetail(int i3, int i16, String str, int i17, String str2, String str3, UniBusiCommItemAidInfo uniBusiCommItemAidInfo, UniBusiSimpleSigItem uniBusiSimpleSigItem, UniBusiSimpleFontItem uniBusiSimpleFontItem) {
        this.appId = i3;
        this.itemId = i16;
        this.name = str;
        this.feeType = i17;
        this.image = str2;
        this.itemBgColor = str3;
        this.stAidInfo = uniBusiCommItemAidInfo;
        this.stSigItem = uniBusiSimpleSigItem;
        this.stFontItem = uniBusiSimpleFontItem;
    }
}
