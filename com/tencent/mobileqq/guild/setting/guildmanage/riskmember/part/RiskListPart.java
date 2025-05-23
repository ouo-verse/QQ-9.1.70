package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildRemoveGuildDialogFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildRiskListAdapter;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GroupSelectType;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.State;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.k;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pz1.RiskShowData;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0004\u0018\u0000 12\u00020\u0001:\u00012B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskListPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "com/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskListPart$b", "G9", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskListPart$b;", "", "tinyId", "", "nickName", "M9", "K9", "", "isBlack", "J9", "I9", "Landroid/view/View;", "mRootView", "onInitView", "", "d", "I", "listId", "Lpz1/c;", "e", "Lpz1/c;", "H9", "()Lpz1/c;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", tl.h.F, "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "listView", "i", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskListPart$b;", "memberListEventCallback", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskListAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskListAdapter;", "block", "<init>", "(ILpz1/c;Landroidx/lifecycle/LifecycleOwner;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RiskListPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int listId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pz1.c viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter listView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b memberListEventCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRiskListAdapter block;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskListPart$b", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/e;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;", "groupSelectType", "", "b", "", "tinyId", "", "isChecked", "c", "", "nickName", "d", "guildId", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.setting.guildmanage.riskmember.e {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.e
        public void a(@NotNull String guildId, long tinyId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GuildProfileCard.Mh(RiskListPart.this.getActivity(), new GuildProfileData(guildId, "", String.valueOf(tinyId), 0, 1), null);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.e
        public void b(@NotNull GroupSelectType groupSelectType) {
            Intrinsics.checkNotNullParameter(groupSelectType, "groupSelectType");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("RiskItemBlockPart", "onGroupLick " + groupSelectType);
            }
            RiskListPart.this.getViewModel().n2(groupSelectType);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.e
        public void c(long tinyId, boolean isChecked) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("RiskItemBlockPart", "onMemberCheckBoxClick " + tinyId + ", " + isChecked);
            }
            RiskListPart.this.getViewModel().p2(tinyId, isChecked);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.e
        public void d(long tinyId, @NotNull String nickName) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("RiskItemBlockPart", "onMemberSettingClick " + tinyId + ", " + nickName);
            }
            RiskListPart.this.M9(tinyId, nickName);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskListPart$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            LinearLayoutManager linearLayoutManager;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (!RiskListPart.this.getViewModel().c2()) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null && linearLayoutManager.findLastVisibleItemPosition() >= linearLayoutManager.getItemCount() - 1) {
                RiskListPart.this.getViewModel().loadMore();
            }
        }
    }

    public RiskListPart(int i3, @NotNull pz1.c viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.listId = i3;
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
        b G9 = G9();
        this.memberListEventCallback = G9;
        this.block = new GuildRiskListAdapter(G9);
    }

    private final void E9() {
        MutableLiveData<RiskShowData> Z1 = this.viewModel.Z1();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<RiskShowData, Unit> function1 = new Function1<RiskShowData, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskListPart$bindData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RiskShowData riskShowData) {
                invoke2(riskShowData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RiskShowData riskShowData) {
                GuildRiskListAdapter guildRiskListAdapter;
                if (riskShowData != null) {
                    RiskListPart riskListPart = RiskListPart.this;
                    ArrayList arrayList = new ArrayList(riskShowData.a());
                    if (riskShowData.getState() == State.LOAD_MORE) {
                        arrayList.add(new com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.c());
                    }
                    guildRiskListAdapter = riskListPart.block;
                    guildRiskListAdapter.setItems(riskShowData.a());
                }
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RiskListPart.F9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final b G9() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(final long tinyId, String nickName) {
        k kVar = k.f234201a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VideoReport.setLogicParent(kVar.d(activity, nickName, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskListPart$showConfirmRemoveFromRisk$actionSheet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                ArrayList arrayListOf;
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.b(com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.f234195a, it, "clck", "em_sgrp_confirm_remove", null, 8, null);
                pz1.c viewModel = RiskListPart.this.getViewModel();
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(tinyId));
                viewModel.f2(false, 0, false, false, arrayListOf);
            }
        }).getRootView(), getPartRootView());
    }

    private final void J9(long tinyId, boolean isBlack) {
        if (!(getActivity() instanceof FragmentActivity)) {
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        GuildRemoveGuildDialogFragment.wh((FragmentActivity) activity, this.viewModel.getGuildId(), 1, isBlack, new d(tinyId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(final long tinyId) {
        Dialog createDialog = ActionSheetHelper.createDialog(getContext(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f152951as, 3);
        actionSheet.addButton(R.string.f1520219_, 3);
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.d
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                RiskListPart.L9(RiskListPart.this, tinyId, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(RiskListPart this$0, long j3, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.J9(j3, true);
                actionSheet.dismiss();
                return;
            }
            return;
        }
        this$0.J9(j3, false);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(final long tinyId, final String nickName) {
        Map<String, ? extends Object> mapOf;
        k kVar = k.f234201a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        ActionSheet f16 = kVar.f(activity, nickName, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskListPart$showSettingActionSheet$actionSheet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RiskListPart.this.I9(tinyId, nickName);
                com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.b(com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.f234195a, it, "clck", "em_sgrp_remove_danger_user_list", null, 8, null);
            }
        }, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskListPart$showSettingActionSheet$actionSheet$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RiskListPart.this.K9(tinyId);
                com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.b(com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.f234195a, it, "clck", "em_sgrp_single_remove_channel", null, 8, null);
            }
        });
        VideoReport.setLogicParent(f16.getRootView(), getPartRootView());
        com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g gVar = com.tencent.mobileqq.guild.setting.guildmanage.riskmember.g.f234195a;
        ViewGroup rootView = f16.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "actionSheet.rootView");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_to_user_id", String.valueOf(tinyId)));
        gVar.a(rootView, "imp", "em_sgrp_single_remove_danger_user_float", mapOf);
    }

    @NotNull
    /* renamed from: H9, reason: from getter */
    public final pz1.c getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View mRootView) {
        super.onInitView(mRootView);
        View findViewById = getPartRootView().findViewById(this.listId);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(listId)");
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) findViewById;
        this.listView = overScrollRecyclerViewWithHeaderFooter;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setLayoutManager(new LinearLayoutManager(getActivity()));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.listView;
        if (overScrollRecyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            overScrollRecyclerViewWithHeaderFooter3 = null;
        }
        overScrollRecyclerViewWithHeaderFooter3.setAdapter(this.block);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = this.listView;
        if (overScrollRecyclerViewWithHeaderFooter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            overScrollRecyclerViewWithHeaderFooter4 = null;
        }
        overScrollRecyclerViewWithHeaderFooter4.H();
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5 = this.listView;
        if (overScrollRecyclerViewWithHeaderFooter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            overScrollRecyclerViewWithHeaderFooter5 = null;
        }
        overScrollRecyclerViewWithHeaderFooter5.setHasFixedSize(true);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter6 = this.listView;
        if (overScrollRecyclerViewWithHeaderFooter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            overScrollRecyclerViewWithHeaderFooter2 = overScrollRecyclerViewWithHeaderFooter6;
        }
        overScrollRecyclerViewWithHeaderFooter2.addOnScrollListener(new c());
        E9();
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/riskmember/part/RiskListPart$d", "Llv1/b;", "", "isBlack", "", "msgRevokeType", "", "a", "onDismiss", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements lv1.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f234218b;

        d(long j3) {
            this.f234218b = j3;
        }

        @Override // lv1.b
        public void a(boolean isBlack, int msgRevokeType) {
            List<Long> listOf;
            pz1.c viewModel = RiskListPart.this.getViewModel();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(this.f234218b));
            viewModel.f2(isBlack, msgRevokeType, true, false, listOf);
        }

        @Override // lv1.b
        public void onDismiss() {
        }
    }
}
