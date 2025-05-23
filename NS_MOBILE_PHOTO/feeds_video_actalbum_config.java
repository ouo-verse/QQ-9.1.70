package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class feeds_video_actalbum_config extends JceStruct {
    public String banner_btn_title;
    public String banner_main_title;
    public String banner_sub_title;
    public String banner_title;
    public String fscreen_btn_title;
    public String fscreen_jump_h5;
    public String fscreen_sub_title;
    public String fscreen_title;

    public feeds_video_actalbum_config() {
        this.banner_title = "";
        this.banner_main_title = "";
        this.banner_sub_title = "";
        this.banner_btn_title = "";
        this.fscreen_title = "";
        this.fscreen_sub_title = "";
        this.fscreen_jump_h5 = "";
        this.fscreen_btn_title = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.banner_title = jceInputStream.readString(0, false);
        this.banner_main_title = jceInputStream.readString(1, false);
        this.banner_sub_title = jceInputStream.readString(2, false);
        this.banner_btn_title = jceInputStream.readString(3, false);
        this.fscreen_title = jceInputStream.readString(4, false);
        this.fscreen_sub_title = jceInputStream.readString(5, false);
        this.fscreen_jump_h5 = jceInputStream.readString(6, false);
        this.fscreen_btn_title = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.banner_title;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.banner_main_title;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.banner_sub_title;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.banner_btn_title;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.fscreen_title;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.fscreen_sub_title;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        String str7 = this.fscreen_jump_h5;
        if (str7 != null) {
            jceOutputStream.write(str7, 6);
        }
        String str8 = this.fscreen_btn_title;
        if (str8 != null) {
            jceOutputStream.write(str8, 7);
        }
    }

    public feeds_video_actalbum_config(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.banner_title = str;
        this.banner_main_title = str2;
        this.banner_sub_title = str3;
        this.banner_btn_title = str4;
        this.fscreen_title = str5;
        this.fscreen_sub_title = str6;
        this.fscreen_jump_h5 = str7;
        this.fscreen_btn_title = str8;
    }
}
