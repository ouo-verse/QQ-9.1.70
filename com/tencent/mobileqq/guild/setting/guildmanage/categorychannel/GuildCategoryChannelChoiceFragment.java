package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J&\u0010\u0016\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelChoiceFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "data", "", "Lh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Nh", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/l;", "Oh", "Kh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "initData", "initView", "", "T", "J", "guildId", "U", "selectedCategoryId", "Landroidx/recyclerview/widget/RecyclerView;", "V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/a;", "W", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/a;", "adapter", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/e;", "X", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/e;", "viewModel", "<init>", "()V", "Y", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCategoryChannelChoiceFragment extends QQGuildTitleBarFragment {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private long guildId;

    /* renamed from: U, reason: from kotlin metadata */
    private long selectedCategoryId;

    /* renamed from: V, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: W, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: X, reason: from kotlin metadata */
    private e viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelChoiceFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "", "selectedCategoryId", "", "reqCode", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelChoiceFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Activity activity, @NotNull String guildId, long selectedCategoryId, int reqCode) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("extra_selected_channel_category_id", selectedCategoryId);
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) GuildCategoryChannelChoiceFragment.class, reqCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b<T> implements Observer {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ArrayList arrayList = (ArrayList) t16;
            a aVar = GuildCategoryChannelChoiceFragment.this.adapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            aVar.submitList(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            FragmentActivity activity;
            if (((Boolean) t16).booleanValue() && (activity = GuildCategoryChannelChoiceFragment.this.getActivity()) != null) {
                activity.setResult(-1);
            }
        }
    }

    private final void Kh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_user_default_jump_zone");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, String.valueOf(this.guildId), new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(View view, final com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b data) {
        e eVar;
        if (data instanceof GuildCategoryChoiceItemData) {
            GuildCategoryChoiceItemData guildCategoryChoiceItemData = (GuildCategoryChoiceItemData) data;
            Logger.f235387a.d().d("GuildCategoryChannelChoiceFragment", 1, "[itemClick] selected item:" + guildCategoryChoiceItemData.getCategoryChannel().getCategoryAlias());
            e eVar2 = this.viewModel;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                eVar = null;
            } else {
                eVar = eVar2;
            }
            e.U1(eVar, this.guildId, guildCategoryChoiceItemData.getCategoryChannel().getCategoryId(), 0, 4, null);
            return;
        }
        if (data instanceof GuildCategoryChoiceSubItemData) {
            Logger.f235387a.d().d("GuildCategoryChannelChoiceFragment", 1, "[itemClick] selected item:" + ((GuildCategoryChoiceSubItemData) data).getSelectSubCategoryName());
            Dialog createDialog = ActionSheetHelper.createDialog(view.getContext(), null);
            Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
            final ActionSheet actionSheet = (ActionSheet) createDialog;
            actionSheet.addButton(view.getContext().getString(R.string.f145420rf));
            actionSheet.addButton(view.getContext().getString(R.string.f140920f_));
            actionSheet.addButton(view.getContext().getString(R.string.f140930fa));
            actionSheet.setMainTitle(view.getContext().getString(R.string.f140910f9));
            actionSheet.addCancelButton(actionSheet.getContext().getString(R.string.f140850f3));
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.c
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i3) {
                    GuildCategoryChannelChoiceFragment.Mh(b.this, this, actionSheet, view2, i3);
                }
            });
            actionSheet.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b data, GuildCategoryChannelChoiceFragment this$0, ActionSheet this_apply, View view, int i3) {
        e eVar;
        e eVar2;
        e eVar3;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2 && ((GuildCategoryChoiceSubItemData) data).getSelectedSubCategoryType() != 3) {
                    e eVar4 = this$0.viewModel;
                    if (eVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        eVar3 = null;
                    } else {
                        eVar3 = eVar4;
                    }
                    eVar3.T1(this$0.guildId, data.getId(), 3);
                }
            } else if (((GuildCategoryChoiceSubItemData) data).getSelectedSubCategoryType() != 1) {
                e eVar5 = this$0.viewModel;
                if (eVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    eVar2 = null;
                } else {
                    eVar2 = eVar5;
                }
                eVar2.T1(this$0.guildId, data.getId(), 1);
            }
        } else if (((GuildCategoryChoiceSubItemData) data).getSelectedSubCategoryType() != 2) {
            e eVar6 = this$0.viewModel;
            if (eVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                eVar = null;
            } else {
                eVar = eVar6;
            }
            eVar.T1(this$0.guildId, data.getId(), 2);
        }
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        rh();
        setTitle(getResources().getString(R.string.f1502214e));
        initData();
        initView();
        Kh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ehf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initData() {
        long j3;
        Intent intent;
        Intent intent2;
        Long longOrNull;
        FragmentActivity activity = getActivity();
        long j16 = 0;
        if (activity != null && (intent2 = activity.getIntent()) != null && (r0 = intent2.getStringExtra("extra_guild_id")) != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.guildId = j3;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            j16 = intent.getLongExtra("extra_selected_channel_category_id", 0L);
        }
        this.selectedCategoryId = j16;
        Logger.f235387a.d().d("GuildCategoryChannelChoiceFragment", 1, "[initData] guild:" + this.guildId + ", selectedCategoryId:" + this.selectedCategoryId);
        e.Companion companion = e.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = companion.a(requireActivity, this.guildId);
    }

    public final void initView() {
        this.adapter = new a(new g(new GuildCategoryChannelChoiceFragment$initView$1(this), new GuildCategoryChannelChoiceFragment$initView$2(this), new GuildCategoryChannelChoiceFragment$initView$3(this), null, 8, null));
        View findViewById = this.P.findViewById(R.id.zd9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.module_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        e eVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        recyclerView2.setAdapter(aVar);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(defaultItemAnimator);
        int f16 = QQGuildUIUtil.f(16.0f);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ad adVar = new ad(requireContext, ContextCompat.getColor(requireContext(), R.color.qui_common_border_standard), 1, f16, f16, new Function3<Integer, RecyclerView, RecyclerView.State, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.GuildCategoryChannelChoiceFragment$initView$recycleViewDivider$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, RecyclerView recyclerView4, RecyclerView.State state) {
                return invoke(num.intValue(), recyclerView4, state);
            }

            @NotNull
            public final Boolean invoke(int i3, @NotNull RecyclerView rv5, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(rv5, "rv");
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 2>");
                return Boolean.valueOf(i3 != rv5.getChildCount() - 1);
            }
        });
        adVar.a(ContextCompat.getColor(requireContext(), R.color.qui_common_fill_light_secondary));
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addItemDecoration(adVar);
        e eVar2 = this.viewModel;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            eVar2 = null;
        }
        LiveData<ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b>> Q1 = eVar2.Q1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        Q1.observe(viewLifecycleOwner, new b());
        e eVar3 = this.viewModel;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            eVar3 = null;
        }
        LiveData<Boolean> R1 = eVar3.R1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        R1.observe(viewLifecycleOwner2, new c());
        e eVar4 = this.viewModel;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            eVar = eVar4;
        }
        eVar.P1(this.guildId, this.selectedCategoryId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(RecyclerView.ViewHolder it) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(GuildCategoryChannelItemData data) {
    }
}
