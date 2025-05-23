package cooperation.qzone.patch;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_REQ;
import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.os.Build;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.config.AppSetting;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

/* loaded from: classes38.dex */
public class QZonePatchRequest extends QzoneExternalRequest {
    private static final String UNIKEY = "mqBatchUpdate";
    public JceStruct req;

    public QZonePatchRequest(long j3, ArrayList<UPDATE_INFO> arrayList, ArrayList<UPDATE_INFO> arrayList2) {
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        SQ_CLIENT_UPDATE_REQ sq_client_update_req = new SQ_CLIENT_UPDATE_REQ();
        sq_client_update_req.qua = QUA.getQUA3();
        sq_client_update_req.version = AppSetting.n();
        sq_client_update_req.apiLevel = Build.VERSION.SDK_INT;
        sq_client_update_req.triggerType = 1;
        sq_client_update_req.vPlugin = arrayList;
        sq_client_update_req.vModule = arrayList2;
        this.req = sq_client_update_req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.update.mqBatchUpdate";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNIKEY;
    }

    public static SQ_CLIENT_UPDATE_RSP onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        JceStruct decode = QzoneExternalRequest.decode(bArr, UNIKEY);
        if (decode instanceof SQ_CLIENT_UPDATE_RSP) {
            return (SQ_CLIENT_UPDATE_RSP) decode;
        }
        return null;
    }
}
