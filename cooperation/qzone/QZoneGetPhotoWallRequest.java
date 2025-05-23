package cooperation.qzone;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_req;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes28.dex */
public class QZoneGetPhotoWallRequest extends QzoneExternalRequest {
    private static final String CMD_PHOTO_WALL_REQUEST = "QzoneNewService.getPhotoWall";
    public static final String KEY_PHOTO_WALL_REQ = "getPhotoWall";
    public JceStruct req;

    public QZoneGetPhotoWallRequest(long j3, long j16, String str) {
        super.setHostUin(j3);
        super.setLoginUserId(j16);
        mobile_sub_get_photo_wall_req mobile_sub_get_photo_wall_reqVar = new mobile_sub_get_photo_wall_req();
        mobile_sub_get_photo_wall_reqVar.uin = j3;
        mobile_sub_get_photo_wall_reqVar.attachInfo = str;
        this.req = mobile_sub_get_photo_wall_reqVar;
    }

    public static JceStruct decodePhotoWallResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return QzoneExternalRequest.decode(bArr, KEY_PHOTO_WALL_REQ);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return CMD_PHOTO_WALL_REQUEST;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return KEY_PHOTO_WALL_REQ;
    }
}
