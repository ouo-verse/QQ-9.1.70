package ELABORATE_FEED_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class elaborate_feed_report_rsp extends JceStruct {
    public int iRetCode;
    public String strErrorMsg;

    public elaborate_feed_report_rsp() {
        this.strErrorMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRetCode = jceInputStream.read(this.iRetCode, 0, false);
        this.strErrorMsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRetCode, 0);
        String str = this.strErrorMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public elaborate_feed_report_rsp(int i3, String str) {
        this.iRetCode = i3;
        this.strErrorMsg = str;
    }
}
