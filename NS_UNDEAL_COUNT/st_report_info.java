package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class st_report_info extends JceStruct {
    public int report_first_page;
    public int report_second_page;

    public st_report_info() {
        this.report_first_page = 0;
        this.report_second_page = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.report_first_page = jceInputStream.read(this.report_first_page, 0, false);
        this.report_second_page = jceInputStream.read(this.report_second_page, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.report_first_page, 0);
        jceOutputStream.write(this.report_second_page, 1);
    }

    public st_report_info(int i3, int i16) {
        this.report_first_page = i3;
        this.report_second_page = i16;
    }
}
