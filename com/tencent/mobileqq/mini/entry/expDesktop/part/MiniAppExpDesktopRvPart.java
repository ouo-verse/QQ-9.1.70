package com.tencent.mobileqq.mini.entry.expDesktop.part;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankSubTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopUIState;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.EmptyMiniAppViewAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.LimitedTimeWxRecommendModuleAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragHelper;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.PersonalMiniAppModuleAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.RankModuleAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.SearchBarViewAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppTeenagerModeAdapter;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.util.MiniAppDesktopCompatibleUtils;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.az;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020!H\u0016J\u001e\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020$0#0\u00192\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020\u0006H\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u0017H\u0016J\u0012\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00103\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00107\u001a\u00020\u0017H\u0016J\u0010\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020=H\u0002J\u0016\u0010>\u001a\u00020\u00172\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u0019H\u0002J\u0010\u0010A\u001a\u00020\u00172\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\u0017H\u0002J\u0010\u0010E\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0014H\u0002J\b\u0010F\u001a\u00020\u0017H\u0016J&\u0010G\u001a\u00020\u00172\b\u0010H\u001a\u0004\u0018\u00010\u000e2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020K0JH\u0002J\u001e\u0010L\u001a\u00020\u00172\u0006\u00109\u001a\u00020:2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u0019H\u0002J\u0010\u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020\u0017H\u0002J\b\u0010S\u001a\u00020\u0017H\u0002J\u0010\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0006H\u0016J\b\u0010V\u001a\u00020\u0017H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopRvPart;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopAbstractPart;", "()V", "mDesktopDraggingProhibitClickView", "Landroid/view/View;", "mFirstOpenDesktopPreLoad", "", "mIsEmptyViewModuleExp", "mIsMineAppModuleExp", "mIsNeedDelayRefresh", "mIsRankModuleExp", "mIsRecentPlayAppModuleExp", "mIsRecommendModuleExp", "mMiniAppContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "mRoot", "Landroid/widget/FrameLayout;", "mRvConcatAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mUiState", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState$UpdateDesktopAllMiniAppInfo;", "prefetchedDataExposed", "addOnScrollListenerWithMainThread", "", "compatibleElderModeRankList", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankSubTabAppInfo;", "subTabAppInfo", "", "doDelayRefreshRv", "emptyViewModuleExpDtReport", "firstOpenDesktopPreLoad", "getLogTag", "", "getMiniAppListAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isTeenagerMode", "handleUiState", "uiState", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "initMiniAppDesktopAdapter", "initMiniAppDesktopUI", "isNeedDelayRefreshRv", "isNeedDoDelayRefreshRv", "onAccountChanged", "onConfigurationChanged", "configuration", "Landroid/content/res/Configuration;", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onPartPause", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "onPartResume", "onPostThemeChanged", "personalModuleExpDtReport", "moduleType", "", "preloadMiniAppInfo", "scene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "rankModuleExpDtReport", "miniAppRankInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "recommendModuleExpDtReport", "limitedTimeWxRecommendAppInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "scrollToTop", "setAllMiniAppInfo", "setLiveDataObserver", "setPersonalMiniAppInfo", "recyclerView", "personalModuleMap", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "setRankSubTabMiniAppInfo", "rankModules", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "setRankTabChangeListener", "rankAdapter", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/RankModuleAdapter;", "setRootOnDragListenerWithMainThread", "setViewListenerWithMainThread", "studyModeChange", "isStudyMode", "teenagerTipViewModuleExpDtReport", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRvPart extends MiniAppExpDesktopAbstractPart {
    private static final int ELDER_MODE_RANK_MAX_ACCOUNT = 3;
    private View mDesktopDraggingProhibitClickView;
    private boolean mFirstOpenDesktopPreLoad;
    private boolean mIsEmptyViewModuleExp;
    private boolean mIsMineAppModuleExp;
    private boolean mIsNeedDelayRefresh;
    private boolean mIsRankModuleExp;
    private boolean mIsRecentPlayAppModuleExp;
    private boolean mIsRecommendModuleExp;
    private RecyclerView mMiniAppContainerRv;
    private volatile FrameLayout mRoot;
    private volatile RFWConcatAdapter mRvConcatAdapter;
    private MiniAppExpDesktopUIState.UpdateDesktopAllMiniAppInfo mUiState;
    private boolean prefetchedDataExposed;

    private final void addOnScrollListenerWithMainThread() {
        RecyclerView recyclerView = this.mMiniAppContainerRv;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$addOnScrollListenerWithMainThread$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView2, final int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    super.onScrollStateChanged(recyclerView2, newState);
                    MiniAppExpDesktopRvPart.this.getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$addOnScrollListenerWithMainThread$1$onScrollStateChanged$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final MiniAppExpDesktopEffect invoke() {
                            return new MiniAppExpDesktopEffect.OuterRvPartOnScrollStateChanged(newState);
                        }
                    });
                }
            });
        }
    }

    private final List<ExpDesktopRankSubTabAppInfo> compatibleElderModeRankList(List<ExpDesktopRankSubTabAppInfo> subTabAppInfo) {
        List<ExpDesktopRankSubTabAppInfo> mutableList;
        List<ExpDesktopRankSubTabAppInfo> mutableList2;
        if (!SimpleUIUtil.isNowElderMode() || subTabAppInfo.size() <= 3) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) subTabAppInfo);
            return mutableList;
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) subTabAppInfo.subList(0, 3));
        return mutableList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doDelayRefreshRv() {
        if (isNeedDoDelayRefreshRv()) {
            MiniAppExpDesktopUIState.UpdateDesktopAllMiniAppInfo updateDesktopAllMiniAppInfo = this.mUiState;
            Intrinsics.checkNotNull(updateDesktopAllMiniAppInfo);
            setAllMiniAppInfo(updateDesktopAllMiniAppInfo);
            this.mIsNeedDelayRefresh = false;
            this.mUiState = null;
            QLog.i(getTAG(), 1, "doDelayRefreshRv do delay refresh!");
        }
    }

    private final void emptyViewModuleExpDtReport() {
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
        if (((MiniAppExpDesktopPartHost) partHost).getMIsDesktopOpened() && !this.mIsEmptyViewModuleExp) {
            MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper.INSTANCE.getInstance(), "qq_imp", "em_applet_no_result", null, null, 12, null);
            this.mIsEmptyViewModuleExp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void firstOpenDesktopPreLoad() {
        if (this.mFirstOpenDesktopPreLoad) {
            QLog.i(getTAG(), 1, "firstOpenDesktopPreLoad is do!");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.u
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppExpDesktopRvPart.firstOpenDesktopPreLoad$lambda$3();
                }
            }, 16, null, true);
            this.mFirstOpenDesktopPreLoad = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void firstOpenDesktopPreLoad$lambda$3() {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).preloadMiniAppOnce();
        Manager manager = MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER);
        MiniAppSearchDataManager miniAppSearchDataManager = manager instanceof MiniAppSearchDataManager ? (MiniAppSearchDataManager) manager : null;
        if (miniAppSearchDataManager != null) {
            miniAppSearchDataManager.getCachedHistorySearchList();
        }
    }

    private final void initMiniAppDesktopAdapter() {
        this.mRvConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), getMiniAppListAdapter(MiniAppUtils.isTeenagerMode()));
        setViewListenerWithMainThread();
    }

    private final void initMiniAppDesktopUI() {
        View findViewById = getPartRootView().findViewById(R.id.rf9);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.mMiniAppContainerRv = (RecyclerView) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.rgc);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mRoot = (FrameLayout) findViewById2;
        View findViewById3 = getPartRootView().findViewById(R.id.rcx);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.mDesktopDraggingProhibitClickView = findViewById3;
        Intrinsics.checkNotNull(findViewById3);
        findViewById3.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean initMiniAppDesktopUI$lambda$7;
                initMiniAppDesktopUI$lambda$7 = MiniAppExpDesktopRvPart.initMiniAppDesktopUI$lambda$7(view, motionEvent);
                return initMiniAppDesktopUI$lambda$7;
            }
        });
        if (az.e(getContext())) {
            float c16 = az.c(getContext());
            RecyclerView recyclerView = this.mMiniAppContainerRv;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setPadding(0, 0, 0, ((int) c16) + ViewUtils.f352270a.a(80.0f));
            return;
        }
        RecyclerView recyclerView2 = this.mMiniAppContainerRv;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setPadding(0, 0, 0, ViewUtils.f352270a.a(80.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initMiniAppDesktopUI$lambda$7(View view, MotionEvent motionEvent) {
        return true;
    }

    private final boolean isNeedDelayRefreshRv() {
        if (getPartRootView().getContext().getResources().getConfiguration().orientation != 2) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
            if (((MiniAppExpDesktopPartHost) partHost).getMIsDesktopOpened()) {
                return false;
            }
        }
        return true;
    }

    private final boolean isNeedDoDelayRefreshRv() {
        if (getPartRootView().getContext().getResources().getConfiguration().orientation == 1 && this.mIsNeedDelayRefresh && this.mUiState != null) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
            if (((MiniAppExpDesktopPartHost) partHost).getMIsDesktopOpened()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitView$lambda$0(MiniAppExpDesktopRvPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initMiniAppDesktopAdapter();
        MiniAppCmdUtil miniAppCmdUtil = MiniAppCmdUtil.getInstance();
        if (QLog.isColorLevel()) {
            QLog.i(this$0.getTAG(), 2, "initMiniAppDesktopAdapter(true) and perload MiniAppCmdUtil.getInstance():" + miniAppCmdUtil);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitView$lambda$1(MiniAppExpDesktopRvPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.preloadMiniAppInfo(GetAppListV2Scene.START_UP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPostThemeChanged$lambda$5(MiniAppExpDesktopRvPart this$0) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            RFWConcatAdapter rFWConcatAdapter = this$0.mRvConcatAdapter;
            if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
                return;
            }
            Iterator<T> it = adapters.iterator();
            while (it.hasNext()) {
                RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
                if (adapter instanceof RankModuleAdapter) {
                    ((RankModuleAdapter) adapter).setRvDataClearOnThemeChanged();
                }
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e16) {
            QLog.e(this$0.getTAG(), 1, "notifyDataSetChangedWhenThemeChanged error", e16);
        }
    }

    private final void personalModuleExpDtReport(int moduleType) {
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
        if (((MiniAppExpDesktopPartHost) partHost).getMIsDesktopOpened()) {
            if (moduleType != 1) {
                if (moduleType == 3 && !this.mIsMineAppModuleExp) {
                    MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper.INSTANCE.getInstance(), "qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_PERSONAL_MODULE, null, null, 12, null);
                    this.mIsMineAppModuleExp = true;
                    return;
                }
                return;
            }
            if (this.mIsRecentPlayAppModuleExp) {
                return;
            }
            MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper.INSTANCE.getInstance(), "qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_RECENTLY_USE_MODULE, null, null, 12, null);
            this.mIsRecentPlayAppModuleExp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preloadMiniAppInfo(GetAppListV2Scene scene) {
        if (this.mRvConcatAdapter == null) {
            QLog.d(getTAG(), 1, "mRvConcatAdapter == null, not init finish or it is " + scene);
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopRvPart$preloadMiniAppInfo$1(this, scene, null), 3, null);
    }

    private final void recommendModuleExpDtReport(ExpDesktopGroupAppInfo limitedTimeWxRecommendAppInfo) {
        String joinToString$default;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
        if (!((MiniAppExpDesktopPartHost) partHost).getMIsDesktopOpened() || this.mIsRecommendModuleExp) {
            return;
        }
        if (limitedTimeWxRecommendAppInfo.getGroupAppInfo().size() <= 3) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(limitedTimeWxRecommendAppInfo.getGroupAppInfo(), ",", null, null, 0, null, new Function1<DesktopAppInfo, CharSequence>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$recommendModuleExpDtReport$appIds$2
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(DesktopAppInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str = it.mMiniAppInfo.appId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.mMiniAppInfo.appId");
                    return str;
                }
            }, 30, null);
        } else {
            List<DesktopAppInfo> subList = limitedTimeWxRecommendAppInfo.getGroupAppInfo().subList(0, 3);
            Intrinsics.checkNotNullExpressionValue(subList, "limitedTimeWxRecommendAp\u2026.MAX_MINI_APP_SHOW_COUNT)");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(subList, ",", null, null, 0, null, new Function1<DesktopAppInfo, CharSequence>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$recommendModuleExpDtReport$appIds$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(DesktopAppInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str = it.mMiniAppInfo.appId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.mMiniAppInfo.appId");
                    return str;
                }
            }, 30, null);
        }
        MiniAppExpDesktop04239ReportHelper.INSTANCE.report((r23 & 1) != 0 ? null : joinToString$default, (r23 & 2) != 0 ? null : null, "em_expo", (r23 & 8) != 0 ? null : MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XSTG, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        QLog.i(getTAG(), 1, "recommendModuleExpDtReport appIds:" + joinToString$default);
        MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper.INSTANCE.getInstance(), "qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_LIMITED_TIME_RECOMMENDED_MODULE, null, null, 12, null);
        this.mIsRecommendModuleExp = true;
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

    private final void setAllMiniAppInfo(MiniAppExpDesktopUIState.UpdateDesktopAllMiniAppInfo uiState) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        if (isNeedDelayRefreshRv()) {
            this.mUiState = uiState;
            this.mIsNeedDelayRefresh = true;
            QLog.i(getTAG(), 1, "setAllMiniAppInfo not need refresh!");
            return;
        }
        RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
        if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
            return;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            if (adapter instanceof SearchBarViewAdapter) {
                adapter.notifyDataSetChanged();
            } else {
                boolean z16 = false;
                if (adapter instanceof EmptyMiniAppViewAdapter) {
                    DesktopItemInfo desktopItemInfo = uiState.getPersonalModuleMap().get(1);
                    DesktopItemInfo desktopItemInfo2 = uiState.getPersonalModuleMap().get(3);
                    boolean z17 = desktopItemInfo == null || ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo().isEmpty();
                    boolean z18 = desktopItemInfo2 == null || ((ExpDesktopGroupAppInfo) desktopItemInfo2).getGroupAppInfo().isEmpty();
                    EmptyMiniAppViewAdapter emptyMiniAppViewAdapter = (EmptyMiniAppViewAdapter) adapter;
                    if (z17 && z18) {
                        z16 = true;
                    }
                    emptyMiniAppViewAdapter.setData(z16);
                    emptyViewModuleExpDtReport();
                } else if (adapter instanceof PersonalMiniAppModuleAdapter) {
                    setPersonalMiniAppInfo(this.mMiniAppContainerRv, uiState.getPersonalModuleMap());
                } else if ((adapter instanceof LimitedTimeWxRecommendModuleAdapter) && (!uiState.getRecommendModules().isEmpty())) {
                    ((LimitedTimeWxRecommendModuleAdapter) adapter).setData(this.mMiniAppContainerRv, uiState.getRecommendModules().get(0));
                    recommendModuleExpDtReport(uiState.getRecommendModules().get(0));
                } else if ((adapter instanceof RankModuleAdapter) && (!uiState.getRankModules().isEmpty())) {
                    RankModuleAdapter rankModuleAdapter = (RankModuleAdapter) adapter;
                    rankModuleAdapter.setData(this.mMiniAppContainerRv, compatibleElderModeRankList(uiState.getRankModules().get(0).getRankSubTabAppInfo()));
                    setRankTabChangeListener(rankModuleAdapter);
                    rankModuleExpDtReport(uiState.getRankModules());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$2(MiniAppExpDesktopRvPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopRvPart$setLiveDataObserver$1$1(this$0, null), 3, null);
    }

    private final void setRankSubTabMiniAppInfo(int moduleType, List<DesktopAppInfo> rankModules) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
        if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
            return;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            if (adapter instanceof RankModuleAdapter) {
                ((RankModuleAdapter) adapter).setRankSubTabMiniAppInfo(this.mMiniAppContainerRv, moduleType, rankModules);
            }
        }
    }

    private final void setRankTabChangeListener(final RankModuleAdapter rankAdapter) {
        rankAdapter.setRankTabChangeListener(new RankMiniAppViewHolder.OnRankTabChangeListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$setRankTabChangeListener$1
            @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder.OnRankTabChangeListener
            public void onTabChanged(int mainTabPosition, int moduleType, ArrayList<DesktopAppInfo> rankAppInfo) {
                RecyclerView recyclerView;
                Intrinsics.checkNotNullParameter(rankAppInfo, "rankAppInfo");
                if (rankAppInfo.isEmpty()) {
                    LifecycleOwner lifecycleOwner = MiniAppExpDesktopRvPart.this.getPartHost().getLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopRvPart$setRankTabChangeListener$1$onTabChanged$1(MiniAppExpDesktopRvPart.this, moduleType, null), 3, null);
                }
                RankModuleAdapter rankModuleAdapter = rankAdapter;
                recyclerView = MiniAppExpDesktopRvPart.this.mMiniAppContainerRv;
                rankModuleAdapter.setRankSubTabMiniAppInfo(recyclerView, moduleType, rankAppInfo);
                QLog.i(MiniAppExpDesktopRvPart.this.getTAG(), 1, "onTabChanged mainTabPosition" + mainTabPosition + " moduleType:" + moduleType);
            }
        });
    }

    private final void setRootOnDragListenerWithMainThread() {
        FrameLayout frameLayout = this.mRoot;
        if (frameLayout != null) {
            frameLayout.setOnDragListener(new View.OnDragListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.t
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view, DragEvent dragEvent) {
                    boolean rootOnDragListenerWithMainThread$lambda$11;
                    rootOnDragListenerWithMainThread$lambda$11 = MiniAppExpDesktopRvPart.setRootOnDragListenerWithMainThread$lambda$11(MiniAppExpDesktopRvPart.this, view, dragEvent);
                    return rootOnDragListenerWithMainThread$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setRootOnDragListenerWithMainThread$lambda$11(MiniAppExpDesktopRvPart this$0, final View view, DragEvent dragEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view == null || dragEvent == null || dragEvent.getLocalState() == null || !(dragEvent.getLocalState() instanceof MiniAppExpDragData)) {
            return false;
        }
        if (dragEvent.getAction() != 2) {
            QLog.i(this$0.getTAG(), 1, "root view action:" + MiniAppExpDragHelper.INSTANCE.getDragActionString(dragEvent.getAction()) + "\uff0cevent=" + dragEvent);
        }
        int action = dragEvent.getAction();
        if (action == 1) {
            if (this$0.getContext() instanceof Activity) {
                MiniAppDesktopCompatibleUtils.INSTANCE.compatibleDeviceDraggingState(this$0.mDesktopDraggingProhibitClickView, true);
            }
            return true;
        }
        if (action != 2) {
            if (action != 4) {
                if (action != 5) {
                    return action == 6;
                }
                Object localState = dragEvent.getLocalState();
                Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
                final MiniAppExpDragData miniAppExpDragData = (MiniAppExpDragData) localState;
                if (miniAppExpDragData.getStartRv().getId() != R.id.rfb) {
                    this$0.getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$setRootOnDragListenerWithMainThread$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final MiniAppExpDesktopEffect invoke() {
                            return new MiniAppExpDesktopEffect.OnDragEntered(MiniAppExpDragData.this.getStartRv().getId(), view.getId());
                        }
                    });
                }
                return true;
            }
            if (this$0.getContext() instanceof Activity) {
                MiniAppDesktopCompatibleUtils.INSTANCE.compatibleDeviceDraggingState(this$0.mDesktopDraggingProhibitClickView, false);
            }
            MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
            Object localState2 = dragEvent.getLocalState();
            Intrinsics.checkNotNull(localState2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragData");
            companion.resetDraggingViewState((MiniAppExpDragData) localState2);
        }
        return true;
    }

    private final void setViewListenerWithMainThread() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            addOnScrollListenerWithMainThread();
            setRootOnDragListenerWithMainThread();
            RecyclerView recyclerView = this.mMiniAppContainerRv;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getPartRootView().getContext()));
                recyclerView.setAdapter(this.mRvConcatAdapter);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.w
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopRvPart.setViewListenerWithMainThread$lambda$10(MiniAppExpDesktopRvPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewListenerWithMainThread$lambda$10(MiniAppExpDesktopRvPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.addOnScrollListenerWithMainThread();
        this$0.setRootOnDragListenerWithMainThread();
        RecyclerView recyclerView = this$0.mMiniAppContainerRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this$0.getPartRootView().getContext()));
            recyclerView.setAdapter(this$0.mRvConcatAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void teenagerTipViewModuleExpDtReport() {
        if (MiniAppUtils.isTeenagerMode()) {
            MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper.INSTANCE.getInstance(), "qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_TEENAGER_MODE_TIP, new LinkedHashMap(), null, 8, null);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MiniAppExpDesktopPart.MiniAppExpDesktopRvPart";
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void handleUiState(MiniAppExpDesktopUIState uiState) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        QLog.i(getTAG(), 1, "handleUiState:" + uiState);
        if (uiState instanceof MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo) {
            setPersonalMiniAppInfo(this.mMiniAppContainerRv, ((MiniAppExpDesktopUIState.UpdateDesktopPersonalMiniAppInfo) uiState).getPersonalModuleMap());
            return;
        }
        if (uiState instanceof MiniAppExpDesktopUIState.UpdateDesktopRankMiniAppInfo) {
            MiniAppExpDesktopUIState.UpdateDesktopRankMiniAppInfo updateDesktopRankMiniAppInfo = (MiniAppExpDesktopUIState.UpdateDesktopRankMiniAppInfo) uiState;
            setRankSubTabMiniAppInfo(updateDesktopRankMiniAppInfo.getModuleType(), updateDesktopRankMiniAppInfo.getRankMiniAppInfo());
            return;
        }
        if (uiState instanceof MiniAppExpDesktopUIState.UpdateDesktopAllMiniAppInfo) {
            setAllMiniAppInfo((MiniAppExpDesktopUIState.UpdateDesktopAllMiniAppInfo) uiState);
            return;
        }
        if (uiState instanceof MiniAppExpDesktopUIState.MyMiniAppDraggingTempSwitchPosition) {
            RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
            if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
                return;
            }
            Iterator<T> it = adapters.iterator();
            while (it.hasNext()) {
                RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
                if (adapter instanceof PersonalMiniAppModuleAdapter) {
                    PersonalMiniAppModuleAdapter personalMiniAppModuleAdapter = (PersonalMiniAppModuleAdapter) adapter;
                    if (personalMiniAppModuleAdapter.getMModuleType() == 3) {
                        personalMiniAppModuleAdapter.refreshMiniAppInfo(this.mMiniAppContainerRv, bg.f302144a.n(((MiniAppExpDesktopUIState.MyMiniAppDraggingTempSwitchPosition) uiState).getDeepCopyMyMiniAppInfo()));
                    }
                }
            }
            return;
        }
        if (uiState instanceof MiniAppExpDesktopUIState.MiniAppDesktopClose) {
            if (MiniAppUtils.isTeenagerMode()) {
                QLog.i(getTAG(), 1, "is teenager mode!");
            } else {
                scrollToTop();
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void onAccountChanged() {
        QLog.i(getTAG(), 1, "onAccountChanged()");
        this.prefetchedDataExposed = false;
        initMiniAppDesktopUI();
        initMiniAppDesktopAdapter();
        preloadMiniAppInfo(GetAppListV2Scene.ACCOUNT_CHANGE);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        QLog.i(getTAG(), 1, "onConfigurationChanged()");
        if (getPartHost() != null) {
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
            if (((MiniAppExpDesktopPartHost) partHost).getMIsDesktopOpened()) {
                IPartHost partHost2 = getPartHost();
                Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
                if (!((MiniAppExpDesktopPartHost) partHost2).isSubPageVisible() && !MiniAppUtils.isTeenagerMode()) {
                    doDelayRefreshRv();
                    return;
                }
            }
        }
        QLog.i(getTAG(), 1, "desktop is not open or teenager mode!");
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e(getTAG(), 1, "onInitView rootView is null!");
            return;
        }
        initMiniAppDesktopUI();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.r
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopRvPart.onInitView$lambda$0(MiniAppExpDesktopRvPart.this);
            }
        }, 16, null, true);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.s
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopRvPart.onInitView$lambda$1(MiniAppExpDesktopRvPart.this);
            }
        }, 1000L);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.i(getTAG(), 1, "onPartPause()");
        MiniProgramReporter.getInstance().flush();
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.i(getTAG(), 1, "onPartResume()");
        getMMiniAppDesktopViewModel().setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$onPartResume$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppExpDesktopEffect invoke() {
                return new MiniAppExpDesktopEffect.OuterRvPartOnResume(1);
            }
        });
        this.mIsRecentPlayAppModuleExp = false;
        this.mIsEmptyViewModuleExp = false;
        this.mIsMineAppModuleExp = false;
        this.mIsRecommendModuleExp = false;
        this.mIsRankModuleExp = false;
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void onPostThemeChanged() {
        QLog.i(getTAG(), 1, "onPostThemeChanged()");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.v
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopRvPart.onPostThemeChanged$lambda$5(MiniAppExpDesktopRvPart.this);
            }
        }, 1000L);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void setLiveDataObserver() {
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.q
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopRvPart.setLiveDataObserver$lambda$2(MiniAppExpDesktopRvPart.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
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
        getMMiniAppDesktopViewModel().setPreloadInfo(GetAppListV2Scene.DROP_DOWN);
    }

    private final void setPersonalMiniAppInfo(RecyclerView recyclerView, Map<Integer, DesktopItemInfo> personalModuleMap) {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters;
        if (personalModuleMap.containsKey(1) && personalModuleMap.containsKey(3)) {
            RFWConcatAdapter rFWConcatAdapter = this.mRvConcatAdapter;
            if (rFWConcatAdapter == null || (adapters = rFWConcatAdapter.getAdapters()) == null) {
                return;
            }
            Iterator<T> it = adapters.iterator();
            while (it.hasNext()) {
                RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
                if (adapter instanceof EmptyMiniAppViewAdapter) {
                    DesktopItemInfo desktopItemInfo = personalModuleMap.get(1);
                    Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
                    boolean isEmpty = ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo().isEmpty();
                    DesktopItemInfo desktopItemInfo2 = personalModuleMap.get(3);
                    Intrinsics.checkNotNull(desktopItemInfo2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
                    boolean isEmpty2 = ((ExpDesktopGroupAppInfo) desktopItemInfo2).getGroupAppInfo().isEmpty();
                    ((EmptyMiniAppViewAdapter) adapter).setData(isEmpty && isEmpty2);
                    if (isEmpty && isEmpty2) {
                        emptyViewModuleExpDtReport();
                    }
                } else if (adapter instanceof PersonalMiniAppModuleAdapter) {
                    PersonalMiniAppModuleAdapter personalMiniAppModuleAdapter = (PersonalMiniAppModuleAdapter) adapter;
                    if (personalMiniAppModuleAdapter.getMModuleType() == 1 || personalMiniAppModuleAdapter.getMModuleType() == 3) {
                        DesktopItemInfo desktopItemInfo3 = personalModuleMap.get(Integer.valueOf(personalMiniAppModuleAdapter.getMModuleType()));
                        Intrinsics.checkNotNull(desktopItemInfo3, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
                        personalMiniAppModuleAdapter.setData(recyclerView, (ExpDesktopGroupAppInfo) desktopItemInfo3);
                        IPartHost partHost = getPartHost();
                        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
                        personalMiniAppModuleAdapter.setPartHost(partHost);
                        personalModuleExpDtReport(personalMiniAppModuleAdapter.getMModuleType());
                    }
                }
            }
            return;
        }
        QLog.i(getTAG(), 1, "setPersonalMiniAppInfo personalModuleMap is invalid!");
    }

    private final List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getMiniAppListAdapter(boolean isTeenagerMode) {
        List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> mutableListOf;
        List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> mutableListOf2;
        if (isTeenagerMode) {
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(new MiniAppTeenagerModeAdapter());
            return mutableListOf2;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new SearchBarViewAdapter(), new EmptyMiniAppViewAdapter(), new PersonalMiniAppModuleAdapter(1), new PersonalMiniAppModuleAdapter(3), new LimitedTimeWxRecommendModuleAdapter(), new RankModuleAdapter());
        return mutableListOf;
    }

    private final void rankModuleExpDtReport(List<ExpDesktopRankTabAppInfo> miniAppRankInfo) {
        Map mutableMapOf;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
        if (((MiniAppExpDesktopPartHost) partHost).getMIsDesktopOpened() && !this.mIsRankModuleExp && (!miniAppRankInfo.isEmpty()) && (!miniAppRankInfo.get(0).getRankSubTabAppInfo().isEmpty())) {
            MiniAppDesktopDtReportHelper.Companion companion = MiniAppDesktopDtReportHelper.INSTANCE;
            MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(companion.getInstance(), "qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_LEADERBOARD_MODULE, null, null, 12, null);
            MiniAppDesktopDtReportHelper companion2 = companion.getInstance();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PRIMARY_TAB, miniAppRankInfo.get(0).getMMainTitle()), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APPLET_PRIMARY_TAB, miniAppRankInfo.get(0).getRankSubTabAppInfo().get(0).getMTitle()));
            MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(companion2, "qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_PRIMARY_TAB, mutableMapOf, null, 8, null);
            this.mIsRankModuleExp = true;
        }
    }
}
