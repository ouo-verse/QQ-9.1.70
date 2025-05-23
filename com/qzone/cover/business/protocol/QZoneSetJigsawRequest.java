package com.qzone.cover.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_set_photo_wall_combinepic_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSetJigsawRequest extends QZoneRequest {
    public static final String CMD_STRING = "setJigsaw";

    public QZoneSetJigsawRequest(long j3, int i3) {
        super(CMD_STRING);
        mobile_sub_set_photo_wall_combinepic_req mobile_sub_set_photo_wall_combinepic_reqVar = new mobile_sub_set_photo_wall_combinepic_req();
        mobile_sub_set_photo_wall_combinepic_reqVar.uin = j3;
        mobile_sub_set_photo_wall_combinepic_reqVar.photoWallCombinePic = i3;
        this.req = mobile_sub_set_photo_wall_combinepic_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneSetJigsawRequest() {
    }
}
