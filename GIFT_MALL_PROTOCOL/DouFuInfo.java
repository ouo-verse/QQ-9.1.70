package GIFT_MALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DouFuInfo extends JceStruct {
    public String background;
    public String birthday;
    public String blessing;
    public String doufu_link;
    public String icon;
    public long uin;

    public DouFuInfo() {
        this.birthday = "";
        this.uin = 0L;
        this.icon = "";
        this.blessing = "";
        this.doufu_link = "";
        this.background = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.birthday = jceInputStream.readString(0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.icon = jceInputStream.readString(2, false);
        this.blessing = jceInputStream.readString(3, false);
        this.doufu_link = jceInputStream.readString(4, false);
        this.background = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.birthday;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.uin, 1);
        String str2 = this.icon;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.blessing;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.doufu_link;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.background;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
    }

    public DouFuInfo(String str, long j3, String str2, String str3, String str4, String str5) {
        this.birthday = str;
        this.uin = j3;
        this.icon = str2;
        this.blessing = str3;
        this.doufu_link = str4;
        this.background = str5;
    }
}
