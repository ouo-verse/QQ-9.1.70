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
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankSubTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemTouchForDragListener;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.RankMiniAppInnerRvAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.delegate.RankMiniAppInnerRvDelegatesManager;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section.MiniAppTabBarMoreUiSection;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section.MiniAppTitleMoreUiSection;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpDesktopNotifyUtil;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpItemClickLaunchUtils;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.minigame.utils.EntryConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00029:B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0%2\b\u0010&\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010'\u001a\u00020\nJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\nH\u0002J\u0013\u0010+\u001a\b\u0012\u0004\u0012\u00020)0,H\u0002\u00a2\u0006\u0002\u0010-J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020#H\u0002J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u00020#R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u0006j\b\u0012\u0004\u0012\u00020!`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/RankMiniAppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mCurrentRankInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "Lkotlin/collections/ArrayList;", "mCurrentTabIndex", "", "mExpoReportHelper", "Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "getMExpoReportHelper", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "mMiniAppExpDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "getMMiniAppExpDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "mMiniAppExpDesktopViewModel$delegate", "Lkotlin/Lazy;", "mMiniAppRankInnerRvAdapter", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/RankMiniAppInnerRvAdapter;", "mMiniAppTabBarMoreUiSection", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppTabBarMoreUiSection;", "mMiniAppTitleMoreUiSection", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppTitleMoreUiSection;", "mOnRankTabChangeListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/RankMiniAppViewHolder$OnRankTabChangeListener;", "mRankInnerRv", "Landroidx/recyclerview/widget/RecyclerView;", "mRankLoadingLayout", "mRankModuleDataInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankSubTabAppInfo;", "bindView", "", "rankListInfo", "", "onRankTabChangeListener", "getCurrentMainTabIndex", "getHostSceneStr", "", "fromPosition", "getMainTabTitleInfo", "", "()[Ljava/lang/String;", "getNotPositionHostSceneStr", "getRankModuleVia", "moreBtnClickEvent", "reportViewExpo", "resetCurrentTabPosition", "setRankInnerRvInfo", "setRankMainTitleInfo", "setRankViewState", "showRankRv", "", "setRvDataClearOnThemeChanged", "Companion", "OnRankTabChangeListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class RankMiniAppViewHolder extends RecyclerView.ViewHolder {
    public static final int DEFAULT_TAB_INDEX = 0;
    private static final int ITEM_VIEW_CACHE_SIZE = 2;
    private static final String TAG = "RankMiniAppViewHolder";
    private ArrayList<DesktopAppInfo> mCurrentRankInfo;
    private int mCurrentTabIndex;
    private final MiniExpValidExpoReportHelper mExpoReportHelper;

    /* renamed from: mMiniAppExpDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppExpDesktopViewModel;
    private RankMiniAppInnerRvAdapter mMiniAppRankInnerRvAdapter;
    private MiniAppTabBarMoreUiSection mMiniAppTabBarMoreUiSection;
    private MiniAppTitleMoreUiSection mMiniAppTitleMoreUiSection;
    private OnRankTabChangeListener mOnRankTabChangeListener;
    private RecyclerView mRankInnerRv;
    private View mRankLoadingLayout;
    private ArrayList<ExpDesktopRankSubTabAppInfo> mRankModuleDataInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/RankMiniAppViewHolder$OnRankTabChangeListener;", "", "onTabChanged", "", "mainTabPosition", "", "moduleType", "rankAppInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "Lkotlin/collections/ArrayList;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface OnRankTabChangeListener {
        void onTabChanged(int mainTabPosition, int moduleType, ArrayList<DesktopAppInfo> rankAppInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder$2] */
    public RankMiniAppViewHolder(final View itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppExpDesktopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder$mMiniAppExpDesktopViewModel$2
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
        this.mRankModuleDataInfo = new ArrayList<>();
        this.mCurrentRankInfo = new ArrayList<>();
        this.mExpoReportHelper = new MiniExpValidExpoReportHelper(TAG);
        View findViewById = itemView.findViewById(R.id.rha);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026rank_inner_recycler_view)");
        this.mRankInnerRv = (RecyclerView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.rhb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026_app_rank_loading_layout)");
        this.mRankLoadingLayout = findViewById2;
        View findViewById3 = itemView.findViewById(R.id.rh8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026p_personal_tabbar_layout)");
        this.mMiniAppTabBarMoreUiSection = new MiniAppTabBarMoreUiSection(findViewById3);
        View findViewById4 = itemView.findViewById(R.id.rh9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026pp_personal_title_layout)");
        this.mMiniAppTitleMoreUiSection = new MiniAppTitleMoreUiSection(findViewById4);
        this.mMiniAppRankInnerRvAdapter = new RankMiniAppInnerRvAdapter(new DiffUtil.ItemCallback<DesktopItemInfo>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder.2
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(DesktopItemInfo p06, DesktopItemInfo p16) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p16, "p1");
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(DesktopItemInfo p06, DesktopItemInfo p16) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p16, "p1");
                return false;
            }
        }, new RankMiniAppInnerRvDelegatesManager()) { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder.1
            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
                Map<String, String> mutableMapOf;
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewAttachedToWindow(holder);
                int positionInfoByViewHolder = RankMiniAppViewHolder.this.getMExpoReportHelper().getPositionInfoByViewHolder(RankMiniAppViewHolder.this.mCurrentRankInfo, holder);
                MiniExpValidExpoReportHelper mExpoReportHelper = RankMiniAppViewHolder.this.getMExpoReportHelper();
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", RankMiniAppViewHolder.this.getRankModuleVia()), TuplesKt.to("position", String.valueOf(positionInfoByViewHolder)), TuplesKt.to("module", MiniAppDesktopDtReportHelper.MINI_APP_EM_PRIMARY_TAB), TuplesKt.to("page_id", MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN), TuplesKt.to(MiniExpValidExpoReportHelper.ReportKeyConst.REPORT_KEY_TAB_TITLE, ((ExpDesktopRankSubTabAppInfo) RankMiniAppViewHolder.this.mRankModuleDataInfo.get(RankMiniAppViewHolder.this.mCurrentTabIndex)).getMTitle()), TuplesKt.to("host_scene", RankMiniAppViewHolder.this.getHostSceneStr(positionInfoByViewHolder)));
                mExpoReportHelper.sendMiniAppExpoReport(holder, mutableMapOf);
            }

            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewDetachedFromWindow(holder);
                MiniExpValidExpoReportHelper mExpoReportHelper = RankMiniAppViewHolder.this.getMExpoReportHelper();
                Object tag = holder.itemView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                mExpoReportHelper.cancelMiniAppExpoReport(holder, (DesktopItemInfo) tag);
            }
        };
        this.mRankInnerRv.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        this.mRankInnerRv.setAdapter(this.mMiniAppRankInnerRvAdapter);
        RecyclerView recyclerView = this.mRankInnerRv;
        recyclerView.addOnItemTouchListener(new MiniAppExpInnerRvItemTouchForDragListener(recyclerView, new MiniAppExpInnerRvItemLongClickForDragListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder.3
            @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener
            public void onItemLongClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition, float rawX, float rawY) {
                Intrinsics.checkNotNullParameter(rv5, "rv");
                Intrinsics.checkNotNullParameter(vh5, "vh");
            }

            @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener
            public void onItemClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition) {
                Map mutableMapOf;
                Intrinsics.checkNotNullParameter(rv5, "rv");
                Intrinsics.checkNotNullParameter(vh5, "vh");
                QLog.i(RankMiniAppViewHolder.TAG, 1, "RankMiniAppViewHolder, onItemClick");
                if (fromPosition >= 0 && fromPosition < RankMiniAppViewHolder.this.mCurrentRankInfo.size()) {
                    MiniAppInfo miniAppInfo = ((DesktopAppInfo) RankMiniAppViewHolder.this.mCurrentRankInfo.get(fromPosition)).mMiniAppInfo;
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("applet_appid", miniAppInfo.appId), TuplesKt.to("applet_type", String.valueOf(miniAppInfo.engineType)), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, MiniAppDesktopDtReportHelper.MINI_APP_EM_PRIMARY_TAB), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APP_SOURCE, String.valueOf(miniAppInfo.isWxMiniApp() ? 2 : 1)), TuplesKt.to("host_scene", RankMiniAppViewHolder.this.getHostSceneStr(fromPosition)), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APPLET_PRIMARY_TAB, ((ExpDesktopRankSubTabAppInfo) RankMiniAppViewHolder.this.mRankModuleDataInfo.get(RankMiniAppViewHolder.this.mCurrentTabIndex)).getMTitle()));
                    MiniAppExpItemClickLaunchUtils miniAppExpItemClickLaunchUtils = MiniAppExpItemClickLaunchUtils.INSTANCE;
                    Context context = rv5.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    Activity activity = (Activity) context;
                    Object obj = RankMiniAppViewHolder.this.mCurrentRankInfo.get(fromPosition);
                    Intrinsics.checkNotNullExpressionValue(obj, "mCurrentRankInfo[fromPosition]");
                    DesktopAppInfo desktopAppInfo = (DesktopAppInfo) obj;
                    int i3 = fromPosition + 1;
                    MiniAppExpItemClickLaunchUtils.startMiniApp$default(miniAppExpItemClickLaunchUtils, activity, desktopAppInfo, i3, mutableMapOf, false, 16, null);
                    miniAppInfo.hostScene = RankMiniAppViewHolder.this.getHostSceneStr(fromPosition);
                    if (miniAppInfo.isWxMiniApp()) {
                        miniAppInfo.via = "";
                    } else {
                        miniAppInfo.hostScene = "";
                    }
                    MiniAppExpDesktop04239ReportHelper.reportWithAppInfo$default(MiniAppExpDesktop04239ReportHelper.INSTANCE, miniAppInfo, RankMiniAppViewHolder.this.getRankModuleVia(), "pg_click", null, null, null, null, String.valueOf(i3), 120, null);
                    return;
                }
                QLog.i(RankMiniAppViewHolder.TAG, 1, "onItemClick fromPosition:" + fromPosition + "is invalid!");
            }
        }));
        itemView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.j
            @Override // java.lang.Runnable
            public final void run() {
                RankMiniAppViewHolder._init_$lambda$0(itemView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View itemView, RankMiniAppViewHolder this$0) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new RankMiniAppViewHolder$4$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getHostSceneStr(int fromPosition) {
        Object valueOf;
        int size = this.mRankModuleDataInfo.size();
        int i3 = this.mCurrentTabIndex;
        if (size > i3 && !this.mRankModuleDataInfo.get(i3).getHostScene().isEmpty()) {
            if (fromPosition < 9) {
                valueOf = "0" + (fromPosition + 1);
            } else {
                valueOf = Integer.valueOf(fromPosition + 1);
            }
            int size2 = this.mRankModuleDataInfo.size();
            int i16 = this.mCurrentTabIndex;
            if (size2 <= i16) {
                return "";
            }
            String str = this.mRankModuleDataInfo.get(i16).getHostScene().get(0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) str);
            sb5.append(valueOf);
            return sb5.toString();
        }
        QLog.i(TAG, 1, "mRankModuleDataInfo error,getHostSceneStr is empty!");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniAppExpDesktopViewModel getMMiniAppExpDesktopViewModel() {
        return (MiniAppExpDesktopViewModel) this.mMiniAppExpDesktopViewModel.getValue();
    }

    private final String[] getMainTabTitleInfo() {
        int size = this.mRankModuleDataInfo.size();
        String[] strArr = new String[size];
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            strArr[i16] = "";
        }
        for (Object obj : this.mRankModuleDataInfo) {
            int i17 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            strArr[i3] = ((ExpDesktopRankSubTabAppInfo) obj).getMTitle();
            i3 = i17;
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getNotPositionHostSceneStr() {
        int size = this.mRankModuleDataInfo.size();
        int i3 = this.mCurrentTabIndex;
        if (size > i3) {
            String str = this.mRankModuleDataInfo.get(i3).getHostScene().get(0);
            Intrinsics.checkNotNullExpressionValue(str, "mRankModuleDataInfo[mCur\u2026.DESKTOP_MAIN_PAGE_INDEX]");
            return str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRankModuleVia() {
        int size = this.mRankModuleDataInfo.size();
        int i3 = this.mCurrentTabIndex;
        if (size > i3) {
            String str = this.mRankModuleDataInfo.get(i3).getVia().get(0);
            Intrinsics.checkNotNullExpressionValue(str, "mRankModuleDataInfo[mCur\u2026.DESKTOP_MAIN_PAGE_INDEX]");
            return str;
        }
        return "";
    }

    private final void setRankInnerRvInfo() {
        if (this.mRankModuleDataInfo.get(this.mCurrentTabIndex) != null) {
            ArrayList<DesktopAppInfo> rankAppInfo = this.mRankModuleDataInfo.get(this.mCurrentTabIndex).getRankAppInfo();
            this.mCurrentRankInfo = rankAppInfo;
            if (rankAppInfo.isEmpty()) {
                setRankViewState(false);
                return;
            }
            RankMiniAppInnerRvAdapter rankMiniAppInnerRvAdapter = this.mMiniAppRankInnerRvAdapter;
            if (rankMiniAppInnerRvAdapter != null) {
                rankMiniAppInnerRvAdapter.setItems(this.mCurrentRankInfo);
            }
            setRankViewState(true);
        }
    }

    private final void setRankMainTitleInfo() {
        if (this.mRankModuleDataInfo.size() == 1) {
            MiniAppTitleMoreUiSection miniAppTitleMoreUiSection = this.mMiniAppTitleMoreUiSection;
            Intrinsics.checkNotNull(miniAppTitleMoreUiSection);
            View mRootView = miniAppTitleMoreUiSection.getMRootView();
            if (mRootView != null) {
                mRootView.setVisibility(0);
            }
            MiniAppTabBarMoreUiSection miniAppTabBarMoreUiSection = this.mMiniAppTabBarMoreUiSection;
            Intrinsics.checkNotNull(miniAppTabBarMoreUiSection);
            View mRootView2 = miniAppTabBarMoreUiSection.getMRootView();
            if (mRootView2 != null) {
                mRootView2.setVisibility(8);
            }
            MiniAppTitleMoreUiSection miniAppTitleMoreUiSection2 = this.mMiniAppTitleMoreUiSection;
            Intrinsics.checkNotNull(miniAppTitleMoreUiSection2);
            miniAppTitleMoreUiSection2.setTitleText(this.mRankModuleDataInfo.get(0).getMTitle());
            MiniAppTitleMoreUiSection miniAppTitleMoreUiSection3 = this.mMiniAppTitleMoreUiSection;
            Intrinsics.checkNotNull(miniAppTitleMoreUiSection3);
            miniAppTitleMoreUiSection3.setMoreBtnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankMiniAppViewHolder.setRankMainTitleInfo$lambda$1(RankMiniAppViewHolder.this, view);
                }
            });
            return;
        }
        MiniAppTitleMoreUiSection miniAppTitleMoreUiSection4 = this.mMiniAppTitleMoreUiSection;
        Intrinsics.checkNotNull(miniAppTitleMoreUiSection4);
        View mRootView3 = miniAppTitleMoreUiSection4.getMRootView();
        if (mRootView3 != null) {
            mRootView3.setVisibility(8);
        }
        MiniAppTabBarMoreUiSection miniAppTabBarMoreUiSection2 = this.mMiniAppTabBarMoreUiSection;
        Intrinsics.checkNotNull(miniAppTabBarMoreUiSection2);
        View mRootView4 = miniAppTabBarMoreUiSection2.getMRootView();
        if (mRootView4 != null) {
            mRootView4.setVisibility(0);
        }
        String[] mainTabTitleInfo = getMainTabTitleInfo();
        MiniAppTabBarMoreUiSection miniAppTabBarMoreUiSection3 = this.mMiniAppTabBarMoreUiSection;
        if (miniAppTabBarMoreUiSection3 != null) {
            miniAppTabBarMoreUiSection3.bindView(mainTabTitleInfo, 16.0f);
        }
        MiniAppTabBarMoreUiSection miniAppTabBarMoreUiSection4 = this.mMiniAppTabBarMoreUiSection;
        Intrinsics.checkNotNull(miniAppTabBarMoreUiSection4);
        miniAppTabBarMoreUiSection4.setMoreListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankMiniAppViewHolder.setRankMainTitleInfo$lambda$2(RankMiniAppViewHolder.this, view);
            }
        });
        MiniAppTabBarMoreUiSection miniAppTabBarMoreUiSection5 = this.mMiniAppTabBarMoreUiSection;
        if (miniAppTabBarMoreUiSection5 != null) {
            miniAppTabBarMoreUiSection5.setTabBarChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.i
                @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
                public final void I0(int i3, boolean z16) {
                    RankMiniAppViewHolder.setRankMainTitleInfo$lambda$3(RankMiniAppViewHolder.this, i3, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRankMainTitleInfo$lambda$1(RankMiniAppViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.moreBtnClickEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRankMainTitleInfo$lambda$2(RankMiniAppViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.moreBtnClickEvent();
    }

    public final void bindView(List<ExpDesktopRankSubTabAppInfo> rankListInfo, OnRankTabChangeListener onRankTabChangeListener) {
        Intrinsics.checkNotNullParameter(rankListInfo, "rankListInfo");
        this.mRankModuleDataInfo.clear();
        this.mRankModuleDataInfo.addAll(rankListInfo);
        this.mOnRankTabChangeListener = onRankTabChangeListener;
        setRankMainTitleInfo();
        setRankInnerRvInfo();
    }

    /* renamed from: getCurrentMainTabIndex, reason: from getter */
    public final int getMCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public final MiniExpValidExpoReportHelper getMExpoReportHelper() {
        return this.mExpoReportHelper;
    }

    public final void reportViewExpo() {
        MiniAppExpDesktop04239ReportHelper.INSTANCE.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_expo", (r23 & 8) != 0 ? null : MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XIALA_BANGDAN_TAB, (r23 & 16) != 0 ? null : String.valueOf(this.mCurrentTabIndex + 1), (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        MiniProgramReporter.getInstance().flush();
    }

    public final void resetCurrentTabPosition() {
        this.mCurrentTabIndex = 0;
        MiniAppTabBarMoreUiSection miniAppTabBarMoreUiSection = this.mMiniAppTabBarMoreUiSection;
        if (miniAppTabBarMoreUiSection != null) {
            miniAppTabBarMoreUiSection.setCurrentPosition(0);
        }
    }

    public final void setRvDataClearOnThemeChanged() {
        try {
            Field declaredField = this.mRankInnerRv.getClass().getDeclaredField("mRecycler");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.mRankInnerRv);
            RecyclerView.Recycler recycler = obj instanceof RecyclerView.Recycler ? (RecyclerView.Recycler) obj : null;
            if (recycler != null) {
                recycler.clear();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "clear recycler error for " + e16);
        }
        this.mRankInnerRv.getRecycledViewPool().clear();
        this.mRankInnerRv.setItemViewCacheSize(2);
        RecyclerView.Adapter<?> adapter = this.mRankInnerRv.getAdapter();
        if (adapter != null) {
            MiniAppExpDesktopNotifyUtil.INSTANCE.safeNotifyDataSetChanged(this.mRankInnerRv, adapter);
        }
    }

    private final void moreBtnClickEvent() {
        Map mutableMapOf;
        MiniAppLauncher.launchMiniGameCenter(this.itemView.getContext(), EntryConstants.DropdownEntry.DROPDOWN_FRIEND_PLAYING_ENTRY);
        MiniAppUtils.reportMiniGameCenterDC00087("1", "969", "9044", "904401", "209626", "20", EntryConstants.DropdownEntry.DROPDOWN_FRIEND_PLAYING_ENTRY);
        MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, MiniAppDesktopDtReportHelper.MINI_APP_EM_LEADERBOARD_MODULE));
        MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(companion, "qq_clck", MiniAppDesktopDtReportHelper.MINI_APP_EM_SEE_MORE, mutableMapOf, null, 8, null);
        MiniAppExpDesktop04239ReportHelper.INSTANCE.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_click", (r23 & 8) != 0 ? null : MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XIALA_BANGDAN_MORE, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        MiniProgramReporter.getInstance().flush();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRankMainTitleInfo$lambda$3(RankMiniAppViewHolder this$0, int i3, boolean z16) {
        Map mutableMapOf;
        Map mutableMapOf2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCurrentTabIndex = i3;
        int moduleType = this$0.mRankModuleDataInfo.get(i3).getModuleType();
        ArrayList<DesktopAppInfo> rankAppInfo = this$0.mRankModuleDataInfo.get(this$0.mCurrentTabIndex).getRankAppInfo();
        OnRankTabChangeListener onRankTabChangeListener = this$0.mOnRankTabChangeListener;
        if (onRankTabChangeListener != null) {
            onRankTabChangeListener.onTabChanged(this$0.mCurrentTabIndex, moduleType, rankAppInfo);
        }
        if (z16) {
            MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PRIMARY_TAB, this$0.mRankModuleDataInfo.get(this$0.mCurrentTabIndex).getMTitle()), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APPLET_PRIMARY_TAB, this$0.mRankModuleDataInfo.get(this$0.mCurrentTabIndex).getMTitle()));
            MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(companion, "qq_clck", MiniAppDesktopDtReportHelper.MINI_APP_EM_PRIMARY_TAB, mutableMapOf2, null, 8, null);
            MiniAppExpDesktop04239ReportHelper.INSTANCE.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_click", (r23 & 8) != 0 ? null : MiniAppExpDesktop04239ReportHelper.RESERVE_ACTION_XIALA_BANGDAN_TAB, (r23 & 16) != 0 ? null : String.valueOf(i3 + 1), (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
            MiniProgramReporter.getInstance().flush();
        }
        MiniAppDesktopDtReportHelper companion2 = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PRIMARY_TAB, this$0.mRankModuleDataInfo.get(this$0.mCurrentTabIndex).getMTitle()), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APPLET_PRIMARY_TAB, this$0.mRankModuleDataInfo.get(this$0.mCurrentTabIndex).getMTitle()));
        MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(companion2, "qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_PRIMARY_TAB, mutableMapOf, null, 8, null);
        this$0.reportViewExpo();
    }

    private final void setRankViewState(boolean showRankRv) {
        if (showRankRv) {
            this.mRankLoadingLayout.setVisibility(8);
            this.mRankInnerRv.setVisibility(0);
            return;
        }
        RankMiniAppInnerRvAdapter rankMiniAppInnerRvAdapter = this.mMiniAppRankInnerRvAdapter;
        if (rankMiniAppInnerRvAdapter != null) {
            rankMiniAppInnerRvAdapter.setItems(Collections.emptyList());
        }
        RecyclerView.Adapter<?> adapter = this.mRankInnerRv.getAdapter();
        if (adapter != null) {
            MiniAppExpDesktopNotifyUtil.INSTANCE.safeNotifyDataSetChanged(this.mRankInnerRv, adapter);
        }
        this.mRankInnerRv.setVisibility(8);
        this.mRankLoadingLayout.setVisibility(0);
    }
}
