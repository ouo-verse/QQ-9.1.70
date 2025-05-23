package com.tencent.mobileqq.guild.media.thirdapp.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.ViewKt;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.livemanager.player.l;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.media.widget.GuildMediaMemberListView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0004\u0084\u0001\u0088\u0001\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B\u0015\b\u0016\u0012\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001B!\b\u0016\u0012\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001\u0012\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001\u00a2\u0006\u0006\b\u008e\u0001\u0010\u0092\u0001B*\b\u0016\u0012\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001\u0012\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001\u0012\u0007\u0010\u0093\u0001\u001a\u00020\u001b\u00a2\u0006\u0006\b\u008e\u0001\u0010\u0094\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J$\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J\u0016\u0010-\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001bH\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\u0012\u00106\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000104H\u0014J\u0012\u00108\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u000107H\u0016R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010C\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010I\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010BR\u0014\u0010K\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0014\u0010[\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010VR\u0014\u0010]\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010BR\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010NR\u0014\u0010e\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010NR\u0014\u0010g\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010VR\u0014\u0010i\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010`R\u0016\u0010k\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010_R\u0016\u0010m\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010_R\u0016\u0010o\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010_R\u0016\u0010r\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010_R\u0016\u0010v\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010?R\u0018\u0010y\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010qR\u0016\u0010}\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010qR\u0016\u0010\u007f\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010_R\u0018\u0010\u0081\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010_R\u0018\u0010\u0083\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010?R\u0018\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppNormalContentView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/f;", "Landroid/view/View$OnClickListener;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "show", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "y", "fromPreview", "o", "v", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "w", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "l", "c", "", "d", "width", "height", "setThirdAppSize", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyAppInfo;", "appInfo", "setThirdAppInfo", "Lcom/tencent/mobileqq/guild/media/thirdapp/e;", "appPreloadInfo", "setThirdAppPreloadInfo", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/g;", "listener", "setThirdAppClickListener", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "userList", "setActiveUserInfo", "setPortraitFullUI", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, "setResetUI", "setLandFullUI", "setHorizontalMarginGone", "a", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/View;", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", "livePlayerManager", "e", "Z", "mUserListViewInit", "f", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMemberListView;", h.F, "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaMemberListView;", "mUserLayout", "i", "mThirdAppLayout", "Landroid/widget/FrameLayout;", "mAppContentLayout", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "mThirdAppInfoLayout", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppInfoBar;", "D", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppInfoBar;", "mThirdAppInfoBar", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mThirdAppCloseBtn", UserInfo.SEX_FEMALE, "mThirdAppZoomInBtn", "G", "mThirdAppToLandBtn", "H", "mContentLoadingView", "Lcom/airbnb/lottie/LottieAnimationView;", "I", "Lcom/airbnb/lottie/LottieAnimationView;", "mThirdAppAnimView", "J", "mContentLoadingLayout", "K", "mLoadingIntroduceContainer", "L", "mLoadingIntroduceImg", "M", "mLoadingIntroduceAnimView", "N", "mLoadingIntroduceWidth", "P", "mLoadingIntroduceHeight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mLoadingIntroduceContentHeight", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "mCurrentLoadingUrl", ExifInterface.LATITUDE_SOUTH, "mCurrentLoadingType", "T", "needShowLoadingIntroduce", "U", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/g;", "mThirdAppClickListener", "V", "mCurrentThirdAppId", "W", "mCurrentThirdAppName", "a0", "mAppContainerWidth", "b0", "mAppContainerHeight", "c0", "mIsFullScreenMode", "com/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppNormalContentView$b", "d0", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppNormalContentView$b;", "mMediaObserver", "com/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppNormalContentView$c", "e0", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppNormalContentView$c;", "observer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f0", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaThirdAppNormalContentView extends FrameLayout implements f, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mThirdAppInfoLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GuildMediaThirdAppInfoBar mThirdAppInfoBar;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView mThirdAppCloseBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView mThirdAppZoomInBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView mThirdAppToLandBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final View mContentLoadingView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LottieAnimationView mThirdAppAnimView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mContentLoadingLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mLoadingIntroduceContainer;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final ImageView mLoadingIntroduceImg;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LottieAnimationView mLoadingIntroduceAnimView;

    /* renamed from: N, reason: from kotlin metadata */
    private int mLoadingIntroduceWidth;

    /* renamed from: P, reason: from kotlin metadata */
    private int mLoadingIntroduceHeight;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mLoadingIntroduceContentHeight;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String mCurrentLoadingUrl;

    /* renamed from: S, reason: from kotlin metadata */
    private int mCurrentLoadingType;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean needShowLoadingIntroduce;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private g mThirdAppClickListener;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String mCurrentThirdAppId;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String mCurrentThirdAppName;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int mAppContainerWidth;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int mAppContainerHeight;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy livePlayerManager;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mMediaObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mUserListViewInit;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c observer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaMemberListView mUserLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mThirdAppLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout mAppContentLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppNormalContentView$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void i() {
            QLog.i("GuildMediaThirdAppNormalSubView", 1, "onUserListFirstFetched:");
            GuildMediaThirdAppNormalContentView.p(GuildMediaThirdAppNormalContentView.this, false, 1, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\"\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppNormalContentView$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "guildId", "onGuildInfoUpdated", "", "channelIdList", "onChannelUserPermissionChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            QLog.i("GuildMediaThirdAppNormalSubView", 1, "onChannelInfoUpdated:");
            GuildMediaThirdAppNormalContentView.this.v();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelUserPermissionChanged(@Nullable String guildId, @Nullable List<String> channelIdList) {
            super.onChannelUserPermissionChanged(guildId, channelIdList);
            QLog.i("GuildMediaThirdAppNormalSubView", 1, "onChannelUserPermissionChanged:");
            GuildMediaThirdAppNormalContentView.this.v();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            QLog.i("GuildMediaThirdAppNormalSubView", 1, "onGuildInfoUpdated:");
            GuildMediaThirdAppNormalContentView.this.v();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppNormalContentView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) GuildMediaThirdAppNormalContentView$livePlayerManager$2.INSTANCE);
        this.livePlayerManager = lazy;
        View inflate = View.inflate(getContext(), R.layout.eyd, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026rd_app_normal_view, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f96745ii);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026ird_app_user_grid_layout)");
        this.mUserLayout = (GuildMediaMemberListView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f96635i8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.third_app_layout)");
        this.mThirdAppLayout = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f96645i9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026third_app_load_container)");
        this.mAppContentLayout = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f96585i3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.third_app_info_layout)");
        this.mThirdAppInfoLayout = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f96555i0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.third_app_info)");
        this.mThirdAppInfoBar = (GuildMediaThirdAppInfoBar) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f96505hv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.third_app_close)");
        this.mThirdAppCloseBtn = (ImageView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f96755ij);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.third_app_zoom_in)");
        this.mThirdAppZoomInBtn = (ImageView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f96735ih);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.third_app_to_land)");
        this.mThirdAppToLandBtn = (ImageView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f96655i_);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.third_app_loading)");
        this.mContentLoadingView = findViewById9;
        View findViewById10 = inflate.findViewById(R.id.f96675ib);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R\u2026p_loading_animation_view)");
        this.mThirdAppAnimView = (LottieAnimationView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.f96665ia);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R\u2026ding_animation_container)");
        this.mContentLoadingLayout = (LinearLayout) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.f96695id);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R\u2026ding_introduce_container)");
        this.mLoadingIntroduceContainer = (LinearLayout) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.f96705ie);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R\u2026pp_loading_introduce_img)");
        this.mLoadingIntroduceImg = (ImageView) findViewById13;
        View findViewById14 = inflate.findViewById(R.id.f96685ic);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R\u2026introduce_animation_view)");
        this.mLoadingIntroduceAnimView = (LottieAnimationView) findViewById14;
        this.mCurrentLoadingUrl = "";
        this.mCurrentLoadingType = -1;
        this.mCurrentThirdAppId = "";
        this.mCurrentThirdAppName = "";
        this.mMediaObserver = new b();
        this.observer = new c();
    }

    private final void A() {
        ViewGroup.LayoutParams layoutParams = this.mContentLoadingView.getLayoutParams();
        layoutParams.height = this.mAppContainerHeight;
        this.mContentLoadingView.setLayoutParams(layoutParams);
        int i3 = this.mAppContainerWidth;
        this.mLoadingIntroduceWidth = i3;
        this.mLoadingIntroduceHeight = ((int) (i3 * 0.5625f)) + x.c(BaseApplication.getContext(), 60.0f);
        this.mLoadingIntroduceContentHeight = (int) (this.mLoadingIntroduceWidth * 0.5625f);
        ViewGroup.LayoutParams layoutParams2 = this.mLoadingIntroduceContainer.getLayoutParams();
        layoutParams2.width = this.mLoadingIntroduceWidth;
        layoutParams2.height = this.mLoadingIntroduceHeight;
        this.mLoadingIntroduceContainer.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.mLoadingIntroduceImg.getLayoutParams();
        layoutParams3.height = this.mLoadingIntroduceContentHeight;
        this.mLoadingIntroduceImg.setLayoutParams(layoutParams3);
    }

    private final HashMap<String, Object> l() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_appid", this.mCurrentThirdAppId);
        hashMap.put("sgrp_app_name", this.mCurrentThirdAppName);
        return hashMap;
    }

    private final l m() {
        return (l) this.livePlayerManager.getValue();
    }

    private final void n(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo, boolean fromPreview) {
        this.mUserLayout.i0(new com.tencent.mobileqq.guild.media.widget.user.adapter.c(ViewKt.findFragment(this)), fromPreview);
        this.mUserLayout.c0();
        this.mUserLayout.j0("GuildMediaThirdAppNormalSubView");
    }

    private final void o(boolean fromPreview) {
        IGProGuildInfo M = ch.M(j.a().getGuildID());
        IGProChannelInfo C = ch.C(ch.m(), j.a().getGuildID(), j.a().E());
        if (M != null && C != null) {
            if (this.mUserListViewInit) {
                Logger.f235387a.d().i("GuildMediaThirdAppNormalSubView", 1, "initUserListLayout: has been Invoked");
                return;
            } else {
                this.mUserListViewInit = true;
                n(M, C, fromPreview);
                return;
            }
        }
        QLog.i("GuildMediaThirdAppNormalSubView", 1, "initUserListLayout: guild info or channel info is empty.");
    }

    static /* synthetic */ void p(GuildMediaThirdAppNormalContentView guildMediaThirdAppNormalContentView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildMediaThirdAppNormalContentView.o(z16);
    }

    private final void q() {
        com.tencent.mobileqq.guild.api.impl.e.c(this.mThirdAppCloseBtn, "em_sgrp_app_close");
        ImageView imageView = this.mThirdAppCloseBtn;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(imageView, endExposurePolicy);
        ImageView imageView2 = this.mThirdAppCloseBtn;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(imageView2, clickPolicy);
        VideoReport.setEventDynamicParams(this.mThirdAppCloseBtn, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.b
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map r16;
                r16 = GuildMediaThirdAppNormalContentView.r(GuildMediaThirdAppNormalContentView.this, str);
                return r16;
            }
        });
        com.tencent.mobileqq.guild.api.impl.e.c(this.mThirdAppInfoBar, "em_sgrp_appname_webview");
        VideoReport.setElementEndExposePolicy(this.mThirdAppInfoBar, endExposurePolicy);
        VideoReport.setElementClickPolicy(this.mThirdAppInfoBar, clickPolicy);
        VideoReport.setEventDynamicParams(this.mThirdAppInfoBar, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.c
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map s16;
                s16 = GuildMediaThirdAppNormalContentView.s(GuildMediaThirdAppNormalContentView.this, str);
                return s16;
            }
        });
        ImageView imageView3 = this.mThirdAppToLandBtn;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.T0(imageView3, "em_sgrp_avchannel_switchpicture", clickPolicy, exposurePolicy, new HashMap());
        VideoReport.setEventDynamicParams(this.mThirdAppToLandBtn, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map t16;
                t16 = GuildMediaThirdAppNormalContentView.t(GuildMediaThirdAppNormalContentView.this, str);
                return t16;
            }
        });
        ch.T0(this.mThirdAppZoomInBtn, "em_sgrp_avchannel_transfer_gridpage", clickPolicy, exposurePolicy, new HashMap());
        VideoReport.setEventDynamicParams(this.mThirdAppZoomInBtn, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.e
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map u16;
                u16 = GuildMediaThirdAppNormalContentView.u(GuildMediaThirdAppNormalContentView.this, str);
                return u16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map r(GuildMediaThirdAppNormalContentView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map s(GuildMediaThirdAppNormalContentView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map t(GuildMediaThirdAppNormalContentView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, Object> l3 = this$0.l();
        l3.put("sgrp_avchannel_app_window_status", 1);
        return l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map u(GuildMediaThirdAppNormalContentView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, Object> l3 = this$0.l();
        l3.put("sgrp_avchannel_app_window_status", 1);
        return l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        IGProGuildInfo M = ch.M(j.a().getGuildID());
        IGProChannelInfo C = ch.C(ch.m(), j.a().getGuildID(), j.a().E());
        if (M != null && C != null) {
            w(M, C);
        } else {
            QLog.i("GuildMediaThirdAppNormalSubView", 1, "initView: guild info or channel info is empty.");
        }
    }

    private final void w(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        boolean z16;
        this.mThirdAppCloseBtn.setOnClickListener(this);
        if (this.mIsFullScreenMode) {
            this.mThirdAppCloseBtn.setVisibility(8);
            return;
        }
        if (!ch.t0(guildInfo) && !channelInfo.isChannelOrCategoryAdmin()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.mThirdAppCloseBtn.setVisibility(0);
        } else {
            CorountineFunKt.e(MediaChannelCore.INSTANCE.a().getCoroutineScope(), "setThirdAppCloseBtn", null, null, null, new GuildMediaThirdAppNormalContentView$setThirdAppCloseBtn$1(guildInfo, channelInfo, this, null), 14, null);
        }
    }

    private final void x() {
        this.mLoadingIntroduceImg.setVisibility(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mRequestWidth = this.mLoadingIntroduceWidth;
        obtain.mRequestHeight = this.mLoadingIntroduceContentHeight;
        obtain.mLoadingDrawable = new ColorDrawable(-14869216);
        URLDrawable drawable = URLDrawable.getDrawable(this.mCurrentLoadingUrl, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(mCurrentLoadingUrl, options)");
        this.mLoadingIntroduceImg.setImageDrawable(drawable);
    }

    private final void y() {
        this.mLoadingIntroduceImg.setVisibility(8);
        View a16 = l.a.a(m(), this.mCurrentLoadingUrl, GuildLivePlayerTag.GUILD_THIRD_APP_LOADING, 0, false, true, 12, null);
        ViewGroup.LayoutParams layoutParams = a16.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.mLoadingIntroduceContentHeight;
        }
        if (layoutParams != null) {
            layoutParams.width = this.mLoadingIntroduceWidth;
        }
        a16.setLayoutParams(layoutParams);
        this.mLoadingIntroduceContainer.addView(a16, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(boolean show) {
        int i3;
        int i16;
        View view = this.mContentLoadingView;
        int i17 = 8;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (show) {
            com.tencent.mobileqq.g.f211804a = false;
            LinearLayout linearLayout = this.mContentLoadingLayout;
            if (this.needShowLoadingIntroduce) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            linearLayout.setVisibility(i16);
            LinearLayout linearLayout2 = this.mLoadingIntroduceContainer;
            if (this.needShowLoadingIntroduce) {
                i17 = 0;
            }
            linearLayout2.setVisibility(i17);
            if (this.needShowLoadingIntroduce) {
                this.mLoadingIntroduceAnimView.setAnimationFromUrl("https://downv6.qq.com/innovate/guild/lotties/playtogether.json");
                this.mLoadingIntroduceAnimView.setRepeatCount(-1);
                this.mLoadingIntroduceAnimView.playAnimation();
                if (this.mCurrentLoadingType == 0) {
                    x();
                    return;
                } else {
                    y();
                    return;
                }
            }
            this.mThirdAppAnimView.setAnimationFromUrl("https://downv6.qq.com/innovate/guild/lotties/playtogether.json");
            this.mThirdAppAnimView.setRepeatCount(-1);
            this.mThirdAppAnimView.playAnimation();
            return;
        }
        if (this.needShowLoadingIntroduce) {
            m().b(GuildLivePlayerTag.GUILD_THIRD_APP_LOADING);
            this.mLoadingIntroduceAnimView.cancelAnimation();
        } else {
            this.mThirdAppAnimView.cancelAnimation();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void a() {
        j.a().l0().B(this.mMediaObserver);
        ((IGPSService) ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
        this.mUserLayout.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void b(boolean show) {
        if (!show) {
            z(false);
        } else {
            GuildMediaWebIPCServer.INSTANCE.a().i(j.a().d0().E1(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppNormalContentView$showThirdAppLoadingView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    GuildMediaThirdAppNormalContentView.this.z(!z16);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void c() {
        q();
        j.a().l0().b(this.mMediaObserver);
        ((IGPSService) ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
        v();
        setResetUI(0);
        if (j.a().I0().getListFetched()) {
            Intrinsics.checkNotNullExpressionValue(j.c().getUserInfoList().f228125a, "getDataHub().userInfoList.anchors");
            if (!r1.isEmpty()) {
                QLog.i("GuildMediaThirdAppNormalSubView", 1, "[onChatSubViewCreated] init user view directly");
                p(this, false, 1, null);
                return;
            }
        }
        if (!MediaChannelCore.INSTANCE.a().o0().getStartParams().getPreviewData().e().isEmpty()) {
            Logger.f235387a.d().i("GuildMediaThirdAppNormalSubView", 1, "[onChatSubViewCreated] init with preview data");
            o(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public int d() {
        return R.id.f96645i9;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        g gVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && !o.a(v3)) {
            if (Intrinsics.areEqual(v3, this.mThirdAppCloseBtn)) {
                g gVar2 = this.mThirdAppClickListener;
                if (gVar2 != null) {
                    gVar2.C7();
                }
            } else if (Intrinsics.areEqual(v3, this.mThirdAppZoomInBtn)) {
                g gVar3 = this.mThirdAppClickListener;
                if (gVar3 != null) {
                    gVar3.tg();
                }
            } else if (Intrinsics.areEqual(v3, this.mThirdAppToLandBtn) && (gVar = this.mThirdAppClickListener) != null) {
                gVar.L3();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        v();
    }

    public void setActiveUserInfo(@NotNull List<? extends p> userList) {
        Intrinsics.checkNotNullParameter(userList, "userList");
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void setHorizontalMarginGone() {
        ViewGroup.LayoutParams layoutParams = this.mThirdAppLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.rightMargin = 0;
        this.mThirdAppLayout.setLayoutParams(marginLayoutParams);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void setLandFullUI() {
        this.mIsFullScreenMode = true;
        this.mUserLayout.setVisibility(8);
        this.mThirdAppInfoLayout.setVisibility(8);
        this.mThirdAppZoomInBtn.setVisibility(8);
        this.mThirdAppToLandBtn.setVisibility(8);
        this.mThirdAppInfoBar.setVisibility(8);
        this.mThirdAppCloseBtn.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void setPortraitFullUI() {
        this.mIsFullScreenMode = true;
        this.mThirdAppInfoLayout.setVisibility(8);
        this.mThirdAppZoomInBtn.setVisibility(8);
        this.mThirdAppToLandBtn.setVisibility(8);
        this.mThirdAppInfoBar.setVisibility(8);
        this.mUserLayout.setVisibility(8);
        this.mThirdAppCloseBtn.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void setResetUI(int screenMode) {
        this.mIsFullScreenMode = false;
        if (screenMode != 0) {
            if (screenMode != 1) {
                if (screenMode != 2) {
                    if (screenMode == 3) {
                        this.mThirdAppZoomInBtn.setVisibility(0);
                        this.mThirdAppToLandBtn.setVisibility(0);
                    }
                } else {
                    this.mThirdAppZoomInBtn.setVisibility(8);
                    this.mThirdAppToLandBtn.setVisibility(0);
                }
            } else {
                this.mThirdAppZoomInBtn.setVisibility(0);
                this.mThirdAppToLandBtn.setVisibility(8);
            }
        } else {
            this.mThirdAppZoomInBtn.setVisibility(8);
            this.mThirdAppToLandBtn.setVisibility(8);
        }
        this.mThirdAppInfoLayout.setVisibility(0);
        this.mThirdAppInfoBar.setVisibility(0);
        this.mUserLayout.setVisibility(0);
        this.mThirdAppZoomInBtn.setOnClickListener(this);
        this.mThirdAppToLandBtn.setOnClickListener(this);
        v();
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void setThirdAppClickListener(@NotNull g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mThirdAppClickListener = listener;
        this.mThirdAppInfoBar.setThirdAppClickListener(listener);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void setThirdAppInfo(@NotNull IGProLobbyAppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        String appId = appInfo.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "appInfo.appId");
        this.mCurrentThirdAppId = appId;
        String appName = appInfo.getAppName();
        Intrinsics.checkNotNullExpressionValue(appName, "appInfo.appName");
        this.mCurrentThirdAppName = appName;
        this.mThirdAppInfoBar.d(appInfo);
        this.mThirdAppLayout.setVisibility(0);
        String perLoadingMaterialUrl = appInfo.getPerLoadingMaterialUrl();
        Intrinsics.checkNotNullExpressionValue(perLoadingMaterialUrl, "appInfo.perLoadingMaterialUrl");
        this.mCurrentLoadingUrl = perLoadingMaterialUrl;
        this.mCurrentLoadingType = appInfo.getPerLoadingMaterialType();
        this.needShowLoadingIntroduce = !TextUtils.isEmpty(appInfo.getPerLoadingMaterialUrl());
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void setThirdAppPreloadInfo(@NotNull com.tencent.mobileqq.guild.media.thirdapp.e appPreloadInfo) {
        Intrinsics.checkNotNullParameter(appPreloadInfo, "appPreloadInfo");
        this.mCurrentThirdAppId = appPreloadInfo.getAppId();
        this.mCurrentThirdAppName = appPreloadInfo.getTitle();
        this.mThirdAppInfoBar.e(appPreloadInfo);
        this.mThirdAppLayout.setVisibility(0);
        this.mCurrentLoadingUrl = appPreloadInfo.getPerLoadingMaterialUrl();
        this.mCurrentLoadingType = appPreloadInfo.getPerLoadingMaterialType();
        this.needShowLoadingIntroduce = !TextUtils.isEmpty(appPreloadInfo.getPerLoadingMaterialUrl());
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.f
    public void setThirdAppSize(int width, int height) {
        if (this.mAppContainerWidth == width && this.mAppContainerHeight == height) {
            return;
        }
        QLog.d("GuildMediaThirdAppNormalSubView", 1, "setThirdAppSize: " + width + ", " + height);
        this.mAppContainerWidth = width;
        this.mAppContainerHeight = height;
        ViewGroup.LayoutParams layoutParams = this.mAppContentLayout.getLayoutParams();
        layoutParams.height = this.mAppContainerHeight;
        this.mAppContentLayout.setLayoutParams(layoutParams);
        A();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppNormalContentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) GuildMediaThirdAppNormalContentView$livePlayerManager$2.INSTANCE);
        this.livePlayerManager = lazy;
        View inflate = View.inflate(getContext(), R.layout.eyd, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026rd_app_normal_view, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f96745ii);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026ird_app_user_grid_layout)");
        this.mUserLayout = (GuildMediaMemberListView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f96635i8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.third_app_layout)");
        this.mThirdAppLayout = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f96645i9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026third_app_load_container)");
        this.mAppContentLayout = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f96585i3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.third_app_info_layout)");
        this.mThirdAppInfoLayout = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f96555i0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.third_app_info)");
        this.mThirdAppInfoBar = (GuildMediaThirdAppInfoBar) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f96505hv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.third_app_close)");
        this.mThirdAppCloseBtn = (ImageView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f96755ij);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.third_app_zoom_in)");
        this.mThirdAppZoomInBtn = (ImageView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f96735ih);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.third_app_to_land)");
        this.mThirdAppToLandBtn = (ImageView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f96655i_);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.third_app_loading)");
        this.mContentLoadingView = findViewById9;
        View findViewById10 = inflate.findViewById(R.id.f96675ib);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R\u2026p_loading_animation_view)");
        this.mThirdAppAnimView = (LottieAnimationView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.f96665ia);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R\u2026ding_animation_container)");
        this.mContentLoadingLayout = (LinearLayout) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.f96695id);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R\u2026ding_introduce_container)");
        this.mLoadingIntroduceContainer = (LinearLayout) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.f96705ie);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R\u2026pp_loading_introduce_img)");
        this.mLoadingIntroduceImg = (ImageView) findViewById13;
        View findViewById14 = inflate.findViewById(R.id.f96685ic);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R\u2026introduce_animation_view)");
        this.mLoadingIntroduceAnimView = (LottieAnimationView) findViewById14;
        this.mCurrentLoadingUrl = "";
        this.mCurrentLoadingType = -1;
        this.mCurrentThirdAppId = "";
        this.mCurrentThirdAppName = "";
        this.mMediaObserver = new b();
        this.observer = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppNormalContentView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) GuildMediaThirdAppNormalContentView$livePlayerManager$2.INSTANCE);
        this.livePlayerManager = lazy;
        View inflate = View.inflate(getContext(), R.layout.eyd, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026rd_app_normal_view, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f96745ii);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026ird_app_user_grid_layout)");
        this.mUserLayout = (GuildMediaMemberListView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f96635i8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.third_app_layout)");
        this.mThirdAppLayout = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f96645i9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026third_app_load_container)");
        this.mAppContentLayout = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f96585i3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.third_app_info_layout)");
        this.mThirdAppInfoLayout = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f96555i0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.third_app_info)");
        this.mThirdAppInfoBar = (GuildMediaThirdAppInfoBar) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f96505hv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.third_app_close)");
        this.mThirdAppCloseBtn = (ImageView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f96755ij);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.third_app_zoom_in)");
        this.mThirdAppZoomInBtn = (ImageView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f96735ih);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.third_app_to_land)");
        this.mThirdAppToLandBtn = (ImageView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f96655i_);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.third_app_loading)");
        this.mContentLoadingView = findViewById9;
        View findViewById10 = inflate.findViewById(R.id.f96675ib);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R\u2026p_loading_animation_view)");
        this.mThirdAppAnimView = (LottieAnimationView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.f96665ia);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R\u2026ding_animation_container)");
        this.mContentLoadingLayout = (LinearLayout) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.f96695id);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R\u2026ding_introduce_container)");
        this.mLoadingIntroduceContainer = (LinearLayout) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.f96705ie);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R\u2026pp_loading_introduce_img)");
        this.mLoadingIntroduceImg = (ImageView) findViewById13;
        View findViewById14 = inflate.findViewById(R.id.f96685ic);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R\u2026introduce_animation_view)");
        this.mLoadingIntroduceAnimView = (LottieAnimationView) findViewById14;
        this.mCurrentLoadingUrl = "";
        this.mCurrentLoadingType = -1;
        this.mCurrentThirdAppId = "";
        this.mCurrentThirdAppName = "";
        this.mMediaObserver = new b();
        this.observer = new c();
    }
}
