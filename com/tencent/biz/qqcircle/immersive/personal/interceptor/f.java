package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QFSGetProfileFeedsRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f extends QFSUIStateBaseManager<QFSGetProfileFeedsRequest, FeedCloudRead$StGetFeedListRsp> {

    /* renamed from: c, reason: collision with root package name */
    private String f88717c;

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public List<e30.b> l(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, boolean z16) {
        RFWLog.i("QFSGetProfileFeedUIStateManager", RFWLog.USR, "[parseDataFromRsp] -> mAttachInfo = " + this.f88717c);
        this.f88717c = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
        return e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean m(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            return true;
        }
        return false;
    }

    public void r(String str) {
        this.f88717c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void n(QFSGetProfileFeedsRequest qFSGetProfileFeedsRequest) {
        if (qFSGetProfileFeedsRequest != null && !TextUtils.isEmpty(this.f88717c)) {
            RFWLog.i("QFSGetProfileFeedUIStateManager", RFWLog.USR, "[wrapperLoadMoreParams] -> mAttachInfo = " + this.f88717c);
            qFSGetProfileFeedsRequest.setAttachInfo(this.f88717c);
        }
    }
}
