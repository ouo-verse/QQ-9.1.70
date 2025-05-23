package com.qzone.reborn.qzmoment.request;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentReader$StGetFeedListReq;
import qzonemoment.QZMomentReader$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMGetMyFeedListRequest extends QZMBaseRequest {
    private QZMomentReader$StGetFeedListReq mGetFeedListReq;
    private final int mListNum = 10;

    public QZMGetMyFeedListRequest(QZMomentMeta$StFeed qZMomentMeta$StFeed, String str) {
        QZMomentReader$StGetFeedListReq qZMomentReader$StGetFeedListReq = new QZMomentReader$StGetFeedListReq();
        this.mGetFeedListReq = qZMomentReader$StGetFeedListReq;
        qZMomentReader$StGetFeedListReq.from.set(0);
        this.mGetFeedListReq.userId.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        this.mGetFeedListReq.listNum.set(10);
        if (!TextUtils.isEmpty(str)) {
            this.mGetFeedListReq.feedAttchInfo.set(str);
        }
        if (qZMomentMeta$StFeed != null) {
            this.mGetFeedListReq.feed.set(qZMomentMeta$StFeed);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qz_moment.commreader.ComReader.GetUserFeedList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mGetFeedListReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentReader$StGetFeedListRsp qZMomentReader$StGetFeedListRsp = new QZMomentReader$StGetFeedListRsp();
        try {
            qZMomentReader$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZMGetMyFeedListRequest", 1, "decode error: ", e16);
        }
        return qZMomentReader$StGetFeedListRsp;
    }
}
