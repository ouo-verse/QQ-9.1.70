package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class StFeedsReportQuicklyRsp extends JceStruct {
    public long code;
    public String errMsg;

    public StFeedsReportQuicklyRsp() {
        this.code = 0L;
        this.errMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.errMsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        String str = this.errMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public StFeedsReportQuicklyRsp(long j3, String str) {
        this.code = j3;
        this.errMsg = str;
    }
}
