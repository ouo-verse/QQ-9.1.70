package com.qzone.reborn.feedx.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.feedx.bean.QZoneFeedEventTagInitBean;
import com.qzone.reborn.feedx.request.QZoneFeedxEventTagHeadRequest;
import com.qzone.reborn.feedx.request.QZoneFeedxEventTagListRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StFeed;
import qzone.QZoneTagFeedList$GetTagFeedListHeadRsp;
import qzone.QZoneTagFeedList$GetTagFeedListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\u000f\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u001e\u0010\u0014\u001a\u00020\u00022\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0006\u0010\u001c\u001a\u00020\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u001e\u0010\"\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010!\u001a\u00020 H\u0016J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0012J\u000e\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0012J\b\u0010'\u001a\u00020\u0002H\u0016R$\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020(8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R(\u00107\u001a\b\u0012\u0004\u0012\u0002000/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R)\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100/8\u0006\u00a2\u0006\f\n\u0004\b8\u00102\u001a\u0004\b9\u00104R%\u0010>\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010\u00040\u00040/8\u0006\u00a2\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u00104R\"\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00120C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "Ltc/b;", "", "K2", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, VideoProxy.PARAM_ENABLE_CACHE, "L2", QAdRewardDefine$VideoParams.ISCACHE, "Lqzone/QZoneTagFeedList$GetTagFeedListRsp;", "rsp", NowProxyConstants.AccountInfoKey.A2, Constants.BASE_IN_PLUGIN_VERSION, "F2", "isFinish", Constants.MMCCID, "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "H2", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "E2", "Lcom/qzone/feed/business/service/a;", "R1", "J2", "P1", "f2", "feedsData", "", "loadType", "g2", "feedData", "z2", "realFeed", "C2", "L1", "Lcom/qzone/reborn/feedx/bean/QZoneFeedEventTagInitBean;", "<set-?>", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/bean/QZoneFeedEventTagInitBean;", "v2", "()Lcom/qzone/reborn/feedx/bean/QZoneFeedEventTagInitBean;", "initBean", "Landroidx/lifecycle/MutableLiveData;", "Lqzone/QZoneTagFeedList$GetTagFeedListHeadRsp;", "G", "Landroidx/lifecycle/MutableLiveData;", "w2", "()Landroidx/lifecycle/MutableLiveData;", "setMEventTagHeadData", "(Landroidx/lifecycle/MutableLiveData;)V", "mEventTagHeadData", "H", "x2", "mFeedListData", "kotlin.jvm.PlatformType", "I", "y2", "mShouldScrollTop", "", "J", "Ljava/util/Map;", "mPublishFeedDataMap", "", "K", "Ljava/util/List;", "mAllFeedData", "Lcom/qzone/feed/business/service/QZoneFeedService;", "L", "Lcom/qzone/feed/business/service/QZoneFeedService;", "mCurService", "M", "Ljava/lang/String;", "mAttachInfo", "N", "Z", "mIsFinish", "<init>", "()V", "P", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagViewModel extends tc.b {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneFeedEventTagInitBean initBean;

    /* renamed from: G, reason: from kotlin metadata */
    private MutableLiveData<QZoneTagFeedList$GetTagFeedListHeadRsp> mEventTagHeadData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<List<BusinessFeedData>>> mFeedListData = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> mShouldScrollTop = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: J, reason: from kotlin metadata */
    private Map<String, BusinessFeedData> mPublishFeedDataMap = new LinkedHashMap();

    /* renamed from: K, reason: from kotlin metadata */
    private final List<BusinessFeedData> mAllFeedData = new ArrayList();

    /* renamed from: L, reason: from kotlin metadata */
    private QZoneFeedService mCurService;

    /* renamed from: M, reason: from kotlin metadata */
    private String mAttachInfo;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsFinish;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZoneTagFeedList$GetTagFeedListHeadRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "baseRequest", "", "isSuccess", "", "retCode", "", "errorMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<QZoneTagFeedList$GetTagFeedListHeadRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean isSuccess, long retCode, String errorMsg, QZoneTagFeedList$GetTagFeedListHeadRsp rsp) {
            Intrinsics.checkNotNullParameter(baseRequest, "baseRequest");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
            QLog.d(QZoneFeedxEventTagViewModel.this.getTAG(), 1, hashCode() + " | requestEventTagHead onReceive: dispatch Success:" + isSuccess + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + retCode + " | retMessage:" + errorMsg + " | isCache:" + isProtocolCache);
            if (isSuccess && retCode == 0 && rsp != null) {
                QZoneFeedxEventTagViewModel.this.w2().postValue(rsp);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel$c", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZoneTagFeedList$GetTagFeedListRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "baseRequest", "", "isSuccess", "", "retCode", "", "errorMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements VSDispatchObserver.OnVSRspCallBack<QZoneTagFeedList$GetTagFeedListRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f55879b;

        c(boolean z16) {
            this.f55879b = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean isSuccess, long retCode, String errorMsg, QZoneTagFeedList$GetTagFeedListRsp rsp) {
            PBRepeatMessageField<QZoneBaseMeta$StFeed> pBRepeatMessageField;
            Intrinsics.checkNotNullParameter(baseRequest, "baseRequest");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
            QLog.d(QZoneFeedxEventTagViewModel.this.getTAG(), 1, hashCode() + " | requestEventTagList onReceive: dispatch Success:" + isSuccess + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + retCode + " | retMessage:" + errorMsg + " | isLoadMore:" + this.f55879b + " | isCache:" + isProtocolCache + " | size:" + ((rsp == null || (pBRepeatMessageField = rsp.feed) == null) ? 0 : pBRepeatMessageField.size()));
            if (!isSuccess || retCode != 0) {
                QZoneFeedxEventTagViewModel.this.H2(UIStateData.obtainError(errorMsg).setRetCode(retCode).setLoadMore(this.f55879b));
            } else {
                QZoneFeedxEventTagViewModel.this.A2(isProtocolCache, rsp, this.f55879b);
            }
        }
    }

    public QZoneFeedxEventTagViewModel() {
        QZoneFeedService W = QZoneFeedService.W();
        Intrinsics.checkNotNullExpressionValue(W, "getEventTagFeedsService()");
        this.mCurService = W;
        this.mAttachInfo = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A2(final boolean isCache, final QZoneTagFeedList$GetTagFeedListRsp rsp, final boolean isLoadMore) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.feedx.viewmodel.j
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxEventTagViewModel.B2(QZoneFeedxEventTagViewModel.this, rsp, isLoadMore, isCache);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(QZoneFeedxEventTagViewModel this$0, QZoneTagFeedList$GetTagFeedListRsp qZoneTagFeedList$GetTagFeedListRsp, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D2(qZoneTagFeedList$GetTagFeedListRsp);
        boolean F2 = this$0.F2(qZoneTagFeedList$GetTagFeedListRsp);
        this$0.mIsFinish = F2;
        this$0.G2(qZoneTagFeedList$GetTagFeedListRsp, z16, z17, F2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H2(final UIStateData<List<BusinessFeedData>> data) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.viewmodel.i
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxEventTagViewModel.I2(QZoneFeedxEventTagViewModel.this, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(QZoneFeedxEventTagViewModel this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mFeedListData.setValue(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K2() {
        QZoneFeedxEventTagHeadRequest qZoneFeedxEventTagHeadRequest = new QZoneFeedxEventTagHeadRequest(v2().getEventTag());
        qZoneFeedxEventTagHeadRequest.setEnableCache(true);
        sendRequest(qZoneFeedxEventTagHeadRequest, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2(boolean isLoadMore, boolean enableCache) {
        String str;
        String eventTag = v2().getEventTag();
        if (isLoadMore) {
            str = this.mAttachInfo;
        } else {
            str = "";
        }
        QZoneFeedxEventTagListRequest qZoneFeedxEventTagListRequest = new QZoneFeedxEventTagListRequest(eventTag, str);
        qZoneFeedxEventTagListRequest.setEnableCache(enableCache);
        sendRequest(qZoneFeedxEventTagListRequest, new c(isLoadMore));
    }

    public final void C2(BusinessFeedData realFeed) {
        Intrinsics.checkNotNullParameter(realFeed, "realFeed");
        int i3 = 0;
        for (Object obj : this.mAllFeedData) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            BusinessFeedData businessFeedData = (BusinessFeedData) obj;
            CellFeedCommInfo cellFeedCommInfo = realFeed.cellFeedCommInfo;
            String str = cellFeedCommInfo != null ? cellFeedCommInfo.clientkey : null;
            CellFeedCommInfo cellFeedCommInfo2 = businessFeedData.cellFeedCommInfo;
            if (Intrinsics.areEqual(str, cellFeedCommInfo2 != null ? cellFeedCommInfo2.clientkey : null)) {
                this.mAllFeedData.set(i3, realFeed);
                QLog.d("QZoneFeedxEventTagViewModel", 1, "[handlePublishMoodSuccess] update feed");
            }
            i3 = i16;
        }
        H2(UIStateData.obtainSuccess(false).setDataList(this.mAllFeedData));
    }

    @Override // tc.b, com.qzone.reborn.base.n
    public void L1() {
        super.L1();
        this.mCurService.close();
    }

    @Override // tc.b
    public void P1() {
        super.P1();
        QLog.d("QZoneFeedxEventTagViewModel", 1, "doRefresh");
        L2(false, false);
    }

    @Override // tc.b
    /* renamed from: R1 */
    public com.qzone.feed.business.service.a getMCurService() {
        return this.mCurService;
    }

    @Override // tc.b
    public void f2() {
        QLog.d("QZoneFeedxEventTagViewModel", 1, "loadMoreFeeds");
        L2(true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[EDGE_INSN: B:34:0x009b->B:35:0x009b BREAK  A[LOOP:1: B:22:0x006f->B:46:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[LOOP:1: B:22:0x006f->B:46:?, LOOP_END, SYNTHETIC] */
    @Override // tc.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g2(List<? extends BusinessFeedData> feedsData, int loadType) {
        Object obj;
        boolean z16;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(feedsData, "feedsData");
        super.g2(feedsData, loadType);
        if (bl.b(feedsData)) {
            QLog.e("QZoneFeedxEventTagViewModel", 1, "[onFeedDataChange] feedsData isEmpty");
            return;
        }
        BusinessFeedData businessFeedData = feedsData.get(0);
        CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
        String str = cellBottomRecomm != null ? cellBottomRecomm.title : null;
        QZoneTagFeedList$GetTagFeedListHeadRsp value = this.mEventTagHeadData.getValue();
        boolean equals = TextUtils.equals(str, (value == null || (pBStringField = value.tag_name) == null) ? null : pBStringField.get());
        if (businessFeedData.isFakeFeed() && equals) {
            z2(businessFeedData);
        }
        for (Map.Entry<String, BusinessFeedData> entry : this.mPublishFeedDataMap.entrySet()) {
            Iterator<T> it = feedsData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                BusinessFeedData businessFeedData2 = (BusinessFeedData) obj;
                if (!businessFeedData2.isFakeFeed()) {
                    String key = entry.getKey();
                    CellFeedCommInfo cellFeedCommInfo = businessFeedData2.cellFeedCommInfo;
                    if (Intrinsics.areEqual(key, cellFeedCommInfo != null ? cellFeedCommInfo.clientkey : null)) {
                        z16 = true;
                        if (!z16) {
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            BusinessFeedData businessFeedData3 = (BusinessFeedData) obj;
            if (businessFeedData3 != null && entry.getValue().isFakeFeed()) {
                this.mPublishFeedDataMap.put(entry.getKey(), businessFeedData3);
                C2(businessFeedData3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxEventTagViewModel";
    }

    public final QZoneFeedEventTagInitBean v2() {
        QZoneFeedEventTagInitBean qZoneFeedEventTagInitBean = this.initBean;
        if (qZoneFeedEventTagInitBean != null) {
            return qZoneFeedEventTagInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final MutableLiveData<QZoneTagFeedList$GetTagFeedListHeadRsp> w2() {
        return this.mEventTagHeadData;
    }

    public final MutableLiveData<UIStateData<List<BusinessFeedData>>> x2() {
        return this.mFeedListData;
    }

    public final MutableLiveData<Boolean> y2() {
        return this.mShouldScrollTop;
    }

    public final void z2(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        QLog.i("QZoneFeedxEventTagViewModel", 1, "[handleFakePublishMoodSuccess] insert feed ");
        if (feedData.cellFeedCommInfo == null) {
            return;
        }
        if (!bl.b(this.mAllFeedData)) {
            CellFeedCommInfo cellFeedCommInfo = this.mAllFeedData.get(0).cellFeedCommInfo;
            if (!Intrinsics.areEqual(cellFeedCommInfo != null ? cellFeedCommInfo.clientkey : null, feedData.cellFeedCommInfo.clientkey)) {
                this.mAllFeedData.add(0, feedData);
                this.mShouldScrollTop.setValue(Boolean.TRUE);
            }
        } else {
            this.mAllFeedData.add(0, feedData);
            this.mShouldScrollTop.setValue(Boolean.TRUE);
        }
        Map<String, BusinessFeedData> map = this.mPublishFeedDataMap;
        String str = feedData.cellFeedCommInfo.clientkey;
        Intrinsics.checkNotNullExpressionValue(str, "feedData.cellFeedCommInfo.clientkey");
        map.put(str, feedData);
        H2(UIStateData.obtainSuccess(false).setDataList(this.mAllFeedData));
    }

    public final void J2() {
        QLog.d("QZoneFeedxEventTagViewModel", 1, "refreshData");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new QZoneFeedxEventTagViewModel$refreshData$1(this, null), 2, null);
    }

    private final boolean F2(QZoneTagFeedList$GetTagFeedListRsp rsp) {
        PBBoolField pBBoolField;
        if (rsp == null || (pBBoolField = rsp.has_finish) == null) {
            return true;
        }
        return pBBoolField.get();
    }

    public final void E2(Activity activity) {
        Intent intent;
        Bundle extras;
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || !extras.containsKey("qzone_route_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("qzone_route_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.feedx.bean.QZoneFeedEventTagInitBean");
        this.initBean = (QZoneFeedEventTagInitBean) serializable;
    }

    private final void D2(QZoneTagFeedList$GetTagFeedListRsp rsp) {
        if (rsp == null) {
            return;
        }
        String str = rsp.attach_info.get();
        Intrinsics.checkNotNullExpressionValue(str, "rsp.attach_info.get()");
        this.mAttachInfo = str;
    }

    private final void G2(QZoneTagFeedList$GetTagFeedListRsp rsp, boolean isLoadMore, boolean isCache, boolean isFinish) {
        if (rsp == null) {
            return;
        }
        if (!isLoadMore) {
            this.mAllFeedData.clear();
        }
        ArrayList arrayList = new ArrayList();
        for (QZoneBaseMeta$StFeed stFeed : rsp.feed.get()) {
            oj.a aVar = oj.a.f423008a;
            Intrinsics.checkNotNullExpressionValue(stFeed, "stFeed");
            QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = rsp.ext;
            Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "rsp.ext");
            arrayList.add(aVar.B(stFeed, qZoneBaseCommon$StCommonExt));
        }
        this.mAllFeedData.addAll(arrayList);
        H2(UIStateData.obtainSuccess(isCache).setFinish(isFinish).setData(isLoadMore, this.mAllFeedData));
    }
}
