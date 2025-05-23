package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_gift_card extends JceStruct {
    public String btn_link_1;
    public String btn_link_2;
    public String btn_pic_1;
    public String btn_pic_2;
    public String btn_pic_reply;
    public boolean btn_reply;
    public String card_url;
    public String pic_100;
    public String pic_65;
    public String pic_background;
    public String pic_baseurl;
    public String pic_big;
    public String word_desc;
    public String word_msg;
    public String word_name;

    public s_gift_card() {
        this.pic_baseurl = "";
        this.pic_background = "";
        this.pic_65 = "";
        this.pic_100 = "";
        this.pic_big = "";
        this.btn_reply = true;
        this.btn_pic_reply = "";
        this.btn_pic_1 = "";
        this.btn_link_1 = "";
        this.btn_pic_2 = "";
        this.btn_link_2 = "";
        this.word_name = "";
        this.word_desc = "";
        this.word_msg = "";
        this.card_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pic_baseurl = jceInputStream.readString(0, false);
        this.pic_background = jceInputStream.readString(1, false);
        this.pic_65 = jceInputStream.readString(2, false);
        this.pic_100 = jceInputStream.readString(3, false);
        this.pic_big = jceInputStream.readString(4, false);
        this.btn_reply = jceInputStream.read(this.btn_reply, 5, false);
        this.btn_pic_reply = jceInputStream.readString(6, false);
        this.btn_pic_1 = jceInputStream.readString(7, false);
        this.btn_link_1 = jceInputStream.readString(8, false);
        this.btn_pic_2 = jceInputStream.readString(9, false);
        this.btn_link_2 = jceInputStream.readString(10, false);
        this.word_name = jceInputStream.readString(11, false);
        this.word_desc = jceInputStream.readString(12, false);
        this.word_msg = jceInputStream.readString(13, false);
        this.card_url = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.pic_baseurl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.pic_background;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.pic_65;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.pic_100;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.pic_big;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        jceOutputStream.write(this.btn_reply, 5);
        String str6 = this.btn_pic_reply;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.btn_pic_1;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.btn_link_1;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
        String str9 = this.btn_pic_2;
        if (str9 != null) {
            jceOutputStream.write(str9, 9);
        }
        String str10 = this.btn_link_2;
        if (str10 != null) {
            jceOutputStream.write(str10, 10);
        }
        String str11 = this.word_name;
        if (str11 != null) {
            jceOutputStream.write(str11, 11);
        }
        String str12 = this.word_desc;
        if (str12 != null) {
            jceOutputStream.write(str12, 12);
        }
        String str13 = this.word_msg;
        if (str13 != null) {
            jceOutputStream.write(str13, 13);
        }
        String str14 = this.card_url;
        if (str14 != null) {
            jceOutputStream.write(str14, 14);
        }
    }

    public s_gift_card(String str, String str2, String str3, String str4, String str5, boolean z16, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.pic_baseurl = str;
        this.pic_background = str2;
        this.pic_65 = str3;
        this.pic_100 = str4;
        this.pic_big = str5;
        this.btn_reply = z16;
        this.btn_pic_reply = str6;
        this.btn_pic_1 = str7;
        this.btn_link_1 = str8;
        this.btn_pic_2 = str9;
        this.btn_link_2 = str10;
        this.word_name = str11;
        this.word_desc = str12;
        this.word_msg = str13;
        this.card_url = str14;
    }
}
