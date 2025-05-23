package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.search.model.r;
import com.tencent.mobileqq.search.model.s;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.bean.InviteToTroopParam;
import com.tencent.qqnt.bean.InviteToTroopUserInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
@RoutePage(desc = "\u9009\u4eba\u5668", path = RouterConstants.UI_ROUTE_SELECTMEMBER)
/* loaded from: classes18.dex */
public class SelectMemberActivity extends QBaseActivity implements View.OnClickListener, com.tencent.mobileqq.search.view.d, ITroopCreateInfoService.a, ISelectMemberActivityConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String FRIEND_TEAM_ID = "friend_team_id";
    public static final String GROUP_MEMBER_COUNT = "group_member_type";
    public static final String GROUP_NAME = "group_name";
    public static final String GROUP_TYPE = "group_type";
    public static final String GROUP_UIN = "group_uin";
    public static final int HEADER_TROOP_MEMBER_NOT_ALLOW_CREATE_DISCUSSION = 1000;
    private static final int ICON_BACK_SIZE = 24;
    private static final String INDEX_NOT_ADMIN_INVITE_MEMBER_COUNT = "not_admin_invite_member_count";
    private static final int MSG_INIT_DATA = 1000;
    public static final String NEED_CLOSE_WHEN_PSTN_CLOSE = "NEED_CLOSE_WHEN_PSTN_CLOSE";
    private static final int NOT_ADMIN_INVITE_MEMBER_MAX_COUNT = 3;
    static final int PAGE_CONTACTS_LIST = 1;
    public static final int PAGE_DISCUSSION_MEMBER_LIST = 7;
    static final int PAGE_FRIEND_LIST = 5;
    static final int PAGE_FRIEND_TEAM_LIST = 0;
    public static final int PAGE_FRIENT_TEAN_SELECT = 8;
    static final int PAGE_RECENT_MEMBER_LIST = 4;
    public static final int PAGE_TROOP_BATCH_ADD_FRDS_LIST = 9;
    static final int PAGE_TROOP_DISCUSSION_LIST = 3;
    static final int PAGE_TROOP_LIST = 2;
    public static final int PAGE_TROOP_MEMBER_LIST = 6;
    public static final String PARAMR_ADMIN_GVIDEO_ROOM_NUM = "PARAMR_ADMIN_GVIDEO_ROOM_NUM";
    public static final int REQUEST_CODE_QQSTORY_CREATE_SHARE_GROUP = 10001;
    public static final int REQUEST_CODE_SELECT_HISTORY = 10002;
    public static final int REQUEST_CODE_UNITED_VERIFY_MSG_EDIT = 10;
    static final String TAG = "SelectMemberActivity";
    protected static final int addReqError = 1;
    protected static final int addReqOK = 0;
    protected static final int refreshGridView = 2;
    public static boolean sNeedBlockDiscussSelfInviteMsg;
    protected AppInterface app;
    com.tencent.mobileqq.search.view.f contactSearchFragment;
    private DiscussRunnable discussRunnable;
    private boolean enableSearchDefaultSingleModeByConfig;
    InputMethodManager imm;
    boolean isClosed;
    public boolean isStoryNotSee;
    public boolean isSupportSelectFriendGroup;
    long lastCreateTimeStamp;
    public int lastInerFrame;
    boolean mAddPassedMembersToResultSet;
    private Drawable mAnimationDrawable;
    private com.tencent.mobileqq.avatar.observer.a mAvatarObserver;
    int mBackButtonSide;
    protected Button mCreateTroopButton;
    protected View mCreateTroopButtonLayout;
    Bitmap mDefaultAvatar;
    protected float mDensity;
    private com.tencent.mobileqq.discussion.observer.a mDiscussionObserver;
    String mDoneBtnText;
    String mDoneBtnText_x;
    boolean mDonotNeedContacts;
    boolean mDonotNeedDiscussion;
    boolean mDonotNeedTroop;
    int mEnterAnimation;
    protected int mEntrance;
    int mExitAnimation;
    IFaceDecoder mFaceDecoder;
    public boolean mFilterRobot;
    protected int mFrom;
    protected TextView mGVideoTextView;
    String mGroupCode;
    ArrayList<TroopMemberInfo> mGroupmembers;
    final Handler mHandler;
    protected InnerFrameManager mInnerFrameManager;
    protected Intent mIntent;
    private Runnable mInviteMiniCallback;
    protected long mInviteNoAuthLimitNum;
    String mInviteSuccToastWording;
    protected InviteWithMsgGroup mInviteWithMsgGroup;
    protected List<String> mInvitedUinList;
    private boolean mInviting;
    public boolean mIsForbidOnlyChooseMySelf;
    protected boolean mIsLimitToInviteByTroopMaxLimit;
    public boolean mIsNeedSendIsResumeBroadcast;
    public boolean mIsPutMySelfFirst;
    protected boolean mIsSelectAllMembers;
    private boolean mIsShowDoneButtonInBottom;
    boolean mIsSoftInputShowing;
    protected boolean mIsTroopAdmin;
    protected TextView mLeftBackBtn;
    protected TextView mLeftCancelBtn;
    protected LinearLayout mListPanel;
    protected int mMaxSelectNumber;
    protected int mMinSelectNumber;
    private boolean mModeMulti;
    private Button mMultiAddBtn;
    private View mMultiAddContainerV;
    View mMultiSearchView;
    p mOnSelectStateChangeListener;
    boolean mOnlyDiscussionMember;
    boolean mOnlyFaceToFaceTroop;
    boolean mOnlyFriends;
    boolean mOnlySelectTroopOrDiscussionMember;
    boolean mOnlyTroopMember;
    boolean mOverloadTipsIncludeDefaultCount;
    private long mOverloadToastLastShowTime;
    protected QQProgressDialog mQQProgressDialog;
    protected QQToastNotifier mQQTH;
    protected ArrayList<ResultRecord> mResultList;
    protected TextView mRightBtn;
    protected View mSearchResultLayout;
    protected boolean mSearchTextEmpty;
    protected SelectedAndSearchBar mSelectedAndSearchBar;
    private SelectedAndSearchBar.i mSelectedAndSearchBarCallback;
    protected boolean mShowMyself;
    protected int mSubType;
    protected TextView mTitle;
    protected View mTitleBar;
    String mTitleString;
    private IToPayManager mToPayManagerApi;
    protected View mTooManyMembersTipsBar;
    protected View mTooManyMembersTipsClose;
    public ArrayList<String> mTopayTips;
    protected Bitmap mTransparentFace;
    private com.tencent.mobileqq.troop.troopmanager.api.b mTroopManagerBizObserver;
    protected int mTroopMemberNum;
    protected int mType;
    public ArrayList<String> mUinsSelectedDefault;
    public ArrayList<String> mUinsSelectedFriends;
    public ArrayList<String> mUinsToHide;
    private int mUnblessedUinCount;
    private int mWebUinCount;
    String mYellowTipsWording;
    boolean needShowYellowTips;
    private List<String> unclickableSelectedUins;
    private BroadcastReceiver videoMsgReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.selectmember.SelectMemberActivity$11, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass11 implements IRelationNTUinAndUidApi.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f285694a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f285695b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f285696c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f285697d;

        AnonymousClass11(HashMap hashMap, List list, List list2, List list3) {
            this.f285694a = hashMap;
            this.f285695b = list;
            this.f285696c = list2;
            this.f285697d = list3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SelectMemberActivity.this, hashMap, list, list2, list3);
            }
        }

        @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.c
        public void a(Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            for (String str : map.keySet()) {
                InviteToTroopUserInfo inviteToTroopUserInfo = (InviteToTroopUserInfo) this.f285694a.get(str);
                if (inviteToTroopUserInfo != null) {
                    inviteToTroopUserInfo.e(map.get(str));
                }
            }
            if (QLog.isDebugVersion()) {
                QLog.d(SelectMemberActivity.TAG, 4, "[inviteUserToGroup] onFetchUidUinMap uins.size:" + this.f285695b.size() + ", map.size:" + map.size());
            }
            SelectMemberActivity.this.mInviting = true;
            SelectMemberActivity.this.reportInviteFriend("Clk_invite");
            InviteToTroopParam inviteToTroopParam = new InviteToTroopParam();
            inviteToTroopParam.troopUin = SelectMemberActivity.this.mGroupCode;
            inviteToTroopParam.invitedUserList.addAll(this.f285696c);
            List list = this.f285697d;
            if (list != null) {
                inviteToTroopParam.historyMsgList.addAll(list);
            }
            ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).inviteToGroup(inviteToTroopParam, SelectMemberActivity.this, SelectMemberActivity.TAG, new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.11.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this);
                    }
                }

                @Override // com.tencent.qqnt.troop.i
                public void onResult(boolean z16, int i3, @NonNull String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str2);
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable(z16, i3) { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.11.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f285700d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ int f285701e;

                            {
                                this.f285700d = z16;
                                this.f285701e = i3;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z16), Integer.valueOf(i3));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    SelectMemberActivity.this.handleInviteMember(this.f285700d, this.f285701e);
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f285715d;

        a(ArrayList arrayList) {
            this.f285715d = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this, (Object) arrayList);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
                SelectMemberActivity.this.inviteUserToGroup(this.f285715d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements SelectedAndSearchBar.i {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void a(ResultRecord resultRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resultRecord);
                return;
            }
            String str = resultRecord.uin;
            if (SelectMemberActivity.this.isResultListContainFriend(str)) {
                SelectMemberActivity.this.removeFriendFromResultList(str);
                SelectMemberActivity.this.updateMultiAddState(resultRecord, false);
                SelectMemberActivity.this.setupDoneBtn();
                int b16 = SelectMemberActivity.this.mInnerFrameManager.b();
                if (b16 == 6 || b16 == 7 || b16 == 5 || b16 == 4 || b16 == 1 || b16 == 0 || b16 == 8 || b16 == 9) {
                    ((SelectMemberInnerFrame) SelectMemberActivity.this.mInnerFrameManager.getCurrentView()).p();
                }
                SelectMemberActivity.this.startRelationFriendAndTroopSearch(false);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void afterTextChanged(Editable editable) {
            com.tencent.mobileqq.search.view.f fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj)) {
                if (SelectMemberActivity.this.mSearchResultLayout.getVisibility() == 0 && (fVar = SelectMemberActivity.this.contactSearchFragment) != null) {
                    fVar.y8();
                }
                SelectMemberActivity.this.mSearchResultLayout.setVisibility(8);
            } else {
                if (SelectMemberActivity.this.mSearchResultLayout.getVisibility() == 8) {
                    SelectMemberActivity.this.notifySearchFragmentShow();
                }
                SelectMemberActivity.this.mSearchResultLayout.setVisibility(0);
            }
            com.tencent.mobileqq.search.view.f fVar2 = SelectMemberActivity.this.contactSearchFragment;
            if (fVar2 != null) {
                fVar2.startSearch(obj);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void b(boolean z16) {
            com.tencent.mobileqq.search.k kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (z16) {
                SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                int i3 = selectMemberActivity.lastInerFrame;
                if (i3 == 6 || i3 == 7 || i3 != selectMemberActivity.mInnerFrameManager.b()) {
                    SelectMemberInnerFrame selectMemberInnerFrame = (SelectMemberInnerFrame) SelectMemberActivity.this.mInnerFrameManager.getCurrentView();
                    if (SelectMemberActivity.this.enableSearchDefaultSingleMode()) {
                        kVar = SelectMemberActivity.this.newSearchOperationIoc();
                    } else {
                        kVar = null;
                    }
                    com.tencent.mobileqq.search.view.f n3 = selectMemberInnerFrame.n(SelectMemberActivity.this.enableSearchDefaultSingleMode(), kVar);
                    if (n3 != null) {
                        n3.z7(SelectMemberActivity.this.mFilterRobot);
                        int i16 = SelectMemberActivity.this.mSubType;
                        boolean z17 = true;
                        if (i16 != 0 && i16 != 1) {
                            z17 = false;
                        }
                        n3.e2(z17);
                        n3.B5(SelectMemberActivity.this.getResultUins(), SelectMemberActivity.this.getJoinUins());
                        FragmentTransaction beginTransaction = SelectMemberActivity.this.getSupportFragmentManager().beginTransaction();
                        com.tencent.mobileqq.search.view.f fVar = SelectMemberActivity.this.contactSearchFragment;
                        if (fVar != null) {
                            beginTransaction.remove(fVar.getFragment());
                        }
                        beginTransaction.add(R.id.result_layout, n3.getFragment());
                        beginTransaction.commitAllowingStateLoss();
                        SelectMemberActivity.this.contactSearchFragment = n3;
                    }
                    SelectMemberActivity selectMemberActivity2 = SelectMemberActivity.this;
                    if (selectMemberActivity2.mSubType == 0) {
                        ReportController.o(selectMemberActivity2.app, "CliOper", "", "", "0X800543F", "0X800543F", 1, 0, "", "", "", "");
                    } else {
                        ReportController.o(selectMemberActivity2.app, "CliOper", "", "", "0X800543F", "0X800543F", 2, 0, "", "", "", "");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        float f285718d;

        /* renamed from: e, reason: collision with root package name */
        float f285719e;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            } else {
                this.f285718d = 0.0f;
                this.f285719e = 0.0f;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f285718d = motionEvent.getRawX();
                this.f285719e = motionEvent.getRawY();
                return false;
            }
            if (action == 2) {
                if (motionEvent.getRawX() - this.f285718d > 10.0f || motionEvent.getRawY() - this.f285719e > 10.0f) {
                    SelectMemberActivity.this.mSelectedAndSearchBar.v();
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements com.tencent.mobileqq.search.k {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.search.k
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            QLog.i(SelectMemberActivity.TAG, 1, "setSearchFragmentVisibility " + z16);
            if (z16) {
                if (SelectMemberActivity.this.mSearchResultLayout.getVisibility() == 8) {
                    SelectMemberActivity.this.mSearchResultLayout.setVisibility(0);
                    com.tencent.mobileqq.search.view.f fVar = SelectMemberActivity.this.contactSearchFragment;
                    if (fVar != null) {
                        fVar.tb();
                        return;
                    }
                    return;
                }
                return;
            }
            SelectMemberActivity.this.quitSearchState();
        }

        @Override // com.tencent.mobileqq.search.k
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void f(boolean z16, int i3, long j3, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
                return;
            }
            QQProgressDialog qQProgressDialog = SelectMemberActivity.this.mQQProgressDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
                if (z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(SelectMemberActivity.TAG, 2, "add discussion member success: roomId: " + j3);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<ResultRecord> it = SelectMemberActivity.this.mResultList.iterator();
                    while (it.hasNext()) {
                        ResultRecord next = it.next();
                        if (next.type == 5) {
                            if (next.uin.startsWith("pstn")) {
                                next.uin = next.uin.substring(4);
                            }
                            arrayList2.add(next.uin);
                        }
                    }
                    SelectMemberActivity.this.mIntent.putExtra("roomId", j3);
                    SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                    selectMemberActivity.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, selectMemberActivity.mResultList);
                    if (z16) {
                        SelectMemberActivity selectMemberActivity2 = SelectMemberActivity.this;
                        selectMemberActivity2.setResult(-1, selectMemberActivity2.mIntent);
                    } else {
                        SelectMemberActivity selectMemberActivity3 = SelectMemberActivity.this;
                        selectMemberActivity3.setResult(1, selectMemberActivity3.mIntent);
                    }
                    SelectMemberActivity.this.finish();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(SelectMemberActivity.TAG, 2, "add discussion member fail");
                }
                if (i3 == 1000) {
                    ReportController.o(SelectMemberActivity.this.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
                }
                SelectMemberActivity selectMemberActivity4 = SelectMemberActivity.this;
                QQToast.makeText(selectMemberActivity4, selectMemberActivity4.getString(R.string.arz), 2000).show(SelectMemberActivity.this.mTitleBar.getHeight());
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void i(boolean z16, int i3, long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str);
                return;
            }
            if (!z16) {
                SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg = false;
            }
            QQProgressDialog qQProgressDialog = SelectMemberActivity.this.mQQProgressDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
                if (z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(SelectMemberActivity.TAG, 2, "create discussion success: roomId: " + j3 + ", mSubType: " + SelectMemberActivity.this.mSubType + ", mEntrance: " + SelectMemberActivity.this.mEntrance);
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<ResultRecord> it = SelectMemberActivity.this.mResultList.iterator();
                    while (it.hasNext()) {
                        ResultRecord next = it.next();
                        int i16 = next.type;
                        if (i16 == 5) {
                            if (next.uin.startsWith("pstn")) {
                                next.uin = next.uin.substring(4);
                            }
                            arrayList.add(next.uin);
                        } else if (i16 == 4 && next.uin.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                            arrayList.add(next.uin);
                        }
                    }
                    SelectMemberActivity.this.mIntent.putExtra("roomId", j3);
                    SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                    if (selectMemberActivity.mEntrance == 12) {
                        selectMemberActivity.mIntent.putExtra("select_memeber_discussion_memeber_count", selectMemberActivity.mResultList.size() + 1);
                    }
                    SelectMemberActivity selectMemberActivity2 = SelectMemberActivity.this;
                    selectMemberActivity2.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, selectMemberActivity2.mResultList);
                    SelectMemberActivity selectMemberActivity3 = SelectMemberActivity.this;
                    selectMemberActivity3.setResult(-1, selectMemberActivity3.mIntent);
                    SelectMemberActivity.this.finish();
                    return;
                }
                QLog.d(SelectMemberActivity.TAG, 1, "create discussion fail, errCode=" + i3);
                if (i3 == 1000) {
                    SelectMemberActivity selectMemberActivity4 = SelectMemberActivity.this;
                    QQToast.makeText(selectMemberActivity4, selectMemberActivity4.getString(R.string.f171404es1), 2000).show(SelectMemberActivity.this.mTitleBar.getHeight());
                    ReportController.o(SelectMemberActivity.this.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
                } else {
                    SelectMemberActivity selectMemberActivity5 = SelectMemberActivity.this;
                    QQToast.makeText(selectMemberActivity5, selectMemberActivity5.getString(R.string.as5), 2000).show(SelectMemberActivity.this.mTitleBar.getHeight());
                }
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void o(Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) objArr);
                return;
            }
            QQProgressDialog qQProgressDialog = SelectMemberActivity.this.mQQProgressDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            if (objArr == null) {
                return;
            }
            if (SelectMemberActivity.this.mGroupCode.equals((String) objArr[0])) {
                QLog.d(SelectMemberActivity.TAG, 2, "add discussion member failed, error code: " + ((Integer) objArr[1]).intValue());
                SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                QQToast.makeText(selectMemberActivity, selectMemberActivity.getString(R.string.arz), 0).show(SelectMemberActivity.this.getTitleBarHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f extends com.tencent.mobileqq.troop.troopmanager.api.b {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopmanager.api.b
        protected void onGetInvitedUinList(boolean z16, Long l3, List<Long> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), l3, list);
                return;
            }
            String valueOf = String.valueOf(l3);
            if (z16 && valueOf.equals(SelectMemberActivity.this.mGroupCode)) {
                Iterator<Long> it = list.iterator();
                while (it.hasNext()) {
                    SelectMemberActivity.this.mInvitedUinList.add(String.valueOf(it.next()));
                }
                if (QLog.isColorLevel()) {
                    QLog.d(SelectMemberActivity.TAG, 2, "troop" + valueOf + " get invitedUinList = " + list.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f285725d;

        h(ArrayList arrayList) {
            this.f285725d = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this, (Object) arrayList);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                SelectMemberActivity.this.doInviteTroopMember(this.f285725d);
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
            selectMemberActivity.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, selectMemberActivity.mResultList);
            SelectMemberActivity selectMemberActivity2 = SelectMemberActivity.this;
            selectMemberActivity2.setResult(-1, selectMemberActivity2.mIntent);
            SelectMemberActivity.this.finish();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class l implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SelectMemberActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                if (selectMemberActivity.mEntrance == 27) {
                    selectMemberActivity.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, selectMemberActivity.mResultList);
                    ((InputMethodManager) SelectMemberActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(SelectMemberActivity.this.getWindow().peekDecorView().getWindowToken(), 0);
                    SelectMemberActivity selectMemberActivity2 = SelectMemberActivity.this;
                    selectMemberActivity2.setResult(-1, selectMemberActivity2.mIntent);
                }
                SelectMemberActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class n implements Function1<TroopMemberNickInfo, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultRecord f285732d;

        n(ResultRecord resultRecord) {
            this.f285732d = resultRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this, (Object) resultRecord);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
            }
            this.f285732d.name = troopMemberNickInfo.getShowName();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class o implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                if (selectMemberActivity.mEntrance == 36) {
                    if (selectMemberActivity.mType == 1) {
                        selectMemberActivity.createNewTypeDiscussion();
                    } else {
                        selectMemberActivity.startCreateOrAdd();
                    }
                } else {
                    selectMemberActivity.startCreateOrAdd();
                }
                dialogInterface.dismiss();
                ReportController.o(null, "CliOper", "", "", "0X8004CEE", "0X8004CEE", 0, 0, "", "", "", "");
            }
        }

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            String str;
            int i3;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                if (SelectMemberActivity.this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ShowInviteEntry, false)) {
                    IShareChatApi iShareChatApi = (IShareChatApi) QRoute.api(IShareChatApi.class);
                    SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                    iShareChatApi.share((BaseQQAppInterface) selectMemberActivity.app, selectMemberActivity, view, selectMemberActivity.mIntent);
                } else {
                    SelectMemberActivity selectMemberActivity2 = SelectMemberActivity.this;
                    if (selectMemberActivity2.mEntrance == 11) {
                        if (selectMemberActivity2.mInnerFrameManager.b() == 0) {
                            ReportController.o(SelectMemberActivity.this.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
                        } else if (SelectMemberActivity.this.mInnerFrameManager.b() == 1) {
                            ReportController.o(SelectMemberActivity.this.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
                        }
                    }
                    SelectMemberActivity selectMemberActivity3 = SelectMemberActivity.this;
                    if (selectMemberActivity3.mSubType == 3) {
                        String stringExtra = selectMemberActivity3.getIntent().getStringExtra("group_uin");
                        StringBuilder sb5 = new StringBuilder();
                        ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                        AppInterface appInterface = SelectMemberActivity.this.app;
                        sb5.append(iSelectMemberRefatorHelperApi.getMemberType(appInterface, appInterface.getCurrentAccountUin(), stringExtra));
                        sb5.append("");
                        ReportController.o(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, stringExtra, sb5.toString(), "\u53d1\u8d77\u89c6\u9891".equals(SelectMemberActivity.this.mRightBtn.getText().toString()) ? "0" : "1", "");
                    }
                    SelectMemberActivity selectMemberActivity4 = SelectMemberActivity.this;
                    int i16 = selectMemberActivity4.mEntrance;
                    if (i16 == 33) {
                        IToPayManager iToPayManager = selectMemberActivity4.mToPayManagerApi;
                        SelectMemberActivity selectMemberActivity5 = SelectMemberActivity.this;
                        iToPayManager.topay(selectMemberActivity5, selectMemberActivity5.mResultList);
                    } else {
                        if (i16 == 32 || i16 == 43) {
                            int size = selectMemberActivity4.mResultList.size();
                            SelectMemberActivity selectMemberActivity6 = SelectMemberActivity.this;
                            if (size > selectMemberActivity6.mMaxSelectNumber) {
                                QQToast.makeText(SelectMemberActivity.this, MessageFormat.format(selectMemberActivity6.getString(R.string.hdc), Integer.valueOf(SelectMemberActivity.this.mMaxSelectNumber)), 0).show(SelectMemberActivity.this.mTitleBar.getHeight());
                            }
                        }
                        if (!NetworkUtil.isNetSupport(SelectMemberActivity.this)) {
                            SelectMemberActivity selectMemberActivity7 = SelectMemberActivity.this;
                            QQToast.makeText(selectMemberActivity7, selectMemberActivity7.getString(R.string.b3j), 0).show(SelectMemberActivity.this.mTitleBar.getHeight());
                        } else {
                            SelectMemberActivity selectMemberActivity8 = SelectMemberActivity.this;
                            if (selectMemberActivity8.mIsForbidOnlyChooseMySelf && selectMemberActivity8.mResultList.size() == 1 && SelectMemberActivity.this.mResultList.get(0) != null) {
                                ResultRecord resultRecord = SelectMemberActivity.this.mResultList.get(0);
                                String currentUin = SelectMemberActivity.this.app.getCurrentUin();
                                if (currentUin != null && (str2 = resultRecord.uin) != null && currentUin.equals(str2)) {
                                    SelectMemberActivity selectMemberActivity9 = SelectMemberActivity.this;
                                    QQToast.makeText(selectMemberActivity9, selectMemberActivity9.getString(R.string.hda), 0).show(SelectMemberActivity.this.mTitleBar.getHeight());
                                }
                            }
                            Iterator<ResultRecord> it = SelectMemberActivity.this.mResultList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z16 = false;
                                    break;
                                } else if (it.next().type != 5) {
                                    z16 = true;
                                    break;
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(SelectMemberActivity.TAG, 2, "right btn click entrance[" + SelectMemberActivity.this.mEntrance + "], uinType[" + SelectMemberActivity.this.mType + "], nopstn[" + z16 + "]");
                            }
                            SelectMemberActivity selectMemberActivity10 = SelectMemberActivity.this;
                            int i17 = selectMemberActivity10.mEntrance;
                            if ((i17 == 36 || i17 == 11) && z16) {
                                DialogUtil.createCustomDialog(selectMemberActivity10, 230, (String) null, selectMemberActivity10.getString(R.string.vtd), R.string.d_2, R.string.a8j, new a(), new b()).show();
                                ReportController.o(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
                            } else {
                                if (i17 == 12 && selectMemberActivity10.mMaxSelectNumber == 1) {
                                    if (selectMemberActivity10.mResultList.size() == 1) {
                                        ResultRecord resultRecord2 = SelectMemberActivity.this.mResultList.get(0);
                                        Intent intent = new Intent();
                                        intent.putExtra("select_memeber_single_friend", true);
                                        intent.putExtra("select_memeber_single_friend_type", resultRecord2.type);
                                        if (resultRecord2.type == 1) {
                                            str = SelectMemberActivity.this.getTroopCodeFromTroopUin(resultRecord2.groupUin);
                                            i3 = 1000;
                                        } else {
                                            str = null;
                                            i3 = 0;
                                        }
                                        int i18 = resultRecord2.type;
                                        if (i18 == 2) {
                                            str = resultRecord2.groupUin;
                                            i3 = 1004;
                                        }
                                        if (i18 == 3) {
                                            i3 = 1021;
                                        } else if (i18 == 4) {
                                            i3 = 1006;
                                        }
                                        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(resultRecord2.uin), SelectMemberActivity.TAG)) {
                                            i3 = 0;
                                        }
                                        Bundle bundle = new Bundle();
                                        bundle.putString("uin", resultRecord2.uin);
                                        bundle.putInt("uintype", i3);
                                        bundle.putString("uinname", resultRecord2.name);
                                        bundle.putString("troop_uin", str);
                                        intent.putExtras(bundle);
                                        SelectMemberActivity.this.setResult(-1, intent);
                                        SelectMemberActivity.this.finish();
                                    } else {
                                        SelectMemberActivity.this.startCreateOrAdd();
                                    }
                                    ReportController.o(SelectMemberActivity.this.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
                                } else if (i17 == 23) {
                                    Intent intent2 = new Intent();
                                    Bundle bundle2 = new Bundle();
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    Iterator<ResultRecord> it5 = SelectMemberActivity.this.mResultList.iterator();
                                    while (it5.hasNext()) {
                                        ResultRecord next = it5.next();
                                        if (next.type == 1) {
                                            arrayList.add(next.uin);
                                        }
                                    }
                                    bundle2.putStringArrayList("troopMemList", arrayList);
                                    intent2.putExtras(bundle2);
                                    SelectMemberActivity.this.setResult(-1, intent2);
                                    SelectMemberActivity.this.finish();
                                } else if (i17 == 24) {
                                    Intent intent3 = new Intent();
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putParcelableArrayList("friendsSelected", SelectMemberActivity.this.mResultList);
                                    intent3.putExtras(bundle3);
                                    SelectMemberActivity.this.setResult(-1, intent3);
                                    if (SelectMemberActivity.this.isStoryNotSee) {
                                        SelectMemberActivity.reportEventByStoryReportor("set_notsee", "clk_done", 0, 0, "", "", "", "");
                                    } else {
                                        SelectMemberActivity.reportEventByStoryReportor("set_notletsee", "clk_done", 0, 0, "", "", "", "");
                                    }
                                    SelectMemberActivity.this.finish();
                                } else if (i17 == 37) {
                                    selectMemberActivity10.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, selectMemberActivity10.mResultList);
                                    SelectMemberActivity selectMemberActivity11 = SelectMemberActivity.this;
                                    selectMemberActivity11.setResult(-1, selectMemberActivity11.mIntent);
                                    SelectMemberActivity.this.finish();
                                } else if (selectMemberActivity10.mType == 3000 && selectMemberActivity10.mSubType == 0) {
                                    selectMemberActivity10.createNewTypeDiscussion();
                                } else {
                                    selectMemberActivity10.startCreateOrAdd();
                                }
                                SelectMemberActivity selectMemberActivity12 = SelectMemberActivity.this;
                                if (selectMemberActivity12.mSubType == 1) {
                                    Iterator<ResultRecord> it6 = selectMemberActivity12.mResultList.iterator();
                                    int i19 = 0;
                                    while (it6.hasNext()) {
                                        int i26 = it6.next().type;
                                        if (i26 == 1 || i26 == 2) {
                                            i19++;
                                        }
                                    }
                                    if (i19 > 0) {
                                        SelectMemberActivity selectMemberActivity13 = SelectMemberActivity.this;
                                        TroopInfo troopInfo = selectMemberActivity13.getTroopInfo(selectMemberActivity13.mGroupCode);
                                        if (troopInfo != null) {
                                            String currentUin2 = SelectMemberActivity.this.app.getCurrentUin();
                                            int i27 = troopInfo.isTroopOwner(currentUin2) ? 0 : troopInfo.isTroopAdmin(currentUin2) ? 1 : 2;
                                            SelectMemberActivity selectMemberActivity14 = SelectMemberActivity.this;
                                            ReportController.o(selectMemberActivity14.app, "dc00899", "invite_friend", "", "friend_list", "invite_friend", 0, 0, selectMemberActivity14.mGroupCode, String.valueOf(i27), String.valueOf(i19), "");
                                        }
                                    }
                                }
                                if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(SelectMemberActivity.this)) {
                                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).reportFinishClick(SelectMemberActivity.this.mIntent.getStringExtra("group_uin"), SelectMemberActivity.convertToGameTroopSelectMemberInfoList(SelectMemberActivity.this.mResultList), SelectMemberActivity.this.mIntent.getStringExtra(ITroopUtilApi.GAME_H5_SELECT_GAME_APPID));
                                }
                            }
                        }
                    }
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface p {
        void b(boolean z16, boolean z17);

        void c(String str);

        void d(ResultRecord resultRecord, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class q extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (!TextUtils.isEmpty(intent.getPackage()) && intent.getPackage().equals(SelectMemberActivity.this.app.getApp().getPackageName())) {
                if (action.equals("tencent.av.v2q.StopVideoChat")) {
                    int intExtra = intent.getIntExtra("stopReason", 0);
                    int intExtra2 = intent.getIntExtra("stopReason3rd", -1);
                    if (intExtra == 0 || intExtra2 == 1) {
                        int i3 = SelectMemberActivity.this.mEntrance;
                        if (i3 == 11 || i3 == 36) {
                            if (QLog.isColorLevel()) {
                                QLog.d(SelectMemberActivity.TAG, 2, "ACTION_STOP_VIDEO_CHAT");
                            }
                            SelectMemberActivity.this.finish();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(SelectMemberActivity.TAG, 2, "receive broadcast from wrong package:" + intent.getPackage() + ",action:" + action);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26202);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 67)) {
            redirector.redirect((short) 67);
        } else {
            sNeedBlockDiscussSelfInviteMsg = false;
        }
    }

    public SelectMemberActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.unclickableSelectedUins = new ArrayList();
        this.enableSearchDefaultSingleModeByConfig = ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).enableDefaultSingleMode();
        this.mInviteMiniCallback = new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                    selectMemberActivity.doInviteTroopMember(selectMemberActivity.mResultList);
                }
            }
        };
        this.mSearchTextEmpty = true;
        this.mGVideoTextView = null;
        this.mIsLimitToInviteByTroopMaxLimit = false;
        this.mResultList = new ArrayList<>();
        this.mIsSelectAllMembers = false;
        this.mOverloadToastLastShowTime = 0L;
        this.mUnblessedUinCount = 0;
        this.mWebUinCount = 0;
        this.isSupportSelectFriendGroup = true;
        this.isStoryNotSee = false;
        this.mInviteNoAuthLimitNum = Long.MAX_VALUE;
        this.mInvitedUinList = new ArrayList();
        this.mIsNeedSendIsResumeBroadcast = true;
        this.mIsPutMySelfFirst = false;
        this.mIsForbidOnlyChooseMySelf = false;
        this.mFilterRobot = false;
        this.lastCreateTimeStamp = 0L;
        this.needShowYellowTips = false;
        this.mInviteSuccToastWording = HardCodeUtil.qqStr(R.string.t_b);
        this.mYellowTipsWording = "";
        this.isClosed = false;
        this.lastInerFrame = -1;
        this.mSelectedAndSearchBarCallback = new b();
        this.imm = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.20
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this, (Object) r5);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i3;
                String string;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i16 = message.what;
                if (i16 != 0) {
                    if (i16 == 1 && SelectMemberActivity.this.mInviting) {
                        SelectMemberActivity.this.mInviting = false;
                        String str = (String) message.obj;
                        if (str == null) {
                            str = SelectMemberActivity.this.getString(R.string.bzq);
                        }
                        QQToast.makeText(SelectMemberActivity.this, 1, str, 1500).show(SelectMemberActivity.this.getTitleBarHeight());
                        return;
                    }
                    return;
                }
                if (SelectMemberActivity.this.mInviting) {
                    SelectMemberActivity.this.mInviting = false;
                    Intent intent = new Intent();
                    intent.putExtra("select_member_add_request_ok", true);
                    SelectMemberActivity.this.setResult(-1, intent);
                    if (!TextUtils.isEmpty(SelectMemberActivity.this.mInviteSuccToastWording)) {
                        string = SelectMemberActivity.this.mInviteSuccToastWording;
                    } else {
                        SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                        if (selectMemberActivity.mIsTroopAdmin) {
                            i3 = R.string.bzs;
                        } else {
                            i3 = R.string.bzr;
                        }
                        string = selectMemberActivity.getResources().getString(i3);
                    }
                    QQToast.makeText(SelectMemberActivity.this, 2, string, 1500).show(SelectMemberActivity.this.getTitleBarHeight());
                    postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.20.1
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
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else if (!SelectMemberActivity.this.isFinishing()) {
                                SelectMemberActivity.this.finish();
                            }
                        }
                    }, 1500L);
                }
            }
        };
        this.videoMsgReceiver = null;
        this.mInviteWithMsgGroup = new InviteWithMsgGroup(this.mInviteMiniCallback);
    }

    private void afterCreateTroopSucc(String str, boolean z16) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "afterCreateTroopSucc, troop[" + str + "], entrance[" + this.mEntrance + "]");
        }
        TroopInfo troopInfo = getTroopInfo(str);
        if (troopInfo == null) {
            str2 = "";
        } else {
            str2 = troopInfo.troopname;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ResultRecord> it = this.mResultList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            int i3 = next.type;
            if (i3 == 5) {
                if (next.uin.startsWith("pstn")) {
                    next.uin = next.uin.substring(4);
                }
                arrayList.add(next.uin);
            } else if (i3 == 4 && next.uin.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                arrayList.add(next.uin);
            }
        }
        this.mIntent.putExtra("roomId", str);
        this.mIntent.putExtra("discussName", str2);
        this.mIntent.putExtra("qqPhoneUserList", arrayList);
        this.mIntent.putExtra("audioType", 2);
        this.mIntent.putExtra("isReuse", z16);
        this.mIntent.putExtra(ISelectMemberActivityConstants.Result_Uin, str);
        this.mIntent.putExtra(ISelectMemberActivityConstants.Result_UinType, 1);
        this.mIntent.putExtra(ISelectMemberActivityConstants.Result_Name, str2);
        if (this.mEntrance == 12) {
            this.mIntent.putExtra("select_memeber_discussion_memeber_count", this.mResultList.size() + 1);
        }
        this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
        setResult(-1, this.mIntent);
        finish();
    }

    private boolean canInvite() {
        if (!this.mIsTroopAdmin) {
            getNotAdminInviteMemberCount();
            return true;
        }
        return true;
    }

    private void checkNeedGameInfo(SelectMemberActivity selectMemberActivity, String str, int i3) {
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(selectMemberActivity)) {
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).onSearchBarDone(this.app, selectMemberActivity, convertToGameTroopSelectMemberInfoList(this.mResultList), i3, str, getIntent().getStringExtra("group_uin"));
        }
    }

    public static int checkPhoneNumber(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String replace = str.replace("-", "").replace(" ", "");
        if (replace.length() <= 6) {
            return 5;
        }
        if (replace.length() > 16) {
            return 4;
        }
        if (z16 && (replace.startsWith("00") || replace.startsWith(Marker.ANY_NON_NULL_MARKER) || replace.startsWith("86"))) {
            if (replace.startsWith("0086")) {
                replace = replace.substring(4);
            } else if (replace.startsWith("+86")) {
                replace = replace.substring(3);
            } else if (replace.startsWith("86")) {
                replace = replace.substring(2);
            } else {
                return 1;
            }
        }
        if (replace.startsWith(IndividuationPlugin.Business_Pendant) || replace.startsWith(IndividuationPlugin.Business_Suit)) {
            return 2;
        }
        if (!replace.startsWith("0") && replace.length() <= 9) {
            return 3;
        }
        if (replace.length() != 11 && replace.length() != 12) {
            return 6;
        }
        return 0;
    }

    private void configLeftBackIconDrawable() {
        Drawable drawable = getResources().getDrawable(R.drawable.top_back_left_selector);
        if (drawable != null) {
            int color = getResources().getColor(R.color.qui_common_icon_nav_secondary);
            drawable = drawable.mutate();
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        this.mLeftBackBtn.setBackground(drawable);
    }

    public static ResultRecord constructAResultRecord(String str, String str2, int i3, String str3) {
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.uin = str;
        resultRecord.name = str2;
        resultRecord.type = i3;
        resultRecord.groupUin = str3;
        return resultRecord;
    }

    static ArrayList<com.tencent.mobileqq.troop.b> convertToGameTroopSelectMemberInfoList(List<ResultRecord> list) {
        ArrayList<com.tencent.mobileqq.troop.b> arrayList = new ArrayList<>();
        if (list != null) {
            for (ResultRecord resultRecord : list) {
                arrayList.add(new com.tencent.mobileqq.troop.b(resultRecord.uin, resultRecord.name, resultRecord.type, resultRecord.uinType, resultRecord.groupUin, resultRecord.phone, resultRecord.lastChooseTime, resultRecord.isNewTroop, resultRecord.gameLevelIcon));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean enableSearchDefaultSingleMode() {
        if (this.enableSearchDefaultSingleModeByConfig && this.mInnerFrameManager.b() == 0) {
            return true;
        }
        return false;
    }

    static String getFromArray(int i3, String... strArr) {
        if (strArr != null && strArr.length > i3) {
            return strArr[i3];
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> getJoinUins() {
        if (enableSearchDefaultSingleMode()) {
            ArrayList<String> arrayList = this.mUinsSelectedDefault;
            if (arrayList != null) {
                this.unclickableSelectedUins.addAll(arrayList);
            }
            return this.unclickableSelectedUins;
        }
        return this.mUinsSelectedDefault;
    }

    private void handleGuildInviteFriends() {
        int intExtra = this.mIntent.getIntExtra("guild_current_member_number", 0);
        if (this.mResultList.size() + intExtra <= this.mIntent.getIntExtra("guild_member_scale_limit", 0)) {
            this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
            setResult(-1, this.mIntent);
            finish();
            return;
        }
        String stringExtra = this.mIntent.getStringExtra("guild_invite_friends_dialog_title");
        String stringExtra2 = this.mIntent.getStringExtra("guild_invite_friends_dialog_desc");
        String stringExtra3 = this.mIntent.getStringExtra("guild_invite_firends_dialog_right_btn");
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = getString(R.string.a8j);
        }
        String str = stringExtra3;
        if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2)) {
            this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
            setResult(-1, this.mIntent);
            finish();
            return;
        }
        DialogUtil.createCustomDialog(this, 230, stringExtra, stringExtra2, getString(R.string.d_2), str, new j(), new k()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInviteMember(boolean z16, int i3) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "add troop member success");
            }
            this.mHandler.sendEmptyMessage(0);
            if (!this.mIsTroopAdmin) {
                setNotAdminInviteMemberCount(getNotAdminInviteMemberCount() + 1);
                ReportController.o(this.app, "CliOper", "", "", "Grp", "Send_invite", 0, 0, "", "", "", "");
            }
            ArrayList<ResultRecord> outGroupMem = getOutGroupMem();
            this.mIntent.putExtra("roomId", Long.parseLong(this.mGroupCode));
            this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
            this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET_For_out_Member, outGroupMem);
            setResult(-1);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "add troop member fail");
        }
        handleTroopInviteGroupFailed(i3);
    }

    private void handleTroopInviteGroupFailed(int i3) {
        String string;
        if (i3 != 1281) {
            if (i3 != 1286) {
                if (i3 != 1288) {
                    if (i3 != 1294) {
                        int i16 = this.mEntrance;
                        if (i16 != 11 && i16 != 36) {
                            string = getString(R.string.bzq);
                        } else {
                            string = getString(R.string.f171233dd0);
                        }
                    } else {
                        string = getString(R.string.bzo);
                    }
                } else {
                    string = getString(R.string.bzp);
                }
            } else {
                string = getString(R.string.bzm);
            }
        } else {
            string = getString(R.string.bzn);
        }
        this.mHandler.obtainMessage(1, string).sendToTarget();
        QLog.w(TAG, 1, "handleTroopInviteGroupFailed, result[" + i3 + "], errStr[" + string + "]");
    }

    private boolean hasAdd2ResultList(String str) {
        try {
            Iterator<ResultRecord> it = this.mResultList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().uin, str)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void initObserver() {
        this.mDiscussionObserver = new e();
        this.mTroopManagerBizObserver = new f();
        this.mAvatarObserver = new g();
        addObserver(this.mDiscussionObserver);
        addObserver(this.mAvatarObserver);
        addObserver(this.mTroopManagerBizObserver);
    }

    private void initTroopMemberName(ResultRecord resultRecord) {
        resultRecord.name = resultRecord.uin;
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(resultRecord.groupUin, resultRecord.uin, TAG, new n(resultRecord));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ResultRecord innerOnItemClick(String str, String str2, int i3, String str3) {
        ResultRecord constructAResultRecord;
        boolean z16;
        boolean z17 = false;
        ResultRecord resultRecord = null;
        if (isResultListContainFriend(str)) {
            removeFriendFromResultList(str);
        } else if (!isMemberOverLoad("onListViewItemClick1", false, str, str2, i3, str3) && !isMemberOverload(str, str2) && preAddPstnNumber(str, str2, i3, str3)) {
            constructAResultRecord = constructAResultRecord(str, str2, i3, str3);
            this.mResultList.add(constructAResultRecord);
            if (this.mType == 9003) {
                if (this.mEntrance == 15 && !((IBlessApi) QRoute.api(IBlessApi.class)).isUinBlessed(this.app, str)) {
                    this.mUnblessedUinCount++;
                } else if (this.mEntrance == 32 && !((IBlessApi) QRoute.api(IBlessApi.class)).isWebUinSended(this.app, str)) {
                    this.mUnblessedUinCount++;
                }
            }
            z16 = true;
            if (!isInvitedListContainFriend(str)) {
                removeFriendFromResultList(str);
                String qqStr = HardCodeUtil.qqStr(R.string.t_8);
                if (com.tencent.mobileqq.selectmember.util.a.n(this.app, str)) {
                    qqStr = "\u8bf7\u7b49\u5f85\u7ba1\u7406\u5458\u5ba1\u6838";
                }
                QQToast.makeText(this, 1, qqStr, 0).show(getTitleBarHeight());
                ReportController.o(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, str3, "", "", "");
            } else {
                resultRecord = constructAResultRecord;
                z17 = z16;
            }
            this.mSelectedAndSearchBar.p(z17);
            setupDoneBtn();
            onResultListChanged();
            startRelationFriendAndTroopSearch(true);
            checkNeedGameInfo(this, str, 3);
            return resultRecord;
        }
        z16 = false;
        constructAResultRecord = null;
        if (!isInvitedListContainFriend(str)) {
        }
        this.mSelectedAndSearchBar.p(z17);
        setupDoneBtn();
        onResultListChanged();
        startRelationFriendAndTroopSearch(true);
        checkNeedGameInfo(this, str, 3);
        return resultRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inviteUserToGroup(ArrayList<ResultRecord> arrayList) {
        if (u.a().b()) {
            return;
        }
        List<InviteToTroopUserInfo> d16 = com.tencent.mobileqq.troop.troopcreate.a.d(arrayList);
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        for (InviteToTroopUserInfo inviteToTroopUserInfo : d16) {
            if (inviteToTroopUserInfo.b() == null || inviteToTroopUserInfo.b().isEmpty()) {
                hashMap.put(inviteToTroopUserInfo.c(), inviteToTroopUserInfo);
                arrayList2.add(inviteToTroopUserInfo.c());
            }
        }
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).fetchUin2UidMap(arrayList2, true, true, new AnonymousClass11(hashMap, arrayList2, d16, this.mInviteWithMsgGroup.o()));
    }

    private boolean isNotMaxOfPSTN() {
        Iterator<ResultRecord> it = this.mResultList.iterator();
        int i3 = 0;
        while (it.hasNext() && (it.next().type != 5 || (i3 = i3 + 1) < 8)) {
        }
        if (i3 >= 8) {
            return false;
        }
        return true;
    }

    private boolean isTroopAddBatchFriend() {
        if (this.mFrom == 30) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.search.k newSearchOperationIoc() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySearchFragmentShow() {
        this.unclickableSelectedUins.clear();
        this.unclickableSelectedUins.addAll(getSelectedUinList());
        com.tencent.mobileqq.search.view.f fVar = this.contactSearchFragment;
        if (fVar != null) {
            fVar.B5(getResultUins(), getJoinUins());
            this.contactSearchFragment.tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetNoAuthMemberLimit(Boolean bool, TroopInfo troopInfo) {
        if (bool.booleanValue()) {
            this.mInviteNoAuthLimitNum = troopInfo.inviteNoAuthLimitNum;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "troop" + this.mGroupCode + " get inviteNoAuthLimitNum = " + this.mInviteNoAuthLimitNum);
            }
            long j3 = this.mTroopMemberNum;
            long j16 = this.mInviteNoAuthLimitNum;
            if (j3 >= j16 && j16 > 0) {
                this.mTooManyMembersTipsBar.setVisibility(0);
                AppInterface appInterface = this.app;
                String str = this.mGroupCode;
                StringBuilder sb5 = new StringBuilder();
                ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                AppInterface appInterface2 = this.app;
                sb5.append(iSelectMemberRefatorHelperApi.getMemberType(appInterface2, appInterface2.getCurrentAccountUin(), this.mGroupCode));
                sb5.append("");
                ReportController.o(appInterface, "dc00899", "invite_friend", "", "friend_list", "exp_needagree", 0, 0, str, sb5.toString(), "", "");
            }
        }
    }

    static void reportEventByStoryReportor(String str, String str2, int i3, int i16, String... strArr) {
        ReportController.o(null, "dc00899", "grp_story", "", str, str2, i3, i16, getFromArray(0, strArr), getFromArray(1, strArr), getFromArray(2, strArr), getFromArray(3, strArr));
    }

    private void sendIsResumeBroadcast(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendIsResumeBroadcast isNeedSend = " + this.mIsNeedSendIsResumeBroadcast + " ,isResume = " + z16);
        }
        if (this.mIsNeedSendIsResumeBroadcast) {
            String str = MobileQQ.QQ_PACKAGE_NAME;
            SmallScreenUtils.A(BaseApplication.getContext(), z16);
        }
    }

    private void setDoneBtnEnabled(boolean z16) {
        String format;
        if (this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ShowInviteEntry, false)) {
            return;
        }
        int size = this.mResultList.size();
        if (size <= 1) {
            if (this.mSubType == 3) {
                format = this.mDoneBtnText;
                if (size != 1) {
                    z16 = false;
                }
            } else {
                format = size == 1 ? MessageFormat.format(this.mDoneBtnText_x, Integer.valueOf(size)) : this.mDoneBtnText;
            }
        } else {
            format = this.mSubType == 3 ? this.mDoneBtnText : MessageFormat.format(this.mDoneBtnText_x, Integer.valueOf(size));
        }
        if (z16) {
            this.mRightBtn.setEnabled(true);
            if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
                this.mRightBtn.setAlpha(1.0f);
            }
            this.mRightBtn.setText(format);
        } else {
            this.mRightBtn.setEnabled(false);
            if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
                this.mRightBtn.setAlpha(0.5f);
            }
            this.mRightBtn.setText(format);
        }
        if (AppSetting.f99565y) {
            this.mRightBtn.setContentDescription(this.mDoneBtnText + HardCodeUtil.qqStr(R.string.t_5) + size + HardCodeUtil.qqStr(R.string.t9w));
        }
    }

    private void setTitleText(String str) {
        this.mTitle.setText(str);
    }

    private void setUpOrientation() {
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    private void showMemberOverloadToast(int i3) {
        showMemberOverloadToast(getString(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRelationFriendAndTroopSearch(boolean z16) {
        ResultRecord resultRecord;
        int i3 = this.mEntrance;
        if (i3 == 38 || i3 == 29 || i3 == 39) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "isItemClick\uff1a" + z16);
            }
            SelectMemberInnerFrame selectMemberInnerFrame = (SelectMemberInnerFrame) this.mInnerFrameManager.getChildAt(1);
            if ((!z16 || this.mInnerFrameManager.b() != 0) && (selectMemberInnerFrame instanceof FriendTeamListInnerFrame)) {
                if (this.mResultList.size() > 0) {
                    ArrayList<ResultRecord> arrayList = this.mResultList;
                    resultRecord = arrayList.get(arrayList.size() - 1);
                } else {
                    resultRecord = null;
                }
                selectMemberInnerFrame.q(resultRecord, this.mEntrance);
            }
        }
    }

    private void updateLeftRightViewTextColor() {
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_common_text_nav_secondary_selector);
        TextView textView = this.mLeftBackBtn;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.mLeftCancelBtn;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
        TextView textView3 = this.mRightBtn;
        if (textView3 != null) {
            textView3.setTextColor(colorStateList);
        }
    }

    private void updateTitleTextColor() {
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.qui_common_text_nav_secondary));
        }
    }

    public boolean addFriendResults(List<ResultRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) ? addFriendResults(list, z16, false) : ((Boolean) iPatchRedirector.redirect((short) 36, this, list, Boolean.valueOf(z16))).booleanValue();
    }

    public void adjustGridView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, z16);
            return;
        }
        SelectedAndSearchBar selectedAndSearchBar = this.mSelectedAndSearchBar;
        if (selectedAndSearchBar != null) {
            selectedAndSearchBar.p(z16);
        }
    }

    public void afterMemberFilter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, i3);
        } else {
            if (this.mEntrance != 35) {
                return;
            }
            this.mIsSelectAllMembers = false;
            doEnableAllSelect(i3);
            showAllSelectBtn();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:13|(5:14|15|(1:19)|20|21)|(1:23)(8:46|(1:48)(2:49|(1:51)(2:52|(1:54)(2:55|(1:57)(1:59))))|25|26|27|(3:29|(2:32|30)|33)|34|(2:36|37)(2:38|(2:40|41)(1:42)))|24|25|26|27|(0)|34|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c3, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.selectmember.SelectMemberActivity.TAG, 1, "createNewTypeDiscussion json error!", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void createNewTypeDiscussion() {
        int i3;
        ArrayList<String> arrayList;
        int i16;
        int i17;
        int intExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (System.currentTimeMillis() - this.lastCreateTimeStamp < 1500) {
            return;
        }
        this.lastCreateTimeStamp = System.currentTimeMillis();
        ITroopCreateService iTroopCreateService = (ITroopCreateService) this.app.getRuntimeService(ITroopCreateService.class, "");
        if (iTroopCreateService != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("group_type", 1);
                StringBuilder sb5 = new StringBuilder();
                ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                AppInterface appInterface = this.app;
                sb5.append(iSelectMemberRefatorHelperApi.getAccountNickName(appInterface, appInterface.getCurrentAccountUin()));
                sb5.append(HardCodeUtil.qqStr(R.string.t9v));
                jSONObject.put("name", sb5.toString());
                jSONObject.put("classify", 10010);
                int i18 = this.mEntrance;
                if (i18 != 12 && i18 != 36) {
                    jSONObject.put("isJumpAio", 1);
                }
                i17 = this.mEntrance;
            } catch (JSONException e16) {
                e = e16;
                i3 = 0;
            }
            if (i17 == 12) {
                intExtra = 3;
            } else {
                if (i17 == 28) {
                    i3 = 5;
                } else if (i17 == 39) {
                    intExtra = 8;
                } else if (i17 == 29) {
                    intExtra = 2;
                } else if (i17 == 27) {
                    intExtra = getIntent().getIntExtra("create_source", 0);
                } else {
                    i3 = 0;
                }
                jSONObject.put("create_source", i3);
                jSONObject.put("new_create_source", 1);
                ((ITroopCreateInfoService) this.app.getRuntimeService(ITroopCreateInfoService.class, "")).refreshCreateInfo(jSONObject.toString(), 5);
                ReportController.o(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + i3, "", "");
                ArrayList<ResultRecord> arrayList2 = new ArrayList<>(this.mResultList.size());
                arrayList2.addAll(this.mResultList);
                arrayList = this.mUinsSelectedDefault;
                if (arrayList != null) {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        ResultRecord resultRecord = new ResultRecord();
                        resultRecord.uin = next;
                        resultRecord.type = 0;
                        resultRecord.groupUin = "-1";
                        resultRecord.name = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getNickName(this.app, resultRecord.uin, resultRecord.type);
                        arrayList2.add(resultRecord);
                    }
                }
                iTroopCreateService.startCreateTroop(this, this, arrayList2);
                i16 = this.mFrom;
                if (i16 == 1003) {
                    ReportController.o(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_main", 0, 0, "", "", "", "");
                    return;
                } else {
                    if (i16 == 1002) {
                        ReportController.o(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_conta", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
            }
            i3 = intExtra;
            jSONObject.put("create_source", i3);
            jSONObject.put("new_create_source", 1);
            ((ITroopCreateInfoService) this.app.getRuntimeService(ITroopCreateInfoService.class, "")).refreshCreateInfo(jSONObject.toString(), 5);
            ReportController.o(this.app, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + i3, "", "");
            ArrayList<ResultRecord> arrayList22 = new ArrayList<>(this.mResultList.size());
            arrayList22.addAll(this.mResultList);
            arrayList = this.mUinsSelectedDefault;
            if (arrayList != null) {
            }
            iTroopCreateService.startCreateTroop(this, this, arrayList22);
            i16 = this.mFrom;
            if (i16 == 1003) {
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    void doEnableAllSelect(int i3) {
        TroopInfo troopInfo;
        int i16;
        int i17;
        int i18 = 0;
        if (!this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, false)) {
            return;
        }
        String stringExtra = this.mIntent.getStringExtra("group_uin");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        boolean z16 = this.mOnlyDiscussionMember;
        if (z16 || this.mOnlyTroopMember) {
            if (i3 != -1) {
                if (this.mShowMyself) {
                    i17 = i3 - 1;
                } else {
                    i17 = i3;
                }
            } else {
                if (z16) {
                    i16 = ((IDiscussionService) this.app.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(stringExtra);
                } else {
                    if (this.mOnlyTroopMember && (troopInfo = getTroopInfo(stringExtra)) != null) {
                        i16 = troopInfo.wMemberNum;
                    }
                    i17 = i18 - 1;
                }
                i18 = i16;
                i17 = i18 - 1;
            }
            if (i17 <= this.mIntent.getIntExtra(ISelectMemberActivityConstants.PARAM_ALL_SELECT_MAX_NUM, this.mMaxSelectNumber)) {
                this.mIsSelectAllMembers = true;
            }
            QLog.w(TAG, 1, "isEnableAllSelect, memCount[" + i3 + "], memFromAPI[" + i18 + "], finalCount[" + i17 + "], mIsSelectAllMembers[" + this.mIsSelectAllMembers + "], mShowMyself[" + this.mShowMyself + "]");
        }
    }

    protected void doInviteTroopMember(ArrayList<ResultRecord> arrayList) {
        TroopInfo findTroopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList.size() > 0 && this.mGroupCode.length() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "add troop member: troopCode: " + this.mGroupCode + " member count: " + arrayList.size());
            }
            if (!canInvite()) {
                QQToast.makeText(this, R.string.ck8, 0).show(getTitleBarHeight());
                return;
            }
            if (this.mTroopMemberNum <= 0 && (findTroopInfo = findTroopInfo(this.mGroupCode)) != null) {
                this.mTroopMemberNum = findTroopInfo.wMemberNum;
            }
            if (this.mInviteNoAuthLimitNum > 0 && arrayList.size() + this.mTroopMemberNum > this.mInviteNoAuthLimitNum) {
                DialogUtil.createNoTitleDialog(this, HardCodeUtil.qqStr(R.string.t_6), R.string.cancel, R.string.bzk, new a(arrayList), new DialogUtil.DialogOnClickAdapter()).show();
                reportInviteFriend("exp_msgbox");
                return;
            } else {
                inviteUserToGroup(arrayList);
                return;
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 10001) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "qqstory create share group result:" + i16);
            }
            if (i16 == -1) {
                setResult(-1, intent);
                finish();
                return;
            }
            return;
        }
        if (i3 == 10002) {
            this.mInviteWithMsgGroup.j(i16, intent);
            return;
        }
        InnerFrameManager innerFrameManager = this.mInnerFrameManager;
        if (innerFrameManager != null) {
            innerFrameManager.a(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        ArrayList<String> uinListToSend;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle)).booleanValue();
        }
        setTheme(R.style.f173428d2);
        super.doOnCreate(bundle);
        setUpOrientation();
        this.app = (AppInterface) getAppRuntime();
        getIntentExtras();
        setContentLayout();
        this.mToPayManagerApi = (IToPayManager) QRoute.api(IToPayManager.class);
        int i3 = this.mEntrance;
        if (i3 != 11 && i3 != 36) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            super.getWindow().addFlags(524288);
        }
        this.mFaceDecoder = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        this.mDensity = getResources().getDisplayMetrics().density;
        findViews();
        initTitleBar();
        initSelectedBar();
        initSearchBar();
        initObserver();
        initInnerFrameManager();
        if (this.mType == 1 && this.mSubType == 1) {
            TroopInfo findTroopInfo = findTroopInfo(this.mGroupCode);
            if (findTroopInfo != null) {
                this.mTroopMemberNum = findTroopInfo.wMemberNum;
            }
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopInfoForNoAuthMemberLimit(this.mGroupCode, TAG, this, new Function3<Boolean, Integer, TroopInfo, Unit>() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unit invoke(Boolean bool, Integer num, TroopInfo troopInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, this, bool, num, troopInfo);
                    }
                    ThreadManager.getUIHandler().post(new Runnable(bool, troopInfo) { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Boolean f285705d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ TroopInfo f285706e;

                        {
                            this.f285705d = bool;
                            this.f285706e = troopInfo;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass2.this, bool, troopInfo);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                SelectMemberActivity.this.onGetNoAuthMemberLimit(this.f285705d, this.f285706e);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    return null;
                }
            });
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.troop.troopmanager.api.a aVar = (com.tencent.mobileqq.troop.troopmanager.api.a) SelectMemberActivity.this.app.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopManagerBizHandlerName());
                    if (aVar != null) {
                        try {
                            aVar.x2(Long.valueOf(SelectMemberActivity.this.mGroupCode));
                        } catch (NumberFormatException unused) {
                            if (QLog.isColorLevel()) {
                                QLog.e(SelectMemberActivity.TAG, 2, "NumberFormatException : mGroupCode = " + SelectMemberActivity.this.mGroupCode);
                            }
                        }
                    }
                }
            }, 8, null, true);
        }
        this.mTransparentFace = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        this.mDefaultAvatar = BaseImageUtil.getDefaultFaceBitmap();
        if (this.videoMsgReceiver == null) {
            this.videoMsgReceiver = new q();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("tencent.av.v2q.StopVideoChat");
            registerReceiver(this.videoMsgReceiver, intentFilter);
        }
        if (isTroopAddBatchFriend()) {
            toggleSelectMode(true, true);
        }
        int i16 = this.mType;
        if ((i16 == 9003 || 8998 == i16) && (uinListToSend = ((IBlessApi) QRoute.api(IBlessApi.class)).getUinListToSend(this.app)) != null && uinListToSend.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = uinListToSend.iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(next), TAG);
                if (friendsSimpleInfoWithUid != null) {
                    arrayList.add(constructAResultRecord(next, friendsSimpleInfoWithUid.m(), 0, "-1"));
                }
            }
            addFriendResults(arrayList, false);
        }
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_SELECTED_RECORDS_FOR_CREATE_DISCURRION);
        if (parcelableArrayListExtra != null) {
            addFriendResults(parcelableArrayListExtra, false);
        }
        int i17 = this.mFrom;
        if (i17 == 1003) {
            ReportController.o(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_main", 0, 0, "", "", "", "");
        } else if (i17 == 1002) {
            ReportController.o(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_conta", 0, 0, "", "", "", "");
        }
        com.tencent.mobileqq.selectmember.util.c.b(this, this.mFrom, this.mGroupCode);
        if (this.mEntrance == 33) {
            ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "friendpay.askaio.payershowfriendpay.askaio.payershowfriendpay.askaio.payerclickfriendpay.selectpage.show", 0, 0, "", "", "", "");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.doOnDestroy();
        this.mInnerFrameManager.d();
        removeObserver(this.mDiscussionObserver);
        removeObserver(this.mTroopManagerBizObserver);
        removeObserver(this.mAvatarObserver);
        IFaceDecoder iFaceDecoder = this.mFaceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        BroadcastReceiver broadcastReceiver = this.videoMsgReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.videoMsgReceiver = null;
        }
        ITroopCreateService iTroopCreateService = (ITroopCreateService) this.app.getRuntimeService(ITroopCreateService.class, "");
        if (iTroopCreateService != null) {
            iTroopCreateService.releaseCreateCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnNewIntent");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnPause();
        this.mInnerFrameManager.e();
        sendIsResumeBroadcast(false);
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
        this.mInnerFrameManager.f();
        sendIsResumeBroadcast(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.doOnStart();
            getWindow().setSoftInputMode(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.doOnStop();
        getWindow().setSoftInputMode(48);
        this.mInnerFrameManager.g();
    }

    TroopInfo findTroopInfo(String str) {
        return ((ITroopInfoService) this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
    }

    @TargetApi(14)
    protected void findViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root);
        boolean z16 = true;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            relativeLayout.setFitsSystemWindows(true);
            relativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        View findViewById = findViewById(R.id.jo9);
        this.mTitleBar = findViewById;
        findViewById.setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        this.mTitle = (TextView) findViewById(R.id.ivTitleName);
        this.mLeftBackBtn = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.mLeftCancelBtn = (TextView) findViewById(R.id.ivTitleBtnLeftButton);
        this.mRightBtn = (TextView) findViewById(R.id.ivTitleBtnRightText);
        updateTitleTextColor();
        updateLeftRightViewTextColor();
        this.mSelectedAndSearchBar = (SelectedAndSearchBar) findViewById(R.id.imi);
        this.mListPanel = (LinearLayout) findViewById(R.id.ebk);
        this.mInnerFrameManager = (InnerFrameManager) findViewById(R.id.kwa);
        View findViewById2 = findViewById(R.id.result_layout);
        this.mSearchResultLayout = findViewById2;
        findViewById2.setVisibility(8);
        View findViewById3 = findViewById(R.id.jsp);
        this.mTooManyMembersTipsBar = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
            this.mTooManyMembersTipsBar.setOnClickListener(this);
        }
        View findViewById4 = findViewById(R.id.jsq);
        this.mTooManyMembersTipsClose = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this);
        }
        this.mCreateTroopButtonLayout = findViewById(R.id.bbu);
        if (isShowDoneButtonInBottom()) {
            this.mCreateTroopButtonLayout.setVisibility(0);
            Button button = (Button) findViewById(R.id.bbt);
            this.mCreateTroopButton = button;
            if (this.mEntrance == 35) {
                button.setText(this.mDoneBtnText);
            } else {
                z16 = false;
            }
            if (this.mEntrance == 40) {
                this.mCreateTroopButton.setText(this.mDoneBtnText);
            }
            this.mCreateTroopButton.setOnClickListener(this);
            this.mCreateTroopButton.setEnabled(z16);
            if (isCreateNewTroopEntrance()) {
                int intExtra = getIntent().getIntExtra("create_source", 0);
                ReportController.o(this.app, "dc00899", "Grp_create_new", "", "create_page", "exp_chose", 0, 0, "", "" + intExtra, "", "");
            } else if (isInviteTroopMember()) {
                int i3 = this.mEntrance;
                if (i3 != 11 && i3 != 35 && i3 != 36) {
                    this.mCreateTroopButton.setText(HardCodeUtil.qqStr(R.string.t9c));
                } else {
                    this.mCreateTroopButton.setText(HardCodeUtil.qqStr(R.string.f214075rx));
                }
                refreshInviteTipsBar();
                if (this.mInviteWithMsgGroup.k(this, this.mGroupCode)) {
                    this.mCreateTroopButton.setVisibility(8);
                }
            } else {
                int i16 = this.mEntrance;
                if (i16 == 44 || i16 == 49) {
                    this.mCreateTroopButton.setText(this.mDoneBtnText);
                }
            }
        }
        this.mMultiSearchView = findViewById(R.id.imj);
        this.mMultiAddContainerV = findViewById(R.id.cc8);
        Button button2 = (Button) findViewById(R.id.aii);
        this.mMultiAddBtn = button2;
        if (button2 != null) {
            button2.setOnClickListener(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(TAG, 1, "finish", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        }
        ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).notifyResultReceiver(this.mIntent, this);
        super.finish();
        BroadcastReceiver broadcastReceiver = this.videoMsgReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.videoMsgReceiver = null;
        }
        int i3 = this.mExitAnimation;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        overridePendingTransition(0, R.anim.f154423k);
                    } else {
                        overridePendingTransition(0, 0);
                    }
                } else {
                    overridePendingTransition(0, R.anim.f154458a7);
                }
            }
        } else {
            overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
        if (this.mSelectedAndSearchBar.E()) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.19
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SelectMemberActivity.this.quitSearchState();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCheckPhoneNumberResId(String str) {
        switch (checkPhoneNumber(str.substring(4), true)) {
            case -1:
                return R.string.hdo;
            case 0:
            default:
                return 0;
            case 1:
                return R.string.hdi;
            case 2:
                return R.string.hdj;
            case 3:
                return R.string.hdk;
            case 4:
                return R.string.hdl;
            case 5:
                return R.string.hdm;
            case 6:
                return R.string.hdn;
        }
    }

    public Map<String, List<TroopMemberInfo>> getIndexedFriends() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (Map) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        InnerFrameManager innerFrameManager = this.mInnerFrameManager;
        if (innerFrameManager != null && (innerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame)) {
            return ((TroopMemberListInnerFrame) this.mInnerFrameManager.getCurrentView()).E();
        }
        return null;
    }

    protected void getIntentExtras() {
        int i3;
        TroopInfo c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        Intent intent = getIntent();
        this.mIntent = intent;
        this.mType = intent.getExtras().getInt("param_type");
        this.mSubType = this.mIntent.getExtras().getInt(ISelectMemberActivityConstants.PARAM_SUBTYPE);
        this.mFrom = this.mIntent.getExtras().getInt(ISelectMemberActivityConstants.PARAM_FROM);
        this.mEntrance = this.mIntent.getIntExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 0);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getIntentExtras mType = " + this.mType + ",mSubType = " + this.mSubType + ",mFrom = " + this.mFrom + ",mEntrance = " + this.mEntrance);
        }
        this.mFilterRobot = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_FILTER_ROBOT, false);
        this.mUinsSelectedDefault = this.mIntent.getStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT);
        this.mUinsSelectedFriends = this.mIntent.getStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECTED_FRIENDS);
        ArrayList<String> stringArrayListExtra = this.mIntent.getStringArrayListExtra(ISelectMemberActivityConstants.PARAM_HIDE_UIN_LIST);
        this.mUinsToHide = stringArrayListExtra;
        if (stringArrayListExtra == null) {
            this.mUinsToHide = new ArrayList<>();
        }
        this.mUinsToHide.add(AppConstants.BABY_Q_UIN);
        List<TroopInfo> sortedJoinedValidTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getSortedJoinedValidTroopInfoFromCache();
        if (sortedJoinedValidTroopInfoFromCache != null) {
            for (TroopInfo troopInfo : sortedJoinedValidTroopInfoFromCache) {
                if (troopInfo.isQidianPrivateTroop()) {
                    this.mUinsToHide.add(troopInfo.troopuin);
                }
            }
        }
        this.mGroupCode = this.mIntent.getExtras().getString(ISelectMemberActivityConstants.PARAM_GROUPCODE);
        this.mIsTroopAdmin = this.mIntent.getExtras().getBoolean(ISelectMemberActivityConstants.PARAM_IS_TROOP_ADMIN, true);
        this.mMaxSelectNumber = this.mIntent.getIntExtra(ISelectMemberActivityConstants.PARAM_MAX, Integer.MAX_VALUE);
        if (!TextUtils.isEmpty(this.mGroupCode) && !TextUtils.equals("0", this.mGroupCode) && (c16 = com.tencent.mobileqq.selectmember.util.a.c(this.app, this.mGroupCode)) != null) {
            int i16 = c16.wMemberMax - c16.wMemberNum;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mMaxSelectNumber:" + this.mMaxSelectNumber + " remain:" + i16 + "  wMemberMax:" + c16.wMemberMax + "  wMemberNum:" + c16.wMemberNum + "  real mMaxSelectNumber" + Math.min(this.mMaxSelectNumber, i16));
            }
            if (i16 > 0 && this.mMaxSelectNumber > i16) {
                this.mMaxSelectNumber = i16;
                this.mIsLimitToInviteByTroopMaxLimit = true;
            }
        }
        this.mMinSelectNumber = this.mIntent.getIntExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        this.mShowMyself = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_SHOW_MYSELF, false);
        this.mDonotNeedContacts = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, false);
        this.mDonotNeedTroop = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_TROOP, false);
        this.mDonotNeedDiscussion = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_DISCUSSION, false);
        this.mOnlyFriends = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, false);
        this.mOnlyTroopMember = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, false);
        this.mOnlyDiscussionMember = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ONLY_DISCUSSION_MEMBER, false);
        this.mOnlySelectTroopOrDiscussionMember = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_OR_DISCUSSION_MEMBER, false);
        this.mOnlyFaceToFaceTroop = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_FACE_TO_FACE_TROOP, false);
        this.mOverloadTipsIncludeDefaultCount = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_OVERLOAD_TIPS_INCLUDE_DEFAULT_COUNT, false);
        String stringExtra = this.mIntent.getStringExtra(ISelectMemberActivityConstants.PARAM_TITLE);
        this.mTitleString = stringExtra;
        if (stringExtra == null) {
            this.mTitleString = getString(R.string.hcv);
        }
        String stringExtra2 = this.mIntent.getStringExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING);
        this.mDoneBtnText = stringExtra2;
        if (stringExtra2 == null) {
            this.mDoneBtnText = getString(R.string.hd9);
        }
        String stringExtra3 = this.mIntent.getStringExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING);
        this.mDoneBtnText_x = stringExtra3;
        if (stringExtra3 == null) {
            this.mDoneBtnText_x = this.mDoneBtnText + "({0})";
        }
        this.mIsShowDoneButtonInBottom = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_SHOW_DONE_BUTTON_IN_BOTTOM, false);
        this.mAddPassedMembersToResultSet = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ADD_PASSED_MEMBERS_TO_RESULT_SET, false);
        this.mExitAnimation = this.mIntent.getIntExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 0);
        this.mBackButtonSide = this.mIntent.getIntExtra(ISelectMemberActivityConstants.PARAM_BACK_BUTTON_SIDE, 1);
        this.mIsPutMySelfFirst = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_IS_PUT_MYSELF_FIRST, false);
        this.mIsForbidOnlyChooseMySelf = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_IS_FORBID_ONLY_CHOOSE_MYSELF, false);
        int i17 = this.mEntrance;
        if (i17 != 14 && i17 != 21) {
            if ((i17 != 32 && i17 != 43 && i17 != 35) || (!this.mOnlyTroopMember && !this.mOnlyDiscussionMember)) {
                if ((i17 == 17 || i17 == 48) && this.mUinsSelectedFriends != null) {
                    for (int i18 = 0; i18 < this.mUinsSelectedFriends.size(); i18++) {
                        if (!TextUtils.isEmpty(this.mUinsSelectedFriends.get(i18))) {
                            ResultRecord resultRecord = new ResultRecord();
                            resultRecord.uin = this.mUinsSelectedFriends.get(i18);
                            this.mResultList.add(resultRecord);
                        }
                    }
                }
            } else {
                doEnableAllSelect(-1);
                String stringExtra4 = this.mIntent.getStringExtra("group_uin");
                if (!TextUtils.isEmpty(stringExtra4) && !this.mIsSelectAllMembers && this.mUinsSelectedFriends != null) {
                    for (int i19 = 0; i19 < this.mUinsSelectedFriends.size(); i19++) {
                        if (!TextUtils.isEmpty(this.mUinsSelectedFriends.get(i19))) {
                            ResultRecord resultRecord2 = new ResultRecord();
                            resultRecord2.uin = this.mUinsSelectedFriends.get(i19);
                            if (this.mOnlyDiscussionMember) {
                                i3 = 2;
                            } else {
                                i3 = 1;
                            }
                            resultRecord2.type = i3;
                            resultRecord2.groupUin = stringExtra4;
                            this.mResultList.add(resultRecord2);
                        }
                    }
                }
            }
        } else {
            ArrayList parcelableArrayListExtra = this.mIntent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_DEFAULT_SELECTED_TROOP_MEMBERS);
            if (parcelableArrayListExtra != null) {
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    this.mResultList.add((ResultRecord) it.next());
                }
            }
        }
        this.isSupportSelectFriendGroup = this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_IS_SUPPORT_SELECT_FROM_FRIEND_GROUPS, false);
        QLog.d(TAG, 1, String.format("getIntentExtras [%d,%d,%d,%d,%s]", Integer.valueOf(this.mType), Integer.valueOf(this.mSubType), Integer.valueOf(this.mFrom), Integer.valueOf(this.mEntrance), this.mGroupCode));
    }

    public com.tencent.mobileqq.adapter.e getMemberListAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (com.tencent.mobileqq.adapter.e) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        InnerFrameManager innerFrameManager = this.mInnerFrameManager;
        if (innerFrameManager != null && (innerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame)) {
            return ((TroopMemberListInnerFrame) this.mInnerFrameManager.getCurrentView()).F();
        }
        return null;
    }

    int getNotAdminInviteMemberCount() {
        long v3 = Utils.v();
        String string = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getString(INDEX_NOT_ADMIN_INVITE_MEMBER_COUNT, null);
        if (string == null) {
            return 0;
        }
        try {
            String[] split = string.split(":");
            if (Long.parseLong(split[0]) != v3) {
                return 0;
            }
            return Integer.parseInt(split[1]);
        } catch (Exception unused) {
            return 0;
        }
    }

    ArrayList<ResultRecord> getOutGroupMem() {
        if (this.mEntrance == 11 && this.mGroupmembers != null) {
            ArrayList<ResultRecord> arrayList = new ArrayList<>();
            Iterator<ResultRecord> it = this.mResultList.iterator();
            while (it.hasNext()) {
                ResultRecord next = it.next();
                if (!isGroupMember(next.uin)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        return this.mResultList;
    }

    public ArrayList<ResultRecord> getResultRecordList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (ArrayList) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        ArrayList<ResultRecord> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.mResultList.size(); i3++) {
            arrayList.add(this.mResultList.get(i3));
        }
        ArrayList<String> arrayList2 = this.mUinsSelectedDefault;
        if (arrayList2 != null) {
            Iterator<String> it = arrayList2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.uin = next;
                resultRecord.type = 0;
                resultRecord.groupUin = "-1";
                resultRecord.name = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getNickName(this.app, resultRecord.uin, resultRecord.type);
                arrayList.add(resultRecord);
            }
        }
        return arrayList;
    }

    public List<String> getResultUins() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (List) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mResultList.size(); i3++) {
            arrayList.add(this.mResultList.get(i3).uin);
        }
        return arrayList;
    }

    public ArrayList<String> getSelectedUinList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (ArrayList) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.mResultList.size(); i3++) {
            arrayList.add(this.mResultList.get(i3).uin);
        }
        ArrayList<String> arrayList2 = this.mUinsSelectedDefault;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    protected String getTroopCodeFromTroopUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
        }
        TroopInfo findTroopInfo = findTroopInfo(str);
        if (findTroopInfo != null) {
            return findTroopInfo.troopcode;
        }
        return null;
    }

    TroopInfo getTroopInfo(String str) {
        return ((ITroopInfoService) this.app.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this)).intValue();
        }
        return this.mType;
    }

    protected void initInnerFrameManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mInnerFrameManager.c(this);
        this.mInnerFrameManager.setAppIntf((BaseQQAppInterface) this.app);
        if (this.mFrom == 30) {
            this.mInnerFrameManager.j(9, this.mIntent.getExtras());
            return;
        }
        if (this.mOnlyTroopMember) {
            this.mInnerFrameManager.j(6, this.mIntent.getExtras());
            return;
        }
        if (this.mOnlyDiscussionMember) {
            this.mInnerFrameManager.j(7, this.mIntent.getExtras());
        } else if (this.mOnlySelectTroopOrDiscussionMember) {
            this.mInnerFrameManager.j(3, this.mIntent.getExtras());
        } else {
            this.mInnerFrameManager.i(0);
        }
    }

    public void initSearchBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (this.imm == null) {
            this.imm = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        }
        this.mSearchResultLayout.setOnTouchListener(new c());
    }

    @SuppressLint({"NewApi"})
    protected void initSelectedBar() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this)) {
            this.mSelectedAndSearchBar.setIsFrom(1);
        }
        this.mSelectedAndSearchBar.s(this.mResultList, this.mFaceDecoder, this.mSelectedAndSearchBarCallback);
        if ((this.mResultList.size() != 0 && ((i3 = this.mEntrance) == 14 || i3 == 21 || i3 == 43)) || this.mEntrance == 32) {
            Iterator<ResultRecord> it = this.mResultList.iterator();
            while (it.hasNext()) {
                ResultRecord next = it.next();
                int i16 = this.mEntrance;
                if (i16 != 32 && i16 != 43) {
                    initTroopMemberName(next);
                } else {
                    int i17 = next.type;
                    if (i17 == 1) {
                        initTroopMemberName(next);
                    } else if (i17 == 2) {
                        next.name = ((IDiscussionService) this.app.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberName(next.groupUin, next.uin);
                    }
                }
            }
            this.mSelectedAndSearchBar.p(true);
            checkNeedGameInfo(this, "", 1);
        } else if (!this.mResultList.isEmpty() && this.mEntrance == 48) {
            this.mSelectedAndSearchBar.p(true);
        }
        this.mRightBtn.setOnClickListener(new o());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTitleBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.mLeftBackBtn.setVisibility(0);
        this.mLeftCancelBtn.setVisibility(8);
        this.mRightBtn.setVisibility(0);
        this.mLeftBackBtn.setText(R.string.f173096hd0);
        this.mLeftBackBtn.setBackgroundResource(0);
        this.mLeftBackBtn.setPadding(0, 0, 0, 0);
        setTitleText(this.mTitleString);
        if (AppSetting.f99565y) {
            this.mTitle.setContentDescription(this.mTitleString);
            this.mLeftBackBtn.setContentDescription(getString(R.string.f173096hd0));
        }
        if (isShowDoneButtonInBottom()) {
            this.mRightBtn.setVisibility(8);
            if (isCreateNewTroopEntrance()) {
                this.mLeftBackBtn.setText("");
                configLeftBackIconDrawable();
            } else if (!isInviteTroopMember() && this.mEntrance != 49) {
                this.mLeftBackBtn.setText("");
                configLeftBackIconDrawable();
            } else {
                this.mLeftBackBtn.setText(R.string.cancel);
                this.mLeftBackBtn.setBackgroundDrawable(null);
            }
            this.mLeftCancelBtn.setVisibility(8);
        }
        this.mLeftBackBtn.setOnClickListener(new m());
        setupDoneBtn();
        if (this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ShowInviteEntry, false)) {
            if (this.mEntrance == 35) {
                this.mRightBtn.setText(R.string.vqr);
                com.tencent.av.share.a.o();
            } else {
                this.mRightBtn.setText(R.string.vqs);
            }
            this.mRightBtn.setVisibility(0);
            this.mRightBtn.setAccessibilityTraversalAfter(R.id.ivTitleName);
        }
    }

    boolean isCreateNewTroopEntrance() {
        int i3 = this.mEntrance;
        if (i3 != 27 && i3 != 28 && i3 != 12 && i3 != 29 && i3 != 39) {
            return false;
        }
        return true;
    }

    boolean isCreateNewTypeTroop() {
        int i3;
        boolean isCreateNewTroopEntrance = isCreateNewTroopEntrance();
        int size = this.mResultList.size();
        ArrayList<String> arrayList = this.mUinsSelectedDefault;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        int i16 = size + i3;
        if (!isCreateNewTroopEntrance || this.mSubType != 0 || i16 < 1) {
            return false;
        }
        return true;
    }

    boolean isGroupMember(String str) {
        Iterator<TroopMemberInfo> it = this.mGroupmembers.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().memberuin, str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInviteMemberFromTroopSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this)).booleanValue();
        }
        if (this.mEntrance == 38) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInviteTroopMember() {
        if (this.mType == 1 && this.mSubType == 1) {
            return true;
        }
        return false;
    }

    public boolean isInvitedListContainFriend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str)).booleanValue();
        }
        for (int i3 = 0; i3 < this.mInvitedUinList.size(); i3++) {
            if (this.mInvitedUinList.get(i3).equals(str)) {
                return true;
            }
        }
        return false;
    }

    boolean isMemberOverLoad(String str, boolean z16, String str2, String str3, int i3, String str4) {
        ArrayList<String> arrayList;
        ArrayList<TroopMemberInfo> arrayList2;
        int i16 = this.mEntrance;
        if ((i16 == 32 || i16 == 43) && z16 && this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, false)) {
            return false;
        }
        int i17 = this.mType;
        if (i17 == 3000) {
            int size = this.mResultList.size();
            int i18 = this.mMaxSelectNumber;
            if (size < i18) {
                return false;
            }
            if (this.mEntrance == 12 && i18 == 1) {
                showMemberOverloadToast(R.string.atx);
            } else {
                showMemberOverloadToast(R.string.ato);
            }
        } else if (i17 == 1) {
            if (this.mIsLimitToInviteByTroopMaxLimit && this.mResultList.size() >= this.mMaxSelectNumber) {
                showMemberOverloadToast(HardCodeUtil.qqStr(R.string.t9o));
            } else {
                int i19 = this.mSubType;
                if (i19 == 0) {
                    if (this.mResultList.size() < this.mMaxSelectNumber) {
                        return false;
                    }
                    showMemberOverloadToast(getString(R.string.i9o));
                } else if (i19 == 1) {
                    if (this.mResultList.size() >= this.mMaxSelectNumber) {
                        showMemberOverloadToast(R.string.i9o);
                    } else {
                        if (this.mEntrance != 11 || (arrayList2 = this.mGroupmembers) == null) {
                            return false;
                        }
                        int size2 = arrayList2.size() + 1;
                        String stringExtra = this.mIntent.getStringExtra("group_uin");
                        int memNumForAutoInviteIntoGroup = getTroopInfo(stringExtra).getMemNumForAutoInviteIntoGroup(this.app.getCurrentUin());
                        int i26 = memNumForAutoInviteIntoGroup > size2 ? memNumForAutoInviteIntoGroup - size2 : 0;
                        int size3 = getOutGroupMem().size();
                        int size4 = this.mResultList.size() - size3;
                        boolean isGroupMember = isGroupMember(str2);
                        if (QLog.isColorLevel()) {
                            QLog.w(TAG, 1, "isMemberOverLoad[" + str + "], \u53ef\u9080\u8bf7\u7684\u7fa4\u5916\u6210\u5458\u5230\u8fbe\u4e0a\u9650\u68c0\u67e5, \u5df2\u7ecf\u9009\u62e9\u7fa4\u5185\u6210\u5458[" + size4 + "], \u5f53\u524d\u7fa4\u6210\u5458[" + size2 + "], \u5b9e\u9645\u53ef\u9080\u8bf7\u7684\u7fa4\u5916\u6210\u5458[" + i26 + "], \u5df2\u7ecf\u9009\u62e9\u7684\u7fa4\u5916\u6210\u5458[" + size3 + "], \u5f53\u524d\u9009\u62e9\u7684\u662f\u7fa4\u6210\u5458[" + isGroupMember + "], uin[" + str2 + "], name[" + str3 + "], type[" + i3 + "], fromGroupUin[" + str4 + "], mResultList[" + this.mResultList.size() + "], groupUin[" + stringExtra + "], mGroupCode[" + this.mGroupCode + "]");
                        }
                        if (!isGroupMember) {
                            size3++;
                        }
                        if (size3 <= i26) {
                            return false;
                        }
                        showMemberOverloadToast(R.string.f173236i91);
                    }
                } else if (i19 == 3) {
                    if (this.mResultList.size() < this.mMaxSelectNumber) {
                        return false;
                    }
                    showMemberOverloadToast(getString(R.string.i8z));
                    String str5 = this.mGroupCode;
                    StringBuilder sb5 = new StringBuilder();
                    ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                    AppInterface appInterface = this.app;
                    sb5.append(iSelectMemberRefatorHelperApi.getMemberType(appInterface, appInterface.getCurrentAccountUin(), this.mGroupCode));
                    sb5.append("");
                    ReportController.o(null, "dc00899", "Grp_video", "", "invite", "toast_over", 0, 0, str5, sb5.toString(), "", "");
                } else if (i19 == 4) {
                    int size5 = this.mResultList.size();
                    int i27 = this.mMaxSelectNumber;
                    if (size5 < i27) {
                        return false;
                    }
                    showMemberOverloadToast(getString(R.string.i5q, Integer.valueOf(i27)));
                } else {
                    if (this.mResultList.size() < this.mMaxSelectNumber) {
                        return false;
                    }
                    if (this.mEntrance == 35) {
                        showMemberOverloadToast(R.string.i9o);
                    } else {
                        showMemberOverloadToast(R.string.i8z);
                    }
                }
            }
        } else if (i17 == 9003) {
            int i28 = this.mEntrance;
            if (i28 == 15) {
                if (this.mResultList.size() < ((IBlessApi) QRoute.api(IBlessApi.class)).getAvailableSendCount(this.app)) {
                    return false;
                }
                showMemberOverloadToast(String.format(getString(R.string.f170627wc), Integer.valueOf(((IBlessApi) QRoute.api(IBlessApi.class)).getTotalSendLimit(this.app))));
            } else {
                if (i28 != 32 || this.mResultList.size() < ((IBlessApi) QRoute.api(IBlessApi.class)).getWebAvailableSendCount(this.app)) {
                    return false;
                }
                showMemberOverloadToast(String.format(getString(R.string.f170627wc), Integer.valueOf(((IBlessApi) QRoute.api(IBlessApi.class)).getWebTotalSendLimit(this.app))));
            }
        } else {
            if (this.mResultList.size() < this.mMaxSelectNumber) {
                return false;
            }
            int size6 = (!this.mOverloadTipsIncludeDefaultCount || (arrayList = this.mUinsSelectedDefault) == null) ? 0 : arrayList.size();
            int i29 = this.mEntrance;
            if (i29 == 44 || i29 == 49) {
                showMemberOverloadToast(getString(R.string.i8z));
            } else {
                showMemberOverloadToast(String.format(getString(R.string.cpx), Integer.valueOf(size6 + this.mMaxSelectNumber)));
            }
        }
        return true;
    }

    protected boolean isMemberOverload(String str, String str2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (this.mType != 9003) {
            return false;
        }
        if (this.mEntrance == 15 && !((IBlessApi) QRoute.api(IBlessApi.class)).isUinBlessed(this.app, str) && this.mUnblessedUinCount >= ((IBlessApi) QRoute.api(IBlessApi.class)).getAvailableUinCount(this.app)) {
            showMemberOverloadToast(String.format(getString(R.string.f170628we), Integer.valueOf(((IBlessApi) QRoute.api(IBlessApi.class)).getTotalUinLimit(this.app))));
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mEntrance == 32 && !((IBlessApi) QRoute.api(IBlessApi.class)).isWebUinSended(this.app, str) && this.mUnblessedUinCount >= ((IBlessApi) QRoute.api(IBlessApi.class)).getWebAvailableUinCount(this.app)) {
            showMemberOverloadToast(String.format(getString(R.string.ifo), Integer.valueOf(((IBlessApi) QRoute.api(IBlessApi.class)).getWebTotalUinLimit(this.app))));
            return true;
        }
        return z16;
    }

    public boolean isResultListContainFriend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str)).booleanValue();
        }
        for (int i3 = 0; i3 < this.mResultList.size(); i3++) {
            if (this.mResultList.get(i3).uin.equals(str)) {
                return true;
            }
        }
        return false;
    }

    boolean isShowDoneButtonInBottom() {
        int i3;
        if (isCreateNewTroopEntrance() || isInviteTroopMember() || (i3 = this.mEntrance) == 35 || i3 == 40 || i3 == 49) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "isShowDoneButtonInBottom return " + this.mIsShowDoneButtonInBottom);
        }
        return this.mIsShowDoneButtonInBottom;
    }

    public boolean isSoftInputShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return this.mIsSoftInputShowing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return false;
    }

    public void notifyListOrSearchChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, z16);
            return;
        }
        InnerFrameManager innerFrameManager = this.mInnerFrameManager;
        if (innerFrameManager != null && (innerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame)) {
            ((TroopMemberListInnerFrame) this.mInnerFrameManager.getCurrentView()).p();
        }
        if (z16) {
            adjustGridView(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x032c  */
    @Override // com.tencent.mobileqq.search.view.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAction(View view) {
        String str;
        boolean z16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) view);
            return;
        }
        com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) view.getTag(R.id.kxb);
        if (kVar == 0) {
            return;
        }
        if (this.mEntrance == 33) {
            ReportController.o(this.app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "friendpay.selectpage.searchclick", 0, 0, "", "", "", "");
        }
        String uin = kVar.getUin();
        String charSequence = kVar.getTitleSpans().toString();
        boolean z17 = kVar instanceof com.tencent.mobileqq.search.model.m;
        if (z17) {
            str = ((com.tencent.mobileqq.search.model.m) kVar).d();
        } else if (kVar instanceof com.tencent.mobileqq.search.model.p) {
            str = ((com.tencent.mobileqq.search.model.p) kVar).getTroopUin();
        } else {
            str = "-1";
        }
        String str3 = str;
        boolean z18 = kVar instanceof com.tencent.mobileqq.search.model.q;
        if (z18) {
            PhoneContact b16 = ((com.tencent.mobileqq.search.model.q) kVar).b();
            if (TextUtils.isEmpty(b16.uin)) {
                uin = "pstn" + b16.mobileNo;
            } else if (b16.uin.equals("0")) {
                uin = b16.nationCode + b16.mobileCode;
            } else {
                uin = b16.uin;
            }
        }
        String str4 = uin;
        if (kVar instanceof com.tencent.mobileqq.search.model.l) {
            Bundle bundle = new Bundle();
            bundle.putString("group_uin", kVar.getUin());
            bundle.putString("group_name", kVar.getTitle());
            this.mInnerFrameManager.j(7, bundle);
            quitSearchState();
            return;
        }
        if (kVar instanceof com.tencent.mobileqq.search.model.o) {
            TroopInfo a16 = ((com.tencent.mobileqq.search.model.o) kVar).a();
            if (!a16.isAllowCreateDiscuss() && !a16.isTroopOwner(this.app.getCurrentAccountUin()) && !a16.isTroopAdmin(this.app.getCurrentAccountUin())) {
                QQToast.makeText(this, 0, getResources().getString(R.string.f171405es2), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("group_uin", kVar.getUin());
            bundle2.putString("group_name", kVar.getTitle());
            this.mInnerFrameManager.j(6, bundle2);
            quitSearchState();
            return;
        }
        if (kVar instanceof r) {
            TroopInfo a17 = ((r) kVar).a();
            if (!a17.isAllowCreateDiscuss() && !a17.isTroopOwner(this.app.getCurrentAccountUin()) && !a17.isTroopAdmin(this.app.getCurrentAccountUin())) {
                QQToast.makeText(this, 0, getResources().getString(R.string.f171405es2), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("group_uin", kVar.getUin());
            bundle3.putString("group_name", kVar.getTitle());
            this.mInnerFrameManager.j(6, bundle3);
            quitSearchState();
            return;
        }
        if (isInvitedListContainFriend(str4)) {
            QQToast.makeText(this, 1, HardCodeUtil.qqStr(R.string.t9z), 0).show(getTitleBarHeight());
            ReportController.o(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, str3, "", "", "");
            return;
        }
        ArrayList<String> arrayList = this.mUinsSelectedDefault;
        if ((arrayList == null || !arrayList.contains(str4)) && !isResultListContainFriend(str4) && !isMemberOverLoad("onAction", false, str4, charSequence, -1, str3) && !isMemberOverload(str4, charSequence)) {
            SelectMemberInnerFrame selectMemberInnerFrame = (SelectMemberInnerFrame) this.mInnerFrameManager.getCurrentView();
            int i3 = 4;
            if (this.mInnerFrameManager.b() != 5 && this.mInnerFrameManager.b() != 0 && this.mInnerFrameManager.b() != 4 && this.mInnerFrameManager.b() != 3 && this.mInnerFrameManager.b() != 8) {
                if (this.mInnerFrameManager.b() == 6) {
                    this.mResultList.add(constructAResultRecord(str4, charSequence, 1, selectMemberInnerFrame.o()));
                } else if (this.mInnerFrameManager.b() == 7) {
                    this.mResultList.add(constructAResultRecord(str4, charSequence, 2, selectMemberInnerFrame.o()));
                } else if (this.mInnerFrameManager.b() == 1) {
                    if (str4.startsWith("pstn") && preAddPstnNumber(str4, charSequence, 5, selectMemberInnerFrame.o())) {
                        this.mResultList.add(constructAResultRecord(str4, charSequence, 5, selectMemberInnerFrame.o()));
                    } else if (str4.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                        this.mResultList.add(constructAResultRecord(str4, charSequence, 4, selectMemberInnerFrame.o()));
                    } else {
                        z16 = false;
                        this.mResultList.add(constructAResultRecord(str4, charSequence, 0, selectMemberInnerFrame.o()));
                    }
                } else {
                    z16 = false;
                    if (this.mInnerFrameManager.b() == 9) {
                        ResultRecord constructAResultRecord = constructAResultRecord(str4, charSequence, 1, selectMemberInnerFrame.o());
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(constructAResultRecord);
                        addFriendResults(arrayList2, false);
                    }
                }
                z16 = false;
            } else {
                z16 = false;
                if (z17) {
                    i3 = 2;
                } else if (kVar instanceof com.tencent.mobileqq.search.model.p) {
                    i3 = 1;
                } else {
                    if (kVar instanceof s) {
                        s sVar = (s) kVar;
                        if (sVar.c()) {
                            str2 = sVar.getGroupCode();
                            i3 = 1;
                        }
                        i3 = 0;
                    } else {
                        if (!(kVar instanceof com.tencent.mobileqq.search.model.n)) {
                            if (z18) {
                                if (str4.startsWith("pstn")) {
                                    str2 = str3;
                                    if (preAddPstnNumber(str4, charSequence, 5, str2)) {
                                        i3 = 5;
                                    }
                                } else {
                                    str2 = str3;
                                }
                                if (!str4.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                    i3 = 0;
                                }
                            } else {
                                str2 = str3;
                                i3 = -1;
                            }
                        }
                        i3 = 0;
                    }
                    if (i3 != -1) {
                        this.mResultList.add(constructAResultRecord(str4, charSequence, i3, str2));
                    }
                }
                str2 = str3;
                if (i3 != -1) {
                }
            }
            onResultListChanged();
            setupDoneBtn();
            selectMemberInnerFrame.p();
            this.mSelectedAndSearchBar.p(true);
            com.tencent.mobileqq.search.view.f fVar = this.contactSearchFragment;
            if (fVar != null && fVar.L5()) {
                QLog.i(TAG, 2, "current search is multi mode select, do not dismiss");
                this.mSelectedAndSearchBar.w();
            } else {
                this.mSelectedAndSearchBar.u();
            }
            if (this.mType == 9003) {
                if (this.mEntrance == 15 && !((IBlessApi) QRoute.api(IBlessApi.class)).isUinBlessed(this.app, str4)) {
                    this.mUnblessedUinCount++;
                } else if (this.mEntrance == 32 && !((IBlessApi) QRoute.api(IBlessApi.class)).isWebUinSended(this.app, str4)) {
                    this.mUnblessedUinCount++;
                }
            }
            startRelationFriendAndTroopSearch(z16);
            checkNeedGameInfo(this, str4, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.mSelectedAndSearchBar.z())) {
            quitSearchState();
            return true;
        }
        if (this.mSelectedAndSearchBar.E()) {
            quitSearchState();
        }
        switch (this.mInnerFrameManager.b()) {
            case 1:
            case 2:
            case 4:
            case 5:
                stopTitleProgress();
                this.mInnerFrameManager.i(0);
                return true;
            case 3:
                if (this.mOnlySelectTroopOrDiscussionMember) {
                    if (this.mEntrance == 27) {
                        this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
                        ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
                        setResult(-1, this.mIntent);
                    }
                    finish();
                } else {
                    stopTitleProgress();
                    this.mInnerFrameManager.i(0);
                }
                return true;
            case 6:
                if (this.mOnlyTroopMember) {
                    finish();
                } else {
                    stopTitleProgress();
                    this.mInnerFrameManager.i(3);
                }
                return true;
            case 7:
                if (this.mOnlyDiscussionMember) {
                    finish();
                } else {
                    stopTitleProgress();
                    this.mInnerFrameManager.i(3);
                }
                return true;
            case 8:
                this.mInnerFrameManager.i(0);
                return true;
            case 9:
                finish();
                break;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.jsq) {
                this.mTooManyMembersTipsBar.setVisibility(8);
                this.isClosed = true;
                AppInterface appInterface = this.app;
                String str2 = this.mGroupCode;
                StringBuilder sb5 = new StringBuilder();
                ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                AppInterface appInterface2 = this.app;
                sb5.append(iSelectMemberRefatorHelperApi.getMemberType(appInterface2, appInterface2.getCurrentAccountUin(), this.mGroupCode));
                sb5.append("");
                ReportController.o(appInterface, "dc00899", "invite_friend", "", "friend_list", "Clk_close", 0, 0, str2, sb5.toString(), "", "");
            } else {
                String str3 = null;
                int i16 = 0;
                if (id5 == R.id.bbt) {
                    if (this.mEntrance == 35) {
                        if (this.mResultList.size() >= 1) {
                            str = "1";
                        } else {
                            str = "2";
                        }
                        ReportController.o(this.app, "CliOper", "", "", "0X8009E2B", "0X8009E2B", 0, 0, str, "", "", "");
                    }
                    if (this.mEntrance == 12 && this.mResultList.size() == 1) {
                        ResultRecord resultRecord = this.mResultList.get(0);
                        Intent intent = new Intent();
                        intent.putExtra("select_memeber_single_friend", true);
                        intent.putExtra("select_memeber_single_friend_type", resultRecord.type);
                        int i17 = resultRecord.type;
                        if (i17 == 1) {
                            str3 = resultRecord.groupUin;
                            i3 = 1000;
                        } else {
                            i3 = 0;
                        }
                        if (i17 == 2) {
                            str3 = resultRecord.groupUin;
                            i3 = 1004;
                        }
                        if (i17 == 3) {
                            i3 = 1021;
                        } else if (i17 == 4) {
                            i3 = 1006;
                        }
                        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(resultRecord.uin), TAG)) {
                            i16 = i3;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("uin", resultRecord.uin);
                        bundle.putInt("uintype", i16);
                        bundle.putString("uinname", resultRecord.name);
                        bundle.putString("troop_uin", str3);
                        intent.putExtras(bundle);
                        setResult(-1, intent);
                        finish();
                    } else if (isCreateNewTroopEntrance()) {
                        createNewTypeDiscussion();
                    } else if (isInviteTroopMember()) {
                        int i18 = this.mEntrance;
                        if (i18 == 11) {
                            ArrayList<ResultRecord> outGroupMem = getOutGroupMem();
                            if (outGroupMem.size() > 0) {
                                DialogUtil.createCustomDialog(this, 230, getString(R.string.dfp), getString(R.string.dcm), R.string.d_2, R.string.d_d, new h(outGroupMem), new i()).show();
                            } else {
                                afterCreateTroopSucc(this.mIntent.getStringExtra("group_uin"), false);
                            }
                        } else if (i18 == 37) {
                            this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
                            setResult(-1, this.mIntent);
                            finish();
                        } else {
                            doInviteTroopMember(this.mResultList);
                        }
                    } else if (this.mEntrance == 49) {
                        handleGuildInviteFriends();
                    } else {
                        this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
                        setResult(-1, this.mIntent);
                        finish();
                    }
                } else if (id5 == R.id.aii) {
                    quitSearchState();
                    if (getResultUins().size() == 1) {
                        String str4 = getResultUins().get(0);
                        p pVar = this.mOnSelectStateChangeListener;
                        if (pVar != null) {
                            pVar.c(str4);
                        }
                    } else {
                        String stringExtra = getIntent().getStringExtra("group_uin");
                        ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).startUnitedVerifyMsgEditFragment(this, stringExtra, 10);
                        if (!TextUtils.isEmpty(stringExtra)) {
                            ThreadManagerV2.post(new Runnable(stringExtra) { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.23
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f285710d;

                                {
                                    this.f285710d = stringExtra;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this, (Object) stringExtra);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                                        ReportController.o(selectMemberActivity.app, "dc00899", "Grp_addFrd", "", "frd_select", "multiMode_add", 0, 0, this.f285710d, String.valueOf(selectMemberActivity.getResultUins().size()), "", "");
                                    }
                                }
                            }, 5, null, true);
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onCreateTroopCompletely(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
        } else if (i3 == 0 && !TextUtils.isEmpty(str)) {
            ReportController.o(this.app, "dc00899", "Grp_create", "", "choose_cre", "cre_suc", 0, 0, str, "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onInviteComplete(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        boolean z16 = true;
        if (QLog.isColorLevel() || i3 != 0) {
            QLog.w(TAG, 1, "onInviteComplete, retCode[" + i3 + "], troopUin[" + str + "], mSubType[" + this.mSubType + "], mEntrance[" + this.mEntrance + "]");
        }
        if (i3 != 0) {
            z16 = false;
        }
        if (z16) {
            afterCreateTroopSucc(str, false);
        } else {
            QQToast.makeText(this, getString(R.string.as5), 2000).show(this.mTitleBar.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onListViewItemClick(String str, String str2, int i3, String str3) {
        return innerOnItemClick(str, str2, i3, str3) != null;
    }

    public void onRelationTroopItemClick(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) str);
            return;
        }
        int i3 = this.mEntrance;
        if (i3 == 38 || i3 == 29 || i3 == 39) {
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "onRelationTroopItemClick: empty");
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "onRelationTroopItemClick: troopUin:" + str);
                }
                onReusedTroop(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onRestart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResultListChanged() {
        String str;
        int i3;
        String format;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        Iterator<ResultRecord> it = this.mResultList.iterator();
        String str2 = null;
        int i17 = 0;
        while (it.hasNext()) {
            ResultRecord next = it.next();
            if (next.type == 5) {
                if (i17 >= 3) {
                    break;
                }
                if (str2 == null) {
                    str2 = next.name;
                } else {
                    str2 = str2 + "\u3001" + next.name;
                }
                i17++;
            }
        }
        com.tencent.mobileqq.search.view.f fVar = this.contactSearchFragment;
        if (fVar != null) {
            fVar.B5(getResultUins(), getJoinUins());
        }
        if (isShowDoneButtonInBottom()) {
            int size = this.mResultList.size();
            boolean z16 = true;
            if (size > 0) {
                int i18 = this.mEntrance;
                if (i18 != 35 && i18 != 40 && i18 != 49) {
                    if (i18 == 44) {
                        format = this.mDoneBtnText;
                    } else {
                        if (isCreateNewTroopEntrance()) {
                            i16 = R.string.t_9;
                        } else {
                            i16 = R.string.t9m;
                        }
                        format = MessageFormat.format(HardCodeUtil.qqStr(i16), Integer.valueOf(size));
                    }
                } else {
                    format = MessageFormat.format(this.mDoneBtnText_x, Integer.valueOf(size));
                }
                this.mCreateTroopButton.setText(format);
                this.mCreateTroopButton.setContentDescription(format);
                this.mCreateTroopButton.setEnabled(true);
                this.mInviteWithMsgGroup.w(true, size);
            } else {
                int i19 = this.mEntrance;
                if (i19 == 35) {
                    str = this.mDoneBtnText;
                } else {
                    if (i19 != 40 && i19 != 44 && i19 != 49) {
                        if (isCreateNewTroopEntrance()) {
                            i3 = R.string.t9d;
                        } else {
                            i3 = R.string.t_a;
                        }
                        str = HardCodeUtil.qqStr(i3);
                    } else {
                        str = this.mDoneBtnText;
                    }
                    z16 = false;
                }
                this.mCreateTroopButton.setText(str);
                this.mCreateTroopButton.setContentDescription(str);
                this.mCreateTroopButton.setEnabled(z16);
                this.mInviteWithMsgGroup.w(z16, 0);
            }
        }
        if (isInviteTroopMember()) {
            refreshInviteTipsBar();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onReusedTroop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 1, "onReusedTroop,troopUin[" + str + "], mSubType[" + this.mSubType + "], mEntrance[" + this.mEntrance + "]");
        }
        afterCreateTroopSucc(str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onTroopMemberItemClick(String str, String str2, int i3, String str3, TroopMemberNickInfo troopMemberNickInfo) {
        ResultRecord innerOnItemClick = innerOnItemClick(str, str2, i3, str3);
        if (innerOnItemClick != null) {
            innerOnItemClick.memberNickInfo = troopMemberNickInfo;
        }
        if (innerOnItemClick != null) {
            return true;
        }
        return false;
    }

    boolean preAddPstnNumber(String str, String str2, int i3, String str3) {
        boolean z16;
        if (i3 != 5) {
            return true;
        }
        boolean isNotMaxOfPSTN = isNotMaxOfPSTN();
        if (!isNotMaxOfPSTN) {
            QQToast.makeText(this, R.string.hdp, 1).show(getTitleBarHeight());
        }
        int checkPhoneNumberResId = getCheckPhoneNumberResId(str);
        if (checkPhoneNumberResId == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QQToast.makeText(this, checkPhoneNumberResId, 1).show(getTitleBarHeight());
        }
        if (isNotMaxOfPSTN && z16) {
            return true;
        }
        return false;
    }

    protected ArrayList<ResultRecord> processResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (ArrayList) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        ArrayList<ResultRecord> arrayList = new ArrayList<>();
        Iterator<ResultRecord> it = this.mResultList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            if (next.type == 5) {
                if (next.uin.startsWith("pstn")) {
                    next.uin = next.uin.substring(4);
                }
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void qCircleReport(ArrayList<ResultRecord> arrayList, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) arrayList, i3);
            return;
        }
        if (arrayList != null) {
            Iterator<ResultRecord> it = arrayList.iterator();
            StringBuilder sb5 = null;
            while (it.hasNext()) {
                ResultRecord next = it.next();
                if (next != null && !TextUtils.isEmpty(next.uin)) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder(next.uin + "");
                    } else {
                        sb5.append("|" + next.uin);
                    }
                }
            }
            if (sb5 != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                if (i3 == 41) {
                    str = "1";
                } else {
                    str = "2";
                }
                hashMap.put("ext1", str);
                hashMap.put("ext6", sb5.toString());
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(41).setSubActionType(1).setThrActionType(2).setExtras(hashMap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void quitSearchState() {
        this.imm.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
        this.mSelectedAndSearchBar.u();
        this.mSelectedAndSearchBar.v();
        View view = this.mSearchResultLayout;
        if (view != null && view.getVisibility() == 0) {
            this.mSearchResultLayout.setVisibility(8);
            com.tencent.mobileqq.search.view.f fVar = this.contactSearchFragment;
            if (fVar != null) {
                fVar.y8();
            }
        }
        this.mIsSoftInputShowing = false;
    }

    public void refreshGVideoTextView(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (this.mSubType == 3) {
            this.mGVideoTextView = (TextView) findViewById(R.id.f166841im1);
            if (z16 && getIntent().getIntExtra(ISelectMemberActivityConstants.PARAM_TROOP_MEMBER_SHOW_TYPE, 1) == 2) {
                this.mGVideoTextView.setVisibility(0);
                this.mGVideoTextView.setText(getString(R.string.ewu, Integer.valueOf(Math.min(i3, this.mMaxSelectNumber))));
            } else {
                this.mGVideoTextView.setVisibility(0);
                this.mGVideoTextView.setText(getString(R.string.eww, Integer.valueOf(this.mMaxSelectNumber)));
            }
        }
    }

    protected void refreshInviteTipsBar() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        TroopInfo troopInfo = getTroopInfo(this.mGroupCode);
        if (troopInfo != null) {
            long j3 = troopInfo.troopPrivilegeFlag;
            if ((101711872 & j3) == 0 || ((j3 & 33554432) != 33554432 ? !((j3 & 67108864) != 67108864 || troopInfo.wMemberNum + this.mResultList.size() <= 100) : troopInfo.wMemberNum + this.mResultList.size() > 50)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z16 = !troopInfo.isOwnerOrAdmin();
            }
            if (troopInfo.maxInviteMemNum > 0 && troopInfo.wMemberNum + this.mResultList.size() > troopInfo.maxInviteMemNum) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "refreshInviteTipsBar needAdminCheck = " + z16 + " needAgree = " + z17);
            }
            if (!z16 && !z17) {
                this.needShowYellowTips = false;
                int i3 = this.mEntrance;
                if (i3 != 11 && i3 != 36) {
                    this.mInviteSuccToastWording = HardCodeUtil.qqStr(R.string.t_3);
                } else {
                    this.mInviteSuccToastWording = getString(R.string.f171234dd1);
                }
            } else if (!z16 && z17) {
                this.needShowYellowTips = true;
                this.mYellowTipsWording = HardCodeUtil.qqStr(R.string.t9k);
                this.mInviteSuccToastWording = HardCodeUtil.qqStr(R.string.t_c);
            } else if (z16 && z17) {
                this.needShowYellowTips = true;
                this.mYellowTipsWording = HardCodeUtil.qqStr(R.string.t_0);
                this.mInviteSuccToastWording = HardCodeUtil.qqStr(R.string.t9p);
            } else if (z16 && !z17) {
                this.needShowYellowTips = true;
                this.mYellowTipsWording = HardCodeUtil.qqStr(R.string.t9g);
                this.mInviteSuccToastWording = HardCodeUtil.qqStr(R.string.t9r);
            }
            if (!this.isClosed && this.needShowYellowTips && !TextUtils.isEmpty(this.mYellowTipsWording)) {
                this.mTooManyMembersTipsBar.setVisibility(0);
                TextView textView = (TextView) this.mTooManyMembersTipsBar.findViewById(R.id.jsr);
                textView.setText(this.mYellowTipsWording);
                textView.setContentDescription(this.mYellowTipsWording);
                return;
            }
            this.mTooManyMembersTipsBar.setVisibility(8);
        }
    }

    public boolean removeAllFriendResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        this.mResultList.clear();
        this.mSelectedAndSearchBar.p(false);
        setupDoneBtn();
        onResultListChanged();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFriendFromResultList(String str) {
        for (int i3 = 0; i3 < this.mResultList.size(); i3++) {
            if (this.mResultList.get(i3).uin.equals(str)) {
                this.mResultList.remove(i3);
                this.unclickableSelectedUins.remove(str);
                if (this.mType == 9003) {
                    if (this.mEntrance == 15 && !((IBlessApi) QRoute.api(IBlessApi.class)).isUinBlessed(this.app, str)) {
                        this.mUnblessedUinCount--;
                    } else if (this.mEntrance == 32 && !((IBlessApi) QRoute.api(IBlessApi.class)).isWebUinSended(this.app, str)) {
                        this.mUnblessedUinCount--;
                    }
                }
            }
        }
        onResultListChanged();
    }

    public void reportInviteFriend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        } else {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.12
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f285703d;

                {
                    this.f285703d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SelectMemberActivity selectMemberActivity = SelectMemberActivity.this;
                    AppInterface appInterface = selectMemberActivity.app;
                    String str2 = this.f285703d;
                    String str3 = selectMemberActivity.mGroupCode;
                    StringBuilder sb5 = new StringBuilder();
                    ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                    AppInterface appInterface2 = SelectMemberActivity.this.app;
                    sb5.append(iSelectMemberRefatorHelperApi.getMemberType(appInterface2, appInterface2.getCurrentAccountUin(), SelectMemberActivity.this.mGroupCode));
                    sb5.append("");
                    ReportController.o(appInterface, "dc00899", "invite_friend", "", "friend_list", str2, 0, 0, str3, sb5.toString(), "", "");
                }
            }, 32, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    @Override // com.tencent.mobileqq.search.view.d
    public void selectedItemClick(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        com.tencent.mobileqq.search.view.f fVar = this.contactSearchFragment;
        if (fVar != null && fVar.L5() && z16 && this.mResultList != null) {
            for (int i16 = 0; i16 < this.mResultList.size(); i16++) {
                if (TextUtils.equals(this.mResultList.get(i16).uin, str)) {
                    this.mSelectedAndSearchBarCallback.a(this.mResultList.get(i16));
                    notifyListOrSearchChange(true);
                }
            }
        }
    }

    protected void sendContactsListBroadcast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        ArrayList<ResultRecord> arrayList = this.mResultList;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<ResultRecord> processResult = processResult();
            Intent intent = new Intent("tencent.video.q2v.SelectMember");
            intent.setPackage(this.app.getApplication().getPackageName());
            if (processResult.size() > 0) {
                intent.putParcelableArrayListExtra("SelectMemberList", processResult);
            }
            int size = this.mResultList.size();
            String str = this.mResultList.get(0).name;
            intent.putExtra("InviteCount", size);
            intent.putExtra("FirstName", str);
            this.app.getApp().sendBroadcast(intent);
        }
    }

    protected void setContentLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            setContentView(R.layout.bye);
        } catch (IllegalStateException e16) {
            QLog.e(TAG, 1, "setContentView IllegalStateException", e16);
        }
    }

    public void setGroupMembers(ArrayList<TroopMemberInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) arrayList);
        } else {
            this.mGroupmembers = arrayList;
        }
    }

    void setNotAdminInviteMemberCount(int i3) {
        long v3 = Utils.v();
        SharedPreferences.Editor edit = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
        edit.putString(INDEX_NOT_ADMIN_INVITE_MEMBER_COUNT, v3 + ":" + i3);
        edit.commit();
    }

    public void setOnSelectStateChangeListener(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) pVar);
        } else {
            this.mOnSelectStateChangeListener = pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setupDoneBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            if (isTroopAddBatchFriend()) {
                return;
            }
            if (this.mResultList.size() >= this.mMinSelectNumber) {
                setDoneBtnEnabled(true);
            } else {
                setDoneBtnEnabled(false);
            }
        }
    }

    public void setupTitleBar(boolean z16, String str, String str2) {
        CharSequence text;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), str, str2);
            return;
        }
        if (z16) {
            configLeftBackIconDrawable();
            this.mLeftBackBtn.setVisibility(0);
            this.mLeftBackBtn.setText(str);
            this.mLeftBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        SelectMemberActivity.this.onBackEvent();
                        if (AppSetting.f99565y) {
                            SelectMemberActivity.this.mLeftBackBtn.post(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.4.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        SelectMemberActivity.this.mLeftBackBtn.sendAccessibilityEvent(4);
                                    }
                                }
                            });
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            this.mLeftCancelBtn.setVisibility(8);
            QIphoneTitleBarActivity.setLayerType(this.mLeftBackBtn);
        } else {
            initTitleBar();
        }
        int i3 = this.mEntrance;
        if (i3 != 14 && i3 != 21 && i3 != 25 && i3 != 35 && i3 != 32) {
            if (this.mSubType == 3) {
                setTitleText(getString(R.string.ewv));
            } else if (isTroopAddBatchFriend()) {
                this.mTitleString = getString(R.string.zdd);
                if (!this.mTitle.getText().equals(this.mTitleString)) {
                    setTitleText(this.mTitleString);
                }
                if (this.mRightBtn.getVisibility() != 0) {
                    this.mRightBtn.setVisibility(0);
                }
                if (8 != this.mLeftCancelBtn.getVisibility()) {
                    this.mLeftCancelBtn.setVisibility(8);
                }
                this.mLeftBackBtn.setVisibility(0);
                this.mRightBtn.setVisibility(8);
                this.mLeftBackBtn.setOnClickListener(new l());
                if (AppSetting.f99565y) {
                    this.mTitle.setContentDescription(this.mTitleString);
                    this.mLeftBackBtn.setContentDescription(getString(R.string.f173096hd0));
                }
            } else {
                setTitleText(str2);
            }
        } else if (!TextUtils.isEmpty(this.mTitleString)) {
            setTitleText(this.mTitleString);
        } else {
            setTitleText(str2);
        }
        if (AppSetting.f99565y) {
            TextView textView = this.mTitle;
            textView.setContentDescription(textView.getText());
            TextView textView2 = this.mLeftBackBtn;
            if (TextUtils.isEmpty(textView2.getText())) {
                text = HardCodeUtil.qqStr(R.string.t_1);
            } else {
                text = this.mLeftBackBtn.getText();
            }
            textView2.setContentDescription(text);
            this.mLeftBackBtn.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectMemberActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SelectMemberActivity.this.mLeftBackBtn.sendAccessibilityEvent(8);
                    }
                }
            }, 1000L);
        }
    }

    void showAllSelectBtn() {
        RelativeLayout relativeLayout;
        if (this.mEntrance != 35) {
            return;
        }
        int i3 = 0;
        if (this.mIntent.getBooleanExtra(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, false) && (relativeLayout = (RelativeLayout) findViewById(R.id.idl)) != null) {
            if (!this.mIsSelectAllMembers) {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
        }
    }

    protected void startCreateOrAdd() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        if (this.mType == 3000 && isCreateNewTypeTroop()) {
            createNewTypeDiscussion();
            return;
        }
        int i17 = this.mType;
        if (i17 != 1) {
            boolean z16 = false;
            if (i17 != 3000) {
                String stringExtra = this.mIntent.getStringExtra("group_uin");
                if (stringExtra != null && (((i16 = this.mEntrance) == 32 || i16 == 43) && (this.mOnlyTroopMember || this.mOnlyDiscussionMember))) {
                    this.mIntent.putExtra("group_uin", stringExtra);
                    if (this.mOnlyTroopMember) {
                        TroopInfo troopInfo = getTroopInfo(stringExtra);
                        this.mIntent.putExtra("group_type", 4);
                        if (troopInfo != null) {
                            this.mIntent.putExtra("group_name", troopInfo.troopname);
                            this.mIntent.putExtra("group_member_type", troopInfo.wMemberNum);
                        }
                    } else if (this.mOnlyDiscussionMember) {
                        DiscussionInfo discussionInfo = (DiscussionInfo) ((IDiscussionService) this.app.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(stringExtra);
                        this.mIntent.putExtra("group_type", 8);
                        this.mIntent.putExtra("group_member_type", ((IDiscussionService) this.app.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(stringExtra));
                        if (discussionInfo != null) {
                            this.mIntent.putExtra("group_name", discussionInfo.discussionName);
                        }
                    }
                    if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this)) {
                        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fillResultRecordLevelIcon(convertToGameTroopSelectMemberInfoList(this.mResultList));
                    }
                }
                int i18 = this.mEntrance;
                if (i18 == 42 || i18 == 41 || i18 == 48) {
                    qCircleReport(this.mResultList, i18);
                }
                if (this.mResultList != null) {
                    QLog.d(TAG, 1, "result list is " + this.mResultList.size());
                }
                this.mIntent.putParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET, this.mResultList);
                ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
                setResult(-1, this.mIntent);
                finish();
                return;
            }
            if (this.mAddPassedMembersToResultSet) {
                Iterator<String> it = this.mUinsSelectedDefault.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!hasAdd2ResultList(next)) {
                        ResultRecord resultRecord = new ResultRecord();
                        resultRecord.uin = next;
                        resultRecord.type = 0;
                        resultRecord.groupUin = "-1";
                        this.mResultList.add(resultRecord);
                    }
                }
            }
            this.mResultList.size();
            Iterator<ResultRecord> it5 = this.mResultList.iterator();
            boolean z17 = false;
            while (it5.hasNext()) {
                int i19 = it5.next().type;
                if (i19 == 3) {
                    z16 = true;
                }
                if (i19 != 5) {
                    z17 = true;
                }
                if (z16 && z17) {
                    break;
                }
            }
            boolean z18 = z17;
            if (z16) {
                ReportController.o(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
            } else {
                ReportController.o(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
            }
            if (this.mSubType == 0) {
                ReportController.o(this.app, "CliOper", "", "", "0X8005446", "0X8005446", 0, 0, "", "", "", "");
            } else {
                com.tencent.mobileqq.selectmember.b.b("0X800C12A", "0");
                ReportController.o(this.app, "CliOper", "", "", "0X800674C", "0X800674C", 0, 0, "", "", "", "");
            }
            if (this.mSubType == 0) {
                i3 = R.string.as_;
            } else {
                i3 = R.string.f170844as1;
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            this.mQQProgressDialog = qQProgressDialog;
            qQProgressDialog.setMessage(i3);
            this.mQQProgressDialog.show();
            if (this.mSubType == 0 || z18) {
                DiscussRunnable discussRunnable = new DiscussRunnable(new WeakReference(this.app), this.mGroupCode, new ArrayList(this.mResultList), this.mFrom, this);
                this.discussRunnable = discussRunnable;
                com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.e(new com.tencent.mobileqq.qcoroutine.api.g("SelectMemberActivity_addDiscussion", i.e.f261783e, discussRunnable));
            }
            if (this.mSubType != 0) {
                sendContactsListBroadcast();
                if (!z18) {
                    finish();
                    return;
                }
                return;
            }
            return;
        }
        doInviteTroopMember(this.mResultList);
    }

    public void startTitleProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        if (this.mTitle != null && this.mAnimationDrawable == null) {
            this.mAnimationDrawable = getResources().getDrawable(R.drawable.common_loading6);
            this.mTitle.setCompoundDrawablePadding(10);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds(this.mAnimationDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ((Animatable) this.mAnimationDrawable).start();
        }
    }

    public void stopTitleProgress() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        } else if (this.mTitle != null && (obj = this.mAnimationDrawable) != null) {
            ((Animatable) obj).stop();
            this.mAnimationDrawable = null;
            this.mTitle.setCompoundDrawables(null, null, null, null);
        }
    }

    public void toggleSelectMode(boolean z16, boolean z17) {
        int i3;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z17) {
            this.mModeMulti = !this.mModeMulti;
        }
        View view = this.mMultiSearchView;
        if (this.mModeMulti) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        setupTitleBar(true, "", "");
        if (this.mModeMulti) {
            this.mMultiAddContainerV.setVisibility(0);
            if (this.mResultList.isEmpty()) {
                string = getString(R.string.a97);
            } else {
                string = getString(R.string.a98, Integer.valueOf(this.mResultList.size()));
            }
            Button button = this.mMultiAddBtn;
            if (button != null) {
                button.setText(string);
            }
        } else {
            this.mSearchResultLayout.setVisibility(8);
            this.mMultiSearchView.setVisibility(8);
            this.mMultiAddContainerV.setVisibility(8);
        }
        this.mSelectedAndSearchBar.u();
        Button button2 = this.mMultiAddBtn;
        if (button2 != null) {
            button2.setEnabled(!this.mResultList.isEmpty());
        }
        p pVar = this.mOnSelectStateChangeListener;
        if (pVar != null && !z17) {
            pVar.b(true, z17);
        }
        if (!z16) {
            this.mSelectedAndSearchBar.p(true);
            onResultListChanged();
        }
        quitSearchState();
        boolean z18 = this.mModeMulti;
        String stringExtra = getIntent().getStringExtra("group_uin");
        if (!TextUtils.isEmpty(stringExtra)) {
            ThreadManagerV2.post(new Runnable(z18, stringExtra) { // from class: com.tencent.mobileqq.selectmember.SelectMemberActivity.24
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f285711d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f285712e;

                {
                    this.f285711d = z18;
                    this.f285712e = stringExtra;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SelectMemberActivity.this, Boolean.valueOf(z18), stringExtra);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f285711d) {
                        str = "multiMode_exp";
                    } else {
                        str = "singleMode_exp";
                    }
                    ReportController.o(SelectMemberActivity.this.app, "dc00899", "Grp_addFrd", "", "frd_select", str, 0, 0, this.f285712e, "0", "", "");
                }
            }, 5, null, true);
        }
    }

    public void updateGameData(Map<String, List<TroopMemberInfo>> map, int[] iArr, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, map, iArr, strArr);
            return;
        }
        InnerFrameManager innerFrameManager = this.mInnerFrameManager;
        if (innerFrameManager != null && (innerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame)) {
            ((TroopMemberListInnerFrame) this.mInnerFrameManager.getCurrentView()).R(map, iArr, strArr);
            notifyListOrSearchChange(true);
        }
    }

    public void updateMultiAddState(ResultRecord resultRecord, boolean z16) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, resultRecord, Boolean.valueOf(z16));
            return;
        }
        if (!isTroopAddBatchFriend()) {
            return;
        }
        p pVar = this.mOnSelectStateChangeListener;
        if (pVar != null) {
            pVar.d(resultRecord, z16);
        }
        if (this.mResultList.isEmpty()) {
            string = getString(R.string.a97);
        } else {
            string = getString(R.string.a98, Integer.valueOf(this.mResultList.size()));
        }
        Button button = this.mMultiAddBtn;
        if (button != null) {
            button.setText(string);
            this.mMultiAddBtn.setEnabled(!this.mResultList.isEmpty());
        }
    }

    private void showMemberOverloadToast(String str) {
        if (System.currentTimeMillis() - this.mOverloadToastLastShowTime > 2000) {
            QQToast.makeText(this, str, 2000).show(this.mTitleBar.getHeight());
            this.mOverloadToastLastShowTime = System.currentTimeMillis();
        }
    }

    public boolean addFriendResults(List<ResultRecord> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (z16) {
            this.mResultList.clear();
        }
        HashSet hashSet = new HashSet(this.mResultList.size());
        Iterator<ResultRecord> it = this.mResultList.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().uin);
        }
        ArrayList<String> arrayList = this.mUinsSelectedDefault;
        if (arrayList != null) {
            Iterator<String> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                hashSet.add(it5.next());
            }
        }
        for (ResultRecord resultRecord : list) {
            if (!hashSet.contains(resultRecord.uin)) {
                if (!isMemberOverLoad("addFriendResults", z17, resultRecord.uin, resultRecord.name, resultRecord.type, resultRecord.groupUin) && !isMemberOverload(resultRecord.uin, resultRecord.name) && preAddPstnNumber(resultRecord.uin, resultRecord.name, resultRecord.type, resultRecord.groupUin)) {
                    this.mResultList.add(resultRecord);
                    updateMultiAddState(resultRecord, true);
                    if (this.mType == 9003) {
                        if (this.mEntrance == 15 && !((IBlessApi) QRoute.api(IBlessApi.class)).isUinBlessed(this.app, resultRecord.uin)) {
                            this.mUnblessedUinCount++;
                        } else if (this.mEntrance == 32 && !((IBlessApi) QRoute.api(IBlessApi.class)).isWebUinSended(this.app, resultRecord.uin)) {
                            this.mUnblessedUinCount++;
                        }
                    }
                } else if (this.mType != 9003) {
                    break;
                }
            }
        }
        this.mSelectedAndSearchBar.p(true);
        setupDoneBtn();
        onResultListChanged();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onListViewItemClick(String str, String str2, int i3, String str3, String str4) {
        boolean z16;
        boolean z17 = false;
        if (isResultListContainFriend(str)) {
            removeFriendFromResultList(str);
        } else if (!isMemberOverLoad("onListViewItemClick2", false, str, str2, i3, str3) && preAddPstnNumber(str, str2, i3, str3)) {
            this.mResultList.add(constructAResultRecord(str, str2, i3, str3, str4));
            z16 = true;
            if (isInvitedListContainFriend(str)) {
                z17 = z16;
            } else {
                removeFriendFromResultList(str);
                QQToast.makeText(this, 1, HardCodeUtil.qqStr(R.string.t9_), 0).show(getTitleBarHeight());
                ReportController.o(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, str3, "", "", "");
            }
            this.mSelectedAndSearchBar.p(z17);
            setupDoneBtn();
            onResultListChanged();
            return z17;
        }
        z16 = false;
        if (isInvitedListContainFriend(str)) {
        }
        this.mSelectedAndSearchBar.p(z17);
        setupDoneBtn();
        onResultListChanged();
        return z17;
    }

    public ResultRecord constructAResultRecord(String str, String str2, int i3, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (ResultRecord) iPatchRedirector.redirect((short) 42, this, str, str2, Integer.valueOf(i3), str3, str4);
        }
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.uin = str;
        resultRecord.name = str2;
        resultRecord.type = i3;
        resultRecord.groupUin = str3;
        resultRecord.phone = str4;
        return resultRecord;
    }
}
