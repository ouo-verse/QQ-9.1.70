package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetOnlineInfoReq extends JceStruct {
    public boolean bReqCustomOnlineStatus;
    public long dwReqType;
    public long dwUin;
    public String strMobile;
    public long version;

    public GetOnlineInfoReq() {
        this.dwReqType = 0L;
        this.dwUin = 0L;
        this.strMobile = "";
        this.version = 0L;
        this.bReqCustomOnlineStatus = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwReqType = jceInputStream.read(this.dwReqType, 0, true);
        this.dwUin = jceInputStream.read(this.dwUin, 1, false);
        this.strMobile = jceInputStream.readString(2, false);
        this.version = jceInputStream.read(this.version, 3, false);
        this.bReqCustomOnlineStatus = jceInputStream.read(this.bReqCustomOnlineStatus, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwReqType, 0);
        jceOutputStream.write(this.dwUin, 1);
        String str = this.strMobile;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.version, 3);
        jceOutputStream.write(this.bReqCustomOnlineStatus, 4);
    }

    public GetOnlineInfoReq(long j3, long j16, String str, long j17, boolean z16) {
        this.dwReqType = j3;
        this.dwUin = j16;
        this.strMobile = str;
        this.version = j17;
        this.bReqCustomOnlineStatus = z16;
    }
}
