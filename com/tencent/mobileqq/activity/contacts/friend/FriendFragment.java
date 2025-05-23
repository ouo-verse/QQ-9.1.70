package com.tencent.mobileqq.activity.contacts.friend;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.CommonLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipTextViewMenuBuilder;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FriendFragment extends ContactsBaseFragment implements View.OnClickListener, Handler.Callback, od2.a {
    static IPatchRedirector $redirector_;
    private boolean N;
    private boolean P;
    protected ContactsFPSPinnedHeaderExpandableListView Q;
    protected BuddyListAdapter R;
    private final d S;
    private final e T;
    private final b U;
    private final c V;
    private final g W;
    private final f X;
    private final h Y;
    private MqqHandler Z;

    /* renamed from: a0, reason: collision with root package name */
    private CommonLoadingView f181581a0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements com.tencent.mobileqq.activity.contacts.friend.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.friend.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (com.tencent.relation.common.config.toggle.c.H.g(false)) {
                FriendFragment friendFragment = FriendFragment.this;
                if (friendFragment.Q != null && friendFragment.f181581a0 != null && FriendFragment.this.f181581a0.getVisibility() == 0) {
                    FriendFragment friendFragment2 = FriendFragment.this;
                    friendFragment2.Q.removeHeaderView(friendFragment2.f181581a0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                FriendFragment.this.Rh(5000L, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends CardObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetCalReactiveDays(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("interactive", 2, " contacts onGetCalReactiveDays isAllow= " + z17);
                }
                FriendFragment.this.Rh(1400L, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onAddGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), groupActionResp);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onDeleteGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), groupActionResp);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetOnlineInfoByUinOrMobile(boolean z16, long j3, String str, GetOnlineInfoResp getOnlineInfoResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Long.valueOf(j3), str, getOnlineInfoResp);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGroupDataInited() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
                FriendFragment.this.Rh(1400L, true);
            } else {
                iPatchRedirector.redirect((short) 21, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onRenameGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), groupActionResp);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onResortGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), groupActionResp);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetAsNormalContacts(boolean z16, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), list);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetAsUncommonlyUsedContacts(boolean z16, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), list);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetComment(boolean z16, String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetSpecialCareSwitch_global(boolean z16, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), objArr);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + z16);
            }
            BuddyListAdapter buddyListAdapter = FriendFragment.this.R;
            if (buddyListAdapter != null) {
                buddyListAdapter.notifyDataSetChanged();
            }
            if (z16 && FriendFragment.this.isResumed()) {
                try {
                    String[] strArr = (String[]) objArr[1];
                    boolean[] zArr = (boolean[]) objArr[2];
                    if (QLog.isColorLevel()) {
                        QLog.d("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString(strArr), Arrays.toString(zArr));
                    }
                    if (zArr != null && zArr.length > 0) {
                        if (zArr[0]) {
                            QQToast.makeText(FriendFragment.this.getBaseActivity(), 2, HardCodeUtil.qqStr(R.string.mry), 0).show();
                        } else {
                            QQToast.makeText(FriendFragment.this.getBaseActivity(), 2, HardCodeUtil.qqStr(R.string.mrz), 0).show();
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global fail!", e16);
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateAnswerAddedFriend(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateDelFriend isSucess= " + z16);
            }
            if (z16) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            boolean z18;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            FriendFragment friendFragment = FriendFragment.this;
            if (!z17 && z16) {
                z18 = false;
            } else {
                z18 = true;
            }
            friendFragment.N = z18;
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateFriendList isSucess= " + z16 + ",isComplete=" + z17);
            }
            boolean z19 = FriendFragment.this.P;
            if (FriendFragment.this.P) {
                if (FriendFragment.this.N) {
                    FriendFragment.this.P = false;
                    if (((ContactsBaseFragment) FriendFragment.this).C != null) {
                        ((ContactsBaseFragment) FriendFragment.this).C.c(FriendFragment.this.th(), z16, null);
                    }
                }
                FriendFragment friendFragment2 = FriendFragment.this;
                if (friendFragment2.N) {
                    j3 = 0;
                } else {
                    j3 = 1400;
                }
                friendFragment2.Rh(j3, true);
            }
            if (!z19 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateGatherFriendList(boolean z16, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            } else if (z16 && z17 && z18) {
                FriendFragment.this.Rh(0L, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateHotFriendLevel(boolean z16, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
                FriendFragment.this.Rh(1400L, false);
            } else {
                iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), arrayList);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateLastLoginInfo(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16) {
                FriendFragment.this.Rh(1400L, false);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateMoveGroup(String str, byte b16, byte b17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, str, Byte.valueOf(b16), Byte.valueOf(b17));
            } else if (str != null && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateOlympicTorchList(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, z16);
            } else if (z16) {
                FriendFragment.this.Rh(1400L, false);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateOnlineFriend(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), strArr);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSignature(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), strArr);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, false);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSpecialCareList(boolean z16, boolean z17, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList2) {
            BuddyListAdapter buddyListAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), arrayList, arrayList2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateSpecialCareList isSucess= " + z16 + ",isComplete=" + z17);
            }
            if (z16 && (buddyListAdapter = FriendFragment.this.R) != null) {
                buddyListAdapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateAddFriend isSucess= " + z16 + ",addSuccess=" + z17 + " addDirect=" + z18);
            }
            if (z16 && z17 && z18) {
                FriendFragment.this.Rh(1400L, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f extends bs {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onUpdateFriendsList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else if (z16 && FriendFragment.this.N) {
                FriendFragment.this.Rh(1400L, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class h implements com.tencent.mobileqq.richstatus.e {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            } else if (FriendFragment.this.N && bitmap != null && i16 == 200) {
                FriendFragment.this.Rh(1400L, false);
            }
        }
    }

    public FriendFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.N = true;
        this.P = false;
        this.S = new d();
        this.T = new e();
        this.U = new b();
        this.V = new c();
        this.W = new g();
        this.X = new f();
        this.Y = new h();
        this.Z = new MqqHandler(Looper.getMainLooper(), this);
    }

    private void Oh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "<<--doRefreshBuddyList, load=" + z16);
        }
        BuddyListAdapter buddyListAdapter = this.R;
        if (buddyListAdapter != null) {
            if (z16) {
                buddyListAdapter.notifyDataSetChanged();
                return;
            }
            buddyListAdapter.A();
            if (Contacts.mStartRelationTabShowTime != 0) {
                com.tencent.relation.common.report.a.c(Contacts.RELATION_TAB_SHOWTIME, System.currentTimeMillis() - Contacts.mStartRelationTabShowTime, true, null);
                Contacts.mStartRelationTabShowTime = 0L;
            }
        }
    }

    private boolean Ph(Object obj) {
        if (obj instanceof Friends) {
            Friends friends = (Friends) obj;
            if (QLog.isColorLevel()) {
                QLog.d("Hyim", 2, "onItemClick:" + friends.name + friends.uin + "--[" + ((int) friends.detalStatusFlag) + "] [" + friends.iTermType + "] [" + friends.getLastLoginType() + "] [" + friends.showLoginClient + "]");
            }
            AllInOne allInOne = new AllInOne(friends.uin, 1);
            allInOne.profileEntryType = 59;
            allInOne.chatEntrance = 2;
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 51);
            ProfileUtils.openProfileCard(this.K, allInOne);
            Sh(friends);
            return true;
        }
        return false;
    }

    private void Qh(View view) {
        boolean z16;
        Object tag = view.getTag(-2);
        Object tag2 = view.getTag(-10);
        if ((tag instanceof Integer) && (((z16 = tag2 instanceof Friends)) || (tag2 instanceof TroopInfo) || (tag2 instanceof DiscussionInfo))) {
            if (!NetworkUtil.isNetworkAvailable(this.K)) {
                QQToast.makeText(this.K, 1, R.string.b3j, 1).show();
                return;
            }
            if (z16) {
                int intValue = ((Integer) tag).intValue();
                Friends friends = (Friends) tag2;
                FriendListHandler friendListHandler = (FriendListHandler) this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                int[] iArr = BuddyListFriends.f181573o;
                if (intValue == iArr[1]) {
                    friendListHandler.setSpecialCareSwitch(1, new String[]{friends.uin}, new boolean[]{true});
                    ReportController.o(this.E, "CliOper", "", "", "0X8006A6B", "0X8006A6B", 0, 0, "", "", "", "");
                    return;
                } else {
                    if (intValue == iArr[0]) {
                        friendListHandler.setSpecialCareSwitch(1, new String[]{friends.uin}, new boolean[]{false});
                        return;
                    }
                    return;
                }
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
            QLog.d("contacts.fragment.FriendFragment", 2, "handleRightMenuClick onClick tag is not int");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(long j3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "refreshBuddyList, delay=" + j3 + ", load=" + z16);
        }
        int i3 = 4;
        this.Z.removeMessages(4);
        if (z16) {
            this.Z.removeMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION);
        } else if (this.Z.hasMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION)) {
            return;
        }
        if (j3 == 0) {
            Oh(z16);
            return;
        }
        MqqHandler mqqHandler = this.Z;
        if (z16) {
            i3 = 9527;
        }
        mqqHandler.sendEmptyMessageDelayed(i3, j3);
    }

    private void Sh(Friends friends) {
        ExtensionInfo extensionInfo = this.E.getExtensionInfo(friends.uin, false);
        if (extensionInfo != null && extensionInfo.feedType == 2 && !TextUtils.isEmpty(extensionInfo.feedPhotoUrl)) {
            new q(this.E).i("dc00898").h(friends.uin).f("mystatus_notice").d("contact_notice_clk").g();
        }
    }

    private void Th() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "resetContactsList, mElvGroupingBuddies=" + this.Q);
        }
        if (this.Q != null) {
            BuddyListAdapter buddyListAdapter = this.R;
            if (buddyListAdapter != null) {
                buddyListAdapter.destroy();
                this.Q.resetState();
            }
            BuddyListAdapter buddyListAdapter2 = new BuddyListAdapter(this.K, this.E, this.Q, this);
            this.R = buddyListAdapter2;
            buddyListAdapter2.z(new a());
            this.Q.setAdapter(this.R);
            this.Q.setOnScrollListener(this.R);
        }
    }

    private void Uh(ListView listView) {
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.E.removeObserver(this.S);
        this.E.removeObserver(this.T);
        this.E.removeObserver(this.U);
        this.E.removeObserver(this.V);
        this.E.removeObserver(this.W);
        this.E.removeObserver(this.X);
        StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager != null) {
            statusManager.b0(this.Y);
        }
        ((IPhoneContactService) this.E.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
    }

    @Override // od2.a
    public void B7(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        }
    }

    @Override // od2.a
    public void L1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void T2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void Ug(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "onBindStateChanged bindState=" + i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "doOnDestroy.");
        }
        this.Z.removeCallbacksAndMessages(null);
        BuddyListAdapter buddyListAdapter = this.R;
        if (buddyListAdapter != null) {
            buddyListAdapter.destroy();
        }
        Ah();
    }

    @Override // od2.a
    public void e7(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 == 9527) {
                    Rh(0L, true);
                }
            } else if (this.N) {
                Rh(0L, false);
            }
        } else if (this.N) {
            Rh(0L, false);
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            view.getId();
            if (Utils.p(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM, view.getTag())) {
                Qh(view);
            } else {
                c.C7154c c7154c = (c.C7154c) view.getTag();
                if (c7154c != null && (obj = c7154c.f181513m) != null) {
                    Ph(obj);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            com.tencent.mobileqq.activity.contacts.report.d.n("PAGE_INIT");
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.E.addObserver(this.S);
        this.E.addObserver(this.T);
        this.E.addObserver(this.U);
        this.E.addObserver(this.V);
        this.E.addObserver(this.W);
        this.E.addObserver(this.X);
        StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager != null) {
            statusManager.C(this.Y);
        }
        ((IPhoneContactService) this.E.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "doOnPause.");
        }
        Ah();
        ContactsFPSPinnedHeaderExpandableListView contactsFPSPinnedHeaderExpandableListView = this.Q;
        if (contactsFPSPinnedHeaderExpandableListView != null) {
            if (contactsFPSPinnedHeaderExpandableListView.getVisibility() == 0) {
                this.Q.hideCurShowingRightView();
            }
            this.Q.d0();
        }
        BuddyListAdapter buddyListAdapter = this.R;
        if (buddyListAdapter != null) {
            buddyListAdapter.t();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "refresh");
        }
        if (this.N) {
            ((FriendListHandler) this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, true);
        }
        this.P = true;
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "updateBuddyList succeeded");
        }
        ReportController.o(this.E, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", 51, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "resetData");
        }
        this.Z.removeCallbacksAndMessages(null);
        Th();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        boolean g16 = com.tencent.relation.common.config.toggle.c.H.g(false);
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "doOnResume. tabChange:" + z16 + ",mElvGroupingBuddies=" + this.Q + ", mGroupingBuddyListAdapter=" + this.R + ", isFriendFragmentShowOptEnable=" + g16);
        }
        if (this.Q == null) {
            return;
        }
        if (this.R == null) {
            Th();
        }
        ph();
        if (g16) {
            j3 = 0;
        } else {
            j3 = 500;
        }
        Rh(j3, true);
        ((FriendListHandler) this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(this.E.getCurrentAccountUin(), (byte) 1);
        if (!this.Z.hasMessages(5)) {
            this.Z.sendEmptyMessageDelayed(5, com.tencent.mobileqq.mutualmark.oldlogic.a.h() * 1000);
        }
        ((FriendsManager) this.E.getManager(QQManagerFactory.FRIENDS_MANAGER)).E(true);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater layoutInflater, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this, (Object) layoutInflater, (Object) bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.FriendFragment", 2, "getView mElvGroupingBuddies=" + this.Q);
        }
        ContactsFPSPinnedHeaderExpandableListView contactsFPSPinnedHeaderExpandableListView = this.Q;
        if (contactsFPSPinnedHeaderExpandableListView == null) {
            if (layoutInflater != null) {
                ContactsFPSPinnedHeaderExpandableListView contactsFPSPinnedHeaderExpandableListView2 = (ContactsFPSPinnedHeaderExpandableListView) layoutInflater.inflate(R.layout.f167792hn, (ViewGroup) null);
                this.Q = contactsFPSPinnedHeaderExpandableListView2;
                contactsFPSPinnedHeaderExpandableListView2.setActTAG("actFPSFriend");
                this.Q.setSelector(R.color.ajr);
                this.Q.setNeedCheckSpringback(true);
                this.Q.setGroupIndicator(null);
                this.Q.mForContacts = true;
                if (!com.tencent.relation.common.config.toggle.c.H.g(false)) {
                    return this.Q;
                }
                if (this.f181581a0 == null) {
                    CommonLoadingView commonLoadingView = (CommonLoadingView) layoutInflater.inflate(QUITokenResUtil.getResId(R.layout.f167785hg, R.layout.e3h), (ViewGroup) null);
                    this.f181581a0 = commonLoadingView;
                    TextView textView = (TextView) commonLoadingView.findViewById(R.id.f167068kf1);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                    layoutParams.gravity = 49;
                    layoutParams.topMargin = ViewUtils.dip2px(40.0f);
                    textView.setLayoutParams(layoutParams);
                }
                this.Q.addHeaderView(this.f181581a0);
            }
        } else {
            ViewParent parent = contactsFPSPinnedHeaderExpandableListView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.Q);
            }
        }
        return this.Q;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void xh() {
        BuddyListAdapter buddyListAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.Q != null && (buddyListAdapter = this.R) != null) {
            int groupCount = buddyListAdapter.getGroupCount();
            for (int i3 = 0; i3 < groupCount; i3++) {
                this.Q.collapseGroup(i3);
            }
            Uh(this.Q);
        }
    }
}
