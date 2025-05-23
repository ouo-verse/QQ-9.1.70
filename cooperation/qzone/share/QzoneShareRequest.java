package cooperation.qzone.share;

import NS_MOBILE_OPERATION.operation_forward_req;
import NS_MOBILE_OPERATION.operation_forward_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneShareRequest extends QzoneExternalRequest {
    private static final String CMD_STRING = "forward";
    public JceStruct req;

    public QzoneShareRequest(String str, String str2, int i3, long j3, String str3, String str4, String str5, ArrayList<String> arrayList, long j16, String str6, int i16, Map<String, String> map, Map<String, String> map2) {
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        operation_forward_req operation_forward_reqVar = new operation_forward_req();
        if (j16 != 0) {
            operation_forward_reqVar.subid = (int) j16;
        }
        String str7 = str == null ? "" : str;
        if (str2 != null) {
            operation_forward_reqVar.srcId = str2;
        }
        if (i3 > 0) {
            operation_forward_reqVar.appid = i3;
        }
        operation_forward_reqVar.uin = j3;
        if (j3 > 0) {
            operation_forward_reqVar.ownUin = j3;
        }
        if (str3 != null) {
            if (str3.length() > 200) {
                operation_forward_reqVar.srcTitle = str3.substring(0, 200);
            } else {
                operation_forward_reqVar.srcTitle = str3;
            }
        }
        if (str4 != null) {
            if (str4.length() > 600) {
                operation_forward_reqVar.srcAbstract = str4.substring(0, 600);
            } else {
                operation_forward_reqVar.srcAbstract = str4;
            }
        }
        if (str5 != null) {
            if (str5.length() > 1500) {
                operation_forward_reqVar.reason = str5.substring(0, 1500);
            } else {
                operation_forward_reqVar.reason = str5;
            }
        }
        if (arrayList != null && arrayList.size() > 9) {
            if (operation_forward_reqVar.srcImages == null) {
                operation_forward_reqVar.srcImages = new ArrayList<>();
            }
            for (int i17 = 0; i17 < 9; i17++) {
                operation_forward_reqVar.srcImages.add(arrayList.get(i17));
            }
        } else {
            operation_forward_reqVar.srcImages = arrayList;
        }
        operation_forward_reqVar.operatemask = 4;
        if (operation_forward_reqVar.busi_param == null) {
            operation_forward_reqVar.busi_param = new HashMap();
        }
        operation_forward_reqVar.busi_param.put(43, str7);
        if (!TextUtils.isEmpty(str6)) {
            operation_forward_reqVar.busi_param.put(79, str6);
        }
        operation_forward_reqVar.iUrlInfoFrm = i16;
        operation_forward_reqVar.xcxMapEx = map;
        operation_forward_reqVar.stored_extend_info = map2;
        this.req = operation_forward_reqVar;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.forward";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public static operation_forward_rsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        JceStruct decode = QzoneExternalRequest.decode(bArr, CMD_STRING);
        if (decode instanceof operation_forward_rsp) {
            return (operation_forward_rsp) decode;
        }
        return null;
    }
}
