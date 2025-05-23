package com.qzone.publish.business.protocol;

import NS_MOBILE_QUN.qzone_quote_photo_from_qun_req;
import NS_MOBILE_QUN.s_quote_photo_info;
import android.text.TextUtils;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.util.image.NetImageInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class QZoneQuotePicFromQunRequest extends QZoneRequest {
    private static final String CMD_STRING = "qzoneQuotePhotoFromQun";

    public QZoneQuotePicFromQunRequest(String str, String str2, String str3, long j3, ArrayList<NetImageInfo> arrayList, String str4) {
        super(CMD_STRING);
        qzone_quote_photo_from_qun_req qzone_quote_photo_from_qun_reqVar = new qzone_quote_photo_from_qun_req();
        qzone_quote_photo_from_qun_reqVar.qunid = str;
        qzone_quote_photo_from_qun_reqVar.albumid = str2;
        qzone_quote_photo_from_qun_reqVar.batchid = j3;
        if (TextUtils.isEmpty(str2)) {
            qzone_quote_photo_from_qun_reqVar.albumhandset = 1L;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<s_quote_photo_info> arrayList2 = new ArrayList<>();
            Iterator<NetImageInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                NetImageInfo next = it.next();
                s_quote_photo_info s_quote_photo_infoVar = new s_quote_photo_info();
                s_quote_photo_infoVar.url = next.mBigPath;
                s_quote_photo_infoVar.uuid = next.mUuid;
                s_quote_photo_infoVar.msgtime = next.mMsgTime;
                s_quote_photo_infoVar.groupUin = next.mTroopCode;
                arrayList2.add(s_quote_photo_infoVar);
            }
            qzone_quote_photo_from_qun_reqVar.photos = arrayList2;
        }
        qzone_quote_photo_from_qun_reqVar.desc = str4;
        this.req = qzone_quote_photo_from_qun_reqVar;
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
