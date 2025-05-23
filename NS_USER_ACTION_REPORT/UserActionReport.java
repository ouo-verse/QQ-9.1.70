package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UserActionReport extends JceStruct {
    public PageInfo page_info;
    public long to_uin;
    public TraceInfo trace_info;
    static TraceInfo cache_trace_info = new TraceInfo();
    static PageInfo cache_page_info = new PageInfo();

    public UserActionReport() {
        this.trace_info = null;
        this.page_info = null;
        this.to_uin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.trace_info = (TraceInfo) jceInputStream.read((JceStruct) cache_trace_info, 0, true);
        this.page_info = (PageInfo) jceInputStream.read((JceStruct) cache_page_info, 1, true);
        this.to_uin = jceInputStream.read(this.to_uin, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.trace_info, 0);
        jceOutputStream.write((JceStruct) this.page_info, 1);
        jceOutputStream.write(this.to_uin, 2);
    }

    public UserActionReport(TraceInfo traceInfo, PageInfo pageInfo, long j3) {
        this.trace_info = traceInfo;
        this.page_info = pageInfo;
        this.to_uin = j3;
    }
}
