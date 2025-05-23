package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QFSUpdateFeedListEvent;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel;
import com.tencent.biz.qqcircle.immersive.layer.base.e;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import z20.g;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J4\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000bJ \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J,\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\"J\u0012\u0010&\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010%H\u0016J\b\u0010'\u001a\u00020\u000bH\u0016J(\u0010+\u001a\"\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010)\u0018\u00010(j\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010)\u0018\u0001`*H\u0016R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/QFSPublicAccountLayerPageListViewModel;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/e;", "Lcom/tencent/biz/qqcircle/events/QFSUpdateFeedListEvent;", "simpleBaseEvent", "", "v2", "", "feedId", "Le30/b;", "selectedBlockData", "x2", "", "isSuccess", "", "retCode", "errMsg", "Lfeedcloud/FeedCloudRead$StGetFeedListRsp;", "rsp", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "bean", "u2", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "initBean", "w2", "getLogTag", "isRefresh", "y2", "attachInfo", "r2", "", "action", "currentFeedPos", "Lfeedcloud/FeedCloudMeta$StFeed;", "currentFeed", "", "currentFeedIds", NowProxyConstants.AccountInfoKey.A2, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", SemanticAttributes.DbSystemValues.H2, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo;", "K", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo;", "repo", "<init>", "()V", "L", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountLayerPageListViewModel extends e {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final QFSPublicAccountStaggeredRepo repo = new QFSPublicAccountStaggeredRepo();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(final QFSPublicAccountLayerPageListViewModel this$0, final QCircleInitBean bean, BaseRequest baseRequest, final boolean z16, final long j3, final String str, final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.d
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountLayerPageListViewModel.t2(QFSPublicAccountLayerPageListViewModel.this, z16, j3, str, feedCloudRead$StGetFeedListRsp, bean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(QFSPublicAccountLayerPageListViewModel this$0, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, QCircleInitBean bean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        this$0.u2(z16, j3, str, feedCloudRead$StGetFeedListRsp, bean);
    }

    private final void u2(boolean isSuccess, long retCode, String errMsg, FeedCloudRead$StGetFeedListRsp rsp, QCircleInitBean bean) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (isSuccess && rsp != null && retCode == 0) {
            String stringAttachInfo = this.f86506m.getStringAttachInfo();
            if (stringAttachInfo != null && stringAttachInfo.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            boolean z19 = !z16;
            QLog.i("QFSPublicAccountLayerPageListViewModel", 1, "[handleFeedListResponse] isLoadMore=" + z19 + ", attachInfo=" + rsp.feedAttchInfo.get());
            this.f86506m.setStringAttachInfo(rsp.feedAttchInfo.get());
            this.f86506m.setAdAttachInfo(rsp.adAttchInfo.get());
            LoadInfo loadInfo = this.f86506m;
            if (rsp.isFinish.get() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            loadInfo.setFinish(z17);
            if (rsp.extInfo.has()) {
                updateSession(rsp.extInfo.get());
            }
            this.f86506m.setCurrentState(4);
            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = new QQCircleFeedBase$StFeedListBusiRspData();
            if (rsp.busiRspData.has()) {
                try {
                    qQCircleFeedBase$StFeedListBusiRspData.mergeFrom(rsp.busiRspData.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("QFSPublicAccountLayerPageListViewModel", 1, e16.getMessage(), e16);
                }
            }
            j2(qQCircleFeedBase$StFeedListBusiRspData.middlePageData);
            w20.a.j().initOrUpdateGlobalState((List) e30.d.b(rsp.vecFeed.get()), true);
            w2(z19, bean, rsp);
            List<FeedCloudMeta$StFeed> list = rsp.vecFeed.get();
            if (rsp.isFinish.get() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            k2(z19, list, z18, 0);
            List<FeedCloudMeta$StFeed> list2 = rsp.vecFeed.get();
            Intrinsics.checkNotNullExpressionValue(list2, "rsp.vecFeed.get()");
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list2) {
                if (QLog.isColorLevel()) {
                    QLog.i("QFSPublicAccountLayerPageListViewModel", 1, "feed=" + feedCloudMeta$StFeed.f398449id.get());
                }
            }
            U1(errMsg, rsp.isFirstLogin.get(), bean);
            return;
        }
        this.D.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode).setLoadMore(false));
    }

    private final void v2(QFSUpdateFeedListEvent simpleBaseEvent) {
        if (simpleBaseEvent.getType() == 2) {
            String preFeedId = simpleBaseEvent.getPreFeedId();
            Intrinsics.checkNotNullExpressionValue(preFeedId, "simpleBaseEvent.preFeedId");
            e30.b nextBlockData = simpleBaseEvent.getNextBlockData();
            Intrinsics.checkNotNullExpressionValue(nextBlockData, "simpleBaseEvent.nextBlockData");
            x2(preFeedId, nextBlockData);
        }
    }

    private final void w2(boolean isLoadMore, QCircleInitBean initBean, FeedCloudRead$StGetFeedListRsp rsp) {
        Object firstOrNull;
        FeedCloudMeta$StFeed feed;
        if (isLoadMore) {
            return;
        }
        List<FeedCloudMeta$StFeed> list = rsp.vecFeed.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.vecFeed.get()");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) firstOrNull;
        if (feedCloudMeta$StFeed != null && (feed = initBean.getFeed()) != null && !Intrinsics.areEqual(feedCloudMeta$StFeed.f398449id.get(), feed.f398449id.get())) {
            rsp.vecFeed.get().add(0, initBean.getFeed());
        }
    }

    private final void x2(String feedId, e30.b selectedBlockData) {
        int i3;
        List<e30.b> list = this.C;
        int d16 = bj.d(list, feedId);
        if (d16 <= -1) {
            i3 = bj.b(list, selectedBlockData);
        } else {
            i3 = d16;
        }
        if (i3 > -1 && !list.isEmpty() && d16 < list.size()) {
            e30.b bVar = list.get(i3);
            if (bVar == null) {
                QLog.e("QFSPublicAccountLayerPageListViewModel", 1, "VFS-[replaceNewDataToFeedList] blockData == null.");
                return;
            }
            QLog.d("QFSPublicAccountLayerPageListViewModel", 1, "VFS-[replaceNewDataToFeedList] replacePosition: " + i3 + " | nextFeedId:" + bj.g(selectedBlockData));
            bVar.m(selectedBlockData);
            UIStateData<List<e30.b>> pos = UIStateData.obtainDelete().setDataList(list).setPos(i3);
            Intrinsics.checkNotNullExpressionValue(pos, "obtainDelete<List<FeedBl\u2026 .setPos(replacePosition)");
            pos.setState(-1000);
            R1(pos);
            return;
        }
        QLog.e("QFSPublicAccountLayerPageListViewModel", 1, "VFS-[replaceNewDataToFeedList] current param illegality, end flow,  | replacePosition: " + i3 + " | unselectedPosition: " + d16 + " | sourcesSize: " + list.size() + " | next feed id: " + bj.g(selectedBlockData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(QFSPublicAccountLayerPageListViewModel this$0, QCircleInitBean bean, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bean, "$bean");
        this$0.r2(bean, z16, this$0.f86506m.getStringAttachInfo());
    }

    public final void A2(int action, final int currentFeedPos, @NotNull FeedCloudMeta$StFeed currentFeed, @NotNull List<String> currentFeedIds) {
        Intrinsics.checkNotNullParameter(currentFeed, "currentFeed");
        Intrinsics.checkNotNullParameter(currentFeedIds, "currentFeedIds");
        this.repo.A(currentFeed, 82, action, currentFeedIds, new Function1<QFSPublicAccountStaggeredRepo.GetFeedResult, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.QFSPublicAccountLayerPageListViewModel$requestForceInsertOnPositiveFeedback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPublicAccountStaggeredRepo.GetFeedResult getFeedResult) {
                invoke2(getFeedResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QFSPublicAccountStaggeredRepo.GetFeedResult result) {
                LoadInfo loadInfo;
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(result, "result");
                UIStateData dataList = UIStateData.obtainInsert(currentFeedPos + 1).setDataList(result.c());
                loadInfo = ((QFSLayerBaseViewModel) this).f86506m;
                UIStateData finish = dataList.setFinish(loadInfo.isFinish());
                mutableLiveData = ((QFSLayerBaseViewModel) this).D;
                mutableLiveData.postValue(finish);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> eventClass = super.getEventClass();
        eventClass.add(QFSUpdateFeedListEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPublicAccountLayerPageListViewModel";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e
    public boolean h2() {
        boolean contains$default;
        if (!g.a()) {
            return false;
        }
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        String DEFAULT_SUPPORT_LOAD_MORE_CONFIG = e.J;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_SUPPORT_LOAD_MORE_CONFIG, "DEFAULT_SUPPORT_LOAD_MORE_CONFIG");
        String loadAsString = iUnitedConfigManager.loadAsString("qqcircle_enable_load_more_back_up_feed_white_list", DEFAULT_SUPPORT_LOAD_MORE_CONFIG);
        if (!TextUtils.isEmpty(loadAsString)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) loadAsString, (CharSequence) QCircleDaTongConstant.ElementParamValue.QCIRCLE_PUBLIC_ACCOUNT_MAIN_ENTRANCE, false, 2, (Object) null);
            return contains$default;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSUpdateFeedListEvent) {
            v2((QFSUpdateFeedListEvent) simpleBaseEvent);
        }
    }

    public final void r2(@NotNull final QCircleInitBean bean, boolean isRefresh, @Nullable String attachInfo) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        FeedCloudCommon$StCommonExt session = getSession(isRefresh);
        Intrinsics.checkNotNullExpressionValue(session, "getSession(isRefresh)");
        sendRequest(new QFSPublicAccountLayerPageListRequest(bean, isRefresh, attachInfo, session), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSPublicAccountLayerPageListViewModel.s2(QFSPublicAccountLayerPageListViewModel.this, bean, baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedListRsp) obj);
            }
        });
    }

    public final void y2(@NotNull final QCircleInitBean bean, final boolean isRefresh) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (P1().getCurrentState() == 3) {
            QLog.i("QFSPublicAccountLayerPageListViewModel", 1, "requestFeedDetailAndList skipped. page is loading.");
            return;
        }
        boolean b16 = h20.c.b();
        QLog.i("QFSPublicAccountLayerPageListViewModel", 1, "requestFeedDetailAndList isRefresh=" + isRefresh + ", enableBuildRequestInSubThread:" + b16);
        this.D.setValue(UIStateData.obtainLoading());
        P1().setCurrentState(3);
        if (isRefresh) {
            this.f86506m.setStringAttachInfo(null);
        }
        if (b16) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.b
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublicAccountLayerPageListViewModel.z2(QFSPublicAccountLayerPageListViewModel.this, bean, isRefresh);
                }
            });
        } else {
            r2(bean, isRefresh, this.f86506m.getStringAttachInfo());
        }
    }
}
