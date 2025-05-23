package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsMsg extends JceStruct implements Comparable<AcsMsg> {
    public String applet_jump_url;
    public int banner_type;
    public String banner_url;
    public String btn_text;
    public String busi_icon;
    public String busi_id;
    public String busi_logo;
    public String busi_name;
    public int calendar;
    public String content;
    public String extend_field;
    public String flag_text;
    public String jump_url;
    public int mn_appid;
    public String mn_reserved;
    public String msg_id;
    public long notice_time;
    public long sub_time;
    public String title;
    public int type;

    public AcsMsg() {
        this.msg_id = "";
        this.busi_id = "";
        this.busi_name = "";
        this.busi_icon = "";
        this.sub_time = 0L;
        this.type = 0;
        this.flag_text = "";
        this.btn_text = "";
        this.title = "";
        this.content = "";
        this.notice_time = 0L;
        this.banner_url = "";
        this.jump_url = "";
        this.applet_jump_url = "";
        this.banner_type = 0;
        this.mn_appid = 0;
        this.mn_reserved = "";
        this.busi_logo = "";
        this.calendar = 0;
        this.extend_field = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.msg_id = jceInputStream.readString(0, false);
        this.busi_id = jceInputStream.readString(1, false);
        this.busi_name = jceInputStream.readString(2, false);
        this.busi_icon = jceInputStream.readString(3, false);
        this.sub_time = jceInputStream.read(this.sub_time, 4, false);
        this.type = jceInputStream.read(this.type, 5, false);
        this.flag_text = jceInputStream.readString(6, false);
        this.btn_text = jceInputStream.readString(7, false);
        this.title = jceInputStream.readString(8, false);
        this.content = jceInputStream.readString(9, false);
        this.notice_time = jceInputStream.read(this.notice_time, 10, false);
        this.banner_url = jceInputStream.readString(11, false);
        this.jump_url = jceInputStream.readString(12, false);
        this.applet_jump_url = jceInputStream.readString(13, false);
        this.banner_type = jceInputStream.read(this.banner_type, 14, false);
        this.mn_appid = jceInputStream.read(this.mn_appid, 15, false);
        this.mn_reserved = jceInputStream.readString(16, false);
        this.busi_logo = jceInputStream.readString(17, false);
        this.calendar = jceInputStream.read(this.calendar, 18, false);
        this.extend_field = jceInputStream.readString(19, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.msg_id;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.busi_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.busi_name;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.busi_icon;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.sub_time, 4);
        jceOutputStream.write(this.type, 5);
        String str5 = this.flag_text;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.btn_text;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.title;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        String str8 = this.content;
        if (str8 != null) {
            jceOutputStream.write(str8, 9);
        }
        jceOutputStream.write(this.notice_time, 10);
        String str9 = this.banner_url;
        if (str9 != null) {
            jceOutputStream.write(str9, 11);
        }
        String str10 = this.jump_url;
        if (str10 != null) {
            jceOutputStream.write(str10, 12);
        }
        String str11 = this.applet_jump_url;
        if (str11 != null) {
            jceOutputStream.write(str11, 13);
        }
        jceOutputStream.write(this.banner_type, 14);
        jceOutputStream.write(this.mn_appid, 15);
        String str12 = this.mn_reserved;
        if (str12 != null) {
            jceOutputStream.write(str12, 16);
        }
        String str13 = this.busi_logo;
        if (str13 != null) {
            jceOutputStream.write(str13, 17);
        }
        jceOutputStream.write(this.calendar, 18);
        String str14 = this.extend_field;
        if (str14 != null) {
            jceOutputStream.write(str14, 19);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(AcsMsg acsMsg) {
        int[] iArr = {JceUtil.compareTo(this.notice_time, acsMsg.notice_time)};
        for (int i3 = 0; i3 < 1; i3++) {
            int i16 = iArr[i3];
            if (i16 != 0) {
                return i16;
            }
        }
        return 0;
    }

    public AcsMsg(String str, String str2, String str3, String str4, long j3, int i3, String str5, String str6, String str7, String str8, long j16, String str9, String str10, String str11, int i16, int i17, String str12, String str13, int i18, String str14) {
        this.msg_id = str;
        this.busi_id = str2;
        this.busi_name = str3;
        this.busi_icon = str4;
        this.sub_time = j3;
        this.type = i3;
        this.flag_text = str5;
        this.btn_text = str6;
        this.title = str7;
        this.content = str8;
        this.notice_time = j16;
        this.banner_url = str9;
        this.jump_url = str10;
        this.applet_jump_url = str11;
        this.banner_type = i16;
        this.mn_appid = i17;
        this.mn_reserved = str12;
        this.busi_logo = str13;
        this.calendar = i18;
        this.extend_field = str14;
    }
}
