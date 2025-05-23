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
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragHelper;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemTouchForDragListener;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.PersonalMiniAppInnerRvAdapter;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.delegate.PersonalMiniAppInnerRvDelegatesManager;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.section.MiniAppTitleMoreUiSection;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpItemClickLaunchUtils;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppItemCallback;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppExpDesktop04239ReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0014J\u001e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0014H\u0002J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020(H\u0002J\u000e\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/PersonalMiniAppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mExpoReportHelper", "Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "getMExpoReportHelper", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;", "setMExpoReportHelper", "(Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniExpValidExpoReportHelper;)V", "mMiniAppExpDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "getMMiniAppExpDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopViewModel;", "mMiniAppExpDesktopViewModel$delegate", "Lkotlin/Lazy;", "mMiniAppTitleMoreUiSection", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/section/MiniAppTitleMoreUiSection;", "mModuleType", "", "mPersonalGroupAppInfo", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "mPersonalModuleInnerRv", "Landroidx/recyclerview/widget/RecyclerView;", "mPersonalRvAdapter", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mPortHost", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "bindView", "", "recentUsedGroupAppInfo", "moduleType", "findIndexFromMineRv", "fromDesktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "dataList", "", "getHostSceneStr", "", "fromPosition", "miniAppOperateReport", "desktopAppInfo", AdMetricTag.EVENT_NAME, "setPartHost", "partHost", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PersonalMiniAppViewHolder extends RecyclerView.ViewHolder {
    private static final String EXPO_MY_MODULE_TAG = "MyMiniAppViewHolder";
    private static final String EXPO_RECENT_USED_MODULE_TAG = "recentUsedMiniAppViewHolder";
    private static final String TAG = "PersonalMiniAppViewHolder";
    private MiniExpValidExpoReportHelper mExpoReportHelper;

    /* renamed from: mMiniAppExpDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppExpDesktopViewModel;
    private MiniAppTitleMoreUiSection mMiniAppTitleMoreUiSection;
    private int mModuleType;
    private ExpDesktopGroupAppInfo mPersonalGroupAppInfo;
    private RecyclerView mPersonalModuleInnerRv;
    private AsyncListDifferDelegationAdapter<DesktopItemInfo> mPersonalRvAdapter;
    private IPartHost mPortHost;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalMiniAppViewHolder(final View itemView) {
        super(itemView);
        Lazy lazy;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppExpDesktopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.PersonalMiniAppViewHolder$mMiniAppExpDesktopViewModel$2
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
        this.mPersonalGroupAppInfo = new ExpDesktopGroupAppInfo("", 1, arrayList, arrayListOf, null, false, 48, null);
        this.mModuleType = 1;
        this.mMiniAppTitleMoreUiSection = new MiniAppTitleMoreUiSection(itemView);
        View findViewById = itemView.findViewById(R.id.rh7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026onal_inner_recycler_view)");
        this.mPersonalModuleInnerRv = (RecyclerView) findViewById;
        this.mMiniAppTitleMoreUiSection.setMoreBtnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PersonalMiniAppViewHolder._init_$lambda$0(PersonalMiniAppViewHolder.this, view);
            }
        });
        this.mPersonalRvAdapter = new PersonalMiniAppInnerRvAdapter(new MiniAppItemCallback(), new PersonalMiniAppInnerRvDelegatesManager()) { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.PersonalMiniAppViewHolder.2
            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
                Map<String, String> mutableMapOf;
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewAttachedToWindow(holder);
                if (!(!PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getGroupAppInfo().isEmpty()) || PersonalMiniAppViewHolder.this.getMExpoReportHelper() == null) {
                    return;
                }
                MiniExpValidExpoReportHelper mExpoReportHelper = PersonalMiniAppViewHolder.this.getMExpoReportHelper();
                Intrinsics.checkNotNull(mExpoReportHelper);
                int positionInfoByViewHolder = mExpoReportHelper.getPositionInfoByViewHolder(PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getGroupAppInfo(), holder);
                MiniExpValidExpoReportHelper mExpoReportHelper2 = PersonalMiniAppViewHolder.this.getMExpoReportHelper();
                Intrinsics.checkNotNull(mExpoReportHelper2);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getVia().get(0)), TuplesKt.to("position", String.valueOf(positionInfoByViewHolder)), TuplesKt.to("module", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_RECENTLY_USE_MODULE), TuplesKt.to("page_id", MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN), TuplesKt.to("host_scene", PersonalMiniAppViewHolder.this.getHostSceneStr(positionInfoByViewHolder)));
                mExpoReportHelper2.sendMiniAppExpoReport(holder, mutableMapOf);
            }

            @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                super.onViewDetachedFromWindow(holder);
                MiniExpValidExpoReportHelper mExpoReportHelper = PersonalMiniAppViewHolder.this.getMExpoReportHelper();
                if (mExpoReportHelper != null) {
                    Object tag = holder.itemView.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo");
                    mExpoReportHelper.cancelMiniAppExpoReport(holder, (DesktopItemInfo) tag);
                }
            }
        };
        this.mPersonalModuleInnerRv.setLayoutManager(new GridLayoutManager(itemView.getContext(), 4));
        this.mPersonalModuleInnerRv.setAdapter(this.mPersonalRvAdapter);
        this.mPersonalModuleInnerRv.setHasFixedSize(false);
        RecyclerView recyclerView = this.mPersonalModuleInnerRv;
        recyclerView.addOnItemTouchListener(new MiniAppExpInnerRvItemTouchForDragListener(recyclerView, new MiniAppExpInnerRvItemLongClickForDragListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.PersonalMiniAppViewHolder.3
            @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener
            public void onItemClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition) {
                String str;
                Map mutableMapOf;
                Intrinsics.checkNotNullParameter(rv5, "rv");
                Intrinsics.checkNotNullParameter(vh5, "vh");
                if (fromPosition >= 0 && fromPosition < PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getGroupAppInfo().size()) {
                    DesktopAppInfo desktopAppInfo = PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getGroupAppInfo().get(fromPosition);
                    Intrinsics.checkNotNullExpressionValue(desktopAppInfo, "mPersonalGroupAppInfo.ge\u2026upAppInfo()[fromPosition]");
                    DesktopAppInfo desktopAppInfo2 = desktopAppInfo;
                    Pair[] pairArr = new Pair[5];
                    pairArr[0] = TuplesKt.to("applet_appid", desktopAppInfo2.mMiniAppInfo.appId);
                    pairArr[1] = TuplesKt.to("applet_type", String.valueOf(desktopAppInfo2.mMiniAppInfo.engineType));
                    if (PersonalMiniAppViewHolder.this.mModuleType == 1) {
                        str = MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_RECENTLY_USE_MODULE;
                    } else {
                        str = MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_PERSONAL_MODULE;
                    }
                    pairArr[2] = TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, str);
                    pairArr[3] = TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APP_SOURCE, String.valueOf(desktopAppInfo2.mMiniAppInfo.isWxMiniApp() ? 2 : 1));
                    pairArr[4] = TuplesKt.to("host_scene", PersonalMiniAppViewHolder.this.getHostSceneStr(fromPosition));
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                    desktopAppInfo2.mMiniAppInfo.via = PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getVia().get(0);
                    desktopAppInfo2.mMiniAppInfo.hostScene = PersonalMiniAppViewHolder.this.getHostSceneStr(fromPosition);
                    MiniAppExpItemClickLaunchUtils miniAppExpItemClickLaunchUtils = MiniAppExpItemClickLaunchUtils.INSTANCE;
                    Context context = rv5.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    int i3 = fromPosition + 1;
                    MiniAppExpItemClickLaunchUtils.startMiniApp$default(miniAppExpItemClickLaunchUtils, (Activity) context, desktopAppInfo2, i3, mutableMapOf, false, 16, null);
                    if (desktopAppInfo2.mMiniAppInfo.isWxMiniApp()) {
                        desktopAppInfo2.mMiniAppInfo.via = "";
                    } else {
                        desktopAppInfo2.mMiniAppInfo.hostScene = "";
                    }
                    MiniAppExpDesktop04239ReportHelper miniAppExpDesktop04239ReportHelper = MiniAppExpDesktop04239ReportHelper.INSTANCE;
                    MiniAppInfo miniAppInfo = desktopAppInfo2.mMiniAppInfo;
                    MiniAppExpDesktop04239ReportHelper.reportWithAppInfo$default(miniAppExpDesktop04239ReportHelper, miniAppInfo, miniAppInfo.via, "pg_click", null, null, null, null, String.valueOf(i3), 120, null);
                    return;
                }
                QLog.i(PersonalMiniAppViewHolder.TAG, 1, "onItemClick fromPosition:" + fromPosition + "is invalid!");
            }

            @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpInnerRvItemLongClickForDragListener
            public void onItemLongClick(RecyclerView rv5, RecyclerView.ViewHolder vh5, int fromPosition, float rawX, float rawY) {
                List items;
                List items2;
                Intrinsics.checkNotNullParameter(rv5, "rv");
                Intrinsics.checkNotNullParameter(vh5, "vh");
                QLog.i(PersonalMiniAppViewHolder.TAG, 1, "onItemLongClick");
                if (PersonalMiniAppViewHolder.this.mPersonalRvAdapter != null) {
                    AsyncListDifferDelegationAdapter asyncListDifferDelegationAdapter = PersonalMiniAppViewHolder.this.mPersonalRvAdapter;
                    DesktopItemInfo desktopItemInfo = null;
                    if ((asyncListDifferDelegationAdapter != null ? asyncListDifferDelegationAdapter.getItems() : null) != null && fromPosition >= 0) {
                        AsyncListDifferDelegationAdapter asyncListDifferDelegationAdapter2 = PersonalMiniAppViewHolder.this.mPersonalRvAdapter;
                        Integer valueOf = (asyncListDifferDelegationAdapter2 == null || (items2 = asyncListDifferDelegationAdapter2.getItems()) == null) ? null : Integer.valueOf(items2.size());
                        Intrinsics.checkNotNull(valueOf);
                        if (fromPosition < valueOf.intValue()) {
                            MiniAppExpDragHelper.Companion companion = MiniAppExpDragHelper.INSTANCE;
                            AsyncListDifferDelegationAdapter asyncListDifferDelegationAdapter3 = PersonalMiniAppViewHolder.this.mPersonalRvAdapter;
                            if (asyncListDifferDelegationAdapter3 != null && (items = asyncListDifferDelegationAdapter3.getItems()) != null) {
                                desktopItemInfo = (DesktopItemInfo) items.get(fromPosition);
                            }
                            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
                            companion.startDrag(rv5, vh5, fromPosition, (DesktopAppInfo) desktopItemInfo, rawX, rawY);
                            return;
                        }
                    }
                }
                QLog.i(PersonalMiniAppViewHolder.TAG, 1, "onItemLongClick fromPosition:" + fromPosition + "is invalid!");
            }
        }));
        itemView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.f
            @Override // java.lang.Runnable
            public final void run() {
                PersonalMiniAppViewHolder._init_$lambda$1(itemView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(View itemView, PersonalMiniAppViewHolder this$0) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new PersonalMiniAppViewHolder$4$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int findIndexFromMineRv(DesktopAppInfo fromDesktopAppInfo, List<DesktopAppInfo> dataList) {
        for (DesktopAppInfo desktopAppInfo : dataList) {
            Boolean areItemsTheSame = desktopAppInfo.areItemsTheSame(fromDesktopAppInfo);
            Intrinsics.checkNotNullExpressionValue(areItemsTheSame, "item.areItemsTheSame(fromDesktopAppInfo)");
            if (areItemsTheSame.booleanValue()) {
                return dataList.indexOf(desktopAppInfo);
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getHostSceneStr(int fromPosition) {
        Object valueOf;
        if (this.mPersonalGroupAppInfo.getHostScene().isEmpty()) {
            QLog.e(TAG, 1, "getHostSceneStr mPersonalGroupAppInfo error,hostScene is empty!");
            return "";
        }
        if (fromPosition < 9) {
            valueOf = "0" + (fromPosition + 1);
        } else {
            valueOf = Integer.valueOf(fromPosition + 1);
        }
        String str = this.mPersonalGroupAppInfo.getHostScene().get(0);
        StringBuilder sb5 = new StringBuilder();
        sb5.append((Object) str);
        sb5.append(valueOf);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniAppExpDesktopViewModel getMMiniAppExpDesktopViewModel() {
        return (MiniAppExpDesktopViewModel) this.mMiniAppExpDesktopViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void miniAppOperateReport(DesktopAppInfo desktopAppInfo, String eventName) {
        String str;
        Map<String, String> mutableMapOf;
        if (desktopAppInfo.mMiniAppInfo.isWxMiniApp()) {
            str = "2";
        } else {
            str = "1";
        }
        MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("applet_appid", desktopAppInfo.mMiniAppInfo.appId), TuplesKt.to("applet_type", String.valueOf(desktopAppInfo.mMiniAppInfo.engineType)), TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_APP_SOURCE, str));
        companion.miniAppDesktopCommonReport("qq_clck", eventName, mutableMapOf, MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN);
    }

    public final void bindView(ExpDesktopGroupAppInfo recentUsedGroupAppInfo, int moduleType) {
        String str;
        Intrinsics.checkNotNullParameter(recentUsedGroupAppInfo, "recentUsedGroupAppInfo");
        this.mPersonalGroupAppInfo = recentUsedGroupAppInfo;
        this.mModuleType = moduleType;
        this.mMiniAppTitleMoreUiSection.bindView(recentUsedGroupAppInfo.getMModuleTitle());
        this.mPersonalModuleInnerRv.setVisibility(0);
        this.mMiniAppTitleMoreUiSection.showMoreLayoutView();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(recentUsedGroupAppInfo.getGroupAppInfo());
        AsyncListDifferDelegationAdapter<DesktopItemInfo> asyncListDifferDelegationAdapter = this.mPersonalRvAdapter;
        Intrinsics.checkNotNull(asyncListDifferDelegationAdapter);
        asyncListDifferDelegationAdapter.setItems(arrayList);
        if (this.mExpoReportHelper == null) {
            if (this.mModuleType == 1) {
                str = EXPO_RECENT_USED_MODULE_TAG;
            } else {
                str = EXPO_MY_MODULE_TAG;
            }
            this.mExpoReportHelper = new MiniExpValidExpoReportHelper(str);
        }
    }

    public final MiniExpValidExpoReportHelper getMExpoReportHelper() {
        return this.mExpoReportHelper;
    }

    public final void setMExpoReportHelper(MiniExpValidExpoReportHelper miniExpValidExpoReportHelper) {
        this.mExpoReportHelper = miniExpValidExpoReportHelper;
    }

    public final void setPartHost(IPartHost partHost) {
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        this.mPortHost = partHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(final PersonalMiniAppViewHolder this$0, View view) {
        String str;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiniAppExpDesktopViewModel mMiniAppExpDesktopViewModel = this$0.getMMiniAppExpDesktopViewModel();
        if (mMiniAppExpDesktopViewModel != null) {
            mMiniAppExpDesktopViewModel.setEffect(new Function0<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.PersonalMiniAppViewHolder$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MiniAppExpDesktopEffect invoke() {
                    ArrayList<DesktopAppInfo> groupAppInfo = PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getGroupAppInfo();
                    int i3 = PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.mModuleType;
                    String mModuleTitle = PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getMModuleTitle();
                    String str2 = PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getVia().get(1);
                    Intrinsics.checkNotNullExpressionValue(str2, "mPersonalGroupAppInfo.ge\u2026r.DESKTOP_SUB_PAGE_INDEX]");
                    String str3 = str2;
                    String str4 = PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getHostScene().get(1);
                    Intrinsics.checkNotNullExpressionValue(str4, "mPersonalGroupAppInfo.ge\u2026r.DESKTOP_SUB_PAGE_INDEX]");
                    return new MiniAppExpDesktopEffect.SetSubLayoutDesktopDataList(groupAppInfo, i3, mModuleTitle, str3, str4, PersonalMiniAppViewHolder.this.mPersonalGroupAppInfo.getMIsFinished());
                }
            });
        }
        MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
        Pair[] pairArr = new Pair[1];
        if (this$0.mModuleType == 1) {
            str = MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_RECENTLY_USE_MODULE;
        } else {
            str = MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_PERSONAL_MODULE;
        }
        pairArr[0] = TuplesKt.to(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(companion, "qq_clck", MiniAppDesktopDtReportHelper.MINI_APP_EM_SEE_MORE, mutableMapOf, null, 8, null);
        MiniAppExpDesktop04239ReportHelper miniAppExpDesktop04239ReportHelper = MiniAppExpDesktop04239ReportHelper.INSTANCE;
        miniAppExpDesktop04239ReportHelper.report((r23 & 1) != 0 ? null : null, (r23 & 2) != 0 ? null : null, "em_click", (r23 & 8) != 0 ? null : miniAppExpDesktop04239ReportHelper.getModuleMoreClickReserveAction(this$0.mModuleType), (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) != 0 ? null : null);
        MiniProgramReporter.getInstance().flush();
    }
}
