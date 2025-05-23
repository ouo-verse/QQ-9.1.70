package com.qzone.commoncode.module.videorecommend.model;

import NS_MOBILE_BITMAP_4TH.bmp4_get_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class QzoneIsPublicRequest extends QZoneRequest {
    private static final String CMD_STRING = "bmp4thGet";
    public static final long QZONE_NO_PUBLIC = 1;
    public static final long QZONE_PUBLIC = 0;
    public static final String STR_BMP4_IS_QZONE_PUBLIC = "is_qzone_public";
    private int bitmapId;

    public QzoneIsPublicRequest(long j3) {
        super(CMD_STRING);
        this.bitmapId = 1;
        bmp4_get_req bmp4_get_reqVar = new bmp4_get_req();
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j3));
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(STR_BMP4_IS_QZONE_PUBLIC);
        bmp4_get_reqVar.vec_uins = arrayList;
        bmp4_get_reqVar.vec_keys = arrayList2;
        bmp4_get_reqVar.bitmap_id = this.bitmapId;
        this.req = bmp4_get_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "QzoneNewService.bmp4thGet";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
