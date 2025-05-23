package com.tencent.mobileqq.activity;

import Wallet.PfaFriend;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.dataline.activities.LiteActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.adapter.ForwardRecentRoundItemView;
import com.tencent.mobileqq.adapter.ForwardSelectionRecentFriendGridAdapter;
import com.tencent.mobileqq.adapter.n;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.asyncdb.cache.RecentForwardUserCache;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.b;
import com.tencent.mobileqq.forward.ForwardBaseActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardChooseFriendOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.forward.ForwardFriendPermissionOption;
import com.tencent.mobileqq.forward.ForwardH5PTVOption;
import com.tencent.mobileqq.forward.ForwardH5RabbitSpringEmoteOption;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.forward.ForwardStructingMsgOption;
import com.tencent.mobileqq.forward.ForwardZPlanShareOption;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactsSearchNTFragment;
import com.tencent.mobileqq.search.business.contact.fragment.FriendPermissionSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.RabbitYearEmoteSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ZPlanSearchFragment;
import com.tencent.mobileqq.search.qqmc.SearchQQMC;
import com.tencent.mobileqq.selectfriend.api.ISelectNtSaveRecentUserApi;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.BlockTroopForwardConfig;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.api.ITroopSelectorApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.ToastUtil;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.XListView;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import wn2.ContactSearchModelNtBuddy;
import wn2.ContactSearchModelNtTroop;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Forward", testTags = {"AUTO_PRELOAD"})
@RoutePage(desc = "\u8df3\u8f6c\u6700\u8fd1\u9009\u62e9\u6846", path = RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT)
/* loaded from: classes9.dex */
public class ForwardRecentActivity extends ForwardBaseActivity implements IToPayManager.a {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_BIND_FINISH = "ForwardEntranceActivity";
    public static final String DATONG_GUILD_SHARE_CHANNEL_ITEM = "em_sgrp_share_channel_item";
    public static final String DATONG_PAGE_ID = "pg_sgrp_choose_shareview";
    public static final String FORWARD_ABILITY_ENTRENCE_SHOW_IN_SHARE = "forward_ability_entrence_show_in_share";
    public static final int FORWARD_SELECTION_REQUEST = 20000;
    protected static final String FORWARD_SHARE_CARD = "forward_share_card";
    public static final int FORWARD_TO_QZONE = 10;
    public static final String KEY_DIRECT_JUMP_QZONE_SHUOSHUO = "key_direct_jump_qzone_shuoshuo";
    protected static final String KEY_FILE = "forward_thumb";
    public static final String KEY_FORWARD_BUSINESS_ID = "key_forward_business_id";
    public static final String KEY_FORWARD_FROM_FRIEND_PERMISSION = "key_forward_from_friend_permission";
    public static final String KEY_FORWARD_FROM_MSGTAB_CAMERA = "key_forward_from_msgtab_camera";
    public static final String KEY_FORWARD_GUILD_SHARE_FROM_MINI = "key_forward_guild_share_from_mini";
    public static final String KEY_FORWARD_IMAGE_SHARE = "key_forward_image_share";
    public static final String KEY_FORWARD_IMAGE_SHARE_APPID = "key_forward_image_share_appid";
    public static final String KEY_FORWARD_IMAGE_SHARE_TITLE = "key_forward_image_share_title";
    public static final String KEY_FORWARD_IMAGE_SHARE_UIN_TYPE = "key_forward_image_share_uin_type";
    public static final String KEY_FORWARD_MATCH_FRIEND_TEST_SHARE = "key_forward_match_friend_test_share";
    public static final String KEY_FORWARD_SHARE = "key_forward_share";
    public static final String KEY_FORWARD_SHARE_FROM_ZPLAN = "key_forward_share_from_zplan";
    public static final String KEY_FORWARD_SHARE_FROM_ZPLAN_APPID = "key_forward_share_from_zplan_appid";
    public static final String KEY_FORWARD_SHARE_MATCH_FRIEND_LIST = "key_forward_share_match_friend_list";
    public static final String KEY_FORWARD_SHARE_TITLE = "key_forward_share_title";
    public static final String KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS = "k_forward_show_direct_share_tips";
    public static final String KEY_FORWARD_TITLE = "k_forward_title";
    public static final String KEY_IS_SHOW_RECENT_CHAT_LIST = "key_is_show_recent_chat_list";
    public static final String KEY_IS_SHOW_RECENT_FORWARD_LIST = "key_is_show_recent_forward_list";
    public static final String KEY_JUMP_FROM_QZONE_FEED = "key_jump_from_qzone_feed";
    public static final String KEY_JUMP_FROM_QZONE_FEED_LEFT_TITLE = "key_jump_from_qzone_feed_left_title";
    private static final String KEY_QCIRCLE_CLICK = "key_qcircle_click";
    private static final String KEY_QCIRCLE_FORWARD = "key_qcircle_forward";
    public static final String KEY_REQUEST_ORIENTATION = "k_forward_orientation";
    public static final String KEY_SEARCH_SOURCE = "searchSource";
    public static final String KEY_SHOW_CANCEL_BUTTON = "k_cancel_button";
    protected static final String KEY_TEXT = "forward_text";
    protected static final String KEY_TYPE = "forward_type";
    private static final int MAX_SELECTED_NUM = 9;
    public static final String NOT_SUPPORT_MULTI_GUILD = "\u6682\u4e0d\u652f\u6301\u591a\u9009\u9891\u9053";
    public static final String NOT_SUPPORT_SHARE_TO_GUILD = "\u4e0d\u652f\u6301\u5206\u4eab\u5230\u9891\u9053";
    private static final int NUM_MAX_RECENT_FORWARD = 5;
    private static final int ONE_DAY_SECONDS = 86400;
    public static final String PARAM_BIND_FINISH = "param_bind_finish";
    public static final int REQUEST_CODE_CREATE_DISCUSSION = 20003;
    public static final int REQUEST_CODE_FORWARD_TO_QZONE = 20005;
    public static final int REQUEST_CODE_SEND_HONG_BAO = 20002;
    public static final int REQ_CODE_PRESENT_BOOK = 20001;
    public static final String SELECTION_MODE = "selection_mode";
    public static final int SELECTION_MODE_MULTI = 2;
    public static final int SELECTION_MODE_SINGE = 1;
    private static final int STATUS_DEFAULT = 0;
    private static final int STATUS_MULTI_SELECT = 1;
    private static final int STYLE_DEFAULT = 0;
    private static final int STYLE_GRID = 2;
    static final String TAG = "ForwardOption.ForwardEntranceActivity";
    private static final int VALID_FORWARD_DATA_NUMBERS = 15;
    private static int k16dp;
    private static final Map<String, Boolean> sMigrateCache;
    String appid;
    private BroadcastReceiver bindFinishReceiver;
    private String businessId;
    FormItemRelativeLayout contactLayout;
    private com.tencent.mobileqq.search.k contactSelectOperationIoc;
    Uri dataUri;
    TipsBar directShareTips;
    private View.OnClickListener directShareTipsCloseListener;
    private final boolean enableHeaderViewStatusFix;
    private boolean enableSearchDefaultSingleModeByConfig;
    Bundle extra;
    FormItemRelativeLayout friendLayout;
    private com.tencent.mobileqq.app.ar friendListObserver;
    String fromPkgName;
    private final View.OnClickListener gameContactClickListener;
    FormItemRelativeLayout gameContactLayout;
    HorizontalListView horizontalListView;
    private final boolean isDelegateResourceEnabled;
    private final boolean isEnableArgus;
    boolean isForConfessDirectFriends;
    boolean isSdkShare;
    private boolean isShowInSare;
    private boolean isWalletPetShare;
    private final com.tencent.mobileqq.zplan.servlet.b mAvatarZPlanObserver;
    int mBusinessSubType;
    int mBusinessType;
    String mCallActivity;
    private int mCurrentStatus;
    private DataSetObserver mDataSetObserver;
    private LinearLayout mEntryContentContainer;
    private View mEntryHeader;
    private IFaceDecoder mFaceDecoder;
    private Dialog mForwardCountLimitDialog;
    private ForwardRecentItemView mForwardIpadItemView;
    ForwardBaseOption mForwardOption;
    private ForwardRecentItemView mForwardPcItemView;
    private ForwardRecentItemView mForwardPhoneItemView;
    private n.c mForwardRecentListAdapterCallback;
    private Map<String, ResultRecord> mForwardTargetMap;
    private ForwardRecentItemView mForwardWechatItemView;
    private final com.tencent.mobileqq.friend.observer.a mFriendObserver;
    private IQQGuildService mGuildService;
    private InputMethodManager mImm;
    private AutomatorObserver mInitObserver;
    private boolean mIsFinishWhenMultiSelect;
    boolean mIsForConfess;
    private boolean mIsFriendPermission;
    boolean mIsFromAIO;
    boolean mIsFromDatalineAIO;
    boolean mIsFromMini;
    boolean mIsFromShare;
    boolean mIsFromWeb;
    private boolean mIsFromZplan;
    private boolean mIsMatchFriendUserList;
    private boolean mIsRegister;
    private boolean mIsShowGuildEntrance;
    private boolean mIsShowRecentChatList;
    private boolean mIsShowRecentForwardList;
    private boolean mIsShowWechatEntrance;
    private boolean mIsSingleStatusInSearch;
    boolean mIsToPayList;
    private boolean mJumpQzoneShuoshuoDirect;
    private XListView mListView;
    LinearLayout mLlRoot;
    boolean mNeedShareCallback;
    boolean mNeedShowDirectShareTips;
    private com.tencent.mobileqq.search.view.d mOnActionListener;
    boolean mOnlySingleSelection;
    private QQProgressDialog mProgressDialog;
    protected int mReq;
    private com.tencent.mobileqq.search.view.f mSearchFragment;
    FrameLayout mSearchResultLayout;
    SelectedAndSearchBar mSelectedAndSearchBar;
    private SelectedAndSearchBar.i mSelectedAndSearchBarCallback;
    private int mStyle;
    int miniAppShareFrom;
    FormItemRelativeLayout multiChatLayout;
    private View.OnClickListener onClick;
    private BroadcastReceiver qqBroadcastReceiver;
    private View.OnClickListener qzoneEntryOnClickListener;
    FormItemRelativeLayout qzoneLayout;
    private com.tencent.mobileqq.adapter.n recentAdapter;
    protected List<RecentUser> recentChatList;
    protected List<RecentUser> recentForwardList;
    TextView recommendTv;
    private com.tencent.mobileqq.guild.feed.api.g share2GuildCallback;
    RelativeLayout tipLayout;
    TextView tipTv;
    private TextView title;
    private IToPayManager topayManager;
    FormItemRelativeLayout troopDiscussionLayout;
    private com.tencent.mobileqq.troop.api.observer.b troopMngObserver;
    private com.tencent.mobileqq.troop.api.observer.e troopObserver;
    int uinType;
    private List<String> unclickableSelectedUins;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (!ForwardRecentActivity.this.isFinishing()) {
                ForwardRecentActivity.this.finish();
                QLog.i(ForwardRecentActivity.TAG, 1, "ForwardRecentActivity has finished by broadcastReceiver.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class aa implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        aa() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardRecentActivity.this.onRightClick();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ab implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultRecord f175835d;

        ab(ResultRecord resultRecord) {
            this.f175835d = resultRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this, (Object) resultRecord);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (ForwardRecentActivity.this.isMultiSelectStatus()) {
                ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                String str = AppConstants.DATALINE_PC_UIN;
                if (forwardRecentActivity.isForwardTargetSelected(str, 6000)) {
                    ForwardRecentActivity.this.mForwardPcItemView.e(false);
                    ForwardRecentActivity.this.syncRecentChatClicked(this.f175835d, true);
                    ForwardRecentActivity.this.removeFromForwardTargetList(str, 6000);
                } else if (ForwardRecentActivity.this.add2ForwardTargetList(this.f175835d)) {
                    ForwardRecentActivity.this.mForwardPcItemView.e(true);
                    ForwardRecentActivity.this.syncRecentChatClicked(this.f175835d, false);
                }
            } else {
                ForwardRecentActivity forwardRecentActivity2 = ForwardRecentActivity.this;
                ResultRecord resultRecord = this.f175835d;
                forwardRecentActivity2.openDataLineForwardDialog(resultRecord.uin, resultRecord.getUinType());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ac implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultRecord f175837d;

        ac(ResultRecord resultRecord) {
            this.f175837d = resultRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this, (Object) resultRecord);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (ForwardRecentActivity.this.isMultiSelectStatus()) {
                ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                String str = AppConstants.DATALINE_PHONE_UIN;
                if (forwardRecentActivity.isForwardTargetSelected(str, 6005)) {
                    ForwardRecentActivity.this.mForwardPhoneItemView.e(false);
                    ForwardRecentActivity.this.removeFromForwardTargetList(str, 6005);
                } else if (ForwardRecentActivity.this.add2ForwardTargetList(this.f175837d)) {
                    ForwardRecentActivity.this.mForwardPhoneItemView.e(true);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("uin", AppConstants.DATALINE_PHONE_UIN);
                bundle.putInt("uintype", 6005);
                bundle.putString("caller_name", ForwardRecentActivity.this.mCallActivity);
                ForwardRecentActivity.this.mForwardOption.buildForwardDialog(com.tencent.mobileqq.forward.e.f211017e4.intValue(), bundle);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ad implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultRecord f175839d;

        ad(ResultRecord resultRecord) {
            this.f175839d = resultRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this, (Object) resultRecord);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (ForwardRecentActivity.this.isMultiSelectStatus()) {
                ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                String str = AppConstants.DATALINE_IPAD_UIN;
                if (forwardRecentActivity.isForwardTargetSelected(str, 6003)) {
                    ForwardRecentActivity.this.mForwardIpadItemView.e(false);
                    ForwardRecentActivity.this.removeFromForwardTargetList(str, 6003);
                } else if (ForwardRecentActivity.this.add2ForwardTargetList(this.f175839d)) {
                    ForwardRecentActivity.this.mForwardIpadItemView.e(true);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("uin", AppConstants.DATALINE_IPAD_UIN);
                bundle.putInt("uintype", 6003);
                bundle.putString("caller_name", ForwardRecentActivity.this.mCallActivity);
                ForwardRecentActivity.this.mForwardOption.buildForwardDialog(com.tencent.mobileqq.forward.e.X3.intValue(), bundle);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (!ForwardRecentActivity.this.isFinishing()) {
                ForwardRecentActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Comparator<RecentUser> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RecentUser recentUser, RecentUser recentUser2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) recentUser, (Object) recentUser2)).intValue();
            }
            return (int) (recentUser2.showUpTime - recentUser.showUpTime);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d extends TypeToken<LinkedHashMap<String, ResultRecord>> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            } else if (z16) {
                ForwardRecentActivity.this.refreshRecentList();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void m(boolean z16, byte b16, TroopInfo troopInfo, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Byte.valueOf(b16), troopInfo, Boolean.valueOf(z17));
            } else if (z16) {
                ForwardRecentActivity.this.refreshRecentList();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class g extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopMemberCardInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), arrayList, Boolean.valueOf(z17));
            } else if (z16 && arrayList != null && arrayList.size() > 0 && z17) {
                ForwardRecentActivity.this.refreshRecentList();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class h extends AutomatorObserver {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.AutomatorObserver
        protected void onCacheInited(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == 1 || i3 == 2 || i3 == 3) {
                ForwardRecentActivity.this.mForwardOption.rebuildForwardAbility();
            }
            try {
                ForwardRecentActivity.this.adjustEntryLayout();
            } catch (Exception e16) {
                QLog.e(ForwardRecentActivity.TAG, 1, "mInitObserver", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ForwardRecentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ForwardRecentActivity.this.removeWindowContent();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateSetFriendPermission(boolean z16, HashMap<String, Integer> hashMap, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap, Integer.valueOf(i3));
                return;
            }
            ForwardRecentActivity.this.mForwardOption.hideProgressDialog();
            if (z16 && hashMap != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                for (String str : hashMap.keySet()) {
                    Integer num = 0;
                    if (num.equals(hashMap.get(str))) {
                        arrayList.add(str);
                    } else {
                        arrayList2.add(str);
                    }
                }
                int size = arrayList2.size();
                if (size > 0) {
                    QQToastUtil.showQQToast(1, R.string.f225476lq, Integer.valueOf(size));
                } else {
                    QQToastUtil.showQQToast(2, R.string.f225486lr, Integer.valueOf(arrayList.size()));
                }
                Intent intent = new Intent();
                intent.putStringArrayListExtra("only_chat_remove_uins", arrayList);
                ForwardRecentActivity.this.setResult(-1, intent);
                ForwardRecentActivity.this.finish();
                return;
            }
            QQToastUtil.showQQToast(1, R.string.f221076_u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements b.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultRecord f175849a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f175850b;

        k(ResultRecord resultRecord, View view) {
            this.f175849a = resultRecord;
            this.f175850b = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardRecentActivity.this, resultRecord, view);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardRecentActivity.this.openForwardDialog(this.f175849a, this.f175850b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ForwardRecentActivity.this.openForwardDialog(this.f175849a, this.f175850b);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else if (ForwardRecentActivity.this.mDataSetObserver != null) {
                ForwardRecentActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class l implements b.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultRecord f175852a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ForwardRecentRoundItemView f175853b;

        l(ResultRecord resultRecord, ForwardRecentRoundItemView forwardRecentRoundItemView) {
            this.f175852a = resultRecord;
            this.f175853b = forwardRecentRoundItemView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardRecentActivity.this, resultRecord, forwardRecentRoundItemView);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardRecentActivity.this.openForwardDialog(this.f175852a, this.f175853b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ForwardRecentActivity.this.openForwardDialog(this.f175852a, this.f175853b);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else if (ForwardRecentActivity.this.mDataSetObserver != null) {
                ForwardRecentActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class m implements n.c {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.adapter.n.c
        public boolean a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ForwardRecentActivity.this.isForwardTargetSelected(str, i3);
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).booleanValue();
        }

        @Override // com.tencent.mobileqq.adapter.n.c
        public void b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                boolean isMultiSelectStatus = ForwardRecentActivity.this.isMultiSelectStatus();
                if (QLog.isColorLevel()) {
                    QLog.d(ForwardRecentActivity.TAG, 2, "onItemViewClicked" + isMultiSelectStatus);
                }
                if (isMultiSelectStatus) {
                    if (view instanceof ForwardRecentItemView) {
                        ForwardRecentActivity.this.onListViewItemClickedInMultiSelectStatus(view);
                    } else if (view instanceof ForwardRecentRoundItemView) {
                        ForwardRecentActivity.this.onGridViewItemClickedInMultiSelectStatus(view);
                    }
                } else {
                    ForwardRecentActivity.this.onListViewItemClickedInDefaultStatus(view);
                }
                ForwardRecentActivity.this.setReportParam(view);
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements b.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultRecord f175856a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ForwardRecentItemView f175857b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f175858c;

        n(ResultRecord resultRecord, ForwardRecentItemView forwardRecentItemView, boolean z16) {
            this.f175856a = resultRecord;
            this.f175857b = forwardRecentItemView;
            this.f175858c = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardRecentActivity.this, resultRecord, forwardRecentItemView, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardRecentActivity.this.setListItemSelected(this.f175856a, this.f175857b, this.f175858c);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ForwardRecentActivity.this.setListItemSelected(this.f175856a, this.f175857b, this.f175858c);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements b.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultRecord f175860a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ForwardRecentRoundItemView f175861b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f175862c;

        o(ResultRecord resultRecord, ForwardRecentRoundItemView forwardRecentRoundItemView, boolean z16) {
            this.f175860a = resultRecord;
            this.f175861b = forwardRecentRoundItemView;
            this.f175862c = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardRecentActivity.this, resultRecord, forwardRecentRoundItemView, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardRecentActivity.this.setGridItemSelected(this.f175860a, this.f175861b, this.f175862c);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ForwardRecentActivity.this.setGridItemSelected(this.f175860a, this.f175861b, this.f175862c);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileassistant.util.b.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class p implements SelectedAndSearchBar.i {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void a(ResultRecord resultRecord) {
            ForwardRecentItemView forwardRecentItemView;
            ResultRecord resultRecord2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resultRecord);
                return;
            }
            if (resultRecord != null) {
                ForwardRecentActivity.this.removeFromForwardTargetList(resultRecord.uin, resultRecord.getUinType());
                int childCount = ForwardRecentActivity.this.mListView.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = ForwardRecentActivity.this.mListView.getChildAt(i3);
                    if ((childAt instanceof ForwardRecentItemView) && (resultRecord2 = (forwardRecentItemView = (ForwardRecentItemView) childAt).J) != null && resultRecord2.uinType == resultRecord.uinType && resultRecord2.uin.equals(resultRecord.uin)) {
                        forwardRecentItemView.e(false);
                    }
                }
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100230", false)) {
                    ForwardRecentActivity.this.onRecentForwardItemDelete(resultRecord);
                }
                ForwardRecentActivity.this.onHeaderItemDelete(resultRecord);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj)) {
                if (ForwardRecentActivity.this.mSearchResultLayout.getVisibility() == 0 && ForwardRecentActivity.this.mSearchFragment != null) {
                    ForwardRecentActivity.this.mSearchFragment.y8();
                }
                ForwardRecentActivity.this.mSearchResultLayout.setVisibility(8);
                if (!ForwardRecentActivity.this.isMultiSelectStatus()) {
                    ForwardRecentActivity.this.quiSecNavBar.setRightType(1);
                    ForwardRecentActivity.this.mIsSingleStatusInSearch = false;
                    ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                    if (!forwardRecentActivity.mOnlySingleSelection) {
                        forwardRecentActivity.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.mpt));
                    } else {
                        forwardRecentActivity.quiSecNavBar.setLeftType(0);
                        ForwardRecentActivity.this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.mpt));
                    }
                }
            } else {
                if (ForwardRecentActivity.this.mSearchResultLayout.getVisibility() == 8) {
                    ForwardRecentActivity.this.notifySearchFragmentShow();
                }
                ForwardRecentActivity.this.mSearchResultLayout.setVisibility(0);
                if (!ForwardRecentActivity.this.isMultiSelectStatus()) {
                    ForwardRecentActivity.this.quiSecNavBar.setRightType(0);
                    ForwardRecentActivity.this.mIsSingleStatusInSearch = true;
                    if (ForwardRecentActivity.this.mStyle == 0) {
                        ForwardRecentActivity.this.quiSecNavBar.setLeftType(1);
                        ForwardRecentActivity.this.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.f171898lr0));
                    } else {
                        ForwardRecentActivity.this.quiSecNavBar.setLeftType(1);
                        ForwardRecentActivity.this.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.cancel));
                    }
                }
            }
            if (ForwardRecentActivity.this.mSearchFragment != null) {
                ForwardRecentActivity.this.mSearchFragment.startSearch(obj);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void b(boolean z16) {
            boolean z17;
            boolean z18;
            ArrayList<String> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (z16 && ForwardRecentActivity.this.mSearchFragment == null) {
                int searchSource = ForwardRecentActivity.this.getSearchSource();
                if (ForwardRecentActivity.this.mIsFromZplan) {
                    List singletonList = Collections.singletonList(ForwardRecentActivity.this.app.getCurrentAccountUin());
                    ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                    forwardRecentActivity.mSearchFragment = ZPlanSearchFragment.Eh(7, searchSource, null, singletonList, forwardRecentActivity.mOnActionListener, 0, 1L, ForwardRecentActivity.this.appid);
                } else if (ForwardRecentActivity.this.mIsFriendPermission) {
                    ForwardBaseOption forwardBaseOption = ForwardRecentActivity.this.mForwardOption;
                    if (forwardBaseOption instanceof ForwardFriendPermissionOption) {
                        arrayList = ((ForwardFriendPermissionOption) forwardBaseOption).l();
                    } else {
                        arrayList = new ArrayList<>();
                    }
                    ArrayList<String> arrayList2 = arrayList;
                    ForwardRecentActivity forwardRecentActivity2 = ForwardRecentActivity.this;
                    forwardRecentActivity2.mSearchFragment = FriendPermissionSearchFragment.Fh(6, searchSource, null, null, forwardRecentActivity2.mOnActionListener, 0, 1L, 1, arrayList2);
                } else {
                    ForwardRecentActivity forwardRecentActivity3 = ForwardRecentActivity.this;
                    ForwardBaseOption forwardBaseOption2 = forwardRecentActivity3.mForwardOption;
                    if (forwardBaseOption2 instanceof ForwardH5RabbitSpringEmoteOption) {
                        forwardRecentActivity3.mSearchFragment = RabbitYearEmoteSearchFragment.Dh(7, searchSource, null, null, forwardRecentActivity3.mOnActionListener);
                    } else if (forwardBaseOption2 instanceof ForwardFileOption) {
                        if (forwardRecentActivity3.enableSearchDefaultSingleMode().booleanValue()) {
                            ForwardRecentActivity.this.initSearchOperationIoc();
                        }
                        ForwardRecentActivity forwardRecentActivity4 = ForwardRecentActivity.this;
                        forwardRecentActivity4.mSearchFragment = ContactsSearchNTFragment.INSTANCE.a(7, searchSource, null, null, forwardRecentActivity4.mOnActionListener, 0, 1L, false, ForwardRecentActivity.this.enableSearchDefaultSingleMode().booleanValue(), ForwardRecentActivity.this.contactSelectOperationIoc);
                    } else {
                        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("revert_fs_filter_temp_chat", false);
                        if (QLog.isColorLevel()) {
                            QLog.d(ForwardRecentActivity.TAG, 2, "disableFilterTempChat" + isSwitchOn);
                        }
                        if (ForwardRecentActivity.this.mCurrentStatus == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (ForwardRecentActivity.this.enableSearchDefaultSingleMode().booleanValue()) {
                            ForwardRecentActivity.this.initSearchOperationIoc();
                            z18 = false;
                        } else {
                            z18 = z17;
                        }
                        if (!isSwitchOn && !ForwardRecentActivity.this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.V3)) {
                            ForwardRecentActivity forwardRecentActivity5 = ForwardRecentActivity.this;
                            forwardRecentActivity5.mSearchFragment = ContactsSearchNTFragment.INSTANCE.a(7, searchSource, null, null, forwardRecentActivity5.mOnActionListener, 0, 1L, z18, ForwardRecentActivity.this.enableSearchDefaultSingleMode().booleanValue(), ForwardRecentActivity.this.contactSelectOperationIoc);
                        } else {
                            ForwardRecentActivity forwardRecentActivity6 = ForwardRecentActivity.this;
                            forwardRecentActivity6.mSearchFragment = ContactsSearchNTFragment.INSTANCE.a(7, searchSource, null, null, forwardRecentActivity6.mOnActionListener, 0, -1L, z18, ForwardRecentActivity.this.enableSearchDefaultSingleMode().booleanValue(), ForwardRecentActivity.this.contactSelectOperationIoc);
                        }
                    }
                }
                Bundle arguments = ForwardRecentActivity.this.mSearchFragment.getFragment().getArguments();
                if (arguments != null && BlockTroopForwardConfig.a()) {
                    arguments.putBoolean(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_FILTER_BLOCK_GROUP, true);
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it = ForwardRecentActivity.this.mForwardTargetMap.values().iterator();
                while (it.hasNext()) {
                    arrayList3.add(((ResultRecord) it.next()).uin);
                }
                if (ForwardRecentActivity.this.mSearchFragment.K9()) {
                    ForwardRecentActivity.this.mSearchFragment.B5(arrayList3, null);
                } else {
                    ForwardRecentActivity.this.mSearchFragment.B5(arrayList3, arrayList3);
                }
                FragmentTransaction beginTransaction = ForwardRecentActivity.this.getSupportFragmentManager().beginTransaction();
                beginTransaction.add(R.id.result_layout, ForwardRecentActivity.this.mSearchFragment.getFragment());
                beginTransaction.commitAllowingStateLoss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class q implements com.tencent.mobileqq.search.view.d {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.search.view.d
        public void onAction(View view) {
            String str;
            int M;
            HorizontalListView horizontalListView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) view.getTag(R.id.kxb);
            if (kVar == null) {
                return;
            }
            if (kVar instanceof wn2.d) {
                ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).onGameFriendItemSelected(ForwardRecentActivity.this, ((wn2.d) kVar).S());
                return;
            }
            String uin = kVar.getUin();
            String charSequence = kVar.getTitle().toString();
            int i3 = 3000;
            if (kVar instanceof wn2.b) {
                str = ((wn2.b) kVar).d();
            } else if (kVar instanceof wn2.a) {
                str = kVar.getUin();
            } else {
                i3 = 1;
                if (kVar instanceof wn2.i) {
                    str = ((wn2.i) kVar).X;
                } else if (kVar instanceof wn2.q) {
                    str = ((wn2.q) kVar).a().troopuin;
                } else {
                    String str2 = "-1";
                    if (kVar instanceof wn2.c) {
                        str = "-1";
                        i3 = 0;
                    } else {
                        if ((kVar instanceof wn2.n) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100388", false)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(ForwardRecentActivity.TAG, 2, "isSetTypeToggle " + ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100388", false));
                            }
                            M = 1004;
                        } else if (kVar instanceof ContactSearchModelNtBuddy) {
                            String fromGroupCode = ((ContactSearchModelNtBuddy) kVar).getFromGroupCode();
                            if (!TextUtils.isEmpty(fromGroupCode)) {
                                str2 = fromGroupCode;
                            }
                            M = kVar.M();
                        } else if (!(kVar instanceof ContactSearchModelNtTroop)) {
                            str = "-1";
                            i3 = -1;
                        } else {
                            String uin2 = kVar.getUin();
                            i3 = kVar.M();
                            str = uin2;
                        }
                        String str3 = str2;
                        i3 = M;
                        str = str3;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(ForwardRecentActivity.TAG, 2, "onAction, uin = " + uin + ", troopUin = " + str + ", type = " + i3);
            }
            if (ForwardRecentActivity.this.isMultiSelectStatus()) {
                if (i3 != -1 && ForwardRecentActivity.this.add2ForwardTargetList(new ResultRecord(uin, charSequence, i3, str, ""))) {
                    if (ForwardRecentActivity.this.recentAdapter != null) {
                        ForwardRecentActivity.this.recentAdapter.notifyDataSetChanged();
                    }
                    if (com.tencent.relation.common.config.toggle.c.W.g(false) && (horizontalListView = ForwardRecentActivity.this.horizontalListView) != null && horizontalListView.getAdapter() != null && (ForwardRecentActivity.this.horizontalListView.getAdapter() instanceof ForwardSelectionRecentFriendGridAdapter)) {
                        ((ForwardSelectionRecentFriendGridAdapter) ForwardRecentActivity.this.horizontalListView.getAdapter()).notifyDataSetChanged();
                    }
                }
            } else {
                if (TextUtils.isEmpty(uin)) {
                    return;
                }
                if (AppConstants.DATALINE_PC_UIN.equals(uin) || AppConstants.DATALINE_PHONE_UIN.equals(uin) || AppConstants.DATALINE_IPAD_UIN.equals(uin)) {
                    ForwardRecentActivity.this.openDataLineForwardDialog(uin, i3);
                    return;
                }
                ForwardRecentItemView forwardRecentItemView = new ForwardRecentItemView(ForwardRecentActivity.this);
                forwardRecentItemView.G = charSequence;
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.uinType = i3;
                resultRecord.uin = uin;
                resultRecord.groupUin = str;
                resultRecord.guildId = "";
                ForwardRecentActivity.this.openForwardDialog(resultRecord, forwardRecentItemView);
            }
            if (ForwardRecentActivity.this.mSearchFragment != null && !ForwardRecentActivity.this.mSearchFragment.K9()) {
                ForwardRecentActivity.this.quitSearchState();
                return;
            }
            SelectedAndSearchBar selectedAndSearchBar = ForwardRecentActivity.this.mSelectedAndSearchBar;
            if (selectedAndSearchBar != null) {
                selectedAndSearchBar.w();
            }
        }

        @Override // com.tencent.mobileqq.search.view.d
        public void selectedItemClick(String str, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            if (ForwardRecentActivity.this.isMultiSelectStatus() && z16) {
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.init(str, "", i3, str, "");
                ForwardRecentActivity.this.removeFromForwardTargetList(str, i3);
                ForwardRecentActivity.this.syncRecentChatClicked(resultRecord, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class r implements com.tencent.mobileqq.search.k {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.search.k
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            QLog.i(ForwardRecentActivity.TAG, 1, "setSearchFragmentVisibility " + z16);
            if (!z16) {
                ForwardRecentActivity.this.quitSearchState();
                ForwardRecentActivity.this.mIsSingleStatusInSearch = false;
            } else if (ForwardRecentActivity.this.mSearchResultLayout.getVisibility() == 8) {
                ForwardRecentActivity.this.mSearchResultLayout.setVisibility(0);
                if (ForwardRecentActivity.this.mSearchFragment != null) {
                    ForwardRecentActivity.this.mSearchFragment.tb();
                }
            }
        }

        @Override // com.tencent.mobileqq.search.k
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (ForwardRecentActivity.this.isMultiSelectStatus() == z16) {
                return;
            }
            if (z16) {
                ForwardRecentActivity.this.switch2MultiSelectStatus();
                ForwardRecentActivity.this.quiSecNavBar.setRightType(1);
            } else {
                ForwardRecentActivity.this.switch2DefaultStatus(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class s implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                if (forwardRecentActivity.isMultiSelectStatus()) {
                    str = "0X800C01B";
                } else {
                    str = "0X800C012";
                }
                forwardRecentActivity.report(str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class t implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TipsBar tipsBar = ForwardRecentActivity.this.directShareTips;
                if (tipsBar != null && tipsBar.getVisibility() == 0) {
                    ForwardRecentActivity.this.directShareTips.setVisibility(8);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class u implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intent intent = ForwardRecentActivity.this.getIntent();
                String stringExtra = intent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_BUSINESS_ID);
                if (!ForwardRecentActivity.this.mForwardOption.handleQZoneClick()) {
                    if (!TextUtils.isEmpty(stringExtra)) {
                        boolean hasExtra = intent.hasExtra("file_send_path");
                        ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                        cb.a(forwardRecentActivity.app, forwardRecentActivity, intent, stringExtra, hasExtra);
                    } else {
                        int intExtra = intent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, 0);
                        if (QLog.isColorLevel()) {
                            QLog.d(ForwardRecentActivity.TAG, 2, "-->addQZoneEntry--onClick--req_type = " + intExtra);
                        }
                        Bundle extras = intent.getExtras();
                        String string = extras.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
                        if (string == null) {
                            string = extras.getString("image_url");
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (!TextUtils.isEmpty(string)) {
                            for (String str : string.split(";")) {
                                arrayList.add(URLDecoder.decode(str));
                            }
                        }
                        extras.putStringArrayList("image_url", arrayList);
                        extras.putString(QZoneShareManager.QZONE_SHARE_ACTION, "shareToQQ");
                        extras.putString(AppConstants.Key.SHARE_REQ_SHARE_JFROM, "login");
                        extras.putBoolean(AppConstants.Key.SHARE_REQ_THIRDPART, true);
                        com.tencent.mobileqq.phonecontact.constant.b.f258441a = true;
                        ForwardRecentActivity forwardRecentActivity2 = ForwardRecentActivity.this;
                        QZoneShareManager.jumpToQzoneShare(forwardRecentActivity2.app, forwardRecentActivity2, extras, null);
                        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
                        reportInfo.actionType = "1";
                        reportInfo.subactionType = "0";
                        reportInfo.tabletype = 4;
                        reportInfo.sourceType = "5";
                        reportInfo.sourceFrom = QZoneClickReport.ClickReportConfig.SOURCE_FROM_THIRDAPP;
                        reportInfo.sourceTo = QZoneClickReport.ClickReportConfig.SOURCE_TO_FRIENDFEED;
                        QZoneClickReport.startReportImediately(ForwardRecentActivity.this.app.getAccount(), reportInfo);
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "5");
                        hashMap.put("source_from", QZoneClickReport.ClickReportConfig.SOURCE_FROM_THIRDAPP);
                        hashMap.put("source_to", QZoneClickReport.ClickReportConfig.SOURCE_TO_FRIENDFEED);
                        StatisticCollector.getInstance(ForwardRecentActivity.this.getApplicationContext()).collectPerformance(ForwardRecentActivity.this.app.getAccount(), StatisticCollector.QZONE_SOURCE_DATA_REPORT, true, 0L, 0L, hashMap, null);
                        if (ForwardRecentActivity.this.isSdkShare) {
                            ReportCenter f16 = ReportCenter.f();
                            String account = ForwardRecentActivity.this.app.getAccount();
                            ForwardRecentActivity forwardRecentActivity3 = ForwardRecentActivity.this;
                            f16.q(account, "", forwardRecentActivity3.appid, "1000", WadlProxyConsts.OPER_TYPE_APK_SIGN, "0", false, forwardRecentActivity3.isSdkShare);
                            ForwardBaseOption forwardBaseOption = ForwardRecentActivity.this.mForwardOption;
                            if (forwardBaseOption instanceof ForwardSdkBaseOption) {
                                Bundle bundle = new Bundle();
                                bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "102");
                                bundle.putString("act_type", "81");
                                bundle.putString("intext_1", "" + com.tencent.open.agent.report.e.b(((ForwardSdkBaseOption) forwardBaseOption).K));
                                bundle.putString("intext_2", "" + com.tencent.open.agent.report.e.c(-1, AppConstants.QZONE_UIN));
                                bundle.putString("intext_3", "0");
                                ReportCenter.f().m(bundle, "", ForwardRecentActivity.this.app.getCurrentAccountUin(), false, ForwardRecentActivity.this.isSdkShare);
                            }
                        }
                        ForwardRecentActivity forwardRecentActivity4 = ForwardRecentActivity.this;
                        if (forwardRecentActivity4.isSdkShare && intExtra == 5) {
                            forwardRecentActivity4.initBroadcastReceiver();
                        } else {
                            forwardRecentActivity4.finish();
                        }
                    }
                    ForwardRecentActivity.this.mForwardOption.getExtras().putString("uin", "-1010");
                    ForwardRecentActivity.this.mForwardOption.reportFinalSelectedTargets();
                    ForwardRecentActivity forwardRecentActivity5 = ForwardRecentActivity.this;
                    ReportController.o(forwardRecentActivity5.app, "CliOper", "", "", "friendchoose", "0X800A2D7", forwardRecentActivity5.getReportFromType(), 0, "", "", "", ForwardRecentActivity.this.getBusinessId());
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("key_receiver_type", 3L);
                    if ("caller_aecamera".equals(ForwardRecentActivity.this.mCallActivity)) {
                        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", bundle2, null);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class v implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (!TextUtils.isEmpty(ForwardRecentActivity.this.getIntent().getStringExtra(AppConstants.Key.KEY_GC_GAME_APPID))) {
                IGameCenterFriendApi iGameCenterFriendApi = (IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class);
                ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                iGameCenterFriendApi.openGameFriendChoosePage(forwardRecentActivity, forwardRecentActivity.getIntent().getExtras(), 20000);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class w implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (QLog.isColorLevel()) {
                QLog.d(ForwardRecentActivity.TAG, 2, "-->addBlankHeaderDivider--onClick--");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class x extends DataSetObserver {
        static IPatchRedirector $redirector_;

        x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            boolean z16;
            n.b bVar;
            RecentUser recentUser;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onChanged();
            if (QLog.isColorLevel()) {
                QLog.d(ForwardRecentActivity.TAG, 2, "onChanged() called " + System.identityHashCode(ForwardRecentActivity.this));
            }
            ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
            int i3 = forwardRecentActivity.mReq;
            if (i3 == 2) {
                ForwardRecentActivity.this.getIntent().putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, forwardRecentActivity.getRecentForwardAndChat());
                ForwardRecentActivity.this.setResult(-1);
                ForwardRecentActivity.this.finish();
                return;
            }
            if (i3 == 1) {
                ListAdapter adapter = forwardRecentActivity.mListView.getAdapter();
                int count = adapter.getCount();
                String stringExtra = ForwardRecentActivity.this.getIntent().getStringExtra("key_direct_show_uin");
                int intExtra = ForwardRecentActivity.this.getIntent().getIntExtra("key_direct_show_uin_type", 0);
                if (6000 == intExtra && TextUtils.equals(AppConstants.DATALINE_PC_UIN, stringExtra) && ForwardRecentActivity.this.mForwardPcItemView != null) {
                    ForwardRecentActivity.this.mForwardPcItemView.callOnClick();
                    return;
                }
                if (10027 == intExtra) {
                    if (!ForwardRecentActivity.this.forwardToGuildFeeds(stringExtra)) {
                        ForwardRecentActivity.this.setResult(0);
                        ForwardRecentActivity.this.finish();
                        return;
                    }
                    return;
                }
                if (1046 == intExtra) {
                    ForwardRecentActivity.this.forwardToMatchFriendUser(stringExtra);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(ForwardRecentActivity.TAG, 2, "[FORWARD_SHOW_DIALOG]start find clickview in adapter, count=" + count + ", uin=" + com.tencent.mobileqq.qcall.g.b(stringExtra));
                }
                int i16 = 0;
                while (true) {
                    if (i16 < count) {
                        Object item = adapter.getItem(i16);
                        if ((item instanceof n.b) && (recentUser = (bVar = (n.b) item).f187222d) != null && TextUtils.equals(recentUser.uin, stringExtra) && intExtra == bVar.f187222d.getType()) {
                            View view = adapter.getView(i16, null, ForwardRecentActivity.this.mListView);
                            if (QLog.isColorLevel()) {
                                QLog.i(ForwardRecentActivity.TAG, 2, "[FORWARD_SHOW_DIALOG]invoke onListViewItemClickedInDefaultStatus, uin=" + com.tencent.mobileqq.qcall.g.b(stringExtra));
                            }
                            ForwardRecentActivity.this.onListViewItemClickedInDefaultStatus(view);
                            z16 = true;
                        } else {
                            i16++;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100468", false);
                QLog.i(ForwardRecentActivity.TAG, 2, String.format("isExecute:%b isFinishingSwitch:%b", Boolean.valueOf(z16), Boolean.valueOf(isSwitchOn)));
                if (!z16 && isSwitchOn) {
                    ToastUtil.a().b(R.string.f1787837l);
                    ForwardRecentActivity.this.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class y implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardRecentActivity.this.onLeftClick();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class z implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardRecentActivity.this.onLeftClick();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            sMigrateCache = new ConcurrentHashMap();
            k16dp = ViewUtils.dpToPx(16.0f);
        }
    }

    public ForwardRecentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isSdkShare = false;
        this.appid = "";
        this.recentForwardList = new ArrayList();
        this.isForConfessDirectFriends = false;
        this.mForwardOption = null;
        this.isShowInSare = false;
        this.mIsToPayList = false;
        this.mBusinessType = 0;
        this.mBusinessSubType = 0;
        this.mIsForConfess = false;
        this.mIsFromShare = false;
        this.mIsFromDatalineAIO = false;
        this.mIsFromAIO = false;
        this.mIsFromWeb = false;
        this.mIsFromMini = false;
        this.mOnlySingleSelection = false;
        this.mNeedShareCallback = false;
        this.miniAppShareFrom = -1;
        this.mJumpQzoneShuoshuoDirect = false;
        this.mNeedShowDirectShareTips = false;
        this.mReq = -1;
        this.mStyle = 0;
        this.mIsSingleStatusInSearch = false;
        this.mIsFromZplan = false;
        this.mIsFriendPermission = false;
        this.mIsMatchFriendUserList = false;
        this.mIsFinishWhenMultiSelect = false;
        this.mIsRegister = false;
        this.isEnableArgus = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("Argus_Forward", false);
        this.isDelegateResourceEnabled = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("Argus_Forward_Resource", false);
        this.enableHeaderViewStatusFix = true ^ ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("revert_header_view_status_fix", false);
        this.unclickableSelectedUins = new ArrayList();
        this.enableSearchDefaultSingleModeByConfig = SearchQQMC.INSTANCE.getDefaultSingleModeConfig().getEnable();
        this.onClick = new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.14
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    int id5 = view.getId();
                    if (!hf0.a.a(ForwardRecentActivity.TAG)) {
                        if (id5 == R.id.ivTitleBtnRightText) {
                            ForwardRecentActivity.this.onRightClick();
                        } else if (id5 == R.id.ivTitleBtnLeftButton) {
                            ForwardRecentActivity.this.onLeftClick();
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("call_by_forward", true);
                            Uri uri = ForwardRecentActivity.this.dataUri;
                            if (uri != null) {
                                intent.setData(uri);
                            }
                            Bundle extras = ForwardRecentActivity.this.mForwardOption.getExtras();
                            if (extras.getBoolean("sendMultiple", false)) {
                                intent.putStringArrayListExtra("foward_key_m_p_l", extras.getStringArrayList("foward_key_m_p_l"));
                            } else {
                                intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, extras.getString(AppConstants.Key.FORWARD_FILEPATH));
                            }
                            intent.putExtras(ForwardRecentActivity.this.mForwardOption.getExtras());
                            if (ForwardRecentActivity.this.getIntent().getBooleanExtra("isFromShare", false)) {
                                intent.putExtras(ForwardRecentActivity.this.mForwardOption.getExtras());
                                intent.setAction(ForwardRecentActivity.this.getIntent().getAction());
                            } else {
                                intent.putExtras(ForwardRecentActivity.this.getIntent().getExtras());
                            }
                            int id6 = view.getId();
                            if (id6 == R.id.cjh) {
                                PermissionChecker.e(ForwardRecentActivity.this, new Runnable(intent) { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.14.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ Intent f175827d;

                                    {
                                        this.f175827d = intent;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass14.this, (Object) intent);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                            ForwardRecentActivity.this.bindFinishReceiver(this.f175827d);
                                            this.f175827d.setClass(ForwardRecentActivity.this, PhoneFrameActivity.class);
                                            this.f175827d.putExtra("key_req_type", 2);
                                            Intent intent2 = ForwardRecentActivity.this.getIntent();
                                            if (intent2 != null && intent2.hasExtra("forward_type")) {
                                                this.f175827d.putExtra("forward_type", intent2.getIntExtra("forward_type", Integer.MAX_VALUE));
                                            }
                                            ForwardRecentActivity.this.startActivityForResult(this.f175827d, 20000);
                                            ReportController.o(ForwardRecentActivity.this.app, "CliOper", "", "", "0X8007011", "0X8007011", 0, 0, "", "", "", "");
                                            if (!ForwardRecentActivity.this.queryHasMigrate(ForwardRecentActivity.FORWARD_SHARE_CARD)) {
                                                QMMKV.migrateToSpAdapter(BaseApplication.getContext(), ForwardRecentActivity.FORWARD_SHARE_CARD, "common_mmkv_configurations");
                                                ForwardRecentActivity.this.setHasMigrate(ForwardRecentActivity.FORWARD_SHARE_CARD);
                                            }
                                            QMMKV.fromSpAdapter(BaseApplication.getContext(), ForwardRecentActivity.FORWARD_SHARE_CARD, "common_mmkv_configurations").edit().putBoolean(ForwardRecentActivity.FORWARD_SHARE_CARD, false).apply();
                                            ForwardRecentActivity.this.mEntryHeader.findViewById(R.id.dqk).setVisibility(8);
                                            return;
                                        }
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }, new DenyRunnable(ForwardRecentActivity.this, 6));
                                ForwardRecentActivity forwardRecentActivity = ForwardRecentActivity.this;
                                ReportController.o(forwardRecentActivity.app, "dc00899", AegisLogger.SHARE, "", "select_friend", "clk_addressbook", 0, 0, forwardRecentActivity.mIsFromShare ? "2" : "1", "", "", "");
                            } else if (id6 == R.id.cje) {
                                ForwardRecentActivity.this.reportDataForBusiness("0X8007824");
                                ForwardRecentActivity.this.bindFinishReceiver(intent);
                                ReportController.o(ForwardRecentActivity.this.app, "CliOper", "", "", "0X800665F", "0X800665F", 0, 0, "", "", "", "");
                                intent.setClass(ForwardRecentActivity.this, ForwardFriendListActivity.class);
                                intent.putExtra("extra_choose_friend", 5);
                                intent.putExtra("only_single_selection", ForwardRecentActivity.this.mOnlySingleSelection);
                                intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(ForwardRecentActivity.this.mForwardTargetMap.values()));
                                intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN, ForwardRecentActivity.this.mIsFromZplan);
                                intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID, ForwardRecentActivity.this.appid);
                                ForwardRecentActivity.this.startActivityForResult(intent, 20000);
                                ReportController.o(ForwardRecentActivity.this.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
                                ForwardRecentActivity forwardRecentActivity2 = ForwardRecentActivity.this;
                                ReportController.o(forwardRecentActivity2.app, "CliOper", "", "", "friendchoose", "0X8009D95", forwardRecentActivity2.getReportFromType(), 0, "", "", "", "");
                                ForwardRecentActivity forwardRecentActivity3 = ForwardRecentActivity.this;
                                if (forwardRecentActivity3.mIsToPayList) {
                                    int i3 = forwardRecentActivity3.mBusinessType;
                                    if (i3 == 1 && forwardRecentActivity3.mBusinessSubType == 1) {
                                        ReportController.o(forwardRecentActivity3.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.buyerselectpage.select", 0, 0, "", "", "", "");
                                    } else if (i3 == 1 && forwardRecentActivity3.mBusinessSubType == 2) {
                                        ReportController.o(forwardRecentActivity3.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.payerselectpage.select", 0, 0, "", "", "", "");
                                    }
                                }
                            } else if (id6 == R.id.cjg) {
                                ForwardRecentActivity.this.onClickFromCreateNewChat();
                            } else if (id6 == R.id.cjk) {
                                ForwardRecentActivity.this.bindFinishReceiver(intent);
                                ForwardRecentActivity forwardRecentActivity4 = ForwardRecentActivity.this;
                                if (forwardRecentActivity4.mOnlySingleSelection) {
                                    forwardRecentActivity4.reportDataForBusiness("0X8007825");
                                    ForwardRecentActivity forwardRecentActivity5 = ForwardRecentActivity.this;
                                    ReportController.o(forwardRecentActivity5.app, "dc00899", AegisLogger.SHARE, "", "select_friend", "clk_group", 0, 0, forwardRecentActivity5.mIsFromShare ? "2" : "1", "", "", "");
                                    new com.tencent.mobileqq.statistics.q(ForwardRecentActivity.this.app).i("dc00899").a("Grp_listNew").f("send_to").d("clk_grpList").g();
                                    if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106129", true)) {
                                        QLog.i(ForwardRecentActivity.TAG, 1, "open newTroopSelector");
                                        ((ITroopSelectorApi) QRoute.api(ITroopSelectorApi.class)).openNewTroopSelector(ForwardRecentActivity.this, intent, new TroopSelectorConfig(false, 0, true, true, true, new ArrayList(), 6), 20000);
                                    } else {
                                        intent.setClass(ForwardRecentActivity.this, TroopActivity.class);
                                        if (!ForwardRecentActivity.this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.Q3)) {
                                            intent.putExtra("onlyOneSegement", true);
                                            intent.putExtra("_key_mode", 0);
                                        } else if (!ForwardRecentActivity.this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.P3)) {
                                            intent.putExtra("onlyOneSegement", true);
                                            intent.putExtra("_key_mode", 1);
                                        }
                                        intent.putExtra("only_single_selection", ForwardRecentActivity.this.mOnlySingleSelection);
                                        ForwardRecentActivity.this.startActivityForResult(intent, 20000);
                                    }
                                } else {
                                    intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(ForwardRecentActivity.this.mForwardTargetMap.values()));
                                    intent.putExtra("public_fragment_window_feature", 1);
                                    PublicFragmentActivity.b.d(ForwardRecentActivity.this, intent, PublicTransFragmentActivity.class, ForwardTroopListFragment.class, 20000);
                                    ForwardRecentActivity.this.report("0X800C01C");
                                }
                            } else if (id6 == R.id.kbr) {
                                if (ForwardRecentActivity.this.isMultiSelectStatus()) {
                                    ForwardRecentActivity.this.report("0X800C019");
                                    ForwardRecentActivity.this.bindFinishReceiver(intent);
                                    intent.setClass(ForwardRecentActivity.this, ForwardFriendListActivity.class);
                                    intent.putExtra("extra_choose_friend", 8);
                                    intent.putExtra("only_single_selection", ForwardRecentActivity.this.mOnlySingleSelection);
                                    intent.putExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, ForwardRecentActivity.this.uinType);
                                    intent.putExtra("key_forward_is_show_troop", true);
                                    intent.putExtra("key_forward_is_show_guild", false);
                                    intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(ForwardRecentActivity.this.mForwardTargetMap.values()));
                                    extras.putInt("via", 3);
                                    intent.putExtra(ForwardRecentActivity.KEY_SEARCH_SOURCE, ForwardRecentActivity.this.getSearchSource());
                                    intent.putExtra("key_is_search_default_single_mode", ForwardRecentActivity.this.enableSearchDefaultSingleMode());
                                    ForwardRecentActivity.this.startActivityForResult(intent, 20000);
                                    ForwardRecentActivity.this.report("0X800C01A");
                                } else {
                                    ForwardRecentActivity.this.report("0X800C017");
                                    ForwardRecentActivity.this.onClickFromCreateNewChat();
                                }
                            }
                        }
                    }
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.friendListObserver = new e();
        this.troopMngObserver = new f();
        this.troopObserver = new g();
        this.mInitObserver = new h();
        this.mAvatarZPlanObserver = new com.tencent.mobileqq.zplan.servlet.b() { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.20
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
                }
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i3 == 3) {
                    ForwardRecentActivity.this.mForwardOption.hideProgressDialog();
                    if (z16 && obj != null) {
                        try {
                            List<String> list = (List) obj;
                            ForwardBaseOption forwardBaseOption = ForwardRecentActivity.this.mForwardOption;
                            if (forwardBaseOption instanceof ForwardZPlanShareOption) {
                                ((ForwardZPlanShareOption) forwardBaseOption).n(list);
                            }
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.20.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass20.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        ForwardRecentActivity.this.refreshRecentList();
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th5) {
                            QLog.e(ForwardRecentActivity.TAG, 1, "[onUpdate] NOTIFY_TYPE_GET_ZPLAN_FORWARD_FRIEND_LIST. exception = ", th5);
                            return;
                        }
                    }
                    QQToast.makeText(ForwardRecentActivity.this, HardCodeUtil.qqStr(R.string.u3h), 1000).show();
                    if (!ForwardRecentActivity.this.isFinishing()) {
                        ForwardRecentActivity.this.finish();
                        QLog.i(ForwardRecentActivity.TAG, 1, "ForwardRecentActivity has finished by mAvatarZPlanObserver.");
                    }
                }
            }
        };
        this.mFriendObserver = new j();
        this.mCurrentStatus = 0;
        this.mForwardTargetMap = new LinkedHashMap();
        this.mForwardRecentListAdapterCallback = new m();
        this.mSelectedAndSearchBarCallback = new p();
        this.mOnActionListener = new q();
        this.directShareTipsCloseListener = new t();
        this.qzoneEntryOnClickListener = new u();
        this.gameContactClickListener = new v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean add2ForwardTargetList(ResultRecord resultRecord) {
        if (resultRecord == null) {
            return false;
        }
        String forwardTargetKey = getForwardTargetKey(resultRecord.uin, resultRecord.getUinType());
        ResultRecord resultRecord2 = this.mForwardTargetMap.get(forwardTargetKey);
        if (resultRecord2 != null) {
            resultRecord2.lastChooseTime = SystemClock.elapsedRealtime();
            this.mSelectedAndSearchBar.H(new ArrayList(this.mForwardTargetMap.values()), false);
            return false;
        }
        if (this.mForwardTargetMap.size() == 9) {
            showForwardCountLimitDialog();
            return false;
        }
        ResultRecord copyResultRecord = ResultRecord.copyResultRecord(resultRecord);
        copyResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
        this.mForwardTargetMap.put(forwardTargetKey, copyResultRecord);
        refreshRightBtn();
        this.mSelectedAndSearchBar.H(new ArrayList(this.mForwardTargetMap.values()), true);
        ArrayList arrayList = new ArrayList();
        Iterator<ResultRecord> it = this.mForwardTargetMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().uin);
        }
        setSearchSelectedAndJoinedUins();
        return true;
    }

    private void addBlankHeaderDivider() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setEnabled(false);
        linearLayout.setClickable(false);
        linearLayout.setOnClickListener(new w());
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dpToPx(12.0f)));
        linearLayout.setBackgroundResource(R.drawable.qui_common_transparent_bg);
        if (com.tencent.mobileqq.util.ab.a() && AppSetting.f99565y) {
            AccessibilityUtil.n(linearLayout, false);
        }
        this.mListView.addHeaderView(linearLayout);
    }

    private void addDatalineEntry() {
        this.mForwardPcItemView = new ForwardRecentItemView(this);
        String str = AppConstants.DATALINE_PC_UIN;
        ResultRecord resultRecord = new ResultRecord(str, HardCodeUtil.qqStr(R.string.cf5), 6000, "", "");
        this.mForwardPcItemView.a(HardCodeUtil.qqStr(R.string.cf5), "", getResources().getDrawable(R.drawable.qfile_dataline_pc_recent), resultRecord, isMultiSelectStatus(), isForwardTargetSelected(str, 6000));
        this.mForwardPcItemView.setOnClickListener(new ab(resultRecord));
        updateItemViewStatus(this.mForwardPcItemView);
        this.mListView.addHeaderView(this.mForwardPcItemView);
        if (this.mForwardOption.isFromFav()) {
            return;
        }
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        if (registerProxySvcPackHandler.O2() != 0) {
            this.mForwardPhoneItemView = new ForwardRecentItemView(this);
            String str2 = AppConstants.DATALINE_PHONE_UIN;
            ResultRecord resultRecord2 = new ResultRecord(str2, "\u6211\u7684\u624b\u673a", 6005, "", "");
            this.mForwardPhoneItemView.a("\u6211\u7684\u624b\u673a", "", getResources().getDrawable(R.drawable.qfile_dataline_user_aio), resultRecord2, isMultiSelectStatus(), isForwardTargetSelected(str2, 6005));
            this.mForwardPhoneItemView.setOnClickListener(new ac(resultRecord2));
            updateItemViewStatus(this.mForwardPhoneItemView);
            this.mListView.addHeaderView(this.mForwardPhoneItemView);
        }
        if (registerProxySvcPackHandler.N2() != 0) {
            this.mForwardIpadItemView = new ForwardRecentItemView(this);
            String string = getResources().getString(R.string.f16272217);
            if (registerProxySvcPackHandler.U2()) {
                string = getResources().getString(R.string.c5g);
            }
            String str3 = AppConstants.DATALINE_IPAD_UIN;
            ResultRecord resultRecord3 = new ResultRecord(str3, string, 6003, "", "");
            this.mForwardIpadItemView.a(string, "", getResources().getDrawable(R.drawable.qfile_dataline_ipad_recent), resultRecord3, isMultiSelectStatus(), isForwardTargetSelected(str3, 6003));
            this.mForwardIpadItemView.setOnClickListener(new ad(resultRecord3));
            updateItemViewStatus(this.mForwardIpadItemView);
            this.mListView.addHeaderView(this.mForwardIpadItemView);
        }
    }

    private void addRecentForwardHeader() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.f167796ht, (ViewGroup) null);
        inflate.setFocusable(true);
        ((TextView) inflate.findViewById(R.id.k7c)).setText(R.string.f2205569f);
        this.mListView.addHeaderView(inflate);
        report("0X800C015");
    }

    private void addRecentForwardedGrid(int i3) {
        addRecentForwardHeader();
        if (this.horizontalListView == null) {
            this.horizontalListView = new HorizontalListView(this);
        }
        this.horizontalListView.setAdapter((ListAdapter) new ForwardSelectionRecentFriendGridAdapter(this, this.app, this.horizontalListView, this.recentForwardList.subList(0, i3), this.mForwardRecentListAdapterCallback));
        this.mListView.addHeaderView(this.horizontalListView);
    }

    private void addWechatEntry() {
        this.mForwardWechatItemView = new ForwardRecentItemView(this);
        this.mForwardWechatItemView.a("\u8f6c\u53d1\u5230\u5fae\u4fe1", "", getResources().getDrawable(R.drawable.oce), new ResultRecord("", "\u8f6c\u53d1\u5230\u5fae\u4fe1", 0, "", ""), false, false);
        this.mForwardWechatItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.bz
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForwardRecentActivity.this.lambda$addWechatEntry$1(view);
            }
        });
        this.mListView.addHeaderView(this.mForwardWechatItemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustEntryLayout() {
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        Integer num = com.tencent.mobileqq.forward.e.O3;
        if (!forwardBaseOption.isSupportAbility(num) && !this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.P3) && !this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.Q3)) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "-->adjustEntryLayout--don't support friends, troop and discuss forward, remove mEntryHeader");
            }
            ForwardBaseOption forwardBaseOption2 = this.mForwardOption;
            if (!(forwardBaseOption2 instanceof ForwardChooseFriendOption) || forwardBaseOption2.isSupportAbility(com.tencent.mobileqq.forward.e.Y3)) {
                this.mListView.removeHeaderView(this.mEntryHeader);
                return;
            }
        }
        if (!this.mForwardOption.isSupportAbility(num)) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "-->adjustEntryLayout--don't support friends forward, set friendBtn gone");
            }
            this.friendLayout.setVisibility(8);
        }
        if (!this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.U3)) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "-->adjustEntryLayout--don't support phone contacts forward, set contactBtn gone");
            }
            this.contactLayout.setVisibility(8);
            this.mEntryHeader.findViewById(R.id.dqk).setVisibility(8);
        }
        ForwardBaseOption forwardBaseOption3 = this.mForwardOption;
        Integer num2 = com.tencent.mobileqq.forward.e.P3;
        if (!forwardBaseOption3.isSupportAbility(num2) || this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.Y3)) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "-->adjustEntryLayout--don't support discuss forward, set multiChatBtn gone");
            }
            this.multiChatLayout.setVisibility(8);
        }
        if (!this.mForwardOption.isSupportAbility(num2) && !this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.Q3)) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "-->adjustEntryLayout--don't support troop and discuss forward, set troopDiscussionBtn gone");
            }
            this.troopDiscussionLayout.setVisibility(8);
        }
        if (!this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.f211018f4)) {
            this.gameContactLayout.setVisibility(8);
        } else {
            ((TextView) this.friendLayout.findViewById(R.id.ahi)).setText(R.string.f224926k9);
        }
        ForwardBaseOption forwardBaseOption4 = this.mForwardOption;
        if (forwardBaseOption4 instanceof ForwardH5PTVOption) {
            if (!forwardBaseOption4.isSupportAbility(num) && !this.mForwardOption.isSupportAbility(num2)) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "-->adjustEntryLayout--don't support friends and troop forward, set friendBtn gone");
                }
                this.friendLayout.setVisibility(8);
                this.multiChatLayout.setVisibility(8);
            }
            if (!this.mForwardOption.isSupportAbility(num)) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "-->adjustEntryLayout--don't support friends");
                }
                this.friendLayout.setVisibility(8);
                this.multiChatLayout.setVisibility(8);
            }
        }
        ForwardBaseOption forwardBaseOption5 = this.mForwardOption;
        if ((forwardBaseOption5 instanceof ForwardChooseFriendOption) && !forwardBaseOption5.isSupportAbility(com.tencent.mobileqq.forward.e.Y3)) {
            this.multiChatLayout.setVisibility(0);
        }
        if (this.mForwardOption instanceof ForwardH5RabbitSpringEmoteOption) {
            onlyShowMultiChatLayoutInItemArea();
        }
    }

    private void attachQCircleReportParam(boolean z16) {
        Bundle extras;
        String userInputStr;
        if (isNotQCircleForwardFlow()) {
            return;
        }
        Intent intent = getIntent();
        Bundle extras2 = intent.getExtras();
        if (extras2 == null) {
            extras2 = new Bundle();
        }
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption == null) {
            extras = null;
        } else {
            extras = forwardBaseOption.getExtras();
        }
        ForwardBaseOption forwardBaseOption2 = this.mForwardOption;
        if (forwardBaseOption2 == null) {
            userInputStr = "";
        } else {
            userInputStr = forwardBaseOption2.getUserInputStr();
        }
        if (!TextUtils.isEmpty(userInputStr)) {
            extras2.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, userInputStr);
        }
        if (extras != null) {
            extras2.putInt("uintype", extras.getInt("uintype"));
            extras2.putString("uin", extras.getString("uin"));
            extras2.putString("uinname", extras.getString("uinname"));
            extras2.putBoolean(KEY_QCIRCLE_CLICK, z16);
            extras2.putBoolean("is_multi_selection", isMultiSelectStatus());
            Serializable serializable = extras.getSerializable(AppConstants.Key.FORWARD_ARK_MSG_ID_MAP);
            if (serializable != null) {
                extras2.putSerializable(AppConstants.Key.FORWARD_ARK_MSG_ID_MAP, serializable);
            }
            saveMultiUinAndUinTypeAndUinName(extras2);
            intent.putExtras(extras2);
        }
    }

    private void attachSelectedParam() {
        Bundle extras;
        if (!isNeedReturnSelectedList()) {
            return;
        }
        Intent intent = getIntent();
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption == null) {
            extras = null;
        } else {
            extras = forwardBaseOption.getExtras();
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (isMultiSelectStatus()) {
            Iterator<ResultRecord> it = this.mForwardTargetMap.values().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else if (extras != null) {
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.uinType = extras.getInt("uintype");
            resultRecord.uin = extras.getString("uin");
            arrayList.add(resultRecord);
        }
        if (!intent.hasExtra("selected_target_list")) {
            intent.putParcelableArrayListExtra("selected_target_list", arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindFinishReceiver(Intent intent) {
        if (this.isSdkShare) {
            initBindFinishReceiver();
            intent.putExtra(PARAM_BIND_FINISH, true);
        }
    }

    private void bindSelectAndSearchBarData() {
        if (this.mFaceDecoder == null) {
            this.mFaceDecoder = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        }
        if (this.mGuildService == null) {
            this.mGuildService = (IQQGuildService) this.app.getRuntimeService(IQQGuildService.class, "");
        }
        this.mSelectedAndSearchBar.t(null, this.mFaceDecoder, this.mSelectedAndSearchBarCallback, this.mGuildService);
    }

    private boolean canShowSelectedAndSearchBar() {
        if (this.mIsMatchFriendUserList) {
            return false;
        }
        return true;
    }

    private static void changeMarginRight(@NonNull View view, int i3) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, i3, marginLayoutParams.bottomMargin);
            view.requestLayout();
        }
    }

    private boolean checkGuildInValid(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).isGuildMember(str)) {
            return true;
        }
        return false;
    }

    private boolean checkIntentDataIllegal() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fs_forward_act_intent_data_illegal_check_switch", false)) {
            return false;
        }
        try {
            QLog.i(TAG, 1, "checkIntentDataIllegal preAct: " + getIntent().getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY));
            return false;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "checkIntentDataIllegal exp: ", e16);
            return true;
        }
    }

    private void clearForwardTarget() {
        this.mForwardTargetMap.clear();
    }

    private RecentUser createNewVersionDatalineEntry() {
        RecentUser recentUser = new RecentUser(AppConstants.DATALINE_NEW_VERSION_UIN, 0);
        recentUser.displayName = getString(R.string.f187533u9);
        return recentUser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean enableSearchDefaultSingleMode() {
        boolean z16 = true;
        if (!this.enableSearchDefaultSingleModeByConfig) {
            QLog.w(TAG, 1, "enableSearchDefaultSingleMode disable qqmc");
        }
        if (this.mOnlySingleSelection) {
            return Boolean.FALSE;
        }
        if (!this.enableSearchDefaultSingleModeByConfig || !canShowSelectedAndSearchBar()) {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filterRecentData(List<RecentUser> list) {
        int size;
        int size2;
        if (this.mIsShowRecentChatList) {
            this.recentChatList = getForwardRecentList(list);
        }
        IRecentForwardUserProxy recentForwardCache = ((IRecentUserProxyService) this.app.getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache();
        if (this.mIsShowRecentForwardList) {
            this.recentForwardList = getForwardRecentList(recentForwardCache.getRecentList(true));
        }
        int i3 = 0;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refreshRecentList 01 recentChatList size is: ");
            List<RecentUser> list2 = this.recentChatList;
            if (list2 == null) {
                size = 0;
            } else {
                size = list2.size();
            }
            sb5.append(size);
            sb5.append(" recentForwardList size is:");
            List<RecentUser> list3 = this.recentForwardList;
            if (list3 == null) {
                size2 = 0;
            } else {
                size2 = list3.size();
            }
            sb5.append(size2);
            QLog.i(TAG, 2, sb5.toString());
        }
        List<RecentUser> list4 = this.recentChatList;
        if (list4 != null) {
            filterRecentList(list4);
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.app)) {
                this.recentChatList.add(0, createNewVersionDatalineEntry());
            }
        }
        List<RecentUser> list5 = this.recentForwardList;
        if (list5 != null) {
            filterRecentList(list5);
            ForwardBaseOption forwardBaseOption = this.mForwardOption;
            if (forwardBaseOption != null) {
                forwardBaseOption.filterRecentForwardList(this.recentForwardList);
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("refreshRecentList forwardList size is: ");
            List<RecentUser> list6 = this.recentChatList;
            if (list6 != null) {
                i3 = list6.size();
            }
            sb6.append(i3);
            QLog.i(TAG, 2, sb6.toString());
        }
    }

    private void filterRecentList(List<RecentUser> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (RecentUser recentUser : list) {
            if (recentUser.lFlag == 16 || recentUser.getType() == 10005) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 1038) {
                arrayList.add(recentUser);
            }
            if (TextUtils.equals(recentUser.uin, "256111111111111111") || TextUtils.equals(recentUser.uin, "1111111111111111FFFFFFFFFFFFFFFF")) {
                arrayList.add(recentUser);
            }
            if (TextUtils.equals(recentUser.uin, "256111111111111112")) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 1046) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 10019) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 10027 && checkGuildInValid(recentUser.uin)) {
                arrayList.add(recentUser);
            }
            if (this.mIsForConfess && TextUtils.equals(recentUser.uin, this.app.getCurrentAccountUin())) {
                arrayList.add(recentUser);
            }
            if (TextUtils.equals(recentUser.uin, com.tencent.mobileqq.filemanager.fileassistant.util.h.g(this.app))) {
                arrayList.add(recentUser);
            }
            if (TextUtils.equals(AppConstants.CONVERSATION_MAY_KNOW_FRIEND_UIN, recentUser.uin) || recentUser.getType() == 8111 || recentUser.getType() == 8112 || recentUser.getType() == 8113 || recentUser.getType() == 10007 || recentUser.getType() == 10015) {
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 1 && ((TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER)).k(recentUser.uin) == null) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "refreshRecentList, filter troop, recentUser.troopUin =" + recentUser.troopUin + ",recentUser.uin = " + recentUser.uin);
                }
                arrayList.add(recentUser);
            }
            if (recentUser.getType() == 0) {
                hashMap.put(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(recentUser.uin)), recentUser);
            }
            ForwardBaseOption forwardBaseOption = this.mForwardOption;
            if (forwardBaseOption != null && !forwardBaseOption.allowRecentUser(recentUser)) {
                arrayList.add(recentUser);
            }
            if (!((ISelectNtSaveRecentUserApi) QRoute.api(ISelectNtSaveRecentUserApi.class)).shouldAddToList(recentUser, true)) {
                arrayList.add(recentUser);
            }
        }
        if (!hashMap.isEmpty()) {
            Map<String, Boolean> isFriends = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriends(TAG, new ArrayList<>(hashMap.keySet()));
            for (String str : isFriends.keySet()) {
                if (Boolean.FALSE.equals(isFriends.get(str)) && hashMap.get(str) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i(TAG, 4, "refreshRecentList, filter deleted friend, uin = " + ((RecentUser) hashMap.get(str)).uin);
                    }
                    arrayList.add((RecentUser) hashMap.get(str));
                }
            }
        }
        list.removeAll(arrayList);
    }

    private void forward2MultiTargets() {
        if (this.mForwardTargetMap.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "forward2MultiTargets no forward target !");
                return;
            }
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.mForwardTargetMap.values());
        Collections.sort(arrayList, new ResultRecord.DefaultComparator());
        Bundle bundle = new Bundle();
        bundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.f307202c0.intValue());
        bundle.putParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET, arrayList);
        bundle.putBoolean(AppConstants.Key.FORWARD_FROM_OUTSIDE_SHARE, this.mIsFromShare);
        bundle.putBoolean(AppConstants.Key.FORWARD_FROM_DATALINE_AIO, this.mIsFromDatalineAIO);
        this.mForwardOption.buildForwardDialog(com.tencent.mobileqq.forward.e.N3.intValue(), bundle);
        this.mForwardOption.reportForward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean forwardToGuildFeeds(String str) {
        if (((IGPSService) this.app.getRuntimeService(IGPSService.class)).getGuildInfo(str) == null) {
            QLog.e(TAG, 1, "guildInfo is null for " + str);
            return false;
        }
        if ((this.mForwardOption instanceof com.tencent.mobileqq.forward.al) && !TextUtils.isEmpty(str) && ((com.tencent.mobileqq.forward.al) this.mForwardOption).b()) {
            this.mForwardOption.getExtras().putString("uin", str);
            this.mForwardOption.getExtras().putInt("uintype", 10027);
            this.mForwardOption.getExtras().putInt("key_forward_ability_type", com.tencent.mobileqq.forward.e.f211016c4.intValue());
            this.share2GuildCallback = new com.tencent.mobileqq.guild.feed.api.g() { // from class: com.tencent.mobileqq.activity.bv
                @Override // com.tencent.mobileqq.guild.feed.api.g
                public final void a(boolean z16) {
                    ForwardRecentActivity.this.lambda$forwardToGuildFeeds$0(z16);
                }
            };
            Intent intent = getIntent();
            int ordinal = GuildSharePageSource.UNKNOWN.ordinal();
            if (intent != null && intent.hasExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE)) {
                ordinal = intent.getIntExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, ordinal);
            }
            ((com.tencent.mobileqq.forward.al) this.mForwardOption).a(this, str, ordinal, this.share2GuildCallback);
            return true;
        }
        QQToast.makeText(BaseApplication.getContext(), 0, NOT_SUPPORT_SHARE_TO_GUILD, 1).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forwardToMatchFriendUser(String str) {
        for (ResultRecord resultRecord : ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).getMsgListUserData(false)) {
            if (str.equals(resultRecord.uin)) {
                openForwardDialog(resultRecord, null);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBusinessId() {
        if (TextUtils.isEmpty(this.businessId)) {
            this.businessId = getIntent().getStringExtra(KEY_FORWARD_BUSINESS_ID);
        }
        if (TextUtils.isEmpty(this.businessId)) {
            this.businessId = "other";
        }
        return this.businessId;
    }

    private com.tencent.mobileqq.filemanager.fileassistant.util.b getDeviceChooseModel() {
        Intent intent = getIntent();
        ArrayList arrayList = new ArrayList();
        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
        if (forwardFileInfo != null) {
            arrayList.add(forwardFileInfo);
            return com.tencent.mobileqq.filemanager.fileassistant.util.b.j(arrayList);
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("fileinfo_array");
        if (parcelableArrayListExtra != null) {
            return com.tencent.mobileqq.filemanager.fileassistant.util.b.j(parcelableArrayListExtra);
        }
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null && (forwardBaseOption instanceof ForwardFileOption)) {
            ForwardFileOption forwardFileOption = (ForwardFileOption) forwardBaseOption;
            if (forwardFileOption.isFromJumpActivity()) {
                return com.tencent.mobileqq.filemanager.fileassistant.util.b.m(forwardFileOption);
            }
        }
        List<ChatMessage> v3 = MultiMsgManager.w().v();
        com.tencent.mobileqq.filemanager.fileassistant.util.b k3 = com.tencent.mobileqq.filemanager.fileassistant.util.b.k(v3);
        if (v3.size() > 1) {
            k3.o();
        }
        return k3;
    }

    public static String getFilePath(Context context, Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.equals("file")) {
            if (scheme.equals("content")) {
                try {
                    Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{"_data"}, null, null, null);
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                    query.moveToFirst();
                    String string = query.getString(columnIndexOrThrow);
                    query.close();
                    return string;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            return null;
        }
        return new File(uri.getPath()).getAbsolutePath();
    }

    private List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        if (this.mIsMatchFriendUserList) {
            return ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).getForwardRecentList();
        }
        return this.mForwardOption.getForwardRecentList(list);
    }

    private String getForwardTargetKey(String str, int i3) {
        return i3 + "_" + str;
    }

    private List<String> getJoinUins(List<String> list) {
        if (enableSearchDefaultSingleMode().booleanValue()) {
            return this.unclickableSelectedUins;
        }
        if (this.mSearchFragment.K9()) {
            return null;
        }
        return list;
    }

    private String getNameForGuild(String str, String str2) {
        return str + "|" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ResultRecord> getRecentForwardAndChat() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getRecentForwardAndChat() called #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        ArrayList<ResultRecord> resultRecord = getResultRecord();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<ResultRecord> it = resultRecord.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().uin);
        }
        ArrayList<ResultRecord> arrayList2 = new ArrayList<>(getValidForwardResultRecord(arrayList));
        if (arrayList2.size() >= 15) {
            return arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<ResultRecord> it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(it5.next().uin);
        }
        Iterator<ResultRecord> it6 = resultRecord.iterator();
        while (it6.hasNext()) {
            ResultRecord next = it6.next();
            if (!arrayList3.contains(next.uin)) {
                arrayList2.add(next);
                arrayList3.add(next.uin);
            }
        }
        return arrayList2;
    }

    private List<RecentUser> getRecentForwardListWithoutShowUp() {
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            QLog.e(TAG, 1, "getRecentForwardListWithoutShowUp is error, app is null!");
            return this.recentForwardList;
        }
        IRecentForwardUserProxy recentForwardCache = ((IRecentUserProxyService) qQAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache();
        if (recentForwardCache == null) {
            QLog.e(TAG, 1, "getRecentForwardListWithoutShowUp is error, forwardUserProxy is null!");
            return this.recentForwardList;
        }
        List<RecentUser> recentList = recentForwardCache.getRecentList(true, true, false);
        filterRecentList(recentList);
        return recentList;
    }

    private ArrayList<RecentUser> getRecentGuildChatChannel() {
        ArrayList<RecentUser> arrayList = new ArrayList<>();
        if (this.mStyle == 2 && this.mIsShowGuildEntrance) {
            List<t02.e> recentTalkedChannelsInfo = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getRecentTalkedChannelsInfo(this.app);
            if (recentTalkedChannelsInfo == null) {
                return arrayList;
            }
            for (t02.e eVar : recentTalkedChannelsInfo) {
                RecentUser recentUser = new RecentUser(eVar.a(), 10014);
                recentUser.troopUin = eVar.c();
                recentUser.displayName = getNameForGuild(eVar.d(), eVar.b());
                recentUser.lastmsgtime = eVar.e().longValue() / 1000;
                arrayList.add(recentUser);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getReportFromType() {
        if (this.mIsFromShare) {
            return 2;
        }
        if (this.mIsFromWeb) {
            return 3;
        }
        return 1;
    }

    private ArrayList<ResultRecord> getResultRecord() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getResultRecord() called #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        ArrayList<ResultRecord> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.recentChatList) {
            for (RecentUser recentUser : this.recentChatList) {
                if (recentUser.getType() != 10027) {
                    arrayList2.add(recentUser);
                }
            }
        }
        arrayList2.addAll(getRecentGuildChatChannel());
        Collections.sort(arrayList2, new RecentForwardUserCache.RecentComparator(true));
        com.tencent.mobileqq.adapter.n nVar = this.recentAdapter;
        if (nVar != null) {
            Iterator<n.b> it = nVar.m(arrayList2).iterator();
            while (it.hasNext()) {
                n.b next = it.next();
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.uin = next.f187221c;
                RecentUser recentUser2 = next.f187222d;
                if (recentUser2 != null) {
                    resultRecord.type = recentUser2.getType();
                    resultRecord.guildId = next.f187222d.troopUin;
                }
                if (resultRecord.type == 1 && !TroopUtils.n(resultRecord.uin)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                resultRecord.isNewTroop = z16;
                resultRecord.name = next.f187219a;
                resultRecord.source = 2;
                arrayList.add(resultRecord);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSearchSource() {
        int i3;
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.O3)) {
            i3 = 33;
        } else {
            i3 = 32;
        }
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.U3)) {
            i3 |= 256;
        }
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.V3)) {
            i3 |= 4;
        }
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.Q3)) {
            i3 |= 8;
        }
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.P3)) {
            i3 = i3 | 16 | 2097152 | 4194304;
        }
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.f211018f4)) {
            return i3 | 134217728;
        }
        return i3;
    }

    private List<String> getSelectedUins() {
        ArrayList arrayList = new ArrayList();
        Iterator<ResultRecord> it = this.mForwardTargetMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().uin);
        }
        return arrayList;
    }

    private ArrayList<ResultRecord> getValidForwardResultRecord(ArrayList<String> arrayList) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getValidForwardResultRecord() called #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        long a16 = com.tencent.relation.common.config.toggle.c.B.a(0);
        long serverTime = NetConnInfoCenter.getServerTime();
        ArrayList<ResultRecord> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList(getRecentForwardListWithoutShowUp());
        com.tencent.mobileqq.adapter.n nVar = this.recentAdapter;
        if (nVar != null) {
            Iterator<n.b> it = nVar.m(arrayList3).iterator();
            while (it.hasNext()) {
                n.b next = it.next();
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.uin = next.f187221c;
                RecentUser recentUser = next.f187222d;
                if (recentUser != null) {
                    int type = recentUser.getType();
                    resultRecord.type = type;
                    RecentUser recentUser2 = next.f187222d;
                    resultRecord.guildId = recentUser2.troopUin;
                    if (a16 <= 0 || serverTime - recentUser2.lastmsgtime <= 86400 * a16) {
                        if (type == 10027) {
                            if (checkGuildInValid(resultRecord.uin)) {
                            }
                        } else if (!arrayList.contains(resultRecord.uin)) {
                        }
                    }
                }
                if (resultRecord.type == 1 && !TroopUtils.n(resultRecord.uin)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                resultRecord.isNewTroop = z16;
                resultRecord.name = next.f187219a;
                resultRecord.source = 1;
                arrayList2.add(resultRecord);
            }
        }
        return arrayList2;
    }

    private void initBindFinishReceiver() {
        if (this.bindFinishReceiver == null) {
            b bVar = new b();
            this.bindFinishReceiver = bVar;
            registerReceiver(bVar, new IntentFilter(ACTION_BIND_FINISH));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBroadcastReceiver() {
        if (this.qqBroadcastReceiver == null) {
            this.qqBroadcastReceiver = new a();
            registerReceiver(this.qqBroadcastReceiver, new IntentFilter(JumpActivity.BROCAST_RECEIVER_ACTION));
        }
    }

    private void initEntryHeaderView() {
        if (!this.mIsMatchFriendUserList) {
            addBlankHeaderDivider();
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.f167969o3, (ViewGroup) this.mListView, false);
        this.mEntryHeader = inflate;
        inflate.setOverScrollMode(2);
        if (this.uinType != 9501) {
            this.mListView.addHeaderView(this.mEntryHeader);
        }
        this.mEntryContentContainer = (LinearLayout) this.mEntryHeader.findViewById(R.id.ed_);
        this.friendLayout = (FormItemRelativeLayout) this.mEntryHeader.findViewById(R.id.cje);
        this.contactLayout = (FormItemRelativeLayout) this.mEntryHeader.findViewById(R.id.cjh);
        this.troopDiscussionLayout = (FormItemRelativeLayout) this.mEntryHeader.findViewById(R.id.cjk);
        this.multiChatLayout = (FormItemRelativeLayout) this.mEntryHeader.findViewById(R.id.cjg);
        this.qzoneLayout = (FormItemRelativeLayout) this.mEntryHeader.findViewById(R.id.lik);
        this.gameContactLayout = (FormItemRelativeLayout) this.mEntryHeader.findViewById(R.id.vdw);
        this.directShareTips = (TipsBar) this.mEntryHeader.findViewById(R.id.m_l);
        this.friendLayout.setBGType(1);
        this.troopDiscussionLayout.setBGType(2);
        this.multiChatLayout.setBGType(3);
        this.contactLayout.setBGType(2);
        this.qzoneLayout.setBGType(0);
        this.friendLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        this.contactLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        this.troopDiscussionLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        this.multiChatLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        this.qzoneLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        this.gameContactLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        this.directShareTips.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        this.friendLayout.setOnClickListener(this.onClick);
        this.troopDiscussionLayout.setOnClickListener(this.onClick);
        this.contactLayout.setOnClickListener(this.onClick);
        this.multiChatLayout.setOnClickListener(this.onClick);
        this.qzoneLayout.setOnClickListener(this.qzoneEntryOnClickListener);
        this.directShareTips.setCloseListener(this.directShareTipsCloseListener);
        this.gameContactLayout.setOnClickListener(this.gameContactClickListener);
        if (this.mOnlySingleSelection) {
            this.friendLayout.setVisibility(0);
            this.contactLayout.setVisibility(0);
            this.troopDiscussionLayout.setVisibility(0);
            this.multiChatLayout.setVisibility(0);
            this.gameContactLayout.setVisibility(0);
            return;
        }
        this.friendLayout.setVisibility(8);
        this.contactLayout.setVisibility(8);
        this.troopDiscussionLayout.setVisibility(8);
        this.multiChatLayout.setVisibility(0);
        this.gameContactLayout.setVisibility(8);
    }

    private void initQUITitle() {
        this.quiSecNavBar.setCenterText(this.mForwardOption.getTitle());
        if (!this.mOnlySingleSelection) {
            this.quiSecNavBar.setLeftType(1);
            this.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.mpt));
            this.quiSecNavBar.setRightType(1);
            this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.mpn));
        } else {
            this.quiSecNavBar.setLeftType(0);
            this.quiSecNavBar.setRightType(1);
            this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.j6l));
        }
        this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new y());
        this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_TEXT, new z());
        this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new aa());
    }

    private void initRecentForwardedHeaderViews() {
        int i3;
        View inflate = LayoutInflater.from(this).inflate(R.layout.f167796ht, (ViewGroup) null);
        inflate.setFocusable(true);
        this.recommendTv = (TextView) inflate.findViewById(R.id.k7c);
        this.tipLayout = (RelativeLayout) inflate.findViewById(R.id.idv);
        TextView textView = (TextView) inflate.findViewById(R.id.kbr);
        this.tipTv = textView;
        if (isMultiSelectStatus()) {
            i3 = R.string.f170745zm3;
        } else {
            i3 = R.string.f170800zp0;
        }
        textView.setText(i3);
        this.tipTv.setOnClickListener(this.onClick);
        if (this.mIsToPayList) {
            this.recommendTv.setText(R.string.bcb);
        } else {
            if (this.mStyle == 0) {
                this.recommendTv.setText(R.string.bca);
                this.tipLayout.setVisibility(8);
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "!mIsToPayList && mStyle == STYLE_DEFAULT");
                }
            } else {
                this.recommendTv.setText(R.string.f1357602b);
                this.tipLayout.setVisibility(0);
            }
            report("0X800C016");
        }
        if (this.mStyle != 0) {
            if (this.multiChatLayout.getVisibility() == 8) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "mStyle != STYLE_DEFAULT && null != tipTv && multiChatLayout.getVisibility() == View.GONE");
                }
                this.tipTv.setVisibility(8);
            } else if (this.multiChatLayout.getVisibility() == 0) {
                this.multiChatLayout.setVisibility(8);
                this.tipTv.setVisibility(0);
            }
            initRecentForwardedView();
        }
        setMatchFriendForwardMode();
        if (!isAllHeaderTabsEmpty()) {
            addBlankHeaderDivider();
        }
        this.mListView.addHeaderView(inflate);
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.S3) && !com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.app)) {
            addDatalineEntry();
        }
        if (this.mIsShowWechatEntrance && !this.mOnlySingleSelection) {
            addWechatEntry();
        }
        setWalletPetRecentMode();
    }

    private void initRecentForwardedView() {
        int min;
        if (this.mStyle == 0 || (min = Math.min(5, this.recentForwardList.size())) == 0) {
            return;
        }
        if (this.mStyle == 2) {
            addRecentForwardedGrid(min);
        }
        addBlankHeaderDivider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSearchOperationIoc() {
        if (this.contactSelectOperationIoc == null) {
            this.contactSelectOperationIoc = new r();
        }
    }

    private void initSelectMode(Intent intent) {
        String stringExtra = intent.getStringExtra("caller_name");
        boolean z16 = false;
        int intExtra = intent.getIntExtra(SELECTION_MODE, 0);
        if (intExtra == 2) {
            this.mOnlySingleSelection = false;
        } else if (intExtra == 1) {
            this.mOnlySingleSelection = true;
        } else {
            if ("SplashActivity".equals(stringExtra) || "ChatActivity".equals(stringExtra) || "LiteActivity".equals(stringExtra) || "ChatHistoryActivity".equals(stringExtra)) {
                this.mIsFromAIO = true;
            }
            if (intent.getBooleanExtra("only_single_selection", false) || !this.mForwardOption.isSupportMultipleForward() || (!this.mIsFromAIO && !this.mIsFromWeb && this.mForwardOption.isFromLimit())) {
                z16 = true;
            }
            this.mOnlySingleSelection = z16;
        }
        this.mForwardOption.getExtras().putBoolean("onlySingleSelection", this.mOnlySingleSelection);
    }

    private void initSelectedAndSearchBar() {
        this.mImm = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.mSelectedAndSearchBar = (SelectedAndSearchBar) super.findViewById(R.id.imi);
        if (!canShowSelectedAndSearchBar()) {
            this.mSelectedAndSearchBar.setVisibility(8);
        }
        this.mSelectedAndSearchBar.r(0L);
        this.mSelectedAndSearchBar.o(new s());
        if (this.mFaceDecoder == null || this.mGuildService == null) {
            bindSelectAndSearchBarData();
        }
    }

    private void initSelectedForwardTarget(@NotNull Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("selected_target_list");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            switch2MultiSelectStatus();
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                add2ForwardTargetList((ResultRecord) it.next());
            }
        }
    }

    private void initViews() {
        this.mLlRoot = (LinearLayout) super.findViewById(R.id.root);
        initQUITitle();
        initSelectedAndSearchBar();
        this.mSearchResultLayout = (FrameLayout) super.findViewById(R.id.result_layout);
        this.mListView = (XListView) super.findViewById(R.id.listView1);
        initEntryHeaderView();
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.R3) && !this.isShowInSare) {
            this.qzoneLayout.setVisibility(0);
            ReportController.o(this.app, "CliOper", "", "", "friendchoose", "0X800A2D6", getReportFromType(), 0, "", "", "", getBusinessId());
        } else {
            this.qzoneLayout.setVisibility(8);
        }
        updatePhoneContactsNewFlag();
        TipsBar tipsBar = this.directShareTips;
        if (tipsBar != null) {
            if (this.mNeedShowDirectShareTips) {
                tipsBar.setVisibility(0);
                ta1.m c16 = TencentDocMyFileNameProcessor.c();
                if (c16 != null && !TextUtils.isEmpty(c16.f435718i)) {
                    this.directShareTips.setTipsText(c16.f435718i);
                }
            } else {
                tipsBar.setVisibility(8);
            }
        }
        int i3 = this.mReq;
        if (1 == i3 || 2 == i3 || 4 == i3 || 5 == i3 || i3 == 6) {
            getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new i());
        }
    }

    private boolean isAllHeaderTabsEmpty() {
        if (this.friendLayout.getVisibility() == 8 && this.contactLayout.getVisibility() == 8 && this.troopDiscussionLayout.getVisibility() == 8 && this.multiChatLayout.getVisibility() == 8 && this.qzoneLayout.getVisibility() == 8 && this.directShareTips.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isForwardTargetSelected(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.mForwardTargetMap.containsKey(getForwardTargetKey(str, i3));
    }

    private boolean isInterceptAndDeal(Intent intent) {
        ResultRecord resultRecord = new ResultRecord();
        if (intent.getBooleanExtra("select_memeber_single_friend", false)) {
            resultRecord.uin = intent.getStringExtra("uin");
            resultRecord.uinType = intent.getIntExtra("uintype", -1);
        } else {
            resultRecord.uin = intent.getStringExtra(ISelectMemberActivityConstants.Result_Uin);
            resultRecord.uinType = intent.getIntExtra(ISelectMemberActivityConstants.Result_UinType, -1);
        }
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption == null || !forwardBaseOption.isInterceptForwardDialog(resultRecord)) {
            return false;
        }
        this.mForwardOption.onListViewItemClicked(resultRecord);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMultiSelectStatus() {
        if (this.mCurrentStatus == 1) {
            return true;
        }
        return false;
    }

    private boolean isNeedReturnSelectedList() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null) {
            extras = null;
        } else {
            extras = intent.getExtras();
        }
        if (extras == null || !extras.getBoolean("key_is_need_return_selected_list", false)) {
            return false;
        }
        return true;
    }

    private boolean isNotQCircleForwardFlow() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null) {
            extras = null;
        } else {
            extras = intent.getExtras();
        }
        if (extras != null && extras.getBoolean(KEY_QCIRCLE_FORWARD, false)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addWechatEntry$1(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!WXShareHelper.b0().e0()) {
            i3 = R.string.f173257ih1;
        } else if (!WXShareHelper.b0().f0()) {
            i3 = R.string.f173258ih2;
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            QQToast.makeText(BaseApplication.getContext(), i3, 0).show();
        } else {
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getWxShareOrganizer().a(getIntent());
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forwardToGuildFeeds$0(boolean z16) {
        if ((this instanceof ForwardRecentTranslucentActivity) || z16) {
            Intent intent = new Intent();
            intent.putExtras(this.mForwardOption.getExtras());
            intent.putExtra("uintype", 10027);
            if (z16) {
                setResult(-1, intent);
            } else {
                setResult(0, intent);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showForwardCountLimitDialog$3(DialogInterface dialogInterface, int i3) {
        if (!isFinishing()) {
            this.mForwardCountLimitDialog.dismiss();
        }
    }

    private boolean launchNewSharePanel() {
        return false;
    }

    private void notifyForwardRecentItemClick() {
        if (isNotQCircleForwardFlow()) {
            return;
        }
        attachQCircleReportParam(true);
        notifyResultReceiver(getIntent(), this);
    }

    public static void notifyResultReceiver(Intent intent, Object obj) {
        boolean z16;
        ResultReceiver resultReceiver;
        if (intent != null && intent.getExtras() != null && obj != null) {
            int i3 = 0;
            if (obj instanceof Activity) {
                z16 = ((Activity) obj).isFinishing();
            } else {
                z16 = false;
            }
            if (!z16 && (resultReceiver = (ResultReceiver) intent.getParcelableExtra("PARAM_ActivityResultReceiver")) != null) {
                try {
                    Field declaredField = Activity.class.getDeclaredField("mResultCode");
                    declaredField.setAccessible(true);
                    i3 = ((Integer) declaredField.get(obj)).intValue();
                } catch (NoSuchFieldException e16) {
                    QLog.w(TAG, 1, "finish, get mResultCode NoSuchFieldException", e16);
                } catch (Exception e17) {
                    QLog.w(TAG, 1, "finish, get mResultCode fail", e17);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.w(TAG, 1, "notifyResultReceiver, resultReceiver[" + resultReceiver + "]", new Throwable("throwable"));
                }
                resultReceiver.send(i3, intent.getExtras());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySearchFragmentShow() {
        this.unclickableSelectedUins.clear();
        this.unclickableSelectedUins.addAll(getSelectedUins());
        setSearchSelectedAndJoinedUins();
        com.tencent.mobileqq.search.view.f fVar = this.mSearchFragment;
        if (fVar != null) {
            fVar.tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickFromCreateNewChat() {
        int i3;
        reportDataForBusiness("0X8007826");
        if (!this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.O3)) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        Intent intent = new Intent();
        intent.putExtra("param_type", 3000);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, getString(R.string.f173099hd3));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, getString(R.string.f173100hd4));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, i3);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 99);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 12);
        this.mForwardOption.wrapCreateNewChatIntent(intent);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, intent, 20003);
        ReportController.o(this.app, "CliOper", "", "", "friendchoose", "0X8009D92", getReportFromType(), 0, "", "", "", "");
    }

    private void onFileAssistantItemCLickedInMultiSelectStatus(ResultRecord resultRecord, ForwardRecentItemView forwardRecentItemView, boolean z16) {
        com.tencent.mobileqq.filemanager.fileassistant.util.b deviceChooseModel = getDeviceChooseModel();
        if (z16) {
            deviceChooseModel.o();
        }
        deviceChooseModel.b(this, resultRecord.uin, new n(resultRecord, forwardRecentItemView, z16));
    }

    private void onFileAssistantItemClickedInDefaultStatus(ResultRecord resultRecord, View view) {
        getDeviceChooseModel().b(this, resultRecord.uin, new k(resultRecord, view));
    }

    private void onFileAssistantRoundItemClickedInDefaultStatus(ResultRecord resultRecord, ForwardRecentRoundItemView forwardRecentRoundItemView) {
        getDeviceChooseModel().b(this, resultRecord.uin, new l(resultRecord, forwardRecentRoundItemView));
    }

    private void onFileAssistantRoundItemClickedInMultiSelectStatus(ResultRecord resultRecord, ForwardRecentRoundItemView forwardRecentRoundItemView, boolean z16) {
        com.tencent.mobileqq.filemanager.fileassistant.util.b deviceChooseModel = getDeviceChooseModel();
        if (z16) {
            deviceChooseModel.o();
        }
        deviceChooseModel.b(this, resultRecord.uin, new o(resultRecord, forwardRecentRoundItemView, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGridViewItemClickedInMultiSelectStatus(View view) {
        ForwardRecentRoundItemView forwardRecentRoundItemView = (ForwardRecentRoundItemView) view;
        ResultRecord resultRecord = forwardRecentRoundItemView.F;
        if (resultRecord == null) {
            return;
        }
        boolean isForwardTargetSelected = isForwardTargetSelected(resultRecord.uin, resultRecord.getUinType());
        if (!forwardRecentRoundItemView.f187022i.isEnabled() && 10027 == resultRecord.uinType) {
            QQToast.makeText(BaseApplication.getContext(), 0, NOT_SUPPORT_MULTI_GUILD, 1).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.k(resultRecord.uin)) {
            setGridItemSelected(resultRecord, forwardRecentRoundItemView, isForwardTargetSelected);
        } else {
            onFileAssistantRoundItemClickedInMultiSelectStatus(resultRecord, forwardRecentRoundItemView, isForwardTargetSelected);
        }
        syncRecentChatClicked(resultRecord, isForwardTargetSelected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHeaderItemDelete(ResultRecord resultRecord) {
        onItemViewDelete(this.mForwardPcItemView, resultRecord);
        onItemViewDelete(this.mForwardIpadItemView, resultRecord);
        onItemViewDelete(this.mForwardPhoneItemView, resultRecord);
    }

    private void onItemViewDelete(ForwardRecentItemView forwardRecentItemView, ResultRecord resultRecord) {
        ResultRecord resultRecord2;
        if (forwardRecentItemView != null && resultRecord != null && this.enableHeaderViewStatusFix && (resultRecord2 = forwardRecentItemView.J) != null && resultRecord2.uinType == resultRecord.uinType && resultRecord2.uin.equals(resultRecord.uin)) {
            forwardRecentItemView.e(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLeftClick() {
        if (isMultiSelectStatus()) {
            if (this.mIsFinishWhenMultiSelect) {
                quitSearchState();
                finish();
                return;
            } else {
                switch2DefaultStatus(true);
                report("0X800C018");
                return;
            }
        }
        if (this.mIsSingleStatusInSearch) {
            switch2DefaultStatus(false);
            return;
        }
        quitSearchState();
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.endForwardCallback(false);
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
        }
        report("0X800C014");
        finish();
        if ("caller_aecamera".equals(this.mCallActivity)) {
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_cancle_send_info", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListViewItemClickedInMultiSelectStatus(View view) {
        ForwardRecentItemView forwardRecentItemView = (ForwardRecentItemView) view;
        ResultRecord resultRecord = forwardRecentItemView.J;
        if (resultRecord == null) {
            return;
        }
        if (resultRecord.uinType == 10027) {
            QQToast.makeText(view.getContext(), NOT_SUPPORT_MULTI_GUILD, 0).show();
            return;
        }
        boolean isForwardTargetSelected = isForwardTargetSelected(resultRecord.uin, resultRecord.getUinType());
        if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.k(resultRecord.uin)) {
            setListItemSelected(resultRecord, forwardRecentItemView, isForwardTargetSelected);
        } else {
            onFileAssistantItemCLickedInMultiSelectStatus(resultRecord, forwardRecentItemView, isForwardTargetSelected);
        }
        syncRecentChatClicked(resultRecord, isForwardTargetSelected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRecentForwardItemDelete(ResultRecord resultRecord) {
        ForwardRecentRoundItemView forwardRecentRoundItemView;
        ResultRecord resultRecord2;
        HorizontalListView horizontalListView = this.horizontalListView;
        if (horizontalListView == null) {
            return;
        }
        int childCount = horizontalListView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.horizontalListView.getChildAt(i3);
            if ((childAt instanceof ForwardRecentRoundItemView) && (resultRecord2 = (forwardRecentRoundItemView = (ForwardRecentRoundItemView) childAt).F) != null && resultRecord2.uinType == resultRecord.uinType && resultRecord2.uin.equals(resultRecord.uin)) {
                forwardRecentRoundItemView.d(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRightClick() {
        if (this.mOnlySingleSelection) {
            ForwardBaseOption forwardBaseOption = this.mForwardOption;
            if (forwardBaseOption != null) {
                forwardBaseOption.endForwardCallback(false);
                com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
            }
            quitSearchState();
            if (this.mNeedShareCallback) {
                QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_FAIL_CALLBACK, null, null);
            }
            reportMiniAppShareFail();
            finish();
            if (getIntent().getBooleanExtra(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
                ReportController.o(this.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "2", "", "", "");
                return;
            }
            return;
        }
        if (isMultiSelectStatus()) {
            forward2MultiTargets();
        } else {
            switch2MultiSelectStatus();
            report("0X800C013");
        }
    }

    private void onlyShowMultiChatLayoutInItemArea() {
        this.friendLayout.setVisibility(8);
        this.troopDiscussionLayout.setVisibility(8);
        this.multiChatLayout.setVisibility(0);
        if (this.tipTv != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onlyShowMultiChatLayoutInItemArea && null != tipTv");
            }
            this.tipTv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openDataLineForwardDialog(String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", str);
        bundle.putInt("uintype", i3);
        bundle.putBoolean("forward_report_confirm", true);
        bundle.putString("forward_report_confirm_action_name", "0X8005A13");
        bundle.putString("forward_report_confirm_reverse2", "0");
        bundle.putString("caller_name", this.mCallActivity);
        this.mForwardOption.buildForwardDialog(com.tencent.mobileqq.forward.e.S3.intValue(), bundle);
        this.mForwardOption.reportFinalSelectedTargets();
        if (this.isSdkShare) {
            ReportCenter.f().q(this.app.getAccount(), "", this.appid, "1000", WadlProxyConsts.OPER_TYPE_MONITOR, "0", false, this.isSdkShare);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openForwardDialog(ResultRecord resultRecord, View view) {
        String str;
        String str2;
        String str3;
        if (view instanceof ForwardRecentItemView) {
            str = ((ForwardRecentItemView) view).G;
        } else if (view instanceof ForwardRecentRoundItemView) {
            str = ((ForwardRecentRoundItemView) view).C;
        } else {
            str = "";
        }
        if (this.mForwardOption.isInterceptForwardDialog(resultRecord)) {
            this.mForwardOption.onListViewItemClicked(resultRecord);
            return;
        }
        if (this.isSdkShare && resultRecord != null) {
            int uinType = resultRecord.getUinType();
            if (uinType != 0) {
                if (uinType != 1) {
                    if (uinType == 3000) {
                        ReportCenter.f().q(this.app.getAccount(), "", this.appid, "1000", "32", "0", false, this.isSdkShare);
                    }
                } else {
                    ReportCenter.f().q(this.app.getAccount(), "", this.appid, "1000", "31", "0", false, this.isSdkShare);
                }
            } else {
                ReportCenter.f().q(this.app.getAccount(), "", this.appid, "1000", "30", "0", false, this.isSdkShare);
            }
        }
        if (resultRecord != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("uintype", resultRecord.getUinType());
            bundle.putString("uin", resultRecord.uin);
            if (resultRecord.getUinType() != 1 && resultRecord.getUinType() != 3000) {
                str2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(resultRecord.uin);
            } else {
                str2 = resultRecord.uin;
            }
            bundle.putString(AppConstants.Key.UID, str2);
            bundle.putString("troop_uin", resultRecord.groupUin);
            bundle.putString("guild_id", resultRecord.guildId);
            if (resultRecord.getUinType() == 3000) {
                bundle.putString("uinname", ForwardUtils.r(this.app, str, resultRecord.uin));
            } else if (resultRecord.getUinType() == 1) {
                bundle.putString("uinname", ForwardUtils.s(this.app, resultRecord.uin, getIntent().getIntExtra("forward_type", -1), str));
            } else if (resultRecord.getUinType() == 10014) {
                if (TextUtils.isEmpty(resultRecord.guildId)) {
                    str3 = resultRecord.uin;
                } else {
                    str3 = resultRecord.guildId;
                }
                bundle.putString("guild_id", str3);
                if (TextUtils.isEmpty(str)) {
                    str = resultRecord.name;
                }
                bundle.putString("uinname", str);
            } else if (resultRecord.getUinType() == 1046) {
                bundle.putString("uin", resultRecord.uin);
                bundle.putString("uinname", resultRecord.name);
            } else {
                bundle.putString("uinname", str);
            }
            bundle.putBoolean("forward_report_confirm", true);
            bundle.putString("forward_report_confirm_action_name", "0X8005A13");
            bundle.putString("forward_report_confirm_reverse2", "5");
            bundle.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.f307202c0.intValue());
            bundle.putString("caller_name", this.mCallActivity);
            if (getIntent() != null && getIntent().getExtras() != null) {
                bundle.putBoolean("needShareCallBack", getIntent().getExtras().getBoolean("needShareCallBack"));
                bundle.putInt("miniAppShareFrom", getIntent().getExtras().getInt("miniAppShareFrom"));
            }
            com.tencent.mobileqq.filemanager.fileassistant.util.h.v(this.app, getIntent(), bundle);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[FORWARD_SHOW_DIALOG]invoke mForwardOption.buildForwardDialog uin=" + com.tencent.mobileqq.qcall.g.b(resultRecord.uin));
            }
            this.mForwardOption.buildForwardDialog(com.tencent.mobileqq.forward.e.N3.intValue(), bundle);
            this.mForwardOption.reportForward();
            if (resultRecord.getUinType() == 3000 || resultRecord.getUinType() == 1) {
                new com.tencent.mobileqq.statistics.q(this.app).i("dc00899").a("Grp_listNew").f("send_to").d("clk_grp").b("0").g();
            }
            ReportController.o(this.app, "CliOper", "", "", "friendchoose", "0X8009D90", getReportFromType(), 0, "", "", "", getBusinessId());
            notifyForwardRecentItemClick();
        }
    }

    private void popupSearchDialog(int i3) {
        long j3;
        getSearchSource();
        if (this.mForwardOption instanceof ForwardStructingMsgOption) {
            j3 = 1;
        } else {
            j3 = -1;
        }
        ContactSearchComponentActivity.W2(this, null, 7, getSearchSource(), 21001, j3);
        ReportController.o(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean queryHasMigrate(String str) {
        Map<String, Boolean> map = sMigrateCache;
        if (map.containsKey(str)) {
            return map.get(str).booleanValue();
        }
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitSearchState() {
        InputMethodManager inputMethodManager = this.mImm;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
        }
        SelectedAndSearchBar selectedAndSearchBar = this.mSelectedAndSearchBar;
        if (selectedAndSearchBar != null && selectedAndSearchBar.E()) {
            this.mSelectedAndSearchBar.u();
            this.mSelectedAndSearchBar.v();
        }
        FrameLayout frameLayout = this.mSearchResultLayout;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            this.mSearchResultLayout.setVisibility(8);
            com.tencent.mobileqq.search.view.f fVar = this.mSearchFragment;
            if (fVar != null) {
                fVar.y8();
            }
        }
    }

    private void refreshForwardList(boolean z16) {
        ArrayList arrayList;
        HashMap<String, Object> topayList = this.topayManager.getTopayList(this, z16, this.mBusinessType, this.mBusinessSubType);
        if (topayList == null) {
            return;
        }
        Object obj = topayList.get("tips");
        if (obj != null) {
            this.mForwardOption.getExtras().putStringArrayList("choose_friend_feedbacks", (ArrayList) obj);
        }
        this.recentChatList = new ArrayList();
        Object obj2 = topayList.get("recommend");
        if (obj2 != null) {
            arrayList = (ArrayList) obj2;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                PfaFriend pfaFriend = (PfaFriend) arrayList.get(i3);
                if (pfaFriend != null && !TextUtils.isEmpty(pfaFriend.uin) && (!this.mIsForConfess || !TextUtils.equals(pfaFriend.uin, this.app.getCurrentAccountUin()))) {
                    this.recentChatList.add(new RecentUser(pfaFriend.uin, 0));
                    Collections.sort(this.recentChatList, new c());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshNewList() {
        com.tencent.mobileqq.adapter.n nVar = this.recentAdapter;
        if (nVar == null) {
            if (this.mListView != null) {
                this.recentAdapter = new com.tencent.mobileqq.adapter.n(this, this.app, this.mListView, this.recentChatList, this.mForwardRecentListAdapterCallback);
                if (!this.mIsFriendPermission) {
                    initRecentForwardedHeaderViews();
                }
                this.mListView.setAdapter((ListAdapter) this.recentAdapter);
            }
        } else {
            nVar.n(this.recentChatList);
        }
        int i3 = this.mReq;
        if (1 == i3 || 2 == i3) {
            registerListViewDataSetChangedObserver();
        }
        HorizontalListView horizontalListView = this.horizontalListView;
        if (horizontalListView != null && horizontalListView.getAdapter() != null) {
            ((ForwardSelectionRecentFriendGridAdapter) this.horizontalListView.getAdapter()).e(this.recentForwardList.subList(0, Math.min(5, this.recentForwardList.size())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshRecentList() {
        if (!this.app.isAccLoginSuccess()) {
            QLog.d(TAG, 2, "!app.isAccLoginSuccess");
        } else {
            ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(this.app, new RecentContactListener() { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
                    }
                }

                @Override // com.tencent.relation.common.nt.listener.RecentContactListener
                public void onResult(@NonNull List<RecentUser> list) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(list) { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.13.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ List f175824d;

                            {
                                this.f175824d = list;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass13.this, (Object) list);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    ForwardRecentActivity.this.filterRecentData(this.f175824d);
                                    ForwardRecentActivity.this.refreshNewList();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }
            }, true);
        }
    }

    private void refreshRightBtn() {
        if (this.mForwardTargetMap.isEmpty()) {
            this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.mpq));
            this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
        } else {
            this.quiSecNavBar.setRightText(String.format(HardCodeUtil.qqStr(R.string.mpf), Integer.valueOf(this.mForwardTargetMap.size())));
            this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
        }
    }

    private void registerListViewDataSetChangedObserver() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "registerListViewDataSetChangedObserver() called #this = " + Integer.toHexString(System.identityHashCode(this)) + " mIsRegister = " + this.mIsRegister);
        }
        if (this.mIsRegister) {
            return;
        }
        if (this.mDataSetObserver == null) {
            this.mDataSetObserver = new x();
        }
        XListView xListView = this.mListView;
        if (xListView == null) {
            QLog.e(TAG, 1, "registerListViewDataSetChangedObserver() mListView is null.");
            return;
        }
        ListAdapter adapter = xListView.getAdapter();
        if (adapter != null) {
            adapter.registerDataSetObserver(this.mDataSetObserver);
            this.mIsRegister = true;
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "registerListViewDataSetChangedObserver() adapter is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromForwardTargetList(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mForwardTargetMap.remove(getForwardTargetKey(str, i3));
        refreshRightBtn();
        this.mSelectedAndSearchBar.H(new ArrayList(this.mForwardTargetMap.values()), true);
        this.unclickableSelectedUins.remove(str);
        setSearchSelectedAndJoinedUins();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWindowContent() {
        boolean z16;
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.setAlpha(0.0f);
        if (com.tencent.mobileqq.util.v.d() && com.tencent.mobileqq.util.v.b().startsWith("2.0.1")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            viewGroup.setBackgroundDrawable(new ColorDrawable(0));
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101276", false);
        if (!z16 && !isSwitchOn) {
            viewGroup.setBackgroundDrawable(null);
        }
        viewGroup.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(String str) {
        String str2;
        String str3;
        SystemBarActivityModule.isInMultiScreen();
        QQAppInterface qQAppInterface = this.app;
        String currentUin = qQAppInterface.getCurrentUin();
        if (!isMultiSelectStatus()) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        if (!this.mOnlySingleSelection) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        ReportController.n(qQAppInterface, "P_CliOper", "dc00898", currentUin, str, str, 0, 1, 0, str2, str3, "", "");
    }

    private void reportMiniAppEventByIPC(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("key_mini_report_event_action_type", str);
        bundle.putString("key_mini_report_event_sub_action_type", str2);
        bundle.putString("key_mini_report_event_reserves", str3);
        bundle.putString("key_mini_report_event_reserves2", str4);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
    }

    private void reportMiniAppShareFail() {
        switch (this.miniAppShareFrom) {
            case 10:
                reportMiniAppEventByIPC("user_click", "more_about", "share", "fail");
                return;
            case 11:
                reportMiniAppEventByIPC("user_click", "custom_button", "share_QQ", "fail");
                return;
            case 12:
                reportMiniAppEventByIPC("user_click", "more_button", "share_QQ", "fail");
                return;
            default:
                return;
        }
    }

    private void saveMultiUinAndUinTypeAndUinName(Bundle bundle) {
        if (RFSafeMapUtils.isEmpty(this.mForwardTargetMap)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        int i3 = -1;
        for (ResultRecord resultRecord : this.mForwardTargetMap.values()) {
            if (sb5.length() > 0) {
                sb5.append(",");
            }
            sb5.append(resultRecord.uin);
            if (sb6.length() > 0) {
                sb6.append(",");
            }
            sb6.append(resultRecord.name);
            i3 = resultRecord.uinType;
        }
        String sb7 = sb5.toString();
        String sb8 = sb6.toString();
        if (!TextUtils.isEmpty(sb7)) {
            bundle.putString("uin", sb7);
        }
        if (i3 != -1) {
            bundle.putInt("uintype", i3);
        }
        if (!TextUtils.isEmpty(sb8)) {
            bundle.putString("uinname", sb8);
        }
    }

    private void setDefaultThemeAnimPullUp() {
        int i3 = this.mReq;
        if (1 != i3 && 2 != i3 && 4 != i3 && 5 != i3 && i3 != 6) {
            setTheme(R.style.f173428d2);
        } else {
            setTheme(R.style.f173436d8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGridItemSelected(ResultRecord resultRecord, ForwardRecentRoundItemView forwardRecentRoundItemView, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onForwardRecentRoundItemViewClickedInMultiSelectStatus, isSelected = " + z16);
        }
        if (z16) {
            forwardRecentRoundItemView.d(false);
            removeFromForwardTargetList(resultRecord.uin, resultRecord.getUinType());
        } else if (add2ForwardTargetList(resultRecord)) {
            forwardRecentRoundItemView.d(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHasMigrate(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(str, true);
        Map<String, Boolean> map = sMigrateCache;
        if (!map.containsKey(str)) {
            map.put(str, Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListItemSelected(ResultRecord resultRecord, ForwardRecentItemView forwardRecentItemView, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onListViewItemClickedInMultiSelectStatus, isSelected = " + z16);
        }
        if (z16) {
            forwardRecentItemView.e(false);
            removeFromForwardTargetList(resultRecord.uin, resultRecord.getUinType());
        } else if (add2ForwardTargetList(resultRecord)) {
            forwardRecentItemView.e(true);
        }
    }

    private void setMatchFriendForwardMode() {
        if (this.mIsMatchFriendUserList) {
            TextView textView = this.recommendTv;
            if (textView != null) {
                textView.setText(R.string.f201044tr);
            }
            if (this.tipTv != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "mIsMatchFriendUserList && null != tipTv");
                }
                this.tipTv.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.tipLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    private void setOrientationFromParam() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(KEY_REQUEST_ORIENTATION)) {
            int intExtra = intent.getIntExtra(KEY_REQUEST_ORIENTATION, 3);
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "orientation : " + intExtra);
            }
            setRequestedOrientation(intExtra);
            return;
        }
        setRequestedOrientation(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReportParam(View view) {
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            if ((view instanceof ForwardRecentItemView) && !((ForwardRecentItemView) view).E) {
                forwardBaseOption.getExtras().putInt("via", 2);
            } else {
                forwardBaseOption.getExtras().putInt("via", 1);
            }
        }
    }

    private void setSearchSelectedAndJoinedUins() {
        List<String> selectedUins = getSelectedUins();
        com.tencent.mobileqq.search.view.f fVar = this.mSearchFragment;
        if (fVar != null) {
            fVar.B5(selectedUins, getJoinUins(selectedUins));
        }
    }

    private void setThemeFromParam() {
        Intent intent = getIntent();
        if (intent == null) {
            setDefaultThemeAnimPullUp();
        } else if (intent.getIntExtra(AppConstants.Key.FORWARD_ANIMATION_TYPE, -1) == 1) {
            setTheme(R.style.f173437a05);
        } else {
            setDefaultThemeAnimPullUp();
        }
    }

    private void setUpOrientation() {
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101114", false);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "isSupportParamOrientation : " + isSwitchOn);
        }
        if (isSwitchOn) {
            setOrientationFromParam();
        } else {
            setRequestedOrientation(3);
        }
    }

    private void setWalletPetRecentMode() {
        if (this.isWalletPetShare && this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.Y3) && this.tipTv != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isWalletPetShare && mForwardOption.isSupportAbility(ForwardAbilityType.FORWARD_ABILITY_TYPE_HIDE_CREATE_MULTI_CHAT) && tipTv != null");
            }
            this.tipTv.setVisibility(8);
        }
    }

    private void showForwardCountLimitDialog() {
        if (this.mForwardCountLimitDialog == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, (String) null, getString(R.string.fjk), (String) null, getString(R.string.cpy), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.bw
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ForwardRecentActivity.this.lambda$showForwardCountLimitDialog$3(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            this.mForwardCountLimitDialog = createCustomDialog;
            createCustomDialog.setCanceledOnTouchOutside(false);
        }
        if (!isFinishing()) {
            this.mForwardCountLimitDialog.show();
        }
    }

    private void startChatAndSendMsg() {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        Bundle bundle = new Bundle(this.mForwardOption.getExtras());
        bundle.putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
        bundle.putBoolean(PeakConstants.IS_FORWARD, true);
        bundle.putInt(PeakConstants.SEND_BUSINESS_TYPE, 1031);
        bundle.putBoolean("PicContants.NEED_COMPRESS", false);
        m3.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        m3.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        m3.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        m3.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        m3.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
        m3.putExtra("isBack2Root", false);
        m3.putExtras(bundle);
        String string = bundle.getString("GALLERY.FORWORD_LOCAL_PATH");
        ArrayList arrayList = new ArrayList();
        arrayList.add(string);
        PhotoUtils.sendPhoto(this, m3, arrayList, 0, false);
        ForwardUtils.s0(this.app, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switch2DefaultStatus(boolean z16) {
        TextView textView;
        FormItemRelativeLayout formItemRelativeLayout;
        this.mCurrentStatus = 0;
        quitSearchState();
        this.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.mpt));
        if (this.mOnlySingleSelection) {
            this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.mpt));
        } else {
            updateNavRightTextInMultiMode(false);
        }
        this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
        if (this.mStyle == 0 && !this.mIsFromZplan && !this.mIsFriendPermission) {
            this.multiChatLayout.setVisibility(0);
        }
        this.friendLayout.setVisibility(8);
        this.troopDiscussionLayout.setVisibility(8);
        if (this.mIsFromZplan && this.mOnlySingleSelection) {
            this.quiSecNavBar.setLeftType(0);
            this.quiSecNavBar.setRightType(1);
            this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.j6l));
            this.friendLayout.setVisibility(0);
        }
        if (this.mForwardOption.isSupportAbility(com.tencent.mobileqq.forward.e.R3) && !this.isShowInSare && (formItemRelativeLayout = this.qzoneLayout) != null) {
            formItemRelativeLayout.setVisibility(0);
        } else {
            FormItemRelativeLayout formItemRelativeLayout2 = this.qzoneLayout;
            if (formItemRelativeLayout2 != null) {
                formItemRelativeLayout2.setVisibility(8);
            }
        }
        clearForwardTarget();
        this.mForwardOption.removeDataInExtra(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (this.mStyle != 0 && (textView = this.tipTv) != null) {
            textView.setText(R.string.f170800zp0);
        }
        this.mListView.postDelayed(new Runnable(z16) { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.28
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f175832d;

            {
                this.f175832d = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ForwardRecentActivity.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int childCount = ForwardRecentActivity.this.mListView.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = ForwardRecentActivity.this.mListView.getChildAt(i3);
                    if (childAt instanceof ForwardRecentItemView) {
                        ForwardRecentItemView forwardRecentItemView = (ForwardRecentItemView) childAt;
                        if (this.f175832d) {
                            forwardRecentItemView.g(150L);
                        } else {
                            forwardRecentItemView.g(0L);
                        }
                    } else if (childAt instanceof ForwardRecentRoundItemView) {
                        ((ForwardRecentRoundItemView) childAt).e();
                    }
                }
                ForwardRecentActivity.this.updateHeaderItemStatus();
                if (ForwardRecentActivity.this.recentAdapter != null) {
                    ForwardRecentActivity.this.recentAdapter.p(false);
                }
                HorizontalListView horizontalListView = ForwardRecentActivity.this.horizontalListView;
                if (horizontalListView != null && horizontalListView.getAdapter() != null) {
                    ((ForwardSelectionRecentFriendGridAdapter) ForwardRecentActivity.this.horizontalListView.getAdapter()).g(false);
                }
            }
        }, 1L);
        this.mSelectedAndSearchBar.H(new ArrayList(), true);
        com.tencent.mobileqq.search.view.f fVar = this.mSearchFragment;
        if (fVar != null) {
            fVar.lf(false);
        }
        if (this.isSdkShare) {
            togglePCViewStatus(true);
        }
        if (z16) {
            this.mListView.addHeaderView(this.mForwardWechatItemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switch2MultiSelectStatus() {
        TextView textView;
        this.mCurrentStatus = 1;
        this.quiSecNavBar.setLeftText(HardCodeUtil.qqStr(R.string.cancel));
        updateNavRightTextInMultiMode(true);
        this.quiSecNavBar.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, false);
        if (this.enableHeaderViewStatusFix && this.mStyle == 0 && !this.mIsFromZplan && !this.mIsFriendPermission) {
            this.multiChatLayout.setVisibility(8);
        }
        if (this.mStyle == 0 && !this.mIsFriendPermission) {
            this.friendLayout.setVisibility(0);
        }
        this.qzoneLayout.setVisibility(8);
        if (this.mStyle == 0 && !this.mIsFromZplan && !this.mIsFriendPermission) {
            this.troopDiscussionLayout.setVisibility(0);
        }
        this.troopDiscussionLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        if (this.mStyle != 0 && (textView = this.tipTv) != null) {
            textView.setText(R.string.f170745zm3);
        }
        this.mListView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.27
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int childCount = ForwardRecentActivity.this.mListView.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = ForwardRecentActivity.this.mListView.getChildAt(i3);
                    if (childAt instanceof ForwardRecentItemView) {
                        ((ForwardRecentItemView) childAt).h(150L);
                    } else if (childAt instanceof ForwardRecentRoundItemView) {
                        ((ForwardRecentRoundItemView) childAt).f();
                    }
                }
                ForwardRecentActivity.this.updateHeaderItemStatus();
                if (ForwardRecentActivity.this.recentAdapter != null) {
                    ForwardRecentActivity.this.recentAdapter.p(true);
                }
                HorizontalListView horizontalListView = ForwardRecentActivity.this.horizontalListView;
                if (horizontalListView != null && horizontalListView.getAdapter() != null) {
                    ((ForwardSelectionRecentFriendGridAdapter) ForwardRecentActivity.this.horizontalListView.getAdapter()).g(true);
                }
            }
        }, 50L);
        this.mSelectedAndSearchBar.H(new ArrayList(this.mForwardTargetMap.values()), true);
        if (this.isSdkShare) {
            togglePCViewStatus(false);
            ForwardUtils.h0(this.app, "0X800A733", new String[0]);
        }
        this.mListView.removeHeaderView(this.mForwardWechatItemView);
        com.tencent.mobileqq.search.view.f fVar = this.mSearchFragment;
        if (fVar != null) {
            fVar.lf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncRecentChatClicked(ResultRecord resultRecord, boolean z16) {
        HorizontalListView horizontalListView;
        if (!z16 && this.mForwardTargetMap.size() == 9) {
            return;
        }
        if (this.mListView != null) {
            for (int i3 = 0; i3 < this.mListView.getChildCount(); i3++) {
                if (this.mListView.getChildAt(i3) instanceof ForwardRecentItemView) {
                    ForwardRecentItemView forwardRecentItemView = (ForwardRecentItemView) this.mListView.getChildAt(i3);
                    if (forwardRecentItemView.J.uin.equals(resultRecord.uin) && resultRecord.uinType == forwardRecentItemView.J.uinType) {
                        forwardRecentItemView.e(!z16);
                    }
                }
            }
        }
        XListView xListView = this.mListView;
        if (xListView != null && (xListView.getAdapter() instanceof com.tencent.mobileqq.adapter.n)) {
            ((com.tencent.mobileqq.adapter.n) this.mListView.getAdapter()).n(this.recentChatList);
        }
        if (this.mStyle == 2 && (horizontalListView = this.horizontalListView) != null && (horizontalListView.getAdapter() instanceof ForwardSelectionRecentFriendGridAdapter)) {
            ((ForwardSelectionRecentFriendGridAdapter) this.horizontalListView.getAdapter()).e(this.recentForwardList.subList(0, Math.min(5, this.recentForwardList.size())));
        }
    }

    private void togglePCViewStatus(boolean z16) {
        ForwardRecentItemView forwardRecentItemView = this.mForwardPcItemView;
        if (forwardRecentItemView != null) {
            if (z16) {
                this.mListView.addHeaderView(forwardRecentItemView);
            } else {
                this.mListView.removeHeaderView(forwardRecentItemView);
            }
        }
        ForwardRecentItemView forwardRecentItemView2 = this.mForwardIpadItemView;
        if (forwardRecentItemView2 != null) {
            if (z16) {
                this.mListView.addHeaderView(forwardRecentItemView2);
            } else {
                this.mListView.removeHeaderView(forwardRecentItemView2);
            }
        }
    }

    private void unregisterListViewDataSetChangedObserver() {
        ListAdapter adapter;
        if (this.mDataSetObserver == null || (adapter = this.mListView.getAdapter()) == null) {
            return;
        }
        adapter.unregisterDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeaderItemStatus() {
        updateItemViewStatus(this.mForwardPcItemView);
        updateItemViewStatus(this.mForwardIpadItemView);
        updateItemViewStatus(this.mForwardPhoneItemView);
    }

    private void updateItemViewStatus(ForwardRecentItemView forwardRecentItemView) {
        if (!this.enableHeaderViewStatusFix || forwardRecentItemView == null) {
            return;
        }
        if (isMultiSelectStatus()) {
            forwardRecentItemView.h(0L);
        } else {
            forwardRecentItemView.g(0L);
        }
    }

    private void updateNavRightTextInMultiMode(boolean z16) {
        if (z16) {
            this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.mpq));
        } else {
            this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.mpr));
        }
    }

    private void updatePhoneContactsNewFlag() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardRecentActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!ForwardRecentActivity.this.queryHasMigrate(ForwardRecentActivity.FORWARD_SHARE_CARD)) {
                    QMMKV.migrateToSpAdapter(BaseApplication.getContext(), ForwardRecentActivity.FORWARD_SHARE_CARD, "common_mmkv_configurations");
                    ForwardRecentActivity.this.setHasMigrate(ForwardRecentActivity.FORWARD_SHARE_CARD);
                }
                SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), ForwardRecentActivity.FORWARD_SHARE_CARD, "common_mmkv_configurations");
                if (fromSpAdapter == null || !fromSpAdapter.getBoolean(ForwardRecentActivity.FORWARD_SHARE_CARD, false)) {
                    return;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ForwardRecentActivity.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            if (ForwardRecentActivity.this.mEntryHeader == null) {
                                return;
                            }
                            ForwardRecentActivity.this.mEntryHeader.findViewById(R.id.dqk).setVisibility(0);
                        }
                    }
                });
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    protected void doOnActivityResult(int i3, int i16, Intent intent) {
        ArrayList<ResultRecord> arrayList;
        ForwardBaseOption forwardBaseOption;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        QLog.d(TAG, 4, "doOnActivityResult requestCode:" + i3 + ", resultCode:" + i16);
        if (i16 == -1) {
            if (i3 != 102) {
                if (i3 != 19001) {
                    if (i3 != 20005) {
                        if (i3 != 21001) {
                            switch (i3) {
                                case 20000:
                                    if (intent != null && (forwardBaseOption = this.mForwardOption) != null && forwardBaseOption.getExtras() != null) {
                                        this.mForwardOption.getExtras().putAll(intent.getExtras());
                                    }
                                    if (getIntent().getExtras().getBoolean("jump_to_mobileqq_share", false)) {
                                        setResult(10, intent);
                                    } else {
                                        setResult(-1, intent);
                                    }
                                    finish();
                                    overridePendingTransition(0, 0);
                                    return;
                                case 20001:
                                    setResult(-1, intent);
                                    finish();
                                    return;
                                case 20002:
                                    this.mForwardOption.onActivityResult(i3, i16, intent);
                                    return;
                                case 20003:
                                    if (isInterceptAndDeal(intent)) {
                                        return;
                                    }
                                    if (intent.getBooleanExtra("select_memeber_single_friend", false)) {
                                        Bundle extras = intent.getExtras();
                                        int intExtra = intent.getIntExtra("select_memeber_single_friend_type", 2);
                                        if (intExtra == 4) {
                                            intExtra = 1;
                                        }
                                        if (intExtra != 0) {
                                            i17 = intExtra;
                                        }
                                        extras.putBoolean("forward_report_confirm", true);
                                        extras.putString("forward_report_confirm_action_name", "0X8005A14");
                                        extras.putString("forward_report_confirm_reverse2", Integer.toString(i17));
                                        this.mForwardOption.buildForwardDialog(com.tencent.mobileqq.forward.e.O3.intValue(), extras);
                                        ReportCenter.f().q(this.app.getAccount(), "", this.appid, "1000", "30", "0", false, this.isSdkShare);
                                        return;
                                    }
                                    String stringExtra = intent.getStringExtra("roomId");
                                    if (!StringUtil.isEmpty(stringExtra)) {
                                        refreshRecentList();
                                        ReportController.o(this.app, "CliOper", "", "", "0X80056B0", "0X80056B0", 0, 0, "", "", "", "");
                                        int intExtra2 = intent.getIntExtra("select_memeber_discussion_memeber_count", 0);
                                        Bundle bundle = new Bundle();
                                        bundle.putBoolean("forward_report_confirm", true);
                                        bundle.putString("forward_report_confirm_action_name", "0X8005A15");
                                        bundle.putString("forward_report_confirm_reverse2", Integer.toString(intExtra2));
                                        this.mForwardOption.afterCreateDiscuss(stringExtra, intent.getStringExtra("discussName"), bundle);
                                    }
                                    ReportCenter.f().q(this.app.getAccount(), "", this.appid, "1000", "32", "0", false, this.isSdkShare);
                                    return;
                                default:
                                    return;
                            }
                        }
                        intent.putExtra("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.f307203d0);
                        if (getIntent() != null) {
                            z16 = getIntent().getBooleanExtra("choose_friend_needConfirm", false);
                        }
                        if (z16) {
                            String stringExtra2 = getIntent().getStringExtra("choose_friend_confirmTitle");
                            String stringExtra3 = getIntent().getStringExtra("choose_friend_confirmContent");
                            intent.putExtra("choose_friend_needConfirm", z16);
                            intent.putExtra("choose_friend_confirmTitle", stringExtra2);
                            intent.putExtra("choose_friend_confirmContent", stringExtra3);
                        }
                        SearchUtil.h(intent, this.mForwardOption);
                        return;
                    }
                    setResult(-1, intent);
                    finish();
                    if (!this.mJumpQzoneShuoshuoDirect) {
                        cb.b();
                        return;
                    }
                    return;
                }
                this.mForwardOption.onActivityResult(i3, i16, intent);
                return;
            }
            this.mForwardOption.onActivityResult(i3, i16, intent);
            return;
        }
        if (i16 == 1) {
            if (20000 == i3) {
                setResult(-1, intent);
                finish();
                return;
            }
            return;
        }
        if (20000 == i3 && i16 != -1) {
            if (this.isForConfessDirectFriends) {
                finish();
                return;
            }
            if (i16 == 0) {
                if (intent != null) {
                    arrayList = intent.getParcelableArrayListExtra("selected_target_list");
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    Gson gson = new Gson();
                    Map map = (Map) gson.fromJson(gson.toJson(this.mForwardTargetMap), new d().getType());
                    this.mForwardTargetMap.clear();
                    if (arrayList.isEmpty()) {
                        this.mSelectedAndSearchBar.H(arrayList, false);
                        Iterator it = map.values().iterator();
                        while (it.hasNext()) {
                            syncRecentChatClicked((ResultRecord) it.next(), true);
                        }
                        this.recentAdapter.notifyDataSetChanged();
                        refreshRightBtn();
                    } else {
                        Collections.sort(arrayList, new ResultRecord.DefaultComparator());
                        for (ResultRecord resultRecord : arrayList) {
                            add2ForwardTargetList(resultRecord);
                            syncRecentChatClicked(resultRecord, false);
                        }
                        for (ResultRecord resultRecord2 : map.values()) {
                            if (!arrayList.contains(resultRecord2)) {
                                syncRecentChatClicked(resultRecord2, true);
                            }
                        }
                        this.recentAdapter.notifyDataSetChanged();
                    }
                    ForwardRecentItemView forwardRecentItemView = this.mForwardPcItemView;
                    if (forwardRecentItemView != null) {
                        forwardRecentItemView.e(isForwardTargetSelected(AppConstants.DATALINE_PC_UIN, 6000));
                    }
                    ForwardRecentItemView forwardRecentItemView2 = this.mForwardIpadItemView;
                    if (forwardRecentItemView2 != null) {
                        forwardRecentItemView2.e(isForwardTargetSelected(AppConstants.DATALINE_IPAD_UIN, 6003));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (i16 == 0 && this.mJumpQzoneShuoshuoDirect && i3 == 20005) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (!isFinishing()) {
            this.mForwardOption.endForwardCallback(false);
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
        }
        setResult(0);
        super.doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = false;
        if (checkIntentDataIllegal()) {
            QLog.e(TAG, 1, "doOnCreate intent data illegal");
            finish();
            return true;
        }
        QLog.i(TAG, 2, "doOnCreate isEnableArgus:" + this.isEnableArgus);
        setThemeFromParam();
        super.doOnCreate(bundle);
        setUpOrientation();
        this.topayManager = (IToPayManager) QRoute.api(IToPayManager.class);
        this.app.addObserver(this.friendListObserver);
        this.app.addObserver(this.troopMngObserver);
        this.app.addObserver(this.troopObserver);
        this.app.addObserver(this.mInitObserver);
        this.app.addObserver(this.mAvatarZPlanObserver);
        this.app.addObserver(this.mFriendObserver);
        setContentView(R.layout.f167972o7);
        return doOnCreate_init(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0290 A[Catch: Exception -> 0x02d8, TryCatch #0 {Exception -> 0x02d8, blocks: (B:32:0x00ef, B:34:0x0104, B:35:0x0106, B:37:0x0143, B:38:0x0149, B:41:0x014f, B:43:0x0153, B:45:0x015b, B:47:0x0166, B:48:0x0168, B:52:0x01e2, B:53:0x01e4, B:55:0x01ef, B:56:0x01f8, B:58:0x0203, B:59:0x0205, B:62:0x0235, B:64:0x023d, B:68:0x024a, B:72:0x025c, B:74:0x0269, B:75:0x026c, B:77:0x0270, B:79:0x0276, B:81:0x027e, B:82:0x0286, B:83:0x0288, B:85:0x028c, B:86:0x0293, B:88:0x02a9, B:89:0x02b3, B:92:0x02bc, B:94:0x02c0, B:95:0x02d0, B:97:0x02d4, B:129:0x02b9, B:130:0x0290), top: B:31:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0269 A[Catch: Exception -> 0x02d8, TryCatch #0 {Exception -> 0x02d8, blocks: (B:32:0x00ef, B:34:0x0104, B:35:0x0106, B:37:0x0143, B:38:0x0149, B:41:0x014f, B:43:0x0153, B:45:0x015b, B:47:0x0166, B:48:0x0168, B:52:0x01e2, B:53:0x01e4, B:55:0x01ef, B:56:0x01f8, B:58:0x0203, B:59:0x0205, B:62:0x0235, B:64:0x023d, B:68:0x024a, B:72:0x025c, B:74:0x0269, B:75:0x026c, B:77:0x0270, B:79:0x0276, B:81:0x027e, B:82:0x0286, B:83:0x0288, B:85:0x028c, B:86:0x0293, B:88:0x02a9, B:89:0x02b3, B:92:0x02bc, B:94:0x02c0, B:95:0x02d0, B:97:0x02d4, B:129:0x02b9, B:130:0x0290), top: B:31:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0270 A[Catch: Exception -> 0x02d8, TryCatch #0 {Exception -> 0x02d8, blocks: (B:32:0x00ef, B:34:0x0104, B:35:0x0106, B:37:0x0143, B:38:0x0149, B:41:0x014f, B:43:0x0153, B:45:0x015b, B:47:0x0166, B:48:0x0168, B:52:0x01e2, B:53:0x01e4, B:55:0x01ef, B:56:0x01f8, B:58:0x0203, B:59:0x0205, B:62:0x0235, B:64:0x023d, B:68:0x024a, B:72:0x025c, B:74:0x0269, B:75:0x026c, B:77:0x0270, B:79:0x0276, B:81:0x027e, B:82:0x0286, B:83:0x0288, B:85:0x028c, B:86:0x0293, B:88:0x02a9, B:89:0x02b3, B:92:0x02bc, B:94:0x02c0, B:95:0x02d0, B:97:0x02d4, B:129:0x02b9, B:130:0x0290), top: B:31:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x028c A[Catch: Exception -> 0x02d8, TryCatch #0 {Exception -> 0x02d8, blocks: (B:32:0x00ef, B:34:0x0104, B:35:0x0106, B:37:0x0143, B:38:0x0149, B:41:0x014f, B:43:0x0153, B:45:0x015b, B:47:0x0166, B:48:0x0168, B:52:0x01e2, B:53:0x01e4, B:55:0x01ef, B:56:0x01f8, B:58:0x0203, B:59:0x0205, B:62:0x0235, B:64:0x023d, B:68:0x024a, B:72:0x025c, B:74:0x0269, B:75:0x026c, B:77:0x0270, B:79:0x0276, B:81:0x027e, B:82:0x0286, B:83:0x0288, B:85:0x028c, B:86:0x0293, B:88:0x02a9, B:89:0x02b3, B:92:0x02bc, B:94:0x02c0, B:95:0x02d0, B:97:0x02d4, B:129:0x02b9, B:130:0x0290), top: B:31:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02a9 A[Catch: Exception -> 0x02d8, TryCatch #0 {Exception -> 0x02d8, blocks: (B:32:0x00ef, B:34:0x0104, B:35:0x0106, B:37:0x0143, B:38:0x0149, B:41:0x014f, B:43:0x0153, B:45:0x015b, B:47:0x0166, B:48:0x0168, B:52:0x01e2, B:53:0x01e4, B:55:0x01ef, B:56:0x01f8, B:58:0x0203, B:59:0x0205, B:62:0x0235, B:64:0x023d, B:68:0x024a, B:72:0x025c, B:74:0x0269, B:75:0x026c, B:77:0x0270, B:79:0x0276, B:81:0x027e, B:82:0x0286, B:83:0x0288, B:85:0x028c, B:86:0x0293, B:88:0x02a9, B:89:0x02b3, B:92:0x02bc, B:94:0x02c0, B:95:0x02d0, B:97:0x02d4, B:129:0x02b9, B:130:0x0290), top: B:31:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02c0 A[Catch: Exception -> 0x02d8, TryCatch #0 {Exception -> 0x02d8, blocks: (B:32:0x00ef, B:34:0x0104, B:35:0x0106, B:37:0x0143, B:38:0x0149, B:41:0x014f, B:43:0x0153, B:45:0x015b, B:47:0x0166, B:48:0x0168, B:52:0x01e2, B:53:0x01e4, B:55:0x01ef, B:56:0x01f8, B:58:0x0203, B:59:0x0205, B:62:0x0235, B:64:0x023d, B:68:0x024a, B:72:0x025c, B:74:0x0269, B:75:0x026c, B:77:0x0270, B:79:0x0276, B:81:0x027e, B:82:0x0286, B:83:0x0288, B:85:0x028c, B:86:0x0293, B:88:0x02a9, B:89:0x02b3, B:92:0x02bc, B:94:0x02c0, B:95:0x02d0, B:97:0x02d4, B:129:0x02b9, B:130:0x0290), top: B:31:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02d4 A[Catch: Exception -> 0x02d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x02d8, blocks: (B:32:0x00ef, B:34:0x0104, B:35:0x0106, B:37:0x0143, B:38:0x0149, B:41:0x014f, B:43:0x0153, B:45:0x015b, B:47:0x0166, B:48:0x0168, B:52:0x01e2, B:53:0x01e4, B:55:0x01ef, B:56:0x01f8, B:58:0x0203, B:59:0x0205, B:62:0x0235, B:64:0x023d, B:68:0x024a, B:72:0x025c, B:74:0x0269, B:75:0x026c, B:77:0x0270, B:79:0x0276, B:81:0x027e, B:82:0x0286, B:83:0x0288, B:85:0x028c, B:86:0x0293, B:88:0x02a9, B:89:0x02b3, B:92:0x02bc, B:94:0x02c0, B:95:0x02d0, B:97:0x02d4, B:129:0x02b9, B:130:0x0290), top: B:31:0x00ef }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doOnCreate_init(Bundle bundle) {
        com.tencent.mobileqq.forward.e eVar;
        boolean z16;
        long longExtra;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle)).booleanValue();
        }
        ForwardBaseOption d16 = com.tencent.mobileqq.forward.k.d(getIntent(), this.app, this);
        this.mForwardOption = d16;
        if (d16 != null) {
            d16.getForwardAbility();
            if (isFinishing()) {
                QLog.d(TAG, 1, "-->doOnCreate_init--isFinishing");
                return false;
            }
            this.mStyle = 2;
            this.mForwardOption.reportShowForwardRecent();
            Intent intent = getIntent();
            this.isShowInSare = intent.getBooleanExtra(FORWARD_ABILITY_ENTRENCE_SHOW_IN_SHARE, false);
            this.mIsFromWeb = intent.getBooleanExtra("isWebCompShare", false);
            this.mIsForConfess = intent.getBooleanExtra("choose_friend_isForConfess", false);
            this.mNeedShareCallback = intent.getBooleanExtra("needShareCallBack", false);
            this.miniAppShareFrom = intent.getIntExtra("miniAppShareFrom", -1);
            this.mNeedShowDirectShareTips = intent.getBooleanExtra(KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS, false);
            this.mJumpQzoneShuoshuoDirect = intent.getBooleanExtra(KEY_DIRECT_JUMP_QZONE_SHUOSHUO, false);
            int i16 = this.miniAppShareFrom;
            boolean z17 = i16 == 10;
            this.mIsFromMini = z17;
            boolean z18 = z17 || i16 == 11;
            this.mIsFromMini = z18;
            this.mIsFromMini = z18 || i16 == 12;
            this.mIsShowWechatEntrance = intent.getBooleanExtra(AppConstants.Key.FORWARD_SHOW_WECHAT_ENTRANCE, false);
            QLog.i(TAG, 1, "mIsShowWechatEntrance: " + this.mIsShowWechatEntrance);
            if (this.mJumpQzoneShuoshuoDirect) {
                cb.a(this.app, this, intent, intent.getStringExtra(KEY_FORWARD_BUSINESS_ID), intent.hasExtra("file_send_path"));
                QLog.d(TAG, 1, "-->doOnCreate_init--mJumpQzoneShuoshuoDirect==true");
                return true;
            }
            try {
                this.uinType = intent.getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, 0);
                this.dataUri = intent.getData();
                if (intent.getIntExtra("forward_type", -1) == 11) {
                    this.isSdkShare = true;
                }
                this.fromPkgName = intent.getStringExtra("pkg_name");
                long longExtra2 = intent.getLongExtra("req_share_id", 0L);
                this.mCallActivity = getIntent().getStringExtra("caller_name");
                this.mIsFromShare = getIntent().getBooleanExtra("isFromShare", false);
                this.mIsFromDatalineAIO = getIntent().getBooleanExtra("isFromDataLineAIO", false);
                if (longExtra2 > 0) {
                    this.appid = String.valueOf(longExtra2);
                }
                if (!this.mIsFromShare && (longExtra2 > 0 || this.isSdkShare || (!TextUtils.isEmpty(this.fromPkgName) && !this.fromPkgName.equals("com.tencent.mobileqq")))) {
                    this.mIsFromShare = true;
                }
                QLog.d(TAG, 1, "-->doOnCreate_init--isSdkShare=", Boolean.valueOf(this.isSdkShare), ", pkgName=", this.fromPkgName, ", appid=", this.appid, ", isFromWeb=" + this.mIsFromWeb + ", isFromShare=" + this.mIsFromShare + ", isFromDatalineAIO=" + this.mIsFromDatalineAIO + ", enableHeaderViewStatusFix=" + this.enableHeaderViewStatusFix);
                initSelectMode(intent);
                this.mBusinessType = intent.getIntExtra("choose_friend_businessType", 0);
                int intExtra = intent.getIntExtra("choose_friend_businessSubType", 0);
                this.mBusinessSubType = intExtra;
                if (this.mBusinessType == 1 && intExtra > 0 && intExtra < 3) {
                    this.mIsToPayList = true;
                }
                boolean booleanExtra = intent.getBooleanExtra(KEY_FORWARD_SHARE_FROM_ZPLAN, false);
                this.mIsFromZplan = booleanExtra;
                if (booleanExtra) {
                    this.appid = intent.getStringExtra(KEY_FORWARD_SHARE_FROM_ZPLAN_APPID);
                }
                boolean booleanExtra2 = intent.getBooleanExtra(KEY_FORWARD_FROM_FRIEND_PERMISSION, false);
                this.mIsFriendPermission = booleanExtra2;
                if (booleanExtra2) {
                    this.mStyle = 0;
                }
                this.mIsMatchFriendUserList = intent.getBooleanExtra(KEY_FORWARD_SHARE_MATCH_FRIEND_LIST, false);
                this.mIsShowRecentForwardList = intent.getBooleanExtra(KEY_IS_SHOW_RECENT_FORWARD_LIST, true);
                this.mIsShowRecentChatList = intent.getBooleanExtra(KEY_IS_SHOW_RECENT_CHAT_LIST, true);
                this.mIsFinishWhenMultiSelect = intent.getBooleanExtra("key_forward_finish_when_multi_select", false);
                this.isWalletPetShare = intent.getIntExtra("forward_type", -1) == 1059;
                eVar = this.mForwardOption;
            } catch (Exception e16) {
                QLog.d(TAG, 1, "exception in ForwardRecentActivity", e16);
                finish();
            }
            if (!((eVar instanceof com.tencent.mobileqq.forward.al) && ((com.tencent.mobileqq.forward.al) eVar).b()) && !((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).checkShowShareGuildEntrance(intent)) {
                z16 = false;
                this.mIsShowGuildEntrance = z16;
                initViews();
                if (this.app.getCurrentAccountUin() == null) {
                    finish();
                }
                if (this.mIsFromZplan) {
                    ForwardBaseOption forwardBaseOption = this.mForwardOption;
                    if (forwardBaseOption instanceof ForwardZPlanShareOption) {
                        if (!((ForwardZPlanShareOption) forwardBaseOption).m()) {
                            this.mForwardOption.showProgressDialog(R.string.kug);
                        }
                        this.mStyle = 0;
                    }
                }
                if (!this.mIsToPayList) {
                    refreshRecommendList(true);
                } else {
                    refreshRecentList();
                }
                this.mForwardOption.preForward();
                initSelectedForwardTarget(intent);
                adjustEntryLayout();
                longExtra = intent.getLongExtra(AppConstants.Key.FORWARD_SEND_TO_UIN, 0L);
                if (longExtra != 0) {
                    showForwardDialog(longExtra, intent.getStringExtra(AppConstants.Key.FORWARD_SEND_TO_UIN_NICKNAME));
                }
                i3 = this.mReq;
                if (1 != i3 || 2 == i3) {
                    registerListViewDataSetChangedObserver();
                }
                if (3 == this.mReq) {
                    this.mForwardOption.forwardDirectly(getIntent().getStringExtra("direct_show_msg"));
                }
                if (this.mReq == 6) {
                    forward2MultiTargets();
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("StructingMsgItemBuildertime", 4, "zhuanfa end:" + System.currentTimeMillis());
                }
                if (this.mIsToPayList) {
                    int i17 = this.mBusinessType;
                    if (i17 == 1 && this.mBusinessSubType == 1) {
                        ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.buyerselectpage.show", 0, 0, "", "", "", "");
                    } else if (i17 == 1 && this.mBusinessSubType == 2) {
                        ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "autofriendpay.payerselectpage.show", 0, 0, "", "", "", "");
                    }
                }
                if (intent.getBooleanExtra(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
                    ReportController.o(this.app, "dc00898", "", "", "0X8009F7A", "0X8009F7A", 0, 0, "", "", "", "");
                }
                if (this.mIsForConfess) {
                    this.isForConfessDirectFriends = true;
                    Intent intent2 = new Intent();
                    intent2.putExtra("call_by_forward", true);
                    Uri uri = this.dataUri;
                    if (uri != null) {
                        intent2.setData(uri);
                    }
                    intent2.putExtras(this.mForwardOption.getExtras());
                    intent2.putExtras(intent.getExtras());
                    intent2.putExtra("extra_forward_title", this.mForwardOption.getTitle());
                    intent2.setClass(this, ForwardFriendListActivity.class);
                    intent2.putExtra("extra_choose_friend", 5);
                    startActivityForResult(intent2, 20000);
                }
                ((SystemBarActivityModule) getModule(SystemBarActivityModule.class)).correctStatusBarHeight();
                report("0X800C011");
                this.mForwardOption.onActivityCreated();
                if (this.mIsFriendPermission) {
                    switch2MultiSelectStatus();
                }
                if (this.mIsMatchFriendUserList) {
                    switch2MultiSelectStatus();
                }
                return true;
            }
            z16 = true;
            this.mIsShowGuildEntrance = z16;
            initViews();
            if (this.app.getCurrentAccountUin() == null) {
            }
            if (this.mIsFromZplan) {
            }
            if (!this.mIsToPayList) {
            }
            this.mForwardOption.preForward();
            initSelectedForwardTarget(intent);
            adjustEntryLayout();
            longExtra = intent.getLongExtra(AppConstants.Key.FORWARD_SEND_TO_UIN, 0L);
            if (longExtra != 0) {
            }
            i3 = this.mReq;
            if (1 != i3) {
            }
            registerListViewDataSetChangedObserver();
            if (3 == this.mReq) {
            }
            if (this.mReq == 6) {
            }
            if (QLog.isDevelopLevel()) {
            }
            if (this.mIsToPayList) {
            }
            if (intent.getBooleanExtra(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
            }
            if (this.mIsForConfess) {
            }
            ((SystemBarActivityModule) getModule(SystemBarActivityModule.class)).correctStatusBarHeight();
            report("0X800C011");
            this.mForwardOption.onActivityCreated();
            if (this.mIsFriendPermission) {
            }
            if (this.mIsMatchFriendUserList) {
            }
            return true;
        }
        QLog.d(TAG, 1, "-->doOnCreate_init--mForwardOption == null");
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).clearExpandGuildList();
        this.app.removeObserver(this.friendListObserver);
        this.app.removeObserver(this.troopMngObserver);
        this.app.removeObserver(this.troopObserver);
        this.app.removeObserver(this.mInitObserver);
        this.app.removeObserver(this.mAvatarZPlanObserver);
        this.app.removeObserver(this.mFriendObserver);
        if (this.mIsToPayList) {
            this.topayManager.removeObserver(this.app);
        }
        int i3 = this.mReq;
        if (1 == i3 || 2 == i3) {
            try {
                unregisterListViewDataSetChangedObserver();
            } catch (IllegalStateException unused) {
            }
        }
        com.tencent.mobileqq.adapter.n nVar = this.recentAdapter;
        if (nVar != null) {
            nVar.destroy();
            this.mListView.setAdapter((ListAdapter) null);
        }
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.onDestroy();
        }
        BroadcastReceiver broadcastReceiver = this.qqBroadcastReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.bindFinishReceiver;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
        }
        IFaceDecoder iFaceDecoder = this.mFaceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        ArrayList<String> stringArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ForwardOption.ForwardEntranceActivity onNewIntent()");
        }
        boolean z16 = false;
        if (intent.getBooleanExtra(PeakConstants.SEND_FLAG, false) && (stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS")) != null && !stringArrayListExtra.isEmpty()) {
            String str = stringArrayListExtra.get(0);
            Bundle extras = this.mForwardOption.getExtras();
            int i3 = extras.getInt("key_forward_ability_type", 0);
            String string = extras.getString("uin");
            int i16 = extras.getInt("uintype", -1);
            String string2 = extras.getString("troop_uin");
            extras.getString("uinname");
            boolean z17 = extras.getBoolean(AppConstants.Key.FORWARD_IS_QZONE_SHARE);
            boolean z18 = true;
            extras.putBoolean(AppConstants.Key.FORWARD_IS_EDITED, true);
            if (z17) {
                if (i3 != com.tencent.mobileqq.forward.e.S3.intValue() && i3 != com.tencent.mobileqq.forward.e.X3.intValue() && i3 != com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
                    if (i3 == com.tencent.mobileqq.forward.e.T3.intValue()) {
                        this.mForwardOption.getExtras().putString(AppConstants.Key.FORWARD_FILEPATH, str);
                        this.mForwardOption.getExtras().putString("GALLERY.FORWORD_LOCAL_PATH", str);
                        this.mForwardOption.forwardToFavorite();
                        z16 = true;
                    } else {
                        z18 = ForwardSendPicUtil.c(this.app, str, string, i16, string2, true, this);
                    }
                } else {
                    LiteActivity.C4(this.app, str, this);
                }
                if (z18) {
                    setResult(-1);
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "failed to send pic from qzone");
                }
                if (!z16) {
                    finish();
                    return;
                }
                return;
            }
            if (i3 != com.tencent.mobileqq.forward.e.S3.intValue() && i3 != com.tencent.mobileqq.forward.e.X3.intValue() && i3 != com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
                if (i3 == com.tencent.mobileqq.forward.e.T3.intValue()) {
                    this.mForwardOption.getExtras().putString(AppConstants.Key.FORWARD_FILEPATH, str);
                    this.mForwardOption.getExtras().putString("GALLERY.FORWORD_LOCAL_PATH", str);
                    this.mForwardOption.forwardToFavorite();
                    return;
                } else {
                    this.mForwardOption.getExtras().putString("GALLERY.FORWORD_LOCAL_PATH", str);
                    startChatAndSendMsg();
                    ReportController.o(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
                    return;
                }
            }
            this.mForwardOption.getExtras().putString(AppConstants.Key.FORWARD_EXTRA, str);
            this.mForwardOption.forwardToDataLine(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.doOnPause();
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
            return;
        }
        super.doOnRestoreInstanceState(bundle);
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.doOnRestoreInstanceState(bundle);
        }
        quitSearchState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnResume();
        if (com.tencent.mobileqq.startup.a.f289664e > 0) {
            Log.d("AutoMonitor", "actStartSel, cost=" + (SystemClock.uptimeMillis() - com.tencent.mobileqq.startup.a.f289664e));
        }
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
            return;
        }
        super.doOnSaveInstanceState(bundle);
        ForwardBaseOption forwardBaseOption = this.mForwardOption;
        if (forwardBaseOption != null) {
            forwardBaseOption.doOnSaveInstanceState(bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        attachQCircleReportParam(false);
        attachSelectedParam();
        notifyResultReceiver(getIntent(), this);
        super.finish();
        overridePendingTransition(0, R.anim.f154423k);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isCloneInflaterInSubThreadEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isEnableArgus;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateLayoutInflaterEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isEnableArgus;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateResourceEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isDelegateResourceEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 20002) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    protected boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (this.mSearchResultLayout.getVisibility() != 8) {
            quitSearchState();
            return true;
        }
        if (this.mSelectedAndSearchBar.E()) {
            quitSearchState();
        }
        if (this.mNeedShareCallback) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_FAIL_CALLBACK, null, null);
        }
        reportMiniAppShareFail();
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected void onListViewItemClickedInDefaultStatus(View view) {
        ResultRecord resultRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
            return;
        }
        if (launchNewSharePanel()) {
            com.tencent.mobileqq.sharepanel.f createSharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(this, "debug1");
            final Intent intent = getIntent();
            createSharePanel.k0(new com.tencent.mobileqq.sharepanel.n() { // from class: com.tencent.mobileqq.activity.bx
                @Override // com.tencent.mobileqq.sharepanel.n
                public final void a(ArrayList arrayList, com.tencent.mobileqq.sharepanel.m mVar) {
                    mVar.a(intent);
                }
            });
            createSharePanel.show();
            return;
        }
        reportDataForBusiness("0X8007827");
        if (view instanceof ForwardRecentItemView) {
            resultRecord = ((ForwardRecentItemView) view).J;
        } else if (view instanceof ForwardRecentRoundItemView) {
            resultRecord = ((ForwardRecentRoundItemView) view).F;
        } else {
            resultRecord = null;
        }
        if (resultRecord == null) {
            QLog.e(TAG, 1, "onListViewItemClickedInDefaultStatus fail, resultRecord is null");
            return;
        }
        if (!AppConstants.DATALINE_PC_UIN.equals(resultRecord.uin) && !AppConstants.DATALINE_IPAD_UIN.equals(resultRecord.uin) && !AppConstants.DATALINE_PHONE_UIN.equals(resultRecord.uin)) {
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(resultRecord.uin)) {
                onFileAssistantItemClickedInDefaultStatus(resultRecord, view);
                return;
            }
            if (resultRecord.uinType == 10027) {
                forwardToGuildFeeds(resultRecord.uin);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[FORWARD_SHOW_DIALOG]invoke openForwardDialog uin=" + com.tencent.mobileqq.qcall.g.b(resultRecord.uin));
            }
            openForwardDialog(resultRecord, view);
            return;
        }
        openDataLineForwardDialog(resultRecord.uin, resultRecord.getUinType());
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.IToPayManager.a
    public void onRefreshTopayList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            refreshRecommendList(false);
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onResume();
        }
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        try {
            super.onStop();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onStop exception: ", e16);
        }
    }

    protected void refreshRecommendList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        if (isFinishing()) {
            return;
        }
        refreshForwardList(z16);
        com.tencent.mobileqq.adapter.n nVar = this.recentAdapter;
        if (nVar == null) {
            com.tencent.mobileqq.adapter.n nVar2 = new com.tencent.mobileqq.adapter.n(this, this.app, this.mListView, this.recentChatList, this.mForwardRecentListAdapterCallback);
            this.recentAdapter = nVar2;
            this.mListView.setAdapter((ListAdapter) nVar2);
            return;
        }
        nVar.n(this.recentChatList);
    }

    public void reportDataForBusiness(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else if (getIntent().getBooleanExtra("forward_source_from_shoot_quick", false)) {
            ReportController.o(this.app, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
    }

    public void showForwardDialog(long j3, String str) {
        Bundle bundle;
        Bundle bundle2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), str);
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putInt("uintype", 0);
        bundle2.putString("uin", j3 + "");
        if (str != null) {
            bundle2.putString("uinname", str);
        }
        this.mForwardOption.buildForwardDialog(com.tencent.mobileqq.forward.e.N3.intValue(), bundle2);
        this.mForwardOption.reportForward();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }
}
