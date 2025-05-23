package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountSettingFragment;
import com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper;
import com.tencent.biz.pubaccount.accountdetail.activity.PubAccountMoreInfoActivity;
import com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountObserverImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileImageAvatar;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.cf;
import com.tencent.mobileqq.activity.em;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.applets.c;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.guild.api.GuildPublicAccountParams;
import com.tencent.mobileqq.guild.api.IGuildDiscoverApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$UnFollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$UnFollowResponse;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgCenterSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgDetailSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqnews.api.IQQNewsCommApi;
import com.tencent.mobileqq.qqshop.api.IQQShopApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.utils.z;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.utils.cc;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.api.IVasReadPublicAccount;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.z1.mod.api.IZPlanPublicAccountLauncherApi;
import com.tencent.open.base.MD5Utils;
import com.tencent.pb.oac.OACProfilePb$ProfileDataRsp;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import cooperation.qqfav.QfavUtil;
import ff0.a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.NewIntent;
import mqq.app.api.ProcessConstant;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$RspBody;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse;

/* loaded from: classes32.dex */
public class PublicAccountDetailActivityImpl extends BaseActivity implements View.OnClickListener, AccountDetailXListView.b, IPublicAccountDetailActivity {
    public static final int ARTICLE_ID = 111;
    static final String ATTENTION_ACTION_FOR_REPORT_FROM_OTHER_APP = "0X8005B6D";
    protected static final int BOTTON_ITEM = 2;
    public static final int BUSY_FLODER = 108;
    public static final int BUSY_SERRCH = 109;
    public static final String DOMAIN_MP_ARTICLE = "article.mp.qq.com";
    public static final String DOMAIN_MP_FIND = "find.mp.qq.com";
    public static final String DOMAIN_MP_POST = "post.mp.qq.com";
    static final int DP_STATUS_BAR_HEIGHT = 27;
    public static final int DP_TITLE_BAR_HEIGHT = 64;
    public static final int FOLLOWED = 1;
    public static final String FROM_BROWSER = "fromBrowser";
    public static final String IS_USE_STYLE_839 = "is_use_style_839";
    protected static final int MIDDLE_ITEM = 3;
    static final int MSG_HD_FACE_UPDATE = 3;
    static final int MSG_REPORT = 4;
    protected static final int MSG_REQUEST_UPDATE = 1;
    static final int MSG_TOPFOL = 5;
    protected static final int MSG_UNFOLLOW_UPDATE = 2;
    public static int NETWORK_ERROR = -1;
    public static int NETWORK_UNKNOW = 0;
    public static int NO_MORE_DATA = 1;
    protected static final int SINGLE_ITEM = 0;
    public static final int SOURCE_CENTRE = 104;
    public static final int SOURCE_MULTIVIDEO = 114;
    public static final int SOURCE_QR = 1;
    public static final int SOURCE_WEISHI_VIDEO_FEEDS = 120;
    protected static final int SPECIAL_BOTTON_ITEM = 5;
    protected static final int SPECIAL_TOP_ITEM = 4;
    public static final int SUBSCRIPTION_FLODER = 105;
    public static final int SUBSCRIPTION_GUESS = 106;
    public static final String TAG = "com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity";
    public static final String TAG_TROOP = "AccountDetailActivity.bindTroop";
    protected static final int TOP_ITEM = 1;
    protected static final int UIN_TYPE = 1008;
    static final String UN_ATTENTION_ACTION_FOR_REPORT_FROM_OTHER_APP = "0X8005B6E";
    private com.tencent.biz.pubaccount.a accountMoreDetailController;
    protected QQAppInterface app;
    protected View bottomContainer;
    protected View btnsDivider1;
    View btnsDivider2;
    View btnsDivider3;
    protected View callBtn;
    public String cuin;
    protected float density;
    protected NewIntent detailIntent;
    protected BusinessObserver detailObserver;
    private ViewGroup detailRootView;
    long enterTime;
    LinearLayout errorContainer;
    protected View followBtn;
    protected NewIntent followIntent;
    protected BusinessObserver followObserver;
    mobileqq_mp$GetPublicAccountDetailInfoResponse gAccountData;
    public ImageView iconCertifiedTop;
    public ImageView iconCicleTop;
    public ImageView iconTop;
    private boolean isClickingWSFollow;
    protected boolean isFirst;
    long leaveTime;
    protected AccountDetailXListView mAccountDetailListView;
    private float mDensity;
    q mFaceObserver;
    protected Intent mIntent;
    protected ProfileParams mProfileParams;
    QQProgressDialog mProgress;
    private MqqHandler mQQUiHandler;
    protected String mSendMessage;
    protected ff0.a mShareActionSheet;
    com.tencent.biz.widgets.e mShareAttentionSuccessDlg;
    protected ShareActionSheet mShareDialogBuilder;
    protected AccountDetailTopGestureLayout mTopGestureLayout;
    protected String mTypeMessage;
    r model;
    com.tencent.mobileqq.applets.c newFollowObserver;
    com.tencent.mobileqq.applets.c newUnFollowObserver;
    JSONObject postData;
    protected PublicAccountHandlerImpl publicAccountHandler;
    PublicAccountObserverImpl publicAccountObserver;
    protected ImageView rightViewImg;
    TextView rightViewText;
    Button searchBtn;
    protected Button sendMsgBtn;
    protected String shareUrl;
    public String sopName;
    public String sopType;
    ImageView titleLeftIcon;
    public RelativeLayout titleViewLayout;
    Button topFollowed;
    protected String uin;
    boolean unFollowActionSheetHasClick;
    protected Button unfollowBtn;
    NewIntent unfollowIntent;
    BusinessObserver unfollowObserver;
    public int weatherOutsideFollowState;
    public String weatherShareUrl;
    PublicAccountDetailImpl accountDetail = null;
    protected AccountDetailBaseAdapter mAccountDetailAdapter = null;
    protected boolean isShowGroupList = false;
    protected boolean mIsSendMessage = false;
    protected boolean mIsReportMessage = false;
    ActionSheet actionSheet = null;
    ActionSheet unFollowActionSheet = null;
    protected int waitingCount = 0;
    protected boolean needUpdateView = false;
    int screenHeight = 0;
    int titleHeight = 0;
    int bottomHeight = 0;
    boolean isDestroy = false;
    protected int fromwhere = 0;
    boolean mShouldNotStayAtThisApp = true;
    boolean mIsChangedFromOutSide = true;
    public boolean isNewSubscriptAIOUser = false;
    boolean isSubscriptAccount = false;
    int mSource = 0;
    boolean isGetPanelHeight = false;
    private boolean isFromBrowser = false;
    protected int errorStatus = NETWORK_UNKNOW;
    private boolean hasReport2 = false;
    boolean fromJS = false;
    private boolean isUseStyleAfter839 = false;
    boolean isDownCancel = false;
    boolean isFirstDataComplate = false;
    protected Handler mHandler = new g();
    Drawable bigFace = null;
    boolean hdFaceLoaded = false;
    private ShareActionSheet.OnItemClickListener itemClickListener = new m();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b extends IPublicAccountCommonMrg.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f79043b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f79044c;

