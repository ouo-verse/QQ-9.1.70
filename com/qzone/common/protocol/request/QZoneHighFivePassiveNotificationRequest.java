package com.qzone.common.protocol.request;

import NS_MOBILE_BITMAP_4TH.bmp4_set_req;
import NS_MOBILE_BITMAP_4TH.bmp4_values;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class QZoneHighFivePassiveNotificationRequest extends QZoneRequest {
    private static final String CMD_STRING = "bmp4thSet";
    private static String strBMP4CloseHBPush = "is_clapping_close_push";
    public int bitmap_id;

    public QZoneHighFivePassiveNotificationRequest(long j3, long j16) {
        super(CMD_STRING);
        this.bitmap_id = 3;
        bmp4_set_req bmp4_set_reqVar = new bmp4_set_req();
        bmp4_set_reqVar.uin = j3;
        HashMap hashMap = new HashMap();
        hashMap.put(strBMP4CloseHBPush, Long.valueOf(j16));
        bmp4_set_reqVar.map_kv = new bmp4_values(hashMap);
        bmp4_set_reqVar.bitmap_id = this.bitmap_id;
        this.req = bmp4_set_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "QzoneNewService.bmp4thSet";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
