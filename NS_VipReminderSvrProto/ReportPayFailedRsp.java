package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReportPayFailedRsp extends JceStruct {
    public int iRet;
    public String sMsg;

    public ReportPayFailedRsp() {
        this.sMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, true);
        this.sMsg = jceInputStream.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        jceOutputStream.write(this.sMsg, 1);
    }

    public ReportPayFailedRsp(int i3, String str) {
        this.iRet = i3;
        this.sMsg = str;
    }
}
