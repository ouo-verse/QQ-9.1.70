package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BubbleInfo extends JceStruct {
    static ItemBase cache_item = new ItemBase();
    public String btn;
    public int feeType;
    public ItemBase item;
    public int month;

    /* renamed from: msg, reason: collision with root package name */
    public String f25083msg;
    public String name;
    public String payUrl;
    public String strPicUrl;
    public String title;
    public String type;

    public BubbleInfo() {
        this.item = null;
        this.feeType = 0;
        this.name = "";
        this.payUrl = "";
        this.type = "";
        this.month = 0;
        this.f25083msg = "";
        this.btn = "";
        this.title = "";
        this.strPicUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.item = (ItemBase) jceInputStream.read((JceStruct) cache_item, 0, false);
        this.feeType = jceInputStream.read(this.feeType, 1, false);
        this.name = jceInputStream.readString(2, false);
        this.payUrl = jceInputStream.readString(3, false);
        this.type = jceInputStream.readString(4, false);
        this.month = jceInputStream.read(this.month, 5, false);
        this.f25083msg = jceInputStream.readString(6, false);
        this.btn = jceInputStream.readString(7, false);
        this.title = jceInputStream.readString(8, false);
        this.strPicUrl = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ItemBase itemBase = this.item;
        if (itemBase != null) {
            jceOutputStream.write((JceStruct) itemBase, 0);
        }
        jceOutputStream.write(this.feeType, 1);
        String str = this.name;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.payUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.type;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.month, 5);
        String str4 = this.f25083msg;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.btn;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.title;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        String str7 = this.strPicUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 9);
        }
    }

    public BubbleInfo(ItemBase itemBase, int i3, String str, String str2, String str3, int i16, String str4, String str5, String str6, String str7) {
        this.item = itemBase;
        this.feeType = i3;
        this.name = str;
        this.payUrl = str2;
        this.type = str3;
        this.month = i16;
        this.f25083msg = str4;
        this.btn = str5;
        this.title = str6;
        this.strPicUrl = str7;
    }
}
