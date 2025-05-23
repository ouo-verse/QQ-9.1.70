package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MobileQbossReportExceptionRsp extends JceStruct {
    public int iRet;

    public MobileQbossReportExceptionRsp() {
        this.iRet = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
    }

    public MobileQbossReportExceptionRsp(int i3) {
        this.iRet = i3;
    }
}
