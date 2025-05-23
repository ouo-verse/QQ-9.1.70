package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.share_outsite_req;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetOutShareUrlRequest extends QZoneRequest {
    public static final String CMD_STRING = "Operation.shareOutsite";
    public static final int NOT_SHUOSHUO = -1;

    public QzoneGetOutShareUrlRequest(int i3, int i16, String str, String str2, String str3, String str4, long j3, int i17, String str5, int i18) {
        super(CMD_STRING);
        share_outsite_req share_outsite_reqVar = new share_outsite_req();
        share_outsite_reqVar.albumid = str2;
        share_outsite_reqVar.appid = i3;
        share_outsite_reqVar.batchid = str4;
        share_outsite_reqVar.cellid = str;
        share_outsite_reqVar.lloc = str3;
        share_outsite_reqVar.ugc_type = i16;
        share_outsite_reqVar.uHostUin = j3;
        share_outsite_reqVar.iIsShareTo = i17;
        share_outsite_reqVar.strMd5Key = str5;
        share_outsite_reqVar.shareScene = i18;
        this.req = share_outsite_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "shareOutsite";
    }

    public QzoneGetOutShareUrlRequest(int i3, int i16, String str, String str2, String str3, String str4, long j3, int i17, String str5, int i18, Map<Integer, String> map) {
        super(CMD_STRING);
        share_outsite_req share_outsite_reqVar = new share_outsite_req();
        share_outsite_reqVar.albumid = str2;
        share_outsite_reqVar.appid = i3;
        share_outsite_reqVar.batchid = str4;
        share_outsite_reqVar.cellid = str;
        share_outsite_reqVar.lloc = str3;
        share_outsite_reqVar.ugc_type = i16;
        share_outsite_reqVar.uHostUin = j3;
        share_outsite_reqVar.iIsShareTo = i17;
        share_outsite_reqVar.strMd5Key = str5;
        share_outsite_reqVar.shareScene = i18;
        share_outsite_reqVar.busi_param = map;
        this.req = share_outsite_reqVar;
    }

    public QzoneGetOutShareUrlRequest(int i3, int i16, String str, String str2, String str3, String str4, long j3, int i17, Map<Integer, String> map) {
        super(CMD_STRING);
        share_outsite_req share_outsite_reqVar = new share_outsite_req();
        share_outsite_reqVar.albumid = str2;
        share_outsite_reqVar.appid = i3;
        share_outsite_reqVar.batchid = str4;
        share_outsite_reqVar.cellid = str;
        share_outsite_reqVar.lloc = str3;
        share_outsite_reqVar.ugc_type = i16;
        share_outsite_reqVar.uHostUin = j3;
        share_outsite_reqVar.iIsShareTo = i17;
        share_outsite_reqVar.busi_param = map;
        this.req = share_outsite_reqVar;
    }

    public QzoneGetOutShareUrlRequest(int i3, int i16, String str, String str2, String str3, String str4) {
        super(CMD_STRING);
        share_outsite_req share_outsite_reqVar = new share_outsite_req();
        share_outsite_reqVar.albumid = str2;
        share_outsite_reqVar.appid = i3;
        share_outsite_reqVar.batchid = str4;
        share_outsite_reqVar.cellid = str;
        share_outsite_reqVar.lloc = str3;
        share_outsite_reqVar.ugc_type = i16;
        this.req = share_outsite_reqVar;
    }

    public QzoneGetOutShareUrlRequest(int i3, int i16, String str, String str2, String str3, String str4, int i17, long j3, int i18, Map<Integer, String> map) {
        super(CMD_STRING);
        share_outsite_req share_outsite_reqVar = new share_outsite_req();
        share_outsite_reqVar.albumid = str2;
        share_outsite_reqVar.appid = i3;
        share_outsite_reqVar.batchid = str4;
        share_outsite_reqVar.cellid = str;
        share_outsite_reqVar.lloc = str3;
        share_outsite_reqVar.ugc_type = i16;
        share_outsite_reqVar.busi_param = map;
        share_outsite_reqVar.iIsShareTo = i17;
        share_outsite_reqVar.shareScene = i18;
        share_outsite_reqVar.uHostUin = j3;
        this.req = share_outsite_reqVar;
    }
}
