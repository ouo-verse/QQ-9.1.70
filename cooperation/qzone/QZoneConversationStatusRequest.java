package cooperation.qzone;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneConversationStatusRequest extends QZoneCommonRequest {
    public static final String CMD_STRING = "QzoneNewService.getMsgNewestFeeds";
    public static final String UNI_KEY = "getMsgNewestFeeds";
    newest_feeds_req req;

    public QZoneConversationStatusRequest(long j3, Map<Long, Long> map) {
        newest_feeds_req newest_feeds_reqVar = new newest_feeds_req();
        this.req = newest_feeds_reqVar;
        newest_feeds_reqVar.cmd = 4;
        newest_feeds_reqVar.login_uin = j3;
        newest_feeds_reqVar.strQua = QUA.getQUA3();
        this.req.mapUinTimes = new HashMap();
        this.req.mapUinTimes.putAll(map);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return CMD_STRING;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QZoneCommonRequest
    public int getType() {
        return 1000;
    }

    public String toString() {
        newest_feeds_req newest_feeds_reqVar = this.req;
        return String.format("reqetuest ,cmd:%d,loginUin;%d,qua;%s,mapUintimes:%s ", Integer.valueOf(this.req.cmd), Long.valueOf(this.req.login_uin), newest_feeds_reqVar.strQua, String.valueOf(newest_feeds_reqVar.mapUinTimes));
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNI_KEY;
    }
}
