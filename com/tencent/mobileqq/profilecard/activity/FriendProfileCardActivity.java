package com.tencent.mobileqq.profilecard.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import com.dataline.util.j;
import com.tencent.biz.bmqq.api.IBmqqSegmentApi;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.enterpriseqq.api.IEnterpriseQQService;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.minigame.metafarm.event.MetaFarmCardOpenEvent;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardBlacklistApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IProfileComponentApi;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.ComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.multyple.FriendProfileCardMultiple;
import com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiple;
import com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.report.ProfileCardTracer;
import com.tencent.mobileqq.profilecard.report.ProfilePerformanceHelper;
import com.tencent.mobileqq.profilecard.report.ProfilePerformancePart;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileCardForbidAccountHelper;
import com.tencent.mobileqq.profilecard.utils.ProfileCardPerformanceReport;
import com.tencent.mobileqq.profilecard.utils.ProfileCardReportUtil;
import com.tencent.mobileqq.profilecard.utils.ProfileCardUtil;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecard.version.ProfileCardVersionController;
import com.tencent.mobileqq.profilecard.zplan.IZPlanChangeTitleStatusListener;
import com.tencent.mobileqq.qcircle.api.data.QCircleFeedCoverBean;
import com.tencent.mobileqq.qcircle.api.event.QFSSetCoverFeedEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IAIAvatarConfig;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi;
import com.tencent.qidian.api.IQidianApi;
import com.tencent.qidian.api.IQidianManagerApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@ArgusTag(testConfigKey = "argus_friend_profile", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes16.dex */
public class FriendProfileCardActivity extends QBaseActivity implements XListView.MotionEventInterceptor, TopGestureLayout.OnGestureListener, SimpleEventReceiver {
    static IPatchRedirector $redirector_ = null;
    private static final int ARGS_FROM_GET_PROFILE_CARD_REQUEST = 1;
    public static final String DTREPORT_PAGE_PARAMS_HOST_GUEST_TYPE = "user_profile_host_guest_type";
    public static final String DTREPORT_PAGE_PARAMS_IS_QQ_FRI = "is_qq_fri";
    public static final String DTREPORT_PAGE_PARAMS_PROFILE_VERSION = "profile_version";
    public static final String DTREPORT_PAGE_PARAMS_TO_UIN = "to_uin";
    private static final String DTREPORT_PAGE_USER_PROFILE_ELEGANT = "pg_user_profile_new";
    private static final int[] HANDLE_REQUEST_PROFILE_CARD_TYPE;
    private static final int MAX_REQUEST_CARD_COUNT = 5;
    public static final String QQ_PROFILE_CARD_PERFORMANCE_OPTIMISATION_SWITCH = "qq_profilecard_performance_optimisation_switch";
    private static final int SUB_MSG_INIT_CARD = 1;
    private static final int SUB_MSG_INIT_CONTACT_CARD = 2;
    private static final int SUB_MSG_UPDATE_CARD = 3;
    private static final boolean SWITCH_TO_NEW_PROFILE_CARD;
    private static final String TAG = "FriendProfileCardActivity";
    private static final int UI_MSG_INIT_HEADER_VIEW_TIMEOUT = 103;
    private static final int UI_MSG_SWITCH_TO_FRIEND = 100;
    private static final int UI_MSG_UPDATE_CARD = 102;
    private static final int UI_MSG_UPDATE_CONTACT_CARD = 101;
    private long costTimeStart;
    private boolean hasReportZplanExpose;
    private final boolean isCloneInflaterInSubThreadForSplashActivity;
    private final boolean isEnableDelegateLayoutInflaterForSplashActivity;
    private final ITaskListener.Stub listener;
    private final com.tencent.mobileqq.avatar.observer.a mAvatarObserver;
    private View mBgContainerView;
    private View mBottomContainerView;
    private IComponentCenter mComponentCenter;
    private IProfileConfig mConfigHelper;
    private View mContentContainerView;
    private View mContentView;
    private BroadcastReceiver mDetailModifyReceiver;
    private ProfilePerformancePart mDrawPerformancePart;
    private View mFgContainerView;
    private ProfileCardForbidAccountHelper mForbidAccountHelper;
    private boolean mHasUpdateFriendsDetail;
    private View mHeaderContainerView;
    private boolean mInterceptTouchEvent;
    private boolean mIsShowQCircleCover;
    private boolean mIsShowZplanCover;
    private boolean mIsVasProfileCard;
    private final RFWThreadLocal<LayoutInflater> mLayoutInflaters;
    private LinearLayout mLoadingView;
    private final ProfileCardInfo mProfileCardInfo;
    private List<AbsProfileComponent> mProfileContainers;
    private final IProfileActivityDelegate mProfileDelegate;
    private PullToZoomHeaderListView mProfileListView;
    private List<AbsListView.OnScrollListener> mProfileScrollListeners;
    private int mRequestCardCount;
    private View mRootView;
    private ProfilePerformancePart mScrollPerformancePart;
    private final Handler.Callback mSubCallback;
    private WeakReferenceHandler mSubHandler;
    private View mTitleContainerView;
    private TopGestureLayout mTopView;
    private final Handler.Callback mUICallback;
    private WeakReferenceHandler mUIHandler;
    private IZPlanChangeTitleStatusListener mZPlanCheckTitleStatusListener;
    private final AbsListView.OnScrollListener onScrollListener;
    private final ProfileCardObserver profileCardObserver;
    private int refreshUiCount;
    private boolean reportFlag;
    private WinkPublishServiceProxy2 winkPublishService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity$6, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass6 extends ITaskListener.Stub {
        static IPatchRedirector $redirector_;

        AnonymousClass6() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTaskChange$0(TaskInfo taskInfo, String str) {
            if (taskInfo.isSuccess()) {
                ((IWinkDraft) QRoute.api(IWinkDraft.class)).delete(WinkCommonUtil.getCurrentAccountLong(), taskInfo.getMissionId());
                QLog.d("FriendProfileCardActivity", 1, "success");
                QQToast.makeText(BaseApplication.getContext(), 2, j.d(BaseApplication.getContext().getString(R.string.f238917l2)), 1).show();
                HashMap hashMap = new HashMap();
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, str);
                VideoReport.reportEvent(EventKey.ACT, FriendProfileCardActivity.this.mRootView, hashMap);
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), R.string.hit, 1).show();
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(final TaskInfo taskInfo) {
            final String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskInfo);
                return;
            }
            if (!taskInfo.isFinish()) {
                return;
            }
            QLog.d("FriendProfileCardActivity", 1, "isFinish true");
            Bundle transParams = taskInfo.getTransParams();
            if (transParams == null || (string = transParams.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, null)) == null) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.activity.d
                @Override // java.lang.Runnable
                public final void run() {
                    FriendProfileCardActivity.AnonymousClass6.this.lambda$onTaskChange$0(taskInfo, string);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19603);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            SWITCH_TO_NEW_PROFILE_CARD = ar.b("shouyouye", "2025-01-09", "vas_switch_to_new_profile").isEnable(true);
            HANDLE_REQUEST_PROFILE_CARD_TYPE = new int[]{0, 60, 1, 78, 40, 41, 42, 73, 86, 36, 30, 32, 31, 50, 51, 34, 53, 29, 45, 46, 47, 20, 21, 58, 22, 3, 2, 74, 35, 37, 75, 61, 70, 25, 27, 28, 108, 26, 95, 4, 77, 52, 19, 23, 24, 120, 104, 111, 105, 106, 97, 98, 126, 55, 56, 57, 72, 71, 82, 81, 83, 84, 101, 103, 102, 107, 110, 96, 112, 113, 115, 117};
        }
    }

    public FriendProfileCardActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLayoutInflaters = new RFWThreadLocal<>();
        this.mProfileCardInfo = new ProfileCardInfo();
        this.mHasUpdateFriendsDetail = false;
        this.mRequestCardCount = 0;
        this.mInterceptTouchEvent = true;
        this.mDetailModifyReceiver = null;
        this.hasReportZplanExpose = false;
        this.costTimeStart = 0L;
        this.reportFlag = false;
        this.refreshUiCount = 0;
        this.mForbidAccountHelper = new ProfileCardForbidAccountHelper();
        this.mAvatarObserver = new com.tencent.mobileqq.avatar.observer.a() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.avatar.observer.a
            public void onUpdateCustomHead(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str);
                    return;
                }
                super.onUpdateCustomHead(z16, str);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).downloadHDAvatar(peekAppRuntime.getCurrentAccountUin(), peekAppRuntime);
            }
        };
        this.onScrollListener = new AbsListView.OnScrollListener() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                }
            }

            @Override // com.tencent.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                } else if (FriendProfileCardActivity.this.mProfileScrollListeners != null) {
                    Iterator it = FriendProfileCardActivity.this.mProfileScrollListeners.iterator();
                    while (it.hasNext()) {
                        ((AbsListView.OnScrollListener) it.next()).onScroll(absListView, i3, i16, i17);
                    }
                }
            }

            @Override // com.tencent.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) absListView, i3);
                    return;
                }
                if (i3 == 0) {
                    FriendProfileCardActivity.this.reportEndScroll();
                    oy3.a.a().c("vas_profilecard_list", false);
                } else {
                    FriendProfileCardActivity.this.reportStartScroll();
                    oy3.a.a().b("vas_profilecard_list");
                }
                if (FriendProfileCardActivity.this.mProfileScrollListeners != null) {
                    Iterator it = FriendProfileCardActivity.this.mProfileScrollListeners.iterator();
                    while (it.hasNext()) {
                        ((AbsListView.OnScrollListener) it.next()).onScrollStateChanged(absListView, i3);
                    }
                }
            }
        };
        this.profileCardObserver = new ProfileCardObserver() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onGetProfileCard(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    FriendProfileCardActivity.this.handleGetProfileCard(z16, obj);
                } else {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onSetCardTemplateReturn(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    FriendProfileCardActivity.this.handleSetCardTemplateReturn(z16, obj);
                } else {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                }
            }
        };
        this.mSubCallback = new Handler.Callback() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                Card card;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                boolean z16 = false;
                if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileCardActivity", 2, String.format("handleMessage Sub msg=%s", message));
                }
                int i3 = message.what;
                if (i3 == 1) {
                    FriendProfileCardActivity.this.initProfileCard((String) message.obj);
                } else if (i3 == 2) {
                    FriendProfileCardActivity.this.initContactCard();
                } else if (i3 == 3) {
                    Object obj = message.obj;
                    if (obj instanceof Card) {
                        card = (Card) obj;
                    } else {
                        card = FriendProfileCardActivity.this.mProfileCardInfo.card;
                    }
                    if (message.arg1 == 1) {
                        z16 = true;
                    }
                    FriendProfileCardActivity.this.onCardUpdate(card, true, 3, z16);
                }
                return true;
            }
        };
        this.mUICallback = new Handler.Callback() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                }
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                Card card;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
                }
                boolean z16 = false;
                if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileCardActivity", 2, String.format("handleMessage UI msg=%s", message));
                }
                String str = null;
                FriendProfileCardActivity.this.mFgContainerView.setBackground(null);
                FriendProfileCardActivity.this.updateLoadingPage(false);
                switch (message.what) {
                    case 100:
                        Object obj = message.obj;
                        if (obj instanceof Card) {
                            Card card2 = (Card) obj;
                            str = card2.uin;
                            card = card2;
                        } else {
                            card = null;
                        }
                        if (str != null && str.length() > 0) {
                            FriendProfileCardActivity.this.switchedToFriend(card, str);
                            break;
                        }
                        break;
                    case 101:
                        if (message.arg1 == 1) {
                            z16 = true;
                        }
                        FriendProfileCardActivity.this.updateContactCardInfo((ProfileCardInfo) message.obj, z16);
                        break;
                    case 102:
                        if (message.arg1 == 1) {
                            z16 = true;
                        }
                        Object obj2 = message.obj;
                        if (obj2 instanceof Card) {
                            Card card3 = (Card) obj2;
                            FriendProfileCardActivity.this.mProfileCardInfo.card = card3;
                            FriendProfileCardActivity.this.updateCardInfo(card3, z16);
                            break;
                        }
                        break;
                    case 103:
                        if (FriendProfileCardActivity.this.mProfileCardInfo.card != null) {
                            FriendProfileCardActivity.this.mProfileCardInfo.isTimeOut = true;
                            FriendProfileCardActivity.this.mProfileCardInfo.card.lCurrentStyleId = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
                            FriendProfileCardActivity.this.mProfileCardInfo.card.templateRet = 0;
                            FriendProfileCardActivity.this.mProfileCardInfo.currentTemplate = null;
                            FriendProfileCardActivity friendProfileCardActivity = FriendProfileCardActivity.this;
                            friendProfileCardActivity.updateCardInfo(friendProfileCardActivity.mProfileCardInfo.card, false);
                            break;
                        }
                        break;
                }
                return true;
            }
        };
        this.winkPublishService = null;
        this.listener = new AnonymousClass6();
        this.isCloneInflaterInSubThreadForSplashActivity = RFWConfig.getConfigValue("FRIEND_ACTIVITY_INFLATE_DELEGATE", true);
        this.isEnableDelegateLayoutInflaterForSplashActivity = RFWConfig.getConfigValue("FRIEND_ACTIVITY_INFLATE_DELEGATE", false);
        this.mIsVasProfileCard = false;
        this.mProfileDelegate = new IProfileActivityDelegate() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.10
            static IPatchRedirector $redirector_;
            private IProfileCardMultiple mProfileCardMultiple;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void addProfileScrollListener(AbsListView.OnScrollListener onScrollListener) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 10)) {
                    FriendProfileCardActivity.this.addProfileScrollListener(onScrollListener);
                } else {
                    iPatchRedirector2.redirect((short) 10, (Object) this, (Object) onScrollListener);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void checkAndSwitch2Friend(boolean z16, boolean z17, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 14)) {
                    FriendProfileCardActivity.this.checkAndSwitch2Friend(z16, z17, str);
                } else {
                    iPatchRedirector2.redirect((short) 14, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public boolean enableFoldSplit() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 19)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 19, (Object) this)).booleanValue();
                }
                return false;
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public int getComponentBgResource() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 17)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 17, (Object) this)).intValue();
                }
                if (getProfileCardMultiple().getMultiConfig().enableVasComponent()) {
                    return R.drawable.f160556k2;
                }
                if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                    return R.color.ce7;
                }
                return R.color.ce8;
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public boolean getIsShowZplanCover() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 18)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 18, (Object) this)).booleanValue();
                }
                if (QLog.isDebugVersion()) {
                    QLog.i("FriendProfileCardActivity", 1, "getIsShowZplanCover isShowVasCustomBgCover : " + isShowVasCustomBgCover() + "; mIsShowZplanCover : " + FriendProfileCardActivity.this.mIsShowZplanCover);
                }
                if (!isShowVasCustomBgCover() && FriendProfileCardActivity.this.mIsShowZplanCover) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public PullToZoomHeaderListView getListView() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 4)) {
                    return FriendProfileCardActivity.this.mProfileListView;
                }
                return (PullToZoomHeaderListView) iPatchRedirector2.redirect((short) 4, (Object) this);
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public IProfileCardMultiple getProfileCardMultiple() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 15)) {
                    return (IProfileCardMultiple) iPatchRedirector2.redirect((short) 15, (Object) this);
                }
                if (this.mProfileCardMultiple == null) {
                    this.mProfileCardMultiple = new FriendProfileCardMultiple(ProfileCardVersionController.getVersion());
                }
                return this.mProfileCardMultiple;
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public IProfileConfig getProfileConfig() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    return FriendProfileCardActivity.this.mConfigHelper;
                }
                return (IProfileConfig) iPatchRedirector2.redirect((short) 2, (Object) this);
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public ViewGroup getRootView() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (ViewGroup) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                return (ViewGroup) FriendProfileCardActivity.this.mRootView;
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public IZPlanChangeTitleStatusListener getZPlanChangeTitleStatusListener() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 23)) {
                    return FriendProfileCardActivity.this.mZPlanCheckTitleStatusListener;
                }
                return (IZPlanChangeTitleStatusListener) iPatchRedirector2.redirect((short) 23, (Object) this);
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public boolean isForceRefreshDiyProfile() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 21)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 21, (Object) this)).booleanValue();
                }
                return VasNormalToggle.VAS_BUG_118008826.isEnable(true);
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public boolean isShowQCircleCover() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 22)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 22, (Object) this)).booleanValue();
                }
                if (!isShowVasCustomBgCover() && FriendProfileCardActivity.this.mIsShowQCircleCover) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public boolean isShowVasCustomBgCover() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 20)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 20, (Object) this)).booleanValue();
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (!(peekAppRuntime instanceof AppInterface)) {
                    return false;
                }
                return ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isVasCustomBg(FriendProfileCardActivity.this.mProfileCardInfo, (AppInterface) peekAppRuntime);
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void notifyCardUpdate() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 6)) {
                    FriendProfileCardActivity.this.notifyCardUpdate(null);
                } else {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void removeProfileScrollListener(AbsListView.OnScrollListener onScrollListener) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 11)) {
                    FriendProfileCardActivity.this.removeProfileScrollListener(onScrollListener);
                } else {
                    iPatchRedirector2.redirect((short) 11, (Object) this, (Object) onScrollListener);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void requestUpdateCard() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 5)) {
                    FriendProfileCardActivity.this.requestUpdateCard(0L, null, null, false);
                } else {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void scrollToListTop() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 8)) {
                    FriendProfileCardActivity.this.scrollToListTop();
                } else {
                    iPatchRedirector2.redirect((short) 8, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void scrollToMoreInfoView(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 9)) {
                    FriendProfileCardActivity.this.scrollToMoreInfoView(i3);
                } else {
                    iPatchRedirector2.redirect((short) 9, (Object) this, i3);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void setInterceptTouchEvent(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 12)) {
                    FriendProfileCardActivity.this.setInterceptTouchEvent(z16);
                } else {
                    iPatchRedirector2.redirect((short) 12, (Object) this, z16);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void setRemark(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 13)) {
                    FriendProfileCardActivity.this.setNewRemark(str);
                } else {
                    iPatchRedirector2.redirect((short) 13, (Object) this, (Object) str);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void setZPlanChangeTitleStatusListener(IZPlanChangeTitleStatusListener iZPlanChangeTitleStatusListener) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 24)) {
                    FriendProfileCardActivity.this.mZPlanCheckTitleStatusListener = iZPlanChangeTitleStatusListener;
                } else {
                    iPatchRedirector2.redirect((short) 24, (Object) this, (Object) iZPlanChangeTitleStatusListener);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public void notifyCardUpdate(Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 7)) {
                    FriendProfileCardActivity.this.notifyCardUpdate(card);
                } else {
                    iPatchRedirector2.redirect((short) 7, (Object) this, (Object) card);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
            public IProfileCardMultiple getProfileCardMultiple(boolean z16) {
                FriendProfileCardMultiple friendProfileCardMultiple;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 16)) {
                    return (IProfileCardMultiple) iPatchRedirector2.redirect((short) 16, (Object) this, z16);
                }
                if (z16) {
                    friendProfileCardMultiple = new FriendProfileCardMultiple(ProfileCardVersionController.OLD);
                } else {
                    friendProfileCardMultiple = new FriendProfileCardMultiple(ProfileCardVersionController.getVersion());
                }
                this.mProfileCardMultiple = friendProfileCardMultiple;
                return friendProfileCardMultiple;
            }
        };
    }

    private String addNationCodeIfNeeded(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).addNationCodeIfNeeded(peekAppRuntime, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProfileScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (this.mProfileScrollListeners == null) {
            this.mProfileScrollListeners = new ArrayList();
        }
        this.mProfileScrollListeners.add(onScrollListener);
    }

    private void backAndUpdateCard(Intent intent) {
        byte[] bArr;
        if (intent != null && this.mProfileCardInfo.card != null && intent.getBooleanExtra(IProfileCardConst.PARAM_SWITCHES_CHANGED, false)) {
            ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
            AllInOne allInOne = profileCardInfo.allInOne;
            int i3 = allInOne.f260789pa;
            if (i3 != 56 && i3 != 57) {
                if (i3 != 35 && i3 != 37 && i3 != 36) {
                    bArr = null;
                } else {
                    bArr = allInOne.chatCookie;
                }
            } else {
                bArr = allInOne.chatCookie;
            }
            Card card = profileCardInfo.card;
            requestUpdateCard(card.feedPreviewTime, card.vSeed, bArr, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndSwitch2Friend(boolean z16, boolean z17, String str) {
        AllInOne allInOne;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && this.mUIHandler != null && (allInOne = this.mProfileCardInfo.allInOne) != null && !ProfilePAUtils.isPaTypeFriend(allInOne) && this.mProfileCardInfo.allInOne.f260789pa != 0 && !TextUtils.equals(str, getCurrentAccountUin()) && !TextUtils.equals(this.mProfileCardInfo.allInOne.uin, getCurrentAccountUin())) {
            boolean z18 = false;
            if (QLog.isColorLevel()) {
                QLog.i("FriendProfileCardActivity", 2, String.format("checkAndSwitch2Friend isFromContactCard=%s needCheckFriend=%s uin=%s", Boolean.valueOf(z16), Boolean.valueOf(z17), str));
            }
            if (z16) {
                Card switchContactCardToFriendCard = switchContactCardToFriendCard(str, ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne));
                Message obtain = Message.obtain();
                obtain.what = 100;
                Object obj = str;
                if (switchContactCardToFriendCard != null) {
                    obj = switchContactCardToFriendCard;
                }
                obtain.obj = obj;
                this.mUIHandler.sendMessage(obtain);
                return;
            }
            boolean z19 = !z17;
            if (!z19) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.mProfileCardInfo.allInOne.uin), "FriendProfileCardActivity");
                if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                    z18 = true;
                }
                z19 = z18;
            }
            if (z19) {
                Card profileCard = ((IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(this.mProfileCardInfo.allInOne.uin, true);
                Message obtain2 = Message.obtain();
                obtain2.what = 100;
                obtain2.obj = profileCard;
                this.mUIHandler.sendMessage(obtain2);
            }
        }
    }

    private boolean checkGotoCrmMainProfile(AppInterface appInterface, String str) {
        ICrmApi iCrmApi = (ICrmApi) appInterface.getRuntimeService(ICrmApi.class, "");
        IQidianManagerApi iQidianManagerApi = (IQidianManagerApi) appInterface.getRuntimeService(IQidianManagerApi.class, "");
        if (!iCrmApi.isCrmMainUinAndGetSimpleInfoIfNeed(str) && !iQidianManagerApi.isQidianMaster(str)) {
            return false;
        }
        iCrmApi.gotoCrmMainProfile(appInterface.getApplicationContext(), null, str, false, -1, true, -1);
        return true;
    }

    private boolean checkParamValidate(ProfileCardInfo profileCardInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("checkParamValidate allInOne=%s", profileCardInfo.allInOne));
        }
        AllInOne allInOne = profileCardInfo.allInOne;
        if (allInOne != null && !TextUtils.isEmpty(allInOne.uin)) {
            return true;
        }
        return false;
    }

    private boolean checkToJumpOther(Intent intent, AllInOne allInOne) {
        Intent profileCardIntent;
        Intent babyQProfileCardIntent;
        Serializable serializableExtra;
        if (intent.hasExtra(IProfileCardConst.KEY_WZRY_DATA) && (serializableExtra = intent.getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA)) != null) {
            Intent kPLProfileCardIntent = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getKPLProfileCardIntent(this);
            kPLProfileCardIntent.putExtra(IProfileCardConst.KEY_WZRY_DATA, serializableExtra);
            startActivity(kPLProfileCardIntent);
            finish();
            return true;
        }
        if (Utils.G(allInOne.uin) && (babyQProfileCardIntent = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getBabyQProfileCardIntent(this, allInOne)) != null) {
            startActivity(babyQProfileCardIntent);
            overridePendingTransition(0, 0);
            finish();
            return true;
        }
        if (!((IBmqqSegmentApi) QRoute.api(IBmqqSegmentApi.class)).isBmqqUinNoBlock(this.mProfileCardInfo.allInOne.uin) || (profileCardIntent = ((IQidianApi) QRoute.api(IQidianApi.class)).getProfileCardIntent(this, this.mProfileCardInfo.allInOne)) == null) {
            return false;
        }
        startActivity(profileCardIntent);
        finish();
        return true;
    }

    private void clearProfileRedDot() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (FriendProfileCardActivity.this.mProfileCardInfo.allInOne.f260789pa == 0 && peekAppRuntime != null) {
                    ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).onProfileRedTouchClick(peekAppRuntime);
                }
            }
        }, 5, null, false);
    }

    private void dealQQBrowserActivityIntent(Intent intent) {
        try {
            String name = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).getQQBrowserActivityClass().getName();
            ComponentName component = intent.getComponent();
            if (component != null && TextUtils.equals(component.getClassName(), name)) {
                String stringExtra = intent.getStringExtra("url");
                String stringExtra2 = intent.getStringExtra("big_brother_source_key");
                if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileCardActivity", 2, String.format("dealQQBrowserActivityIntent url=%s key=%s", stringExtra, stringExtra2));
                }
                if (TextUtils.isEmpty(stringExtra2)) {
                    intent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
                }
            }
        } catch (Exception e16) {
            QLog.d("FriendProfileCardActivity", 1, "", e16);
        }
    }

    private void destroyProfileContainer() {
        List<AbsProfileComponent> list = this.mProfileContainers;
        if (list != null) {
            Iterator<AbsProfileComponent> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().detachFromComponentCenter();
                } catch (Exception e16) {
                    QLog.e("FriendProfileCardActivity", 1, "destroyProfileContainer fail.", e16);
                }
            }
            this.mProfileContainers.clear();
        }
    }

    private void fixProfilePA() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (this.mProfileCardInfo.allInOne.f260789pa == 90) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.mProfileCardInfo.allInOne.uin), "FriendProfileCardActivity");
            if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                this.mProfileCardInfo.allInOne.f260789pa = 1;
            } else {
                this.mProfileCardInfo.allInOne.f260789pa = 19;
            }
        }
        AllInOne allInOne = this.mProfileCardInfo.allInOne;
        if (allInOne.profileEntryType == 100 && allInOne.f260789pa == 34 && !((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).isBindedIgnoreUpload(peekAppRuntime)) {
            this.mProfileCardInfo.allInOne.f260789pa = 29;
        }
        if (this.mProfileCardInfo.allInOne.f260789pa != 53 && TextUtils.equals(peekAppRuntime.getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin)) {
            this.mProfileCardInfo.allInOne.f260789pa = 0;
        }
    }

    private AllInOne getAllInOneForTroop(Intent intent, AllInOne allInOne) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return allInOne;
        }
        this.mProfileCardInfo.isTroopMemberCard = intent.hasExtra("troopUin");
        ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
        if (profileCardInfo.isTroopMemberCard) {
            profileCardInfo.troopUin = intent.getStringExtra("troopUin");
            this.mProfileCardInfo.troopMemberCard = new TroopMemberCard();
            if (allInOne == null) {
                String stringExtra = intent.getStringExtra("memberUin");
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = this.mProfileCardInfo.allInOne.uin;
                }
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra), "FriendProfileCardActivity");
                if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                    AllInOne allInOne2 = new AllInOne(stringExtra, 1);
                    allInOne2.nickname = friendsSimpleInfoWithUid.p();
                    allInOne2.remark = friendsSimpleInfoWithUid.r();
                    allInOne = allInOne2;
                } else {
                    allInOne = new AllInOne(stringExtra, 21);
                    allInOne.subSourceId = 11;
                }
            }
            if (!TextUtils.isEmpty(this.mProfileCardInfo.troopUin) && TextUtils.isEmpty(allInOne.troopCode)) {
                allInOne.troopCode = this.mProfileCardInfo.troopUin;
            }
            if (!TextUtils.isEmpty(allInOne.troopCode) && TextUtils.isEmpty(allInOne.troopUin)) {
                allInOne.troopUin = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(allInOne.troopCode);
            }
        }
        return allInOne;
    }

    private List<Integer> getContainerTypeList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(102);
        arrayList.add(103);
        arrayList.add(104);
        arrayList.add(105);
        arrayList.add(106);
        arrayList.add(107);
        arrayList.add(108);
        return arrayList;
    }

    private View getContainerView(int i3) {
        switch (i3) {
            case 102:
                return this.mHeaderContainerView;
            case 103:
                return this.mContentContainerView;
            case 104:
                return this.mBgContainerView;
            case 105:
                return this.mFgContainerView;
            case 106:
                return this.mTitleContainerView;
            case 107:
                return this.mBottomContainerView;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentAccountUin() {
        String currentAccountUin;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (currentAccountUin = peekAppRuntime.getCurrentAccountUin()) == null) {
            return "";
        }
        return currentAccountUin;
    }

    private LayoutInflater getInnerLayoutInflater(LayoutInflater layoutInflater) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return layoutInflater;
        }
        LayoutInflater layoutInflater2 = this.mLayoutInflaters.get();
        if (layoutInflater2 == null) {
            layoutInflater2 = layoutInflater.cloneInContext(this);
        }
        this.mLayoutInflaters.set(layoutInflater2);
        return layoutInflater2;
    }

    private AllInOne getProfileAllInOne(Intent intent) {
        AllInOne allInOneForTroop = getAllInOneForTroop(intent, (AllInOne) intent.getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE));
        if (allInOneForTroop != null && TextUtils.isEmpty(allInOneForTroop.uid) && !TextUtils.isEmpty(allInOneForTroop.uin)) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(allInOneForTroop.uin);
            if (TextUtils.isEmpty(uidFromUin)) {
                allInOneForTroop.uid = uidFromUin;
            }
        }
        return allInOneForTroop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetProfileCard(boolean z16, Object obj) {
        Card card;
        ContactCard contactCard;
        boolean p16;
        boolean z17 = false;
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("onGetProfileCard isSuccess=%s data=%s", Boolean.valueOf(z16), obj));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            return;
        }
        if (checkGotoCrmMainProfile((AppInterface) peekAppRuntime, this.mProfileCardInfo.allInOne.uin)) {
            finish();
            return;
        }
        boolean isPaTypeHasUin = ProfilePAUtils.isPaTypeHasUin(this.mProfileCardInfo.allInOne);
        AllInOne allInOne = this.mProfileCardInfo.allInOne;
        if (allInOne.f260789pa == 41 && (TextUtils.isEmpty(allInOne.uin) || this.mProfileCardInfo.allInOne.uin.equals("0"))) {
            isPaTypeHasUin = false;
        }
        boolean z18 = obj instanceof Card;
        Card card2 = null;
        if (z18 && isPaTypeHasUin) {
            card = (Card) obj;
            boolean p17 = Utils.p(this.mProfileCardInfo.allInOne.uin, card.uin);
            if ((card.lUserFlag & 1) != 0) {
                ((IEnterpriseQQService) peekAppRuntime.getRuntimeService(IEnterpriseQQService.class, "")).getMenuFromNet(card.uin, false);
            }
            z17 = p17;
        } else {
            if ((obj instanceof ContactCard) && !isPaTypeHasUin) {
                contactCard = (ContactCard) obj;
                boolean p18 = Utils.p(contactCard.mobileNo, addNationCodeIfNeeded(ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne)));
                AllInOne allInOne2 = this.mProfileCardInfo.allInOne;
                allInOne2.uin = contactCard.mobileNo;
                ArrayList<ProfileContactInfo> arrayList = allInOne2.contactArray;
                if (arrayList != null && arrayList.size() > 0) {
                    allInOne2.contactArray.get(0).phoneNumber = contactCard.mobileNo;
                }
                z17 = p18;
            } else {
                if (obj instanceof String) {
                    String mobileNumberWithNationCode = ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne);
                    String str = (String) obj;
                    if (isPaTypeHasUin) {
                        p16 = Utils.p(str, this.mProfileCardInfo.allInOne.uin);
                    } else {
                        p16 = Utils.p(str, mobileNumberWithNationCode);
                    }
                    z17 = p16;
                } else if (z18 && !isPaTypeHasUin) {
                    card = (Card) obj;
                    z17 = Utils.p(this.mProfileCardInfo.allInOne.encId, card.encId);
                    this.mProfileCardInfo.allInOne.uin = card.uin;
                }
                contactCard = null;
            }
            handleNotifyProfileCard(z16, card2, contactCard, z17);
        }
        card2 = card;
        contactCard = null;
        handleNotifyProfileCard(z16, card2, contactCard, z17);
    }

    private void handleNotifyProfileCard(boolean z16, Card card, ContactCard contactCard, boolean z17) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (z16) {
            if (z17 && card != null) {
                WeakReferenceHandler weakReferenceHandler = this.mSubHandler;
                if (weakReferenceHandler != null) {
                    Message obtainMessage = weakReferenceHandler.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.obj = card;
                    obtainMessage.arg1 = 1;
                    this.mSubHandler.sendMessage(obtainMessage);
                }
                IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) peekAppRuntime.getRuntimeService(IQQAvatarHandlerService.class, "");
                if (iQQAvatarHandlerService != null) {
                    AllInOne allInOne = this.mProfileCardInfo.allInOne;
                    if (allInOne.discussUin != null) {
                        if (ProfilePAUtils.isPaTypeHasUin(allInOne)) {
                            iQQAvatarHandlerService.getCustomHead(this.mProfileCardInfo.allInOne.uin);
                            return;
                        }
                        return;
                    }
                    iQQAvatarHandlerService.getCustomHead(allInOne.uin);
                    return;
                }
                return;
            }
            if (z17 && contactCard != null) {
                if (TextUtils.isEmpty(this.mProfileCardInfo.allInOne.contactName)) {
                    AllInOne allInOne2 = this.mProfileCardInfo.allInOne;
                    allInOne2.contactName = allInOne2.nickname;
                }
                if (ProfileCardUtil.isContactNicknameValid(contactCard.nickName)) {
                    this.mProfileCardInfo.allInOne.nickname = contactCard.nickName;
                }
                if (!TextUtils.isEmpty(contactCard.uin)) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(contactCard.uin), "FriendProfileCardActivity");
                    if (friendsSimpleInfoWithUid != null) {
                        this.mProfileCardInfo.allInOne.remark = friendsSimpleInfoWithUid.r();
                    }
                }
                ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
                profileCardInfo.allInOne.bindQQ = contactCard.bindQQ;
                profileCardInfo.contactCard = contactCard;
                ProfileCardInfo fillProfileCardInfo = ProfileCardUtil.fillProfileCardInfo(contactCard);
                WeakReferenceHandler weakReferenceHandler2 = this.mUIHandler;
                if (weakReferenceHandler2 != null) {
                    Message obtainMessage2 = weakReferenceHandler2.obtainMessage();
                    obtainMessage2.what = 101;
                    obtainMessage2.obj = fillProfileCardInfo;
                    obtainMessage2.arg1 = 1;
                    this.mUIHandler.sendMessage(obtainMessage2);
                }
                IQQAvatarHandlerService iQQAvatarHandlerService2 = (IQQAvatarHandlerService) peekAppRuntime.getRuntimeService(IQQAvatarHandlerService.class, "");
                if (iQQAvatarHandlerService2 != null && !TextUtils.isEmpty(contactCard.mobileNo)) {
                    iQQAvatarHandlerService2.getMobileQQHead(contactCard.mobileNo);
                    return;
                }
                return;
            }
            return;
        }
        ProfileCardInfo profileCardInfo2 = this.mProfileCardInfo;
        Card card2 = profileCardInfo2.card;
        if ((card2 != null && card2.lCurrentStyleId == -1) || ProfileCardUtil.shouldNotifyUpdateCardOnFail(profileCardInfo2)) {
            Card card3 = this.mProfileCardInfo.card;
            card3.lCurrentStyleId = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
            card3.templateRet = 0;
            WeakReferenceHandler weakReferenceHandler3 = this.mSubHandler;
            if (weakReferenceHandler3 != null) {
                Message obtainMessage3 = weakReferenceHandler3.obtainMessage();
                obtainMessage3.what = 3;
                obtainMessage3.obj = this.mProfileCardInfo.card;
                this.mSubHandler.sendMessage(obtainMessage3);
            }
        }
        ContactCard contactCard2 = this.mProfileCardInfo.contactCard;
        if (z17 && contactCard2 != null && !contactCard2.isForbidAccount) {
            ContactCard contactCardByMobileNo = ((IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "all")).getContactCardByMobileNo(contactCard2.mobileNo, true);
            if (contactCardByMobileNo.isForbidAccount) {
                ProfileCardInfo profileCardInfo3 = this.mProfileCardInfo;
                Card card4 = profileCardInfo3.card;
                card4.isForbidAccount = true;
                int i3 = contactCardByMobileNo.forbidCode;
                card4.forbidCode = i3;
                ContactCard contactCard3 = profileCardInfo3.contactCard;
                contactCard3.isForbidAccount = true;
                contactCard3.forbidCode = i3;
                Message obtain = Message.obtain();
                obtain.what = 101;
                obtain.obj = this.mProfileCardInfo;
                obtain.arg1 = 0;
                this.mUIHandler.sendMessage(obtain);
            }
        }
    }

    private void handleRequestProfileCard1(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 40) {
                    if (i3 != 60) {
                        if (i3 == 78) {
                            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 24, j3, (byte) 1, 0L, 0L, bArr, "", j16, 3022, bArr2, (byte) 0);
                            return;
                        }
                        return;
                    }
                    iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 26, j3, (byte) 1, 0L, 0L, bArr, "", j16, 10004, bArr2, b16);
                    return;
                }
                iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 1, j3, (byte) 1, 0L, 0L, bArr, "", j16, 10004, bArr2, b16);
                return;
            }
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 1, j3, (byte) 1, 0L, 0L, bArr, "", j16, 10004, bArr2, b16);
            return;
        }
        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 0, j3, (byte) 1, 0L, 0L, bArr, "", j16, 10004, bArr2, b16);
    }

    private void handleRequestProfileCard10(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        if (i3 != 96) {
            if (i3 != 107 && i3 != 110) {
                if (i3 == 112) {
                    iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3004, bArr2, (byte) 0);
                    return;
                }
                switch (i3) {
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                        break;
                    default:
                        switch (i3) {
                            case 101:
                            case 102:
                            case 103:
                                break;
                            default:
                                return;
                        }
                }
            }
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 25, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3045, bArr2, (byte) 0);
            return;
        }
        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 53, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3094, bArr2, (byte) 0);
    }

    private void handleRequestProfileCard11(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        if (i3 != 113) {
            if (i3 != 115) {
                if (i3 == 117) {
                    iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3076, bArr2, (byte) 0);
                    return;
                }
                return;
            }
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 71, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3050, bArr2, (byte) 0);
            return;
        }
        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3004, bArr2, (byte) 0);
    }

    private void handleRequestProfileCard2(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        String str;
        int i16;
        if (i3 != 30) {
            if (i3 != 36) {
                if (i3 != 73 && i3 != 86) {
                    if (i3 != 41) {
                        if (i3 != 42) {
                            return;
                        }
                    } else {
                        if (!TextUtils.isEmpty(this.mProfileCardInfo.allInOne.uin) && !this.mProfileCardInfo.allInOne.uin.equals("0")) {
                            str = "";
                            i16 = 6;
                        } else {
                            str = this.mProfileCardInfo.allInOne.encId;
                            i16 = 37;
                        }
                        String currentAccountUin = getCurrentAccountUin();
                        String str2 = this.mProfileCardInfo.allInOne.uin;
                        iProfileProtocolService.requestProfileCard(currentAccountUin, str2, i16, j3, (byte) 0, 0L, 0L, bArr, str, j16, 10004, bArr2, (byte) 0);
                        return;
                    }
                }
                iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 8, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
                return;
            }
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), "0", 32, j3, (byte) 0, 0L, 0L, bArr, ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne), j16, 3014, bArr2, (byte) 0);
            return;
        }
        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 15, j3, (byte) 1, 0L, 0L, bArr, "", j16, 10004, bArr2, b16);
    }

    private void handleRequestProfileCard3(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        int i16 = 50;
        if (i3 == 29 || i3 == 34 || i3 == 53 || i3 == 31 || i3 == 32 || i3 == 50 || i3 == 51) {
            AllInOne allInOne = this.mProfileCardInfo.allInOne;
            int i17 = allInOne.f260789pa;
            if (i17 == 34) {
                i16 = 17;
            } else if (i17 != 53) {
                i16 = 16;
            }
            String addNationCodeIfNeeded = addNationCodeIfNeeded(ProfileUtils.getMobileNumberWithNationCode(allInOne));
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), "0", i16, j3, (byte) 0, 0L, 0L, bArr, addNationCodeIfNeeded, j16, 10004, null, (byte) 0);
        }
    }

    private void handleRequestProfileCard4(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        long j17;
        int i16;
        int i17;
        boolean z17;
        byte b17;
        switch (i3) {
            case 45:
            case 46:
            case 47:
                String str = this.mProfileCardInfo.allInOne.discussUin;
                if (str != null) {
                    try {
                        j17 = Long.parseLong(str);
                    } catch (Exception unused) {
                        j17 = 0;
                    }
                    long j18 = j17;
                    int i18 = this.mProfileCardInfo.allInOne.f260789pa;
                    if (i18 == 45) {
                        i17 = 13;
                        z17 = true;
                    } else {
                        if (i18 == 46) {
                            i16 = 4;
                        } else {
                            i16 = 14;
                        }
                        i17 = i16;
                        z17 = false;
                    }
                    if (z17) {
                        b17 = b16;
                    } else {
                        b17 = 0;
                    }
                    iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, i17, j3, (byte) 0, j18, 0L, bArr, "", j16, 10004, bArr2, b17);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void handleRequestProfileCard5(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        int i16;
        int i17;
        byte b17;
        byte b18;
        if (i3 != 3) {
            if (i3 != 58) {
                switch (i3) {
                    case 20:
                    case 21:
                    case 22:
                        break;
                    default:
                        return;
                }
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                long troopCode = ProfileUtils.getTroopCode((AppInterface) peekAppRuntime, this.mProfileCardInfo.allInOne);
                int i18 = this.mProfileCardInfo.allInOne.f260789pa;
                if (i18 == 20) {
                    i17 = 2;
                    b17 = 1;
                } else {
                    if (i18 != 21 && i18 != 58) {
                        if (i18 == 22) {
                            i16 = 7;
                        } else {
                            i16 = 12;
                        }
                    } else {
                        i16 = 5;
                    }
                    i17 = i16;
                    b17 = 0;
                }
                if (b17 == 1) {
                    b18 = b16;
                } else {
                    b18 = 0;
                }
                iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, i17, j3, b17, troopCode, 0L, bArr, "", j16, 10004, bArr2, b18);
                return;
            }
            return;
        }
        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 21, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
    }

    private void handleRequestProfileCard6(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        if (i3 != 2) {
            if (i3 != 35 && i3 != 37) {
                if (i3 != 61) {
                    if (i3 != 70) {
                        if (i3 != 74) {
                            if (i3 == 75) {
                                iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 38, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3017, bArr2, (byte) 0);
                                return;
                            }
                            return;
                        }
                        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 10, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
                        return;
                    }
                    iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 36, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
                    return;
                }
                iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 27, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
                return;
            }
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 31, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3001, bArr2, (byte) 0);
            return;
        }
        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 10, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
    }

    private void handleRequestProfileCard7(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        int i16;
        String str;
        AppRuntime peekAppRuntime;
        long j17;
        if (i3 != 108) {
            switch (i3) {
                case 25:
                case 26:
                case 27:
                case 28:
                    break;
                default:
                    return;
            }
        }
        AllInOne allInOne = this.mProfileCardInfo.allInOne;
        if (allInOne.f260789pa == 27) {
            i16 = 35;
        } else {
            i16 = 11;
        }
        int i17 = i16;
        int i18 = allInOne.sourceID;
        String str2 = "0";
        if (i18 != 3004 && i18 != 2004) {
            if (i18 == 3005 || i18 == 2005) {
                str2 = allInOne.troopCode;
            }
        } else {
            if (!TextUtils.isEmpty(allInOne.troopCode)) {
                str = this.mProfileCardInfo.allInOne.troopCode;
            } else if (TextUtils.isEmpty(this.mProfileCardInfo.allInOne.troopUin) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                str = "0";
            } else {
                str = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopCodeByTroopUin(this.mProfileCardInfo.allInOne.troopUin);
            }
            if (str != null) {
                str2 = str;
            }
        }
        try {
            j17 = Long.parseLong(str2);
        } catch (Exception unused) {
            j17 = 0;
        }
        long j18 = j17;
        String currentAccountUin = getCurrentAccountUin();
        AllInOne allInOne2 = this.mProfileCardInfo.allInOne;
        iProfileProtocolService.requestProfileCard(currentAccountUin, allInOne2.uin, i17, j3, (byte) 0, j18, 0L, bArr, "", j16, allInOne2.sourceID, bArr2, (byte) 0);
    }

    private void handleRequestProfileCard8(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        if (i3 != 4) {
            if (i3 != 19) {
                if (i3 != 52) {
                    if (i3 != 77 && i3 != 95) {
                        if (i3 != 97) {
                            if (i3 != 111 && i3 != 120 && i3 != 124 && i3 != 126 && i3 != 23 && i3 != 24) {
                                switch (i3) {
                                    case 104:
                                    case 105:
                                    case 106:
                                        break;
                                    default:
                                        return;
                                }
                            }
                        } else {
                            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3095, bArr2, (byte) 0);
                            return;
                        }
                    }
                } else {
                    iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 24, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
                    return;
                }
            }
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
            return;
        }
        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 25, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
    }

    private void handleRequestProfileCard9(int i3, IProfileProtocolService iProfileProtocolService, long j3, byte[] bArr, byte[] bArr2, boolean z16, long j16, byte b16) {
        if (i3 != 71) {
            if (i3 != 72) {
                if (i3 != 98) {
                    switch (i3) {
                        case 55:
                            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 28, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, b16);
                            return;
                        case 56:
                            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 29, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
                            return;
                        case 57:
                            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 30, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
                            return;
                        default:
                            return;
                    }
                }
                iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 12, j3, (byte) 0, 0L, 0L, bArr, "", j16, 3096, bArr2, (byte) 0);
                return;
            }
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 34, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
            return;
        }
        iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 33, j3, (byte) 0, 0L, 0L, bArr, "", j16, 10004, bArr2, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetCardTemplateReturn(boolean z16, Object obj) {
        AllInOne allInOne;
        WeakReferenceHandler weakReferenceHandler;
        if (z16 && (allInOne = this.mProfileCardInfo.allInOne) != null && allInOne.f260789pa != 33 && (weakReferenceHandler = this.mSubHandler) != null) {
            Message obtainMessage = weakReferenceHandler.obtainMessage();
            if (ProfilePAUtils.isPaTypeHasUin(this.mProfileCardInfo.allInOne)) {
                obtainMessage.what = 1;
                obtainMessage.obj = this.mProfileCardInfo.allInOne.uin;
                this.mSubHandler.sendMessage(obtainMessage);
            }
        }
    }

    private void handleSwitchVasCard() {
        boolean isVasProfileCard = isVasProfileCard();
        if (this.mIsVasProfileCard != isVasProfileCard) {
            this.mIsVasProfileCard = isVasProfileCard;
            if (QQTheme.isNowSimpleUI() && SWITCH_TO_NEW_PROFILE_CARD) {
                return;
            }
            this.mProfileDelegate.getProfileCardMultiple(isVasProfileCard);
            initProfileCardLayout();
            destroyProfileContainer();
            initProfileFramework();
            updateTheme();
        }
    }

    private void initCardInfo() {
        Message obtainMessage;
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "send async message to init card in db");
        }
        if (this.mSubHandler != null) {
            AllInOne allInOne = this.mProfileCardInfo.allInOne;
            if (allInOne.f260789pa == 33) {
                obtainMessage = null;
            } else if (ProfilePAUtils.isPaTypeHasUin(allInOne)) {
                obtainMessage = this.mSubHandler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = this.mProfileCardInfo.allInOne.uin;
                if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileCardActivity", 2, "SUB_MSG_INIT_CARD.uni:" + this.mProfileCardInfo.allInOne.uin);
                }
            } else {
                obtainMessage = this.mSubHandler.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.obj = this.mProfileCardInfo.allInOne.uin;
                if (QLog.isColorLevel()) {
                    QLog.d("FriendProfileCardActivity", 2, "SUB_MSG_INIT_CONTACT_CARD.uni:" + this.mProfileCardInfo.allInOne.uin);
                }
            }
            if (obtainMessage != null) {
                this.mSubHandler.sendMessage(obtainMessage);
            }
        }
    }

    private void initComponentCenter() {
        if (this.mComponentCenter == null) {
            ComponentCenter componentCenter = new ComponentCenter();
            this.mComponentCenter = componentCenter;
            componentCenter.init(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initContactCard() {
        String addNationCodeIfNeeded;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (addNationCodeIfNeeded = addNationCodeIfNeeded(ProfileUtils.getMobileNumberWithNationCode(this.mProfileCardInfo.allInOne))) != null && addNationCodeIfNeeded.length() > 0) {
            IProfileDataService iProfileDataService = (IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
            ContactCard contactCardByMobileNo = iProfileDataService.getContactCardByMobileNo(addNationCodeIfNeeded, true);
            ProfileContactInfo cardContactInfo = ProfileUtils.getCardContactInfo(this.mProfileCardInfo.allInOne);
            if (cardContactInfo != null) {
                contactCardByMobileNo.nationCode = cardContactInfo.phoneNationalCode;
                contactCardByMobileNo.mobileCode = cardContactInfo.phoneNumber;
                contactCardByMobileNo.strContactName = cardContactInfo.phoneName;
            }
            if (!ProfileCardUtil.isContactNicknameValid(contactCardByMobileNo.nickName)) {
                contactCardByMobileNo.nickName = this.mProfileCardInfo.allInOne.nickname;
            }
            iProfileDataService.saveContactCard(contactCardByMobileNo);
            this.mProfileCardInfo.allInOne.bindQQ = contactCardByMobileNo.bindQQ;
            if (!TextUtils.isEmpty(contactCardByMobileNo.uin)) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(contactCardByMobileNo.uin), "FriendProfileCardActivity");
                if (friendsSimpleInfoWithUid != null) {
                    this.mProfileCardInfo.allInOne.remark = friendsSimpleInfoWithUid.r();
                }
            }
            updateNameArrayByContactCard(contactCardByMobileNo, false);
            ProfileNameUtils.updateProfileName(this.mProfileCardInfo);
            ProfileCardInfo fillProfileCardInfo = ProfileCardUtil.fillProfileCardInfo(contactCardByMobileNo);
            Message obtain = Message.obtain();
            obtain.what = 101;
            obtain.obj = fillProfileCardInfo;
            obtain.arg1 = 0;
            this.mUIHandler.sendMessage(obtain);
            requestUpdateCard(0L, null, null, false);
        }
    }

    private void initContactCardInfoList(boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).initContactCardInfoList((AppInterface) peekAppRuntime, this.mProfileCardInfo, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDtReport() {
        int i3;
        Bundle bundle;
        String str;
        int i16;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.mRootView, DTREPORT_PAGE_USER_PROFILE_ELEGANT);
        HashMap hashMap = new HashMap();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i17 = 2;
        if (peekAppRuntime instanceof AppInterface) {
            if (ProfileUtils.isFriend((AppInterface) peekAppRuntime, this.mProfileCardInfo.allInOne.uin)) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            hashMap.put("is_qq_fri", Integer.valueOf(i16));
        }
        if (this.mProfileCardInfo.allInOne.f260789pa == 0) {
            i17 = 1;
        }
        hashMap.put("user_profile_host_guest_type", Integer.valueOf(i17));
        if (ProfileCardVersionController.getVersion().equals(ProfileCardVersion.V_ELEGANT)) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        hashMap.put("profile_version", Integer.valueOf(i3));
        AllInOne allInOne = this.mProfileCardInfo.allInOne;
        if (allInOne.f260789pa != 0) {
            hashMap.put("to_uin", allInOne.uin);
        }
        AllInOne allInOne2 = this.mProfileCardInfo.allInOne;
        if (allInOne2 != null && (bundle = allInOne2.extras) != null) {
            int i18 = bundle.getInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID);
            int i19 = this.mProfileCardInfo.allInOne.extras.getInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID);
            if (i18 != 0) {
                hashMap.put(ProfileCardConst.ENTER_PAGE_SOURCE_ID, Integer.valueOf(i18));
                hashMap.put(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, Integer.valueOf(i19));
            }
            if (i18 == 1) {
                hashMap.put(ProfileCardConst.ENTER_PAGE_GRP_ID, this.mProfileCardInfo.allInOne.troopUin);
            }
            if (ProfilePAUtils.isFromTroopMemberCard(this.mProfileCardInfo.allInOne.f260789pa)) {
                hashMap.put("group_id", this.mProfileCardInfo.allInOne.troopUin);
            }
            int i26 = this.mProfileCardInfo.allInOne.extras.getInt(IProfileCardConst.PARAM_ADD_FRIEND_SUB_ID);
            int i27 = this.mProfileCardInfo.allInOne.extras.getInt(IProfileCardConst.PARAM_ADD_FRIEND_ID);
            byte[] byteArray = this.mProfileCardInfo.allInOne.extras.getByteArray("recommend_algh_id");
            String string = this.mProfileCardInfo.allInOne.extras.getString("recommend_reason");
            if (byteArray != null && byteArray.length > 0) {
                str = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                str = "";
            }
            if (i26 != 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("user_request_subsourceid", i26);
                    jSONObject.put("user_request_sourceid", i27);
                    jSONObject.put("algo_id", str);
                    jSONObject.put("reason", string);
                    hashMap.put("ext", jSONObject);
                } catch (JSONException e16) {
                    QLog.e("FriendProfileCardActivity", 1, "initDtReport error:", e16);
                }
            }
        }
        hashMap.put(ProfileCardConst.IS_BLACK_LIST, Integer.valueOf(((IProfileCardBlacklistApi) QRoute.api(IProfileCardBlacklistApi.class)).getProfileCardBlacklistReportType(this.mProfileCardInfo.allInOne.uin)));
        VideoReport.setPageContentId(this.mRootView, FriendProfileCardActivity.class.getName());
        VideoReport.setPageParams(this.mRootView, new PageParams(hashMap));
    }

    private void initDtReportInSubThread() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    FriendProfileCardActivity.this.initDtReport();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 32, null, true);
    }

    private void initPerformanceReport() {
        ProfilePerformancePart profilePerformancePart = new ProfilePerformancePart();
        this.mDrawPerformancePart = profilePerformancePart;
        profilePerformancePart.onCreate();
        this.mDrawPerformancePart.startMonitor(this, ProfilePerformanceHelper.sceneOnDraw);
        ProfilePerformancePart profilePerformancePart2 = new ProfilePerformancePart();
        this.mScrollPerformancePart = profilePerformancePart2;
        profilePerformancePart2.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initProfileCard(String str) {
        boolean z16;
        byte[] bArr;
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("initProfileCard uin=%s", str));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ProfileCardTracer.tagNode("fetch_local_data_start_time");
        Card profileCard = ((IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "")).getProfileCard(str, true);
        if (profileCard != null) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(profileCard.uin), "FriendProfileCardActivity");
            if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !this.mProfileCardInfo.allInOne.uin.equals(peekAppRuntime.getCurrentAccountUin()) && !ProfilePAUtils.isPaTypeFriend(this.mProfileCardInfo.allInOne)) {
                this.mProfileCardInfo.allInOne.f260789pa = 1;
            }
            this.mProfileCardInfo.card = profileCard;
            ProfileCardTracer.tagNode("fetch_local_data_end_time");
            onCardUpdate(profileCard, false, 1, false);
            ProfileCardTracer.tagNode("request_data_time");
            byte[] bArr2 = profileCard.vSeed;
            AllInOne allInOne = this.mProfileCardInfo.allInOne;
            int i3 = allInOne.f260789pa;
            if (i3 != 56 && i3 != 57) {
                if (i3 != 35 && i3 != 37 && i3 != 36) {
                    bArr = null;
                } else {
                    bArr = allInOne.chatCookie;
                }
            } else {
                bArr = allInOne.chatCookie;
            }
            requestUpdateCard(profileCard.feedPreviewTime, bArr2, bArr, false);
        }
    }

    private void initProfileCardLayout() {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "initProfileCardLayout");
        }
        View inflate = View.inflate(this, R.layout.b0y, null);
        this.mRootView = inflate;
        this.mLoadingView = (LinearLayout) inflate.findViewById(R.id.f28160i7);
        this.mBgContainerView = this.mRootView.findViewById(R.id.f27930hk);
        this.mFgContainerView = this.mRootView.findViewById(R.id.f28130i4);
        this.mTitleContainerView = this.mRootView.findViewById(R.id.f28390it);
        this.mBottomContainerView = this.mRootView.findViewById(R.id.f27940hl);
        PullToZoomHeaderListView pullToZoomHeaderListView = (PullToZoomHeaderListView) this.mRootView.findViewById(R.id.common_xlistview);
        this.mProfileListView = pullToZoomHeaderListView;
        pullToZoomHeaderListView.setVerticalScrollBarEnabled(false);
        this.mProfileListView.setMotionEventInterceptor(this);
        this.mProfileListView.setNeedCheckSpringback(true);
        this.mProfileListView.setOnScrollListener(this.onScrollListener);
        this.mProfileListView.setClickable(false);
        this.mProfileListView.setFocusable(false);
        View inflate2 = View.inflate(this, R.layout.azv, null);
        this.mContentView = inflate2;
        this.mHeaderContainerView = inflate2.findViewById(R.id.dk_);
        View findViewById = this.mContentView.findViewById(R.id.dkh);
        this.mContentContainerView = findViewById;
        findViewById.setVisibility(0);
        ImageView imageView = (ImageView) this.mContentView.findViewById(R.id.f165800dk2);
        if (imageView != null) {
            try {
                Animatable animatable = (Animatable) imageView.getDrawable();
                if (!animatable.isRunning()) {
                    animatable.start();
                }
            } catch (Exception unused) {
            }
        }
        this.mProfileListView.addHeaderView(this.mContentView);
        this.mProfileListView.setAdapter((ListAdapter) new XSimpleListAdapter(null));
        TopGestureLayout topGestureLayout = new TopGestureLayout(this);
        this.mTopView = topGestureLayout;
        topGestureLayout.setOnFlingGesture(this);
        this.mTopView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mTopView.addView(this.mRootView);
        setContentView(this.mTopView);
        FrameLayout frameLayout = (FrameLayout) findViewById(android.R.id.content);
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(getResources().getColorStateList(R.color.qui_common_bg_bottom_light).getDefaultColor());
        }
    }

    private void initProfileContainer() {
        AbsProfileComponent absProfileComponent;
        if (this.mProfileContainers == null) {
            this.mProfileContainers = new ArrayList();
        }
        this.mProfileContainers.clear();
        ((IProfileComponentApi) QRoute.api(IProfileComponentApi.class)).initProfileComponentArray(this.mProfileDelegate);
        Iterator<Integer> it = getContainerTypeList().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            try {
                absProfileComponent = ProfileUtils.create(intValue, this.mComponentCenter, this.mProfileCardInfo, this.mProfileDelegate);
                if (absProfileComponent != null) {
                    absProfileComponent.setContainerView(getContainerView(intValue));
                    absProfileComponent.attachToComponentCenter();
                }
            } catch (Exception e16) {
                QLog.e("FriendProfileCardActivity", 1, "initProfileContainer fail.", e16);
                absProfileComponent = null;
            }
            if (absProfileComponent != null) {
                this.mProfileContainers.add(absProfileComponent);
            }
        }
    }

    private void initProfileFramework() {
        try {
            initComponentCenter();
            initProfileContainer();
        } catch (Exception e16) {
            QLog.e("FriendProfileCardActivity", 1, "initComponentCenter fail.", e16);
            finish();
        }
    }

    private boolean isNeedHandleRequestProfileCardDefault(int i3) {
        for (int i16 : HANDLE_REQUEST_PROFILE_CARD_TYPE) {
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    private boolean isVasProfileCard() {
        Card card;
        ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            if (ProfileTemplateApi.isVasCustomBgTemplateStyleID(card.lCurrentStyleId)) {
                return false;
            }
            ProfileCardInfo profileCardInfo2 = this.mProfileCardInfo;
            if (profileCardInfo2.currentTemplate == null && !ProfileTemplateApi.isDiyTemplateStyleID(profileCardInfo2.card.lCurrentStyleId)) {
                return false;
            }
            return true;
        }
        return this.mIsVasProfileCard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchMemoryReportTask$2() {
        ProfilePerformancePart profilePerformancePart = this.mDrawPerformancePart;
        if (profilePerformancePart != null) {
            profilePerformancePart.captureMemoryOnStable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchRefreshUiReportTask$1() {
        ProfilePerformanceHelper.reportRefreshUICount(this.refreshUiCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerAvatarPublishListener$0(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
        QLog.d("FriendProfileCardActivity", 1, "bind success :$service");
        winkPublishServiceProxy2.addTaskListener(this.listener);
        this.winkPublishService = winkPublishServiceProxy2;
    }

    private void launchMemoryReportTask() {
        if (!ProfilePerformanceHelper.isEnable()) {
            return;
        }
        ProfilePerformancePart profilePerformancePart = this.mDrawPerformancePart;
        if (profilePerformancePart != null) {
            profilePerformancePart.captureMemoryOnStart();
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.profilecard.activity.c
            @Override // java.lang.Runnable
            public final void run() {
                FriendProfileCardActivity.this.lambda$launchMemoryReportTask$2();
            }
        }, 16, null, false, 2000L);
    }

    private void launchRefreshUiReportTask() {
        if (!ProfilePerformanceHelper.isEnable()) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.profilecard.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                FriendProfileCardActivity.this.lambda$launchRefreshUiReportTask$1();
            }
        }, 16, null, false, 3000L);
    }

    private byte needReqMedalWall() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return (byte) 0;
        }
        byte needReqMedalWall = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).needReqMedalWall(this, peekAppRuntime);
        ITroopInfoService iTroopInfoService = (ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
        if (profileCardInfo.isTroopMemberCard && iTroopInfoService.isQidianPrivateTroop(profileCardInfo.troopUin)) {
            return (byte) 0;
        }
        return needReqMedalWall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCardUpdate(Card card) {
        WeakReferenceHandler weakReferenceHandler = this.mSubHandler;
        if (weakReferenceHandler != null) {
            Message obtainMessage = weakReferenceHandler.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = card;
            this.mSubHandler.sendMessage(obtainMessage);
        }
    }

    private void notifyComponentDataUpdate() {
        handleSwitchVasCard();
        List<AbsProfileComponent> list = this.mProfileContainers;
        if (list != null) {
            Iterator<AbsProfileComponent> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().lambda$checkValidComponent$3(this.mProfileCardInfo);
                } catch (Exception e16) {
                    QLog.e("FriendProfileCardActivity", 1, "notifyComponentDataUpdate fail:" + e16.getMessage(), e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onCardUpdate(Card card, boolean z16, int i3, boolean z17) {
        int i16 = 1;
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("onCardUpdate card=%s isNetCard=%s msgType=%s isFromGetProfileCardRequest=%s", card, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17)));
        }
        if (card != null) {
            updateNameArrayByCard(card, z16);
            ProfileNameUtils.updateProfileName(this.mProfileCardInfo);
            byte[] bArr = card.tempChatSig;
            if (bArr != null && bArr.length > 0) {
                this.mProfileCardInfo.allInOne.chatCookie = bArr;
            }
            updateFriendDetail(card, z16);
            ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
            profileCardInfo.card = card;
            profileCardInfo.isFromGetProfileCardRequest = z17;
            ProfileTemplateApi.getTemplateManager(this.mComponentCenter).preNotifyOnCardUpdate(this, this.mProfileCardInfo);
            WeakReferenceHandler weakReferenceHandler = this.mUIHandler;
            if (weakReferenceHandler != null) {
                weakReferenceHandler.removeMessages(103);
                if (!z16) {
                    i16 = 0;
                }
                this.mUIHandler.obtainMessage(102, i16, i3, card).sendToTarget();
            }
        }
    }

    private void profileEntryReport() {
        int i3;
        int i16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (Utils.G(this.mProfileCardInfo.allInOne.uin)) {
            int i17 = this.mProfileCardInfo.allInOne.profileEntryType;
            if (i17 == 59) {
                i16 = 1;
            } else {
                if (i17 == 1) {
                    i3 = 2;
                } else if (i17 == 8) {
                    i3 = 3;
                } else {
                    i3 = 0;
                }
                i16 = i3;
            }
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800723B", "0X800723B", i16, 0, "", "", "", "");
        }
        int i18 = this.mProfileCardInfo.allInOne.profileEntryType;
        if (i18 == 118) {
            ReportController.o(null, "dc00898", "", "", "0X800A11E", "0X800A11E", 0, 0, "", "", "", "");
        } else if (i18 == 121) {
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A51D", "0X800A51D", 0, 0, "", "", "", "");
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "", "0X800A4BF", 0, 0, "", "", "", "");
        if (peekAppRuntime instanceof AppInterface) {
            ProfileCardReport.reportProfileEntry((AppInterface) peekAppRuntime, this.mProfileCardInfo);
        }
        if (ProfileCardVersionController.getVersion().equals(ProfileCardVersion.V_ELEGANT) && ProfilePAUtils.isPaTypeStrangerInContact(this.mProfileCardInfo.allInOne)) {
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C007", "0X800C007", ProfileCardReportUtil.getProfileSourceType(this.mProfileCardInfo.allInOne), 0, "", "", "", "");
        }
    }

    private void registerAvatarPublishListener() {
        WinkPublishHelper2.INSTANCE.bindService(1, new WinkPublishHelper2.Callback() { // from class: com.tencent.mobileqq.profilecard.activity.a
            @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
            public final void onServiceConnected(WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                FriendProfileCardActivity.this.lambda$registerAvatarPublishListener$0(winkPublishServiceProxy2);
            }
        });
    }

    private void registerDetailModifyReceiver() {
        if (this.mDetailModifyReceiver == null) {
            this.mDetailModifyReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Card profileCard;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        String currentAccountUin = FriendProfileCardActivity.this.getCurrentAccountUin();
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (FriendProfileCardActivity.this.mProfileCardInfo.allInOne.uin.equals(currentAccountUin) && peekAppRuntime != null && (profileCard = ((IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(FriendProfileCardActivity.this.mProfileCardInfo.allInOne.uin, false)) != null) {
                            FriendProfileCardActivity.this.requestUpdateCard(profileCard.feedPreviewTime, profileCard.vSeed, null, false);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                }
            };
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IProfileCardConst.ACTION_MODIFY_DETAIL_INFO);
                intentFilter.setPriority(Integer.MAX_VALUE);
                registerReceiver(this.mDetailModifyReceiver, intentFilter);
            } catch (Throwable th5) {
                QLog.e("FriendProfileCardActivity", 1, "registerDetailModifyReceiver fail.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProfileScrollListener(AbsListView.OnScrollListener onScrollListener) {
        List<AbsListView.OnScrollListener> list = this.mProfileScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportEndScroll() {
        ProfilePerformancePart profilePerformancePart;
        if (ProfilePerformanceHelper.isEnable() && (profilePerformancePart = this.mScrollPerformancePart) != null) {
            profilePerformancePart.endMonitor(ProfilePerformanceHelper.sceneOnScroll);
        }
    }

    private void reportOnNetResp(Card card, boolean z16) {
        int i3;
        String str;
        ProfilePerformancePart profilePerformancePart;
        int i16;
        if (card != null && (i16 = card.mQQLevelType) != 0) {
            i3 = i16;
        } else {
            i3 = 99999;
        }
        if (this.mProfileCardInfo.allInOne.f260789pa == 0) {
            if (z16 && !this.reportFlag) {
                this.reportFlag = true;
                ProfileCardPerformanceReport.reportLoadResult(true, "1", System.currentTimeMillis() - this.costTimeStart);
            }
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A777", i3, 0, "", "", "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A776", i3, 0, "", "", "", "");
            if (z16 && !this.reportFlag) {
                this.reportFlag = true;
                ProfileCardPerformanceReport.reportLoadResult(true, "2", System.currentTimeMillis() - this.costTimeStart);
            }
        }
        if (z16) {
            str = "refresh_ui_time";
        } else {
            str = "local_data_show_time";
        }
        ProfileCardTracer.tagNode(str);
        if (z16 && (profilePerformancePart = this.mDrawPerformancePart) != null) {
            profilePerformancePart.endMonitor(ProfilePerformanceHelper.sceneOnDraw);
        }
        this.refreshUiCount++;
    }

    private void reportOnNetRespFirst(boolean z16) {
        if (z16) {
            ProfileCardTracer.tagNode("response_data_time");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportStartScroll() {
        ProfilePerformancePart profilePerformancePart;
        if (ProfilePerformanceHelper.isEnable() && (profilePerformancePart = this.mScrollPerformancePart) != null) {
            profilePerformancePart.startMonitor(this, ProfilePerformanceHelper.sceneOnScroll);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUpdateCard(long j3, byte[] bArr, byte[] bArr2, boolean z16) {
        byte[] bArr3;
        byte[] bArr4;
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("requestUpdateCard forceRequest=%s mRequestCardCount=%s", Boolean.valueOf(z16), Integer.valueOf(this.mRequestCardCount)));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        int i3 = this.mRequestCardCount;
        if (i3 > 5 && !z16) {
            return;
        }
        this.mRequestCardCount = i3 + 1;
        if (bArr == null) {
            bArr3 = new byte[]{0};
        } else {
            bArr3 = bArr;
        }
        if (bArr2 == null) {
            bArr4 = new byte[]{0};
        } else {
            bArr4 = bArr2;
        }
        long control = ProfileUtils.getControl(this.mProfileCardInfo.allInOne, ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).needReqOCRCard(peekAppRuntime));
        byte needReqMedalWall = needReqMedalWall();
        IProfileProtocolService iProfileProtocolService = (IProfileProtocolService) peekAppRuntime.getRuntimeService(IProfileProtocolService.class, "all");
        byte[] bArr5 = bArr3;
        byte[] bArr6 = bArr4;
        handleRequestProfileCard1(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard2(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard3(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard4(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard5(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard6(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard7(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard8(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard9(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard10(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        handleRequestProfileCard11(this.mProfileCardInfo.allInOne.f260789pa, iProfileProtocolService, j3, bArr5, bArr6, z16, control, needReqMedalWall);
        if (!isNeedHandleRequestProfileCardDefault(this.mProfileCardInfo.allInOne.f260789pa)) {
            iProfileProtocolService.requestProfileCard(getCurrentAccountUin(), this.mProfileCardInfo.allInOne.uin, 65535, j3, (byte) 0, 0L, 0L, bArr3, "", control, BuddySource.DEFAULT, bArr4, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToListTop() {
        this.mProfileListView.smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToMoreInfoView(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("scrollToExtendsFriendInfo offset=%s", Integer.valueOf(i3)));
        }
        int height = (i3 + this.mHeaderContainerView.getHeight()) - getTitleBarHeight();
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("scrollToMoreInfoView offset=%s", Integer.valueOf(height)));
        }
        PullToZoomHeaderListView pullToZoomHeaderListView = this.mProfileListView;
        if (pullToZoomHeaderListView != null) {
            pullToZoomHeaderListView.smoothScrollToPositionFromTop(0, -height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInterceptTouchEvent(boolean z16) {
        QLog.e("FriendProfileCardActivity", 1, String.format("setInterceptTouchEvent intercept=%s", Boolean.valueOf(z16)));
        this.mInterceptTouchEvent = z16;
        TopGestureLayout topGestureLayout = this.mTopView;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewRemark(String str) {
        ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
        profileCardInfo.allInOne.remark = str;
        ProfileNameUtils.updateNameArray(profileCardInfo, 4, str);
        ProfileNameUtils.updateProfileName(this.mProfileCardInfo);
        notifyCardUpdate(null);
    }

    private void showBackOrStayDialogIfNeed() {
        String str = ProfileNameUtils.getCurCardName(this.mProfileCardInfo) + getResources().getString(R.string.third_app_add_friend_already);
        boolean booleanExtra = getIntent().getBooleanExtra(IProfileCardConst.KEY_FROM_APP_SHOW_DIALOG, false);
        String stringExtra = getIntent().getStringExtra("src_name");
        if (booleanExtra && !TextUtils.isEmpty(stringExtra)) {
            com.tencent.open.widget.b.e(this, str, stringExtra, null);
        }
    }

    private void showBackOrStayDialogIfNeedOptimize() {
        boolean booleanExtra = getIntent().getBooleanExtra(IProfileCardConst.KEY_FROM_APP_SHOW_DIALOG, false);
        String stringExtra = getIntent().getStringExtra("src_name");
        if (booleanExtra && !TextUtils.isEmpty(stringExtra)) {
            com.tencent.open.widget.b.e(this, ProfileNameUtils.getCurCardName(this.mProfileCardInfo) + HardCodeUtil.qqStr(R.string.third_app_add_friend_already), stringExtra, null);
        }
    }

    private void startTimeCheck() {
        WeakReferenceHandler weakReferenceHandler = this.mUIHandler;
        if (weakReferenceHandler != null) {
            this.mUIHandler.sendMessageDelayed(weakReferenceHandler.obtainMessage(103), 10000L);
        }
    }

    private Card switchContactCardToFriendCard(String str, String str2) {
        IProfileDataService iProfileDataService;
        ContactCard contactCardByMobileNo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (contactCardByMobileNo = (iProfileDataService = (IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "all")).getContactCardByMobileNo(str2, false)) == null) {
            return null;
        }
        Card profileCard = iProfileDataService.getProfileCard(str, true);
        profileCard.strContactName = contactCardByMobileNo.strContactName;
        profileCard.strMobile = contactCardByMobileNo.mobileNo;
        profileCard.age = contactCardByMobileNo.bAge;
        profileCard.shGender = contactCardByMobileNo.bSex;
        profileCard.strProvince = contactCardByMobileNo.strProvince;
        profileCard.strCity = contactCardByMobileNo.strCity;
        profileCard.strCountry = contactCardByMobileNo.strCountry;
        iProfileDataService.saveProfileCard(profileCard);
        return profileCard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchedToFriend(Card card, String str) {
        long j3;
        byte[] bArr;
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("switchedToFriend card=%s uin=%s", card, str));
        }
        AllInOne allInOne = this.mProfileCardInfo.allInOne;
        allInOne.f260789pa = 1;
        allInOne.uin = str;
        initContactCardInfoList(true);
        byte[] bArr2 = null;
        if (card != null) {
            j3 = card.feedPreviewTime;
            byte[] bArr3 = card.vSeed;
            this.mProfileCardInfo.card = card;
            updateCardInfo(card, false);
            bArr = bArr3;
        } else {
            initProfileCardLayout();
            destroyProfileContainer();
            initProfileFramework();
            j3 = 0;
            bArr = null;
        }
        long j16 = j3;
        AllInOne allInOne2 = this.mProfileCardInfo.allInOne;
        int i3 = allInOne2.f260789pa;
        if (i3 == 56 || i3 == 57) {
            bArr2 = allInOne2.chatCookie;
        }
        requestUpdateCard(j16, bArr, bArr2, true);
    }

    private void unregisterAvatarPublishListener() {
        WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.winkPublishService;
        if (winkPublishServiceProxy2 != null) {
            winkPublishServiceProxy2.removeTaskListener(this.listener);
        }
    }

    private void unregisterDetailModifyReceiver() {
        BroadcastReceiver broadcastReceiver = this.mDetailModifyReceiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e("FriendProfileCardActivity", 1, "unregisterDetailModifyReceiver fail.", e16);
            }
            this.mDetailModifyReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCardInfo(Card card, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("updateCardInfo card=%s isNetRet=%s", card, Boolean.valueOf(z16)));
        }
        reportOnNetRespFirst(z16);
        updateProfileCardInfo(card, z16);
        updateTheme();
        updateForbidState();
        notifyComponentDataUpdate();
        reportOnNetResp(card, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContactCardInfo(ProfileCardInfo profileCardInfo, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("updateContactCardInfo card=%s isNetRet=%s", profileCardInfo.contactCard, Boolean.valueOf(z16)));
        }
        ProfileCardInfo profileCardInfo2 = this.mProfileCardInfo;
        profileCardInfo2.contactCard = profileCardInfo.contactCard;
        profileCardInfo2.card = profileCardInfo.card;
        profileCardInfo2.isNetRet = z16;
        this.mIsShowZplanCover = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardShowZplanCover(this.mProfileCardInfo);
        this.mIsShowQCircleCover = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardShowQCircleCover(this.mProfileCardInfo);
        reportDtZplanEntranceExpose();
        updateNameArrayByContactCard(profileCardInfo.contactCard, z16);
        ProfileNameUtils.updateProfileName(this.mProfileCardInfo);
        notifyComponentDataUpdate();
        updateForbidState();
    }

    private void updateForbidState() {
        ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
        if (profileCardInfo != null && ProfileCardForbidAccountHelper.isForbidByAnyType(profileCardInfo)) {
            this.mContentContainerView.setVisibility(4);
            if (ProfileCardForbidAccountHelper.isForbidBySpecifyTypes(new ArrayList(Collections.singletonList(201)), this.mProfileCardInfo.card)) {
                QLog.i("FriendProfileCardActivity", 1, "updateForbidState forbidAccount");
                this.mForbidAccountHelper.showDialog(this);
                return;
            }
            return;
        }
        this.mContentContainerView.setVisibility(0);
    }

    private void updateFriendDetail(Card card, boolean z16) {
        boolean z17;
        boolean z18;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && this.mProfileCardInfo.allInOne.f260789pa != 0 && z16 && !this.mHasUpdateFriendsDetail) {
            this.mHasUpdateFriendsDetail = true;
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(card.uin), "FriendProfileCardActivity");
            if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if ((card.lUserFlag & 2048) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            QLog.i("FriendProfileCardActivity", 1, String.format("onCardUpdate isFriend=%s profileFriend=%s", Boolean.valueOf(z17), Boolean.valueOf(z18)));
            if (z18 != z17) {
                ((IFriendHandlerService) peekAppRuntime.getRuntimeService(IFriendHandlerService.class, "all")).requestFriendInfo(card.uin);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadingPage(boolean z16) {
        int i3;
        LinearLayout linearLayout = this.mLoadingView;
        if (linearLayout != null) {
            if (!isVasProfileCard() && z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        }
    }

    private void updateNameArrayByCard(Card card, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("updateNameArrayByCard isNetRet=%s", Boolean.valueOf(z16)));
        }
        if (card == null) {
            return;
        }
        if (z16 || !TextUtils.isEmpty(card.strNick)) {
            this.mProfileCardInfo.nameArray[0] = card.strNick;
        }
        if (z16 || !TextUtils.isEmpty(card.strReMark)) {
            this.mProfileCardInfo.nameArray[4] = card.strReMark;
        }
        if (z16 || !TextUtils.isEmpty(card.strAutoRemark)) {
            this.mProfileCardInfo.nameArray[6] = card.strAutoRemark;
        }
        if (!TextUtils.isEmpty(card.strContactName)) {
            this.mProfileCardInfo.nameArray[3] = card.strContactName;
        }
        if (!TextUtils.isEmpty(card.strAutoRemark)) {
            this.mProfileCardInfo.nameArray[2] = card.strAutoRemark;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "updateNameArray(), strNick = " + Utils.U(this.mProfileCardInfo.nameArray[0]) + ", strRemark = " + Utils.U(this.mProfileCardInfo.nameArray[4]) + ", strContactName = " + Utils.U(this.mProfileCardInfo.nameArray[3]) + ", strCircleName = " + Utils.U(this.mProfileCardInfo.nameArray[2]) + ", strRecommenName = " + Utils.U(this.mProfileCardInfo.nameArray[5]) + ", strTroopNickName = " + Utils.U(this.mProfileCardInfo.nameArray[1]) + ", strAutoRemark = " + Utils.U(this.mProfileCardInfo.nameArray[6]));
        }
    }

    private void updateNameArrayByContactCard(ContactCard contactCard, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("updateNameArrayByContactCard card=%s isNetRet=%s", contactCard, Boolean.valueOf(z16)));
        }
        if (contactCard == null) {
            return;
        }
        if ((z16 || !TextUtils.isEmpty(contactCard.nickName)) && ProfileCardUtil.isContactNicknameValid(contactCard.nickName)) {
            this.mProfileCardInfo.nameArray[0] = contactCard.nickName;
        }
        if (!TextUtils.isEmpty(contactCard.strContactName)) {
            this.mProfileCardInfo.nameArray[3] = contactCard.strContactName;
        }
    }

    private void updateProfileCardInfo(Card card, boolean z16) {
        ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
        profileCardInfo.card = card;
        profileCardInfo.isNetRet = z16;
        this.mIsShowZplanCover = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardShowZplanCover(this.mProfileCardInfo);
        this.mIsShowQCircleCover = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardShowQCircleCover(this.mProfileCardInfo);
        reportDtZplanEntranceExpose();
    }

    private void updateTheme() {
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "updateTheme");
        }
        try {
            ITemplateUtils templateUtils = ProfileTemplateApi.getTemplateUtils(this.mComponentCenter);
            FrameLayout frameLayout = (FrameLayout) findViewById(android.R.id.content);
            ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
            if (profileCardInfo.currentTemplate != null) {
                frameLayout.setForeground(null);
                this.mContentView.setBackgroundResource(0);
                templateUtils.updateViewAttr(this.mContentView, "background", this.mProfileCardInfo.currentTemplate, "background");
                if (ProfileTemplateApi.isDiyTemplateStyleID(this.mProfileCardInfo.card.lCurrentStyleId)) {
                    this.mContentContainerView.setBackgroundDrawable(null);
                    return;
                } else {
                    if (!ProfileTemplateApi.isVasCustomBgTemplateStyleID(this.mProfileCardInfo.card.lCurrentStyleId)) {
                        templateUtils.updateViewAttr(this.mContentContainerView, "background", this.mProfileCardInfo.currentTemplate, "commonMaskBackground");
                        return;
                    }
                    return;
                }
            }
            if (ProfileTemplateApi.isDiyTemplateStyleID(profileCardInfo.card.lCurrentStyleId)) {
                frameLayout.setForeground(null);
                frameLayout.setBackgroundDrawable(null);
                this.mContentView.setBackgroundResource(0);
                this.mContentContainerView.setBackgroundResource(0);
                return;
            }
            frameLayout.setForeground(getResources().getDrawable(R.drawable.skin_header_bar_shadow));
            this.mContentView.setBackgroundResource(0);
        } catch (Exception e16) {
            QLog.e("FriendProfileCardActivity", 1, "updateTheme fail.", e16);
        }
    }

    public void disableTopGestureLR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        TopGestureLayout topGestureLayout = this.mTopView;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptScrollLRFlag(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, String.format("doOnActivityResult requestCode=%s resultCode=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.onActivityResult(i3, i16, intent);
        }
        if (i3 == 1022) {
            backAndUpdateCard(intent);
            return;
        }
        if (i3 == 1012) {
            if (i16 == -1 && intent != null) {
                if (intent.getBooleanExtra("finchat", false)) {
                    finish();
                } else {
                    String stringExtra = intent.getStringExtra("remark");
                    if (!Utils.p(this.mProfileCardInfo.allInOne.remark, stringExtra)) {
                        setNewRemark(stringExtra);
                    }
                }
                backAndUpdateCard(intent);
                return;
            }
            return;
        }
        if (i3 == 99000) {
            if (i16 == -1) {
                setResult(-1);
                finish();
                return;
            }
            return;
        }
        if (i3 == 1039) {
            Intent intent2 = new Intent();
            intent2.putExtra(IProfileCardConst.PARAM_SWITCHES_CHANGED, true);
            backAndUpdateCard(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        getWindow().setFormat(-3);
        this.mActNeedImmersive = false;
        if (((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarPageTransitionAnim()) {
            try {
                requestWindowFeature(13);
            } catch (Exception e16) {
                QLog.e("FriendProfileCardActivity", 1, "doOnCreate: requestWindowFeature error", e16);
            }
        }
        super.doOnCreate(bundle);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intent intent = getIntent();
        if ((peekAppRuntime instanceof AppInterface) && !TextUtils.isEmpty(peekAppRuntime.getAccount()) && intent != null) {
            AllInOne profileAllInOne = getProfileAllInOne(intent);
            this.mProfileCardInfo.allInOne = profileAllInOne;
            if (ProfilePAUtils.isPaTypeStrangerInContact(profileAllInOne) && ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion()) {
                ProfileCardVersionController.forceElegant();
            }
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            this.mConfigHelper = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).createProfileConfig(appInterface);
            this.mSubHandler = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this.mSubCallback);
            this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
            if (!checkParamValidate(this.mProfileCardInfo)) {
                QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 2.");
                finish();
                return false;
            }
            if (checkToJumpOther(intent, profileAllInOne)) {
                QLog.e("FriendProfileCardActivity", 1, "doOnCreate jump to other.");
                return false;
            }
            fixProfilePA();
            clearProfileRedDot();
            registerDetailModifyReceiver();
            addObserver(this.profileCardObserver);
            try {
                initContactCardInfoList(false);
                this.mProfileCardInfo.nameArray = new String[8];
                ThreadManagerV2.excute(new Runnable(peekAppRuntime) { // from class: com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.7
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ AppRuntime val$app;

                    {
                        this.val$app = peekAppRuntime;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileCardActivity.this, (Object) peekAppRuntime);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            ProfileNameUtils.initNameArray((AppInterface) this.val$app, FriendProfileCardActivity.this.mProfileCardInfo);
                            ProfileNameUtils.updateProfileName(FriendProfileCardActivity.this.mProfileCardInfo);
                            if (!ProfilePAUtils.isPaTypeFriend(FriendProfileCardActivity.this.mProfileCardInfo.allInOne) && !ProfilePAUtils.isPaTypeStrangerInContact(FriendProfileCardActivity.this.mProfileCardInfo.allInOne)) {
                                FriendProfileCardActivity.this.checkAndSwitch2Friend(false, true, null);
                            }
                        } catch (Throwable th5) {
                            QLog.e("FriendProfileCardActivity", 1, "doOnCreate inner init fail.", th5);
                        }
                    }
                }, 16, null, true);
                this.mIsShowZplanCover = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardShowZplanCover(this.mProfileCardInfo);
                this.mIsShowQCircleCover = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isProfileCardShowQCircleCover(this.mProfileCardInfo);
                reportDtZplanEntranceExpose();
                initProfileCardLayout();
                updateLoadingPage(true);
                initProfileFramework();
                IComponentCenter iComponentCenter = this.mComponentCenter;
                if (iComponentCenter != null) {
                    iComponentCenter.onCreate(this, bundle);
                }
                ProfileCardTracer.tagNode("PAGE_INIT");
                ProfileCardInfo profileCardInfo = this.mProfileCardInfo;
                if (profileCardInfo.allInOne.f260789pa != 33) {
                    startTimeCheck();
                    initCardInfo();
                } else {
                    updateCardInfo(profileCardInfo.card, false);
                }
                profileEntryReport();
                initDtReportInSubThread();
                ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).downloadHDAvatar(getCurrentAccountUin(), peekAppRuntime);
                appInterface.addObserver(this.mAvatarObserver);
                SimpleEventBus.getInstance().registerReceiver(this);
                return true;
            } catch (Exception e17) {
                QLog.e("FriendProfileCardActivity", 1, "doOnCreate fail.", e17);
                finish();
                return false;
            } catch (OutOfMemoryError e18) {
                QLog.e("FriendProfileCardActivity", 1, "doOnCreate fail. OutOfMemoryError:" + e18.getMessage(), e18);
                finish();
                return false;
            }
        }
        QLog.e("FriendProfileCardActivity", 1, "doOnCreate invalid params 1.");
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        WeakReferenceHandler weakReferenceHandler = this.mUIHandler;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
            this.mUIHandler.removeMessages(0);
        }
        WeakReferenceHandler weakReferenceHandler2 = this.mSubHandler;
        if (weakReferenceHandler2 != null) {
            weakReferenceHandler2.removeCallbacksAndMessages(null);
            this.mSubHandler.removeMessages(0);
            this.mSubHandler = null;
        }
        IProfileConfig iProfileConfig = this.mConfigHelper;
        if (iProfileConfig != null) {
            iProfileConfig.destroy();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).removeObserver(this.mAvatarObserver);
        }
        removeObserver(this.profileCardObserver);
        unregisterDetailModifyReceiver();
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.onDestroy();
        }
        PullToZoomHeaderListView pullToZoomHeaderListView = this.mProfileListView;
        if (pullToZoomHeaderListView != null) {
            pullToZoomHeaderListView.onDestroy();
        }
        destroyProfileContainer();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ProfilePerformancePart profilePerformancePart = this.mDrawPerformancePart;
        if (profilePerformancePart != null) {
            profilePerformancePart.onPartDestroy(this);
            this.mDrawPerformancePart = null;
        }
        ProfilePerformancePart profilePerformancePart2 = this.mScrollPerformancePart;
        if (profilePerformancePart2 != null) {
            profilePerformancePart2.onPartDestroy(this);
            this.mScrollPerformancePart = null;
        }
        this.mForbidAccountHelper.doOnDestroy();
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.doOnPause();
        AbstractVideoImage.pauseAll();
        ApngImage.pauseAll();
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.onPause();
        }
        unregisterAvatarPublishListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnResume();
        AbstractVideoImage.resumeAll();
        ApngImage.playByTag(9);
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.onResume();
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isMyCard(this.mProfileCardInfo) && peekAppRuntime != null) {
                ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).preRecordActionInSummary(peekAppRuntime);
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).checkZPlanAvatarUpdate();
            }
        } catch (ArrayIndexOutOfBoundsException e16) {
            QLog.d("FriendProfileCardActivity", 1, "doOnResume.e:" + e16.toString());
        }
        registerAvatarPublishListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnStart();
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.onStart();
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_profilecard_performance_optimisation_switch", false)) {
            showBackOrStayDialogIfNeedOptimize();
        } else {
            showBackOrStayDialogIfNeed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnStop();
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        super.doOnWindowFocusChanged(z16);
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null) {
            iComponentCenter.onWindowFocusChanged(z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
    public void flingLToR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else if ((!com.tencent.mobileqq.onlinestatus.utils.a.b(this) || !OnlineStatusToggleUtils.t()) && this.mInterceptTouchEvent) {
            doOnBackPressed();
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
    public void flingRToL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ArrayList) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSetCoverFeedEvent.class);
        arrayList.add(MetaFarmCardOpenEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        }
        if ("layout_inflater".equals(str)) {
            Object systemService = super.getSystemService("layout_inflater");
            if (systemService instanceof LayoutInflater) {
                return getInnerLayoutInflater((LayoutInflater) systemService);
            }
        }
        return super.getSystemService(str);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        View view = this.mTitleContainerView;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    @Override // com.tencent.widget.XListView.MotionEventInterceptor
    public boolean intercept(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return !this.mInterceptTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isCloneInflaterInSubThreadEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isCloneInflaterInSubThreadForSplashActivity;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateLayoutInflaterEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isEnableDelegateLayoutInflaterForSplashActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.e("FriendProfileCardActivity", 2, "onBackEvent_TraceSrc_", new RuntimeException(""));
        }
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter != null && iComponentCenter.onBackPressed()) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendProfileCardActivity", 2, "onBackEvent event cost by component");
                return true;
            }
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        ProfileCardTracer.tagNode("page_on_create_time");
        initPerformanceReport();
        launchRefreshUiReportTask();
        launchMemoryReportTask();
        this.costTimeStart = System.currentTimeMillis();
        ProfileCardVersionController.initConfig();
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            updateTheme();
            notifyComponentDataUpdate();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSSetCoverFeedEvent) {
            QFSSetCoverFeedEvent qFSSetCoverFeedEvent = (QFSSetCoverFeedEvent) simpleBaseEvent;
            QCircleFeedCoverBean coverBean = qFSSetCoverFeedEvent.getCoverBean();
            if (coverBean != null) {
                Card card = this.mProfileCardInfo.card;
                card.qcircleFeedId = coverBean.qcircleFeedId;
                card.qcircleFeedPosterUin = coverBean.qcircleFeedPosterUin;
                card.qcircleVideoUrl = coverBean.qcircleVideoUrl;
                card.qcircleVideoHeight = coverBean.qcircleVideoHeight;
                card.qcircleVideoWidth = coverBean.qcircleVideoWidth;
                card.qcircleVideoCoverUrl = coverBean.qcircleVideoCoverUrl;
                card.qcircleCoverY = coverBean.qcircleCoverY;
                card.isShowQCircleCover = true;
                updateCardInfo(card, false);
                if (qFSSetCoverFeedEvent.getShouldFinishProfileCard() && !isFinishing()) {
                    finish();
                    return;
                }
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof MetaFarmCardOpenEvent) {
            Intent intent = new Intent();
            intent.putExtra(IProfileCardConst.PARAM_SWITCHES_CHANGED, true);
            backAndUpdateCard(intent);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        WeakReferenceHandler weakReferenceHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onRestart();
        if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "onRestart");
        }
        if (isFinishing()) {
            QLog.d("FriendProfileCardActivity", 2, "activity is finsihing, should not update profile info");
            return;
        }
        AllInOne allInOne = this.mProfileCardInfo.allInOne;
        if (allInOne != null && allInOne.f260789pa != 33 && (weakReferenceHandler = this.mSubHandler) != null) {
            Message obtainMessage = weakReferenceHandler.obtainMessage();
            if (ProfilePAUtils.isPaTypeHasUin(this.mProfileCardInfo.allInOne)) {
                obtainMessage.what = 1;
                obtainMessage.obj = this.mProfileCardInfo.allInOne.uin;
                this.mSubHandler.sendMessage(obtainMessage);
            }
        }
    }

    public void reportDtZplanEntranceExpose() {
        String str;
        String str2;
        Card card;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        boolean isMyCard = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isMyCard(this.mProfileCardInfo);
        if (this.mIsShowZplanCover && !this.hasReportZplanExpose) {
            HashMap hashMap = new HashMap();
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
            if (isMyCard) {
                str = ZootopiaSource.SUB_SOURCE_PROFILE_OWNER;
            } else {
                str = ZootopiaSource.SUB_SOURCE_PROFILE_VISITOR;
            }
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
            hashMap.put("zplan_action_type", "imp");
            if (!isMyCard && (card = this.mProfileCardInfo.card) != null) {
                hashMap.put("zplan_other_user_qq", card.uin);
            }
            if (((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isZplanUnderMaintenance()) {
                str2 = "maintaining";
            } else {
                str2 = "serviceable";
            }
            hashMap.put("zplan_entrance_status", str2);
            hashMap.put(EmotionReportDtImpl.IS_RED_TIPS_BEFORE, 0);
            VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
            this.hasReportZplanExpose = true;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, intent, Integer.valueOf(i3), bundle);
        } else {
            dealQQBrowserActivityIntent(intent);
            super.startActivityForResult(intent, i3, bundle);
        }
    }
}
