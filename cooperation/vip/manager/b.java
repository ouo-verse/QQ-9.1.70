package cooperation.vip.manager;

import GIFT_MALL_PROTOCOL.doufu_piece_req;
import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends QzoneExternalRequest {

    /* renamed from: d, reason: collision with root package name */
    private doufu_piece_req f391283d;

    public b(long j3, Map<String, String> map) {
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        this.needCompress = false;
        this.f391283d = new doufu_piece_req(j3, map);
    }

    public static doufu_piece_rsp a(byte[] bArr, int[] iArr) {
        doufu_piece_rsp doufu_piece_rspVar;
        if (bArr == null || (doufu_piece_rspVar = (doufu_piece_rsp) QzoneExternalRequest.decode(bArr, "getDofuPieceInfo", iArr)) == null) {
            return null;
        }
        return doufu_piece_rspVar;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.getDofuPieceInfo";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.f391283d;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getDofuPieceInfo";
    }
}
