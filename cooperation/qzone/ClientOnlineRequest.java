package cooperation.qzone;

import QzoneCombine.ClientOnlineNotfiyReq;
import com.qq.taf.jce.JceStruct;
import common.config.service.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class ClientOnlineRequest extends QzoneExternalRequest {
    ClientOnlineNotfiyReq req;

    public ClientOnlineRequest(long j3, byte[] bArr) {
        this.needCompress = false;
        this.req = new ClientOnlineNotfiyReq(bArr, j3);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService." + uniKey();
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    protected byte[] getEncodedUniParameter() {
        return d.b(this.req);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "MqqOnlineNtf";
    }
}
