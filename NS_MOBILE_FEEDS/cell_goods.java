package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_goods extends JceStruct {
    public int btn_actiontype;
    public int btn_color;
    public String btn_title;
    public String btn_url;
    public String dis_price;
    public String goods_desc;
    public String goods_name;
    public int goods_type;
    public int iBuyCount;
    public int iOpenMonth;
    public int iProductType;
    public int iQuantity;
    public int isCanChange;
    public int isDepositGameCoin;
    public int layout_type;
    public String left_price_desc;
    public String payofferid;
    public String payremark;

    /* renamed from: pf, reason: collision with root package name */
    public String f24984pf;
    public String pfkey;
    public String popup_desc;
    public String popup_title;
    public String price;
    public String product_id;
    public String product_name;
    public String right_price_desc;
    public String strItemId;
    public String under_price_desc;
    public String upper_price_desc;
    public String zoneid;

    public cell_goods() {
        this.goods_desc = "";
        this.price = "";
        this.dis_price = "";
        this.btn_title = "";
        this.btn_url = "";
        this.upper_price_desc = "";
        this.under_price_desc = "";
        this.left_price_desc = "";
        this.right_price_desc = "";
        this.payremark = "";
        this.payofferid = "";
        this.popup_title = "";
        this.popup_desc = "";
        this.product_id = "";
        this.product_name = "";
        this.f24984pf = "";
        this.pfkey = "";
        this.zoneid = "";
        this.strItemId = "";
        this.goods_name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.goods_type = jceInputStream.read(this.goods_type, 0, false);
        this.goods_desc = jceInputStream.readString(1, false);
        this.price = jceInputStream.readString(2, false);
        this.dis_price = jceInputStream.readString(3, false);
        this.btn_title = jceInputStream.readString(4, false);
        this.btn_color = jceInputStream.read(this.btn_color, 5, false);
        this.btn_actiontype = jceInputStream.read(this.btn_actiontype, 6, false);
        this.btn_url = jceInputStream.readString(7, false);
        this.upper_price_desc = jceInputStream.readString(8, false);
        this.under_price_desc = jceInputStream.readString(9, false);
        this.left_price_desc = jceInputStream.readString(10, false);
        this.right_price_desc = jceInputStream.readString(11, false);
        this.payremark = jceInputStream.readString(12, false);
        this.payofferid = jceInputStream.readString(13, false);
        this.iOpenMonth = jceInputStream.read(this.iOpenMonth, 14, false);
        this.isCanChange = jceInputStream.read(this.isCanChange, 15, false);
        this.popup_title = jceInputStream.readString(16, false);
        this.popup_desc = jceInputStream.readString(17, false);
        this.product_id = jceInputStream.readString(18, false);
        this.iQuantity = jceInputStream.read(this.iQuantity, 19, false);
        this.iProductType = jceInputStream.read(this.iProductType, 20, false);
        this.product_name = jceInputStream.readString(21, false);
        this.isDepositGameCoin = jceInputStream.read(this.isDepositGameCoin, 22, false);
        this.f24984pf = jceInputStream.readString(23, false);
        this.pfkey = jceInputStream.readString(24, false);
        this.zoneid = jceInputStream.readString(25, false);
        this.strItemId = jceInputStream.readString(26, false);
        this.iBuyCount = jceInputStream.read(this.iBuyCount, 27, false);
        this.goods_name = jceInputStream.readString(28, false);
        this.layout_type = jceInputStream.read(this.layout_type, 29, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.goods_type, 0);
        String str = this.goods_desc;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.price;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.dis_price;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.btn_title;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.btn_color, 5);
        jceOutputStream.write(this.btn_actiontype, 6);
        String str5 = this.btn_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        String str6 = this.upper_price_desc;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        String str7 = this.under_price_desc;
        if (str7 != null) {
            jceOutputStream.write(str7, 9);
        }
        String str8 = this.left_price_desc;
        if (str8 != null) {
            jceOutputStream.write(str8, 10);
        }
        String str9 = this.right_price_desc;
        if (str9 != null) {
            jceOutputStream.write(str9, 11);
        }
        String str10 = this.payremark;
        if (str10 != null) {
            jceOutputStream.write(str10, 12);
        }
        String str11 = this.payofferid;
        if (str11 != null) {
            jceOutputStream.write(str11, 13);
        }
        jceOutputStream.write(this.iOpenMonth, 14);
        jceOutputStream.write(this.isCanChange, 15);
        String str12 = this.popup_title;
        if (str12 != null) {
            jceOutputStream.write(str12, 16);
        }
        String str13 = this.popup_desc;
        if (str13 != null) {
            jceOutputStream.write(str13, 17);
        }
        String str14 = this.product_id;
        if (str14 != null) {
            jceOutputStream.write(str14, 18);
        }
        jceOutputStream.write(this.iQuantity, 19);
        jceOutputStream.write(this.iProductType, 20);
        String str15 = this.product_name;
        if (str15 != null) {
            jceOutputStream.write(str15, 21);
        }
        jceOutputStream.write(this.isDepositGameCoin, 22);
        String str16 = this.f24984pf;
        if (str16 != null) {
            jceOutputStream.write(str16, 23);
        }
        String str17 = this.pfkey;
        if (str17 != null) {
            jceOutputStream.write(str17, 24);
        }
        String str18 = this.zoneid;
        if (str18 != null) {
            jceOutputStream.write(str18, 25);
        }
        String str19 = this.strItemId;
        if (str19 != null) {
            jceOutputStream.write(str19, 26);
        }
        jceOutputStream.write(this.iBuyCount, 27);
        String str20 = this.goods_name;
        if (str20 != null) {
            jceOutputStream.write(str20, 28);
        }
        jceOutputStream.write(this.layout_type, 29);
    }

    public cell_goods(int i3, String str, String str2, String str3, String str4, int i16, int i17, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i18, int i19, String str12, String str13, String str14, int i26, int i27, String str15, int i28, String str16, String str17, String str18, String str19, int i29, String str20, int i36) {
        this.goods_type = i3;
        this.goods_desc = str;
        this.price = str2;
        this.dis_price = str3;
        this.btn_title = str4;
        this.btn_color = i16;
        this.btn_actiontype = i17;
        this.btn_url = str5;
        this.upper_price_desc = str6;
        this.under_price_desc = str7;
        this.left_price_desc = str8;
        this.right_price_desc = str9;
        this.payremark = str10;
        this.payofferid = str11;
        this.iOpenMonth = i18;
        this.isCanChange = i19;
        this.popup_title = str12;
        this.popup_desc = str13;
        this.product_id = str14;
        this.iQuantity = i26;
        this.iProductType = i27;
        this.product_name = str15;
        this.isDepositGameCoin = i28;
        this.f24984pf = str16;
        this.pfkey = str17;
        this.zoneid = str18;
        this.strItemId = str19;
        this.iBuyCount = i29;
        this.goods_name = str20;
        this.layout_type = i36;
    }
}
