package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.LimitedTimeRecommendMiniAppInnerRvAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemTouchForDragListener;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.delegate.LimitedTimeRecommendMiniAppInnerRvDelegatesManager;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section.MiniAppTitleMoreUiSection;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppItemCallback;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\u001bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/LimitedTimeRecommendMiniAppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mExpoReportHelper", "Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "getMExpoReportHelper", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "setMExpoReportHelper", "(Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;)V", "mLimitedTimeRecommendGroupAppInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "mLimitedTimeRecommendModuleInnerRv", "Landroidx/recyclerview/widget/RecyclerView;", "mLimitedTimeRecommendRvAdapter", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mMiniAppExpDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "getMMiniAppExpDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "mMiniAppExpDesktopViewModel$delegate", "Lkotlin/Lazy;", "mMiniAppTitleMoreUiSection", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppTitleMoreUiSection;", "bindView", "", "recentUsedGroupAppInfo", "getHostSceneStr", "", "fromPosition", "", "gotoLimitedTimeRecommendPage", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class LimitedTimeRecommendMiniAppViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "LimitedTimeRecommendMiniAppViewHolder";
    private MiniExpValidExpoReportHelper mExpoReportHelper;
    private ExpDesktopGroupAppInfo mLimitedTimeRecommendGroupAppInfo;
    private RecyclerView mLimitedTimeRecommendModuleInnerRv;
    private AsyncListDifferDelegationAdapter<DesktopItemInfo> mLimitedTimeRecommendRvAdapter;

    /* renamed from: mMiniAppExpDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppExpDesktopViewModel;
    private MiniAppTitleMoreUiSection mMiniAppTitleMoreUiSection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitedTimeRecommendMiniAppViewHolder(final View itemView) {
        super(itemView);
        Lazy lazy;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppExpDesktopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.LimitedTimeRecommendMiniAppViewHolder$mMiniAppExpDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppExpDesktopViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(itemView);
                MiniAppExpDesktopViewModel miniAppExpDesktopViewModel = viewModelStoreOwner != null ? (MiniAppExpDesktopViewModel) new ViewModelProvider(viewModelStoreOwner).get(MiniAppExpDesktopViewModel.class) : null;
                if (miniAppExpDesktopViewModel != null) {
                    Context context = itemView.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    miniAppExpDesktopViewModel.setContextHashCode(((Activity) context).hashCode());
                }
                return miniAppExpDesktopViewModel;
            }
        });
        this.mMiniAppExpDesktopViewModel = lazy;
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("", "");
        this.mLimitedTimeRecommendGroupAppInfo = new ExpDesktopGroupAppInfo("", 2, arrayList, arrayListOf, null, false, 48, null);
        this.mMiniAppTitleMoreUiSection = new MiniAppTitleMoreUiSection(itemView);
        View findViewById = itemView.findViewById(R.id.rgg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026mited_time_recycler_view)");
        this.mLimitedTimeRecommendModuleInnerRv = (RecyclerView) findViewById;
        this.mMiniAppTitleMoreUiSection.setMoreBtnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LimitedTimeRecommendMiniAppViewHolder._init_$lambda$0(LimitedTimeRecommendMiniAppViewHolder.this, view);
            }
        });
        this.mLimitedTimeRecommendRvAdapter = new LimitedTimeRecommendMiniAppInnerRvAdapter(new MiniAppItemCallback(), new LimitedTimeRecommendMiniAppInnerRvDelegatesManager()) { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.LimitedTimeRecommendMiniAppViewHolder.2
            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
                Map<String, String> mutableMapOf;
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewAttachedToWindow(holder);
                if (!(!LimitedTimeRecommendMiniAppViewHolder.this.mLimitedTimeRecommendGroupAppInfo.getGroupAppInfo().isEmpty()) || LimitedTimeRecommendMiniAppViewHolder.this.getMExpoReportHelper() == null) {
                    return;
                }
                MiniExpValidExpoReportHelper mExpoReportHelper = LimitedTimeRecommendMiniAppViewHolder.this.getMExpoReportHelper();
                Intrinsics.checkNotNull(mExpoReportHelper);
                int positionInfoByViewHolder = mExpoReportHelper.getPositionInfoByViewHolder(LimitedTimeRecommendMiniAppViewHolder.this.mLimitedTimeRecommendGroupAppInfo.getGroupAppInfo(), holder);
                MiniExpValidExpoReportHelper mExpoReportHelper2 = LimitedTimeRecommendMiniAppViewHolder.this.getMExpoReportHelper();
                Intrinsics.checkNotNull(mExpoReportHelper2);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", LimitedTimeRecommendMiniAppViewHolder.this.mLimitedTimeRecommendGroupAppInfo.getVia().get(0)), TuplesKt.to("position", String.valueOf(positionInfoByViewHolder)), TuplesKt.to("module", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_RECENTLY_USE_MODULE), TuplesKt.to("page_id", MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN), TuplesKt.to("host_scene", LimitedTimeRecommendMiniAppViewHolder.this.getHostSceneStr(positionInfoByViewHolder)));
                mExpoReportHelper2.sendMiniAppExpoReport(holder, mutableMapOf);
            }

            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewDetachedFromWindow(holder);
                MiniExpValidExpoReportHelper mExpoReportHelper = LimitedTimeRecommendMiniAppViewHolder.this.getMExpoReportHelper();
                if (mExpoReportHelper != null) {
                    Object tag = holder.itemView.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                    mExpoReportHelper.cancelMiniAppExpoReport(holder, (DesktopItemInfo) tag);
                }
            }
        };
        this.mLimitedTimeRecommendModuleInnerRv.setLayoutManager(new GridLayoutManager(itemView.getContext(), 4));
        this.mLimitedTimeRecommendModuleInnerRv.setAdapter(this.mLimitedTimeRecommendRvAdapter);
        this.mLimitedTimeRecommendModuleInnerRv.setHasFixedSize(false);
        RecyclerView recyclerView = this.mLimitedTimeRecommendModuleInnerRv;
        recyclerView.addOnItemTouchListener(new MiniAppExpInnerRvItemTouchForDragListener(recyclerView, new MiniAppExpInnerRvItemLongClickForDragListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.LimitedTimeRecommendMiniAppViewHolder.3
            @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener
            public void onItemClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition) {
                Intrinsics.checkNotNullParameter(rv5, "rv");
                Intrinsics.checkNotNullParameter(vh5, "vh");
                LimitedTimeRecommendMiniAppViewHolder.this.gotoLimitedTimeRecommendPage();
            }

            @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener
            public void onItemLongClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition, float rawX, float rawY) {
                Intrinsics.checkNotNullParameter(rv5, "rv");
                Intrinsics.checkNotNullParameter(vh5, "vh");
                QLog.i(LimitedTimeRecommendMiniAppViewHolder.TAG, 1, "onItemLongClick");
            }
        }));
        itemView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.b
            @Override // java.lang.Runnable
            public final void run() {
                LimitedTimeRecommendMiniAppViewHolder._init_$lambda$1(itemView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(LimitedTimeRecommendMiniAppViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotoLimitedTimeRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(View itemView, LimitedTimeRecommendMiniAppViewHolder this$0) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new LimitedTimeRecommendMiniAppViewHolder$4$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getHostSceneStr(int fromPosition) {
        Object valueOf;
        if (this.mLimitedTimeRecommendGroupAppInfo.getHostScene().isEmpty()) {
            QLog.e(TAG, 1, "getHostSceneStr LimitedTimeRecommendGroupAppInfo error,hostScene is empty!");
            return "";
        }
        if (fromPosition < 9) {
            valueOf = "0" + (fromPosition + 1);
        } else {
            valueOf = Integer.valueOf(fromPosition + 1);
        }
        String str = this.mLimitedTimeRecommendGroupAppInfo.getHostScene().get(0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append((Object) str);
        sb5.append(valueOf);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniAppExpDesktopViewModel getMMiniAppExpDesktopViewModel() {
        return (MiniAppExpDesktopViewModel) this.mMiniAppExpDesktopViewModel.getValue();
    }

    public final void bindView(ExpDesktopGroupAppInfo recentUsedGroupAppInfo) {
        Intrinsics.checkNotNullParameter(recentUsedGroupAppInfo, "recentUsedGroupAppInfo");
        this.mLimitedTimeRecommendGroupAppInfo = recentUsedGroupAppInfo;
        this.mMiniAppTitleMoreUiSection.bindView(recentUsedGroupAppInfo.getMModuleTitle());
        this.mLimitedTimeRecommendModuleInnerRv.setVisibility(0);
        this.mMiniAppTitleMoreUiSection.showMoreLayoutView();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(recentUsedGroupAppInfo.getGroupAppInfo());
        AsyncListDifferDelegationAdapter<DesktopItemInfo> asyncListDifferDelegationAdapter = this.mLimitedTimeRecommendRvAdapter;
        Intrinsics.checkNotNull(asyncListDifferDelegationAdapter);
        asyncListDifferDelegationAdapter.setItems(arrayList);
        if (this.mExpoReportHelper == null) {
            this.mExpoReportHelper = new MiniExpValidExpoReportHelper(TAG);
        }
    }

    public final MiniExpValidExpoReportHelper getMExpoReportHelper() {
        return this.mExpoReportHelper;
    }

    public final void setMExpoReportHelper(MiniExpValidExpoReportHelper miniExpValidExpoReportHelper) {
        this.mExpoReportHelper = miniExpValidExpoReportHelper;
    }

    public final void gotoLimitedTimeRecommendPage() {
        String str;
        MiniAppLauncher.launchWxMiniGameCenter(this.itemView.getContext());
        MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(MiniAppDesktopDtReportHelper.INSTANCE.getInstance(), "qq_clck", MiniAppDesktopDtReportHelper.MINI_APP_EM_LIMITED_TIME_RECOMMENDED_MODULE, null, null, 12, null);
        StringBuilder sb5 = new StringBuilder("");
        int i3 = 0;
        for (Object obj : this.mLimitedTimeRecommendGroupAppInfo.getGroupAppInfo()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) obj;
            if (i3 < this.mLimitedTimeRecommendGroupAppInfo.getGroupAppInfo().size() - 1) {
                str = desktopAppInfo.mMiniAppInfo.appId + ",";
            } else {
                str = desktopAppInfo.mMiniAppInfo.appId;
            }
            sb5.append(str);
            i3 = i16;
        }
        MiniAppExpDesktop04239ReportHelper.INSTANCE.report((r23 & 1) != 0 ? null : sb5.toString(), (r23 & 2) != 0 ? null : null, "em_click", (r23 & 8) != 0 ? null : MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XSTG, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        MiniProgramReporter.getInstance().flush();
    }
}
