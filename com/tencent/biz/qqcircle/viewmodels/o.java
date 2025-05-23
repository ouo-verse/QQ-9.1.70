package com.tencent.biz.qqcircle.viewmodels;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QFSMixFeedRecommendPageRequester;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class o extends QFSMixFeedViewModel {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends QCircleTabGetFeedListRequest.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest.b
        public FeedCloudRead$StGetFeedListReq g() {
            FeedCloudRead$StGetFeedListReq g16 = super.g();
            g16.source.set(56);
            g16.subSource.set(2);
            return g16;
        }
    }

    private QCircleTabGetFeedListRequest.b i2(boolean z16) {
        FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2;
        QCircleTabGetFeedListRequest.b p16 = new a().p(new QCircleTabInfo(new QQCircleFeedBase$StTabInfo()));
        if (uq3.o.i()) {
            feedCloudMeta$StGPSV2 = com.tencent.biz.qqcircle.c.e().d();
        } else {
            feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
        }
        QCircleTabGetFeedListRequest.b o16 = p16.j(feedCloudMeta$StGPSV2).o(2);
        String str = "";
        if (z16 && !TextUtils.isEmpty(this.G)) {
            str = this.G;
        }
        return o16.h(str);
    }

    public void C2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e30.b(feedCloudMeta$StFeed));
        this.f435354m.setValue(UIStateData.obtainSuccess(false).setData(false, arrayList));
    }

    @Override // com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel
    @NotNull
    protected QCircleTabGetFeedListRequest f2(boolean z16) {
        return new QFSMixFeedRecommendPageRequester(i2(z16));
    }

    @Override // com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMixFeedRecommendViewModel";
    }
}
