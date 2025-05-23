package com.tencent.mobileqq.guild.setting.guildmanage.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayout;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingItemViewModel;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingViewModel;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.listitem.DataObserver;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.ac;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import ef1.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\f\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J&\u0010\u001b\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014R\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010%\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010\u001e\u001a\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/more/QQGuildManageMoreFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "initData", "Lcom/tencent/mobileqq/widget/listitem/a;", "Vh", "Oh", "Th", "Landroid/widget/ImageView;", "imageView", "", PhotoCategorySummaryInfo.AVATAR_URL, "di", "Landroid/view/View;", "view", "elementId", "ei", "", "ci", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "T", "Lkotlin/Lazy;", "Yh", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "itemAdapter", "U", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/api/IQQGuildRouterApi;", "V", "Lcom/tencent/mobileqq/guild/api/IQQGuildRouterApi;", "mRouteApi", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "W", "Xh", "()Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "guildSettingViewModel", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/l;", "X", "ai", "()Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/l;", "settingJumpViewModel", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/GuildSecondaryAuthorityViewModel;", "Y", "Zh", "()Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/GuildSecondaryAuthorityViewModel;", "mAuthorityViewModel", "<init>", "()V", "Z", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildManageMoreFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy itemAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildId;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final IQQGuildRouterApi mRouteApi;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildSettingViewModel;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy settingJumpViewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAuthorityViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/more/QQGuildManageMoreFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (context == null) {
                QLog.w("QQGuildManageMoreFragment", 2, "context is null.");
            } else {
                if (TextUtils.isEmpty(guildId)) {
                    QQGuildUIUtil.Q(context, R.string.f143560me);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("extra_guild_id", guildId);
                GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, QQGuildManageMoreFragment.class, null, 8, null);
            }
        }

        Companion() {
        }
    }

    public QQGuildManageMoreFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIListItemAdapter>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$itemAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIListItemAdapter invoke() {
                return new QUIListItemAdapter(null, false, false, 7, null);
            }
        });
        this.itemAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$guildId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String string;
                Bundle arguments = QQGuildManageMoreFragment.this.getArguments();
                return (arguments == null || (string = arguments.getString("extra_guild_id")) == null) ? "" : string;
            }
        });
        this.guildId = lazy2;
        QRouteApi api = QRoute.api(IQQGuildRouterApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQGuildRouterApi::class.java)");
        this.mRouteApi = (IQQGuildRouterApi) api;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildSettingViewModel>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$guildSettingViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSettingViewModel invoke() {
                String guildId;
                String guildId2;
                if (QQGuildManageMoreFragment.this.getActivity() != null && GuildSplitViewUtils.f235370a.n(QQGuildManageMoreFragment.this.requireActivity())) {
                    c.Companion companion = ef1.c.INSTANCE;
                    QQGuildManageMoreFragment qQGuildManageMoreFragment = QQGuildManageMoreFragment.this;
                    guildId2 = qQGuildManageMoreFragment.getGuildId();
                    return (GuildSettingViewModel) companion.a(qQGuildManageMoreFragment, GuildSettingViewModel.class, guildId2);
                }
                c.Companion companion2 = ef1.c.INSTANCE;
                FragmentActivity requireActivity = QQGuildManageMoreFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                guildId = QQGuildManageMoreFragment.this.getGuildId();
                return (GuildSettingViewModel) companion2.a(requireActivity, GuildSettingViewModel.class, guildId);
            }
        });
        this.guildSettingViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$settingJumpViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                String guildId;
                l.Companion companion = l.INSTANCE;
                QQGuildManageMoreFragment qQGuildManageMoreFragment = QQGuildManageMoreFragment.this;
                guildId = qQGuildManageMoreFragment.getGuildId();
                Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                QBaseActivity qBaseActivity = QQGuildManageMoreFragment.this.getQBaseActivity();
                Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
                return companion.a(qQGuildManageMoreFragment, guildId, qBaseActivity);
            }
        });
        this.settingJumpViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<GuildSecondaryAuthorityViewModel>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$mAuthorityViewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSecondaryAuthorityViewModel invoke() {
                return (GuildSecondaryAuthorityViewModel) BaseChannelViewModel.sViewModelFactory.create(GuildSecondaryAuthorityViewModel.class);
            }
        });
        this.mAuthorityViewModel = lazy5;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Oh() {
        String string = getString(R.string.f146580uk);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_home_setting_my_active)");
        final x xVar = new x(new x.b.d(string), new x.c.d("", "", false, false, 12, null));
        xVar.T(new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$createGuildActiveConfig$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String url) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(url, "url");
                QQGuildManageMoreFragment.this.di(imageView, url);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageMoreFragment.Ph(QQGuildManageMoreFragment.this, view);
            }
        });
        LiveData<String> b26 = Xh().getGuildSettingItemViewModel().b2();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$createGuildActiveConfig$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QUIListItemAdapter Yh;
                x.c.d O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                Yh = this.Yh();
                Yh.l0(xVar);
            }
        };
        b26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageMoreFragment.Qh(Function1.this, obj);
            }
        });
        LiveData<String> a26 = Xh().getGuildSettingItemViewModel().a2();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$createGuildActiveConfig$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                QUIListItemAdapter Yh;
                x.c.d O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.j(it);
                Yh = this.Yh();
                Yh.l0(xVar);
            }
        };
        a26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageMoreFragment.Rh(Function1.this, obj);
            }
        });
        return xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.f
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                QQGuildManageMoreFragment.Sh(QQGuildManageMoreFragment.this, view);
            }
        }).l(this, Yh()).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(QQGuildManageMoreFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.ci()) {
            l ai5 = this$0.ai();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ai5.W1(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(QQGuildManageMoreFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.ei(view, "em_sgrp_set_active");
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Th() {
        String string = getString(R.string.f156461k_);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_setting_third_app_show)");
        x xVar = new x(new x.b.d(string), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageMoreFragment.Uh(QQGuildManageMoreFragment.this, view);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        DataObserver<com.tencent.mobileqq.widget.listitem.a<ac<V>>> l3 = xVar.l(viewLifecycleOwner, Yh());
        LiveData<Boolean> showPlatformIdentity = Zh().getShowPlatformIdentity();
        Intrinsics.checkNotNullExpressionValue(showPlatformIdentity, "mAuthorityViewModel.showPlatformIdentity");
        l3.e(showPlatformIdentity);
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(QQGuildManageMoreFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!QQGuildUIUtil.v() && !this$0.ci()) {
            this$0.mRouteApi.openGuildThirdAppSetting(this$0.getContext(), this$0.getGuildId());
            VideoReport.reportEvent("clck", this$0.getView(), null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Vh() {
        String string = getString(R.string.f154131dz);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_robot_name)");
        x xVar = new x(new x.b.d(string), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildManageMoreFragment.Wh(QQGuildManageMoreFragment.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(QQGuildManageMoreFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.ci()) {
            GuildSettingItemViewModel guildSettingItemViewModel = this$0.Xh().getGuildSettingItemViewModel();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            guildSettingItemViewModel.e2(it, this$0.getActivity());
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final GuildSettingViewModel Xh() {
        return (GuildSettingViewModel) this.guildSettingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIListItemAdapter Yh() {
        return (QUIListItemAdapter) this.itemAdapter.getValue();
    }

    private final GuildSecondaryAuthorityViewModel Zh() {
        return (GuildSecondaryAuthorityViewModel) this.mAuthorityViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l ai() {
        return (l) this.settingJumpViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean ci() {
        boolean z16 = !ch.m0(getGuildId());
        if (z16) {
            ch.f1(HardCodeUtil.qqStr(R.string.f140840f2));
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di(ImageView imageView, String avatarUrl) {
        int e16 = QQGuildUIUtil.e(20.0f, imageView.getContext().getResources());
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(e16, e16);
        layoutParams.b(0.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = QQGuildUIUtil.e(12.0f, imageView.getContext().getResources());
        imageView.setLayoutParams(layoutParams);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mRequestWidth = e16;
        obtain.mRequestHeight = e16;
        try {
            if (TextUtils.isEmpty(avatarUrl)) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            URLDrawable drawable = URLDrawable.getDrawable(avatarUrl, obtain);
            drawable.setTag(new int[]{e16, e16});
            imageView.setImageDrawable(drawable);
        } catch (Exception e17) {
            QLog.e("QQGuildManageMoreFragment", 1, e17, new Object[0]);
        }
    }

    private final void ei(View view, String elementId) {
        VideoReport.setElementReuseIdentifier(view, elementId);
        ch.Y0(view, elementId, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getGuildId() {
        return (String) this.guildId.getValue();
    }

    private final void initData() {
        LiveData<IGProGuildInfo> j26 = Xh().j2();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.QQGuildManageMoreFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                l ai5;
                ai5 = QQGuildManageMoreFragment.this.ai();
                ai5.i2(iGProGuildInfo);
            }
        };
        j26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.more.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildManageMoreFragment.bi(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        ((RecyclerView) this.P.findViewById(R.id.i4m)).setAdapter(Yh());
        Yh().t0(new Group(Vh()), new Group(Oh(), Th()));
        setTitle("\u66f4\u591a");
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f36;
    }
}
