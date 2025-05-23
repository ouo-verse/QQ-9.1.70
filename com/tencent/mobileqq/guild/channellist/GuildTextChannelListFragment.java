package com.tencent.mobileqq.guild.channellist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ar1.h;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.guild.api.ILocalFocusService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.heartbeatreport.impl.FacadeFragmentOnlineReportHelper;
import com.tencent.mobileqq.guild.homev2.views.widget.GuildHomeVisitorJoinView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.main.view.GuildSubChannelSettingDialogFragment;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildSubscribePollingManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.QQToastUtil;
import cr0.GuildActiveInfo;
import ef1.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zr1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 W2\u00020\u0001:\u0001XB\u0007\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/GuildTextChannelListFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "Wh", "Xh", "hi", "view", "Th", "Vh", "initViewModel", "ii", "Lar1/h$b;", "fi", "ki", "", "getContentLayoutId", "", "needStatusTrans", "needImmersive", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, NodeProps.ON_CLICK, "gi", "rh", "onBackEvent", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "T", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "listView", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "U", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragHost", "Lcom/tencent/mobileqq/guild/homev2/views/widget/GuildHomeVisitorJoinView;", "V", "Lcom/tencent/mobileqq/guild/homev2/views/widget/GuildHomeVisitorJoinView;", "guildJoinContainer", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "W", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "createChannelLayout", "Lcom/tencent/mobileqq/guild/channellist/b;", "X", "Lcom/tencent/mobileqq/guild/channellist/b;", "channelAdapter", "Lcom/tencent/mobileqq/guild/channellist/s;", "Y", "Lcom/tencent/mobileqq/guild/channellist/s;", "summaryRefreshHelper", "Z", "Lar1/h$b;", "pointDragListener", "Lap1/a;", "a0", "Lkotlin/Lazy;", "Uh", "()Lap1/a;", "guildChannelListJumpHandler", "Lar1/h;", "b0", "Lar1/h;", "dragHandler", "Lcom/tencent/mobileqq/guild/channellist/ChannelListViewModel;", "c0", "Lcom/tencent/mobileqq/guild/channellist/ChannelListViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "d0", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "e0", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "f0", "Ljava/lang/String;", "curInstanceId", "<init>", "()V", "g0", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildTextChannelListFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter listView;

    /* renamed from: U, reason: from kotlin metadata */
    private DragFrameLayout dragHost;

    /* renamed from: V, reason: from kotlin metadata */
    private GuildHomeVisitorJoinView guildJoinContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private ShadowFrameLayout createChannelLayout;

    /* renamed from: X, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.channellist.b channelAdapter;

    /* renamed from: Y, reason: from kotlin metadata */
    private s summaryRefreshHelper;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final h.b pointDragListener;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildChannelListJumpHandler;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ar1.h dragHandler;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ChannelListViewModel viewModel;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFacadeType guildFacadeType;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private JumpGuildParam jumpGuildParam;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String curInstanceId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/GuildTextChannelListFragment$Companion;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "a", "", "PARAM_JUMP_GUILD_PARAM", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull final Context context, @NotNull JumpGuildParam jumpGuildParam) {
            Unit unit;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
            Bundle bundle = new Bundle();
            bundle.putParcelable("param_jump_guild_param", jumpGuildParam);
            final Intent intent = new Intent();
            intent.putExtras(bundle);
            qw1.b.r(intent, Reporters.f231995a.b().a("guild_chat_page").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            if (ch.L(jumpGuildParam.guildId) != null) {
                GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildTextChannelListFragment.class, null, 8, null);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Logger.f235387a.d().d("Guild.GuildTextChannelListFragment", 1, "guild is empty, fetch channel info");
                String str = jumpGuildParam.guildId;
                Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
                GuildMainFrameUtils.i(str, null, 0, null, false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment$Companion$show$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                        invoke2(guildAndChannelInfoRsp);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildTextChannelListFragment.class, null, 8, null);
                    }
                }, 30, null);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f215272a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildTextChannelListFragment f215273b;

        public a(ViewModelStoreOwner viewModelStoreOwner, GuildTextChannelListFragment guildTextChannelListFragment) {
            this.f215272a = viewModelStoreOwner;
            this.f215273b = guildTextChannelListFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            JumpGuildParam jumpGuildParam = this.f215273b.jumpGuildParam;
            if (jumpGuildParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                jumpGuildParam = null;
            }
            String str = jumpGuildParam.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            TimedValue timedValue = new TimedValue(new ChannelListViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/channellist/GuildTextChannelListFragment$b", "Lar1/h$b;", "", "b", "a", "Lzq1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements h.b {
        b() {
        }

        @Override // ar1.h.b
        public void a() {
            ChannelListViewModel channelListViewModel = GuildTextChannelListFragment.this.viewModel;
            if (channelListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                channelListViewModel = null;
            }
            channelListViewModel.w2();
        }

        @Override // ar1.h.b
        public void b() {
            ChannelListViewModel channelListViewModel = GuildTextChannelListFragment.this.viewModel;
            if (channelListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                channelListViewModel = null;
            }
            channelListViewModel.x2();
        }

        @Override // ar1.h.b
        public void c(@NotNull zq1.e item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ChannelListViewModel channelListViewModel = GuildTextChannelListFragment.this.viewModel;
            if (channelListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                channelListViewModel = null;
            }
            channelListViewModel.t2(item);
        }
    }

    public GuildTextChannelListFragment() {
        Lazy lazy;
        h.b fi5 = fi();
        this.pointDragListener = fi5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ap1.a>() { // from class: com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment$guildChannelListJumpHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ap1.a invoke() {
                return new ap1.a();
            }
        });
        this.guildChannelListJumpHandler = lazy;
        this.dragHandler = new ar1.h(fi5);
        this.guildFacadeType = GuildFacadeType.FeedsGuildHome9015;
        this.curInstanceId = System.identityHashCode(this) + "_" + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(View view) {
        long j3;
        IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
        FragmentManager childFragmentManager = getChildFragmentManager();
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        ChannelListViewModel channelListViewModel = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        String str = jumpGuildParam.guildId;
        ChannelListViewModel channelListViewModel2 = this.viewModel;
        if (channelListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            channelListViewModel2 = null;
        }
        String chatTitle = channelListViewModel2.getChatTitle();
        ChannelListViewModel channelListViewModel3 = this.viewModel;
        if (channelListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            channelListViewModel = channelListViewModel3;
        }
        Long channelCategoryId = channelListViewModel.getChannelCategoryId();
        if (channelCategoryId != null) {
            j3 = channelCategoryId.longValue();
        } else {
            j3 = 0;
        }
        iQQGuildRouterApi.createTextChannel(childFragmentManager, str, chatTitle, "main_setting", j3);
    }

    private final ap1.a Uh() {
        return (ap1.a) this.guildChannelListJumpHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(View view) {
        IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
        Context context = getContext();
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        iQQGuildRouterApi.openGuildChannelManage(context, jumpGuildParam.guildId, 2);
    }

    private final void Wh(View rootView) {
        IPerformanceReportTask g16;
        View findViewById = rootView.findViewById(R.id.eap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.list)");
        this.listView = (OverScrollRecyclerViewWithHeaderFooter) findViewById;
        View findViewById2 = rootView.findViewById(R.id.uar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.create_channel_layout)");
        this.createChannelLayout = (ShadowFrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.ulf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.drag_frame_layout)");
        this.dragHost = (DragFrameLayout) findViewById3;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.listView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setLayoutManager(new LinearLayoutManager(getActivity()));
        DragFrameLayout dragFrameLayout = this.dragHost;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHost");
            dragFrameLayout = null;
        }
        this.channelAdapter = new com.tencent.mobileqq.guild.channellist.b(dragFrameLayout, new eg1.a(new GuildTextChannelListFragment$initChannelList$1(this), new GuildTextChannelListFragment$initChannelList$2(this), new GuildTextChannelListFragment$initChannelList$3(this)));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.listView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            overScrollRecyclerViewWithHeaderFooter2 = null;
        }
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        com.tencent.mobileqq.guild.channellist.b bVar = this.channelAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelAdapter");
            bVar = null;
        }
        adapterArr[0] = bVar;
        overScrollRecyclerViewWithHeaderFooter2.setAdapter(new RFWConcatAdapter(adapterArr));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.listView;
        if (overScrollRecyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            overScrollRecyclerViewWithHeaderFooter3 = null;
        }
        this.summaryRefreshHelper = new s(overScrollRecyclerViewWithHeaderFooter3);
        Bundle arguments = getArguments();
        if (arguments != null && (g16 = qw1.b.g(arguments, null, 1, null)) != null) {
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = this.listView;
            if (overScrollRecyclerViewWithHeaderFooter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                overScrollRecyclerViewWithHeaderFooter4 = null;
            }
            qw1.b.q(g16, overScrollRecyclerViewWithHeaderFooter4, null, 2, null);
        }
    }

    private final void Xh(View rootView) {
        View findViewById = rootView.findViewById(R.id.x4w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026uild_visitor_join_layout)");
        GuildHomeVisitorJoinView guildHomeVisitorJoinView = (GuildHomeVisitorJoinView) findViewById;
        this.guildJoinContainer = guildHomeVisitorJoinView;
        JumpGuildParam jumpGuildParam = null;
        if (guildHomeVisitorJoinView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildJoinContainer");
            guildHomeVisitorJoinView = null;
        }
        JumpGuildParam jumpGuildParam2 = this.jumpGuildParam;
        if (jumpGuildParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
        } else {
            jumpGuildParam = jumpGuildParam2;
        }
        guildHomeVisitorJoinView.c(jumpGuildParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(GuildTextChannelListFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Th(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final h.b fi() {
        return new b();
    }

    private final void hi() {
        JumpGuildParam jumpGuildParam = (JumpGuildParam) GuildSplitViewUtils.f235370a.g(this).getParcelable("param_jump_guild_param");
        if (jumpGuildParam != null) {
            this.jumpGuildParam = jumpGuildParam;
            return;
        }
        throw new IllegalStateException("Guild.GuildTextChannelListFragment param_facade_args_data is null");
    }

    private final void ii(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_sgrp_chat_list");
        HashMap hashMap = new HashMap(com.tencent.mobileqq.guild.report.b.d());
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        iGuildDTReportApi.setGuildPageParams(view, jumpGuildParam.guildId, hashMap);
    }

    private final void initView(View rootView) {
        rootView.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        setTitle("\u8ba8\u8bba\u7ec4");
        rh();
        Wh(rootView);
        Xh(rootView);
    }

    private final void initViewModel() {
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new a(this, this)).get(ChannelListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        ChannelListViewModel channelListViewModel = (ChannelListViewModel) viewModel;
        this.viewModel = channelListViewModel;
        ShadowFrameLayout shadowFrameLayout = null;
        if (channelListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            channelListViewModel = null;
        }
        LiveData<List<c>> l26 = channelListViewModel.l2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final GuildTextChannelListFragment$initViewModel$2 guildTextChannelListFragment$initViewModel$2 = new GuildTextChannelListFragment$initViewModel$2(this);
        l26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.channellist.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildTextChannelListFragment.Yh(Function1.this, obj);
            }
        });
        ChannelListViewModel channelListViewModel2 = this.viewModel;
        if (channelListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            channelListViewModel2 = null;
        }
        LiveData<Boolean> o26 = channelListViewModel2.o2();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter;
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2;
                b bVar;
                overScrollRecyclerViewWithHeaderFooter = GuildTextChannelListFragment.this.listView;
                b bVar2 = null;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                overScrollRecyclerViewWithHeaderFooter.setItemViewCacheSize(0);
                overScrollRecyclerViewWithHeaderFooter2 = GuildTextChannelListFragment.this.listView;
                if (overScrollRecyclerViewWithHeaderFooter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    overScrollRecyclerViewWithHeaderFooter2 = null;
                }
                overScrollRecyclerViewWithHeaderFooter2.setItemViewCacheSize(2);
                bVar = GuildTextChannelListFragment.this.channelAdapter;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelAdapter");
                } else {
                    bVar2 = bVar;
                }
                bVar2.notifyDataSetChanged();
            }
        };
        o26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.channellist.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildTextChannelListFragment.Zh(Function1.this, obj);
            }
        });
        ChannelListViewModel channelListViewModel3 = this.viewModel;
        if (channelListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            channelListViewModel3 = null;
        }
        LiveData<Boolean> s26 = channelListViewModel3.s2();
        LifecycleOwner lifecycleOwner3 = getLifecycleOwner();
        final GuildTextChannelListFragment$initViewModel$4 guildTextChannelListFragment$initViewModel$4 = new GuildTextChannelListFragment$initViewModel$4(this);
        s26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.channellist.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildTextChannelListFragment.ai(Function1.this, obj);
            }
        });
        ChannelListViewModel channelListViewModel4 = this.viewModel;
        if (channelListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            channelListViewModel4 = null;
        }
        LiveData<Boolean> m26 = channelListViewModel4.m2();
        LifecycleOwner lifecycleOwner4 = getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment$initViewModel$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                GuildTextChannelListFragment.this.ki();
                FragmentActivity activity = GuildTextChannelListFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        };
        m26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.channellist.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildTextChannelListFragment.bi(Function1.this, obj);
            }
        });
        ChannelListViewModel channelListViewModel5 = this.viewModel;
        if (channelListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            channelListViewModel5 = null;
        }
        LiveData<IGProGuildInfo> n26 = channelListViewModel5.n2();
        LifecycleOwner lifecycleOwner5 = getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function13 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment$initViewModel$6
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
                GuildHomeVisitorJoinView guildHomeVisitorJoinView;
                GuildHomeVisitorJoinView guildHomeVisitorJoinView2;
                GuildHomeVisitorJoinView guildHomeVisitorJoinView3 = null;
                if (iGProGuildInfo == null || !iGProGuildInfo.isMember()) {
                    guildHomeVisitorJoinView = GuildTextChannelListFragment.this.guildJoinContainer;
                    if (guildHomeVisitorJoinView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildJoinContainer");
                    } else {
                        guildHomeVisitorJoinView3 = guildHomeVisitorJoinView;
                    }
                    guildHomeVisitorJoinView3.setVisibility(0);
                    return;
                }
                guildHomeVisitorJoinView2 = GuildTextChannelListFragment.this.guildJoinContainer;
                if (guildHomeVisitorJoinView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildJoinContainer");
                } else {
                    guildHomeVisitorJoinView3 = guildHomeVisitorJoinView2;
                }
                guildHomeVisitorJoinView3.setVisibility(8);
            }
        };
        n26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.channellist.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildTextChannelListFragment.ci(Function1.this, obj);
            }
        });
        ChannelListViewModel channelListViewModel6 = this.viewModel;
        if (channelListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            channelListViewModel6 = null;
        }
        LiveData<Boolean> j26 = channelListViewModel6.j2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment$initViewModel$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ShadowFrameLayout shadowFrameLayout2;
                ShadowFrameLayout shadowFrameLayout3;
                ShadowFrameLayout shadowFrameLayout4;
                Logger.f235387a.d().i("Guild.GuildTextChannelListFragment", 1, "liveCreatePermission: " + it);
                shadowFrameLayout2 = GuildTextChannelListFragment.this.createChannelLayout;
                if (shadowFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createChannelLayout");
                    shadowFrameLayout2 = null;
                }
                shadowFrameLayout2.setVisibility(Intrinsics.areEqual(it, Boolean.TRUE) ? 0 : 8);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    shadowFrameLayout3 = GuildTextChannelListFragment.this.createChannelLayout;
                    if (shadowFrameLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createChannelLayout");
                        shadowFrameLayout4 = null;
                    } else {
                        shadowFrameLayout4 = shadowFrameLayout3;
                    }
                    bt.d(shadowFrameLayout4, "em_sgrp_create_aio", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
                }
            }
        };
        j26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.channellist.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildTextChannelListFragment.di(Function1.this, obj);
            }
        });
        ShadowFrameLayout shadowFrameLayout2 = this.createChannelLayout;
        if (shadowFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createChannelLayout");
        } else {
            shadowFrameLayout = shadowFrameLayout2;
        }
        shadowFrameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channellist.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildTextChannelListFragment.ei(GuildTextChannelListFragment.this, view);
            }
        });
    }

    @JvmStatic
    public static final void ji(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam) {
        INSTANCE.a(context, jumpGuildParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki() {
        QQToastUtil.showQQToast(1, "\u4f60\u5df2\u88ab\u79fb\u51fa\u9891\u9053");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.etj;
    }

    public final boolean gi(@NotNull View view) {
        c cVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(R.id.w1p);
        if (tag instanceof c) {
            cVar = (c) tag;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            QLog.e("Guild.GuildTextChannelListFragment", 1, "onLongClick() item is not ChannelData");
            return false;
        }
        if (cVar instanceof TextChannelData) {
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            TextChannelData textChannelData = (TextChannelData) cVar;
            IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(String.valueOf(textChannelData.getChannelUin()));
            if (channelInfo != null) {
                QLog.e("Guild.GuildTextChannelListFragment", 1, "onLongClick(" + textChannelData.getChannelUin() + "): " + channelInfo.getFinalMsgNotify());
                GuildSubChannelSettingDialogFragment.GuildSubChannelParams th5 = GuildSubChannelSettingDialogFragment.th(channelInfo, this.guildFacadeType);
                if (th5.canShowSettingDialog()) {
                    GuildSubChannelSettingDialogFragment.Bh(getQBaseActivity(), th5);
                    return true;
                }
            }
        } else if (cVar instanceof AppChannelData) {
            com.tencent.mobileqq.guild.base.extension.r rVar2 = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            IRuntimeService S02 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S02, "runtimeService(T::class.java, process)");
            AppChannelData appChannelData = (AppChannelData) cVar;
            IGProChannelInfo channelInfo2 = ((IGPSService) S02).getChannelInfo(String.valueOf(appChannelData.getChannelUin()));
            if (channelInfo2 != null) {
                QLog.e("Guild.GuildTextChannelListFragment", 1, "onLongClick(" + appChannelData.getChannelUin() + "): " + channelInfo2.getFinalMsgNotify());
                GuildSubChannelSettingDialogFragment.GuildSubChannelParams th6 = GuildSubChannelSettingDialogFragment.th(channelInfo2, this.guildFacadeType);
                if (th6.canShowSettingDialog()) {
                    GuildSubChannelSettingDialogFragment.Bh(getQBaseActivity(), th6);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    public final void onClick(@NotNull View view) {
        c cVar;
        Map<String, ? extends Object> mapOf;
        Map<String, ? extends Object> mapOf2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (QQGuildUIUtil.v()) {
            return;
        }
        Object tag = view.getTag(R.id.w1p);
        if (tag instanceof c) {
            cVar = (c) tag;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            QLog.e("Guild.GuildTextChannelListFragment", 1, "onItemClick() item is not ChannelData");
            return;
        }
        if (cVar instanceof TextChannelData) {
            TextChannelData textChannelData = (TextChannelData) cVar;
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_sub_channel_id", String.valueOf(textChannelData.getChannelUin())), TuplesKt.to("sgrp_red_tips_type", Integer.valueOf(textChannelData.getMsgData().f())), TuplesKt.to("sgrp_rank", Integer.valueOf(textChannelData.getIndex())), TuplesKt.to("sgrp_subchannel_type", 1));
            bt.f235484a.g(view, "em_sgrp_channel", "clck", mapOf2);
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(String.valueOf(textChannelData.getChannelUin()));
            if (channelInfo != null) {
                ap1.a Uh = Uh();
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                Uh.b(channelInfo, true, requireContext);
                return;
            }
            return;
        }
        if (cVar instanceof AppChannelData) {
            AppChannelData appChannelData = (AppChannelData) cVar;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_sub_channel_id", String.valueOf(appChannelData.getChannelUin())), TuplesKt.to("sgrp_red_tips_type", Integer.valueOf(appChannelData.getMsgData().f())), TuplesKt.to("sgrp_rank", Integer.valueOf(appChannelData.getIndex())), TuplesKt.to("sgrp_subchannel_type", 6));
            bt.f235484a.g(view, "em_sgrp_channel", "clck", mapOf);
            com.tencent.mobileqq.guild.base.extension.r rVar2 = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            IRuntimeService S02 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S02, "runtimeService(T::class.java, process)");
            IGProChannelInfo channelInfo2 = ((IGPSService) S02).getChannelInfo(String.valueOf(appChannelData.getChannelUin()));
            if (channelInfo2 != null) {
                ap1.a Uh2 = Uh();
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                Uh2.b(channelInfo2, true, requireContext2);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        boolean z16;
        super.onDestroy();
        ILocalFocusService iLocalFocusService = (ILocalFocusService) ch.R0(ILocalFocusService.class);
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        String str = jumpGuildParam.guildId;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "0";
        }
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId.i\u2026FocusService.INVALID_ID }");
        iLocalFocusService.setActiveGuild(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(str, this.curInstanceId), 2, false));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ar1.h hVar = this.dragHandler;
        DragFrameLayout dragFrameLayout = this.dragHost;
        JumpGuildParam jumpGuildParam = null;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHost");
            dragFrameLayout = null;
        }
        hVar.b(dragFrameLayout);
        s sVar = this.summaryRefreshHelper;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryRefreshHelper");
            sVar = null;
        }
        sVar.k();
        GuildSubscribePollingManager guildSubscribePollingManager = GuildSubscribePollingManager.f235373a;
        JumpGuildParam jumpGuildParam2 = this.jumpGuildParam;
        if (jumpGuildParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
        } else {
            jumpGuildParam = jumpGuildParam2;
        }
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        guildSubscribePollingManager.d(str, this.curInstanceId);
        FacadeFragmentOnlineReportHelper.h();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z16;
        super.onResume();
        Logger.a d16 = Logger.f235387a.d();
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        JumpGuildParam jumpGuildParam2 = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        boolean z17 = true;
        d16.i("Guild.GuildTextChannelListFragment", 1, "onResume(" + jumpGuildParam.guildId + ")");
        ar1.h hVar = this.dragHandler;
        DragFrameLayout dragFrameLayout = this.dragHost;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHost");
            dragFrameLayout = null;
        }
        hVar.a(dragFrameLayout);
        s sVar = this.summaryRefreshHelper;
        if (sVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryRefreshHelper");
            sVar = null;
        }
        sVar.l();
        GuildSubscribePollingManager guildSubscribePollingManager = GuildSubscribePollingManager.f235373a;
        JumpGuildParam jumpGuildParam3 = this.jumpGuildParam;
        if (jumpGuildParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam3 = null;
        }
        String str = jumpGuildParam3.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        guildSubscribePollingManager.c(str, this.curInstanceId);
        JumpGuildParam jumpGuildParam4 = this.jumpGuildParam;
        if (jumpGuildParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam4 = null;
        }
        FacadeFragmentOnlineReportHelper.d(jumpGuildParam4.guildId);
        ILocalFocusService iLocalFocusService = (ILocalFocusService) ch.R0(ILocalFocusService.class);
        JumpGuildParam jumpGuildParam5 = this.jumpGuildParam;
        if (jumpGuildParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam5 = null;
        }
        String str2 = jumpGuildParam5.guildId;
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = "0";
        }
        Intrinsics.checkNotNullExpressionValue(str2, "jumpGuildParam.guildId.i\u2026FocusService.INVALID_ID }");
        GuildActiveInfo.UniqueKey uniqueKey = new GuildActiveInfo.UniqueKey(str2, this.curInstanceId);
        JumpGuildParam jumpGuildParam6 = this.jumpGuildParam;
        if (jumpGuildParam6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
        } else {
            jumpGuildParam2 = jumpGuildParam6;
        }
        String str3 = jumpGuildParam2.guildId;
        Intrinsics.checkNotNullExpressionValue(str3, "jumpGuildParam.guildId");
        if (str3.length() <= 0) {
            z17 = false;
        }
        iLocalFocusService.setActiveGuild(new GuildActiveInfo(uniqueKey, 2, z17));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        hi();
        initView(view);
        ap1.a Uh = Uh();
        e.Companion companion = zr1.e.INSTANCE;
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        Uh.a(companion.a(jumpGuildParam, null));
        initViewModel();
        ii(view);
        GuildSplitViewUtils.f235370a.B(this.N);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }
}
