package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReportPayFailedReq extends JceStruct {
    public int iErrorCode;
    public int iSrc;
    public int iStep;
    public String sAid;
    public String sQua;
    public String sReason;
    public long uiUin;

    public ReportPayFailedReq() {
        this.sAid = "";
        this.sQua = "";
        this.sReason = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sAid = jceInputStream.readString(0, true);
        this.uiUin = jceInputStream.read(this.uiUin, 1, true);
        this.sQua = jceInputStream.readString(2, false);
        this.iSrc = jceInputStream.read(this.iSrc, 3, false);
        this.iStep = jceInputStream.read(this.iStep, 4, false);
        this.iErrorCode = jceInputStream.read(this.iErrorCode, 5, false);
        this.sReason = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sAid, 0);
        jceOutputStream.write(this.uiUin, 1);
        String str = this.sQua;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.iSrc, 3);
        jceOutputStream.write(this.iStep, 4);
        jceOutputStream.write(this.iErrorCode, 5);
        String str2 = this.sReason;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
    }

    public ReportPayFailedReq(String str, long j3, String str2, int i3, int i16, int i17, String str3) {
        this.sAid = str;
        this.uiUin = j3;
        this.sQua = str2;
        this.iSrc = i3;
        this.iStep = i16;
        this.iErrorCode = i17;
        this.sReason = str3;
    }
}
