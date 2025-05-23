package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetCollectBoxFeedListRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFavoritesFeedsPageRsp;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<e30.b> {
    private long E;
    private String F;
    private Map<String, String> G;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<e30.b>>> f89144m = new MutableLiveData<>();
    private final List<e30.b> C = new ArrayList();
    private final MutableLiveData<QQCircleFeedBase$StFavoritesFeedsPageRsp> D = new MutableLiveData<>();

    private void Q1(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
        try {
            qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSPersonalCollectBoxDetailViewModel", 1, "[handleHeadData] get busiRspData error:", e16);
        }
        QQCircleFeedBase$StFavoritesFeedsPageRsp qQCircleFeedBase$StFavoritesFeedsPageRsp = qQCircleFeedBase$StFeedListBusiRspData.favoritesFeedsPageRsp;
        if (qQCircleFeedBase$StFavoritesFeedsPageRsp != null && qQCircleFeedBase$StFavoritesFeedsPageRsp.has()) {
            this.D.postValue(qQCircleFeedBase$StFavoritesFeedsPageRsp);
        }
    }

    private boolean S1() {
        UIStateData<List<e30.b>> value = this.f89144m.getValue();
        if (value != null && value.isLoading()) {
            QLog.e("QFSPersonalCollectBoxDetailViewModel", 1, "[isLoading]:true_" + P1());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(final boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QLog.d("QFSPersonalCollectBoxDetailViewModel", 1, "[requestData] error:", Long.valueOf(j3), "  errorMsg:", str, "_", P1());
        if (z17 && j3 == 0 && feedCloudRead$StGetFeedListRsp != null) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.T1(feedCloudRead$StGetFeedListRsp, z16);
                }
            });
        } else {
            Z1(str);
        }
    }

    private void W1(final boolean z16) {
        String str;
        int i3;
        QLog.d("QFSPersonalCollectBoxDetailViewModel", 1, "[requestData] isLoadMore:", Boolean.valueOf(z16));
        if (S1()) {
            return;
        }
        a2();
        if (z16) {
            str = this.F;
        } else {
            str = "";
        }
        String str2 = str;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        QFSGetCollectBoxFeedListRequest qFSGetCollectBoxFeedListRequest = new QFSGetCollectBoxFeedListRequest(this.E, false, false, str2, i3);
        c2(qFSGetCollectBoxFeedListRequest);
        sendRequest(qFSGetCollectBoxFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.g
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str3, Object obj) {
                i.this.U1(z16, baseRequest, z17, j3, str3, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }

    private void Z1(String str) {
        this.f89144m.postValue(UIStateData.obtainError(str).setLoadMore(true));
    }

    private void a2() {
        this.f89144m.postValue(UIStateData.obtainLoading().setLoadMore(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b2, reason: merged with bridge method [inline-methods] */
    public void T1(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, boolean z16) {
        if (!z16) {
            Q1(feedCloudRead$StGetFeedListRsp);
            this.C.clear();
        }
        ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        this.C.addAll(b16);
        boolean z17 = false;
        QLog.d("QFSPersonalCollectBoxDetailViewModel", 1, "[setSuccessStatus] rspDataList size:" + b16.size(), "_" + P1());
        UIStateData loadMore = UIStateData.obtainSuccess(false).setLoadMore(z16);
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            z17 = true;
        }
        UIStateData<List<e30.b>> dataList = loadMore.setFinish(z17).setDataList(this.C);
        this.F = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
        this.f89144m.postValue(dataList);
    }

    private void c2(QFSGetCollectBoxFeedListRequest qFSGetCollectBoxFeedListRequest) {
        Map<String, String> map = this.G;
        if (map != null && !map.isEmpty()) {
            qFSGetCollectBoxFeedListRequest.mRequest.extInfo.setHasFlag(true);
            String str = this.G.get(QCircleSchemeAttr.CollectBoxDetail.SHARE_TIME);
            if (!TextUtils.isEmpty(str)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry.key.set(QCircleSchemeAttr.CollectBoxDetail.SHARE_TIME);
                feedCloudCommon$Entry.value.set(str);
                qFSGetCollectBoxFeedListRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
            }
            String str2 = this.G.get("title");
            if (!TextUtils.isEmpty(str2)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry2.key.set("title");
                feedCloudCommon$Entry2.value.set(str2);
                qFSGetCollectBoxFeedListRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry2);
            }
        }
    }

    public void N1(List<FeedCloudMeta$StFeed> list, boolean z16, boolean z17) {
        ArrayList<e30.b> b16 = e30.d.b(list);
        this.C.addAll(0, b16);
        QLog.d("QFSPersonalCollectBoxDetailViewModel", 1, "[addFeeds] dataList size:" + b16.size(), "_" + P1());
        this.f89144m.postValue(UIStateData.obtainSuccess(false).setLoadMore(z16).setFinish(z17).setDataList(this.C));
    }

    public MutableLiveData<QQCircleFeedBase$StFavoritesFeedsPageRsp> O1() {
        return this.D;
    }

    public String P1() {
        return String.valueOf(hashCode());
    }

    public void R1(long j3, Map<String, String> map) {
        this.F = "";
        this.E = j3;
        this.G = map;
        W1(false);
        QLog.d("QFSPersonalCollectBoxDetailViewModel", 1, "[initData] collectBoxId:", Long.valueOf(j3), " getViewModeKey():", P1());
    }

    public void X1(List<FeedCloudMeta$StFeed> list, boolean z16, boolean z17) {
        ArrayList<e30.b> b16 = e30.d.b(list);
        this.C.clear();
        this.C.addAll(b16);
        QLog.d("QFSPersonalCollectBoxDetailViewModel", 1, "[removeFeeds] dataList size:" + b16.size(), "_" + P1());
        this.f89144m.postValue(UIStateData.obtainSuccess(false).setLoadMore(z16).setFinish(z17).setDataList(this.C));
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f89144m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCollectBoxDetailViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        W1(true);
    }
}
