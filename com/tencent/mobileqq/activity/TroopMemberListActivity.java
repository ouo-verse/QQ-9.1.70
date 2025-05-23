package com.tencent.mobileqq.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.QProxyManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickSearchInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.memberlist.AddFrdHelper;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.ITroopMemberTempApi;
import com.tencent.qqnt.aio.at.widget.IndexBar;
import com.tencent.qqnt.aio.at.widget.IndexBarTipsLayout;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.TroopMemberDBExtInfoRepo;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotInfoUpdateService;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import h44.OpenRobotProfileCardArgs;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x406.cmd0x406$GroupFeeMember;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f$Range;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f$ReqBody;
import tencent.im.oidb.cmd0x74f.oidb_cmd0x74f$RspBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$UserInfo;

/* compiled from: P */
@RoutePage(desc = "\u7fa4\u6210\u5458\u5217\u8868", path = "/troop/memberlist/TroopMemberList")
/* loaded from: classes9.dex */
public class TroopMemberListActivity extends QBaseActivity implements AdapterView.OnItemClickListener, IndexView.b, IndexView.a {
    static IPatchRedirector $redirector_ = null;
    private static final long DEFAULT_SEARCH_LOADING_INTERVAL = 200;
    private static final double FAKE_DATA_MAX_PROGRESS = 0.9d;
    protected static double FAKE_PROGRESS_DELTA = 0.0d;
    public static final String GUEST_MEMBER_LIST_URL = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3";
    public static final String PARAM_DELETED_UINS = "param_deleted_uins";
    public static final String PARAM_SEQ_DAYS = "param_seq_days";
    public static final String PARAM_SEQ_NAME = "param_seq_name";
    private static final int PROCESS_MEM_COUNT_PER_JOB = 1000;
    private static final int[] SEARCHING_TIPS_ARRAY;
    private static final long SEARCH_BAR_ANIM_DURATION = 300;
    public static final String TAG = "TroopMemberListActivity";
    public static final String TAG_DB = "TroopMemberListActivity|DB";
    public static final String TAG_ERR = "TroopMemberListActivity|ERR";
    public static final String TAG_NET = "TroopMemberListActivity|Net";
    public static final String TAG_TIME = "TroopMemberListActivity|TIME";
    private static final String TITLE_SORT_ICON_QUI_EXCEPTION_REPORT = "title_sort_icon_qui_exception_report";
    protected static final int TROOP_FEE_ENTRANCE_TYPE_CHECK_PAYED_MEMBERS = 1;
    private static Map<String, Boolean> hadInitData;
    private static final boolean isEnableVipGoldName;
    private ii controller;
    private long convertDataCost;
    private int convertDataOpt;
    private long convertDataStartTime;
    protected long createActivityTimeMs;
    private ArrayList<String> deletedInactiveUins;
    private boolean hadEnterSearch;
    private boolean hasSendFlowerPrivilege;
    private View inactiveTitle;
    protected IndexBarTipsLayout indexBarTips;
    protected boolean isPositiveSort;
    private boolean isSearchDataIniting;
    protected boolean isSearchMode;
    protected String mActionMemberUin;
    protected ActionSheet mActionSheet;
    protected t mAdapter;
    public AddFrdHelper mAddFrdHelper;
    protected RelativeLayout mAllMemberLayout;
    protected boolean mCanAtAll;
    protected int mChatMode;
    protected boolean mChooseIsNeedColorNickName;
    protected String mCustomTitleName;
    protected ArrayList<String> mDelList;
    protected float mDensity;
    protected int mDiscRemainCout;
    protected IDiscussionHandlerService mDiscussionHandler;
    protected DiscussionInfo mDiscussionInfo;
    public com.tencent.mobileqq.troop.discussion.a mDiscussionObserver;
    protected double mFakeProgess;
    private boolean mFilerRobot;
    public View.OnClickListener mFinishListener;
    public int mFrom;
    protected Handler mHandler;
    protected boolean mHasDeletedMember;
    protected List<String> mHideUins;
    protected IndexBar mIndexView;
    private boolean mIsApollo;
    public boolean mIsDefaultTheme;
    boolean mIsHomeworkTroop;
    protected boolean mIsInDeleteState;
    protected boolean mIsInMultiDeleteState;
    protected boolean mIsPopUpStyle;
    protected boolean mIsQidianPrivateTroop;
    protected boolean mIsTroopAdmin;
    private boolean mIsZPlan;
    private int mJobCount;
    protected LayoutInflater mLayoutInflater;
    protected TextView mLeftBackBtn;
    protected String mLeftBackBtnText;
    protected int mLeftMarginOfNick;
    public List<com.tencent.mobileqq.troop.troopmemberlist.a> mListData;
    protected PinnedDividerSwipListView mListView;
    protected RelativeLayout mListZone;
    private boolean mLoadGiftListFinish;
    private boolean mLoadLocalFinish;
    protected RelativeLayout mLoadingLayout;
    protected TextView mLoadingTv;
    protected View mLoadingView;
    protected List<String> mMemberUins;
    public View.OnClickListener mMultiDeleteListener;
    protected String mMyTroopRole;
    protected String mNoAtAllRemainTips;
    protected boolean mOnDestroy;
    public View.OnClickListener mOnItemClickListener;
    public View.OnClickListener mOnKickOutBtnClickListener;
    protected int mPickMaxNum;
    public int mPickNumExceedsWordingId;
    protected String mPickTitle;
    protected ProgressBar mProgressBar;
    protected Dialog mProgressDialog;
    protected Drawable mRemainAnimDrawable;
    protected TextView mRightManageBtn;
    protected LinearLayout mRootView;
    protected View mSearchBar;
    public Dialog mSearchDialog;
    protected u mSearchResultAdapter;
    protected List<com.tencent.mobileqq.troop.troopmemberlist.a> mSearchResultList;
    protected String mSearchSlideLeftUin;
    private v mSearchTextWatcher;
    protected String mSlideLeftUin;
    private String[] mSortActionWords;
    private String[] mSortDescribes;
    protected int mSortType;
    private int mSource;
    protected TextView mSubTitle;
    protected TextView mTitle;
    protected View mTitleBar;
    protected LinearLayout mTitleLayout;
    protected ImageView mTitleRightImgBtn;
    protected ImageView mTitleSortImgBtn;
    public String mTroopCode;
    protected String mTroopFeeCallback;
    protected int mTroopFeeEntranceType;
    protected int mTroopFeeMemberCount;
    public com.tencent.mobileqq.troop.observer.g mTroopFeeObserver;
    protected String mTroopFeeProjectId;
    protected String mTroopGiftFrom;
    public TroopInfo mTroopInfo;
    protected TroopInfoData mTroopInfoData;
    protected long mTroopInfoReqStartTime;
    private int mTroopMemberCount;
    public com.tencent.mobileqq.troop.observer.h mTroopMessageObserver;
    protected String mTroopName;
    public com.tencent.mobileqq.troop.onlinemember.api.b mTroopOnlineMemberObserver;
    protected String mTroopOwnerUin;
    public ct2.b mTroopRobotObserver;
    protected String mTroopUin;
    private int maxIndex;
    protected ActionSheet.OnButtonClickListener moreOperationClickListener;
    private boolean needInitSearchData;
    private long nextPullTime;
    private int openDataSize;
    private long openTimeCost;
    private boolean readFromDB;
    protected View root;
    protected EditText searchEditText;
    protected XListView searchList;
    protected RelativeLayout searchResultLayout;
    protected TextView searchResultTipsTextView;
    protected ActionSheet sortTypeActionSheet;
    public com.tencent.mobileqq.troop.troopsetting.api.b troopSettingObserver;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SearchDialogDismissRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<TroopMemberListActivity> f177371d;

