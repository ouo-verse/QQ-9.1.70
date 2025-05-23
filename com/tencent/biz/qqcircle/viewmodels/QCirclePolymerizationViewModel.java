package com.tencent.biz.qqcircle.viewmodels;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.wink.QQWinkSchemaParamsModifier;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleProfile$GuildInfo;
import qqcircle.QQCircleProfile$StProfileBizData;

/* loaded from: classes5.dex */
public class QCirclePolymerizationViewModel extends com.tencent.biz.qqcircle.viewmodels.a implements IQCircleReportSessionOperation, IDataDisplaySurface<e30.b> {
    private QCirclePolymerizationBean T;
    private QCircleLayerBean.QFSTagPolymerizationBean U;
    private Context V;

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<UIStateData<List<e30.b>>> f92797m = new MutableLiveData<>();
    public MutableLiveData<UIStateData<List<e30.b>>> C = new MutableLiveData<>();
    public MutableLiveData<UIStateData<List<e30.b>>> D = new MutableLiveData<>();
    public MutableLiveData<UIStateData<List<e30.b>>> E = new MutableLiveData<>();
    public MutableLiveData<UIStateData<List<e30.b>>> F = new MutableLiveData<>();
    public MutableLiveData<UIStateData<List<e30.b>>> G = new MutableLiveData<>();
    public MutableLiveData<Integer> H = new MutableLiveData<>();
    private List<e30.b> I = new ArrayList();
    private List<e30.b> J = new ArrayList();
    private List<e30.b> K = new ArrayList();
    public QQCircleProfile$StProfileBizData L = new QQCircleProfile$StProfileBizData();
    public QQCircleProfile$GuildInfo M = new QQCircleProfile$GuildInfo();
    public QQCircleBase$StUserBusiData N = new QQCircleBase$StUserBusiData();
    public MutableLiveData<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> P = new MutableLiveData<>();
    public MutableLiveData<String> Q = new MutableLiveData<>();
    private String R = null;
    private String S = null;
    private int W = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f92813a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QCirclePolymerizationBean f92814b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f92815c;

