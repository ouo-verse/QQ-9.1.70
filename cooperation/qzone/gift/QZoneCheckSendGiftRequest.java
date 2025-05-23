package cooperation.qzone.gift;

import NS_MOBILE_TEMPLATE_GIFT.template_gift_get_send_status_req;
import NS_MOBILE_TEMPLATE_GIFT.template_gift_get_send_status_rsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneCheckSendGiftRequest extends QzoneExternalRequest {
    public static String CMD = "getGiftSendUins";
    public static String PRE_CMD = "QzoneNewService.";
    public JceStruct req;

    public QZoneCheckSendGiftRequest(long j3, ArrayList<Long> arrayList, Map<String, String> map) {
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        this.req = new template_gift_get_send_status_req(j3, arrayList, map);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return PRE_CMD + CMD;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD;
    }

    public static template_gift_get_send_status_rsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        JceStruct decode = QzoneExternalRequest.decode(bArr, CMD);
        if (decode instanceof template_gift_get_send_status_rsp) {
            return (template_gift_get_send_status_rsp) decode;
        }
        return null;
    }
}
