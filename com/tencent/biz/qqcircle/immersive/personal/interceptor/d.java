package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSUIStateBaseManager<QFSGetFeedListRequest, FeedCloudRead$StGetFeedListRsp> {

    /* renamed from: c, reason: collision with root package name */
    private String f88714c;

    /* renamed from: d, reason: collision with root package name */
    private String f88715d;

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public List<e30.b> l(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, boolean z16) {
        this.f88714c = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
        if (feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            try {
                qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.has()) {
                this.f88715d = qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.get();
            }
        }
        ArrayList<e30.b> b16 = e30.d.b(list);
        if (!z16) {
            w20.a.j().initOrUpdateGlobalState((List) b16, true);
            QCirclePushInfoManager.e().j(list);
        }
        return b16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean m(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void n(QFSGetFeedListRequest qFSGetFeedListRequest) {
        if (qFSGetFeedListRequest != null && !TextUtils.isEmpty(this.f88714c)) {
            qFSGetFeedListRequest.setAttachInfo(this.f88714c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void o(QFSGetFeedListRequest qFSGetFeedListRequest) {
        if (qFSGetFeedListRequest != null && !TextUtils.isEmpty(this.f88715d)) {
            qFSGetFeedListRequest.setRefreshAttachInfo(this.f88715d);
        }
    }
}
