package VipRecommend.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PayParam extends JceStruct {
    public String app_id;
    public int maxUpMonth;
    public String offerid;
    public int openMode;
    public int openMonth;
    public int openServicePrice;
    public int openType;
    public int pay_item;
    public String product_id;
    public String product_type;
    public int qq_product_id;
    public String qq_product_name;
    public String serviceName;
    public String serviceType;
    public String type;

    public PayParam() {
        this.type = "";
        this.openMode = 0;
        this.openMonth = 0;
        this.maxUpMonth = 0;
        this.offerid = "";
        this.serviceType = "";
        this.serviceName = "";
        this.openType = 0;
        this.openServicePrice = 0;
        this.app_id = "";
        this.product_id = "";
        this.product_type = "";
        this.pay_item = 0;
        this.qq_product_id = 0;
        this.qq_product_name = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.readString(0, true);
        this.openMode = jceInputStream.read(this.openMode, 1, true);
        this.openMonth = jceInputStream.read(this.openMonth, 2, true);
        this.maxUpMonth = jceInputStream.read(this.maxUpMonth, 3, true);
        this.offerid = jceInputStream.readString(4, false);
        this.serviceType = jceInputStream.readString(5, false);
        this.serviceName = jceInputStream.readString(6, false);
        this.openType = jceInputStream.read(this.openType, 7, false);
        this.openServicePrice = jceInputStream.read(this.openServicePrice, 8, false);
        this.app_id = jceInputStream.readString(9, false);
        this.product_id = jceInputStream.readString(10, false);
        this.product_type = jceInputStream.readString(11, false);
        this.pay_item = jceInputStream.read(this.pay_item, 12, false);
        this.qq_product_id = jceInputStream.read(this.qq_product_id, 13, false);
        this.qq_product_name = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.openMode, 1);
        jceOutputStream.write(this.openMonth, 2);
        jceOutputStream.write(this.maxUpMonth, 3);
        String str = this.offerid;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.serviceType;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.serviceName;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.openType, 7);
        jceOutputStream.write(this.openServicePrice, 8);
        String str4 = this.app_id;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        String str5 = this.product_id;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        String str6 = this.product_type;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
        jceOutputStream.write(this.pay_item, 12);
        jceOutputStream.write(this.qq_product_id, 13);
        String str7 = this.qq_product_name;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
    }

    public PayParam(String str, int i3, int i16, int i17, String str2, String str3, String str4, int i18, int i19, String str5, String str6, String str7, int i26, int i27, String str8) {
        this.type = str;
        this.openMode = i3;
        this.openMonth = i16;
        this.maxUpMonth = i17;
        this.offerid = str2;
        this.serviceType = str3;
        this.serviceName = str4;
        this.openType = i18;
        this.openServicePrice = i19;
        this.app_id = str5;
        this.product_id = str6;
        this.product_type = str7;
        this.pay_item = i26;
        this.qq_product_id = i27;
        this.qq_product_name = str8;
    }
}
