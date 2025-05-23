package com.tencent.biz.qqcircle.immersive.layer.biz;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageCommDataRequest;
import com.tencent.biz.qqcircle.immersive.request.QFSGetMiddlePageFeedRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QFSGetFeedDetailRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.event.QFSPublicAccountFollowUserReadEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import java.util.Collections;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerDefaultViewModel extends com.tencent.biz.qqcircle.immersive.layer.base.e {
    private QCircleInitBean K;
    private String L;
    private String M;
    private String N = "";

    private void U2(final QCircleInitBean qCircleInitBean) {
        final String uin = qCircleInitBean.getUin();
        if (TextUtils.isEmpty(uin)) {
            QLog.e("QFSLayerDefaultViewModel", 1, "[getApertureFeedList] uin is null. ");
        } else {
            sendRequest(new QFSGetMainPageCommDataRequest.b(uin).k(W2(qCircleInitBean)).h(this.N).b(), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.l
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    QFSLayerDefaultViewModel.this.h3(uin, qCircleInitBean, baseRequest, z16, j3, str, (FeedCloudRead$StGetMainPageCommDataRsp) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2(QCircleInitBean qCircleInitBean, boolean z16) {
        String b16 = n50.a.b(qCircleInitBean);
        if (PreLoader.exists(b16)) {
            loadPreloadResult(b16);
            return;
        }
        if (z16) {
            this.f86506m.setStringAttachInfo(null);
        }
        final QFSGetMiddlePageFeedRequest qFSGetMiddlePageFeedRequest = new QFSGetMiddlePageFeedRequest(qCircleInitBean, this.f86506m.getStringAttachInfo(), z16);
        qFSGetMiddlePageFeedRequest.setDtPageId(this.M);
        qFSGetMiddlePageFeedRequest.mRequest.extInfo.set(getSession(z16));
        if (qFSGetMiddlePageFeedRequest.mRequest.source.get() == 63 && qCircleInitBean.getHotEventInfo() != null) {
            PbExtKt.b(qFSGetMiddlePageFeedRequest.mRequest.extInfo.mapInfo, qCircleInitBean.getHotEventInfo());
        }
        if (qFSGetMiddlePageFeedRequest.mRequest.source.get() == 90 && qCircleInitBean.getQQVideoBusinessFeedID() != null) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("qzone_feed_id");
            feedCloudCommon$Entry.value.set(qCircleInitBean.getQQVideoBusinessFeedID());
            qFSGetMiddlePageFeedRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
        }
        if (qFSGetMiddlePageFeedRequest.mRequest.source.get() == 81 && qCircleInitBean.getCommentExtentInfo() != null) {
            af.f(qFSGetMiddlePageFeedRequest.mRequest.extInfo.mapInfo, qCircleInitBean.getCommentExtentInfo());
        }
        sendRequest(qFSGetMiddlePageFeedRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.i
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                QFSLayerDefaultViewModel.this.i3(qFSGetMiddlePageFeedRequest, baseRequest, z17, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }

    private int W2(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getLaunchFrom() != null && !TextUtils.isEmpty(qCircleInitBean.getLaunchFrom()) && TextUtils.isDigitsOnly(qCircleInitBean.getLaunchFrom())) {
            try {
                return Integer.parseInt(qCircleInitBean.getLaunchFrom());
            } catch (Exception unused) {
                QLog.e("QFSLayerDefaultViewModel", 1, "parse error. ");
            }
        }
        return 0;
    }

    private void Y2(QCircleInitBean qCircleInitBean) {
        String b16 = n50.a.b(qCircleInitBean);
        if (PreLoader.exists(b16)) {
            loadPreloadResult(b16);
            return;
        }
        this.K = qCircleInitBean;
        final QFSGetFeedDetailRequest qFSGetFeedDetailRequest = new QFSGetFeedDetailRequest(qCircleInitBean.getFeed().f398449id.get(), false, 0, qCircleInitBean.getFeed(), qCircleInitBean);
        qFSGetFeedDetailRequest.setDtPageId(this.M);
        qFSGetFeedDetailRequest.mRequest.extInfo.set(getSession(true));
        sendRequest(qFSGetFeedDetailRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.k
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSLayerDefaultViewModel.this.j3(qFSGetFeedDetailRequest, baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedDetailRsp) obj);
            }
        });
    }

    private void a3(String str, String str2) {
        QCircleGetFeedListRequest qCircleGetFeedListRequest = new QCircleGetFeedListRequest(str, str2, true, this.f86506m.getStringAttachInfo(), null);
        qCircleGetFeedListRequest.mRequest.extInfo.set(getSession(false));
        sendRequest(qCircleGetFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.j
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str3, Object obj) {
                QFSLayerDefaultViewModel.this.k3(baseRequest, z16, j3, str3, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }

    private void b3(final boolean z16, final long j3, final String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.QFSLayerDefaultViewModel.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                boolean z18;
                if (z16 && feedCloudRead$StGetFeedListRsp != null) {
                    boolean z19 = !TextUtils.isEmpty(((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m.getStringAttachInfo());
                    QLog.d("QFSLayerDefaultViewModel", 1, "[handleFeedListResponse] attachInfo: " + feedCloudRead$StGetFeedListRsp.feedAttchInfo.get() + " isLoadMore: " + z19);
                    ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m.setStringAttachInfo(feedCloudRead$StGetFeedListRsp.feedAttchInfo.get());
                    ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m.setAdAttachInfo(feedCloudRead$StGetFeedListRsp.adAttchInfo.get());
                    LoadInfo loadInfo = ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m;
                    if (feedCloudRead$StGetFeedListRsp.isFinish.get() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    loadInfo.setFinish(z17);
                    if (feedCloudRead$StGetFeedListRsp.extInfo.has()) {
                        QFSLayerDefaultViewModel.this.updateSession(feedCloudRead$StGetFeedListRsp.extInfo.get());
                    }
                    QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
                    if (feedCloudRead$StGetFeedListRsp.busiRspData.has()) {
                        try {
                            qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetFeedListRsp.busiRspData.get().toByteArray());
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e16.printStackTrace();
                        }
                    }
                    if (j3 == 0) {
                        QFSLayerDefaultViewModel.this.j2(qQCircleFeedBase$StFeedListBusiRspData.middlePageData);
                        w20.a.j().initOrUpdateGlobalState((List) e30.d.b(feedCloudRead$StGetFeedListRsp.vecFeed.get()), true);
                        QFSLayerDefaultViewModel qFSLayerDefaultViewModel = QFSLayerDefaultViewModel.this;
                        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
                        if (feedCloudRead$StGetFeedListRsp.isFinish.get() > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        qFSLayerDefaultViewModel.k2(z19, list, z18, 0);
                        w20.a.j().initOrUpdateGlobalState(((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).C, true);
                        QLog.d("QFSLayerDefaultViewModel", 1, "[handleFeedListResponse] feedList " + PbExtKt.e(feedCloudRead$StGetFeedListRsp.vecFeed));
                    } else {
                        ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
                    }
                    QFSLayerDefaultViewModel.this.U1(str, feedCloudRead$StGetFeedListRsp.isFirstLogin.get(), QFSLayerDefaultViewModel.this.K);
                } else {
                    ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
                }
                ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m.setCurrentState(4);
            }
        });
    }

    private void c3(final boolean z16, final long j3, final String str, final FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.QFSLayerDefaultViewModel.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                boolean z18;
                if (z16 && feedCloudRead$StGetMainPageCommDataRsp != null) {
                    boolean z19 = !TextUtils.isEmpty(((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m.getStringAttachInfo());
                    QLog.d("QFSLayerDefaultViewModel", 1, "[handleFeedListResponse] attachInfo: " + feedCloudRead$StGetMainPageCommDataRsp.feedAttchInfo.get() + " isLoadMore: " + z19);
                    ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m.setStringAttachInfo(feedCloudRead$StGetMainPageCommDataRsp.feedAttchInfo.get());
                    LoadInfo loadInfo = ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m;
                    if (feedCloudRead$StGetMainPageCommDataRsp.isFinish.get() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    loadInfo.setFinish(z17);
                    if (feedCloudRead$StGetMainPageCommDataRsp.extInfo.has()) {
                        QFSLayerDefaultViewModel.this.updateSession(feedCloudRead$StGetMainPageCommDataRsp.extInfo.get());
                    }
                    QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
                    if (feedCloudRead$StGetMainPageCommDataRsp.busiRspData.has()) {
                        try {
                            qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(feedCloudRead$StGetMainPageCommDataRsp.busiRspData.get().toByteArray());
                        } catch (InvalidProtocolBufferMicroException e16) {
                            e16.printStackTrace();
                        }
                    }
                    if (j3 == 0) {
                        QFSLayerDefaultViewModel.this.j2(qQCircleFeedBase$StFeedListBusiRspData.middlePageData);
                        w20.a.j().initOrUpdateGlobalState((List) e30.d.b(feedCloudRead$StGetMainPageCommDataRsp.vecFeed.get()), true);
                        QFSLayerDefaultViewModel.this.n3(feedCloudRead$StGetMainPageCommDataRsp);
                        QFSLayerDefaultViewModel qFSLayerDefaultViewModel = QFSLayerDefaultViewModel.this;
                        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetMainPageCommDataRsp.vecFeed.get();
                        if (feedCloudRead$StGetMainPageCommDataRsp.isFinish.get() > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        qFSLayerDefaultViewModel.k2(z19, list, z18, 0);
                        QLog.d("QFSLayerDefaultViewModel", 1, "[handleFeedListResponse] feedList " + PbExtKt.e(feedCloudRead$StGetMainPageCommDataRsp.vecFeed));
                    } else {
                        ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
                    }
                } else {
                    ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
                }
                ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m.setCurrentState(4);
            }
        });
    }

    private void d3(final boolean z16, final long j3, final String str, final FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.QFSLayerDefaultViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp2;
                if (z16 && (feedCloudRead$StGetFeedDetailRsp2 = feedCloudRead$StGetFeedDetailRsp) != null) {
                    if (feedCloudRead$StGetFeedDetailRsp2.extInfo.has()) {
                        QFSLayerDefaultViewModel.this.updateSession(feedCloudRead$StGetFeedDetailRsp.extInfo.get());
                    }
                    QFSLayerDefaultViewModel.this.U1(str, feedCloudRead$StGetFeedDetailRsp.isFirstLogin.get(), QFSLayerDefaultViewModel.this.K);
                    ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).f86506m.setCurrentState(4);
                    if (j3 == 0) {
                        QFSLayerDefaultViewModel.this.q3(str, feedCloudRead$StGetFeedDetailRsp);
                        QFSLayerDefaultViewModel.this.k2(false, Collections.singletonList(feedCloudRead$StGetFeedDetailRsp.feed.get()), true, 0);
                        w20.a.j().initOrUpdateGlobalState(((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).C, true);
                        return;
                    }
                    ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
                    return;
                }
                ((QFSLayerBaseViewModel) QFSLayerDefaultViewModel.this).D.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(false));
            }
        });
    }

    private boolean f3(QCircleInitBean qCircleInitBean) {
        if (W2(qCircleInitBean) == 13) {
            return true;
        }
        return false;
    }

    private boolean g3(QCircleInitBean qCircleInitBean) {
        if (W2(qCircleInitBean) == 14) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h3(String str, QCircleInitBean qCircleInitBean, BaseRequest baseRequest, boolean z16, long j3, String str2, FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        S1(z16, baseRequest, j3, str2, "getApertureFeedList");
        c3(z16, j3, str2, feedCloudRead$StGetMainPageCommDataRsp);
        if (z16 && j3 == 0) {
            m3(str, W2(qCircleInitBean));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i3(QFSGetMiddlePageFeedRequest qFSGetMiddlePageFeedRequest, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        S1(z16, qFSGetMiddlePageFeedRequest, j3, str, "getFeedList");
        b3(z16, j3, str, feedCloudRead$StGetFeedListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j3(QFSGetFeedDetailRequest qFSGetFeedDetailRequest, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
        S1(z16, qFSGetFeedDetailRequest, j3, str, "getSingleFeed");
        d3(z16, j3, str, feedCloudRead$StGetFeedDetailRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k3(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        S1(z16, baseRequest, j3, str, "getTagFeedList");
        b3(z16, j3, str, feedCloudRead$StGetFeedListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l3(Object[] objArr) {
        b3(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], (FeedCloudRead$StGetFeedListRsp) objArr[3]);
    }

    private void m3(String str, int i3) {
        if (i3 == 14) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPublicAccountFollowUserReadEvent(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        if (feedCloudRead$StGetMainPageCommDataRsp == null) {
            return;
        }
        this.N = feedCloudRead$StGetMainPageCommDataRsp.feedAttchInfo.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q3(String str, FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp) {
        if (!VSNetworkHelper.isProtocolCache(str) && feedCloudRead$StGetFeedDetailRsp != null) {
            w20.a.j().initOrUpdateGlobalState((List) e30.d.b(Collections.singletonList(feedCloudRead$StGetFeedDetailRsp.feed.get())), true);
        }
    }

    public void e3(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            this.L = qCircleInitBean.getSchemeAttrs().get("xsj_main_entrance");
            RFWLog.d("QFSLayerDefaultViewModel", RFWLog.USR, "[initSchemaParams] mLoginMainEntrance:" + this.L);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerDefaultViewModel";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e
    public boolean h2() {
        String[] split;
        if (!z20.g.a()) {
            return false;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_enable_load_more_back_up_feed_white_list", com.tencent.biz.qqcircle.immersive.layer.base.e.J);
        if (!TextUtils.isEmpty(loadAsString) && (split = loadAsString.split("\\|")) != null && split.length != 0) {
            for (String str : split) {
                if (TextUtils.equals(str, this.L)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void o3(final QCircleInitBean qCircleInitBean, boolean z16, final boolean z17) {
        if (qCircleInitBean == null) {
            QLog.d("QFSLayerDefaultViewModel", 1, "[requestFeedDetailAndList] bean is null. ");
            return;
        }
        QLog.d("QFSLayerDefaultViewModel", 1, "[requestFeedDetailAndList] isGetFeedList: " + z16 + ", isRefresh: " + z17);
        this.K = qCircleInitBean;
        e3(qCircleInitBean);
        P1().setCurrentState(3);
        this.D.setValue(UIStateData.obtainLoading());
        if (!z16) {
            Y2(qCircleInitBean);
            return;
        }
        if (qCircleInitBean.getTagInfo().has()) {
            if (PreLoader.exists("2005")) {
                PreLoader.addListener("2005", new OnTaskListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.h
                    @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
                    public final void onComplete(Object[] objArr) {
                        QFSLayerDefaultViewModel.this.l3(objArr);
                    }
                });
                return;
            } else {
                a3(qCircleInitBean.getTagInfo().tagId.get(), qCircleInitBean.getTagInfo().tagName.get());
                return;
            }
        }
        if (!f3(qCircleInitBean) && !g3(qCircleInitBean)) {
            boolean b16 = h20.c.b();
            QLog.d(getTAG(), 1, "[requestFeedDetailAndList] enableBuildRequestInSubThread:" + b16);
            if (b16) {
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.QFSLayerDefaultViewModel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSLayerDefaultViewModel.this.V2(qCircleInitBean, z17);
                    }
                });
                return;
            } else {
                V2(qCircleInitBean, z17);
                return;
            }
        }
        U2(qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public void onPreloadComplete(Object[] objArr) {
        super.onPreloadComplete(objArr);
        if (objArr.length >= 4 && (objArr[0] instanceof Boolean) && (objArr[1] instanceof Long) && (objArr[2] instanceof String)) {
            String b16 = n50.a.b(this.K);
            Object obj = objArr[3];
            if (obj instanceof FeedCloudRead$StGetFeedListRsp) {
                QLog.d("QFSLayerDefaultViewModel", 1, "get feedList from preload" + b16);
                b3(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], (FeedCloudRead$StGetFeedListRsp) objArr[3]);
                return;
            }
            if (obj instanceof FeedCloudRead$StGetFeedDetailRsp) {
                QLog.d("QFSLayerDefaultViewModel", 1, "get feedDetail from preload" + b16);
                d3(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], (FeedCloudRead$StGetFeedDetailRsp) objArr[3]);
            }
        }
    }

    public void p3(String str) {
        this.M = str;
    }
}
