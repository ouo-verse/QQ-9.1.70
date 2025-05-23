package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TraceInfo extends JceStruct {
    public String trace_detail;
    public String trace_id;
    public String trace_index;
    public long trace_num;

    public TraceInfo() {
        this.trace_id = "";
        this.trace_num = 0L;
        this.trace_detail = "";
        this.trace_index = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.trace_id = jceInputStream.readString(0, true);
        this.trace_num = jceInputStream.read(this.trace_num, 1, true);
        this.trace_detail = jceInputStream.readString(2, false);
        this.trace_index = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.trace_id, 0);
        jceOutputStream.write(this.trace_num, 1);
        String str = this.trace_detail;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.trace_index;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
    }

    public TraceInfo(String str, long j3, String str2, String str3) {
        this.trace_id = str;
        this.trace_num = j3;
        this.trace_detail = str2;
        this.trace_index = str3;
    }
}
