package com.tencent.mobileqq.vas.social.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Vibrator;
import android.view.View;
import android.widget.PopupWindow;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.paiyipai.PaiYiPaiHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vas.an;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.social.SquareVasPagImageView;
import com.tencent.mobileqq.vas.social.SquareVasPagView;
import com.tencent.mobileqq.vas.square.SquareSummaryView;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.utils.SystemUtils;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.square.debugger.LibraryDebugFragment;
import com.tencent.square.debugger.SquareDemoFragment;
import com.tencent.state.SquareRuntime;
import com.tencent.state.square.CalloutPopupWindowStyle;
import com.tencent.state.square.DebugPageType;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.SquareSummaryViewConfig;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.config.MsgBoxConfig;
import com.tencent.state.square.config.PerformanceConfig;
import com.tencent.state.square.data.SquareDeviceInfo;
import com.tencent.state.utils.TimeFormatUtils;
import com.tencent.util.QQDeviceInfo;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u008e\u00012\u00020\u0001:\u0001|B\t\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J3\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u0002H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u000eH\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020\u0002H\u0016J3\u00100\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\"\u00107\u001a\u0004\u0018\u0001062\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u00022\u0006\u00105\u001a\u000204H\u0016J \u0010:\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\fH\u0016J\"\u0010:\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010;\u001a\u0004\u0018\u00010\u00022\u0006\u00109\u001a\u00020\fH\u0016J\u0010\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020?H\u0016J\b\u0010A\u001a\u00020\fH\u0016J\b\u0010B\u001a\u00020\fH\u0016J\u0010\u0010D\u001a\u00020\t2\u0006\u0010C\u001a\u00020\fH\u0016J\u0010\u0010E\u001a\u00020\t2\u0006\u0010C\u001a\u00020\fH\u0016J@\u0010K\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010\u00022\u0006\u0010I\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0JH\u0016JU\u0010K\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\t0\u0004H\u0016J\u0010\u0010O\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010P\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010Q\u001a\u00020\u0005H\u0016J\b\u0010R\u001a\u00020\u0005H\u0016J\u0012\u0010T\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020UH\u0016J\u0012\u0010[\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016J\b\u0010\\\u001a\u00020\u0005H\u0016J\u0010\u0010]\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\n\u0010_\u001a\u0004\u0018\u00010^H\u0016J\b\u0010`\u001a\u00020\fH\u0016J\b\u0010a\u001a\u00020\fH\u0016J\u0011\u0010b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\bb\u0010cJ\n\u0010d\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010e\u001a\u00020\fH\u0016J\b\u0010f\u001a\u00020\u0002H\u0016J\u0010\u0010h\u001a\u00020\t2\u0006\u0010g\u001a\u00020\u0005H\u0016J\b\u0010i\u001a\u00020\u0005H\u0016J\u0010\u0010k\u001a\u00020\t2\u0006\u0010j\u001a\u00020\u0005H\u0016J\b\u0010l\u001a\u00020\u0005H\u0016J\u0018\u0010n\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010q\u001a\u00020p2\u0006\u0010o\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020pH\u0016J\b\u0010r\u001a\u00020\u0005H\u0016J\b\u0010s\u001a\u00020\u0005H\u0016J\b\u0010t\u001a\u00020\u0002H\u0016J\b\u0010v\u001a\u00020uH\u0016J\b\u0010w\u001a\u00020\u0005H\u0016J\u0012\u0010{\u001a\u0004\u0018\u00010z2\u0006\u0010y\u001a\u00020xH\u0016R\u0016\u0010~\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010C\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0082\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010}R\u0017\u0010j\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010}R\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/f;", "Lcom/tencent/state/square/ICommonUtils;", "", "friendUin", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "callback", "paiYiPaiFriend", "", "from", "", "duration", "phoneVibrate", "getNeedReportPlaySuccess", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "color", "setImmersiveStatus", "startZPlanEngineWhenNotReady", "getDeviceName", "uin", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getFriendRemarkName", "getGpuInfo", "Lcom/tencent/state/square/config/MsgBoxConfig;", "getMsgBoxConfig", "Landroid/content/Context;", "context", "Lcom/tencent/state/square/api/ISquarePagView;", "getPagView", "getPagImageView", "getRAMSize", "getServerTime", "getSystemVersion", "url", "Ljava/io/File;", "getUrlDrawableFile", "getUserAppearanceKey", "isCurrentAccount", "checkZplanAccessible", "time", "formatTimeForMsgBox", "getCurrentAccountUin", "getSelfTinyId", "shouldShowSmallHomeEntry", "Landroid/view/View;", "decor", "text", "Lcom/tencent/state/square/CalloutPopupWindowStyle;", "style", "Landroid/widget/PopupWindow;", "showCallOutPopupWindow", PoiListCacheRecord.WEIGHT_TYPE, "type", UIJsPlugin.EVENT_SHOW_TOAST, "message", "isDebug", "setSquareDebug", "getSquareDebug", "Lcom/tencent/state/square/data/SquareDeviceInfo;", "getSquareDeviceInfo", "getSquarePlayCountIncludeMe", "getSquareFilamentPlayCountIncludeMe", "playCount", "setSquarePlayCountIncludeMe", "setSquareFilamentPlayCountIncludeMe", "msg", "midText", "title", "isSelect", "Lkotlin/Function0;", "showDialog", "rightText", "leftText", "isRight", "setStandardFont", "unSetStandardFont", "isApngLoaded", "isBackgroundStop", "songMid", "isSongPlaying", "Lcom/tencent/state/square/api/SquareSummaryViewConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/api/ISquareSummaryView;", "getSummaryView", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "isDrawableReady", "isLikeIconUseHug", "hasSendFriendRequest", "Landroid/app/Application;", "getApplication", "getCpuCoreNum", "getCpuMaxFreq", "getAvatarGender", "()Ljava/lang/Integer;", "getQZoneHomePageUrl", "getQZonePrivacyDialogShowLimitDay", "getQZoneFeedsBubbleText", "forbidden", "setForbidLocalRecord", "getForbidLocalRecord", "needShieldTeenager", "setNeedShieldTeenager", "getNeedShieldTeenager", "key", "isSwitchOn", VipFunCallConstants.KEY_GROUP, "", "loadRawConfig", "getStudyMode", "isDebugVersion", "getAppReportVersionName", "Lcom/tencent/state/square/config/PerformanceConfig;", "getPerformanceConfig", "enableZPlanFilamentBase", "Lcom/tencent/state/square/DebugPageType;", "pageType", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "getDebugFragment", "a", "Z", "isSquareDebug", "b", "I", "c", "filamentPlayCount", "d", "Lcom/tencent/state/square/config/MsgBoxConfig;", "msgBoxConfig", "e", "forbiddenLocalRecord", "f", "g", "Lcom/tencent/state/square/config/PerformanceConfig;", "performanceConfig", "<init>", "()V", tl.h.F, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f implements ICommonUtils {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isSquareDebug;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MsgBoxConfig msgBoxConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean needShieldTeenager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private PerformanceConfig performanceConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int playCount = 10;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int filamentPlayCount = 2;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean forbiddenLocalRecord = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/f$a;", "", "", "forceDebugPlayCount", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setForceDebugPlayCount", "(Ljava/lang/Integer;)V", "GENDER_FRMALE", "I", "GENDER_MALE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.social.config.f$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Integer a() {
            return null;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f310716a;

        static {
            int[] iArr = new int[DebugPageType.values().length];
            try {
                iArr[DebugPageType.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DebugPageType.LIBRARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f310716a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final Function1 callback, final Boolean bool) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.social.config.e
            @Override // java.lang.Runnable
            public final void run() {
                f.g(Function1.this, bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 callback, Boolean isRegistered) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(isRegistered, "isRegistered");
        callback.invoke(isRegistered);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 callback, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
        qQCustomDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 callback, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.FALSE);
        qQCustomDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 callback, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.TRUE);
        qQCustomDialog.dismiss();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean checkZplanAccessible(String uin) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(uin, "uin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(1000L, longOrNull != null ? longOrNull.longValue() : 0L)) {
            return true;
        }
        QLog.e("VasSquareCommonUtils", 1, " isInWhiteList: false");
        return false;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean enableZPlanFilamentBase() {
        return ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String formatTimeForMsgBox(Context context, long time) {
        String obj;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence f16 = en.f(context, 3, time, true, true);
        return (f16 == null || (obj = f16.toString()) == null) ? TimeFormatUtils.INSTANCE.formatTimeBaseOnMill(time, DateUtil.DATE_FORMAT_HOUR) : obj;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getAppReportVersionName() {
        String reportVersionName = AppSetting.f99554n;
        Intrinsics.checkNotNullExpressionValue(reportVersionName, "reportVersionName");
        return reportVersionName;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public Application getApplication() {
        return BaseApplicationImpl.sApplication;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public Integer getAvatarGender() {
        boolean z16;
        boolean isBlank;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(currentAccountUin);
            if (!isBlank) {
                z16 = false;
                if (z16 && ZplanDataRepository.l(ZplanDataRepository.f334898a, currentAccountUin, false, 2, null).gender == 2) {
                    return 2;
                }
                return 1;
            }
        }
        z16 = true;
        if (z16) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public int getCpuCoreNum() {
        return ah.n();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public int getCpuMaxFreq() {
        return (int) (ah.m() / 1024);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getCurrentAccountUin() {
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            return getSelfTinyId();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        return currentAccountUin == null ? "" : currentAccountUin;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public QPublicBaseFragment getDebugFragment(DebugPageType pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        int i3 = b.f310716a[pageType.ordinal()];
        if (i3 == 1) {
            return SquareDemoFragment.INSTANCE.a();
        }
        if (i3 != 2) {
            return null;
        }
        return new LibraryDebugFragment();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getDeviceName() {
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    @Override // com.tencent.state.square.ICommonUtils
    /* renamed from: getForbidLocalRecord, reason: from getter */
    public boolean getForbiddenLocalRecord() {
        return this.forbiddenLocalRecord;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getFriendRemarkName(String uin, String defaultValue) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        aVar.d(uid);
        String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
        if (nameWithConfig == null) {
            return defaultValue;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(nameWithConfig);
        return isBlank ? defaultValue : nameWithConfig;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getGpuInfo() {
        t74.d dVar = t74.d.f435534a;
        return dVar.b() + "_" + dVar.a();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public MsgBoxConfig getMsgBoxConfig() {
        MsgBoxConfig msgBoxConfig = this.msgBoxConfig;
        if (msgBoxConfig != null) {
            return msgBoxConfig;
        }
        MsgBoxConfig parseConfig = MsgBoxConfig.INSTANCE.parseConfig(((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().b());
        this.msgBoxConfig = parseConfig;
        return parseConfig;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getNeedReportPlaySuccess() {
        xa1.e eVar;
        q03.e d16 = ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d();
        q03.k kVar = d16 instanceof q03.k ? (q03.k) d16 : null;
        if (kVar == null || (eVar = kVar.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String()) == null) {
            return false;
        }
        return eVar.getNeedReportPlaySuccess();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getNeedShieldTeenager() {
        return this.needShieldTeenager;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public ISquarePagView getPagImageView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (getPerformanceConfig().getForbiddenPagPlay()) {
            return null;
        }
        return new SquareVasPagImageView(context);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public ISquarePagView getPagView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (getPerformanceConfig().getForbiddenPagPlay()) {
            return null;
        }
        return new SquareVasPagView(context);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public PerformanceConfig getPerformanceConfig() {
        PerformanceConfig performanceConfig = this.performanceConfig;
        if (performanceConfig != null) {
            return performanceConfig;
        }
        PerformanceConfig parseConfig = PerformanceConfig.INSTANCE.parseConfig(((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().c());
        this.performanceConfig = parseConfig;
        return parseConfig;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getQZoneFeedsBubbleText() {
        return ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().a().a();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getQZoneHomePageUrl() {
        return ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().a().c();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public int getQZonePrivacyDialogShowLimitDay() {
        return ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().a().b();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public int getRAMSize() {
        return (int) t74.c.b();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getSelfTinyId() {
        return ((IMapNearbyDataService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMapNearbyDataService.class, "")).getSelfUserInfo().p();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public long getServerTime() {
        return NetConnInfoCenter.getServerTime();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getShaderUseMulti() {
        return ICommonUtils.DefaultImpls.getShaderUseMulti(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    /* renamed from: getSquareDebug, reason: from getter */
    public boolean getIsSquareDebug() {
        return this.isSquareDebug;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public SquareDeviceInfo getSquareDeviceInfo() {
        SquareDeviceInfo squareDeviceInfo = new SquareDeviceInfo();
        vu4.e a16 = com.tencent.mobileqq.zplan.utils.i.a();
        String str = a16.f443572c;
        Intrinsics.checkNotNullExpressionValue(str, "hardwareInfo.gles");
        squareDeviceInfo.setGlesVersion(str);
        String str2 = a16.f443582m;
        Intrinsics.checkNotNullExpressionValue(str2, "hardwareInfo.os");
        squareDeviceInfo.setOsName(str2);
        String str3 = a16.f443578i;
        Intrinsics.checkNotNullExpressionValue(str3, "hardwareInfo.osVersion");
        squareDeviceInfo.setOsVersion(str3);
        String str4 = a16.f443577h;
        Intrinsics.checkNotNullExpressionValue(str4, "hardwareInfo.manufacturer");
        squareDeviceInfo.setManufacturer(str4);
        String str5 = a16.f443576g;
        Intrinsics.checkNotNullExpressionValue(str5, "hardwareInfo.instructionSet");
        squareDeviceInfo.setInstrumentationSet(str5);
        String str6 = a16.f443579j;
        Intrinsics.checkNotNullExpressionValue(str6, "hardwareInfo.coreName");
        squareDeviceInfo.setCpuCore(str6);
        String str7 = a16.f443580k;
        Intrinsics.checkNotNullExpressionValue(str7, "hardwareInfo.cpuName");
        squareDeviceInfo.setCpuName(str7);
        squareDeviceInfo.setArm64(String.valueOf(a16.f443583n));
        String str8 = a16.f443570a;
        Intrinsics.checkNotNullExpressionValue(str8, "hardwareInfo.gpuName");
        squareDeviceInfo.setGpuName(str8);
        String str9 = a16.f443575f;
        Intrinsics.checkNotNullExpressionValue(str9, "hardwareInfo.model");
        squareDeviceInfo.setModel(str9);
        String qimei = QQDeviceInfo.getQIMEI();
        Intrinsics.checkNotNullExpressionValue(qimei, "getQIMEI()");
        squareDeviceInfo.setUdid(qimei);
        String str10 = a16.f443573d;
        Intrinsics.checkNotNullExpressionValue(str10, "hardwareInfo.brand");
        squareDeviceInfo.setBrand(str10);
        String str11 = a16.f443574e;
        Intrinsics.checkNotNullExpressionValue(str11, "hardwareInfo.device");
        squareDeviceInfo.setDevice(str11);
        String str12 = a16.f443571b;
        Intrinsics.checkNotNullExpressionValue(str12, "hardwareInfo.ram");
        squareDeviceInfo.setRamSize(str12);
        squareDeviceInfo.setDisplayWidth(String.valueOf(ah.Z()));
        squareDeviceInfo.setDisplayHeight(String.valueOf(ah.y()));
        squareDeviceInfo.setDisplayDensity(String.valueOf(ah.f307408i));
        squareDeviceInfo.setCpuCoreCount(String.valueOf(ah.n()));
        squareDeviceInfo.setCpuFreq(String.valueOf(ah.m() / 1024));
        String systemUI = SystemUtils.getSystemUI();
        if (systemUI == null) {
            systemUI = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(systemUI, "SystemUtils.getSystemUI() ?: \"\"");
        }
        squareDeviceInfo.setSystemUiVersion(systemUI);
        return squareDeviceInfo;
    }

    @Override // com.tencent.state.square.ICommonUtils
    /* renamed from: getSquareFilamentPlayCountIncludeMe, reason: from getter */
    public int getFilamentPlayCount() {
        return this.filamentPlayCount;
    }

    @Override // com.tencent.state.square.ICommonUtils
    /* renamed from: getSquarePlayCountIncludeMe */
    public int getPlayCountIncludeMe() {
        Integer a16 = INSTANCE.a();
        if (a16 != null) {
            return a16.intValue();
        }
        return this.playCount;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getStudyMode() {
        return StudyModeManager.t();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public ISquareSummaryView getSummaryView(Context context, SquareSummaryViewConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return new SquareSummaryView(context, config);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getSystemVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public File getUrlDrawableFile(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return AbsDownloader.getFile(url);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public String getUserAppearanceKey() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return ZplanDataRepository.l(ZplanDataRepository.f334898a, peekAppRuntime.getCurrentAccountUin().toString(), false, 2, null).appearanceKey;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean hasSendFriendRequest(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return false;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        FriendsManager friendsManager = manager instanceof FriendsManager ? (FriendsManager) manager : null;
        if (friendsManager == null) {
            return false;
        }
        return friendsManager.R(uin, false, true);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isApngLoaded() {
        return an.h().isLoaded();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isBackgroundStop() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        return appInterface != null && appInterface.isBackgroundStop;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isCurrentAccount(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            return Intrinsics.areEqual(getSelfTinyId(), uin);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return Intrinsics.areEqual(peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null, uin);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isDebugVersion() {
        return false;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isDrawableReady(URLDrawable urlDrawable) {
        if (urlDrawable != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isLikeIconUseHug() {
        return true;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isSongPlaying(String songMid) {
        if (!((IQQPlayer) QRoute.api(IQQPlayer.class)).isPlaying()) {
            return false;
        }
        SongInfo currentSong = ((IQQPlayer) QRoute.api(IQQPlayer.class)).getCurrentSong();
        return Intrinsics.areEqual(currentSong != null ? currentSong.f251868e : null, songMid);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isSwitchOn(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(key, defaultValue);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public byte[] loadRawConfig(String group, byte[] defaultValue) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(group, defaultValue);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void paiYiPaiFriend(String friendUin, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.paiyipai.PaiYiPaiHandler");
        ((PaiYiPaiHandler) businessHandler).K2(friendUin, friendUin, 0);
        phoneVibrate(-1, 50L);
        callback.invoke(Boolean.TRUE);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void phoneVibrate(int from, long duration) {
        try {
            Object systemService = MobileQQ.sMobileQQ.getSystemService("vibrator");
            Vibrator vibrator = systemService instanceof Vibrator ? (Vibrator) systemService : null;
            if (vibrator != null) {
                vibrator.vibrate(duration);
            }
        } catch (Throwable th5) {
            QLog.e("VasSquareCommonUtils", 1, "phoneVibrate, from:" + from + ", err.", th5);
        }
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setForbidLocalRecord(boolean forbidden) {
        this.forbiddenLocalRecord = forbidden;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setImmersiveStatus(Activity activity, int color) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, color);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(color);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(color);
        }
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setNeedShieldTeenager(boolean needShieldTeenager) {
        this.needShieldTeenager = needShieldTeenager;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setSquareDebug(boolean isDebug) {
        this.isSquareDebug = isDebug;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setSquareFilamentPlayCountIncludeMe(int playCount) {
        this.filamentPlayCount = playCount;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setSquarePlayCountIncludeMe(int playCount) {
        this.playCount = playCount;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setStandardFont(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (FontSettingManager.getFontLevel() == 16.0f) {
            return;
        }
        FontSettingManager.setCustomDensity(context, 16.0f, false);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void shouldShowSmallHomeEntry(String friendUin, final Function1<? super Boolean, Unit> callback) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(friendUin);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        if (longValue == 0) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(2001L, peekAppRuntime != null ? peekAppRuntime.getLongAccountUin() : 0L)) {
            QLog.e("VasSquareCommonUtils", 1, " isInWhiteList: false");
            callback.invoke(Boolean.FALSE);
        } else if (((IZootopiaApi) QRoute.api(IZootopiaApi.class)).shouldHideSmallHomeEntry()) {
            QLog.e("VasSquareCommonUtils", 1, "study mode hide small home entry");
            callback.invoke(Boolean.FALSE);
        } else {
            ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanSmallHomeAccessible(longValue, new nk3.o() { // from class: com.tencent.mobileqq.vas.social.config.d
                @Override // nk3.o
                public final void a(Boolean bool) {
                    f.f(Function1.this, bool);
                }
            });
        }
    }

    @Override // com.tencent.state.square.ICommonUtils
    public PopupWindow showCallOutPopupWindow(View decor, String text, CalloutPopupWindowStyle style) {
        Intrinsics.checkNotNullParameter(decor, "decor");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.builder(decor.getContext()).setText(text).setTextSize(style.getTextSize()).setVerticalPaddingDp(style.getVerticalPaddingDp()).setHorizontalPaddingDp(style.getHorizontalPaddingDp()).setTextColor(style.getTextColor()).setPosition(style.getPosition()).setLifetime(style.getLifeTime()).setMaxWidth((int) (decor.getContext().getResources().getDisplayMetrics().widthPixels * 0.5d))).setBackgroundColor(style.getBackgroundColor()).setBackgroundRadius(style.getBackgroundRadius()).build().build();
        build.setFocusable(true);
        build.setMarginScreen(ViewExtensionsKt.dip(decor.getContext(), style.getMarginScreen()));
        build.showAsPointer(decor);
        return build;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showDialog(Context context, String msg2, String midText, String title, boolean isSelect, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(midText, "midText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        createCustomDialog.setNegativeButton(midText, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.social.config.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.h(Function0.this, createCustomDialog, dialogInterface, i3);
            }
        }).setMessage(msg2).setTitle(title).setTextIsSelectable(isSelect).show();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showToast(Context context, int r36, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        QQToast.makeText(context, type, r36, 0).show();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showToastSafely(Context context, String str, int i3) {
        ICommonUtils.DefaultImpls.showToastSafely(this, context, str, i3);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void startZPlanEngineWhenNotReady() {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startEngineWhenNotReady(null, "zootopia_square");
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void unSetStandardFont(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FontSettingManager.setCustomDensity(context, FontSettingManager.getFontLevel(), false);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showToast(Context context, String message, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        QQToast.makeText(context, type, message, 0).show();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showDialog(Context context, String msg2, String rightText, String leftText, String title, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(rightText, "rightText");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        createCustomDialog.setNegativeButton(leftText, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.social.config.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.i(Function1.this, createCustomDialog, dialogInterface, i3);
            }
        }).setPositiveButton(rightText, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.social.config.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.j(Function1.this, createCustomDialog, dialogInterface, i3);
            }
        }).setMessage(msg2).setTitle(title).show();
    }
}