        b(int i3, String str) {
            this.f79043b = i3;
            this.f79044c = str;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
        public void b(int i3, boolean z16) {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).setTop(com.tencent.mobileqq.qcall.g.e(PublicAccountDetailActivityImpl.this.accountDetail.getUin()), PublicAccountDetailActivityImpl.this.accountDetail.uid, !z16, null);
            ((IEcshopReportApi) QRoute.api(IEcshopReportApi.class)).reportSetTopOrCancleSetTop(this.f79043b, this.f79044c, !z16);
            if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(PublicAccountDetailActivityImpl.this.uin)) {
                if (z16) {
                    ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportProfilePageCancelSetTop(PublicAccountDetailActivityImpl.this.app);
                } else {
                    ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportProfilePageSetTop(PublicAccountDetailActivityImpl.this.app);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PublicAccountDetailActivityImpl.this.unFollowActionSheetHasClick = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements ActionSheet.OnButtonClickListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit b(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportUnFollowInProfilePageActionSheet(PublicAccountDetailActivityImpl.this.app, qCirclePublicAccountMessageInfo);
            return null;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            if (publicAccountDetailActivityImpl.unFollowActionSheetHasClick) {
                return;
            }
            publicAccountDetailActivityImpl.unFollowActionSheetHasClick = true;
            if (i3 == 0) {
                publicAccountDetailActivityImpl.mIsChangedFromOutSide = false;
                publicAccountDetailActivityImpl.unfollow();
                if (((EcShopAssistantManager) PublicAccountDetailActivityImpl.this.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).o(PublicAccountDetailActivityImpl.this.uin)) {
                    ((EcshopReportHandler) PublicAccountDetailActivityImpl.this.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).H2(134243868, PublicAccountDetailActivityImpl.this.uin, null, null, null, 2L, false);
                }
                com.tencent.mobileqq.activity.aio.l.f179531g = false;
                if (AppConstants.VALUE.UIN_QZONE.equals(PublicAccountDetailActivityImpl.this.uin)) {
                    ReportController.o(PublicAccountDetailActivityImpl.this.app, "CliOper", "", "", "0X80090E7", "0X80090E7", 0, 0, "", "", "", "");
                } else if (TextUtils.equals(String.valueOf(AppConstants.WEISHI_UIN_LONGVALUE), PublicAccountDetailActivityImpl.this.uin)) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800929F", "0X800929F", 0, 0, "", "", "", ((IVideoReporter) QRoute.api(IVideoReporter.class)).videoReportBaseR5(null), false);
                } else if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(PublicAccountDetailActivityImpl.this.uin)) {
                    ((IQCirclePublicAccountMessageService) PublicAccountDetailActivityImpl.this.app.getRuntimeService(IQCirclePublicAccountMessageService.class)).fetchLastMessageInfo(new Function1() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit b16;
                            b16 = PublicAccountDetailActivityImpl.d.this.b((QCirclePublicAccountMessageInfo) obj);
                            return b16;
                        }
                    });
                }
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                PublicAccountDetailImpl publicAccountDetailImpl = publicAccountDetailActivityImpl2.accountDetail;
                if (publicAccountDetailImpl != null) {
                    str = publicAccountDetailImpl.name;
                } else {
                    str = "";
                }
                if (publicAccountDetailImpl != null) {
                    RecentPubAccHelper.m(publicAccountDetailActivityImpl2.app, publicAccountDetailActivityImpl2.uin, str);
                }
            }
            PublicAccountDetailActivityImpl.this.unFollowActionSheet.dismiss();
        }
    }

    /* loaded from: classes32.dex */
    class e extends IPublicAccountObserver.c {
        e() {
        }

        void a() {
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            if (publicAccountDetailActivityImpl.mIsChangedFromOutSide) {
                publicAccountDetailActivityImpl.initData();
            }
            PublicAccountDetailActivityImpl.this.mIsChangedFromOutSide = true;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onDynamicListGet(boolean z16, int i3) {
            zx.a aVar;
            super.onDynamicListGet(z16, i3);
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            if (publicAccountDetailActivityImpl.mAccountDetailAdapter == null) {
                return;
            }
            publicAccountDetailActivityImpl.isFirstDataComplate = true;
            if (i3 == 0 && (aVar = (zx.a) ((IPublicAccountDetailDynamicDataManagerService) publicAccountDetailActivityImpl.app.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(PublicAccountDetailActivityImpl.this.uin)) != null) {
                PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.e0(aVar.b(), aVar.f453624d);
                PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.c0(aVar.b());
            }
            if (z16) {
                r0 = PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.o() != 0;
                if (r0) {
                    PublicAccountDetailActivityImpl.this.resetFootView();
                }
                PublicAccountDetailActivityImpl.this.mAccountDetailListView.g0(r0);
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "onDynamicListGet: --hasMoreData=" + r0);
                }
            } else {
                PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.notifyDataSetChanged();
                PublicAccountDetailActivityImpl.this.mAccountDetailListView.h0();
            }
            if (i3 == 1) {
                PublicAccountDetailActivityImpl.this.errorStatus = PublicAccountDetailActivityImpl.NETWORK_ERROR;
            } else if (i3 == 4 || (i3 == 0 && !r0)) {
                PublicAccountDetailActivityImpl.this.errorStatus = PublicAccountDetailActivityImpl.NO_MORE_DATA;
            }
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
            publicAccountDetailActivityImpl2.mAccountDetailAdapter.O(publicAccountDetailActivityImpl2.errorStatus);
            PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.notifyDataSetChanged();
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean z16, String str) {
            super.onFollowPublicAccount(z16, str);
            a();
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUnfollowPublicAccount(int i3, Object obj) {
            super.onUnfollowPublicAccount(i3, obj);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements AccountDetailBaseAdapter.q {
        f() {
        }

        @Override // com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.q
        public void a() {
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            publicAccountDetailActivityImpl.startLoadMore(publicAccountDetailActivityImpl.mAccountDetailListView);
        }
    }

    /* loaded from: classes32.dex */
    class g extends Handler {
        g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                if (publicAccountDetailActivityImpl.isFirst) {
                    publicAccountDetailActivityImpl.updateViewInMain();
                    PublicAccountDetailActivityImpl.this.removeLoading();
                } else {
                    publicAccountDetailActivityImpl.updateViewInMain();
                }
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                publicAccountDetailActivityImpl2.reportSource2(publicAccountDetailActivityImpl2.getIntent());
                return;
            }
            if (i3 == 2) {
                Intent intent = new Intent();
                intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                PublicAccountDetailActivityImpl.this.setResult(-1, intent);
                PublicAccountDetailActivityImpl.this.finish();
                return;
            }
            if (i3 == 3) {
                PublicAccountDetailActivityImpl.this.setHDFace();
                return;
            }
            if (i3 != 4) {
                if (i3 != 5) {
                    return;
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500L);
                PublicAccountDetailActivityImpl.this.topFollowed.startAnimation(alphaAnimation);
                PublicAccountDetailActivityImpl.this.topFollowed.setVisibility(8);
                return;
            }
            Intent intent2 = new Intent(PublicAccountDetailActivityImpl.this.getActivity(), (Class<?>) QQBrowserActivity.class);
            intent2.putExtra("BSafeReportPost", true);
            try {
                JSONObject jSONObject = PublicAccountDetailActivityImpl.this.postData;
                if (jSONObject != null) {
                    intent2.putExtra("SafeReportData", jSONObject.toString().getBytes("utf-8"));
                }
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            intent2.putExtra("hide_more_buttonbutton", true);
            intent2.putExtra("ishiderefresh", true);
            intent2.putExtra("ishidebackforward", true);
            PublicAccountDetailActivityImpl.this.startActivity(intent2.putExtra("url", "https://jubao.mp.qq.com/mobile/reportAccount"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements PublicAccountStQWebServletWrapper.b<OACProfilePb$ProfileDataRsp> {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(OACProfilePb$ProfileDataRsp oACProfilePb$ProfileDataRsp) {
            IPublicAccountManager iPublicAccountManager = (IPublicAccountManager) QRoute.api(IPublicAccountManager.class);
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            iPublicAccountManager.savePublicAccountMenuSetting(publicAccountDetailActivityImpl.app, publicAccountDetailActivityImpl.uin, oACProfilePb$ProfileDataRsp.menu_rsp);
        }

        @Override // com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(int i3, boolean z16, final OACProfilePb$ProfileDataRsp oACProfilePb$ProfileDataRsp, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "success:" + String.valueOf(z16));
            }
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            int i16 = publicAccountDetailActivityImpl.waitingCount - 1;
            publicAccountDetailActivityImpl.waitingCount = i16;
            if (i16 == 0) {
                publicAccountDetailActivityImpl.removeLoading();
            }
            if (!z16) {
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                if (publicAccountDetailActivityImpl2.isFirst) {
                    AccountDetailBaseAdapter accountDetailBaseAdapter = publicAccountDetailActivityImpl2.mAccountDetailAdapter;
                    if (accountDetailBaseAdapter != null) {
                        accountDetailBaseAdapter.T(false);
                        PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.notifyDataSetChanged();
                        return;
                    } else {
                        publicAccountDetailActivityImpl2.displayToast(R.string.d6b);
                        return;
                    }
                }
                return;
            }
            PublicAccountDetailImpl publicAccountDetailImpl = new PublicAccountDetailImpl(oACProfilePb$ProfileDataRsp);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.o
                @Override // java.lang.Runnable
                public final void run() {
                    PublicAccountDetailActivityImpl.h.this.c(oACProfilePb$ProfileDataRsp);
                }
            }, 32, null, true);
            QQAppInterface qQAppInterface = PublicAccountDetailActivityImpl.this.app;
            if (qQAppInterface != null) {
                Object findPublicAccountInfoCache = ((IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(PublicAccountDetailActivityImpl.this.uin);
                if (findPublicAccountInfoCache instanceof PublicAccountInfo) {
                    publicAccountDetailImpl.certifiedGrade = (int) ((PublicAccountInfo) findPublicAccountInfoCache).certifiedGrade;
                }
            }
            PublicAccountDetailActivityImpl.this.updateDetailInfo(publicAccountDetailImpl, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements BusinessObserver {
        i() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            boolean convert0xcf8ToMobileMP;
            if (QLog.isColorLevel()) {
                QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "success:" + String.valueOf(z16));
            }
            if (!z16) {
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                if (publicAccountDetailActivityImpl.isFirst) {
                    AccountDetailBaseAdapter accountDetailBaseAdapter = publicAccountDetailActivityImpl.mAccountDetailAdapter;
                    if (accountDetailBaseAdapter != null) {
                        accountDetailBaseAdapter.T(false);
                        PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.notifyDataSetChanged();
                    } else {
                        publicAccountDetailActivityImpl.displayToast(R.string.d6b);
                    }
                }
            } else {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    int i16 = bundle.getInt("type", 0);
                    if (byteArray != null) {
                        mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
                        oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse oidb_cmd0xcf8_getpublicaccountdetailinforesponse = new oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse();
                        if (i16 == 0) {
                            mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(byteArray);
                            convert0xcf8ToMobileMP = true;
                        } else {
                            convert0xcf8ToMobileMP = PublicAccountUtilImpl.convert0xcf8ToMobileMP(byteArray, oidb_cmd0xcf8_getpublicaccountdetailinforesponse, mobileqq_mp_getpublicaccountdetailinforesponse);
                        }
                        if (convert0xcf8ToMobileMP) {
                            if (mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get() == 0) {
                                if (PublicAccountDetailActivityImpl.this.accountDetail != null && (!mobileqq_mp_getpublicaccountdetailinforesponse.seqno.has() || mobileqq_mp_getpublicaccountdetailinforesponse.seqno.get() == PublicAccountDetailActivityImpl.this.accountDetail.seqno)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "sendPublicAccountDetailInfoRequest: seqno is same, no need to update, seqno = " + PublicAccountDetailActivityImpl.this.accountDetail.seqno);
                                    }
                                    PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                                    if (publicAccountDetailActivityImpl2.mIsSendMessage && publicAccountDetailActivityImpl2.accountDetail.followType == 1) {
                                        publicAccountDetailActivityImpl2.gotoChatActivity();
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + mobileqq_mp_getpublicaccountdetailinforesponse.seqno.get());
                                }
                                PublicAccountDetailActivityImpl.this.gAccountData = mobileqq_mp_getpublicaccountdetailinforesponse;
                                PublicAccountDetailImpl publicAccountDetailImpl = new PublicAccountDetailImpl();
                                publicAccountDetailImpl.init(PublicAccountDetailActivityImpl.this.gAccountData);
                                if (PublicAccountUtilImpl.isShopOrServiceAccount(publicAccountDetailImpl)) {
                                    PublicAccountDetailActivityImpl.this.send839PublicAccountDetailInfoRequest();
                                } else {
                                    PublicAccountDetailActivityImpl publicAccountDetailActivityImpl3 = PublicAccountDetailActivityImpl.this;
                                    if (publicAccountDetailActivityImpl3.mIsSendMessage && publicAccountDetailImpl.followType == 1) {
                                        publicAccountDetailActivityImpl3.updateDetailInfo(publicAccountDetailImpl, false);
                                    } else {
                                        publicAccountDetailActivityImpl3.updateDetailInfo(publicAccountDetailImpl, true);
                                    }
                                }
                            } else {
                                PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                            }
                        } else {
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl4 = PublicAccountDetailActivityImpl.this;
                            if (publicAccountDetailActivityImpl4.isFirst) {
                                AccountDetailBaseAdapter accountDetailBaseAdapter2 = publicAccountDetailActivityImpl4.mAccountDetailAdapter;
                                if (accountDetailBaseAdapter2 != null) {
                                    accountDetailBaseAdapter2.T(false);
                                    PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.notifyDataSetChanged();
                                } else {
                                    publicAccountDetailActivityImpl4.displayToast(R.string.d6b);
                                }
                            }
                        }
                    } else {
                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl5 = PublicAccountDetailActivityImpl.this;
                        if (publicAccountDetailActivityImpl5.isFirst) {
                            AccountDetailBaseAdapter accountDetailBaseAdapter3 = publicAccountDetailActivityImpl5.mAccountDetailAdapter;
                            if (accountDetailBaseAdapter3 != null) {
                                accountDetailBaseAdapter3.T(false);
                                PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.notifyDataSetChanged();
                            } else {
                                publicAccountDetailActivityImpl5.displayToast(R.string.d6b);
                            }
                        }
                    }
                } catch (Exception e16) {
                    PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                    QLog.w(PublicAccountDetailActivityImpl.TAG, 4, e16.getMessage(), e16);
                }
            }
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl6 = PublicAccountDetailActivityImpl.this;
            int i17 = publicAccountDetailActivityImpl6.waitingCount - 1;
            publicAccountDetailActivityImpl6.waitingCount = i17;
            if (i17 == 0) {
                publicAccountDetailActivityImpl6.removeLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j implements ShareActionSheet.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f79053d;

        j(Activity activity) {
            this.f79053d = activity;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            String shareToFriends;
            int i3 = actionSheetItem.action;
            a.b shareDetail = PublicAccountDetailActivityImpl.this.getShareDetail();
            String a16 = shareDetail.a();
            int accountType = PublicAccountDetailActivityImpl.this.getAccountType();
            String shareUrl = PublicAccountDetailActivityImpl.this.getShareUrl();
            if (i3 != 2) {
                if (i3 == 3) {
                    shareToFriends = PublicAccountDetailActivityImpl.this.shareToQZone(shareDetail, a16, accountType, shareUrl, (BaseActivity) this.f79053d);
                } else if (i3 == 9 || i3 == 10) {
                    shareToFriends = PublicAccountDetailActivityImpl.this.shareToWX(i3, shareDetail, a16, accountType, shareUrl, (BaseActivity) this.f79053d);
                } else if (i3 == 72) {
                    shareToFriends = PublicAccountDetailActivityImpl.this.shareToSpecifiedFriend(actionSheetItem, shareDetail, a16, accountType, shareUrl, this.f79053d);
                } else if (i3 != 73) {
                    shareToFriends = null;
                }
                shareActionSheet.dismiss();
                PublicAccountDetailActivityImpl.this.reportShareDetail(shareToFriends, shareDetail);
            }
            shareToFriends = PublicAccountDetailActivityImpl.this.shareToFriends(shareDetail, a16, accountType, shareUrl, (BaseActivity) this.f79053d);
            shareActionSheet.dismiss();
            PublicAccountDetailActivityImpl.this.reportShareDetail(shareToFriends, shareDetail);
        }
    }

    /* loaded from: classes32.dex */
    class k implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f79055d;

        k(Dialog dialog) {
            this.f79055d = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Dialog dialog = this.f79055d;
            if (dialog == null || !dialog.isShowing() || this.f79055d.getWindow() == null) {
                return;
            }
            this.f79055d.dismiss();
        }
    }

    /* loaded from: classes32.dex */
    class l implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79057d;

        l(String str) {
            this.f79057d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublicAccountDetailActivityImpl.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f79057d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public class p {

        /* renamed from: a, reason: collision with root package name */
        private ActionSheet f79062a;

        /* renamed from: b, reason: collision with root package name */
        private List<Integer> f79063b = new ArrayList();

        public p(ActionSheet actionSheet) {
            this.f79062a = actionSheet;
        }

        private void c(int i3, int i16) {
            this.f79062a.addButton(i3, i16);
            this.f79063b.add(Integer.valueOf(i3));
        }

        private void i() {
            this.f79062a.setOnButtonClickListener(new a());
        }

        public void d() {
            this.f79062a.addButton(R.string.cancel);
            this.f79063b.add(Integer.valueOf(R.string.cancel));
        }

        public void f() {
            if (!PublicAccountDetailActivityImpl.this.needShowUnFollowBtnInActionSheet() || PublicAccountUtilImpl.getMessageSetting(PublicAccountDetailActivityImpl.this.accountDetail) == null) {
                return;
            }
            c(R.string.f1764931e, 5);
        }

        public void g() {
            if (PublicAccountDetailActivityImpl.this.needShowUnFollowBtnInActionSheet()) {
                c(R.string.d7k, 3);
            }
        }

        public ActionSheet h() {
            i();
            return this.f79062a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class a implements ActionSheet.OnButtonClickListener {
            a() {
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (i3 >= 0 && i3 < p.this.f79063b.size()) {
                    switch (((Integer) p.this.f79063b.get(i3)).intValue()) {
                        case R.string.d5_ /* 2131896084 */:
                        case R.string.d7_ /* 2131896160 */:
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                            publicAccountDetailActivityImpl.setOrCancelSetTop(publicAccountDetailActivityImpl.uin);
                            break;
                        case R.string.f1764931e /* 2131896159 */:
                            PublicAccountDetailActivityImpl.this.toSettingFragment();
                            break;
                        case R.string.d7c /* 2131896163 */:
                            PublicAccountDetailActivityImpl.this.share();
                            break;
                        case R.string.d7k /* 2131896180 */:
                            PublicAccountDetailActivityImpl.this.showUnFollowActionSheet();
                            break;
                    }
                    p.this.f79062a.dismiss();
                    return;
                }
                p.this.f79062a.dismiss();
            }
        }

        public void e(boolean z16) {
            if (z16) {
                c(R.string.d5_, 5);
            } else {
                c(R.string.d7_, 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public static class q extends com.tencent.mobileqq.avatar.observer.a {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<PublicAccountDetailActivityImpl> f79066d;

        public q(PublicAccountDetailActivityImpl publicAccountDetailActivityImpl) {
            this.f79066d = new WeakReference<>(publicAccountDetailActivityImpl);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = this.f79066d.get();
            if (publicAccountDetailActivityImpl != null && !publicAccountDetailActivityImpl.isDestroy && z16 && str.equals(publicAccountDetailActivityImpl.uin)) {
                publicAccountDetailActivityImpl.setHDFace();
            }
        }
    }

    /* loaded from: classes32.dex */
    public static class r {

        /* renamed from: a, reason: collision with root package name */
        s f79067a;

        /* renamed from: b, reason: collision with root package name */
        FriendProfileImageAvatar f79068b;

        /* renamed from: c, reason: collision with root package name */
        WeakReference<PublicAccountDetailActivityImpl> f79069c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class a extends AsyncTask<Void, Void, Void> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ cf.b f79070a;

            a(cf.b bVar) {
                this.f79070a = bVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                r.this.f79068b.j(this.f79070a);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r26) {
                r.this.f79068b.m(-1);
            }
        }

        public r(QQAppInterface qQAppInterface, PublicAccountDetailActivityImpl publicAccountDetailActivityImpl) {
            FriendProfileImageAvatar friendProfileImageAvatar = new FriendProfileImageAvatar(qQAppInterface);
            this.f79068b = friendProfileImageAvatar;
            friendProfileImageAvatar.f180634d = publicAccountDetailActivityImpl.uin;
            this.f79069c = new WeakReference<>(publicAccountDetailActivityImpl);
            this.f79067a = new s(publicAccountDetailActivityImpl);
        }

        public void a() {
            if (this.f79069c.get() != null) {
                this.f79068b.n(null);
                this.f79068b.d(this.f79069c.get());
            }
        }

        public void b() {
            cf.b bVar = new cf.b();
            bVar.f180645g = this.f79068b.f180634d;
            bVar.f180639a = null;
            if (this.f79069c.get() == null) {
                return;
            }
            this.f79068b.k(this.f79069c.get(), bVar);
            this.f79068b.n(this.f79067a);
            this.f79068b.l(this.f79069c.get());
            new a(bVar).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public static class s implements cf.a {

        /* renamed from: d, reason: collision with root package name */
        java.lang.ref.WeakReference<PublicAccountDetailActivityImpl> f79072d;

        public s(PublicAccountDetailActivityImpl publicAccountDetailActivityImpl) {
            this.f79072d = new java.lang.ref.WeakReference<>(publicAccountDetailActivityImpl);
        }

        @Override // com.tencent.mobileqq.activity.cf.a
        public void G0(cf.b bVar) {
            java.lang.ref.WeakReference<PublicAccountDetailActivityImpl> weakReference = this.f79072d;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f79072d.get().loadHDFace(bVar);
            this.f79072d.get().setHDFace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildAndShowActionSheet(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "ActionSheet showActionSheet");
        }
        p pVar = new p((ActionSheet) ActionSheetHelper.createDialog(this, null));
        if (isFollowed()) {
            if (!this.uin.equals("1770946116") && !CrmUtils.t(this.app, this.uin)) {
                ServiceAccountFolderNTManager serviceAccountFolderNTManager = ServiceAccountFolderNTManager.f79965a;
                if (serviceAccountFolderNTManager.k(this.accountDetail)) {
                    pVar.f();
                } else if (serviceAccountFolderNTManager.j(this.accountDetail) && z17) {
                    pVar.e(z16);
                    pVar.f();
                } else {
                    pVar.g();
                    pVar.f();
                }
            } else {
                pVar.g();
            }
        }
        pVar.d();
        ActionSheet h16 = pVar.h();
        this.actionSheet = h16;
        if (h16.isShowing()) {
            return;
        }
        this.actionSheet.show();
    }

    private List<ShareActionSheetBuilder.ActionSheetItem>[] getActionSheetItems() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        QidianManager.g(this, arrayList);
        ArrayList arrayList2 = new ArrayList();
        if (needShowUnFollowBtnInActionSheet()) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(30));
        }
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(31));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        if (needShowUnFollowBtnInActionSheet()) {
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(32));
        }
        return new ArrayList[]{arrayList, arrayList2};
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> getShareActionSheetOperations() {
        return new ArrayList();
    }

    private List<ShareActionSheetBuilder.ActionSheetItem> getShareActionSheetPaths() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return arrayList;
    }

    private void goToEcommerceMsgActivity(int i3) {
        if (i3 == EcommerceMsgDetailSource.MAIN_PAGE.getValue()) {
            doOnBackPressed();
        } else {
            ((IEcommerceMsgCenter) QRoute.api(IEcommerceMsgCenter.class)).launchMainPage(this.app, this, EcommerceMsgCenterSource.PUBLIC_ACCOUNT_PROFILE_PAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoMiniGamePublicAccountActivity() {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoNowQQLiveActivity() {
        qb2.b.e(this, this.uin, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoQQSportAfterFollow() {
        ((IQQHealthService) this.app.getRuntimeService(IQQHealthService.class)).redirectAIOToMainPage(this, 161);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoWeiShiAfterFollow() {
        if (this.isClickingWSFollow) {
            ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(this, "from_account_detail", true);
            this.isClickingWSFollow = false;
        }
    }

    private boolean isNoTransparentTitleBar() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$showUnFollowActionSheet$1(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
        ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportProfilePageUnfollowClick(this.app, qCirclePublicAccountMessageInfo);
        return null;
    }

    public static void setDatatongElement(Object obj, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("target_qq", str2);
            hashMap.put(GdtGetUserInfoHandler.KEY_AREA, "2");
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0P000B1E6X38P6V3");
            VideoReport.setElementParams(obj, hashMap);
            VideoReport.setElementId(obj, str);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 2, "setDatatongElement", e16);
        }
    }

    private void setDatongParam() {
        try {
            VideoReport.addToDetectionWhitelist(this);
            VideoReport.setPageId(this, "gzh_pg_profile");
            HashMap hashMap = new HashMap();
            hashMap.put(MiniAppPlugin.ATTR_PAGE_TYPE, "2");
            hashMap.put("target_qq", this.uin);
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0P000B1E6X38P6V3");
            VideoReport.setPageParams(this, new PageParams(hashMap));
            setDatatongElement(this.sendMsgBtn, "gzh_ele_enter_aio", this.uin);
            setDatatongElement(this.followBtn, "gzh_ele_follow", this.uin);
            setDatatongElement(this.unfollowBtn, "gzh_ele_unfollow", this.uin);
            setDatatongElement(this.rightViewImg, "gzh_ele_three_dot", this.uin);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 2, "setDatongParam", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrCancelSetTop(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "ActionSheet setOrCancelSetTop");
        }
        int uinType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getUinType(this.app, this.uin);
        if (uinType == 1024) {
            QLog.d(TAG, 1, "setOrCancelTop pUin = " + str + " userType = " + uinType + " is UIN_TYPE_BUSINESS_CMR_TMP");
        }
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null && !TextUtils.isEmpty(publicAccountDetailImpl.uid)) {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).getTopState(this.accountDetail.uid, new b(uinType, str));
        } else {
            QLog.e(TAG, 1, "setOrCancelSetTop detail or uid null!!!");
        }
    }

    private void setShareActionSheetOnClickListener(ShareActionSheet shareActionSheet, Activity activity) {
        shareActionSheet.setItemClickListenerV2(new j(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String shareToFriends(a.b bVar, String str, int i3, String str2, BaseActivity baseActivity) {
        ff0.a.d(baseActivity, bVar, i3, str2);
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, str, "Grp_tribe", "interest_data", "share_qq");
        return HiAnalyticsConstant.KeyAndValue.NUMBER_01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String shareToQZone(a.b bVar, String str, int i3, String str2, BaseActivity baseActivity) {
        ff0.a.f(baseActivity, bVar, i3, str2);
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, str, "Grp_tribe", "interest_data", "share_qzone");
        return "02";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String shareToSpecifiedFriend(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, a.b bVar, String str, int i3, String str2, Activity activity) {
        ff0.a.g(activity, bVar, i3, str2, actionSheetItem);
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, str, "Grp_tribe", "interest_data", "share_qq");
        return HiAnalyticsConstant.KeyAndValue.NUMBER_01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toSettingFragment() {
        Integer messageSetting;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "ActionSheet toSettingFragment");
        }
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl == null || (messageSetting = PublicAccountUtilImpl.getMessageSetting(publicAccountDetailImpl)) == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("uin", this.uin);
        intent.putExtra("name", this.accountDetail.name);
        intent.putExtra(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, messageSetting);
        QPublicFragmentActivity.start(getActivity(), intent, AccountSettingFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewInMain() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mQQUiHandler.post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.18
                @Override // java.lang.Runnable
                public void run() {
                    PublicAccountDetailActivityImpl.this.updateView();
                }
            });
        } else {
            updateView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void delayShowLoading(final int i3) {
        this.followBtn.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.2
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                if (publicAccountDetailActivityImpl.waitingCount > 0) {
                    publicAccountDetailActivityImpl.showLoading(i3);
                }
            }
        }, 500L);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 2 || action == 3) && this.isDownCancel) {
                this.isDownCancel = false;
                return true;
            }
        } else if (this.needUpdateView) {
            this.isDownCancel = true;
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void displayToast(int i3) {
        QQToast.makeText(getApplicationContext(), i3, 0).show();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        boolean z16 = this.mProfileParams != null;
        boolean z17 = this.mShouldNotStayAtThisApp;
        boolean z18 = !z17;
        if (z16 && z17) {
            moveTaskToBack(true);
        } else if (z16 && z18 && super.isTaskRoot()) {
            super.startActivity(SplashActivity.getAliasIntent(this));
        }
        if (!isFollowed()) {
            reportEventIfFromOtherApp(UN_ATTENTION_ACTION_FOR_REPORT_FROM_OTHER_APP);
        }
        if (getIntent().getBooleanExtra("from_newer_guide", false)) {
            Intent intent = new Intent();
            intent.putExtra("has_operation", isFollowed());
            intent.putExtra("uin", this.uin);
            setResult(-1, intent);
        }
        AccountDetailBaseAdapter accountDetailBaseAdapter = this.mAccountDetailAdapter;
        if (accountDetailBaseAdapter != null && accountDetailBaseAdapter.m() != null) {
            this.mAccountDetailAdapter.m().c();
        }
        super.doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        String str;
        super.doOnDestroy();
        super.removeObserver(this.publicAccountObserver);
        super.removeObserver(this.newFollowObserver);
        super.removeObserver(this.newUnFollowObserver);
        super.removeObserver(this.mFaceObserver);
        long currentTimeMillis = System.currentTimeMillis();
        this.leaveTime = currentTimeMillis;
        long j3 = (currentTimeMillis - this.enterTime) / 1000;
        IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
        String str2 = this.uin;
        String str3 = j3 + "";
        if (isFollowed()) {
            str = "02";
        } else {
            str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
        }
        iPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007800", "0X8007800", 0, 0, str3, "", str, String.valueOf(PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), false);
        AccountDetailBaseAdapter accountDetailBaseAdapter = this.mAccountDetailAdapter;
        if (accountDetailBaseAdapter != null && accountDetailBaseAdapter.m() != null) {
            this.mAccountDetailAdapter.m().c();
        }
        ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).setKeepOldPublicAccountData(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        this.bigFace = null;
        this.mIntent = intent;
        init(intent);
        if (this.uin != null) {
            initData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        this.mShouldNotStayAtThisApp = false;
        QQProgressDialog qQProgressDialog = this.mProgress;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        this.mProgress = null;
        AccountDetailBaseAdapter accountDetailBaseAdapter = this.mAccountDetailAdapter;
        if (accountDetailBaseAdapter != null && accountDetailBaseAdapter.m() != null) {
            this.mAccountDetailAdapter.m().a();
        }
        AbstractGifImage.pauseAll();
    }

    void firstFetch() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "firstFetch");
        }
        sendDetailInfoRequest();
        updateViewInMain();
    }

    protected void follow() {
        cc.a(null, "pubAcc_follow_confirm", this.uin);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "follow uin=" + this.uin);
        }
        this.needUpdateView = true;
        this.followBtn.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.7
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountDetailActivityImpl.this.needUpdateView = false;
            }
        }, 3000L);
        delayShowLoading(R.string.d5n);
        if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag) == -4) {
            NewIntent newIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
            this.followIntent = newIntent;
            newIntent.putExtra("cmd", "follow");
            mobileqq_mp$FollowRequest mobileqq_mp_followrequest = new mobileqq_mp$FollowRequest();
            mobileqq_mp_followrequest.ext.set("1");
            mobileqq_mp_followrequest.uin.set((int) Long.parseLong(this.uin));
            mobileqq_mp_followrequest.account_type.set(getAccountType());
            this.followIntent.putExtra("data", mobileqq_mp_followrequest.toByteArray());
            this.followIntent.putExtra("source", 1);
            BusinessObserver businessObserver = new BusinessObserver() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.8
                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i3, boolean z16, Bundle bundle) {
                    QQAppInterface qQAppInterface;
                    QQAppInterface qQAppInterface2;
                    String str;
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "follow isSuccess:" + String.valueOf(z16));
                    }
                    if (!z16) {
                        PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        PublicAccountDetailImpl publicAccountDetailImpl = PublicAccountDetailActivityImpl.this.accountDetail;
                        if (publicAccountDetailImpl != null) {
                            try {
                                jSONObject.put("uin", publicAccountDetailImpl.uin);
                                jSONObject.put("name", PublicAccountDetailActivityImpl.this.accountDetail.name);
                                jSONObject.put("summary", PublicAccountDetailActivityImpl.this.accountDetail.summary);
                                jSONObject.put("certified", PublicAccountDetailActivityImpl.this.accountDetail.certifiedGrade);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                                com.tencent.mobileqq.jsp.h.w("follow", jSONObject, arrayList, null);
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        }
                        try {
                            if (z16) {
                                byte[] byteArray = bundle.getByteArray("data");
                                if (byteArray != null) {
                                    mobileqq_mp$FollowResponse mobileqq_mp_followresponse = new mobileqq_mp$FollowResponse();
                                    mobileqq_mp_followresponse.mergeFrom(byteArray);
                                    int i16 = mobileqq_mp_followresponse.ret_info.get().ret_code.get();
                                    if (i16 == 0) {
                                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                                        String str2 = "";
                                        if (publicAccountDetailActivityImpl.mIsReportMessage) {
                                            PublicAccountDetailImpl publicAccountDetailImpl2 = publicAccountDetailActivityImpl.accountDetail;
                                            if (publicAccountDetailImpl2 == null) {
                                                str = "";
                                            } else {
                                                str = publicAccountDetailImpl2.uin;
                                            }
                                            ReportController.o(publicAccountDetailActivityImpl.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, publicAccountDetailActivityImpl.uin, "mp_msg_sys_12", "scan_via", 0, 0, str, "", "", publicAccountDetailActivityImpl.mSendMessage);
                                        }
                                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                                        PublicAccountDetailImpl publicAccountDetailImpl3 = publicAccountDetailActivityImpl2.accountDetail;
                                        if (publicAccountDetailImpl3 != null) {
                                            publicAccountDetailImpl3.followType = 1;
                                        }
                                        publicAccountDetailActivityImpl2.followBtn.setEnabled(false);
                                        PublicAccountDetailActivityImpl.this.setFollowStatus();
                                        PublicAccountDetailActivityImpl.this.updateFollowInfo();
                                        PublicAccountDetailActivityImpl.this.showAttentionSuccessDlgIfJumpFromOtherApp();
                                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl3 = PublicAccountDetailActivityImpl.this;
                                        PublicAccountDetailActivityImpl.reportEvents(publicAccountDetailActivityImpl3.app, publicAccountDetailActivityImpl3.uin, publicAccountDetailActivityImpl3.mIntent);
                                        if (!TextUtils.isEmpty(PublicAccountDetailActivityImpl.this.sopType) && !TextUtils.isEmpty(PublicAccountDetailActivityImpl.this.sopName)) {
                                            QQAppInterface qQAppInterface3 = PublicAccountDetailActivityImpl.this.app;
                                            if (qQAppInterface3 != null) {
                                                str2 = qQAppInterface3.getCurrentAccountUin();
                                            }
                                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl4 = PublicAccountDetailActivityImpl.this;
                                            ReportController.o(publicAccountDetailActivityImpl4.app, "CliOper", "", "", publicAccountDetailActivityImpl4.sopType, publicAccountDetailActivityImpl4.sopName, 0, 0, "", "", str2, publicAccountDetailActivityImpl4.uin);
                                            if (QLog.isColorLevel()) {
                                                QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "----[follow report done]----");
                                            }
                                        }
                                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl5 = PublicAccountDetailActivityImpl.this;
                                        if (publicAccountDetailActivityImpl5.mSource == 115 && (qQAppInterface2 = publicAccountDetailActivityImpl5.app) != null) {
                                            ((EcshopReportHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).H2(134247140, PublicAccountDetailActivityImpl.this.uin, null, null, null, 0L, false);
                                        }
                                        if (PublicAccountDetailActivityImpl.this.mIntent.hasExtra(IPublicAccountDetailActivity.REPORT_BUSINESS_TVALUE)) {
                                            int intExtra = PublicAccountDetailActivityImpl.this.mIntent.getIntExtra(IPublicAccountDetailActivity.REPORT_BUSINESS_TVALUE, -1);
                                            String stringExtra = PublicAccountDetailActivityImpl.this.mIntent.getStringExtra("strp1");
                                            if (intExtra != -1 && (qQAppInterface = PublicAccountDetailActivityImpl.this.app) != null) {
                                                ((EcshopReportHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).H2(intExtra, PublicAccountDetailActivityImpl.this.uin, stringExtra, null, null, 0L, false);
                                            }
                                        }
                                    } else if (i16 == 58) {
                                        PublicAccountDetailActivityImpl.this.displayToast(R.string.d69);
                                    } else if (i16 == 65) {
                                        PublicAccountDetailActivityImpl.this.displayToast(R.string.d5i);
                                    } else {
                                        PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                                    }
                                }
                            } else {
                                PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    PublicAccountDetailActivityImpl publicAccountDetailActivityImpl6 = PublicAccountDetailActivityImpl.this;
                    int i17 = publicAccountDetailActivityImpl6.waitingCount - 1;
                    publicAccountDetailActivityImpl6.waitingCount = i17;
                    if (i17 == 0) {
                        publicAccountDetailActivityImpl6.removeLoading();
                    }
                    PublicAccountDetailActivityImpl.this.followBtn.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PublicAccountDetailActivityImpl.this.needUpdateView = false;
                        }
                    }, 2000L);
                }
            };
            this.followObserver = businessObserver;
            this.followIntent.setObserver(businessObserver);
            this.app.startServlet(this.followIntent);
        } else {
            this.isClickingWSFollow = true;
            this.app.removeObserver(this.newFollowObserver);
            com.tencent.mobileqq.applets.c cVar = new com.tencent.mobileqq.applets.c(new c.a() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.9
                @Override // com.tencent.mobileqq.applets.c.a
                public void a(boolean z16, Object obj) {
                    PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                    int i3 = publicAccountDetailActivityImpl.waitingCount - 1;
                    publicAccountDetailActivityImpl.waitingCount = i3;
                    if (i3 == 0) {
                        publicAccountDetailActivityImpl.removeLoading();
                    }
                    PublicAccountDetailActivityImpl.this.followBtn.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PublicAccountDetailActivityImpl.this.needUpdateView = false;
                        }
                    }, 1000L);
                }

                @Override // com.tencent.mobileqq.applets.c.a
                public void c(Object obj) {
                    PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                }

                @Override // com.tencent.mobileqq.applets.c.a
                public int e() {
                    return 4;
                }

                @Override // com.tencent.mobileqq.applets.c.a
                public void d(Object obj) {
                    QQAppInterface qQAppInterface;
                    QQAppInterface qQAppInterface2;
                    String str;
                    if (obj instanceof oidb_cmd0xc96$RspBody) {
                        oidb_cmd0xc96$RspBody oidb_cmd0xc96_rspbody = (oidb_cmd0xc96$RspBody) obj;
                        if (QLog.isColorLevel()) {
                            QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "0xc96 responseBody success, wording=", oidb_cmd0xc96_rspbody.wording.get());
                        }
                        JSONObject jSONObject = new JSONObject();
                        PublicAccountDetailImpl publicAccountDetailImpl = PublicAccountDetailActivityImpl.this.accountDetail;
                        if (publicAccountDetailImpl != null) {
                            try {
                                jSONObject.put("uin", publicAccountDetailImpl.uin);
                                jSONObject.put("name", PublicAccountDetailActivityImpl.this.accountDetail.name);
                                jSONObject.put("summary", PublicAccountDetailActivityImpl.this.accountDetail.summary);
                                jSONObject.put("certified", PublicAccountDetailActivityImpl.this.accountDetail.certifiedGrade);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                                com.tencent.mobileqq.jsp.h.w("follow", jSONObject, arrayList, null);
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        }
                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                        String str2 = "";
                        if (publicAccountDetailActivityImpl.mIsReportMessage) {
                            PublicAccountDetailImpl publicAccountDetailImpl2 = publicAccountDetailActivityImpl.accountDetail;
                            if (publicAccountDetailImpl2 == null) {
                                str = "";
                            } else {
                                str = publicAccountDetailImpl2.uin;
                            }
                            ReportController.o(publicAccountDetailActivityImpl.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, publicAccountDetailActivityImpl.uin, "mp_msg_sys_12", "scan_via", 0, 0, str, "", "", publicAccountDetailActivityImpl.mSendMessage);
                        }
                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                        PublicAccountDetailImpl publicAccountDetailImpl3 = publicAccountDetailActivityImpl2.accountDetail;
                        if (publicAccountDetailImpl3 != null) {
                            publicAccountDetailImpl3.followType = 1;
                        }
                        publicAccountDetailActivityImpl2.followBtn.setEnabled(false);
                        PublicAccountDetailActivityImpl.this.setFollowStatus();
                        PublicAccountDetailActivityImpl.this.updateFollowInfo();
                        PublicAccountDetailActivityImpl.this.showAttentionSuccessDlgIfJumpFromOtherApp();
                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl3 = PublicAccountDetailActivityImpl.this;
                        PublicAccountDetailActivityImpl.reportEvents(publicAccountDetailActivityImpl3.app, publicAccountDetailActivityImpl3.uin, publicAccountDetailActivityImpl3.mIntent);
                        if (!TextUtils.isEmpty(PublicAccountDetailActivityImpl.this.sopType) && !TextUtils.isEmpty(PublicAccountDetailActivityImpl.this.sopName)) {
                            QQAppInterface qQAppInterface3 = PublicAccountDetailActivityImpl.this.app;
                            if (qQAppInterface3 != null) {
                                str2 = qQAppInterface3.getCurrentAccountUin();
                            }
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl4 = PublicAccountDetailActivityImpl.this;
                            ReportController.o(publicAccountDetailActivityImpl4.app, "CliOper", "", "", publicAccountDetailActivityImpl4.sopType, publicAccountDetailActivityImpl4.sopName, 0, 0, "", "", str2, publicAccountDetailActivityImpl4.uin);
                            if (QLog.isColorLevel()) {
                                QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "----[follow report done]----");
                            }
                        }
                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl5 = PublicAccountDetailActivityImpl.this;
                        if (publicAccountDetailActivityImpl5.mSource == 115 && (qQAppInterface2 = publicAccountDetailActivityImpl5.app) != null) {
                            ((EcshopReportHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).H2(134247140, PublicAccountDetailActivityImpl.this.uin, null, null, null, 0L, false);
                        }
                        if (PublicAccountDetailActivityImpl.this.mIntent.hasExtra(IPublicAccountDetailActivity.REPORT_BUSINESS_TVALUE)) {
                            int intExtra = PublicAccountDetailActivityImpl.this.mIntent.getIntExtra(IPublicAccountDetailActivity.REPORT_BUSINESS_TVALUE, -1);
                            String stringExtra = PublicAccountDetailActivityImpl.this.mIntent.getStringExtra("strp1");
                            if (intExtra == -1 || (qQAppInterface = PublicAccountDetailActivityImpl.this.app) == null) {
                                return;
                            }
                            ((EcshopReportHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).H2(intExtra, PublicAccountDetailActivityImpl.this.uin, stringExtra, null, null, 0L, false);
                        }
                    }
                }

                @Override // com.tencent.mobileqq.applets.c.a
                public void b(boolean z16, Object obj) {
                }
            });
            this.newFollowObserver = cVar;
            this.app.addObserver(cVar);
            com.tencent.mobileqq.applets.e.c(this.app, true, this.accountDetail.uin, 1);
        }
        this.waitingCount++;
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.app, this.uin, 1);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "follow exit");
        }
        if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(this.uin)) {
            ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportProfilePageFollowClick(this.app);
        }
    }

    protected String getAccountName() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            return publicAccountDetailImpl.name;
        }
        return "";
    }

    protected int getAccountType() {
        return 1;
    }

    Drawable getBackgroundForMainPanel() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl == null) {
            return null;
        }
        if (!TextUtils.isEmpty(publicAccountDetailImpl.configBackgroundImg)) {
            return URLDrawable.getDrawable(this.accountDetail.configBackgroundImg);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.21
            @Override // java.lang.Runnable
            public void run() {
                final Drawable gaussianBlurPic;
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                Bitmap faceBitmap = publicAccountDetailActivityImpl.app.getFaceBitmap(115, publicAccountDetailActivityImpl.uin, (byte) 1, true, 0);
                if (faceBitmap == null || (gaussianBlurPic = PublicAccountDetailActivityImpl.this.getGaussianBlurPic(faceBitmap)) == null) {
                    return;
                }
                PublicAccountDetailActivityImpl.super.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.U(gaussianBlurPic);
                        PublicAccountDetailActivityImpl.this.mAccountDetailAdapter.notifyDataSetChanged();
                    }
                });
            }
        }, 10L);
        return null;
    }

    protected int getCertifiedGrade() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            return publicAccountDetailImpl.certifiedGrade;
        }
        return 0;
    }

    public int getContainerListviewHeight() {
        return ((this.screenHeight - this.titleHeight) - this.bottomHeight) - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getFace() {
        Drawable drawable = this.bigFace;
        if (drawable != null) {
            return drawable;
        }
        File file = new File(FaceUtil.getHDAvatarPath(this.uin));
        if (file.isFile()) {
            loadHDFace(file.getAbsolutePath());
            return FaceDrawable.getFaceDrawable(this.app, 115, this.uin);
        }
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.app, 115, this.uin);
        if (this.mFaceObserver == null) {
            q qVar = new q(this);
            this.mFaceObserver = qVar;
            addObserver(qVar);
        }
        return faceDrawable;
    }

    Drawable getImageForMainPanel() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl == null) {
            return null;
        }
        if (TextUtils.isEmpty(publicAccountDetailImpl.configBackgroundColor)) {
            this.accountDetail.configBackgroundColor = "3d7fe3";
        }
        try {
            return new ColorDrawable(Color.parseColor("#E6" + this.accountDetail.configBackgroundColor.substring(0, 6)));
        } catch (StringIndexOutOfBoundsException unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "configBackgroundColor length is not 6!");
            }
            return null;
        }
    }

    public JSONObject getMessageList(BaseActivity baseActivity, String str) {
        ArrayList arrayList;
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        int i3;
        try {
            List<MessageRecord> E = baseActivity.app.getMessageFacade().E(str, 0, new int[]{-1000, -2000, -2002, MessageRecord.MSG_TYPE_STRUCT_MSG, MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO}, 40);
            arrayList = new ArrayList();
            if (E != null) {
                for (int size = E.size(); size > 0; size--) {
                    int i16 = size - 1;
                    if (E.get(i16).issend == 0) {
                        arrayList.add(E.get(i16));
                        if (arrayList.size() > 4) {
                            break;
                        }
                    }
                }
            }
            jSONObject = new JSONObject();
            jSONArray = new JSONArray();
            jSONObject2 = new JSONObject();
            jSONObject3 = new JSONObject();
        } catch (Exception unused) {
        }
        try {
            String account = this.app.getAccount();
            jSONObject3.put("qq", account);
            String valueOf = String.valueOf(NetConnInfoCenter.getServerTime());
            jSONObject3.put("mpUin", str);
            jSONObject3.put("timestamp", "" + valueOf);
            jSONObject3.put("scene", ThemeReporter.FROM_DIY);
            jSONObject3.put("subAppname", "profile");
            jSONObject3.put("sign", MD5Utils.encodeHexStr(account + str + 201 + valueOf + "jubao@article@123").toLowerCase());
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                MessageRecord messageRecord = (MessageRecord) arrayList.get(i17);
                if (messageRecord instanceof MessageForText) {
                    jSONObject5.put("text", messageRecord.f203106msg);
                    i3 = 1;
                } else if (messageRecord instanceof MessageForPic) {
                    jSONObject5.put("fileUuid", ((MessageForPic) messageRecord).uuid);
                    i3 = 2;
                } else if (messageRecord instanceof MessageForPtt) {
                    jSONObject5.put("fileUuid", ((MessageForPtt) messageRecord).urlAtServer);
                    jSONObject5.put(TagName.FILE_TYPE, ((MessageForPtt) messageRecord).busiType);
                    i3 = 3;
                } else if (messageRecord instanceof MessageForShortVideo) {
                    jSONObject5.put("fileUuid", ((MessageForShortVideo) messageRecord).uuid.substring(1));
                    i3 = 4;
                } else if (messageRecord instanceof MessageForStructing) {
                    jSONObject5.put("text", new String(com.tencent.mobileqq.structmsg.k.i(QfavUtil.g(com.tencent.mobileqq.structmsg.i.d(messageRecord.msgData).getXmlBytes()), 0), "utf-8"));
                    i3 = 5;
                } else {
                    i3 = 0;
                }
                jSONObject4.put("content", jSONObject5);
                jSONObject4.put("messageType", "" + i3);
                jSONArray.put(i17, jSONObject4);
            }
            jSONObject.put("msgNum", "" + arrayList.size());
            jSONObject.put("messageList", PluginBaseInfoHelper.Base64Helper.encodeToString(jSONArray.toString().getBytes("utf-8"), 0));
            jSONObject2.put("Verify", jSONObject3);
            jSONObject2.put("reportData", jSONObject);
            return jSONObject2;
        } catch (Exception unused2) {
            return null;
        }
    }

    Bitmap getMidBitmap(Bitmap bitmap) {
        int i3;
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int i16 = (int) (this.density * 140.0f);
        int height = bitmap.getHeight();
        int width2 = bitmap.getWidth();
        int i17 = width2 * i16;
        int i18 = height * width;
        int i19 = 0;
        if (i17 > i18) {
            int i26 = i18 / i16;
            i3 = 0;
            i19 = (width2 - i26) / 2;
            width2 = i26;
        } else {
            int i27 = i17 / width;
            i3 = (height - i27) / 2;
            height = i27;
        }
        return Bitmap.createBitmap(bitmap, i19, i3, width2, height);
    }

    public PublicAccountObserverImpl getPublicAccountObserver() {
        return this.publicAccountObserver;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    protected a.b getShareDetail() {
        if (this.accountDetail == null) {
            return null;
        }
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        a.b bVar = new a.b(publicAccountDetailImpl.uin, publicAccountDetailImpl.name, publicAccountDetailImpl.summary);
        bVar.f398556d = a.b.f398552h;
        bVar.f398557e = isFollowed();
        bVar.f398558f = PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail);
        return bVar;
    }

    public String getShareUrl() {
        if (this.shareUrl == null) {
            int accountType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag);
            if (accountType != -2 && accountType != -5) {
                this.shareUrl = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.uin;
            } else {
                this.shareUrl = "https://share.mp.qq.com/cgi/share.php?uin=" + this.uin + "&account_flag=" + this.accountDetail.accountFlag + "&jumptype=1&card_type=public_account";
            }
        }
        return this.shareUrl;
    }

    protected void gotoChatActivity() {
        if (this.accountDetail != null) {
            if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(this.uin)) {
                ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(this.uin, this.accountDetail.uid);
            }
            open(this.uin, 1008, this.accountDetail.name, ChatActivity.class);
        }
    }

    protected void gotoGameMallActivity() {
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startGameMallPubAccount(this, 0);
    }

    public void gotoMoreInfoActivity() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "ActionSheet gotoMoreInfoActivity");
        }
        Intent intent = new Intent(getActivity(), (Class<?>) PubAccountMoreInfoActivity.class);
        intent.putExtra("uin", this.uin);
        startActivity(intent);
    }

    protected void gotoQQGameActivity() {
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(this, 0);
    }

    protected void gotoWeiShiFlowActivity() {
        if (this.mSource == 119) {
            doOnBackPressed();
        } else {
            ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(this, "from_account_detail", true);
        }
    }

    void init(Intent intent) {
        QQAppInterface qQAppInterface;
        ProfileParams profileParams;
        this.app = (QQAppInterface) super.getAppRuntime();
        Bundle extras = intent.getExtras();
        if (extras != null && (profileParams = (ProfileParams) extras.getParcelable("profile_params")) != null) {
            this.mProfileParams = profileParams;
        }
        this.uin = getUin(intent);
        this.isUseStyleAfter839 = this.mIntent.getBooleanExtra(IS_USE_STYLE_839, true);
        this.sopType = intent.getStringExtra(IPublicAccountDetailActivity.REPORT_SRC_PARAM_TYPE);
        this.sopName = intent.getStringExtra(IPublicAccountDetailActivity.REPORT_SRC_PARAM_NAME);
        this.weatherShareUrl = intent.getStringExtra(IPublicAccountDetailActivity.WEATHE_SHARE_URL);
        this.weatherOutsideFollowState = intent.getIntExtra(IPublicAccountDetailActivity.WEATHE_OUTSIDE_FOLLOW_STATE, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[sopType]:" + this.sopType + ",[sopName]:" + this.sopName + ",[weatherShareUrl]:" + this.weatherShareUrl + ",[weatherOutsideFollowState]:" + this.weatherOutsideFollowState);
        }
        this.mSendMessage = intent.getStringExtra("extvalue");
        this.mTypeMessage = intent.getStringExtra("exttype");
        if (!TextUtils.isEmpty(this.mSendMessage)) {
            if ("2".equals(this.mTypeMessage)) {
                this.mIsSendMessage = true;
            } else if ("1".equals(this.mTypeMessage)) {
                this.mIsReportMessage = true;
            }
        }
        if (this.uin == null || (qQAppInterface = this.app) == null) {
            return;
        }
        this.cuin = qQAppInterface.getCurrentUin();
        this.publicAccountHandler = (PublicAccountHandlerImpl) this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
        initView();
        updateHDFace();
        reportSource(intent);
        this.mDensity = getResources().getDisplayMetrics().density;
    }

    void initData() {
        if (loadCache()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initData hasCache");
            }
            this.isFirst = false;
            updateViewInMain();
            sendDetailInfoRequest();
            return;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.14
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "initData loadDatabase");
                }
                PublicAccountDetailActivityImpl.this.isFirst = !r0.loadDatabase();
                PublicAccountDetailActivityImpl.super.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                        if (!publicAccountDetailActivityImpl.isFirst) {
                            publicAccountDetailActivityImpl.updateViewInMain();
                            PublicAccountDetailActivityImpl.this.sendDetailInfoRequest();
                        } else {
                            publicAccountDetailActivityImpl.firstFetch();
                        }
                    }
                });
            }
        });
    }

    void initView() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initView");
        }
        super.setContentView(R.layout.c4k);
        this.density = super.getResources().getDisplayMetrics().density;
        super.findViewById(R.id.f163874ay).setBackground(getDrawable(R.drawable.qui_common_bg_bottom_standard_bg));
        initTitleView();
        initBottomContainer();
        initAccountDetailListView();
        this.errorContainer = (LinearLayout) super.findViewById(R.id.by9);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f163878s84);
        this.detailRootView = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublicAccountDetailActivityImpl.lambda$initView$0(view);
            }
        });
        this.accountMoreDetailController = new com.tencent.biz.pubaccount.a(this, this, this.detailRootView);
    }

    protected boolean isFollowed() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        return (publicAccountDetailImpl != null ? publicAccountDetailImpl.followType : -1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jumpWebView(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) PublicAccountBrowserImpl.class);
        if (this.app == null || TextUtils.isEmpty(this.uin) || TextUtils.isEmpty(this.app.getAccount())) {
            return;
        }
        String replace = str.replace("${puin}", this.uin).replace("${uin}", this.app.getAccount());
        intent.putExtra("uin", this.app.getCurrentAccountUin());
        intent.putExtra("url", replace);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "jumpWebView url=" + replace);
        }
        intent.putExtra(IPublicAccountBrowser.KEY_PUB_UIN, this.uin);
        intent.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(this.uin));
        String accountName = getAccountName();
        if (!TextUtils.isEmpty(accountName)) {
            intent.putExtra("source_name", accountName);
        }
        super.startActivity(intent);
    }

    protected boolean loadCache() {
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            this.accountDetail = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfoCache(this.uin);
            updateViewInMain();
        }
        if (this.accountDetail == null) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(TAG, 2, "loadCache = null");
            return false;
        }
        parseAccountDetail();
        return true;
    }

    protected boolean loadDatabase() {
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            this.accountDetail = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(this.uin);
            updateViewInMain();
        }
        if (this.accountDetail == null) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d(TAG, 2, "loadDatabase = null");
            return false;
        }
        parseAccountDetail();
        return true;
    }

    void loadHDFace(final String str) {
        if (this.hdFaceLoaded || this.bigFace != null) {
            return;
        }
        this.hdFaceLoaded = true;
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int c16 = x.c(PublicAccountDetailActivityImpl.this, 110.0f);
                    Bitmap decodeScaledBitmap = BaseImageUtil.decodeScaledBitmap(str, c16, c16);
                    PublicAccountDetailActivityImpl.this.bigFace = new BitmapDrawable(BaseImageUtil.getRoundFaceBitmap(decodeScaledBitmap, c16, c16));
                    PublicAccountDetailActivityImpl.this.mHandler.sendEmptyMessage(3);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountDetailActivityImpl.TAG, 2, e16.toString());
                    }
                    e16.printStackTrace();
                }
            }
        });
    }

    protected boolean needShowQQCall() {
        return false;
    }

    protected boolean needShowUnFollowBtnInActionSheet() {
        return isFollowed() && this.accountDetail.isShowFollowButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        if (this.detailRootView.getVisibility() != 8) {
            this.detailRootView.setVisibility(8);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("menu");
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestroy = true;
        QQProgressDialog qQProgressDialog = this.mProgress;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        this.mProgress = null;
        q qVar = this.mFaceObserver;
        if (qVar != null) {
            this.app.removeObserver(qVar);
            this.mFaceObserver = null;
        }
        NewIntent newIntent = this.detailIntent;
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
        NewIntent newIntent2 = this.unfollowIntent;
        if (newIntent2 != null) {
            newIntent2.setObserver(null);
        }
        NewIntent newIntent3 = this.followIntent;
        if (newIntent3 != null) {
            newIntent3.setObserver(null);
        }
        r rVar = this.model;
        if (rVar != null) {
            rVar.a();
        }
        com.tencent.biz.widgets.e eVar = this.mShareAttentionSuccessDlg;
        if (eVar != null) {
            eVar.dismiss();
        }
        AccountDetailBaseAdapter accountDetailBaseAdapter = this.mAccountDetailAdapter;
        if (accountDetailBaseAdapter != null) {
            accountDetailBaseAdapter.destroy();
        }
        AccountDetailXListView accountDetailXListView = this.mAccountDetailListView;
        if (accountDetailXListView != null) {
            accountDetailXListView.c0();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i3, Menu menu) {
        return false;
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (isInMultiWindow()) {
            QQToast.makeText(this, getString(R.string.d6g), 0).show();
            finish();
            return;
        }
        AccountDetailBaseAdapter accountDetailBaseAdapter = this.mAccountDetailAdapter;
        if (accountDetailBaseAdapter != null && accountDetailBaseAdapter.m() != null) {
            this.mAccountDetailAdapter.m().d(true);
        }
        AbstractGifImage.resumeAll();
        xx.b.INSTANCE.o(this.uin);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            cc.a("pubAcc_profile_display", null, this.uin);
            this.isGetPanelHeight = true;
        } else {
            this.isGetPanelHeight = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void open(String str, int i3, String str2, Class<? extends Activity> cls) {
        open(str, i3, str2, cls, false);
    }

    protected void parseAccountDetail() {
        try {
            mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
            this.gAccountData = mobileqq_mp_getpublicaccountdetailinforesponse;
            mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(this.accountDetail.accountData);
            this.accountDetail.newGroupInfoList = this.gAccountData.config_group_info_new.get();
            if (this.gAccountData.unified_account_descrpition.has()) {
                this.accountDetail.unifiedDesrpition = this.gAccountData.unified_account_descrpition.get();
                this.accountDetail.parser();
            } else {
                this.accountDetail.seqno = 0;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeLoading() {
        QQProgressDialog qQProgressDialog = this.mProgress;
        if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
            return;
        }
        this.mProgress.dismiss();
    }

    void report() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "ActionSheet report");
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.12
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                publicAccountDetailActivityImpl.postData = publicAccountDetailActivityImpl.getMessageList(publicAccountDetailActivityImpl, publicAccountDetailActivityImpl.uin);
                PublicAccountDetailActivityImpl.this.mHandler.sendEmptyMessage(4);
            }
        });
        if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(this.uin)) {
            ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportProfilePageTipOffClick(this.app);
        }
    }

    void reportSource2(Intent intent) {
        String str;
        if (this.hasReport2 || this.accountDetail == null) {
            return;
        }
        this.hasReport2 = true;
        this.isFromBrowser = intent.getBooleanExtra(FROM_BROWSER, false);
        int intExtra = intent.getIntExtra("source", 0);
        this.mSource = intExtra;
        if (intExtra == 1) {
            this.fromwhere = 12;
        } else if (intExtra == 2) {
            this.fromwhere = 13;
        } else if (intExtra == 3) {
            this.fromwhere = 19;
        } else if (intExtra == 4) {
            this.fromwhere = 14;
        } else if (intExtra == 5) {
            this.fromwhere = 11;
        } else if (intExtra == 111) {
            this.fromwhere = 18;
        } else if (intExtra != 114) {
            switch (intExtra) {
                case 116:
                    this.fromwhere = 17;
                    break;
                case 117:
                    this.fromwhere = 15;
                    break;
                case 118:
                    this.fromwhere = 21;
                    break;
            }
        } else {
            this.fromwhere = 16;
        }
        if (this.isFromBrowser) {
            this.fromwhere = 20;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[fromwhere]:" + this.fromwhere);
        }
        QQAppInterface qQAppInterface = this.app;
        String str2 = this.uin;
        int i3 = this.fromwhere;
        if (isFollowed()) {
            str = "02";
        } else {
            str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
        }
        ReportController.o(qQAppInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, str2, "0X8007CA0", "0X8007CA0", i3, 0, str, String.valueOf(this.fromwhere), String.valueOf(PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "");
    }

    void resetFootView() {
        if (this.mAccountDetailAdapter.f78877l0) {
            this.mAccountDetailListView.setAdapter((ListAdapter) null);
            this.mAccountDetailListView.j0(true);
            this.mAccountDetailListView.setAdapter((ListAdapter) this.mAccountDetailAdapter);
        }
        this.mAccountDetailAdapter.f78877l0 = false;
    }

    protected void saveAccountDetailInSubThread() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.15
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                publicAccountDetailActivityImpl.saveAccountDetailToDBAndCache(publicAccountDetailActivityImpl.accountDetail);
            }
        }, 10L);
    }

    protected void saveDetailForStateChange(int i3, boolean z16) {
        this.accountDetail.accountData = this.gAccountData.toByteArray();
        if (i3 == 3) {
            PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
            publicAccountDetailImpl.isSyncLbs = true;
            publicAccountDetailImpl.isAgreeSyncLbs = z16;
        }
        saveAccountDetailInSubThread();
    }

    void send839PublicAccountDetailInfoRequest() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "send839PublicAccountDetailInfoRequest");
        }
        PublicAccountStQWebServletWrapper.getAccountDetail(Long.valueOf(Long.parseLong(this.uin)), "", new h());
    }

    protected void sendDetailInfoRequest() {
        sendPublicAccountDetailInfoRequest();
    }

    void sendPublicAccountDetailInfoRequest() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendPublicAccountDetailInfoRequest");
        }
        NewIntent newIntent = this.detailIntent;
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
        NewIntent newIntent2 = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
        this.detailIntent = newIntent2;
        newIntent2.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_DETAIL_INFO);
        mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
        mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        mobileqq_mp_getpublicaccountdetailinforequest.version.set(1);
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(publicAccountDetailImpl.seqno);
        } else {
            mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(0);
        }
        try {
            mobileqq_mp_getpublicaccountdetailinforequest.uin.set((int) Long.parseLong(this.uin));
        } catch (Exception unused) {
        }
        this.detailIntent.putExtra("data", mobileqq_mp_getpublicaccountdetailinforequest.toByteArray());
        i iVar = new i();
        this.detailObserver = iVar;
        this.detailIntent.setObserver(iVar);
        this.app.startServlet(this.detailIntent);
        this.waitingCount++;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendPublicAccountDetailInfoRequest exit");
        }
    }

    protected void setAccountData() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            publicAccountDetailImpl.accountData = this.gAccountData.toByteArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFollowStatus() {
        if (isFollowed()) {
            this.isShowGroupList = true;
        } else {
            this.isShowGroupList = false;
        }
    }

    public void setHDFace() {
        if (TextUtils.isEmpty(this.uin)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setHDFace uin is null");
            }
        } else if (this.mAccountDetailAdapter != null) {
            this.mAccountDetailAdapter.P(getFace());
            this.mAccountDetailAdapter.notifyDataSetChanged();
        }
    }

    void setInfoForAdapter() {
        this.mAccountDetailAdapter.U(getBackgroundForMainPanel());
        this.mAccountDetailAdapter.V(getImageForMainPanel());
        this.mAccountDetailAdapter.P(getFace());
        this.mAccountDetailAdapter.R(this.isSubscriptAccount);
        this.mAccountDetailAdapter.S(getContainerListviewHeight());
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            this.mAccountDetailAdapter.G(publicAccountDetailImpl);
        }
    }

    protected void setIsConfirmed(boolean z16) {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            publicAccountDetailImpl.isConfirmed = z16;
        }
    }

    protected void setShowMsgFlag(int i3) {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            publicAccountDetailImpl.mShowMsgFlag = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void share() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "share");
        }
        if (TextUtils.isEmpty(this.uin) || this.accountDetail == null) {
            return;
        }
        showNewShareActionSheet();
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, this.uin, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_10", "pbshare_click");
        if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(this.uin)) {
            ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportProfilePageShareClick(this.app);
        }
    }

    protected void showActionSheet() {
        if (this.accountDetail == null) {
            QLog.d(TAG, 1, "accountDetail == null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "accountDetail.uid:" + this.accountDetail.uid);
        }
        if (TextUtils.isEmpty(this.accountDetail.uid)) {
            QLog.d(TAG, 1, "accountDetail.uid is empty!");
            buildAndShowActionSheet(false, false);
        } else {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).getTopState(this.accountDetail.uid, new IPublicAccountCommonMrg.a() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.11
                @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
                public void b(final int i3, final boolean z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "onTopState resultCode:" + i3 + " isTop:" + z16);
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PublicAccountDetailActivityImpl.this.buildAndShowActionSheet(z16, i3 == 0);
                        }
                    });
                }
            });
        }
    }

    protected void showActionSheetSub() {
        ShareActionSheet shareActionSheet = this.mShareDialogBuilder;
        if (shareActionSheet == null) {
            ShareActionSheet create = ShareActionSheetFactory.create(this, false);
            this.mShareDialogBuilder = create;
            create.setActionSheetTitle(getString(R.string.hja));
            this.mShareDialogBuilder.setActionSheetItems(getActionSheetItems());
            this.mShareDialogBuilder.setItemClickListenerV2(this.itemClickListener);
        } else {
            shareActionSheet.setActionSheetItems(getActionSheetItems());
        }
        try {
            this.mShareDialogBuilder.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + e16);
            }
        }
    }

    void showAttentionSuccessDlg(Activity activity) {
        if (this.mShareAttentionSuccessDlg == null) {
            this.mShareAttentionSuccessDlg = new com.tencent.biz.widgets.e(activity);
        }
        this.mShareAttentionSuccessDlg.Q(HardCodeUtil.qqStr(R.string.j18));
        String str = this.app.getApplication().getString(R.string.hih) + HardCodeUtil.qqStr(R.string.j19);
        a aVar = new a(activity);
        this.mShareAttentionSuccessDlg.O(str, aVar);
        this.mShareAttentionSuccessDlg.P(aVar);
        this.mShareAttentionSuccessDlg.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showAttentionSuccessDlgIfJumpFromOtherApp() {
        if (this.mProfileParams != null) {
            showAttentionSuccessDlg(this);
        }
    }

    void showErrorTip() {
        this.searchBtn.setVisibility(0);
        this.errorContainer.setVisibility(0);
        this.titleViewLayout.setBackgroundColor(0);
        this.iconTop.setVisibility(8);
        this.iconCicleTop.setVisibility(8);
        this.mAccountDetailListView.setVisibility(8);
    }

    void showLoading(int i3) {
        QQProgressDialog qQProgressDialog = this.mProgress;
        if (qQProgressDialog != null) {
            qQProgressDialog.setMessage(i3);
            if (this.mProgress.isShowing()) {
                return;
            }
            this.mProgress.show();
        }
    }

    protected void showNewShareActionSheet() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "ActionSheet showNewShareActionSheet");
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = this;
        param.fullScreen = false;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        create.setIntentForStartForwardRecentActivity(getIntent());
        create.setActionSheetItems(getShareActionSheetPaths(), getShareActionSheetOperations());
        create.setRowVisibility(0, 0, 0);
        setShareActionSheetOnClickListener(create, this);
        getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh");
        create.show();
        create.refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showPhoneConfirm(String str) {
        Dialog dialog = new Dialog(this, R.style.qZoneInputDialog);
        dialog.setContentView(R.layout.atf);
        ((TextView) dialog.findViewById(R.id.bkh)).setVisibility(8);
        TextView textView = (TextView) dialog.findViewById(R.id.bk8);
        TextView textView2 = (TextView) dialog.findViewById(R.id.bk5);
        TextView textView3 = (TextView) dialog.findViewById(R.id.bka);
        textView.setText(str);
        textView.setGravity(3);
        textView2.setText(R.string.cancel);
        textView3.setText(R.string.ano);
        dialog.setCanceledOnTouchOutside(false);
        textView2.setOnClickListener(new k(dialog));
        textView3.setOnClickListener(new l(str));
        try {
            dialog.show();
        } catch (Exception unused) {
        }
    }

    void showUnFollowActionSheet() {
        if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(this.uin)) {
            ((IQCirclePublicAccountMessageService) this.app.getRuntimeService(IQCirclePublicAccountMessageService.class)).fetchLastMessageInfo(new Function1() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$showUnFollowActionSheet$1;
                    lambda$showUnFollowActionSheet$1 = PublicAccountDetailActivityImpl.this.lambda$showUnFollowActionSheet$1((QCirclePublicAccountMessageInfo) obj);
                    return lambda$showUnFollowActionSheet$1;
                }
            });
        }
        this.unFollowActionSheet = ActionSheet.create(this);
        this.unFollowActionSheet.setMainTitle(getString(R.string.d7m, getAccountName()));
        this.unFollowActionSheet.addButton(R.string.dz7, 3);
        this.unFollowActionSheet.addCancelButton(R.string.cancel);
        this.unFollowActionSheet.setOnDismissListener(new c());
        this.unFollowActionSheet.setOnButtonClickListener(new d());
        if (this.unFollowActionSheet.isShowing()) {
            return;
        }
        this.unFollowActionSheetHasClick = false;
        this.unFollowActionSheet.show();
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView.b
    public void startLoadMore(ListView listView) {
        if (this.isFirstDataComplate) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "startLoadMore: uin=" + this.uin);
            }
            com.tencent.biz.pubaccount.accountdetail.model.a.b(this.app, Long.parseLong(this.uin), this.publicAccountObserver);
        }
    }

    void startSearchActivity() {
        super.finish();
        em.c(this, "");
    }

    void unfollow() {
        if (AppConstants.KANDIAN_DAILY_UIN.equals(this.uin)) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009944", "0X8009944", 0, 0, "", "", "", new JSONObject().toString(), false);
        }
        cc.a(null, " pubAcc_follow_cancel", this.uin);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW);
        }
        delayShowLoading(R.string.d7l);
        if (this.accountDetail != null && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(this.accountDetail.accountFlag) != -4) {
            com.tencent.mobileqq.applets.c cVar = this.newUnFollowObserver;
            if (cVar != null) {
                this.app.removeObserver(cVar);
            }
            com.tencent.mobileqq.applets.c cVar2 = new com.tencent.mobileqq.applets.c(new o());
            this.newUnFollowObserver = cVar2;
            this.app.addObserver(cVar2);
            com.tencent.mobileqq.applets.e.c(this.app, false, this.accountDetail.uin, 1);
            this.waitingCount++;
        } else {
            NewIntent newIntent = this.unfollowIntent;
            if (newIntent != null) {
                newIntent.setObserver(null);
            }
            NewIntent newIntent2 = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
            this.unfollowIntent = newIntent2;
            newIntent2.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW);
            mobileqq_mp$UnFollowRequest mobileqq_mp_unfollowrequest = new mobileqq_mp$UnFollowRequest();
            mobileqq_mp_unfollowrequest.uin.set((int) Long.parseLong(this.uin));
            mobileqq_mp_unfollowrequest.account_type.set(getAccountType());
            this.unfollowIntent.putExtra("data", mobileqq_mp_unfollowrequest.toByteArray());
            this.unfollowIntent.putExtra("source", 1);
            n nVar = new n();
            this.unfollowObserver = nVar;
            this.unfollowIntent.setObserver(nVar);
            this.app.startServlet(this.unfollowIntent);
            this.waitingCount++;
        }
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.app, this.uin);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unfollow exit");
        }
    }

    void updateBottomContainer() {
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl == null || this.isSubscriptAccount) {
            return;
        }
        boolean z16 = publicAccountDetailImpl.isShowFollowButton;
        if (publicAccountDetailImpl.followType == 1) {
            if (!this.uin.equals("1770946116") && !CrmUtils.t(this.app, this.uin)) {
                this.sendMsgBtn.setVisibility(0);
                this.followBtn.setVisibility(8);
                this.btnsDivider3.setVisibility(0);
                this.unfollowBtn.setVisibility(0);
                this.bottomContainer.setVisibility(0);
            } else {
                this.sendMsgBtn.setVisibility(0);
                this.followBtn.setVisibility(8);
                this.bottomContainer.setVisibility(0);
            }
        } else {
            if (z16) {
                this.followBtn.setVisibility(0);
                this.followBtn.setOnClickListener(this);
            }
            this.sendMsgBtn.setVisibility(8);
            this.btnsDivider3.setVisibility(8);
            this.unfollowBtn.setVisibility(8);
            this.bottomContainer.setVisibility(0);
        }
        if (needShowQQCall()) {
            this.btnsDivider1.setVisibility(0);
            this.callBtn.setVisibility(0);
            this.callBtn.setOnClickListener(this);
        } else {
            this.btnsDivider1.setVisibility(8);
            this.callBtn.setVisibility(8);
        }
        if (this.sendMsgBtn.getVisibility() == 8 && this.followBtn.getVisibility() == 8) {
            this.bottomContainer.setVisibility(8);
        }
    }

    void updateDetailInfo(final PublicAccountDetailImpl publicAccountDetailImpl, final boolean z16) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.23
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "updateDetailInfo");
                }
                PublicAccountDetailActivityImpl.this.saveAccountDetailToDBAndCache(publicAccountDetailImpl);
                PublicAccountDetailImpl publicAccountDetailImpl2 = publicAccountDetailImpl;
                if (publicAccountDetailImpl2 != null && publicAccountDetailImpl2.followType == 1 && publicAccountDetailImpl2.isSyncLbs) {
                    PublicAccountDetailActivityImpl.this.publicAccountHandler.onFollowPublicAccount(publicAccountDetailImpl2);
                }
                if (PublicAccountDetailActivityImpl.this.tryGoToWeatherWhenGetInfo(publicAccountDetailImpl)) {
                    return;
                }
                if (!z16) {
                    PublicAccountDetailActivityImpl.super.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.23.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PublicAccountDetailActivityImpl.this.gotoChatActivity();
                        }
                    });
                } else {
                    PublicAccountDetailActivityImpl.this.mHandler.sendEmptyMessage(1);
                }
            }
        }, 10L);
    }

    protected void updateFollowInfo() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.6
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "updateFollowInfo");
                }
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                publicAccountDetailActivityImpl.saveAccountDetailToDBAndCache(publicAccountDetailActivityImpl.accountDetail);
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                publicAccountDetailActivityImpl2.publicAccountHandler.onFollowPublicAccount(publicAccountDetailActivityImpl2.accountDetail);
                PublicAccountDetailActivityImpl.this.sendDetailInfoRequest();
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl3 = PublicAccountDetailActivityImpl.this;
                final boolean z16 = publicAccountDetailActivityImpl3.mProfileParams == null;
                cc.a("pubAcc_follow_confirm", null, publicAccountDetailActivityImpl3.uin);
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl4 = PublicAccountDetailActivityImpl.this;
                if (publicAccountDetailActivityImpl4.tryGoToWeatherWhenFollow(publicAccountDetailActivityImpl4.accountDetail)) {
                    return;
                }
                if (PublicAccountDetailActivityImpl.this.accountDetail != null && ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(PublicAccountDetailActivityImpl.this.uin)) {
                    IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
                    PublicAccountDetailActivityImpl publicAccountDetailActivityImpl5 = PublicAccountDetailActivityImpl.this;
                    iRelationNTUinAndUidApi.saveUidByUin(publicAccountDetailActivityImpl5.uin, publicAccountDetailActivityImpl5.accountDetail.uid);
                }
                PublicAccountDetailActivityImpl.super.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PublicAccountDetailActivityImpl.this.updateBottomContainer();
                        if (TextUtils.equals(AppConstants.WEISHI_UIN, PublicAccountDetailActivityImpl.this.uin)) {
                            PublicAccountDetailActivityImpl.this.gotoWeiShiAfterFollow();
                            return;
                        }
                        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(PublicAccountDetailActivityImpl.this.uin)) {
                            PublicAccountDetailActivityImpl.this.gotoMiniGamePublicAccountActivity();
                            return;
                        }
                        if (TextUtils.equals(qb2.a.f428781a, PublicAccountDetailActivityImpl.this.uin)) {
                            PublicAccountDetailActivityImpl.this.gotoNowQQLiveActivity();
                            return;
                        }
                        if (((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).isWeatherPA(PublicAccountDetailActivityImpl.this.uin)) {
                            IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl6 = PublicAccountDetailActivityImpl.this;
                            if (iWeatherCommApi.startNewWeatherWebPageActivity(publicAccountDetailActivityImpl6, publicAccountDetailActivityImpl6.app)) {
                                return;
                            }
                        }
                        if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isNeedRedirectAIOToMainPage(PublicAccountDetailActivityImpl.this.uin)) {
                            PublicAccountDetailActivityImpl.this.gotoQQSportAfterFollow();
                            return;
                        }
                        if (TextUtils.equals(AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN, PublicAccountDetailActivityImpl.this.uin)) {
                            IQCirclePublicAccountLauncher iQCirclePublicAccountLauncher = (IQCirclePublicAccountLauncher) QRoute.api(IQCirclePublicAccountLauncher.class);
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl7 = PublicAccountDetailActivityImpl.this;
                            iQCirclePublicAccountLauncher.launchQCircleFromPublicAccount(publicAccountDetailActivityImpl7.app, publicAccountDetailActivityImpl7, QCirclePublicAccountLauncherSource.PUBLIC_ACCOUNT_PROFILE_PAGE);
                            return;
                        }
                        if (TextUtils.equals(AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN, PublicAccountDetailActivityImpl.this.uin)) {
                            IEcommerceMsgCenter iEcommerceMsgCenter = (IEcommerceMsgCenter) QRoute.api(IEcommerceMsgCenter.class);
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl8 = PublicAccountDetailActivityImpl.this;
                            iEcommerceMsgCenter.launchMainPage(publicAccountDetailActivityImpl8.app, publicAccountDetailActivityImpl8, EcommerceMsgCenterSource.PUBLIC_ACCOUNT_PROFILE_PAGE);
                            return;
                        }
                        if (IPublicAccountUtil.UIN_FOR_SHOP.equals(PublicAccountDetailActivityImpl.this.uin)) {
                            ((IEcshopUtilApi) QRoute.api(IEcshopUtilApi.class)).jump(PublicAccountDetailActivityImpl.this);
                            return;
                        }
                        IQQNewsCommApi iQQNewsCommApi = (IQQNewsCommApi) QRoute.api(IQQNewsCommApi.class);
                        PublicAccountDetailActivityImpl publicAccountDetailActivityImpl9 = PublicAccountDetailActivityImpl.this;
                        if (iQQNewsCommApi.startQQNewsPAIfMatched(publicAccountDetailActivityImpl9, publicAccountDetailActivityImpl9.uin)) {
                            return;
                        }
                        if (((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).isGuildPublicAccount(PublicAccountDetailActivityImpl.this.uin)) {
                            ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).openDiscoverFromPublicAccount(PublicAccountDetailActivityImpl.this, new GuildPublicAccountParams(5));
                            return;
                        }
                        if (TextUtils.equals(AppConstants.ZPLAN_MOD_SMALLHOME_PUBLIC_ACCOUNT_UIN, PublicAccountDetailActivityImpl.this.uin)) {
                            IZPlanPublicAccountLauncherApi iZPlanPublicAccountLauncherApi = (IZPlanPublicAccountLauncherApi) QRoute.api(IZPlanPublicAccountLauncherApi.class);
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl10 = PublicAccountDetailActivityImpl.this;
                            iZPlanPublicAccountLauncherApi.launchSmallHomeMainPageFromPublicAccount(publicAccountDetailActivityImpl10.app, publicAccountDetailActivityImpl10, "updateFollowInfo");
                        } else if (((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).isPAUin(PublicAccountDetailActivityImpl.this.uin)) {
                            IStrangerPublicAccountUtil iStrangerPublicAccountUtil = (IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class);
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl11 = PublicAccountDetailActivityImpl.this;
                            iStrangerPublicAccountUtil.jumpToPublicAccountPage(publicAccountDetailActivityImpl11, publicAccountDetailActivityImpl11.uin);
                        } else if (z16) {
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl12 = PublicAccountDetailActivityImpl.this;
                            if (publicAccountDetailActivityImpl12.isSubscriptAccount) {
                                return;
                            }
                            publicAccountDetailActivityImpl12.open(publicAccountDetailActivityImpl12.uin, 1008, publicAccountDetailActivityImpl12.accountDetail.name, ChatActivity.class, true);
                        }
                    }
                });
            }
        }, 10L);
    }

    protected void updateHDFace() {
        if (TextUtils.isEmpty(this.uin)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateHDFace uin is null");
            }
        } else if (!NetworkUtil.isWifiConnected(this)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateHDFace not wifi, so need't update");
            }
        } else {
            r rVar = new r(this.app, this);
            this.model = rVar;
            rVar.b();
        }
    }

    void updateListView() {
        if (this.mAccountDetailAdapter != null && this.mAccountDetailListView.getAdapter() != null && (this.accountDetail == null || this.mAccountDetailAdapter.n() != null)) {
            setInfoForAdapter();
            this.mAccountDetailAdapter.notifyDataSetChanged();
            return;
        }
        if (this.mAccountDetailListView.getAdapter() != null) {
            ((AccountDetailBaseAdapter) this.mAccountDetailListView.getAdapter()).destroy();
            this.mAccountDetailListView.setAdapter((ListAdapter) null);
        }
        AccountDetailBaseAdapter accountDetailBaseAdapter = new AccountDetailBaseAdapter(this.app, this, this.accountDetail, this.uin, this.isSubscriptAccount, this.mAccountDetailListView, this.mTopGestureLayout);
        this.mAccountDetailAdapter = accountDetailBaseAdapter;
        accountDetailBaseAdapter.X(this.iconTop, this.iconCicleTop, this.titleViewLayout, this.iconCertifiedTop, this.topFollowed);
        setInfoForAdapter();
        if (!this.isSubscriptAccount) {
            this.mAccountDetailListView.j0(false);
        }
        this.mAccountDetailAdapter.W(new f());
        this.mAccountDetailListView.setAdapter((ListAdapter) this.mAccountDetailAdapter);
    }

    void updateTopContainer() {
        if (this.accountDetail != null && this.isSubscriptAccount && isFollowed()) {
            this.topFollowed.setBackgroundDrawable(null);
            this.topFollowed.setText(R.string.d7i);
            this.topFollowed.setAlpha(0.5f);
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.19
                @Override // java.lang.Runnable
                public void run() {
                    PublicAccountDetailActivityImpl.this.mHandler.sendEmptyMessage(5);
                }
            }, 0L);
        }
    }

    protected void updateUnfollowInfo() {
        ThreadManager.getSubThreadHandler().postDelayed(new AnonymousClass3(), 10L);
    }

    protected void updateView() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, VasPerfReportUtils.WHILE_UPDATE_ITEM);
        }
        boolean isShopOrServiceAccount = PublicAccountUtilImpl.isShopOrServiceAccount(this.accountDetail);
        this.isUseStyleAfter839 = isShopOrServiceAccount;
        if (isShopOrServiceAccount) {
            this.mActNeedImmersive = true;
        } else {
            this.mActNeedImmersive = false;
        }
        SystemBarActivityModule.setImmersiveStatus(this);
        this.isSubscriptAccount = isSubscriptAccount(this.accountDetail);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSubscriptAccount = " + this.isSubscriptAccount);
        }
        if (this.isSubscriptAccount && !TextUtils.isEmpty(this.uin)) {
            com.tencent.biz.pubaccount.accountdetail.model.a.c(this.app, Long.parseLong(this.uin), this.publicAccountObserver);
        }
        mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = this.gAccountData;
        if (mobileqq_mp_getpublicaccountdetailinforesponse != null && mobileqq_mp_getpublicaccountdetailinforesponse.show_flag.has() && this.gAccountData.show_flag.get() == 2) {
            showErrorTip();
            return;
        }
        updateTopContainer();
        updateBottomContainer();
        updateListView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl$3, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, int i3, String str2) {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).deleteRecentContact4PA(str, (IOperateCallback) null);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "updateUnfollowInfo");
            }
            PublicAccountDetailImpl publicAccountDetailImpl = PublicAccountDetailActivityImpl.this.accountDetail;
            if (publicAccountDetailImpl == null) {
                QLog.e(PublicAccountDetailActivityImpl.TAG, 1, "accountDetail is null!!!!");
                return;
            }
            if (TextUtils.isEmpty(publicAccountDetailImpl.uid)) {
                QLog.e(PublicAccountDetailActivityImpl.TAG, 1, "invalid uin, uid: " + PublicAccountDetailActivityImpl.this.accountDetail.uid);
                return;
            }
            PublicAccountDetailActivityImpl.this.mHandler.sendEmptyMessage(2);
            final String str = PublicAccountDetailActivityImpl.this.accountDetail.uid;
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).setTop(com.tencent.mobileqq.qcall.g.c(PublicAccountDetailActivityImpl.this.accountDetail.uin), PublicAccountDetailActivityImpl.this.accountDetail.uid, false, new IOperateCallback() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.p
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    PublicAccountDetailActivityImpl.AnonymousClass3.b(str, i3, str2);
                }
            });
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).markRead4PA(PublicAccountDetailActivityImpl.this.accountDetail.uid, null);
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).clearMsgRecords4PA(PublicAccountDetailActivityImpl.this.accountDetail.uid, null);
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            publicAccountDetailActivityImpl.publicAccountHandler.onUnfollowPublicAccount(publicAccountDetailActivityImpl.accountDetail);
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
            publicAccountDetailActivityImpl2.deleteAccount(publicAccountDetailActivityImpl2.accountDetail);
            if (TextUtils.equals(PublicAccountDetailActivityImpl.this.uin, IPublicAccountUtil.UIN_FOR_SHOP)) {
                ((IQQShopApi) QRoute.api(IQQShopApi.class)).afterUnFollowQQShop(2);
            }
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl3 = PublicAccountDetailActivityImpl.this;
            QQAppInterface qQAppInterface = publicAccountDetailActivityImpl3.app;
            String str2 = publicAccountDetailActivityImpl3.uin;
            ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str2, "0X8004E43", "0X8004E43", 0, 0, str2, "", "", "");
            cc.a(" pubAcc_follow_cancel", null, PublicAccountDetailActivityImpl.this.uin);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class n implements BusinessObserver {
        n() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "unfollow isSuccess:" + String.valueOf(z16));
            }
            if (!z16) {
                PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
            } else {
                JSONObject jSONObject = new JSONObject();
                String str = PublicAccountDetailActivityImpl.this.uin;
                if (str != null) {
                    try {
                        jSONObject.put("uin", str);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                        com.tencent.mobileqq.jsp.h.w(IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW, jSONObject, arrayList, null);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
                try {
                    if (z16) {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            mobileqq_mp$UnFollowResponse mobileqq_mp_unfollowresponse = new mobileqq_mp$UnFollowResponse();
                            mobileqq_mp_unfollowresponse.mergeFrom(byteArray);
                            if (mobileqq_mp_unfollowresponse.ret_info.get().ret_code.get() == 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "unfollow success");
                                }
                                PublicAccountDetailActivityImpl.this.updateUnfollowInfo();
                                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                                iPublicAccountReportUtils.publicAccountReportClickEventForMigrate(publicAccountDetailActivityImpl.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, publicAccountDetailActivityImpl.uin, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
                                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                                StructLongMessageDownloadProcessor.deleteTask(publicAccountDetailActivityImpl2.app, publicAccountDetailActivityImpl2.uin);
                                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl3 = PublicAccountDetailActivityImpl.this;
                                if (publicAccountDetailActivityImpl3.accountDetail != null) {
                                    ((z) publicAccountDetailActivityImpl3.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).b(PublicAccountDetailActivityImpl.this.accountDetail.uin);
                                }
                            } else {
                                PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                            }
                        }
                    } else {
                        PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
                    }
                } catch (Exception unused) {
                }
            }
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl4 = PublicAccountDetailActivityImpl.this;
            int i16 = publicAccountDetailActivityImpl4.waitingCount - 1;
            publicAccountDetailActivityImpl4.waitingCount = i16;
            if (i16 == 0) {
                publicAccountDetailActivityImpl4.removeLoading();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = true;
        this.enterTime = System.currentTimeMillis();
        ca.a(this);
        super.doOnCreate(bundle);
        this.mQQUiHandler = new MqqHandler(Looper.getMainLooper());
        FlingHandler flingHandler = GestureActivityModule.getFlingHandler(this);
        if (flingHandler != null && (flingHandler instanceof FlingGestureHandler)) {
            AccountDetailTopGestureLayout accountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
            this.mTopGestureLayout = accountDetailTopGestureLayout;
            ((FlingGestureHandler) flingHandler).setTopLayout(accountDetailTopGestureLayout);
        }
        Intent intent = getIntent();
        this.mIntent = intent;
        init(intent);
        if (this.uin != null) {
            if (getClass().equals(PublicAccountDetailActivityImpl.class) && (CrmUtils.t(this.app, this.uin) || QidianManager.P(this.app, this.uin))) {
                Intent intent2 = this.mIntent;
                CrmUtils.n(this, intent2, intent2.getStringExtra("uin"), this.mIntent.getBooleanExtra(IPublicAccountUtil.NEED_FINISH, false), this.mIntent.getIntExtra("source", -1), true, -1);
                finish();
                return true;
            }
            initData();
        }
        reportSource2(this.mIntent);
        boolean booleanExtra = this.mIntent.getBooleanExtra(IPublicAccountDetailActivity.FROM_JS, false);
        this.fromJS = booleanExtra;
        if (booleanExtra) {
            gotoMoreInfoActivity();
            finish();
        }
        setDatongParam();
        PublicAccountObserverImpl publicAccountObserverImpl = new PublicAccountObserverImpl();
        this.publicAccountObserver = publicAccountObserverImpl;
        publicAccountObserverImpl.setOnCallback(new e());
        super.addObserver(this.publicAccountObserver);
        ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).setKeepOldPublicAccountData(true);
        return true;
    }

    public int[] getAccurateScreenDpi() {
        int[] iArr = new int[2];
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return iArr;
    }

    protected void open(String str, int i3, String str2, Class<? extends Activity> cls, boolean z16) {
        if (TextUtils.equals(AppConstants.VALUE.UIN_QZONE, str) && ((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).open(this, this.app)) {
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (getIntent().hasExtra("qidian_chat") && getIntent().getBooleanExtra("qidian_chat", false)) {
            intent.setComponent(SplashActivity.getAliasComponent(this));
            bundle.putBoolean("open_chatfragment", true);
        } else {
            intent.setComponent(new ComponentName(this, cls));
        }
        bundle.putString("uin", str);
        bundle.putInt("uintype", i3);
        bundle.putString("uinname", str2);
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            bundle.putString("key_peerId", publicAccountDetailImpl.uid);
        }
        intent.putExtras(bundle);
        intent.setFlags(67108864);
        boolean booleanExtra = this.mIntent.getBooleanExtra(IPublicAccountUtil.NEED_FINISH, false);
        if (this.mIsSendMessage) {
            intent.putExtra("forward_type", -1);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, this.mSendMessage);
            this.mIsSendMessage = false;
        }
        if (booleanExtra) {
            super.finish();
        }
        intent.putExtra("isforceRequestDetail", z16);
        intent.putExtra("jump_from", 2);
        super.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
        getWindow().setFormat(-3);
    }

    void saveAccountDetailToDBAndCache(PublicAccountDetailImpl publicAccountDetailImpl) {
        if (publicAccountDetailImpl == null) {
            QLog.e(TAG, 1, "saveAccountDetailToDBAndCache invalid data!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveAccountDetailToDBAndCache");
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        PublicAccountDetailImpl publicAccountDetailImpl2 = this.accountDetail;
        if (publicAccountDetailImpl2 != null && publicAccountDetailImpl2.getId() != -1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, publicAccountDetailImpl.name);
            }
            this.accountDetail.clone(publicAccountDetailImpl);
            if (!createEntityManager.update(this.accountDetail)) {
                createEntityManager.drop(PublicAccountDetailImpl.class);
            }
        } else {
            this.accountDetail = publicAccountDetailImpl;
            createEntityManager.persist(publicAccountDetailImpl);
        }
        createEntityManager.close();
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            iPublicAccountDataManager.saveAccountDetailInfoCache(this.accountDetail);
            if (publicAccountDetailImpl.followType == 1) {
                iPublicAccountDataManager.savePublicAccountInfo(PublicAccountInfo.createPublicAccount(publicAccountDetailImpl, 0L));
            }
        }
        updateViewInMain();
    }

    /* loaded from: classes32.dex */
    class m implements ShareActionSheet.OnItemClickListener {
        m() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            String str;
            if (actionSheetItem == null) {
                return;
            }
            if (PublicAccountDetailActivityImpl.this.mShareDialogBuilder.isShowing()) {
                PublicAccountDetailActivityImpl.this.mShareDialogBuilder.dismiss();
            }
            int i3 = actionSheetItem.action;
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            int reportAccountType = PublicAccountDetailImpl.getReportAccountType(publicAccountDetailActivityImpl.app, publicAccountDetailActivityImpl.uin, publicAccountDetailActivityImpl.accountDetail);
            int i16 = 2;
            if (i3 == 2) {
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                ff0.a.d(publicAccountDetailActivityImpl2, publicAccountDetailActivityImpl2.getShareDetail(), PublicAccountDetailActivityImpl.this.getAccountType(), PublicAccountDetailActivityImpl.this.getShareUrl());
                i16 = 1;
            } else if (i3 != 3) {
                if (i3 != 19) {
                    switch (i3) {
                        case 9:
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl3 = PublicAccountDetailActivityImpl.this;
                            ff0.a.h(publicAccountDetailActivityImpl3, publicAccountDetailActivityImpl3.getShareDetail(), PublicAccountDetailActivityImpl.this.getAccountType(), PublicAccountDetailActivityImpl.this.getShareUrl(), i3);
                            i16 = 3;
                            break;
                        case 10:
                            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl4 = PublicAccountDetailActivityImpl.this;
                            ff0.a.h(publicAccountDetailActivityImpl4, publicAccountDetailActivityImpl4.getShareDetail(), PublicAccountDetailActivityImpl.this.getAccountType(), PublicAccountDetailActivityImpl.this.getShareUrl(), i3);
                            i16 = 4;
                            break;
                        case 11:
                            PublicAccountDetailActivityImpl.this.report();
                            i16 = 7;
                            break;
                        default:
                            switch (i3) {
                                case 30:
                                    PublicAccountDetailActivityImpl.this.gotoChatActivity();
                                    i16 = 5;
                                    break;
                                case 31:
                                    PublicAccountDetailActivityImpl.this.gotoMoreInfoActivity();
                                    i16 = 6;
                                    break;
                                case 32:
                                    PublicAccountDetailActivityImpl.this.showUnFollowActionSheet();
                                    i16 = 8;
                                    break;
                            }
                    }
                } else {
                    PublicAccountDetailActivityImpl publicAccountDetailActivityImpl5 = PublicAccountDetailActivityImpl.this;
                    PublicAccountDetailImpl publicAccountDetailImpl = publicAccountDetailActivityImpl5.accountDetail;
                    QidianManager.i0(publicAccountDetailActivityImpl5, 6, publicAccountDetailImpl.name, publicAccountDetailImpl.summary, publicAccountDetailActivityImpl5.shareUrl, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + PublicAccountDetailActivityImpl.this.accountDetail.uin, PublicAccountDetailActivityImpl.this.accountDetail.uin, reportAccountType, true);
                }
                i16 = 0;
            } else {
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl6 = PublicAccountDetailActivityImpl.this;
                ff0.a.f(publicAccountDetailActivityImpl6, publicAccountDetailActivityImpl6.getShareDetail(), PublicAccountDetailActivityImpl.this.getAccountType(), PublicAccountDetailActivityImpl.this.getShareUrl());
            }
            IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl7 = PublicAccountDetailActivityImpl.this;
            String str2 = publicAccountDetailActivityImpl7.uin;
            if (publicAccountDetailActivityImpl7.needShowUnFollowBtnInActionSheet()) {
                str = "02";
            } else {
                str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            }
            iPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007CA6", "0X8007CA6", 0, 0, str, i16 + "", reportAccountType + "", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportShareDetail(String str, a.b bVar) {
        String str2;
        if (TextUtils.isEmpty(str) || bVar.f398556d != a.b.f398552h) {
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        String a16 = bVar.a();
        if (bVar.f398557e) {
            str2 = "02";
        } else {
            str2 = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
        }
        ReportController.o(qQAppInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, a16, "0X8007CA6", "0X8007CA6", 0, 0, str2, str, String.valueOf(bVar.f398558f), "");
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity
    public String getArticleId(String str) {
        if (str != null) {
            try {
                int indexOf = str.indexOf("article_id=");
                if (indexOf > 0) {
                    String substring = str.substring(indexOf + 11);
                    int indexOf2 = substring.indexOf(ContainerUtils.FIELD_DELIMITER);
                    return indexOf2 >= 0 ? substring.substring(0, indexOf2) : substring;
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    String getUin(Intent intent) {
        if (intent != null) {
            return intent.getStringExtra("uin");
        }
        ProfileParams profileParams = this.mProfileParams;
        if (profileParams != null) {
            return profileParams.a().f80190e;
        }
        return null;
    }

    void reportEventIfFromOtherApp(String str) {
        ProfileParams profileParams = this.mProfileParams;
        if (profileParams != null) {
            String b16 = profileParams.b();
            String c16 = this.mProfileParams.c();
            String e16 = this.mProfileParams.e();
            if (TextUtils.isEmpty(b16)) {
                b16 = "";
            }
            if (TextUtils.isEmpty(c16)) {
                c16 = "";
            }
            if (TextUtils.isEmpty(e16)) {
                e16 = "";
            }
            ReportController.n(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", str, str, 0, 1, 0, b16 + ",app," + c16 + "," + e16 + "," + System.currentTimeMillis(), "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportItemEvent(String str) {
        if (str == null) {
            str = "";
        }
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.uin, "0X8005A27", "0X8005A27", 0, 0, str, "", "", "", false);
    }

    void deleteAccount(PublicAccountDetailImpl publicAccountDetailImpl) {
        if (publicAccountDetailImpl == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteAccount");
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        createEntityManager.remove(publicAccountDetailImpl);
        createEntityManager.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAccountDetailListView() {
        this.mAccountDetailListView = (AccountDetailXListView) super.findViewById(R.id.f163847a9);
        this.screenHeight = getWindowManager().getDefaultDisplay().getHeight();
        this.mAccountDetailListView.setOverScrollMode(2);
        this.mAccountDetailListView.setDividerHeight(0);
        this.mAccountDetailListView.setRefreshCallback(this);
        updateListView();
    }

    void initBottomContainer() {
        View findViewById = super.findViewById(R.id.f163897bk);
        this.bottomContainer = findViewById;
        findViewById.setVisibility(8);
        this.bottomHeight = this.bottomContainer.getLayoutParams().height;
        this.btnsDivider1 = super.findViewById(R.id.f163861al);
        this.callBtn = super.findViewById(R.id.ao8);
        this.btnsDivider1.setVisibility(8);
        this.callBtn.setVisibility(8);
        View findViewById2 = super.findViewById(R.id.cgt);
        this.followBtn = findViewById2;
        findViewById2.setVisibility(8);
        View findViewById3 = super.findViewById(R.id.f163862am);
        this.btnsDivider2 = findViewById3;
        findViewById3.setVisibility(8);
        super.setTitle(R.string.d5f);
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
        this.mProgress = qQProgressDialog;
        qQProgressDialog.setCanceledOnTouchOutside(true);
        Button button = (Button) super.findViewById(R.id.ija);
        this.searchBtn = button;
        button.setOnClickListener(this);
        Button button2 = (Button) super.findViewById(R.id.inf);
        this.sendMsgBtn = button2;
        button2.setText(R.string.c1u);
        this.sendMsgBtn.setOnClickListener(this);
        this.sendMsgBtn.setVisibility(8);
        Button button3 = (Button) super.findViewById(R.id.khg);
        this.unfollowBtn = button3;
        button3.setText(R.string.c1v);
        this.unfollowBtn.setOnClickListener(this);
        this.unfollowBtn.setVisibility(8);
        View findViewById4 = super.findViewById(R.id.f163863an);
        this.btnsDivider3 = findViewById4;
        findViewById4.setVisibility(8);
    }

    void initTitleView() {
        RelativeLayout relativeLayout = (RelativeLayout) super.findViewById(R.id.e8z);
        this.titleViewLayout = relativeLayout;
        relativeLayout.setOnClickListener(null);
        this.titleViewLayout.setBackground(getResources().getDrawable(R.drawable.qui_common_bg_bottom_light_bg, null));
        int i3 = (int) (this.density * 64.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i3);
        layoutParams.setMargins(0, (int) (this.density * 27.0f), 0, 0);
        this.titleViewLayout.setLayoutParams(layoutParams);
        this.titleViewLayout.setPadding(0, 0, 0, 0);
        this.titleHeight = i3;
        AccountDetailTopGestureLayout accountDetailTopGestureLayout = this.mTopGestureLayout;
        if (accountDetailTopGestureLayout != null) {
            accountDetailTopGestureLayout.setTitleHeight(i3);
        }
        ImageView imageView = (ImageView) super.findViewById(R.id.e8y);
        this.titleLeftIcon = imageView;
        imageView.setImageResource(R.drawable.qui_chevron_left_icon_primary_selector);
        this.titleLeftIcon.setOnClickListener(this);
        TextView textView = (TextView) super.findViewById(R.id.ivTitleBtnRightText);
        this.rightViewText = textView;
        textView.setText("");
        ImageView imageView2 = (ImageView) super.findViewById(R.id.ivTitleBtnRightImage);
        this.rightViewImg = imageView2;
        imageView2.setImageResource(R.drawable.qui_more_icon_primary);
        this.rightViewImg.setContentDescription(getString(R.string.epf));
        this.rightViewImg.setVisibility(0);
        this.rightViewImg.setOnClickListener(this);
        this.iconTop = (ImageView) super.findViewById(R.id.f165731da0);
        this.iconCicleTop = (ImageView) super.findViewById(R.id.d_a);
        this.iconCertifiedTop = (ImageView) super.findViewById(R.id.asv);
        Button button = (Button) super.findViewById(R.id.f163879b1);
        this.topFollowed = button;
        button.setOnClickListener(this);
    }

    void loadHDFace(cf.b bVar) {
        if (bVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateCurrentImage currentImage is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateCurrentImage uin=" + bVar.f180645g + ", state=" + bVar.f180642d);
        }
        if (bVar.f180642d == 6) {
            loadHDFace(bVar.f180641c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<IPublicAccountConfigAttr.a> resetConfigInfoListForUnfollow(List<IPublicAccountConfigAttr.a> list, boolean z16) {
        int i3;
        if (z16) {
            return list;
        }
        ArrayList arrayList = new ArrayList(2);
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            IPublicAccountConfigAttr.a aVar = list.get(i16);
            if (aVar.f79329a == 3 && ((i3 = aVar.f79333e) == 7 || i3 == 8)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    protected static boolean isSubscriptAccount(PublicAccountDetailImpl publicAccountDetailImpl) {
        if (publicAccountDetailImpl == null) {
            return false;
        }
        int accountType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(publicAccountDetailImpl.accountFlag);
        return accountType == -2 || accountType == -3 || accountType == -4 || ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType2(publicAccountDetailImpl.accountFlag2) == -8;
    }

    public static void reportEvents(QQAppInterface qQAppInterface, String str, Intent intent) {
        if (intent == null || !intent.hasExtra("source")) {
            return;
        }
        int intExtra = intent.getIntExtra("source", 0);
        if (intExtra == 1) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str, "0X800574C", "0X800574C", 0, 0, str, "", "", "", false);
            return;
        }
        if (intExtra == 2) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str, "0X800574D", "0X800574D", 0, 0, str, "", "", "", false);
        } else if (intExtra == 3) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str, "0X800574E", "0X800574E", 0, 0, str, "", "", "", false);
        } else {
            if (intExtra != 4) {
                return;
            }
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str, "0X800589D", "0X800589D", 0, 0, str, "", "", "", false);
        }
    }

    Drawable getGaussianBlurPic(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap midBitmap = getMidBitmap(bitmap);
            eh.a(midBitmap, 1);
            return new BitmapDrawable(midBitmap);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        AccountDetailBaseAdapter accountDetailBaseAdapter;
        String str2;
        IPublicAccountConfigAttr.a messageHistoryInfo;
        if (view == this.searchBtn) {
            startSearchActivity();
            return;
        }
        if (view != this.followBtn && (((accountDetailBaseAdapter = this.mAccountDetailAdapter) == null || view != accountDetailBaseAdapter.f78863c0 || isFollowed()) && (view != this.topFollowed || isFollowed()))) {
            if (view == this.sendMsgBtn) {
                int intExtra = getIntent().getIntExtra("source", 0);
                IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
                if (!(iWeatherCommApi.isWeatherPA(this.uin) && iWeatherCommApi.startNewWeatherWebPageActivity(this, this.app))) {
                    if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(this.uin)) {
                        ((IQCirclePublicAccountLauncher) QRoute.api(IQCirclePublicAccountLauncher.class)).launchQCircleFromPublicAccount(this.app, this, QCirclePublicAccountLauncherSource.PUBLIC_ACCOUNT_PROFILE_PAGE);
                    } else if (AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN.equals(this.uin)) {
                        goToEcommerceMsgActivity(intExtra);
                    } else if (((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).isWeiShiAccount(this.uin)) {
                        gotoWeiShiFlowActivity();
                    } else if (AppConstants.TIM_TEAM_UIN.equals(this.uin)) {
                        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).enterTimTeam(this, this.app);
                    } else if (intExtra == 120) {
                        doOnBackPressed();
                    } else if (TextUtils.equals("2747277822", this.uin) && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()) {
                        if (getIntent() != null && getIntent().getBooleanExtra("fromQGamePub", false)) {
                            doOnBackPressed();
                        } else {
                            gotoQQGameActivity();
                        }
                    } else if (TextUtils.equals("3593944551", this.uin) && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isCustomGameMallPubAccount()) {
                        gotoGameMallActivity();
                    } else if (TextUtils.equals(qb2.a.f428781a, this.uin)) {
                        if (!qb2.b.e(this, this.uin, 2)) {
                            gotoChatActivity();
                        }
                    } else if (TextUtils.equals(IPublicAccountUtil.UIN_FOR_SHOP, this.uin)) {
                        if (this.mSource == 5) {
                            doOnBackPressed();
                        } else {
                            ((IEcshopUtilApi) QRoute.api(IEcshopUtilApi.class)).jump(this);
                        }
                    } else if (TextUtils.equals("2909288299", this.uin)) {
                        if (getIntent() != null && getIntent().getBooleanExtra("fromQQNewsPubNew", false)) {
                            doOnBackPressed();
                        } else if (!((IQQNewsCommApi) QRoute.api(IQQNewsCommApi.class)).startQQNewsPA(this)) {
                            gotoChatActivity();
                        }
                    } else if (((IMiniAppService) QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(this.uin)) {
                        if (getIntent() != null && getIntent().getBooleanExtra("fromMiniGamePub", false)) {
                            doOnBackPressed();
                        } else {
                            gotoMiniGamePublicAccountActivity();
                        }
                    } else if (TextUtils.equals(AppConstants.QQ_VIP_UIN, this.uin)) {
                        s23.a.j(this, "other");
                    } else if (TextUtils.equals(this.uin, AppConstants.QQ_YELLOW_VIP_UIN)) {
                        y33.b.f449310a.d(this, "other");
                    } else if (((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).isVipRead(this.uin)) {
                        ((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).startVipReadFragment(this);
                    } else if (((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).isPAUin(this.uin)) {
                        ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).jumpToPublicAccountPage(this, this.uin);
                    } else if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isNeedRedirectAIOToMainPage(this.uin)) {
                        if (!((IQQHealthService) this.app.getRuntimeService(IQQHealthService.class, ProcessConstant.MULTI)).redirectAIOToMainPage(this, 162)) {
                            gotoChatActivity();
                        }
                    } else if (((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).isGuildPublicAccount(this.uin)) {
                        ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).openDiscoverFromPublicAccount(this, new GuildPublicAccountParams(4));
                    } else if (AppConstants.ZPLAN_MOD_SMALLHOME_PUBLIC_ACCOUNT_UIN.equals(this.uin)) {
                        ((IZPlanPublicAccountLauncherApi) QRoute.api(IZPlanPublicAccountLauncherApi.class)).launchSmallHomeMainPageFromPublicAccount(this.app, this, "PublicAccountDetail sendMsgBtn");
                    } else if (AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN.equals(this.uin)) {
                        ((ITVideoPublicAccountLauncherApi) QRoute.api(ITVideoPublicAccountLauncherApi.class)).launchTVideoPublicAccountPage(this.app, this, "");
                    } else {
                        gotoChatActivity();
                    }
                }
                QQAppInterface qQAppInterface = this.app;
                String str3 = this.uin;
                ReportController.o(qQAppInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str3, "0X8004E44", "0X8004E44", 0, 0, str3, "", "", "");
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.uin, "0X8005A26", "0X8005A26", 0, 0, "", "", "", "", false);
                xx.b.INSTANCE.n(this.uin);
                return;
            }
            if (view == this.callBtn) {
                CrmUtils.z(this.app, this, getAccountName(), this.uin, "IvrEnterpriseDetailEngineFalse");
                ReportController.o(this.app, "CliOper", "", "", "0X8004653", "0X8004653", 0, 0, "", "", "", "");
                return;
            }
            if (view == this.titleLeftIcon) {
                doOnBackPressed();
                return;
            }
            if (view != this.rightViewImg && (view == null || view.getId() != R.id.ivTitleBtnRightImage)) {
                if (view == this.unfollowBtn) {
                    showUnFollowActionSheet();
                    xx.b.INSTANCE.v(this.uin);
                    return;
                }
                if (view != null && view.getId() == R.id.f907353_) {
                    this.detailRootView.setVisibility(0);
                    this.accountMoreDetailController.d(this.accountDetail);
                    xx.b.INSTANCE.w(this.uin);
                    return;
                } else {
                    if (view == null || view.getId() != R.id.f165698xa3 || (messageHistoryInfo = PublicAccountUtilImpl.getMessageHistoryInfo(this.accountDetail)) == null) {
                        return;
                    }
                    jumpWebView(messageHistoryInfo.f79336h);
                    return;
                }
            }
            if (this.isSubscriptAccount) {
                showActionSheetSub();
            } else {
                showActionSheet();
            }
            QQAppInterface qQAppInterface2 = this.app;
            String str4 = this.uin;
            if (isFollowed()) {
                str2 = "02";
            } else {
                str2 = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
            }
            ReportController.o(qQAppInterface2, "dc01160", IPublicAccountHandler.MAIN_ACTION, str4, "0X8007CA5", "0X8007CA5", 0, 0, str2, String.valueOf(PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "", "");
            xx.b.INSTANCE.s(this.uin);
            return;
        }
        reportEventIfFromOtherApp(ATTENTION_ACTION_FOR_REPORT_FROM_OTHER_APP);
        this.mIsChangedFromOutSide = false;
        follow();
        setFollowStatus();
        this.followBtn.setEnabled(false);
        this.followBtn.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.26
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountDetailActivityImpl.this.followBtn.setEnabled(true);
            }
        }, 1000L);
        if (ServiceAccountFolderManager.j(this.app, this.uin)) {
            ((EcshopReportHandler) this.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).H2(134243868, this.uin, null, null, null, 1L, false);
        }
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.uin, "0X8005A25", "0X8005A25", this.fromwhere, 0, "", "", "", "", false);
        ((IPublicAccountDetailReportUtil) QRoute.api(IPublicAccountDetailReportUtil.class)).setAttrSearchAttention(4, this.uin, 0, UniteSearchActivity.f282684b0, com.tencent.mobileqq.search.util.o.a().b(this.uin));
        QQAppInterface qQAppInterface3 = this.app;
        String str5 = this.uin;
        if (isFollowed()) {
            str = "02";
        } else {
            str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
        }
        ReportController.o(qQAppInterface3, "dc01160", IPublicAccountHandler.MAIN_ACTION, str5, "0X8007CA1", "0X8007CA1", 0, 0, str, String.valueOf(this.fromwhere), String.valueOf(PublicAccountDetailImpl.getReportAccountType(this.app, this.uin, this.accountDetail)), "");
        if (AppConstants.KANDIAN_DAILY_UIN.equals(this.uin)) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009946", "0X8009946", 0, 0, "", "", "", new JSONObject().toString(), false);
        }
        xx.b.INSTANCE.p(this.uin);
    }

    void reportSource(Intent intent) {
        this.isFromBrowser = intent.getBooleanExtra(FROM_BROWSER, false);
        int intExtra = intent.getIntExtra("source", 0);
        this.mSource = intExtra;
        if (intExtra == 1) {
            this.fromwhere = 2;
        } else if (intExtra == 2) {
            this.fromwhere = 3;
        } else if (intExtra == 3) {
            this.fromwhere = 12;
        } else if (intExtra == 4) {
            this.fromwhere = 0;
        } else if (intExtra == 5) {
            this.fromwhere = 1;
        } else if (intExtra == 108) {
            this.fromwhere = 8;
        } else if (intExtra == 109) {
            this.fromwhere = 9;
        } else if (intExtra == 111) {
            this.fromwhere = 11;
        } else if (intExtra == 112) {
            this.fromwhere = 50;
        } else if (intExtra != 114) {
            switch (intExtra) {
                case 104:
                    this.fromwhere = 4;
                    break;
                case 105:
                    this.fromwhere = 5;
                    break;
                case 106:
                    this.fromwhere = 6;
                    break;
            }
        } else {
            this.fromwhere = 13;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[fromwhere]:" + this.fromwhere);
        }
        ReportController.o(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, this.uin, "0X8005A24", "0X8005A24", this.fromwhere, 0, "", "", "", "");
    }

    public boolean tryGoToWeatherWhenFollow(PublicAccountDetailImpl publicAccountDetailImpl) {
        if (publicAccountDetailImpl == null || this.weatherOutsideFollowState != 2) {
            return false;
        }
        final IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
        if (TextUtils.isEmpty(this.weatherShareUrl) || !iWeatherCommApi.isWeatherPA(this.uin) || publicAccountDetailImpl.followType != 1) {
            return false;
        }
        QLog.i(TAG, 1, "handleIfWeatherShare" + this.weatherShareUrl);
        runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.33
            @Override // java.lang.Runnable
            public void run() {
                IWeatherCommApi iWeatherCommApi2 = iWeatherCommApi;
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                iWeatherCommApi2.startWeatherWebPageActivity(publicAccountDetailActivityImpl, publicAccountDetailActivityImpl.app, 4, publicAccountDetailActivityImpl.weatherShareUrl);
                PublicAccountDetailActivityImpl.this.finish();
            }
        });
        return true;
    }

    public boolean tryGoToWeatherWhenGetInfo(PublicAccountDetailImpl publicAccountDetailImpl) {
        if (publicAccountDetailImpl == null || this.weatherOutsideFollowState != 3) {
            return false;
        }
        if (!TextUtils.isEmpty(this.weatherShareUrl) && ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.uin) && publicAccountDetailImpl.followType == 1) {
            QLog.i(TAG, 1, "handleIfWeatherShare" + this.weatherShareUrl);
            this.weatherOutsideFollowState = 1;
            runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.32
                @Override // java.lang.Runnable
                public void run() {
                    IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
                    PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                    iWeatherCommApi.startWeatherWebPageActivity(publicAccountDetailActivityImpl, publicAccountDetailActivityImpl.app, 4, publicAccountDetailActivityImpl.weatherShareUrl);
                    PublicAccountDetailActivityImpl.this.finish();
                }
            });
            return true;
        }
        this.weatherOutsideFollowState = 2;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f79041d;

        a(Activity activity) {
            this.f79041d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return;
                }
                PublicAccountDetailActivityImpl.this.gotoChatActivity();
                dialogInterface.dismiss();
                return;
            }
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            publicAccountDetailActivityImpl.mShouldNotStayAtThisApp = true;
            publicAccountDetailActivityImpl.doOnBackPressed();
            ForwardSdkBaseOption.F(this.f79041d, true, "shareToQQ", Long.valueOf(PublicAccountDetailActivityImpl.this.mProfileParams.c()).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String shareToWX(int i3, a.b bVar, String str, int i16, String str2, BaseActivity baseActivity) {
        String str3;
        String str4;
        ff0.a.h(baseActivity, bVar, i16, str2, i3);
        if (i3 == 9) {
            str3 = "share_wechat";
            str4 = "03";
        } else {
            str3 = "share_circle";
            str4 = "04";
        }
        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.app, str, "Grp_tribe", "interest_data", str3);
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initView$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class o extends c.a {
        o() {
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean z16, Object obj) {
            PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
            int i3 = publicAccountDetailActivityImpl.waitingCount - 1;
            publicAccountDetailActivityImpl.waitingCount = i3;
            if (i3 == 0) {
                publicAccountDetailActivityImpl.removeLoading();
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object obj) {
            PublicAccountDetailActivityImpl.this.displayToast(R.string.d6b);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object obj) {
            if (obj instanceof oidb_cmd0xc96$RspBody) {
                oidb_cmd0xc96$RspBody oidb_cmd0xc96_rspbody = (oidb_cmd0xc96$RspBody) obj;
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountDetailActivityImpl.TAG, 2, "0xc96 responseBody success, wording=", oidb_cmd0xc96_rspbody.wording.get());
                }
                JSONObject jSONObject = new JSONObject();
                String str = PublicAccountDetailActivityImpl.this.uin;
                if (str != null) {
                    try {
                        jSONObject.put("uin", str);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                        com.tencent.mobileqq.jsp.h.w("unFollow", jSONObject, arrayList, null);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
                PublicAccountDetailActivityImpl.this.updateUnfollowInfo();
                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl = PublicAccountDetailActivityImpl.this;
                iPublicAccountReportUtils.publicAccountReportClickEventForMigrate(publicAccountDetailActivityImpl.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, publicAccountDetailActivityImpl.uin, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
                PublicAccountDetailActivityImpl publicAccountDetailActivityImpl2 = PublicAccountDetailActivityImpl.this;
                StructLongMessageDownloadProcessor.deleteTask(publicAccountDetailActivityImpl2.app, publicAccountDetailActivityImpl2.uin);
                ((z) PublicAccountDetailActivityImpl.this.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).b(PublicAccountDetailActivityImpl.this.accountDetail.uin);
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 5;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean z16, Object obj) {
        }
    }
}
