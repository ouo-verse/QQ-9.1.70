package com.qzone.feed.business.protocol;

import NS_QQRADIO_KUOLIE_PROTOCOL.CommonInfo;
import NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieFriendRecomReq;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetRecommendFriendsRequest extends QZoneRequest {
    private static final String CMD_STRING = "Liveshow.getKuolieFriendRecom";
    public static String mRecommendFriendsCookie = "";

    public QzoneGetRecommendFriendsRequest(String str, String str2, int i3, int i16) {
        super(CMD_STRING);
        String str3;
        try {
            str3 = String.valueOf(i3);
        } catch (Exception e16) {
            QLog.e(this.TAG, 4, e16.getMessage());
            str3 = null;
        }
        CommonInfo commonInfo = new CommonInfo();
        if (str3 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("room_cur_status", str3);
            hashMap.put("STR_ONLINE_TIME", String.valueOf(i16));
            commonInfo.mapExt = hashMap;
        }
        this.req = new GetKuolieFriendRecomReq(commonInfo, str, str2);
    }

    public static void setRecommendFriendsCookie(String str) {
        mRecommendFriendsCookie = str;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getKuolieFriendRecom";
    }
}
