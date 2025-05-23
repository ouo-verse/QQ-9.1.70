package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetFaceToFaceTroopMemberListReq extends JceStruct {
    public long dwReqType;
    public long dwUin;
    public String strMobile;

    public GetFaceToFaceTroopMemberListReq() {
        this.dwReqType = 0L;
        this.dwUin = 0L;
        this.strMobile = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwReqType = jceInputStream.read(this.dwReqType, 0, true);
        this.dwUin = jceInputStream.read(this.dwUin, 1, false);
        this.strMobile = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwReqType, 0);
        jceOutputStream.write(this.dwUin, 1);
        String str = this.strMobile;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public GetFaceToFaceTroopMemberListReq(long j3, long j16, String str) {
        this.dwReqType = j3;
        this.dwUin = j16;
        this.strMobile = str;
    }
}
