package cooperation.qzone;

import NS_MOBILE_PHOTO.get_albumlist_num_req;
import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneGetAlbumListNumRequest extends QzoneExternalRequest {
    public static final String CMD_STRING = "getAlbumListNum";
    private static final String CMD_STRING_BUFFER = "QzoneNewService.getAlbumListNum";
    public static final String KEY_GET_ALBUM_LIST_NUM = "getAlbumListNum";
    private static final String unikey = "getAlbumListNum";
    public JceStruct req;

    public QZoneGetAlbumListNumRequest(long j3, String str) {
        super.setRefer(str);
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        get_albumlist_num_req get_albumlist_num_reqVar = new get_albumlist_num_req();
        get_albumlist_num_reqVar.uin = j3;
        this.req = get_albumlist_num_reqVar;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return CMD_STRING_BUFFER;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getAlbumListNum";
    }

    public static get_albumlist_num_rsp onResponse(byte[] bArr) {
        get_albumlist_num_rsp get_albumlist_num_rspVar;
        if (bArr == null || (get_albumlist_num_rspVar = (get_albumlist_num_rsp) QzoneExternalRequest.decode(bArr, "getAlbumListNum")) == null) {
            return null;
        }
        return get_albumlist_num_rspVar;
    }
}