        /* renamed from: e, reason: collision with root package name */
        private int f177372e;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a extends AnimatorListenerAdapter {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TroopMemberListActivity f177373d;

            a(TroopMemberListActivity troopMemberListActivity) {
                this.f177373d = troopMemberListActivity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchDialogDismissRunnable.this, (Object) troopMemberListActivity);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.f177373d.mRootView.getLayoutParams();
                layoutParams.height = this.f177373d.mRootView.getHeight() - SearchDialogDismissRunnable.this.f177372e;
                this.f177373d.mRootView.setLayoutParams(layoutParams);
            }
        }

        public SearchDialogDismissRunnable(TroopMemberListActivity troopMemberListActivity, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopMemberListActivity, i3);
            } else {
                this.f177371d = new WeakReference<>(troopMemberListActivity);
                this.f177372e = i3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(TroopMemberListActivity troopMemberListActivity, ValueAnimator valueAnimator) {
            troopMemberListActivity.mRootView.setTop(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            final TroopMemberListActivity troopMemberListActivity = this.f177371d.get();
            if (troopMemberListActivity != null) {
                troopMemberListActivity.isSearchMode = false;
                ValueAnimator duration = ValueAnimator.ofInt(-this.f177372e, 0).setDuration(300L);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.ih
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TroopMemberListActivity.SearchDialogDismissRunnable.c(TroopMemberListActivity.this, valueAnimator);
                    }
                });
                duration.addListener(new a(troopMemberListActivity));
                duration.start();
                ((InputMethodManager) troopMemberListActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(troopMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f177375d;

        a(int i3) {
            this.f177375d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this, i3);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            } else {
                TroopMemberListActivity.this.mSearchDialog.show();
                TroopMemberListActivity.this.reportDialogPageOut(Boolean.TRUE);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            ViewGroup.LayoutParams layoutParams = TroopMemberListActivity.this.mRootView.getLayoutParams();
            layoutParams.height = TroopMemberListActivity.this.mRootView.getHeight() + this.f177375d;
            TroopMemberListActivity.this.mRootView.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TroopInfo troopInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (TroopMemberListActivity.this.isFinishing()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TroopMemberListActivity.TAG, 2, "handleMessage,msg.what:" + message.what);
            }
            boolean z16 = true;
            switch (message.what) {
                case 1:
                case 2:
                    TroopMemberListActivity.this.refreshUI(message);
                    return;
                case 3:
                case 4:
                case 5:
                case 10:
                default:
                    return;
                case 6:
                    t tVar = TroopMemberListActivity.this.mAdapter;
                    if (tVar != null) {
                        List<String> list = tVar.H;
                        if (list != null) {
                            list.clear();
                        }
                        TroopMemberListActivity.this.mAdapter.m();
                    }
                    Dialog dialog = TroopMemberListActivity.this.mProgressDialog;
                    if (dialog != null && dialog.isShowing()) {
                        TroopMemberListActivity.this.mProgressDialog.dismiss();
                    }
                    TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                    QQToast.makeText(troopMemberListActivity, troopMemberListActivity.getString(R.string.ajw), 0).show();
                    TroopMemberListActivity.this.setRighBtnEnabledInMutiDelete();
                    return;
                case 7:
                    Dialog dialog2 = TroopMemberListActivity.this.mProgressDialog;
                    if (dialog2 != null && dialog2.isShowing()) {
                        TroopMemberListActivity.this.mProgressDialog.dismiss();
                    }
                    TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                    QQToast.makeText(troopMemberListActivity2, troopMemberListActivity2.getString(R.string.ajv), 0).show(TroopMemberListActivity.this.mTitleBar.getHeight());
                    return;
                case 8:
                    Object[] objArr = (Object[]) message.obj;
                    boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                    ArrayList<String> arrayList = (ArrayList) objArr[1];
                    TroopMemberListActivity.this.getIntent().putExtra(ISelectMemberActivityConstants.PARAM_WITH_HISTORY, true);
                    IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
                    TroopMemberListActivity troopMemberListActivity3 = TroopMemberListActivity.this;
                    iChatSettingForTroopApi.inviteMember(troopMemberListActivity3, troopMemberListActivity3.mTroopUin, booleanValue, arrayList, 1);
                    return;
                case 9:
                    t tVar2 = TroopMemberListActivity.this.mAdapter;
                    if (tVar2 != null) {
                        tVar2.m();
                        return;
                    }
                    return;
                case 11:
                    TroopInfo troopInfo2 = (TroopInfo) message.obj;
                    String str = troopInfo2.troopowneruin;
                    if (str != null) {
                        TroopMemberListActivity.this.mTroopOwnerUin = str;
                    }
                    TroopMemberListActivity troopMemberListActivity4 = TroopMemberListActivity.this;
                    if (!troopMemberListActivity4.getApp().getCurrentAccountUin().equals(troopInfo2.troopowneruin) && ((troopInfo = TroopMemberListActivity.this.mTroopInfo) == null || !troopInfo.isOwnerOrAdmin())) {
                        z16 = false;
                    }
                    troopMemberListActivity4.mIsTroopAdmin = z16;
                    TroopInfo troopInfo3 = TroopMemberListActivity.this.mTroopInfo;
                    if (troopInfo3 != null && troopInfo3.isOwner()) {
                        TroopMemberListActivity.this.mMyTroopRole = "0";
                    } else {
                        TroopInfo troopInfo4 = TroopMemberListActivity.this.mTroopInfo;
                        if (troopInfo4 != null && troopInfo4.isOwnerOrAdmin()) {
                            TroopMemberListActivity.this.mMyTroopRole = "1";
                        }
                    }
                    t tVar3 = TroopMemberListActivity.this.mAdapter;
                    if (tVar3 != null) {
                        tVar3.m();
                        return;
                    }
                    return;
                case 12:
                    synchronized (TroopMemberListActivity.this) {
                        TroopMemberListActivity.this.mJobCount--;
                        List list2 = (List) message.obj;
                        if (list2 == null && TroopMemberListActivity.this.mFrom != 14) {
                            return;
                        }
                        if (TroopMemberListActivity.this.mLoadingLayout.getVisibility() == 0) {
                            TroopMemberListActivity.this.mHandler.removeMessages(13);
                            double min = Math.min(((message.arg1 * 1.0d) / TroopMemberListActivity.this.mTroopMemberCount) + 0.9d, 1.0d);
                            int i3 = (int) (100.0d * min);
                            if (i3 > TroopMemberListActivity.this.mProgressBar.getProgress()) {
                                TroopMemberListActivity troopMemberListActivity5 = TroopMemberListActivity.this;
                                troopMemberListActivity5.showLoadingProgress((int) (TroopMemberListActivity.this.mTroopMemberCount * min), troopMemberListActivity5.mTroopMemberCount, i3);
                            }
                        }
                        if (list2 != null) {
                            TroopMemberListActivity.this.mListData.addAll(list2);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(TroopMemberListActivity.TAG, 2, "remaining job count:" + TroopMemberListActivity.this.mJobCount + " mATroopMemberList.size: " + TroopMemberListActivity.this.mListData.size());
                        }
                        if (TroopMemberListActivity.this.mJobCount <= 0) {
                            TroopMemberListActivity.this.mLoadLocalFinish = true;
                        }
                        if (TroopMemberListActivity.this.mLoadLocalFinish && TroopMemberListActivity.this.mLoadGiftListFinish) {
                            if (!TroopMemberListActivity.this.mListData.isEmpty()) {
                                TroopMemberListActivity.this.convertDataCost = System.currentTimeMillis() - TroopMemberListActivity.this.convertDataStartTime;
                                if (QLog.isColorLevel()) {
                                    QLog.d(TroopMemberListActivity.TAG_TIME, 2, "convert data timeCost: " + TroopMemberListActivity.this.convertDataCost + ", start refreshUI");
                                }
                                QProxyManager qProxyManager = (QProxyManager) TroopMemberListActivity.this.getApp().getProxyManagerInner();
                                if (qProxyManager != null) {
                                    qProxyManager.notifyRefreshTroopMember();
                                }
                                message.obj = TroopMemberListActivity.this.controller.G();
                                TroopMemberListActivity.this.refreshUI(message);
                                if (TroopMemberListActivity.this.needInitSearchData) {
                                    TroopMemberListActivity.this.preloadSearchData();
                                }
                            } else {
                                TroopMemberListActivity.this.stopTitleProgress();
                                return;
                            }
                        }
                        return;
                    }
                case 13:
                    TroopMemberListActivity troopMemberListActivity6 = TroopMemberListActivity.this;
                    double d16 = troopMemberListActivity6.mFakeProgess + TroopMemberListActivity.FAKE_PROGRESS_DELTA;
                    troopMemberListActivity6.mFakeProgess = d16;
                    if (d16 > troopMemberListActivity6.mProgressBar.getProgress()) {
                        TroopMemberListActivity troopMemberListActivity7 = TroopMemberListActivity.this;
                        if (troopMemberListActivity7.mFakeProgess < 90.0d && troopMemberListActivity7.mTroopMemberCount > 0) {
                            TroopMemberListActivity troopMemberListActivity8 = TroopMemberListActivity.this;
                            int i16 = (int) troopMemberListActivity8.mFakeProgess;
                            double d17 = troopMemberListActivity8.mTroopMemberCount;
                            TroopMemberListActivity troopMemberListActivity9 = TroopMemberListActivity.this;
                            troopMemberListActivity9.showLoadingProgress((int) ((d17 * troopMemberListActivity9.mFakeProgess) / 100.0d), troopMemberListActivity9.mTroopMemberCount, i16);
                            Handler handler = TroopMemberListActivity.this.mHandler;
                            handler.sendMessageDelayed(handler.obtainMessage(13), 800L);
                            return;
                        }
                        return;
                    }
                    return;
                case 14:
                    TroopMemberListActivity.this.mLoadingLayout.setVisibility(0);
                    return;
                case 15:
                    Dialog dialog3 = TroopMemberListActivity.this.mProgressDialog;
                    if (dialog3 != null && dialog3.isShowing()) {
                        TroopMemberListActivity.this.mProgressDialog.dismiss();
                        return;
                    }
                    return;
                case 16:
                    t tVar4 = TroopMemberListActivity.this.mAdapter;
                    if (tVar4 != null) {
                        List<String> list3 = tVar4.H;
                        if (list3 != null) {
                            list3.clear();
                        }
                        TroopMemberListActivity.this.mAdapter.m();
                        return;
                    }
                    return;
                case 17:
                    int i17 = message.arg1;
                    if (i17 >= TroopMemberListActivity.SEARCHING_TIPS_ARRAY.length) {
                        i17 = 0;
                    }
                    TroopMemberListActivity.this.searchResultTipsTextView.setVisibility(0);
                    TroopMemberListActivity.this.searchResultTipsTextView.setText(TroopMemberListActivity.SEARCHING_TIPS_ARRAY[i17]);
                    TroopMemberListActivity.this.mHandler.sendMessageDelayed(TroopMemberListActivity.this.mHandler.obtainMessage(17, i17 + 1, 0), TroopMemberListActivity.DEFAULT_SEARCH_LOADING_INTERVAL);
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag instanceof com.tencent.mobileqq.troop.widget.e) {
                    com.tencent.mobileqq.troop.widget.e eVar = (com.tencent.mobileqq.troop.widget.e) tag;
                    int i3 = eVar.position;
                    if (eVar.isFromSearchList) {
                        TroopMemberListActivity.this.doItemClick((com.tencent.mobileqq.troop.troopmemberlist.a) TroopMemberListActivity.this.mSearchResultAdapter.getItem(i3));
                        Dialog dialog = TroopMemberListActivity.this.mSearchDialog;
                        if (dialog != null && dialog.isShowing()) {
                            TroopMemberListActivity.this.mSearchDialog.dismiss();
                        }
                        TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                        if (troopMemberListActivity.mFrom == 11) {
                            ReportController.o(troopMemberListActivity.getApp(), "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
                        }
                    } else {
                        com.tencent.mobileqq.troop.troopmemberlist.a aVar = (com.tencent.mobileqq.troop.troopmemberlist.a) TroopMemberListActivity.this.mAdapter.getItem(i3);
                        TroopMemberListActivity.this.doItemClick(aVar);
                        TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                        if (troopMemberListActivity2.mFrom == 11) {
                            ReportController.o(troopMemberListActivity2.getApp(), "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
                        }
                        TroopMemberListActivity troopMemberListActivity3 = TroopMemberListActivity.this;
                        if (troopMemberListActivity3.mFrom == 18) {
                            ReportController.o(troopMemberListActivity3.getApp(), "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, TroopMemberListActivity.this.mTroopUin, "", "", "");
                        }
                        TroopMemberListActivity troopMemberListActivity4 = TroopMemberListActivity.this;
                        if (troopMemberListActivity4.mFrom == 0) {
                            troopMemberListActivity4.reportTroopMemberDefaultDtClick(view, aVar);
                        }
                        TroopMemberListActivity troopMemberListActivity5 = TroopMemberListActivity.this;
                        if (troopMemberListActivity5.mFrom == 19) {
                            troopMemberListActivity5.reportTroopTeacherClick(view, aVar);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.mobileqq.troop.troopmemberlist.a aVar;
            boolean z16;
            boolean z17;
            boolean z18;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag instanceof com.tencent.mobileqq.troop.widget.e) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TroopMemberListActivity.TAG, 2, "mOnKickOutBtnClickListener onclick");
                    }
                    int id5 = view.getId();
                    com.tencent.mobileqq.troop.widget.e eVar = (com.tencent.mobileqq.troop.widget.e) tag;
                    int i3 = eVar.position;
                    boolean z19 = eVar.isFromSearchList;
                    if (z19) {
                        aVar = (com.tencent.mobileqq.troop.troopmemberlist.a) TroopMemberListActivity.this.mSearchResultAdapter.getItem(i3);
                    } else {
                        aVar = (com.tencent.mobileqq.troop.troopmemberlist.a) TroopMemberListActivity.this.mAdapter.getItem(i3);
                    }
                    String j3 = aVar.j();
                    if (aVar.f().role == MemberRole.OWNER) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (aVar.f().role == MemberRole.ADMIN) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    boolean equals = TroopMemberListActivity.this.getApp().getCurrentAccountUin().equals(TroopMemberListActivity.this.mTroopOwnerUin);
                    if ((equals && !j3.equals(TroopMemberListActivity.this.getApp().getCurrentAccountUin())) || (!equals && !z16 && !z17)) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (id5 == R.id.bf9) {
                        TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                        if (troopMemberListActivity.mFrom == 20) {
                            troopMemberListActivity.doItemClick(aVar);
                        } else if (troopMemberListActivity.mIsInMultiDeleteState) {
                            if (troopMemberListActivity.mAdapter.H.contains(j3)) {
                                TroopMemberListActivity.this.mAdapter.H.remove(j3);
                            } else if (z18) {
                                TroopMemberListActivity.this.mAdapter.H.add(j3);
                            }
                            TroopMemberListActivity.this.setRighBtnEnabledInMutiDelete();
                            TroopMemberListActivity.this.mAdapter.notifyDataSetChanged();
                        } else if (z19) {
                            if (!troopMemberListActivity.mSearchSlideLeftUin.equals(j3)) {
                                eVar.troopMember.b(true);
                                if (!TextUtils.isEmpty(TroopMemberListActivity.this.mSearchSlideLeftUin)) {
                                    TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                                    com.tencent.mobileqq.troop.widget.e findListItemHolderByUin = troopMemberListActivity2.findListItemHolderByUin(troopMemberListActivity2.mSearchSlideLeftUin, z19);
                                    if (findListItemHolderByUin != null) {
                                        findListItemHolderByUin.troopMember.c(true);
                                    }
                                }
                                TroopMemberListActivity.this.mSearchSlideLeftUin = j3;
                            }
                        } else if (!troopMemberListActivity.mSlideLeftUin.equals(j3)) {
                            eVar.troopMember.b(true);
                            if (!TextUtils.isEmpty(TroopMemberListActivity.this.mSlideLeftUin)) {
                                TroopMemberListActivity troopMemberListActivity3 = TroopMemberListActivity.this;
                                com.tencent.mobileqq.troop.widget.e findListItemHolderByUin2 = troopMemberListActivity3.findListItemHolderByUin(troopMemberListActivity3.mSlideLeftUin, z19);
                                if (findListItemHolderByUin2 != null) {
                                    findListItemHolderByUin2.troopMember.c(true);
                                }
                            }
                            TroopMemberListActivity.this.mSlideLeftUin = j3;
                        }
                    } else if (id5 == R.id.ixj) {
                        TroopMemberListActivity troopMemberListActivity4 = TroopMemberListActivity.this;
                        if (troopMemberListActivity4.mIsInMultiDeleteState) {
                            if (troopMemberListActivity4.mAdapter.H.contains(j3)) {
                                TroopMemberListActivity.this.mAdapter.H.remove(j3);
                            } else if (z18) {
                                TroopMemberListActivity.this.mAdapter.H.add(j3);
                            }
                            TroopMemberListActivity.this.setRighBtnEnabledInMutiDelete();
                            TroopMemberListActivity.this.mAdapter.notifyDataSetChanged();
                        }
                        if (z19) {
                            TroopMemberListActivity troopMemberListActivity5 = TroopMemberListActivity.this;
                            com.tencent.mobileqq.troop.widget.e findListItemHolderByUin3 = troopMemberListActivity5.findListItemHolderByUin(troopMemberListActivity5.mSearchSlideLeftUin, z19);
                            if (findListItemHolderByUin3 != null) {
                                findListItemHolderByUin3.troopMember.c(true);
                                TroopMemberListActivity.this.mSearchSlideLeftUin = "";
                            }
                            TroopMemberListActivity.this.mSearchResultAdapter.notifyDataSetChanged();
                        } else {
                            TroopMemberListActivity troopMemberListActivity6 = TroopMemberListActivity.this;
                            com.tencent.mobileqq.troop.widget.e findListItemHolderByUin4 = troopMemberListActivity6.findListItemHolderByUin(troopMemberListActivity6.mSlideLeftUin, z19);
                            if (findListItemHolderByUin4 != null) {
                                findListItemHolderByUin4.troopMember.c(true);
                                TroopMemberListActivity.this.mSlideLeftUin = "";
                            }
                        }
                    } else if (id5 == R.id.f164668ai4 && TroopMemberListActivity.this.mIsInDeleteState) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TroopMemberListActivity.TAG, 2, "delBtn onClick, uin=" + j3);
                        }
                        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                            if (TroopMemberListActivity.this.isResume()) {
                                TroopMemberListActivity troopMemberListActivity7 = TroopMemberListActivity.this;
                                QQToast.makeText(troopMemberListActivity7, troopMemberListActivity7.getString(R.string.f171139ci4), 0).show(TroopMemberListActivity.this.getTitleBarHeight());
                            }
                        } else {
                            TroopMemberListActivity troopMemberListActivity8 = TroopMemberListActivity.this;
                            int i16 = troopMemberListActivity8.mFrom;
                            if (i16 == 1) {
                                troopMemberListActivity8.kickOutDiscussionMember(j3);
                            } else if (i16 == 13) {
                                com.tencent.mobileqq.troop.troopmemberlist.a removeItem = troopMemberListActivity8.removeItem(j3);
                                TroopMemberListActivity.this.mDelList.add(j3);
                                TroopMemberListActivity.this.mAdapter.m();
                                if (TroopMemberListActivity.this.mSearchDialog.isShowing()) {
                                    if (removeItem != null) {
                                        TroopMemberListActivity.this.mSearchResultList.remove(removeItem);
                                    }
                                    TroopMemberListActivity.this.mSearchResultAdapter.notifyDataSetChanged();
                                }
                            } else if (i16 == 21) {
                                com.tencent.mobileqq.troop.troopmemberlist.a removeItem2 = troopMemberListActivity8.removeItem(j3);
                                TroopMemberListActivity.this.mDelList.add(j3);
                                TroopMemberListActivity.this.mAdapter.m();
                                if (TroopMemberListActivity.this.mSearchDialog.isShowing()) {
                                    if (removeItem2 != null) {
                                        TroopMemberListActivity.this.mSearchResultList.remove(removeItem2);
                                    }
                                    TroopMemberListActivity.this.mSearchResultAdapter.notifyDataSetChanged();
                                }
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Long.valueOf(Long.parseLong(j3)));
                                TroopMemberListActivity.this.showKickoutWindow(arrayList);
                            }
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e extends com.tencent.mobileqq.troop.discussion.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(boolean z16, String str, boolean z17, int i3, int i16, boolean z18) {
            TroopMemberListActivity.this.updateUIForAtAllRemainedCount(z16, str, z17, i3, i16, "", "", z18);
        }

        @Override // com.tencent.mobileqq.troop.discussion.a
        protected void b(boolean z16, Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), l3);
                return;
            }
            Dialog dialog = TroopMemberListActivity.this.mProgressDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.troop.discussion.a
        protected void c(final boolean z16, final String str, final boolean z17, final int i3, final int i16, final boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z18));
            } else {
                TroopMemberListActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.hu
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.e.this.g(z16, str, z17, i3, i16, z18);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.troop.discussion.a
        protected void d(boolean z16, Long l3, Long l16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), l3, l16);
                return;
            }
            if (z16) {
                ReportController.o(TroopMemberListActivity.this.getApp(), "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
                TroopMemberListActivity.this.removeItem(l16 + "");
                t tVar = TroopMemberListActivity.this.mAdapter;
                if (tVar != null) {
                    tVar.m();
                }
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                if (troopMemberListActivity.isSearchMode) {
                    troopMemberListActivity.removeSearchItem(l16 + "");
                    u uVar = TroopMemberListActivity.this.mSearchResultAdapter;
                    if (uVar != null) {
                        uVar.notifyDataSetChanged();
                    }
                }
            } else {
                TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                QQToast.makeText(troopMemberListActivity2, 1, troopMemberListActivity2.getString(R.string.c0h), 0).show(TroopMemberListActivity.this.getTitleBarHeight());
            }
            Dialog dialog = TroopMemberListActivity.this.mProgressDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.troop.discussion.a
        protected void e(boolean z16, Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), l3);
                return;
            }
            Dialog dialog = TroopMemberListActivity.this.mProgressDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f extends ct2.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // ct2.b
        protected void b(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            } else if (str != null && str.equals(TroopMemberListActivity.this.mTroopInfo.troopuin)) {
                TroopMemberListActivity.this.removeItem(str2);
                Handler handler = TroopMemberListActivity.this.mHandler;
                handler.sendMessage(handler.obtainMessage(9));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g extends com.tencent.mobileqq.troop.troopsetting.api.b {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(String str, TroopMemberInfo troopMemberInfo) {
            TroopMemberListActivity.this.removeItem(str);
            synchronized (TroopMemberListActivity.this) {
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                troopMemberListActivity.mListData.add(com.tencent.mobileqq.troop.troopmemberlist.a.INSTANCE.a(troopMemberListActivity, troopMemberInfo, troopMemberListActivity.mAddFrdHelper, troopMemberListActivity.mChooseIsNeedColorNickName));
                TroopMemberListActivity.this.mHandler.sendEmptyMessage(9);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(final String str, final TroopMemberInfo troopMemberInfo) {
            IFriendDataService iFriendDataService = (IFriendDataService) com.tencent.mobileqq.troop.utils.bg.l(IFriendDataService.class);
            if (troopMemberInfo != null && iFriendDataService != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.hw
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.g.this.n(str, troopMemberInfo);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.troop.troopsetting.api.b
        protected void e(String str, final String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            } else {
                if (!TroopMemberListActivity.this.mTroopUin.equals(str)) {
                    return;
                }
                TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                troopMemberListRepo.fetchTroopMemberInfo(troopMemberListActivity.mTroopUin, str2, false, troopMemberListActivity, TroopMemberListActivity.TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.activity.hv
                    @Override // com.tencent.qqnt.troopmemberlist.g
                    public final void a(TroopMemberInfo troopMemberInfo) {
                        TroopMemberListActivity.g.this.o(str2, troopMemberInfo);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class h extends com.tencent.mobileqq.troop.observer.g {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.observer.g
        protected void a(boolean z16, List<cmd0x406$GroupFeeMember> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                return;
            }
            if (!z16) {
                QLog.e(TroopMemberListActivity.TAG_ERR, 1, "onGetTroopFeeMemberList : isSuccess= false");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (cmd0x406$GroupFeeMember cmd0x406_groupfeemember : list) {
                arrayList.add(com.tencent.mobileqq.troop.troopmemberlist.a.INSTANCE.c(TroopMemberListActivity.this.mTroopUin, String.valueOf(cmd0x406_groupfeemember.uint64_uin.get()), cmd0x406_groupfeemember.string_nick_name.get(), TroopMemberListActivity.this.mAddFrdHelper));
            }
            TroopMemberListActivity.this.mTroopFeeMemberCount = list.size();
            Handler handler = TroopMemberListActivity.this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, new Object[]{arrayList}));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                troopMemberListActivity.setResult(0, troopMemberListActivity.getIntent());
                TroopMemberListActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j extends com.tencent.mobileqq.troop.onlinemember.api.b {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(List list) {
            if (TroopMemberListActivity.this.isFinishing()) {
                return;
            }
            TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
            if (troopMemberListActivity.mAdapter != null) {
                troopMemberListActivity.controller.k(list);
                TroopMemberListActivity.this.mAdapter.m();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(List list) {
            if (TroopMemberListActivity.this.isFinishing()) {
                return;
            }
            TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
            if (troopMemberListActivity.mAdapter != null) {
                troopMemberListActivity.controller.o(list);
                TroopMemberListActivity.this.mAdapter.m();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(List list) {
            if (TroopMemberListActivity.this.isFinishing()) {
                return;
            }
            TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
            if (troopMemberListActivity.mAdapter != null) {
                troopMemberListActivity.controller.r(list);
                TroopMemberListActivity.this.mAdapter.m();
            }
        }

        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        protected void b(boolean z16, String str, final List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, list);
            } else if (z16 && TextUtils.equals(str, TroopMemberListActivity.this.mTroopUin) && TroopMemberListActivity.this.mSortType == 5 && list != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.hx
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.j.this.r(list);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        protected void c(boolean z16, String str, final List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, list);
            } else if (z16 && TextUtils.equals(str, TroopMemberListActivity.this.mTroopUin) && TroopMemberListActivity.this.mSortType == 1 && list != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.hz
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.j.this.s(list);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        protected void d(boolean z16, String str, final List<oidb_0xa2a$UserInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, list);
            } else if (z16 && TextUtils.equals(str, TroopMemberListActivity.this.mTroopUin) && TroopMemberListActivity.this.mSortType == 8 && list != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.hy
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.j.this.t(list);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k extends com.tencent.mobileqq.troop.observer.h {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(boolean z16, String str, boolean z17, String str2, String str3, boolean z18) {
            TroopMemberListActivity.this.updateUIForAtAllRemainedCount(z16, str, z17, 0, 0, str2, str3, z18);
        }

        @Override // com.tencent.mobileqq.troop.observer.h
        protected void a(final boolean z16, final String str, final boolean z17, final String str2, final String str3, final boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), str2, str3, Boolean.valueOf(z18));
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ia
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.k.this.d(z16, str, z17, str2, str3, z18);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                troopMemberListActivity.setResult(0, troopMemberListActivity.getIntent());
                TroopMemberListActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                troopMemberListActivity.setResult(0, troopMemberListActivity.getIntent());
                TroopMemberListActivity.this.finish();
                TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                if (troopMemberListActivity2.mFrom == 11) {
                    ReportController.o(troopMemberListActivity2.getApp(), "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "1", "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopMemberListActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
            troopMemberListActivity.mIsInMultiDeleteState = false;
            troopMemberListActivity.mRightManageBtn.setText(R.string.f170869aw3);
            TroopMemberListActivity.this.mRightManageBtn.setVisibility(0);
            TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
            troopMemberListActivity2.mRightManageBtn.setOnClickListener(troopMemberListActivity2.mMultiDeleteListener);
            TroopMemberListActivity.this.mRightManageBtn.setEnabled(true);
            TroopMemberListActivity.this.mLeftBackBtn.setVisibility(8);
            TroopMemberListActivity troopMemberListActivity3 = TroopMemberListActivity.this;
            troopMemberListActivity3.mLeftBackBtn = (TextView) troopMemberListActivity3.findViewById(R.id.ivTitleBtnLeft);
            TroopMemberListActivity.this.mLeftBackBtn.setVisibility(0);
            TroopMemberListActivity troopMemberListActivity4 = TroopMemberListActivity.this;
            troopMemberListActivity4.mLeftBackBtn.setOnClickListener(troopMemberListActivity4.mFinishListener);
            t tVar = TroopMemberListActivity.this.mAdapter;
            if (tVar != null) {
                tVar.m();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                troopMemberListActivity.mIsInMultiDeleteState = true;
                troopMemberListActivity.mLeftBackBtn.setVisibility(8);
                TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                troopMemberListActivity2.mLeftBackBtn = (TextView) troopMemberListActivity2.findViewById(R.id.ivTitleBtnLeftButton);
                TroopMemberListActivity.this.mLeftBackBtn.setVisibility(0);
                TroopMemberListActivity.this.mLeftBackBtn.setText(HardCodeUtil.qqStr(R.string.f172844un3));
                TroopMemberListActivity.this.mLeftBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.ib
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        TroopMemberListActivity.o.this.b(view2);
                    }
                });
                TroopMemberListActivity.this.setRighBtnEnabledInMutiDelete();
                t tVar = TroopMemberListActivity.this.mAdapter;
                if (tVar != null) {
                    tVar.m();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p implements IndexBar.a {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // com.tencent.qqnt.aio.at.widget.IndexBar.a
        public void m(boolean z16) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            IndexBarTipsLayout indexBarTipsLayout = TroopMemberListActivity.this.indexBarTips;
            if (indexBarTipsLayout != null) {
                String a16 = indexBarTipsLayout.a();
                int i3 = 0;
                if (z16 && !TextUtils.isEmpty(a16) && !a16.equals("$")) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                IndexBarTipsLayout indexBarTipsLayout2 = TroopMemberListActivity.this.indexBarTips;
                if (!z17) {
                    i3 = 4;
                }
                indexBarTipsLayout2.setVisibility(i3);
            }
        }

        @Override // com.tencent.qqnt.aio.at.widget.IndexBar.a
        public void p1(String str, int i3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Float.valueOf(f16));
                return;
            }
            IndexBarTipsLayout indexBarTipsLayout = TroopMemberListActivity.this.indexBarTips;
            if (indexBarTipsLayout != null) {
                indexBarTipsLayout.setText(str, f16 + r0.calTipsOffset());
                if (!TextUtils.isEmpty(str) && !str.equals("$")) {
                    z16 = false;
                }
                IndexBarTipsLayout indexBarTipsLayout2 = TroopMemberListActivity.this.indexBarTips;
                if (z16) {
                    i16 = 8;
                }
                indexBarTipsLayout2.setVisibility(i16);
            }
            TroopMemberListActivity.this.onIndexChanged(str);
            IndexBar indexBar = TroopMemberListActivity.this.mIndexView;
            if (indexBar != null) {
                indexBar.setChooseIndex(str);
            }
            TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
            if (troopMemberListActivity.mFrom == 11) {
                troopMemberListActivity.onIndexChanged(str, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class q extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            try {
                QLog.i(TroopMemberListActivity.TAG, 1, "showInactiveTitle. uin: " + TroopMemberListActivity.this.mTroopUin + ", from: " + TroopMemberListActivity.this.mFrom + ", 0x74f retCode: " + i3);
                if (i3 == 0 && bArr != null) {
                    oidb_cmd0x74f$RspBody oidb_cmd0x74f_rspbody = new oidb_cmd0x74f$RspBody();
                    oidb_cmd0x74f_rspbody.mergeFrom(bArr);
                    boolean z16 = oidb_cmd0x74f_rspbody.bool_display_entrance.get();
                    if (oidb_cmd0x74f_rspbody.uint32_ret_code.get() == 0 && z16 && oidb_cmd0x74f_rspbody.range.has()) {
                        TroopMemberListActivity.this.addInactiveTitle(oidb_cmd0x74f_rspbody.range.get());
                        if (oidb_cmd0x74f_rspbody.uint64_next_pull_time.has()) {
                            TroopMemberListActivity.this.nextPullTime = oidb_cmd0x74f_rspbody.uint64_next_pull_time.get();
                            return;
                        }
                        return;
                    }
                    QLog.e(TroopMemberListActivity.TAG_ERR, 1, "0x74f onResult error showEntrance: " + z16);
                }
            } catch (Exception e16) {
                QLog.e(TroopMemberListActivity.TAG_ERR, 1, e16, "0x74f onResult");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class r extends ITroopMemberListActivityApi.a {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi.a
        public void a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.e(TroopMemberListActivity.TAG_ERR, 1, "onGetGiftMemberList error code: " + i3 + " msg: " + str);
            TroopMemberListActivity.this.mLoadGiftListFinish = true;
            if (TroopMemberListActivity.this.mLoadLocalFinish) {
                TroopMemberListActivity.this.mHandler.sendMessage(TroopMemberListActivity.this.mHandler.obtainMessage(12, null));
            }
        }

        @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi.a
        public void b(long[] jArr, long[] jArr2, long[] jArr3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, jArr, jArr2, jArr3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TroopMemberListActivity.TAG, 2, "onGetGiftMemberList");
            }
            TroopMemberListActivity.this.controller.j(jArr);
            TroopMemberListActivity.this.controller.n(jArr2);
            TroopMemberListActivity.this.controller.m(jArr3);
            TroopMemberListActivity.this.mLoadGiftListFinish = true;
            if (TroopMemberListActivity.this.mLoadLocalFinish) {
                TroopMemberListActivity.this.mHandler.sendMessage(TroopMemberListActivity.this.mHandler.obtainMessage(12, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class s implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            TroopMemberListActivity.this.inviteMember();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            TroopMemberListActivity.this.inviteMember();
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (!TroopMemberListActivity.this.hasSendFlowerPrivilege && i3 >= 5) {
                i16 = i3 + 1;
            } else {
                i16 = i3;
            }
            com.tencent.mobileqq.troop.report.addfriend.a.c(view);
            TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
            if (troopMemberListActivity.mIsQidianPrivateTroop) {
                if (i3 == 0) {
                    troopMemberListActivity.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.ic
                        @Override // java.lang.Runnable
                        public final void run() {
                            TroopMemberListActivity.s.this.c();
                        }
                    }, 320L);
                } else if (QLog.isColorLevel()) {
                    QLog.d(TroopMemberListActivity.TAG, 2, "mOnActionSheetClickListener.OnClick, error : which = " + i3 + ", troopUin = " + TroopMemberListActivity.this.mTroopUin);
                }
            } else if (troopMemberListActivity.mFrom == 9) {
                if (i16 == 0) {
                    troopMemberListActivity.mIsInDeleteState = true;
                    troopMemberListActivity.mSlideLeftUin = "";
                    troopMemberListActivity.mRightManageBtn.setVisibility(0);
                    TroopMemberListActivity.this.mTitleRightImgBtn.setVisibility(8);
                    TroopMemberListActivity.this.mTitleSortImgBtn.setVisibility(8);
                    t tVar = TroopMemberListActivity.this.mAdapter;
                    if (tVar != null) {
                        tVar.m();
                    }
                    AppInterface app = TroopMemberListActivity.this.getApp();
                    TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                    ReportController.o(app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, troopMemberListActivity2.mTroopUin, troopMemberListActivity2.mMyTroopRole, "", "");
                }
            } else if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            troopMemberListActivity.delTroopMember();
                        }
                    } else {
                        troopMemberListActivity.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.id
                            @Override // java.lang.Runnable
                            public final void run() {
                                TroopMemberListActivity.s.this.d();
                            }
                        }, 320L);
                    }
                } else if (!TextUtils.isEmpty(troopMemberListActivity.mTroopCode)) {
                    Intent intent = new Intent();
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 30);
                    intent.putExtra("group_uin", TroopMemberListActivity.this.mTroopUin);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, TroopMemberListActivity.this.mTroopCode);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 30);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 4);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 30);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 30);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 3);
                    if (Build.VERSION.SDK_INT < 24) {
                        intent.addFlags(268435456);
                    }
                    ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(TroopMemberListActivity.this, intent);
                    TroopMemberListActivity.this.overridePendingTransition(R.anim.f154454a3, 0);
                    ReportController.o(TroopMemberListActivity.this.getApp(), "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, TroopMemberListActivity.this.mTroopUin, "", "", "");
                }
            } else {
                troopMemberListActivity.showMemberDstribute();
            }
            ActionSheet actionSheet = TroopMemberListActivity.this.mActionSheet;
            if (actionSheet != null && actionSheet.isShowing()) {
                TroopMemberListActivity.this.mActionSheet.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class t extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;
        public Map<String, List<com.tencent.mobileqq.troop.troopmemberlist.a>> D;
        public int[] E;
        public String[] F;
        public List<com.tencent.mobileqq.troop.troopmemberlist.a> G;
        public List<String> H;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements AbsListView.OnScrollListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
                }
            }

            @Override // com.tencent.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    return;
                }
                int binarySearch = Arrays.binarySearch(t.this.E, i3);
                if (binarySearch < 0) {
                    binarySearch = (-(binarySearch + 1)) - 1;
                }
                t tVar = t.this;
                TroopMemberListActivity.this.mIndexView.setChooseIndex(tVar.F[binarySearch]);
            }

            @Override // com.tencent.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) absListView, i3);
                }
            }
        }

        public t() {
            super(TroopMemberListActivity.this, TroopMemberListActivity.this.getApp(), TroopMemberListActivity.this.mListView, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
                return;
            }
            this.D = new LinkedHashMap();
            this.E = new int[0];
            this.F = new String[0];
            this.G = new ArrayList();
            this.H = new ArrayList();
        }

        private void j(com.tencent.mobileqq.troop.widget.e eVar) {
            Button button;
            if (eVar != null && !TextUtils.isEmpty(eVar.f187210d)) {
                HashMap hashMap = new HashMap();
                hashMap.put("qq_num", eVar.f187210d);
                TroopMemberListSlideItem troopMemberListSlideItem = eVar.troopMember;
                ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
                com.tencent.mobileqq.troop.dtreport.a.g(troopMemberListSlideItem, "em_group_member_unit", hashMap, clickPolicy);
                View view = eVar.addFrdLayout;
                if (view == null || (button = (Button) view.findViewById(R.id.f164019h6)) == null) {
                    return;
                }
                com.tencent.mobileqq.troop.dtreport.a.g(button, "em_group_member_add", hashMap, clickPolicy);
                return;
            }
            QLog.e(TroopMemberListActivity.TAG_ERR, 1, "uin is empty");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(com.tencent.mobileqq.troop.widget.e eVar, com.tencent.mobileqq.troop.troopmemberlist.a aVar) {
            TroopMemberListActivity.this.setItemViewValue(eVar, aVar, false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(com.tencent.mobileqq.troop.widget.e eVar, com.tencent.mobileqq.troop.troopmemberlist.a aVar, int i3) {
            TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
            boolean z16 = true;
            if (i3 != 1) {
                z16 = false;
            }
            troopMemberListActivity.setItemViewValue(eVar, aVar, false, z16);
        }

        private void n() {
            TroopMemberListActivity.this.mListView.setOnScrollListener(new a());
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, i3);
                return;
            }
            int i16 = TroopMemberListActivity.this.mFrom;
            if (i16 != 9 && i16 != 19) {
                int[] iArr = this.E;
                if (iArr.length > 0 && this.F.length > 0) {
                    int binarySearch = Arrays.binarySearch(iArr, i3);
                    if (binarySearch < 0) {
                        binarySearch = (-(binarySearch + 1)) - 1;
                    }
                    List<com.tencent.mobileqq.troop.troopmemberlist.a> list = this.D.get(this.F[binarySearch]);
                    if (list != null && list.size() > 1) {
                        ((TextView) view).setText(this.F[binarySearch] + TroopMemberListActivity.this.getString(R.string.iha, Integer.valueOf(list.size())));
                    } else {
                        ((TextView) view).setText(this.F[binarySearch]);
                    }
                    if (TroopMemberListActivity.this.mIsDefaultTheme) {
                        view.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
                    } else {
                        view.setBackgroundResource(R.drawable.skin_group_list_sub_entry);
                    }
                    view.setPadding((int) (TroopMemberListActivity.this.mDensity * 10.0f), 0, 0, 0);
                    return;
                }
                return;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
            if (troopMemberListActivity.mFrom == 9) {
                List<com.tencent.mobileqq.troop.troopmemberlist.a> list = troopMemberListActivity.mListData;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            int[] iArr = this.E;
            if (iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + this.D.get(this.F[r2.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            if (TroopMemberListActivity.this.mFrom == 9) {
                return 0;
            }
            return R.layout.f168255qg;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (TroopMemberListActivity.this.mFrom == 9) {
                if (i3 < 0 || i3 > r0.mListData.size() - 1) {
                    return null;
                }
                return TroopMemberListActivity.this.mListData.get(i3);
            }
            int binarySearch = Arrays.binarySearch(this.E, i3);
            if (binarySearch >= 0) {
                return null;
            }
            return this.D.get(this.F[(-(binarySearch + 1)) - 1]).get((i3 - this.E[r0]) - 1);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            int binarySearch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            if (TroopMemberListActivity.this.isPickUpPurposeFor760() && (binarySearch = Arrays.binarySearch(this.E, i3)) < 0) {
                int i16 = (-(binarySearch + 1)) - 1;
                com.tencent.mobileqq.troop.troopmemberlist.a aVar = this.D.get(this.F[i16]).get((i3 - this.E[i16]) - 1);
                if (aVar.i().getShowName().equals(aVar.c())) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            final com.tencent.mobileqq.troop.widget.e eVar;
            View view2;
            int i16;
            View view3;
            IndexBar indexBar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                final int itemViewType = getItemViewType(i3);
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                troopMemberListActivity.maxIndex = Math.max(i3, troopMemberListActivity.maxIndex);
                if (view == null) {
                    if (itemViewType == 0) {
                        view2 = TroopMemberListActivity.this.mLayoutInflater.inflate(R.layout.c1x, viewGroup, false);
                        eVar = new com.tencent.mobileqq.troop.widget.e(view2, false);
                    } else {
                        view2 = TroopMemberListActivity.this.mLayoutInflater.inflate(R.layout.c1z, viewGroup, false);
                        eVar = new com.tencent.mobileqq.troop.widget.e(view2, true);
                    }
                    view2.setTag(eVar);
                } else {
                    eVar = (com.tencent.mobileqq.troop.widget.e) view.getTag();
                    view2 = view;
                }
                eVar.position = i3;
                eVar.f187210d = "";
                TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                if (troopMemberListActivity2.mFrom == 9) {
                    final com.tencent.mobileqq.troop.troopmemberlist.a aVar = troopMemberListActivity2.mListData.get(i3);
                    eVar.f187210d = aVar.j();
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ie
                        @Override // java.lang.Runnable
                        public final void run() {
                            TroopMemberListActivity.t.this.k(eVar, aVar);
                        }
                    });
                } else {
                    int binarySearch = Arrays.binarySearch(this.E, i3);
                    if (binarySearch < 0) {
                        int i17 = (-(binarySearch + 1)) - 1;
                        final com.tencent.mobileqq.troop.troopmemberlist.a aVar2 = this.D.get(this.F[i17]).get((i3 - this.E[i17]) - 1);
                        eVar.f187210d = aVar2.j();
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.if
                            @Override // java.lang.Runnable
                            public final void run() {
                                TroopMemberListActivity.t.this.l(eVar, aVar2, itemViewType);
                            }
                        });
                        if (TroopMemberListActivity.this.mFrom == 12) {
                            if (this.G.contains(aVar2)) {
                                eVar.selectedIcon.setVisibility(0);
                            } else {
                                eVar.selectedIcon.setVisibility(8);
                            }
                        }
                        TroopMemberListActivity troopMemberListActivity3 = TroopMemberListActivity.this;
                        if (troopMemberListActivity3.mIsInMultiDeleteState) {
                            eVar.addFrdLayout.setVisibility(8);
                        } else {
                            AddFrdHelper addFrdHelper = troopMemberListActivity3.mAddFrdHelper;
                            if (addFrdHelper != null) {
                                addFrdHelper.j(eVar, aVar2);
                                if (eVar.addFrdLayout.getVisibility() == 0) {
                                    i16 = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
                                } else {
                                    i16 = Integer.MAX_VALUE;
                                }
                                eVar.tvName.setMaxWidth(i16);
                                TroopMemberListActivity.checkAdjustNicknameMaxWidthWhenShowRobotMask(TroopMemberListActivity.this.getApp(), eVar.tvName, eVar.mRobotMsk, aVar2.j(), i16);
                            }
                        }
                    } else {
                        eVar.troopMember.c(false);
                        eVar.troopMember.setVisibility(8);
                        eVar.feedback.setVisibility(8);
                        eVar.selectedIcon.setVisibility(8);
                        eVar.troopMember.setOnClickListener(null);
                        int i18 = TroopMemberListActivity.this.mFrom;
                        if (i18 != 9 && i18 != 19) {
                            eVar.divider.setVisibility(0);
                            List<com.tencent.mobileqq.troop.troopmemberlist.a> list = this.D.get(this.F[binarySearch]);
                            if (list != null) {
                                if (TroopMemberListActivity.this.getString(R.string.i8u).equals(String.valueOf(this.F[binarySearch]))) {
                                    eVar.divider.setText(String.valueOf(this.F[binarySearch]));
                                } else {
                                    eVar.divider.setText(String.valueOf(this.F[binarySearch]) + TroopMemberListActivity.this.getString(R.string.iha, Integer.valueOf(list.size())));
                                }
                            }
                        } else {
                            eVar.divider.setVisibility(8);
                        }
                        if (TroopMemberListActivity.this.mFrom == 12) {
                            List<com.tencent.mobileqq.troop.troopmemberlist.a> list2 = this.D.get(this.F[binarySearch]);
                            int i19 = (i3 - this.E[binarySearch]) - 1;
                            if (i19 >= 0 && i19 < list2.size()) {
                                if (this.G.contains(list2.get(i19))) {
                                    eVar.selectedIcon.setVisibility(0);
                                } else {
                                    eVar.selectedIcon.setVisibility(8);
                                }
                            }
                        }
                        eVar.troopMember.setContentDescription("");
                    }
                }
                if (eVar.rightSpace != null && (indexBar = TroopMemberListActivity.this.mIndexView) != null) {
                    if (indexBar.getVisibility() == 0) {
                        eVar.rightSpace.setVisibility(0);
                    } else {
                        eVar.rightSpace.setVisibility(8);
                    }
                }
                j(eVar);
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return 2;
        }

        public int i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).intValue();
            }
            if (this.F != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.F;
                    if (i3 < strArr.length) {
                        if (strArr[i3].equals(str)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0) {
                    return this.E[i3];
                }
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
            }
            if (TroopMemberListActivity.this.mFrom == 9 || Arrays.binarySearch(this.E, i3) < 0) {
                return false;
            }
            return true;
        }

        public void m() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TroopMemberListActivity.TAG, 2, "notifyDataSetChanged2 list count: ", Integer.valueOf(TroopMemberListActivity.this.mListData.size()));
            }
            ij G = TroopMemberListActivity.this.controller.G();
            TroopMemberListActivity.this.controller.p(null);
            if (G.g().isEmpty() && ((i3 = TroopMemberListActivity.this.mFrom) == 13 || i3 == 21)) {
                this.D.clear();
                this.E = new int[0];
                String[] strArr = new String[0];
                this.F = strArr;
                TroopMemberListActivity.this.mIndexView.setLetters(strArr);
                notifyDataSetChanged();
            } else {
                this.D = G.g();
                this.E = G.b();
                this.F = G.c();
                TroopMemberListActivity.this.mIndexView.setLetters(G.d(true));
                TroopMemberListActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.ig
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.t.this.notifyDataSetChanged();
                    }
                });
            }
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class u extends BaseAdapter implements com.tencent.mobileqq.troop.api.troopmemberlist.b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public List<com.tencent.mobileqq.troop.troopmemberlist.a> f177393d;

        /* renamed from: e, reason: collision with root package name */
        private com.tencent.mobileqq.troop.api.troopmemberlist.c f177394e;

        /* renamed from: f, reason: collision with root package name */
        private String f177395f;

        public u(List<com.tencent.mobileqq.troop.troopmemberlist.a> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this, (Object) list);
                return;
            }
            this.f177395f = "";
            this.f177394e = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getFacePreloadBaseAdapterProxy(this, TroopMemberListActivity.this, TroopMemberListActivity.this.getApp(), TroopMemberListActivity.this.searchList, 1, true);
            this.f177393d = list;
        }

        private void b(com.tencent.mobileqq.troop.widget.e eVar) {
            Button button;
            if (eVar != null && !TextUtils.isEmpty(eVar.f187210d)) {
                HashMap hashMap = new HashMap();
                hashMap.put("qq_num", eVar.f187210d);
                String str = this.f177395f;
                if (str == null) {
                    str = "";
                }
                hashMap.put("search_query", str);
                com.tencent.mobileqq.troop.dtreport.a.f(eVar.troopMember, "em_single_result", hashMap);
                View view = eVar.addFrdLayout;
                if (view == null || (button = (Button) view.findViewById(R.id.f164019h6)) == null) {
                    return;
                }
                com.tencent.mobileqq.troop.dtreport.a.g(button, "em_group_member_add", hashMap, ClickPolicy.REPORT_NONE);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TroopMemberListActivity.TAG, 1, "uin is empty");
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            } else {
                this.f177394e.destroy();
            }
        }

        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                this.f177395f = str;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            List<com.tencent.mobileqq.troop.troopmemberlist.a> list = this.f177393d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            if (i3 >= 0 && i3 < this.f177393d.size()) {
                return this.f177393d.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
            }
            if (TroopMemberListActivity.this.isPickUpPurposeFor760()) {
                com.tencent.mobileqq.troop.troopmemberlist.a aVar = this.f177393d.get(i3);
                if (aVar.i().getShowName().equals(aVar.c())) {
                    return 1;
                }
                return 0;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            com.tencent.mobileqq.troop.widget.e eVar;
            boolean z16;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                view2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                int itemViewType = getItemViewType(i3);
                if (view == null) {
                    if (itemViewType == 0) {
                        view = TroopMemberListActivity.this.mLayoutInflater.inflate(R.layout.c1x, viewGroup, false);
                        eVar = new com.tencent.mobileqq.troop.widget.e(view, false);
                    } else {
                        view = TroopMemberListActivity.this.mLayoutInflater.inflate(R.layout.c1z, viewGroup, false);
                        eVar = new com.tencent.mobileqq.troop.widget.e(view, true);
                    }
                    view.setTag(eVar);
                } else {
                    eVar = (com.tencent.mobileqq.troop.widget.e) view.getTag();
                }
                eVar.position = i3;
                com.tencent.mobileqq.troop.troopmemberlist.a aVar = this.f177393d.get(i3);
                eVar.f187210d = aVar.j();
                TroopMemberListActivity troopMemberListActivity = TroopMemberListActivity.this;
                if (itemViewType == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                troopMemberListActivity.setItemViewValue(eVar, aVar, true, z16);
                TroopMemberListActivity troopMemberListActivity2 = TroopMemberListActivity.this;
                if (troopMemberListActivity2.mFrom == 12) {
                    if (troopMemberListActivity2.mAdapter.G.contains(aVar)) {
                        eVar.selectedIcon.setVisibility(0);
                    } else {
                        eVar.selectedIcon.setVisibility(8);
                    }
                }
                AddFrdHelper addFrdHelper = TroopMemberListActivity.this.mAddFrdHelper;
                if (addFrdHelper != null) {
                    addFrdHelper.j(eVar, aVar);
                    if (eVar.addFrdLayout.getVisibility() == 0) {
                        int maxWidthForNameInTroopMemberListActivity = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getMaxWidthForNameInTroopMemberListActivity(2);
                        eVar.tvName.setMaxWidth(maxWidthForNameInTroopMemberListActivity);
                        TroopMemberListActivity.checkAdjustNicknameMaxWidthWhenShowRobotMask(TroopMemberListActivity.this.getApp(), eVar.tvName, eVar.mRobotMsk, aVar.j(), maxWidthForNameInTroopMemberListActivity);
                    }
                }
                b(eVar);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class v implements TextWatcher {
        static IPatchRedirector $redirector_;

        protected v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) editable);
                return;
            }
            String trim = TroopMemberListActivity.this.searchEditText.getText().toString().trim();
            if (TroopMemberListActivity.this.needInitSearchData) {
                TroopMemberListActivity.this.initSearchData();
                if (trim.length() > 0 && TroopMemberListActivity.this.searchResultTipsTextView.getVisibility() != 0) {
                    TroopMemberListActivity.this.mHandler.sendEmptyMessage(17);
                    return;
                }
                return;
            }
            TroopMemberListActivity.this.refreshSearchResultList(trim);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63711);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 44)) {
            redirector.redirect((short) 44);
            return;
        }
        hadInitData = new HashMap();
        SEARCHING_TIPS_ARRAY = new int[]{R.string.f234857a3, R.string.f234867a4, R.string.f234877a5, R.string.f234887a6};
        isEnableVipGoldName = com.tencent.mobileqq.vas.ar.b("linkliang", "2024-03-13", "vas_color_name_gold_9030").isEnable(false);
        FAKE_PROGRESS_DELTA = 10.0d;
    }

    public TroopMemberListActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsTroopAdmin = false;
        this.mIsHomeworkTroop = false;
        this.mTroopCode = "";
        this.mTroopUin = "";
        this.mTroopName = "";
        this.mTroopGiftFrom = "";
        this.mTroopOwnerUin = "";
        this.mNoAtAllRemainTips = "";
        this.mCanAtAll = false;
        this.mDiscRemainCout = 0;
        this.mChatMode = 0;
        this.mDensity = 1.5f;
        this.mListData = new ArrayList();
        this.mAdapter = null;
        this.mSearchResultList = new ArrayList();
        this.mTroopInfoData = new TroopInfoData();
        this.isSearchMode = false;
        this.mMemberUins = new ArrayList();
        this.mHideUins = new ArrayList();
        this.mDelList = new ArrayList<>();
        this.mTroopFeeMemberCount = 0;
        this.mOnDestroy = false;
        this.mIsPopUpStyle = false;
        this.mFrom = 0;
        this.mTroopFeeProjectId = null;
        this.mTroopFeeEntranceType = -1;
        this.mCustomTitleName = null;
        this.mPickMaxNum = Integer.MAX_VALUE;
        this.mLeftMarginOfNick = 0;
        this.createActivityTimeMs = 0L;
        this.mTroopInfoReqStartTime = 0L;
        this.mMyTroopRole = "2";
        this.mIsApollo = false;
        this.mIsZPlan = false;
        this.nextPullTime = 0L;
        this.deletedInactiveUins = new ArrayList<>();
        this.mLoadGiftListFinish = true;
        this.mLoadLocalFinish = false;
        this.mAddFrdHelper = null;
        this.mIsDefaultTheme = true;
        this.mFilerRobot = false;
        this.mSortType = 0;
        this.isPositiveSort = true;
        this.openTimeCost = 0L;
        this.openDataSize = 0;
        this.maxIndex = 0;
        this.hadEnterSearch = false;
        this.readFromDB = false;
        this.convertDataCost = 0L;
        this.convertDataOpt = -1;
        this.needInitSearchData = false;
        this.isSearchDataIniting = false;
        this.mHasDeletedMember = false;
        this.mTroopFeeCallback = "";
        this.mMultiDeleteListener = new o();
        this.mFinishListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gr
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberListActivity.this.lambda$new$4(view);
            }
        };
        this.moreOperationClickListener = new s();
        this.mHandler = new b();
        this.mOnItemClickListener = new c();
        this.mFakeProgess = 0.0d;
        this.mJobCount = -1;
        this.convertDataStartTime = 0L;
        this.mTroopMemberCount = 0;
        this.mSlideLeftUin = "";
        this.mSearchSlideLeftUin = "";
        this.mOnKickOutBtnClickListener = new d();
        this.mDiscussionObserver = new e();
        this.mTroopRobotObserver = new f();
        this.troopSettingObserver = new g();
        this.mTroopFeeObserver = new h();
        this.mTroopOnlineMemberObserver = new j();
        this.mTroopMessageObserver = new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addInactiveTitle(List<oidb_cmd0x74f$Range> list) {
        if (this.inactiveTitle != null) {
            return;
        }
        int i3 = 0;
        View inflate = getLayoutInflater().inflate(R.layout.c1w, (ViewGroup) this.mListView, false);
        this.inactiveTitle = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.dj6);
        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayList<String> arrayList2 = new ArrayList<>();
        final int calInActiveCount = calInActiveCount(list, arrayList, arrayList2);
        textView.setText(calInActiveCount + "");
        TroopInfo troopInfo = this.mTroopInfo;
        if (troopInfo == null || !troopInfo.isOwner()) {
            i3 = 1;
        }
        final int i16 = i3;
        this.inactiveTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberListActivity.this.lambda$addInactiveTitle$17(arrayList2, arrayList, calInActiveCount, i16, view);
            }
        });
        updateInactiveTitleArrowMargin();
        this.mListView.addHeaderView(this.inactiveTitle);
        ReportController.o(getApp(), "dc00899", "Grp_mber", "", "mber_list", "exp_inacmem", 0, 0, this.mTroopUin, "" + i16, "", "");
    }

    private int calInActiveCount(List<oidb_cmd0x74f$Range> list, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000);
        for (oidb_cmd0x74f$Range oidb_cmd0x74f_range : list) {
            arrayList2.add(String.valueOf(oidb_cmd0x74f_range.uint32_days.get()));
            arrayList.add(oidb_cmd0x74f_range.string_name.get());
        }
        Iterator<com.tencent.mobileqq.troop.troopmemberlist.a> it = this.mListData.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            TroopMemberInfo f16 = it.next().f();
            long j3 = 0;
            if (f16 != null) {
                long j16 = f16.last_active_time;
                if (j16 > 0) {
                    j3 = j16;
                } else {
                    j3 = f16.join_time;
                }
            }
            if (!TextUtils.isEmpty(this.controller.d(j3, calendar, arrayList2, arrayList))) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calTipsOffset() {
        IndexBar indexBar = this.mIndexView;
        if (indexBar != null && this.indexBarTips != null) {
            int[] iArr = new int[2];
            indexBar.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            this.indexBarTips.getLocationOnScreen(iArr2);
            return (iArr[1] - iArr2[1]) - com.tencent.mobileqq.util.x.c(getBaseContext(), 20.0f);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkAdjustNicknameMaxWidthWhenShowRobotMask(AppInterface appInterface, TextView textView, View view, String str, int i3) {
        if (appInterface == null || textView == null || view == null || TextUtils.isEmpty(str) || !((ITroopRobotService) appInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str)) {
            return;
        }
        int width = view.getWidth();
        if (width == 0) {
            view.measure(0, 0);
            width = view.getMeasuredWidth();
        }
        if (width == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth error");
                return;
            }
            return;
        }
        int i16 = i3 - width;
        if (i16 > 0) {
            textView.setMaxWidth(i16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkAdjustNicknameMaxWidthWithRobotMask nRobotMaskWidth:" + width + " nTargetMaxWidth:" + i16);
        }
    }

    private void convertTroopMemberInfo2ItemInfo(@NonNull List<TroopMemberInfo> list, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "convertTroopMemberInfo2ATroopMember, processIndex:" + i3);
        }
        ArrayList arrayList = new ArrayList();
        ITroopRobotService iTroopRobotService = (ITroopRobotService) getApp().getRuntimeService(ITroopRobotService.class, "all");
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            TroopMemberInfo troopMemberInfo = list.get(i16);
            if (troopMemberInfo != null && !filterMember(troopMemberInfo, iTroopRobotService)) {
                arrayList.add(com.tencent.mobileqq.troop.troopmemberlist.a.INSTANCE.a(this, troopMemberInfo, this.mAddFrdHelper, this.mChooseIsNeedColorNickName));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "convertTroopMemberInfo2ATroopMember finish");
        }
        Message obtainMessage = this.mHandler.obtainMessage(12, arrayList);
        obtainMessage.arg1 = i3;
        this.mHandler.sendMessage(obtainMessage);
    }

    private void deleteTroopMember(List<Long> list, CheckBox checkBox, Dialog dialog) {
        String str;
        com.tencent.qqnt.bean.b bVar = new com.tencent.qqnt.bean.b();
        bVar.troopUin = this.mTroopUin;
        bVar.isBlack = checkBox.isChecked();
        bVar.d(list);
        ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).deleteTroopMember(bVar, this, TAG, new com.tencent.qqnt.troop.c() { // from class: com.tencent.mobileqq.activity.ho
            @Override // com.tencent.qqnt.troop.c
            public final void a(boolean z16, int i3, ArrayList arrayList) {
                TroopMemberListActivity.this.handleDeleteTroopMember(z16, i3, arrayList);
            }
        });
        String str2 = this.mMyTroopRole;
        if (checkBox.isChecked()) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(getApp(), "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.mTroopUin, str2, str, "");
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        constructProgressDialog();
        this.mProgressDialog.show();
    }

    private void doPageReportTask() {
        String str;
        VideoReport.addToDetectionWhitelist(this);
        if (this.mFrom == 19) {
            str = "pg_group_teacher_msg_list";
        } else {
            str = "pg_group_member_list";
        }
        VideoReport.setPageId(this.mRootView, str);
        VideoReport.setPageParams(this.mRootView, "group_id", this.mTroopUin);
        VideoReport.setPageReportPolicy(this.mRootView, PageReportPolicy.REPORT_ALL);
        com.tencent.mobileqq.troop.troopmemberlist.e.a(this.mTroopUin, this.mSortType);
    }

    private boolean enableConvertDataOpt() {
        int i3 = this.convertDataOpt;
        if (i3 > -1) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102336", false);
        this.convertDataOpt = isSwitchOn ? 1 : 0;
        return isSwitchOn;
    }

    private void fetchTroopMemberInner() {
        final long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = false;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102333", false);
        boolean equals = Boolean.TRUE.equals(hadInitData.get(getInitDataKey()));
        if (isSwitchOn && equals) {
            z16 = true;
        }
        final boolean z17 = !z16;
        this.readFromDB = z16;
        QLog.i(TAG, 1, "[fetchTroopMemberInner] troopUin: " + this.mTroopUin + ", troopCode: " + this.mTroopCode + ", hadInitData:" + equals + ", enableReadDB:" + isSwitchOn);
        fetchTroopMemberList(z17, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.gz
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z18, List list) {
                TroopMemberListActivity.this.lambda$fetchTroopMemberInner$22(z17, currentTimeMillis, z18, list);
            }
        });
    }

    private void fetchTroopMemberList(boolean z16, com.tencent.qqnt.troopmemberlist.f fVar) {
        if (z16 && !NetworkUtil.isNetworkAvailable(this)) {
            fVar.a(false, new ArrayList());
        } else if (enableConvertDataOpt()) {
            TroopMemberListRepo.INSTANCE.fetchTroopMemberListWithExtInfo(this.mTroopUin, this, z16, TAG, fVar);
        } else {
            TroopMemberListRepo.INSTANCE.fetchTroopMemberList(this.mTroopUin, this, z16, TAG, fVar);
        }
    }

    private boolean filterMember(TroopMemberInfo troopMemberInfo, ITroopRobotService iTroopRobotService) {
        MemberRole memberRole;
        if (Utils.M(troopMemberInfo.memberuin)) {
            if (this.mFrom == 2 && ((memberRole = troopMemberInfo.role) == MemberRole.OWNER || memberRole == MemberRole.ADMIN)) {
                return true;
            }
            List<String> list = this.mHideUins;
            if (list != null && list.contains(troopMemberInfo.memberuin)) {
                return true;
            }
            if ((this.mFrom == 20 && iTroopRobotService.isRobotUin(troopMemberInfo.memberuin)) || troopMemberInfo.memberuin.equals("50000000")) {
                return true;
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "filterMember, continued, tmi.memberuin:" + troopMemberInfo.memberuin);
        }
        return true;
    }

    public static void get0x74fInactiveMember(AppRuntime appRuntime, long j3, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        oidb_cmd0x74f$ReqBody oidb_cmd0x74f_reqbody = new oidb_cmd0x74f$ReqBody();
        oidb_cmd0x74f_reqbody.uint64_group_code.set(j3);
        ProtoUtils.j(appRuntime, troopProtocolObserver, oidb_cmd0x74f_reqbody.toByteArray(), "OidbSvc.0x74f_1", 1871, 1);
    }

    private String getInitDataKey() {
        return getApp().getCurrentUin() + "-" + this.mTroopUin;
    }

    public static Intent getLaunchIntent(Context context, String str, int i3) {
        Intent intent = new Intent(context, (Class<?>) TroopMemberListActivity.class);
        intent.putExtra("troop_uin", str);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, i3);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeleteTroopMember(boolean z16, int i3, ArrayList<String> arrayList) {
        QLog.i(TAG, 1, "[handleDeleteTroopMember] isSus:" + z16 + ", code:" + i3 + ", size:" + arrayList.size());
        if (z16) {
            if (arrayList.size() > 0) {
                this.mHasDeletedMember = true;
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    removeItem(it.next());
                }
                if (this.mFrom == 15) {
                    this.deletedInactiveUins = arrayList;
                }
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage(6));
                return;
            }
            return;
        }
        if (i3 == 2) {
            Handler handler2 = this.mHandler;
            handler2.sendMessage(handler2.obtainMessage(15));
        } else {
            Handler handler3 = this.mHandler;
            handler3.sendMessage(handler3.obtainMessage(7));
        }
    }

    private void initCancelDtReport(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("search_query", "");
        com.tencent.mobileqq.troop.dtreport.a.g(view, "em_cancel_button", hashMap, ClickPolicy.REPORT_NONE);
    }

    private void initIndexTouchListener() {
        this.mIndexView.setOnIndexBarTouchListener(new p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSearchData() {
        if (this.isSearchDataIniting) {
            return;
        }
        this.isSearchDataIniting = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.ga
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListActivity.this.lambda$initSearchData$29();
            }
        }, 16, null, false);
    }

    private void initSearchDialogAndSearchList() {
        ReportDialog reportDialog = new ReportDialog(this);
        this.mSearchDialog = reportDialog;
        reportDialog.setCanceledOnTouchOutside(true);
        this.mSearchDialog.requestWindowFeature(1);
        this.mSearchDialog.getWindow().setSoftInputMode(36);
        this.mSearchDialog.setContentView(R.layout.f168950hg3);
        WindowManager.LayoutParams attributes = this.mSearchDialog.getWindow().getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.height = -1;
        attributes.windowAnimations = android.R.style.Animation;
        attributes.gravity = 51;
        this.mSearchDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (ImmersiveUtils.isSupporImmersive() == 1 && Build.VERSION.SDK_INT < 24) {
            this.mSearchDialog.getWindow().addFlags(67108864);
            new SystemBarCompact(this.mSearchDialog, true, getResources().getColor(R.color.skin_color_title_immersive_bar)).init();
            View findViewById = this.mSearchDialog.findViewById(R.id.root);
            findViewById.setFitsSystemWindows(true);
            findViewById.setPadding(0, ImmersiveUtils.getScreenHeight(), 0, 0);
        }
        XListView xListView = (XListView) this.mSearchDialog.findViewById(R.id.searchList);
        this.searchList = xListView;
        xListView.setBackgroundDrawable(getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg));
        this.searchList.setDividerHeight(0);
        this.mSearchResultList.clear();
        u uVar = new u(this.mSearchResultList);
        this.mSearchResultAdapter = uVar;
        this.searchList.setAdapter((ListAdapter) uVar);
        this.searchList.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.activity.fx
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean lambda$initSearchDialogAndSearchList$18;
                lambda$initSearchDialogAndSearchList$18 = TroopMemberListActivity.lambda$initSearchDialogAndSearchList$18(inputMethodManager, view, motionEvent);
                return lambda$initSearchDialogAndSearchList$18;
            }
        });
        this.searchEditText = (EditText) this.mSearchDialog.findViewById(R.id.f66003_g);
        if (this.mSearchTextWatcher == null) {
            this.mSearchTextWatcher = new v();
        }
        this.searchEditText.addTextChangedListener(this.mSearchTextWatcher);
        this.root = this.mSearchDialog.findViewById(R.id.root);
        this.searchResultTipsTextView = (TextView) this.mSearchDialog.findViewById(R.id.f166412fa0);
        RelativeLayout relativeLayout = (RelativeLayout) this.mSearchDialog.findViewById(R.id.result_layout);
        this.searchResultLayout = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberListActivity.this.lambda$initSearchDialogAndSearchList$19(view);
            }
        });
        initSearchDialogPageDtReportData();
    }

    private void initSearchDialogPageDtReportData() {
        if (this.root == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", this.mTroopUin);
        VideoReport.setPageId(this.root, "pg_group_search_results");
        VideoReport.setPageParams(this.root, new PageParams(hashMap));
        VideoReport.setPageReportPolicy(this.root, PageReportPolicy.REPORT_NONE);
    }

    private void initTitleSortImgBtn() {
        ImageView imageView = (ImageView) findViewById(R.id.dsn);
        this.mTitleSortImgBtn = imageView;
        imageView.setContentDescription(getString(R.string.i5r));
        try {
            this.mTitleSortImgBtn.setBackgroundResource(TokenResUtils.getTokenRes1(R.drawable.qb_troop_member_list_sort, R.drawable.qui_sort_icon_navigation_01_selector));
        } catch (Exception e16) {
            QLog.e(TAG_ERR, 1, e16, "title sort icon qui exception");
            this.mTitleSortImgBtn.setBackgroundResource(R.drawable.qb_troop_member_list_sort);
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent(TITLE_SORT_ICON_QUI_EXCEPTION_REPORT);
        }
    }

    private boolean isApolloOrZPlan() {
        if (!this.mIsApollo && !this.mIsZPlan) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPickUpPurposeFor760() {
        boolean z16;
        boolean z17;
        int i3 = this.mFrom;
        if (i3 != 3 && i3 != 2 && i3 != 14) {
            z16 = false;
        } else {
            z16 = true;
        }
        TroopInfo troopInfo = this.mTroopInfo;
        if (troopInfo != null) {
            long j3 = troopInfo.dwGroupClassExt;
            if (j3 == 10009 || j3 == 10010 || j3 == 10011) {
                z17 = true;
                if (!z16 && z17) {
                    return true;
                }
            }
        }
        z17 = false;
        return !z16 ? false : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addInactiveTitle$17(ArrayList arrayList, ArrayList arrayList2, int i3, int i16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.i(TAG, 1, "inactiveTitle clicked. uin: " + this.mTroopUin + ", from: " + this.mFrom);
        Intent intent = new Intent(this, (Class<?>) TroopMemberListActivity.class);
        intent.putExtra("troop_uin", this.mTroopUin);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 15);
        intent.putExtra(PARAM_SEQ_DAYS, arrayList);
        intent.putExtra(PARAM_SEQ_NAME, arrayList2);
        intent.putExtra(AppConstants.Key.TROOP_INFO_MEMBER_NUM, i3);
        startActivityForResult(intent, 4);
        ReportController.o(getApp(), "dc00899", "Grp_mber", "", "mber_list", "clk_inacentry", 0, 0, this.mTroopUin, "" + i16, "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clickSearchBar$25(ValueAnimator valueAnimator) {
        this.mRootView.setTop(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clickSearchBar$26(int i3, DialogInterface dialogInterface) {
        QLog.d(TAG, 4, "search dialog dismissed");
        EditText editText = this.searchEditText;
        if (editText != null) {
            editText.clearFocus();
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.searchEditText.getWindowToken(), 0);
        }
        this.mHandler.postDelayed(new SearchDialogDismissRunnable(this, i3), 150L);
        reportDialogPageOut(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clickSearchBar$27(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mFrom == 11) {
            ReportController.o(getApp(), "CliOper", "", "", "0X8006216", "0X8006216", 0, 0, "", "", "", "");
        }
        reportCancelDtClick(view);
        this.mSearchDialog.cancel();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$doItemClick$32(String str, TroopMemberNickInfo troopMemberNickInfo) {
        String str2;
        if (troopMemberNickInfo != null) {
            str2 = troopMemberNickInfo.getShowName();
        } else {
            str2 = str;
        }
        QRoute.createNavigator(this, "/base/chathistory/main").withInt("nt_chat_history_chatType", 2).withString("frameKey", ((IChatHistoryApi) QRoute.api(IChatHistoryApi.class)).getTroopMemberHistoryFragmentClassName()).withStringList("key_troop_member_uids", new ArrayList<String>(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str)) { // from class: com.tencent.mobileqq.activity.TroopMemberListActivity.13
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$uid;

            {
                this.val$uid = r5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this, (Object) r5);
                } else {
                    add(r5);
                }
            }
        }).withString("nt_chat_history_peerId", this.mTroopUin).withString("key_troop_member_nick", str2).request();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$doItemClick$33(String str, TroopMemberNickInfo troopMemberNickInfo) {
        String str2;
        if (troopMemberNickInfo != null) {
            str2 = troopMemberNickInfo.getShowName();
        } else {
            str2 = str;
        }
        ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).openTeacherHistoryMsgPage(str2, this.mTroopUin, new ArrayList<String>(str) { // from class: com.tencent.mobileqq.activity.TroopMemberListActivity.14
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$uin;

            {
                this.val$uin = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivity.this, (Object) str);
                } else {
                    add(str);
                }
            }
        }, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doItemClick$34(TroopMemberInfo troopMemberInfo) {
        com.tencent.mobileqq.utils.eu.g("Grp_edu", "teachermsg", "showsomeone", 0, 0, this.mTroopInfoData.troopUin, com.tencent.mobileqq.utils.eu.a(troopMemberInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doOnActivityResult$0(TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo != null) {
            removeItem(this.mActionMemberUin);
            synchronized (this) {
                this.mListData.add(com.tencent.mobileqq.troop.troopmemberlist.a.INSTANCE.a(this, troopMemberInfo, this.mAddFrdHelper, this.mChooseIsNeedColorNickName));
                this.mHandler.sendEmptyMessage(9);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTroopMemberInner$22(boolean z16, long j3, boolean z17, List list) {
        onFetchTroopMemberList(z17, z16, new ArrayList(list), j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fillData$20() {
        ((gt2.a) getApp().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopFeeHandlerName())).j1(this.mTroopUin, this.mTroopFeeProjectId, this.mTroopFeeEntranceType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fillData$21() {
        int i3 = this.mFrom;
        if (i3 == 1 || i3 == 11 || i3 == 16) {
            ij discussionMemberFromDB = getDiscussionMemberFromDB(this.mTroopUin);
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, discussionMemberFromDB));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMemberListFromUinList$35(List list, long j3, boolean z16, List list2) {
        processMemberUinListData(list2, list);
        processOwnerAdminData(list2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG_TIME, 2, "getMemberListFromUins cost:" + (System.currentTimeMillis() - j3) + " uinList size: " + list.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTroopMemberFromDBIfNeeded$36(List list) {
        processMemberListData(list);
        processOwnerAdminData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTroopMemberFromDBIfNeeded$37(boolean z16, final List list) {
        if (enableConvertDataOpt()) {
            processMemberListDataV2(list);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.gx
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberListActivity.this.lambda$getTroopMemberFromDBIfNeeded$36(list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListView$10(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intent intent = new Intent();
        intent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
        RouteUtils.startActivity(getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListView$11(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mCanAtAll && !isApolloOrZPlan()) {
            int i3 = this.mFrom;
            if ((i3 == 11 && this.mDiscRemainCout > 0) || i3 == 3) {
                Intent intent = getIntent();
                intent.putExtra("member_uin", "0");
                intent.putExtra("member_display_name", str);
                setResult(-1, intent);
                finish();
                if (this.mFrom == 11) {
                    ReportController.o(getApp(), "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
                }
            } else {
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.umu), 0).show(this.mTitleBar.getHeight());
            }
        } else if (!TextUtils.isEmpty(this.mNoAtAllRemainTips)) {
            QQToast.makeText(this, this.mNoAtAllRemainTips, 0).show(this.mTitleBar.getHeight());
        } else {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.ulr), 0).show(this.mTitleBar.getHeight());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListView$12(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onTriggerSearchBar();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListView$13(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onTriggerSearchBar();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListView$14(TroopMemberInfo troopMemberInfo) {
        com.tencent.mobileqq.utils.eu.g("Grp_edu", "teachermsg", "showall", 0, 0, this.mTroopInfoData.troopUin, com.tencent.mobileqq.utils.eu.a(troopMemberInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListView$15(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        List<com.tencent.mobileqq.troop.troopmemberlist.a> list = this.mAdapter.D.get(this.controller.b());
        if (list != null && list.size() != 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < list.size(); i3++) {
                arrayList.add(list.get(i3).j());
            }
            ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).openTeacherHistoryMsgPage(getString(R.string.f235737cg), this.mTroopUin, arrayList, null);
            ((ITroopMemberInfoService) getApp().getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(this.mTroopInfoData.troopUin, getApp().getCurrentAccountUin(), "TroopMemberListActivity-teacher", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.activity.hf
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    TroopMemberListActivity.this.lambda$initListView$14(troopMemberInfo);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchData$28() {
        this.searchResultTipsTextView.setVisibility(8);
        this.needInitSearchData = false;
        this.isSearchDataIniting = false;
        refreshSearchResultList(this.searchEditText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchData$29() {
        Iterator<com.tencent.mobileqq.troop.troopmemberlist.a> it = this.mListData.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initSearchData: finished");
        }
        this.mHandler.removeMessages(17);
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.gu
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListActivity.this.lambda$initSearchData$28();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$initSearchDialogAndSearchList$18(InputMethodManager inputMethodManager, View view, MotionEvent motionEvent) {
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchDialogAndSearchList$19(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.mSearchDialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTitleBarRightBtn$5(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        showMoreOperationActionSheet();
        new com.tencent.mobileqq.statistics.q(getApp()).i("dc00899").a("Grp_online").f("mber_list").d("clk_more").b(this.mTroopUin).g();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTitleBarRightBtn$6(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        showSortTypeActionSheet();
        new com.tencent.mobileqq.statistics.q(getApp()).i("dc00899").a("Grp_online").f("mber_list").d("clk_sort").b(this.mTroopUin).g();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTitleBarRightBtn$7(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.mIsInDeleteState = false;
        this.mSlideLeftUin = "";
        this.mRightManageBtn.setVisibility(8);
        this.mTitleRightImgBtn.setVisibility(0);
        if (this.mFrom != 22) {
            this.mTitleSortImgBtn.setVisibility(0);
        }
        t tVar = this.mAdapter;
        if (tVar != null) {
            tVar.m();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTitleBarRightBtn$8(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        AssertUtils.checkNotNull(this.mAdapter);
        AssertUtils.checkNotNull(this.mAdapter.G);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.mAdapter.G.size(); i3++) {
            arrayList.add(this.mAdapter.G.get(i3).j());
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra("extra_member_uin_list", arrayList);
        setResult(-1, intent);
        finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTitleBarRightBtn$9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        AssertUtils.checkNotNull(this.mAdapter);
        AssertUtils.checkNotNull(this.mListData);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.mListData.size(); i3++) {
            arrayList.add(this.mListData.get(i3).j());
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra("extra_member_uin_list", arrayList);
        setResult(-1, intent);
        finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteMember$46(boolean z16, List list) {
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((TroopMemberInfo) it.next()).memberuin);
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 8;
        obtainMessage.obj = new Object[]{Boolean.valueOf(this.mIsTroopAdmin), arrayList2};
        this.mHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mFrom == 15 && this.deletedInactiveUins.size() > 0) {
            Intent intent = new Intent();
            intent.putExtra(PARAM_DELETED_UINS, this.deletedInactiveUins);
            setResult(-1, intent);
            TroopInfo troopInfo = this.mTroopInfo;
            if (troopInfo != null && troopInfo.isOwner()) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            ReportController.o(getApp(), "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, this.mTroopUin, "" + i3, "1", this.deletedInactiveUins.toString());
        }
        QLog.i(TAG, 1, "mFinishListener clicked finish(), troopCode=" + this.mTroopCode + " troopUin=" + this.mTroopUin + " from=" + this.mFrom);
        finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFetchTroopMemberList$23(List list) {
        this.mHandler.removeMessages(1);
        int i3 = this.mFrom;
        if (i3 != 13 && i3 != 21) {
            processMemberListData(list);
            ((IRobotInfoUpdateService) getApp().getRuntimeService(IRobotInfoUpdateService.class, "")).onEnterTroopMemberList(list);
        } else {
            processMemberUinListData(list, this.mMemberUins);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onShowMemberCard$1(int i3, String str) {
        ITroopInfoService iTroopInfoService;
        boolean z16;
        TroopInfo troopInfo;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onShowMemberCard, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=" + i3 + ", optUin=" + str);
        }
        if ((i3 & 1) != 0) {
            removeItem(str);
        }
        if ((i3 & 4) != 0 && (iTroopInfoService = (ITroopInfoService) getApp().getRuntimeService(ITroopInfoService.class, "")) != null) {
            TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(this.mTroopUin);
            this.mTroopInfo = findTroopInfo;
            boolean z17 = false;
            if (findTroopInfo != null && findTroopInfo.isHomeworkTroop()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsHomeworkTroop = z16;
            this.controller.l(z16);
            TroopInfo troopInfo2 = this.mTroopInfo;
            if (troopInfo2 != null) {
                this.controller.s(troopInfo2);
                String str2 = this.mTroopInfo.troopowneruin;
                if (str2 != null) {
                    this.mTroopOwnerUin = str2;
                }
                if ((str2 != null && str2.equals(getApp().getCurrentAccountUin())) || ((troopInfo = this.mTroopInfo) != null && troopInfo.isOwnerOrAdmin())) {
                    z17 = true;
                }
                this.mIsTroopAdmin = z17;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onShowMemberCard, REQUEST_CODE_SHOW_MEMBER_CARD, admins: owner:" + this.mTroopOwnerUin);
                }
            }
        }
        if (this.mAdapter != null) {
            this.mHandler.sendEmptyMessage(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preloadSearchData$30() {
        this.needInitSearchData = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preloadSearchData$31() {
        ArrayList arrayList;
        synchronized (TroopMemberListActivity.class) {
            arrayList = new ArrayList(this.mListData);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.troopmemberlist.a) it.next()).k();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preloadSearchData: finished, listData=" + arrayList.size());
        }
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.gs
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListActivity.this.lambda$preloadSearchData$30();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processMemberListData$40(List list, int i3, int i16) {
        convertTroopMemberInfo2ItemInfo(list.subList(i3, i16), i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processMemberListDataV2$38() {
        stopTitleProgress();
        QQToast.makeText(this, getString(R.string.f171139ci4), 0).show(getTitleBarHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processMemberListDataV2$39() {
        TroopMemberListRepo.INSTANCE.fetchTroopMemberList(this.mTroopUin, null, true, "TroopMemberListActivity-refresh", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRighBtnEnabledInMutiDelete$24(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.mAdapter.H.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong(it.next())));
        }
        showKickoutWindow(arrayList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInactiveTitle$16() {
        get0x74fInactiveMember(getApp(), Long.parseLong(this.mTroopUin), new q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showKickoutWindow$41(Dialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showKickoutWindow$42(List list, CheckBox checkBox, Dialog dialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        deleteTroopMember(list, checkBox, dialog);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$showSortTypeActionSheet$3(Integer num) {
        if (num.intValue() == this.mSortType) {
            return null;
        }
        int intValue = num.intValue();
        this.mSortType = intValue;
        this.controller.q(intValue);
        int i3 = this.mSortType;
        if (i3 >= 0) {
            String[] strArr = this.mSortDescribes;
            if (i3 < strArr.length) {
                this.mSubTitle.setText(strArr[i3]);
            }
        }
        triggerSelectSortType(num.intValue());
        if (!this.isPositiveSort) {
            this.isPositiveSort = true;
        }
        t tVar = this.mAdapter;
        if (tVar != null) {
            tVar.m();
        }
        checkShowCharIndexView();
        if (this.mSortType == 0) {
            this.mListView.setSelectionFromTop(0, 0);
        } else {
            this.mListView.setSelectionFromTop(0, -getResources().getDimensionPixelSize(R.dimen.atz));
        }
        this.mTitleLayout.setContentDescription(this.mTitle.getText().toString() + this.mSubTitle.getText().toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showTroopSendFlowerNoPermission$47(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMemberInfo$2(IFriendDataService iFriendDataService, String str, TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo != null && iFriendDataService != null) {
            removeItem(str);
            synchronized (this) {
                this.mListData.add(com.tencent.mobileqq.troop.troopmemberlist.a.INSTANCE.a(this, troopMemberInfo, this.mAddFrdHelper, this.mChooseIsNeedColorNickName));
            }
        }
        if (this.mAdapter != null) {
            this.mHandler.sendEmptyMessage(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUIForAtAllRemainedCount$43(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intent intent = new Intent();
        intent.putExtra("url", "https://m.vip.qq.com/freedom/freedom_group_all.html?_wv=1");
        RouteUtils.startActivity(getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUIForAtAllRemainedCount$44(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mCanAtAll && !isApolloOrZPlan()) {
            int i3 = this.mFrom;
            if ((i3 == 11 && this.mDiscRemainCout > 0) || i3 == 3) {
                Intent intent = getIntent();
                intent.putExtra("member_uin", "0");
                intent.putExtra("member_display_name", str);
                setResult(-1, intent);
                finish();
                if (this.mFrom == 11) {
                    ReportController.o(getApp(), "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
                }
            } else {
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.umq), 0).show(this.mTitleBar.getHeight());
            }
        } else if (!TextUtils.isEmpty(this.mNoAtAllRemainTips)) {
            QQToast.makeText(this, this.mNoAtAllRemainTips, 0).show(this.mTitleBar.getHeight());
        } else {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.umm), 0).show(this.mTitleBar.getHeight());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUIForAtAllRemainedCount$45(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Bundle bundle = new Bundle();
        bundle.putString(VasH5PayUtil.SERVICENAME, HardCodeUtil.qqStr(R.string.um9));
        bundle.putString(VasH5PayUtil.SERVICECODE, "CJCLUBT");
        bundle.putString(VasH5PayUtil.OFFERID, "1450000516");
        bundle.putInt(VasH5PayUtil.OPENMONTH, 3);
        bundle.putString(VasH5PayUtil.PAY_URL, VasH5PayUtil.H5_PAY_URL + "mvip.pt.vipsite.tqtips_chengyuan");
        bundle.putString(VasH5PayUtil.VIPTYPE, "svip");
        bundle.putString(VasH5PayUtil.SENDUIN, getApp().getCurrentAccountUin());
        VasH5PayUtil.openClubPay(this, bundle);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void onFetchTroopMemberList(boolean z16, boolean z17, final List<TroopMemberInfo> list, long j3) {
        Object valueOf;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread id:");
            sb5.append(Thread.currentThread().getId());
            sb5.append(",threadName:");
            sb5.append(Thread.currentThread().getName());
            sb5.append("|onUpdateTroopGetMemberList:");
            sb5.append(z16);
            sb5.append("|troopMemberInfoList size:");
            if (list == null) {
                valueOf = "";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            sb5.append("|forceNet:");
            sb5.append(z17);
            sb5.append("|time:");
            sb5.append(currentTimeMillis - j3);
            QLog.d(TAG_NET, 2, sb5.toString());
        }
        this.convertDataStartTime = System.currentTimeMillis();
        if (z16) {
            if (z17) {
                try {
                    hadInitData.put(getInitDataKey(), Boolean.TRUE);
                    getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + getApp().getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.mTroopUin, System.currentTimeMillis()).commit();
                } catch (Exception e16) {
                    QLog.e(TAG_ERR, 1, e16, "onUpdateTroopGetMemberList");
                    return;
                }
            }
            this.convertDataStartTime = System.currentTimeMillis();
            if (enableConvertDataOpt()) {
                this.mHandler.removeMessages(1);
                int i3 = this.mFrom;
                if (i3 != 13 && i3 != 21) {
                    processMemberListDataV2(list);
                    ((IRobotInfoUpdateService) getApp().getRuntimeService(IRobotInfoUpdateService.class, "")).onEnterTroopMemberList(list);
                    return;
                } else {
                    processMemberUinListData(list, this.mMemberUins);
                    return;
                }
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.hg
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberListActivity.this.lambda$onFetchTroopMemberList$23(list);
                }
            });
            processOwnerAdminData(list);
            return;
        }
        int i16 = this.mFrom;
        if (i16 != 13 && i16 != 21) {
            getTroopMemberFromDBIfNeeded();
        } else {
            getMemberListFromUinList(this.mTroopUin, this.mMemberUins);
        }
    }

    private void onShowMemberCard(Intent intent, IFriendDataService iFriendDataService) {
        final String str;
        final int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("memberOperationFlag", 0);
            str = intent.getStringExtra("memberOperateUin");
        } else {
            str = "";
        }
        if (i3 == 0) {
            return;
        }
        if ((i3 & 2) != 0) {
            updateMemberInfo(str, iFriendDataService);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.hh
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberListActivity.this.lambda$onShowMemberCard$1(i3, str);
                }
            }, 32, null, true);
        }
    }

    private void onTriggerSearchBar() {
        clickSearchBar();
        doReport("Clk_find", this.mMyTroopRole, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadSearchData() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.gb
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListActivity.this.lambda$preloadSearchData$31();
            }
        }, 16, null, false);
    }

    private void processMemberListData(final List<TroopMemberInfo> list) {
        int i3;
        this.mListData.clear();
        this.mFakeProgess = 0.0d;
        this.mJobCount = -1;
        this.mTroopMemberCount = 0;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    int size = list.size();
                    this.mTroopMemberCount = size;
                    int i16 = size / 1000;
                    if (size % 1000 == 0) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    this.mJobCount = i16 + i3;
                    final int i17 = 0;
                    while (i17 < size) {
                        int i18 = i17 + 1000;
                        final int min = Math.min(i18 - 1, size);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.he
                            @Override // java.lang.Runnable
                            public final void run() {
                                TroopMemberListActivity.this.lambda$processMemberListData$40(list, i17, min);
                            }
                        }, 16, null, true);
                        i17 = i18;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG_DB, 2, "processMemberListData, listSize:" + size + "|mJobCount:" + this.mJobCount);
                        return;
                    }
                    return;
                }
            } catch (Exception | OutOfMemoryError e16) {
                QLog.e(TAG_ERR, 1, e16, "processMemberListData");
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG_DB, 2, "troopMemberInfoList == null || troopMemberInfoList.isEmpty()");
        }
        stopTitleProgress();
        QQToast.makeText(this, getString(R.string.f171139ci4), 0).show(getTitleBarHeight());
    }

    private void processMemberListDataV2(List<TroopMemberInfo> list) {
        QLog.d(TAG, 1, "processMemberListDataV2: ");
        this.mListData.clear();
        this.mJobCount = 0;
        this.mTroopMemberCount = 0;
        this.needInitSearchData = true;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            this.mTroopMemberCount = size;
            StringBuilder sb5 = new StringBuilder();
            TroopInfo findTroopInfo = ((ITroopInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopInfoService.class)).findTroopInfo(this.mTroopUin);
            com.tencent.qqnt.inner.compator.troopinfo.d dVar = new com.tencent.qqnt.inner.compator.troopinfo.d();
            dVar.b(findTroopInfo);
            ArrayList arrayList = new ArrayList();
            ITroopRobotService iTroopRobotService = (ITroopRobotService) getApp().getRuntimeService(ITroopRobotService.class, "all");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "processMemberListDataV2: start preload no friend remark");
            }
            ArrayList<Pair<String, String>> arrayList2 = new ArrayList<>();
            for (TroopMemberInfo troopMemberInfo : list) {
                arrayList2.add(new Pair<>(troopMemberInfo.memberuin, troopMemberInfo.memberUid));
            }
            ((ITroopMemberTempApi) QRoute.api(ITroopMemberTempApi.class)).preloadNoFriendRemark(arrayList2);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "processMemberListDataV2: end preload no friend remark");
            }
            for (TroopMemberInfo troopMemberInfo2 : list) {
                if (troopMemberInfo2 != null) {
                    MemberRole memberRole = troopMemberInfo2.role;
                    if (memberRole == MemberRole.OWNER && findTroopInfo != null) {
                        findTroopInfo.troopowneruin = troopMemberInfo2.memberuin;
                    } else if (memberRole == MemberRole.ADMIN) {
                        sb5.append(troopMemberInfo2.memberuin);
                        sb5.append("|");
                    }
                    if (!filterMember(troopMemberInfo2, iTroopRobotService)) {
                        com.tencent.mobileqq.troop.troopmemberlist.a d16 = com.tencent.mobileqq.troop.troopmemberlist.a.INSTANCE.d(this, troopMemberInfo2, this.mAddFrdHelper, this.mChooseIsNeedColorNickName);
                        arrayList.add(d16);
                        troopMemberInfo2.updatePinyin(d16.i());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                if (findTroopInfo != null) {
                    QLog.d(TAG, 2, "processMemberListDataV2: troopOwner=" + findTroopInfo.troopowneruin + ", admin=" + findTroopInfo.Administrator);
                } else {
                    QLog.e(TAG, 1, "processMemberListDataV2: troopinfo is null");
                }
            }
            getApp().getCurrentUin();
            if (findTroopInfo != null) {
                findTroopInfo.Administrator = sb5.toString();
                dVar.a(findTroopInfo).c();
                this.mTroopOwnerUin = findTroopInfo.troopowneruin;
                this.mIsTroopAdmin = findTroopInfo.isOwnerOrAdmin();
                if (findTroopInfo.isOwner()) {
                    this.mMyTroopRole = "0";
                } else if (findTroopInfo.isOwnerOrAdmin()) {
                    this.mMyTroopRole = "1";
                }
            }
            this.controller.h(arrayList);
            Message obtainMessage = this.mHandler.obtainMessage(12, arrayList);
            obtainMessage.arg1 = size;
            this.mHandler.sendMessage(obtainMessage);
            ((ITroopMemberTempApi) QRoute.api(ITroopMemberTempApi.class)).clearNoFriendRemarkCache();
            TroopMemberDBExtInfoRepo.INSTANCE.updateTroopMemberShowNamePinyin(this.mTroopUin, list, TAG);
            if (this.readFromDB) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.hb
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.this.lambda$processMemberListDataV2$39();
                    }
                }, 16, null, false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG_DB, 2, "troopMemberInfoList == null || troopMemberInfoList.isEmpty()");
        }
        com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.mobileqq.activity.ha
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListActivity.this.lambda$processMemberListDataV2$38();
            }
        });
    }

    private void processMemberUinListData(List<TroopMemberInfo> list, List<String> list2) {
        HashMap hashMap = new HashMap();
        for (TroopMemberInfo troopMemberInfo : list) {
            hashMap.put(troopMemberInfo.memberuin, troopMemberInfo);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            TroopMemberInfo troopMemberInfo2 = (TroopMemberInfo) hashMap.get(it.next());
            if (troopMemberInfo2 != null) {
                arrayList.add(com.tencent.mobileqq.troop.troopmemberlist.a.INSTANCE.a(this, troopMemberInfo2, this.mAddFrdHelper, this.mChooseIsNeedColorNickName));
            }
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(2, new Object[]{arrayList}));
    }

    private void processOwnerAdminData(List<TroopMemberInfo> list) {
        TroopInfo findTroopInfo = ((ITroopInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopInfoService.class)).findTroopInfo(this.mTroopUin);
        if (findTroopInfo == null) {
            return;
        }
        com.tencent.qqnt.inner.compator.troopinfo.d dVar = new com.tencent.qqnt.inner.compator.troopinfo.d();
        dVar.b(findTroopInfo);
        StringBuilder sb5 = new StringBuilder();
        for (TroopMemberInfo troopMemberInfo : list) {
            String str = troopMemberInfo.memberuin;
            if (str != null && !"".equals(str.trim())) {
                MemberRole memberRole = troopMemberInfo.role;
                if (memberRole == MemberRole.OWNER) {
                    findTroopInfo.troopowneruin = troopMemberInfo.memberuin;
                } else if (memberRole == MemberRole.ADMIN && !troopMemberInfo.memberuin.trim().equals(findTroopInfo.troopowneruin)) {
                    sb5.append(troopMemberInfo.memberuin);
                    sb5.append("|");
                }
            }
        }
        findTroopInfo.Administrator = sb5.toString();
        dVar.a(findTroopInfo).c();
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 11;
        obtainMessage.obj = findTroopInfo;
        this.mHandler.sendMessage(obtainMessage);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, findTroopInfo.Administrator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI(Message message) {
        boolean z16;
        if (message == null) {
            return;
        }
        RelativeLayout relativeLayout = this.mListZone;
        if (relativeLayout != null && relativeLayout.getVisibility() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mListZone.setVisibility(0);
        }
        ij ijVar = (ij) message.obj;
        if (ijVar != null && !ijVar.g().isEmpty()) {
            t tVar = this.mAdapter;
            if (tVar != null) {
                tVar.D = ijVar.g();
                this.mAdapter.E = ijVar.b();
                this.mAdapter.F = ijVar.c();
                this.mIndexView.setLetters(ijVar.d(true));
            } else {
                QLog.e(TAG, 2, "mAdapter is null, cannot update data");
            }
            QLog.d(TAG, 2, "obj.length==3, refreshUI List count: ", Integer.valueOf(this.mListData.size()));
        } else {
            this.mListData.clear();
            QLog.d(TAG, 2, "refreshUI List count: ", Integer.valueOf(this.mListData.size()));
        }
        int size = this.mListData.size();
        if (size > 0) {
            showInactiveTitle();
            checkShowCharIndexView();
            if (this.mAdapter != null) {
                if (enableConvertDataOpt()) {
                    this.mAdapter.m();
                } else {
                    this.mAdapter.notifyDataSetChanged();
                    this.mAdapter.m();
                }
            } else {
                t tVar2 = new t();
                this.mAdapter = tVar2;
                this.controller.i(tVar2);
                this.mListView.setAdapter((ListAdapter) this.mAdapter);
            }
            this.mListView.setVisibility(0);
        }
        initTitleBarRightBtn();
        stopTitleProgress();
        if (z16) {
            this.openTimeCost = System.currentTimeMillis() - this.createActivityTimeMs;
            this.openDataSize = size;
        }
    }

    private void reportCancelDtClick(View view) {
        String str;
        HashMap hashMap = new HashMap();
        EditText editText = this.searchEditText;
        String str2 = "";
        if (editText == null) {
            str = "";
        } else {
            str = editText.getText().toString();
        }
        if (str != null) {
            str2 = str;
        }
        hashMap.put("search_query", str2);
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDialogPageOut(Boolean bool) {
        View findViewById;
        Dialog dialog = this.mSearchDialog;
        if (dialog == null || (findViewById = dialog.findViewById(R.id.root)) == null) {
            return;
        }
        if (bool.booleanValue()) {
            VideoReport.reportPgIn(findViewById);
        } else {
            VideoReport.reportPgOut(findViewById);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportTroopMemberDefaultDtClick(View view, com.tencent.mobileqq.troop.troopmemberlist.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_num", aVar.j());
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportTroopTeacherClick(View view, com.tencent.mobileqq.troop.troopmemberlist.a aVar) {
        if (aVar.f() == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_num", aVar.j());
        int i3 = aVar.f().titleId;
        if (i3 != 332 && i3 != 333) {
            hashMap.put("is_teacher", "0");
        } else {
            hashMap.put("is_teacher", "1");
        }
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRighBtnEnabledInMutiDelete() {
        int size = this.mAdapter.H.size();
        if (size > 0) {
            String format = MessageFormat.format(HardCodeUtil.qqStr(R.string.umt), Integer.valueOf(size));
            this.mRightManageBtn.setEnabled(true);
            this.mRightManageBtn.setText(format);
            this.mRightManageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gf
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopMemberListActivity.this.lambda$setRighBtnEnabledInMutiDelete$24(view);
                }
            });
            return;
        }
        this.mRightManageBtn.setEnabled(false);
        this.mRightManageBtn.setText(HardCodeUtil.qqStr(R.string.uni));
    }

    public static void setVipIconAndName(AppInterface appInterface, Context context, Resources resources, com.tencent.mobileqq.troop.widget.e eVar, com.tencent.mobileqq.troop.troopmemberlist.a aVar) {
        int color;
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        boolean useDefaultNickColor = com.tencent.mobileqq.vip.api.b.a().getVipDataForFriends(aVar.j()).getUseDefaultNickColor();
        if (!simpleUISwitch && !useDefaultNickColor) {
            if (isEnableVipGoldName) {
                color = Color.parseColor("#D09B49");
            } else {
                color = resources.getColor(R.color.skin_red_theme_version2);
            }
            if (((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getBigClubFlag(aVar.f().mBigClubVipType) != 0) {
                eVar.tvName.setTextColor(color);
                return;
            }
            int vipTypeByFlag = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getVipTypeByFlag(aVar.f().mVipType);
            if (vipTypeByFlag != 1) {
                if (vipTypeByFlag != 2) {
                    if (vipTypeByFlag != 3) {
                        if (vipTypeByFlag != 4) {
                            eVar.tvName.setTextColor(resources.getColor(R.color.qui_common_text_primary));
                            return;
                        } else {
                            eVar.tvName.setTextColor(color);
                            return;
                        }
                    }
                } else {
                    eVar.tvName.setTextColor(color);
                    return;
                }
            }
            eVar.tvName.setTextColor(color);
            return;
        }
        eVar.tvName.setTextColor(resources.getColor(R.color.qui_common_text_primary));
    }

    private void showInactiveTitle() {
        TroopInfo troopInfo;
        boolean z16;
        TroopInfo troopInfo2 = this.mTroopInfo;
        if ((troopInfo2 != null && troopInfo2.isOwnerOrAdmin()) || ((troopInfo = this.mTroopInfo) != null && troopInfo.isOwner())) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i(TAG, 1, "showInactiveTitle. uin: " + this.mTroopUin + ", from: " + this.mFrom + ", isTroopAdmin: " + z16);
        if (!this.mIsQidianPrivateTroop && z16) {
            int i3 = this.mFrom;
            if ((i3 == 0 || i3 == 17) && System.currentTimeMillis() > this.nextPullTime) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.gt
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberListActivity.this.lambda$showInactiveTitle$16();
                    }
                }, 128, null, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showKickoutWindow(final List<Long> list) {
        boolean z16 = true;
        if (list.size() < 1) {
            return;
        }
        final ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.f167936ng);
        ((TextView) reportDialog.findViewById(R.id.dialogTitle)).setText(getString(R.string.akq));
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogText);
        final CheckBox checkBox = (CheckBox) reportDialog.findViewById(R.id.checkBoxConfirm);
        if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.addRule(14);
            textView.setLayoutParams(layoutParams);
        }
        if (checkBox.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) checkBox.getLayoutParams();
            layoutParams2.addRule(14);
            checkBox.setLayoutParams(layoutParams2);
        }
        if (this.mIsTroopAdmin || this.mTroopInfoData.allowMemberKick != 1) {
            z16 = false;
        }
        ((TextView) reportDialog.findViewById(R.id.dialogTitle)).setText(getString(R.string.c0g));
        textView.setVisibility(8);
        checkBox.setText(getString(R.string.h0e));
        if (z16) {
            checkBox.setVisibility(8);
        }
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.dialogRightBtn);
        textView2.setText(17039360);
        textView3.setText(android.R.string.ok);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberListActivity.lambda$showKickoutWindow$41(reportDialog, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberListActivity.this.lambda$showKickoutWindow$42(list, checkBox, reportDialog, view);
            }
        });
        reportDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingProgress(int i3, int i16, int i17) {
        int i18 = this.mFrom;
        if (i18 != 20 && i18 != 21) {
            this.mLoadingTv.setText(String.format(HardCodeUtil.qqStr(R.string.f172832ul1), Integer.valueOf(i3), Integer.valueOf(i16)));
        } else {
            this.mLoadingTv.setText(String.format(HardCodeUtil.qqStr(R.string.umr), Integer.valueOf(i17)));
        }
        this.mProgressBar.setProgress(i17);
    }

    private void showSortTypeActionSheet() {
        if (this.sortTypeActionSheet == null) {
            this.sortTypeActionSheet = com.tencent.mobileqq.troop.troopmemberlist.g.b(this, this.mSortActionWords, this.mSortType, new Function1() { // from class: com.tencent.mobileqq.activity.hd
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$showSortTypeActionSheet$3;
                    lambda$showSortTypeActionSheet$3 = TroopMemberListActivity.this.lambda$showSortTypeActionSheet$3((Integer) obj);
                    return lambda$showSortTypeActionSheet$3;
                }
            });
        }
        this.sortTypeActionSheet.show();
    }

    private void startTitleProgress() {
        this.mListZone.setVisibility(8);
        showLoadingProgress(0, this.mTroopMemberCount, 0);
        this.mHandler.sendEmptyMessageDelayed(14, 800L);
    }

    private void triggerSelectSortType(int i3) {
        String str;
        String troopOnlineMemberHandlerName = ((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName();
        if (i3 == 0) {
            doReport("Clk_def", this.mMyTroopRole, "");
            return;
        }
        if (i3 == 1) {
            ((com.tencent.mobileqq.troop.onlinemember.api.a) getApp().getBusinessHandler(troopOnlineMemberHandlerName)).i0(this.mTroopUin);
            new com.tencent.mobileqq.statistics.q(getApp()).i("dc00899").a("Grp_online").f("mber_list").d("exp_onlineList").c(0).b(this.mTroopUin).g();
            new com.tencent.mobileqq.statistics.q(getApp()).i("dc00899").a("Grp_online").f("mber_list").d("clk_onlinefirst").b(this.mTroopUin).g();
        } else {
            if (i3 == 5) {
                ((com.tencent.mobileqq.troop.onlinemember.api.a) getApp().getBusinessHandler(troopOnlineMemberHandlerName)).x0(this.mTroopUin);
                return;
            }
            if (i3 == 2) {
                str = "Clk_lastactivetime";
            } else {
                str = "Clk_jointime";
            }
            doReport(str, "1", this.mMyTroopRole);
        }
    }

    private void updateInactiveTitleArrowMargin() {
        View findViewById;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View view = this.inactiveTitle;
        if (view != null && this.mIndexView != null && (findViewById = view.findViewById(R.id.i_n)) != null && (findViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()) != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (this.mIndexView.getVisibility() == 0) {
                marginLayoutParams.rightMargin = (int) (displayMetrics.density * 26.0f);
            } else {
                marginLayoutParams.rightMargin = (int) (displayMetrics.density * 18.0f);
            }
        }
    }

    private void updateMemberInfo(final String str, final IFriendDataService iFriendDataService) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(this.mTroopUin, str, false, this, TAG, new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.activity.hc
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopMemberListActivity.this.lambda$updateMemberInfo$2(iFriendDataService, str, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUIForAtAllRemainedCount(boolean z16, String str, boolean z17, int i3, int i16, String str2, String str3, boolean z18) {
        boolean z19;
        String str4;
        String str5;
        Object obj;
        RelativeLayout relativeLayout;
        boolean z26 = false;
        if (this.mFrom == 3 && !this.mIsTroopAdmin && this.mChatMode != 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!this.mIsTroopAdmin && z18 && (relativeLayout = this.mAllMemberLayout) != null) {
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_name);
            final String string = getString(R.string.i7z);
            textView.setText(string);
            TextView textView2 = (TextView) this.mAllMemberLayout.findViewById(R.id.i6q);
            textView2.setText("");
            ((ImageView) this.mAllMemberLayout.findViewById(R.id.dvo)).setBackgroundDrawable(((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getDefaultTroopFaceDrawableNew());
            ImageView imageView = (ImageView) this.mAllMemberLayout.findViewById(R.id.g6d);
            imageView.setVisibility(8);
            if (z19) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.hl
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopMemberListActivity.this.lambda$updateUIForAtAllRemainedCount$43(view);
                    }
                });
                textView2.setTextSize(12.0f);
            }
            this.mAllMemberLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.hm
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopMemberListActivity.this.lambda$updateUIForAtAllRemainedCount$44(string, view);
                }
            });
            if (!isApolloOrZPlan()) {
                this.mAllMemberLayout.setVisibility(0);
                this.mAllMemberLayout.setEnabled(false);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetAtAllRemianCountInfo:" + z16 + ", " + str + ", " + z17 + ", " + i3 + ", " + str2 + ", " + str3);
        }
        if (this.mAllMemberLayout != null && (obj = this.mRemainAnimDrawable) != null) {
            ((Animatable) obj).stop();
            this.mRemainAnimDrawable = null;
            ((TextView) this.mAllMemberLayout.findViewById(R.id.i6q)).setCompoundDrawables(null, null, null, null);
        }
        RelativeLayout relativeLayout2 = this.mAllMemberLayout;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() != 8) {
            this.mAllMemberLayout.setEnabled(true);
            if (z16 && str != null) {
                ((TextView) this.mAllMemberLayout.findViewById(R.id.tv_name)).setTextColor(getResources().getColor(R.color.qui_common_text_primary));
                TextView textView3 = (TextView) this.mAllMemberLayout.findViewById(R.id.i6q);
                String qqStr = HardCodeUtil.qqStr(R.string.uld);
                Button button = (Button) this.mAllMemberLayout.findViewById(R.id.fdi);
                button.setVisibility(8);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.hn
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopMemberListActivity.this.lambda$updateUIForAtAllRemainedCount$45(view);
                    }
                });
                int currentUserVipType = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getCurrentUserVipType(getApp());
                if (this.mFrom == 11) {
                    if (!str.equals(this.mTroopCode)) {
                        return;
                    }
                    this.mDiscRemainCout = i16;
                    if (z17 && i3 > 0) {
                        z26 = true;
                    }
                    this.mCanAtAll = z26;
                    if (z26) {
                        String str6 = HardCodeUtil.qqStr(R.string.ulh) + i3 + HardCodeUtil.qqStr(R.string.ulk);
                        this.mNoAtAllRemainTips = str6;
                        textView3.setText(str6);
                        str5 = qqStr + "," + this.mNoAtAllRemainTips;
                    } else if (i3 == 0) {
                        this.mNoAtAllRemainTips = HardCodeUtil.qqStr(R.string.un6);
                        str5 = qqStr + ",\u5269\u4f590\u6b21";
                        textView3.setText("\u5269\u4f590\u6b21");
                    } else {
                        this.mNoAtAllRemainTips = "";
                        str5 = qqStr + "," + HardCodeUtil.qqStr(R.string.un5);
                        textView3.setText("");
                    }
                    if (this.mIndexView.getVisibility() == 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                        layoutParams.rightMargin = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).dp2px(20.0f, getResources());
                        textView3.setLayoutParams(layoutParams);
                    }
                } else {
                    if (!str.equals(this.mTroopUin)) {
                        return;
                    }
                    this.mCanAtAll = z17;
                    this.mNoAtAllRemainTips = str3;
                    if (TextUtils.isEmpty(str2)) {
                        QLog.e(TAG, 1, "updateUIForAtAllRemainedCount remainTips empty");
                        return;
                    }
                    if (!this.mCanAtAll && currentUserVipType != 3) {
                        button.setVisibility(0);
                        str4 = str2 + ",\n\u8d85\u7ea7\u4f1a\u5458\u53ef\u7ee7\u7eed\u4f7f\u7528";
                        textView3.setGravity(21);
                        textView3.setLineSpacing(this.mDensity * 5.0f, 1.0f);
                        int length = (int) (HardCodeUtil.qqStr(R.string.f172843un2).length() * 12 * this.mDensity);
                        new DisplayMetrics();
                        float f16 = getResources().getDisplayMetrics().widthPixels;
                        float f17 = this.mDensity;
                        int i17 = (int) ((f16 - (227.0f * f17)) - (f17 * 5.0f));
                        if (length > i17) {
                            textView3.setSingleLine(false);
                            textView3.setLines(2);
                            textView3.setWidth(i17);
                            textView3.setEllipsize(TextUtils.TruncateAt.END);
                        }
                    } else {
                        str4 = str2;
                    }
                    SpannableString spannableString = new SpannableString(str4);
                    String trim = Pattern.compile("[^0-9]").matcher(str4).replaceAll("").trim();
                    if (!TextUtils.isEmpty(trim)) {
                        int indexOf = str4.indexOf(trim);
                        spannableString.setSpan(new ForegroundColorSpan(-48606), indexOf, trim.length() + indexOf, 33);
                    }
                    if (str4.contains(HardCodeUtil.qqStr(R.string.unb))) {
                        int indexOf2 = str4.indexOf(HardCodeUtil.qqStr(R.string.unc));
                        spannableString.setSpan(new ForegroundColorSpan(-48606), indexOf2, HardCodeUtil.qqStr(R.string.f172835ul4).length() + indexOf2, 33);
                    }
                    textView3.setText(spannableString);
                    str5 = qqStr + "," + str4;
                }
                this.mAllMemberLayout.setContentDescription(str5);
            }
        }
    }

    protected void checkShowCharIndexView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        ij e16 = this.controller.e();
        if (e16 != null && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkShowCharIndexView: normalMemberCount=" + e16.e() + ", otherMemberCount=" + e16.f() + ", charCount=" + e16.a());
        }
        int visibility = this.mIndexView.getVisibility();
        if (this.mSortType == 0) {
            if (this.mFrom == 11) {
                if (e16 != null && e16.e() > 6 && e16.a() > 1) {
                    this.mIndexView.setVisibility(0);
                }
            } else if (e16 != null && e16.e() + e16.f() >= this.controller.f() && e16.a() > 1) {
                this.mIndexView.setVisibility(0);
            } else {
                this.mIndexView.setVisibility(4);
            }
        } else {
            this.mIndexView.setVisibility(4);
        }
        if (visibility != this.mIndexView.getVisibility()) {
            updateInactiveTitleArrowMargin();
        }
    }

    protected void clickSearchBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.mFrom == 11) {
            ReportController.o(getApp(), "CliOper", "", "", "0X8006217", "0X8006217", 0, 0, "", "", "", "");
        }
        final int height = this.mTitleBar.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(0, -height).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.hi
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TroopMemberListActivity.this.lambda$clickSearchBar$25(valueAnimator);
            }
        });
        duration.addListener(new a(height));
        duration.start();
        this.mSearchDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.activity.hj
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                TroopMemberListActivity.this.lambda$clickSearchBar$26(height, dialogInterface);
            }
        });
        this.searchEditText.setText("");
        this.searchEditText.setSelection(0);
        this.searchEditText.requestFocus();
        TextView textView = (TextView) this.mSearchDialog.findViewById(R.id.f658039x);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.hk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberListActivity.this.lambda$clickSearchBar$27(view);
            }
        });
        initCancelDtReport(textView);
        this.mSearchResultList.clear();
        this.mSearchResultAdapter.notifyDataSetChanged();
        this.isSearchMode = true;
        this.hadEnterSearch = true;
    }

    protected void constructProgressDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (this.mProgressDialog == null) {
            ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
            this.mProgressDialog = reportDialog;
            reportDialog.setContentView(R.layout.account_wait);
            Dialog dialog = this.mProgressDialog;
            boolean z16 = true;
            if (this.mFrom == 1) {
                z16 = false;
            }
            dialog.setCancelable(z16);
            ((TextView) this.mProgressDialog.findViewById(R.id.dialogText)).setText(getString(R.string.hex));
        }
    }

    protected void delTroopMember() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        new com.tencent.mobileqq.statistics.q(getApp()).i("dc00899").a("Grp_mber").f("del_mber").d("clk").c(0).b(this.mTroopUin, this.mMyTroopRole).g();
        ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).startSelectTroopMemberFragment(this, true, this.mTroopInfoData.troopUin, 5);
        overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    protected void doItemClick(com.tencent.mobileqq.troop.troopmemberlist.a aVar) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null && !TextUtils.isEmpty(aVar.j())) {
            final String j3 = aVar.j();
            String showName = aVar.i().getShowName();
            int i16 = this.mFrom;
            if (i16 == 1) {
                if (getApp().getCurrentAccountUin().equals(j3)) {
                    AllInOne allInOne = new AllInOne(j3, 0);
                    allInOne.nickname = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getAccountNickName(getApp(), j3);
                    allInOne.lastActivity = 3;
                    allInOne.profileEntryType = 4;
                    ProfileUtils.openProfileCard(this, allInOne);
                    return;
                }
                openProfileCard(j3, aVar.i().getUid());
                return;
            }
            if (i16 == 2) {
                Intent intent = getIntent();
                intent.putExtra("troop_uin", this.mTroopUin);
                intent.putExtra("member_uin", j3);
                intent.putExtra("member_info", aVar.i());
                setResult(-1, intent);
                QLog.i(TAG, 1, "doItemClick finish(), troopCode=" + this.mTroopCode + " troopUin=" + this.mTroopUin + " from=" + this.mFrom);
                finish();
                return;
            }
            if (i16 != 3 && i16 != 11 && i16 != 16) {
                if (i16 != 0 && i16 != 4 && i16 != 9 && i16 != 15 && i16 != 17 && i16 != 22) {
                    if (i16 == 5 && aVar.f() != null) {
                        String str2 = this.mTroopOwnerUin;
                        if (str2 != null && str2.equals(j3)) {
                            i3 = 3;
                        } else if (aVar.f().role == MemberRole.ADMIN) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).startEditUniqueTitleActivity(this, this.mTroopUin, j3, i3, aVar.f().getSpecialTitleStr(), 2);
                        this.mActionMemberUin = j3;
                        AppInterface app = getApp();
                        String str3 = this.mTroopUin;
                        String valueOf = String.valueOf(this.mSortType);
                        if (this.isPositiveSort) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        ReportController.o(app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_person_list", 0, 0, str3, valueOf, str, "");
                        return;
                    }
                    int i17 = this.mFrom;
                    if (i17 == 14) {
                        Intent intent2 = getIntent();
                        intent2.putExtra("member_uin", j3);
                        if (aVar.f() != null) {
                            intent2.putExtra("member_nickname", aVar.f().nickInfo.getFriendNick());
                        }
                        intent2.putExtra("member_display_name", showName);
                        intent2.putExtra("troop_uin", this.mTroopUin);
                        intent2.putExtra("troop_gift_from", this.mTroopGiftFrom);
                        setResult(-1, intent2);
                        QLog.i(TAG, 1, "doItemClick finish(), troopCode=" + this.mTroopCode + " troopUin=" + this.mTroopUin + " from=" + this.mFrom);
                        finish();
                        return;
                    }
                    if (i17 != 12 && i17 != 20) {
                        if (i17 == 18) {
                            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(this.mTroopUin, j3, TAG, new Function1() { // from class: com.tencent.mobileqq.activity.gc
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit lambda$doItemClick$32;
                                    lambda$doItemClick$32 = TroopMemberListActivity.this.lambda$doItemClick$32(j3, (TroopMemberNickInfo) obj);
                                    return lambda$doItemClick$32;
                                }
                            });
                            return;
                        }
                        if (i17 == 19) {
                            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(this.mTroopUin, j3, TAG, new Function1() { // from class: com.tencent.mobileqq.activity.gd
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit lambda$doItemClick$33;
                                    lambda$doItemClick$33 = TroopMemberListActivity.this.lambda$doItemClick$33(j3, (TroopMemberNickInfo) obj);
                                    return lambda$doItemClick$33;
                                }
                            });
                            ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) com.tencent.mobileqq.troop.utils.bg.l(ITroopMemberInfoService.class);
                            if (iTroopMemberInfoService != null) {
                                iTroopMemberInfoService.getTroopMemberInfoAsync(this.mTroopInfoData.troopUin, getApp().getCurrentAccountUin(), "TroopMemberListActivity-itemClick", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.activity.ge
                                    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                                    public final void a(TroopMemberInfo troopMemberInfo) {
                                        TroopMemberListActivity.this.lambda$doItemClick$34(troopMemberInfo);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (i17 == 23) {
                            ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).openTroopFileBrowserActivity(this, this.mTroopUin, showName, j3, getApp().getCurrentAccountUin(), this.mSource);
                            return;
                        }
                        return;
                    }
                    if (this.mPickMaxNum == 1) {
                        this.mAdapter.G.clear();
                        this.mAdapter.G.add(aVar);
                        Intent intent3 = new Intent();
                        JSONArray jSONArray = new JSONArray();
                        List<com.tencent.mobileqq.troop.troopmemberlist.a> list = this.mAdapter.G;
                        if (list != null) {
                            for (com.tencent.mobileqq.troop.troopmemberlist.a aVar2 : list) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("uin", aVar2.j());
                                    jSONObject.put("nick", aVar2.i().getShowName());
                                } catch (Exception e16) {
                                    QLog.e(TAG_ERR, 1, e16, new Object[0]);
                                }
                                jSONArray.mo162put(jSONObject);
                            }
                        }
                        intent3.putExtra("result", jSONArray.toString());
                        setResult(-1, intent3);
                        QLog.i(TAG, 1, "doItemClick finish(), troopCode=" + this.mTroopCode + " troopUin=" + this.mTroopUin + " from=" + this.mFrom);
                        finish();
                        return;
                    }
                    if (this.mAdapter.G.contains(aVar)) {
                        this.mAdapter.G.remove(aVar);
                    } else {
                        int size = this.mAdapter.G.size();
                        int i18 = this.mPickMaxNum;
                        if (size < i18) {
                            this.mAdapter.G.add(aVar);
                        } else if (i18 == 1) {
                            this.mAdapter.G.clear();
                            this.mAdapter.G.add(aVar);
                        } else {
                            QQToast.makeText(this, getResources().getString(this.mPickNumExceedsWordingId, Integer.valueOf(this.mPickMaxNum)), 0).show();
                        }
                    }
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
                startTroopMemberCardActivity(j3);
                if (this.mFrom == 22) {
                    com.tencent.mobileqq.utils.eu.g("Grp_idol", "mber_list", "clk", 0, 0, this.mTroopUin);
                    return;
                }
                return;
            }
            Intent intent4 = getIntent();
            intent4.putExtra("member_display_name", showName);
            intent4.putExtra("member_uin", j3);
            intent4.putExtra("troop_uin", this.mTroopUin);
            setResult(-1, intent4);
            QLog.i(TAG, 1, "doItemClick finish(), troopCode=" + this.mTroopCode + " troopUin=" + this.mTroopUin + " from=" + this.mFrom);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        ArrayList<String> stringArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        IFriendDataService iFriendDataService = (IFriendDataService) getApp().getRuntimeService(IFriendDataService.class, "");
        if (i16 == -1) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5 && intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST)) != null && stringArrayListExtra.size() > 0) {
                            this.mHasDeletedMember = true;
                            Iterator<String> it = stringArrayListExtra.iterator();
                            while (it.hasNext()) {
                                removeItem(it.next());
                            }
                            if (this.mFrom == 15) {
                                this.deletedInactiveUins = stringArrayListExtra;
                            }
                            Handler handler = this.mHandler;
                            handler.sendMessage(handler.obtainMessage(16));
                            return;
                        }
                        return;
                    }
                    if (intent != null) {
                        ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra(PARAM_DELETED_UINS);
                        if (stringArrayListExtra2.size() > 0) {
                            Iterator<String> it5 = stringArrayListExtra2.iterator();
                            while (it5.hasNext()) {
                                removeItem(it5.next());
                            }
                            t tVar = this.mAdapter;
                            if (tVar != null) {
                                tVar.m();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (intent != null && (stringExtra = intent.getStringExtra("roomId")) != null) {
                    String discussionName = ((IDiscussionService) getApp().getRuntimeService(IDiscussionService.class, "")).getDiscussionName(getApplicationContext(), stringExtra);
                    Intent m3 = BaseAIOUtils.m(new Intent(), null);
                    m3.putExtra("uin", stringExtra);
                    m3.putExtra("uintype", 3000);
                    m3.putExtra("uinname", discussionName);
                    m3.putExtra("isBack2Root", true);
                    m3.setFlags(67108864);
                    RouteUtils.startActivity(getActivity(), m3, RouterConstants.UI_ROUTER_SPLASH);
                    QLog.i(TAG, 1, "doOnActivityResult finish(), troopCode=" + this.mTroopCode + " troopUin=" + this.mTroopUin + " from=" + this.mFrom + ", resultCode: " + i16);
                    finish();
                    return;
                }
                return;
            }
            if (intent != null && intent.getBooleanExtra(AppConstants.Key.IS_NEED_FINISH, false)) {
                z16 = true;
            }
            if (z16) {
                Intent intent2 = new Intent();
                intent2.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                setResult(-1, intent2);
                QLog.i(TAG, 1, "doOnActivityResult finish(), troopCode=" + this.mTroopCode + " troopUin=" + this.mTroopUin + " from=" + this.mFrom + ", resultCode: " + i16);
                finish();
                return;
            }
            onShowMemberCard(intent, iFriendDataService);
            return;
        }
        if (i3 == 1 && !TextUtils.isEmpty(this.mActionMemberUin)) {
            ((ITroopMemberInfoService) getApp().getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(this.mTroopUin, this.mActionMemberUin, "TroopMemberListActivity-memberCard", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.activity.hq
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    TroopMemberListActivity.this.lambda$doOnActivityResult$0(troopMemberInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mFrom == 11) {
            ReportController.o(getApp(), "CliOper", "", "", "0X8006215", "0X8006215", 0, 0, "2", "", "", "");
        }
        if (this.mLeftBackBtn.getVisibility() != 0 || !this.mLeftBackBtn.performClick()) {
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        int i3;
        TroopInfo troopInfo;
        TroopInfo troopInfo2;
        TroopInfo findTroopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        this.createActivityTimeMs = System.currentTimeMillis();
        this.mNeedStatusTrans = !isInMultiWindow();
        getWindow().setFlags(16777216, 16777216);
        super.doOnCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return false;
        }
        this.mTroopUin = extras.getString("troop_uin");
        this.mTroopName = extras.getString(AppConstants.Key.TROOP_INFO_NAME);
        this.mTroopGiftFrom = extras.getString("troop_gift_from");
        this.mLeftBackBtnText = extras.getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
        this.mIsPopUpStyle = extras.getBoolean("param_is_pop_up_style", false);
        this.mFrom = extras.getInt(ISelectMemberActivityConstants.PARAM_FROM, 0);
        this.mTroopFeeProjectId = extras.getString("param_troop_fee_project_id");
        this.mTroopFeeEntranceType = extras.getInt("param_troop_fee_entrance_type", -1);
        this.mTroopFeeCallback = extras.getString("callback");
        this.mIsApollo = extras.getBoolean("param_troop_send_apollo_msg", false);
        this.mIsZPlan = extras.getBoolean("param_troop_send_zplan_msg", false);
        this.mTroopMemberCount = extras.getInt(AppConstants.Key.TROOP_INFO_MEMBER_NUM, 0);
        this.mSortType = extras.getInt("sort_type", 0);
        this.mPickMaxNum = extras.getInt("param_pick_max_num", this.mPickMaxNum);
        this.mMemberUins = extras.getStringArrayList("param_delete_filter_member_list");
        this.mHideUins = extras.getStringArrayList("param_hide_filter_member_list");
        this.mPickNumExceedsWordingId = extras.getInt("param_pick_max_num_exceeds_wording", R.string.f171400er0);
        this.mPickTitle = extras.getString("param_pick_title_string", this.mPickTitle);
        this.mChooseIsNeedColorNickName = extras.getBoolean("need_color_nickname", true);
        this.mFilerRobot = extras.getBoolean("param_filter_robot", false);
        this.mSource = extras.getInt("key_source", 0);
        if (this.mFrom == 17) {
            new com.tencent.mobileqq.statistics.q(getApp()).i("dc00899").a("Grp_online").f("mber_list").d("exp_onlineList").c(1).b(this.mTroopUin).g();
        }
        if (this.mFrom == 22) {
            com.tencent.mobileqq.utils.eu.g("Grp_idol", "mber_list", "exp", 0, 0, this.mTroopUin);
        }
        if (this.mFrom == 9 && TextUtils.isEmpty(this.mTroopFeeProjectId) && QLog.isColorLevel()) {
            QLog.e("TroopMemberListActivity.troop.troop_fee", 2, "TextUtils.isEmpty(mTroopFeeProjectId)");
        }
        if (this.mFrom == 14) {
            this.mSortType = 7;
            this.mLoadGiftListFinish = false;
        }
        this.mChatMode = extras.getInt("param_chat_mode", 0);
        this.mCustomTitleName = extras.getString("custom_title_name");
        String string = extras.getString(ISelectMemberActivityConstants.PARAM_FROM);
        if (string != null) {
            try {
                this.mFrom = Integer.parseInt(string);
            } catch (NumberFormatException e16) {
                QLog.e(TAG_ERR, 1, e16, new Object[0]);
            }
        }
        QLog.i(TAG, 1, "doOnCreate, troopCode=" + this.mTroopCode + " troopUin=" + this.mTroopUin + " from=" + this.mFrom);
        if (this.mIsPopUpStyle) {
            setTheme(R.style.f173428d2);
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) getApp().getRuntimeService(ITroopInfoService.class, "");
        this.mIsQidianPrivateTroop = iTroopInfoService.isQidianPrivateTroop(this.mTroopUin);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnCreate, mIsQidianPrivateTroop = " + this.mIsQidianPrivateTroop + ", mTroopUin = " + this.mTroopUin);
        }
        setContentView(R.layout.c1u);
        findViews();
        if (this.mTroopMemberCount == 0 && (findTroopInfo = iTroopInfoService.findTroopInfo(this.mTroopUin)) != null) {
            this.mTroopMemberCount = findTroopInfo.wMemberNum;
        }
        try {
            this.mIsDefaultTheme = ThemeUtil.isDefaultTheme();
        } catch (Throwable th5) {
            QLog.e(TAG_ERR, 1, th5, new Object[0]);
        }
        if (this.mFrom == 15) {
            this.mSortType = 6;
        }
        com.tencent.mobileqq.troop.onlinemember.api.a aVar = (com.tencent.mobileqq.troop.onlinemember.api.a) getApp().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName());
        int i16 = this.mSortType;
        if (i16 == 1 || i16 == 8) {
            aVar.i0(this.mTroopUin);
        }
        if (this.mSortType == 5) {
            aVar.x0(this.mTroopUin);
        }
        this.mDiscussionHandler = (IDiscussionHandlerService) getApp().getRuntimeService(IDiscussionHandlerService.class, "");
        this.mLayoutInflater = getLayoutInflater();
        this.mDensity = getResources().getDisplayMetrics().density;
        IDiscussionService iDiscussionService = (IDiscussionService) getApp().getRuntimeService(IDiscussionService.class, "");
        if (iDiscussionService != null) {
            int i17 = this.mFrom;
            if (i17 != 1 && i17 != 11 && i17 != 16) {
                TroopInfo findTroopInfo2 = iTroopInfoService.findTroopInfo(this.mTroopUin);
                this.mTroopInfo = findTroopInfo2;
                this.mTroopInfoData.troopUin = this.mTroopUin;
                this.mIsHomeworkTroop = findTroopInfo2 != null && findTroopInfo2.isHomeworkTroop();
                this.mTroopInfoData.updateForTroopInfo(this.mTroopInfo, getApp().getCurrentAccountUin());
                TroopInfo troopInfo3 = this.mTroopInfo;
                if (troopInfo3 != null) {
                    this.mTroopCode = troopInfo3.troopcode;
                    this.hasSendFlowerPrivilege = TroopInfo.hasPayPrivilege(troopInfo3.troopPrivilegeFlag, 32);
                } else {
                    QLog.e(TAG_ERR, 1, "doOnCreate ERROR, from: " + this.mFrom + ", troopInfo is NULL! troopUin: " + this.mTroopUin);
                    finish();
                    return false;
                }
            } else {
                this.mDiscussionInfo = (DiscussionInfo) iDiscussionService.findDiscussionInfoByID(this.mTroopUin);
                this.mTroopCode = this.mTroopUin;
            }
            if (this.mFrom == 5 && (troopInfo2 = this.mTroopInfo) != null && !troopInfo2.isTroopOwner(getApp().getCurrentAccountUin())) {
                QLog.e(TAG_ERR, 1, "doOnCreate ERROR, from: " + this.mFrom + ", isTroopOwner = false! troopUin: " + this.mTroopUin);
                finish();
                return false;
            }
            int i18 = this.mFrom;
            if (i18 != 1 && i18 != 11 && i18 != 16) {
                getApp().addObserver(this.troopSettingObserver, true);
                getApp().addObserver(this.mTroopRobotObserver, true);
                getApp().addObserver(this.mTroopFeeObserver, true);
                getApp().addObserver(this.mTroopOnlineMemberObserver, true);
                getApp().addObserver(this.mTroopMessageObserver, true);
            } else {
                addObserver(this.mDiscussionObserver);
            }
            if (isApolloOrZPlan() && this.mFrom == 3) {
                this.mSortType = 2;
            }
            if (this.mFrom == 0) {
                this.mAddFrdHelper = new AddFrdHelper(this);
            }
            int i19 = this.mFrom;
            if (i19 == 1) {
                this.mIsInDeleteState = true;
                this.mSlideLeftUin = "";
                DiscussionInfo discussionInfo = this.mDiscussionInfo;
                if (discussionInfo != null) {
                    this.mTroopOwnerUin = discussionInfo.ownerUin;
                } else if (QLog.isColorLevel()) {
                    QLog.e(TAG_ERR, 1, "doOnCreate, mDiscussionInfo==null");
                }
                TroopInfo troopInfo4 = this.mTroopInfo;
                if (troopInfo4 != null && troopInfo4.isOwner()) {
                    this.mIsTroopAdmin = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doOnCreate, mDiscussionInfo owner: " + this.mTroopOwnerUin);
                }
            } else if (i19 == 11) {
                DiscussionInfo discussionInfo2 = this.mDiscussionInfo;
                if (discussionInfo2 != null) {
                    this.mTroopOwnerUin = discussionInfo2.ownerUin;
                    TroopInfo troopInfo5 = this.mTroopInfo;
                    this.mIsTroopAdmin = troopInfo5 != null && troopInfo5.isOwner();
                }
                ReportController.o(getApp(), "CliOper", "", "", "0X8006214", "0X8006214", 0, 0, "", "", "", "");
            } else {
                this.mIsInDeleteState = false;
                TroopInfo troopInfo6 = this.mTroopInfo;
                if (troopInfo6 != null) {
                    String str = troopInfo6.troopowneruin;
                    if (str != null) {
                        this.mTroopOwnerUin = str;
                    }
                    this.mIsTroopAdmin = (str != null && str.equals(getApp().getCurrentAccountUin())) || ((troopInfo = this.mTroopInfo) != null && troopInfo.isOwnerOrAdmin());
                    TroopInfo troopInfo7 = this.mTroopInfo;
                    if (troopInfo7 != null && troopInfo7.isOwner()) {
                        this.mMyTroopRole = "0";
                    } else {
                        TroopInfo troopInfo8 = this.mTroopInfo;
                        if (troopInfo8 != null && troopInfo8.isOwnerOrAdmin()) {
                            this.mMyTroopRole = "1";
                        }
                    }
                } else {
                    QLog.e(TAG_ERR, 1, "doOnCreate, mTroopInfo==null");
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doOnCreate, mTroopInfo admin:   owner:" + this.mTroopOwnerUin);
                }
            }
            if (this.mFrom == 21) {
                this.mIsInDeleteState = true;
            }
            String[] stringArray = getResources().getStringArray(R.array.f155256c7);
            String[] stringArray2 = getResources().getStringArray(R.array.f155255c6);
            TroopInfo troopInfo9 = this.mTroopInfo;
            if (troopInfo9 != null && troopInfo9.isKingBattleTroop()) {
                TroopExtDBInfo troopExtDBInfo = this.mTroopInfo.extDBInfo;
                if (troopExtDBInfo.showGameSwitchStatus == 1 && troopExtDBInfo.gameSwitchStatus == 1) {
                    z16 = true;
                    i3 = 2;
                } else {
                    z16 = false;
                    i3 = 1;
                }
                this.mSortActionWords = new String[stringArray.length + i3];
                int length = stringArray.length;
                int i26 = 0;
                int i27 = 0;
                while (i26 < length) {
                    this.mSortActionWords[i27] = stringArray[i26];
                    i26++;
                    i27++;
                }
                int i28 = i27 + 1;
                this.mSortActionWords[i27] = getResources().getString(R.string.vts);
                if (z16) {
                    this.mSortActionWords[i28] = getResources().getString(R.string.vtr);
                }
                this.mSortDescribes = new String[stringArray2.length + i3];
                int length2 = stringArray2.length;
                int i29 = 0;
                int i36 = 0;
                while (i29 < length2) {
                    this.mSortDescribes[i36] = stringArray2[i29];
                    i29++;
                    i36++;
                }
                int i37 = i36 + 1;
                this.mSortDescribes[i36] = getResources().getString(R.string.vtt);
                if (z16) {
                    this.mSortDescribes[i37] = getResources().getString(R.string.vtr);
                }
            } else {
                this.mSortActionWords = stringArray;
                this.mSortDescribes = stringArray2;
            }
            initTitleBar();
            initListView();
            int i38 = this.mFrom;
            int i39 = this.mSortType;
            TroopInfo troopInfo10 = this.mTroopInfo;
            t tVar = this.mAdapter;
            this.controller = new ii(this, extras, i38, i39, troopInfo10, tVar, this.mListData, tVar.G, this.mFilerRobot, this.mIsHomeworkTroop);
            fillData();
            setAccSoft();
            int i46 = this.mFrom;
            String str2 = "2";
            String str3 = i46 != 0 ? i46 != 2 ? i46 != 3 ? i46 != 4 ? "4" : "1" : "2" : "3" : "0";
            TroopInfo troopInfo11 = this.mTroopInfo;
            if (troopInfo11 == null || !troopInfo11.isOwner()) {
                TroopInfo troopInfo12 = this.mTroopInfo;
                if (troopInfo12 != null && troopInfo12.isOwnerOrAdmin()) {
                    str2 = "1";
                }
            } else {
                str2 = "0";
            }
            this.mMyTroopRole = str2;
            doReport("exp", str3, str2);
            if (this.mFrom == 14) {
                showTroopSendFlowerNoPermission();
            }
            if (this.mFrom == 18) {
                ReportController.o(getApp(), "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_exp", 0, 0, this.mTroopUin, "", "", "");
            }
            doPageReportTask();
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doOnCreate ERROR, from: ");
        sb5.append(this.mFrom);
        sb5.append(", troopInfoService: ");
        sb5.append(false);
        sb5.append(", dm: ");
        sb5.append(iDiscussionService == null);
        QLog.e(TAG_ERR, 1, sb5.toString());
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mOnDestroy = true;
        try {
            this.mHandler.removeCallbacksAndMessages(null);
        } catch (Exception e16) {
            QLog.e(TAG_ERR, 1, e16, new Object[0]);
        }
        AddFrdHelper addFrdHelper = this.mAddFrdHelper;
        if (addFrdHelper != null) {
            addFrdHelper.destroy();
            this.mAddFrdHelper = null;
        }
        EditText editText = this.searchEditText;
        if (editText != null) {
            editText.removeTextChangedListener(this.mSearchTextWatcher);
        }
        try {
            removeObserver(this.mDiscussionObserver);
            removeObserver(this.troopSettingObserver);
            removeObserver(this.mTroopRobotObserver);
            removeObserver(this.mTroopFeeObserver);
            removeObserver(this.mTroopOnlineMemberObserver);
            removeObserver(this.mTroopMessageObserver);
        } catch (Exception e17) {
            QLog.e(TAG_ERR, 1, e17, new Object[0]);
        }
        u uVar = this.mSearchResultAdapter;
        if (uVar != null) {
            uVar.a();
        }
        super.doOnDestroy();
        Dialog dialog = this.mProgressDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
        t tVar = this.mAdapter;
        if (tVar != null) {
            tVar.destroy();
        }
        ActionSheet actionSheet = this.mActionSheet;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.mActionSheet.dismiss();
        }
        Dialog dialog2 = this.mSearchDialog;
        if (dialog2 != null && dialog2.isShowing()) {
            this.mSearchDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4 && (i16 = this.mFrom) != 1 && i16 != 13 && i16 != 21 && (this.mIsInMultiDeleteState || this.mIsInDeleteState)) {
            if (i16 == 15) {
                doOnBackPressed();
                return true;
            }
            this.mIsInMultiDeleteState = false;
            this.mTitleRightImgBtn.setVisibility(0);
            if (this.mFrom != 22) {
                this.mTitleSortImgBtn.setVisibility(0);
            }
            this.mRightManageBtn.setVisibility(8);
            this.mLeftBackBtn.setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
            this.mLeftBackBtn = textView;
            textView.setVisibility(0);
            this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
            t tVar = this.mAdapter;
            if (tVar != null) {
                tVar.m();
            }
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        try {
            getWindow().setSoftInputMode(48);
        } catch (Exception e16) {
            QLog.e(TAG_ERR, 1, e16, new Object[0]);
        }
        View view = this.mTitleBar;
        if (view != null) {
            view.destroyDrawingCache();
            this.mTitleBar.requestLayout();
            this.mTitleBar.invalidate();
        }
        AddFrdHelper addFrdHelper = this.mAddFrdHelper;
        if (addFrdHelper != null) {
            addFrdHelper.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnStop();
            getWindow().setSoftInputMode(16);
        }
    }

    protected void doReport(String str, String str2, String str3) {
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, str, str2, str3);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "doReport, actionName=" + str + " ext2=" + str2 + " ext3=" + str3 + " from=" + this.mFrom);
            }
            int i3 = this.mFrom;
            if (i3 != 1 && i3 != 11) {
                if (i3 == 9) {
                    if (this.mTroopFeeEntranceType == 1) {
                        str4 = "suc_pay_list";
                    } else {
                        str4 = "un_pay_list";
                    }
                    ReportController.o(getApp(), "P_CliOper", "Grp_pay", "", str4, str, 0, 0, this.mTroopUin, str3, "", "");
                    return;
                }
                ReportController.o(getApp(), "P_CliOper", "Grp_mber", "", "mber_list", str, 0, 0, this.mTroopUin, str2, str3, "");
            }
        } catch (Exception e16) {
            QLog.e(TAG_ERR, 1, e16, "doReport");
        }
    }

    protected void fillData() {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        startTitleProgress();
        int i3 = this.mFrom;
        if (i3 == 9) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.gv
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberListActivity.this.lambda$fillData$20();
                }
            }, 128, null, true);
            return;
        }
        if (i3 != 15 && i3 != 1 && i3 != 11 && i3 != 16) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(13));
            runnable = null;
        } else {
            runnable = new Runnable() { // from class: com.tencent.mobileqq.activity.gw
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberListActivity.this.lambda$fillData$21();
                }
            };
        }
        int i16 = this.mFrom;
        if (i16 != 11 && i16 != 1 && i16 != 16) {
            fetchTroopMemberInner();
        }
        if (runnable != null) {
            ThreadManagerV2.excute(runnable, 32, null, true);
        }
        if (this.mFrom == 14) {
            ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).requestGiftMemberList(getApp(), this.mTroopUin, new r());
        }
    }

    protected com.tencent.mobileqq.troop.widget.e findListItemHolderByUin(String str, boolean z16) {
        ViewGroup viewGroup;
        com.tencent.mobileqq.troop.widget.e eVar;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (com.tencent.mobileqq.troop.widget.e) iPatchRedirector.redirect((short) 33, this, str, Boolean.valueOf(z16));
        }
        if (z16) {
            viewGroup = this.searchList;
        } else {
            viewGroup = this.mListView;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getTag() != null && (childAt.getTag() instanceof com.tencent.mobileqq.troop.widget.e) && (str2 = (eVar = (com.tencent.mobileqq.troop.widget.e) childAt.getTag()).f187210d) != null && str2.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "findListItemHolderByUin:" + i3);
                }
                return eVar;
            }
        }
        return null;
    }

    protected void findViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.mRootView = (LinearLayout) findViewById(R.id.k09);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.mRootView.setFitsSystemWindows(true);
        }
        this.mTitleBar = findViewById(R.id.jo9);
        this.mTitle = (TextView) findViewById(R.id.ivTitleName);
        this.mSubTitle = (TextView) findViewById(R.id.f165889ds3);
        this.mTitleLayout = (LinearLayout) findViewById(R.id.asq);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.mLeftBackBtn = textView;
        int i3 = this.mFrom;
        if (i3 == 3 || i3 == 11) {
            textView.setVisibility(8);
            TextView textView2 = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
            this.mLeftBackBtn = textView2;
            textView2.setVisibility(0);
        }
        if (AppSetting.f99565y) {
            AccessibilityUtil.p(this.mLeftBackBtn, HardCodeUtil.qqStr(R.string.f170549u3));
        }
        this.mRightManageBtn = (TextView) findViewById(R.id.ivTitleBtnRightText);
        this.mTitleRightImgBtn = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.mListView = (PinnedDividerSwipListView) findViewById(R.id.f167018k05);
        this.mIndexView = (IndexBar) findViewById(R.id.xmb);
        this.indexBarTips = (IndexBarTipsLayout) findViewById(R.id.dji);
        this.mLoadingView = findViewById(R.id.i5n);
        this.mListZone = (RelativeLayout) findViewById(R.id.ebu);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ef7);
        this.mLoadingLayout = relativeLayout;
        this.mProgressBar = (ProgressBar) relativeLayout.findViewById(R.id.d7z);
        this.mLoadingTv = (TextView) this.mLoadingLayout.findViewById(R.id.efr);
        this.mTitleRightImgBtn.setContentDescription(getString(R.string.epf));
        initTitleSortImgBtn();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "finish. uin: " + this.mTroopUin + ", from: " + this.mFrom + ", readFromDB: " + this.readFromDB);
        int i3 = this.openDataSize;
        if (i3 > 0) {
            com.tencent.mobileqq.troop.troopmemberlist.e.b(this.openTimeCost, i3, this.maxIndex, this.hadEnterSearch, this.readFromDB, this.convertDataCost, this.convertDataOpt, this.mTroopUin, this.mSortType);
        }
        if (this.mFrom == 9 && (this.mHasDeletedMember || this.mTroopFeeMemberCount != this.mListData.size())) {
            Intent intent = new Intent();
            intent.putExtra("key_troop_fee_notify_js_data_changed", true);
            intent.putExtra("callback", this.mTroopFeeCallback);
            setResult(-1, intent);
        }
        super.finish();
        if (this.mIsPopUpStyle) {
            overridePendingTransition(0, R.anim.f154423k);
        }
        if (this.mFrom == 12) {
            overridePendingTransition(0, R.anim.f154458a7);
        }
    }

    public AppInterface getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (AppInterface) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    protected synchronized ij getDiscussionMemberFromDB(String str) {
        DiscussionInfo discussionInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (ij) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        }
        this.mListData.clear();
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDiscussionMemberFromDB, uin:" + str);
            }
            ArrayList arrayList = (ArrayList) ((IDiscussionService) getApp().getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberInfoListByUin(str);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    DiscussionMemberInfo discussionMemberInfo = (DiscussionMemberInfo) arrayList.get(i3);
                    if (discussionMemberInfo != null) {
                        String str2 = discussionMemberInfo.memberUin;
                        if (str2 != null && str2.trim().length() > 0 && !discussionMemberInfo.memberUin.trim().equalsIgnoreCase("0")) {
                            if ((this.mFrom != 2 || !discussionMemberInfo.memberUin.equals(this.mTroopOwnerUin)) && (this.mFrom != 1 || (discussionInfo = this.mDiscussionInfo) == null || !discussionMemberInfo.memberUin.equals(discussionInfo.inheritOwnerUin))) {
                                this.mListData.add(com.tencent.mobileqq.troop.troopmemberlist.a.INSTANCE.b(discussionMemberInfo, this.mAddFrdHelper));
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "getDiscussionMemberFromDB, continued:" + discussionMemberInfo.memberUin);
                        }
                    }
                }
                QProxyManager qProxyManager = (QProxyManager) getApp().getProxyManagerInner();
                if (qProxyManager != null) {
                    qProxyManager.notifyRefreshTroopMember();
                }
            }
            return this.controller.G();
        } catch (Exception | OutOfMemoryError e16) {
            QLog.d(TAG_ERR, 1, e16, "getDiscussionMemberFromDB");
            return null;
        }
    }

    protected synchronized void getMemberListFromUinList(String str, final List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, (Object) list);
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            TroopMemberListRepo.INSTANCE.fetchTroopMemberUinListInfo(str, new ArrayList(list), false, this, TAG, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.gj
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z16, List list2) {
                    TroopMemberListActivity.this.lambda$getMemberListFromUinList$35(list, currentTimeMillis, z16, list2);
                }
            });
        }
    }

    protected synchronized void getTroopMemberFromDBIfNeeded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG_DB, 2, "getTroopMemberFromDBIfNeeded, uin:" + this.mTroopUin);
        }
        this.convertDataStartTime = System.currentTimeMillis();
        fetchTroopMemberList(false, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.gg
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                TroopMemberListActivity.this.lambda$getTroopMemberFromDBIfNeeded$37(z16, list);
            }
        });
    }

    protected void initListView() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.f169147c20, (ViewGroup) this.mListView, false);
        this.mSearchBar = inflate.findViewById(R.id.iir);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f164294rc);
        this.mAllMemberLayout = relativeLayout;
        relativeLayout.setVisibility(8);
        AccessibilityUtil.n(this.mSearchBar, false);
        AccessibilityUtil.n(inflate, false);
        TextView textView = (TextView) this.mAllMemberLayout.findViewById(R.id.tv_name);
        this.mLeftMarginOfNick = ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin;
        int i3 = this.mFrom;
        if (i3 == 3 && this.mIsTroopAdmin && this.mChatMode != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == 11 && this.mIsTroopAdmin) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || z17) {
            final String string = getString(R.string.i7z);
            textView.setText(string);
            TextView textView2 = (TextView) this.mAllMemberLayout.findViewById(R.id.i6q);
            textView2.setText("");
            ((ImageView) this.mAllMemberLayout.findViewById(R.id.dvo)).setBackgroundDrawable(((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getDefaultTroopFaceDrawableNew());
            ImageView imageView = (ImageView) this.mAllMemberLayout.findViewById(R.id.g6d);
            imageView.setVisibility(8);
            if (z16) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.hr
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopMemberListActivity.this.lambda$initListView$10(view);
                    }
                });
                textView2.setTextSize(12.0f);
            }
            this.mAllMemberLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.hs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopMemberListActivity.this.lambda$initListView$11(string, view);
                }
            });
            if (!isApolloOrZPlan()) {
                this.mAllMemberLayout.setVisibility(0);
                this.mAllMemberLayout.setEnabled(false);
            }
            mt2.a aVar = (mt2.a) getApp().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopMessageHandlerName());
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QQToast.makeText(this, 1, R.string.f171137ci2, 0).show(getTitleBarHeight());
            } else {
                IDiscussionHandlerService iDiscussionHandlerService = this.mDiscussionHandler;
                if (iDiscussionHandlerService != null && this.mFrom == 11) {
                    iDiscussionHandlerService.getAtAllRemainCountInfo(getApp().getCurrentAccountUin(), this.mTroopCode);
                } else if (aVar != null) {
                    aVar.getAtAllRemainCountInfo(getApp().getCurrentAccountUin(), this.mTroopUin);
                }
                Drawable drawable = getResources().getDrawable(R.drawable.common_loading6);
                this.mRemainAnimDrawable = drawable;
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                ((Animatable) this.mRemainAnimDrawable).start();
            }
        }
        int i16 = this.mFrom;
        if (i16 == 3 && !this.mIsTroopAdmin && this.mChatMode != 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (i16 == 11 && !this.mIsTroopAdmin) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (this.mTroopInfoData.isNewTroop && (z18 || z19)) {
            mt2.a aVar2 = (mt2.a) getApp().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopMessageHandlerName());
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QQToast.makeText(this, 1, R.string.f171137ci2, 0).show(getTitleBarHeight());
            } else {
                IDiscussionHandlerService iDiscussionHandlerService2 = this.mDiscussionHandler;
                if (iDiscussionHandlerService2 != null && this.mFrom == 11) {
                    iDiscussionHandlerService2.getAtAllRemainCountInfo(getApp().getCurrentAccountUin(), this.mTroopCode);
                } else if (aVar2 != null) {
                    aVar2.getAtAllRemainCountInfo(getApp().getCurrentAccountUin(), this.mTroopUin);
                }
            }
        }
        EditText editText = (EditText) this.mSearchBar.findViewById(R.id.f66003_g);
        editText.setFocusableInTouchMode(false);
        editText.setCursorVisible(false);
        editText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.ht
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberListActivity.this.lambda$initListView$12(view);
            }
        });
        this.mSearchBar.findViewById(R.id.f65993_f).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.fy
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopMemberListActivity.this.lambda$initListView$13(view);
            }
        });
        if (isHomeworkChatHistory()) {
            View inflate2 = getLayoutInflater().inflate(R.layout.c1v, (ViewGroup) this.mListView, false);
            inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.fz
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopMemberListActivity.this.lambda$initListView$15(view);
                }
            });
            this.mListView.addHeaderView(inflate2);
        } else {
            int i17 = this.mFrom;
            if (i17 != 9 && i17 != 15) {
                this.mListView.addHeaderView(inflate);
            }
        }
        t tVar = new t();
        this.mAdapter = tVar;
        this.mListView.setAdapter((ListAdapter) tVar);
        int i18 = this.mFrom;
        if (i18 == 19 || i18 == 21) {
            this.mSearchBar.setVisibility(8);
        }
        int i19 = this.mFrom;
        if (i19 != 9 && i19 != 19) {
            initSearchDialogAndSearchList();
        }
        initIndexTouchListener();
    }

    protected void initTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        int i3 = this.mFrom;
        if (i3 == 1) {
            this.mTitle.setText(getString(R.string.atm));
            this.mLeftBackBtn.setVisibility(4);
            this.mRightManageBtn.setText(getString(R.string.b9f));
            this.mRightManageBtn.setVisibility(0);
            this.mRightManageBtn.setContentDescription(getString(R.string.atq));
            this.mRightManageBtn.setOnClickListener(this.mFinishListener);
        } else if (i3 == 2) {
            this.mTitle.setText(getString(R.string.f170079fa));
            this.mRightManageBtn.setVisibility(8);
            this.mTitleRightImgBtn.setVisibility(8);
            this.mTitleRightImgBtn.setImageResource(TokenResUtils.getTokenRes1(R.drawable.header_btn_more, R.drawable.qui_more_icon_navigation_01_selector));
            this.mTitleSortImgBtn.setVisibility(0);
            this.mLeftBackBtn.setContentDescription(getString(R.string.cpa) + getString(R.string.f170645x8));
            this.mLeftBackBtn.setOnClickListener(new i());
        } else if (i3 == 3) {
            this.mTitle.setText(getString(R.string.f171317e05));
            this.mLeftBackBtn.setText(R.string.cancel);
            this.mRightManageBtn.setVisibility(8);
            this.mTitleRightImgBtn.setVisibility(8);
            this.mTitleRightImgBtn.setImageResource(TokenResUtils.getTokenRes1(R.drawable.header_btn_more, R.drawable.qui_more_icon_navigation_01_selector));
            this.mTitleSortImgBtn.setVisibility(0);
            this.mLeftBackBtn.setOnClickListener(new l());
        } else if (i3 == 11) {
            this.mTitle.setText(getString(R.string.e07));
            this.mLeftBackBtn.setText(R.string.cancel);
            this.mRightManageBtn.setVisibility(8);
            this.mTitleRightImgBtn.setVisibility(8);
            this.mTitleSortImgBtn.setVisibility(8);
            this.mLeftBackBtn.setOnClickListener(new m());
        } else if (i3 == 5) {
            this.mTitle.setText(getString(R.string.dvp));
            if (this.mLeftBackBtnText == null) {
                this.mLeftBackBtnText = getString(R.string.button_back);
            }
            this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
            this.mTitleRightImgBtn.setVisibility(8);
            this.mTitleSortImgBtn.setVisibility(0);
            this.mTitleRightImgBtn.setImageResource(TokenResUtils.getTokenRes1(R.drawable.header_btn_more, R.drawable.qui_more_icon_navigation_01_selector));
        } else if (i3 != 14 && i3 != 16) {
            if (i3 == 15) {
                this.mTitle.setText(R.string.i8b);
                this.mRightManageBtn.setText(R.string.f170869aw3);
                this.mRightManageBtn.setVisibility(0);
                this.mRightManageBtn.setOnClickListener(this.mMultiDeleteListener);
                this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
                this.mTitleRightImgBtn.setVisibility(8);
                this.mTitleSortImgBtn.setVisibility(8);
            } else if (i3 != 12 && i3 != 20 && i3 != 21) {
                if (i3 == 18) {
                    this.mTitle.setText(R.string.i5s);
                    this.mRightManageBtn.setVisibility(8);
                    this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
                    this.mTitleSortImgBtn.setVisibility(8);
                    this.mTitleRightImgBtn.setVisibility(8);
                } else if (i3 == 19) {
                    this.mTitleRightImgBtn.setVisibility(8);
                    this.mTitleSortImgBtn.setVisibility(8);
                    this.mTitle.setText(HardCodeUtil.qqStr(R.string.ukw));
                    this.mLeftBackBtn.setOnClickListener(new n());
                } else if (i3 == 23) {
                    this.mTitle.setText(R.string.i5s);
                    this.mRightManageBtn.setVisibility(8);
                    this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
                    this.mTitleSortImgBtn.setVisibility(8);
                    this.mTitleRightImgBtn.setVisibility(8);
                } else {
                    this.mTitle.setText(HardCodeUtil.qqStr(R.string.ump));
                    String str = this.mCustomTitleName;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        this.mTitle.setText(this.mCustomTitleName);
                    }
                    if (this.mLeftBackBtnText == null) {
                        this.mLeftBackBtnText = getString(R.string.button_back);
                    }
                    this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
                    this.mRightManageBtn.setVisibility(8);
                    this.mRightManageBtn.setText(R.string.b9f);
                    if (this.mFrom != 4) {
                        this.mTitleRightImgBtn.setVisibility(0);
                        this.mTitleRightImgBtn.setImageResource(TokenResUtils.getTokenRes1(R.drawable.header_btn_more, R.drawable.qui_more_icon_navigation_01_selector));
                        this.mTitleRightImgBtn.setContentDescription(getString(R.string.epf));
                        if (this.mFrom != 22) {
                            this.mTitleSortImgBtn.setVisibility(0);
                        }
                    } else {
                        this.mTitleRightImgBtn.setVisibility(8);
                        this.mTitleSortImgBtn.setVisibility(8);
                    }
                }
            } else {
                String str2 = this.mPickTitle;
                if (str2 != null) {
                    this.mTitle.setText(str2);
                }
                this.mLeftBackBtn.setOnClickListener(this.mFinishListener);
                this.mTitleRightImgBtn.setVisibility(8);
                this.mTitleSortImgBtn.setVisibility(8);
                if (this.mPickMaxNum == 1) {
                    this.mRightManageBtn.setVisibility(8);
                } else {
                    this.mRightManageBtn.setText(getString(R.string.b9f));
                    this.mRightManageBtn.setVisibility(0);
                    this.mRightManageBtn.setContentDescription(getString(R.string.atq));
                }
            }
        } else {
            String str3 = this.mCustomTitleName;
            if (str3 != null && !TextUtils.isEmpty(str3)) {
                this.mTitle.setText(this.mCustomTitleName);
            }
            this.mLeftBackBtn.setVisibility(8);
            this.mTitleRightImgBtn.setVisibility(8);
            this.mTitleSortImgBtn.setVisibility(8);
            this.mRightManageBtn.setText(R.string.ejm);
            this.mRightManageBtn.setVisibility(0);
            this.mRightManageBtn.setOnClickListener(this.mFinishListener);
        }
        if (this.mTitleSortImgBtn.getVisibility() == 0) {
            this.mSubTitle.setVisibility(0);
            int i16 = this.mSortType;
            if (i16 >= 0) {
                String[] strArr = this.mSortDescribes;
                if (i16 < strArr.length) {
                    this.mSubTitle.setText(strArr[i16]);
                }
            }
        } else {
            this.mSubTitle.setVisibility(8);
        }
        if (this.mSortType == 8) {
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(HardCodeUtil.qqStr(R.string.ul5));
        }
        if (this.mFrom == 14) {
            this.mSubTitle.setVisibility(8);
        }
        this.mTitleLayout.setFocusable(true);
        this.mTitleLayout.setContentDescription(this.mTitle.getText().toString() + this.mSubTitle.getText().toString());
        if (TokenResUtils.useTokenRes1()) {
            this.mLeftBackBtn.setBackground(null);
            this.mLeftBackBtn.setPadding(0, 0, 0, 0);
            Drawable drawable = getResources().getDrawable(R.drawable.qui_chevron_left_icon_navigation_01_selector);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.mLeftBackBtn.setCompoundDrawables(drawable, null, null, null);
        }
    }

    protected void initTitleBarRightBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        int i3 = this.mFrom;
        if (i3 == 2 || i3 == 3 || i3 == 11 || i3 == 0 || i3 == 17 || i3 == 5 || i3 == 9 || i3 == 22) {
            if (i3 == 9 && this.mTroopFeeEntranceType == 1) {
                this.mTitleRightImgBtn.setVisibility(8);
                this.mTitleSortImgBtn.setVisibility(8);
                return;
            } else {
                this.mTitleRightImgBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopMemberListActivity.this.lambda$initTitleBarRightBtn$5(view);
                    }
                });
                this.mTitleSortImgBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gl
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopMemberListActivity.this.lambda$initTitleBarRightBtn$6(view);
                    }
                });
            }
        }
        int i16 = this.mFrom;
        if (i16 != 0 && i16 != 9 && i16 != 17 && i16 != 22) {
            if (i16 == 7) {
                this.mTitleRightImgBtn.setVisibility(8);
                this.mTitleSortImgBtn.setVisibility(8);
            } else if (i16 != 12 && i16 != 20) {
                if (i16 == 21) {
                    this.mRightManageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.go
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TroopMemberListActivity.this.lambda$initTitleBarRightBtn$9(view);
                        }
                    });
                } else if (i16 == 22) {
                    this.mTitleSortImgBtn.setVisibility(8);
                }
            } else {
                this.mRightManageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gn
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopMemberListActivity.this.lambda$initTitleBarRightBtn$8(view);
                    }
                });
            }
        } else {
            this.mRightManageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.gm
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopMemberListActivity.this.lambda$initTitleBarRightBtn$7(view);
                }
            });
        }
        if (this.mIsQidianPrivateTroop && !this.mIsTroopAdmin) {
            TroopInfo troopInfo = this.mTroopInfo;
            if (troopInfo == null || !troopInfo.mMemberInvitingFlag || troopInfo.cGroupOption == 3) {
                this.mTitleRightImgBtn.setVisibility(8);
            }
        }
    }

    protected void inviteMember() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            fetchTroopMemberList(false, new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.hp
                @Override // com.tencent.qqnt.troopmemberlist.f
                public final void a(boolean z16, List list) {
                    TroopMemberListActivity.this.lambda$inviteMember$46(z16, list);
                }
            });
            doReport("Clk_invite", this.mMyTroopRole, "");
        }
    }

    protected boolean isHomeworkChatHistory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.mFrom == 19) {
            return true;
        }
        return false;
    }

    protected void kickOutDiscussionMember(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "kickOutDiscussionMember:" + str);
        }
        try {
            if (this.mProgressDialog == null) {
                ReportDialog reportDialog = new ReportDialog(this, R.style.qZoneInputDialog);
                this.mProgressDialog = reportDialog;
                reportDialog.setContentView(R.layout.account_wait);
                Dialog dialog = this.mProgressDialog;
                if (this.mFrom != 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                dialog.setCancelable(z16);
                ((TextView) this.mProgressDialog.findViewById(R.id.dialogText)).setText(getString(R.string.f170846at4));
            }
            this.mProgressDialog.show();
            this.mDiscussionHandler.kickOutMemberFromDiscussion(Long.parseLong(this.mTroopCode), Long.valueOf(str).longValue());
        } catch (Exception e16) {
            QLog.e(TAG_ERR, 1, e16, "kickOutDiscussionMember");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            getWindow().getDecorView().invalidate();
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.mListView.setSelection(0);
            return;
        }
        int i3 = this.mAdapter.i(str);
        if (i3 != -1) {
            PinnedDividerSwipListView pinnedDividerSwipListView = this.mListView;
            pinnedDividerSwipListView.setSelection(i3 + pinnedDividerSwipListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    protected void openProfileCard(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(str2, TAG)) {
            AllInOne allInOne = new AllInOne(str, 20);
            allInOne.f260789pa = 20;
            allInOne.troopUin = this.mTroopCode;
            allInOne.troopCode = this.mTroopUin;
            allInOne.profileEntryType = 4;
            ProfileUtils.openProfileCard(this, allInOne);
            return;
        }
        AllInOne allInOne2 = new AllInOne(str, 21);
        allInOne2.f260789pa = 21;
        allInOne2.subSourceId = 11;
        allInOne2.troopUin = this.mTroopCode;
        allInOne2.troopCode = this.mTroopUin;
        allInOne2.profileEntryType = 4;
        ProfileUtils.openProfileCard(this, allInOne2);
    }

    public void refreshAddFrdState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        if (!isResume()) {
            return;
        }
        t tVar = this.mAdapter;
        if (tVar != null) {
            try {
                tVar.notifyDataSetChanged();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        u uVar = this.mSearchResultAdapter;
        if (uVar != null) {
            try {
                uVar.notifyDataSetChanged();
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
    }

    protected void refreshSearchResultList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mSearchSlideLeftUin = "";
        this.mSearchResultList.clear();
        this.root.getLayoutParams().height = -1;
        if (str != null && str.trim().length() != 0) {
            this.searchList.setVisibility(0);
            String str2 = new String(str);
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ITroopRobotService iTroopRobotService = (ITroopRobotService) getApp().getRuntimeService(ITroopRobotService.class, "all");
            synchronized (this) {
                for (int i3 = 0; i3 < this.mListData.size(); i3++) {
                    com.tencent.mobileqq.troop.troopmemberlist.a aVar = this.mListData.get(i3);
                    if (!this.mFilerRobot || !iTroopRobotService.isRobotUin(aVar.j())) {
                        aVar.r(null);
                        for (TroopMemberNickSearchInfo troopMemberNickSearchInfo : aVar.g()) {
                            if (!lowerCase.equalsIgnoreCase(troopMemberNickSearchInfo.getName()) && !lowerCase.equalsIgnoreCase(troopMemberNickSearchInfo.getPyAll()) && !lowerCase.equalsIgnoreCase(troopMemberNickSearchInfo.getPyFirst())) {
                                if (troopMemberNickSearchInfo.getName().toLowerCase().indexOf(lowerCase) != 0 && troopMemberNickSearchInfo.getPyFirst().toLowerCase().indexOf(lowerCase) != 0 && troopMemberNickSearchInfo.getPyAll().toLowerCase().indexOf(lowerCase) != 0) {
                                    if (troopMemberNickSearchInfo.getName().toLowerCase().indexOf(lowerCase) > 0 || troopMemberNickSearchInfo.getPyFirst().toLowerCase().indexOf(lowerCase) > 0 || troopMemberNickSearchInfo.getPyAll().toLowerCase().indexOf(lowerCase) > 0) {
                                        aVar.r(troopMemberNickSearchInfo);
                                        arrayList3.add(aVar);
                                        break;
                                    }
                                }
                                aVar.r(troopMemberNickSearchInfo);
                                arrayList2.add(aVar);
                                break;
                            }
                            aVar.r(troopMemberNickSearchInfo);
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(arrayList2, true);
            this.mSearchResultList.addAll(arrayList);
            this.mSearchResultList.addAll(arrayList2);
            this.mSearchResultList.addAll(arrayList3);
            if (this.mSearchResultList.isEmpty()) {
                this.searchResultTipsTextView.setText(R.string.h_i);
                this.searchResultTipsTextView.setVisibility(0);
            } else {
                this.searchResultTipsTextView.setVisibility(8);
            }
            this.mSearchResultAdapter.c(str2);
            this.mSearchResultAdapter.notifyDataSetChanged();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i(TAG_TIME, 2, "refreshSearchResultList: searchText: " + lowerCase + " costTime: " + (currentTimeMillis2 - currentTimeMillis) + " resultSize: " + this.mSearchResultList.size() + " listSize: " + this.mListData.size());
                return;
            }
            return;
        }
        this.searchList.setVisibility(8);
        this.searchResultTipsTextView.setVisibility(8);
        this.mSearchResultAdapter.notifyDataSetChanged();
    }

    protected com.tencent.mobileqq.troop.troopmemberlist.a removeItem(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (com.tencent.mobileqq.troop.troopmemberlist.a) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeItem:" + str);
        }
        synchronized (this) {
            for (int i3 = 0; i3 < this.mListData.size(); i3++) {
                com.tencent.mobileqq.troop.troopmemberlist.a aVar = this.mListData.get(i3);
                if (aVar != null && aVar.j().equals(str)) {
                    return this.mListData.remove(i3);
                }
            }
            return null;
        }
    }

    protected void removeSearchItem(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeSearchItem:" + str);
        }
        synchronized (this.mSearchResultList) {
            int i3 = 0;
            while (true) {
                if (i3 < this.mSearchResultList.size()) {
                    com.tencent.mobileqq.troop.troopmemberlist.a aVar = this.mSearchResultList.get(i3);
                    if (aVar != null && aVar.j().equals(str)) {
                        this.mSearchResultList.remove(i3);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    protected void setAccSoft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rlCommenTitle);
        if (viewGroup != null) {
            QIphoneTitleBarActivity.setLayerType(viewGroup);
        }
        View findViewById = findViewById(R.id.jo9);
        if (findViewById != null) {
            QIphoneTitleBarActivity.setLayerType(findViewById);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            QIphoneTitleBarActivity.setLayerType(textView);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x05f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void setItemViewValue(com.tencent.mobileqq.troop.widget.e eVar, com.tencent.mobileqq.troop.troopmemberlist.a aVar, boolean z16, boolean z17) {
        String str;
        boolean z18;
        StringBuffer stringBuffer;
        TroopMemberNewLevelView troopMemberNewLevelView;
        TroopMemberNewLevelView troopMemberNewLevelView2;
        String str2;
        TextView textView;
        boolean z19;
        int i3;
        TroopMemberNewLevelView troopMemberNewLevelView3;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        int i16;
        TroopMemberNewLevelView troopMemberNewLevelView4;
        boolean z36;
        boolean z37;
        boolean z38;
        TroopMemberNewLevelView troopMemberNewLevelView5;
        TroopMemberNewLevelView troopMemberNewLevelView6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, eVar, aVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!aVar.j().equals(eVar.f187210d)) {
            QLog.d(TAG, 1, "[setItemViewValue] uin has changed");
            return;
        }
        if (z16) {
            str = this.mSearchSlideLeftUin;
        } else {
            str = this.mSlideLeftUin;
        }
        eVar.isFromSearchList = z16;
        eVar.troopMember.setVisibility(0);
        eVar.divider.setVisibility(8);
        eVar.feedback.setVisibility(8);
        eVar.f187213h.x(1, aVar.j(), new e.a().e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(aVar.j())).a());
        int i17 = this.mSortType;
        if (i17 != 1 && i17 != 5) {
            eVar.f187213h.setAlpha(1.0f);
        } else if (!aVar.l()) {
            eVar.f187213h.setAlpha(0.647f);
        } else {
            eVar.f187213h.setAlpha(1.0f);
        }
        setVipIconAndName(getApp(), this, getResources(), eVar, aVar);
        if (this.mFrom == 13 && z16) {
            String str3 = aVar.i().getShowName() + "(" + aVar.j() + ")";
            SpannableString spannableString = new SpannableString(str3);
            spannableString.setSpan(new ForegroundColorSpan(-7829368), aVar.i().getShowName().length(), str3.length(), 18);
            eVar.tvName.setText(spannableString);
        } else if (z17) {
            SpannableString createColorNickText = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).createColorNickText(aVar.f().nickInfo.getShowName(this.mChooseIsNeedColorNickName, false), 16);
            eVar.tvName.setText(createColorNickText);
            ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).setColorText(getApp(), eVar.tvName, createColorNickText);
        } else {
            SpannableString createColorNickText2 = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).createColorNickText(aVar.i().getShowName(), 16);
            eVar.tvName.setText(createColorNickText2);
            ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).setColorText(getApp(), eVar.tvName, createColorNickText2);
        }
        ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).setCustomCloth(eVar.tvName, this, aVar.f().troopColorNickId, false);
        if (z17 && eVar.remark != null) {
            eVar.remark.setText(HardCodeUtil.qqStr(R.string.ukn) + aVar.c());
        }
        eVar.f187210d = aVar.j();
        eVar.f187211e = 1;
        eVar.identity.setText("");
        if (this.mFrom == 9 && (troopMemberNewLevelView6 = eVar.troopMemberNewLevelView) != null) {
            troopMemberNewLevelView6.setVisibility(8);
        }
        eVar.kickoutBtn.setOnClickListener(this.mOnKickOutBtnClickListener);
        eVar.delIcon.setOnClickListener(this.mOnKickOutBtnClickListener);
        eVar.troopMember.setOnClickListener(this.mOnItemClickListener);
        eVar.kickoutBtn.setTag(eVar);
        eVar.delIcon.setTag(eVar);
        eVar.troopMember.setTag(eVar);
        eVar.slideLeftContent.setTag(eVar);
        if (!this.mIsInDeleteState && !this.mIsInMultiDeleteState) {
            if (this.mFrom == 21) {
                eVar.slideLeftContent.setOnClickListener(null);
                eVar.slideLeftContent.setClickable(false);
            } else {
                eVar.slideLeftContent.setOnClickListener(null);
                eVar.slideLeftContent.setClickable(false);
            }
        } else {
            eVar.slideLeftContent.setOnClickListener(this.mOnKickOutBtnClickListener);
            eVar.slideLeftContent.setClickable(true);
            if (this.mIsInMultiDeleteState) {
                eVar.troopMember.setOnClickListener(null);
            }
        }
        int i18 = this.mFrom;
        if (i18 != 1 && i18 != 13) {
            TextUtils.isEmpty(aVar.f().getSpecialTitleStr());
            if (aVar.f().role == MemberRole.OWNER) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (aVar.f().role == MemberRole.ADMIN) {
                z27 = true;
            } else {
                z27 = false;
            }
            boolean equals = getApp().getCurrentAccountUin().equals(aVar.j());
            TroopInfo troopInfo = this.mTroopInfo;
            if (troopInfo != null && troopInfo.isOwner()) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (this.mFrom == 5) {
                eVar.mUniqueTitle.setVisibility(0);
                TroopMemberNewLevelView troopMemberNewLevelView7 = eVar.troopMemberNewLevelView;
                if (troopMemberNewLevelView7 != null) {
                    troopMemberNewLevelView7.setVisibility(8);
                }
                eVar.honorView.setVisibility(8);
                com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem_Unique = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem_Unique(this.mTroopInfo, aVar.f());
                if (troopMemberRankItem_Unique != null && (troopMemberNewLevelView5 = eVar.troopMemberNewLevelView) != null) {
                    troopMemberNewLevelView5.setTroopMemberNewLevel(troopMemberRankItem_Unique);
                }
            } else {
                TroopInfo troopInfo2 = this.mTroopInfo;
                if (troopInfo2 != null) {
                    z29 = troopInfo2.isQidianPrivateTroop();
                } else {
                    z29 = false;
                }
                if ((z29 || this.mIsHomeworkTroop) && isHomeworkChatHistory() && !aVar.j().equals(getApp().getCurrentAccountUin())) {
                    eVar.mRightArrow.setVisibility(0);
                }
                TroopMemberNewLevelView troopMemberNewLevelView8 = eVar.troopMemberNewLevelView;
                if (troopMemberNewLevelView8 != null) {
                    troopMemberNewLevelView8.setVisibility(8);
                    com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(this.mTroopInfo, aVar.f());
                    if (troopMemberRankItem == null) {
                        return;
                    } else {
                        eVar.troopMemberNewLevelView.setTroopMemberNewLevel(troopMemberRankItem);
                    }
                }
                ITroopHonorService iTroopHonorService = (ITroopHonorService) getApp().getRuntimeService(ITroopHonorService.class, "");
                if (iTroopHonorService.isSupportTroopHonor(this.mTroopUin)) {
                    List<com.tencent.mobileqq.troop.honor.config.a> convertToHonorList = iTroopHonorService.convertToHonorList(aVar.f().honorList, Byte.valueOf(aVar.f().mHonorRichFlag));
                    if (convertToHonorList != null && convertToHonorList.size() > 0) {
                        eVar.honorView.setHonorList(convertToHonorList, 2);
                        eVar.honorView.setVisibility(0);
                        i16 = 8;
                    } else {
                        eVar.honorView.setHonorList(null);
                        i16 = 8;
                        eVar.honorView.setVisibility(8);
                    }
                } else {
                    i16 = 8;
                    eVar.honorView.setHonorList(null);
                    eVar.honorView.setVisibility(8);
                }
                if (this.mIsHomeworkTroop && (troopMemberNewLevelView4 = eVar.troopMemberNewLevelView2) != null) {
                    troopMemberNewLevelView4.setVisibility(i16);
                    if (z26) {
                        com.tencent.mobileqq.troop.troopmemberlevel.a aVar2 = new com.tencent.mobileqq.troop.troopmemberlevel.a();
                        aVar2.f300596g = true;
                        aVar2.f300595f = false;
                        aVar2.f300590a = 300;
                        aVar2.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar2.f300590a);
                        aVar2.f300592c = HardCodeUtil.qqStr(R.string.upl);
                        aVar2.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColorByRankId(aVar2.f300590a);
                        eVar.troopMemberNewLevelView2.setTroopMemberNewLevel(aVar2);
                    } else if (z27) {
                        com.tencent.mobileqq.troop.troopmemberlevel.a aVar3 = new com.tencent.mobileqq.troop.troopmemberlevel.a();
                        aVar3.f300596g = true;
                        aVar3.f300595f = false;
                        aVar3.f300590a = 301;
                        aVar3.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar3.f300590a);
                        aVar3.f300592c = HardCodeUtil.qqStr(R.string.upa);
                        aVar3.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColorByRankId(aVar3.f300590a);
                        eVar.troopMemberNewLevelView2.setTroopMemberNewLevel(aVar3);
                    }
                }
                int i19 = this.mFrom;
                if (i19 != 9 && i19 != 12) {
                    if (aVar.j() != null && aVar.j().equals(getApp().getCurrentAccountUin())) {
                        eVar.identity.setText(getString(R.string.cfm));
                    } else {
                        eVar.identity.setText("");
                    }
                }
            }
            ITroopRobotService iTroopRobotService = (ITroopRobotService) getApp().getRuntimeService(ITroopRobotService.class, "all");
            if (iTroopRobotService != null && iTroopRobotService.isRobotUin(aVar.j())) {
                z36 = true;
            } else {
                z36 = false;
            }
            if (this.mIsInDeleteState) {
                if (this.mFrom != 21 && (z26 || ((!z28 && z27) || (!z28 && z36)))) {
                    eVar.delIcon.setVisibility(8);
                    eVar.troopMember.c(false);
                } else {
                    eVar.delIcon.setVisibility(0);
                    eVar.delIconInner.setBackgroundResource(R.drawable.bxk);
                    if (str.equals(aVar.j())) {
                        eVar.troopMember.b(false);
                    } else {
                        eVar.troopMember.c(false);
                    }
                }
            } else {
                if (this.mIsInMultiDeleteState) {
                    if (!z26 && ((z28 || !z27) && !equals)) {
                        z37 = false;
                    } else {
                        z37 = true;
                    }
                    if (z37) {
                        eVar.delIcon.setVisibility(8);
                    } else {
                        eVar.delIcon.setVisibility(0);
                        if (aVar.j() != null && this.mAdapter.H.contains(aVar.j())) {
                            eVar.delIconInner.setBackgroundResource(R.drawable.list_checkbox_selected);
                            z38 = true;
                            z18 = z38;
                        } else {
                            eVar.delIconInner.setBackgroundResource(R.drawable.list_checkbox_multi);
                        }
                    }
                    z38 = false;
                    z18 = z38;
                } else if (this.mFrom == 20) {
                    eVar.delIcon.setVisibility(0);
                    if (aVar.j() != null && this.mAdapter.G.contains(aVar)) {
                        eVar.delIconInner.setBackgroundResource(R.drawable.list_checkbox_selected);
                        z18 = true;
                    } else {
                        eVar.delIconInner.setBackgroundResource(R.drawable.list_checkbox);
                    }
                } else {
                    eVar.delIcon.setVisibility(8);
                    eVar.troopMember.c(false);
                }
                if (eVar.mRobotMsk != null) {
                    ITroopRobotService iTroopRobotService2 = (ITroopRobotService) getApp().getRuntimeService(ITroopRobotService.class, "all");
                    if (iTroopRobotService2 != null && iTroopRobotService2.isRobotUin(aVar.j())) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        eVar.mRobotMsk.setVisibility(0);
                        if (eVar.troopMemberNewLevelView != null) {
                            if (aVar.f().role == MemberRole.ADMIN) {
                                com.tencent.mobileqq.troop.troopmemberlevel.a aVar4 = new com.tencent.mobileqq.troop.troopmemberlevel.a();
                                aVar4.f300596g = true;
                                aVar4.f300595f = false;
                                aVar4.f300590a = 301;
                                aVar4.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar4.f300590a);
                                aVar4.f300592c = HardCodeUtil.qqStr(R.string.upa);
                                aVar4.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColorByRankId(aVar4.f300590a);
                                eVar.troopMemberNewLevelView.setTroopMemberNewLevel(aVar4);
                            } else {
                                i3 = 8;
                                eVar.troopMemberNewLevelView.setVisibility(8);
                                troopMemberNewLevelView3 = eVar.troopMemberNewLevelView2;
                                if (troopMemberNewLevelView3 != null) {
                                    troopMemberNewLevelView3.setVisibility(i3);
                                }
                            }
                        }
                        i3 = 8;
                        troopMemberNewLevelView3 = eVar.troopMemberNewLevelView2;
                        if (troopMemberNewLevelView3 != null) {
                        }
                    } else {
                        eVar.mRobotMsk.setVisibility(8);
                    }
                }
                stringBuffer = new StringBuffer();
                stringBuffer.append(eVar.tvName.getText().toString());
                if (z17 && (textView = eVar.remark) != null) {
                    stringBuffer.append(textView.getText());
                }
                troopMemberNewLevelView = eVar.troopMemberNewLevelView;
                if (troopMemberNewLevelView != null && troopMemberNewLevelView.getVisibility() == 0) {
                    stringBuffer.append(eVar.troopMemberNewLevelView.getContentDescription());
                }
                troopMemberNewLevelView2 = eVar.troopMemberNewLevelView2;
                if (troopMemberNewLevelView2 != null && troopMemberNewLevelView2.getVisibility() == 0) {
                    stringBuffer.append(eVar.troopMemberNewLevelView2.getContentDescription());
                }
                if (eVar.honorView.getVisibility() == 0) {
                    stringBuffer.append(eVar.honorView.a());
                }
                if (eVar.delIcon.getVisibility() == 0 && this.mIsInMultiDeleteState) {
                    if (!z18) {
                        str2 = "\u5df2\u9009\u4e2d";
                    } else {
                        str2 = "\u672a\u9009\u4e2d";
                    }
                    stringBuffer.append(str2);
                }
                eVar.slideLeftContent.setContentDescription(new QQText(stringBuffer.toString(), 16, 16).toPlainText());
            }
        } else {
            eVar.tvName.setContentDescription(getString(R.string.atr) + eVar.tvName.getText().toString());
            eVar.delIconInner.setBackgroundResource(R.drawable.bxk);
            int i26 = this.mFrom;
            if (i26 == 13) {
                eVar.delIcon.setVisibility(0);
            } else if (i26 == 21) {
                eVar.delIcon.setVisibility(0);
            } else if (this.mTroopOwnerUin != null && !aVar.j().equals(this.mTroopOwnerUin)) {
                eVar.delIcon.setVisibility(0);
            } else {
                eVar.delIcon.setVisibility(8);
                eVar.troopMember.c(false);
            }
            if (str.equals(aVar.j())) {
                eVar.troopMember.b(false);
            } else {
                eVar.troopMember.c(false);
            }
            eVar.delIcon.setContentDescription(String.format(getString(R.string.at6), eVar.tvName.getText().toString()));
            eVar.kickoutBtn.setContentDescription(getString(R.string.at5));
        }
        z18 = false;
        if (eVar.mRobotMsk != null) {
        }
        stringBuffer = new StringBuffer();
        stringBuffer.append(eVar.tvName.getText().toString());
        if (z17) {
            stringBuffer.append(textView.getText());
        }
        troopMemberNewLevelView = eVar.troopMemberNewLevelView;
        if (troopMemberNewLevelView != null) {
            stringBuffer.append(eVar.troopMemberNewLevelView.getContentDescription());
        }
        troopMemberNewLevelView2 = eVar.troopMemberNewLevelView2;
        if (troopMemberNewLevelView2 != null) {
            stringBuffer.append(eVar.troopMemberNewLevelView2.getContentDescription());
        }
        if (eVar.honorView.getVisibility() == 0) {
        }
        if (eVar.delIcon.getVisibility() == 0) {
            if (!z18) {
            }
            stringBuffer.append(str2);
        }
        eVar.slideLeftContent.setContentDescription(new QQText(stringBuffer.toString(), 16, 16).toPlainText());
    }

    protected void showMemberDstribute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        String str = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.mTroopUin;
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this, IPublicAccountBrowser.ROUTE_NAME);
        activityURIRequest.extra().putString("url", str);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showMemberDstribute:" + str);
        }
        doReport("Clk_mberdist", this.mMyTroopRole, "");
    }

    protected void showMoreOperationActionSheet() {
        String[] stringArray;
        boolean z16;
        int length;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        int i16 = 0;
        if (this.mFrom == 9) {
            stringArray = getResources().getStringArray(R.array.f155250c1);
            z16 = false;
        } else {
            stringArray = getResources().getStringArray(R.array.f155248bz);
            z16 = true;
        }
        int i17 = this.mFrom;
        if (i17 != 0 && i17 != 17 && i17 != 22) {
            if (i17 == 9) {
                i3 = stringArray.length;
            } else {
                i3 = stringArray.length - 5;
            }
        } else if (this.mIsTroopAdmin) {
            i3 = stringArray.length;
        } else {
            TroopInfo troopInfo = this.mTroopInfo;
            if (troopInfo != null && troopInfo.mMemberInvitingFlag) {
                if (troopInfo.cGroupOption != 3) {
                    i3 = stringArray.length - 1;
                } else {
                    length = stringArray.length;
                }
            } else {
                length = stringArray.length;
            }
            i3 = length - 2;
        }
        this.mActionSheet = ActionSheet.create(this);
        while (true) {
            if (i16 >= i3) {
                break;
            }
            if (this.mIsQidianPrivateTroop) {
                if (!HardCodeUtil.qqStr(R.string.ulu).equals(stringArray[i16]) && i16 == 2) {
                    this.mActionSheet.addButton(stringArray[i16]);
                    break;
                }
            } else if (i16 == 3) {
                this.mActionSheet.addButton(stringArray[i16], 3);
            } else {
                this.mActionSheet.addButton(stringArray[i16]);
                if (stringArray[i16].equals(HardCodeUtil.qqStr(R.string.ukr))) {
                    ReportController.o(getApp(), "dc00899", "Grp_mber", "", "mber_list", "exp_Add", 0, 0, this.mTroopUin, "", "", "");
                }
            }
            i16++;
        }
        this.mActionSheet.addCancelButton(R.string.cancel);
        this.mActionSheet.setOnButtonClickListener(this.moreOperationClickListener);
        this.mActionSheet.show();
        if (z16) {
            com.tencent.mobileqq.troop.report.addfriend.a.d(this.mActionSheet, this.mTroopUin);
        }
    }

    void showTroopSendFlowerNoPermission() {
        ViewStub viewStub;
        if (!this.hasSendFlowerPrivilege && (viewStub = (ViewStub) findViewById(R.id.k1_)) != null) {
            ((LinearLayout) viewStub.inflate().findViewById(R.id.k1a)).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.activity.gy
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean lambda$showTroopSendFlowerNoPermission$47;
                    lambda$showTroopSendFlowerNoPermission$47 = TroopMemberListActivity.lambda$showTroopSendFlowerNoPermission$47(view, motionEvent);
                    return lambda$showTroopSendFlowerNoPermission$47;
                }
            });
        }
    }

    protected void startTroopMemberCardActivity(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
            return;
        }
        if (((ITroopRobotService) getApp().getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str)) {
            ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(this, str, this.mTroopUin, 8, 0, null));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.i7y));
        String str2 = this.mCustomTitleName;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            bundle.putString("custom_leftbackbutton_name", getString(R.string.button_back));
        }
        ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).openTroopmemberCard(getApp(), this, this.mTroopUin, str, 1, bundle);
        this.mActionMemberUin = str;
        doReport("Clk_item", this.mMyTroopRole, "");
    }

    void stopTitleProgress() {
        this.mHandler.removeMessages(14);
        RelativeLayout relativeLayout = this.mLoadingLayout;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.mLoadingLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.widget.IndexView.a
    public void onIndexChanged(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str, i3);
            return;
        }
        if ("$".equals(str)) {
            if (this.mFrom == 11 && i3 == 1) {
                ReportController.o(getApp(), "CliOper", "", "", "0X800621B", "0X800621B", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        if (this.mFrom == 11 && i3 == 0) {
            ReportController.o(getApp(), "CliOper", "", "", "0X800621A", "0X800621A", 0, 0, "", "", "", "");
        }
    }
}
