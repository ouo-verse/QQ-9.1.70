package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReportExceptionInfo extends JceStruct {
    static int cache_iCode;
    public int iAppid;
    public int iCode;
    public int iTaskId;
    public String strMsg;

    public ReportExceptionInfo() {
        this.iAppid = 0;
        this.iTaskId = 0;
        this.iCode = 0;
        this.strMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iAppid = jceInputStream.read(this.iAppid, 0, false);
        this.iTaskId = jceInputStream.read(this.iTaskId, 1, false);
        this.iCode = jceInputStream.read(this.iCode, 2, false);
        this.strMsg = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iAppid, 0);
        jceOutputStream.write(this.iTaskId, 1);
        jceOutputStream.write(this.iCode, 2);
        String str = this.strMsg;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public ReportExceptionInfo(int i3, int i16, int i17, String str) {
        this.iAppid = i3;
        this.iTaskId = i16;
        this.iCode = i17;
        this.strMsg = str;
    }
}
