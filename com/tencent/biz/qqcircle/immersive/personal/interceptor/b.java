package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetCollectionListRequest;
import feedcloud.FeedCloudRead$GetCollectionListRsp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends QFSUIStateBaseManager<QFSGetCollectionListRequest, FeedCloudRead$GetCollectionListRsp> {

    /* renamed from: c, reason: collision with root package name */
    private String f88713c;

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    public String g() {
        return "QFSGetCollectedFeedListUIStateManager";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public List<e30.b> l(FeedCloudRead$GetCollectionListRsp feedCloudRead$GetCollectionListRsp, boolean z16) {
        this.f88713c = feedCloudRead$GetCollectionListRsp.attach_info.get();
        ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$GetCollectionListRsp.collectionData.feeds.get());
        if (!z16) {
            w20.a.j().initOrUpdateGlobalState((List) b16, true);
        }
        return b16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean m(FeedCloudRead$GetCollectionListRsp feedCloudRead$GetCollectionListRsp) {
        return !feedCloudRead$GetCollectionListRsp.has_more.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void n(QFSGetCollectionListRequest qFSGetCollectionListRequest) {
        if (qFSGetCollectionListRequest != null && !TextUtils.isEmpty(this.f88713c)) {
            qFSGetCollectionListRequest.setAttachInfo(this.f88713c);
        }
    }
}
