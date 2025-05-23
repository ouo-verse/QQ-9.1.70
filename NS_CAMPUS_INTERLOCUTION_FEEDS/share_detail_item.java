package NS_CAMPUS_INTERLOCUTION_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class share_detail_item extends JceStruct {
    public int action_type;
    public String action_url;
    public long answer_num;
    public String content;
    public String module_name;
    public String nick;
    public String optype;
    public String pic_url;
    public String portrait;
    public String school_name;
    public String share_content;
    public int type;
    public long uin;
    public long user_type;
    public long visit_num;

    public share_detail_item() {
        this.action_type = 0;
        this.action_url = "";
        this.type = 0;
        this.pic_url = "";
        this.uin = 0L;
        this.nick = "";
        this.optype = "";
        this.content = "";
        this.visit_num = 0L;
        this.answer_num = 0L;
        this.portrait = "";
        this.user_type = 0L;
        this.school_name = "";
        this.module_name = "";
        this.share_content = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.action_type = jceInputStream.read(this.action_type, 0, true);
        this.action_url = jceInputStream.readString(1, true);
        this.type = jceInputStream.read(this.type, 2, true);
        this.pic_url = jceInputStream.readString(3, true);
        this.uin = jceInputStream.read(this.uin, 10, false);
        this.nick = jceInputStream.readString(11, false);
        this.optype = jceInputStream.readString(12, false);
        this.content = jceInputStream.readString(13, false);
        this.visit_num = jceInputStream.read(this.visit_num, 14, false);
        this.answer_num = jceInputStream.read(this.answer_num, 15, false);
        this.portrait = jceInputStream.readString(16, false);
        this.user_type = jceInputStream.read(this.user_type, 17, false);
        this.school_name = jceInputStream.readString(20, false);
        this.module_name = jceInputStream.readString(21, false);
        this.share_content = jceInputStream.readString(30, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.action_type, 0);
        jceOutputStream.write(this.action_url, 1);
        jceOutputStream.write(this.type, 2);
        jceOutputStream.write(this.pic_url, 3);
        jceOutputStream.write(this.uin, 10);
        String str = this.nick;
        if (str != null) {
            jceOutputStream.write(str, 11);
        }
        String str2 = this.optype;
        if (str2 != null) {
            jceOutputStream.write(str2, 12);
        }
        String str3 = this.content;
        if (str3 != null) {
            jceOutputStream.write(str3, 13);
        }
        jceOutputStream.write(this.visit_num, 14);
        jceOutputStream.write(this.answer_num, 15);
        String str4 = this.portrait;
        if (str4 != null) {
            jceOutputStream.write(str4, 16);
        }
        jceOutputStream.write(this.user_type, 17);
        String str5 = this.school_name;
        if (str5 != null) {
            jceOutputStream.write(str5, 20);
        }
        String str6 = this.module_name;
        if (str6 != null) {
            jceOutputStream.write(str6, 21);
        }
        String str7 = this.share_content;
        if (str7 != null) {
            jceOutputStream.write(str7, 30);
        }
    }

    public share_detail_item(int i3, String str, int i16, String str2, long j3, String str3, String str4, String str5, long j16, long j17, String str6, long j18, String str7, String str8, String str9) {
        this.action_type = i3;
        this.action_url = str;
        this.type = i16;
        this.pic_url = str2;
        this.uin = j3;
        this.nick = str3;
        this.optype = str4;
        this.content = str5;
        this.visit_num = j16;
        this.answer_num = j17;
        this.portrait = str6;
        this.user_type = j18;
        this.school_name = str7;
        this.module_name = str8;
        this.share_content = str9;
    }
}
