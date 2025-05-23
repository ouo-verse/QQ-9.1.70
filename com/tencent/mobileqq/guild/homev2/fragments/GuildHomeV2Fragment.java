package com.tencent.mobileqq.guild.homev2.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.h;
import com.tencent.mobileqq.guild.base.extension.k;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.home.helper.GuildHomeTipHelper;
import com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout;
import com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment;
import com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior;
import com.tencent.mobileqq.guild.homev2.misc.logics.GuildHomeSaveStateLogic;
import com.tencent.mobileqq.guild.homev2.misc.logics.ShowLoadingLogic;
import com.tencent.mobileqq.guild.homev2.misc.logics.f;
import com.tencent.mobileqq.guild.homev2.parts.GuildHomeV2BanPart;
import com.tencent.mobileqq.guild.homev2.parts.GuildHomeV2VisitorInvisiblePart;
import com.tencent.mobileqq.guild.homev2.parts.GuildHomeV2VisitorJoinPart;
import com.tencent.mobileqq.guild.homev2.parts.GuildNavigatorPart;
import com.tencent.mobileqq.guild.homev2.parts.GuildTabsPart;
import com.tencent.mobileqq.guild.homev2.parts.PullRefreshLoadingPart;
import com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2CoverPart;
import com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitlePart;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.homev2.views.GuildHomeV2ContentLayout;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.g;
import com.tencent.mobileqq.pad.l;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import cooperation.qzone.QzoneIPCModule;
import ef1.c;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.v;
import wo1.ImageColorInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0094\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0095\u0001B\t\u00a2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\"\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020\u0011H\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001a\u00100\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u00101\u001a\u00020\u000bH\u0016J\b\u00102\u001a\u00020\u0011H\u0016J\u0010\u00104\u001a\u00020\u00112\u0006\u00103\u001a\u00020\tH\u0016J\u0012\u00107\u001a\u00020\u00112\b\u00106\u001a\u0004\u0018\u000105H\u0016J\u0012\u00108\u001a\u00020\u00112\b\u00106\u001a\u0004\u0018\u000105H\u0016J\u0012\u0010;\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\n\u0010=\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000bH\u0016J\b\u0010@\u001a\u00020\u0011H\u0002J\b\u0010A\u001a\u00020\u0011H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\u0010\u0010D\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020CH\u0002J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020CH\u0002J\b\u0010F\u001a\u00020\u0011H\u0002J\u0010\u0010H\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u0016H\u0002J\b\u0010I\u001a\u00020\u0011H\u0002J\b\u0010J\u001a\u00020\u000bH\u0002J\b\u0010K\u001a\u00020\u0011H\u0002J\b\u0010M\u001a\u00020LH\u0002R+\u0010 \u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001f8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010_R\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010Z\u001a\u0004\be\u0010fR\u001b\u0010k\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010Z\u001a\u0004\bi\u0010jR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010Z\u001a\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0083\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R\u0019\u0010\u0086\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/fragments/GuildHomeV2Fragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/guild/homev2/misc/a;", "Lcom/tencent/mobileqq/pad/g;", "Lmqq/app/IAccountCallback;", "Lcom/tencent/mobileqq/webview/swift/u;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "", "needStatusTrans", "needImmersive", "isWrapContent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "initWindowStyleAndAnimation", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lwo1/a;", "listener", "Fh", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "bi", "", "guildId", "", "categoryId", "ai", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onBackEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onDestroyView", "oldGuildId", "Z2", "contentView", "onViewCreatedBeforePartInit", "qOnBackPressed", "qOnNewIntent", "from", "d5", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "getCurrentWebViewFragment", NodeProps.VISIBLE, "setBottomBarVisibility", "Zh", "Ph", "initData", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout;", "Sh", "Xh", "Gh", "requireView", "Vh", "Kh", "Ih", "Jh", "Lmp1/a;", "Uh", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/properties/ReadWriteProperty;", "getGuildId", "()Ljava/lang/String;", "Wh", "(Ljava/lang/String;)V", "D", "Ljava/lang/String;", "pageId", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "E", "Lkotlin/Lazy;", "Oh", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportMainTask", "G", "reportPauseTask", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", "H", "Lh", "()Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "I", "Nh", "()Lmp1/a;", "homeProvider", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "J", "Mh", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "guildHomeViewModel", "Lcom/tencent/mobileqq/guild/homev2/misc/logics/f;", "K", "Lcom/tencent/mobileqq/guild/homev2/misc/logics/f;", "handlePullRefresh", "Lcom/tencent/mobileqq/guild/homev2/parts/GuildTabsPart;", "L", "Lcom/tencent/mobileqq/guild/homev2/parts/GuildTabsPart;", "guildTabsPart", "Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2ContentLayout;", "M", "Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2ContentLayout;", "contentLayout", "N", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "P", "Landroid/view/View;", "header", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "loadingView", BdhLogUtil.LogTag.Tag_Req, "Z", "hasConsumedJumpParam", ExifInterface.LATITUDE_SOUTH, "Lwo1/a;", "coverInfoListener", "Lwo1/d;", "T", "Lwo1/d;", "imageCoverInfo", "Lcom/tencent/mobileqq/guild/home/helper/GuildHomeTipHelper;", "U", "Lcom/tencent/mobileqq/guild/home/helper/GuildHomeTipHelper;", "guildHomeTipHelper", "<init>", "()V", "V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2Fragment extends QPublicBaseFragment implements com.tencent.mobileqq.guild.homev2.misc.a, g, IAccountCallback, u {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty guildId = com.tencent.mobileqq.guild.homev2.misc.b.b(this, null, 1, null);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String pageId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy reportTask;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportMainTask;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportPauseTask;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy behavior;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeProvider;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildHomeViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final f handlePullRefresh;

    /* renamed from: L, reason: from kotlin metadata */
    private GuildTabsPart guildTabsPart;

    /* renamed from: M, reason: from kotlin metadata */
    private GuildHomeV2ContentLayout contentLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private JumpGuildParam jumpGuildParam;

    /* renamed from: P, reason: from kotlin metadata */
    private View header;

    /* renamed from: Q, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean hasConsumedJumpParam;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private wo1.a coverInfoListener;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ImageColorInfo imageCoverInfo;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private GuildHomeTipHelper guildHomeTipHelper;
    static final /* synthetic */ KProperty<Object>[] W = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GuildHomeV2Fragment.class, "guildId", "getGuildId()Ljava/lang/String;", 0))};

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/fragments/GuildHomeV2Fragment$a;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "b", "Landroid/content/Context;", "context", "param", "", "c", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GuildFacadeType b(JumpGuildParam jumpGuildParam) {
            GuildFacadeType guildFacadeType;
            Serializable serializable = jumpGuildParam.extras.getSerializable("guild_facade_type");
            if (serializable instanceof GuildFacadeType) {
                guildFacadeType = (GuildFacadeType) serializable;
            } else {
                guildFacadeType = null;
            }
            if (guildFacadeType == null) {
                return GuildFacadeType.UnknownType;
            }
            return guildFacadeType;
        }

        @JvmStatic
        public final void c(@NotNull Context context, @NotNull JumpGuildParam param) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            String str = param.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
            com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.g.n(str);
            TraceUtils traceUtils = TraceUtils.f235403a;
            GuildFacadeType guildFacadeType = null;
            if (!TraceUtils.m()) {
                traceUtils.l();
                param.extras.putBoolean("V2", true);
                Serializable serializable = param.extras.getSerializable("guild_facade_type");
                if (serializable instanceof GuildFacadeType) {
                    guildFacadeType = (GuildFacadeType) serializable;
                }
                if (guildFacadeType == null) {
                    guildFacadeType = GuildFacadeType.UnknownType;
                }
                Intent intent = new Intent();
                intent.putExtra(JumpGuildParam.KEY_JUMP_GUILD_PARAM, (Parcelable) param);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                IPerformanceReportTask stageCode = Reporters.f231995a.b().newReportTask().setEventCode("guild_main_page").setStageCode("stage_open");
                String str2 = param.guildId;
                Intrinsics.checkNotNullExpressionValue(str2, "param.guildId");
                GuildSplitViewUtils.f235370a.r(context, k.c(k.b(qw1.b.r(intent, stageCode.setParam("guild_id", str2).setEnterFrom(guildFacadeType.toString()).setAppChannel(com.tencent.mobileqq.guild.report.b.c()).report()))), GuildHomeV2Fragment.class);
                return;
            }
            try {
                cy.c("Guild.HomePage.Fragment.open");
                param.extras.putBoolean("V2", true);
                Serializable serializable2 = param.extras.getSerializable("guild_facade_type");
                if (serializable2 instanceof GuildFacadeType) {
                    guildFacadeType = (GuildFacadeType) serializable2;
                }
                if (guildFacadeType == null) {
                    guildFacadeType = GuildFacadeType.UnknownType;
                }
                Intent intent2 = new Intent();
                intent2.putExtra(JumpGuildParam.KEY_JUMP_GUILD_PARAM, (Parcelable) param);
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                IPerformanceReportTask stageCode2 = Reporters.f231995a.b().newReportTask().setEventCode("guild_main_page").setStageCode("stage_open");
                String str3 = param.guildId;
                Intrinsics.checkNotNullExpressionValue(str3, "param.guildId");
                GuildSplitViewUtils.f235370a.r(context, k.c(k.b(qw1.b.r(intent2, stageCode2.setParam("guild_id", str3).setEnterFrom(guildFacadeType.toString()).setAppChannel(com.tencent.mobileqq.guild.report.b.c()).report()))), GuildHomeV2Fragment.class);
                Unit unit = Unit.INSTANCE;
            } finally {
                cy.d();
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f225725d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f225726e;

        public b(Object obj, Observer observer) {
            this.f225725d = obj;
            this.f225726e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f225725d)) != null) {
                this.f225726e.onChanged(b16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f225727d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f225728e;

        public c(Object obj, Observer observer) {
            this.f225727d = obj;
            this.f225728e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f225727d)) != null) {
                this.f225728e.onChanged(b16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"com/tencent/mobileqq/guild/homev2/fragments/GuildHomeV2Fragment$d", "Lmp1/a;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "a", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "b", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "d", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "homeViewModel", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "c", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", "e", "()Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", "fragmentBehavior", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "f", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements mp1.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QBaseActivity activity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildHomeViewModel homeViewModel;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IPerformanceReportTask reportTask;

        d() {
            QBaseActivity qBaseActivity = GuildHomeV2Fragment.this.getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
            this.activity = qBaseActivity;
            this.homeViewModel = GuildHomeV2Fragment.this.Mh();
            this.reportTask = GuildHomeV2Fragment.this.Oh();
        }

        @Override // mp1.a
        @NotNull
        public GuildFacadeType a() {
            return GuildHomeV2Fragment.INSTANCE.b(f());
        }

        @Override // mp1.a
        @NotNull
        /* renamed from: b, reason: from getter */
        public IPerformanceReportTask getReportTask() {
            return this.reportTask;
        }

        @Override // mp1.a
        @NotNull
        /* renamed from: d, reason: from getter */
        public GuildHomeViewModel getHomeViewModel() {
            return this.homeViewModel;
        }

        @Override // mp1.a
        @NotNull
        public GuildHomeV2FragmentBehavior e() {
            return GuildHomeV2Fragment.this.Lh();
        }

        @Override // mp1.a
        @NotNull
        public JumpGuildParam f() {
            JumpGuildParam jumpGuildParam = GuildHomeV2Fragment.this.jumpGuildParam;
            if (jumpGuildParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                return null;
            }
            return jumpGuildParam;
        }

        @Override // mp1.a
        @NotNull
        public QBaseActivity getActivity() {
            return this.activity;
        }
    }

    public GuildHomeV2Fragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        String b16 = m.b(this);
        this.pageId = b16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPerformanceReportTask>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment$reportTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IPerformanceReportTask invoke() {
                return qw1.b.d(GuildHomeV2Fragment.this.getArguments(), null, 1, null);
            }
        });
        this.reportTask = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeV2FragmentBehavior>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment$behavior$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeV2FragmentBehavior invoke() {
                Context requireContext = GuildHomeV2Fragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                GuildHomeV2Fragment.Companion companion = GuildHomeV2Fragment.INSTANCE;
                JumpGuildParam jumpGuildParam = GuildHomeV2Fragment.this.jumpGuildParam;
                if (jumpGuildParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                    jumpGuildParam = null;
                }
                return new GuildHomeV2FragmentBehavior(requireContext, null, companion.b(jumpGuildParam));
            }
        });
        this.behavior = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<mp1.a>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment$homeProvider$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final mp1.a invoke() {
                mp1.a Uh;
                Uh = GuildHomeV2Fragment.this.Uh();
                return Uh;
            }
        });
        this.homeProvider = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeViewModel>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment$guildHomeViewModel$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f225733a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildHomeV2Fragment f225734b;

                public a(ViewModelStoreOwner viewModelStoreOwner, GuildHomeV2Fragment guildHomeV2Fragment) {
                    this.f225733a = viewModelStoreOwner;
                    this.f225734b = guildHomeV2Fragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
                    JumpGuildParam jumpGuildParam = this.f225734b.jumpGuildParam;
                    if (jumpGuildParam == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                        jumpGuildParam = null;
                    }
                    TimedValue timedValue = new TimedValue(new GuildHomeViewModel(jumpGuildParam), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
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
            public final GuildHomeViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                GuildHomeV2Fragment guildHomeV2Fragment = GuildHomeV2Fragment.this;
                ViewModel viewModel = new ViewModelProvider(guildHomeV2Fragment, new a(guildHomeV2Fragment, guildHomeV2Fragment)).get(GuildHomeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (GuildHomeViewModel) viewModel;
            }
        });
        this.guildHomeViewModel = lazy4;
        this.handlePullRefresh = new f(this);
        com.tencent.mobileqq.guild.homev2.misc.logics.a.f225907a.a(this, b16);
        GuildHomeSaveStateLogic.f225894a.f(this);
        MiscKt.b(this);
    }

    private final void Gh() {
        uh2.c gProGuildMsgService = ((IGProSession) bz.b(IGProSession.class)).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.clearGuildReadSceneV2(new GProContact(16, getGuildId(), getGuildId()), 5, new IGuildOperateCallback() { // from class: com.tencent.mobileqq.guild.homev2.fragments.b
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    GuildHomeV2Fragment.Hh(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(int i3, String str) {
        QLog.e("Guild.NewHome.GuildHomeV2Fragment", 1, "clearUnread: result = " + i3 + ", errMsg = " + str);
    }

    private final boolean Ih() {
        if (!GuildSplitViewUtils.f235370a.n(getActivity()) && !((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity(getActivity())) {
            return false;
        }
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof l) {
            ((l) activity).getqFragmentStackManager().q(GuildHomeV2Fragment.class.getName());
            return true;
        }
        return true;
    }

    private final void Jh() {
        ShowLoadingLogic.Companion companion = ShowLoadingLogic.INSTANCE;
        StateFlow<GuildHomeViewModel.GuildHomeUiState> P1 = Mh().P1();
        View view = this.loadingView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            view = null;
        }
        FlowKt.launchIn(companion.a(P1, new ShowLoadingLogic(view, Mh())), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh() {
        FragmentActivity activity;
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeV2Fragment", 1, "finishFragment ");
        if (!Ih() && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildHomeV2FragmentBehavior Lh() {
        return (GuildHomeV2FragmentBehavior) this.behavior.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildHomeViewModel Mh() {
        return (GuildHomeViewModel) this.guildHomeViewModel.getValue();
    }

    private final mp1.a Nh() {
        return (mp1.a) this.homeProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPerformanceReportTask Oh() {
        return (IPerformanceReportTask) this.reportTask.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r5, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ph() {
        JumpGuildNoticeMsg jumpGuildNoticeMsg;
        Context context;
        boolean z16;
        String str;
        List split$default;
        Object orNull;
        if (this.hasConsumedJumpParam) {
            return;
        }
        this.hasConsumedJumpParam = true;
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        JumpGuildParam jumpGuildParam2 = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        String string = jumpGuildParam.getExtras().getString("detailId");
        if (string != null) {
            if (string.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = string;
            } else {
                str = null;
            }
            if (str != null && split$default != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 3);
                String str2 = (String) orNull;
                if (str2 != null) {
                    ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchByScheme(str2);
                    return;
                }
            }
        }
        JumpGuildParam jumpGuildParam3 = this.jumpGuildParam;
        if (jumpGuildParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam3 = null;
        }
        Parcelable parcelable = jumpGuildParam3.getExtras().getParcelable(JumpGuildParam.EXTRA_JUMP_NOTICE_MSG);
        if (parcelable instanceof JumpGuildNoticeMsg) {
            jumpGuildNoticeMsg = (JumpGuildNoticeMsg) parcelable;
        } else {
            jumpGuildNoticeMsg = null;
        }
        if (jumpGuildNoticeMsg != null && (context = getContext()) != null) {
            GuildSettingFragment.Companion companion = GuildSettingFragment.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            JumpGuildParam jumpGuildParam4 = this.jumpGuildParam;
            if (jumpGuildParam4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            } else {
                jumpGuildParam2 = jumpGuildParam4;
            }
            FacadeArgsData j3 = MiscKt.j(jumpGuildParam2);
            j3.C.putBoolean("PARAM_SUPPORT_NEXT_JUMP", true);
            Unit unit = Unit.INSTANCE;
            companion.a(context, j3);
        }
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

    private final void Sh(BetterCoordinatorLayout view) {
        IPerformanceReportTask iPerformanceReportTask = this.reportMainTask;
        if (iPerformanceReportTask == null) {
            iPerformanceReportTask = Oh().duplicate("guild_id").setStageCode("stage_main");
        }
        this.reportMainTask = iPerformanceReportTask;
        IPerformanceReportTask iPerformanceReportTask2 = this.reportPauseTask;
        if (iPerformanceReportTask2 == null) {
            iPerformanceReportTask2 = Oh().duplicate("guild_id").setStageCode("stage_fragment_onpause");
        }
        this.reportPauseTask = iPerformanceReportTask2;
        dp1.a aVar = dp1.a.f394517a;
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        JumpGuildParam jumpGuildParam2 = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        aVar.e(str, System.currentTimeMillis());
        Companion companion = INSTANCE;
        JumpGuildParam jumpGuildParam3 = this.jumpGuildParam;
        if (jumpGuildParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam3 = null;
        }
        if (companion.b(jumpGuildParam3) == GuildFacadeType.GameCenter) {
            view.setFitsSystemWindows(false);
        }
        JumpGuildParam jumpGuildParam4 = this.jumpGuildParam;
        if (jumpGuildParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam4 = null;
        }
        if (Intrinsics.areEqual(jumpGuildParam4.extras.getString("scrollTop", "0"), "1")) {
            Lh().B(true);
        }
        Xh(view);
        View findViewById = view.findViewById(R.id.ws8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.guild_navigator_layout)");
        this.header = findViewById;
        View findViewById2 = view.findViewById(R.id.b9w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.content_layout)");
        this.contentLayout = (GuildHomeV2ContentLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.f79684_f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.s\u2026nning_light_loading_view)");
        this.loadingView = findViewById3;
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.contentLayout;
        if (guildHomeV2ContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout = null;
        }
        guildHomeV2ContentLayout.setupBehavior(Lh());
        view.setTouchEventAware(Lh());
        qw1.b.k(this.reportMainTask, view, null, 2, null);
        this.reportMainTask = DummyPerformanceReportTask.INSTANCE;
        JumpGuildParam jumpGuildParam5 = this.jumpGuildParam;
        if (jumpGuildParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
        } else {
            jumpGuildParam2 = jumpGuildParam5;
        }
        String str2 = jumpGuildParam2.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "jumpGuildParam.guildId");
        Wh(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final mp1.a Uh() {
        return new d();
    }

    private final void Vh(View requireView) {
        String str;
        com.tencent.mobileqq.guild.report.b.i("pg_sgrp_channel_feed", "Guild.NewHome.GuildHomeV2Fragment");
        HashMap hashMap = new HashMap(com.tencent.mobileqq.guild.report.b.d());
        if (Nh().a() == GuildFacadeType.GameCenter) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("sgrp_distribute_scene", str);
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        JumpGuildParam jumpGuildParam2 = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        String string = jumpGuildParam.extras.getString(JumpGuildParam.EXTRA_KEY_TRACE_ID);
        String str2 = "";
        if (string == null) {
            string = "";
        }
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, string);
        JumpGuildParam jumpGuildParam3 = this.jumpGuildParam;
        if (jumpGuildParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
        } else {
            jumpGuildParam2 = jumpGuildParam3;
        }
        String string2 = jumpGuildParam2.extras.getString("sgrp_channel_extension_info");
        if (string2 != null) {
            str2 = string2;
        }
        hashMap.put("sgrp_channel_extension_info", str2);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getView(), "pg_sgrp_channel_feed");
        com.tencent.mobileqq.guild.util.report.a.a(getView(), getGuildId(), hashMap);
        VideoReport.setPageLinkEnable(getView(), true);
    }

    private final void Xh(BetterCoordinatorLayout view) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.homev2.fragments.c
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat Yh;
                Yh = GuildHomeV2Fragment.Yh(GuildHomeV2Fragment.this, view2, windowInsetsCompat);
                return Yh;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat Yh(GuildHomeV2Fragment this$0, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        Intrinsics.checkNotNullExpressionValue(insets, "insets");
        String a16 = MiscKt.a(insets);
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, insets);
        Intrinsics.checkNotNullExpressionValue(onApplyWindowInsets, "onApplyWindowInsets(v, insets)");
        int[] iArr2 = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        if (!Arrays.equals(iArr, iArr2)) {
            Logger.a d16 = Logger.f235387a.d();
            String arrays = Arrays.toString(iArr);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            String arrays2 = Arrays.toString(iArr2);
            Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
            d16.i("Guild.NewHome.GuildHomeV2Fragment", 1, "setIgnoreWindowInsetsPaddings: " + arrays + " -> " + arrays2 + ", " + a16);
            view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            this$0.Mh().Q1().setValue(new Rect(iArr2[0], iArr2[1], iArr2[2], iArr2[3]));
        }
        return onApplyWindowInsets;
    }

    private final void Zh() {
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        JumpGuildParam jumpGuildParam2 = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        String string = jumpGuildParam.extras.getString("param_first_show_text");
        if (string != null) {
            View requireView = requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            JumpGuildParam jumpGuildParam3 = this.jumpGuildParam;
            if (jumpGuildParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            } else {
                jumpGuildParam2 = jumpGuildParam3;
            }
            String str = jumpGuildParam2.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            GuildHomeTipHelper guildHomeTipHelper = new GuildHomeTipHelper(requireView, requireActivity, str, string);
            this.guildHomeTipHelper = guildHomeTipHelper;
            guildHomeTipHelper.g();
        }
    }

    private final void initData() {
        MutableLiveData<ef1.a<Boolean>> T = Mh().T();
        LifecycleOwner hostLifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "hostLifecycleOwner");
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment$initData$1
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
                f fVar;
                GuildHomeV2Fragment.this.Mh().d2("pullDownRefresh");
                fVar = GuildHomeV2Fragment.this.handlePullRefresh;
                fVar.f();
            }
        };
        T.observe(hostLifecycleOwner, new b(this, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.fragments.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2Fragment.Qh(Function1.this, obj);
            }
        }));
        MutableLiveData<ef1.a<Long>> W1 = Mh().W1();
        LifecycleOwner hostLifecycleOwner2 = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner2, "hostLifecycleOwner");
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                GuildHomeV2Fragment guildHomeV2Fragment = GuildHomeV2Fragment.this;
                JumpGuildParam jumpGuildParam = guildHomeV2Fragment.jumpGuildParam;
                if (jumpGuildParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                    jumpGuildParam = null;
                }
                String str = jumpGuildParam.guildId;
                Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildHomeV2Fragment.ai(str, it.longValue());
            }
        };
        W1.observe(hostLifecycleOwner2, new c(this, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.fragments.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2Fragment.Rh(Function1.this, obj);
            }
        }));
        FlowKt.launchIn(FlowKt.onEach(Mh().P1(), new GuildHomeV2Fragment$initData$3(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        FlowKt.launchIn(FlowKt.onEach(Mh().Q1(), new GuildHomeV2Fragment$initData$4(null)), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final void Fh(@NotNull wo1.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.coverInfoListener = listener;
        Logger.f235387a.d().d("Guild.NewHome.GuildHomeV2Fragment", 1, "addCoverColorListener " + this.pageId + " " + System.identityHashCode(listener));
    }

    public void Wh(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId.setValue(this, W[0], str);
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.a
    public void Z2(@NotNull String oldGuildId) {
        Intrinsics.checkNotNullParameter(oldGuildId, "oldGuildId");
        com.tencent.mobileqq.guild.homev2.misc.logics.a.f225907a.b(this, this.pageId, oldGuildId);
        Mh().e2(getGuildId());
    }

    public final void ai(@NotNull String guildId, long categoryId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        GuildTabsPart guildTabsPart = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        if (!Intrinsics.areEqual(guildId, jumpGuildParam.guildId)) {
            return;
        }
        GuildTabsPart guildTabsPart2 = this.guildTabsPart;
        if (guildTabsPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildTabsPart");
        } else {
            guildTabsPart = guildTabsPart2;
        }
        guildTabsPart.S9(String.valueOf(categoryId));
        Logger.f235387a.d().d("Guild.NewHome.GuildHomeV2Fragment", 1, "switchTabSelect " + guildId + " " + categoryId);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> listOf;
        GuildTabsPart guildTabsPart = new GuildTabsPart();
        this.guildTabsPart = guildTabsPart;
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Part[]{new PullRefreshLoadingPart(), new GuildHomeV2TitlePart(), new GuildHomeV2CoverPart(), guildTabsPart, new GuildNavigatorPart(), new GuildHomeV2BanPart(), new GuildHomeV2VisitorJoinPart(), new GuildHomeV2VisitorInvisiblePart(), new com.tencent.mobileqq.guild.homev2.parts.d(), ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getFeedPublishPart()});
        return listOf;
    }

    public final void bi(@NotNull JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeV2Fragment", 1, "updateJumpGuildParam: " + jumpGuildParam);
        this.jumpGuildParam = jumpGuildParam;
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putParcelable(JumpGuildParam.KEY_JUMP_GUILD_PARAM, jumpGuildParam);
        }
        Mh().f2(jumpGuildParam);
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        Wh(str);
        GuildTabsPart guildTabsPart = this.guildTabsPart;
        if (guildTabsPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildTabsPart");
            guildTabsPart = null;
        }
        guildTabsPart.ca();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eu9;
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    @Nullable
    public WebViewFragment getCurrentWebViewFragment() {
        GuildTabsPart guildTabsPart = this.guildTabsPart;
        if (guildTabsPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildTabsPart");
            guildTabsPart = null;
        }
        return guildTabsPart.N9();
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.d
    @NotNull
    public String getGuildId() {
        return (String) this.guildId.getValue(this, W[0]);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        JumpGuildParam d16 = com.tencent.mobileqq.guild.base.extension.c.d(getArguments());
        this.jumpGuildParam = d16;
        if (d16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            d16 = null;
        }
        boolean z16 = d16.extras.getBoolean("jumpGuildFromLoadingPage", false);
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeV2Fragment", 1, "initWindowStyleAndAnimation: " + this.pageId + " JUMP_GUILD_FROM_LOADING_PAGE: " + z16);
        if (z16) {
            if (activity != null) {
                activity.overridePendingTransition(R.anim.l_, R.anim.l_);
            }
        } else if (activity != null) {
            activity.overridePendingTransition(R.anim.f154619or, R.anim.f154425m);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        Ih();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        h.a(this, requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity;
        if (!super.onBackEvent() && !h.b(this) && !Ih() && (activity = getActivity()) != null) {
            activity.finish();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JumpGuildParam d16 = com.tencent.mobileqq.guild.base.extension.c.d(getArguments());
        this.jumpGuildParam = d16;
        dp1.a aVar = dp1.a.f394517a;
        if (d16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            d16 = null;
        }
        String str = d16.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        aVar.f(str, System.currentTimeMillis());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Gh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        qw1.b.m(this.reportMainTask);
        GuildHomeTipHelper guildHomeTipHelper = this.guildHomeTipHelper;
        if (guildHomeTipHelper != null) {
            guildHomeTipHelper.p();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGPSService) S0).fetchGuildInfoWithSource(getGuildId(), 104, new v() { // from class: com.tencent.mobileqq.guild.homev2.fragments.a
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                GuildHomeV2Fragment.Th(i3, str, iGProGuildInfo);
            }
        });
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        Vh(requireView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.a d16 = Logger.f235387a.d();
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        d16.i("Guild.NewHome.GuildHomeV2Fragment", 1, "onViewCreated: " + jumpGuildParam);
        super.onViewCreated(view, savedInstanceState);
        if (view instanceof BetterCoordinatorLayout) {
            Sh((BetterCoordinatorLayout) view);
            Zh();
            initData();
            Jh();
            Gh();
            Ph();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        boolean z16;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        if (contentView == getView()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            PartFragmentIOCKt.registerIoc(this, contentView, Nh(), mp1.a.class);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public boolean setBottomBarVisibility(boolean visible) {
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }

    @Override // com.tencent.mobileqq.pad.g
    public void d5(int from) {
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(int i3, String str, IGProGuildInfo iGProGuildInfo) {
    }
}
