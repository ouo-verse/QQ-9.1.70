package com.tencent.mobileqq.guild.profile.profilecard.joined.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment;
import com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "Mh", "Lh", "Qh", "Landroid/view/View;", "view", "Uh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "getContentLayoutId", "qh", "ph", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel;", "T", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedViewModel;", "viewModel", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "U", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "V", "Landroidx/recyclerview/widget/RecyclerView;", "guildList", "Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedAdapter;", "W", "Lkotlin/Lazy;", "Th", "()Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedAdapter;", "adapter", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "X", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "profileData", "<init>", "()V", "Y", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileJoinedFragment extends QQGuildTitleBarFragment {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String Z = "https://qun.qq.com/guild/h5/guild-create/index.html?_wv=54183&_wwv=128&cateid=50000&from=plus#/";

    /* renamed from: T, reason: from kotlin metadata */
    private GuildProfileJoinedViewModel viewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: V, reason: from kotlin metadata */
    private RecyclerView guildList;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private GuildProfileData profileData;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/GuildProfileJoinedFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "profileData", "", "a", "", "CREATE_GUILD_URL", "Ljava/lang/String;", "EXTRA_PROFILE_DATA", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull GuildProfileData profileData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(profileData, "profileData");
            Intent intent = new Intent();
            intent.putExtra("EXTRA_PROFILE_DATA", profileData);
            Logger.f235387a.d().d("Guild.profile.GuildProfileJoinedFragment", 1, "open userProfileInfo " + profileData.getUserProfileInfo());
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildProfileJoinedFragment.class);
        }

        Companion() {
        }
    }

    public GuildProfileJoinedFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildProfileJoinedAdapter>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedFragment$adapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildProfileJoinedAdapter invoke() {
                return new GuildProfileJoinedAdapter();
            }
        });
        this.adapter = lazy;
    }

    private final void Lh() {
        String str;
        GuildBaseProfileData guildBaseProfileData;
        GuildBaseProfileData guildBaseProfileData2;
        GuildProfileData guildProfileData = this.profileData;
        String str2 = null;
        if (guildProfileData != null && (guildBaseProfileData2 = guildProfileData.getGuildBaseProfileData()) != null) {
            str = guildBaseProfileData2.b();
        } else {
            str = null;
        }
        if (str == null) {
            str = "0";
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        String selfTinyId = ((IGPSService) S0).getSelfTinyId();
        GuildProfileData guildProfileData2 = this.profileData;
        if (guildProfileData2 != null && (guildBaseProfileData = guildProfileData2.getGuildBaseProfileData()) != null) {
            str2 = guildBaseProfileData.b();
        }
        int i3 = !Intrinsics.areEqual(selfTinyId, str2) ? 1 : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_profile_userid", str);
        hashMap.put("sgrp_user_master", Integer.valueOf(i3));
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_show_join_channel");
        VideoReport.setPageParams(this.N, new PageParams(hashMap));
    }

    private final void Mh() {
        String str;
        String str2;
        GuildBaseProfileData guildBaseProfileData;
        GuildBaseProfileData guildBaseProfileData2;
        setTitle(QQGuildUIUtil.r(R.string.f1521019h));
        Logger.a d16 = Logger.f235387a.d();
        GuildProfileData guildProfileData = this.profileData;
        RecyclerView recyclerView = null;
        if (guildProfileData != null && (guildBaseProfileData2 = guildProfileData.getGuildBaseProfileData()) != null) {
            str = guildBaseProfileData2.b();
        } else {
            str = null;
        }
        GuildProfileData guildProfileData2 = this.profileData;
        if (guildProfileData2 != null && (guildBaseProfileData = guildProfileData2.getGuildBaseProfileData()) != null) {
            str2 = guildBaseProfileData.j();
        } else {
            str2 = null;
        }
        d16.d("Guild.profile.GuildProfileJoinedFragment", 1, "bindView dstTinyId:" + str + " selfTinyId:" + str2);
        GuildProfileData guildProfileData3 = this.profileData;
        if (guildProfileData3 != null) {
            Intrinsics.checkNotNull(guildProfileData3);
            String b16 = guildProfileData3.getGuildBaseProfileData().b();
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            if (Intrinsics.areEqual(b16, ((IGPSService) S0).getSelfTinyId())) {
                wh(R.drawable.guild_title_top_right_add_icon, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildProfileJoinedFragment.Nh(GuildProfileJoinedFragment.this, view);
                    }
                });
            }
        }
        View findViewById = this.P.findViewById(R.id.f72333qk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.refresh_layout)");
        this.refreshLayout = (SmartRefreshLayout) findViewById;
        View findViewById2 = this.P.findViewById(R.id.wlx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.guild_list)");
        this.guildList = (RecyclerView) findViewById2;
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(true).setEnableOverScrollBounce(true).setEnableOverScrollDrag(true);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.l
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                GuildProfileJoinedFragment.Oh(GuildProfileJoinedFragment.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.m
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener
            public final void onLoadMore(IRefreshLayout iRefreshLayout) {
                GuildProfileJoinedFragment.Ph(GuildProfileJoinedFragment.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.setEnableFooterFollowWhenNoMoreData(true);
        dh1.b bVar = new dh1.b();
        bVar.a(bi.d());
        int mostCardCnt = bVar.getMostCardCnt();
        Th().q0(mostCardCnt);
        GuildProfileJoinedViewModel guildProfileJoinedViewModel = this.viewModel;
        if (guildProfileJoinedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileJoinedViewModel = null;
        }
        guildProfileJoinedViewModel.setCardCnt(mostCardCnt, bVar.b(bi.c()));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), mostCardCnt, 1, false);
        RecyclerView recyclerView2 = this.guildList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildList");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView3 = this.guildList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildList");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.setAdapter(Th());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GuildProfileJoinedFragment this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.Uh(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GuildProfileJoinedFragment this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        GuildProfileJoinedViewModel guildProfileJoinedViewModel = this$0.viewModel;
        if (guildProfileJoinedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileJoinedViewModel = null;
        }
        guildProfileJoinedViewModel.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(GuildProfileJoinedFragment this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        GuildProfileJoinedViewModel guildProfileJoinedViewModel = this$0.viewModel;
        if (guildProfileJoinedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileJoinedViewModel = null;
        }
        guildProfileJoinedViewModel.loadMore();
    }

    private final void Qh() {
        GuildProfileJoinedViewModel guildProfileJoinedViewModel = this.viewModel;
        GuildProfileJoinedViewModel guildProfileJoinedViewModel2 = null;
        if (guildProfileJoinedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileJoinedViewModel = null;
        }
        e12.a<GuildProfileJoinedViewModel.GuildJoinedCardInfo> dataList = guildProfileJoinedViewModel.getDataList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<GuildProfileJoinedViewModel.GuildJoinedCardInfo, Unit> function1 = new Function1<GuildProfileJoinedViewModel.GuildJoinedCardInfo, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedFragment$bindViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildProfileJoinedViewModel.GuildJoinedCardInfo guildJoinedCardInfo) {
                invoke2(guildJoinedCardInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildProfileJoinedViewModel.GuildJoinedCardInfo guildJoinedCardInfo) {
                SmartRefreshLayout smartRefreshLayout;
                GuildProfileJoinedAdapter Th;
                smartRefreshLayout = GuildProfileJoinedFragment.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                smartRefreshLayout.finishRefresh();
                Th = GuildProfileJoinedFragment.this.Th();
                Th.setData(guildJoinedCardInfo.a());
                GuildProfileJoinedFragment.this.setTitle(QQGuildUIUtil.r(R.string.f1521019h) + "\uff08" + guildJoinedCardInfo.getNumStr() + "\uff09");
            }
        };
        dataList.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileJoinedFragment.Rh(Function1.this, obj);
            }
        });
        GuildProfileJoinedViewModel guildProfileJoinedViewModel3 = this.viewModel;
        if (guildProfileJoinedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileJoinedViewModel3 = null;
        }
        e12.a<GuildProfileJoinedViewModel.GuildJoinedCardInfo> moreData = guildProfileJoinedViewModel3.getMoreData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<GuildProfileJoinedViewModel.GuildJoinedCardInfo, Unit> function12 = new Function1<GuildProfileJoinedViewModel.GuildJoinedCardInfo, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedFragment$bindViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildProfileJoinedViewModel.GuildJoinedCardInfo guildJoinedCardInfo) {
                invoke2(guildJoinedCardInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildProfileJoinedViewModel.GuildJoinedCardInfo guildJoinedCardInfo) {
                SmartRefreshLayout smartRefreshLayout;
                SmartRefreshLayout smartRefreshLayout2;
                GuildProfileJoinedAdapter Th;
                smartRefreshLayout = GuildProfileJoinedFragment.this.refreshLayout;
                SmartRefreshLayout smartRefreshLayout3 = null;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                smartRefreshLayout.finishLoadMore();
                smartRefreshLayout2 = GuildProfileJoinedFragment.this.refreshLayout;
                if (smartRefreshLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                } else {
                    smartRefreshLayout3 = smartRefreshLayout2;
                }
                smartRefreshLayout3.setNoMoreData(guildJoinedCardInfo.getIsEnd());
                Th = GuildProfileJoinedFragment.this.Th();
                Th.m0(guildJoinedCardInfo.a());
            }
        };
        moreData.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileJoinedFragment.Sh(Function1.this, obj);
            }
        });
        GuildProfileJoinedViewModel guildProfileJoinedViewModel4 = this.viewModel;
        if (guildProfileJoinedViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildProfileJoinedViewModel2 = guildProfileJoinedViewModel4;
        }
        guildProfileJoinedViewModel2.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildProfileJoinedAdapter Th() {
        return (GuildProfileJoinedAdapter) this.adapter.getValue();
    }

    private final void Uh(View view) {
        Activity activity;
        if (FastClickUtils.isFastDoubleClick("Guild.profile.GuildProfileJoinedFragment")) {
            Logger.f235387a.d().w("Guild.profile.GuildProfileJoinedFragment", 1, "handleClickCreateGuild isFastDoubleClick");
            return;
        }
        VideoReport.setElementId(view, "em_sgrp_head_create");
        ch.x(view);
        VideoReport.reportEvent("clck", view, new HashMap());
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f1510816q);
            return;
        }
        GuildCreateFragment.Companion companion = GuildCreateFragment.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.a(requireContext);
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154630p2, R.anim.f154442w);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GuildProfileData guildProfileData;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            guildProfileData = (GuildProfileData) arguments.getParcelable("EXTRA_PROFILE_DATA");
        } else {
            guildProfileData = null;
        }
        this.profileData = guildProfileData;
        this.viewModel = (GuildProfileJoinedViewModel) ef1.c.INSTANCE.c(this, GuildProfileJoinedViewModel.class, new Function0<GuildProfileJoinedViewModel>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.GuildProfileJoinedFragment$doOnCreateView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildProfileJoinedViewModel invoke() {
                return new GuildProfileJoinedViewModel(GuildProfileJoinedFragment.this.profileData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f2n;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int f16 = QQGuildUIUtil.f(newConfig.screenWidthDp * 1.0f);
        dh1.b bVar = new dh1.b();
        int a16 = bVar.a(f16);
        int mostCardCnt = bVar.getMostCardCnt();
        Th().q0(mostCardCnt);
        GuildProfileJoinedViewModel guildProfileJoinedViewModel = this.viewModel;
        RecyclerView recyclerView = null;
        if (guildProfileJoinedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileJoinedViewModel = null;
        }
        guildProfileJoinedViewModel.setCardCnt(mostCardCnt, bVar.b(bi.c()));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), mostCardCnt, 1, false);
        RecyclerView recyclerView2 = this.guildList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildList");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        Logger.f235387a.d().i("Guild.profile.GuildProfileJoinedFragment", 1, "onConfigurationChanged cardCnt=" + a16 + " screenWidth=" + f16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Mh();
        Qh();
        Lh();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.guild_color_f5f6fa_171718;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.guild_drawable_f5f6fa_171718;
    }
}
