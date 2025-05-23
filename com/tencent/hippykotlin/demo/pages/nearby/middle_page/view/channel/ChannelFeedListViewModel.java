package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.GetChannelFeedsRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.FeedListViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import l25.b;
import l25.c;
import p35.ah;
import x25.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ChannelFeedListViewModel extends FeedListViewModel {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final b channelSign;
    public boolean createEventHandled;
    public final Set<String> exposedFeeds;
    public final FastClickUtils fastClickUtils;
    public Set<String> feedIds;
    public String fetchCookies;
    public final MutableState isEnd$delegate;
    public boolean listExpanded;
    public AsyncTaskTracker<Unit> listExpandedWaitingTask;
    public final ComposeFeedListViewModel listVm;
    public final Lazy repo$delegate;
    public final MutableState tabOpened$delegate;
    public AsyncTaskTracker<Unit> tabOpenedWaitingTask;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ChannelFeedListViewModel(float f16, NBPMiddlePageDTReporter nBPMiddlePageDTReporter, b bVar, ah ahVar) {
        super(f16, nBPMiddlePageDTReporter, ahVar);
        Lazy lazy;
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.channelSign = bVar;
        this.fastClickUtils = new FastClickUtils(200L);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPPOIRepo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewModel$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPPOIRepo invoke() {
                return new NBPPOIRepo();
            }
        });
        this.repo$delegate = lazy;
        this.fetchCookies = "";
        this.listVm = new ComposeFeedListViewModel(new Function1<Function2<? super Boolean, ? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewModel$listVm$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Function2<? super Boolean, ? super Boolean, ? extends Unit> function2) {
                KLog.INSTANCE.i("ChannelFeedListViewModel", "start to LoadMore");
                ChannelFeedListViewModel.this.onLoadMore(function2);
                return Unit.INSTANCE;
            }
        });
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isEnd$delegate = mutableStateOf$default;
        this.feedIds = new LinkedHashSet();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.tabOpened$delegate = mutableStateOf$default2;
        this.tabOpenedWaitingTask = new AsyncTaskTracker<>();
        this.listExpandedWaitingTask = new AsyncTaskTracker<>();
        this.exposedFeeds = new LinkedHashSet();
        markOpened();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isEnd() {
        return ((Boolean) this.isEnd$delegate.getValue()).booleanValue();
    }

    public final void markOpened() {
        this.tabOpened$delegate.setValue(Boolean.TRUE);
        this.tabOpenedWaitingTask.markDoneAndClearCbs(Unit.INSTANCE);
        if (this.listExpanded) {
            this.listExpanded = true;
            this.tabOpenedWaitingTask.executeOnDone(false, new ChannelFeedListViewModel$markExpanded$1(this));
        }
    }

    public final void onLoadMore(final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        if (isEnd()) {
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, Boolean.FALSE);
                return;
            }
            return;
        }
        NBPPOIRepo nBPPOIRepo = (NBPPOIRepo) this.repo$delegate.getValue();
        long j3 = this.channelSign.f413741d;
        ah ahVar = this.poiInfo;
        String str = this.fetchCookies;
        final Function3<f, Integer, String, Unit> function3 = new Function3<f, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedListViewModel$onLoadMore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(f fVar, Integer num, String str2) {
                boolean z16;
                int collectionSizeOrDefault;
                f fVar2 = fVar;
                int intValue = num.intValue();
                String str3 = str2;
                if (intValue == 0 && fVar2 != null) {
                    List<c> list = fVar2.f447087d;
                    ChannelFeedListViewModel channelFeedListViewModel = this;
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (true) {
                        z16 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (true ^ channelFeedListViewModel.feedIds.contains(((c) next).f413744d)) {
                            arrayList.add(next);
                        }
                    }
                    ChannelFeedListViewModel channelFeedListViewModel2 = this;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        c cVar = (c) it5.next();
                        channelFeedListViewModel2.feedIds.add(cVar.f413744d);
                        arrayList2.add(new ChannelFeedItemViewModel(cVar, new ChannelFeedListViewModel$onLoadMore$1$newFeeds$2$1(channelFeedListViewModel2), new ChannelFeedListViewModel$onLoadMore$1$newFeeds$2$2(channelFeedListViewModel2)));
                    }
                    ChannelFeedListViewModel channelFeedListViewModel3 = this;
                    channelFeedListViewModel3.fetchCookies = fVar2.f447089f;
                    channelFeedListViewModel3.listVm.feedCardViewModelList.addAll(arrayList2);
                    ChannelFeedListViewModel channelFeedListViewModel4 = this;
                    if (!fVar2.f447088e && !fVar2.f447087d.isEmpty()) {
                        z16 = false;
                    }
                    channelFeedListViewModel4.isEnd$delegate.setValue(Boolean.valueOf(z16));
                    Function2<Boolean, Boolean, Unit> function22 = function2;
                    if (function22 != null) {
                        function22.invoke(Boolean.valueOf(this.isEnd()), Boolean.FALSE);
                    }
                } else {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("getChannelFeeds failure code:", intValue, ", message:", str3, ", rsp=");
                    m3.append(fVar2);
                    m3.append('}');
                    kLog.e("ChannelFeedListViewModel", m3.toString());
                    Function2<Boolean, Boolean, Unit> function23 = function2;
                    if (function23 != null) {
                        function23.invoke(Boolean.TRUE, Boolean.FALSE);
                    }
                    this.isEnd$delegate.setValue(Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        };
        nBPPOIRepo.getClass();
        KLog.INSTANCE.i("NBPPOIRepo", "getChannelFeeds: guildId=" + j3 + " poiId=" + ahVar.f425143d + " poiName=" + ahVar.Q + " count=10");
        GetChannelFeedsRequest getChannelFeedsRequest = new GetChannelFeedsRequest(ahVar, str, j3);
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(getChannelFeedsRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, getChannelFeedsRequest.getCmd()), new Function1<OIDBResponse<f>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo$getChannelFeeds$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<f> oIDBResponse) {
                List<c> list;
                OIDBResponse<f> oIDBResponse2 = oIDBResponse;
                if (oIDBResponse2.success) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getChannelFeeds success, trace=");
                    f fVar = oIDBResponse2.rsp;
                    m3.append(fVar != null ? fVar.f447090h : null);
                    m3.append(" size=");
                    f fVar2 = oIDBResponse2.rsp;
                    m3.append((fVar2 == null || (list = fVar2.f447087d) == null) ? null : Integer.valueOf(list.size()));
                    m3.append(" isEnd=");
                    f fVar3 = oIDBResponse2.rsp;
                    m3.append(fVar3 != null ? Boolean.valueOf(fVar3.f447088e) : null);
                    kLog.i("NBPPOIRepo", m3.toString());
                } else {
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getChannelFeeds failure, trace=");
                    f fVar4 = oIDBResponse2.rsp;
                    m16.append(fVar4 != null ? fVar4.f447090h : null);
                    m16.append(" code:");
                    m16.append(oIDBResponse2.code);
                    m16.append(", message:");
                    m16.append(oIDBResponse2.f114186msg);
                    m16.append('}');
                    kLog2.e("NBPPOIRepo", m16.toString());
                }
                function3.invoke(oIDBResponse2.rsp, Integer.valueOf(oIDBResponse2.code), oIDBResponse2.f114186msg);
                return Unit.INSTANCE;
            }
        }));
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model.FeedListViewModel, com.tencent.ntcompose.lifecycle.common.a
    public final void onStateChanged(com.tencent.ntcompose.lifecycle.common.c cVar, Lifecycle.Event event) {
        if (WhenMappings.$EnumSwitchMapping$0[event.ordinal()] == 1 && !this.createEventHandled) {
            this.createEventHandled = true;
            onLoadMore(null);
            KLog.INSTANCE.i("ChannelFeedListViewModel", "onCreate and onLoadMore");
        }
    }
}
