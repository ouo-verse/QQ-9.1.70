package com.tencent.mobileqq.guild.profile.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment;
import com.tencent.mobileqq.guild.profile.me.profilesetting.GuildProfilePrivacySettingFragment;
import com.tencent.mobileqq.guild.profile.myguild.GuildMyGuildFragment;
import com.tencent.mobileqq.guild.profile.profilearchives.fragment.GuildProfileArchivesListFragment;
import com.tencent.mobileqq.guild.recently.GuildRecentlyViewedFragment;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J0\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J@\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\fH\u0014J&\u0010$\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010%\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u00020'H\u0016R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildMeFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "initViewModel", "initView", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", DownloadInfo.spKey_Config, "Landroid/view/View$OnClickListener;", "clickListener", "Mh", "", "type", "Vh", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Ph", "Oh", "Rh", "Sh", "Wh", "", "leftText", "rightText", "elementId", "Lkotlin/Function1;", "Landroid/view/View;", "clickBlock", "Xh", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "onResume", "rh", "", "onBackEvent", "Lcom/tencent/mobileqq/guild/profile/me/i;", "T", "Lcom/tencent/mobileqq/guild/profile/me/i;", "viewModel", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "U", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "quiSettingsRecyclerView", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "guildHelpAndFeedbackView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "W", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "quiListItemAdapter", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$b;", "X", "Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$b;", "signAndWalletConfig", "<init>", "()V", "Y", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMeFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private i viewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private QUISettingsRecyclerView quiSettingsRecyclerView;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView guildHelpAndFeedbackView;

    /* renamed from: W, reason: from kotlin metadata */
    private QUIListItemAdapter quiListItemAdapter;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final GuildSignAndWalletConfig.b signAndWalletConfig = GuildSignAndWalletConfig.INSTANCE.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/GuildMeFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "", "HEAD_WIDGET_LIST_URL", "Ljava/lang/String;", "MEDAL_LIST_URL", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent r16 = qw1.b.r(new Intent(), Reporters.f231995a.b().newReportTask().setEventCode("guild_profile_info").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            qw1.b.s(r16, com.tencent.mobileqq.guild.util.report.b.a("guild_drawer_page"), "_extra_param_report_task_view_pager_tab");
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, r16, GuildMeFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/profile/me/GuildMeFragment$b", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends com.tencent.mobileqq.widget.listitem.u {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        protected View H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = new View(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(8.0f)));
            return view;
        }
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Mh(com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> config, final View.OnClickListener clickListener) {
        config.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMeFragment.Nh(GuildMeFragment.this, clickListener, view);
            }
        });
        return config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GuildMeFragment this$0, View.OnClickListener clickListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickListener, "$clickListener");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            clickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Group Oh() {
        return new Group(Xh("\u6211\u53d1\u8868\u7684\u5e16\u5b50", "", "em_sgrp_mine_forum_publish", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createFeedsGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                GuildMeFragment.this.Vh(1);
            }
        }), Xh("\u6211\u8d5e\u8fc7\u7684\u5e16\u5b50", "", "em_sgrp_mine_forum_like", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createFeedsGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                GuildMeFragment.this.Vh(2);
            }
        }), Xh("\u6700\u8fd1\u6d4f\u89c8", "", "em_sgrp_recent_view", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createFeedsGroup$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                GuildRecentlyViewedFragment.INSTANCE.a(GuildMeFragment.this.getContext(), new Bundle());
            }
        }));
    }

    private final Group Ph() {
        Group.Companion companion = Group.INSTANCE;
        b bVar = new b();
        com.tencent.mobileqq.widget.listitem.a<?>[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[2];
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Xh = Xh("\u6211\u7684\u9891\u9053", "", "em_sgrp_user_join_channel", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createGuildGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                GuildMyGuildFragment.Companion companion2 = GuildMyGuildFragment.INSTANCE;
                Context requireContext = GuildMeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                companion2.a(requireContext);
            }
        });
        i iVar = this.viewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            iVar = null;
        }
        LiveData<Integer> W1 = iVar.W1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createGuildGroup$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                QUIListItemAdapter qUIListItemAdapter;
                if (num != null) {
                    Xh.O().h(num + "\u4e2a");
                    qUIListItemAdapter = this.quiListItemAdapter;
                    if (qUIListItemAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
                        qUIListItemAdapter = null;
                    }
                    qUIListItemAdapter.l0(Xh);
                }
            }
        };
        W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMeFragment.Qh(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = Xh;
        aVarArr[1] = Xh("\u521b\u5efa\u9891\u9053", "", "em_sgrp_create_new_channel", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createGuildGroup$4
            /* JADX INFO: Access modifiers changed from: package-private */
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
                GuildCreateFragment.Companion companion2 = GuildCreateFragment.INSTANCE;
                Context requireContext = GuildMeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                companion2.a(requireContext);
            }
        });
        return companion.e(bVar, aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Group Rh() {
        return new Group(Xh("\u5934\u50cf\u6302\u4ef6", "", "em_sgrp_change_head_frame", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createPersonalInfoGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                cx.a(GuildMeFragment.this.getContext(), "https://qun.qq.com/guild/h5/guild-head-frame");
            }
        }), Xh("\u52cb\u7ae0\u5899", "", "em_sgrp_personal_medal", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createPersonalInfoGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                cx.a(GuildMeFragment.this.getActivity(), "https://qun.qq.com/guild/h5/guild-medal");
            }
        }), Xh("\u4e2a\u6027\u6863\u6848", "", "em_sgrp_mine_allfile", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createPersonalInfoGroup$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_owner", true);
                GuildProfileArchivesListFragment.Jh(GuildMeFragment.this.getActivity(), bundle, ch.f(), "0");
            }
        }), Xh("\u9690\u79c1\u8bbe\u7f6e", "", "em_sgrp_privacy_set", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createPersonalInfoGroup$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildProfilePrivacySettingFragment.Companion companion = GuildProfilePrivacySettingFragment.INSTANCE;
                Context context = it.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                companion.a(context);
            }
        }));
    }

    private final Group Sh() {
        ArrayList arrayList = new ArrayList();
        if (this.signAndWalletConfig.getGuildWalletEntranceConfig().getIsShow()) {
            arrayList.add(Xh("\u9891\u9053\u94b1\u5305", "", "em_sgrp_wallet_entrance", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createWalletGroup$guildWalletConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    GuildSignAndWalletConfig.b bVar;
                    Intrinsics.checkNotNullParameter(it, "it");
                    bVar = GuildMeFragment.this.signAndWalletConfig;
                    String jumpUrl = bVar.getGuildWalletEntranceConfig().getJumpUrl();
                    if (jumpUrl != null) {
                        ch.i1(GuildMeFragment.this.getActivity(), jumpUrl);
                    }
                }
            }));
        }
        if (this.signAndWalletConfig.getSingingCenterConfig().getIsShow()) {
            final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Xh = Xh("\u7b7e\u7ea6\u4e2d\u5fc3", "", "em_sgrp_sign_center_entrance", new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createWalletGroup$guildSignConfig$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    GuildSignAndWalletConfig.b bVar;
                    Intrinsics.checkNotNullParameter(it, "it");
                    bVar = GuildMeFragment.this.signAndWalletConfig;
                    String jumpUrl = bVar.getSingingCenterConfig().getJumpUrl();
                    if (jumpUrl != null) {
                        ch.i1(GuildMeFragment.this.getActivity(), jumpUrl);
                    }
                }
            });
            i iVar = this.viewModel;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                iVar = null;
            }
            LiveData<Boolean> Z1 = iVar.Z1();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.profile.me.GuildMeFragment$createWalletGroup$guildSignConfig$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean isSign) {
                    QUIListItemAdapter qUIListItemAdapter;
                    x.c.g O = Xh.O();
                    Intrinsics.checkNotNullExpressionValue(isSign, "isSign");
                    O.h(isSign.booleanValue() ? "\u5df2\u7b7e\u7ea6" : "");
                    qUIListItemAdapter = this.quiListItemAdapter;
                    if (qUIListItemAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
                        qUIListItemAdapter = null;
                    }
                    qUIListItemAdapter.l0(Xh);
                }
            };
            Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildMeFragment.Th(Function1.this, obj);
                }
            });
            arrayList.add(Xh);
        }
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(GuildMeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            ch.i1(this$0.getActivity(), ch.P());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(int type) {
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam();
        joinInfoParam.setMainSource("mine");
        joinInfoParam.setSubSource("mine_like");
        Bundle bundle = new Bundle();
        bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
        bundle.putInt("feed_my_feeds_type", type);
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iGuildFeedLauncherApi.launchGuildFeedPostsLoadFragment(requireContext, bundle);
    }

    private final void Wh() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_mine");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        com.tencent.mobileqq.guild.data.w.b(hashMap);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(this.P, new PageParams(hashMap));
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Xh(String leftText, String rightText, final String elementId, final Function1<? super View, Unit> clickBlock) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(leftText), new x.c.g(rightText, false, false, 6, null));
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.profile.me.b
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildMeFragment.Yh(elementId, view);
            }
        });
        Mh(xVar, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMeFragment.Zh(Function1.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(String elementId, View it) {
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(it, "it");
        bt.d(it, elementId, null, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(Function1 clickBlock, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(clickBlock, "$clickBlock");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        clickBlock.invoke(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void initView() {
        IPerformanceReportTask f16;
        IPerformanceReportTask g16;
        setTitle("\u66f4\u591a");
        rh();
        View findViewById = this.P.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recycler_view)");
        this.quiSettingsRecyclerView = (QUISettingsRecyclerView) findViewById;
        View findViewById2 = this.P.findViewById(R.id.whz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026.guild_help_and_feedback)");
        this.guildHelpAndFeedbackView = (TextView) findViewById2;
        this.quiListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, false, 6, null);
        QUISettingsRecyclerView qUISettingsRecyclerView = this.quiSettingsRecyclerView;
        TextView textView = null;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSettingsRecyclerView");
            qUISettingsRecyclerView = null;
        }
        QUIListItemAdapter qUIListItemAdapter = this.quiListItemAdapter;
        if (qUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter = null;
        }
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        QUIListItemAdapter qUIListItemAdapter2 = this.quiListItemAdapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiListItemAdapter");
            qUIListItemAdapter2 = null;
        }
        qUIListItemAdapter2.t0(Ph(), Oh(), Rh(), Sh());
        Bundle arguments = getArguments();
        if (arguments != null && (g16 = qw1.b.g(arguments, null, 1, null)) != null) {
            QUISettingsRecyclerView qUISettingsRecyclerView2 = this.quiSettingsRecyclerView;
            if (qUISettingsRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quiSettingsRecyclerView");
                qUISettingsRecyclerView2 = null;
            }
            qw1.b.k(g16, qUISettingsRecyclerView2, null, 2, null);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (f16 = qw1.b.f(arguments2, "_extra_param_report_task_view_pager_tab")) != null) {
            QUISettingsRecyclerView qUISettingsRecyclerView3 = this.quiSettingsRecyclerView;
            if (qUISettingsRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quiSettingsRecyclerView");
                qUISettingsRecyclerView3 = null;
            }
            qw1.b.q(f16, qUISettingsRecyclerView3, null, 2, null);
        }
        TextView textView2 = this.guildHelpAndFeedbackView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHelpAndFeedbackView");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMeFragment.Uh(GuildMeFragment.this, view);
            }
        });
    }

    private final void initViewModel() {
        this.viewModel = i.INSTANCE.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initViewModel();
        initView();
        Wh();
        TextView textView = this.guildHelpAndFeedbackView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHelpAndFeedbackView");
            textView = null;
        }
        bt.d(textView, "em_sgrp_mine_feedback", null, null, null, null, 60, null);
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.es6;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        i iVar = this.viewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            iVar = null;
        }
        iVar.onResume();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }
}
