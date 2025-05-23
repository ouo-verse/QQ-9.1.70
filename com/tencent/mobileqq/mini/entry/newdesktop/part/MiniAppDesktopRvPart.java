package com.tencent.mobileqq.mini.entry.newdesktop.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.PartLifecycleHost;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopEffect;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.EmptyMiniAppHintViewAdapter;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppBannerAdapter;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineAdapter;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecentAdapter;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecommendAdapter;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppSearchAdapter;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppTeenagerModeAdapter;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J<\u0010&\u001a\u00020\u000422\u0010'\u001a.\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0017\u0018\u00010(j\u0016\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0017\u0018\u0001`)H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001c\u00106\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010:\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010;\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010<\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010=\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010>\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020\u0010H\u0002J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\u0010H\u0002J\b\u0010E\u001a\u00020\u0010H\u0016J8\u0010F\u001a\u00020\u00102.\u0010'\u001a*\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00170(j\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0017`)H\u0002J\b\u0010G\u001a\u00020\u0010H\u0002J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010I\u001a\u00020\u0010H\u0002J\u0010\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopRvPart;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/MiniAppDesktopAbstractPart;", "()V", "mIsAccountChanged", "", "mIsNeedForceRequest", "mMiniAppContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "mRoot", "Landroid/widget/FrameLayout;", "mRvConcatAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mSearchKeyWordSchedule", "Ljava/util/concurrent/ScheduledExecutorService;", "prefetchedDataExposed", "addOnScrollListenerWithMainThread", "", "doSetAdapterWithMainThread", "isFromInitView", "exposePrefetchedData", "getLogTag", "", "getMiniAppListAdapter", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isTeenagerMode", "getMiniAppModuleTitle", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "titleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "module", "", "handleUiState", "uiState", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState;", "initMiniAppDesktopAdapter", "initMiniAppDesktopUI", "isCanShowBanner", "desktopData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "notifyDataSetChangedWhenThemeChanged", "onAccountChanged", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnAccountChanged;", "onChangeRedDotSwitch", "bundle", "Landroid/os/Bundle;", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onPartCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "onPartDestroy", "onPartPause", "onPartResume", "onPartStart", "onPartStop", "onPostThemeChanged", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$OnPostThemeChanged;", "preloadMiniAppSearchHistoryKey", "refreshRecentMiniAppInfo", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopUIState$UpdateDesktopMiniAppInfo;", "scrollToTop", "setLiveDataObserver", "setMiniAppDesktopInfo", "setRootOnDragListenerWithMainThread", "setViewListenerWithMainThread", "startSearchKeyWordTask", "studyModeChange", "isStudyMode", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDesktopRvPart extends MiniAppDesktopAbstractPart {
    private static final long SEARCH_KEY_WORD_DURATION = 3000;
    private boolean mIsAccountChanged;
    private boolean mIsNeedForceRequest = true;
    private RecyclerView mMiniAppContainerRv;
    private volatile FrameLayout mRoot;
    private volatile RFWConcatAdapter mRvConcatAdapter;
    private ScheduledExecutorService mSearchKeyWordSchedule;
    private boolean prefetchedDataExposed;

    private final void addOnScrollListenerWithMainThread() {
        RecyclerView recyclerView = this.mMiniAppContainerRv;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$addOnScrollListenerWithMainThread$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView2, final int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    super.onScrollStateChanged(recyclerView2, newState);
                    MiniAppDesktopRvPart.this.getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$addOnScrollListenerWithMainThread$1$onScrollStateChanged$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final MiniAppDesktopEffect invoke() {
                            return new MiniAppDesktopEffect.OuterRvPartOnScrollStateChanged(newState);
                        }
                    });
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView2, int dx5, int dy5) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                }
            });
        }
    }

    private final void doSetAdapterWithMainThread(boolean isFromInitView) {
        RecyclerView recyclerView = this.mMiniAppContainerRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getPartRootView().getContext()));
            recyclerView.setAdapter(this.mRvConcatAdapter);
        }
        if (isFromInitView) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppDesktopRvPart$doSetAdapterWithMainThread$2(this, null), 3, null);
        }
    }

    private final void exposePrefetchedData() {
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost");
        if (!((MiniAppDesktopPartHost) partHost).getMIsDesktopOpened() || this.prefetchedDataExposed) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Manager manager = peekAppRuntime.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
            ((MiniAppExposureManager) manager).clearReportedItemMap();
        }
        this.prefetchedDataExposed = true;
    }

    private final void initMiniAppDesktopAdapter(boolean isFromInitView) {
        this.mRvConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), getMiniAppListAdapter(MiniAppUtils.isTeenagerMode()));
        setViewListenerWithMainThread(isFromInitView);
    }

    private final void initMiniAppDesktopUI() {
        View findViewById = getPartRootView().findViewById(R.id.rf9);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.mMiniAppContainerRv = (RecyclerView) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.rgc);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mRoot = (FrameLayout) findViewById2;
    }

    private final void notifyDataSetChangedWhenThemeChanged() {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
        if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
            return;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            if (adapter instanceof MiniAppMineAdapter) {
                ((MiniAppMineAdapter) adapter).notifyDataSetChanged(true);
            } else if (adapter instanceof MiniAppRecentAdapter) {
                ((MiniAppRecentAdapter) adapter).notifyDataSetChanged(true);
            } else {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private final void onChangeRedDotSwitch(Bundle bundle) {
        RFWConcatAdapter rFWConcatAdapter;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        QLog.i(getTAG(), 1, "onChangeRedDotSwitch()");
        int i3 = bundle.getInt("redDot", -1);
        boolean z16 = bundle.getBoolean("refreshUI", false);
        if (-1 == i3 || !z16 || (rFWConcatAdapter = this.mRvConcatAdapter) == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
            return;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            ((RecyclerView.Adapter) it.next()).notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitView$lambda$0(MiniAppDesktopRvPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initMiniAppDesktopAdapter(true);
        MiniAppCmdUtil miniAppCmdUtil = MiniAppCmdUtil.getInstance();
        if (QLog.isColorLevel()) {
            QLog.i(this$0.getTAG(), 2, "initMiniAppDesktopAdapter(true) and perload MiniAppCmdUtil.getInstance():" + miniAppCmdUtil);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPartPause$lambda$18() {
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPostThemeChanged$lambda$2(MiniAppDesktopRvPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.notifyDataSetChangedWhenThemeChanged();
        } catch (Exception e16) {
            QLog.e(this$0.getTAG(), 1, "notifyDataSetChangedWhenThemeChanged error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preloadMiniAppSearchHistoryKey() {
        Manager manager = MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager");
        ((MiniAppSearchDataManager) manager).getCachedHistorySearchList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        if ((r2 == null || r2.isEmpty()) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshRecentMiniAppInfo(MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo uiState) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
        if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
            return;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            boolean z16 = true;
            if (adapter instanceof EmptyMiniAppHintViewAdapter) {
                List<DesktopItemInfo> list = uiState.getDesktopData().get(1);
                if (list == null || list.isEmpty()) {
                    List<DesktopItemInfo> list2 = uiState.getDesktopData().get(3);
                }
                z16 = false;
                ((EmptyMiniAppHintViewAdapter) adapter).setData(z16);
            } else if (adapter instanceof MiniAppRecentAdapter) {
                List<DesktopItemInfo> list3 = uiState.getDesktopData().get(1);
                Intrinsics.checkNotNull(list3);
                ((MiniAppRecentAdapter) adapter).setData(list3, null, true);
            }
        }
    }

    private final void scrollToTop() {
        RecyclerView recyclerView = this.mMiniAppContainerRv;
        if (!(recyclerView != null && recyclerView.getVisibility() == 0)) {
            QLog.i(getTAG(), 1, "not need scrollToTop\uff01");
            return;
        }
        QLog.i(getTAG(), 1, "scrollToTop\uff01");
        RecyclerView recyclerView2 = this.mMiniAppContainerRv;
        RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$1(MiniAppDesktopRvPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppDesktopRvPart$setLiveDataObserver$1$1(this$0, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0191, code lost:
    
        if ((r2 == null || r2.isEmpty()) != false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setMiniAppDesktopInfo(HashMap<Integer, List<DesktopItemInfo>> desktopData) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
        if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
            return;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            boolean z16 = true;
            if ((adapter instanceof MiniAppRecentAdapter) && desktopData.get(1) != null) {
                MiniAppRecentAdapter miniAppRecentAdapter = (MiniAppRecentAdapter) adapter;
                List<DesktopItemInfo> list = desktopData.get(1);
                Intrinsics.checkNotNull(list);
                MiniAppRecentAdapter.setData$default(miniAppRecentAdapter, list, getMiniAppModuleTitle(desktopData.get(16), 1), false, 4, null);
            } else if ((adapter instanceof MiniAppMineAdapter) && desktopData.get(3) != null) {
                MiniAppMineAdapter miniAppMineAdapter = (MiniAppMineAdapter) adapter;
                List<DesktopItemInfo> list2 = desktopData.get(3);
                Intrinsics.checkNotNull(list2);
                MiniAppMineAdapter.setData$default(miniAppMineAdapter, list2, getMiniAppModuleTitle(desktopData.get(16), 3), false, 4, null);
            } else {
                if (adapter instanceof MiniAppRecommendAdapter) {
                    List<DesktopItemInfo> list3 = desktopData.get(2);
                    if (!(list3 == null || list3.isEmpty())) {
                        DesktopAppModuleInfo miniAppModuleTitle = getMiniAppModuleTitle(desktopData.get(16), 2);
                        if (miniAppModuleTitle != null) {
                            miniAppModuleTitle.moduleTitle = HardCodeUtil.qqStr(R.string.o85);
                        }
                        List<DesktopItemInfo> list4 = desktopData.get(2);
                        Intrinsics.checkNotNull(list4);
                        ((MiniAppRecommendAdapter) adapter).setData(list4, miniAppModuleTitle);
                    }
                }
                if (adapter instanceof MiniAppSearchAdapter) {
                    List<DesktopItemInfo> list5 = desktopData.get(15);
                    if (!(list5 == null || list5.isEmpty())) {
                        List<DesktopItemInfo> list6 = desktopData.get(15);
                        Intrinsics.checkNotNull(list6);
                        if (list6.get(0) instanceof DesktopSearchInfo) {
                            List<DesktopItemInfo> list7 = desktopData.get(15);
                            Intrinsics.checkNotNull(list7);
                            DesktopItemInfo desktopItemInfo = list7.get(0);
                            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo");
                            ((MiniAppSearchAdapter) adapter).setData((DesktopSearchInfo) desktopItemInfo);
                        }
                    }
                }
                if (adapter instanceof MiniAppBannerAdapter) {
                    List<DesktopItemInfo> list8 = desktopData.get(14);
                    if (!(list8 == null || list8.isEmpty()) && isCanShowBanner(desktopData)) {
                        List<DesktopItemInfo> list9 = desktopData.get(14);
                        Intrinsics.checkNotNull(list9);
                        ((MiniAppBannerAdapter) adapter).setData(list9);
                    }
                }
                if (adapter instanceof EmptyMiniAppHintViewAdapter) {
                    List<DesktopItemInfo> list10 = desktopData.get(1);
                    if (list10 == null || list10.isEmpty()) {
                        List<DesktopItemInfo> list11 = desktopData.get(3);
                    }
                    z16 = false;
                    ((EmptyMiniAppHintViewAdapter) adapter).setData(z16);
                }
            }
        }
    }

    private final void setRootOnDragListenerWithMainThread() {
        FrameLayout frameLayout = this.mRoot;
        if (frameLayout != null) {
            frameLayout.setOnDragListener(new View.OnDragListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.m
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view, DragEvent dragEvent) {
                    boolean rootOnDragListenerWithMainThread$lambda$8;
                    rootOnDragListenerWithMainThread$lambda$8 = MiniAppDesktopRvPart.setRootOnDragListenerWithMainThread$lambda$8(MiniAppDesktopRvPart.this, view, dragEvent);
                    return rootOnDragListenerWithMainThread$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setRootOnDragListenerWithMainThread$lambda$8(MiniAppDesktopRvPart this$0, final View view, DragEvent dragEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view == null || dragEvent == null || dragEvent.getLocalState() == null || !(dragEvent.getLocalState() instanceof MiniAppDragData)) {
            return false;
        }
        if (dragEvent.getAction() != 2) {
            QLog.i(this$0.getTAG(), 1, "root view action:" + MiniAppDragHelper.INSTANCE.getDragActionString(dragEvent.getAction()) + "\uff0cevent=" + dragEvent);
        }
        switch (dragEvent.getAction()) {
            case 1:
            case 2:
                return true;
            case 3:
                Object localState = dragEvent.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                return ((MiniAppDragData) localState).getStartRv().getId() == R.id.rgh;
            case 4:
                Object localState2 = dragEvent.getLocalState();
                Intrinsics.checkNotNull(localState2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                ((MiniAppDragData) localState2).getStartViewHolder().itemView.setVisibility(0);
                return true;
            case 5:
                Object localState3 = dragEvent.getLocalState();
                Intrinsics.checkNotNull(localState3, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragData");
                final MiniAppDragData miniAppDragData = (MiniAppDragData) localState3;
                if (miniAppDragData.getStartRv().getId() != R.id.rfb) {
                    this$0.getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$setRootOnDragListenerWithMainThread$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final MiniAppDesktopEffect invoke() {
                            return new MiniAppDesktopEffect.OnDragEntered(MiniAppDragData.this.getStartRv().getId(), view.getId());
                        }
                    });
                }
                return true;
            case 6:
                return true;
            default:
                return false;
        }
    }

    private final void setViewListenerWithMainThread(final boolean isFromInitView) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            addOnScrollListenerWithMainThread();
            setRootOnDragListenerWithMainThread();
            doSetAdapterWithMainThread(isFromInitView);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.p
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopRvPart.setViewListenerWithMainThread$lambda$6(MiniAppDesktopRvPart.this, isFromInitView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewListenerWithMainThread$lambda$6(MiniAppDesktopRvPart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.addOnScrollListenerWithMainThread();
        this$0.setRootOnDragListenerWithMainThread();
        this$0.doSetAdapterWithMainThread(z16);
    }

    private final void startSearchKeyWordTask() {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
        if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
            return;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            if (adapter instanceof MiniAppSearchAdapter) {
                MiniAppSearchAdapter miniAppSearchAdapter = (MiniAppSearchAdapter) adapter;
                if (miniAppSearchAdapter.isNeedUpdateKeyword()) {
                    if (miniAppSearchAdapter.getKeywordSize() == 1) {
                        miniAppSearchAdapter.updateKeyword();
                    } else if (miniAppSearchAdapter.getKeywordSize() > 1 && this.mSearchKeyWordSchedule == null) {
                        ScheduledExecutorService newScheduledThreadPool = ProxyExecutors.newScheduledThreadPool(1);
                        this.mSearchKeyWordSchedule = newScheduledThreadPool;
                        Intrinsics.checkNotNull(newScheduledThreadPool);
                        newScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.t
                            @Override // java.lang.Runnable
                            public final void run() {
                                MiniAppDesktopRvPart.startSearchKeyWordTask$lambda$15$lambda$14(MiniAppDesktopRvPart.this);
                            }
                        }, 3000L, 3000L, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSearchKeyWordTask$lambda$15$lambda$14(final MiniAppDesktopRvPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.o
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopRvPart.startSearchKeyWordTask$lambda$15$lambda$14$lambda$13(MiniAppDesktopRvPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSearchKeyWordTask$lambda$15$lambda$14$lambda$13(MiniAppDesktopRvPart this$0) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWConcatAdapter rFWConcatAdapter = this$0.mRvConcatAdapter;
        if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
            return;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            if (adapter instanceof MiniAppSearchAdapter) {
                MiniAppSearchAdapter miniAppSearchAdapter = (MiniAppSearchAdapter) adapter;
                miniAppSearchAdapter.updateKeyword();
                miniAppSearchAdapter.resetKeywordIndex();
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppDesktopPart.MiniAppDesktopRvPart";
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void handleUiState(MiniAppDeskTopUIState uiState) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        RFWConcatAdapter rFWConcatAdapter;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        QLog.i(getTAG(), 1, "handleUiState:" + uiState);
        if (uiState instanceof MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo) {
            MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo updateDesktopMiniAppInfo = (MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo) uiState;
            int miniAppType = updateDesktopMiniAppInfo.getMiniAppType();
            if (miniAppType == 0) {
                setMiniAppDesktopInfo(updateDesktopMiniAppInfo.getDesktopData());
                startSearchKeyWordTask();
                exposePrefetchedData();
                return;
            }
            if (miniAppType == 1) {
                refreshRecentMiniAppInfo(updateDesktopMiniAppInfo);
                return;
            }
            if (miniAppType != 3 || (rFWConcatAdapter = this.mRvConcatAdapter) == null || (adapters2 = rFWConcatAdapter.getAdapters()) == null) {
                return;
            }
            Iterator<T> it = adapters2.iterator();
            while (it.hasNext()) {
                RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
                if (adapter instanceof MiniAppMineAdapter) {
                    MiniAppMineAdapter miniAppMineAdapter = (MiniAppMineAdapter) adapter;
                    List<DesktopItemInfo> list = updateDesktopMiniAppInfo.getDesktopData().get(3);
                    Intrinsics.checkNotNull(list);
                    MiniAppMineAdapter.setData$default(miniAppMineAdapter, list, null, false, 6, null);
                }
            }
            return;
        }
        if (uiState instanceof MiniAppDeskTopUIState.MyMiniAppDraggingTempSwitchPosition) {
            RFWConcatAdapter rFWConcatAdapter2 = this.mRvConcatAdapter;
            if (rFWConcatAdapter2 == null || (adapters = rFWConcatAdapter2.getAdapters()) == null) {
                return;
            }
            Iterator<T> it5 = adapters.iterator();
            while (it5.hasNext()) {
                RecyclerView.Adapter adapter2 = (RecyclerView.Adapter) it5.next();
                if (adapter2 instanceof MiniAppMineAdapter) {
                    MiniAppMineAdapter.setData$default((MiniAppMineAdapter) adapter2, ((MiniAppDeskTopUIState.MyMiniAppDraggingTempSwitchPosition) uiState).getDeepCopyMyMiniAppInfo(), null, false, 6, null);
                }
            }
            return;
        }
        if (uiState instanceof MiniAppDeskTopUIState.MiniAppDesktopClose) {
            if (MiniAppUtils.isTeenagerMode()) {
                return;
            }
            scrollToTop();
        } else if (uiState instanceof MiniAppDeskTopUIState.OnChangeRedDotSwitch) {
            onChangeRedDotSwitch(((MiniAppDeskTopUIState.OnChangeRedDotSwitch) uiState).getBundle());
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void onAccountChanged(MiniAppDeskTopUIState.OnAccountChanged uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        QLog.i(getTAG(), 1, "onAccountChanged()");
        this.prefetchedDataExposed = false;
        this.mIsNeedForceRequest = true;
        initMiniAppDesktopUI();
        initMiniAppDesktopAdapter(false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        QLog.i(getTAG(), 1, "onConfigurationChanged()");
        if (getPartHost() != null) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost");
            if (((MiniAppDesktopPartHost) partHost).getMIsDesktopOpened() && !MiniAppUtils.isTeenagerMode()) {
                RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
                if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
                    return;
                }
                Iterator<T> it = adapters.iterator();
                while (it.hasNext()) {
                    ((RecyclerView.Adapter) it.next()).notifyDataSetChanged();
                }
                return;
            }
        }
        QLog.i(getTAG(), 1, "desktop is not open or teenager mode!");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e(getTAG(), 1, "onInitView rootView is null!");
        } else {
            initMiniAppDesktopUI();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.r
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppDesktopRvPart.onInitView$lambda$0(MiniAppDesktopRvPart.this);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        QLog.i(getTAG(), 1, "onPartCreate()");
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.i(getTAG(), 1, "onPartDestroy()");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.i(getTAG(), 1, "onPartPause()");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.q
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopRvPart.onPartPause$lambda$18();
            }
        }, 128, null, true);
        getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$onPartPause$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDesktopEffect invoke() {
                return new MiniAppDesktopEffect.OuterRvPartOnPause(1);
            }
        });
        ScheduledExecutorService scheduledExecutorService = this.mSearchKeyWordSchedule;
        if (scheduledExecutorService != null) {
            Intrinsics.checkNotNull(scheduledExecutorService);
            if (scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService2 = this.mSearchKeyWordSchedule;
            Intrinsics.checkNotNull(scheduledExecutorService2);
            scheduledExecutorService2.shutdown();
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.i(getTAG(), 1, "onPartResume()");
        startSearchKeyWordTask();
        getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$onPartResume$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDesktopEffect invoke() {
                return new MiniAppDesktopEffect.OuterRvPartOnResume(1);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        super.onPartStart(activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        QLog.i(getTAG(), 1, "onPartStop()");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void onPostThemeChanged(MiniAppDeskTopUIState.OnPostThemeChanged uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        QLog.i(getTAG(), 1, "onPostThemeChanged()");
        if (this.mRvConcatAdapter == null) {
            QLog.i(getTAG(), 1, "onPostThemeChanged(), mRvConcatAdapter == null, delay 1s and retry");
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.n
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppDesktopRvPart.onPostThemeChanged$lambda$2(MiniAppDesktopRvPart.this);
                }
            }, 1000L);
        } else {
            notifyDataSetChangedWhenThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void setLiveDataObserver() {
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.s
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopRvPart.setLiveDataObserver$lambda$1(MiniAppDesktopRvPart.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopAbstractPart, com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartInterface
    public void studyModeChange(boolean isStudyMode) {
        QLog.i(getTAG(), 1, "studyModeChange isStudyMode\uff1a" + isStudyMode);
        this.mRvConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), getMiniAppListAdapter(isStudyMode));
        RecyclerView recyclerView = this.mMiniAppContainerRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getPartRootView().getContext()));
            recyclerView.setAdapter(this.mRvConcatAdapter);
        }
        if (isStudyMode) {
            return;
        }
        getMMiniAppDesktopViewModel().setStartAppDesktopFirstOpen(false);
        getMMiniAppDesktopViewModel().setUserAccountFirstOpenDesktop(false);
    }

    private final List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getMiniAppListAdapter(boolean isTeenagerMode) {
        List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> mutableListOf;
        List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> mutableListOf2;
        if (isTeenagerMode) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.biz.richframework.PartLifecycleHost");
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(new MiniAppSearchAdapter((PartLifecycleHost) partHost), new MiniAppTeenagerModeAdapter());
            return mutableListOf2;
        }
        IPartHost partHost2 = getPartHost();
        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type com.tencent.biz.richframework.PartLifecycleHost");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new MiniAppSearchAdapter((PartLifecycleHost) partHost2), new MiniAppBannerAdapter(), new EmptyMiniAppHintViewAdapter(), new MiniAppRecentAdapter(), new MiniAppMineAdapter(), new MiniAppRecommendAdapter());
        return mutableListOf;
    }

    private final DesktopAppModuleInfo getMiniAppModuleTitle(List<DesktopItemInfo> titleInfo, int module) {
        if (titleInfo == null) {
            return null;
        }
        for (DesktopItemInfo desktopItemInfo : titleInfo) {
            if (desktopItemInfo instanceof DesktopAppModuleInfo) {
                DesktopAppModuleInfo desktopAppModuleInfo = (DesktopAppModuleInfo) desktopItemInfo;
                if (desktopAppModuleInfo.getModuleType() == module) {
                    return desktopAppModuleInfo;
                }
            }
        }
        return null;
    }

    private final boolean isCanShowBanner(HashMap<Integer, List<DesktopItemInfo>> desktopData) {
        if (desktopData == null || desktopData.isEmpty()) {
            return false;
        }
        List<DesktopItemInfo> list = desktopData.get(1);
        if (!(list != null && (list.isEmpty() ^ true))) {
            List<DesktopItemInfo> list2 = desktopData.get(3);
            if (!(list2 != null && (list2.isEmpty() ^ true))) {
                return false;
            }
        }
        return true;
    }
}
