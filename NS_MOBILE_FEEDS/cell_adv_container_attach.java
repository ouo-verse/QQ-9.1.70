package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_adv_container_attach extends JceStruct {
    static s_picdata cache_picinfo = new s_picdata();
    public int actiontype;
    public String actionurl;
    public int is_report;
    public s_picdata picinfo;
    public String remark;
    public String report_url;

    public cell_adv_container_attach() {
        this.picinfo = null;
        this.remark = "";
        this.actiontype = 0;
        this.actionurl = "";
        this.is_report = 0;
        this.report_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picinfo = (s_picdata) jceInputStream.read((JceStruct) cache_picinfo, 0, false);
        this.remark = jceInputStream.readString(1, false);
        this.actiontype = jceInputStream.read(this.actiontype, 2, false);
        this.actionurl = jceInputStream.readString(3, false);
        this.is_report = jceInputStream.read(this.is_report, 4, false);
        this.report_url = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_picdata s_picdataVar = this.picinfo;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 0);
        }
        String str = this.remark;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.actiontype, 2);
        String str2 = this.actionurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.is_report, 4);
        String str3 = this.report_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
    }

    public cell_adv_container_attach(s_picdata s_picdataVar, String str, int i3, String str2, int i16, String str3) {
        this.picinfo = s_picdataVar;
        this.remark = str;
        this.actiontype = i3;
        this.actionurl = str2;
        this.is_report = i16;
        this.report_url = str3;
    }
}
