package com.tencent.mobileqq.friend.group;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.friend.ContactsFPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.util.GroupCacheHelper;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.report.ProfilePerformanceHelper;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.CommonLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_contact", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes33.dex */
public class GroupFragment extends ContactsBaseFragment implements View.OnClickListener, Handler.Callback {
    protected ContactsFPSPinnedHeaderExpandableListView Q;
    private GroupListAdapter R;
    private CommonLoadingView V;

    /* renamed from: b0, reason: collision with root package name */
    private zc1.a f211615b0;

    /* renamed from: c0, reason: collision with root package name */
    private zc1.a f211616c0;
    private boolean N = true;
    private boolean P = false;
    private final e S = new e();
    private com.tencent.mobileqq.phonecontact.observer.b T = new c();
    private MqqHandler U = new MqqHandler(Looper.getMainLooper(), this);
    private int W = 0;
    private final d X = new d();
    private volatile boolean Y = true;
    private Map Z = new HashMap();

    /* renamed from: a0, reason: collision with root package name */
    private Map f211614a0 = new HashMap();

    /* renamed from: d0, reason: collision with root package name */
    private boolean f211617d0 = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen();

    /* renamed from: e0, reason: collision with root package name */
    private boolean f211618e0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105868", false);

    /* renamed from: f0, reason: collision with root package name */
    private hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> f211619f0 = new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.friend.group.GroupFragment.1
        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
            if (eVar != null && eVar.a() == 0) {
                final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16 = eVar.b();
                if (b16 != null) {
                    if (GroupFragment.this.Y) {
                        GroupFragment.this.Y = false;
                        GroupCacheHelper.f211730a.b(b16);
                    }
                    QLog.d("contacts.fragment.GroupFragment", 2, "friendsCategoryInfo.arrayList.size:" + b16.size());
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.friend.group.GroupFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupFragment.this.R == null) {
                                return;
                            }
                            if (((ContactsBaseFragment) GroupFragment.this).C != null) {
                                ((ContactsBaseFragment) GroupFragment.this).C.c(GroupFragment.this.th(), true, null);
                            }
                            GroupFragment.this.R.m(b16);
                            GroupFragment.this.R.i();
                        }
                    });
                    com.tencent.mobileqq.activity.contacts.report.d.f181714a.g(RelationListReqType.NORMAL, 0);
                    return;
                }
                com.tencent.mobileqq.activity.contacts.report.d.f181714a.g(RelationListReqType.NORMAL, 1);
                QLog.d("contacts.fragment.GroupFragment", 2, "null == ntCategoryInfoList");
                return;
            }
            QLog.d("contacts.fragment.GroupFragment", 2, "responseData.getCode() != RelationResponseConstant.RELATION_RESPONSE_SUCCESS || responseData == null");
            com.tencent.mobileqq.activity.contacts.report.d.f181714a.g(RelationListReqType.NORMAL, 1);
        }
    };

    /* renamed from: g0, reason: collision with root package name */
    private hx3.b<String> f211620g0 = new hx3.b<String>() { // from class: com.tencent.mobileqq.friend.group.GroupFragment.2
        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<String> eVar) {
            if (eVar != null && eVar.a() == 0) {
                ArrayList<String> b16 = eVar.b();
                if (b16 != null && b16.size() != 0) {
                    QLog.d("contacts.fragment.GroupFragment", 2, "changeUidList.arrayList.size:" + b16.size());
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.friend.group.GroupFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupFragment.this.R == null) {
                                return;
                            }
                            GroupFragment.this.R.o();
                        }
                    });
                    return;
                }
                QLog.d("contacts.fragment.GroupFragment", 2, "null == changeUidList");
                return;
            }
            QLog.d("contacts.fragment.GroupFragment", 2, "mAnyFriendDataCallback responseData.getCode() != RelationResponseConstant.RELATION_RESPONSE_SUCCESS || responseData == null");
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements com.tencent.mobileqq.activity.contacts.friend.b {
        b() {
        }

        @Override // com.tencent.mobileqq.activity.contacts.friend.b
        public void a() {
            if (com.tencent.relation.common.config.toggle.c.H.g(false)) {
                GroupFragment groupFragment = GroupFragment.this;
                if (groupFragment.Q != null && groupFragment.V != null && GroupFragment.this.V.getVisibility() == 0) {
                    GroupFragment groupFragment2 = GroupFragment.this;
                    groupFragment2.Q.removeHeaderView(groupFragment2.V);
                }
            }
            if (GroupFragment.this.f211615b0 != null) {
                GroupFragment.this.f211615b0.x9(((ContactsBaseFragment) GroupFragment.this).K, ProfilePerformanceHelper.keyFpsOnDraw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d extends ar {
        d() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_global(boolean z16, Object[] objArr) {
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.GroupFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + z16);
            }
            GroupFragment.this.Xh(Boolean.FALSE);
            if (GroupFragment.this.R != null) {
                GroupFragment.this.R.notifyDataSetChanged();
            }
            if (z16 && GroupFragment.this.isResumed()) {
                try {
                    String[] strArr = (String[]) objArr[1];
                    boolean[] zArr = (boolean[]) objArr[2];
                    if (QLog.isColorLevel()) {
                        QLog.d("contacts.fragment.GroupFragment", 2, "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString(strArr), Arrays.toString(zArr));
                    }
                    if (com.tencent.mobileqq.friend.util.a.f211732a.a() || zArr == null || zArr.length <= 0) {
                        return;
                    }
                    if (zArr[0]) {
                        QQToast.makeText(GroupFragment.this.getBaseActivity(), 2, HardCodeUtil.qqStr(R.string.mry), 0).show();
                    } else {
                        QQToast.makeText(GroupFragment.this.getBaseActivity(), 2, HardCodeUtil.qqStr(R.string.mrz), 0).show();
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("contacts.fragment.GroupFragment", 2, "onSetSpecialCareSwitch_global fail!", e16);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e implements com.tencent.mobileqq.richstatus.e {
        e() {
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            if (GroupFragment.this.N && bitmap != null && i16 == 200) {
                GroupFragment.this.bi(1400L, false);
            }
        }
    }

    private void Wh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "<<--doRefreshBuddyList, load=" + z16);
        }
        GroupListAdapter groupListAdapter = this.R;
        if (groupListAdapter != null) {
            if (z16) {
                Xh(Boolean.FALSE);
            } else {
                groupListAdapter.o();
                if (Contacts.mStartRelationTabShowTime != 0) {
                    com.tencent.relation.common.report.a.c(Contacts.RELATION_TAB_SHOWTIME, System.currentTimeMillis() - Contacts.mStartRelationTabShowTime, true, null);
                    Contacts.mStartRelationTabShowTime = 0L;
                }
            }
        }
        zc1.a aVar = this.f211615b0;
        if (aVar != null) {
            aVar.B9("FRIEND_LIST_ANDROID");
            this.f211615b0.x9(this.K, ProfilePerformanceHelper.keyFpsOnDraw);
        }
    }

    private boolean Yh(Object obj) {
        if (obj instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj;
            if (QLog.isColorLevel() && this.f211617d0) {
                QLog.d("contacts.fragment.GroupFragment", 2, "onItemClick:" + dVar.p() + dVar.x());
            }
            AllInOne allInOne = new AllInOne(dVar.x(), 1);
            allInOne.profileEntryType = 59;
            allInOne.chatEntrance = 2;
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 51);
            ProfileUtils.openProfileCard(this.K, allInOne);
            return true;
        }
        if (obj instanceof String) {
            if (this.f211617d0) {
                QLog.d("contacts.fragment.GroupFragment", 2, "obj instanceof String");
            }
            AllInOne allInOne2 = new AllInOne(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid((String) obj), 1);
            allInOne2.profileEntryType = 59;
            allInOne2.chatEntrance = 2;
            allInOne2.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
            allInOne2.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 51);
            ProfileUtils.openProfileCard(this.K, allInOne2);
            return true;
        }
        if (!this.f211617d0) {
            return false;
        }
        QLog.d("contacts.fragment.GroupFragment", 2, "obj instanceof other");
        return false;
    }

    private void Zh(View view) {
        QLog.d("contacts.fragment.GroupFragment", 2, "handleRightMenuClick");
        Object tag = view.getTag(-2);
        Object tag2 = view.getTag(-10);
        if ((tag instanceof Integer) && ((tag2 instanceof Friends) || (tag2 instanceof TroopInfo) || (tag2 instanceof DiscussionInfo))) {
            if (!NetworkUtil.isNetworkAvailable(this.K)) {
                QQToast.makeText(this.K, 1, R.string.b3j, 1).show();
                return;
            }
            if (tag2 instanceof TroopInfo) {
                TroopInfo troopInfo = (TroopInfo) tag2;
                ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).requestSetTroopTop(null, troopInfo.troopuin, false, true, null);
                new q(this.E).i("dc00899").a("Grp_set").f("Grp_contactlist").d("Clk_unstick").b(troopInfo.troopuin).g();
                return;
            } else {
                if (tag2 instanceof DiscussionInfo) {
                    ((DiscussionHandler) this.E.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).s4(Long.valueOf(((DiscussionInfo) tag2).uin).longValue());
                    return;
                }
                return;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "handleRightMenuClick onClick tag is not int");
        }
    }

    private void ai() {
        zc1.a aVar = new zc1.a();
        this.f211615b0 = aVar;
        aVar.z9("FRIEND_LIST_ANDROID");
        this.f211615b0.startMonitor(this.K, ProfilePerformanceHelper.keyFpsOnDraw);
        zc1.a aVar2 = new zc1.a();
        this.f211616c0 = aVar2;
        aVar2.z9("FRIEND_LIST_ANDROID");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(long j3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("contacts.fragment.GroupFragment", 2, "refreshBuddyList, delay=" + j3 + ", load=" + z16);
        }
        this.U.removeMessages(4);
        if (z16) {
            this.U.removeMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION);
        } else if (this.U.hasMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION)) {
            return;
        }
        if (j3 == 0) {
            Wh(z16);
        } else {
            this.U.sendEmptyMessageDelayed(z16 ? 9527 : 4, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci() {
        zc1.a aVar;
        if (!com.tencent.mobileqq.app.friendlist.b.a() || (aVar = this.f211616c0) == null) {
            return;
        }
        aVar.B9("FRIEND_LIST_ANDROID");
        this.f211616c0.x9(this.K, ProfilePerformanceHelper.keyFpsOnScroll);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
        zc1.a aVar;
        if (!com.tencent.mobileqq.app.friendlist.b.a() || (aVar = this.f211616c0) == null) {
            return;
        }
        aVar.startMonitor(this.K, ProfilePerformanceHelper.keyFpsOnScroll);
    }

    private void ei() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "resetContactsList, mElvGroupingBuddies=" + this.Q);
        }
        if (this.Q != null) {
            GroupListAdapter groupListAdapter = this.R;
            if (groupListAdapter != null) {
                groupListAdapter.destroy();
                this.Q.resetState();
            }
            GroupListAdapter groupListAdapter2 = new GroupListAdapter(this.K, this.E, this.Q, this);
            this.R = groupListAdapter2;
            groupListAdapter2.n(new b());
            this.Q.setAdapter(this.R);
            this.Q.setOnScrollListener(this.R);
            ((IQQFriendsInfoApi) QRoute.api(IQQFriendsInfoApi.class)).resetData("contacts.fragment.GroupFragment");
            Xh(Boolean.TRUE);
        }
    }

    private void fi(ListView listView) {
        if (listView == this.Q) {
            if (listView.getFirstVisiblePosition() > 0) {
                this.Q.setSelection(0);
            }
        } else if (listView.getFirstVisiblePosition() > 0) {
            listView.setSelection(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void Ah() {
        this.E.removeObserver(this.X);
        StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager != null) {
            statusManager.b0(this.S);
        }
    }

    public void Xh(Boolean bool) {
        com.tencent.mobileqq.activity.contacts.report.d.n("fetch_local_data_start_time");
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryCacheInfoV2(RelationListReqType.NORMAL, true, "contacts.fragment.GroupFragment", bool.booleanValue(), this.f211619f0);
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).addChangeFriendUidsCallBack("contacts.fragment.GroupFragment", this.f211620g0);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "doOnDestroy.");
        }
        this.U.removeCallbacksAndMessages(null);
        GroupListAdapter groupListAdapter = this.R;
        if (groupListAdapter != null) {
            groupListAdapter.destroy();
        }
        Ah();
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).unregisterFriendCategoryInfoV2Callback(RelationListReqType.NORMAL, "contacts.fragment.GroupFragment", this.f211619f0);
        this.f211620g0 = null;
        zc1.a aVar = this.f211615b0;
        if (aVar != null) {
            aVar.onPartDestroy(this.K);
            this.f211615b0 = null;
        }
        zc1.a aVar2 = this.f211616c0;
        if (aVar2 != null) {
            aVar2.onPartDestroy(this.K);
            this.f211616c0 = null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 == 9527) {
                    bi(0L, true);
                }
            } else if (this.N) {
                bi(0L, false);
            }
        } else if (this.N) {
            bi(0L, false);
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f211617d0) {
            QLog.i("contacts.fragment.GroupFragment", 2, "onclick");
        }
        view.getId();
        if (Utils.p(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM, view.getTag())) {
            Zh(view);
            return;
        }
        if (this.f211617d0) {
            QLog.i("contacts.fragment.GroupFragment", 2, "!Utils.equalsWithNullCheck");
        }
        c.C7154c c7154c = (c.C7154c) view.getTag();
        if (c7154c == null || c7154c.f181513m == null) {
            return;
        }
        if (this.f211617d0) {
            QLog.i("contacts.fragment.GroupFragment", 2, "handleRequest");
        }
        Yh(c7154c.f181513m);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mobileqq.activity.contacts.report.d.n("PAGE_INIT");
        ai();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ci();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void ph() {
        this.E.addObserver(this.X);
        StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager != null) {
            statusManager.C(this.S);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "doOnPause.");
        }
        Ah();
        ContactsFPSPinnedHeaderExpandableListView contactsFPSPinnedHeaderExpandableListView = this.Q;
        if (contactsFPSPinnedHeaderExpandableListView != null) {
            if (contactsFPSPinnedHeaderExpandableListView.getVisibility() == 0) {
                this.Q.hideCurShowingRightView();
            }
            this.Q.d0();
        }
        GroupListAdapter groupListAdapter = this.R;
        if (groupListAdapter != null) {
            groupListAdapter.j();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "refresh");
        }
        if (this.N) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).requestAllCategoriesInfo("contacts.fragment.GroupFragment");
        }
        this.P = true;
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "updateBuddyList succeeded");
        }
        ReportController.o(this.E, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", 51, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "resetData");
        }
        this.U.removeCallbacksAndMessages(null);
        ei();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean z16) {
        boolean g16 = com.tencent.relation.common.config.toggle.c.H.g(false);
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "doOnResume. tabChange:" + z16 + ",mElvGroupingBuddies=" + this.Q + ", mGroupListAdapter=" + this.R + ", isFriendFragmentShowOptEnable=" + g16);
        }
        if (this.Q == null) {
            return;
        }
        if (this.R == null) {
            ei();
        }
        ph();
        QLog.i("contacts.fragment.GroupFragment", 2, "doOnResume refreshOptSwitch = " + this.f211618e0);
        if (this.f211618e0) {
            QLog.i("contacts.fragment.GroupFragment", 2, "doOnResume shelf  refreshBuddyList");
        } else {
            bi(g16 ? 0L : 500L, true);
        }
        ((FriendListHandler) this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(this.E.getCurrentAccountUin(), (byte) 1);
        if (!this.U.hasMessages(5)) {
            this.U.sendEmptyMessageDelayed(5, com.tencent.mobileqq.mutualmark.oldlogic.a.h() * 1000);
        }
        ((FriendsManager) this.E.getManager(QQManagerFactory.FRIENDS_MANAGER)).E(true);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater layoutInflater, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.GroupFragment", 2, "getView mElvGroupingBuddies=" + this.Q);
        }
        ContactsFPSPinnedHeaderExpandableListView contactsFPSPinnedHeaderExpandableListView = this.Q;
        if (contactsFPSPinnedHeaderExpandableListView != null) {
            ViewParent parent = contactsFPSPinnedHeaderExpandableListView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.Q);
            }
        } else if (layoutInflater != null) {
            ContactsFPSPinnedHeaderExpandableListView contactsFPSPinnedHeaderExpandableListView2 = (ContactsFPSPinnedHeaderExpandableListView) layoutInflater.inflate(R.layout.f167792hn, (ViewGroup) null);
            this.Q = contactsFPSPinnedHeaderExpandableListView2;
            contactsFPSPinnedHeaderExpandableListView2.setActTAG("actFPSFriend");
            this.Q.setSelector(R.color.ajr);
            this.Q.setNeedCheckSpringback(true);
            this.Q.setGroupIndicator(null);
            this.Q.mForContacts = true;
            IFriendsTABService iFriendsTABService = (IFriendsTABService) QRoute.api(IFriendsTABService.class);
            if (iFriendsTABService.isNtDataService()) {
                int cacheFriendCount = iFriendsTABService.getCacheFriendCount();
                this.Q.addOnScrollListener(new a(iFriendsTABService, cacheFriendCount, cacheFriendCount / 2));
            }
            if (!com.tencent.relation.common.config.toggle.c.H.g(false)) {
                return this.Q;
            }
            if (this.V == null) {
                CommonLoadingView commonLoadingView = (CommonLoadingView) layoutInflater.inflate(QUITokenResUtil.getResId(R.layout.f167785hg, R.layout.e3h), (ViewGroup) null);
                this.V = commonLoadingView;
                TextView textView = (TextView) commonLoadingView.findViewById(R.id.f167068kf1);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.gravity = 49;
                layoutParams.topMargin = ViewUtils.dip2px(40.0f);
                textView.setLayoutParams(layoutParams);
            }
            this.Q.addHeaderView(this.V);
        }
        return this.Q;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void xh() {
        GroupListAdapter groupListAdapter;
        if (this.Q == null || (groupListAdapter = this.R) == null) {
            return;
        }
        int groupCount = groupListAdapter.getGroupCount();
        for (int i3 = 0; i3 < groupCount; i3++) {
            this.Q.collapseGroup(i3);
        }
        fi(this.Q);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void zh(boolean z16, int i3) {
        super.zh(z16, i3);
        ContactsFPSPinnedHeaderExpandableListView contactsFPSPinnedHeaderExpandableListView = this.Q;
        if (contactsFPSPinnedHeaderExpandableListView == null) {
            QLog.d("contacts.fragment.GroupFragment", 2, "mElvGroupingBuddies == null");
        } else {
            contactsFPSPinnedHeaderExpandableListView.invalidateViews();
            resetData();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IFriendsTABService f211626d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f211627e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f211628f;

        a(IFriendsTABService iFriendsTABService, int i3, int i16) {
            this.f211626d = iFriendsTABService;
            this.f211627e = i3;
            this.f211628f = i16;
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> h16;
            if (!this.f211626d.isNtDataService() || GroupFragment.this.R == null || (h16 = GroupFragment.this.R.h()) == null || h16.size() == 0) {
                return;
            }
            if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                QLog.i("contacts.fragment.GroupFragment", 2, " firstVisibleItem = " + i3 + " visibleItemCount = " + i16 + "totalItemCount :" + i17);
            }
            int i18 = this.f211627e;
            int i19 = i3 / i18;
            int i26 = i18 / 4;
            int i27 = (i19 + 1) * this.f211628f;
            if (i3 > GroupFragment.this.W) {
                if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                    QLog.i("contacts.fragment.GroupFragment", 2, "\u5411\u4e0a\u6ed1\u52a8");
                }
                if (i3 >= i27) {
                    if (!GroupFragment.this.Z.containsKey(Integer.valueOf(i19))) {
                        GroupFragment.this.Z.clear();
                        GroupFragment.this.Z.put(Integer.valueOf(i19), Boolean.TRUE);
                        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                            QLog.i("contacts.fragment.GroupFragment", 2, "\u5411\u4e0a\u6ed1\u52a8\uff0c\u5230\u8fbe\u4e34\u754c\u503c firstVisibleItem = " + i3 + " loadSectionIndex = " + i27);
                        }
                        GroupCacheHelper.f211730a.c(h16, i3 - i26, Math.min((this.f211627e - i26) + i3, i17));
                    } else {
                        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                            QLog.i("contacts.fragment.GroupFragment", 2, "sectionIndex = " + i19 + "\u5df2\u7ecf\u8fdb\u884c\u9884\u52a0\u8f7d");
                            return;
                        }
                        return;
                    }
                }
            }
            if (i3 < GroupFragment.this.W) {
                if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                    QLog.i("contacts.fragment.GroupFragment", 2, "\u5411\u4e0b\u6ed1\u52a8");
                }
                if (i3 <= i27) {
                    if (!GroupFragment.this.f211614a0.containsKey(Integer.valueOf(i19))) {
                        GroupFragment.this.f211614a0.clear();
                        GroupFragment.this.f211614a0.put(Integer.valueOf(i19), Boolean.TRUE);
                        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                            QLog.i("contacts.fragment.GroupFragment", 2, "\u5411\u4e0b\u6ed1\u52a8\uff0c\u5230\u8fbe\u4e34\u754c\u503c firstVisibleItem = " + i3 + " loadSectionIndex = " + i27);
                        }
                        GroupCacheHelper.f211730a.c(h16, Math.max(0, i3 - i26), (this.f211627e - i26) + i3);
                    } else {
                        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                            QLog.i("contacts.fragment.GroupFragment", 2, "sectionIndex = " + i19 + "\u5df2\u7ecf\u8fdb\u884c\u9884\u52a0\u8f7d");
                            return;
                        }
                        return;
                    }
                }
            }
            if (i3 == GroupFragment.this.W) {
                return;
            }
            GroupFragment.this.W = i3;
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0) {
                GroupFragment.this.ci();
            } else {
                GroupFragment.this.di();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private class c extends com.tencent.mobileqq.phonecontact.observer.b {
        c() {
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onHideContact(boolean z16) {
        }
    }
}
