package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsGetMsgRsp extends JceStruct {
    public String busi_logo;
    public String busi_name;
    public int calendar;
    public String content;
    public String err_str;
    public String jump_url;
    public long notice_time;
    public int ret_code;
    public String sub_content;
    public String title;
    public int type;

    public AcsGetMsgRsp() {
        this.ret_code = 0;
        this.err_str = "";
        this.content = "";
        this.notice_time = 0L;
        this.type = 0;
        this.busi_name = "";
        this.busi_logo = "";
        this.sub_content = "";
        this.calendar = 0;
        this.jump_url = "";
        this.title = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.err_str = jceInputStream.readString(1, false);
        this.content = jceInputStream.readString(2, false);
        this.notice_time = jceInputStream.read(this.notice_time, 3, false);
        this.type = jceInputStream.read(this.type, 4, false);
        this.busi_name = jceInputStream.readString(5, false);
        this.busi_logo = jceInputStream.readString(6, false);
        this.sub_content = jceInputStream.readString(7, false);
        this.calendar = jceInputStream.read(this.calendar, 8, false);
        this.jump_url = jceInputStream.readString(9, false);
        this.title = jceInputStream.readString(10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.err_str;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.notice_time, 3);
        jceOutputStream.write(this.type, 4);
        String str3 = this.busi_name;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.busi_logo;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        String str5 = this.sub_content;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.calendar, 8);
        String str6 = this.jump_url;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        String str7 = this.title;
        if (str7 != null) {
            jceOutputStream.write(str7, 10);
        }
    }

    public AcsGetMsgRsp(int i3, String str, String str2, long j3, int i16, String str3, String str4, String str5, int i17, String str6, String str7) {
        this.ret_code = i3;
        this.err_str = str;
        this.content = str2;
        this.notice_time = j3;
        this.type = i16;
        this.busi_name = str3;
        this.busi_logo = str4;
        this.sub_content = str5;
        this.calendar = i17;
        this.jump_url = str6;
        this.title = str7;
    }
}
