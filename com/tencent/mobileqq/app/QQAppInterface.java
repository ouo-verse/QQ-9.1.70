package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.AccessibilityManager;
import com.dataline.activities.LiteActivity;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.aelight.camera.api.IQIMManager;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.ark.ArkStateCenter;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.api.IVideoProcessMonitor;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.core.experiment.annotation.DeprecatedReport;
import com.tencent.core.experiment.trace.CoreExperimentalMethodTrace;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.app.memory.QLogReporter;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.guild.api.IGuildRuntimeApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.jump.model.extras.GuildManageNoticePushMsg;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.inputstatus.InputStatusHandler;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoExtractFrameManager;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.multimsg.MultiMsgController;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.ui.fragment.NewFriendFragment;
import com.tencent.mobileqq.notification.modularize.ZPlanNTPushCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecommon.processor.ChatHistoryProfileCommonProcessor;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderMsgService;
import com.tencent.mobileqq.reminder.api.IQQReminderOfTianshuService;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.WtloginReporter;
import com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi;
import com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.theme.SimpleUIManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifiphoto.api.IExportFileService;
import com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqnt.aio.predownload.api.IAIOPreDownloadService;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.IKernelSetter;
import com.tencent.qqnt.kernel.api.IKickApi;
import com.tencent.qqnt.kernel.api.IServletAPI;
import com.tencent.qqnt.kernel.nativeinterface.DeviceInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsfChangeReasonType;
import com.tencent.qqnt.kernel.nativeinterface.MsfStatusType;
import com.tencent.qqnt.kernel.nativeinterface.OnLineBusinessInfo;
import com.tencent.qqnt.kernel.nativeinterface.RegisterInfo;
import com.tencent.qqnt.kernel.nativeinterface.UnregisterInfo;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqperf.monitor.crash.ReportLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.api.IRelationNTPushService;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.TextHook;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import com.tencent.util.BadgeUtils;
import com.tencent.util.DeprecatedMethodInvokeReport;
import com.tencent.util.MsgAutoMonitorUtil;
import com.tencent.util.notification.NotificationController;
import com.tencent.widget.TraceUtils;
import com.tenpay.sdk.util.QQFaceFileUtil;
import common.config.service.QzoneConfig;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavHelper;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.tianshu.TianShuManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.ProcessConstant;
import mqq.manager.Manager;
import mqq.manager.PushManager;
import mqq.manager.ServerConfigManager;
import mqq.manager.impl.SecurityFileFrameworkServiceImpl;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Marker;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAppInterface extends BaseQQAppInterface implements PluginManageHandler.IPluginManagerProvider {
    public static final String AUTHORIZATION_NAME = "B1_QQ_Neighbor_android";
    public static final String AUTHORIZATION_PASSWORD = "NzVK_qGE";
    public static final String BROADCAST_NEW_MESSAGE_NOFITY = "com.tencent.msg.newmessage";
    private static final String BROADCAST_QZONE_CLEAR_COUNT = "com.tencent.qzone.cleanunreadcount";
    private static long CHECK_FACE_UPDATE_PERIOD = 86400000;
    static final String DATANAME_QZONE_CLEAR_COUNT = "clean_unread_feed_type";
    private static final int FACE_TYPE_OHTER_SYSTEM = -55;
    private static final int FACE_TYPE_TROOP_SYSTEM = -56;
    private static final long FIVE_SECOND = 5000;
    private static final int MAX_CHECKTIME = 168;
    public static final int MAX_RUNNING_TASK = 2;
    public static final int MAX_TRY_TIME = 3;
    private static final int MIN_CHECKTIME = 1;
    private static final int MSG_GET_ONLINE_FRIENDS = 0;
    public static final int MSG_X_2_MOBILE = 1;
    public static final int MSG_X_2_NONE = 3;
    public static final int MSG_X_2_WIFI = 2;
    private static final String POSTPONE_SET_MEDIA_PRELOAD_SWITCH_OFF = "postpone_media_predownload_switch_off";
    private static final String POSTPONE_SET_MEDIA_PRELOAD_SWITCH_OFF_KEY = "postpone_media_predownload_switch_off";
    public static final String QQ_ACTION_LOGOUT = "com.tencent.mobileqq.intent.logout";
    private static final String QQ_HEAD_BROADCAST = "Q.qqhead.broadcast";
    public static final String QQ_HEAD_QAIF = "Q.qqhead.qaif";
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;
    private static final long SERVER_CONFIG_TIMEOUT = 7200000;
    public static final String TAG = "QQAppInterface";
    private static final String TAG_NOTIFY = "Notification.Notify";
    public static final long TIME_SPACE = 2000;
    private static final String VIDEO_PROCESS_NAME = "com.tencent.mobileqq:video";
    public static int curBrowserFontSizeIndex = 1;
    private static boolean sIsQQHeadBroadcastRegister;
    public AboutConfig aboutConfig;
    public boolean bFirstPacket;
    public boolean bReceiveMsgOnExit;
    private com.tencent.mobileqq.app.asyncdb.a cacheManager;
    private e checkPttListener;
    private com.tencent.mobileqq.config.e config;
    volatile ConversationFacade convsFacade;

    /* renamed from: em, reason: collision with root package name */
    private EntityManager f194969em;
    private volatile com.tencent.mobileqq.persistence.l emFactory;
    private FileTransferHandler fileTransferHandler;
    Set<String> friendInfoQueue;
    private ar friendListObserver;

    @Deprecated
    public boolean isCallTabShow;
    public boolean isConversationTabShow;
    public boolean isExitTaskUnfinished;
    public boolean isFinished;
    public boolean isInCallList;
    public boolean isKandianTabShow;
    private Boolean isMSFConnect;
    public boolean isMsfPullFilterConfigInited;
    private boolean isRealSwitchToBackground;
    public volatile boolean isReleased;
    public boolean isStartSyncOnlineFriend;
    private Handler lockDetectHandler;
    private HandlerThread lockDetectThread;
    private AVNotifyCenter mAVNotifyCenter;
    public Automator mAutomator;
    private com.tencent.av.app.b mAvAddFriendService;
    volatile com.tencent.mobileqq.qcall.f mCallFacade;

    @Deprecated
    public int mCallTabShowState;
    private final com.tencent.mobileqq.config.c mConfigProcess;
    private com.tencent.mobileqq.filemanager.fileassistant.util.c mDatalineMsgDBTransformer;
    private FileManagerDataCenter mFileManagerDataCenter;
    private FileManagerEngine mFileManagerEngine;
    private volatile FileManagerNotifyCenter mFileManagerNotifyCenter;
    private com.tencent.mobileqq.filemanager.core.e mFileManagerRSCenter;
    public boolean mFirstGetSubAccountName;
    private cj mGAudioHandler;
    private ay mHCMng;
    ConcurrentLinkedQueue<Intent> mHeadGetIntents;

    @Deprecated
    public boolean mIsShowNewLeba;
    public long mLoginTime;
    private bt mMsgTabUnreadListener;
    private bv mMultiAIOUnreadListener;
    private MultiMsgController mMultiMsgController;
    private OnlineFileSessionCenter mOnlineFileSessionCenter;
    private volatile ParcelHooker mParcelHooker;
    private long mPreShowKickedNTs;
    private QQProxyForQlink mQQProxyForQlink;
    public WeakReference<QQServiceForAV> mQQServiceRef;
    private cooperation.qlink.c mQlinkServiceManager;
    private RecentUserProxy mRecentUserProxy;
    public long mRegisterPushTime;
    private ReportController mReportController;
    private Object mReportControllerLock;
    AtomicInteger mRunningTaskNum;
    private Intent mSecurityDetectBannerIntent;
    private ShortVideoResourceManager mShortVideoResourceMgr;
    private Object mSystemMsgInitLock;
    public int mTryTimeForNear;
    public int mTryTimeForStatus;
    public volatile boolean mainActivityIsForeground;
    private volatile int managerDestroyIndex;
    private Manager[] managers;
    public bq messageNotifiableChecker;
    br messageNotificationGenerator;
    private ThreadLocal<Integer> mgrCallingDepthThreadLocal;
    private ThreadLocal<StringBuilder> mgrCallingStackThreadLocal;
    private final Object[] mgrLockArray;
    public com.tencent.mobileqq.service.d mqqService;
    public boolean msfPullFilterSwitch;
    private com.tencent.mobileqq.service.message.e msgCache;
    volatile QQMessageFacade msgFacade;
    private MessageHandler msgHandler;
    public boolean needReuploadQfav;
    MyNetInfoHandler netHandler;
    private final Object notifyCenterLock;
    private NTFileManageBridger ntFileManageBridger;
    private ProxyManager proxyManager;
    private iv.d qavOfflineMsgCenter;
    private BroadcastReceiver qqAccountReceiver;
    private final BroadcastReceiver qqHeadBroadcastReceiver;
    private BroadcastReceiver qzoneBrocastReceiver;
    private Hashtable<ServerConfigManager.ConfigType, HashMap<String, String>> serverConfig;
    private HashMap<ServerConfigManager.ConfigType, Long> serverConfigTimeOut;
    private ShortVideoPreDownloader shortVideoPreDownloader;
    public com.tencent.mobileqq.app.utils.q soundAndVibrateUtils;

    /* renamed from: sp, reason: collision with root package name */
    SharedPreferences f194970sp;
    public int userActiveStatus;
    List<dm> vibrateListenerList;
    private static final int[] IMPORTANT_MANAGERS = {QQManagerFactory.PROXY_MANAGER, QQManagerFactory.CACHE_MANAGER, QQManagerFactory.MGR_MSG_FACADE, QQManagerFactory.CONVS_FACADE, QQManagerFactory.MGR_SUB_ACNT, QQManagerFactory.MGR_PLUGIN, QQManagerFactory.TROOP_GAG_MANAGER, QQManagerFactory.BEANCURD_MANAGER, QQManagerFactory.EXTEND_FRIEND_MANAGER};
    public static int sNextGetOnlineFriendDelay = 300000;
    public static long sLastGetOnlineFriendTime = 0;
    public static int sGetOnlineFriendDelay = 30000;
    protected static Handler sGetOnlineFriendHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.mobileqq.app.QQAppInterface.14
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                QQAppInterface qQAppInterface = (QQAppInterface) ((WeakReference) message.obj).get();
                if (qQAppInterface == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(QQAppInterface.TAG, 2, "getOnlineFriend app is null");
                        return;
                    }
                    return;
                }
                long j3 = QQAppInterface.sNextGetOnlineFriendDelay;
                long uptimeMillis = SystemClock.uptimeMillis();
                long abs = Math.abs(uptimeMillis - QQAppInterface.sLastGetOnlineFriendTime);
                if (!"0".equals(qQAppInterface.getCurrentAccountUin()) && abs >= QQAppInterface.sNextGetOnlineFriendDelay) {
                    if (QLog.isColorLevel()) {
                        QLog.d(QQAppInterface.TAG, 2, "getOnlineFriend");
                    }
                    QQAppInterface.sLastGetOnlineFriendTime = uptimeMillis;
                    FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                    if (friendListHandler != null) {
                        friendListHandler.getOnlineFriend(qQAppInterface.getCurrentAccountUin(), (byte) 0);
                    }
                }
                int i3 = QQAppInterface.sNextGetOnlineFriendDelay;
                if (abs < i3) {
                    j3 = i3 - abs;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QQAppInterface.TAG, 2, "getOnlineFriend send next msg " + j3);
                }
                QQAppInterface.sGetOnlineFriendHandler.sendMessageDelayed(QQAppInterface.sGetOnlineFriendHandler.obtainMessage(0, new WeakReference(qQAppInterface)), j3);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.QQAppInterface$9, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$run$0(int i3) {
            if (i3 >= 378 && i3 <= 477) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 265);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 267);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 274);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 236);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 268);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 272);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 271);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 273);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 239);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 266);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 524);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", 527);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", NotificationUtil.Constants.NOTIFY_ID_UPCOMING_MSG);
                qQNotificationManager.cancel("QQAppInterface_removeNotification", NotificationUtil.Constants.NOTIFY_ID_AVGAME_PLAYING);
                com.tencent.util.notification.d dVar = (com.tencent.util.notification.d) QQAppInterface.this.getManager(QQManagerFactory.NOTIFY_ID_MANAGER);
                if (dVar != null) {
                    dVar.b();
                }
                ((PushNoticeManager) QQAppInterface.this.getManager(QQManagerFactory.PUSH_NOTICE_MANAGER)).i(qQNotificationManager, -1);
                ThirdPushManager.getInstance().clearNotifications(QQAppInterface.this.getApplication(), new com.tencent.mobileqq.pushnotice.proxy.b() { // from class: com.tencent.mobileqq.app.ci
                    @Override // com.tencent.mobileqq.pushnotice.proxy.b
                    public final boolean a(int i3) {
                        boolean lambda$run$0;
                        lambda$run$0 = QQAppInterface.AnonymousClass9.lambda$run$0(i3);
                        return lambda$run$0;
                    }
                });
                if (QLog.isColorLevel()) {
                    QLog.d("notification", 2, "removeNotification");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("notification", 2, "removeNotification", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class MyNetInfoHandler implements INetInfoHandler {
        private static WeakReference<QQAppInterface> mApp;

        public MyNetInfoHandler(QQAppInterface qQAppInterface) {
            mApp = new WeakReference<>(qQAppInterface);
        }

        private void onNetChange4RawPhoto(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(AppConstants.TAG_RAW_PHOTO, 2, "type:" + i3 + ",logmsg:" + str);
            }
            WeakReference<QQAppInterface> weakReference = mApp;
            if (weakReference != null && weakReference.get() != null) {
                if (1 == i3) {
                    mApp.get().onX2Mobile();
                } else if (2 == i3) {
                    mApp.get().onX2Wifi();
                }
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            onNetChange4RawPhoto(3, "onNetMobile2None");
            ReportLog.b("Network", "onNetMobile2None()");
            WeakReference<QQAppInterface> weakReference = mApp;
            if (weakReference != null && weakReference.get() != null) {
                MqqHandler handler = mApp.get().getHandler(FileManagerNotifyCenter.class);
                if (handler != null) {
                    handler.obtainMessage(10001, (Runnable) null).sendToTarget();
                }
                MqqHandler handler2 = mApp.get().getHandler(Conversation.class);
                if (handler2 != null) {
                    handler2.obtainMessage(10003, ((AppInterface) mApp.get()).app.getString(R.string.b3j)).sendToTarget();
                }
                ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(3, ((AppInterface) mApp.get()).app.getString(R.string.b3j));
                FMTSrvAddrProvider.getInstance().clear();
                com.tencent.mobileqq.troop.soso.b.c().b();
                if (((AppInterface) mApp.get()).mHwEngine != null) {
                    ((AppInterface) mApp.get()).mHwEngine.onNetMobile2None();
                }
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            onNetChange4RawPhoto(2, "onNetMobile2Wifi");
            ReportLog.b("Network", "onNetMobile2Wifi()");
            WeakReference<QQAppInterface> weakReference = mApp;
            if (weakReference != null && weakReference.get() != null) {
                QQAppInterface qQAppInterface = mApp.get();
                MqqHandler handler = qQAppInterface.getHandler(FileManagerNotifyCenter.class);
                if (handler != null) {
                    handler.obtainMessage(10001, (Runnable) null).sendToTarget();
                }
                MqqHandler handler2 = qQAppInterface.getHandler(Conversation.class);
                if (handler2 != null) {
                    handler2.obtainMessage(10003, (Runnable) null).sendToTarget();
                }
                ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(3, null);
                FMTSrvAddrProvider.getInstance().clear();
                com.tencent.mobileqq.troop.soso.b.c().b();
                if (((AppInterface) qQAppInterface).mHwEngine != null) {
                    ((AppInterface) qQAppInterface).mHwEngine.onNetMobile2Wifi(str);
                }
                qQAppInterface.tryReuploadQfavItems();
                IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
                if (iEarlyDownloadService != null) {
                    iEarlyDownloadService.onNetChanged();
                }
                MqqHandler handler3 = qQAppInterface.getHandler(ShortVideoPlayActivity.class);
                if (handler3 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPlayActivity.TAG, 2, "onNetMobile2Wifi");
                    }
                    handler3.obtainMessage(5).sendToTarget();
                }
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            onNetChange4RawPhoto(1, "onNetNone2Mobile");
            ReportLog.b("Network", "onNetNone2Mobile()");
            WeakReference<QQAppInterface> weakReference = mApp;
            if (weakReference != null && weakReference.get() != null) {
                QQAppInterface qQAppInterface = mApp.get();
                MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
                if (handler != null) {
                    handler.obtainMessage(10003, (Runnable) null).sendToTarget();
                }
                ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(3, null);
                FMTSrvAddrProvider.getInstance().clear();
                com.tencent.mobileqq.troop.soso.b.c().b();
                if (((AppInterface) qQAppInterface).mHwEngine != null) {
                    ((AppInterface) qQAppInterface).mHwEngine.onNetNone2Mobile(str);
                }
                IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
                if (iEarlyDownloadService != null) {
                    iEarlyDownloadService.onNetChanged();
                }
                MqqHandler handler2 = qQAppInterface.getHandler(ShortVideoPlayActivity.class);
                if (handler2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPlayActivity.TAG, 2, "onNetNone2Mobile");
                    }
                    handler2.obtainMessage(4).sendToTarget();
                }
                wx.b.d().e();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            onNetChange4RawPhoto(2, "onNetNone2Wifi");
            ReportLog.b("Network", "onNetNone2Wifi()");
            WeakReference<QQAppInterface> weakReference = mApp;
            if (weakReference != null && weakReference.get() != null) {
                QQAppInterface qQAppInterface = mApp.get();
                MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
                if (handler != null) {
                    handler.obtainMessage(10003, (Runnable) null).sendToTarget();
                }
                ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(3, null);
                FMTSrvAddrProvider.getInstance().clear();
                com.tencent.mobileqq.troop.soso.b.c().b();
                if (((AppInterface) qQAppInterface).mHwEngine != null) {
                    ((AppInterface) qQAppInterface).mHwEngine.onNetNone2Wifi(str);
                }
                qQAppInterface.tryReuploadQfavItems();
                IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
                if (iEarlyDownloadService != null) {
                    iEarlyDownloadService.onNetChanged();
                }
                MqqHandler handler2 = qQAppInterface.getHandler(ShortVideoPlayActivity.class);
                if (handler2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPlayActivity.TAG, 2, "onNetNone2Wifi");
                    }
                    handler2.obtainMessage(5).sendToTarget();
                }
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            onNetChange4RawPhoto(1, "onNetWifi2Mobile");
            com.tencent.mobileqq.pic.y z16 = com.tencent.mobileqq.pic.y.z1();
            if (z16 != null) {
                z16.N1();
            }
            ReportLog.b("Network", "onNetWifi2Mobile()");
            WeakReference<QQAppInterface> weakReference = mApp;
            if (weakReference != null && weakReference.get() != null) {
                QQAppInterface qQAppInterface = mApp.get();
                MqqHandler handler = qQAppInterface.getHandler(FileManagerNotifyCenter.class);
                if (handler != null) {
                    handler.obtainMessage(10001, (Runnable) null).sendToTarget();
                }
                MqqHandler handler2 = qQAppInterface.getHandler(Conversation.class);
                if (handler2 != null) {
                    handler2.obtainMessage(10003, (Runnable) null).sendToTarget();
                }
                ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(3, null);
                FMTSrvAddrProvider.getInstance().clear();
                com.tencent.mobileqq.troop.soso.b.c().b();
                if (((AppInterface) qQAppInterface).mHwEngine != null) {
                    ((AppInterface) qQAppInterface).mHwEngine.onNetWifi2Mobile(str);
                }
                IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
                if (iEarlyDownloadService != null) {
                    iEarlyDownloadService.onNetChanged();
                }
                MqqHandler handler3 = qQAppInterface.getHandler(ShortVideoPlayActivity.class);
                if (handler3 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ShortVideoPlayActivity.TAG, 2, "onNetWifi2Mobile");
                    }
                    handler3.obtainMessage(4).sendToTarget();
                }
                wx.b.d().e();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            onNetChange4RawPhoto(3, "onNetWifi2None");
            ReportLog.b("Network", "onNetWifi2None()");
            WeakReference<QQAppInterface> weakReference = mApp;
            if (weakReference != null && weakReference.get() != null) {
                QQAppInterface qQAppInterface = mApp.get();
                MqqHandler handler = qQAppInterface.getHandler(FileManagerNotifyCenter.class);
                if (handler != null) {
                    handler.obtainMessage(10001, (Runnable) null).sendToTarget();
                }
                MqqHandler handler2 = qQAppInterface.getHandler(Conversation.class);
                if (handler2 != null) {
                    handler2.obtainMessage(10003, ((AppInterface) qQAppInterface).app.getString(R.string.b3j)).sendToTarget();
                }
                ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(3, ((AppInterface) qQAppInterface).app.getString(R.string.b3j));
                FMTSrvAddrProvider.getInstance().clear();
                com.tencent.mobileqq.troop.soso.b.c().b();
                if (((AppInterface) qQAppInterface).mHwEngine != null) {
                    ((AppInterface) qQAppInterface).mHwEngine.onNetWifi2None();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class QQHeadBroadcastReceiver extends BroadcastReceiver {
        WeakReference<QQAppInterface> mAppRef;

        public QQHeadBroadcastReceiver(QQAppInterface qQAppInterface) {
            this.mAppRef = new WeakReference<>(qQAppInterface);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QQAppInterface.sIsQQHeadBroadcastRegister = true;
            WeakReference<QQAppInterface> weakReference = this.mAppRef;
            if (weakReference != null && weakReference.get() != null) {
                if (this.mAppRef.get().isReleased) {
                    QLog.e(QQAppInterface.QQ_HEAD_BROADCAST, 1, "qqHeadBroadcastReceiver onReceive, app isReleased");
                    return;
                } else {
                    if (intent != null && "com.tencent.qqhead.getheadreq".equals(intent.getAction())) {
                        this.mAppRef.get().addHeadGetTask(intent);
                        return;
                    }
                    return;
                }
            }
            QLog.e(QQAppInterface.QQ_HEAD_BROADCAST, 1, "QQHeadBroadcastReceiver onReceive, mAppRef is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class ServerConfigXMLHandler extends DefaultHandler {
        private HashMap<String, String> elements = new HashMap<>();
        private String preTAG;

        public ServerConfigXMLHandler() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i16) throws SAXException {
            String str = new String(cArr, i3, i16);
            String str2 = this.preTAG;
            if (str2 != null) {
                this.elements.put(str2, str);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            this.preTAG = null;
        }

        public HashMap<String, String> getElements() {
            return this.elements;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            super.startDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            this.preTAG = str2;
        }
    }

    public QQAppInterface(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
        int i3 = QQManagerFactory.COUNT_MANAGER;
        this.mgrLockArray = new Object[i3];
        this.mgrCallingDepthThreadLocal = new ThreadLocal<>();
        this.mgrCallingStackThreadLocal = new ThreadLocal<>();
        this.lockDetectThread = null;
        this.lockDetectHandler = null;
        this.userActiveStatus = 0;
        this.mFirstGetSubAccountName = true;
        this.mSystemMsgInitLock = new Object();
        this.vibrateListenerList = new ArrayList();
        this.mainActivityIsForeground = false;
        this.isMSFConnect = null;
        this.needReuploadQfav = false;
        this.isExitTaskUnfinished = false;
        this.mReportControllerLock = new Object();
        this.managerDestroyIndex = -1;
        this.netHandler = null;
        this.managers = new Manager[i3];
        this.notifyCenterLock = new Object();
        this.isMsfPullFilterConfigInited = false;
        this.msfPullFilterSwitch = true;
        this.qqHeadBroadcastReceiver = new QQHeadBroadcastReceiver(this);
        this.bFirstPacket = true;
        this.qqAccountReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.app.QQAppInterface.6
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intent kickIntent;
                String action = intent.getAction();
                if (action == null) {
                    return;
                }
                if (!action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && !action.equals(NewIntent.ACTION_ACCOUNT_KICKED) && !action.equals(NewIntent.ACTION_ACCOUNT_EXPIRED) && !action.equals(NewIntent.ACTION_FORCE_LOGOUT) && !action.equals(NewIntent.ACTION_LOGOUT)) {
                    if (!action.equals("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName())) {
                        if (action.equals(AppConstants.QQ_KICKED_LOGIN_OTHER_DEVICE)) {
                            String stringExtra = intent.getStringExtra("kickedUin");
                            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(QQAppInterface.this.getAccount()) && (kickIntent = QQAppInterface.this.getKickIntent()) != null) {
                                kickIntent.putExtra("isSameDevice", false);
                                String stringExtra2 = intent.getStringExtra("msg");
                                if (!TextUtils.isEmpty(stringExtra2)) {
                                    kickIntent.putExtra("msg", stringExtra2);
                                }
                                QQAppInterface.this.setKickIntent(kickIntent);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                com.tencent.mobileqq.hitrate.a.b();
                com.tencent.mobileqq.perf.process.foregroud.b.f257916a.g();
                com.tencent.mobileqq.notification.modularize.e.c();
                com.tencent.mobileqq.onlinestatus.manager.c cVar = (com.tencent.mobileqq.onlinestatus.manager.c) ((IOnlineStatusManagerService) QQAppInterface.this.getRuntimeService(IOnlineStatusManagerService.class)).getManager(com.tencent.mobileqq.onlinestatus.manager.c.class);
                if (cVar != null) {
                    cVar.x();
                }
                if (action.equals(NewIntent.ACTION_ACCOUNT_CHANGED)) {
                    QQAppInterface.this.initSkinTheme();
                }
            }
        };
        this.mPreShowKickedNTs = 0L;
        this.friendInfoQueue = new HashSet();
        this.friendListObserver = new ar() { // from class: com.tencent.mobileqq.app.QQAppInterface.8
            @Override // com.tencent.mobileqq.app.ar
            protected void onUpdateFriendInfo(String str2, boolean z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAppInterface_friendListObserver", 2, "onUpdateFriendInfo uin:" + str2 + ",isSuccess:" + z16);
                }
                if (QQAppInterface.this.friendInfoQueue.contains(str2)) {
                    if (QQAppInterface.this.msgFacade.f116353m.getTotalCounter() == 1 && str2 != null && str2.equals(QQAppInterface.this.msgFacade.f116353m.getInBackgroundMessages().get(0).frienduin)) {
                        QQAppInterface qQAppInterface = QQAppInterface.this;
                        if (qQAppInterface.isBackgroundPause && qQAppInterface.isShowMsgContent()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQAppInterface_friendListObserver", 2, "update notifcation");
                            }
                            QQAppInterface qQAppInterface2 = QQAppInterface.this;
                            qQAppInterface2.showMessageNotificationWithPreview(qQAppInterface2.msgFacade.f116353m.getInBackgroundMessages().get(0), false);
                        }
                    }
                    QQAppInterface.this.friendInfoQueue.remove(str2);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQAppInterface_friendListObserver", 2, "removeObserver");
                }
                QQAppInterface.this.removeObserver(this);
            }
        };
        this.isReleased = false;
        this.f194970sp = null;
        this.mMsgTabUnreadListener = null;
        this.isStartSyncOnlineFriend = false;
        this.qzoneBrocastReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.app.QQAppInterface.17
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                QzoneAlbumRedTouchManager qzoneAlbumRedTouchManager;
                if (QQAppInterface.this.isReleased) {
                    QLog.i(QQAppInterface.TAG, 1, "qzoneBrocastReceiver release() has been called  ,return ", null);
                    return;
                }
                String action = intent.getAction();
                if (QQAppInterface.BROADCAST_QZONE_CLEAR_COUNT.equals(action)) {
                    int intExtra = intent.getIntExtra(QQAppInterface.DATANAME_QZONE_CLEAR_COUNT, -1);
                    QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) QQAppInterface.this.getManager(QQManagerFactory.QZONE_MANAGER);
                    if (qZoneManagerImp != null && intExtra != -1) {
                        qZoneManagerImp.w(intExtra, 0L, new ArrayList<>(), null, false, false, "");
                        return;
                    }
                    return;
                }
                if ("com.tecent.qzone.clearAlbumRedTouch".equals(action) && (qzoneAlbumRedTouchManager = (QzoneAlbumRedTouchManager) QQAppInterface.this.getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH)) != null) {
                    qzoneAlbumRedTouchManager.c();
                }
            }
        };
        this.isRealSwitchToBackground = false;
        this.serverConfig = new Hashtable<>();
        this.serverConfigTimeOut = new HashMap<>();
        this.mSecurityDetectBannerIntent = null;
        this.mCallTabShowState = -1;
        this.isCallTabShow = false;
        this.isConversationTabShow = true;
        this.isInCallList = false;
        this.mIsShowNewLeba = false;
        this.mHCMng = null;
        this.isKandianTabShow = false;
        this.mHeadGetIntents = new ConcurrentLinkedQueue<>();
        this.mRunningTaskNum = new AtomicInteger(0);
        this.mConfigProcess = new com.tencent.mobileqq.config.c();
        this.soundAndVibrateUtils = new com.tencent.mobileqq.app.utils.q(baseApplicationImpl, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHeadGetTask(Intent intent) {
        this.mHeadGetIntents.offer(intent);
        runNext();
    }

    @SuppressLint({"MissingPermission"})
    @TargetApi(23)
    private void checkBackgroundRestricWhilteList() {
        boolean z16;
        int i3;
        QLog.d(TAG, 1, "checkBackgroundRestricWhilteList ENTER " + System.currentTimeMillis());
        boolean z17 = false;
        int i16 = 5;
        int[][] iArr = {new int[]{0, 0}, new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 7}, new int[]{4, 7}, new int[]{5, 14}};
        BaseApplication context = BaseApplication.getContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            z16 = connectivityManager.isActiveNetworkMetered();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "checkBackgroundRestricWhilteList: failed. ", e16);
            }
            z16 = false;
        }
        if (z16) {
            int i17 = -1;
            try {
                Method method = connectivityManager.getClass().getMethod("getRestrictBackgroundStatus", new Class[0]);
                method.setAccessible(true);
                i3 = ((Integer) method.invoke(connectivityManager, new Object[0])).intValue();
            } catch (Exception e17) {
                e17.printStackTrace();
                i3 = -1;
            }
            long j3 = 0;
            if (i3 != 2) {
                if (i3 == 3) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("qq_background_restric_whitelist_cfg", 0);
                    int i18 = sharedPreferences.getInt("tips_index", 0);
                    j3 = sharedPreferences.getLong("tips_last_time", 0L);
                    if (i18 == 0) {
                        i17 = i18 + 1;
                        sharedPreferences.edit().putInt("tips_index", i17).putLong("tips_last_time", System.currentTimeMillis()).commit();
                        z17 = true;
                    } else {
                        if (i18 >= 0 && i18 <= 5) {
                            i16 = i18;
                        }
                        if (System.currentTimeMillis() >= (iArr[i16][1] * 86400000) + j3) {
                            i17 = i16 + 1;
                            sharedPreferences.edit().putInt("tips_index", i17).putLong("tips_last_time", System.currentTimeMillis()).commit();
                            z17 = true;
                        } else {
                            i17 = i16;
                        }
                    }
                }
            } else {
                context.getSharedPreferences("qq_background_restric_whitelist_cfg", 0).edit().putInt("tips_index", 0).putLong("tips_last_time", 0L).commit();
            }
            QLog.d(TAG, 1, "checkBackgroundRestricWhilteList isActiveNetworkMetered=" + z16 + " restrictStatus=" + i3 + " tipsIdx=" + i17 + " tipsTime=" + j3 + " notice=" + z17);
            if (z17) {
                Intent intent = new Intent(context, (Class<?>) DialogActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.addFlags(131072);
                intent.putExtra("key_dialog_type", DialogActivity.f175527e0);
                context.startActivity(intent);
            }
        }
        QLog.d(TAG, 1, "checkBackgroundRestricWhilteList END");
    }

    private void checkDialogOnBackground() {
        ComponentName componentName;
        ComponentName componentName2;
        try {
            BaseApplication context = BaseApplication.getContext();
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("checkBackgroundRestricWhilteList onRunningBackground topActivity packageName: ");
                    componentName2 = runningTasks.get(0).topActivity;
                    sb5.append(componentName2.getPackageName());
                    QLog.d(TAG, 2, sb5.toString());
                }
                String packageName = context.getPackageName();
                componentName = runningTasks.get(0).topActivity;
                if (packageName.equals(componentName.getPackageName())) {
                    this.isRealSwitchToBackground = false;
                } else {
                    this.isRealSwitchToBackground = true;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "checkBackgroundRestricWhilteList, ", e16);
        }
    }

    private void checkGetManagerCallingDepthForMGRNotNull(int i3) {
        int intValue;
        if (this.mgrCallingDepthThreadLocal.get() == null) {
            intValue = 0;
        } else {
            intValue = this.mgrCallingDepthThreadLocal.get().intValue();
        }
        if (intValue > 0) {
            StringBuilder sb5 = this.mgrCallingStackThreadLocal.get();
            this.mgrCallingDepthThreadLocal.set(Integer.valueOf(intValue + 1));
            sb5.append(",");
            sb5.append(i3);
        }
    }

    private void checkRamForAvideo() {
        boolean h16 = com.tencent.av.utils.ad.h(getApp());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkRamForAvideo isSelfCalling = " + h16);
        }
        if (h16) {
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkRamForAvideo getAVNotifyCenter().isBeInvitingOnDoubleVideo() = ");
            getAVNotifyCenter();
            sb5.append(AVNotifyCenter.V());
            QLog.d(TAG, 2, sb5.toString());
            QLog.d(TAG, 2, "checkRamForAvideo getAVNotifyCenter().isAvChating() = " + getAVNotifyCenter().U());
        }
        getAVNotifyCenter();
        if (AVNotifyCenter.V() && !getAVNotifyCenter().U()) {
            return;
        }
        long c16 = (com.tencent.mobileqq.utils.m.c() / 1024) / 1024;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkRamForAvideo memoryTotal = " + c16);
        }
        if (isVideoChatting() && c16 != 0 && c16 <= 2048) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.20
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(((AppInterface) QQAppInterface.this).app.getApplicationContext(), R.string.f170548u1, 5000).show();
                }
            });
        }
    }

    public static String getBuddyFaceFilePath(String str) {
        return com.tencent.mobileqq.avatar.utils.c.d(str);
    }

    public static Bitmap getCircleFaceBitmap(Bitmap bitmap, int i3, int i16) {
        return com.tencent.mobileqq.avatar.utils.c.e(bitmap, i3, i16);
    }

    private String getCurrentProcess() {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            QLog.d(TAG, 1, "failed to get current process name");
            return null;
        }
    }

    public static String getCurrentThemeId() {
        return ThemeUtil.getCurrentThemeId();
    }

    @NotNull
    private Intent getDefaultIntentByUin(Context context, int i3, String str) {
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        aliasIntent.putExtra("uin", str);
        aliasIntent.putExtra("uintype", i3);
        Intent m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
        m3.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
        return m3;
    }

    @NotNull
    public static String getFaceSettingKey(int i3, String str, int i16) {
        return com.tencent.mobileqq.avatar.utils.c.j(i3, str, i16);
    }

    private Intent getIntentByUin(Context context, com.tencent.imcore.message.Message message, int i3) {
        String string;
        Intent intent;
        Intent b16;
        String str;
        String string2;
        String str2 = message.frienduin;
        if (i3 == 1026) {
            i3 = 1;
        }
        String str3 = AppConstants.FRIEND_SYSTEM_MSG_UIN;
        if (!String.valueOf(str3).equals(str2) && !AppConstants.MAYKNOW_RECOMMEND_UIN.equals(str2) && !AppConstants.FRIEND_ANNIVER_UIN.equals(str2)) {
            if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(str2)) {
                str2 = context.getString(R.string.huc);
                intent = new Intent(context, (Class<?>) QPublicFragmentActivity.class);
                intent.putExtra("public_fragment_class", ((ILaunchTroopSysMsgUIUtilApi) QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).getFragmentNameForLaunch());
            } else if (String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(str2)) {
                intent = new Intent(context, (Class<?>) QQBroadcastActivity.class);
                str2 = context.getString(R.string.hub);
            } else if (String.valueOf(AppConstants.VOTE_MSG_UIN).equals(str2)) {
                str2 = context.getString(R.string.huc);
                intent = new Intent(context, (Class<?>) VisitorsActivity.class);
                intent.putExtra("votersOnly", true);
                intent.putExtra("toUin", Long.valueOf(getCurrentAccountUin()));
            } else {
                String str4 = AppConstants.DATALINE_PC_UIN;
                if (String.valueOf(str4).equals(str2)) {
                    intent = new Intent(context, (Class<?>) LiteActivity.class);
                    intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str4);
                    str2 = context.getString(R.string.c5f);
                } else {
                    String str5 = AppConstants.DATALINE_PHONE_UIN;
                    if (String.valueOf(str5).equals(str2)) {
                        intent = new Intent(context, (Class<?>) LiteActivity.class);
                        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str5);
                        str2 = context.getString(R.string.f16273218);
                    } else {
                        String str6 = AppConstants.DATALINE_IPAD_UIN;
                        if (String.valueOf(str6).equals(str2)) {
                            intent = new Intent(context, (Class<?>) LiteActivity.class);
                            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str6);
                            if (((RegisterProxySvcPackHandler) getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                                string2 = context.getString(R.string.c5g);
                            } else {
                                string2 = context.getString(R.string.f16272217);
                            }
                            str2 = string2;
                        } else if (String.valueOf(9973L).equals(str2)) {
                            Intent intent2 = new Intent(context, (Class<?>) ActivateFriendActivity.class);
                            str2 = context.getString(R.string.f170010ct);
                            intent2.setFlags(67108864);
                            intent2.putExtra("af_key_from", 4);
                            intent2.putExtra("msg_hash", message.uniseq);
                            intent = intent2;
                        } else if (i3 == 7000) {
                            String string3 = context.getString(R.string.hrx);
                            Intent intent3 = new Intent(context, ((IAssociatedAccountApi) QRoute.api(IAssociatedAccountApi.class)).getAssociatedAccountActivity());
                            intent3.putExtra("subAccount", str2);
                            ISubAccountService iSubAccountService = (ISubAccountService) getRuntimeService(ISubAccountService.class, "");
                            if (iSubAccountService != null) {
                                str = iSubAccountService.getLatestUinNick(str2);
                            } else {
                                str = str2;
                            }
                            intent3.putExtra("subAccountLatestNick", str);
                            intent3.putExtra("finishAIO", true);
                            intent3.putExtra("uin", str2);
                            intent3.putExtra("uintype", i3);
                            str2 = string3;
                            intent = intent3;
                        } else {
                            if (i3 != 1044 && i3 != 1045) {
                                if (i3 == 1046) {
                                    string = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getNotificationTitle();
                                    intent = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getNotificationIntent(context, str2);
                                } else if (i3 == 10007) {
                                    intent = ((ITempApi) QRoute.api(ITempApi.class)).getIntentFromMsg(context, message, this);
                                } else if (i3 == 0) {
                                    b16 = getDefaultIntentByUin(context, i3, str2);
                                    str2 = com.tencent.mobileqq.utils.ac.R(this, str2, i3);
                                    if (message.msgtype == -5008) {
                                        com.tencent.mobileqq.listentogether.g.d(this, message, b16);
                                    }
                                } else if (i3 == 1) {
                                    if (((ITroopGuildMsgApi) QRoute.api(ITroopGuildMsgApi.class)).isTroopGuildPushMsg(message)) {
                                        intent = ((ITroopGuildMsgApi) QRoute.api(ITroopGuildMsgApi.class)).getTroopGuildPushMsgIntent(context, message);
                                        str2 = com.tencent.mobileqq.utils.ac.R(this, str2, i3);
                                    } else {
                                        b16 = getDefaultIntentByUin(context, i3, str2);
                                        str2 = com.tencent.mobileqq.utils.ac.R(this, str2, i3);
                                        if (message.msgtype == -5008) {
                                            com.tencent.mobileqq.listentogether.g.d(this, message, b16);
                                        }
                                    }
                                } else if (i3 == 10014) {
                                    IGuildMessageUtilsApi iGuildMessageUtilsApi = (IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class);
                                    String valueOf = String.valueOf(iGuildMessageUtilsApi.getGuildIdFromMR(message));
                                    GuildManageNoticePushMsg guildManageNoticePushMsgFromMr = iGuildMessageUtilsApi.getGuildManageNoticePushMsgFromMr(message);
                                    if (guildManageNoticePushMsgFromMr != null) {
                                        string = guildManageNoticePushMsgFromMr.getTitle();
                                    } else {
                                        string = com.tencent.mobileqq.utils.ac.R(this, valueOf, i3);
                                    }
                                    intent = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getGuildIntent(context, message, true, str2);
                                } else {
                                    intent = getDefaultIntentByUin(context, i3, str2);
                                    if (i3 == 1024) {
                                        intent.putExtra("chat_subType", 1);
                                    }
                                    if (i3 == 1009) {
                                        str2 = context.getString(R.string.h3p);
                                    } else if (String.valueOf(AppConstants.APP_ASSISTANT_UIN).equals(str2)) {
                                        str2 = context.getString(R.string.f170348p5);
                                    } else if (i3 == 1024) {
                                        str2 = com.tencent.mobileqq.utils.ac.R(this, str2, i3);
                                    } else {
                                        str2 = com.tencent.mobileqq.utils.ac.R(this, str2, i3);
                                    }
                                }
                            } else {
                                if (!TextUtils.isEmpty(str2)) {
                                    str2 = com.tencent.mobileqq.utils.ac.g(this, str2, false);
                                } else {
                                    str2 = HardCodeUtil.qqStr(R.string.qly);
                                }
                                b16 = MatchChatMsgUtil.b(context);
                                b16.putExtra("key_matchchat_from_notification", true);
                                b16.putExtra("key_matchchat_from_notification_uin", message.frienduin);
                                b16.putExtra("key_matchchat_from_notification_type", i3);
                            }
                            intent = b16;
                        }
                    }
                }
            }
            intent.putExtra("uinname", str2);
            return intent;
        }
        string = context.getString(R.string.cil);
        Intent newFriendJumpIntent = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getNewFriendJumpIntent(context);
        if (str3.equals(str2)) {
            newFriendJumpIntent.putExtra("from", "from_notification");
            int a16 = com.tencent.mobileqq.activity.contact.newfriend.b.a(message);
            newFriendJumpIntent.putExtra(NewFriendFragment.ARGS_FROM_SUBTYPE, a16);
            if (a16 == 6) {
                ((INewFriendApi) QRoute.api(INewFriendApi.class)).report(this, "0X800A181");
            } else if (a16 == 9 || a16 == 10 || a16 == 1) {
                ((INewFriendApi) QRoute.api(INewFriendApi.class)).report(this, "0X8009CBA");
            }
        }
        newFriendJumpIntent.putExtra("EntranceId", 1);
        intent = newFriendJumpIntent;
        str2 = string;
        intent.putExtra("uinname", str2);
        return intent;
    }

    private Intent getIntentForTroopStranger(Context context, com.tencent.imcore.message.Message message, boolean z16) {
        Intent aliasIntent = SplashActivity.getAliasIntent(context);
        aliasIntent.putExtra("uin", message.frienduin);
        aliasIntent.putExtra("troop_uin", message.senderuin);
        aliasIntent.putExtra("uintype", message.istroop);
        aliasIntent.putExtra("uinname", getTroopDisscussMemberNick(message, z16));
        Intent m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
        m3.setAction("com.tencent.mobileqq.action.CHAT");
        return m3;
    }

    private void getManagerCompatibleWithOldLogic(int i3, Manager manager) {
        if (i3 == QQManagerFactory.PROXY_MANAGER) {
            this.proxyManager = (ProxyManager) manager;
            return;
        }
        if (i3 == QQManagerFactory.CACHE_MANAGER) {
            this.cacheManager = (com.tencent.mobileqq.app.asyncdb.a) manager;
            return;
        }
        if (i3 == QQManagerFactory.MGR_MSG_FACADE) {
            this.msgFacade = (QQMessageFacade) manager;
            onCreateQQMessageFacade(this.msgFacade);
        } else if (i3 == QQManagerFactory.CONVS_FACADE) {
            this.convsFacade = (ConversationFacade) manager;
        } else if (i3 == QQManagerFactory.HOT_CHAT_MANAGER) {
            this.mHCMng = (ay) manager;
        }
    }

    public static boolean getMsfPullFilterSwitch(QQAppInterface qQAppInterface) {
        if (!qQAppInterface.isMsfPullFilterConfigInited) {
            String account = qQAppInterface.getAccount();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp());
            if (defaultSharedPreferences.contains(account + "_" + AppConstants.Preferences.LONG_TEXT_MSG_CONFIG_VERSION)) {
                qQAppInterface.msfPullFilterSwitch = defaultSharedPreferences.getBoolean(account + "_msfpull_filter_switch", true);
            }
        }
        qQAppInterface.isMsfPullFilterConfigInited = true;
        return qQAppInterface.msfPullFilterSwitch;
    }

    private SharedPreferences getPref() {
        if (this.f194970sp == null) {
            this.f194970sp = PreferenceManager.getDefaultSharedPreferences(getApp());
        }
        return this.f194970sp;
    }

    public static Bitmap getRoundFaceBitmap(Bitmap bitmap) {
        return com.tencent.mobileqq.avatar.utils.c.l(bitmap);
    }

    public static Bitmap getShapeRoundFaceBitmap(Bitmap bitmap, int i3, int i16, int i17) {
        return com.tencent.mobileqq.avatar.utils.c.m(bitmap, i3, i16, i17);
    }

    private String getTroopDisscussMemberNick(com.tencent.imcore.message.Message message, boolean z16) {
        String showName;
        int i3 = message.istroop;
        if (i3 != 1000 && i3 != 1020) {
            showName = com.tencent.mobileqq.utils.ac.n(this, message.senderuin, message.frienduin);
        } else {
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(message.senderuin, message.frienduin, null, TAG);
            showName = troopMemberInfoSync != null ? troopMemberInfoSync.nickInfo.getShowName() : message.frienduin;
        }
        if (TextUtils.isEmpty(showName) || showName.equals(message.frienduin)) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(message.frienduin), TAG);
            if (friendsSimpleInfoWithUid != null) {
                showName = !TextUtils.isEmpty(friendsSimpleInfoWithUid.r()) ? friendsSimpleInfoWithUid.r() : friendsSimpleInfoWithUid.p();
            }
            if (z16 && ((TextUtils.isEmpty(showName) || showName.equals(message.frienduin)) && !this.friendInfoQueue.contains(message.frienduin))) {
                this.friendInfoQueue.add(message.frienduin);
                FriendListHandler friendListHandler = (FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                addObserver(this.friendListObserver);
                if (QLog.isColorLevel()) {
                    QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
                }
                friendListHandler.getFriendInfo(message.frienduin);
            }
        }
        return (showName == null || "".equals(showName)) ? message.frienduin : showName;
    }

    private String getVersionName() {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.app.getPackageManager(), this.app.getPackageName(), 0);
            if (packageInfo == null) {
                return AEResManagerConfigBean.DEFAULT_VERSION;
            }
            String str = packageInfo.versionName;
            if (str == null) {
                return AEResManagerConfigBean.DEFAULT_VERSION;
            }
            if (str != null) {
                try {
                    String[] split = str.split("\\.");
                    for (int i3 = 3; i3 > split.length; i3--) {
                        str = str + ".0";
                    }
                } catch (Exception unused) {
                }
            }
            return str;
        } catch (Exception unused2) {
            return AEResManagerConfigBean.DEFAULT_VERSION;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void headQQHeadBroadcast(Intent intent) {
        ((IQQAvatarBroadcastService) getRuntimeService(IQQAvatarBroadcastService.class, "")).headQQHeadBroadcast(intent);
    }

    private void initAbout() {
        if (this.aboutConfig == null) {
            AboutConfig aboutConfig = new AboutConfig(this);
            this.aboutConfig = aboutConfig;
            aboutConfig.m();
        }
    }

    @Deprecated
    private void initCallTabShowState() {
        boolean z16;
        if (this.mCallTabShowState != -1) {
            return;
        }
        String readValue = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY, AppConstants.CallTabType.CALLTAB_DEFAULTVAL);
        if (readValue != null && readValue.length() <= 7) {
            if (readValue.length() < 7) {
                readValue = readValue + AppConstants.CallTabType.CALLTAB_DEFAULTVAL.substring(readValue.length());
            }
            char c16 = readValue.toCharArray()[6];
            final StringBuilder sb5 = new StringBuilder(readValue);
            if ('0' != c16) {
                sb5.setCharAt(6, '0');
                z16 = true;
            } else {
                z16 = false;
            }
            this.mCallTabShowState = 0;
            this.isCallTabShow = false;
            if (z16) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.18
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.i(QQAppInterface.TAG, 2, "isCallTabShow needupdate,result=" + ((Object) sb5));
                        }
                        SettingCloneUtil.writeValue(QQAppInterface.this.getApplication(), QQAppInterface.this.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY, sb5.toString());
                    }
                }, 8, null, false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "isCallTabShow fullVal is null");
        }
    }

    public static void initHeadCfg() {
        int i3 = 0;
        try {
            String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), IDPCApiConstant.HEAD_CONFIG_DEFAULT);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "initHeadCfg, " + featureValueWithoutAccountManager);
            }
            String[] split = featureValueWithoutAccountManager.split("\\|");
            if (split.length > 0 && (i3 = Integer.parseInt(split[0])) >= 1 && i3 <= 168) {
                CHECK_FACE_UPDATE_PERIOD = i3 * 60 * 60 * 1000;
            }
        } catch (Exception e16) {
            CHECK_FACE_UPDATE_PERIOD = 86400000L;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "initHeadCfg error", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initHeadCfg," + i3 + "," + CHECK_FACE_UPDATE_PERIOD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSkinTheme() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.7
            @Override // java.lang.Runnable
            public void run() {
                ThemeUtil.initTheme(QQAppInterface.this);
            }
        }, SimpleUIManager.getDelayMillions(this));
    }

    @TargetApi(19)
    public static int isNotificationEnabled() {
        return QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext()) ? 1 : 0;
    }

    public static EntityManager ktBridgeForEntityManager(QQAppInterface qQAppInterface) {
        return qQAppInterface.getEntityManagerFactory().createEntityManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendBindUinOffline$0() {
        ArrayList<String> allSubUin;
        if (!TextUtils.isEmpty(getAccount()) && (allSubUin = ((ISubAccountService) getRuntimeService(ISubAccountService.class, "")).getAllSubUin()) != null && allSubUin.size() != 0) {
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), (byte) 0, allSubUin);
        }
    }

    private void makeSureHeadBroadcastAvailable() {
        try {
            getApp().sendBroadcast(new Intent(FaceConstant.HeadBroadcast.BROADCAST_QQHEAD_REFRESH_HEAD_REQ), QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[maskeSureHeadBroadcastAvailable]", th5);
        }
    }

    private void notifyMessageReceived(com.tencent.imcore.message.Message message, boolean z16, boolean z17) {
        boolean z18;
        QLog.d(TAG, 1, "notifyMessageReceived: entryA message.frienduin=" + message.frienduin + ", message.senderuin=" + message.senderuin + ", needSoundVibrationsTip " + z16 + " , isOnline " + z17 + "\uff0c  msg " + message.f203106msg + "\uff0c" + message.istroop);
        if (!((NotificationController) getBusinessHandler(BusinessHandlerFactory.NOTIFICATION_CONTROLLER_HANDLER)).shouldNotify(message.frienduin, message.istroop)) {
            QLog.i(TAG, 1, "notifyMessageReceived, should not notify");
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            onSystemNotificationShow(message);
            if (isShowMsgContent()) {
                showMessageNotificationWithPreview(message, true);
            } else {
                showMessageNotificationNoPreview(message, true);
            }
            if (Cdo.i(this.userActiveStatus, message, z16)) {
                this.soundAndVibrateUtils.r(message, z17);
            }
        }
    }

    private void onLineStatusOnAppForeground() {
        com.tencent.mobileqq.onlinestatus.manager.c cVar = (com.tencent.mobileqq.onlinestatus.manager.c) ((IOnlineStatusManagerService) getRuntimeService(IOnlineStatusManagerService.class)).getManager(com.tencent.mobileqq.onlinestatus.manager.c.class);
        if (cVar != null) {
            cVar.u(TAG);
        }
    }

    private void onRunningBackgroundWithAccount() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onRunningBackgroundWithAccount");
        }
        ((IPhoneContactService) getRuntimeService(IPhoneContactService.class, "")).onAppRunBackground();
        NTMsgMigrationManager.X().S0();
    }

    private void onRunningForegroundWithAccount() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onRunningForegroundWithAccount");
        }
        ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        IQQReminderDataService iQQReminderDataService = (IQQReminderDataService) getRuntimeService(IQQReminderDataService.class, "");
        if (activateFriendsManager != null) {
            activateFriendsManager.m();
            iQQReminderDataService.checkTodayReminder();
        }
        IQQReminderOfTianshuService iQQReminderOfTianshuService = (IQQReminderOfTianshuService) getRuntimeService(IQQReminderOfTianshuService.class, "");
        if (iQQReminderOfTianshuService != null) {
            iQQReminderOfTianshuService.getReminderDataFromTianshu(1);
        }
        ((IPhoneContactService) getRuntimeService(IPhoneContactService.class, "")).onAppRunForeground();
        startAllSubMessageAccountMsg(false);
        ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) getRuntimeService(ISubAccountControlService.class, "");
        if (iSubAccountControlService != null && iSubAccountControlService.getIsThirdUnreadReqSkip()) {
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).startGetThirdQQUnreadNum(this, true);
            iSubAccountControlService.setIsThirdUnreadReqSkip(false);
        }
        NTMsgMigrationManager.X().T0();
    }

    private void onSystemNotificationShow(com.tencent.imcore.message.Message message) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ((IQQReminderMsgService) peekAppRuntime.getRuntimeService(IQQReminderMsgService.class, ProcessConstant.MULTI)).onSystemNotificationShow(message);
        }
    }

    private void registerAccountReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
        intentFilter.addAction(AppConstants.QQ_KICKED_LOGIN_OTHER_DEVICE);
        this.app.registerReceiver(this.qqAccountReceiver, intentFilter);
    }

    private void release() {
        if (this.isReleased) {
            return;
        }
        QLog.d(TAG, 1, "release");
        this.isReleased = true;
        vy2.b.f443707a = false;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.reportForegroundRunningTime(false, MobileQQ.processName);
        }
        com.tencent.mobileqq.dt.b.i();
        this.mAutomator.onDestroy();
        HeavyTaskExecutor.a(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.10
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                com.tencent.mobileqq.service.d dVar = QQAppInterface.this.mqqService;
                if (dVar != null) {
                    dVar.destroy();
                }
                for (final int i3 = 0; i3 < QQAppInterface.this.managers.length; i3++) {
                    Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QQAppInterface.this.managerDestroyIndex = i3;
                            Manager manager = QQAppInterface.this.managers[i3];
                            if (manager != null) {
                                manager.onDestroy();
                            }
                        }
                    };
                    if (QQManagerFactory.INSTANCE.getDestroyMgrWhenDestroy()) {
                        if (QQAppInterface.this.mgrLockArray[QQAppInterface.this.mgrLockArray.length - 1] == null) {
                            synchronized (QQAppInterface.this.mgrLockArray) {
                                if (QQAppInterface.this.mgrLockArray[QQAppInterface.this.mgrLockArray.length - 1] == null) {
                                    for (int i16 = 0; i16 < QQAppInterface.this.mgrLockArray.length; i16++) {
                                        QQAppInterface.this.mgrLockArray[i16] = new Object();
                                    }
                                }
                            }
                        }
                        if (!AppSetting.f99556p) {
                            obj = QQAppInterface.this.managers;
                        } else {
                            obj = QQAppInterface.this.mgrLockArray[i3];
                        }
                        synchronized (obj) {
                            runnable.run();
                        }
                    } else {
                        runnable.run();
                    }
                }
                QLog.i(QQAppInterface.TAG, 1, "release|all manager destroy");
                QQAppInterface.this.releaseImportRuntimeService();
            }
        });
        VideoBroadcastReceiver.o0();
        ((IQQAvatarDecoderApi) QRoute.api(IQQAvatarDecoderApi.class)).closeFaceDecodeThread();
        FileManagerEngine fileManagerEngine = this.mFileManagerEngine;
        if (fileManagerEngine != null) {
            fileManagerEngine.I();
        }
        NTFileManageBridger nTFileManageBridger = this.ntFileManageBridger;
        if (nTFileManageBridger != null) {
            nTFileManageBridger.D0();
        }
        iv.d dVar = this.qavOfflineMsgCenter;
        if (dVar != null) {
            dVar.c();
        }
        com.tencent.mobileqq.notification.modularize.r.INSTANCE.a(this).m();
        ((IPskeyManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPskeyManager.class, "")).onAppDestory();
        com.tencent.biz.qrcode.logindev.pclock.e.f94954a.g();
        ZPlanNTPushCenter.f254262a.f();
        ((IRelationNTPushService) QRoute.api(IRelationNTPushService.class)).unRegisterRelationNTPush();
        RecentUserProxy recentUserProxy = this.mRecentUserProxy;
        if (recentUserProxy != null) {
            recentUserProxy.onDestroy();
        }
        WinkPublishHelper2.INSTANCE.unBindService();
        ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).shutdownWySystem();
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).onDestroy();
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).onDestroy();
        com.tencent.mobileqq.equipmentlock.c.m();
        PluginManageHandler.getInstance().setPluginManagerProvider(null, false);
        SessionInfo.clearOldSession();
        HwEngine hwEngine = this.mHwEngine;
        if (hwEngine != null) {
            hwEngine.closeEngine();
        }
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).resetDeleteOldKandian();
        ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).resetPublicAccountConfig(getCurrentUin());
        ((IPublicAccountSearchRecommendManager) QRoute.api(IPublicAccountSearchRecommendManager.class)).reset();
        QQIndividualityPluginProxyService.b();
        nn2.a.f420530a = false;
        FaceScanDownloadManager.b();
        com.tencent.mobileqq.activity.contact.newfriend.a.h();
        ((IAccountApi) QRoute.api(IAccountApi.class)).release();
        HeavyTaskExecutor.a(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.11
            @Override // java.lang.Runnable
            public void run() {
                TroopFileManager.g();
            }
        });
        TroopFileDownloadMgr.g().m();
        TroopFileThumbnailMgr.j().l();
        com.tencent.mobileqq.troop.utils.ah.a(this);
        ((INotifyMsgApi) QRoute.api(INotifyMsgApi.class)).onActiveAccount();
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).clearInstance(this);
        ((IGuildRuntimeApi) QRoute.api(IGuildRuntimeApi.class)).handleAccountRelease();
        WadlProxyServiceUtil.release();
        com.tencent.mobileqq.intervideo.yiqikan.f.c();
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).onAppDestroy();
        com.tencent.mobileqq.webview.swift.cookie.c.j();
        SwiftBrowserCookieMonster.H();
        ((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).reset();
        onRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runNext() {
        final Intent poll;
        if (QLog.isDevelopLevel()) {
            QLog.i(QQ_HEAD_BROADCAST, 2, "runNext," + this.mRunningTaskNum.get() + "," + this.mHeadGetIntents.size());
        }
        if (this.mRunningTaskNum.get() < 2 && !this.mHeadGetIntents.isEmpty() && (poll = this.mHeadGetIntents.poll()) != null) {
            this.mRunningTaskNum.incrementAndGet();
            final long currentTimeMillis = System.currentTimeMillis();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.19
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (QLog.isDevelopLevel()) {
                        QLog.i(QQAppInterface.QQ_HEAD_BROADCAST, 2, "runNext, ThreadManager.excute, cost=" + currentTimeMillis2);
                    }
                    try {
                        QQAppInterface.this.headQQHeadBroadcast(poll);
                    } catch (Exception e16) {
                        QLog.e(QQAppInterface.QQ_HEAD_BROADCAST, 1, "runNext exception", e16);
                    }
                    QQAppInterface.this.mRunningTaskNum.decrementAndGet();
                    QQAppInterface.this.runNext();
                }
            }, 128, null, true);
        }
    }

    private void sendBindUinOffline() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.ch
            @Override // java.lang.Runnable
            public final void run() {
                QQAppInterface.this.lambda$sendBindUinOffline$0();
            }
        }, 16, null, false);
    }

    private boolean shouldPostponeMediaPredownloadSwitchOff() {
        try {
            boolean decodeBool = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeBool("postpone_media_predownload_switch_off", true);
            QLog.i("PicPreDownload", 1, "[shouldPostponeMediaPredownloadSwitchOff] switch=" + decodeBool);
            return decodeBool;
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[shouldPostponeMediaPredownloadSwitchOff] exc=" + th5);
            return false;
        }
    }

    private void showKickedNotification(Intent intent) {
        String stringExtra = intent.getStringExtra("title");
        String a16 = com.tencent.mobileqq.qqsec.api.b.a(intent.getStringExtra("msg"));
        if (SystemClock.elapsedRealtime() - this.mPreShowKickedNTs > 5000) {
            intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 6);
            intent.putExtra(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, true);
            showNotificationWithoutMessage(new com.tencent.mobileqq.app.notification.struct.e(intent, a16, stringExtra, a16, null), "CMD_SHOW_NOTIFIYCATION");
            this.mPreShowKickedNTs = SystemClock.elapsedRealtime();
        }
    }

    private void showMessageNotificationNoPreview(com.tencent.imcore.message.Message message, boolean z16) {
        Intent intentByMessage;
        int counterByType;
        String str;
        String string;
        int i3;
        if (!this.isFinished && com.tencent.mobileqq.util.az.a(this.app.getApplicationContext(), this) && !com.tencent.mobileqq.util.az.c(this.app.getApplicationContext(), this) && com.tencent.mobileqq.message.newmsg.a.d(this).l(message)) {
            if (this.msgFacade.f116353m.getNewConversationSizeWithoutPublicAccount() != 1 && (i3 = message.istroop) != 1044 && i3 != 1045) {
                intentByMessage = SplashActivity.getAliasIntent(getApp());
                intentByMessage.addFlags(335544320);
                intentByMessage.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            } else {
                intentByMessage = getIntentByMessage(getApp(), message, false);
                intentByMessage.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 6);
            }
            Intent d16 = this.messageNotifiableChecker.d(message, intentByMessage);
            d16.putExtra(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, true);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getApp().getString(R.string.cl8));
            int i16 = message.istroop;
            if (i16 != 1044 && i16 != 1045) {
                counterByType = this.msgFacade.f116353m.getTotalCounter();
            } else {
                counterByType = this.msgFacade.f116353m.getCounterByType(1044) + this.msgFacade.f116353m.getCounterByType(1045);
            }
            if (counterByType == 0) {
                return;
            }
            if (counterByType > 1000) {
                stringBuffer.append(getApp().getString(R.string.ckx));
            } else {
                stringBuffer.append(counterByType);
                stringBuffer.append(getApp().getString(R.string.cip));
            }
            if (z16) {
                str = stringBuffer.toString();
            } else {
                str = null;
            }
            String str2 = str;
            int i17 = message.istroop;
            if (i17 != 1045 && i17 != 1044) {
                string = getApp().getResources().getString(R.string.notification_title);
            } else {
                string = getApp().getResources().getString(R.string.fio);
            }
            br.f(this, message, new com.tencent.mobileqq.app.notification.struct.e(d16, str2, string, stringBuffer.toString(), null), "CMD_SHOW_NOTIFIYCATION");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessageNotificationWithPreview(com.tencent.imcore.message.Message message, boolean z16) {
        ThirdPushManager.getInstance().clearNotificationsBackground(getApplicationContext());
        this.messageNotificationGenerator = new br(this);
        if (bq.a(this, message)) {
            this.messageNotificationGenerator.g(this, message, z16);
        }
    }

    public static void speak(String str) {
        com.tencent.mobileqq.util.bq.c(str);
    }

    private void startActivitySafe(Context context, Intent intent, String str) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e16) {
            QQToast.makeText(context, str, 1).show();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "startActivitySafe fail", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterHeadBroadcastReceiver() {
        try {
            this.app.unregisterReceiver(this.qqHeadBroadcastReceiver);
            sIsQQHeadBroadcastRegister = false;
            QLog.i(QQ_HEAD_BROADCAST, 1, "unregister qqHeadBroadcastReceiver");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "unregister qqHeadBroadcastReceiver error", e16);
        }
    }

    private void useAsyncOffline() {
        boolean z16;
        IKernelService iKernelService = (IKernelService) getRuntimeService(IKernelService.class, "");
        AudioManager audioManager = (AudioManager) BaseApplication.context.getSystemService("audio");
        if (SystemMethodProxy.getStreamVolume(audioManager, 3) != 0 && audioManager.getRingerMode() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        DeviceInfo deviceInfo = new DeviceInfo(HexUtil.bytes2HexStr(((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).getGUID()), AppSetting.f99542b, AppActivity.localeId, Build.BRAND + "-" + DeviceInfoMonitor.getModel(), Build.DEVICE, ROMUtil.getRomName(), Build.VERSION.RELEASE, ROMUtil.getRomVersion(), z16, BaseApplication.getContext().getThirdPushType());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        iKernelService.offLine(new UnregisterInfo(deviceInfo), new IOperateCallback() { // from class: com.tencent.mobileqq.app.QQAppInterface.21
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public void onResult(int i3, String str) {
                countDownLatch.countDown();
                QLog.d(QQAppInterface.TAG, 1, "offline: result: ", Integer.valueOf(i3), " errMsg: ", str);
            }
        });
        try {
            QLog.d(TAG, 1, "userLogoutWhenSendState: ", Boolean.valueOf(countDownLatch.await(200L, TimeUnit.MILLISECONDS)));
        } catch (InterruptedException unused) {
            QLog.w(TAG, 1, "userLogoutWhenSendState error");
        }
    }

    private void useSyncOffline() {
        QLog.d(TAG, 1, "offline: result: ", Boolean.valueOf(((IKernelService) getRuntimeService(IKernelService.class, "")).offLineSync(true)));
    }

    public void addAboutListener(ResourcePluginListener resourcePluginListener) {
        initAbout();
        this.aboutConfig.h(resourcePluginListener);
    }

    public void addManager(boolean z16) {
        addManager(z16, 0L);
    }

    public void addVibrateListener(dm dmVar) {
        if (dmVar == null || this.vibrateListenerList.indexOf(dmVar) >= 0) {
            return;
        }
        this.vibrateListenerList.add(dmVar);
    }

    public boolean canPlaySound() {
        return this.soundAndVibrateUtils.a();
    }

    boolean canPlayThemeSound() {
        String userCurrentThemeId;
        ThemeUtil.ThemeInfo themeInfo;
        if (canPlaySound() && (userCurrentThemeId = ThemeUtil.getUserCurrentThemeId(this)) != null && !userCurrentThemeId.equals("1000") && (themeInfo = ThemeUtil.getThemeInfo(getApplication(), userCurrentThemeId)) != null && themeInfo.isVoiceTheme) {
            return true;
        }
        return false;
    }

    public boolean canVibrator() {
        return this.soundAndVibrateUtils.b();
    }

    public void cancelNotification() {
        try {
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            qQNotificationManager.cancel("QQAppInterface_cancelNotification", 265);
            qQNotificationManager.cancel("QQAppInterface_cancelNotification", 275);
            qQNotificationManager.cancel("QQAppInterface_cancelNotification", 527);
        } catch (Exception unused) {
        }
        showIdleNotification(getApp(), null);
    }

    @Override // mqq.app.AppRuntime
    public void cancelSyncOnlineFriend(long j3) {
        if (j3 >= 0) {
            sLastGetOnlineFriendTime = j3;
        }
        sGetOnlineFriendHandler.removeMessages(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkAndGetSelfNickName() {
        boolean z16;
        FriendListHandler friendListHandler;
        String currentAccountUin = getCurrentAccountUin();
        String f16 = com.tencent.mobileqq.utils.ac.f(this, currentAccountUin);
        if (!TextUtils.isEmpty(currentAccountUin) && currentAccountUin.equals(f16)) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(currentAccountUin), TAG);
            if ((friendsSimpleInfoWithUid == null || friendsSimpleInfoWithUid.p() == null) && (friendListHandler = (FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) != null) {
                friendListHandler.getFriendInfo(currentAccountUin);
                z16 = true;
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "checkAndGetSelfNickName, [" + f16 + "," + z16 + "]");
                }
                return z16;
            }
        }
        z16 = false;
        if (QLog.isDevelopLevel()) {
        }
        return z16;
    }

    public void clearMsgCounter() {
        if (this.msgFacade != null) {
            this.msgFacade.f116353m.clearMessageCounter();
        }
        if (!TextUtils.isEmpty(getAccount())) {
            ((ISubAccountService) getRuntimeService(ISubAccountService.class, "")).clearAllUnNotifySenderNum();
        }
        ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        if (activateFriendsManager != null) {
            activateFriendsManager.n();
        }
    }

    public void deleteStrangerFace(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.QQ_HEAD, 2, "deleteStrangerFace.id=" + str + ",idType=" + i3);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i3 != 200 && i3 != 204 && i3 != 202) {
            return;
        }
        removeFaceIconCache(32, str, i3);
        File file = new File(getCustomFaceFilePath(32, str, i3));
        if (file.exists()) {
            file.delete();
        }
    }

    public void execute(Runnable runnable) {
        ThreadManagerV2.executeOnNetWorkThread(runnable);
    }

    @Override // mqq.app.AppRuntime
    public void exit(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("exit", 2, getCurrentAccountUin() + " qq start to exit ");
        }
        this.isExitTaskUnfinished = true;
        sendBindUinOffline();
        com.tencent.mobileqq.statistics.t.a().d(getCurrentAccountUin());
        com.tencent.mobileqq.hitrate.a.b();
        com.tencent.mobileqq.perf.process.foregroud.b.f257916a.g();
        if (isLogin() && !this.bReceiveMsgOnExit) {
            userLogoutWhenSendState();
        }
        release();
        if (isLogin()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "bReceiveMsgOnExit = " + this.bReceiveMsgOnExit + ", needPCActive = " + z16);
            }
            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) getRuntimeService(IOnlineStatusService.class);
            if (this.bReceiveMsgOnExit) {
                iOnlineStatusService.sendOnlineStatus(AppRuntime.Status.receiveofflinemsg, false, 0L, false);
            } else if (z16) {
                iOnlineStatusService.sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
            } else {
                iOnlineStatusService.sendOnlineStatus(AppRuntime.Status.offline, true, 0L, false);
            }
            ((PushManager) getManager(4)).unregistProxyMessagePush(getAppid(), this.app.getPackageName() + MsfConstants.PROCESS_VIDEO);
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.exit();
        }
        if (z16) {
            getApplication().qqProcessExit(!isLogin());
        } else {
            getApplication().qqProcessExit(!this.bReceiveMsgOnExit);
        }
        if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "QQAppInterface exit removeNotification");
        }
        removeNotification();
        HeavyTaskExecutor.e();
        com.tencent.mobileqq.utils.cq.f(true);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        com.tencent.mobileqq.persistence.l lVar = this.emFactory;
        if (lVar != null) {
            lVar.close();
        }
    }

    public int getALLGeneralSettingRing() {
        return this.soundAndVibrateUtils.c();
    }

    public int getALLGeneralSettingVibrate() {
        return this.soundAndVibrateUtils.d();
    }

    public AVNotifyCenter getAVNotifyCenter() {
        if (this.mAVNotifyCenter == null) {
            this.mAVNotifyCenter = new AVNotifyCenter(this);
        }
        return this.mAVNotifyCenter;
    }

    public AboutConfig getAboutConfig() {
        initAbout();
        return this.aboutConfig;
    }

    public int getAndroidInternalId(String str) {
        try {
            for (Class<?> cls : Class.forName("com.android.internal.R").getDeclaredClasses()) {
                if ("id".equals(cls.getSimpleName())) {
                    return cls.getDeclaredField(str).getInt(null);
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    public com.tencent.av.app.b getAvAddFriendService() {
        if (this.mAvAddFriendService == null) {
            this.mAvAddFriendService = new com.tencent.av.app.b(this);
        }
        return this.mAvAddFriendService;
    }

    public Bitmap getBitmapFromCache(String str) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getBitmapFromCache(str);
    }

    public void getBrowserFontSetting() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            curBrowserFontSizeIndex = sharedPreferences.getInt("browser_font_size_index", 1);
        }
    }

    public int getC2CRoamingSetting() {
        return ((IRoamSettingService) getRuntimeService(IRoamSettingService.class, "")).getSettingValue(AppConstants.RoamingMapPath.C2C_ROAMING_MSG, 1);
    }

    public boolean getC2CRoamingSettingFromServerFlagFeature() {
        if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(ChatHistoryProfileCommonProcessor.f260937a + "_" + getCurrentUin(), 0) != 1) {
            return false;
        }
        return true;
    }

    public com.tencent.mobileqq.app.asyncdb.a getCacheManager() {
        if (this.cacheManager == null) {
            this.cacheManager = (com.tencent.mobileqq.app.asyncdb.a) getCacheManagerInner();
        }
        return this.cacheManager;
    }

    public com.tencent.mobileqq.qcall.f getCallFacade() {
        if (this.mCallFacade == null) {
            this.mCallFacade = (com.tencent.mobileqq.qcall.f) getManager(QQManagerFactory.RECENT_CALL_FACADE);
        }
        return this.mCallFacade;
    }

    public e getCheckPttListener() {
        return null;
    }

    public com.tencent.mobileqq.config.e getConfig(String str, boolean z16) {
        if (this.config == null && z16) {
            initConfig(str);
        }
        return this.config;
    }

    public com.tencent.mobileqq.config.c getConfigProcess() {
        return this.mConfigProcess;
    }

    public ConversationFacade getConversationFacade() {
        if (this.convsFacade == null) {
            this.convsFacade = (ConversationFacade) getManager(QQManagerFactory.CONVS_FACADE);
        }
        return this.convsFacade;
    }

    public boolean getCurLoginStatus() {
        boolean z16 = !SettingCloneUtil.readValue((Context) getApp(), getCurrentAccountUin(), AppConstants.Preferences.LOGIN_ACCOUNTS, AppConstants.QQSETTING_BOTHONLINE_KEY, true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "kickPC get value........... kickpc = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // com.tencent.common.app.AppInterface
    public String getCurrentNickname() {
        return com.tencent.mobileqq.utils.ac.y(this, getCurrentAccountUin());
    }

    @Override // mqq.app.AppRuntime
    public String getCurrentUin() {
        if (!"0".equals(getCurrentAccountUin())) {
            return getCurrentAccountUin();
        }
        return "";
    }

    public String getCustomFaceFilePath(boolean z16, String str) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(z16, str);
    }

    public String getCustomFaceFilePathBySetting(Setting setting, int i3, int i16) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePathBySetting(setting, i3, i16);
    }

    public DataLineMsgProxy getDataLineMsgProxy(int i3) {
        return getProxyManager().g(i3);
    }

    @DeprecatedReport
    public com.tencent.mobileqq.filemanager.fileassistant.util.c getDatalineMsgDBTransformer() {
        if (this.mDatalineMsgDBTransformer == null) {
            this.mDatalineMsgDBTransformer = new com.tencent.mobileqq.filemanager.fileassistant.util.c(this);
        }
        com.tencent.mobileqq.filemanager.fileassistant.util.c cVar = this.mDatalineMsgDBTransformer;
        CoreExperimentalMethodTrace.successVisitorMethod("com.tencent.mobileqq.app.QQAppInterface", "getDatalineMsgDBTransformer", "()", "[com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgDbTransformer]");
        return cVar;
    }

    public ExtensionInfo getExtensionInfo(String str, boolean z16) {
        if (this.f194969em == null) {
            ei.a(null, "QQRt_entityManagerFactory_create");
            this.f194969em = getEntityManagerFactory().createEntityManager();
            ei.a("QQRt_entityManagerFactory_create", null);
        }
        FriendsManager friendsManager = (FriendsManager) getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null || this.f194969em == null) {
            return null;
        }
        ExtensionInfo I = friendsManager.I(str, false);
        if (I == null && z16) {
            ExtensionInfo extensionInfo = (ExtensionInfo) DBMethodProxy.find(this.f194969em, (Class<? extends Entity>) ExtensionInfo.class, str);
            friendsManager.v0(extensionInfo);
            return extensionInfo;
        }
        return I;
    }

    public Bitmap getFaceBitmap(String str, boolean z16) {
        return getFaceBitmap(1, str, (byte) 3, z16, 0);
    }

    public String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getFaceBitmapCacheKey(i3, str, b16, i16, 100, false);
    }

    @Deprecated
    public Drawable getFaceDrawable(String str) {
        return getFaceDrawable(str, false, (byte) 3);
    }

    public Setting getFaceSetting(String str) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getFaceSetting(str);
    }

    public FileManagerDataCenter getFileManagerDataCenter() {
        if (this.mFileManagerDataCenter == null) {
            this.mFileManagerDataCenter = new FileManagerDataCenter(this);
        }
        return this.mFileManagerDataCenter;
    }

    public FileManagerEngine getFileManagerEngine() {
        if (this.mFileManagerEngine == null) {
            synchronized (FileManagerEngine.class) {
                if (this.mFileManagerEngine == null) {
                    this.mFileManagerEngine = new FileManagerEngine(this);
                }
            }
        }
        return this.mFileManagerEngine;
    }

    public FileManagerNotifyCenter getFileManagerNotifyCenter() {
        if (this.mFileManagerNotifyCenter == null) {
            synchronized (this.notifyCenterLock) {
                if (this.mFileManagerNotifyCenter == null) {
                    this.mFileManagerNotifyCenter = new FileManagerNotifyCenter(this);
                }
            }
        }
        return this.mFileManagerNotifyCenter;
    }

    public FileManagerProxy getFileManagerProxy() {
        ProxyManager proxyManager = getProxyManager();
        if (proxyManager != null) {
            return proxyManager.h();
        }
        return null;
    }

    public com.tencent.mobileqq.filemanager.core.e getFileManagerRSCenter() {
        if (this.mFileManagerRSCenter == null) {
            this.mFileManagerRSCenter = new com.tencent.mobileqq.filemanager.core.e(this);
        }
        return this.mFileManagerRSCenter;
    }

    public FileTransferHandler getFileTransferHandler() {
        if (this.fileTransferHandler == null) {
            this.fileTransferHandler = new FileTransferHandler(this);
        }
        return this.fileTransferHandler;
    }

    public cj getGAudioHandler() {
        if (this.mGAudioHandler == null) {
            this.mGAudioHandler = new cj(this);
        }
        return this.mGAudioHandler;
    }

    public ay getHotChatMng(boolean z16) {
        if (this.mHCMng == null && z16) {
            this.mHCMng = (ay) getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        }
        return this.mHCMng;
    }

    public Intent getIntentByMessage(Context context, com.tencent.imcore.message.Message message, boolean z16) {
        int i3 = message.istroop;
        if (i3 != 1000 && i3 != 1020 && i3 != 1004) {
            return getIntentByUin(getApp(), message, message.istroop);
        }
        if (RecentUtil.b(this, message.frienduin)) {
            return getIntentByUin(getApp(), message, 0);
        }
        return getIntentForTroopStranger(context, message, z16);
    }

    public MsgBoxInterFollowManager getInterFollowMgr() {
        return (MsgBoxInterFollowManager) getManager(QQManagerFactory.MSG_BOX_INTERACT_MANAGER);
    }

    public boolean getLocVisibilityForStatus() {
        return getPref().getBoolean(getApp().getString(R.string.cyt) + getCurrentAccountUin(), false);
    }

    public boolean getLocZanAllowedForPeople() {
        return ((com.tencent.mobileqq.nearby.a) getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).a();
    }

    public boolean getLocZanAllowedForStatus() {
        return getPref().getBoolean(getApp().getString(R.string.cyq) + getCurrentAccountUin(), false);
    }

    @Override // mqq.app.AppRuntime
    public Manager getManager(int i3) {
        Object obj;
        Manager manager = this.managers[i3];
        if (manager == null) {
            Object[] objArr = this.mgrLockArray;
            if (objArr[objArr.length - 1] == null) {
                synchronized (objArr) {
                    if (this.mgrLockArray[r1.length - 1] == null) {
                        int i16 = 0;
                        while (true) {
                            Object[] objArr2 = this.mgrLockArray;
                            if (i16 >= objArr2.length) {
                                break;
                            }
                            objArr2[i16] = new Object();
                            i16++;
                        }
                    }
                }
            }
            if (AppSetting.f99556p) {
                obj = this.mgrLockArray[i3];
            } else {
                obj = this.managers;
            }
            synchronized (obj) {
                Manager manager2 = this.managers[i3];
                if (manager2 == null && (getAccount() != null || i3 <= 4 || i3 == QQManagerFactory.MGR_PLUGIN)) {
                    TraceUtils.traceBegin("getManager_" + i3);
                    checkGetManagerCallingDepthStart(i3);
                    QQManagerFactory qQManagerFactory = QQManagerFactory.INSTANCE;
                    final Manager createManager = qQManagerFactory.createManager(i3, this);
                    getManagerCompatibleWithOldLogic(i3, createManager);
                    TraceUtils.traceEnd();
                    if (createManager != null) {
                        addManager(i3, createManager);
                    }
                    if (createManager != null && i3 <= this.managerDestroyIndex && qQManagerFactory.getDestroyMgrWhenDestroy()) {
                        HeavyTaskExecutor.a(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.4
                            @Override // java.lang.Runnable
                            public void run() {
                                createManager.onDestroy();
                            }
                        });
                    }
                    manager = createManager;
                }
                return manager2;
            }
        }
        checkGetManagerCallingDepthEnd();
        return manager;
    }

    public QQMessageFacade getMessageFacade() {
        if (this.msgFacade == null) {
            this.msgFacade = (QQMessageFacade) getManager(QQManagerFactory.MGR_MSG_FACADE);
        }
        DeprecatedMethodInvokeReport.d("AppInterface", "QQAppInterface.getMessageFacade", "");
        return this.msgFacade;
    }

    public com.tencent.imcore.message.f getMessageProxy(int i3) {
        ProxyManager proxyManager = getProxyManager();
        if (proxyManager != null) {
            if (10007 == i3) {
                return proxyManager.i();
            }
            return proxyManager.j().e(i3);
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public String[] getMessagePushSSOCommands() {
        String[] strArr = {MiniConst.Spark.CMD_PUSH_SPARK_REWARD, "MessageSvc.PushGroupMsg", BaseConstants.CMD_FORCE_LOGOUT, "MessageSvc.PushNotify", BaseConstants.CMD_FORCE_LOGOUT, "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", BaseConstants.CMD_REGPRXYSVC_GETOFFMSG, "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", BaseConstants.CMD_REGPRXYSVC_NOTICE_END, BaseConstants.CMD_NEW_REGPRXYSVC_PBSYNCMSG, "RegPrxySvc.GetBoxFilter", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", BaseConstants.CMD_REGPRXYSVC_INFOLOGIN, BaseConstants.CMD_MSF_NOTIFYRESP, "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushBindUinGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", BaseConstants.CMD_CONNALLFAILED, BaseConstants.CMD_RECVFIRSTRESP, "MultiVideo.s2c", "MultiVideo.c2sack", "NearFieldTranFileSvr.NotifyList", ProfileContants.CMD_CHECK_UPDATE_REQ, "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat", "StatSvc.SvcReqMSFLoginNotify", BaseConstants.CMD_PUSH_DOMAIN, IOnlineStatusService.CMD_RECV_MUSIC_STATUS_PUSH, "MsgPush.PushGroupProMsg", "trpc.group_pro.synclogic.SyncLogic.PushFirstView", "trpc.group_pro.synclogic.SyncLogic.PushChannelMsg", BaseConstants.CMD_NT_REGPRXYSVC_PUSH_PARAMS, BaseConstants.CMD_NT_REGPRXYSVC_PUSH_INFOSYNC, BaseConstants.CMD_NT_REGPRXYSVC_PUSH_GROUP_MSG, BaseConstants.CMD_NT_REGPRXYSVC_PUSH_C2C_MSG, BaseConstants.CMD_TRPC_MSG_PUSH, BaseConstants.CMD_OFFLINE_PUSH};
        HashSet hashSet = new HashSet(((IServletAPI) QRoute.api(IServletAPI.class)).getNTCmd());
        hashSet.addAll(Arrays.asList(strArr));
        QLog.d(TAG, 1, "getMessagePushSSOCommands, size: ", Integer.valueOf(hashSet.size()));
        return (String[]) hashSet.toArray(new String[0]);
    }

    @Override // mqq.app.AppRuntime
    protected Class<? extends MSFServlet>[] getMessagePushServlets() {
        return new Class[]{com.tencent.mobileqq.compatible.a.class, com.tencent.mobileqq.servlet.d.class, ContactBindServlet.class};
    }

    @Deprecated
    public Drawable getMobileFaceDrawable(String str, byte b16) {
        Bitmap faceBitmap = getFaceBitmap(11, str, b16, true, 0);
        if (faceBitmap == null) {
            faceBitmap = BaseImageUtil.getDefaultFaceBitmap();
        }
        return new BitmapDrawable(faceBitmap);
    }

    @Override // com.tencent.common.app.AppInterface
    public MobileQQServiceBase getMobileQQService() {
        return this.mqqService;
    }

    public MessageHandler getMsgHandler() {
        if (this.msgHandler == null) {
            this.msgHandler = (MessageHandler) getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
        }
        return this.msgHandler;
    }

    public MultiMsgProxy getMultiMessageProxy() {
        if (getProxyManager() != null) {
            return getProxyManager().k();
        }
        return null;
    }

    public MultiMsgController getMultiMsgController() {
        if (this.mMultiMsgController == null) {
            synchronized (this) {
                if (this.mMultiMsgController == null) {
                    this.mMultiMsgController = new MultiMsgController(this);
                }
            }
        }
        return this.mMultiMsgController;
    }

    public NTFileManageBridger getNTFileManageBridger() {
        if (this.ntFileManageBridger == null) {
            this.ntFileManageBridger = new NTFileManageBridger(this);
        }
        return this.ntFileManageBridger;
    }

    public String getNamePostfix(com.tencent.imcore.message.Message message) {
        int i3 = message.bizType;
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 != 7) {
                    if (i3 != 11) {
                        if (i3 != 18) {
                            if (i3 != 23) {
                                if (i3 != 25) {
                                    if (i3 != 13) {
                                        if (i3 != 14) {
                                            return "";
                                        }
                                        return getApp().getString(R.string.ein);
                                    }
                                    return getApp().getString(R.string.f171480f83);
                                }
                                return getApp().getString(R.string.eip);
                            }
                            return com.tencent.mobileqq.troop.navigatebar.expriment.a.b(R.string.ett, R.string.f181153d0);
                        }
                        if (message.msgtype != -2025 || !MessageForQQWalletMsg.isRedPacketMsg(getMessageFacade().w0(message.frienduin, 1, message.uniseq))) {
                            return "";
                        }
                        return com.tencent.mobileqq.troop.navigatebar.expriment.a.b(R.string.bis, R.string.f1380508i);
                    }
                    return com.tencent.mobileqq.troop.navigatebar.expriment.a.b(R.string.fvg, R.string.f2059356y);
                }
                return getApp().getString(R.string.f181083ct);
            }
            return getApp().getString(R.string.enc);
        }
        return getApp().getString(R.string.enp);
    }

    public boolean getNotAllowedSeeMyDongtai(boolean z16) {
        if (z16) {
            ((FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getDongtaiPermission(getCurrentAccountUin(), 1);
        }
        return getPref().getBoolean(getApp().getString(R.string.ck_) + getCurrentAccountUin(), false);
    }

    public wx.a getNowLiveManager() {
        return (wx.a) getManager(QQManagerFactory.NOW_LIVE_MANAGER);
    }

    public String getOldCustomFaceFilePath(int i3, String str) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getOldCustomFaceFilePath(i3, str);
    }

    public OnlineFileSessionCenter getOnlineFileSessionCenter() {
        if (this.mOnlineFileSessionCenter == null) {
            this.mOnlineFileSessionCenter = new OnlineFileSessionCenter(this);
        }
        return this.mOnlineFileSessionCenter;
    }

    public long getOnlineStauts() {
        int value;
        if (isAccLoginSuccess()) {
            value = ((IOnlineStatusService) getRuntimeService(IOnlineStatusService.class)).getOnlineStatus().getValue();
        } else {
            value = AppRuntime.Status.offline.getValue();
        }
        return value;
    }

    public Drawable getOrgFace(int i3, String str, boolean z16, boolean z17) {
        return null;
    }

    public ParcelHooker getParcelHooker() {
        if (this.mParcelHooker == null) {
            synchronized (this) {
                if (this.mParcelHooker == null) {
                    this.mParcelHooker = new ParcelHooker();
                }
            }
        }
        return this.mParcelHooker;
    }

    public void getPreloadSwitch() {
        try {
            ((ConfigHandler) getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).u3();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public ProxyManager getProxyManager() {
        if (this.proxyManager == null) {
            this.proxyManager = (ProxyManager) getProxyManagerInner();
        }
        return this.proxyManager;
    }

    public Bitmap getQCallFaceBitmap(String str, int i3) {
        return getFaceBitmap(16, str, true, i3);
    }

    public Pair<Boolean, Setting> getQQHeadSetting(int i3, String str, int i16) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(i3, str, i16);
    }

    public Setting getQQHeadSettingFromDB(String str) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getSettingFromDb(str);
    }

    public QQProxyForQlink getQQProxyForQlink() {
        if (this.mQQProxyForQlink == null) {
            this.mQQProxyForQlink = new QQProxyForQlink(this);
        }
        return this.mQQProxyForQlink;
    }

    public iv.d getQavOfflineMsgCenter() {
        if (this.qavOfflineMsgCenter == null) {
            this.qavOfflineMsgCenter = new iv.d(this);
        }
        return this.qavOfflineMsgCenter;
    }

    public cooperation.qlink.c getQlinkServiceMgr() {
        if (this.mQlinkServiceManager == null) {
            this.mQlinkServiceManager = new cooperation.qlink.c(this);
        }
        return this.mQlinkServiceManager;
    }

    public RecentUserProxy getRecentUserProxy() {
        if (this.mRecentUserProxy == null) {
            synchronized (this) {
                if (this.mRecentUserProxy == null) {
                    this.mRecentUserProxy = ((IRecentUserProxyService) getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
                }
            }
        }
        return this.mRecentUserProxy;
    }

    public Drawable getRectFaceDrawable(int i3, String str, boolean z16, boolean z17) {
        return null;
    }

    public ReportController getReportController() {
        z91.b b16 = com.tencent.mobileqq.bridge.a.b();
        if (b16 != null) {
            this.mReportController = (ReportController) b16.b(this);
        }
        if (this.mReportController == null) {
            synchronized (this.mReportControllerLock) {
                if (this.mReportController == null) {
                    this.mReportController = ReportControllerImpl.F(this);
                }
            }
        }
        return this.mReportController;
    }

    public Drawable getRoundFaceDrawable(Bitmap bitmap) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getRoundFaceDrawable(bitmap);
    }

    public Pair<Boolean, Bitmap> getScaledFaceBitmap(String str, byte b16, int i3, int i16) {
        boolean z16;
        Bitmap faceBitmap = getFaceBitmap(1, str, b16, true, 0);
        if (faceBitmap == null) {
            faceBitmap = BaseImageUtil.getDefaultFaceBitmap();
            z16 = false;
        } else {
            z16 = true;
        }
        return Pair.create(Boolean.valueOf(z16), faceBitmap);
    }

    public Intent getSecDetBannerIntent() {
        return this.mSecurityDetectBannerIntent;
    }

    public String getServerAddress() {
        String string;
        String[] split;
        SharedPreferences sharedPreferences = this.app.getSharedPreferences("mobileQQ", 0);
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            string = sharedPreferences.getString("serverlist_wifi", null);
        } else {
            string = sharedPreferences.getString("serverlist_2g3g", null);
        }
        if (string == null || (split = string.split(",")) == null) {
            return null;
        }
        return split[(int) (Math.random() * split.length)];
    }

    public String getServerConfigValue(ServerConfigManager.ConfigType configType, String str) {
        StringBuilder sb5;
        String account;
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(32);
            sb5.append("getServerConfigValue type=");
            sb5.append(configType);
            sb5.append(", key=");
            sb5.append(str);
            sb5.append(", value=");
        } else {
            sb5 = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.serverConfig.containsKey(configType) && this.serverConfigTimeOut.containsKey(configType) && currentTimeMillis - this.serverConfigTimeOut.get(configType).longValue() < 7200000) {
            HashMap<String, String> hashMap = this.serverConfig.get(configType);
            if (hashMap.containsKey(str)) {
                if (sb5 != null) {
                    sb5.append(hashMap.get(str));
                    QLog.d(TAG, 2, sb5.toString());
                }
                return hashMap.get(str);
            }
            if (sb5 != null) {
                sb5.append("null");
                QLog.d(TAG, 2, sb5.toString());
            }
            return null;
        }
        if (getAccount() == null) {
            account = "0";
        } else {
            account = getAccount();
        }
        String serverConfig = ((ServerConfigManager) getManager(3)).getServerConfig(account, configType);
        if (serverConfig != null && serverConfig.length() != 0) {
            try {
                XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                ServerConfigXMLHandler serverConfigXMLHandler = new ServerConfigXMLHandler();
                xMLReader.setContentHandler(serverConfigXMLHandler);
                xMLReader.parse(new InputSource(new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ServerConfig>" + serverConfig + "</ServerConfig>").getBytes("UTF-8"))));
                HashMap<String, String> elements = serverConfigXMLHandler.getElements();
                this.serverConfig.put(configType, elements);
                this.serverConfigTimeOut.put(configType, Long.valueOf(currentTimeMillis));
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (sb5 != null) {
                    sb5.append(elements.get(str));
                    sb5.append(",cost:");
                    sb5.append(currentTimeMillis2);
                    QLog.d(TAG, 2, sb5.toString());
                }
                if (currentTimeMillis2 > 2000) {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(getCurrentAccountUin(), "getConfigLongCost", true, currentTimeMillis2, 0L, null, null);
                }
                return elements.get(str);
            } catch (Exception e16) {
                if (sb5 != null) {
                    QLog.e(TAG, 2, sb5.toString(), e16);
                }
                return null;
            }
        }
        if (sb5 != null) {
            sb5.append("null, configText is null");
            QLog.d(TAG, 2, sb5.toString());
        }
        return null;
    }

    public Setting getSettingFromDb(String str) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getSettingFromDb(str);
    }

    public boolean getShieldHisDongtai(boolean z16) {
        if (z16) {
            ((FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getDongtaiPermission(getCurrentAccountUin(), 2);
        }
        return getPref().getBoolean(getApp().getString(R.string.hjx) + getCurrentAccountUin(), false);
    }

    public ShortVideoPreDownloader getShortVideoPredownloer() {
        if (this.shortVideoPreDownloader == null) {
            this.shortVideoPreDownloader = (ShortVideoPreDownloader) getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER);
        }
        return this.shortVideoPreDownloader;
    }

    public ShortVideoResourceManager getShortVideoResourceManager() {
        if (this.mShortVideoResourceMgr == null) {
            this.mShortVideoResourceMgr = (ShortVideoResourceManager) getManager(QQManagerFactory.SHORT_VIDEO_RESOURCE_MANAGER);
        }
        return this.mShortVideoResourceMgr;
    }

    public void getSignInInfo(final int i3) {
        try {
            final CardHandler cardHandler = (CardHandler) getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.12
                @Override // java.lang.Runnable
                public void run() {
                    cardHandler.j3(i3);
                }
            }, 128, null, true);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Deprecated
    public boolean getSingleTroopReceiveStatus(String str) {
        if (this.app.getSharedPreferences(getCurrentAccountUin(), 0).getLong(getCurrentAccountUin() + str, 1L) != 1) {
            return false;
        }
        return true;
    }

    public Bitmap getStrangerFaceBitmap(String str, int i3) {
        return getFaceBitmap(32, str, true, i3);
    }

    public Bitmap getTroopFaceBitmap(String str, byte b16, boolean z16, boolean z17) {
        Bitmap faceBitmap = getFaceBitmap(4, str, b16, true, 0);
        if (faceBitmap == null) {
            faceBitmap = BaseImageUtil.getDefaultTroopFaceBitmap();
        }
        if (faceBitmap != null && z16) {
            faceBitmap = BaseImageUtil.grey(faceBitmap);
        }
        if (faceBitmap != null && z17) {
            return shield(faceBitmap);
        }
        return faceBitmap;
    }

    public Drawable getTroopFaceDrawable(String str) {
        return getTroopFaceDrawable(str, (byte) 3, false, false);
    }

    @Deprecated
    public GroupMsgMask getTroopMask(String str) {
        return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMask(this, str);
    }

    public String getUinDisplayNameBeforeLogin(String str) {
        String property = getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + str);
        if (property != null && property.length() != 0) {
            return property;
        }
        return str;
    }

    public void getVideoConfigUpdate() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getVideoConfigUpdate");
        }
        NewIntent newIntent = new NewIntent(this.app, com.tencent.mobileqq.servlet.r.class);
        newIntent.putExtra("reqType", 11);
        startServlet(newIntent);
    }

    public final boolean getVisibilityForInputStatus(boolean z16) {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        if (!from.decodeBool(getApp().getString(R.string.f227726rt) + getCurrentAccountUin(), false)) {
            from.encodeBool(getApp().getString(R.string.f227726rt) + getCurrentAccountUin(), true);
            from.encodeBool(getApp().getString(R.string.hm7) + getCurrentAccountUin(), getPref().getBoolean(getApp().getString(R.string.hm7) + getCurrentAccountUin(), false));
        }
        if (z16) {
            ((InputStatusHandler) getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER)).D2();
        }
        return from.decodeBool(getApp().getString(R.string.hm7) + getCurrentAccountUin(), false);
    }

    public final boolean getVisibilityForNetWorkStatus(boolean z16) {
        if (z16) {
            ((FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getVisibilityForNetWorkStatus();
        }
        return getPref().getBoolean(getApp().getString(R.string.hm8) + getCurrentAccountUin(), true);
    }

    public void getVisibilitySwitches() {
        ((LBSHandler) getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).I2();
    }

    public void getZanSwitches() {
        ((CardHandler) getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).T2();
    }

    public String getvKeyHexStr() {
        String str = getvKeyStr();
        if (str != null) {
            try {
                return HexUtil.bytes2HexStr(str.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Deprecated
    public String getvKeyStr() {
        return null;
    }

    public void handleReceivedMessage(int i3, boolean z16, boolean z17) {
        handleReceivedMessage(i3, z16, z17, null);
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        boolean hasRunningTask = ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).hasRunningTask();
        QLog.e(TAG, 1, "highPriorityWhenBackground:" + hasRunningTask);
        return hasRunningTask;
    }

    public synchronized com.tencent.mobileqq.config.e initConfig(String str) {
        if (this.config == null) {
            this.config = new com.tencent.mobileqq.config.e(this, str);
        }
        return this.config;
    }

    public void initFaceSettingCache() {
        QLog.i(QQ_HEAD_BROADCAST, 1, "initFaceSettingCache");
        ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).initFaceSettingCache();
    }

    public void initSecureFileFramework() {
        boolean z16;
        boolean z17;
        char c16;
        int i3;
        getSecurityUINRootFile();
        char c17 = 4;
        SharedPreferences sharedPreferences = this.app.getSharedPreferences(SecurityFileFrameworkServiceImpl.TAG, 4);
        String string = sharedPreferences.getString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", "");
        if (!TextUtils.isEmpty(string)) {
            boolean z18 = true;
            boolean z19 = false;
            int i16 = 2;
            if (QLog.isColorLevel()) {
                QLog.d("SecurityFileFramework", 2, "report=", string);
            }
            String[] split = string.split("\\|");
            int length = split.length;
            int i17 = 0;
            while (i17 < length) {
                String str = split[i17];
                if (!TextUtils.isEmpty(str)) {
                    String[] split2 = str.split("#");
                    HashMap<String, String> hashMap = new HashMap<>();
                    int length2 = split2.length;
                    if (length2 != i16) {
                        if (length2 != 5) {
                            i3 = 2;
                            c16 = 4;
                        } else {
                            hashMap.put("BusinessName", split2[0]);
                            hashMap.put("needMigrate", "true");
                            c16 = 4;
                            hashMap.put("doMigrate", split2[4]);
                            hashMap.put("fileSize", split2[2]);
                            hashMap.put("fileAmount", split2[3]);
                            try {
                                StatisticCollector.getInstance(getApp()).collectPerformance(getCurrentUin(), "SecureFileStep", true, 0L, 0L, hashMap, "");
                                i3 = 2;
                            } catch (NumberFormatException unused) {
                                if (QLog.isColorLevel()) {
                                    z17 = false;
                                    z16 = true;
                                    QLog.d(TAG, 2, "SecureFile Report Error, NumberFormatException", str);
                                } else {
                                    z16 = true;
                                    z17 = false;
                                }
                                i3 = 2;
                            }
                        }
                        z16 = true;
                        z17 = false;
                    } else {
                        z16 = true;
                        z17 = false;
                        int i18 = i16;
                        c16 = 4;
                        hashMap.put("BusinessName", split2[0]);
                        hashMap.put("needMigrate", "false");
                        hashMap.put("doMigrate", "null");
                        hashMap.put("fileSize", "-1");
                        hashMap.put("fileAmount", "-1");
                        i3 = i18;
                        StatisticCollector.getInstance(getApp()).collectPerformance(getCurrentUin(), "SecureFileStep", true, 0L, 0L, hashMap, "");
                    }
                } else {
                    z16 = z18;
                    z17 = z19;
                    int i19 = i16;
                    c16 = c17;
                    i3 = i19;
                }
                i17++;
                z18 = z16;
                z19 = z17;
                char c18 = c16;
                i16 = i3;
                c17 = c18;
            }
            sharedPreferences.edit().putString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", "").apply();
        }
    }

    public boolean isAccLoginSuccess() {
        if (getAccount() != null && isLogin()) {
            return true;
        }
        return false;
    }

    @TargetApi(14)
    public boolean isAccessibilityEnabled() {
        try {
            boolean isEnabled = ((AccessibilityManager) this.app.getSystemService("accessibility")).isEnabled();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "isAccessibilityEnabled()  isAccessibilityEnabled=" + isEnabled);
            }
            return isEnabled;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isCallIdle() {
        return com.tencent.mobileqq.app.utils.q.h();
    }

    public boolean isCreateManager(int i3) {
        if (this.managers[i3] != null) {
            return true;
        }
        return false;
    }

    public boolean isFaceFileExist(int i3, String str, int i16, int i17) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).isFaceFileExist(i3, str, i16, i17);
    }

    public boolean isLBSFriendNewClient(String str) {
        byte[] b06 = getMsgCache().b0(str);
        if (b06 != null && b06.length > 0) {
            return true;
        }
        return false;
    }

    public boolean isMSFConnect() {
        boolean z16;
        Boolean bool = this.isMSFConnect;
        if (bool == null || !bool.booleanValue()) {
            if (NetConnInfoCenter.socketConnState == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isMSFConnect = Boolean.valueOf(z16);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[isMSFConnect] isMSFConnect is inited to " + this.isMSFConnect);
            }
        }
        return this.isMSFConnect.booleanValue();
    }

    public boolean isNeedSecurityScan() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app);
        boolean readValue = SettingCloneUtil.readValue((Context) this.app, (String) null, AppConstants.Preferences.SECURITY_SCAN_KEY, AppConstants.QQSETTING_SECURITY_SCAN_KEY, false);
        boolean z16 = defaultSharedPreferences.getBoolean(AppConstants.Preferences.SECURITY_SCAN_LAST_RESULT, false);
        long j3 = defaultSharedPreferences.getLong(AppConstants.Preferences.SECURITY_SCAN_LAST_TIME, 0L);
        Date date = new Date(j3);
        Date date2 = new Date();
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        if (!readValue) {
            return false;
        }
        if (j3 != 0 && date2.getTime() - date.getTime() <= 604800000 && !z16) {
            return false;
        }
        return true;
    }

    public boolean isOpenNoClearNotification() {
        String str;
        try {
            str = getApp().getString(R.string.hhh);
        } catch (Exception unused) {
            str = null;
        }
        boolean z16 = false;
        if (str != null) {
            z16 = SettingCloneUtil.readValue((Context) getApp(), (String) null, str, AppConstants.QQSETTING_NOTIFY_ICON_KEY, false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("MobileQQService", 2, "isOpenNoClearNotification" + z16);
        }
        return z16;
    }

    public final boolean isPhoneNumSearchable(boolean z16) {
        if (z16) {
            ((CardHandler) getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).e3();
        }
        return getPref().getBoolean(getApp().getString(R.string.cyp) + getCurrentAccountUin(), true);
    }

    public boolean isPttRecordingOrPlaying() {
        return false;
    }

    public boolean isQQHeadBroadcastRegister() {
        return sIsQQHeadBroadcastRegister;
    }

    public boolean isRingEqualsZero() {
        return this.soundAndVibrateUtils.i();
    }

    public boolean isRingerNormal() {
        AudioManager audioManager = (AudioManager) getApp().getSystemService("audio");
        if (audioManager != null && audioManager.getRingerMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean isRingerNormalVibrate() {
        String str = Build.MANUFACTURER + DeviceInfoMonitor.getModel();
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("xiaomi")) {
            if (Settings.System.getInt(getApp().getContentResolver(), "vibrate_in_normal", -1) != 1) {
                return false;
            }
            return true;
        }
        if (Settings.System.getInt(getApp().getContentResolver(), "vibrate_when_ringing", -1) != 1) {
            return false;
        }
        return true;
    }

    public boolean isRingerSilent() {
        return this.soundAndVibrateUtils.j();
    }

    public boolean isRingerVibrate() {
        return this.soundAndVibrateUtils.k();
    }

    public boolean isShowMsgContent() {
        return SettingCloneUtil.readValue((Context) getApp(), getCurrentAccountUin(), getApp().getString(R.string.f173079h50), AppConstants.QQSETTING_NOTIFY_SHOWCONTENT_KEY, true);
    }

    @Deprecated
    public boolean isTroopMark(com.tencent.imcore.message.Message message) {
        return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopMark(this, message.frienduin, message.istroop);
    }

    public boolean isUsingCameraOnVideo() {
        Bundle R;
        WeakReference<QQServiceForAV> weakReference = this.mQQServiceRef;
        if (weakReference == null || weakReference.get() == null || !isVideoChatting() || (R = this.mQQServiceRef.get().R(1, 0, null)) == null) {
            return false;
        }
        String string = R.getString("camera_used_desc", null);
        QLog.w(TAG, 1, "isUsingCameraOnVideo, result[" + string + "]");
        if (string == null) {
            return false;
        }
        return true;
    }

    public boolean isVideoChatting() {
        if (!AVNotifyCenter.V() && !getAVNotifyCenter().T()) {
            if (!getAVNotifyCenter().U() && getAVNotifyCenter().J() == 0) {
                return false;
            }
            if (((IVideoProcessMonitor) QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive()) {
                return true;
            }
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) getApp().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                if (runningAppProcesses != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (it.hasNext()) {
                        if (it.next().processName.equals("com.tencent.mobileqq:video")) {
                            AVCoreLog.printColorLog(TAG, "VideoProcessAlive VIDEO_PROCESS_NAME");
                            return true;
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return false;
        }
        AVCoreLog.printColorLog(TAG, "VideoProcessAlive isBeInvitingOnDoubleVideo");
        return true;
    }

    @Override // mqq.app.AppRuntime
    public void logout(boolean z16) {
        if (z16) {
            sendBindUinOffline();
            if (this.isNtLogout.compareAndSet(false, true)) {
                userLogoutWhenSendState();
            }
        }
        ((PushManager) getManager(4)).unregistProxyMessagePush(getAppid(), this.app.getPackageName() + MsfConstants.PROCESS_VIDEO);
        com.tencent.mobileqq.managers.b.b().j();
        release();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "kickPC in app  do logout");
        }
        String currentAccountUin = getCurrentAccountUin();
        if (currentAccountUin != null) {
            try {
                ((IWeiyunHelper) QRoute.api(IWeiyunHelper.class)).cleanPwdRecord(getApp(), Long.parseLong(currentAccountUin));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        TextHook.getInstance().switchDefault();
        super.logout(z16);
    }

    public bq messageNotifiableChecker() {
        return this.messageNotifiableChecker;
    }

    public void notifyFriendListSynced() {
        sLastGetOnlineFriendTime = SystemClock.uptimeMillis();
    }

    public void ntOnline() {
        boolean z16;
        if (isAccLoginSuccess() && this.isLogin) {
            QLog.i(TAG, 1, "ntOnline, Runtime: " + toString());
            IKernelService iKernelService = (IKernelService) getRuntimeService(IKernelService.class, "");
            AudioManager audioManager = (AudioManager) BaseApplication.context.getSystemService("audio");
            if (SystemMethodProxy.getStreamVolume(audioManager, 3) != 0 && audioManager.getRingerMode() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            iKernelService.onLine(new RegisterInfo(true, new DeviceInfo(HexUtil.bytes2HexStr(((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).getGUID()), AppSetting.f99542b, AppActivity.localeId, Build.BRAND + "-" + DeviceInfoMonitor.getModel(), Build.DEVICE, ROMUtil.getRomName(), Build.VERSION.RELEASE, ROMUtil.getRomVersion(), z16, BaseApplication.getContext().getThirdPushType()), new OnLineBusinessInfo()));
        }
    }

    public void onConnAllFailed() {
        QLog.i(TAG, 1, "onConnAllFailed");
        com.tencent.mobileqq.managers.b.b().k(4, "onConnAllFailed");
        MqqHandler handler = getHandler(Conversation.class);
        if (handler != null) {
            handler.obtainMessage(Conversation.MSG_ILLEGALNETWORK_OPEN, (Runnable) null).sendToTarget();
        }
        ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(8, null);
    }

    public void onConnClose() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onConnClose");
        }
        setMSFConnect(false);
        com.tencent.mobileqq.managers.b.b().k(1, "onConnClose");
        MqqHandler handler = getHandler(Conversation.class);
        if (handler != null) {
            handler.obtainMessage(Conversation.MSG_CHANGE_LOADINGSTATE, (Runnable) null).sendToTarget();
        }
        ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(9, null);
        ((IKernelService) getRuntimeService(IKernelService.class)).setOnMsfStatusChanged(MsfStatusType.KDISCONNECTED, MsfChangeReasonType.KAUTO, 0);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        ei.a(null, "QQRt_onCreate");
        ei.a(null, "QQRt_superOnCreate");
        super.onCreate(bundle);
        ei.a("QQRt_superOnCreate", "QQRt_PushServlet");
        startServlet(new NewIntent(getApplication(), com.tencent.mobileqq.servlet.h.class));
        startServlet(new NewIntent(getApplication(), ((IKernelSetter) QRoute.api(IKernelSetter.class)).getPushMsgServlet()));
        ei.a("QQRt_PushServlet", "QQRt_QQInitHandler");
        this.mAutomator = new Automator(this);
        ei.a(null, "QQRt_AccountReceiver");
        registerAccountReceiver();
        ei.a("QQRt_AccountReceiver", "QQRt_videoMsgReceiver");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.1
            @Override // java.lang.Runnable
            public void run() {
                QQAppInterface.this.mqqService = new com.tencent.mobileqq.service.d(QQAppInterface.this);
                QQAppInterface.this.mqqService.v();
                IntentFilter intentFilter = new IntentFilter(QQAppInterface.BROADCAST_QZONE_CLEAR_COUNT);
                intentFilter.addAction("com.tecent.qzone.clearAlbumRedTouch");
                ((AppInterface) QQAppInterface.this).app.registerReceiver(QQAppInterface.this.qzoneBrocastReceiver, intentFilter);
                VideoBroadcastReceiver.l0(QQAppInterface.this);
            }
        });
        ei.a("QQRt_videoMsgReceiver", "QQRt_initAvatarUploadState");
        if (com.tencent.mobileqq.startup.task.ce.INSTANCE.d()) {
            FaceUtil.initAvatarUploadState();
        }
        ei.a("QQRt_initAvatarUploadState", "QQRt_MemoryManager");
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.updateStartTime(this);
        }
        if (isLogin()) {
            com.tencent.mobileqq.dt.b.j(2);
            com.tencent.mobileqq.dt.b.l();
            if (Foreground.isCurrentProcessForeground()) {
                com.tencent.mobileqq.dt.b.f203754c = true;
            }
        }
        this.mFirstGetSubAccountName = true;
        ei.a("QQRt_MemoryManager", "QQRt_QLink");
        getQlinkServiceMgr().f();
        ei.a("QQRt_QLink", "QQRt_FileManager");
        getFileManagerDataCenter().A();
        getQQProxyForQlink().x();
        com.tencent.mobileqq.notification.modularize.r.INSTANCE.a(this).n();
        PluginManageHandler.getInstance().setPluginManagerProvider(this, false);
        onCreateDebug();
        TroopFileDownloadMgr.g().j();
        TroopFileThumbnailMgr.j().k();
        ei.a("QQRt_FileManager", null);
        ei.a("QQRt_onCreate", null);
    }

    protected void onCreateQQMessageFacade(QQMessageFacade qQMessageFacade) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCreateQQMessageFacade() called with: msgFacade = [" + qQMessageFacade + "]");
        }
        new QQMessageFacadeConfig(qQMessageFacade).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        super.onDestroy();
        this.mConfigProcess.g();
        com.tencent.mobileqq.startup.a.f289663d = 0L;
        com.tencent.mobileqq.startup.a.f289662c = 0L;
        com.tencent.mobileqq.startup.a.f289664e = 0L;
        FMTSrvAddrProvider.destroy();
        release();
        ThemeUiPlugin.destroy(this);
        ChatBackgroundManager.d();
        AppNetConnInfo.unregisterNetInfoHandler(this.netHandler);
        Handler handler = sGetOnlineFriendHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((AppInterface) QQAppInterface.this).app.unregisterReceiver(QQAppInterface.this.qqAccountReceiver);
                } catch (Exception unused) {
                }
                try {
                    ((AppInterface) QQAppInterface.this).app.unregisterReceiver(QQAppInterface.this.qzoneBrocastReceiver);
                } catch (Exception unused2) {
                }
            }
        });
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.16
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(QQAppInterface.this.getApp()).edit();
                edit.putString(AppConstants.Preferences.LAST_SCREEN_SHOT_URI, "");
                edit.commit();
                QQAppInterface.this.unregisterHeadBroadcastReceiver();
            }
        }, 80, null, false);
        if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "QQAppInterface onDestroy removeNotification");
        }
        removeNotification();
        AVNotifyCenter aVNotifyCenter = this.mAVNotifyCenter;
        if (aVNotifyCenter != null) {
            aVNotifyCenter.r0();
        }
        MultiMsgController multiMsgController = this.mMultiMsgController;
        if (multiMsgController != null) {
            multiMsgController.f();
            this.mMultiMsgController = null;
        }
        com.tencent.mobileqq.config.e.a();
        OpenApiManager.getInstance().onRuntimeDestroy(this);
        eq2.a.c();
        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).clearInstance(this);
        OnlineFileSessionCenter onlineFileSessionCenter = this.mOnlineFileSessionCenter;
        if (onlineFileSessionCenter != null) {
            onlineFileSessionCenter.e();
        }
        if (!TextUtils.isEmpty(getCurrentAccountUin())) {
            QQOperateManager.c();
        }
        if (this.mFileManagerDataCenter != null) {
            getFileManagerDataCenter().z();
        }
        if (this.mQQProxyForQlink != null) {
            getQQProxyForQlink().w();
        }
        PresendPicMgr g16 = PresendPicMgr.g(null);
        if (g16 != null) {
            g16.l();
        }
        InnerDns.onAppDestroy();
        Handler handler2 = this.lockDetectHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        ((IQIMManager) QRoute.api(IQIMManager.class)).destory();
        this.mHeadGetIntents.clear();
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginManageHandler.IPluginManagerProvider
    public RemotePluginManager.Stub onGetPluginManager() {
        return (cooperation.plugin.g) getManager(QQManagerFactory.MGR_PLUGIN);
    }

    @Override // mqq.app.AppRuntime
    protected AppRuntime onGetSubRuntime(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "QQAppInterface.onGetSubRuntime() moduleId: " + str);
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if ("modular_web".equals(str)) {
            return new BrowserAppInterface(application, MobileQQ.processName);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0232  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessageConnect(long j3) {
        String str;
        String currentProcess;
        SharedPreferences sharedPreferences;
        String string;
        String string2;
        boolean z16;
        boolean z17;
        int i3;
        boolean z18;
        String string3;
        String str2;
        String str3;
        String str4;
        String str5;
        SharedPreferences sharedPreferences2;
        String string4;
        String str6;
        String string5;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onMessageConnect...");
        }
        if (this.mAutomator != null && isAccLoginSuccess()) {
            Automator automator = this.mAutomator;
            if (automator != null) {
                automator.I2();
            }
            sendRegisterPush();
            setLoadingState();
            if (!shouldPostponeMediaPredownloadSwitchOff()) {
                switchOffMediaPredownload();
            }
            ((IScribbleDownloader) getRuntimeService(IScribbleDownloader.class)).off();
            ((IAIOPreDownloadService) getRuntimeService(IAIOPreDownloadService.class, "")).onNetworkConnected();
            try {
                currentProcess = getCurrentProcess();
                sharedPreferences = BaseApplication.getContext().getSharedPreferences("pull_msf" + currentProcess, 0);
                string = sharedPreferences.getString("uin", " ");
                string2 = sharedPreferences.getString("time", "0");
                try {
                    z16 = sharedPreferences.getBoolean("proxy", false);
                    z17 = sharedPreferences.getBoolean(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, false);
                    i3 = sharedPreferences.getInt("param_FailCode", 0);
                    z18 = sharedPreferences.getBoolean("mainProcess", false);
                    string3 = sharedPreferences.getString("sdkver", " ");
                    str2 = "mainProcess";
                    str3 = "param_FailCode";
                } catch (Exception unused) {
                    str = TAG;
                    QLog.d(str, 1, "Failed to report pull Msf Event");
                }
            } catch (Exception unused2) {
            }
            if (!string.equals(" ")) {
                try {
                } catch (Exception unused3) {
                    str = TAG;
                }
                if (!string2.equals("0")) {
                    str4 = "0";
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("uin", string);
                    hashMap.put("time", string2);
                    hashMap.put("process", sharedPreferences.getString("process", ""));
                    hashMap.put("availMem", sharedPreferences.getString("availMem", ""));
                    hashMap.put("lowMem", sharedPreferences.getString("lowMem", ""));
                    hashMap.put("state", sharedPreferences.getString("state", ""));
                    hashMap.put("version", "150806");
                    hashMap.put("build", AppSetting.f99542b);
                    hashMap.put("proxy", String.valueOf(z16));
                    hashMap.put(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, String.valueOf(z17));
                    hashMap.put(str3, String.valueOf(i3));
                    str3 = str3;
                    hashMap.put(str2, String.valueOf(z18));
                    str2 = str2;
                    str5 = "sdkver";
                    hashMap.put(str5, String.valueOf(string3));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_V3", false, 0L, 0L, hashMap, "");
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.clear();
                    edit.commit();
                    sharedPreferences2 = BaseApplication.getContext().getSharedPreferences("pull_msf_succ" + currentProcess, 0);
                    string4 = sharedPreferences2.getString("uin", " ");
                    str6 = str5;
                    String str7 = str4;
                    string5 = sharedPreferences2.getString("time", str7);
                    if (!string4.equals(" ") && !string5.equals(str7)) {
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put("uin", string4);
                        hashMap2.put("time", string5);
                        hashMap2.put("process", sharedPreferences2.getString("process", ""));
                        hashMap2.put("availMem", sharedPreferences2.getString("availMem", ""));
                        hashMap2.put("lowMem", sharedPreferences2.getString("lowMem", ""));
                        hashMap2.put("state", sharedPreferences2.getString("state", ""));
                        hashMap2.put("version", "150806");
                        hashMap2.put("build", AppSetting.f99542b);
                        hashMap2.put("proxy", String.valueOf(z16));
                        hashMap2.put(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, String.valueOf(z17));
                        hashMap2.put(str3, String.valueOf(i3));
                        hashMap2.put(str2, String.valueOf(z18));
                        hashMap2.put(str6, String.valueOf(string3));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_succ_V2", false, 0L, 0L, hashMap2, "");
                        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                        edit2.clear();
                        edit2.commit();
                    }
                    if (!((IKickApi) QRoute.api(IKickApi.class)).shouldIgnoreNotifyMsfStatusChanged()) {
                        str = TAG;
                        try {
                            QLog.d(str, 1, "ignoreNotifyMsfStatusChanged");
                            return;
                        } catch (Exception unused4) {
                        }
                    } else {
                        str = TAG;
                        try {
                            ((IKernelService) getRuntimeService(IKernelService.class)).setOnMsfStatusChanged(MsfStatusType.KCONNECTED, MsfChangeReasonType.KAUTO, (int) j3);
                            return;
                        } catch (Exception unused5) {
                        }
                    }
                    QLog.d(str, 1, "Failed to report pull Msf Event");
                }
            }
            str4 = "0";
            str5 = "sdkver";
            sharedPreferences2 = BaseApplication.getContext().getSharedPreferences("pull_msf_succ" + currentProcess, 0);
            string4 = sharedPreferences2.getString("uin", " ");
            str6 = str5;
            String str72 = str4;
            string5 = sharedPreferences2.getString("time", str72);
            if (!string4.equals(" ")) {
                HashMap<String, String> hashMap22 = new HashMap<>();
                hashMap22.put("uin", string4);
                hashMap22.put("time", string5);
                hashMap22.put("process", sharedPreferences2.getString("process", ""));
                hashMap22.put("availMem", sharedPreferences2.getString("availMem", ""));
                hashMap22.put("lowMem", sharedPreferences2.getString("lowMem", ""));
                hashMap22.put("state", sharedPreferences2.getString("state", ""));
                hashMap22.put("version", "150806");
                hashMap22.put("build", AppSetting.f99542b);
                hashMap22.put("proxy", String.valueOf(z16));
                hashMap22.put(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, String.valueOf(z17));
                hashMap22.put(str3, String.valueOf(i3));
                hashMap22.put(str2, String.valueOf(z18));
                hashMap22.put(str6, String.valueOf(string3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(getCurrentAccountUin(), "pullMsfReport_succ_V2", false, 0L, 0L, hashMap22, "");
                SharedPreferences.Editor edit22 = sharedPreferences2.edit();
                edit22.clear();
                edit22.commit();
            }
            if (!((IKickApi) QRoute.api(IKickApi.class)).shouldIgnoreNotifyMsfStatusChanged()) {
            }
            QLog.d(str, 1, "Failed to report pull Msf Event");
        }
    }

    public void onNetNeedSignon(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkIfNeedSignonNet onNetNeedSignon() called url:" + str);
        }
        Message obtain = Message.obtain();
        obtain.arg1 = 2;
        obtain.obj = str;
        BannerManager.l().O(NetNeedSignOnBannerProcessor.f185235d, 2, obtain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onProcPause() {
        super.onProcPause();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onProcPause");
        }
        if (isLogin()) {
            ((IAppBadgeService) getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onProcResume() {
        super.onProcResume();
    }

    @Override // mqq.app.AppRuntime
    public boolean onReceiveUnhandledKickedMsg(String str, Intent intent) {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null && !guardManager.isProcessForeground(MobileQQ.PACKAGE_NAME) && Build.VERSION.SDK_INT > 28 && NewIntent.ACTION_ACCOUNT_KICKED.equals(str)) {
            setKickIntent(intent);
            showKickedNotification(intent);
            return true;
        }
        return false;
    }

    public void onRecvFistResp() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onRecvFistResp");
        }
        setMSFConnect(true);
        MqqHandler handler = getHandler(Conversation.class);
        if (!com.tencent.mobileqq.managers.b.b().f()) {
            com.tencent.mobileqq.managers.b.b().k(2, "onRecvFistResp");
            if (handler != null) {
                handler.obtainMessage(Conversation.MSG_ILLEGALNETWORK_CLOSE, (Runnable) null).sendToTarget();
            }
            ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(7, null);
        } else if (com.tencent.mobileqq.managers.b.b().g()) {
            if (handler != null) {
                handler.obtainMessage(Conversation.MSG_ILLEGALNETWORK_CLOSE_NOT_LOADING, (Runnable) null).sendToTarget();
            }
            ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(6, null);
        }
        if (handler != null) {
            Message obtain = Message.obtain();
            obtain.arg1 = 0;
            BannerManager.l().O(NetNeedSignOnBannerProcessor.f185235d, 0, obtain);
        }
    }

    @Override // mqq.app.AppRuntime
    public void onRunningBackground() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onRunningBackground");
        }
        super.onRunningBackground();
        if (!TextUtils.isEmpty(getAccount())) {
            onRunningBackgroundWithAccount();
        }
        onRunningBackgroundCommon();
    }

    public void onRunningBackgroundCommon() {
        MayknowRecommendManager mayknowRecommendManager;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onRunningBackgroundGeneral");
        }
        if (isLogin()) {
            ((IAppBadgeService) getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
        ProxyManager proxyManager = this.proxyManager;
        if (proxyManager != null) {
            proxyManager.saveNotify();
        }
        ReportController.D(this);
        getFileTransferHandler().C1();
        QzoneAlbumRedTouchManager qzoneAlbumRedTouchManager = (QzoneAlbumRedTouchManager) getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH);
        if (qzoneAlbumRedTouchManager != null) {
            qzoneAlbumRedTouchManager.b();
        }
        MediaPlayerManager mediaPlayerManager = (MediaPlayerManager) this.managers[QQManagerFactory.MGR_MEDIA_PLAYER];
        if (mediaPlayerManager != null && mediaPlayerManager.t()) {
            ReportController.o(null, "dc00898", "", "", "0X800C391", "0X800C391", 6, 0, "", "", "", "");
            mediaPlayerManager.D(false);
        }
        cancelSyncOnlineFriend(-1L);
        checkDialogOnBackground();
        com.tencent.qqperf.tools.c.a(BaseApplication.getContext());
        LpReportManager.getInstance().startReportImediately(2);
        com.tencent.mobileqq.app.message.j.b();
        if (!TextUtils.isEmpty(getAccount())) {
            ((IPicPreDownload) getRuntimeService(IPicPreDownload.class)).commitTrafficPref();
        }
        JobReporter.reportThreadPeakCount(0L);
        ((IReadInJoySPEventReport) QRoute.api(IReadInJoySPEventReport.class)).reportLeaveQQ();
        try {
            QLogReporter.a().b();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        UserguideActivity.F2();
        ArkStateCenter.getInstance().setForeground(false);
        PushNoticeManager pushNoticeManager = (PushNoticeManager) getManager(QQManagerFactory.PUSH_NOTICE_MANAGER);
        if (pushNoticeManager != null) {
            pushNoticeManager.j();
        }
        ((IVideoExtractFrameManager) QRoute.api(IVideoExtractFrameManager.class)).onEnterBackground();
        checkRamForAvideo();
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).onEnterBackground();
        WtloginReporter.a(this);
        if (isLogin() && (mayknowRecommendManager = (MayknowRecommendManager) getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)) != null) {
            mayknowRecommendManager.o();
        }
        com.tencent.mobileqq.statistics.d.j();
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).onEnterBackground();
        j71.a.a(this.mAutomator.E);
    }

    public void onRunningForegroudCommon() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onRunningForegroudGeneral");
        }
        ReportController.o(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
        QQMessageFacade messageFacade = getMessageFacade();
        if (messageFacade != null && messageFacade.H1() > 1) {
            ReportController.o(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
        }
        ReportController.B(this, false);
        BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.intent.QZONE_PRE_DOWNLOAD_CANCEL"));
        com.tencent.mobileqq.servlet.e eVar = (com.tencent.mobileqq.servlet.e) getManager(QQManagerFactory.GAMECENTER_MANAGER);
        if (eVar != null) {
            eVar.g();
        }
        com.tencent.mobileqq.model.c cVar = (com.tencent.mobileqq.model.c) getManager(QQManagerFactory.QZONE_MANAGER);
        if (cVar != null) {
            if (cVar.q3() > 0) {
                cVar.Z(cVar.q3());
            }
            cVar.Z(2);
        }
        if (MobileQQ.sMobileQQ.waitAppRuntime(null).isLogin()) {
            IQCircleEeveeManangerService d16 = com.tencent.mobileqq.activity.qcircle.utils.c.d();
            if (d16 != null) {
                d16.onSend(2, null, null);
            }
            IQCirclePreLoaderService e16 = com.tencent.mobileqq.activity.qcircle.utils.c.e();
            if (e16 != null) {
                e16.requestWhiteList(getCurrentUin());
            }
        }
        ((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).onQQForeground(this, false);
        QQUtils.k(getApp().getBaseContext());
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).reportDailyUser(this);
        syncOnlineFriend();
        QQToast.canUseCustomToast();
        if (isCreateManager(QQManagerFactory.MGR_PLUGIN)) {
            ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getPayCode(this);
        }
        IQWalletConfigService iQWalletConfigService = (IQWalletConfigService) getRuntimeService(IQWalletConfigService.class, "");
        if (iQWalletConfigService != null) {
            iQWalletConfigService.tryGetConfig(4);
        }
        if (isLogin() && this.isRealSwitchToBackground) {
            checkBackgroundRestricWhilteList();
        }
        VipGrayConfigHelper.launchBackgroundWebView();
        com.tencent.mobileqq.ecshop.ad.d dVar = (com.tencent.mobileqq.ecshop.ad.d) getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
        if (dVar != null) {
            dVar.doOnRunningForeground();
        }
        QLog.d(TAG, 2, "**davorteng**onRunningForeground...");
        ((IVideoExtractFrameManager) QRoute.api(IVideoExtractFrameManager.class)).onEnterForeground();
        ArkStateCenter.getInstance().setForeground(true);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).onEnterForeground();
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).onEnterForeground();
        TianShuManager.setLastClickAdTraceInfo("", "");
        onLineStatusOnAppForeground();
        AccessibilityUtil.B(this.app);
    }

    @Override // mqq.app.AppRuntime
    public void onRunningForeground() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onRunningForeground");
        }
        super.onRunningForeground();
        if (!TextUtils.isEmpty(getAccount())) {
            onRunningForegroundWithAccount();
        }
        onRunningForegroudCommon();
    }

    public void onWeakNet() {
    }

    public void onX2Mobile() {
        if (this.app != null && isLogin()) {
            if (QLog.isColorLevel()) {
                QLog.d(AppConstants.TAG_RAW_PHOTO, 2, "onX2Mobile ");
            }
            ITransFileController iTransFileController = (ITransFileController) getRuntimeService(ITransFileController.class);
            boolean pauseAllRawSend = iTransFileController.getBusHelper().pauseAllRawSend();
            boolean pauseAllShortVideoSend = iTransFileController.getBusHelper().pauseAllShortVideoSend();
            boolean pauseAllShortVideoReceive = iTransFileController.getBusHelper().pauseAllShortVideoReceive();
            Context context = BaseActivity.sTopActivity;
            if (context == null) {
                context = this.app;
            }
            if (pauseAllRawSend || pauseAllShortVideoSend || pauseAllShortVideoReceive) {
                Intent intent = new Intent(context, (Class<?>) DialogActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.addFlags(131072);
                int i3 = R.string.ad9;
                if (pauseAllShortVideoSend) {
                    if (pauseAllShortVideoReceive) {
                        i3 = R.string.ad_;
                    } else if (!pauseAllRawSend) {
                        i3 = R.string.ad7;
                    }
                } else if (pauseAllShortVideoReceive) {
                    if (!pauseAllRawSend) {
                        i3 = R.string.ad5;
                    }
                } else {
                    i3 = R.string.ad8;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onX2Mobile==============pauseAllRawSendC2C:" + pauseAllRawSend);
                    QLog.d(TAG, 2, "onX2Mobile==============pauseAllShortVideoSend:" + pauseAllShortVideoSend);
                    QLog.d(TAG, 2, "onX2Mobile==============pauseAllShortVideoReceive:" + pauseAllShortVideoReceive);
                    QLog.d(TAG, 2, "onX2Mobile==============dialog message:" + context.getResources().getString(i3));
                }
                intent.putExtra("key_dialog_msg_id", i3);
                context.startActivity(intent);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onX2Mobile app = null,maybe not QQ process");
        }
    }

    public void onX2Wifi() {
        if (this.app != null) {
            if (QLog.isColorLevel()) {
                QLog.d(AppConstants.TAG_RAW_PHOTO, 2, "onX2Wifi ");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onX2Wifi app = null,maybe not QQ process");
        }
    }

    public void playThemeVoice(final int i3) {
        execute(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.13
            @Override // java.lang.Runnable
            public void run() {
                boolean isVideoChatting = QQAppInterface.this.isVideoChatting();
                boolean canPlayThemeSound = QQAppInterface.this.canPlayThemeSound();
                if (!QQAppInterface.this.isRingerSilent() && canPlayThemeSound && !isVideoChatting && !QQAppInterface.this.isRingerVibrate() && !QQAppInterface.this.isRingEqualsZero() && QQAppInterface.this.isCallIdle() && QQAppInterface.this.recordingPttStopped()) {
                    String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
                    if (!TextUtils.isEmpty(skinRootPath)) {
                        StringBuilder sb5 = new StringBuilder(skinRootPath);
                        sb5.append(File.separatorChar);
                        sb5.append("voice");
                        sb5.append(File.separatorChar);
                        sb5.append("tab");
                        sb5.append(i3);
                        sb5.append(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION);
                        File file = new File(sb5.toString());
                        if (QLog.isColorLevel()) {
                            QLog.d("playThemeVoice", 2, "Uri:" + sb5.toString());
                        }
                        if (file.exists()) {
                            AudioUtil.p(Uri.fromFile(file), false, false);
                        }
                    }
                }
            }
        });
    }

    public void putBitmapToCache(String str, Bitmap bitmap, byte b16) {
        ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).putBitmapToCache(str, bitmap, b16);
    }

    public int readCallTabStateVal(int i3) {
        if (this.app != null && i3 >= 0 && i3 < 7) {
            String readValue = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY, AppConstants.CallTabType.CALLTAB_DEFAULTVAL);
            if (readValue != null && readValue.length() == 7) {
                int charAt = readValue.charAt(i3) - '0';
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "uin:" + getCurrentAccountUin() + ",readCallTabStateVal index=" + i3 + ", resut=" + charAt);
                }
                return charAt;
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "readCallTabStateVal val is null");
            }
            return -1;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "readCallTabStateVal wrong index," + i3);
        }
        return -1;
    }

    @Override // com.tencent.common.app.AppInterface
    public void receiveToService(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        super.receiveToService(toServiceMsg, fromServiceMsg);
        if (AppSetting.A()) {
            try {
                getParcelHooker().printParams(toServiceMsg, fromServiceMsg);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "receiveToService: ", th5);
            }
        }
    }

    public boolean recordingPttStopped() {
        return true;
    }

    public void refreshFace(String str) {
        IQQAvatarHandlerService iQQAvatarHandlerService;
        if (!TextUtils.isEmpty(str) && (iQQAvatarHandlerService = (IQQAvatarHandlerService) getRuntimeService(IQQAvatarHandlerService.class, "")) != null) {
            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                iQQAvatarHandlerService.getMobileQQHead(str);
            } else {
                iQQAvatarHandlerService.getCustomHead(str);
            }
        }
    }

    public void refreshMsgTabUnreadNum(boolean z16, int i3) {
        bt btVar = this.mMsgTabUnreadListener;
        if (btVar != null) {
            btVar.a(z16, i3);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format(Locale.getDefault(), "refreshMsgTabUnreadNum mMsgTabUnreadListener is null, [%b, %d]", Boolean.valueOf(z16), Integer.valueOf(i3)));
        }
    }

    public void refreshStrangerFace(String str, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.QQ_HEAD, 2, "refreshStrangerFace.id=" + str + ",idType=" + i3 + ",delLocalCache=" + z16);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i3 != 200 && i3 != 204 && i3 != 202) {
            return;
        }
        if (z16) {
            removeFaceIconCache(32, str, i3);
            File file = new File(getCustomFaceFilePath(32, str, i3));
            if (file.exists()) {
                file.delete();
            }
        }
        IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) getRuntimeService(IQQAvatarHandlerService.class, "");
        if (iQQAvatarHandlerService != null) {
            iQQAvatarHandlerService.getStrangerHead(str, i3, (byte) 1, (byte) 0);
        }
    }

    public void refreshTroopFace(String str) {
        IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) getRuntimeService(IQQAvatarHandlerService.class, "");
        if (iQQAvatarHandlerService != null) {
            iQQAvatarHandlerService.getTroopHead(str);
        }
    }

    public void registerHeadBroadcastReceiver() {
        if (getApp() == null) {
            QLog.e(TAG, 1, "registerHeadBroadcastReceiver fail, app is null");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qqhead.getheadreq");
        intentFilter.addAction(FaceConstant.HeadBroadcast.BROADCAST_QQHEAD_REFRESH_HEAD_REQ);
        try {
            getApp().registerReceiver(this.qqHeadBroadcastReceiver, intentFilter);
            makeSureHeadBroadcastAvailable();
            QLog.i(TAG, 1, "registerHeadBroadcastReceiver success");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[registerHeadBroadcastReceiver] error:", th5);
        }
    }

    public void releaseAvAddFriendService() {
        com.tencent.av.app.b bVar = this.mAvAddFriendService;
        if (bVar != null) {
            bVar.j();
            this.mAvAddFriendService = null;
        }
    }

    public void removeAboutListener(ResourcePluginListener resourcePluginListener) {
        AboutConfig aboutConfig = this.aboutConfig;
        if (aboutConfig != null) {
            aboutConfig.q(resourcePluginListener);
        }
    }

    public void removeBitmapFromCache(String str) {
        ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).removeBitmapFromCache(str);
    }

    public void removeFaceIconCache(int i3, String str, int i16) {
        ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).removeFaceIconCache(i3, str, i16);
    }

    public void removeFaceIconCacheApollo(int i3, String str, int i16) {
        ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).removeFaceIconCacheApollo(i3, str, i16);
    }

    public void removeNotification() {
        NotificationFacade.A().I();
        ThreadManagerV2.post(new AnonymousClass9(), 10, null, true);
        try {
            sendToService(new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "CMD_STOP_NOTIFIYCATION"));
        } catch (Exception unused) {
        }
    }

    public void removeVibrateListener(dm dmVar) {
        if (dmVar == null) {
            return;
        }
        this.vibrateListenerList.remove(dmVar);
    }

    public void resetQQHeadBroadcastRegisterState() {
        sIsQQHeadBroadcastRegister = false;
    }

    public void sendQQHeadBroadcast(int i3, String str, int i16, String str2) {
        ((IQQAvatarBroadcastService) getRuntimeService(IQQAvatarBroadcastService.class, "")).sendQQHeadBroadcast(i3, str, i16, str2);
    }

    public void sendRegisterPush() {
        long j3;
        if (isAccLoginSuccess()) {
            ((PushManager) getManager(4)).registProxyMessagePush(getAppid(), this.app.getPackageName() + MsfConstants.PROCESS_VIDEO, "com.tencent.av.ui.VChatActivity", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c");
            ((PushManager) getManager(4)).registProxyMessagePush(getAppid(), this.app.getPackageName() + ":nearby_video", "", "VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c");
            IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) getRuntimeService(IOnlineStatusService.class);
            iOnlineStatusService.registerObserver();
            boolean curLoginStatus = getCurLoginStatus();
            long j16 = this.app.getSharedPreferences(getAccount(), 0).getInt("GetFrdListReq_seq", 0);
            AppRuntime.Status onlineStatus = iOnlineStatusService.getOnlineStatus();
            if ((onlineStatus == null || onlineStatus == AppRuntime.Status.offline || onlineStatus == AppRuntime.Status.receiveofflinemsg) && ((onlineStatus = ((IOnlineStatusService) getRuntimeService(IOnlineStatusService.class)).getOnlineStatusFromSP()) == null || onlineStatus == AppRuntime.Status.offline || onlineStatus == AppRuntime.Status.receiveofflinemsg)) {
                onlineStatus = AppRuntime.Status.online;
                QLog.d(TAG, 1, "sendRegisterPush, change to online, status: " + onlineStatus);
            }
            AppRuntime.Status status = onlineStatus;
            if (status == AppRuntime.Status.online) {
                long extOnlineStatus = iOnlineStatusService.getExtOnlineStatus();
                if (extOnlineStatus == -1) {
                    extOnlineStatus = iOnlineStatusService.getExtOnlineStatusFromSP();
                    if (extOnlineStatus == -1) {
                        QLog.d(TAG, 1, "sendRegisterPush, change to online, ext_status: " + extOnlineStatus);
                    }
                }
                j3 = extOnlineStatus;
            } else {
                j3 = -1;
            }
            iOnlineStatusService.checkBatteryStatus();
            iOnlineStatusService.sendOnlineStatusWithExt(status, curLoginStatus, j16, false, j3);
            this.mRegisterPushTime = NetConnInfoCenter.getServerTime();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, String.format("sendRegisterPush onlineStatus: %s, isKickPC: %s, largeSeq: %s, mRegisterPushTime: %s", status, Boolean.valueOf(curLoginStatus), Long.valueOf(j16), Long.valueOf(this.mRegisterPushTime)));
            }
        }
    }

    public void sendSelfQQHeadBroadcast(int i3, String str, int i16, String str2) {
        ((IQQAvatarBroadcastService) getRuntimeService(IQQAvatarBroadcastService.class, "")).sendSelfQQHeadBroadcast(i3, str, i16, str2);
    }

    public void setALLGeneralSettingRing(int i3) {
        ((IRoamSettingService) getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue(AppConstants.RoamingMapPath.ALL_RING, Integer.valueOf(i3));
    }

    public void setALLGeneralSettingVibrate(int i3) {
        ((IRoamSettingService) getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue(AppConstants.RoamingMapPath.ALL_VIBRATE, Integer.valueOf(i3));
    }

    @Override // mqq.app.AppRuntime
    public void setAutoLogin(boolean z16) {
        String str;
        if (!getCurrentAccountUin().equals("0")) {
            str = getCurrentAccountUin();
        } else {
            str = "";
        }
        AutoLoginUtil.setAutoLogin(str, z16);
    }

    public void setC2CRoamingSetting(int i3) {
        ((IRoamSettingService) getRuntimeService(IRoamSettingService.class, "")).setRoamSettingNewValue(AppConstants.RoamingMapPath.C2C_ROAMING_MSG, Integer.valueOf(i3));
    }

    public void setLoadingState() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onConnOpenAndStartGetMsg");
        }
        com.tencent.mobileqq.managers.b.b().k(1, "onMessageConnect");
        MqqHandler handler = getHandler(Conversation.class);
        if (handler != null) {
            handler.obtainMessage(Conversation.MSG_CHANGE_LOADINGSTATE, (Runnable) null).sendToTarget();
        }
        ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(9, null);
    }

    public void setMSFConnect(boolean z16) {
        this.isMSFConnect = Boolean.valueOf(z16);
    }

    public void setMainActivityState(boolean z16) {
        this.mainActivityIsForeground = z16;
    }

    public void setMsgTabUnreadListener(bt btVar) {
        this.mMsgTabUnreadListener = btVar;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setMsgTabUnreadListener lis: " + btVar);
        }
    }

    public void setNotAllowedSeeMyDongtai(boolean z16, boolean z17) {
        if (z17) {
            ((FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setDongtaiPermission(z16, getCurrentAccountUin(), 1);
            return;
        }
        getPref().edit().putBoolean(getApp().getString(R.string.ck_) + getCurrentAccountUin(), z16).commit();
    }

    public void setPhoneNumSearchable(boolean z16, boolean z17) {
        if (z17) {
            ((CardHandler) getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).o5(z16);
            return;
        }
        getPref().edit().putBoolean(getApp().getString(R.string.cyp) + getCurrentAccountUin(), z16).commit();
    }

    public void setSecDetBannerIntent(Intent intent) {
        this.mSecurityDetectBannerIntent = intent;
    }

    public void setShieldHisDongtai(boolean z16, boolean z17) {
        if (z17) {
            ((FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setDongtaiPermission(z16, getCurrentAccountUin(), 2);
            return;
        }
        getPref().edit().putBoolean(getApp().getString(R.string.hjx) + getCurrentAccountUin(), z16).commit();
    }

    @TargetApi(14)
    public void setTalkbackSwitch() {
        boolean z16;
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.app.getSystemService("accessibility");
            boolean isEnabled = accessibilityManager.isEnabled();
            boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (isEnabled && isTouchExplorationEnabled) {
                z16 = true;
            } else {
                z16 = false;
            }
            AppSetting.f99565y = z16;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "set talkback enable: " + AppSetting.f99565y);
            }
            if (AppSetting.f99565y) {
                SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("Talkback", 0);
                if (System.currentTimeMillis() - sharedPreferences.getLong("LastTime", 0L) > 86400000) {
                    StatisticCollector.getInstance(this.app).collectPerformance(null, "enableTalkback", true, 0L, 0L, null, null);
                    sharedPreferences.edit().putLong("LastTime", System.currentTimeMillis()).commit();
                }
            }
        } catch (Throwable unused) {
        }
        if (AppSetting.f99565y) {
            com.tencent.mobileqq.util.bq.b(getApplication());
        } else {
            com.tencent.mobileqq.util.bq.a();
        }
    }

    public void setVisibilityForInputStatus(boolean z16, boolean z17) {
        if (z17) {
            ((InputStatusHandler) getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER)).H2(z16);
            return;
        }
        QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeBool(getApp().getString(R.string.hm7) + getCurrentAccountUin(), z16);
    }

    public void setVisibilityForNetWorkStatus(boolean z16, boolean z17) {
        if (z17) {
            ((FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setVisibilityForNetWorkStatus(z16);
            return;
        }
        getPref().edit().putBoolean(getApp().getString(R.string.hm8) + getCurrentAccountUin(), z16).commit();
    }

    public void setVisibilityForStatus(boolean z16, boolean z17) {
        if (z17) {
            getPref().edit().putBoolean(getApp().getString(R.string.cyt) + getCurrentAccountUin(), z16).commit();
            return;
        }
        ((LBSHandler) getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).S2(z16);
    }

    public void setZanAllowed(boolean z16, boolean z17) {
        if (z16) {
            this.mTryTimeForNear = 1;
        } else {
            this.mTryTimeForStatus = 1;
        }
        ((CardHandler) getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).e5(z16, z17);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap shield(Bitmap bitmap) {
        Bitmap bitmap2;
        try {
            bitmap2 = BitmapFactory.decodeResource(this.app.getResources(), R.drawable.h2e);
        } catch (Exception e16) {
            e16.printStackTrace();
            bitmap2 = null;
            if (bitmap2 != null) {
            }
            return bitmap;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            bitmap2 = null;
            if (bitmap2 != null) {
            }
            return bitmap;
        }
        if (bitmap2 != null) {
            new Canvas(bitmap).drawBitmap(bitmap2, (bitmap.getWidth() - bitmap2.getWidth()) - 1, (bitmap.getHeight() - bitmap2.getHeight()) - 1, new Paint());
        }
        return bitmap;
    }

    public void showIdleNotification(Context context, Class<?> cls) {
        Intent intent;
        String str;
        Bitmap bitmap;
        Intent aliasIntent;
        if (!isOpenNoClearNotification() || context == null) {
            return;
        }
        if (cls == null) {
            if (context instanceof Activity) {
                aliasIntent = new Intent(this.app.getApplicationContext(), context.getClass());
                Bundle extras = ((Activity) context).getIntent().getExtras();
                if (extras != null) {
                    extras.remove("single");
                    extras.remove("selfuin");
                    aliasIntent.putExtras(extras);
                }
            } else {
                aliasIntent = SplashActivity.getAliasIntent(this.app.getApplicationContext());
            }
            intent = aliasIntent;
        } else {
            intent = new Intent(this.app.getApplicationContext(), cls);
        }
        intent.putExtra("fromNotification", true);
        intent.addFlags(536870912).addFlags(67108864);
        if (!isAccLoginSuccess()) {
            return;
        }
        String currentAccountUin = getCurrentAccountUin();
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(currentAccountUin), TAG);
        if (friendsSimpleInfoWithUid != null) {
            Bitmap faceBitmap = getFaceBitmap(1, friendsSimpleInfoWithUid.x(), (byte) 3, true, 0);
            if (faceBitmap == null) {
                faceBitmap = BaseImageUtil.getDefaultFaceBitmap();
            }
            if (friendsSimpleInfoWithUid.p() != null && friendsSimpleInfoWithUid.p().length() > 0) {
                currentAccountUin = friendsSimpleInfoWithUid.p();
            }
            str = currentAccountUin;
            bitmap = faceBitmap;
        } else {
            str = currentAccountUin;
            bitmap = null;
        }
        showNotificationWithoutMessage(new com.tencent.mobileqq.app.notification.struct.e(intent, "", str, this.app.getString(R.string.h3k), bitmap), "CMD_IDLE_NOTIFIYCATION");
    }

    void showNotificationWithoutMessage(com.tencent.mobileqq.app.notification.struct.e eVar, String str) {
        String f16 = eVar.f();
        Bitmap e16 = eVar.e();
        String c16 = eVar.c();
        String d16 = eVar.d();
        Intent b16 = eVar.b();
        if (QLog.isColorLevel()) {
            QLog.d("[NotificationRebuild] notification", 2, "showNotificationWithoutMessage. cmd=" + str + ", ticker=" + com.tencent.mobileqq.util.aw.a(f16) + ",msgShow:" + com.tencent.mobileqq.util.aw.a(d16) + ", bitmap=" + e16);
        }
        String[] strArr = {f16, c16, d16};
        if (e16 == null) {
            e16 = com.tencent.mobileqq.util.j.g(this.app.getResources(), R.drawable.icon);
        }
        if (e16 != null) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), str);
            toServiceMsg.extraData.putStringArray("cmds", strArr);
            b16.putExtra(QQNotificationManager.PARAM_NOTIFYID, 275);
            toServiceMsg.extraData.putParcelable("intent", b16);
            toServiceMsg.extraData.putParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP, e16);
            sendToService(toServiceMsg);
        }
    }

    public void showReadedMsgNotification(com.tencent.imcore.message.Message message, com.tencent.imcore.message.Message message2) {
        int size = this.msgFacade.f116353m.getInBackgroundMessages().size();
        int totalCounter = this.msgFacade.f116353m.getTotalCounter();
        if (QLog.isColorLevel()) {
            QLog.d(TAG_NOTIFY, 2, "showReadedMsgNotification, Messages size:" + size + ", counter:" + totalCounter);
        }
        com.tencent.util.notification.d h16 = com.tencent.util.notification.d.h(this);
        if (message != null && size != 0 && totalCounter != 0) {
            if (isShowMsgContent()) {
                if (message2 != null && com.tencent.util.notification.d.k(message2)) {
                    if (h16 != null && h16.i(message2)) {
                        showMessageNotificationWithPreview(message2, false);
                    }
                } else {
                    showMessageNotificationWithPreview(message, false);
                }
            } else {
                showMessageNotificationNoPreview(message, false);
            }
        } else {
            cancelNotification();
        }
        if (isShowMsgContent() && h16 != null) {
            h16.c(message2);
        }
    }

    @Override // mqq.app.AppRuntime
    public void start(boolean z16) {
        if (z16 && !com.tencent.mobileqq.startup.a.f289668i) {
            QLog.d(TAG, 1, "start execute delay!");
            return;
        }
        this.netHandler = new MyNetInfoHandler(this);
        AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.netHandler);
        super.start(z16);
    }

    public boolean startAllSubMessageAccountMsg(boolean z16) {
        return startAllSubMessageAccountMsg(z16, 0);
    }

    public void startInspect() {
        gd2.g.f401968a.b(this);
    }

    public void switchOffMediaPredownload() {
        QLog.i("PicPreDownload", 1, "switch off predownload, stack=" + QLog.getStackTraceString(new RuntimeException()));
        ((IPicPreDownload) getRuntimeService(IPicPreDownload.class, "")).switchOff();
        getShortVideoPredownloer().p();
    }

    public void syncOnlineFriend() {
        if (!sGetOnlineFriendHandler.hasMessages(0) && this.isStartSyncOnlineFriend) {
            long j3 = 0;
            if (sLastGetOnlineFriendTime != 0) {
                long uptimeMillis = sNextGetOnlineFriendDelay - (SystemClock.uptimeMillis() - sLastGetOnlineFriendTime);
                if (uptimeMillis >= 0) {
                    j3 = uptimeMillis;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onResume send msg " + j3);
            }
            sGetOnlineFriendHandler.sendMessageDelayed(sGetOnlineFriendHandler.obtainMessage(0, new WeakReference(this)), j3);
        }
    }

    public boolean troopCanPlaySound() {
        return this.soundAndVibrateUtils.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean troopCanVibrator() {
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(this) == 0) {
            return false;
        }
        return true;
    }

    protected void tryReuploadQfavItems() {
        if (!this.needReuploadQfav) {
            this.needReuploadQfav = true;
        } else if (isLogin() && this.needReuploadQfav) {
            if (QLog.isColorLevel()) {
                QLog.i(ProcessConstant.QQFAV, 2, "Wifi, tryReuploadQfavItems");
            }
            QfavHelper.A(this);
        }
    }

    public boolean trySetCardSwitch(boolean z16, boolean z17) {
        if (z16) {
            int i3 = this.mTryTimeForNear;
            this.mTryTimeForNear = i3 + 1;
            if (i3 >= 3) {
                return false;
            }
        }
        int i16 = this.mTryTimeForStatus;
        this.mTryTimeForStatus = i16 + 1;
        if (i16 >= 3) {
            return false;
        }
        ((CardHandler) getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).e5(z16, z17);
        return true;
    }

    public void trySoundAndVibrate() {
        this.soundAndVibrateUtils.p();
    }

    public Object[] unitTestLog(String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unitTestLog: invoked. ", " methodName: ", str, objArr);
        }
        return objArr;
    }

    public boolean updateMediaPredownloadSwitch() {
        try {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("postpone_media_predownload_switch_off", true);
            QLog.i("PicPreDownload", 1, "[updateMediaPredownloadSwitch] switch=" + isSwitchOn);
            QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeBool("postpone_media_predownload_switch_off", isSwitchOn);
            return isSwitchOn;
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[updateMediaPredownloadSwitch] exc=" + th5);
            return false;
        }
    }

    public void updateSettingTableCache(Setting setting) {
        ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(setting);
    }

    @Override // mqq.app.AppRuntime
    protected void userLogoutReleaseData() {
        sendBindUinOffline();
        com.tencent.mobileqq.upgrade.k.i().v(true);
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).clearSystemMsgData();
        MsgAutoMonitorUtil.getInstance().release();
        ChatActivityUtils.T();
        BadgeUtils.m(this.app, 0);
        com.tencent.qqconnect.wtlogin.c.b(this.app);
        ((ITransFileController) getRuntimeService(ITransFileController.class)).getBusHelper().pauseAllShortVideoReceive();
        ((ITransFileController) getRuntimeService(ITransFileController.class)).getBusHelper().pauseAllShortVideoSend();
        OpenApiManager.getInstance().onUserLogout(this);
        this.mAutomator.onDestroy();
        wx.b.d().c();
        SplashADUtil.y(BaseApplication.getContext());
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateMiniAppList(100);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).hideColorNoteSmallScreen(getApp());
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).doWhenQQLogout();
        ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).doWhenQQLogout();
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).doWhenQQLogout();
        ThirdPushManager.getInstance().onLogout();
        NTMsgMigrationManager.X().M0();
        ((IWifiPhotoService) QRoute.api(IWifiPhotoService.class)).disconnect();
        ((IExportFileService) QRoute.api(IExportFileService.class)).disconnect();
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).onLogout(Constants.LogoutReason.user);
    }

    @Override // mqq.app.AppRuntime
    protected void userLogoutWhenSendState() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("nt_offline_use_sync", true);
        QLog.d(TAG, 1, "call offline: ", Boolean.valueOf(isSwitchOn));
        if (isSwitchOn) {
            useSyncOffline();
        } else {
            useAsyncOffline();
        }
    }

    public void vibratorAndAudio() {
        vibratorAndAudio(null, false, true);
    }

    void vibratorAndAudioForMsg(MessageRecord messageRecord, boolean z16) {
        this.soundAndVibrateUtils.r(messageRecord, z16);
    }

    public void vibratorAndAudioForShake(String str, boolean z16) {
        this.soundAndVibrateUtils.s(str, z16);
    }

    public void writeCallTabStateVal(Integer[] numArr) {
        writeCallTabStateVal(numArr, true);
    }

    public void addManager(boolean z16, long j3) {
        if (z16) {
            for (int i3 : IMPORTANT_MANAGERS) {
                int i16 = QQManagerFactory.MGR_PLUGIN;
                if (i3 == i16) {
                    QLog.d("QQInitHandler", 2, "pluginManageDelayTime=", Long.valueOf(j3));
                    if (j3 > 0) {
                        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.3
                            @Override // java.lang.Runnable
                            public void run() {
                                QQAppInterface.this.getManager(QQManagerFactory.MGR_PLUGIN);
                            }
                        }, j3);
                    } else if (j3 == 0) {
                        getManager(i16);
                    }
                } else {
                    getManager(i3);
                }
            }
            return;
        }
        for (int i17 = 0; i17 < QQManagerFactory.COUNT_MANAGER; i17++) {
            if (i17 != QQManagerFactory.MGR_MEDIA_PLAYER) {
                getManager(i17);
            }
        }
    }

    public Bitmap getFaceBitmap(String str, byte b16, boolean z16) {
        return getFaceBitmap(1, str, b16, z16, 0);
    }

    public Drawable getFaceDrawable(String str, boolean z16, byte b16) {
        Bitmap faceBitmap = getFaceBitmap(1, str, b16, true, 0);
        if (faceBitmap != null && z16) {
            faceBitmap = BaseImageUtil.grey(faceBitmap);
        }
        BitmapDrawable bitmapDrawable = faceBitmap != null ? new BitmapDrawable(faceBitmap) : null;
        return bitmapDrawable == null ? BaseImageUtil.getDefaultFaceDrawable() : bitmapDrawable;
    }

    @Override // mqq.app.AppRuntime
    public com.tencent.mobileqq.service.message.e getMsgCache() {
        if (this.msgCache == null) {
            this.msgCache = new com.tencent.mobileqq.service.message.e(this);
        }
        return this.msgCache;
    }

    public Drawable getTroopFaceDrawable(String str, byte b16, boolean z16, boolean z17) {
        Bitmap troopFaceBitmap = getTroopFaceBitmap(str, b16, z16, z17);
        BitmapDrawable bitmapDrawable = troopFaceBitmap != null ? new BitmapDrawable(troopFaceBitmap) : null;
        return bitmapDrawable == null ? BaseImageUtil.getDefaultTroopFaceDrawable() : bitmapDrawable;
    }

    public void handleReceivedMessage(int i3, boolean z16, boolean z17, com.tencent.imcore.message.Message message) {
        bq bqVar = new bq(this, i3, z16, z17);
        this.messageNotifiableChecker = bqVar;
        QQMessageFacade e16 = bqVar.e();
        if (e16 == null) {
            return;
        }
        if (message == null) {
            message = e16.v1();
        }
        if (this.messageNotifiableChecker.z(e16, message)) {
            return;
        }
        QLog.d(TAG_NOTIFY, 1, "handleReceivedMessage ", " message: " + message.toString());
        this.messageNotifiableChecker.C();
        if (this.messageNotifiableChecker.b(message)) {
            if (this.messageNotifiableChecker.D(message)) {
                QLog.i(TAG_NOTIFY, 1, "handleReceivedMessage, updateMessageCounter return false");
                return;
            }
            com.tencent.util.j.a(this, message.istroop, message.msgUid);
            unitTestLog("reportEvent", this, Integer.valueOf(message.istroop), Long.valueOf(message.msgUid));
            OpenApiManager.getInstance().onReceiveNewMsg(message);
            unitTestLog("onReceiveNewMsg", message);
            e16.f116353m.addMessage(message);
            notifyMessageReceived(message, z16, z17);
            unitTestLog("notifyMessageReceived", message, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else if (this.soundAndVibrateUtils.m(z16, z17, message, this.messageNotifiableChecker)) {
            return;
        }
        ((MiniMsgHandler) getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).F2(message.frienduin, message.istroop, message.msgtype);
        ((IZPlanMiniAIOHelper) QRoute.api(IZPlanMiniAIOHelper.class)).notifyUnreadCount();
        ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).notifyUnreadCount();
        unitTestLog("notifyUnreadState", message.frienduin, Integer.valueOf(message.istroop), Integer.valueOf(message.msgtype));
        if (isLogin()) {
            ((IAppBadgeService) getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }

    @Deprecated
    public boolean isTroopMark(String str, int i3) {
        return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopMark(this, str, i3);
    }

    public void onWeakNet(FromServiceMsg fromServiceMsg) {
    }

    public boolean startAllSubMessageAccountMsg(boolean z16, int i3) {
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() isFromPush=" + z16 + " fetchMsgType=" + i3);
        }
        ISubAccountService iSubAccountService = (ISubAccountService) getRuntimeService(ISubAccountService.class, "");
        ArrayList<String> allSubUin = iSubAccountService != null ? iSubAccountService.getAllSubUin() : null;
        if (allSubUin != null) {
            Iterator<String> it = allSubUin.iterator();
            z17 = false;
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.length() > 4) {
                    if (i3 != 2) {
                        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).loadServerMessage(this, next, z16);
                    }
                    z17 = true;
                    if (i3 != 1 && !((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
                        ((ISubAccountServlet) QRoute.api(ISubAccountServlet.class)).fetchOneTroopNewMsg(this, next);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() continue, subUin=" + next);
                }
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() listSubUin==null");
            }
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() result=" + z17 + " forground=" + QBaseActivity.mAppForground);
        }
        ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) getRuntimeService(ISubAccountControlService.class, "");
        if (iSubAccountControlService != null) {
            if (z17) {
                if (QBaseActivity.mAppForground) {
                    iSubAccountControlService.launchTimedMsgTask(this, i3);
                }
            } else {
                iSubAccountControlService.cancelTimedMsgTask(this, 0);
            }
        }
        return z17;
    }

    public void vibratorAndAudio(MessageRecord messageRecord, boolean z16, boolean z17) {
        this.soundAndVibrateUtils.q(messageRecord, z16, z17);
    }

    public void writeCallTabStateVal(Integer[] numArr, boolean z16) {
        String readValue = SettingCloneUtil.readValue(getApplication(), getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY, AppConstants.CallTabType.CALLTAB_DEFAULTVAL);
        if (readValue != null && readValue.length() <= 7 && numArr != null && numArr.length == 7) {
            if (readValue.length() < 7) {
                readValue = readValue + AppConstants.CallTabType.CALLTAB_DEFAULTVAL.substring(readValue.length());
            }
            StringBuilder sb5 = new StringBuilder(readValue);
            for (int i3 = 0; i3 < numArr.length; i3++) {
                Integer num = numArr[i3];
                if (num != null) {
                    if (num.intValue() >= 0 && num.intValue() <= 9) {
                        sb5.setCharAt(i3, (char) (num.intValue() + 48));
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "writeCallTabStateVal wrong index,," + num);
                            return;
                        }
                        return;
                    }
                }
            }
            if (numArr[0] != null) {
                this.mCallTabShowState = 0;
                this.isCallTabShow = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "uin:" + getCurrentAccountUin() + ",writeCallTabStateVal vals=" + numArr + ",mIsCallTabShow=" + this.mCallTabShowState + ",isCallTabShow=" + this.isCallTabShow);
            }
            SettingCloneUtil.writeValue(getApplication(), getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_CALLTAB_SHOW_KEY, sb5.toString());
            String e16 = getNowLiveManager().e();
            char charAt = e16.charAt(2);
            if (z16 && e16.charAt(0) == '0' && numArr[0] != null) {
                if (charAt == '2' || charAt == '3') {
                    Integer[] numArr2 = new Integer[5];
                    numArr2[0] = 1;
                    getNowLiveManager().k(numArr2, false);
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "writeCallTabStateVal valid val," + readValue + "," + numArr);
        }
    }

    public String getCustomFaceFilePath(int i3, String str, int i16) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, i3, str, i16, 0);
    }

    @Override // mqq.app.AppRuntime
    @Deprecated
    public com.tencent.mobileqq.persistence.l getEntityManagerFactory(String str) {
        if (str.equals(getAccount())) {
            return getEntityManagerFactory();
        }
        throw new IllegalStateException(str + "!=" + getAccount());
    }

    public Bitmap getFaceBitmap(int i3, String str, boolean z16, int i16) {
        return getFaceBitmap(i3, str, (byte) 3, z16, i16);
    }

    public String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16, int i17, boolean z16) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getFaceBitmapCacheKey(i3, str, b16, i16, i17, z16);
    }

    public Bitmap getFaceBitmap(int i3, String str, byte b16, boolean z16, int i16) {
        return getFaceBitmap(i3, str, b16, z16, (byte) 1, i16);
    }

    public String getCustomFaceFilePath(int i3, String str, int i16, int i17) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, i3, str, i16, i17);
    }

    public Bitmap getFaceBitmap(int i3, String str, byte b16, boolean z16, byte b17, int i16) {
        return ((IQQAvatarCompatibleService) getRuntimeService(IQQAvatarCompatibleService.class, "")).getFaceBitmap(i3, str, b16, 100, z16, b17, i16);
    }

    @Override // mqq.app.AppRuntime
    public com.tencent.mobileqq.persistence.l getEntityManagerFactory() {
        String account = getAccount();
        if (account != null) {
            if (this.emFactory != null) {
                return this.emFactory;
            }
            synchronized (this) {
                if (this.emFactory == null) {
                    this.emFactory = com.tencent.mobileqq.persistence.l.d(account, super.getEntityManagerFactory());
                    ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.QQAppInterface.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!QQAppInterface.this.emFactory.verifyAuthentication()) {
                                QLog.e(QQAppInterface.TAG, 1, "", new RuntimeException("WTF"));
                                if (QQAppInterface.this.isLogin()) {
                                    QQAppInterface.this.logout(true);
                                }
                                Intent intent = new Intent(NewIntent.ACTION_ACCOUNT_KICKED);
                                intent.putExtra("title", HardCodeUtil.qqStr(R.string.qlx));
                                intent.putExtra("msg", HardCodeUtil.qqStr(R.string.qlz));
                                intent.putExtra("reason", Constants.LogoutReason.kicked);
                                intent.addFlags(268435456);
                                BaseApplicationImpl.sApplication.startActivity(intent);
                            }
                        }
                    }, 3000L);
                }
            }
            return this.emFactory;
        }
        throw new IllegalStateException("WTF");
    }

    public String getCustomFaceFilePath(Setting setting, int i3, String str, int i16, int i17) {
        return ((IQQAvatarDataService) getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(setting, i3, str, i16, i17);
    }

    public final void getVisibilityForInputStatus(boolean z16, iv3.a aVar) {
        ((InputStatusHandler) getBusinessHandler(BusinessHandlerFactory.INPUT_STATUS_HANDLER)).G2(aVar);
        getVisibilityForInputStatus(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void addManager(int i3, Manager manager) {
        Manager[] managerArr = this.managers;
        if (managerArr[i3] != null) {
            return;
        }
        managerArr[i3] = manager;
    }

    @Deprecated(since = "\u83b7\u53d6\u7fa4\u6210\u5458\u6635\u79f0\u5efa\u8bae\u4f7f\u7528ITroopMemberListRepoApi#fetchTroopMemberName\u83b7\u53d6")
    public String getTroopDisscussMemberNick(String str, String str2, int i3, boolean z16) {
        String showName;
        if (i3 != 1000 && i3 != 1020) {
            showName = com.tencent.mobileqq.utils.ac.n(this, str2, str);
        } else {
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str2, str, null, TAG);
            showName = troopMemberInfoSync != null ? troopMemberInfoSync.nickInfo.getShowName() : str;
        }
        if (TextUtils.isEmpty(showName) || showName.equals(str)) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), TAG);
            if (friendsSimpleInfoWithUid != null) {
                showName = !TextUtils.isEmpty(friendsSimpleInfoWithUid.r()) ? friendsSimpleInfoWithUid.r() : friendsSimpleInfoWithUid.p();
            }
            if (z16 && ((TextUtils.isEmpty(showName) || showName.equals(str)) && !this.friendInfoQueue.contains(str))) {
                this.friendInfoQueue.add(str);
                FriendListHandler friendListHandler = (FriendListHandler) getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                addObserver(this.friendListObserver);
                if (QLog.isColorLevel()) {
                    QLog.d("QQAppInterface_friendListObserver", 2, "addObserver");
                }
                friendListHandler.getFriendInfo(str);
            }
        }
        return (showName == null || "".equals(showName)) ? str : showName;
    }

    private void checkGetManagerCallingDepthEnd() {
    }

    public void onCreateDebug() {
    }

    @Override // mqq.app.AppRuntime
    public void onProxyIpChanged() {
    }

    private void checkGetManagerCallingDepthStart(int i3) {
    }

    public void setAllTroopsReceiveStatus(boolean z16) {
    }

    public void setCheckPttListener(e eVar) {
    }

    public void setMultiAIOUnreadListener(bv bvVar) {
    }

    public void refreshMultiAIOUnreadNum(String str, int i3) {
    }
}
