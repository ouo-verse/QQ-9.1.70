package cooperation.qzone;

import NS_MOBILE_AIONewestFeed.AIONewestFeedReq;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneNewestFeedRequest extends QzoneExternalRequest {
    public static final String CMD_STRING = "getAIONewestFeed";
    private static final String CMD_STRING_BUFFER = "QzoneNewService.getAIONewestFeed";
    public static final String KEY_NEWEST_FEEDS = "getAIONewestFeed";
    private static final String unikey = "getAIONewestFeed";
    public JceStruct req;

    public QZoneNewestFeedRequest(long j3, ArrayList<Long> arrayList, long j16, String str, int i3) {
        super.setRefer(str);
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        AIONewestFeedReq aIONewestFeedReq = new AIONewestFeedReq();
        aIONewestFeedReq.uOpUin = j3;
        aIONewestFeedReq.uHostUin = arrayList;
        aIONewestFeedReq.uLastTime = j16;
        aIONewestFeedReq.src = i3;
        this.req = aIONewestFeedReq;
    }

    public static AIONewestFeedRsp onResponse(byte[] bArr, QQAppInterface qQAppInterface) {
        AIONewestFeedRsp aIONewestFeedRsp;
        if (bArr == null || (aIONewestFeedRsp = (AIONewestFeedRsp) QzoneExternalRequest.decode(bArr, "getAIONewestFeed")) == null) {
            return null;
        }
        return aIONewestFeedRsp;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return CMD_STRING_BUFFER;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        return this.req;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getAIONewestFeed";
    }

    public static AIONewestFeedRsp onResponse(byte[] bArr, QQAppInterface qQAppInterface, int[] iArr) {
        AIONewestFeedRsp aIONewestFeedRsp;
        if (bArr == null || (aIONewestFeedRsp = (AIONewestFeedRsp) QzoneExternalRequest.decode(bArr, "getAIONewestFeed", iArr)) == null) {
            return null;
        }
        return aIONewestFeedRsp;
    }
}
