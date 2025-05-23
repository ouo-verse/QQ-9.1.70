package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FontInfo extends JceStruct {
    static ItemBase cache_item = new ItemBase();
    public String btn;
    public int engine;
    public int feeType;
    public ItemBase item;
    public int linkBubbleID;
    public int month;

    /* renamed from: msg, reason: collision with root package name */
    public String f25085msg;
    public String name;
    public String payUrl;
    public String strPicUrl;
    public String title;
    public String type;

    public FontInfo() {
        this.item = null;
        this.linkBubbleID = 0;
        this.feeType = 0;
        this.name = "";
        this.payUrl = "";
        this.type = "";
        this.month = 0;
        this.f25085msg = "";
        this.btn = "";
        this.title = "";
        this.engine = 0;
        this.strPicUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.item = (ItemBase) jceInputStream.read((JceStruct) cache_item, 0, false);
        this.linkBubbleID = jceInputStream.read(this.linkBubbleID, 1, false);
        this.feeType = jceInputStream.read(this.feeType, 2, false);
        this.name = jceInputStream.readString(3, false);
        this.payUrl = jceInputStream.readString(4, false);
        this.type = jceInputStream.readString(5, false);
        this.month = jceInputStream.read(this.month, 6, false);
        this.f25085msg = jceInputStream.readString(7, false);
        this.btn = jceInputStream.readString(8, false);
        this.title = jceInputStream.readString(9, false);
        this.engine = jceInputStream.read(this.engine, 10, false);
        this.strPicUrl = jceInputStream.readString(11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ItemBase itemBase = this.item;
        if (itemBase != null) {
            jceOutputStream.write((JceStruct) itemBase, 0);
        }
        jceOutputStream.write(this.linkBubbleID, 1);
        jceOutputStream.write(this.feeType, 2);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.payUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.type;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.month, 6);
        String str4 = this.f25085msg;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.btn;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        String str6 = this.title;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        jceOutputStream.write(this.engine, 10);
        String str7 = this.strPicUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 11);
        }
    }

    public FontInfo(ItemBase itemBase, int i3, int i16, String str, String str2, String str3, int i17, String str4, String str5, String str6, int i18, String str7) {
        this.item = itemBase;
        this.linkBubbleID = i3;
        this.feeType = i16;
        this.name = str;
        this.payUrl = str2;
        this.type = str3;
        this.month = i17;
        this.f25085msg = str4;
        this.btn = str5;
        this.title = str6;
        this.engine = i18;
        this.strPicUrl = str7;
    }
}
