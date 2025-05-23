package cooperation.qzone.media;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import cooperation.qzone.video.QzoneVideoBeaconReport;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum QZoneMediaBusiness {
    QZONE_PANEL_ALBUM("qzone_panel_album"),
    QZONE_PANEL_CAMERA("qzone_panel_camera"),
    QZONE_MYSHUOSHUO_LIST_PHOTO("qzone_myshuoshuo_list_photo"),
    QZONE_MYSHUOSHUO_LIST_VIDEO("qzone_myshuoshuo_list_video"),
    QZONE_SHUOSHUO_UPLOAD_PIC("qzone_shuoshuo_upload_pic"),
    QZONE_SHUOSHUO_MAKE_VIDEO("qzone_shuoshuo_makevideo"),
    QZONE_SHUOSHUO_LONGPIC("qzone_shuoshuo_longpic"),
    QZONE_ALBUM_LIST(QzoneVideoBeaconReport.EVENT_ALBUM_LIST),
    QZONE_ALBUM_LIST_ONLY_VIDEO(QzoneVideoBeaconReport.EVENT_ALBUM_LIST),
    QZONE_ALBUM_DETAIL("qzone_album_detail"),
    QZONE_ALBUM_UPLOAD_PIC("qzone_album_upload_pic"),
    QZONE_VIDEO_ALBUM("qzone_video_album"),
    QZONE_DIARY("qzone_diary"),
    QZONE_SHOUZHANG("qzone_shouzhang"),
    QZONE_COMMENT_ADD_PIC("qzone_comment_add_pic"),
    QZONE_FACE_SCANNER("qzone_face_scanner"),
    QZONE_SHUOSHUO_PERVIEW("qzone_shuoshuo_preview"),
    QZONE_ALBUM_PERVIEW("qzone_album_preview"),
    QZONE_SHUOSHUO_CAMERA("qzone_shuoshuo_camera"),
    QZONE_PUBLISH_INTIMATE_MOOD("qzone_publish_intimate_mood"),
    QZONE_INTIMATE_UPLOAD_ALBUM("qzone_intimate_upload_album"),
    QZONE_GROUP_UPLOAD_ALBUM(QQWinkConstants.REF_FROM_QZONE_ALBUM_UPLOAD),
    QZONE_GROUP_RESHIP_ALBUM(QQWinkConstants.REF_FROM_QZONE_ALBUM_RESHIP),
    QZONE_SHAISHAI_PERVIEW("qzone_shaishai_preview"),
    QZONE_ALBUMX_UPLOAD_ALBUM("qzone_albumx_upload_album"),
    QZONE_PLUS_ICON_ENTRANCE("qzone_plus_icon_entrance");

    private final String mBusinessName;

    QZoneMediaBusiness(String str) {
        this.mBusinessName = str;
    }

    public String getBusinessName() {
        return this.mBusinessName;
    }
}