        a(boolean z16, QCirclePolymerizationBean qCirclePolymerizationBean, int i3) {
            this.f92813a = z16;
            this.f92814b = qCirclePolymerizationBean;
            this.f92815c = i3;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            Object valueOf;
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("requestTagPageData onReceive: dispatch Success:");
            sb5.append(z16);
            sb5.append(" | TraceId:");
            sb5.append(baseRequest.getTraceId());
            sb5.append(" | SeqId:");
            sb5.append(baseRequest.getCurrentSeq());
            sb5.append(" | retCode:");
            sb5.append(j3);
            sb5.append(" | retMessage:");
            sb5.append(str);
            sb5.append(" | isLoadMore:");
            sb5.append(this.f92813a);
            sb5.append(" | isCache:");
            sb5.append(isProtocolCache);
            sb5.append(" | responseAttachInfo:");
            sb5.append(QCirclePolymerizationViewModel.this.R);
            sb5.append(" | isFinish: ");
            if (feedCloudRead$StGetFeedListRsp == null) {
                valueOf = "";
            } else {
                valueOf = Integer.valueOf(feedCloudRead$StGetFeedListRsp.isFinish.get());
            }
            sb5.append(valueOf);
            QLog.d("QCirclePolymerizationViewModel", 1, sb5.toString());
            QCirclePolymerizationViewModel.this.d2(z16, j3, str, feedCloudRead$StGetFeedListRsp, this.f92813a, this.f92814b, this.f92815c);
        }
    }

    private void U1(int i3, List<e30.b> list) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this.K.addAll(list);
                    return;
                }
                return;
            }
            this.J.addAll(list);
            return;
        }
        this.I.addAll(list);
    }

    private void W1(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this.K.clear();
                    return;
                }
                return;
            }
            this.J.clear();
            return;
        }
        this.I.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b2(final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final int i3, final boolean z16, final boolean z17, final long j3) {
        QCirclePushInfoManager.e().j(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        final ArrayList<e30.b> b16 = e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z18;
                if (b16.size() > 0) {
                    QCirclePolymerizationViewModel.this.m2(i3, z16, z17, b16, feedCloudRead$StGetFeedListRsp);
                } else {
                    QCirclePolymerizationViewModel.this.i2(i3, z16, feedCloudRead$StGetFeedListRsp, j3);
                }
                QCirclePolymerizationViewModel qCirclePolymerizationViewModel = QCirclePolymerizationViewModel.this;
                int i16 = i3;
                boolean z19 = z16;
                ArrayList arrayList = b16;
                boolean z26 = z17;
                if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                qCirclePolymerizationViewModel.o2(i16, z19, arrayList, z26, z18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2(boolean z16, int i3, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final boolean z17, final QCirclePolymerizationBean qCirclePolymerizationBean) {
        if (!z16 && i3 != 1) {
            final QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            if (!feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
                QLog.d("QCirclePolymerizationViewModel", 1, "!rsp.busiRspData.has()");
                return;
            }
            try {
                qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.has()) {
                this.S = qQCircleFeedBase$StFeedListBusiRspData.refreshAttachInfo.get();
            }
            e2(qQCircleFeedBase$StFeedListBusiRspData);
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel.4
                @Override // java.lang.Runnable
                public void run() {
                    UIStateData<QQCircleFeedBase$StFeedListBusiRspData> obtainEmpty;
                    MutableLiveData<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> mutableLiveData = QCirclePolymerizationViewModel.this.P;
                    if (qQCircleFeedBase$StFeedListBusiRspData.has()) {
                        obtainEmpty = UIStateData.obtainSuccess(z17).setData(false, qQCircleFeedBase$StFeedListBusiRspData);
                    } else {
                        obtainEmpty = UIStateData.obtainEmpty();
                    }
                    mutableLiveData.setValue(obtainEmpty);
                    QCirclePolymerizationViewModel.this.p2(qQCircleFeedBase$StFeedListBusiRspData, qCirclePolymerizationBean);
                }
            });
        }
    }

    private void e2(@NonNull QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
        QCirclePolymerizationBean qCirclePolymerizationBean = this.T;
        if (qCirclePolymerizationBean != null && qCirclePolymerizationBean.getPolymerizationType() == 4 && qQCircleFeedBase$StFeedListBusiRspData.has()) {
            try {
                QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
                this.N = qQCircleBase$StUserBusiData;
                qQCircleBase$StUserBusiData.mergeFrom(qQCircleFeedBase$StFeedListBusiRspData.editProfileButton.loginUser.busiData.get().toByteArray());
                QQCircleProfile$StProfileBizData qQCircleProfile$StProfileBizData = new QQCircleProfile$StProfileBizData();
                this.L = qQCircleProfile$StProfileBizData;
                qQCircleProfile$StProfileBizData.mergeFrom(qQCircleFeedBase$StFeedListBusiRspData.editProfileButton.profileBusiData.get().toByteArray());
                QQCircleProfile$GuildInfo qQCircleProfile$GuildInfo = new QQCircleProfile$GuildInfo();
                this.M = qQCircleProfile$GuildInfo;
                qQCircleProfile$GuildInfo.mergeFrom(qQCircleFeedBase$StFeedListBusiRspData.editProfileButton.guildInfo.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2(String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, QCirclePolymerizationBean qCirclePolymerizationBean) {
        if (!VSNetworkHelper.isProtocolCache(str)) {
            QCirclePluginGlobalInfo.Z(feedCloudRead$StGetFeedListRsp.isFirstLogin.get());
            if (qCirclePolymerizationBean != null && qCirclePolymerizationBean.isMiddlePage()) {
                QCircleDTLoginReporter.daTongLoginReportMiddlePage(qCirclePolymerizationBean.getSchemeAttrs(), QCirclePluginGlobalInfo.H());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2(int i3, boolean z16, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, long j3) {
        boolean z17 = false;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData = this.D;
                    UIStateData loadMore = UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z16);
                    if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                        z17 = true;
                    }
                    mutableLiveData.setValue(loadMore.setFinish(z17));
                    return;
                }
                return;
            }
            MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData2 = this.C;
            UIStateData loadMore2 = UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z16);
            if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                z17 = true;
            }
            mutableLiveData2.setValue(loadMore2.setFinish(z17));
            return;
        }
        MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData3 = this.f92797m;
        UIStateData loadMore3 = UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z16);
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            z17 = true;
        }
        mutableLiveData3.setValue(loadMore3.setFinish(z17));
    }

    private void j2(int i3, String str, long j3, boolean z16) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this.D.setValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z16));
                    return;
                }
                return;
            }
            this.C.setValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z16));
            return;
        }
        this.f92797m.setValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z16));
    }

    private void l2(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this.D.setValue(UIStateData.obtainLoading());
                    return;
                }
                return;
            }
            this.C.setValue(UIStateData.obtainLoading());
            return;
        }
        this.f92797m.setValue(UIStateData.obtainLoading());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(int i3, boolean z16, boolean z17, List<e30.b> list, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        boolean z18 = false;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData = this.D;
                    UIStateData data = UIStateData.obtainSuccess(z17).setData(z16, list);
                    if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                        z18 = true;
                    }
                    mutableLiveData.setValue(data.setFinish(z18));
                    return;
                }
                return;
            }
            MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData2 = this.C;
            UIStateData data2 = UIStateData.obtainSuccess(z17).setData(z16, list);
            if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                z18 = true;
            }
            mutableLiveData2.setValue(data2.setFinish(z18));
            return;
        }
        MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData3 = this.f92797m;
        UIStateData data3 = UIStateData.obtainSuccess(z17).setData(z16, list);
        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
            z18 = true;
        }
        mutableLiveData3.setValue(data3.setFinish(z18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2(int i3, boolean z16, List<e30.b> list, boolean z17, boolean z18) {
        if (this.I != null && this.J != null && this.K != null) {
            if (!z16) {
                W1(i3);
            }
            U1(i3, list);
            QLog.d("QCirclePolymerizationViewModel", 2, "[syncLayerFeedsData] tagType = " + i3 + ", isLoadMore = " + z16 + ", isCache = " + z17);
            if (!RFSafeListUtils.isEmpty(list)) {
                QLog.d("QCirclePolymerizationViewModel", 2, "[syncLayerFeedsData] feeds size = " + list.size());
            }
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        this.G.setValue(UIStateData.obtainSuccess(z17).setData(z16, this.K).setFinish(z18));
                        return;
                    }
                    return;
                }
                this.F.setValue(UIStateData.obtainSuccess(z17).setData(z16, this.J).setFinish(z18));
                return;
            }
            this.E.setValue(UIStateData.obtainSuccess(z17).setData(z16, this.I).setFinish(z18));
            return;
        }
        QLog.e("QCirclePolymerizationViewModel", 1, "[syncLayerFeedsData] mDefaultAllFeeds = " + this.I + ", mHotAllFeeds = " + this.J + ", mRecentAllFeeds = " + this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(@NonNull QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData, QCirclePolymerizationBean qCirclePolymerizationBean) {
        String str;
        List<FeedCloudCommon$Entry> list;
        if (!qQCircleFeedBase$StFeedListBusiRspData.has()) {
            return;
        }
        QCircleLayerBean.QFSTagPolymerizationBean qFSTagPolymerizationBean = new QCircleLayerBean.QFSTagPolymerizationBean();
        this.U = qFSTagPolymerizationBean;
        QCirclePolymerizationBean qCirclePolymerizationBean2 = this.T;
        if (qCirclePolymerizationBean2 != null) {
            qFSTagPolymerizationBean.feedTagPageFromType = qCirclePolymerizationBean2.getFeedTagPageFromType();
            this.U.operationActivityId = this.T.getOperationActivityId();
        }
        if (!TextUtils.isEmpty(qQCircleFeedBase$StFeedListBusiRspData.publisherButton.jumpUrl.get())) {
            if (qCirclePolymerizationBean.isFromGalleryPage()) {
                this.Q.setValue(QCircleScheme.AttrGallery.JUMP_TO_GALLERY_PUBLISH_PAGE);
            } else {
                this.Q.setValue(qQCircleFeedBase$StFeedListBusiRspData.publisherButton.jumpUrl.get());
            }
        } else if (qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.has() && qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.optInfo.has() && qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.optInfo.publishSchema.has()) {
            if (qCirclePolymerizationBean.isFromGalleryPage()) {
                str = QCircleScheme.AttrGallery.JUMP_TO_GALLERY_PUBLISH_PAGE;
            } else {
                str = qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.optInfo.publishSchema.get();
            }
            if (!TextUtils.isEmpty(str)) {
                if (qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.tagId.has()) {
                    str = com.tencent.biz.qqcircle.wink.i.a(str, "tagid", qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.tagId.get());
                }
                QCirclePolymerizationBean qCirclePolymerizationBean3 = this.T;
                if (qCirclePolymerizationBean3 != null) {
                    str = com.tencent.biz.qqcircle.wink.i.a(str, "feedtagpagefromtype", qCirclePolymerizationBean3.getFeedTagPageFromType());
                }
                String a16 = QQWinkSchemaParamsModifier.f93925a.a(str, qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo);
                if (a16.contains(QCircleScheme.AttrQQPublish.CHALLENGE_TAG)) {
                    a16 = com.tencent.biz.qqcircle.wink.i.a(a16, "taskid", "topic_challenge_guide_bar");
                }
                QLog.d("QCirclePolymerizationViewModel", 1, "syncTagInfo... challenge schema:" + a16);
                this.Q.setValue(a16);
                this.U.polymerizationScheme = a16;
            }
        } else if (qCirclePolymerizationBean.isFromGalleryPage()) {
            this.Q.setValue(QCircleScheme.AttrGallery.JUMP_TO_GALLERY_PUBLISH_PAGE);
        }
        if (qQCircleFeedBase$StFeedListBusiRspData.tagPageData.subsidiaryFieldDesc.has() && (list = qQCircleFeedBase$StFeedListBusiRspData.tagPageData.subsidiaryFieldDesc.get()) != null && list.size() > 1) {
            if (list.get(0) != null && list.get(0).value != null && list.get(0).value.has()) {
                this.U.tagViews = list.get(0).value.get();
            }
            if (list.get(1) != null && list.get(1).value != null && list.get(1).value.has()) {
                this.U.feedCount = list.get(1).value.get();
            }
        }
    }

    public QCirclePolymerizationBean X1() {
        return this.T;
    }

    @Nullable
    public QCircleLayerBean.QFSTagPolymerizationBean Z1() {
        return this.U;
    }

    public int a2() {
        return this.W;
    }

    public void d2(boolean z16, final long j3, final String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, final boolean z17, final QCirclePolymerizationBean qCirclePolymerizationBean, final int i3) {
        final boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        if (z16 && j3 == 0 && feedCloudRead$StGetFeedListRsp != null) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel.2
                @Override // java.lang.Runnable
                public void run() {
                    if (feedCloudRead$StGetFeedListRsp.extInfo.has()) {
                        QCirclePolymerizationViewModel.this.updateSession(feedCloudRead$StGetFeedListRsp.extInfo.get());
                    }
                    QCirclePolymerizationViewModel.this.R = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
                    QCirclePolymerizationViewModel.this.b2(feedCloudRead$StGetFeedListRsp, i3, z17, isProtocolCache, j3);
                    QCirclePolymerizationViewModel.this.c2(z17, i3, feedCloudRead$StGetFeedListRsp, isProtocolCache, qCirclePolymerizationBean);
                    QCirclePolymerizationViewModel.this.f2(str, feedCloudRead$StGetFeedListRsp, qCirclePolymerizationBean);
                }
            });
        } else {
            QLog.e("QCirclePolymerizationViewModel", 1, "[handlePolymerizationResponse] setErrorFeedDataByType");
            j2(i3, str, j3, z17);
        }
    }

    public void g2(Context context, QCirclePolymerizationBean qCirclePolymerizationBean, boolean z16, boolean z17) {
        h2(context, qCirclePolymerizationBean, z16, z17, qCirclePolymerizationBean.getTagTabType());
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        int i3 = this.W;
        if (i3 != 0) {
            if (i3 != 1) {
                return this.E;
            }
            return this.G;
        }
        return this.F;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        QCirclePolymerizationBean qCirclePolymerizationBean = this.T;
        if (qCirclePolymerizationBean == null) {
            return 0;
        }
        if (qCirclePolymerizationBean.getPolymerizationType() == 7) {
            int i3 = this.W;
            if (i3 != 0) {
                if (i3 == 1) {
                    return 69;
                }
            } else {
                return 68;
            }
        }
        return this.T.getPolymerizationType();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePolymerizationViewModel";
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            return qCircleReporterAgent.getSessionCommonExt(z16);
        }
        return new FeedCloudCommon$StCommonExt();
    }

    public void h2(Context context, QCirclePolymerizationBean qCirclePolymerizationBean, boolean z16, boolean z17, int i3) {
        Object valueOf;
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[requestPolymerizationData] isLoadMore = ");
        sb5.append(z16);
        sb5.append(", enableCache = ");
        sb5.append(z17);
        sb5.append(", tagType = ");
        sb5.append(i3);
        sb5.append(", isFromGalleryPage = ");
        if (qCirclePolymerizationBean == null) {
            valueOf = "";
        } else {
            valueOf = Boolean.valueOf(qCirclePolymerizationBean.isFromGalleryPage());
        }
        sb5.append(valueOf);
        QLog.d("QCirclePolymerizationViewModel", 1, sb5.toString());
        if (qCirclePolymerizationBean == null) {
            QLog.e("QCirclePolymerizationViewModel", 1, "initBean == null");
            return;
        }
        if (z16) {
            str = this.R;
        } else {
            str = null;
        }
        QCircleGetFeedListRequest qCircleGetFeedListRequest = new QCircleGetFeedListRequest(qCirclePolymerizationBean, str, this.S);
        if (qCirclePolymerizationBean.isFromGalleryPage()) {
            qCircleGetFeedListRequest.mRequest.from.set(10);
        }
        qCircleGetFeedListRequest.mRequest.extInfo.set(getSession(!z16));
        if (qCirclePolymerizationBean.getPolymerizationType() == 63 && qCirclePolymerizationBean.getHotEventInfo() != null) {
            PbExtKt.b(qCircleGetFeedListRequest.mRequest.extInfo.mapInfo, qCirclePolymerizationBean.getHotEventInfo());
        }
        qCircleGetFeedListRequest.setEnableCache(z17);
        l2(i3);
        QLog.d("QCirclePolymerizationViewModel", 1, "requestAttachInfo : " + this.R + ", isLoadMore = " + z16);
        if (!z16) {
            VSNetworkHelper.getInstance().cancelRequest(context);
        }
        sendRequest(context, qCircleGetFeedListRequest, new a(z16, qCirclePolymerizationBean, i3));
    }

    public void k2(QCirclePolymerizationBean qCirclePolymerizationBean) {
        if (qCirclePolymerizationBean == null) {
            QLog.e("QCirclePolymerizationViewModel", 1, "[setInitBean] initBean is null");
        } else {
            this.T = qCirclePolymerizationBean;
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        if (getDisplaySurfaceData(new Object[0]).getValue() != null && getDisplaySurfaceData(new Object[0]).getValue().getState() != 1) {
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof QCirclePolymerizationBean) {
                    this.T = (QCirclePolymerizationBean) obj;
                }
            }
            if (objArr.length > 1) {
                Object obj2 = objArr[1];
                if (obj2 instanceof Context) {
                    this.V = (Context) obj2;
                }
            }
            getDisplaySurfaceData(new Object[0]).getValue().setState(1);
            g2(this.V, this.T, true, false);
        }
    }

    public void n2(int i3) {
        this.W = i3;
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.updateSubSession(feedCloudCommon$StCommonExt);
        }
    }
}
