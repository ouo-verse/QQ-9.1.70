package NS_FAMOUS_BASE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SchoolSingleGameItem extends JceStruct {
    public String app_class1;
    public String app_class2;
    public String app_icon;
    public String app_name;
    public long appid;
    public long click_time;
    public long create_time;
    public String detail_url;
    public int flag;
    public long online_time;

    public SchoolSingleGameItem() {
        this.appid = 0L;
        this.app_name = "";
        this.create_time = 0L;
        this.online_time = 0L;
        this.click_time = 0L;
        this.app_icon = "";
        this.detail_url = "";
        this.flag = 0;
        this.app_class1 = "";
        this.app_class2 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, true);
        this.app_name = jceInputStream.readString(1, false);
        this.create_time = jceInputStream.read(this.create_time, 2, false);
        this.online_time = jceInputStream.read(this.online_time, 3, false);
        this.click_time = jceInputStream.read(this.click_time, 4, false);
        this.app_icon = jceInputStream.readString(5, false);
        this.detail_url = jceInputStream.readString(6, false);
        this.flag = jceInputStream.read(this.flag, 7, false);
        this.app_class1 = jceInputStream.readString(8, false);
        this.app_class2 = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        String str = this.app_name;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.create_time, 2);
        jceOutputStream.write(this.online_time, 3);
        jceOutputStream.write(this.click_time, 4);
        String str2 = this.app_icon;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.detail_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        jceOutputStream.write(this.flag, 7);
        String str4 = this.app_class1;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        String str5 = this.app_class2;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
    }

    public SchoolSingleGameItem(long j3, String str, long j16, long j17, long j18, String str2, String str3, int i3, String str4, String str5) {
        this.appid = j3;
        this.app_name = str;
        this.create_time = j16;
        this.online_time = j17;
        this.click_time = j18;
        this.app_icon = str2;
        this.detail_url = str3;
        this.flag = i3;
        this.app_class1 = str4;
        this.app_class2 = str5;
    }
}
