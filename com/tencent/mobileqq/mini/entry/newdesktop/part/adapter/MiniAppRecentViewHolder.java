package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopEffect;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDragHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.MiniAppMoreUiSection;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniValidExpoReportHelper;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"2\b\b\u0002\u0010#\u001a\u00020\nJ\u001a\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J$\u0010(\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010)\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010\u0019H\u0002J \u0010+\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"2\b\b\u0002\u0010#\u001a\u00020\nH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppRecentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mExpoReportHelper", "Lcom/tencent/mobileqq/mini/report/MiniValidExpoReportHelper;", "getMExpoReportHelper", "()Lcom/tencent/mobileqq/mini/report/MiniValidExpoReportHelper;", "mListScrolling", "", "mMiniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "getMMiniAppDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "mMiniAppDesktopViewModel$delegate", "Lkotlin/Lazy;", "mMiniAppInnerRecentRv", "Landroidx/recyclerview/widget/RecyclerView;", "mMiniAppRecentInnerRvAdapter", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppRecentInnerRvAdapter;", "mMiniAppRecentMoreSection", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppMoreUiSection;", "mRecentRvDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/ArrayList;", "mTitleTv", "Landroid/widget/TextView;", "bindView", "", "titleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppModuleInfo;", "dataList", "", "isForceRefresh", "cancelMiniAppExpoReport", "holder", "desktopAppInfo", "doExpoReportAfterScroll", "doMiniAppExpoReport", "position", "", "setData", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRecentViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "MiniAppDesktopPart.MiniAppRecentViewHolder";
    private final MiniValidExpoReportHelper mExpoReportHelper;
    private boolean mListScrolling;

    /* renamed from: mMiniAppDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppDesktopViewModel;
    private RecyclerView mMiniAppInnerRecentRv;
    private MiniAppRecentInnerRvAdapter mMiniAppRecentInnerRvAdapter;
    private MiniAppMoreUiSection mMiniAppRecentMoreSection;
    private ArrayList<DesktopItemInfo> mRecentRvDataList;
    private TextView mTitleTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppRecentViewHolder(final View itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppDeskTopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecentViewHolder$mMiniAppDesktopViewModel$2
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
        this.mRecentRvDataList = new ArrayList<>();
        this.mExpoReportHelper = new MiniValidExpoReportHelper("MiniAppRecentViewHolder");
        this.mMiniAppInnerRecentRv = (RecyclerView) itemView.findViewById(R.id.rgk);
        this.mTitleTv = (TextView) itemView.findViewById(R.id.rgt);
        this.mMiniAppRecentMoreSection = new MiniAppMoreUiSection(itemView, 1, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecentViewHolder.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                QLog.i(MiniAppRecentViewHolder.TAG, 1, "MiniAppRecentViewHolder more btn click");
                MiniAppDeskTopViewModel mMiniAppDesktopViewModel = MiniAppRecentViewHolder.this.getMMiniAppDesktopViewModel();
                if (mMiniAppDesktopViewModel != null) {
                    final MiniAppRecentViewHolder miniAppRecentViewHolder = MiniAppRecentViewHolder.this;
                    mMiniAppDesktopViewModel.setEffect(new Function0<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecentViewHolder.1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final MiniAppDesktopEffect invoke() {
                            ArrayList arrayList = MiniAppRecentViewHolder.this.mRecentRvDataList;
                            String qqStr = HardCodeUtil.qqStr(R.string.f213435q7);
                            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.qqstr_miniappd_6e644192)");
                            return new MiniAppDesktopEffect.SetSubLayoutDesktopDataList(arrayList, 1, qqStr);
                        }
                    });
                }
            }
        });
        MiniAppItemCallback miniAppItemCallback = new MiniAppItemCallback();
        RecyclerView recyclerView = this.mMiniAppInnerRecentRv;
        Intrinsics.checkNotNull(recyclerView);
        this.mMiniAppRecentInnerRvAdapter = new MiniAppRecentInnerRvAdapter(miniAppItemCallback, new MiniAppRecentInnerRvDelegatesManager(recyclerView)) { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecentViewHolder.2
            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewAttachedToWindow(holder);
                MiniAppRecentViewHolder miniAppRecentViewHolder = MiniAppRecentViewHolder.this;
                int adapterPosition = holder.getAdapterPosition();
                Object tag = holder.itemView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                miniAppRecentViewHolder.doMiniAppExpoReport(holder, adapterPosition, (DesktopItemInfo) tag);
            }

            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewDetachedFromWindow(holder);
                MiniAppRecentViewHolder miniAppRecentViewHolder = MiniAppRecentViewHolder.this;
                Object tag = holder.itemView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                miniAppRecentViewHolder.cancelMiniAppExpoReport(holder, (DesktopItemInfo) tag);
            }
        };
        GridLayoutManager gridLayoutManager = new GridLayoutManager(itemView.getContext(), 4);
        RecyclerView recyclerView2 = this.mMiniAppInnerRecentRv;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(gridLayoutManager);
        }
        RecyclerView recyclerView3 = this.mMiniAppInnerRecentRv;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(false);
        }
        RecyclerView recyclerView4 = this.mMiniAppInnerRecentRv;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(this.mMiniAppRecentInnerRvAdapter);
        }
        RecyclerView recyclerView5 = this.mMiniAppInnerRecentRv;
        if (recyclerView5 != null) {
            Intrinsics.checkNotNull(recyclerView5);
            recyclerView5.addOnItemTouchListener(new MiniAppInnerRvItemTouchForDragListener(recyclerView5, new MiniAppInnerRvItemLongClickForDragListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppRecentViewHolder.3
                @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener
                public void onItemClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition) {
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i(MiniAppRecentViewHolder.TAG, 1, "mMiniAppInnerRecentRv, onItemClick");
                    if (fromPosition >= 0 && fromPosition < MiniAppRecentViewHolder.this.mRecentRvDataList.size()) {
                        MiniAppItemClickLaunchUtils miniAppItemClickLaunchUtils = MiniAppItemClickLaunchUtils.INSTANCE;
                        Object obj = MiniAppRecentViewHolder.this.mRecentRvDataList.get(fromPosition);
                        Intrinsics.checkNotNullExpressionValue(obj, "mRecentRvDataList[fromPosition]");
                        Context context = rv5.getContext();
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        MiniAppItemClickLaunchUtils.startMini$default(miniAppItemClickLaunchUtils, (DesktopItemInfo) obj, vh5, (Activity) context, MiniAppRecentViewHolder.this.getMMiniAppDesktopViewModel(), 0, 16, null);
                        MiniAppUtils.updateMiniAppList(104);
                        return;
                    }
                    QLog.i(MiniAppRecentViewHolder.TAG, 1, "onItemClick fromPosition:" + fromPosition + "is invalid!");
                }

                @Override // com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppInnerRvItemLongClickForDragListener
                public void onItemLongClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition, float rawX, float rawY) {
                    List<DesktopItemInfo> items;
                    List<DesktopItemInfo> items2;
                    Intrinsics.checkNotNullParameter(rv5, "rv");
                    Intrinsics.checkNotNullParameter(vh5, "vh");
                    QLog.i(MiniAppRecentViewHolder.TAG, 1, "mMiniAppInnerRecentRv, onItemLongClick");
                    if (MiniAppRecentViewHolder.this.mMiniAppRecentInnerRvAdapter != null) {
                        MiniAppRecentInnerRvAdapter miniAppRecentInnerRvAdapter = MiniAppRecentViewHolder.this.mMiniAppRecentInnerRvAdapter;
                        DesktopItemInfo desktopItemInfo = null;
                        if ((miniAppRecentInnerRvAdapter != null ? miniAppRecentInnerRvAdapter.getItems() : null) != null && fromPosition >= 0) {
                            MiniAppRecentInnerRvAdapter miniAppRecentInnerRvAdapter2 = MiniAppRecentViewHolder.this.mMiniAppRecentInnerRvAdapter;
                            Integer valueOf = (miniAppRecentInnerRvAdapter2 == null || (items2 = miniAppRecentInnerRvAdapter2.getItems()) == null) ? null : Integer.valueOf(items2.size());
                            Intrinsics.checkNotNull(valueOf);
                            if (fromPosition < valueOf.intValue()) {
                                MiniAppDragHelper.Companion companion = MiniAppDragHelper.INSTANCE;
                                MiniAppRecentInnerRvAdapter miniAppRecentInnerRvAdapter3 = MiniAppRecentViewHolder.this.mMiniAppRecentInnerRvAdapter;
                                if (miniAppRecentInnerRvAdapter3 != null && (items = miniAppRecentInnerRvAdapter3.getItems()) != null) {
                                    desktopItemInfo = items.get(fromPosition);
                                }
                                Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
                                companion.startDrag(rv5, vh5, null, fromPosition, (DesktopAppInfo) desktopItemInfo, rawX, rawY);
                                return;
                            }
                        }
                    }
                    QLog.i(MiniAppRecentViewHolder.TAG, 1, "onItemLongClick fromPosition:" + fromPosition + "is invalid!");
                }
            }));
        }
        itemView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.m
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppRecentViewHolder._init_$lambda$0(itemView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View itemView, MiniAppRecentViewHolder this$0) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppRecentViewHolder$4$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doExpoReportAfterScroll() {
        View view;
        RecyclerView recyclerView = this.mMiniAppInnerRecentRv;
        if (recyclerView == null || this.mMiniAppRecentInnerRvAdapter == null) {
            return;
        }
        Intrinsics.checkNotNull(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return;
        }
        while (true) {
            RecyclerView recyclerView2 = this.mMiniAppInnerRecentRv;
            Intrinsics.checkNotNull(recyclerView2);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
            Object tag = (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) ? null : view.getTag();
            doMiniAppExpoReport(findViewHolderForAdapterPosition, findFirstVisibleItemPosition, tag instanceof DesktopItemInfo ? (DesktopItemInfo) tag : null);
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return;
            } else {
                findFirstVisibleItemPosition++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doMiniAppExpoReport(final RecyclerView.ViewHolder holder, final int position, final DesktopItemInfo desktopAppInfo) {
        if (this.mListScrolling) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.l
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppRecentViewHolder.doMiniAppExpoReport$lambda$2(RecyclerView.ViewHolder.this, desktopAppInfo, position, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniAppDeskTopViewModel getMMiniAppDesktopViewModel() {
        return (MiniAppDeskTopViewModel) this.mMiniAppDesktopViewModel.getValue();
    }

    private final void setData(List<DesktopItemInfo> dataList, boolean isForceRefresh) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(dataList);
        MiniAppRecentInnerRvAdapter miniAppRecentInnerRvAdapter = this.mMiniAppRecentInnerRvAdapter;
        Intrinsics.checkNotNull(miniAppRecentInnerRvAdapter);
        miniAppRecentInnerRvAdapter.setItems(arrayList);
        if (isForceRefresh) {
            MiniAppRecentInnerRvAdapter miniAppRecentInnerRvAdapter2 = this.mMiniAppRecentInnerRvAdapter;
            Intrinsics.checkNotNull(miniAppRecentInnerRvAdapter2);
            miniAppRecentInnerRvAdapter2.notifyDataSetChanged();
        }
    }

    public final void bindView(DesktopAppModuleInfo titleInfo, List<DesktopItemInfo> dataList, boolean isForceRefresh) {
        Intrinsics.checkNotNullParameter(titleInfo, "titleInfo");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        QLog.i(TAG, 1, "recent module inner rv bindView!");
        this.mRecentRvDataList.clear();
        this.mRecentRvDataList.addAll(dataList);
        setData(this.mRecentRvDataList, isForceRefresh);
        MiniAppMoreUiSection miniAppMoreUiSection = this.mMiniAppRecentMoreSection;
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
        if (holder == null || !(desktopAppInfo instanceof DesktopAppInfo) || (miniAppInfo = ((DesktopAppInfo) desktopAppInfo).mMiniAppInfo) == null) {
            return;
        }
        MiniAppDesktopRvPartExpoHelper miniAppDesktopRvPartExpoHelper = MiniAppDesktopRvPartExpoHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(miniAppInfo, "desktopAppInfo.mMiniAppInfo");
        String buildMiniAppExpoReportIdentity = miniAppDesktopRvPartExpoHelper.buildMiniAppExpoReportIdentity(miniAppInfo);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_VALID);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_TIAN_SHU);
        this.mExpoReportHelper.cancelExpoReport(buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_CATEGORY);
    }

    public static /* synthetic */ void bindView$default(MiniAppRecentViewHolder miniAppRecentViewHolder, DesktopAppModuleInfo desktopAppModuleInfo, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        miniAppRecentViewHolder.bindView(desktopAppModuleInfo, list, z16);
    }

    static /* synthetic */ void setData$default(MiniAppRecentViewHolder miniAppRecentViewHolder, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        miniAppRecentViewHolder.setData(list, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doMiniAppExpoReport$lambda$2(RecyclerView.ViewHolder viewHolder, DesktopItemInfo desktopItemInfo, int i3, MiniAppRecentViewHolder this$0) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (viewHolder == null || desktopItemInfo == null || !(desktopItemInfo instanceof DesktopAppInfo)) {
            return;
        }
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
        if (desktopAppInfo.mMiniAppInfo != null) {
            MiniAppConfig miniAppConfig = new MiniAppConfig(desktopAppInfo.mMiniAppInfo);
            miniAppConfig.launchParam.scene = 3001;
            MiniAppDesktopRvPartExpoHelper miniAppDesktopRvPartExpoHelper = MiniAppDesktopRvPartExpoHelper.INSTANCE;
            MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
            Intrinsics.checkNotNullExpressionValue(miniAppInfo, "desktopAppInfo.mMiniAppInfo");
            String buildMiniAppExpoReportIdentity = miniAppDesktopRvPartExpoHelper.buildMiniAppExpoReportIdentity(miniAppInfo);
            if (desktopAppInfo.isRecommendBadgeShow()) {
                str = "1";
            } else {
                str = "0";
            }
            if (desktopAppInfo.isBubbleShown()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            String str3 = str;
            String str4 = str2;
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo_valid", null, String.valueOf(i3), str3, str4);
            this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, miniAppModuleExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_VALID);
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData2 = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo", null, null, str3, str4);
            miniAppModuleExposureData2.setPosition(i3 + 1);
            this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, miniAppModuleExposureData2, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO);
            int i16 = desktopAppInfo.mMiniAppInfo.tianshuAdId;
            if (i16 > 0) {
                MiniAppExposureManager.TianShuExposureData tianShuExposureData = new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", String.valueOf(i16), 101);
                this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, tianShuExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_TIAN_SHU);
            }
            MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData3 = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "desktop", MiniProgramLpReportDC04239.DESKTOP_SUB_ACTION_TYPE_RECENT_APP, "expo", null);
            this$0.mExpoReportHelper.beginExpoReport(viewHolder.itemView, miniAppModuleExposureData3, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_CATEGORY);
        }
    }
}
