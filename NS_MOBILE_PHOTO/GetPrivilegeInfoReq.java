package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class GetPrivilegeInfoReq extends JceStruct {
    static int cache_req_type;
    public int req_type;

    public GetPrivilegeInfoReq() {
        this.req_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.req_type = jceInputStream.read(this.req_type, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.req_type, 0);
    }

    public GetPrivilegeInfoReq(int i3) {
        this.req_type = i3;
    }
}
