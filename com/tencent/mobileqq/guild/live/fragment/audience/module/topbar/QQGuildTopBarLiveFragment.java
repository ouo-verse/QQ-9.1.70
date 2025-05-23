package com.tencent.mobileqq.guild.live.fragment.audience.module.topbar;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.channel.frame.titlebar.GuildChannelTitleBarManager;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment;
import com.tencent.mobileqq.guild.media.presenter.GuildMediaShareAnimUseCase;
import com.tencent.mobileqq.guild.media.widget.GuildMediaRankingUserCase;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.as;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.z;
import com.tencent.mobileqq.guild.widget.BubbleView;
import com.tencent.mobileqq.guild.widget.ClickType;
import com.tencent.mobileqq.guild.widget.GuildAIOTitleBar;
import com.tencent.mobileqq.guild.widget.GuildRightIconLayout;
import com.tencent.mobileqq.guild.widget.IconType;
import com.tencent.mobileqq.guild.widget.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.group_pro_proto.channel_share.GuildChannelShare$ChannelShareGuidancePush;
import tx1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0089\u0001B\t\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\u0006H\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J#\u00102\u001a\u00020\u00062\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r00\"\u00020\rH\u0002\u00a2\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u00020\u0006H\u0002J\b\u00106\u001a\u00020\u0006H\u0002J\u0010\u00107\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\rH\u0002J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020%H\u0002J\b\u0010:\u001a\u00020\u0006H\u0002J\b\u0010;\u001a\u00020\u0006H\u0002J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\rH\u0002J\u0012\u0010?\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010B\u001a\u00020\u0006H\u0002J\b\u0010C\u001a\u00020\u0006H\u0002J\b\u0010D\u001a\u00020\u0006H\u0002J\b\u0010E\u001a\u00020\u0006H\u0002J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010e\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010`R\u0016\u0010g\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010`R\u0016\u0010i\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010`R\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020\r0j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u001b\u0010s\u001a\u00020n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u001b\u0010x\u001a\u00020t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bu\u0010p\u001a\u0004\bv\u0010wR\u001b\u0010}\u001a\u00020y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010p\u001a\u0004\b{\u0010|R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/audience/module/topbar/QQGuildTopBarLiveFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/base/module/topbar/QQGuildLiveBaseTopBarFragment;", "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/g;", "Lcom/tencent/mobileqq/guild/widget/ah;", "Landroid/content/Intent;", "intent", "", "onNewIntent", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/view/View;", "view", "initView", "", "getLayoutId", "initViewModel", "initLiveDataObserver", "Landroid/content/Context;", "context", "onAttach", "state", "Qh", "(Ljava/lang/Integer;)V", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "H5", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "T3", "Lcom/tencent/mobileqq/guild/widget/ClickType;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "v", "u2", "", "onBackEvent", "onDetach", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ph", "Uh", "Vh", "Yh", "Rh", "ni", "", "views", "Lh", "([Landroid/view/View;)V", "Jh", "initChannelLoadProxyManager", "ri", "fi", "select", "si", "gi", "Ih", "clickView", "li", "moreView", "pi", WidgetCacheLunarData.JI, "Kh", "hi", "qi", "ki", "ii", "mi", "Ltx1/a;", "D", "Ltx1/a;", "mSettingRoleManager", "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/GuildChannelTitleBarManager;", "E", "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/GuildChannelTitleBarManager;", "mGuildChannelTitleBarManager", "Lcom/tencent/mobileqq/guild/live/viewmodel/h;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/live/viewmodel/h;", "mGuildLiveRoomVM", "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "G", "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "mTitleBar", "H", "Z", "mHasClickMore", "Lcom/tencent/mobileqq/guild/widget/BubbleView;", "I", "Lcom/tencent/mobileqq/guild/widget/BubbleView;", "mMoreBtnBubbleTip", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "J", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "mRankingListBtn", "K", "mFloatZoomBtn", "L", "mVerticalToScaleBtn", "M", "mShareBtn", "N", "mMoreView", "", "P", "Ljava/util/List;", "mAllCtlView", "Lcom/tencent/mobileqq/guild/media/presenter/GuildMediaShareAnimUseCase;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Oh", "()Lcom/tencent/mobileqq/guild/media/presenter/GuildMediaShareAnimUseCase;", "mShareAnimUseCase", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRankingUserCase;", BdhLogUtil.LogTag.Tag_Req, "Nh", "()Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRankingUserCase;", "mRankingListGuideUserCase", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", ExifInterface.LATITUDE_SOUTH, "Mh", "()Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mExitLiveDialog", "Landroid/view/ViewGroup;", "T", "Landroid/view/ViewGroup;", "mDialogRootView", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "U", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "<init>", "()V", "V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildTopBarLiveFragment extends QQGuildLiveBaseTopBarFragment implements com.tencent.mobileqq.guild.channel.frame.titlebar.g, ah {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<Integer> W;

    @NotNull
    private static final Map<IconType, Integer> X;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private tx1.a mSettingRoleManager;

    /* renamed from: E, reason: from kotlin metadata */
    private GuildChannelTitleBarManager mGuildChannelTitleBarManager;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.live.viewmodel.h mGuildLiveRoomVM;

    /* renamed from: G, reason: from kotlin metadata */
    private GuildAIOTitleBar mTitleBar;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mHasClickMore = bw.L().decodeBool("has_click_more", false);

    /* renamed from: I, reason: from kotlin metadata */
    private BubbleView mMoreBtnBubbleTip;

    /* renamed from: J, reason: from kotlin metadata */
    private GuildRightIconLayout mRankingListBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private GuildRightIconLayout mFloatZoomBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private GuildRightIconLayout mVerticalToScaleBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private GuildRightIconLayout mShareBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private GuildRightIconLayout mMoreView;

    /* renamed from: P, reason: from kotlin metadata */
    private List<? extends View> mAllCtlView;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy mShareAnimUseCase;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRankingListGuideUserCase;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy mExitLiveDialog;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ViewGroup mDialogRootView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/audience/module/topbar/QQGuildTopBarLiveFragment$a;", "", "Lcom/tencent/mobileqq/guild/live/fragment/base/QQGuildLiveModuleBaseFragment;", "a", "", "HAS_CLICK_MORE", "Ljava/lang/String;", "TAG", "", "TITLE_SHOW_HIDE_TIME", "J", "", "", "canManagePermissionList", "Ljava/util/List;", "", "Lcom/tencent/mobileqq/guild/widget/IconType;", "iconPriority", "Ljava/util/Map;", "rootViewTag", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final QQGuildLiveModuleBaseFragment a() {
            return new QQGuildTopBarLiveFragment();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f226636a;

        static {
            int[] iArr = new int[ClickType.values().length];
            try {
                iArr[ClickType.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClickType.FULL_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClickType.MINIMIZE_SCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ClickType.RIGHT_TEXT_BUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ClickType.THREE_LINES_SETTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ClickType.SHOW_GUILD_DIALOG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ClickType.SHARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ClickType.JOIN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ClickType.RANKING_LIST.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f226636a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/audience/module/topbar/QQGuildTopBarLiveFragment$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "bussinessId", "", "eventdata", "", "onPushBussinessConfig", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushBussinessConfig(int bussinessId, @Nullable byte[] eventdata) {
            GuildChannelShare$ChannelShareGuidancePush mergeFrom = new GuildChannelShare$ChannelShareGuidancePush().mergeFrom(eventdata);
            Logger.a d16 = Logger.f235387a.d();
            long j3 = mergeFrom.guild_id.get();
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            boolean z16 = true;
            d16.i("QGL.QQGuildTopBarLiveFragment", 1, "onPushBussinessConfig " + bussinessId + " \nguildId: " + j3 + " ; " + gLiveChannelCore.s().getGuildId() + " | channelId: " + mergeFrom.channel_id.get() + " ; " + gLiveChannelCore.s().getChannelId());
            if (bussinessId == 78 && Intrinsics.areEqual(String.valueOf(mergeFrom.guild_id.get()), gLiveChannelCore.s().getGuildId()) && Intrinsics.areEqual(String.valueOf(mergeFrom.channel_id.get()), gLiveChannelCore.s().getChannelId())) {
                IGProChannelInfo B = ch.B(gLiveChannelCore.s().getChannelId());
                if (B == null || B.getVisibleType() != 1) {
                    z16 = false;
                }
                if (z16) {
                    QQGuildTopBarLiveFragment.this.Oh().s();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/audience/module/topbar/QQGuildTopBarLiveFragment$d", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveTopMoreDialogFragment$a;", "", "b", "c", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements GuildLiveTopMoreDialogFragment.a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment.a
        public void a() {
            QQGuildTopBarLiveFragment.this.qi();
        }

        @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment.a
        public void b() {
            QQGuildTopBarLiveFragment.this.ii();
        }

        @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveTopMoreDialogFragment.a
        public void c() {
            QQGuildTopBarLiveFragment.this.hi();
        }
    }

    static {
        List<Integer> listOf;
        Map<IconType, Integer> mapOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{20002, 20003, 20013});
        W = listOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(IconType.MINIMIZE_SCREEN, 0), TuplesKt.to(IconType.FULL_SCREEN, 1), TuplesKt.to(IconType.SHARE, 2), TuplesKt.to(IconType.THREE_LINES_SETTING, 3));
        X = mapOf;
    }

    public QQGuildTopBarLiveFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildMediaShareAnimUseCase>() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment$mShareAnimUseCase$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMediaShareAnimUseCase invoke() {
                GuildRightIconLayout guildRightIconLayout;
                guildRightIconLayout = QQGuildTopBarLiveFragment.this.mMoreView;
                if (guildRightIconLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
                    guildRightIconLayout = null;
                }
                final QQGuildTopBarLiveFragment qQGuildTopBarLiveFragment = QQGuildTopBarLiveFragment.this;
                return new GuildMediaShareAnimUseCase(guildRightIconLayout, 5, "scene_live", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment$mShareAnimUseCase$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        GuildRightIconLayout guildRightIconLayout2;
                        QQGuildTopBarLiveFragment qQGuildTopBarLiveFragment2 = QQGuildTopBarLiveFragment.this;
                        guildRightIconLayout2 = qQGuildTopBarLiveFragment2.mMoreView;
                        if (guildRightIconLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
                            guildRightIconLayout2 = null;
                        }
                        qQGuildTopBarLiveFragment2.ji(guildRightIconLayout2);
                    }
                });
            }
        });
        this.mShareAnimUseCase = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildMediaRankingUserCase>() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment$mRankingListGuideUserCase$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment$mRankingListGuideUserCase$2$1, reason: invalid class name */
            /* loaded from: classes14.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
                AnonymousClass1(Object obj) {
                    super(0, obj, QQGuildTopBarLiveFragment.class, "handleRankingListClick", "handleRankingListClick()V", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((QQGuildTopBarLiveFragment) this.receiver).Ph();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMediaRankingUserCase invoke() {
                GuildRightIconLayout guildRightIconLayout;
                guildRightIconLayout = QQGuildTopBarLiveFragment.this.mRankingListBtn;
                if (guildRightIconLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRankingListBtn");
                    guildRightIconLayout = null;
                }
                return new GuildMediaRankingUserCase(guildRightIconLayout, new AnonymousClass1(QQGuildTopBarLiveFragment.this));
            }
        });
        this.mRankingListGuideUserCase = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new QQGuildTopBarLiveFragment$mExitLiveDialog$2(this));
        this.mExitLiveDialog = lazy3;
        this.mGPServiceObserver = new c();
    }

    private final void Ih() {
        if (AppSetting.t(getContext()) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity(getActivity())) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onKeyDown(4, new KeyEvent(4, 4));
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }

    private final boolean Jh() {
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        if (channelInfo == null) {
            return false;
        }
        return as.j(channelInfo);
    }

    private final void Kh(View view) {
        if (!this.mHasClickMore && GLiveChannelCore.f226698a.s().isLiving()) {
            this.mHasClickMore = true;
            bw.L().encodeBool("has_click_more", true);
            BubbleView bubbleView = this.mMoreBtnBubbleTip;
            if (bubbleView != null) {
                if (bubbleView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                    bubbleView = null;
                }
                bubbleView.e(view);
            }
        }
    }

    private final void Lh(View... views) {
        boolean contains;
        List<? extends View> list = this.mAllCtlView;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAllCtlView");
            list = null;
        }
        for (View view : list) {
            contains = ArraysKt___ArraysKt.contains(views, view);
            if (contains) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    private final QQCustomDialog Mh() {
        Object value = this.mExitLiveDialog.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mExitLiveDialog>(...)");
        return (QQCustomDialog) value;
    }

    private final GuildMediaRankingUserCase Nh() {
        return (GuildMediaRankingUserCase) this.mRankingListGuideUserCase.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildMediaShareAnimUseCase Oh() {
        return (GuildMediaShareAnimUseCase) this.mShareAnimUseCase.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph() {
        if (com.tencent.mobileqq.guild.util.o.d("QGL.QQGuildTopBarLiveFragment_ranking", 1000L)) {
            return;
        }
        QRouteApi api = QRoute.api(IGuildMediaChannelApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMediaChannelApi::class.java)");
        IGuildMediaChannelApi iGuildMediaChannelApi = (IGuildMediaChannelApi) api;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        IGuildMediaChannelApi.a.i(iGuildMediaChannelApi, gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId(), null, null, null, null, 60, null);
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[handleRankingListClick] ");
    }

    private final void Rh() {
        IGProChannelInfo channelInfo;
        if (this.mSettingRoleManager != null || (channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo()) == null) {
            return;
        }
        tx1.a aVar = new tx1.a(channelInfo);
        ni();
        this.mSettingRoleManager = aVar;
        Intrinsics.checkNotNull(aVar);
        aVar.n(new a.b() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.k
            @Override // tx1.a.b
            public final void a(boolean z16, boolean z17, boolean z18) {
                QQGuildTopBarLiveFragment.Sh(QQGuildTopBarLiveFragment.this, z16, z17, z18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(QQGuildTopBarLiveFragment this$0, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ni();
    }

    @JvmStatic
    @NotNull
    public static final QQGuildLiveModuleBaseFragment Th() {
        return INSTANCE.a();
    }

    private final void Uh() {
        ((IGPSService) ch.S0(IGPSService.class, "")).addObserver(this.mGPServiceObserver);
    }

    private final void Vh() {
        com.tencent.mobileqq.guild.live.viewmodel.h hVar = this.mGuildLiveRoomVM;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildLiveRoomVM");
            hVar = null;
        }
        hVar.h2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildTopBarLiveFragment.Wh(QQGuildTopBarLiveFragment.this, (String) obj);
            }
        });
        hVar.g2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildTopBarLiveFragment.Xh(QQGuildTopBarLiveFragment.this, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(QQGuildTopBarLiveFragment this$0, String title) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildAIOTitleBar guildAIOTitleBar = this$0.mTitleBar;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        Intrinsics.checkNotNullExpressionValue(title, "title");
        guildAIOTitleBar.setChannelName(title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(QQGuildTopBarLiveFragment this$0, Void r16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ki();
    }

    private final void Yh() {
        tq1.b t16 = GLiveChannelCore.f226698a.t();
        t16.l().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildTopBarLiveFragment.Zh(QQGuildTopBarLiveFragment.this, (Integer) obj);
            }
        });
        t16.s().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildTopBarLiveFragment.ai(QQGuildTopBarLiveFragment.this, (Boolean) obj);
            }
        });
        t16.e().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildTopBarLiveFragment.bi(QQGuildTopBarLiveFragment.this, (IGProChannelInfo) obj);
            }
        });
        t16.k().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildTopBarLiveFragment.ci(QQGuildTopBarLiveFragment.this, (IGProGuildInfo) obj);
            }
        });
        t16.C().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildTopBarLiveFragment.di(QQGuildTopBarLiveFragment.this, (Boolean) obj);
            }
        });
        t16.p().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildTopBarLiveFragment.ei(QQGuildTopBarLiveFragment.this, (LiveChannelRoomInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(QQGuildTopBarLiveFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(QQGuildTopBarLiveFragment this$0, Boolean select) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(select, "select");
        this$0.si(select.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(QQGuildTopBarLiveFragment this$0, IGProChannelInfo iGProChannelInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ri();
        this$0.ni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(QQGuildTopBarLiveFragment this$0, IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ri();
        this$0.ni();
        GuildAIOTitleBar guildAIOTitleBar = this$0.mTitleBar;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        String guildName = iGProGuildInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "it.guildName");
        guildAIOTitleBar.setGuildName(guildName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(QQGuildTopBarLiveFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (GLiveChannelCore.f226698a.r().a() && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            tx1.a aVar = this$0.mSettingRoleManager;
            boolean z16 = false;
            if (aVar != null && aVar.f()) {
                z16 = true;
            }
            if (!z16) {
                GuildRightIconLayout guildRightIconLayout = this$0.mFloatZoomBtn;
                if (guildRightIconLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFloatZoomBtn");
                    guildRightIconLayout = null;
                }
                guildRightIconLayout.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(QQGuildTopBarLiveFragment this$0, LiveChannelRoomInfo liveChannelRoomInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ni();
    }

    private final void fi(View v3) {
        GuildChannelTitleBarManager guildChannelTitleBarManager = this.mGuildChannelTitleBarManager;
        if (guildChannelTitleBarManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
            guildChannelTitleBarManager = null;
        }
        guildChannelTitleBarManager.t();
    }

    private final void gi() {
        Ih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi() {
        nq1.g gVar = this.mLiveModuleControl;
        if (gVar != null && gVar.a() != null) {
            this.mLiveModuleControl.a().handleZoomFloatWindow(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii() {
        boolean z16;
        tx1.a aVar = this.mSettingRoleManager;
        if (aVar != null) {
            z16 = aVar.f();
        } else {
            z16 = false;
        }
        if (z16) {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            String channelId = gLiveChannelCore.s().getChannelId();
            String guildId = gLiveChannelCore.s().getGuildId();
            IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
            AppRuntime appRuntime = getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            iQQGuildRouterApi.openGuildChannelInfoSetting((AppInterface) appRuntime, getActivity(), guildId, channelId, 2);
        }
    }

    private final void initChannelLoadProxyManager() {
        Bundle bundle;
        if (getContext() != null && getArguments() != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putAll(getArguments());
            Bundle arguments = getArguments();
            if (arguments != null && (bundle = arguments.getBundle(AppConstants.Key.GUILD_EXTRA)) != null) {
                bundle2.putAll(bundle);
            }
            GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            GuildChannelTitleBarManager guildChannelTitleBarManager = new GuildChannelTitleBarManager(requireContext, s16.getGuildId(), s16.getChannelId(), bundle2);
            this.mGuildChannelTitleBarManager = guildChannelTitleBarManager;
            GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
            GuildChannelTitleBarManager guildChannelTitleBarManager2 = null;
            if (guildAIOTitleBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                guildAIOTitleBar = null;
            }
            guildChannelTitleBarManager.z(guildAIOTitleBar);
            GuildChannelTitleBarManager guildChannelTitleBarManager3 = this.mGuildChannelTitleBarManager;
            if (guildChannelTitleBarManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
                guildChannelTitleBarManager3 = null;
            }
            guildChannelTitleBarManager3.y(this);
            GuildChannelTitleBarManager guildChannelTitleBarManager4 = this.mGuildChannelTitleBarManager;
            if (guildChannelTitleBarManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
                guildChannelTitleBarManager4 = null;
            }
            guildChannelTitleBarManager4.A(false);
            GuildChannelTitleBarManager guildChannelTitleBarManager5 = this.mGuildChannelTitleBarManager;
            if (guildChannelTitleBarManager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
                guildChannelTitleBarManager5 = null;
            }
            guildChannelTitleBarManager5.B(false);
            GuildChannelTitleBarManager guildChannelTitleBarManager6 = this.mGuildChannelTitleBarManager;
            if (guildChannelTitleBarManager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
                guildChannelTitleBarManager6 = null;
            }
            guildChannelTitleBarManager6.q();
            GuildChannelTitleBarManager guildChannelTitleBarManager7 = this.mGuildChannelTitleBarManager;
            if (guildChannelTitleBarManager7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
            } else {
                guildChannelTitleBarManager2 = guildChannelTitleBarManager7;
            }
            guildChannelTitleBarManager2.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji(View view) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Kh(view);
            d dVar = new d();
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            boolean V = com.tencent.mobileqq.guild.setting.mute.c.V(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId());
            boolean allowStartLive = gLiveChannelCore.s().getAllowStartLive();
            boolean anchorIsSelf = gLiveChannelCore.s().getAnchorIsSelf();
            boolean isLiving = gLiveChannelCore.s().isLiving();
            String liveRoomName = gLiveChannelCore.s().getLiveRoomName();
            if (liveRoomName == null) {
                liveRoomName = "";
            }
            GuildLiveTopMoreDialogFragment guildLiveTopMoreDialogFragment = new GuildLiveTopMoreDialogFragment(activity, dVar, V, allowStartLive, anchorIsSelf, isLiving, liveRoomName, Jh());
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
            com.tencent.mobileqq.guild.base.extension.d.a(guildLiveTopMoreDialogFragment, supportFragmentManager, "QGL.QQGuildTopBarLiveFragment");
        }
    }

    private final void ki() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
            if (s16.getGuildInfo() != null && s16.getChannelInfo() != null) {
                IGProGuildInfo guildInfo = s16.getGuildInfo();
                Intrinsics.checkNotNull(guildInfo);
                new com.tencent.mobileqq.guild.share.m(activity, guildInfo, s16.getChannelInfo(), GuildSharePageSource.LIVE_CHANNEL).z();
                return;
            }
            QLog.e("QGL.QQGuildTopBarLiveFragment", 1, "onClickShareEvent, data is null, return.");
        }
    }

    private final void li(View clickView) {
        GuildChannelTitleBarManager guildChannelTitleBarManager = this.mGuildChannelTitleBarManager;
        if (guildChannelTitleBarManager != null) {
            if (guildChannelTitleBarManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
                guildChannelTitleBarManager = null;
            }
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            guildChannelTitleBarManager.s(requireActivity);
            VideoReport.setElementId(clickView, "em_sgrp_half_channel");
            VideoReport.setElementExposePolicy(clickView, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(clickView, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("dt_clck", clickView, null);
        }
    }

    private final void mi(View view) {
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        iGuildDTReportApi.setElementExposureAndClickParams(guildAIOTitleBar.D0(), "em_stream_aio_tourist", null);
        IGuildDTReportApi iGuildDTReportApi2 = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        GuildRightIconLayout guildRightIconLayout = this.mRankingListBtn;
        if (guildRightIconLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRankingListBtn");
            guildRightIconLayout = null;
        }
        iGuildDTReportApi2.setElementExposureAndClickParams(guildRightIconLayout, "em_sgrp_contribute_charm_list_entry", null);
        IGuildDTReportApi iGuildDTReportApi3 = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        GuildRightIconLayout guildRightIconLayout2 = this.mShareBtn;
        if (guildRightIconLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout2 = null;
        }
        iGuildDTReportApi3.setElementExposureAndClickParams(guildRightIconLayout2, "em_sgrp_subchannel_top_invite", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.tencent.mobileqq.guild.widget.GuildRightIconLayout] */
    private final void ni() {
        final boolean z16;
        boolean z17;
        int i3;
        tx1.a aVar = this.mSettingRoleManager;
        boolean z18 = false;
        if (aVar != null) {
            z16 = aVar.f();
        } else {
            z16 = false;
        }
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        boolean isLiving = gLiveChannelCore.s().isLiving();
        IGProGuildInfo guildInfo = gLiveChannelCore.s().getGuildInfo();
        if (guildInfo != null && guildInfo.isMember()) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z19 = !z17;
        QLog.i("QGL.QQGuildTopBarLiveFragment", 1, "setVisible isAdmin:" + z16 + " isBroadcasting:" + isLiving + " isGuest:" + z19 + " ");
        Nh().k();
        GuildAIOTitleBar guildAIOTitleBar = null;
        if (z19) {
            if (isLiving) {
                View[] viewArr = new View[1];
                GuildRightIconLayout guildRightIconLayout = this.mFloatZoomBtn;
                if (guildRightIconLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFloatZoomBtn");
                    guildRightIconLayout = null;
                }
                viewArr[0] = guildRightIconLayout;
                Lh(viewArr);
            } else {
                View mRootView = this.C;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                Lh(mRootView);
            }
            GuildRightIconLayout guildRightIconLayout2 = this.mShareBtn;
            if (guildRightIconLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
                guildRightIconLayout2 = null;
            }
            guildRightIconLayout2.setVisibility(0);
            GuildRightIconLayout guildRightIconLayout3 = this.mMoreView;
            if (guildRightIconLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
                guildRightIconLayout3 = null;
            }
            guildRightIconLayout3.setVisibility(8);
            if (Intrinsics.areEqual(gLiveChannelCore.s().getEnterSourceType(), "functional_qq_little_world_feed")) {
                ?? r06 = this.mFloatZoomBtn;
                if (r06 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFloatZoomBtn");
                } else {
                    guildAIOTitleBar = r06;
                }
                guildAIOTitleBar.setVisibility(8);
                return;
            }
            return;
        }
        GuildRightIconLayout guildRightIconLayout4 = this.mShareBtn;
        if (guildRightIconLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout4 = null;
        }
        guildRightIconLayout4.setVisibility(0);
        GuildRightIconLayout guildRightIconLayout5 = this.mMoreView;
        if (guildRightIconLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
            guildRightIconLayout5 = null;
        }
        guildRightIconLayout5.setVisibility(0);
        GuildRightIconLayout guildRightIconLayout6 = this.mFloatZoomBtn;
        if (guildRightIconLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatZoomBtn");
            guildRightIconLayout6 = null;
        }
        if (!isLiving || z16 || Jh() || (gLiveChannelCore.r().a() && gLiveChannelCore.s().getAllowStartLive())) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        guildRightIconLayout6.setVisibility(i3);
        if (Intrinsics.areEqual(gLiveChannelCore.s().getEnterSourceType(), "functional_qq_little_world_feed")) {
            GuildRightIconLayout guildRightIconLayout7 = this.mFloatZoomBtn;
            if (guildRightIconLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFloatZoomBtn");
                guildRightIconLayout7 = null;
            }
            guildRightIconLayout7.setVisibility(8);
        }
        com.tencent.mobileqq.guild.safety.j.b("QGL.QQGuildTopBarLiveFragment", "mHasClickMore: " + this.mHasClickMore + " | startParamsInfo.isLiving(): " + gLiveChannelCore.s().isLiving() + " | guildLiveVideoState: " + gLiveChannelCore.t().l().getValue());
        GuildAIOTitleBar guildAIOTitleBar2 = this.mTitleBar;
        if (guildAIOTitleBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
        } else {
            guildAIOTitleBar = guildAIOTitleBar2;
        }
        pi(guildAIOTitleBar.E0(IconType.THREE_LINES_SETTING));
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Integer value = gLiveChannelCore.t().l().getValue();
        if (value != null && value.intValue() == 2) {
            z18 = true;
        }
        booleanRef.element = z18;
        if (!this.mHasClickMore && this.mMoreBtnBubbleTip != null && !z18) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.l
                @Override // java.lang.Runnable
                public final void run() {
                    QQGuildTopBarLiveFragment.oi(Ref.BooleanRef.this, this, z16);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(Ref.BooleanRef isLandScreen, QQGuildTopBarLiveFragment this$0, boolean z16) {
        boolean z17;
        int i3;
        BubbleView bubbleView;
        GuildRightIconLayout guildRightIconLayout;
        int i16;
        Intrinsics.checkNotNullParameter(isLandScreen, "$isLandScreen");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        Integer value = gLiveChannelCore.t().l().getValue();
        if (value != null && value.intValue() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        isLandScreen.element = z17;
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[setVisible] postDelayed guildLiveVideoState: " + gLiveChannelCore.t().l().getValue());
        GuildRightIconLayout guildRightIconLayout2 = null;
        if (!isLandScreen.element) {
            BubbleView bubbleView2 = this$0.mMoreBtnBubbleTip;
            if (bubbleView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                bubbleView2 = null;
            }
            if (gLiveChannelCore.s().isLiving() && Intrinsics.areEqual(gLiveChannelCore.t().D().getValue(), Boolean.TRUE)) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            bubbleView2.setVisibility(i3);
            BubbleView bubbleView3 = this$0.mMoreBtnBubbleTip;
            if (bubbleView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                bubbleView = null;
            } else {
                bubbleView = bubbleView3;
            }
            GuildRightIconLayout guildRightIconLayout3 = this$0.mMoreView;
            if (guildRightIconLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
                guildRightIconLayout = null;
            } else {
                guildRightIconLayout = guildRightIconLayout3;
            }
            if (z16) {
                i16 = 0;
            } else {
                i16 = 2;
            }
            BubbleView.k(bubbleView, guildRightIconLayout, 0, i16, 2, null);
            return;
        }
        BubbleView bubbleView4 = this$0.mMoreBtnBubbleTip;
        if (bubbleView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
            bubbleView4 = null;
        }
        bubbleView4.setVisibility(8);
        BubbleView bubbleView5 = this$0.mMoreBtnBubbleTip;
        if (bubbleView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
            bubbleView5 = null;
        }
        GuildRightIconLayout guildRightIconLayout4 = this$0.mMoreView;
        if (guildRightIconLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
        } else {
            guildRightIconLayout2 = guildRightIconLayout4;
        }
        bubbleView5.e(guildRightIconLayout2);
    }

    private final void pi(View moreView) {
        Context context;
        if (this.mSettingRoleManager != null && !this.mHasClickMore && this.mMoreBtnBubbleTip == null && moreView != null && moreView.getVisibility() == 0 && (context = getContext()) != null) {
            Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[showBubbleIfNeeded] ");
            int i3 = 0;
            BubbleView.b c16 = com.tencent.mobileqq.guild.widget.d.c(BubbleView.INSTANCE.b(context), 0);
            tx1.a aVar = this.mSettingRoleManager;
            Intrinsics.checkNotNull(aVar);
            if (!aVar.f()) {
                i3 = 2;
            }
            this.mMoreBtnBubbleTip = com.tencent.mobileqq.guild.widget.d.d(com.tencent.mobileqq.guild.widget.d.a(com.tencent.mobileqq.guild.widget.d.e(com.tencent.mobileqq.guild.widget.d.b(c16, i3), R.layout.exb), getResources().getColor(R.color.bry)), moreView);
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            if (!gLiveChannelCore.s().isLiving() || !Intrinsics.areEqual(gLiveChannelCore.t().D().getValue(), Boolean.TRUE)) {
                BubbleView bubbleView = this.mMoreBtnBubbleTip;
                if (bubbleView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                    bubbleView = null;
                }
                bubbleView.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi() {
        int i3;
        if (getContext() == null || Mh().isShowing()) {
            return;
        }
        ViewGroup rootView = Mh().getRootView();
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        guildDTReportApiImpl.setElementExposureAndClickParams(rootView.findViewById(R.id.dialogLeftBtn), "em_stream_aio_cancel", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(rootView.findViewById(R.id.dialogRightBtn), "em_stream_aio_end", null);
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
        if (channelInfo != null) {
            HashMap<String, Object> b16 = new z().b();
            VideoReport.setPageId(rootView, "pg_sgrp_stream_aio_pop");
            guildDTReportApiImpl.setChannelPageParams(rootView, channelInfo, b16);
        } else {
            QLog.e("QGL.QQGuildTopBarLiveFragment", 1, "showEndLiveDialogIfNeed, data is null, ignore report.");
        }
        this.mDialogRootView = rootView;
        View findViewById = rootView.findViewById(R.id.dialogText);
        if (findViewById != null) {
            if (gLiveChannelCore.r().d()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
        Mh().show();
    }

    private final void ri() {
        IGProGuildInfo guildInfo = GLiveChannelCore.f226698a.s().getGuildInfo();
        if (guildInfo == null) {
            QLog.d("QGL.QQGuildTopBarLiveFragment", 1, "getGuildInfo null");
            return;
        }
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        o.a(guildAIOTitleBar, guildInfo);
    }

    private final void si(boolean select) {
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        GuildAIOTitleBar guildAIOTitleBar2 = null;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        guildAIOTitleBar.setRightButtonVisibility(select);
        GuildAIOTitleBar guildAIOTitleBar3 = this.mTitleBar;
        if (guildAIOTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar3 = null;
        }
        guildAIOTitleBar3.setRightIconContainerVisibility(!select);
        if (ch.j0(GLiveChannelCore.f226698a.s().getGuildId())) {
            GuildAIOTitleBar guildAIOTitleBar4 = this.mTitleBar;
            if (guildAIOTitleBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            } else {
                guildAIOTitleBar2 = guildAIOTitleBar4;
            }
            guildAIOTitleBar2.setJoinButtonVisibility(!select);
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.frame.titlebar.g
    public void H5(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
    }

    public final void Qh(@Nullable Integer state) {
        boolean z16;
        BubbleView bubbleView;
        boolean z17 = true;
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[handleScreenVideoStateChanged] state " + state);
        if (state != null && state.intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        GuildRightIconLayout guildRightIconLayout = null;
        if (z16) {
            GuildRightIconLayout guildRightIconLayout2 = this.mVerticalToScaleBtn;
            if (guildRightIconLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVerticalToScaleBtn");
                guildRightIconLayout2 = null;
            }
            guildRightIconLayout2.setVisibility(0);
        } else {
            GuildRightIconLayout guildRightIconLayout3 = this.mVerticalToScaleBtn;
            if (guildRightIconLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVerticalToScaleBtn");
                guildRightIconLayout3 = null;
            }
            guildRightIconLayout3.setVisibility(8);
        }
        if (!z16 && (state == null || state.intValue() != 2)) {
            z17 = false;
        }
        if (z17 && (bubbleView = this.mMoreBtnBubbleTip) != null) {
            if (bubbleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                bubbleView = null;
            }
            GuildRightIconLayout guildRightIconLayout4 = this.mMoreView;
            if (guildRightIconLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
            } else {
                guildRightIconLayout = guildRightIconLayout4;
            }
            bubbleView.e(guildRightIconLayout);
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.frame.titlebar.g
    @NotNull
    public JumpGuildParam.JoinInfoParam T3() {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        Bundle bundle;
        Bundle arguments = getArguments();
        if (arguments != null && (bundle = arguments.getBundle(AppConstants.Key.GUILD_EXTRA)) != null) {
            joinInfoParam = (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        } else {
            joinInfoParam = null;
        }
        if (joinInfoParam == null) {
            return new JumpGuildParam.JoinInfoParam();
        }
        return joinInfoParam;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.exc;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected void initLiveDataObserver() {
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[initLiveDataObserver] ");
        Vh();
        Yh();
        initChannelLoadProxyManager();
        Rh();
        Uh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        List<? extends IconType> listOf;
        List<? extends View> listOf2;
        List listOf3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[initView] ");
        com.tencent.mobileqq.guild.live.livemanager.e showHideAnimHelper = getShowHideAnimHelper();
        if (showHideAnimHelper != null) {
            showHideAnimHelper.o(this.C, "QGL.QQGuildTopBarLiveFragment");
        }
        com.tencent.mobileqq.guild.live.livemanager.e showHideAnimHelper2 = getShowHideAnimHelper();
        if (showHideAnimHelper2 != null) {
            showHideAnimHelper2.j(this.C, "QGL.QQGuildTopBarLiveFragment");
        }
        View findViewById = view.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title_bar)");
        GuildAIOTitleBar guildAIOTitleBar = (GuildAIOTitleBar) findViewById;
        this.mTitleBar = guildAIOTitleBar;
        GuildRightIconLayout guildRightIconLayout = null;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        guildAIOTitleBar.setTitleBarClickListener(this);
        GuildAIOTitleBar guildAIOTitleBar2 = this.mTitleBar;
        if (guildAIOTitleBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar2 = null;
        }
        guildAIOTitleBar2.setLeftIconType(IconType.BACK);
        GuildAIOTitleBar guildAIOTitleBar3 = this.mTitleBar;
        if (guildAIOTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar3 = null;
        }
        IconType iconType = IconType.RANKING_LIST;
        IconType iconType2 = IconType.MINIMIZE_SCREEN;
        IconType iconType3 = IconType.SHARE;
        IconType iconType4 = IconType.FULL_SCREEN;
        IconType iconType5 = IconType.THREE_LINES_SETTING;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IconType[]{iconType, iconType2, iconType3, iconType4, iconType5});
        guildAIOTitleBar3.setRightIcons(listOf);
        GuildAIOTitleBar guildAIOTitleBar4 = this.mTitleBar;
        if (guildAIOTitleBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar4 = null;
        }
        GuildRightIconLayout E0 = guildAIOTitleBar4.E0(iconType);
        Intrinsics.checkNotNull(E0);
        this.mRankingListBtn = E0;
        GuildAIOTitleBar guildAIOTitleBar5 = this.mTitleBar;
        if (guildAIOTitleBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar5 = null;
        }
        GuildRightIconLayout E02 = guildAIOTitleBar5.E0(iconType2);
        Intrinsics.checkNotNull(E02);
        this.mFloatZoomBtn = E02;
        GuildAIOTitleBar guildAIOTitleBar6 = this.mTitleBar;
        if (guildAIOTitleBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar6 = null;
        }
        GuildRightIconLayout E03 = guildAIOTitleBar6.E0(iconType4);
        Intrinsics.checkNotNull(E03);
        this.mVerticalToScaleBtn = E03;
        GuildAIOTitleBar guildAIOTitleBar7 = this.mTitleBar;
        if (guildAIOTitleBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar7 = null;
        }
        GuildRightIconLayout E04 = guildAIOTitleBar7.E0(iconType3);
        Intrinsics.checkNotNull(E04);
        this.mShareBtn = E04;
        GuildAIOTitleBar guildAIOTitleBar8 = this.mTitleBar;
        if (guildAIOTitleBar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar8 = null;
        }
        GuildRightIconLayout E05 = guildAIOTitleBar8.E0(iconType5);
        Intrinsics.checkNotNull(E05);
        this.mMoreView = E05;
        GuildRightIconLayout guildRightIconLayout2 = this.mFloatZoomBtn;
        if (guildRightIconLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatZoomBtn");
            guildRightIconLayout2 = null;
        }
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(guildRightIconLayout2);
        this.mAllCtlView = listOf2;
        GuildRightIconLayout guildRightIconLayout3 = this.mVerticalToScaleBtn;
        if (guildRightIconLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVerticalToScaleBtn");
            guildRightIconLayout3 = null;
        }
        guildRightIconLayout3.setTag("mVerticalToScaleBtn");
        GuildRightIconLayout[] guildRightIconLayoutArr = new GuildRightIconLayout[4];
        GuildRightIconLayout guildRightIconLayout4 = this.mFloatZoomBtn;
        if (guildRightIconLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatZoomBtn");
            guildRightIconLayout4 = null;
        }
        guildRightIconLayoutArr[0] = guildRightIconLayout4;
        GuildRightIconLayout guildRightIconLayout5 = this.mVerticalToScaleBtn;
        if (guildRightIconLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVerticalToScaleBtn");
            guildRightIconLayout5 = null;
        }
        guildRightIconLayoutArr[1] = guildRightIconLayout5;
        GuildRightIconLayout guildRightIconLayout6 = this.mShareBtn;
        if (guildRightIconLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            guildRightIconLayout6 = null;
        }
        guildRightIconLayoutArr[2] = guildRightIconLayout6;
        GuildRightIconLayout guildRightIconLayout7 = this.mMoreView;
        if (guildRightIconLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
        } else {
            guildRightIconLayout = guildRightIconLayout7;
        }
        guildRightIconLayoutArr[3] = guildRightIconLayout;
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) guildRightIconLayoutArr);
        Iterator it = listOf3.iterator();
        while (it.hasNext()) {
            ((GuildRightIconLayout) it.next()).setVisibility(8);
        }
        mi(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initViewModel() {
        this.mGuildLiveRoomVM = (com.tencent.mobileqq.guild.live.viewmodel.h) GLiveChannelCore.f226698a.q(com.tencent.mobileqq.guild.live.viewmodel.h.class);
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[initViewModel] ");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[onAttach] ");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (gLiveChannelCore.t().m() == 1) {
            gLiveChannelCore.t().b0(0);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        BubbleView bubbleView;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[onConfigurationChanged] ");
        if (AppSetting.t(getContext()) && (bubbleView = this.mMoreBtnBubbleTip) != null) {
            GuildRightIconLayout guildRightIconLayout = null;
            if (bubbleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                bubbleView = null;
            }
            GuildRightIconLayout guildRightIconLayout2 = this.mMoreView;
            if (guildRightIconLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
            } else {
                guildRightIconLayout = guildRightIconLayout2;
            }
            bubbleView.e(guildRightIconLayout);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[onDestroy] ");
        GuildChannelTitleBarManager guildChannelTitleBarManager = null;
        if (this.mMoreBtnBubbleTip != null) {
            if (this.mMoreView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
            }
            BubbleView bubbleView = this.mMoreBtnBubbleTip;
            if (bubbleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                bubbleView = null;
            }
            bubbleView.clearAnimation();
            BubbleView bubbleView2 = this.mMoreBtnBubbleTip;
            if (bubbleView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                bubbleView2 = null;
            }
            ViewExtKt.a(bubbleView2);
        }
        com.tencent.mobileqq.guild.live.livemanager.e showHideAnimHelper = getShowHideAnimHelper();
        if (showHideAnimHelper != null) {
            showHideAnimHelper.M(this.C, "topBarLiveRootView");
        }
        com.tencent.mobileqq.guild.live.livemanager.e showHideAnimHelper2 = getShowHideAnimHelper();
        if (showHideAnimHelper2 != null) {
            showHideAnimHelper2.K(this.C, "topBarLiveRootView");
        }
        com.tencent.mobileqq.guild.live.livemanager.e showHideAnimHelper3 = getShowHideAnimHelper();
        if (showHideAnimHelper3 != null) {
            showHideAnimHelper3.K(this.C, "topBarLiveRootView");
        }
        ((IGPSService) ch.S0(IGPSService.class, "")).deleteObserver(this.mGPServiceObserver);
        super.onDestroy();
        tx1.a aVar = this.mSettingRoleManager;
        if (aVar != null) {
            aVar.l();
        }
        GuildChannelTitleBarManager guildChannelTitleBarManager2 = this.mGuildChannelTitleBarManager;
        if (guildChannelTitleBarManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
        } else {
            guildChannelTitleBarManager = guildChannelTitleBarManager2;
        }
        guildChannelTitleBarManager.r();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        BubbleView bubbleView = this.mMoreBtnBubbleTip;
        if (bubbleView != null) {
            BubbleView bubbleView2 = null;
            if (bubbleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
                bubbleView = null;
            }
            bubbleView.clearAnimation();
            BubbleView bubbleView3 = this.mMoreBtnBubbleTip;
            if (bubbleView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMoreBtnBubbleTip");
            } else {
                bubbleView2 = bubbleView3;
            }
            ViewExtKt.a(bubbleView2);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.module.topbar.QQGuildLiveBaseTopBarFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[onDetach] ");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[onNewIntent] ");
        if (this.mGuildChannelTitleBarManager != null && intent != null && intent.getExtras() != null) {
            Bundle bundle = new Bundle(intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA));
            GuildChannelTitleBarManager guildChannelTitleBarManager = this.mGuildChannelTitleBarManager;
            if (guildChannelTitleBarManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
                guildChannelTitleBarManager = null;
            }
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            guildChannelTitleBarManager.C(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId(), bundle);
        }
        tx1.a aVar = this.mSettingRoleManager;
        if (aVar != null) {
            aVar.o(GLiveChannelCore.f226698a.s().getChannelInfo());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[onPause] ");
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        GuildChannelTitleBarManager guildChannelTitleBarManager = null;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        guildAIOTitleBar.H0();
        GuildChannelTitleBarManager guildChannelTitleBarManager2 = this.mGuildChannelTitleBarManager;
        if (guildChannelTitleBarManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildChannelTitleBarManager");
        } else {
            guildChannelTitleBarManager = guildChannelTitleBarManager2;
        }
        guildChannelTitleBarManager.v();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.f235387a.d().d("QGL.QQGuildTopBarLiveFragment", 1, "[onResume] ");
        GuildAIOTitleBar guildAIOTitleBar = this.mTitleBar;
        if (guildAIOTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildAIOTitleBar = null;
        }
        guildAIOTitleBar.G0();
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
    }

    @Override // com.tencent.mobileqq.guild.widget.ah
    public void u2(@NotNull ClickType clickType, @NotNull View v3) {
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        Intrinsics.checkNotNullParameter(v3, "v");
        switch (b.f226636a[clickType.ordinal()]) {
            case 1:
            case 2:
                gi();
                return;
            case 3:
                hi();
                return;
            case 4:
                if (getActivity() != null) {
                    Ih();
                    si(false);
                    return;
                }
                return;
            case 5:
                ji(v3);
                return;
            case 6:
                li(v3);
                return;
            case 7:
                ki();
                return;
            case 8:
                fi(v3);
                return;
            case 9:
                Ph();
                return;
            default:
                return;
        }
    }
}
