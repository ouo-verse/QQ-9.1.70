package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_refer extends JceStruct {
    public int actiontype;
    public String actionurl;
    public String appid;
    public String appname;
    public String downloadurl;
    public String icon;
    public int icon_height;
    public String icon_token;
    public int icon_width;
    public String night_text_color;
    public boolean show_link_color;
    public String text_color;

    public cell_refer() {
        this.appname = "";
        this.actionurl = "";
        this.downloadurl = "";
        this.appid = "";
        this.actiontype = 0;
        this.icon = "";
        this.icon_width = 0;
        this.icon_height = 0;
        this.show_link_color = false;
        this.icon_token = "";
        this.text_color = "";
        this.night_text_color = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appname = jceInputStream.readString(0, true);
        this.actionurl = jceInputStream.readString(1, true);
        this.downloadurl = jceInputStream.readString(2, false);
        this.appid = jceInputStream.readString(3, false);
        this.actiontype = jceInputStream.read(this.actiontype, 4, false);
        this.icon = jceInputStream.readString(5, false);
        this.icon_width = jceInputStream.read(this.icon_width, 6, false);
        this.icon_height = jceInputStream.read(this.icon_height, 7, false);
        this.show_link_color = jceInputStream.read(this.show_link_color, 8, false);
        this.icon_token = jceInputStream.readString(9, false);
        this.text_color = jceInputStream.readString(10, false);
        this.night_text_color = jceInputStream.readString(11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appname, 0);
        jceOutputStream.write(this.actionurl, 1);
        String str = this.downloadurl;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.appid;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.actiontype, 4);
        String str3 = this.icon;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        jceOutputStream.write(this.icon_width, 6);
        jceOutputStream.write(this.icon_height, 7);
        jceOutputStream.write(this.show_link_color, 8);
        String str4 = this.icon_token;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        String str5 = this.text_color;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        String str6 = this.night_text_color;
        if (str6 != null) {
            jceOutputStream.write(str6, 11);
        }
    }

    public cell_refer(String str, String str2, String str3, String str4, int i3, String str5, int i16, int i17, boolean z16, String str6, String str7, String str8) {
        this.appname = str;
        this.actionurl = str2;
        this.downloadurl = str3;
        this.appid = str4;
        this.actiontype = i3;
        this.icon = str5;
        this.icon_width = i16;
        this.icon_height = i17;
        this.show_link_color = z16;
        this.icon_token = str6;
        this.text_color = str7;
        this.night_text_color = str8;
    }
}
