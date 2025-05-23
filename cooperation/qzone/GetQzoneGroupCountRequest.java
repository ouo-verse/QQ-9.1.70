package cooperation.qzone;

import NS_GROUP_COUNT.mobile_group_count_req;
import NS_GROUP_COUNT.mobile_group_count_rsp;
import com.qq.taf.jce.JceStruct;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class GetQzoneGroupCountRequest extends QzoneExternalRequest {
    public static final String CMD_STRING = "Feeds.getgroupcount";
    private static final String unikey = "getgroupcount";
    private mobile_group_count_req req;

    public GetQzoneGroupCountRequest(long j3, long j16, Map<String, String> map) {
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        this.needCompress = false;
        this.req = new mobile_group_count_req(j16, map);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.Feeds.getgroupcount";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return unikey;
    }

    public static mobile_group_count_rsp onResponse(byte[] bArr, int[] iArr) {
        mobile_group_count_rsp mobile_group_count_rspVar;
        if (bArr == null || (mobile_group_count_rspVar = (mobile_group_count_rsp) QzoneExternalRequest.decode(bArr, unikey, iArr)) == null) {
            return null;
        }
        return mobile_group_count_rspVar;
    }
}
