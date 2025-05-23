package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.SortPicReq;
import NS_MOBILE_PHOTO.SortPicRsp;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes39.dex */
public class QZoneSetPhotoListSortTypeRequest extends AbsCompatRequest<SortPicRsp> {
    private static final String CMD_STRING = "asy_photo.SortPic";
    private static final String TAG = "QZoneSetPhotoListSortTypeRequest";
    private static final String UIN_KEY = "SortPic";

    public QZoneSetPhotoListSortTypeRequest(long j3, String str, int i3) {
        super(CMD_STRING);
        super.setHostUin(j3);
        SortPicReq sortPicReq = new SortPicReq();
        sortPicReq.uin = j3;
        sortPicReq.albumid = str;
        sortPicReq.sort_type = i3;
        this.req = sortPicReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public SortPicRsp onJceRespParse(JceStruct jceStruct) throws Exception {
        return null;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UIN_KEY;
    }
}
