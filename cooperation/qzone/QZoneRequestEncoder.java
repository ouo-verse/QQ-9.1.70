package cooperation.qzone;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_req;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneRequestEncoder extends QzoneExternalRequest {
    private static final String CMD_COVER_REQUEST = "QzoneNewService.getCover";
    public static final String KEY_COVER_REQ = "getCover";
    public JceStruct req;

    public QZoneRequestEncoder(long j3, long j16, int i3) {
        mobile_sub_get_cover_req mobile_sub_get_cover_reqVar = new mobile_sub_get_cover_req();
        mobile_sub_get_cover_reqVar.uin = j3;
        mobile_sub_get_cover_reqVar.flag = i3;
        this.req = mobile_sub_get_cover_reqVar;
        super.setHostUin(j3);
        super.setLoginUserId(j16);
    }

    public static JceStruct decodeCoverResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return QzoneExternalRequest.decode(bArr, KEY_COVER_REQ);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return CMD_COVER_REQUEST;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return KEY_COVER_REQ;
    }
}
