package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageCommDataRequest;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends QFSUIStateBaseManager<QFSGetMainPageCommDataRequest, FeedCloudRead$StGetMainPageCommDataRsp> {

    /* renamed from: c, reason: collision with root package name */
    private String f88716c;

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    public String g() {
        return "QFSGetProductsUIStateManager";
    }

    public boolean p(List<e30.b> list, String str) {
        if (f().size() < k(f(), list).size()) {
            this.f88716c = str;
            return true;
        }
        return false;
    }

    public String q() {
        return this.f88716c;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public List<e30.b> l(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp, boolean z16) {
        QLog.i(g(), 1, "[parseDataFromRsp] isCache = " + z16);
        this.f88716c = feedCloudRead$StGetMainPageCommDataRsp.feedAttchInfo.get();
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetMainPageCommDataRsp.vecFeed.get();
        ArrayList<e30.b> b16 = e30.d.b(list);
        if (!z16) {
            w20.a.j().initOrUpdateGlobalState((List) b16, true);
            QCirclePushInfoManager.e().j(list);
        }
        return b16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean m(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        if (feedCloudRead$StGetMainPageCommDataRsp.isFinish.get() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(QFSGetMainPageCommDataRequest qFSGetMainPageCommDataRequest) {
        if (qFSGetMainPageCommDataRequest != null && !TextUtils.isEmpty(this.f88716c)) {
            qFSGetMainPageCommDataRequest.setAttachInfo(this.f88716c);
        }
    }
}
