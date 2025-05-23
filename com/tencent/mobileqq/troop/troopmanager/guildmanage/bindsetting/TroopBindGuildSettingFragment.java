package com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.TroopBindGuildSettingListAdapter;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.TroopBindGuildSwitchAdapter;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ht2.a;
import ht2.g;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/TroopBindGuildSettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Landroid/view/View;", "view", "", "initUI", "Bh", "initData", "initDtPageReport", "Lht2/g;", OcrConfig.CHINESE, "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "yh", "()Ljava/lang/String;", "troopUin", "D", "Ah", "()Lht2/g;", "vm", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSwitchAdapter;", "G", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSwitchAdapter;", "switchAdapter", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/b;", "H", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/b;", "listHeaderAdapter", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSettingListAdapter;", "I", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/TroopBindGuildSettingListAdapter;", "listAdapter", "Lit2/b;", "J", "Lit2/b;", "loadMoreAdapter", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/a;", "K", "Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/adapter/a;", "emptyViewAdapter", "<init>", "()V", "L", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGuildSettingFragment extends QIphoneTitleBarFragment implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private TroopBindGuildSwitchAdapter switchAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.b listHeaderAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private TroopBindGuildSettingListAdapter listAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private it2.b loadMoreAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.a emptyViewAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/TroopBindGuildSettingFragment$a;", "", "", "troopUin", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.TroopBindGuildSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intent intent = new Intent();
            intent.putExtra("TROOP_UIN", troopUin);
            intent.addFlags(268435456);
            QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicFragmentActivity.class, TroopBindGuildSettingFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/guildmanage/bindsetting/TroopBindGuildSettingFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ViewModelProvider.Factory {
        b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            T newInstance = modelClass.getConstructor(String.class).newInstance(TroopBindGuildSettingFragment.this.yh());
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026va).newInstance(troopUin)");
            return newInstance;
        }
    }

    public TroopBindGuildSettingFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.TroopBindGuildSettingFragment$troopUin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String string;
                Bundle arguments = TroopBindGuildSettingFragment.this.getArguments();
                return (arguments == null || (string = arguments.getString("TROOP_UIN")) == null) ? "0" : string;
            }
        });
        this.troopUin = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<g>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.TroopBindGuildSettingFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                g zh5;
                zh5 = TroopBindGuildSettingFragment.this.zh();
                return zh5;
            }
        });
        this.vm = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g Ah() {
        return (g) this.vm.getValue();
    }

    private final void Bh() {
        MutableLiveData<ht2.a> obtainUiState = Ah().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ht2.a, Unit> function1 = new Function1<ht2.a, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.TroopBindGuildSettingFragment$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ht2.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ht2.a aVar) {
                b bVar;
                TroopBindGuildSettingListAdapter troopBindGuildSettingListAdapter;
                it2.b bVar2;
                com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.a aVar2;
                TroopBindGuildSwitchAdapter troopBindGuildSwitchAdapter;
                com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.a aVar3 = null;
                TroopBindGuildSwitchAdapter troopBindGuildSwitchAdapter2 = null;
                if (aVar instanceof a.BindGuildSwitchInitialized) {
                    troopBindGuildSwitchAdapter = TroopBindGuildSettingFragment.this.switchAdapter;
                    if (troopBindGuildSwitchAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("switchAdapter");
                    } else {
                        troopBindGuildSwitchAdapter2 = troopBindGuildSwitchAdapter;
                    }
                    troopBindGuildSwitchAdapter2.u0(((a.BindGuildSwitchInitialized) aVar).getIsOpen());
                    return;
                }
                if (aVar instanceof a.BindGuildListUpdated) {
                    bVar = TroopBindGuildSettingFragment.this.listHeaderAdapter;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listHeaderAdapter");
                        bVar = null;
                    }
                    a.BindGuildListUpdated bindGuildListUpdated = (a.BindGuildListUpdated) aVar;
                    bVar.i0(!bindGuildListUpdated.a().isEmpty());
                    troopBindGuildSettingListAdapter = TroopBindGuildSettingFragment.this.listAdapter;
                    if (troopBindGuildSettingListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                        troopBindGuildSettingListAdapter = null;
                    }
                    troopBindGuildSettingListAdapter.submitList(bindGuildListUpdated.a());
                    bVar2 = TroopBindGuildSettingFragment.this.loadMoreAdapter;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                        bVar2 = null;
                    }
                    bVar2.setLoadState(false, bindGuildListUpdated.getHasMore());
                    aVar2 = TroopBindGuildSettingFragment.this.emptyViewAdapter;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("emptyViewAdapter");
                    } else {
                        aVar3 = aVar2;
                    }
                    aVar3.j0(bindGuildListUpdated.a().isEmpty() && bindGuildListUpdated.getIsOpen());
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopBindGuildSettingFragment.Ch(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopBindGuildSettingFragment$initData$1(this, null), 3, null);
    }

    private final void initDtPageReport() {
        Map mutableMapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_group_channel_bind_set");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("group_id", yh()), TuplesKt.to("group_uin_type", "1"));
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, new PageParams((Map<String, ?>) mutableMapOf));
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
    }

    private final void initUI(View view) {
        View findViewById = view.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        this.recyclerView = (RecyclerView) findViewById;
        FragmentActivity activity = getActivity();
        g Ah = Ah();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        TroopBindGuildSwitchAdapter troopBindGuildSwitchAdapter = new TroopBindGuildSwitchAdapter(activity, Ah, viewLifecycleOwner);
        troopBindGuildSwitchAdapter.setHasStableIds(true);
        this.switchAdapter = troopBindGuildSwitchAdapter;
        com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.b bVar = new com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.b();
        bVar.setHasStableIds(true);
        this.listHeaderAdapter = bVar;
        FragmentActivity activity2 = getActivity();
        g Ah2 = Ah();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        TroopBindGuildSettingListAdapter troopBindGuildSettingListAdapter = new TroopBindGuildSettingListAdapter(activity2, Ah2, viewLifecycleOwner2);
        troopBindGuildSettingListAdapter.setHasStableIds(true);
        this.listAdapter = troopBindGuildSettingListAdapter;
        com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.a aVar = new com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.a();
        aVar.setHasStableIds(true);
        this.emptyViewAdapter = aVar;
        it2.b bVar2 = new it2.b();
        bVar2.setHasStableIds(true);
        bVar2.registerLoadMoreListener(this);
        bVar2.setLoadState(false, true);
        this.loadMoreAdapter = bVar2;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[5];
        TroopBindGuildSwitchAdapter troopBindGuildSwitchAdapter2 = this.switchAdapter;
        if (troopBindGuildSwitchAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchAdapter");
            troopBindGuildSwitchAdapter2 = null;
        }
        adapterArr[0] = troopBindGuildSwitchAdapter2;
        com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.b bVar3 = this.listHeaderAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listHeaderAdapter");
            bVar3 = null;
        }
        adapterArr[1] = bVar3;
        TroopBindGuildSettingListAdapter troopBindGuildSettingListAdapter2 = this.listAdapter;
        if (troopBindGuildSettingListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            troopBindGuildSettingListAdapter2 = null;
        }
        adapterArr[2] = troopBindGuildSettingListAdapter2;
        com.tencent.mobileqq.troop.troopmanager.guildmanage.bindsetting.adapter.a aVar2 = this.emptyViewAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyViewAdapter");
            aVar2 = null;
        }
        adapterArr[3] = aVar2;
        it2.b bVar4 = this.loadMoreAdapter;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            bVar4 = null;
        }
        adapterArr[4] = bVar4;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter = null;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.setOverScrollMode(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String yh() {
        return (String) this.troopUin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g zh() {
        ViewModel viewModel = new ViewModelProvider(this, new b()).get(g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "private fun getVM(): Tro\u2026lass.java\n        )\n    }");
        return (g) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.fzw;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopBindGuildSettingFragment$onLoadMoreStart$1(this, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle(getString(R.string.f2338178_));
        initUI(view);
        Bh();
        initData();
        initDtPageReport();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
