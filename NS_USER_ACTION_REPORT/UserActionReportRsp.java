package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserActionReportRsp extends JceStruct {
    static ArrayList<String> cache_trace_details;
    public long report_interval;
    public int ret_code;
    public String ret_msg;
    public ArrayList<String> trace_details;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_trace_details = arrayList;
        arrayList.add("");
    }

    public UserActionReportRsp() {
        this.ret_code = 0;
        this.ret_msg = "";
        this.trace_details = null;
        this.report_interval = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.ret_msg = jceInputStream.readString(1, false);
        this.trace_details = (ArrayList) jceInputStream.read((JceInputStream) cache_trace_details, 2, false);
        this.report_interval = jceInputStream.read(this.report_interval, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.ret_msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<String> arrayList = this.trace_details;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.report_interval, 3);
    }

    public UserActionReportRsp(int i3, String str, ArrayList<String> arrayList, long j3) {
        this.ret_code = i3;
        this.ret_msg = str;
        this.trace_details = arrayList;
        this.report_interval = j3;
    }
}
