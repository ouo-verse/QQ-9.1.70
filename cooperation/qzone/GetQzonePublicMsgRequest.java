package cooperation.qzone;

import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_req;
import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import com.qq.taf.jce.JceStruct;
import java.util.Map;

/* loaded from: classes38.dex */
public class GetQzonePublicMsgRequest extends QzoneExternalRequest {
    private static final String unikey = "getQzonePublicMsg";
    mobile_get_qzone_public_msg_req req;

    public GetQzonePublicMsgRequest(long j3, Map<String, String> map) {
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        this.needCompress = false;
        this.req = new mobile_get_qzone_public_msg_req(j3, map);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService." + uniKey();
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return unikey;
    }

    public static mobile_get_qzone_public_msg_rsp onResponse(byte[] bArr, int[] iArr) {
        mobile_get_qzone_public_msg_rsp mobile_get_qzone_public_msg_rspVar;
        if (bArr == null || (mobile_get_qzone_public_msg_rspVar = (mobile_get_qzone_public_msg_rsp) QzoneExternalRequest.decode(bArr, unikey, iArr)) == null) {
            return null;
        }
        return mobile_get_qzone_public_msg_rspVar;
    }
}
