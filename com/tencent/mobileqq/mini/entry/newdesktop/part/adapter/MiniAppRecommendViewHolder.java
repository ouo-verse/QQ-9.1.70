package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppMoreUiSection;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.report.MiniValidExpoReportHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 J\u001c\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J$\u0010%\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010&\u001a\u00020'2\b\u0010#\u001a\u0004\u0018\u00010\u0017H\u0002J\u001c\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010+H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppRecommendViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mExpoReportHelper", "Lcom/tencent/mobileqq/mini/report/MiniValidExpoReportHelper;", "getMExpoReportHelper", "()Lcom/tencent/mobileqq/mini/report/MiniValidExpoReportHelper;", "mListScrolling", "", "mMiniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "getMMiniAppDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "mMiniAppDesktopViewModel$delegate", "Lkotlin/Lazy;", "mMiniAppInnerPopularRv", "Landroidx/recyclerview/widget/RecyclerView;", "mMiniAppPopularInnerRvAdapter", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppPopularInnerRvAdapter;", "mMiniAppPopularInnerRvDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/ArrayList;", "mMiniAppPopularMoreSection", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppMoreUiSection;", "bindView", "", "titleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "dataList", "", "cancelMiniAppExpoReport", "holder", "desktopAppInfo", "doExpoReportAfterScroll", "doMiniAppExpoReport", "position", "", "reportExpo2Atta", QQCustomArkDialogUtil.APP_VIEW, "appInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRecommendViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "MiniAppDesktopPart.MiniAppRecommendViewHolder";
    private final MiniValidExpoReportHelper mExpoReportHelper;
    private boolean mListScrolling;

    /* renamed from: mMiniAppDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppDesktopViewModel;
    private RecyclerView mMiniAppInnerPopularRv;
    private MiniAppPopularInnerRvAdapter mMiniAppPopularInnerRvAdapter;
    private ArrayList<DesktopItemInfo> mMiniAppPopularInnerRvDataList;
    private MiniAppMoreUiSection mMiniAppPopularMoreSection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppRecommendViewHolder(final View itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.mMiniAppPopularInnerRvDataList = new ArrayList<>();
        this.mExpoReportHelper = new MiniValidExpoReportHelper("MiniAppRecommendViewHolder");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppDeskTopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecommendViewHolder$mMiniAppDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDeskTopViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(itemView);
                MiniAppDeskTopViewModel miniAppDeskTopViewModel = viewModelStoreOwner != null ? (MiniAppDeskTopViewModel) new ViewModelProvider(viewModelStoreOwner).get(MiniAppDeskTopViewModel.class) : null;
                if (miniAppDeskTopViewModel != null) {
                    Context context = itemView.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    miniAppDeskTopViewModel.setContextHashCode(((Activity) context).hashCode());
                }
                return miniAppDeskTopViewModel;
            }
        });
        this.mMiniAppDesktopViewModel = lazy;
        this.mMiniAppInnerPopularRv = (RecyclerView) itemView.findViewById(R.id.rgj);
        this.mMiniAppPopularMoreSection = new MiniAppMoreUiSection(itemView, 2, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecommendViewHolder.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                QLog.i(MiniAppRecommendViewHolder.TAG, 1, "MiniAppPopularViewHolder more btn click");
            }
        });
        this.mMiniAppPopularInnerRvAdapter = new MiniAppPopularInnerRvAdapter(new MiniAppItemCallback(), new MiniAppPopularInnerRvDelegatesManager()) { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecommendViewHolder.2
            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewAttachedToWindow(holder);
                MiniAppRecommendViewHolder miniAppRecommendViewHolder = MiniAppRecommendViewHolder.this;
                int adapterPosition = holder.getAdapterPosition();
                Object tag = holder.itemView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                miniAppRecommendViewHolder.doMiniAppExpoReport(holder, adapterPosition, (DesktopItemInfo) tag);
            }

            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewDetachedFromWindow(holder);
                MiniAppRecommendViewHolder miniAppRecommendViewHolder = MiniAppRecommendViewHolder.this;
                Object tag = holder.itemView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                miniAppRecommendViewHolder.cancelMiniAppExpoReport(holder, (DesktopItemInfo) tag);
            }
        };
        RecyclerView recyclerView = this.mMiniAppInnerPopularRv;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }
        RecyclerView recyclerView2 = this.mMiniAppInnerPopularRv;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mMiniAppPopularInnerRvAdapter);
        }
        RecyclerView recyclerView3 = this.mMiniAppInnerPopularRv;
        if (recyclerView3 != null) {
            Intrinsics.checkNotNull(recyclerView3);
            recyclerView3.addOnItemTouchListener(new MiniAppInnerRvItemTouchForDragListener(recyclerView3, new MiniAppInnerRvItemLongClickForDragListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecommendViewHolder.3
                @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener
                public void onItemClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition) {
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i(MiniAppRecommendViewHolder.TAG, 1, "mMiniAppInnerPopularRv, onItemClick");
                    if (fromPosition >= 0 && fromPosition < MiniAppRecommendViewHolder.this.mMiniAppPopularInnerRvDataList.size()) {
                        MiniAppItemClickLaunchUtils miniAppItemClickLaunchUtils = MiniAppItemClickLaunchUtils.INSTANCE;
                        Object obj = MiniAppRecommendViewHolder.this.mMiniAppPopularInnerRvDataList.get(fromPosition);
                        Intrinsics.checkNotNullExpressionValue(obj, "mMiniAppPopularInnerRvDataList[fromPosition]");
                        Context context = rv5.getContext();
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        miniAppItemClickLaunchUtils.startMini((DesktopItemInfo) obj, vh5, (Activity) context, MiniAppRecommendViewHolder.this.getMMiniAppDesktopViewModel(), fromPosition + 1);
                        MiniAppUtils.updateMiniAppList(104);
                        return;
                    }
                    QLog.i(MiniAppRecommendViewHolder.TAG, 1, "onItemClick fromPosition:" + fromPosition + "is invalid!");
                }

                @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener
                public void onItemLongClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition, float rawX, float rawY) {
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                }
            }));
        }
        itemView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.n
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppRecommendViewHolder._init_$lambda$0(itemView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View itemView, MiniAppRecommendViewHolder this$0) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppRecommendViewHolder$4$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076 A[Catch: Exception -> 0x008b, TryCatch #0 {Exception -> 0x008b, blocks: (B:22:0x0070, B:24:0x0076, B:25:0x007c), top: B:21:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doExpoReportAfterScroll() {
        View view;
        RecyclerView recyclerView = this.mMiniAppInnerPopularRv;
        if (recyclerView == null || this.mMiniAppPopularInnerRvAdapter == null) {
            return;
        }
        Intrinsics.checkNotNull(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doExpoReportAfterScroll(), startPosition:" + findFirstVisibleItemPosition + ", endPosition:" + findLastVisibleItemPosition);
        }
        try {
            if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                while (true) {
                    RecyclerView recyclerView2 = this.mMiniAppInnerPopularRv;
                    Intrinsics.checkNotNull(recyclerView2);
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                    Object tag = (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) ? null : view.getTag();
                    doMiniAppExpoReport(findViewHolderForAdapterPosition, findFirstVisibleItemPosition, tag instanceof DesktopItemInfo ? (DesktopItemInfo) tag : null);
                    if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                        findFirstVisibleItemPosition++;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "MiniProgramReporter.getInstance().flush(), delay 2000ms");
                }
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppRecommendViewHolder.doExpoReportAfterScroll$lambda$1();
                    }
                }, 2000L);
            }
            if (QLog.isColorLevel()) {
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.p
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppRecommendViewHolder.doExpoReportAfterScroll$lambda$1();
                }
            }, 2000L);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "report flush delay 2s", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doExpoReportAfterScroll$lambda$1() {
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doMiniAppExpoReport(final RecyclerView.ViewHolder holder, final int position, final DesktopItemInfo desktopAppInfo) {
        if (this.mListScrolling) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.o
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppRecommendViewHolder.doMiniAppExpoReport$lambda$3(RecyclerView.ViewHolder.this, position, desktopAppInfo, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doMiniAppExpoReport$lambda$3(RecyclerView.ViewHolder viewHolder, int i3, DesktopItemInfo desktopItemInfo, MiniAppRecommendViewHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (viewHolder == null) {
            QLog.i(TAG, 1, "holder == null, position:" + i3 + ", desktopAppInfo:" + desktopItemInfo);
        }
        if (viewHolder == null || desktopItemInfo == null || !(desktopItemInfo instanceof DesktopAppInfo)) {
            return;
        }
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
        if (desktopAppInfo.mMiniAppInfo != null) {
            MiniAppConfig miniAppConfig = new MiniAppConfig(desktopAppInfo.mMiniAppInfo);
            miniAppConfig.launchParam.scene = 3002;
            MiniAppDesktopRvPartExpoHelper miniAppDesktopRvPartExpoHelper = MiniAppDesktopRvPartExpoHelper.INSTANCE;
            MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "desktopAppInfo.mMiniAppInfo");
            String buildMiniAppExpoReportIdentity = miniAppDesktopRvPartExpoHelper.buildMiniAppExpoReportIdentity(miniAppInfo);
            String str = desktopAppInfo.isRecommendBadgeShow() ? "1" : "0";
            String str2 = desktopAppInfo.isBubbleShown() ? "1" : "0";
            String str3 = str;
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo_valid", null, String.valueOf(i3), str3, str2);
            this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, miniAppModuleExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_VALID);
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData2 = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo", null, null, str3, str2);
            miniAppModuleExposureData2.setPosition(i3 + 1);
            if (desktopAppInfo.requestScene == GetAppListV2Scene.DROP_DOWN.ordinal()) {
                miniAppModuleExposureData2.setStartTs(desktopAppInfo.requestStartTs);
            }
            this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, miniAppModuleExposureData2, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO);
            int i16 = desktopAppInfo.mMiniAppInfo.tianshuAdId;
            if (i16 > 0) {
                MiniAppExposureManager.TianShuExposureData tianShuExposureData = new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", String.valueOf(i16), 101);
                this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, tianShuExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_TIAN_SHU);
            }
            if (desktopAppInfo.mMiniAppInfo.isQQMiniApp() && TextUtils.equals("1108291530", desktopAppInfo.mMiniAppInfo.appId)) {
                MiniAppExposureManager.StoreEntryExposureData storeEntryExposureData = new MiniAppExposureManager.StoreEntryExposureData("main");
                this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, storeEntryExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_STORE_ENTRY);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "mExpoReportHelper.beginExpoReport, itemIdentity:" + buildMiniAppExpoReportIdentity + ", data:" + miniAppModuleExposureData);
            }
            if (2 == desktopAppInfo.getModuleType()) {
                this$0.reportExpo2Atta(viewHolder.itemView, desktopAppInfo.mMiniAppInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniAppDeskTopViewModel getMMiniAppDesktopViewModel() {
        return (MiniAppDeskTopViewModel) this.mMiniAppDesktopViewModel.getValue();
    }

    public final void bindView(DesktopAppModuleInfo titleInfo, List<DesktopItemInfo> dataList) {
        Intrinsics.checkNotNullParameter(titleInfo, "titleInfo");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.mMiniAppPopularInnerRvDataList.clear();
        this.mMiniAppPopularInnerRvDataList.addAll(dataList);
        MiniAppPopularInnerRvAdapter miniAppPopularInnerRvAdapter = this.mMiniAppPopularInnerRvAdapter;
        if (miniAppPopularInnerRvAdapter != null) {
            miniAppPopularInnerRvAdapter.setItems(dataList);
        }
        MiniAppPopularInnerRvAdapter miniAppPopularInnerRvAdapter2 = this.mMiniAppPopularInnerRvAdapter;
        if (miniAppPopularInnerRvAdapter2 != null) {
            miniAppPopularInnerRvAdapter2.notifyDataSetChanged();
        }
        MiniAppMoreUiSection miniAppMoreUiSection = this.mMiniAppPopularMoreSection;
        if (miniAppMoreUiSection != null) {
            miniAppMoreUiSection.bindView(titleInfo, dataList);
        }
    }

    public final MiniValidExpoReportHelper getMExpoReportHelper() {
        return this.mExpoReportHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelMiniAppExpoReport(RecyclerView.ViewHolder holder, DesktopItemInfo desktopAppInfo) {
        MiniAppInfo miniAppInfo;
        if (holder == null || desktopAppInfo == null || !(desktopAppInfo instanceof DesktopAppInfo) || (miniAppInfo = ((DesktopAppInfo) desktopAppInfo).mMiniAppInfo) == null) {
            return;
        }
        MiniAppDesktopRvPartExpoHelper miniAppDesktopRvPartExpoHelper = MiniAppDesktopRvPartExpoHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(miniAppInfo, "desktopAppInfo.mMiniAppInfo");
        String buildMiniAppExpoReportIdentity = miniAppDesktopRvPartExpoHelper.buildMiniAppExpoReportIdentity(miniAppInfo);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_VALID);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_TIAN_SHU);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_STORE_ENTRY);
    }

    private final void reportExpo2Atta(View appView, MiniAppInfo appInfo) {
        if (appInfo == null || appView == null || appInfo.getReportType() != 1) {
            return;
        }
        this.mExpoReportHelper.beginExpoReport(appView, new MiniAppExposureManager.FriendPlayExpoData(appInfo), appInfo.appId + "_3002");
    }
}
