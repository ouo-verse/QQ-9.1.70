package com.tencent.biz.richframework.network.request;

import NS_COMM.COMM;
import NS_QQ_STORY_CLIENT.CLIENT$StGetUserNewestStoryReq;
import NS_QQ_STORY_CLIENT.CLIENT$StGetUserNewestStoryRsp;
import NS_QQ_STORY_CLIENT.CLIENT$StUinTime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QzoneAioStoryFeedRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.qq_story_client.GetUserNewestStory";
    public static final String TAG = "QzoneAioStoryFeedRequest";
    private CLIENT$StGetUserNewestStoryReq req = new CLIENT$StGetUserNewestStoryReq();

    public QzoneAioStoryFeedRequest(COMM.StCommonExt stCommonExt, long j3, long j16) {
        CLIENT$StUinTime cLIENT$StUinTime = new CLIENT$StUinTime();
        cLIENT$StUinTime.newestTime.set(j3);
        cLIENT$StUinTime.uin.set(j16);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(cLIENT$StUinTime);
        this.req.vecUinTime.set(arrayList);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static CLIENT$StGetUserNewestStoryRsp onResponse(byte[] bArr) {
        CLIENT$StGetUserNewestStoryRsp cLIENT$StGetUserNewestStoryRsp = new CLIENT$StGetUserNewestStoryRsp();
        try {
            cLIENT$StGetUserNewestStoryRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return cLIENT$StGetUserNewestStoryRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onResponse fail." + e16);
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
