package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQStayTimeInfo extends JceStruct {
    public long enter_time;
    public String page_info;
    public String page_info_ext;
    public String path_desc;
    public long report_time;
    public long stay_time;

    public QQStayTimeInfo() {
        this.report_time = 0L;
        this.page_info = "";
        this.page_info_ext = "";
        this.path_desc = "";
        this.enter_time = 0L;
        this.stay_time = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.report_time = jceInputStream.read(this.report_time, 0, true);
        this.page_info = jceInputStream.readString(1, true);
        this.page_info_ext = jceInputStream.readString(2, false);
        this.path_desc = jceInputStream.readString(3, false);
        this.enter_time = jceInputStream.read(this.enter_time, 4, true);
        this.stay_time = jceInputStream.read(this.stay_time, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.report_time, 0);
        jceOutputStream.write(this.page_info, 1);
        String str = this.page_info_ext;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.path_desc;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.enter_time, 4);
        jceOutputStream.write(this.stay_time, 5);
    }

    public QQStayTimeInfo(long j3, String str, String str2, String str3, long j16, long j17) {
        this.report_time = j3;
        this.page_info = str;
        this.page_info_ext = str2;
        this.path_desc = str3;
        this.enter_time = j16;
        this.stay_time = j17;
    }
}
