package com.qzone.business.gift.business.protocol;

import NS_MOBILE_TEMPLATE_GIFT.s_send_gift_item;
import NS_MOBILE_TEMPLATE_GIFT.send_common_gift_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGiftCommonSendRequest extends QZoneRequest {
    private static final String CMD_STRING = "sendgift";

    public QzoneGiftCommonSendRequest(s_send_gift_item s_send_gift_itemVar) {
        super(CMD_STRING);
        send_common_gift_req send_common_gift_reqVar = new send_common_gift_req();
        HashMap hashMap = new HashMap();
        hashMap.put("send_gift_source", "jizhuangxiang_feed");
        s_send_gift_itemVar.mapExt = hashMap;
        send_common_gift_reqVar.giftItem = s_send_gift_itemVar;
        this.req = send_common_gift_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QzoneGiftCommonSendRequest() {
    }
}
