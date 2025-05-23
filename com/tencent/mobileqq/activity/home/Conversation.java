package com.tencent.mobileqq.activity.home;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.etrump.mixlayout.VasShieldFont;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.ba;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.IAdConfigApi;
import com.tencent.gdtad.event.MiniAppAdOpenLandingEvent;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.bm;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.chats.NtBasePartFrame;
import com.tencent.mobileqq.activity.home.chats.api.IChatApi;
import com.tencent.mobileqq.activity.home.chats.biz.BannerPart;
import com.tencent.mobileqq.activity.home.chats.biz.ObserverPart;
import com.tencent.mobileqq.activity.home.chats.biz.SubAccountBindPart;
import com.tencent.mobileqq.activity.home.chats.biz.ThirdPart;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSubscribeChannelReturnType;
import com.tencent.mobileqq.activity.home.chats.biz.i;
import com.tencent.mobileqq.activity.home.chats.unread.NtUnreadPart;
import com.tencent.mobileqq.activity.home.parts.NTMsgMigrationPart;
import com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout;
import com.tencent.mobileqq.activity.home.view.TitleAreaLeftLayout;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MissedCallBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetStateBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VerifyPhoneBannerProcessor;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SkinActivityModule;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.chatlist.IMainChatsCardContainerApi;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.font.FontSizeChangeBannerHelper;
import com.tencent.mobileqq.guild.api.IGuildChannelLoadApi;
import com.tencent.mobileqq.login.api.ILoginSuccessAnimApi;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper;
import com.tencent.mobileqq.main.api.IMainUIHelperApi;
import com.tencent.mobileqq.managers.MsgRefreshTipMgr;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.IRefreshOperator;
import com.tencent.mobileqq.mini.entry.IRefreshStatusListener;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.minigame.api.report.IMiniGameReport;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.IQCircleChatMsgNtApi;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqsettingme.QQSettingMe;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.api.IAddTroopAccountIdentityApi;
import com.tencent.mobileqq.ui.ConversationContainer;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mobileqq.utils.dc;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.theme.ThemeVideoController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.chats.IAIServiceApi;
import com.tencent.qqnt.chats.api.IChatsDataRepoCreator;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.biz.main.MainChatsListVB;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.core.mvi.a;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.userintent.a;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qui.quiblurview.f;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.TraceUtils;
import friendlist.GetOnlineInfoResp;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import ly3.c;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Page(business = Business.Conversation, type = PageHierarchy.MainPage)
/* loaded from: classes10.dex */
public class Conversation extends Frame implements AppConstants, Observer, Handler.Callback, View.OnClickListener, FrameHelperActivity.j, ConversationFacade.c, com.tencent.mobileqq.activity.home.chats.unread.b {
    static IPatchRedirector $redirector_ = null;
    private static final int AFTER_MSG_SYNC_FROM_AFTER_MSG_SYNC = 1;
    private static final int AFTER_MSG_SYNC_FROM_INIT_UI_LATER = 2;
    public static final String DEFAULT_CAMERA_JUMP_URL = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1";
    public static final String DIRECT_OPEN_ONLINE_STATUS_PANEL_PARAMS = "direct_open_online_status_panel_params";
    public static final String FROME_CONVERSATION = "conversation";
    public static final String FROM_STRING = "from";
    public static final int MSG_ACCOUNTCHANGED_UI = 1035;
    public static final int MSG_AFTER_SYNC_MSG = 1134064;
    public static final int MSG_BROWSER_BAR_HIDE = 1134042;
    public static final int MSG_BROWSER_BAR_SHOW = 1134041;
    public static final int MSG_CHANGE_LOADINGSTATE = 1134014;
    public static final int MSG_CHECK_MEDAL_GUIDE = 1054;
    public static final int MSG_CHECK_PUSH_BANNER_REPORT = 1053;
    public static final int MSG_CHECK_QQSPORT_RED_PACKET = 1061;
    public static final int MSG_CHECK_SYS_FONT = 1059;
    public static final int MSG_CLOSE_MINI_APP_ENTRY = 1134069;
    public static final int MSG_COMIC_BAR_HIDE = 1134040;
    public static final int MSG_COMIC_BAR_SHOW = 1134039;
    public static final int MSG_CONVERSATION_REMAIND_REPORT = 1070;
    public static final int MSG_DEL_MSG_HISTORY = 1017;
    public static final int MSG_DON_DISTURB_MSG = 1134065;
    public static final int MSG_GAME_BAR_HIDE = 1134050;
    public static final int MSG_GAME_BAR_SHOW = 1134049;
    public static final int MSG_GONE_CHECK_TEXTVIEW = 1060;
    public static final int MSG_HIDE_GENERAL_BANNER = 1134201;
    public static final int MSG_ILLEGALNETWORK_CLOSE = 1134012;
    public static final int MSG_ILLEGALNETWORK_CLOSE_NOT_LOADING = 1134015;
    public static final int MSG_ILLEGALNETWORK_OPEN = 1134013;
    public static final int MSG_INSTALL_UPGRADE_BAR_HIDE = 1134019;
    public static final int MSG_LOAD_UI_LATER = 1020;
    public static final int MSG_MSG_MEMROY_BAR_HIDE = 1134067;
    public static final int MSG_MSG_MEMROY_BAR_SHOW = 1134066;
    public static final int MSG_NEED_REFLESH_LIST = 1014;
    public static final int MSG_NET_WORK_STATE_CHANGE = 10003;
    public static final int MSG_NEW_UPGRADE_DIALOG = 1134020;
    public static final int MSG_ON_RECEIVE_RESPONSE = 1134068;
    public static final int MSG_PRELOAD_WEB_PROCESS = 1073;
    public static final int MSG_QZONE_REPORT = 1134062;
    public static final int MSG_REFLESH_ERROR_NETWORK_BAR = 10002;
    public static final int MSG_REFRESH_AUTH_STATE = 1077;
    public static final int MSG_REFRESH_LIST_ITEMS = 1019;
    public static final int MSG_REFRESH_RECENT = 1009;
    private static final int MSG_REGISTER_OBSERVER = 17;
    public static final int MSG_REQUEST_AMS_OLYMPIC_BANNER = 9006;
    public static final int MSG_REQUEST_TIANSHU_SPLASH = 9003;
    public static final int MSG_RESET_DRAWER = 1031;
    public static final int MSG_RESUME_DELAY_REFRESH = 1030;
    public static final int MSG_SCROLL_TOP_AND_REFRESH = 1071;
    public static final int MSG_SET_INIT_FLAG = 1025;
    public static final int MSG_SHOW_GENERAL_BANNER = 1134200;
    public static final int MSG_SHOW_NEWER_GUIDE_BANNER = 1134210;
    public static final int MSG_TIM_UPGRADE_SHOW = 1134045;
    public static final int MSG_TRIGGER_QZONE_REPORT = 1134061;
    public static final int MSG_UPDATE_PLUS_REDTOUCH = 1048;
    public static final int MSG_UPDATE_STATUS_INFO = 10001;
    public static final int MSG_VAS_AD_BANNER_CLOSE = 1080;
    public static final int MSG_VAS_AD_BANNER_SHOW_WITH_OBJ = 1081;
    public static final int MSG_WIFIPHOTO_BAR_HIDE = 1134022;
    public static final int MSG_WIFIPHOTO_BAR_SHOW = 1134021;
    public static final int MSG_WIFISECURITY_BAR = 1134063;
    private static final int REFRESH_FLAG_DELAY_INIT = 12;
    public static final int REQUEST_CODE_TROOPASSIST_TIP = 9001;
    private static final String SELF_NICKNAME_CACHE = "KEY_SELF_NICKNAME_FOR_CONVERSATION";
    public static final int TAB_CALL = 1;
    public static final String TAB_INDEX = "conversation_index";
    public static final String TAG = "Q.recent";
    public static boolean isConversationList;
    public static boolean sUnreadAnimateSwitch;
    private com.tencent.mobileqq.activity.home.chats.biz.c adPart;
    private com.tencent.mobileqq.activity.home.chats.biz.aa agentPart;
    private BannerPart bannerPart;
    private final com.tencent.mobileqq.chatlist.a cardContainerPart;
    private com.tencent.qqnt.chats.biz.main.part.c chatListPart;
    private com.tencent.mobileqq.activity.home.chats.callbcak.c conversationGetter;
    private com.tencent.mobileqq.activity.home.chats.callbcak.d conversationListListener;
    private final n dirtyStateProvider;
    private DrawerFrame.d drawerCallbacks;
    private com.tencent.mobileqq.activity.home.chats.biz.e fitsWindowsPart;
    public MqqHandler handler;
    ImageView hbEntryIcon;
    public volatile boolean isDestroy;
    public boolean isFromHongBaoShare;
    public boolean isFromThemeDIY;
    boolean isInflated;
    boolean isInited;
    boolean isLoadUIAfterMsgSync;
    boolean isLoadUILater;
    private boolean isLockLateInit;
    private boolean isRestoreStateForTitleBarUpdate;
    private Runnable loginAnimTimeOutRunnable;
    private BannerManager.a mBannerHandler;
    public BannerManager mBannerMang;
    private final s mCardObserver;
    private DragFrameLayout mDragHost;
    public FrameLayout mFLStatusInfo;
    public FrameHelperActivity mFrameHelperActivity;
    private final m mFriendListObserver;
    GestureDetector mGestureDetector;
    private v mGuildSlideConversationNotify;
    private int mImmersionBannerTxtColor;
    private final Runnable mInitBannerRunnable;
    public boolean mIsChatList;
    private boolean mIsDrawerClosed;
    public boolean mIsForeground;
    private boolean mIsImmersionAmsBannerExisted;
    private boolean mIsImmersionBannerExisted;
    private boolean mIsImmersionBannerStatusBlack;
    private final BroadcastReceiver mKernelInitCompleteListener;
    View mListViewBackground;
    View mListViewContainer;
    private a.InterfaceC9585a mListViewModelHandler;
    o mLoadingCallback;
    MqqHandler mLoadingStateHandler;
    public LoginwelcomeHelper mLoginWelHelper;
    private AtomicBoolean mNeedObserver;
    private TextView mNickName;
    private TitleAreaLeftLayout mNickNameAndStatusContainer;
    private LinearLayout mNickNameContainer;
    private String mNicknameText;
    public NtBasePartFrame mNtMainChatsFrame;
    private DragFrameLayout.b mOnDragModeChangeListener;
    private com.tencent.mobileqq.studymode.o mOnModeChangedCallBack;
    private IRefreshOperator mOperator;
    private QCircleObserver mQCircleObserver;
    private RecentPubAccHelper mRecentHelper;
    public com.tencent.mobileqq.activity.recent.l mRecentOptionBar;
    MqqHandler mRefreshHandler;
    public ConversationContainer mRootView;
    public boolean mSelectCallTab;
    public TextView mStatusInfo;
    public TextView mStatusInfoGuide;
    private ViewGroup mStatusRightContainer;
    protected View mStatusTitleDivider;
    public RelativeLayout mTitleArea;
    public bm mTitleEntranceCtrlManager;
    protected u mUICallBack;
    public int mUnReadCount;
    private boolean mUseNewLoadingTip;
    private MiniAppPullInterface miniAppPullInterface;
    private com.tencent.mobileqq.activity.home.chats.biz.i miniProgramPart;
    private final Runnable netErrorTipShowRunnable;
    private NtUnreadPart ntUnreadPart;
    private ObserverPart observerPart;
    ImageView openSession;
    RedTouch openSessionRedTouch;
    ProfileCardObserver profileCardObserver;
    private final RedpointObserver redTouchObserver;
    private r registerProxyListenerWrapper;
    private final MainResourceConfig resConfig;
    private com.tencent.mobileqq.activity.home.chats.biz.m searchPart;
    private com.tencent.mobileqq.activity.home.chats.biz.n showRealNamePart;
    public com.tencent.mobileqq.springhb.module.g springApi;
    RelativeLayout statusTitle;
    public int statusTitleHeightInNormalState;
    private SubAccountBindPart subAccountBindPart;
    private int syncToken;
    private ThirdPart thirdPart;
    private final Handler uiHandler;
    private com.tencent.mobileqq.activity.home.chats.biz.z upgradePart;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).mainPageReport("0x1011", motionEvent);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("statusTitle onTouch event :");
                sb5.append(motionEvent.toString());
                sb5.append(", mGestureDetector is null ");
                if (Conversation.this.mGestureDetector != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("Q.recent", 2, sb5.toString());
            }
            GestureDetector gestureDetector = Conversation.this.mGestureDetector;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements IRefreshOperator {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.IRefreshOperator
        public void close() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                Conversation.this.miniProgramPart.miniProgramHeader.g();
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.IRefreshOperator
        public boolean isTwoLevelShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return Conversation.this.miniProgramPart.miniProgramHeader.D();
        }

        @Override // com.tencent.mobileqq.mini.entry.IRefreshOperator
        public void maskFullScreenView(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, view, Boolean.valueOf(z16));
            } else if (!z16) {
                Conversation.this.mRootView.addView(view);
            } else {
                Conversation.this.mRootView.removeView(view);
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.IRefreshOperator
        public boolean needInterceptTouch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            RefreshState C = Conversation.this.miniProgramPart.miniProgramHeader.C();
            if (C != RefreshState.TwoLevel && C != RefreshState.RefreshReleased) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.mini.entry.IRefreshOperator
        public void openTwoLevel(Animator.AnimatorListener animatorListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) animatorListener);
                return;
            }
            RefreshState C = Conversation.this.miniProgramPart.miniProgramHeader.C();
            if (C != RefreshState.TwoLevel && C != RefreshState.ReleaseToTwoLevel) {
                Conversation.this.miniProgramPart.miniProgramHeader.j(true, animatorListener);
            }
        }

        @Override // com.tencent.mobileqq.mini.entry.IRefreshOperator
        public void switchTwoLevel(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                Conversation.this.miniProgramPart.Oa(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f182771a;

        d(String str) {
            this.f182771a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* synthetic */ void onDismiss() {
            l53.d.b(this);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(this.f182771a, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e implements BannerManager.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // com.tencent.mobileqq.banner.BannerManager.a
        public void a(com.tencent.mobileqq.banner.a aVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, i3);
                return;
            }
            QLog.i("Q.recent", 1, "BannerManager addHeaderView type=" + i3 + ",view=" + aVar.hashCode() + ",name=" + aVar.getClass().getName());
            Conversation.this.chatListPart.mChatsVM.n(new a.C9590a(aVar.f200243c, i3, true, false));
        }

        @Override // com.tencent.mobileqq.banner.BannerManager.a
        public void b(com.tencent.mobileqq.banner.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            QLog.i("Q.recent", 1, "BannerManager removeHeaderView view=" + aVar.hashCode() + ",name=" + aVar.getClass().getName());
            Conversation.this.chatListPart.mChatsVM.n(new a.C9590a(aVar.f200243c, 1, false, false));
        }

        @Override // com.tencent.mobileqq.banner.BannerManager.a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                Conversation.this.chatListPart.mChatsVB.y0(Collections.emptyList());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class f extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else {
                Conversation.this.mNtMainChatsFrame.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements DrawerFrame.d {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            Conversation.this.springApi.b();
            Conversation.this.mNtMainChatsFrame.K();
            Conversation.this.mIsDrawerClosed = false;
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            Conversation.this.subAccountBindPart.ua();
            Conversation.this.mNtMainChatsFrame.J();
            Conversation.this.mTitleEntranceCtrlManager.h();
            if (!Conversation.this.mIsDrawerClosed) {
                Conversation.this.reportForExpExposure();
            }
            Conversation.this.springApi.a();
            Conversation.this.mIsDrawerClosed = true;
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void c(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (Conversation.this.chatListPart != null) {
                Conversation.this.chatListPart.ca();
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        @TargetApi(11)
        public void e(int i3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Float.valueOf(f16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class h extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, " gestureDetector onDoubleTap");
            }
            Conversation.this.chatListPart.scrollToTop();
            return super.onDoubleTap(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class i implements a.InterfaceC9585a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // com.tencent.qqnt.chats.core.mvi.a.InterfaceC9585a
        public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull String str6) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6);
            } else {
                Conversation.this.showDialogView(str, str2, str3, str4, str5, str6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f182778d;

        j(String str) {
            this.f182778d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            QLog.i("Q.recent", 1, "customDialog click, rightUrl is : " + this.f182778d);
            com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = Conversation.this.chatListPart.mChatsVM;
            String str = this.f182778d;
            Conversation conversation = Conversation.this;
            aVar.k(str, (BaseQQAppInterface) conversation.app, conversation.mRootView.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f182780d;

        k(String str) {
            this.f182780d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            QLog.i("Q.recent", 1, "customDialog click, leftUrl is : " + this.f182780d);
            com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = Conversation.this.chatListPart.mChatsVM;
            String str = this.f182780d;
            Conversation conversation = Conversation.this;
            aVar.k(str, (BaseQQAppInterface) conversation.app, conversation.mRootView.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class l implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ba.a f182782d;

        l(ba.a aVar) {
            this.f182782d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this, (Object) aVar);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).mainPageReport("0x1010", motionEvent);
            return this.f182782d.onTouch(view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class m extends ar {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<Conversation> f182784d;

        m(Conversation conversation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
            } else {
                this.f182784d = new WeakReference<>(conversation);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetOnlineInfoByUinOrMobile(boolean z16, long j3, String str, GetOnlineInfoResp getOnlineInfoResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Long.valueOf(j3), str, getOnlineInfoResp);
                return;
            }
            Conversation conversation = this.f182784d.get();
            if (conversation != null && z16 && Utils.p(str, conversation.app.getAccount()) && !OnlineStatusToggleUtils.F()) {
                conversation.mFrameHelperActivity.rj("onGetOnlineInfoByUinOrMobile");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetStoreFace(boolean z16, HashSet<String> hashSet) {
            Conversation conversation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), hashSet);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uins:" + hashSet + ", success :" + z16);
            }
            if (z16 && (conversation = this.f182784d.get()) != null && hashSet.contains(conversation.getApp().getCurrentAccountUin())) {
                conversation.mFrameHelperActivity.mUiHandler.sendEmptyMessage(3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onSetVisibilityForNetWorkStatus(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            Conversation conversation = this.f182784d.get();
            if (conversation != null && z16) {
                conversation.refreshSelfOnlineInfoFromServer();
                conversation.mFrameHelperActivity.rj("onSetVisibilityForNetWorkStatus");
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            Conversation conversation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "onUpdateFriendInfo uin = " + str + ", isSc = " + z16);
            }
            if (z16 && (conversation = this.f182784d.get()) != null && Utils.p(str, conversation.app.getAccount())) {
                conversation.updateNickName("onUpdateFriendInfo");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16 && z17) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.recent", 2, "refresh recent, from_onupdatefriendlist");
                }
                Conversation conversation = this.f182784d.get();
                if (conversation != null) {
                    conversation.updateNickName("onUpdateFriendList");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class n implements f.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f182785a;

        /* renamed from: b, reason: collision with root package name */
        private int f182786b;

        /* renamed from: c, reason: collision with root package name */
        private int f182787c;

        /* renamed from: d, reason: collision with root package name */
        private float f182788d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f182789e;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
                return;
            }
            this.f182785a = -1;
            this.f182786b = -1;
            this.f182787c = -1;
            this.f182788d = 0.0f;
            this.f182789e = new int[2];
        }

        @Override // com.tencent.qui.quiblurview.f.b
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            RecyclerView F = Conversation.this.chatListPart.mChatsVB.F();
            float translationY = F.getTranslationY();
            if (this.f182788d != translationY) {
                this.f182788d = translationY;
                return true;
            }
            if (!F.isDirty()) {
                return false;
            }
            int childCount = F.getChildCount();
            if (this.f182786b != childCount) {
                this.f182786b = childCount;
                return true;
            }
            int computeVerticalScrollOffset = F.computeVerticalScrollOffset();
            if (this.f182785a != computeVerticalScrollOffset) {
                this.f182785a = computeVerticalScrollOffset;
                return true;
            }
            F.getLocationInWindow(this.f182789e);
            int i3 = this.f182789e[1];
            if (this.f182787c == i3) {
                return false;
            }
            this.f182787c = i3;
            return true;
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f182785a = -1;
            this.f182786b = -1;
            this.f182787c = -1;
            this.f182788d = 0.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class o implements Handler.Callback {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            com.tencent.mobileqq.managers.b.b().k(message.what, "LoadingStateCallback");
            if (message.what == 4) {
                QLog.d("Q.recent", 1, "[LoadingStateCallback.handleMessage] connect fail, loadingState=" + message.what);
                Conversation.this.sendEmptyMessageDelayedToHandler(Conversation.MSG_ILLEGALNETWORK_OPEN, 0L, false);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent", 1, "[LoadingStateCallback.handleMessage] loadingState=" + message.what);
                }
                Conversation.this.changeConversationLoadingState(true);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class p extends QCircleObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Conversation> f182792d;

        public p(Conversation conversation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
            } else {
                this.f182792d = new WeakReference<>(conversation);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.api.helper.QCircleObserver
        protected void onUpdateRedPoint(int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            Conversation conversation = this.f182792d.get();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("QCircleObserver onUpdateRedPoint: ");
            if (conversation != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Q.recent", 2, sb5.toString());
            if (conversation != null) {
                conversation.refreshEntranceRedTouch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    static class q extends RedpointObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Conversation> f182793d;

        public q(Conversation conversation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
            } else {
                this.f182793d = new WeakReference<>(conversation);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "redTouchObserver notify dataChanged");
            }
            Conversation conversation = this.f182793d.get();
            if (conversation != null) {
                conversation.updatePlusRedTouch();
                conversation.refreshEntranceRedTouch();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class r implements ConversationFacade.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ConversationFacade.c> f182794d;

        r(@android.support.annotation.NonNull ConversationFacade.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            } else {
                this.f182794d = new WeakReference<>(cVar);
            }
        }

        @Override // com.tencent.imcore.message.ConversationFacade.c
        public void onRegisterProxyDone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ConversationFacade.c cVar = this.f182794d.get();
            if (cVar != null) {
                cVar.onRegisterProxyDone();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class s extends CardObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Conversation> f182795d;

        public s(Conversation conversation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation);
            } else {
                this.f182795d = new WeakReference<>(conversation);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        public void onGetNotDisturb(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            super.onGetNotDisturb(z16, str, str2);
            Conversation conversation = this.f182795d.get();
            if (conversation != null) {
                conversation.onGetNotDisturb(z16, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetNick(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
                return;
            }
            Conversation conversation = this.f182795d.get();
            if (conversation != null) {
                conversation.onSetNick(z16, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onSetNotDisturb(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            super.onSetNotDisturb(z16, str, str2);
            Conversation conversation = this.f182795d.get();
            if (conversation != null) {
                conversation.onSetNotDisturb(z16, str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onUpdateAvatar(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
                return;
            }
            Conversation conversation = this.f182795d.get();
            if (conversation != null) {
                conversation.onUpdateAvatar(z16, str, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class t extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Conversation> f182796d;

        public t(Conversation conversation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this, (Object) conversation);
            } else {
                this.f182796d = new WeakReference<>(conversation);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            Conversation conversation = this.f182796d.get();
            if (conversation != null) {
                conversation.onGetProfileCard(z16, obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class u implements Handler.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f182798d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    Conversation conversation = Conversation.this;
                    conversation.onClick(conversation.openSession);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
            } else {
                this.f182798d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("refresh_net_status_after_receiving_response_9095", true);
            }
        }

        private boolean d(Message message) {
            if (message.what != 1134022 && !Conversation.this.app.isLogin()) {
                return true;
            }
            return i(message);
        }

        private boolean e(Message message) {
            int i3 = message.what;
            if (i3 != 1059) {
                if (i3 != 1060) {
                    if (i3 != 1070) {
                        if (i3 != 1071) {
                            if (i3 == 1134064) {
                                Conversation.this.doAfterMsgSync(1);
                                return true;
                            }
                            return false;
                        }
                        j(message.arg1);
                        return true;
                    }
                    Conversation.this.handler.removeMessages(1070);
                    ((IRedTouchManager) Conversation.this.app.getRuntimeService(IRedTouchManager.class, "")).conversationRemainReport();
                    return true;
                }
                Conversation.this.findViewById(R.id.k4e).setVisibility(8);
                return true;
            }
            VasShieldFont.l((TextView) Conversation.this.findViewById(R.id.k4e));
            return true;
        }

        private boolean f(Message message) {
            int i3 = message.what;
            if (i3 == 1020) {
                Conversation.this.initUiLater();
                return true;
            }
            if (i3 == 1025) {
                Conversation.this.setFirstDrawComplete();
                return true;
            }
            if (i3 == 1030) {
                Conversation.this.resumeDelayRefresh();
                return true;
            }
            if (i3 != 1048) {
                switch (i3) {
                    case 10001:
                    case 10002:
                    case 10003:
                        Conversation.this.refreshNetStatus(message, true);
                        return true;
                    default:
                        switch (i3) {
                            case Conversation.MSG_ILLEGALNETWORK_CLOSE /* 1134012 */:
                                QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE");
                                Conversation.this.refreshNetStatus(message, true);
                                return true;
                            case Conversation.MSG_ILLEGALNETWORK_OPEN /* 1134013 */:
                                QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_OPEN");
                                Conversation.this.refreshNetStatus(message, true);
                                return true;
                            case Conversation.MSG_CHANGE_LOADINGSTATE /* 1134014 */:
                                Conversation.this.refreshNetStatus(null, true);
                                return true;
                            case Conversation.MSG_ILLEGALNETWORK_CLOSE_NOT_LOADING /* 1134015 */:
                                QLog.i("Q.recent", 2, "MSG_ILLEGALNETWORK_CLOSE_NOT_LOADING");
                                Conversation.this.refreshNetStatus(message, false);
                                return true;
                            default:
                                switch (i3) {
                                    case Conversation.MSG_ON_RECEIVE_RESPONSE /* 1134068 */:
                                        QLog.i("Q.recent", 2, "MSG_ON_RECEIVE_RESPONSE");
                                        if (this.f182798d) {
                                            Conversation.this.refreshNetStatus(message, false);
                                            return true;
                                        }
                                        Conversation.this.mLoadingStateHandler.removeMessages(4);
                                        return true;
                                    case Conversation.MSG_CLOSE_MINI_APP_ENTRY /* 1134069 */:
                                        if (Conversation.this.miniAppPullInterface == null) {
                                            return true;
                                        }
                                        Conversation.this.miniAppPullInterface.hideMiniAppEntry(-1);
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
            }
            k(message);
            return true;
        }

        private boolean i(Message message) {
            int i3 = message.what;
            if (i3 != 1035) {
                if (i3 != 1080) {
                    if (i3 != 1081) {
                        return false;
                    }
                    if (Conversation.this.isShowHighImmersionBanner()) {
                        QLog.d("Q.recent", 1, "MSG_QBOSS_AD_BANNER_SHOW_WITH_OBJ return,isShowingBannerOrBrushing = true");
                        return true;
                    }
                    m(message);
                    return true;
                }
                l();
                return true;
            }
            Conversation.this.setThemeDiyBgConversation();
            return true;
        }

        private void j(int i3) {
            if (GuildSlideCoordinator.s()) {
                com.tencent.mobileqq.activity.home.chats.biz.guild.a.a(GuildSubscribeChannelReturnType.CONVERSATION_TAB);
                GuildSlideCoordinator.r();
            } else if (i3 > 0) {
                ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(a.n.f355021a);
            } else {
                ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(a.o.f355022a);
                Conversation.this.miniProgramPart.Ma();
            }
        }

        private void k(Message message) {
            com.tencent.mobileqq.activity.recent.l lVar;
            Conversation conversation = Conversation.this;
            if (conversation.openSessionRedTouch != null && (lVar = conversation.mRecentOptionBar) != null) {
                boolean D = lVar.D();
                QLog.i("Q.recent", 1, "handleMessageForUpdatePlusRedTouch: needsExposeRedTouchUpward = " + D);
                if (D) {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                    redTypeInfo.red_type.set(0);
                    Conversation.this.openSessionRedTouch.parseRedTouch(redTypeInfo);
                    return;
                }
                Conversation.this.openSessionRedTouch.clearRedTouch();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n() {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "handleVasADBannerClose,statusTitle.h = " + Conversation.this.statusTitle.getHeight(), "statusTitleHeightInNormalState=", Integer.valueOf(Conversation.this.statusTitleHeightInNormalState));
            }
            int height = Conversation.this.statusTitle.getHeight();
            Conversation conversation = Conversation.this;
            if (conversation.statusTitleHeightInNormalState > 0) {
                int height2 = conversation.statusTitle.getHeight();
                int i3 = Conversation.this.statusTitleHeightInNormalState;
                if (height2 > i3) {
                    height = i3;
                }
            }
            if (height > 0) {
                ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(new a.r(height));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            View ki5 = Conversation.this.mFrameHelperActivity.ki();
            if (ki5 != null) {
                ki5.performLongClick();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean p(View view) {
            View ki5 = Conversation.this.mFrameHelperActivity.ki();
            if (ki5 != null) {
                return ki5.performLongClick();
            }
            return false;
        }

        private void q(TextView textView, TextView textView2, View view) {
            Drawable drawable;
            if (textView != null) {
                Conversation.this.mNickName.setTag(R.id.uwi, new WeakReference(textView));
                textView.setText(Conversation.this.mNickName.getText());
            }
            if (textView2 != null) {
                Conversation.this.mStatusInfo.setTag(R.id.uwi, new WeakReference(textView2));
                int f16 = BaseAIOUtils.f(10.0f, Conversation.this.getResources());
                BaseAIOUtils.h(textView2, f16, f16, f16, f16);
                textView2.setText(Conversation.this.mStatusInfo.getText());
                Drawable[] compoundDrawables = Conversation.this.mStatusInfo.getCompoundDrawables();
                if (compoundDrawables.length == 4) {
                    textView2.setCompoundDrawablePadding(Conversation.this.mStatusInfo.getCompoundDrawablePadding());
                    Drawable drawable2 = compoundDrawables[2];
                    if (drawable2 != null && (drawable2 instanceof SkinnableBitmapDrawable)) {
                        drawable = new BitmapDrawable(Conversation.this.getResources(), ((SkinnableBitmapDrawable) compoundDrawables[2]).getBitmap());
                        drawable.setBounds(compoundDrawables[2].getBounds());
                        drawable.setColorFilter(textView2.getCurrentTextColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        drawable = null;
                    }
                    Drawable drawable3 = compoundDrawables[0];
                    Drawable drawable4 = compoundDrawables[1];
                    if (drawable == null) {
                        drawable = compoundDrawables[2];
                    }
                    textView2.setCompoundDrawables(drawable3, drawable4, drawable, compoundDrawables[3]);
                }
                textView2.setOnTouchListener(new ba.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.home.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Conversation.u.this.o(view2);
                    }
                }));
                textView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.activity.home.s
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        boolean p16;
                        p16 = Conversation.u.this.p(view2);
                        return p16;
                    }
                });
            }
            if (view != null) {
                Conversation.this.mFLStatusInfo.setTag(R.id.uwi, new WeakReference(view));
            }
            TitleAreaLeftLayout.INSTANCE.b(textView, view);
        }

        private void r(View view, int i3) {
            Drawable drawable;
            if (view != null) {
                view.setOnClickListener(new a());
            }
            if (!(view instanceof ImageView)) {
                return;
            }
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            if (imageView.getDrawable() instanceof SkinnableBitmapDrawable) {
                drawable = new BitmapDrawable(Conversation.this.getResources(), ((SkinnableBitmapDrawable) imageView.getDrawable()).getBitmap());
            } else {
                drawable = imageView.getDrawable();
            }
            drawable.setBounds(imageView.getDrawable().getBounds());
            drawable.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
            imageView.setImageDrawable(drawable);
        }

        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                Conversation.this.mIsImmersionAmsBannerExisted = false;
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        public void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                Conversation.this.mIsImmersionAmsBannerExisted = true;
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            try {
                if (d(message) || f(message) || Conversation.this.mNtMainChatsFrame.v(message)) {
                    return true;
                }
                return e(message);
            } catch (Throwable th5) {
                QLog.e("Q.recent", 1, "UICallBack[handleMessage] err:", th5);
                return false;
            }
        }

        public void l() {
            ConversationTitleBtnCtrl c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "handleVasADBannerClose");
            }
            bm bmVar = Conversation.this.mTitleEntranceCtrlManager;
            if (bmVar != null && (c16 = bmVar.c(2)) != null) {
                c16.l();
                Conversation.this.mTitleEntranceCtrlManager.o(2);
            }
            View findViewById = Conversation.this.statusTitle.findViewById(R.id.f116406yn);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                Conversation.this.statusTitle.removeView(findViewById);
            }
            Conversation.this.mIsImmersionBannerExisted = false;
            Conversation.this.mImmersionBannerTxtColor = 0;
            Conversation.this.mIsImmersionBannerStatusBlack = false;
            Conversation.this.recoverOpenSessionAndQQCircleColor();
            Conversation.this.searchPart.sa(false);
            if (Conversation.this.statusTitle.findViewById(R.id.f87554uo) != null && findViewById == null) {
                QLog.d("Q.recent", 2, "handleVasADBannerClose, skip setting padding for spring banner");
            } else {
                Conversation.this.statusTitle.post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        Conversation.u.this.n();
                    }
                });
            }
        }

        public void m(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) message);
                return;
            }
            Object obj = message.obj;
            if (obj != null && (obj instanceof View[])) {
                Conversation conversation = Conversation.this;
                if (conversation.statusTitleHeightInNormalState < 0) {
                    conversation.statusTitleHeightInNormalState = conversation.statusTitle.getHeight();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent", 2, "handleVasADBannerShowWithObj,statusTitle.h = " + Conversation.this.statusTitle.getHeight() + "\uff0cstatusTitleHeightInNormalState = " + Conversation.this.statusTitleHeightInNormalState);
                }
                View[] viewArr = (View[]) message.obj;
                if (viewArr.length == 6) {
                    int i3 = 0;
                    View view = viewArr[0];
                    TextView textView = (TextView) viewArr[1];
                    TextView textView2 = (TextView) viewArr[2];
                    View view2 = viewArr[3];
                    View view3 = viewArr[4];
                    View view4 = viewArr[5];
                    if (view != null && view.getParent() == null) {
                        View findViewById = Conversation.this.statusTitle.findViewById(R.id.f116406yn);
                        if (findViewById != null) {
                            Conversation.this.statusTitle.removeView(findViewById);
                        }
                        if (Conversation.this.hasOpenMiniAppDesktop()) {
                            view.setVisibility(8);
                        }
                        bm bmVar = Conversation.this.mTitleEntranceCtrlManager;
                        if (bmVar != null) {
                            ConversationTitleBtnCtrl a16 = bmVar.a(2);
                            a16.g(view);
                            a16.x(true);
                        }
                        Conversation.this.statusTitle.addView(view);
                        view.requestLayout();
                        Conversation.this.mIsImmersionBannerExisted = true;
                        q(textView, textView2, view3);
                        Conversation conversation2 = Conversation.this;
                        if (textView != null) {
                            i3 = textView.getCurrentTextColor();
                        }
                        conversation2.mImmersionBannerTxtColor = i3;
                        r(view2, Conversation.this.mImmersionBannerTxtColor);
                        Conversation.this.mIsImmersionBannerStatusBlack = h15.a.a(view4);
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.recent", 2, "handleVasADBannerShowWithObj,mIsImmersionBannerStatusBlack\uff1a" + Conversation.this.mIsImmersionBannerStatusBlack);
                        }
                        Conversation conversation3 = Conversation.this;
                        conversation3.setOpenSessionAndQQCircleColor(conversation3.mImmersionBannerTxtColor);
                        ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(new a.r(view.getLayoutParams().height));
                        ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(a.o.f355022a);
                        Conversation.this.searchPart.sa(true);
                    }
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68415);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 67)) {
            redirector.redirect((short) 67);
        } else {
            isConversationList = true;
            sUnreadAnimateSwitch = true;
        }
    }

    public Conversation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSelectCallTab = false;
        this.isFromHongBaoShare = false;
        this.isFromThemeDIY = false;
        this.isRestoreStateForTitleBarUpdate = false;
        this.mBannerHandler = new e();
        this.mIsForeground = false;
        this.isDestroy = false;
        this.isInited = false;
        this.isLoadUILater = false;
        this.isInflated = false;
        this.isLoadUIAfterMsgSync = false;
        this.mTitleEntranceCtrlManager = null;
        this.springApi = new com.tencent.mobileqq.springhb.entry.worker.d(this);
        this.mIsImmersionBannerExisted = false;
        this.mIsImmersionAmsBannerExisted = false;
        this.mImmersionBannerTxtColor = 0;
        this.mIsImmersionBannerStatusBlack = false;
        this.mIsDrawerClosed = true;
        this.resConfig = MainResourceConfig.g();
        this.statusTitleHeightInNormalState = -1;
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.netErrorTipShowRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Conversation.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!ConvNetState.b().c()) {
                    QLog.i("Q.recent", 1, "netErrorTipShowRunnable ignore showing banner, net is recovered");
                    return;
                }
                QLog.i("Q.recent", 1, "[netErrorTipShowRunnable] show net error banner");
                ConvNetState.b().f(true);
                BannerManager bannerManager = Conversation.this.mBannerMang;
                if (bannerManager != null) {
                    bannerManager.O(NetStateBannerProcessor.f185236d, 2, null);
                }
            }
        };
        this.mInitBannerRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.home.n
            @Override // java.lang.Runnable
            public final void run() {
                Conversation.this.lambda$new$0();
            }
        };
        this.conversationGetter = new com.tencent.mobileqq.activity.home.chats.callbcak.c(this);
        this.chatListPart = new com.tencent.qqnt.chats.biz.main.part.c();
        this.ntUnreadPart = new NtUnreadPart(this);
        this.showRealNamePart = new com.tencent.mobileqq.activity.home.chats.biz.n(this.conversationGetter);
        this.subAccountBindPart = new SubAccountBindPart(this.conversationGetter);
        this.fitsWindowsPart = new com.tencent.mobileqq.activity.home.chats.biz.e(this.conversationGetter);
        this.searchPart = new com.tencent.mobileqq.activity.home.chats.biz.m(this.conversationGetter, this.chatListPart);
        this.upgradePart = new com.tencent.mobileqq.activity.home.chats.biz.z(this.conversationGetter);
        this.thirdPart = new ThirdPart(this.conversationGetter);
        this.bannerPart = new BannerPart(this.conversationGetter);
        this.adPart = new com.tencent.mobileqq.activity.home.chats.biz.c(this.conversationGetter);
        this.observerPart = new ObserverPart(this.conversationGetter);
        this.agentPart = new com.tencent.mobileqq.activity.home.chats.biz.aa(this.conversationGetter);
        com.tencent.mobileqq.chatlist.a createMainChatsCardContainerPart = ((IMainChatsCardContainerApi) QRoute.api(IMainChatsCardContainerApi.class)).createMainChatsCardContainerPart(this.chatListPart, getParentScrollHelperForCardContainer());
        this.cardContainerPart = createMainChatsCardContainerPart;
        this.miniProgramPart = new com.tencent.mobileqq.activity.home.chats.biz.i(this.conversationGetter);
        NtBasePartFrame createFrame = ((IChatApi) QRoute.api(IChatApi.class)).createFrame(null, this.chatListPart, this.miniProgramPart, Arrays.asList(this.ntUnreadPart, this.showRealNamePart, this.subAccountBindPart, this.fitsWindowsPart, new NTMsgMigrationPart(), new com.tencent.mobileqq.activity.home.chats.biz.x(this.conversationGetter), this.upgradePart, this.thirdPart, this.bannerPart, this.adPart, this.agentPart, this.observerPart, ((IAIServiceApi) QRoute.api(IAIServiceApi.class)).getChatsAIServicePart(), new com.tencent.mobileqq.activity.home.parts.c(this.conversationGetter, this.chatListPart)), Arrays.asList(this.searchPart, createMainChatsCardContainerPart));
        this.mNtMainChatsFrame = createFrame;
        this.conversationListListener = new com.tencent.mobileqq.activity.home.chats.callbcak.d(this, createFrame);
        this.registerProxyListenerWrapper = new r(this);
        this.mUICallBack = new u();
        this.syncToken = -1;
        this.mListViewModelHandler = new i();
        this.mLoadingCallback = new o();
        this.mLoadingStateHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.mLoadingCallback);
        this.redTouchObserver = new q(this);
        this.mQCircleObserver = new p(this);
        this.mNeedObserver = new AtomicBoolean(false);
        this.mFriendListObserver = new m(this);
        this.mCardObserver = new s(this);
        this.profileCardObserver = new t(this);
        this.mKernelInitCompleteListener = new f();
        this.mGestureDetector = new GestureDetector(BaseApplication.getContext(), new h());
        this.dirtyStateProvider = new n();
    }

    private void addModeChangedCallback() {
        ((com.tencent.mobileqq.studymode.l) this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).d(this.mOnModeChangedCallBack);
    }

    private void addObservers(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "addObservers" + z16 + this.mNeedObserver);
        }
        synchronized (this.mNeedObserver) {
            if (!z16) {
                this.mNeedObserver.set(true);
                this.mRefreshHandler.sendEmptyMessageDelayed(17, 200L);
                return;
            }
            if (!this.mNeedObserver.get()) {
                return;
            }
            getApp().setHandler(getClass(), this.handler);
            getApp().addObserver(this.mCardObserver, true);
            getApp().addObserver(this.profileCardObserver, true);
            this.mNtMainChatsFrame.a(this.app);
            if (this.app.isLogin()) {
                getApp().addObserver(this.mFriendListObserver, true);
                this.springApi.onCreate();
                getApp().getMessageFacade().addObserver(this);
                com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) this.app.getManager(QQManagerFactory.RECENT_CALL_FACADE);
                if (fVar != null) {
                    fVar.addObserver(this);
                }
                getApp().getGAudioHandler().a();
                ba.clearSpeakerStatus(this.app.getApplication().getApplicationContext());
                getApp().addObserver(this.redTouchObserver);
                getApp().addObserver(this.mQCircleObserver);
                ((IQCircleChatMsgNtApi) QRoute.api(IQCircleChatMsgNtApi.class)).addRecentContactListenerAndFetch();
                LoginwelcomeHelper loginwelcomeHelper = this.mLoginWelHelper;
                if (loginwelcomeHelper != null) {
                    loginwelcomeHelper.f();
                }
                ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).initChannelUpdateManager(this.app);
                ((IAddTroopAccountIdentityApi) QRoute.api(IAddTroopAccountIdentityApi.class)).initRobotConfig(this.app);
            }
            if (this.mFrameHelperActivity != null && !OnlineStatusToggleUtils.F()) {
                this.mFrameHelperActivity.rj("AfterAddObservers");
            }
        }
    }

    private void checkBackgroundInit() {
        QBaseActivity activity = getActivity();
        if (activity == null) {
            QLog.d("Q.recent", 1, "checkBackgroundInit, activity is null");
            return;
        }
        SkinActivityModule skinActivityModule = (SkinActivityModule) activity.getModule(SkinActivityModule.class);
        if (skinActivityModule == null) {
            QLog.d("Q.recent", 1, "checkBackgroundInit, module is null");
            return;
        }
        SkinnableActivityProcesser skinProcessor = skinActivityModule.getSkinProcessor();
        if (skinProcessor == null) {
            QLog.d("Q.recent", 1, "checkBackgroundInit, processor is null");
        } else {
            SimpleModeHelper.c(this.mRootView, skinProcessor, this);
        }
    }

    private void doAfterDrawComplete() {
        if (SetSplash.g()) {
            View contentView = getContentView();
            if (contentView == null) {
                return;
            }
            contentView.post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.8
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.activity.home.Conversation$8$a */
                /* loaded from: classes10.dex */
                class a implements SetSplash.d {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.startup.step.SetSplash.d
                    public void a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            Conversation.this.realOnDrawComplete();
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        SetSplash.p(Conversation.this.findViewById(R.id.f116406yn), new a());
                    }
                }
            });
            return;
        }
        realOnDrawComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doAfterMsgSync(int i3) {
        QLog.d("Q.recent", 1, "doAfterMsgSync from=", Integer.valueOf(i3), " isInRealActionLoginB=", Boolean.valueOf(getApp().mAutomator.isInRealActionLoginB()), " isLoadUIAfterMsgSync=", Boolean.valueOf(this.isLoadUIAfterMsgSync));
        if (1 == i3) {
            if (this.mFrameHelperActivity != null) {
                ((ITabFrameController) QRoute.api(ITabFrameController.class)).clearUselessBackground(this.mFrameHelperActivity.mRootView);
            }
            if (getActivity() != null) {
                dc.D(getActivity().getApplicationContext());
            }
            bm bmVar = this.mTitleEntranceCtrlManager;
            if (bmVar != null) {
                bmVar.e();
            }
        }
        if (!this.isLoadUIAfterMsgSync && !this.isDestroy) {
            this.isLoadUIAfterMsgSync = true;
            sendEmptyMessageDelayedToHandler(1077, 1200L, true);
            this.adPart.B9(i3);
            this.agentPart.B9(i3);
            this.thirdPart.sa(i3, this.isLoadUIAfterMsgSync, this.isDestroy);
            this.subAccountBindPart.B9(i3);
            BannerManager bannerManager = this.mBannerMang;
            if (bannerManager != null) {
                bannerManager.D(VasADBannerProcessor.f185279h, 2001);
            }
            FrameHelperActivity frameHelperActivity = this.mFrameHelperActivity;
            if (frameHelperActivity != null) {
                frameHelperActivity.mUiHandler.sendEmptyMessage(18);
            }
            refreshSelfOnlineInfoFromServer();
            com.tencent.mobileqq.vas.j.a();
            updateLoadingStateToEndState();
        }
    }

    private int getIconAlphaByTheme() {
        if (!SimpleModeHelper.B() && ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
            return 153;
        }
        return 255;
    }

    private int getIconColorFilterByTheme() {
        return getActivity().getColor(R.color.qui_common_icon_nav_primary);
    }

    @NotNull
    private View.OnClickListener getNickNameAreaOnClickListener() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.home.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Conversation.this.lambda$getNickNameAreaOnClickListener$8(view);
            }
        };
    }

    @NotNull
    private View.OnLongClickListener getNickNameAreaOnLongClickListener() {
        return new View.OnLongClickListener() { // from class: com.tencent.mobileqq.activity.home.k
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean lambda$getNickNameAreaOnLongClickListener$7;
                lambda$getNickNameAreaOnLongClickListener$7 = Conversation.this.lambda$getNickNameAreaOnLongClickListener$7(view);
                return lambda$getNickNameAreaOnLongClickListener$7;
            }
        };
    }

    private String getNicknameCacheKey() {
        return "KEY_SELF_NICKNAME_FOR_CONVERSATION-" + this.app.getCurrentAccountUin();
    }

    private String getNicknameFromCache() {
        return QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeString(getNicknameCacheKey(), null);
    }

    private com.tencent.mobileqq.cardcontainer.k getParentScrollHelperForCardContainer() {
        return new com.tencent.mobileqq.cardcontainer.k() { // from class: com.tencent.mobileqq.activity.home.b
            @Override // com.tencent.mobileqq.cardcontainer.k
            public final void requestDisallowInterceptTouchEvent(boolean z16) {
                Conversation.this.lambda$getParentScrollHelperForCardContainer$9(z16);
            }
        };
    }

    private View.OnClickListener getSpaceAreaOnClickListener(View.OnClickListener onClickListener) {
        if (this.mNickNameContainer.getWidth() > this.mFLStatusInfo.getWidth()) {
            return new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.home.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Conversation.this.lambda$getSpaceAreaOnClickListener$6(view);
                }
            };
        }
        return onClickListener;
    }

    private View.OnLongClickListener getSpaceAreaOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (this.mNickNameContainer.getWidth() > this.mFLStatusInfo.getWidth()) {
            return new View.OnLongClickListener() { // from class: com.tencent.mobileqq.activity.home.h
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean lambda$getSpaceAreaOnLongClickListener$5;
                    lambda$getSpaceAreaOnLongClickListener$5 = Conversation.this.lambda$getSpaceAreaOnLongClickListener$5(view);
                    return lambda$getSpaceAreaOnLongClickListener$5;
                }
            };
        }
        return onLongClickListener;
    }

    private Handler getUIHandler() {
        return this.uiHandler;
    }

    private void handleIntent(Intent intent) {
        NtBasePartFrame ntBasePartFrame = this.mNtMainChatsFrame;
        if (ntBasePartFrame != null) {
            ntBasePartFrame.u(intent);
        }
    }

    private void handleSuperThemeBg() {
        View contentView;
        this.mListViewBackground.setBackground(this.resConfig.k(getActivity()));
        if (!ThemeUtil.useNativeThemeVideoPlayer() || (contentView = getContentView()) == null) {
            return;
        }
        contentView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.home.m
            @Override // java.lang.Runnable
            public final void run() {
                Conversation.this.lambda$handleSuperThemeBg$3();
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasOpenMiniAppDesktop() {
        return false;
    }

    private void hideNetStateBanner() {
        removeNetErrorCallback();
        BannerManager bannerManager = this.mBannerMang;
        if (bannerManager != null) {
            bannerManager.O(NetStateBannerProcessor.f185236d, 0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initBanner, reason: merged with bridge method [inline-methods] */
    public void lambda$new$0() {
        QBaseActivity activity;
        if (this.isDestroy || this.mBannerMang != null || (activity = getActivity()) == null) {
            return;
        }
        BannerManager l3 = BannerManager.l();
        this.mBannerMang = l3;
        l3.b(activity, this.mBannerHandler);
        this.mBannerMang.D(PushBannerProcessor.f185251i, 2005);
        o43.a aVar = com.tencent.mobileqq.vassplash.common.c.f312380h;
        if (aVar != null && aVar.f() && !TextUtils.isEmpty(com.tencent.mobileqq.vassplash.common.c.h(getApp().getCurrentUin()))) {
            this.mBannerMang.D(VasADBannerProcessor.f185279h, 3000);
        }
        QLog.d("Q.recent", 1, "BannerManager init, to check show Banner");
        FontSizeChangeBannerHelper fontSizeChangeBannerHelper = FontSizeChangeBannerHelper.f210540a;
        fontSizeChangeBannerHelper.c();
        fontSizeChangeBannerHelper.a(activity);
    }

    private void initDrawerFrame() {
        if (!this.isDestroy && this.mFrameHelperActivity != null) {
            setDrawerCallback();
        } else if (QLog.isColorLevel()) {
            QLog.e("Q.recent", 2, "initDrawerFrame return,isDestroy || mFrameHelperActivity is null");
        }
    }

    private void initListeners() {
        this.chatListPart.la(this.conversationListListener);
        FrameHelperActivity frameHelperActivity = this.mFrameHelperActivity;
        if (frameHelperActivity == null) {
            return;
        }
        frameHelperActivity.ij(this);
    }

    private void initMiniAppView() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mOperator = new c();
        this.miniAppPullInterface = ((IMiniAppService) QRoute.api(IMiniAppService.class)).createMiniAppEntryManager(this.mOperator, this.miniProgramPart.Da().B());
        this.miniProgramPart.ua(new i.b() { // from class: com.tencent.mobileqq.activity.home.Conversation.13
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
                }
            }

            @Override // com.tencent.mobileqq.activity.home.chats.biz.i.b
            public void a(@NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) refreshState, (Object) refreshState2);
                    return;
                }
                IRefreshStatusListener miniRefreshStatusListener = Conversation.this.miniAppPullInterface.getMiniRefreshStatusListener();
                if (miniRefreshStatusListener == null) {
                    return;
                }
                if (refreshState == RefreshState.PullDownToRefresh) {
                    FrameHelperActivity.gj(false, "Q.recent");
                    FrameHelperActivity.hj(false);
                    return;
                }
                if (refreshState == RefreshState.ReleaseToTwoLevel) {
                    miniRefreshStatusListener.onReleaseToTwoLevel();
                    return;
                }
                if (refreshState == RefreshState.ReleaseToRefresh) {
                    miniRefreshStatusListener.onReleaseToRefresh();
                    return;
                }
                if (refreshState == RefreshState.TwoLevel) {
                    miniRefreshStatusListener.onTwoLevelRelease();
                } else if (refreshState == RefreshState.None) {
                    FrameHelperActivity.gj(true, "Q.recent");
                    FrameHelperActivity.hj(true);
                    Conversation.this.refreshBlurView();
                }
            }

            @Override // com.tencent.mobileqq.activity.home.chats.biz.i.b
            public void onProgress(float f16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
                    return;
                }
                if (Conversation.this.mIsImmersionAmsBannerExisted) {
                    if (cooperation.ad.i.f390099a.b().get() && f16 > ((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getTabAdBannerPullProcess()) {
                        SimpleEventBus.getInstance().dispatchEvent(new MiniAppAdOpenLandingEvent());
                        QLog.d("Q.recent", 1, "handle amsAdBanner click");
                        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.13.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass13.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else if (Conversation.this.miniAppPullInterface != null) {
                                    Conversation.this.miniAppPullInterface.hideMiniAppEntry(-1);
                                }
                            }
                        }, 1000L);
                        return;
                    }
                    return;
                }
                if (Conversation.this.miniAppPullInterface != null) {
                    Conversation.this.miniAppPullInterface.onHeaderShowProgress(f16);
                }
            }
        });
        this.miniProgramPart.Ia(new com.tencent.mobileqq.activity.home.chats.callbcak.e(this, this.mNtMainChatsFrame));
        DrawerFrame drawerFrame = this.mFrameHelperActivity.E;
        if (drawerFrame != null) {
            this.miniAppPullInterface.initLater(drawerFrame);
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).asyncMiniAppDesktopInitReport(Long.valueOf(currentTimeMillis));
    }

    private void initMsgRefreshTipUI() {
        this.mUseNewLoadingTip = true;
        MsgRefreshTipMgr.f().p(this.mUseNewLoadingTip);
        MsgRefreshTipMgr.MsgRefreshTipView msgRefreshTipView = (MsgRefreshTipMgr.MsgRefreshTipView) this.mRootView.findViewById(R.id.zgi);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.loading);
        if (this.mUseNewLoadingTip) {
            MsgRefreshTipMgr.f().o(msgRefreshTipView);
            MsgRefreshTipMgr.f().i();
            imageView.setVisibility(8);
            msgRefreshTipView.setVisibility(0);
            MsgRefreshTipMgr.f().q();
            MsgRefreshTipMgr.f().n(new MsgRefreshTipMgr.b() { // from class: com.tencent.mobileqq.activity.home.l
                @Override // com.tencent.mobileqq.managers.MsgRefreshTipMgr.b
                public final void a() {
                    Conversation.this.lambda$initMsgRefreshTipUI$10();
                }
            });
            return;
        }
        imageView.setVisibility(0);
        msgRefreshTipView.setVisibility(8);
    }

    private void initNickname(String str) {
        String nicknameFromCache = getNicknameFromCache();
        if (!TextUtils.isEmpty(nicknameFromCache)) {
            lambda$updateNickName$14(str, nicknameFromCache);
        } else {
            updateNickName(str);
        }
    }

    private void initOnlineStatusContent() {
        if (OnlineStatusToggleUtils.D("online_status_scroll_lyrics")) {
            this.mStatusInfo.setVisibility(8);
            TextView textView = (TextView) this.mRootView.findViewById(R.id.f1056466k);
            this.mStatusInfo = textView;
            textView.setVisibility(0);
        }
        TextView textView2 = this.mStatusInfo;
        if (textView2 instanceof OnlineStatusLyricView) {
            ((OnlineStatusLyricView) textView2).setTextAlign(Paint.Align.LEFT);
        }
        int f16 = BaseAIOUtils.f(10.0f, getResources());
        setStatusInfoClick(f16, this.mStatusInfo);
        setStatusInfoClick(f16, this.mStatusInfoGuide);
        setStatusInfoClick(f16, this.mFLStatusInfo);
    }

    private void initUI() {
        this.mDragHost = (DragFrameLayout) getActivity().findViewById(R.id.b9o);
        this.mOnDragModeChangeListener = new com.tencent.mobileqq.activity.home.chats.callbcak.b(this.conversationGetter);
        this.mIsChatList = true;
        getApp().isInCallList = false;
        ConversationContainer conversationContainer = (ConversationContainer) findViewById(R.id.root);
        this.mRootView = conversationContainer;
        this.mTitleArea = (RelativeLayout) LayoutInflater.from(this.mRootView.getContext()).inflate(R.layout.fq9, (ViewGroup) conversationContainer.findViewById(R.id.yw9).findViewById(R.id.f100135ro), true).findViewById(R.id.b_y);
        RelativeLayout relativeLayout = (RelativeLayout) this.mRootView.findViewById(R.id.j2j);
        this.statusTitle = relativeLayout;
        this.mStatusTitleDivider = SimpleModeHelper.x(relativeLayout);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.f10543660);
        this.mNickName = textView;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.mNickNameContainer = (LinearLayout) this.mRootView.findViewById(R.id.f9w);
        this.mNickNameAndStatusContainer = (TitleAreaLeftLayout) this.mRootView.findViewById(R.id.zrb);
        this.mStatusRightContainer = (ViewGroup) this.mRootView.findViewById(R.id.u9_);
        this.mGuildSlideConversationNotify = new v();
        com.tencent.mobileqq.activity.home.chats.biz.guild.b bVar = (com.tencent.mobileqq.activity.home.chats.biz.guild.b) this.mNtMainChatsFrame.t(com.tencent.mobileqq.activity.home.chats.biz.guild.b.class);
        GuildSlideCoordinator.x(bVar);
        QLog.i("Q.recent", 1, "initUI viewModel_Id=" + System.identityHashCode(bVar));
        bVar.M1().observe(this.mNtMainChatsFrame.getLifecycleOwner(), this.mGuildSlideConversationNotify);
        GuildSlideCoordinator.k(this.mGuildSlideConversationNotify);
        GuildSlideCoordinator.l(this.mGuildSlideConversationNotify);
        GuildSlideCoordinator.k(this.searchPart);
        this.mStatusInfo = (TextView) this.mRootView.findViewById(R.id.f1056266i);
        this.mFLStatusInfo = (FrameLayout) this.mRootView.findViewById(R.id.v7e);
        this.mStatusInfoGuide = (TextView) this.mRootView.findViewById(R.id.f1056366j);
        initMsgRefreshTipUI();
        setStatusInfoGuideBg();
        initOnlineStatusContent();
        IphoneTitleBarActivity.setLayerType(this.mTitleArea);
        this.mListViewContainer = this.mRootView.findViewById(R.id.f166072ec3);
        this.mListViewBackground = this.mRootView.findViewById(R.id.f166071yk3);
        QBaseActivity activity = getActivity();
        ThreadManagerV2.excute(this.mInitBannerRunnable, 240, null, true);
        if (!com.tencent.mobileqq.util.af.i()) {
            this.mFrameHelperActivity.sj();
            this.mFrameHelperActivity.mUiHandler.sendEmptyMessageDelayed(1, 200L);
        }
        this.mLoginWelHelper = new LoginwelcomeHelper(this, this.mDragHost);
        this.openSession = (ImageView) findViewById(R.id.f164917ba3);
        this.openSession.setImageDrawable(cn.f(ResourcesCompat.getDrawable(getResources(), R.drawable.qui_add_icon_navigation_01_selector, null)));
        this.openSessionRedTouch = new RedTouch(getActivity(), this.openSession).setGravity(53).applyTo();
        IphoneTitleBarActivity.setLayerType(this.openSession);
        this.hbEntryIcon = (ImageView) findViewById(R.id.u9b);
        initNickname("initUI");
        SimpleModeHelper.n(this.mNickName);
        checkBackgroundInit();
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        NtBasePartFrame ntBasePartFrame = this.mNtMainChatsFrame;
        ConversationContainer conversationContainer2 = this.mRootView;
        ntBasePartFrame.I(layoutInflater, conversationContainer2, conversationContainer2, null);
        handleSuperThemeBg();
        refreshStatusBarUIByTheme();
        updateAccessibilitySeq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initUiLater() {
        ConversationTitleBtnCtrl c16;
        if (!this.isLoadUILater && !this.isDestroy) {
            StopWatch stopWatch = new StopWatch("Q.recent-initUiLater", true);
            stopWatch.i();
            this.isLoadUILater = true;
            if (!this.isInflated) {
                inflateUI();
                stopWatch.e("inflate ui");
            }
            setThemeDiyBgConversation();
            if (!this.isLoadUIAfterMsgSync && !getApp().mAutomator.isInRealActionLoginB()) {
                doAfterMsgSync(2);
            }
            stopWatch.e("do after msg sync");
            bm bmVar = this.mTitleEntranceCtrlManager;
            if (bmVar != null && (c16 = bmVar.c(1)) != null) {
                c16.f();
            }
            this.openSession.setOnClickListener(this);
            this.openSession.setOnTouchListener(new a());
            this.statusTitle.setOnTouchListener(new b());
            this.mNtMainChatsFrame.z();
            stopWatch.e("lazy create nt main chat frame");
            initMiniAppView();
            stopWatch.e("init mini app view");
            this.springApi.c();
            updateNickName();
            stopWatch.e("update nick name");
            if (!getApp().mAutomator.isInRealActionLoginB()) {
                updateDonDisturb(this.handler, getActivity());
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent", 2, "isInRealActionLoginB MSG_CHECK_QQSPORT_RED_PACKET");
                }
                sendEmptyMessageDelayedToHandler(1061, 0L, false);
                sendEmptyMessageDelayedToHandler(1059, 0L, false);
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "initUiLater() will not send MSG_INIT_MSGTAG_STORY process, loginB: ", Boolean.valueOf(getApp().mAutomator.isInRealActionLoginB()));
            }
            this.mRefreshHandler.sendEmptyMessage(12);
            initDrawerFrame();
            stopWatch.e("init drawer frame");
            this.mNtMainChatsFrame.x();
            stopWatch.b("main chat frame init ui later");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowHighImmersionBanner() {
        if (!this.springApi.e() && !this.mIsImmersionAmsBannerExisted) {
            return false;
        }
        return true;
    }

    private boolean isUpdateStickState(boolean z16) {
        if (z16 && !QQTheme.isSimpleWhite()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getNickNameAreaOnClickListener$8(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.mFrameHelperActivity.mj();
        ReportController.o(getActivity().getAppRuntime(), "dc00898", "", "", "0X800BDEC", "0X800BDEC", 3, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getNickNameAreaOnLongClickListener$7(View view) {
        this.mFrameHelperActivity.mj();
        ReportController.o(getActivity().getAppRuntime(), "dc00898", "", "", "0X800BDEC", "0X800BDEC", 3, 0, "", "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getParentScrollHelperForCardContainer$9(boolean z16) {
        this.mFrameHelperActivity.E.requestDisallowInterceptTouchEvent(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSpaceAreaOnClickListener$6(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.mFrameHelperActivity.C.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getSpaceAreaOnLongClickListener$5(View view) {
        return this.mFrameHelperActivity.C.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOnLoginAnimEnd$2() {
        this.chatListPart.mChatsVM.l(a.p.f355080a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleOnLoginAnimStart$1() {
        QLog.d("Q.recent", 1, "[handleOnLoginAnimEnd] is call, timeout recovery!");
        handleOnLoginAnimEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSuperThemeBg$3() {
        if (ThemeUtil.useNativeThemeVideoPlayer()) {
            this.mListViewBackground.setBackground(null);
            QLog.d("Q.recent", 1, "useNativeThemeVideoPlayer hide bg");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMsgRefreshTipUI$10() {
        this.mFrameHelperActivity.rj("LoadingComplete");
        updateNickName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$notifyCreate$4() {
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).triggerChatsNtFilter(com.tencent.mobileqq.studymode.g.a());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setStatusInfoClick$11(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.mFrameHelperActivity.C.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setStatusInfoClick$12(View view) {
        return this.mFrameHelperActivity.C.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateNickName$13(String str) {
        String G = com.tencent.mobileqq.utils.ac.G(getApp(), getApp().getCurrentUin());
        updateNicknameCache(G);
        updateNickName(str, G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetNotDisturb(boolean z16, String str, String str2) {
        updateDonDisturb(this.handler, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetProfileCard(boolean z16, Object obj) {
        Card card;
        if (obj instanceof Card) {
            card = (Card) obj;
        } else {
            card = null;
        }
        if (z16 && card != null && Utils.p(card.uin, getApp().getCurrentAccountUin())) {
            updateNickName("onCardDownload");
        }
    }

    private void onNetConnect() {
        String str;
        if (!this.mUseNewLoadingTip && (str = this.mNicknameText) != null && !str.equals(this.mNickName.getText().toString())) {
            this.mNickName.setText(this.mNicknameText);
        }
    }

    private void onNetDisconnected() {
        String str;
        if (!this.mUseNewLoadingTip && (str = this.mNicknameText) != null && str.equals(this.mNickName.getText().toString())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNickNameAndStatusContainer.getLayoutParams();
            int width = (((this.mTitleArea.getWidth() - layoutParams.leftMargin) - layoutParams.rightMargin) - this.mNickNameAndStatusContainer.getPaddingLeft()) - this.mNickNameAndStatusContainer.getPaddingRight();
            if (this.mNickName.getMaxWidth() > 0) {
                width = Math.min(this.mNickName.getMaxWidth(), width);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "onBannerShow maxNameWidth=" + width);
            }
            com.tencent.mobileqq.app.utils.p.a(this.app, this.mNickName, this.mNicknameText, width);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetWorkStateChange(int i3, boolean z16) {
        BannerManager bannerManager;
        if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "onNetWorkStateChange isNetWorkConnect = " + z16 + " what = " + i3);
        }
        if (i3 != 10003 && i3 != 10001 && i3 != 10002 && i3 != 1134012) {
            return;
        }
        this.adPart.wa(i3, z16);
        this.agentPart.pa(i3, z16);
        if (z16 && (bannerManager = this.mBannerMang) != null) {
            bannerManager.D(VerifyPhoneBannerProcessor.f185283i, 3000);
        }
    }

    private void onResumeForHongBaoCtrl() {
        if (this.isFromHongBaoShare) {
            if (FrameHelperActivity.Gi()) {
                FrameHelperActivity.Zh();
            }
            this.isFromHongBaoShare = false;
            this.springApi.d();
            return;
        }
        this.springApi.onResume();
    }

    private void onResumeForLoginWelcome() {
        LoginwelcomeHelper loginwelcomeHelper = this.mLoginWelHelper;
        if (loginwelcomeHelper != null) {
            loginwelcomeHelper.j();
        }
    }

    private void onResumeForOnlineStatus() {
        int i3;
        QBaseActivity activity = getActivity();
        int i16 = 1;
        if (activity == null) {
            QLog.e("Q.recent", 1, "onResumeForOnlineStatus error, activity is null!");
            return;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            QLog.e("Q.recent", 1, "onResumeForOnlineStatus error, intent is null!");
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(DIRECT_OPEN_ONLINE_STATUS_PANEL_PARAMS);
        if (serializableExtra == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "onResumeForOnlineStatus params is null.");
                return;
            }
            return;
        }
        if (!(serializableExtra instanceof Map)) {
            QLog.e("Q.recent", 1, "onResumeForOnlineStatus error, serializableParams is invalidate.");
            intent.removeExtra(DIRECT_OPEN_ONLINE_STATUS_PANEL_PARAMS);
            return;
        }
        Map map = (Map) serializableExtra;
        if (map.isEmpty()) {
            QLog.e("Q.recent", 1, "onResumeForOnlineStatus error, serializableParams is empty.");
            intent.removeExtra(DIRECT_OPEN_ONLINE_STATUS_PANEL_PARAMS);
            return;
        }
        Object obj = map.get("sceneType");
        if (obj instanceof String) {
            try {
                i16 = Integer.parseInt((String) obj);
            } catch (NumberFormatException e16) {
                QLog.e("Q.recent", 1, "onResumeForOnlineStatus parse sceneType error! ", e16);
            }
            if (i16 != 2) {
                if (i16 == 3) {
                    i3 = 7;
                }
            } else {
                i3 = 6;
            }
            this.mFrameHelperActivity.nj(i3);
            intent.removeExtra(DIRECT_OPEN_ONLINE_STATUS_PANEL_PARAMS);
        }
        i3 = 5;
        this.mFrameHelperActivity.nj(i3);
        intent.removeExtra(DIRECT_OPEN_ONLINE_STATUS_PANEL_PARAMS);
    }

    private void onResumeForQQCircle(boolean z16) {
        bm bmVar;
        if (this.isLoadUILater && (bmVar = this.mTitleEntranceCtrlManager) != null) {
            bmVar.k(z16);
            this.mTitleEntranceCtrlManager.s(false);
        }
    }

    private void onResumeForReport() {
        this.handler.sendEmptyMessageDelayed(1070, 3000L);
        ((IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
        if (!this.handler.hasMessages(1053)) {
            this.handler.sendEmptyMessageDelayed(1053, 500L);
        }
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.16
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (!QQSettingMe.d0()) {
                    Conversation.this.reportForExpExposure();
                }
            }
        }, 100L);
    }

    private void onResumeForThemeDIY() {
        if (this.isFromThemeDIY) {
            if (FrameHelperActivity.Gi()) {
                FrameHelperActivity.gj(true, "Q.recent");
                FrameHelperActivity.Zh();
            }
            this.isFromThemeDIY = false;
        }
    }

    private void onResumeForZPlanEntryMigratedTips() {
        if (((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("zplan_entry_migrated_tips_has_show", false) || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("zplan_entry_migrated_tips_should_show", false)) {
            return;
        }
        com.tencent.mobileqq.widget.tip.a.r(getAnimHead().getContext()).S(getAnimHead().c()).k0(1).R(1).o0("\u8d85\u7ea7QQ\u79c0\u5165\u53e3\u642c\n\u5230\u8fd9\u91cc\u5566\uff5e").p0(-1).W(Color.parseColor("#9A000000")).j0(10.0f, 8.0f, 10.0f, 8.0f).b0(10000L).f(new d("zplan_entry_migrated_tips_has_show")).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetNick(boolean z16, String str) {
        if (z16) {
            updateNickName("onSetNick", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetNotDisturb(boolean z16, String str, String str2) {
        if (!"not_disturb_from_conversation".equals(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 4, "onSetNotDisturb NOT FROM THIS" + str2);
                return;
            }
            return;
        }
        if (!z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.17
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(Conversation.this.getActivity(), 1, HardCodeUtil.qqStr(R.string.l4f), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                }
            });
            return;
        }
        updateDonDisturb(this.handler, getActivity());
        if (!FriendsStatusUtil.c(getActivity())) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.18
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) Conversation.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(Conversation.this.getActivity(), 2, HardCodeUtil.qqStr(R.string.l4p), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateAvatar(boolean z16, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "Conversation.onUpdateAvatar: uin:" + str + ", success :" + z16);
        }
        if (z16 && this.app != null && Utils.p(str, getApp().getCurrentAccountUin())) {
            this.mFrameHelperActivity.mUiHandler.sendEmptyMessage(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* renamed from: realUpdateNickname, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lambda$updateNickName$14(String str, String str2) {
        TextView textView;
        if (str2.equals(this.mNicknameText)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "[status][mainTab] updateNickName() ignore from: " + str + " nickName: " + cq.w(str2, 3));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "[status][mainTab] updateNickName() from: " + str + " nickName: " + cq.w(str2, 3));
        }
        this.mNickName.setText(str2);
        this.mNicknameText = str2;
        Object tag = this.mNickName.getTag(R.id.uwi);
        if (tag instanceof WeakReference) {
            WeakReference weakReference = (WeakReference) tag;
            if (weakReference.get() instanceof TextView) {
                textView = (TextView) weakReference.get();
                if (textView != null) {
                    textView.setText(str2);
                }
                updateNickName();
            }
        }
        textView = null;
        if (textView != null) {
        }
        updateNickName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recoverOpenSessionAndQQCircleColor() {
        if (isShowHighImmersionBanner()) {
            QLog.d("Q.recent", 1, "hb banner is show, cancel recover color");
            return;
        }
        int iconAlphaByTheme = getIconAlphaByTheme();
        int iconColorFilterByTheme = getIconColorFilterByTheme();
        ImageView imageView = this.openSession;
        if (imageView != null) {
            imageView.setAlpha(iconAlphaByTheme);
            if (ThemeUtil.isNowThemeIsSuperTheme()) {
                this.openSession.setColorFilter((ColorFilter) null);
            } else {
                this.openSession.setColorFilter(iconColorFilterByTheme);
            }
        }
        bm bmVar = this.mTitleEntranceCtrlManager;
        if (bmVar != null) {
            bmVar.p(iconAlphaByTheme);
            this.mTitleEntranceCtrlManager.q(iconColorFilterByTheme);
        }
        ImageView imageView2 = this.hbEntryIcon;
        if (imageView2 != null && imageView2.getVisibility() == 0) {
            this.hbEntryIcon.setAlpha(iconAlphaByTheme);
            this.hbEntryIcon.setColorFilter(iconColorFilterByTheme);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshBlurView() {
        FrameHelperActivity frameHelperActivity = this.mFrameHelperActivity;
        if (frameHelperActivity != null && (frameHelperActivity instanceof MainFragment)) {
            frameHelperActivity.recoverTab();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshSelfOnlineInfoFromServer() {
        ((FriendListHandler) getApp().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(getApp().getCurrentUin(), false);
    }

    private void registerNTCompleteLister() {
        try {
            getActivity().registerReceiver(this.mKernelInitCompleteListener, new IntentFilter("com.tencent.mobileqq.action.ON_KERNEL_INIT_COMPLETE"));
            QLog.d("Q.recent", 1, "register KernelInitCompleteListener");
        } catch (Exception e16) {
            QLog.i("Q.recent", 1, "registerReceiver", e16);
        }
    }

    private void removeModeChangedCallback() {
        ((com.tencent.mobileqq.studymode.l) this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).v(this.mOnModeChangedCallBack);
    }

    private void removeNetErrorCallback() {
        getUIHandler().removeCallbacks(this.netErrorTipShowRunnable);
    }

    private void removeObservers() {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "removeObservers" + this.mNeedObserver);
        }
        synchronized (this.mNeedObserver) {
            this.mNeedObserver.set(false);
            if (this.app != null) {
                getApp().removeObserver(this.mFriendListObserver);
                getApp().removeObserver(this.mCardObserver);
                getApp().removeObserver(this.profileCardObserver);
                if (getApp().getMessageFacade() != null) {
                    getApp().getMessageFacade().deleteObserver(this);
                }
                getApp().setHandler(getClass(), null);
                getApp().removeHandler(getClass());
                getApp().removeObserver(this.redTouchObserver);
                getApp().removeObserver(this.mQCircleObserver);
                ((IQCircleChatMsgNtApi) QRoute.api(IQCircleChatMsgNtApi.class)).removeRecentContactListener();
                ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).destroyChannelUpdateManager();
                com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) this.app.getManager(QQManagerFactory.RECENT_CALL_FACADE);
                if (fVar != null) {
                    fVar.deleteObserver(this);
                }
                LoginwelcomeHelper loginwelcomeHelper = this.mLoginWelHelper;
                if (loginwelcomeHelper != null) {
                    loginwelcomeHelper.n();
                }
                this.mNtMainChatsFrame.Q(this.app);
                this.springApi.onDestroy();
            }
            this.mRefreshHandler.removeMessages(17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportForExpExposure() {
        try {
            ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_QQ_STATUS).reportExpExposure();
            ((IGameMsgBoxABTestApi) QRoute.api(IGameMsgBoxABTestApi.class)).reportGameTabExposure(this.handler);
        } catch (Throwable th5) {
            QLog.e("Q.recent", 1, "online status exp: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeDelayRefresh() {
        if (this.isLockLateInit) {
            sendEmptyMessageDelayedToHandler(1030, 300L, true);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "resumeDelayRefresh");
        }
        this.mNtMainChatsFrame.R();
        if (!this.mFrameHelperActivity.R) {
            com.tencent.mobileqq.activity.framebusiness.controllerinject.n.d(getActivity(), getApp().getCurrentUin());
        }
        updateNickName();
        onResumeForZPlanEntryMigratedTips();
    }

    private void setDrawerCallback() {
        if (this.drawerCallbacks != null) {
            return;
        }
        g gVar = new g();
        this.drawerCallbacks = gVar;
        this.mFrameHelperActivity.Qh(gVar);
        this.mFrameHelperActivity.Qh(new LebaTabRedTouch.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirstDrawComplete() {
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "setFirstDrawComplete, " + this.isInited);
        }
        if (this.isInited) {
            return;
        }
        this.handler.removeMessages(1025);
        this.isInited = true;
        if (!this.isLoadUILater) {
            this.handler.sendEmptyMessage(1020);
        }
        BaseApplicationImpl.sApplication.onActivityFocusChanged(getActivity(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOpenSessionAndQQCircleColor(int i3) {
        if (isShowHighImmersionBanner() && i3 != -1) {
            QLog.d("Q.recent", 1, "hb banner is show, cancel set color");
            return;
        }
        ImageView imageView = this.openSession;
        if (imageView != null) {
            imageView.setAlpha(255);
            this.openSession.setColorFilter(i3);
        }
        bm bmVar = this.mTitleEntranceCtrlManager;
        if (bmVar != null) {
            bmVar.p(255);
            this.mTitleEntranceCtrlManager.q(i3);
        }
        ImageView imageView2 = this.hbEntryIcon;
        if (imageView2 != null && imageView2.getVisibility() == 0) {
            this.hbEntryIcon.setAlpha(255);
            this.hbEntryIcon.setColorFilter(i3);
        }
    }

    private void setSoftInputModeToJustPan() {
        try {
            getActivity().getWindow().setSoftInputMode(32);
        } catch (Exception e16) {
            QLog.e("Q.recent", 1, e16, new Object[0]);
        }
    }

    private void setStatusInfoClick(int i3, View view) {
        if (view == null) {
            return;
        }
        BaseAIOUtils.h(view, i3, i3, i3, i3);
        view.setOnTouchListener(new ba.a(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.home.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Conversation.this.lambda$setStatusInfoClick$11(view2);
            }
        }));
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.activity.home.j
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean lambda$setStatusInfoClick$12;
                lambda$setStatusInfoClick$12 = Conversation.this.lambda$setStatusInfoClick$12(view2);
                return lambda$setStatusInfoClick$12;
            }
        });
    }

    private void stopLoadingState() {
        if (com.tencent.mobileqq.managers.b.b().n()) {
            com.tencent.mobileqq.managers.b.b().k(3, "stopLoadingState");
        }
    }

    private void updateAccessibilitySeq() {
        View animHead = getAnimHead();
        if (animHead == null) {
            animHead = this.mFrameHelperActivity.getBaseActivity().findViewById(R.id.e3u);
        }
        ((IMainUIHelperApi) QRoute.api(IMainUIHelperApi.class)).updateAccessibilitySeq(new com.tencent.mobileqq.main.api.a(animHead, this.mNickNameAndStatusContainer, this.mStatusRightContainer, this.mRootView, (View) this.mFrameHelperActivity.getTabHost()));
    }

    public static void updateDonDisturb(MqqHandler mqqHandler, Context context) {
        mqqHandler.removeMessages(MSG_DON_DISTURB_MSG);
        if (FriendsStatusUtil.c(context)) {
            ReportController.o(null, "CliOper", "", "", "0X8009EB9", "0X8009EB9", 0, 1, "", "", "", "");
            Message obtainMessage = mqqHandler.obtainMessage(MSG_DON_DISTURB_MSG);
            obtainMessage.arg1 = 2;
            mqqHandler.sendMessage(obtainMessage);
            long d16 = FriendsStatusUtil.d(context);
            if (d16 > 0) {
                mqqHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.19
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) MqqHandler.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        MqqHandler.this.removeMessages(Conversation.MSG_DON_DISTURB_MSG);
                        Message obtainMessage2 = MqqHandler.this.obtainMessage(Conversation.MSG_DON_DISTURB_MSG);
                        obtainMessage2.arg1 = 0;
                        MqqHandler.this.sendMessage(obtainMessage2);
                    }
                }, d16 * 1000);
                return;
            }
            return;
        }
        Message obtainMessage2 = mqqHandler.obtainMessage(MSG_DON_DISTURB_MSG);
        obtainMessage2.arg1 = 0;
        mqqHandler.sendMessage(obtainMessage2);
    }

    private void updateForQCallFacade(Observable observable, Object obj) {
        BannerManager bannerManager;
        com.tencent.mobileqq.qcall.f fVar;
        if (observable instanceof com.tencent.mobileqq.qcall.f) {
            if (obj instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                if (!this.mIsChatList && booleanValue) {
                    AppRuntime appRuntime = this.app;
                    if (appRuntime != null) {
                        fVar = (com.tencent.mobileqq.qcall.f) appRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
                    } else {
                        fVar = null;
                    }
                    if (fVar != null) {
                        fVar.M(false);
                    }
                }
            }
            if (this.mIsChatList && (bannerManager = this.mBannerMang) != null) {
                bannerManager.D(MissedCallBannerProcessor.f185230d, 2000);
            }
        }
    }

    private void updateLeftAreaRightMargin() {
        int i3;
        int i16;
        if (this.mRootView != null && this.mNickNameAndStatusContainer != null) {
            ImageView imageView = this.hbEntryIcon;
            if (imageView != null && imageView.getVisibility() == 0) {
                i3 = 3;
            } else {
                i3 = 2;
            }
            TextView textView = (TextView) this.mNickNameAndStatusContainer.findViewById(R.id.f72193q7);
            int dip2px = ViewUtils.dip2px(36.0f) * i3;
            if (!TextUtils.isEmpty(textView.getText())) {
                i16 = 20;
            } else {
                i16 = 0;
            }
            ((ViewGroup.MarginLayoutParams) this.mNickNameAndStatusContainer.getLayoutParams()).rightMargin = dip2px + ViewUtils.dip2px(i16 + 5);
        }
    }

    private void updateLoadingStateToEndState() {
        if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "updateLoadingStateToEndState");
        }
        com.tencent.mobileqq.managers.b.b().k(3, "afterMsgSync");
        changeConversationLoadingState(true);
    }

    private void updateNickName() {
        TextView textView = this.mNickName;
        if (textView == null) {
            return;
        }
        textView.setClickable(true);
        this.mNickNameAndStatusContainer.setClickable(true);
        View.OnClickListener nickNameAreaOnClickListener = getNickNameAreaOnClickListener();
        View.OnLongClickListener nickNameAreaOnLongClickListener = getNickNameAreaOnLongClickListener();
        this.mNickName.setOnTouchListener(new l(new ba.a(nickNameAreaOnClickListener)));
        this.mNickName.setOnLongClickListener(nickNameAreaOnLongClickListener);
        this.mNickNameAndStatusContainer.setOnTouchListener(new ba.a(getSpaceAreaOnClickListener(nickNameAreaOnClickListener)));
        this.mNickNameAndStatusContainer.setOnLongClickListener(getSpaceAreaOnLongClickListener(nickNameAreaOnLongClickListener));
        updateLeftAreaRightMargin();
    }

    private void updateNicknameCache(String str) {
        QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeString(getNicknameCacheKey(), str);
    }

    private void updateTitleBar() {
        MainChatsListVB mainChatsListVB;
        ((IMainUIHelperApi) QRoute.api(IMainUIHelperApi.class)).updateTitleBar(this, this.mTitleArea, this.resConfig, !this.mIsImmersionBannerExisted);
        if (!this.mIsImmersionBannerExisted && !this.isRestoreStateForTitleBarUpdate && !isShowHighImmersionBanner()) {
            com.tencent.qqnt.chats.biz.main.part.c cVar = this.chatListPart;
            if (cVar != null && (mainChatsListVB = cVar.mChatsVB) != null) {
                mainChatsListVB.b(new a.r(this.mTitleArea.getLayoutParams().height));
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.chatListPart.mChatsVB.F().getLayoutManager();
                if (linearLayoutManager != null && linearLayoutManager.findFirstVisibleItemPosition() == 0) {
                    this.chatListPart.mChatsVB.b(a.o.f355022a);
                }
            }
            TitleAreaLeftLayout.INSTANCE.c(this.mNickName, this.mFLStatusInfo);
        }
        this.isRestoreStateForTitleBarUpdate = false;
    }

    public void changeConversationLoadingState(boolean z16) {
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
            return;
        }
        BannerManager bannerManager = this.mBannerMang;
        if (bannerManager != null) {
            z17 = bannerManager.n(NetStateBannerProcessor.f185236d);
            z18 = this.mBannerMang.n(IllegalNetworkBannerProcessor.f185221d);
        } else {
            z17 = false;
            z18 = false;
        }
        QLog.i("Q.recent", 1, "[changeConversationLoadingState] bShowNetBar=" + z17 + ", bShowIllegalNetBar=" + z18 + ", initLoadingHandle=" + z16 + ", loadingState=" + com.tencent.mobileqq.managers.b.b().c());
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 1, "[changeConversationLoadingState] remove messages");
            }
            this.mLoadingStateHandler.removeMessages(4);
            this.mLoadingStateHandler.removeMessages(3);
        }
        if (!z17 && !z18) {
            int c16 = com.tencent.mobileqq.managers.b.b().c();
            if (c16 != 0) {
                if (c16 != 1) {
                    if (c16 != 2) {
                        if (c16 != 3) {
                            if (c16 == 4) {
                                updateLoadingState(false);
                            } else {
                                return;
                            }
                        }
                    } else {
                        updateLoadingState(true);
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.recent", 1, "[changeConversationLoadingState] send delayed end message");
                        }
                        if (!this.mLoadingStateHandler.hasMessages(3)) {
                            this.mLoadingStateHandler.sendEmptyMessageDelayed(3, 180000L);
                            return;
                        }
                        return;
                    }
                } else {
                    updateLoadingState(true);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.recent", 1, "[changeConversationLoadingState] send delayed connect fail message");
                    }
                    if (!this.mLoadingStateHandler.hasMessages(4)) {
                        this.mLoadingStateHandler.sendEmptyMessageDelayed(4, 180000L);
                        return;
                    }
                    return;
                }
            }
            updateLoadingState(false);
            return;
        }
        updateLoadingState(false);
    }

    public void changeSpecialCareVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, z16);
            return;
        }
        MainChatsListVB mainChatsListVB = this.chatListPart.mChatsVB;
        if (mainChatsListVB != null) {
            mainChatsListVB.C0(z16);
        }
    }

    public void changeThirdContainerOffset(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
        } else {
            this.adPart.pa(z16);
        }
    }

    public void clearStatusBarBg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "clearStatusBarBg");
        }
        this.mTitleArea.setBackgroundDrawable(null);
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void fillData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        updateAccountInfo(true);
        this.mFrameHelperActivity.mUiHandler.sendEmptyMessage(5);
        bm bmVar = this.mTitleEntranceCtrlManager;
        if (bmVar != null) {
            bmVar.b();
        }
    }

    public void fitElderMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
            return;
        }
        if (!SimpleUIUtil.isNowElderMode()) {
            return;
        }
        TextView textView = this.mNickName;
        if (textView != null) {
            textView.setTextSize(18.0f);
        }
        int dimension = (int) getResources().getDimension(R.dimen.title_bar_height);
        ConversationTitleBtnCtrl.c(this.openSessionRedTouch, dimension);
        ConversationTitleBtnCtrl.c(this.openSession, dimension);
    }

    public View getAnimContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (View) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.mListViewContainer;
    }

    public TitleAreaHeadLayout getAnimHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (TitleAreaHeadLayout) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.mFrameHelperActivity.mi();
    }

    public View getAnimTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (View) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.statusTitle;
    }

    public QQAppInterface getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return (QQAppInterface) this.app;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public f.b getBlurDirtyState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (f.b) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        return this.dirtyStateProvider;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public String getLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.l4n);
        int i3 = this.mUnReadCount;
        if (i3 > 0) {
            if (i3 > 99) {
                return qqStr + "(99+)";
            }
            return qqStr + "(" + this.mUnReadCount + ")";
        }
        return qqStr;
    }

    public View getListBackgroundView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (View) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        return this.mListViewBackground;
    }

    public MiniAppPullInterface getMiniAppPullInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (MiniAppPullInterface) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.miniAppPullInterface;
    }

    public View getTitleView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (View) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return this.mTitleArea;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, (Object) message)).booleanValue();
        }
        if (!this.isDestroy && getActivity() != null && !getActivity().isFinishing()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, "handleMessage, msg.what=", Integer.valueOf(message.what));
            }
            TraceUtils.traceBegin("conv.handleMessage");
            int i3 = message.what;
            if (i3 != 12) {
                if (i3 == 17) {
                    addObservers(true);
                }
            } else {
                this.mNtMainChatsFrame.P();
            }
            TraceUtils.traceEnd();
        }
        return true;
    }

    public void handleOnLoginAnimEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("Q.recent", 1, "[handleOnLoginAnimEnd] is call, isLockLateInit=" + this.isLockLateInit + ", isDestroy=" + this.isDestroy);
        if (!this.isLockLateInit) {
            return;
        }
        com.tencent.qqperf.opt.threadpriority.b.k(false);
        if (this.syncToken > -1) {
            ly3.c.a(Looper.getMainLooper().getQueue(), "removeSyncBarrier", new c.b(Integer.TYPE, Integer.valueOf(this.syncToken)));
            this.syncToken = -1;
        }
        this.isLockLateInit = false;
        if (this.isDestroy) {
            return;
        }
        getUIHandler().removeCallbacks(this.loginAnimTimeOutRunnable);
        this.loginAnimTimeOutRunnable = null;
        doAfterDrawComplete();
        getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.home.c
            @Override // java.lang.Runnable
            public final void run() {
                Conversation.this.lambda$handleOnLoginAnimEnd$2();
            }
        }, 80L);
    }

    public void handleOnLoginAnimStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        boolean isInSplashAnim = ((ILoginSuccessAnimApi) QRoute.api(ILoginSuccessAnimApi.class)).isInSplashAnim();
        QLog.d("Q.recent", 1, "[handleOnLoginAnimStart] is call, isShowLoginAnim=" + isInSplashAnim);
        if (isInSplashAnim && !this.isLockLateInit) {
            com.tencent.qqperf.opt.threadpriority.b.k(true);
            this.chatListPart.mChatsVM.l(a.d.f355053a);
            this.isLockLateInit = true;
            if (this.loginAnimTimeOutRunnable == null) {
                this.loginAnimTimeOutRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.home.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        Conversation.this.lambda$handleOnLoginAnimStart$1();
                    }
                };
            }
            boolean j3 = this.resConfig.j();
            if (j3 && this.syncToken == -1) {
                QLog.d("Q.recent", 1, "[handleOnLoginAnimStart] use sync barrier on login anim");
                Object a16 = ly3.c.a(Looper.getMainLooper().getQueue(), "postSyncBarrier", new c.b[0]);
                if (a16 != null) {
                    this.syncToken = ((Integer) a16).intValue();
                }
            }
            Message obtain = Message.obtain(getUIHandler(), this.loginAnimTimeOutRunnable);
            if (j3) {
                obtain.setAsynchronous(true);
            }
            getUIHandler().sendMessageDelayed(obtain, 2000L);
        }
    }

    public void handlePullRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            this.springApi.r0();
        }
    }

    public synchronized void inflateUI() {
        String str;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (!this.isInflated && !this.isDestroy) {
            this.isInflated = true;
            BaseActivity baseActivity = (BaseActivity) getActivity();
            try {
                if (this.mRecentOptionBar == null) {
                    this.mRecentOptionBar = new com.tencent.mobileqq.activity.recent.l(baseActivity);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    str = "in main thread ";
                } else {
                    str = "not in main thread ";
                    this.isInflated = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Q.recent", 2, str + e16.toString());
                }
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("device_mode", com.tencent.mobileqq.utils.ah.s());
                    hashMap.put("manufacturer", Build.MANUFACTURER);
                    StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                    String currentAccountUin = getApp().getCurrentAccountUin();
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        j3 = 0;
                    } else {
                        j3 = 1;
                    }
                    statisticCollector.collectPerformance(currentAccountUin, "actConSubInflate", false, j3, 0L, hashMap, "");
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.recent", 2, e17.toString());
                    }
                }
            }
            if (!com.tencent.mobileqq.util.af.i()) {
                this.mFrameHelperActivity.mUiHandler.sendEmptyMessage(2);
            }
        }
    }

    public boolean isCardContainerVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.cardContainerPart.X9();
    }

    public boolean isForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.mIsForeground;
    }

    public boolean isListFirstItemTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Boolean) iPatchRedirector.redirect((short) 65, (Object) this)).booleanValue();
        }
        return this.chatListPart.da();
    }

    public boolean isOnlyInConversationList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        FrameHelperActivity frameHelperActivity = this.mFrameHelperActivity;
        if (frameHelperActivity == null || !isConversationList || frameHelperActivity.R) {
            return false;
        }
        return true;
    }

    public boolean isShowGuildNavigationBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.notifyActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "onActivityResult, [" + i3 + "," + i16 + "," + intent);
        }
        if (i3 != 2) {
            if (i3 == 1000 && i16 == 0) {
                finish();
                getApp().exit(false);
            }
        } else if (getActivity() != null) {
            getActivity().setCanLock(false);
        }
        this.mNtMainChatsFrame.C(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public boolean notifyBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        if (FrameHelperActivity.Gi()) {
            FrameHelperActivity.Zh();
            return true;
        }
        if (this.springApi.onBackPressed()) {
            return true;
        }
        MiniAppPullInterface miniAppPullInterface = this.miniAppPullInterface;
        if (miniAppPullInterface != null && miniAppPullInterface.onBackPressed()) {
            return true;
        }
        return this.mNtMainChatsFrame.E();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) configuration);
            return;
        }
        com.tencent.mobileqq.activity.recent.l lVar = this.mRecentOptionBar;
        if (lVar != null && lVar.isShowing()) {
            this.mRecentOptionBar.h();
        }
        this.mNtMainChatsFrame.G(configuration);
        super.notifyConfigurationChanged(configuration);
        com.tencent.mobileqq.app.utils.i iVar = com.tencent.mobileqq.app.utils.i.f196664a;
        iVar.i(configuration.fontScale, true);
        QBaseActivity activity = getActivity();
        if (activity != null) {
            iVar.a(activity, false);
            FontSizeChangeBannerHelper.f210540a.a(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        ei.a(null, "Recent_OnCreate");
        super.notifyCreate();
        registerNTCompleteLister();
        this.mFrameHelperActivity = FrameHelperActivity.ji((BaseActivity) getActivity());
        this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this.mUICallBack);
        this.mRefreshHandler = new com.tencent.mobileqq.utils.ad(ThreadManagerV2.getRecentThreadLooper(), this);
        this.mRecentHelper = new RecentPubAccHelper(this.handler, getActivity());
        bm bmVar = new bm(this);
        this.mTitleEntranceCtrlManager = bmVar;
        bmVar.a(1);
        this.mNtMainChatsFrame.H();
        if (!ChatsListConfig.f354433a.e()) {
            IRecentContactRepo preloadMainRepo = ((IChatsDataRepoCreator) QRoute.api(IChatsDataRepoCreator.class)).getPreloadMainRepo();
            if ((getActivity() instanceof SplashActivity) && preloadMainRepo != null) {
                QLog.d("Q.recent", 1, "hit repo PreCreate");
                this.chatListPart.ra(preloadMainRepo);
                preloadMainRepo.p();
            }
        }
        this.mNtMainChatsFrame.B();
        initUI();
        initListeners();
        updateAccountInfo(false);
        this.mOnModeChangedCallBack = new com.tencent.mobileqq.studymode.o(new Function0() { // from class: com.tencent.mobileqq.activity.home.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit lambda$notifyCreate$4;
                lambda$notifyCreate$4 = Conversation.lambda$notifyCreate$4();
                return lambda$notifyCreate$4;
            }
        });
        addModeChangedCallback();
        handleOnLoginAnimStart();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101842", true);
        QLog.i("Q.recent", 1, "drawerSwitch:" + isSwitchOn);
        if (isSwitchOn) {
            setDrawerCallback();
        }
        ei.a("Recent_OnCreate", null);
        this.chatListPart.mChatsVM.q(new mqq.util.WeakReference<>(this.mListViewModelHandler));
        this.chatListPart.mChatsVM.g();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public View notifyCreateView(LayoutInflater layoutInflater) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, (Object) this, (Object) layoutInflater);
        }
        ei.a(null, "Recent_Start");
        ei.a(null, "Recent_CreateView");
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null && (baseActivity instanceof SplashActivity)) {
            SplashActivity splashActivity = (SplashActivity) baseActivity;
            view = splashActivity.mPreloadConversationView;
            splashActivity.mPreloadConversationView = null;
        } else {
            view = null;
        }
        if (view == null) {
            view = layoutInflater.inflate(R.layout.f167820ik, (ViewGroup) null);
        }
        ei.a("Recent_CreateView", null);
        return view;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.isDestroy = true;
        RecentPubAccHelper recentPubAccHelper = this.mRecentHelper;
        if (recentPubAccHelper != null) {
            recentPubAccHelper.h();
        }
        this.mNtMainChatsFrame.onDestroy();
        removeObservers();
        this.mFrameHelperActivity.ij(null);
        this.mRefreshHandler.removeCallbacksAndMessages(null);
        this.handler.removeCallbacksAndMessages(null);
        MqqHandler mqqHandler = this.mLoadingStateHandler;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
        this.drawerCallbacks = null;
        LoginwelcomeHelper loginwelcomeHelper = this.mLoginWelHelper;
        if (loginwelcomeHelper != null) {
            loginwelcomeHelper.i();
            this.mLoginWelHelper = null;
        }
        bm bmVar = this.mTitleEntranceCtrlManager;
        if (bmVar != null) {
            bmVar.g();
        }
        MiniAppPullInterface miniAppPullInterface = this.miniAppPullInterface;
        if (miniAppPullInterface != null) {
            miniAppPullInterface.onDestroy();
        }
        MsgRefreshTipMgr.f().e();
        if (getApp() != null) {
            getApp().getConversationFacade().m0(this.registerProxyListenerWrapper);
        }
        removeNetErrorCallback();
        ConvNetState.b().d();
        removeModeChangedCallback();
        handleOnLoginAnimEnd();
        try {
            ((BaseActivity) getActivity()).unregisterReceiver(this.mKernelInitCompleteListener);
            QLog.d("Q.recent", 1, "unRegister KernelInitCompleteListener");
        } catch (Exception e16) {
            QLog.i("Q.recent", 1, "unregisterReceiver", e16);
        }
        super.notifyDestroy();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) intent);
            return;
        }
        super.notifyNewIntent(intent);
        handleOnLoginAnimStart();
        handleIntent(intent);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        QLog.d("Q.recent", 2, "onPause...");
        super.notifyPause(z16);
        this.mIsForeground = false;
        isConversationList = false;
        this.springApi.onPause();
        this.mNtMainChatsFrame.onPause();
        this.handler.removeMessages(1053);
        if (this.app == null) {
            return;
        }
        DragFrameLayout dragFrameLayout = this.mDragHost;
        if (dragFrameLayout != null) {
            dragFrameLayout.removeOnDragModeChangeListener(this.mOnDragModeChangeListener);
        }
        if (AppSetting.K) {
            getApp().setMainActivityState(false);
        }
        this.handler.removeMessages(1070);
        DragFrameLayout dragFrameLayout2 = this.mDragHost;
        if (dragFrameLayout2 != null) {
            dragFrameLayout2.onPause();
        }
        com.tencent.mobileqq.activity.recent.l lVar = this.mRecentOptionBar;
        if (lVar != null) {
            lVar.E();
        }
        getApp().isConversationTabShow = false;
        this.handler.removeMessages(MSG_QZONE_REPORT);
        bm bmVar = this.mTitleEntranceCtrlManager;
        if (bmVar != null) {
            bmVar.i();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) bundle);
            return;
        }
        super.notifyRestoreInstanceState(bundle);
        this.chatListPart.ga(bundle);
        if (ChatsListConfig.f354433a.h()) {
            this.isRestoreStateForTitleBarUpdate = true;
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyResume(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
            return;
        }
        QLog.d("Q.recent", 2, "onResume...");
        if (this.app == null) {
            return;
        }
        ei.a(null, "Recent_OnResume");
        getApp().isConversationTabShow = true;
        this.mIsForeground = true;
        isConversationList = true;
        super.notifyResume(z16);
        if (AppSetting.f99565y) {
            getActivity().setTitle(getString(R.string.c76));
        }
        this.mNtMainChatsFrame.onResume();
        MiniAppPullInterface miniAppPullInterface = this.miniAppPullInterface;
        if (miniAppPullInterface != null) {
            miniAppPullInterface.onResume();
        }
        if (AppSetting.K) {
            getApp().setMainActivityState(true);
        }
        setSoftInputModeToJustPan();
        if (!this.isLockLateInit) {
            if (this.isInited) {
                if (!this.isLoadUILater) {
                    this.handler.sendEmptyMessage(1020);
                }
                this.handler.sendEmptyMessageDelayed(1030, 1000L);
            } else {
                this.handler.sendEmptyMessageDelayed(1025, 3000L);
            }
        }
        this.mDragHost.addOnDragModeChangeListener(this.mOnDragModeChangeListener, false);
        onResumeForThemeDIY();
        updateNickName("onResume");
        this.subAccountBindPart.ua();
        onResumeForHongBaoCtrl();
        onResumeForReport();
        onResumeForLoginWelcome();
        DarkModeManager.u(null);
        onResumeForQQCircle(z16);
        fitElderMode();
        z61.e.a((BaseActivity) getActivity(), z16);
        this.adPart.va(z16, this.isInited);
        this.agentPart.oa(z16, this.isInited);
        ((IOnlineStatusService) this.app.getRuntimeService(IOnlineStatusService.class, "")).checkAndSetConversationGuide(this.mStatusInfo, this.mStatusInfoGuide);
        IKernelService iKernelService = (IKernelService) this.app.getRuntimeService(IKernelService.class, "");
        if (iKernelService.getMsgService() != null) {
            iKernelService.getMsgService().setFocusOnBase(new Contact(0, "0", ""));
        }
        onResumeForOnlineStatus();
        ei.a("Recent_OnResume", null);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifySaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) bundle);
        } else {
            super.notifySaveInstanceState(bundle);
            this.chatListPart.ha(bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this);
        } else {
            this.mNtMainChatsFrame.onStart();
            super.notifyStart();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
            return;
        }
        super.notifyStop();
        com.tencent.mobileqq.activity.recent.l lVar = this.mRecentOptionBar;
        if (lVar != null && lVar.isShowing()) {
            this.mRecentOptionBar.h();
        }
        this.mNtMainChatsFrame.onStop();
        LoginwelcomeHelper loginwelcomeHelper = this.mLoginWelHelper;
        if (loginwelcomeHelper != null) {
            loginwelcomeHelper.k();
        }
        MiniAppPullInterface miniAppPullInterface = this.miniAppPullInterface;
        if (miniAppPullInterface != null) {
            miniAppPullInterface.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.Frame
    public void onBeforeAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        removeObservers();
        BannerManager bannerManager = this.mBannerMang;
        if (bannerManager != null) {
            bannerManager.v(getApp());
        }
        this.springApi.onBeforeAccountChanged();
        this.handler.removeMessages(MSG_DON_DISTURB_MSG);
        this.handler.removeMessages(MSG_TRIGGER_QZONE_REPORT);
        this.handler.removeMessages(MSG_QZONE_REPORT);
        com.tencent.mobileqq.statistics.n.h();
        com.tencent.mobileqq.activity.recent.l lVar = this.mRecentOptionBar;
        if (lVar != null) {
            lVar.G = true;
        }
        RecentPubAccHelper recentPubAccHelper = this.mRecentHelper;
        if (recentPubAccHelper != null) {
            recentPubAccHelper.g(getApp());
        }
        LoginwelcomeHelper loginwelcomeHelper = this.mLoginWelHelper;
        if (loginwelcomeHelper != null) {
            loginwelcomeHelper.h();
        }
        bm bmVar = this.mTitleEntranceCtrlManager;
        if (bmVar != null) {
            bmVar.f();
        }
        NtBasePartFrame ntBasePartFrame = this.mNtMainChatsFrame;
        if (ntBasePartFrame != null) {
            ntBasePartFrame.F(getApp());
        }
        MsgRefreshTipMgr.f().j();
        this.thirdPart.K9(getApp());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) view);
        } else if (view == this.openSession) {
            if (this.mRecentOptionBar != null && !this.isDestroy && getActivity() != null && !getActivity().isFinishing()) {
                com.tencent.mobileqq.activity.recent.l lVar = this.mRecentOptionBar;
                RelativeLayout relativeLayout = this.mTitleArea;
                lVar.M(relativeLayout, (relativeLayout.getWidth() - getResources().getDimensionPixelSize(R.dimen.au6)) - getResources().getDimensionPixelSize(R.dimen.au7), getResources().getDimensionPixelSize(R.dimen.au8));
                this.mRecentOptionBar.J(view);
            }
            FrameHelperActivity frameHelperActivity = this.mFrameHelperActivity;
            if (frameHelperActivity != null && (frameHelperActivity instanceof MainFragment)) {
                ((MainFragment) frameHelperActivity).dk();
            }
            ReportController.o(this.app, "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
            id0.a.n("plus_shoot", "exp_entry", 0, 0, "", "", "", "");
            this.openSessionRedTouch.clearRedTouch();
            SafeModeUtil.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onConversationFrameTabClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (GuildSlideCoordinator.s()) {
            com.tencent.mobileqq.activity.home.chats.biz.guild.a.a(GuildSubscribeChannelReturnType.CONVERSATION_TAB);
            GuildSlideCoordinator.r();
        } else {
            this.chatListPart.ja();
            this.dirtyStateProvider.b();
        }
    }

    public void onConversationTabExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        QQChatListTwoLevelHeader qQChatListTwoLevelHeader = this.miniProgramPart.miniProgramHeader;
        if (qQChatListTwoLevelHeader == null) {
            QLog.d("Q.recent", 1, "onConversationTabExit miniProgramPart.miniProgramHeader is null, return");
        } else {
            qQChatListTwoLevelHeader.postOnAnimation(new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.14
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Conversation.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QLog.d("Q.recent", 1, "close two level");
                        Conversation.this.miniProgramPart.wa();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void onDrawComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        this.mIsForeground = true;
        com.tencent.imcore.message.report.b.a().b();
        if (this.isLockLateInit) {
            QLog.d("Q.recent", 1, "[onDrawComplete] isLockLateInit");
        } else {
            doAfterDrawComplete();
        }
    }

    @Override // com.tencent.mobileqq.app.FrameHelperActivity.j
    public void onDrawerInit(boolean z16) {
        MiniAppPullInterface miniAppPullInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, z16);
        } else if (z16 && (miniAppPullInterface = this.miniAppPullInterface) != null) {
            miniAppPullInterface.initLater(this.mFrameHelperActivity.E);
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void onFrameTabClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.onFrameTabClick();
            onConversationFrameTabClick();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) logoutReason);
            return;
        }
        super.onLogout(logoutReason);
        com.tencent.mobileqq.activity.recent.l lVar = this.mRecentOptionBar;
        if (lVar != null && lVar.isShowing()) {
            this.mRecentOptionBar.h();
        }
        this.springApi.onLogout(logoutReason);
        this.agentPart.onLogout(logoutReason);
    }

    public void onPostThemeChanged() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "conversation onPostThemeChanged");
        }
        handleSuperThemeBg();
        MqqHandler mqqHandler = this.handler;
        if (mqqHandler != null) {
            mqqHandler.sendEmptyMessage(1009);
        }
        SimpleModeHelper.D(this.mStatusTitleDivider);
        setThemeDiyBgConversation();
        com.tencent.mobileqq.activity.home.chats.c.h();
        com.tencent.mobileqq.widget.o.k();
        MsgRefreshTipMgr.f().i();
        MsgRefreshTipMgr.f().q();
        refreshStatusBarUIByTheme();
        MiniAppPullInterface miniAppPullInterface = this.miniAppPullInterface;
        if (miniAppPullInterface != null) {
            miniAppPullInterface.onPostThemeChanged();
        }
        NtBasePartFrame ntBasePartFrame = this.mNtMainChatsFrame;
        if (ntBasePartFrame != null) {
            ntBasePartFrame.M();
        }
        this.mFrameHelperActivity.rj("ThemeChanged");
        this.springApi.onPostThemeChanged();
        if (ThemeUtil.isSimpleAndOtherThemeSwitch()) {
            this.mFrameHelperActivity.sj();
        }
        com.tencent.mobileqq.activity.recent.l lVar = this.mRecentOptionBar;
        if (lVar != null) {
            lVar.G = true;
        }
        if (!QQTheme.isSimpleWhite() && (view = this.mStatusTitleDivider) != null) {
            view.setVisibility(8);
        }
        setStatusInfoGuideBg();
        if (!this.mIsImmersionBannerExisted) {
            recoverOpenSessionAndQQCircleColor();
        } else {
            setOpenSessionAndQQCircleColor(this.mImmersionBannerTxtColor);
        }
        bm bmVar = this.mTitleEntranceCtrlManager;
        if (bmVar != null) {
            bmVar.j();
        }
    }

    @Override // com.tencent.imcore.message.ConversationFacade.c
    public void onRegisterProxyDone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this);
            return;
        }
        QLog.d("Q.recent", 1, "onRegisterProxyDone");
        com.tencent.mobileqq.tianjige.e.b(this.app.getCurrentAccountUin());
        com.tencent.mobileqq.statistics.tianjige.metrics.a.b();
        ((RegisterProxySvcPackHandler) ((QQAppInterface) this.app).getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).M2();
    }

    public void realOnDrawComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (!this.isInited && !this.isDestroy) {
            setFirstDrawComplete();
            ei.a("Recent_Start", null);
        } else if (this.isInited) {
            sendEmptyMessageDelayedToHandler(1030, 0L, true);
        }
    }

    public void refreshEntranceRedTouch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        bm bmVar = this.mTitleEntranceCtrlManager;
        if (bmVar != null) {
            bmVar.l();
        }
    }

    void refreshNetStatus(Message message, boolean z16) {
        int i3 = message == null ? 0 : message.what;
        QLog.i("Q.recent", 1, "refreshNetStatus, app.isMSFConnect = " + getApp().isMSFConnect() + ", initLoadingHandle = " + z16 + ", loadingState = " + com.tencent.mobileqq.managers.b.b().c() + ", what = " + i3);
        if (getApp().isMSFConnect()) {
            refreshNetStatus(i3, true, z16);
            onNetWorkStateChange(i3, true);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(z16, i3) { // from class: com.tencent.mobileqq.activity.home.Conversation.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f182763d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f182764e;

                {
                    this.f182763d = z16;
                    this.f182764e = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Conversation.this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    boolean isNetSupportHw = NetworkUtil.isNetSupportHw(BaseApplication.getContext());
                    if (!isNetSupportHw) {
                        QLog.i("Q.recent", 1, "[refreshNetStatus] isNetSupport = false, initLoadingHandle = " + this.f182763d + ", loadingState = " + com.tencent.mobileqq.managers.b.b().c());
                    }
                    Conversation.this.runOnUiThread(new Runnable(isNetSupportHw) { // from class: com.tencent.mobileqq.activity.home.Conversation.7.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f182765d;

                        {
                            this.f182765d = isNetSupportHw;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass7.this, Boolean.valueOf(isNetSupportHw));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            Conversation.this.refreshNetStatus(anonymousClass7.f182764e, this.f182765d, anonymousClass7.f182763d);
                            AnonymousClass7 anonymousClass72 = AnonymousClass7.this;
                            Conversation.this.onNetWorkStateChange(anonymousClass72.f182764e, this.f182765d);
                        }
                    });
                }
            });
        }
    }

    @Deprecated
    public void refreshRecentList(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, j3);
        }
    }

    public void refreshStatusBarUIByTheme() {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "refreshStatusBarUIByTheme");
        }
        this.mNickName.setTextColor(getResources().getColor(R.color.qui_common_text_nav_primary));
        this.mStatusInfo.setTextColor(getResources().getColor(R.color.qui_common_text_nav_primary));
        Drawable[] compoundDrawables = this.mStatusInfo.getCompoundDrawables();
        if (compoundDrawables != null && (drawable = compoundDrawables[2]) != null) {
            drawable.invalidateSelf();
        }
        updateTitleBar();
        removeTitleBackground();
    }

    public void removeTitleBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
            return;
        }
        if (isShowHighImmersionBanner()) {
            clearStatusBarBg();
            this.mNickName.setTextColor(-1);
            this.mStatusInfo.setTextColor(-1);
            this.mFrameHelperActivity.rj("isShowingTabBanner");
            QUIImmersiveHelper.u(getActivity().getWindow(), true, false);
            setOpenSessionAndQQCircleColor(-1);
        } else if (!this.mIsImmersionBannerExisted) {
            recoverOpenSessionAndQQCircleColor();
        } else {
            setOpenSessionAndQQCircleColor(this.mImmersionBannerTxtColor);
        }
        ImageView imageView = this.hbEntryIcon;
        if (imageView != null && imageView.getVisibility() == 0) {
            updateLeftAreaRightMargin();
        }
    }

    public void sendEmptyMessageDelayedToHandler(int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            this.handler.removeMessages(i3);
        }
        this.handler.sendEmptyMessageDelayed(i3, j3);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void setActivity(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) qBaseActivity);
        } else {
            this.mNtMainChatsFrame.S(qBaseActivity);
            super.setActivity(qBaseActivity);
        }
    }

    public void setStatusInfoGuideBg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mStatusInfoGuide == null) {
            return;
        }
        String currentThemeId = ThemeUtil.getCurrentThemeId();
        if (!"2971".equals(currentThemeId) && !"2921".equals(currentThemeId) && !"2105".equals(currentThemeId)) {
            this.mStatusInfoGuide.setBackgroundResource(R.drawable.jjw);
        } else {
            this.mStatusInfoGuide.setBackgroundResource(R.drawable.jjy);
        }
    }

    public void setThemeDiyBgConversation() {
        DrawerFrame drawerFrame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "setThemeDiyBgConversation ");
        }
        if (ThemeUtil.isNowThemeIsSuperTheme()) {
            FrameHelperActivity frameHelperActivity = this.mFrameHelperActivity;
            if (frameHelperActivity != null && (drawerFrame = frameHelperActivity.E) != null && drawerFrame.q()) {
                DragFrameLayout dragFrameLayout = this.mDragHost;
                if (dragFrameLayout != null) {
                    dragFrameLayout.setAlpha(0.0f);
                }
                ThemeVideoController.getInstance().playDrawerAnimation();
                return;
            }
            DragFrameLayout dragFrameLayout2 = this.mDragHost;
            if (dragFrameLayout2 != null) {
                dragFrameLayout2.setAlpha(1.0f);
            }
            ThemeVideoController.getInstance().playMainAnimation();
            return;
        }
        if (!MainResourceConfig.r()) {
            ThemeBackground.applyThemeBg(this.app, this.mListViewBackground, 1, R.drawable.qui_common_bg_primary_bg, "-conversation-");
        }
    }

    public void showDialogView(String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, str4, str5, str6);
            return;
        }
        boolean isSettingMeViewBackground = ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).isSettingMeViewBackground();
        boolean G0 = this.chatListPart.mChatsVB.G0();
        if (isSettingMeViewBackground && !G0) {
            showPopUpDialog(str, str2, str3, str4, str5, str6);
        } else {
            QLog.d("Q.recent", 1, "showDialogView isSettingBackground and isListInBackground ", Boolean.valueOf(isSettingMeViewBackground), Boolean.valueOf(G0));
        }
    }

    public void showPopUpDialog(String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4, str5, str6);
            return;
        }
        QLog.i("Q.recent", 1, "showPopUpDialog start ----" + str + str5 + str6);
        this.chatListPart.mChatsVM.r();
        DialogUtil.createCustomDialog(this.mRootView.getContext(), 230, str, str2, str3, str5, new j(str6), new k(str4)).show();
        QLog.i("Q.recent", 1, "showPopUpDialog show ----");
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) observable, obj);
        } else {
            updateForQCallFacade(observable, obj);
        }
    }

    protected void updateAccountInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "updateAccountInfo" + z16);
        }
        addObservers(false);
        if (z16) {
            com.tencent.mobileqq.managers.b.b().j();
            if (this.isInited) {
                this.mRefreshHandler.sendEmptyMessage(12);
            }
            if (!com.tencent.mobileqq.util.af.i()) {
                this.mFrameHelperActivity.mUiHandler.sendEmptyMessage(4);
            }
            sendEmptyMessageDelayedToHandler(1035, 100L, false);
            BannerManager bannerManager = this.mBannerMang;
            if (bannerManager != null) {
                bannerManager.F(PushBannerProcessor.f185251i, 2000, 100L, true);
                u uVar = this.mUICallBack;
                if (uVar != null) {
                    uVar.l();
                }
            }
            MiniAppPullInterface miniAppPullInterface = this.miniAppPullInterface;
            if (miniAppPullInterface != null) {
                miniAppPullInterface.onAccountChanged();
            }
            updatePlusRedTouch();
            updateNickName("accountChange");
            bm bmVar = this.mTitleEntranceCtrlManager;
            if (bmVar != null) {
                bmVar.d();
            }
            removeNetErrorCallback();
            ConvNetState.b().d();
            Object obj = this.mNtMainChatsFrame;
            if (obj instanceof IAccountCallback) {
                ((IAccountCallback) obj).onAccountChanged(this.app);
            }
            this.springApi.onAccountChanged();
        }
        sendEmptyMessageDelayedToHandler(10001, 300L, false);
        getApp().getConversationFacade().m0(this.registerProxyListenerWrapper);
        getApp().getConversationFacade().f(this.registerProxyListenerWrapper);
        ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).clearOldPublicAccountData(getApp().getCurrentAccountUin());
        if (MsgBackupManager.R) {
            MsgBackupManager.x().F(getApp());
        }
        if (z16) {
            refreshSelfOnlineInfoFromServer();
        }
        addModeChangedCallback();
        ((IMiniGameReport) QRoute.api(IMiniGameReport.class)).accountUpdateReport(getApp());
    }

    public void updateListViewBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.Conversation.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Conversation.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(Conversation.this.resConfig.k(Conversation.this.getActivity())) { // from class: com.tencent.mobileqq.activity.home.Conversation.6.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ Drawable f182761d;

                            {
                                this.f182761d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    Conversation.this.mListViewBackground.setBackground(this.f182761d);
                                }
                            }
                        });
                    }
                }
            }, 32, null, true);
        }
    }

    protected void updateLoadingState(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "updateLoadingState, showLoadingCircle = " + z16);
        }
        if (this.mUseNewLoadingTip) {
            updateLeftAreaRightMargin();
            return;
        }
        View findViewById = this.mRootView.findViewById(R.id.loading);
        if (findViewById != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
        if (!z16) {
            this.mFrameHelperActivity.rj("LoadingComplete");
        }
        updateNickName();
    }

    public void updatePlusRedTouch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this);
        } else {
            this.handler.obtainMessage(1048).sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.unread.b
    public void updateUnread(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, i3);
        } else {
            this.mUnReadCount = i3;
        }
    }

    void refreshNetStatus(int i3, boolean z16, boolean z17) {
        BannerManager bannerManager;
        if (!z16) {
            stopLoadingState();
        }
        MqqHandler handler = getApp().getHandler(AVNotifyCenter.class);
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(10010);
            obtainMessage.obj = Boolean.valueOf(z16);
            handler.sendMessage(obtainMessage);
        }
        if (getApp().isMSFConnect() && (bannerManager = this.mBannerMang) != null) {
            bannerManager.O(NetNeedSignOnBannerProcessor.f185235d, 0, null);
        }
        boolean z18 = !z16;
        com.tencent.mobileqq.managers.b.b().l(z18);
        boolean e16 = com.tencent.mobileqq.managers.b.b().e();
        if (e16 && i3 == 1134012) {
            e16 = false;
        }
        com.tencent.mobileqq.managers.b.b().m(e16);
        if (!z18 && !e16) {
            ConvNetState.b().e(false);
            hideNetStateBanner();
            ConvNetState.b().f(false);
            onNetConnect();
        } else if (!ConvNetState.b().c()) {
            ConvNetState.b().e(true);
            getUIHandler().postDelayed(this.netErrorTipShowRunnable, 6000L);
            onNetDisconnected();
        }
        int i16 = (z18 || e16) ? 0 : 1;
        QLog.i("Q.recent", 1, "refreshNetStatus event=" + i16 + ", initLoadingHandle=" + z17 + ", bShowErrorNetBar=" + z18 + ", bShowIllegalNetBar=" + e16);
        MsgRefreshTipMgr.f().k(i16);
        changeConversationLoadingState(z18 || e16 || z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNickName(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.home.f
            @Override // java.lang.Runnable
            public final void run() {
                Conversation.this.lambda$updateNickName$13(str);
            }
        }, 16, null, true);
    }

    private void updateNickName(final String str, @android.support.annotation.NonNull final String str2) {
        QLog.i("Q.recent", 1, "[updateNickName] from=" + str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            lambda$updateNickName$14(str, str2);
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.home.g
                @Override // java.lang.Runnable
                public final void run() {
                    Conversation.this.lambda$updateNickName$14(str, str2);
                }
            });
        }
    }

    void test() {
    }
}
