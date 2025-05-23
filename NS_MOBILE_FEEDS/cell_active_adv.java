package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_active_adv extends JceStruct {
    static s_picdata cache_picdata = new s_picdata();
    public int button_actiontype;
    public String button_text;
    public String copy;
    public String copy_actionturl;
    public int copy_actiontype;
    public int is_report;
    public int mediatype;
    public int pic_actiontype;
    public String pic_actionurl;
    public s_picdata picdata;
    public String report_url;
    public String up_copy;
    public int up_copy_actiontype;

    public cell_active_adv() {
        this.pic_actiontype = -1;
        this.pic_actionurl = "";
        this.copy = "";
        this.copy_actionturl = "";
        this.button_text = "";
        this.up_copy = "";
        this.report_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mediatype = jceInputStream.read(this.mediatype, 0, false);
        this.picdata = (s_picdata) jceInputStream.read((JceStruct) cache_picdata, 1, false);
        this.pic_actiontype = jceInputStream.read(this.pic_actiontype, 2, false);
        this.pic_actionurl = jceInputStream.readString(3, false);
        this.copy = jceInputStream.readString(4, false);
        this.copy_actiontype = jceInputStream.read(this.copy_actiontype, 5, false);
        this.copy_actionturl = jceInputStream.readString(6, false);
        this.button_text = jceInputStream.readString(7, false);
        this.button_actiontype = jceInputStream.read(this.button_actiontype, 8, false);
        this.up_copy = jceInputStream.readString(9, false);
        this.up_copy_actiontype = jceInputStream.read(this.up_copy_actiontype, 10, false);
        this.is_report = jceInputStream.read(this.is_report, 11, false);
        this.report_url = jceInputStream.readString(12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mediatype, 0);
        s_picdata s_picdataVar = this.picdata;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 1);
        }
        jceOutputStream.write(this.pic_actiontype, 2);
        String str = this.pic_actionurl;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.copy;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.copy_actiontype, 5);
        String str3 = this.copy_actionturl;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.button_text;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        jceOutputStream.write(this.button_actiontype, 8);
        String str5 = this.up_copy;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        jceOutputStream.write(this.up_copy_actiontype, 10);
        jceOutputStream.write(this.is_report, 11);
        String str6 = this.report_url;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
    }

    public cell_active_adv(int i3, s_picdata s_picdataVar, int i16, String str, String str2, int i17, String str3, String str4, int i18, String str5, int i19, int i26, String str6) {
        this.mediatype = i3;
        this.picdata = s_picdataVar;
        this.pic_actiontype = i16;
        this.pic_actionurl = str;
        this.copy = str2;
        this.copy_actiontype = i17;
        this.copy_actionturl = str3;
        this.button_text = str4;
        this.button_actiontype = i18;
        this.up_copy = str5;
        this.up_copy_actiontype = i19;
        this.is_report = i26;
        this.report_url = str6;
    }
}
