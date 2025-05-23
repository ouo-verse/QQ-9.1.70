package cooperation.qzone;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_del_photo_wall_req;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* loaded from: classes28.dex */
public class QZoneDelPhotoWallRequest extends QzoneExternalRequest {
    private static final String CMD_DEL_PHOTO_WALL_REQUEST = "QzoneNewService.delPhotoWall";
    public static final String KEY_DEL_PHOTO_WALL_REQ = "delPhotoWall";
    public JceStruct req;

    public QZoneDelPhotoWallRequest(long j3, long j16, String str, Long l3) {
        super.setHostUin(j3);
        super.setLoginUserId(j16);
        mobile_sub_del_photo_wall_req mobile_sub_del_photo_wall_reqVar = new mobile_sub_del_photo_wall_req();
        PhotoWall photoWall = new PhotoWall();
        photoWall.photoId = str;
        photoWall.ctime = l3.longValue();
        ArrayList<PhotoWall> arrayList = new ArrayList<>();
        mobile_sub_del_photo_wall_reqVar.vecUrls = arrayList;
        arrayList.add(photoWall);
        this.req = mobile_sub_del_photo_wall_reqVar;
    }

    public static JceStruct decodeDelResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return QzoneExternalRequest.decode(bArr, KEY_DEL_PHOTO_WALL_REQ);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return CMD_DEL_PHOTO_WALL_REQUEST;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return KEY_DEL_PHOTO_WALL_REQ;
    }
}
