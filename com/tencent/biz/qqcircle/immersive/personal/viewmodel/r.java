package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalBasicRequestEvent;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetCollectBoxListRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetCollectionListRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageBasicDataRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageCommDataRequest;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.r;
import com.tencent.biz.qqcircle.immersive.request.QFSDoUrgeRequest;
import com.tencent.biz.qqcircle.immersive.utils.am;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.Call;
import com.tencent.util.Pair;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudFavoritessvr$GetFavoritesListRsp;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$GetCollectionListRsp;
import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import feedcloud.FeedCloudRead$TaskEntry;
import feedcloud.FeedCloudRead$TaskEntryNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import o60.a;
import qqcircle.QQCircleLightinteract$StGetUrgeStatusRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r extends BaseViewModel implements Call.OnRspCallBack<QCircleBaseRequest>, IDataDisplaySurface<e30.b>, a.InterfaceC10889a {
    private final MutableLiveData<FeedCloudRead$TaskEntry> T;
    public LiveData<FeedCloudRead$TaskEntry> U;
    private final MutableLiveData<c> V;
    public LiveData<c> W;
    public MediatorLiveData<Pair<Boolean, Boolean>> X;
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f89159a0;

    /* renamed from: b0, reason: collision with root package name */
    private final MutableLiveData<Boolean> f89160b0;

    /* renamed from: c0, reason: collision with root package name */
    private final MutableLiveData<Boolean> f89161c0;

    /* renamed from: d0, reason: collision with root package name */
    private final MutableLiveData<Integer> f89162d0;

    /* renamed from: e0, reason: collision with root package name */
    private o60.a f89163e0;

    /* renamed from: i, reason: collision with root package name */
    private String f89164i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f89165m = false;
    public boolean C = false;
    public int D = ErrorCode.ERROR_CMD_INVALID;
    private String E = "qfs_personal_tab_product";
    private com.tencent.biz.qqcircle.immersive.personal.interceptor.e F = new com.tencent.biz.qqcircle.immersive.personal.interceptor.e();
    private com.tencent.biz.qqcircle.immersive.personal.interceptor.e G = new com.tencent.biz.qqcircle.immersive.personal.interceptor.e();
    private final v H = new v();
    private final com.tencent.biz.qqcircle.immersive.personal.bean.m I = new com.tencent.biz.qqcircle.immersive.personal.bean.m();
    private final MutableLiveData<FeedCloudMeta$StFeed> J = new MutableLiveData<>();
    private final MutableLiveData<Boolean> K = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<e30.b>>> L = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<e30.b>>> M = new MutableLiveData<>();
    private final MutableLiveData<String> N = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<FeedCloudMeta$FeedAlbum>>> P = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>>> Q = new MutableLiveData<>();
    private final MutableLiveData<List<FeedCloudFavoritessvr$FavoritesInfo>> R = new MutableLiveData<>();
    private final MutableLiveData<Integer> S = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$GetCollectionListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f89166a;

        a(boolean z16) {
            this.f89166a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$GetCollectionListRsp feedCloudRead$GetCollectionListRsp) {
            QLog.d("QFSPersonalViewModel", 1, "[requestCollectAlbum] -> traceId : " + baseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str);
            if (!z16 || j3 != 0 || feedCloudRead$GetCollectionListRsp == null) {
                r.this.z2(this.f89166a, str);
                return;
            }
            QLog.d("QFSPersonalViewModel", 1, "[requestCollectAlbum] -> result size : " + feedCloudRead$GetCollectionListRsp.collectionData.albumList.get().size());
            r.this.A2(this.f89166a, feedCloudRead$GetCollectionListRsp, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$GetFavoritesListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f89168a;

        b(boolean z16) {
            this.f89168a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$GetFavoritesListRsp feedCloudFavoritessvr$GetFavoritesListRsp) {
            QLog.d("QFSPersonalViewModel", 1, "[requestCollectBox] -> traceId : " + baseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str);
            if (!z16 || j3 != 0 || feedCloudFavoritessvr$GetFavoritesListRsp == null) {
                r.this.B2(this.f89168a, str);
            } else {
                r.this.C2(this.f89168a, feedCloudFavoritessvr$GetFavoritesListRsp, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f89170a;

        /* renamed from: b, reason: collision with root package name */
        private FeedCloudRead$TaskEntryNew f89171b;

        /* renamed from: c, reason: collision with root package name */
        private FeedCloudCommon$StCommonExt f89172c;

        public c c(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
            this.f89172c = feedCloudCommon$StCommonExt;
            return this;
        }

        public c d(FeedCloudRead$TaskEntryNew feedCloudRead$TaskEntryNew) {
            this.f89171b = feedCloudRead$TaskEntryNew;
            return this;
        }

        public c e(String str) {
            this.f89170a = str;
            return this;
        }
    }

    public r() {
        MutableLiveData<FeedCloudRead$TaskEntry> mutableLiveData = new MutableLiveData<>();
        this.T = mutableLiveData;
        this.U = mutableLiveData;
        MutableLiveData<c> mutableLiveData2 = new MutableLiveData<>();
        this.V = mutableLiveData2;
        this.W = mutableLiveData2;
        this.X = new MediatorLiveData<>();
        this.Y = "";
        this.Z = "";
        this.f89160b0 = new MutableLiveData<>();
        this.f89161c0 = new MutableLiveData<>();
        this.f89162d0 = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A2(boolean z16, FeedCloudRead$GetCollectionListRsp feedCloudRead$GetCollectionListRsp, String str) {
        int i3;
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        UIStateData<List<FeedCloudMeta$FeedAlbum>> value = this.P.getValue();
        ArrayList arrayList = new ArrayList();
        if (value == null) {
            value = UIStateData.obtainEmpty();
        }
        if (z16 && value.getData() != null) {
            arrayList.addAll(value.getData());
        }
        arrayList.addAll(feedCloudRead$GetCollectionListRsp.collectionData.albumList.get());
        value.setData(z16, arrayList);
        if (arrayList.size() == 0) {
            value.setState(0);
        } else {
            if (isProtocolCache) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            value.setState(i3);
        }
        value.setFinish(!feedCloudRead$GetCollectionListRsp.has_more.get());
        this.P.postValue(value);
        this.Y = feedCloudRead$GetCollectionListRsp.attach_info.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2(boolean z16, String str) {
        UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>> value = this.Q.getValue();
        if (value == null) {
            value = UIStateData.obtainError(str).setFinish(true);
        }
        value.setState(4);
        value.setFinish(true);
        value.setMsg(str);
        value.setLoadMore(z16);
        this.Q.postValue(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C2(boolean z16, FeedCloudFavoritessvr$GetFavoritesListRsp feedCloudFavoritessvr$GetFavoritesListRsp, String str) {
        int i3;
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>> value = this.Q.getValue();
        ArrayList arrayList = new ArrayList();
        if (value == null) {
            value = UIStateData.obtainEmpty();
        }
        if (z16 && value.getData() != null) {
            arrayList.addAll(value.getData());
        }
        arrayList.addAll(feedCloudFavoritessvr$GetFavoritesListRsp.favorites_list.get());
        value.setData(z16, arrayList);
        List<FeedCloudFavoritessvr$FavoritesInfo> value2 = this.R.getValue();
        if (value2 == null) {
            value2 = new ArrayList<>();
        }
        if (!z16) {
            value2 = feedCloudFavoritessvr$GetFavoritesListRsp.draft_favorites_list.get();
            this.R.postValue(value2);
        }
        if (arrayList.size() == 0 && value2.size() == 0) {
            value.setState(0);
        } else {
            if (isProtocolCache) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            value.setState(i3);
        }
        value.setFinish(!feedCloudFavoritessvr$GetFavoritesListRsp.has_more.get());
        this.Q.postValue(value);
        this.Z = feedCloudFavoritessvr$GetFavoritesListRsp.attch_info.get();
    }

    private void D2(@NonNull FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp, boolean z16) {
        QFSPersonalInfo value = this.I.getValue();
        if (value == null) {
            value = new QFSPersonalInfo();
        }
        if (TextUtils.isEmpty(value.i()) || com.tencent.biz.qqcircle.immersive.utils.r.e0(value.i())) {
            i3(feedCloudRead$StGetMainPageBasicDataRsp.user, true);
        }
        value.A(feedCloudRead$StGetMainPageBasicDataRsp);
        value.f88424k = z16;
        if (!z16) {
            w wVar = new w(feedCloudRead$StGetMainPageBasicDataRsp);
            QCircleFollowManager.getInstance().setUinFollowed(wVar.L(), wVar.c().followState.get());
            wVar.R();
            if (QCirclePluginUtil.isOwner(feedCloudRead$StGetMainPageBasicDataRsp.user)) {
                uq3.c.d7(feedCloudRead$StGetMainPageBasicDataRsp.user.icon.iconUrl.get());
                uq3.c.g7(feedCloudRead$StGetMainPageBasicDataRsp.user.nick.get());
                uq3.c.k7(feedCloudRead$StGetMainPageBasicDataRsp.user.qq_vip.get().toByteArray());
                if (feedCloudRead$StGetMainPageBasicDataRsp.task_entry_new != null) {
                    QLog.d("QFSPersonalViewModel", 1, "handleGetMainBasicDataPageRequestRsp... isOwner:" + QCirclePluginUtil.isOwner(feedCloudRead$StGetMainPageBasicDataRsp.user) + " personalInfo.feedNum:" + value.f88423j);
                    this.V.postValue(new c().e(feedCloudRead$StGetMainPageBasicDataRsp.user.f398463id.get()).d(feedCloudRead$StGetMainPageBasicDataRsp.task_entry_new).c(feedCloudRead$StGetMainPageBasicDataRsp.extInfo));
                }
            }
            FeedCloudRead$TaskEntry feedCloudRead$TaskEntry = feedCloudRead$StGetMainPageBasicDataRsp.taskEntry;
            if (feedCloudRead$TaskEntry != null) {
                this.T.postValue(feedCloudRead$TaskEntry.get());
            }
        }
    }

    private void E2(Object obj, boolean z16, boolean z17, long j3, String str) {
        if (obj instanceof UIStateData) {
            H2((UIStateData) obj);
        }
        if (!z16 && (obj instanceof FeedCloudRead$StGetMainPageCommDataRsp)) {
            FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp = (FeedCloudRead$StGetMainPageCommDataRsp) obj;
            QFSPersonalInfo value = this.I.getValue();
            if (value == null) {
                value = new QFSPersonalInfo();
            }
            value.L = z17;
            value.B(feedCloudRead$StGetMainPageCommDataRsp);
            value.x(j3);
            value.y(str);
            this.I.setValue(value);
            w value2 = this.H.getValue();
            if (value2 == null) {
                return;
            }
            value2.M(feedCloudRead$StGetMainPageCommDataRsp);
            value2.J(str);
            value2.I(j3);
            value2.R();
            U1(z17, value, feedCloudRead$StGetMainPageCommDataRsp);
        }
    }

    private void F2(Object obj, boolean z16, boolean z17, long j3, String str) {
        if (obj instanceof UIStateData) {
            G2((UIStateData) obj);
        }
    }

    private void G2(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData == null) {
            QLog.e("QFSPersonalViewModel", 1, "handlePrivateProdsFeedList uiStateData is null");
        } else {
            QLog.d("QFSPersonalViewModel", 1, "handlePrivateProdsFeedList update live data.");
            this.M.setValue(uIStateData);
        }
    }

    private void H2(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData == null) {
            QLog.e("QFSPersonalViewModel", 1, "handleProductsFeedList uiStateData is null");
        } else {
            QLog.d("QFSPersonalViewModel", 1, "handleProductsFeedList update live data.");
            this.L.setValue(uIStateData);
        }
    }

    private void I2(QCircleBaseRequest qCircleBaseRequest, boolean z16, String str) {
        com.tencent.biz.qqcircle.immersive.report.a.a(str, "", "");
        if (!z16) {
            com.tencent.biz.qqcircle.immersive.report.a.b(str, qCircleBaseRequest.get$cmd(), qCircleBaseRequest.getTraceId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M2(QFSPersonalInfo qFSPersonalInfo) {
        b40.d dVar;
        if (this.V.getValue() != null && qFSPersonalInfo != null && qFSPersonalInfo.f88416c != null && (dVar = qFSPersonalInfo.H) != null && dVar.a() != null) {
            boolean z16 = true;
            QLog.d("QFSPersonalViewModel", 1, "combineDataAddSource... A feedNum:" + qFSPersonalInfo.f88423j + " currentId:" + qFSPersonalInfo.f88416c.f398463id.get() + " id:" + this.V.getValue().f89170a + " isOwner:" + QCirclePluginUtil.isOwner(this.V.getValue().f89170a) + " album is empty:" + qFSPersonalInfo.H.a().isEmpty());
            if (qFSPersonalInfo.f88423j <= 0 || !QCirclePluginUtil.isOwner(this.V.getValue().f89170a)) {
                z16 = false;
            }
            if (this.V.getValue().f89171b.task_conf.get().isEmpty()) {
                if (this.I.getValue().H.a().isEmpty()) {
                    if (qFSPersonalInfo.f88416c.f398463id.get().equals(this.V.getValue().f89170a)) {
                        this.X.postValue(new Pair<>(Boolean.valueOf(z16), Boolean.FALSE));
                        return;
                    }
                    return;
                } else {
                    if (qFSPersonalInfo.f88416c.f398463id.get().equals(this.V.getValue().f89170a)) {
                        this.X.postValue(new Pair<>(Boolean.valueOf(z16), Boolean.TRUE));
                        return;
                    }
                    return;
                }
            }
            if (qFSPersonalInfo.f88416c.f398463id.get().equals(this.V.getValue().f89170a)) {
                this.X.postValue(new Pair<>(Boolean.valueOf(z16), Boolean.TRUE));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N2(c cVar) {
        boolean z16 = true;
        if (this.I.getValue() != null && this.I.getValue().H != null && this.I.getValue().f88416c != null && this.I.getValue().H.a() != null) {
            QLog.d("QFSPersonalViewModel", 1, "combineDataAddSource... B feedNum:" + this.I.getValue().f88423j + " currentId:" + this.I.getValue().f88416c.f398463id.get() + " id:" + cVar.f89170a + " isOwner:" + QCirclePluginUtil.isOwner(cVar.f89170a) + " album is empty:" + this.I.getValue().H.a().isEmpty());
            if (this.I.getValue().f88423j <= 0 || !QCirclePluginUtil.isOwner(cVar.f89170a)) {
                z16 = false;
            }
            if (cVar.f89171b.task_conf.get().isEmpty()) {
                if (this.I.getValue().H.a().isEmpty()) {
                    if (this.I.getValue().f88416c.f398463id.get().equals(cVar.f89170a)) {
                        this.X.postValue(new Pair<>(Boolean.valueOf(z16), Boolean.FALSE));
                        return;
                    }
                    return;
                } else {
                    if (this.I.getValue().f88416c.f398463id.get().equals(cVar.f89170a)) {
                        this.X.postValue(new Pair<>(Boolean.valueOf(z16), Boolean.TRUE));
                        return;
                    }
                    return;
                }
            }
            if (this.I.getValue().f88416c.f398463id.get().equals(cVar.f89170a)) {
                this.X.postValue(new Pair<>(Boolean.valueOf(z16), Boolean.TRUE));
                return;
            }
            return;
        }
        QLog.w("QFSPersonalViewModel", 1, "combineDataAddSource... B has null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O2(QFSDoUrgeRequest qFSDoUrgeRequest, boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.i("QFSPersonalViewModel", 1, "[sendPushMoreRequest] -> traceId = " + qFSDoUrgeRequest.getTraceId() + " , isSuccess = " + z16 + " , retCode = " + j3 + " , errMsg = " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R2(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        w wVar;
        this.f89163e0 = new o60.a(this);
        MutableLiveData globalData = w20.a.j().getGlobalData(w.class, feedCloudMeta$StUser.f398463id.get());
        if (globalData != null && globalData.getValue() != 0) {
            QLog.i("QFSPersonalViewModel", 1, "\u52a0\u8f7d\u6570\u636e\u4ed3\u5e93\u7528\u6237\u672c\u5730\u6570\u636e");
            wVar = (w) globalData.getValue();
        } else {
            wVar = new w(feedCloudMeta$StUser);
        }
        this.f89163e0.a(wVar);
    }

    private void U1(boolean z16, QFSPersonalInfo qFSPersonalInfo, FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        String str;
        boolean d16 = am.f90129a.d(qFSPersonalInfo);
        QLog.d("QFSPersonalViewModel", 1, "checkShowDraftGuide, show: " + d16 + ", isCache: " + z16);
        if (!z16) {
            MutableLiveData<String> mutableLiveData = this.N;
            if (d16) {
                str = feedCloudRead$StGetMainPageCommDataRsp.draftBoxButtonName.get();
            } else {
                str = null;
            }
            mutableLiveData.setValue(str);
        }
    }

    private void a3(String str, FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp) {
        if (feedCloudRead$StGetMainPageBasicDataRsp == null) {
            return;
        }
        String str2 = feedCloudRead$StGetMainPageBasicDataRsp.user.f398463id.get();
        QLog.d("QFSPersonalViewModel", 1, "[requestCommDataAgainIfNeed] old uin: " + str + ", real uin: " + str2);
        if (com.tencent.biz.qqcircle.immersive.utils.r.e0(str)) {
            QLog.d("QFSPersonalViewModel", 1, "request again.");
            com.tencent.biz.qqcircle.immersive.personal.request.b.o(str2, this.F, this, true, -1, false);
        }
    }

    private String x2() {
        if (TextUtils.isEmpty(this.f89164i)) {
            this.f89164i = i2();
        }
        return this.f89164i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2(boolean z16, String str) {
        UIStateData<List<FeedCloudMeta$FeedAlbum>> value = this.P.getValue();
        if (value == null) {
            value = UIStateData.obtainError(str).setFinish(true);
        }
        value.setState(4);
        value.setFinish(true);
        value.setMsg(str);
        value.setLoadMore(z16);
        this.P.postValue(value);
    }

    public boolean J2() {
        if (this.K.getValue() == null) {
            return true;
        }
        return this.K.getValue().booleanValue();
    }

    public boolean K2() {
        if (this.I.getValue() == null) {
            return false;
        }
        return this.I.getValue().f88426m;
    }

    public boolean L2() {
        if (this.I.getValue() == null) {
            return false;
        }
        return this.I.getValue().f88425l;
    }

    public void P2() {
        if (!T1(this.M.getValue()) && !S1(this.M.getValue())) {
            com.tencent.biz.qqcircle.immersive.personal.request.b.f(i2(), this.G, this, true);
        } else {
            QLog.i("QFSPersonalViewModel", 1, "[loadMorePrivateProds] -> isLoading cancel");
        }
    }

    protected void Q2() {
        if (!T1(this.L.getValue()) && !S1(this.L.getValue())) {
            com.tencent.biz.qqcircle.immersive.personal.request.b.f(i2(), this.F, this, false);
        } else {
            QLog.i("QFSPersonalViewModel", 1, "[loadMoreProducts] -> isLoading cancel");
        }
    }

    public boolean S1(UIStateData uIStateData) {
        if (uIStateData == null) {
            return false;
        }
        return uIStateData.isLoading();
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: S2, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.d("QFSPersonalViewModel", 1, "[onReceive] -> request = " + qCircleBaseRequest + " , traceId : " + qCircleBaseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str + " , ownerUin : " + i2() + " , isCache : " + VSNetworkHelper.isProtocolCache(str));
        if (qCircleBaseRequest instanceof QFSGetMainPageCommDataRequest) {
            QFSGetMainPageCommDataRequest qFSGetMainPageCommDataRequest = (QFSGetMainPageCommDataRequest) qCircleBaseRequest;
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            if (qFSGetMainPageCommDataRequest.isPrivateProdsReq()) {
                QLog.i("QFSPersonalViewModel", 1, "[onReceive] -> private_prods request, traceId : " + qCircleBaseRequest.getTraceId());
                F2(obj, qFSGetMainPageCommDataRequest.isLoadMore(), isProtocolCache, j3, str);
                return;
            }
            QLog.i("QFSPersonalViewModel", 1, "[onReceive] -> public_prods request, traceId : " + qCircleBaseRequest.getTraceId());
            if (z16 && j3 == 0) {
                I2(qCircleBaseRequest, isProtocolCache, "mainpage_body");
            }
            E2(obj, qFSGetMainPageCommDataRequest.isLoadMore(), isProtocolCache, j3, str);
            return;
        }
        if (qCircleBaseRequest instanceof QFSGetMainPageBasicDataRequest) {
            if (z16 && j3 == 0 && (obj instanceof FeedCloudRead$StGetMainPageBasicDataRsp)) {
                boolean isProtocolCache2 = VSNetworkHelper.isProtocolCache(str);
                I2(qCircleBaseRequest, isProtocolCache2, "mainpage_header");
                FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp = (FeedCloudRead$StGetMainPageBasicDataRsp) obj;
                D2(feedCloudRead$StGetMainPageBasicDataRsp, isProtocolCache2);
                a3(((QFSGetMainPageBasicDataRequest) qCircleBaseRequest).getUin(), feedCloudRead$StGetMainPageBasicDataRsp);
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalBasicRequestEvent(i2(), str, j3));
            w value = this.H.getValue();
            if (value == null) {
                return;
            }
            value.d().i(false);
            value.j("update_version_op_mask");
            this.H.setValue(value);
        }
    }

    public boolean T1(UIStateData uIStateData) {
        if (uIStateData == null) {
            return false;
        }
        if (!uIStateData.isLoading() && !uIStateData.isCacheData()) {
            return false;
        }
        return true;
    }

    public void T2(boolean z16) {
        QLog.d("QFSPersonalViewModel", 4, "[refresh] -> isOpenCache = " + z16);
        U2(z16, -1, null);
    }

    public void U2(boolean z16, int i3, HashMap<String, String> hashMap) {
        QLog.d("QFSPersonalViewModel", 4, "[refresh] -> isOpenCache = " + z16 + ", draftCount = " + i3);
        this.f89162d0.setValue(Integer.valueOf(ErrorCode.ERROR_CMD_INVALID));
        b3(z16, i3, hashMap);
        this.K.setValue(Boolean.FALSE);
    }

    public void V2() {
        this.L.setValue(UIStateData.obtainSuccess(false).setData(false, new ArrayList()).setFinish(true));
    }

    public void W1() {
        QLog.d("QFSPersonalViewModel", 1, "combineDataAddSource...");
        this.X.removeSource(this.I);
        this.X.addSource(this.I, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                r.this.M2((QFSPersonalInfo) obj);
            }
        });
        this.X.removeSource(this.V);
        this.X.addSource(this.V, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                r.this.N2((r.c) obj);
            }
        });
    }

    public void W2(boolean z16) {
        String str;
        QLog.i("QFSPersonalViewModel", 1, "[requestCollectAlbum] -> " + i2() + ", isLoadMore:" + z16);
        if (T1(this.P.getValue())) {
            return;
        }
        QFSGetCollectionListRequest.b g16 = new QFSGetCollectionListRequest.b(i2()).g(1);
        if (z16) {
            str = this.Y;
        } else {
            str = "";
        }
        VSNetworkHelper.getInstance().sendRequest(g16.f(str).a(), new a(z16));
    }

    public boolean X1(String str) {
        Iterator<e30.b> it = this.F.f().iterator();
        while (it.hasNext()) {
            e30.b next = it.next();
            if (next.g() != null && TextUtils.equals(next.g().f398449id.get(), str)) {
                it.remove();
                this.L.setValue(com.tencent.biz.qqcircle.immersive.utils.r.Q0(this.L.getValue(), this.F.f()));
                return true;
            }
        }
        return false;
    }

    public void Y2(boolean z16) {
        String str;
        QLog.i("QFSPersonalViewModel", 1, "[requestCollectBox] -> " + i2());
        if (T1(this.Q.getValue())) {
            return;
        }
        QFSGetCollectBoxListRequest.a aVar = new QFSGetCollectBoxListRequest.a(i2());
        if (z16) {
            str = this.Z;
        } else {
            str = "";
        }
        VSNetworkHelper.getInstance().sendRequest(aVar.f(str).a(), new b(z16));
    }

    public boolean Z1(String str) {
        Iterator<e30.b> it = this.G.f().iterator();
        while (it.hasNext()) {
            e30.b next = it.next();
            if (next.g() != null && TextUtils.equals(next.g().f398449id.get(), str)) {
                it.remove();
                this.M.setValue(com.tencent.biz.qqcircle.immersive.utils.r.Q0(this.M.getValue(), this.G.f()));
                return true;
            }
        }
        return false;
    }

    public void a2(b40.a aVar) {
        int i3;
        if (this.I.getValue() != null && this.I.getValue().j() != null) {
            List<b40.a> a16 = this.I.getValue().j().a();
            Iterator<b40.a> it = a16.iterator();
            while (it.hasNext()) {
                if (it.next().l() == 2) {
                    it.remove();
                }
            }
            Iterator<b40.a> it5 = a16.iterator();
            while (it5.hasNext()) {
                if (it5.next().k().longValue() == aVar.k().longValue()) {
                    return;
                }
            }
            if (a16.size() > 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            a16.add(i3, aVar);
            QFSPersonalInfo value = this.I.getValue();
            b40.d j3 = this.I.getValue().j();
            value.z(new b40.d(j3.d(), j3.c(), j3.e(), a16));
            this.I.setValue(value);
        }
    }

    @Override // o60.a.InterfaceC10889a
    public void b1(w wVar) {
        this.H.setValue(wVar);
    }

    public void b2(long j3) {
        if (this.I.getValue() != null && this.I.getValue().j() != null) {
            List<b40.a> a16 = this.I.getValue().j().a();
            Iterator<b40.a> it = a16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (j3 == it.next().k().longValue()) {
                    it.remove();
                    break;
                }
            }
            QFSPersonalInfo value = this.I.getValue();
            b40.d j16 = this.I.getValue().j();
            value.z(new b40.d(j16.d(), j16.c(), j16.e(), a16));
            this.I.setValue(value);
        }
    }

    public void b3(boolean z16, int i3, HashMap<String, String> hashMap) {
        if (T1(this.L.getValue())) {
            return;
        }
        k3(this.L);
        com.tencent.biz.qqcircle.immersive.personal.request.b.i(i2(), this, z16, this.f89159a0, l2(), hashMap);
        com.tencent.biz.qqcircle.immersive.personal.request.b.o(i2(), this.F, this, z16, i3, false);
    }

    public void c2(b40.a aVar) {
        if (this.I.getValue() != null && this.I.getValue().j() != null) {
            List<b40.a> a16 = this.I.getValue().j().a();
            int i3 = 0;
            int i16 = -1;
            boolean z16 = false;
            int i17 = 0;
            for (int i18 = 0; i18 < a16.size(); i18++) {
                if (a16.get(i18).k().longValue() == aVar.k().longValue()) {
                    if (a16.get(i18).l() == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    i17 = a16.get(i18).g();
                    i16 = i18;
                }
            }
            if (i16 != -1) {
                if (z16) {
                    i3 = 2;
                }
                aVar.q(i3);
                aVar.f().album.feed_count.set(i17);
                a16.remove(i16);
                a16.add(i16, aVar);
                QFSPersonalInfo value = this.I.getValue();
                b40.d j3 = this.I.getValue().j();
                value.z(new b40.d(j3.d(), j3.c(), j3.e(), a16));
                this.I.setValue(value);
            }
        }
    }

    public void c3(boolean z16, int i3) {
        com.tencent.biz.qqcircle.immersive.personal.request.b.o(i2(), this.G, this, z16, i3, true);
    }

    public MutableLiveData<UIStateData<List<FeedCloudMeta$FeedAlbum>>> d2() {
        return this.P;
    }

    public void d3() {
        this.L.setValue(null);
        this.M.setValue(null);
        this.F = new com.tencent.biz.qqcircle.immersive.personal.interceptor.e();
        this.G = new com.tencent.biz.qqcircle.immersive.personal.interceptor.e();
        this.D = ErrorCode.ERROR_CMD_INVALID;
    }

    public MutableLiveData<UIStateData<List<FeedCloudFavoritessvr$FavoritesInfo>>> e2() {
        return this.Q;
    }

    public void e3() {
        int i3;
        if (this.H.getValue() == null || (i3 = this.H.getValue().e().urgeStatus.get()) == 0) {
            return;
        }
        if (i3 == 2) {
            QCircleToast.l(QCircleToast.f91643c, uq3.c.X1(), 0, true, false);
            return;
        }
        final QFSDoUrgeRequest a16 = new QFSDoUrgeRequest.a(i2(), 0).a();
        new QQCircleLightinteract$StGetUrgeStatusRsp().urgeStatus.set(2);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().addRequest(a16).addReqInterceptor(new com.tencent.biz.qqcircle.immersive.personal.interceptor.g()).m250setRspOnCallBack(new Call.OnRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.o
            @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
            public final void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
                r.O2(QFSDoUrgeRequest.this, z16, j3, str, (QCircleBaseRequest) obj, obj2, bundle);
            }
        }).execute();
    }

    public MutableLiveData<String> f2() {
        return this.N;
    }

    public void f3(int i3) {
        this.f89159a0 = i3;
    }

    public MutableLiveData<QFSPersonalInfo> g2() {
        return this.I;
    }

    public void g3(boolean z16) {
        this.f89165m = z16;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof QCircleInitBean) {
                QCircleInitBean qCircleInitBean = (QCircleInitBean) obj;
                if (qCircleInitBean.getExtraTypeInfo() == null) {
                    return null;
                }
                int i3 = qCircleInitBean.getExtraTypeInfo().sourceType;
                if (i3 != 20101) {
                    if (i3 != 20112) {
                        if (i3 != 20105 && i3 != 20106) {
                            return null;
                        }
                    } else {
                        return this.M;
                    }
                }
                return this.L;
            }
        }
        return null;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalViewModel";
    }

    public MutableLiveData<Boolean> h2() {
        return this.K;
    }

    public void h3(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.i("QFSPersonalViewModel", 1, "setPreFeed() -> stFeed is null");
        } else if (this.J.getValue() != null && TextUtils.equals(this.J.getValue().f398449id.get(), feedCloudMeta$StFeed.f398449id.get())) {
            QLog.i("QFSPersonalViewModel", 1, "setPreFeed() -> same stFeed");
        } else {
            this.J.setValue(feedCloudMeta$StFeed);
            i3(feedCloudMeta$StFeed.poster, false);
        }
    }

    public String i2() {
        if (this.I.getValue() != null) {
            return this.I.getValue().f88420g;
        }
        return "";
    }

    public void i3(FeedCloudMeta$StUser feedCloudMeta$StUser, boolean z16) {
        if (feedCloudMeta$StUser == null) {
            QLog.i("QFSPersonalViewModel", 1, "setStUser() -> stUser is null");
            return;
        }
        if (this.I.getValue() != null && TextUtils.equals(this.I.getValue().f88420g, feedCloudMeta$StUser.f398463id.get()) && z16) {
            QLog.i("QFSPersonalViewModel", 1, "setStUser() -> same user");
            return;
        }
        QFSPersonalInfo qFSPersonalInfo = new QFSPersonalInfo(feedCloudMeta$StUser);
        qFSPersonalInfo.f88424k = true;
        this.I.setValue(qFSPersonalInfo);
        this.K.setValue(Boolean.TRUE);
        d3();
        R2(feedCloudMeta$StUser);
    }

    public QFSPersonalInfo j2() {
        QFSPersonalInfo value = this.I.getValue();
        if (value == null) {
            QLog.i("QFSPersonalViewModel", 1, "getPersonalInfo -> personalInfo is null");
            return new QFSPersonalInfo();
        }
        return value;
    }

    public void j3(String str) {
        this.E = str;
    }

    public MutableLiveData<FeedCloudMeta$StFeed> k2() {
        return this.J;
    }

    protected void k3(MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData) {
        UIStateData<List<e30.b>> obtainLoading;
        if (mutableLiveData.getValue() != null) {
            obtainLoading = mutableLiveData.getValue();
            obtainLoading.setState(1);
        } else {
            obtainLoading = UIStateData.obtainLoading();
        }
        mutableLiveData.setValue(obtainLoading);
    }

    public String l2() {
        if (this.J.getValue() == null) {
            return "";
        }
        return this.J.getValue().f398449id.get();
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof QCircleInitBean) {
                QCircleInitBean qCircleInitBean = (QCircleInitBean) obj;
                if (qCircleInitBean.getExtraTypeInfo() == null) {
                    return;
                }
                n(qCircleInitBean.getExtraTypeInfo().sourceType);
            }
        }
    }

    public MutableLiveData<UIStateData<List<e30.b>>> m2() {
        return this.M;
    }

    public void n(int i3) {
        QLog.i("QFSPersonalViewModel", 1, "[loadMore] -> sourceType = " + i3);
        if (i3 != 20101) {
            if (i3 == 20112) {
                P2();
                return;
            }
            return;
        }
        Q2();
    }

    public com.tencent.biz.qqcircle.immersive.personal.interceptor.e n2() {
        return this.F;
    }

    public MutableLiveData<UIStateData<List<e30.b>>> o2() {
        return this.L;
    }

    public MutableLiveData<Integer> p2() {
        return this.f89162d0;
    }

    public MutableLiveData<List<FeedCloudFavoritessvr$FavoritesInfo>> q2() {
        return this.R;
    }

    public MutableLiveData<Boolean> r2() {
        return this.f89161c0;
    }

    public MutableLiveData<Boolean> s2() {
        return this.f89160b0;
    }

    public String t2() {
        return this.E;
    }

    public MutableLiveData<Integer> u2() {
        return this.S;
    }

    public w v2() {
        if (this.H.getValue() == null) {
            QLog.i("QFSPersonalViewModel", 1, "getUserInfo -> userInfo is null");
            return new w();
        }
        return this.H.getValue();
    }

    public v w2() {
        return this.H;
    }

    public String y2() {
        StringBuilder sb5;
        String x26;
        if (this.f89165m) {
            sb5 = new StringBuilder();
            sb5.append(hashCode());
            x26 = "";
        } else {
            sb5 = new StringBuilder();
            sb5.append(hashCode());
            x26 = x2();
        }
        sb5.append(x26);
        String sb6 = sb5.toString();
        QLog.i("QFSPersonalViewModel", 1, "[getViewModelKey] ->isHomePage = " + this.f89165m + ",viewModelKey = " + sb6);
        return sb6;
    }
}
