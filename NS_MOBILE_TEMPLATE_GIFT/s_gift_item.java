package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_gift_item extends JceStruct {
    public String format;
    public long item_id;
    public int item_type;
    public String name;
    public String picUrl;
    public String picUrl_188;
    public String pre_format;
    public int price;
    public String remark;
    public int special_type;
    public String url_audio;
    public String url_video;
    public String url_video_thumbnail;
    public int vip_price;
    public String warm_msg;

    public s_gift_item() {
        this.name = "";
        this.format = "";
        this.remark = "";
        this.pre_format = "";
        this.picUrl = "";
        this.warm_msg = "";
        this.url_audio = "";
        this.url_video = "";
        this.url_video_thumbnail = "";
        this.picUrl_188 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.item_id = jceInputStream.read(this.item_id, 0, true);
        this.name = jceInputStream.readString(1, true);
        this.price = jceInputStream.read(this.price, 2, true);
        this.vip_price = jceInputStream.read(this.vip_price, 3, true);
        this.format = jceInputStream.readString(4, true);
        this.item_type = jceInputStream.read(this.item_type, 5, true);
        this.remark = jceInputStream.readString(6, true);
        this.special_type = jceInputStream.read(this.special_type, 7, true);
        this.pre_format = jceInputStream.readString(8, false);
        this.picUrl = jceInputStream.readString(9, false);
        this.warm_msg = jceInputStream.readString(10, false);
        this.url_audio = jceInputStream.readString(11, false);
        this.url_video = jceInputStream.readString(12, false);
        this.url_video_thumbnail = jceInputStream.readString(13, false);
        this.picUrl_188 = jceInputStream.readString(14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.item_id, 0);
        jceOutputStream.write(this.name, 1);
        jceOutputStream.write(this.price, 2);
        jceOutputStream.write(this.vip_price, 3);
        jceOutputStream.write(this.format, 4);
        jceOutputStream.write(this.item_type, 5);
        jceOutputStream.write(this.remark, 6);
        jceOutputStream.write(this.special_type, 7);
        String str = this.pre_format;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        String str2 = this.picUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        String str3 = this.warm_msg;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        String str4 = this.url_audio;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
        String str5 = this.url_video;
        if (str5 != null) {
            jceOutputStream.write(str5, 12);
        }
        String str6 = this.url_video_thumbnail;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
        String str7 = this.picUrl_188;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
    }

    public s_gift_item(long j3, String str, int i3, int i16, String str2, int i17, String str3, int i18, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.item_id = j3;
        this.name = str;
        this.price = i3;
        this.vip_price = i16;
        this.format = str2;
        this.item_type = i17;
        this.remark = str3;
        this.special_type = i18;
        this.pre_format = str4;
        this.picUrl = str5;
        this.warm_msg = str6;
        this.url_audio = str7;
        this.url_video = str8;
        this.url_video_thumbnail = str9;
        this.picUrl_188 = str10;
    }
}
