package com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.impl.e;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.GuildApplicationManageFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageModuleListPart;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.part.GuildAppManageTopTitlePart;
import com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.viewmodel.GuildApplicationManageViewModel;
import com.tencent.mobileqq.guild.setting.guildmanage.navigation.GuildNavigationStatus;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.bs;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.cq;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J&\u0010\u000e\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/GuildApplicationManageFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "Ih", "setStatusBar", "initData", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "onBackEvent", "", "T", "Lkotlin/Lazy;", "Fh", "()Ljava/lang/String;", "mGuildId", "U", "Gh", "()Z", "mIsEnableShowNavBar", "Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "V", "Hh", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/viewmodel/GuildApplicationManageViewModel;", "mViewModel", "<init>", "()V", "W", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildApplicationManageFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGuildId;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy mIsEnableShowNavBar;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/guildappmanage/GuildApplicationManageFragment$Companion;", "", "", "guildId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus;", "", "resultFun", "c", "Landroid/content/Context;", "context", "f", "KEY_ENABLE_SHOW_NAV_BAR", "Ljava/lang/String;", "", "REQ_ADD_CONFIG", "I", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(final String guildId, final Function1<? super GuildNavigationStatus, Unit> resultFun) {
            IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
            bs bsVar = new bs();
            bsVar.b(Long.parseLong(guildId));
            iGPSService.getNavigationStatus(bsVar, new cq() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.a
                @Override // wh2.cq
                public final void a(int i3, String str, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
                    GuildApplicationManageFragment.Companion.d(Function1.this, guildId, i3, str, iGProGetNavigationStatusRsp);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final Function1 resultFun, final String guildId, final int i3, String errMsg, final IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
            Intrinsics.checkNotNullParameter(resultFun, "$resultFun");
            Intrinsics.checkNotNullParameter(guildId, "$guildId");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("GuildApplicationManageFragment", 1, "[getGuildNavigationStatus]onGetNavigationStatus result:" + i3 + ", errMsg:" + errMsg + ", rsp:" + iGProGetNavigationStatusRsp);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildApplicationManageFragment.Companion.e(i3, iGProGetNavigationStatusRsp, resultFun, guildId);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(int i3, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp, Function1 resultFun, String guildId) {
            boolean z16;
            Intrinsics.checkNotNullParameter(resultFun, "$resultFun");
            Intrinsics.checkNotNullParameter(guildId, "$guildId");
            if (i3 == 0 && iGProGetNavigationStatusRsp != null) {
                boolean z17 = false;
                if (iGProGetNavigationStatusRsp.getEnableSetting() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (iGProGetNavigationStatusRsp.getExistNavigation() == 1) {
                    z17 = true;
                }
                resultFun.invoke(new GuildNavigationStatus(guildId, z16, z17, iGProGetNavigationStatusRsp.getAuditStatus()));
                return;
            }
            resultFun.invoke(null);
        }

        public final void f(@NotNull final Context context, @NotNull final String guildId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (TextUtils.isEmpty(guildId)) {
                QQGuildUIUtil.Q(context, R.string.f143560me);
            } else {
                c(guildId, new Function1<GuildNavigationStatus, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.GuildApplicationManageFragment$Companion$openPage$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GuildNavigationStatus guildNavigationStatus) {
                        invoke2(guildNavigationStatus);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable GuildNavigationStatus guildNavigationStatus) {
                        Intent intent = new Intent();
                        boolean enableShowNavBar = guildNavigationStatus != null ? guildNavigationStatus.getEnableShowNavBar() : false;
                        intent.putExtra("extra_guild_id", guildId);
                        intent.putExtra("key_enable_show_nav_bar", enableShowNavBar);
                        GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildApplicationManageFragment.class, null, 8, null);
                    }
                });
            }
        }

        Companion() {
        }
    }

    public GuildApplicationManageFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.GuildApplicationManageFragment$mGuildId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Bundle arguments = GuildApplicationManageFragment.this.getArguments();
                String string = arguments != null ? arguments.getString("extra_guild_id", "") : null;
                return string == null ? "" : string;
            }
        });
        this.mGuildId = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.GuildApplicationManageFragment$mIsEnableShowNavBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Bundle arguments = GuildApplicationManageFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("key_enable_show_nav_bar", false) : false);
            }
        });
        this.mIsEnableShowNavBar = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildApplicationManageViewModel>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.GuildApplicationManageFragment$mViewModel$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f233935a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildApplicationManageFragment f233936b;

                public a(ViewModelStoreOwner viewModelStoreOwner, GuildApplicationManageFragment guildApplicationManageFragment) {
                    this.f233935a = viewModelStoreOwner;
                    this.f233936b = guildApplicationManageFragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    String Fh;
                    boolean Gh;
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
                    Fh = this.f233936b.Fh();
                    Gh = this.f233936b.Gh();
                    TimedValue timedValue = new TimedValue(new GuildApplicationManageViewModel(Fh, Gh), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildApplicationManageViewModel invoke() {
                c.Companion companion = c.INSTANCE;
                GuildApplicationManageFragment guildApplicationManageFragment = GuildApplicationManageFragment.this;
                ViewModel viewModel = new ViewModelProvider(guildApplicationManageFragment, new a(guildApplicationManageFragment, guildApplicationManageFragment)).get(GuildApplicationManageViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (GuildApplicationManageViewModel) viewModel;
            }
        });
        this.mViewModel = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Fh() {
        return (String) this.mGuildId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Gh() {
        return ((Boolean) this.mIsEnableShowNavBar.getValue()).booleanValue();
    }

    private final GuildApplicationManageViewModel Hh() {
        return (GuildApplicationManageViewModel) this.mViewModel.getValue();
    }

    private final void Ih() {
        this.J.setVisibility(8);
    }

    private final void initData() {
        Hh().U1();
        Hh().X1();
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageParams(this.N, "sgrp_channel_id", Fh());
        VideoReport.setPageParams(this.N, "sgrp_user_type", Integer.valueOf(v.c(Fh())));
        e.a(this.N, "pg_sgrp_apply_category_set", null, null, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, null);
    }

    private final void setStatusBar() {
        QQGuildUIUtil.L(getActivity(), getResources().getColor(R.color.qui_common_bg_bottom_light));
        boolean z16 = !GuildThemeManager.f235286a.b();
        Window window = requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        GuildThemeManager.i(z16, window);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GuildAppManageTopTitlePart(Hh()), new GuildAppManageModuleListPart(this, Hh()));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setStatusBar();
        Ih();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.efx;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        getPartManager().onBackEvent();
        return true;
    }
}
