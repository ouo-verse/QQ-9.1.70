package com.qzone.publish.business.protocol;

import NS_MOBILE_QUN.qun_quote_photo_from_qzone_req;
import NS_MOBILE_QUN.s_quote_photo_info;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.util.image.NetImageInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes39.dex */
public class QZoneQuoteQunPhotoRequest extends QZoneRequest {
    private static final String CMD_STRING = "qunQuotoPhotoFromQzone";

    public QZoneQuoteQunPhotoRequest(String str, String str2, long j3, long j16, List<NetImageInfo> list, String str3, String str4, long j17) {
        super(CMD_STRING);
        qun_quote_photo_from_qzone_req qun_quote_photo_from_qzone_reqVar = new qun_quote_photo_from_qzone_req();
        qun_quote_photo_from_qzone_reqVar.qunid = str;
        qun_quote_photo_from_qzone_reqVar.albumid = str2;
        qun_quote_photo_from_qzone_reqVar.batchid = j3;
        qun_quote_photo_from_qzone_reqVar.fromUin = j16;
        qun_quote_photo_from_qzone_reqVar.clientkey = str3;
        if (list != null && !list.isEmpty()) {
            ArrayList<s_quote_photo_info> arrayList = new ArrayList<>();
            for (NetImageInfo netImageInfo : list) {
                j17++;
                s_quote_photo_info s_quote_photo_infoVar = new s_quote_photo_info();
                s_quote_photo_infoVar.url = netImageInfo.mBigPath;
                s_quote_photo_infoVar.upload_time = j17;
                s_quote_photo_infoVar.uuid = netImageInfo.mUuid;
                s_quote_photo_infoVar.msgtime = netImageInfo.mMsgTime;
                s_quote_photo_infoVar.groupUin = netImageInfo.mTroopCode;
                arrayList.add(s_quote_photo_infoVar);
            }
            qun_quote_photo_from_qzone_reqVar.photo_list = arrayList;
        }
        qun_quote_photo_from_qzone_reqVar.desc = str4;
        this.req = qun_quote_photo_from_qzone_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
