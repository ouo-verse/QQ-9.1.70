package com.tencent.mobileqq.guild.feed.feedsection.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.feed.event.GuildEmptyPartEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedChannelTopEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedPublishPartEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareRefreshEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartCallerMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.squarehead.ownertask.event.GetOwnerTaskCardShowEvent;
import com.tencent.mobileqq.guild.feed.squarehead.ownertask.event.OnOwnerTaskCardShowEvent;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zj1.a;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b?\u0010@J\u001a\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\u0012\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0018H\u0002J\u001c\u0010\u001a\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u001c\u0010\u001b\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\u0012\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010'\u001a\u00020&H\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\u0006\u0012\u0002\b\u00030,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u001d\u0010>\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsection/part/FeedSectionUnitedBridgePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "sectionContext", "", "Z9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "uiStateData", "S9", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnFeedListDifferCompleteMsgIntent;", "intent", "U9", "", "P9", "R9", "show", "Y9", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnFeedListLoadedMsgIntent;", "event", "V9", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnScrollStateChangeMsgIntent;", "W9", "ga", "Q9", "showEmptyView", "X9", "O9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartStop", "", "getLogTag", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "vmApi", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "", "f", "I", "previousItemCount", h.F, "Z", "hasPaused", "i", "isFirstScreenFinished", "Lmp1/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "T9", "()Lmp1/b;", "guildHomeViewModel", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSectionUnitedBridgePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private k vmApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private i<?> session;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int previousItemCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasPaused;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstScreenFinished;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildHomeViewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f218684d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f218685e;

        public a(Object obj, Observer observer) {
            this.f218684d = obj;
            this.f218685e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f218684d)) != null) {
                this.f218685e.onChanged(b16);
            }
        }
    }

    public FeedSectionUnitedBridgePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeViewModel>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$guildHomeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GuildHomeViewModel invoke() {
                Object m476constructorimpl;
                Object partHost = FeedSectionUnitedBridgePart.this.getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                ViewModelStoreOwner b16 = com.tencent.mobileqq.guild.base.fragments.f.b((Fragment) partHost);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl((GuildHomeViewModel) new ViewModelProvider(b16).get(GuildHomeViewModel.class));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                FeedSectionUnitedBridgePart feedSectionUnitedBridgePart = FeedSectionUnitedBridgePart.this;
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    Logger logger = Logger.f235387a;
                    String tag = feedSectionUnitedBridgePart.getTAG();
                    Logger.b bVar = new Logger.b();
                    String str = "initViewModel(GuildHomeViewModel) error:" + m479exceptionOrNullimpl.getMessage();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e(tag, 1, (String) it.next(), null);
                    }
                    m476constructorimpl = null;
                }
                FeedSectionUnitedBridgePart feedSectionUnitedBridgePart2 = FeedSectionUnitedBridgePart.this;
                GuildHomeViewModel guildHomeViewModel = (GuildHomeViewModel) m476constructorimpl;
                Logger logger2 = Logger.f235387a;
                String tag2 = feedSectionUnitedBridgePart2.getTAG();
                logger2.d().i(tag2, 1, "initViewModel(GuildHomeViewModel) id:" + System.identityHashCode(guildHomeViewModel));
                return guildHomeViewModel;
            }
        });
        this.guildHomeViewModel = lazy;
    }

    private final boolean O9() {
        k kVar = this.vmApi;
        List<ij1.g> list = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vmApi");
            kVar = null;
        }
        UIStateData<List<ij1.g>> value = kVar.j().getValue();
        if (value != null) {
            list = value.getData();
        }
        List<ij1.g> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean P9() {
        boolean z16;
        try {
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            String tag = getTAG();
            Logger.b bVar = new Logger.b();
            String str = "checkHasPaused error:" + e16.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(tag, 1, (String) it.next(), null);
            }
        }
        if (this.hasPaused) {
            return true;
        }
        if (getPartHost() instanceof Fragment) {
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Bundle arguments = ((Fragment) partHost).getArguments();
            if (arguments != null) {
                if (arguments.getBoolean("key_has_parent_paused")) {
                    z16 = true;
                    if (!z16) {
                        return true;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(UIStateData<List<ij1.g>> uiStateData) {
        switch (uiStateData.getState()) {
            case 0:
                if (!uiStateData.getIsLoadMore()) {
                    X9(true);
                    return;
                }
                return;
            case 1:
                X9(false);
                return;
            case 2:
            case 3:
                if (!uiStateData.getIsLoadMore()) {
                    X9(false);
                    return;
                }
                return;
            case 4:
                if (O9()) {
                    X9(true);
                    return;
                } else {
                    X9(false);
                    return;
                }
            case 5:
            default:
                return;
            case 6:
            case 7:
            case 8:
                if (uiStateData.getState() == 8) {
                    X9(false);
                    return;
                } else {
                    if (bl.b(uiStateData.getData())) {
                        X9(true);
                        return;
                    }
                    return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(UIStateData<List<ij1.g>> uiStateData) {
        if (uiStateData.getIsLoadMore()) {
            return;
        }
        int state = uiStateData.getState();
        if (state != 0) {
            if (state == 2 || state == 3) {
                Y9(true);
                return;
            }
            return;
        }
        Y9(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(UIStateData<List<ij1.g>> uiStateData) {
        int i3;
        IPerformanceReportTask iPerformanceReportTask;
        if (uiStateData.getIsLoadMore()) {
            return;
        }
        int state = uiStateData.getState();
        if (state == 0 || state == 4) {
            if (!P9() && !this.isFirstScreenFinished) {
                int state2 = uiStateData.getState();
                if (state2 != 0) {
                    if (state2 != 4) {
                        i3 = 0;
                    } else {
                        i3 = 2;
                    }
                } else {
                    i3 = 3;
                }
                int i16 = i3;
                com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
                com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) PartIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
                if (gVar != null) {
                    iPerformanceReportTask = gVar.a();
                } else {
                    iPerformanceReportTask = null;
                }
                cVar.u(iPerformanceReportTask, false, i16, getPartRootView(), new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$emitStageReportEventOnFeedListStateChange$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Boolean invoke() {
                        boolean P9;
                        P9 = FeedSectionUnitedBridgePart.this.P9();
                        return Boolean.valueOf(!P9);
                    }
                });
            }
            this.isFirstScreenFinished = true;
        }
    }

    private final mp1.b T9() {
        return (mp1.b) this.guildHomeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(FeedSectionListPartMsgIntent.OnFeedListDifferCompleteMsgIntent intent) {
        IPerformanceReportTask iPerformanceReportTask = null;
        if (intent.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String()) {
            if (!P9()) {
                com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
                com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) PartIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
                if (gVar != null) {
                    iPerformanceReportTask = gVar.a();
                }
                cVar.u(iPerformanceReportTask, true, 0, getPartRootView(), new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$handleOnFeedListDifferCompleteIntent$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Boolean invoke() {
                        boolean P9;
                        P9 = FeedSectionUnitedBridgePart.this.P9();
                        return Boolean.valueOf(!P9);
                    }
                });
                return;
            }
            return;
        }
        if (!P9() && !this.isFirstScreenFinished) {
            com.tencent.mobileqq.guild.feed.report.c cVar2 = com.tencent.mobileqq.guild.feed.report.c.f223280a;
            com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar2 = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) PartIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
            if (gVar2 != null) {
                iPerformanceReportTask = gVar2.a();
            }
            cVar2.u(iPerformanceReportTask, false, 1, getPartRootView(), new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$handleOnFeedListDifferCompleteIntent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    boolean P9;
                    P9 = FeedSectionUnitedBridgePart.this.P9();
                    return Boolean.valueOf(!P9);
                }
            });
            this.isFirstScreenFinished = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V9(FeedSectionListPartMsgIntent.OnFeedListLoadedMsgIntent event) {
        boolean z16;
        List<?> a16;
        boolean z17;
        int i3 = 0;
        if (!event.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams.ISCACHE java.lang.String()) {
            Boolean c16 = event.a().c();
            if (c16 != null) {
                z17 = c16.booleanValue();
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = true;
                broadcastMessage("message_on_feed_load_complete", new a.OnFeedLoadCompletedMessage(z16, this.previousItemCount, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.d.a(event.a())));
                a16 = event.a().a();
                if (a16 != null) {
                    i3 = a16.size();
                }
                this.previousItemCount = i3;
            }
        }
        z16 = false;
        broadcastMessage("message_on_feed_load_complete", new a.OnFeedLoadCompletedMessage(z16, this.previousItemCount, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.d.a(event.a())));
        a16 = event.a().a();
        if (a16 != null) {
        }
        this.previousItemCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(FeedSectionListPartMsgIntent.OnScrollStateChangeMsgIntent event) {
        broadcastMessage("message_on_feed_scroll_state_changed", new a.OnFeedScrollStateChangedMessage(event.getIsScrolling(), event.b().getFirst().intValue(), event.b().getSecond().intValue(), com.tencent.mobileqq.guild.feed.feedsquare.part.remake.d.b(event.a())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(boolean showEmptyView) {
        boolean z16 = true;
        if (getContext() != null) {
            GetOwnerTaskCardShowEvent getOwnerTaskCardShowEvent = new GetOwnerTaskCardShowEvent(getContext().hashCode(), false);
            SimpleEventBus.getInstance().dispatchEvent(getOwnerTaskCardShowEvent);
            z16 = true ^ getOwnerTaskCardShowEvent.isShow();
        }
        boolean z17 = z16;
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        i<?> iVar = this.session;
        i<?> iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
            iVar = null;
        }
        String guildId = iVar.a().getGuildId();
        i<?> iVar3 = this.session;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
            iVar3 = null;
        }
        String channelId = iVar3.a().getChannelId();
        i<?> iVar4 = this.session;
        if (iVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
        } else {
            iVar2 = iVar4;
        }
        simpleEventBus.dispatchEvent(new GuildEmptyPartEvent(showEmptyView, z17, guildId, channelId, iVar2.getBusinessType()));
    }

    private final void Y9(boolean show) {
        i<?> iVar = this.session;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
            iVar = null;
        }
        IGuildParcelizeSimpleContact a16 = iVar.a();
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedPublishPartEvent(a16.getChannelId(), show, sz1.d.k(a16.getGuildId(), a16.getChannelId())));
    }

    private final void Z9(final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> sectionContext) {
        LiveData<ef1.a<Boolean>> T;
        k kVar = this.vmApi;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vmApi");
            kVar = null;
        }
        MutableLiveData<UIStateData<List<ij1.g>>> j3 = kVar.j();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final FeedSectionUnitedBridgePart$onDependOnsReady$1 feedSectionUnitedBridgePart$onDependOnsReady$1 = new FeedSectionUnitedBridgePart$onDependOnsReady$1(this);
        j3.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSectionUnitedBridgePart.aa(Function1.this, obj);
            }
        });
        k kVar2 = this.vmApi;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vmApi");
            kVar2 = null;
        }
        MutableLiveData<UIStateData<List<ij1.g>>> j16 = kVar2.j();
        LifecycleOwner c17 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final FeedSectionUnitedBridgePart$onDependOnsReady$2 feedSectionUnitedBridgePart$onDependOnsReady$2 = new FeedSectionUnitedBridgePart$onDependOnsReady$2(this);
        j16.observe(c17, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSectionUnitedBridgePart.ba(Function1.this, obj);
            }
        });
        k kVar3 = this.vmApi;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vmApi");
            kVar3 = null;
        }
        MutableLiveData<UIStateData<List<ij1.g>>> j17 = kVar3.j();
        LifecycleOwner c18 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final FeedSectionUnitedBridgePart$onDependOnsReady$3 feedSectionUnitedBridgePart$onDependOnsReady$3 = new FeedSectionUnitedBridgePart$onDependOnsReady$3(this);
        j17.observe(c18, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSectionUnitedBridgePart.ca(Function1.this, obj);
            }
        });
        if (ax.l(sectionContext.d().getBusinessType())) {
            k kVar4 = this.vmApi;
            if (kVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vmApi");
                kVar4 = null;
            }
            MutableLiveData<UIStateData<List<ij1.g>>> j18 = kVar4.j();
            LifecycleOwner c19 = com.tencent.mobileqq.guild.feed.part.a.c(this);
            final FeedSectionUnitedBridgePart$onDependOnsReady$4 feedSectionUnitedBridgePart$onDependOnsReady$4 = new FeedSectionUnitedBridgePart$onDependOnsReady$4(this);
            j18.observe(c19, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeedSectionUnitedBridgePart.da(Function1.this, obj);
                }
            });
        }
        Flow callbackFlow = FlowKt.callbackFlow(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$eventFlow$1(sectionContext.getMessenger(), null));
        LifecycleOwner c26 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        Lifecycle.State state = Lifecycle.State.STARTED;
        Lifecycle lifecycle = c26.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$collectIn$default$1(lifecycle, state, callbackFlow, null, this));
        Flow callbackFlow2 = FlowKt.callbackFlow(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$eventFlow$2(sectionContext.getMessenger(), null));
        Lifecycle lifecycle2 = com.tencent.mobileqq.guild.feed.part.a.c(this).getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle2).launchWhenCreated(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$collectIn$default$2(lifecycle2, state, callbackFlow2, null, this));
        Flow callbackFlow3 = FlowKt.callbackFlow(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$eventFlow$3(sectionContext.getMessenger(), null));
        Lifecycle lifecycle3 = com.tencent.mobileqq.guild.feed.part.a.c(this).getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle3, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle3).launchWhenCreated(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$collectIn$default$3(lifecycle3, state, callbackFlow3, null, this));
        mp1.b T9 = T9();
        if (T9 != null && (T = T9.T()) != null) {
            LifecycleOwner c27 = com.tencent.mobileqq.guild.feed.part.a.c(this);
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$8
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    Object partHost = FeedSectionUnitedBridgePart.this.getPartHost();
                    Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                    if (((Fragment) partHost).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                        sectionContext.getMessenger().h(new FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent(sectionContext.d().a(), false, false, true, null));
                    }
                }
            };
            T.observe(c27, new a(this, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeedSectionUnitedBridgePart.ea(Function1.this, obj);
                }
            }));
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        final Flow callbackFlow4 = FlowKt.callbackFlow(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$eventFlow$4(simpleEventBus, null));
        Flow<GuildFeedSquareRefreshEvent> flow = new Flow<GuildFeedSquareRefreshEvent>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<GuildFeedSquareRefreshEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f218674d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ FeedSectionUnitedBridgePart f218675e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$1$2", f = "FeedSectionUnitedBridgePart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FeedSectionUnitedBridgePart feedSectionUnitedBridgePart) {
                    this.f218674d = flowCollector;
                    this.f218675e = feedSectionUnitedBridgePart;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(GuildFeedSquareRefreshEvent guildFeedSquareRefreshEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    i iVar;
                    i iVar2;
                    boolean z16;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f218674d;
                                GuildFeedSquareRefreshEvent guildFeedSquareRefreshEvent2 = guildFeedSquareRefreshEvent;
                                int i17 = guildFeedSquareRefreshEvent2.mHashCode;
                                if (i17 == 0 || i17 == this.f218675e.getContext().hashCode()) {
                                    String guildId = guildFeedSquareRefreshEvent2.getGuildId();
                                    iVar = this.f218675e.session;
                                    i iVar3 = null;
                                    if (iVar == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
                                        iVar = null;
                                    }
                                    if (Intrinsics.areEqual(guildId, iVar.a().getGuildId())) {
                                        String channelId = guildFeedSquareRefreshEvent2.getChannelId();
                                        iVar2 = this.f218675e.session;
                                        if (iVar2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
                                        } else {
                                            iVar3 = iVar2;
                                        }
                                        if (Intrinsics.areEqual(channelId, iVar3.a().getChannelId())) {
                                            z16 = true;
                                            if (z16) {
                                                anonymousClass1.label = 1;
                                                if (flowCollector.emit(guildFeedSquareRefreshEvent, anonymousClass1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            }
                                        }
                                    }
                                }
                                z16 = false;
                                if (z16) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super GuildFeedSquareRefreshEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        Lifecycle lifecycle4 = com.tencent.mobileqq.guild.feed.part.a.c(this).getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle4, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle4).launchWhenCreated(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$collectIn$default$4(lifecycle4, state, flow, null, sectionContext));
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus2, "getInstance()");
        final Flow callbackFlow5 = FlowKt.callbackFlow(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$eventFlow$5(simpleEventBus2, null));
        Flow<GuildFeedChannelTopEvent> flow2 = new Flow<GuildFeedChannelTopEvent>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$2

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<GuildFeedChannelTopEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f218678d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ FeedSectionUnitedBridgePart f218679e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$2$2", f = "FeedSectionUnitedBridgePart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$2$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FeedSectionUnitedBridgePart feedSectionUnitedBridgePart) {
                    this.f218678d = flowCollector;
                    this.f218679e = feedSectionUnitedBridgePart;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(GuildFeedChannelTopEvent guildFeedChannelTopEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    i iVar;
                    boolean z16;
                    i iVar2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f218678d;
                                GuildFeedChannelTopEvent guildFeedChannelTopEvent2 = guildFeedChannelTopEvent;
                                String valueOf = String.valueOf(guildFeedChannelTopEvent2.getGuildId());
                                iVar = this.f218679e.session;
                                i iVar3 = null;
                                if (iVar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
                                    iVar = null;
                                }
                                if (Intrinsics.areEqual(valueOf, iVar.a().getGuildId())) {
                                    String valueOf2 = String.valueOf(guildFeedChannelTopEvent2.getChannelId());
                                    iVar2 = this.f218679e.session;
                                    if (iVar2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
                                    } else {
                                        iVar3 = iVar2;
                                    }
                                    if (Intrinsics.areEqual(valueOf2, iVar3.a().getChannelId())) {
                                        z16 = true;
                                        if (z16) {
                                            anonymousClass1.label = 1;
                                            if (flowCollector.emit(guildFeedChannelTopEvent, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                }
                                z16 = false;
                                if (z16) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super GuildFeedChannelTopEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        Lifecycle lifecycle5 = com.tencent.mobileqq.guild.feed.part.a.c(this).getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle5, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle5).launchWhenCreated(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$collectIn$default$5(lifecycle5, state, flow2, null, sectionContext));
        SimpleEventBus simpleEventBus3 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus3, "getInstance()");
        final Flow callbackFlow6 = FlowKt.callbackFlow(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$eventFlow$6(simpleEventBus3, null));
        FlowKt.launchIn(FlowKt.onEach(new Flow<OnOwnerTaskCardShowEvent>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$3

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$3$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<OnOwnerTaskCardShowEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f218682d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ FeedSectionUnitedBridgePart f218683e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$3$2", f = "FeedSectionUnitedBridgePart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$filter$3$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FeedSectionUnitedBridgePart feedSectionUnitedBridgePart) {
                    this.f218682d = flowCollector;
                    this.f218683e = feedSectionUnitedBridgePart;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(OnOwnerTaskCardShowEvent onOwnerTaskCardShowEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f218682d;
                                OnOwnerTaskCardShowEvent onOwnerTaskCardShowEvent2 = onOwnerTaskCardShowEvent;
                                Context context = this.f218683e.getContext();
                                boolean z16 = false;
                                if (context != null && onOwnerTaskCardShowEvent2.getContextHashCode() == context.hashCode()) {
                                    z16 = true;
                                }
                                if (z16) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(onOwnerTaskCardShowEvent, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super OnOwnerTaskCardShowEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new FeedSectionUnitedBridgePart$onDependOnsReady$14(this, null)), com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this));
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$eventFlow$7(sectionContext.getMessenger(), null)), new FeedSectionUnitedBridgePart$onDependOnsReady$15(this, null)), com.tencent.mobileqq.guild.feed.part.a.d(this));
        Flow callbackFlow7 = FlowKt.callbackFlow(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$eventFlow$8(sectionContext.getMessenger(), null));
        Lifecycle lifecycle6 = com.tencent.mobileqq.guild.feed.part.a.c(this).getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle6, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle6).launchWhenCreated(new FeedSectionUnitedBridgePart$onDependOnsReady$$inlined$collectIn$default$6(lifecycle6, state, callbackFlow7, null, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga(UIStateData<List<ij1.g>> uiStateData) {
        mp1.b T9;
        if ((uiStateData.getState() == 0 || uiStateData.getState() == 3 || uiStateData.getState() == 4) && (T9 = T9()) != null) {
            T9.finishRefresh();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FeedPublishBtnAdapterPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
        super.onInitView(rootView);
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) PartIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
        if (gVar == null || (context = gVar.getContext()) == null) {
            return;
        }
        this.vmApi = context.getVmApi();
        this.session = context.d();
        Z9(context);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.hasPaused = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        this.hasPaused = true;
    }
}
