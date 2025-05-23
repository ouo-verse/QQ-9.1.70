package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlphabetFriendFragment extends ContactsBaseFragment implements View.OnClickListener, Handler.Callback, od2.a, IndexBar.a {
    static IPatchRedirector $redirector_;
    private boolean N;
    private boolean P;
    protected View Q;
    protected PinnedDividerListView R;
    protected IndexBar S;
    protected IndexBarTipsLayout T;
    private View U;
    private AlphabetFriendAdapter V;
    private final c W;
    private final d X;
    private final a Y;
    private final b Z;

    /* renamed from: a0, reason: collision with root package name */
    private final f f181420a0;

    /* renamed from: b0, reason: collision with root package name */
    private final e f181421b0;

    /* renamed from: c0, reason: collision with root package name */
    private final g f181422c0;

    /* renamed from: d0, reason: collision with root package name */
    private MqqHandler f181423d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f181424e0;

    /* renamed from: f0, reason: collision with root package name */
    private Vibrator f181425f0;

    /* renamed from: g0, reason: collision with root package name */
    private Runnable f181426g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f181427h0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphabetFriendFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                AlphabetFriendFragment.this.Th(5000L, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends CardObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphabetFriendFragment.this);
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
                AlphabetFriendFragment.this.Th(1400L, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends ar {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphabetFriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onAddGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), groupActionResp);
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onDeleteGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), groupActionResp);
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGroupDataInited() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
                AlphabetFriendFragment.this.Th(1400L, true);
            } else {
                iPatchRedirector.redirect((short) 18, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onRenameGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), groupActionResp);
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onResortGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), groupActionResp);
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetComment(boolean z16, String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
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
                QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + z16);
            }
            AlphabetFriendFragment alphabetFriendFragment = AlphabetFriendFragment.this;
            if (alphabetFriendFragment.H && alphabetFriendFragment.V != null) {
                AlphabetFriendFragment.this.V.r();
            }
            if (AlphabetFriendFragment.this.isResumed() && z16 && AlphabetFriendFragment.this.H) {
                try {
                    String[] strArr = (String[]) objArr[1];
                    boolean[] zArr = (boolean[]) objArr[2];
                    if (QLog.isColorLevel()) {
                        QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString(strArr), Arrays.toString(zArr));
                    }
                    if (zArr != null && zArr.length > 0) {
                        if (zArr[0]) {
                            QQToast.makeText(AlphabetFriendFragment.this.getActivity(), 2, HardCodeUtil.qqStr(R.string.jd9), 0).show();
                            return;
                        } else {
                            QQToast.makeText(AlphabetFriendFragment.this.getActivity(), 2, HardCodeUtil.qqStr(R.string.jd_), 0).show();
                            return;
                        }
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("contacts.fragment.AlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global fail!", e16);
                        if (AlphabetFriendFragment.this.isResumed()) {
                            QQToast.makeText(AlphabetFriendFragment.this.getActivity(), 1, HardCodeUtil.qqStr(R.string.d0f), 0).show();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            QLog.e("contacts.fragment.AlphabetFriendFragment", 2, "onSetSpecialCareSwitch_global fail, isResume=" + AlphabetFriendFragment.this.isResumed() + ", isSuccess=" + z16);
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateAnswerAddedFriend(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateDelFriend isSucess= " + z16);
            }
            if (z16) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
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
            AlphabetFriendFragment alphabetFriendFragment = AlphabetFriendFragment.this;
            if (!z17 && z16) {
                z18 = false;
            } else {
                z18 = true;
            }
            alphabetFriendFragment.N = z18;
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateFriendList isSucess= " + z16 + ",isComplete=" + z17);
            }
            boolean z19 = AlphabetFriendFragment.this.P;
            if (AlphabetFriendFragment.this.P) {
                if (AlphabetFriendFragment.this.N) {
                    AlphabetFriendFragment.this.P = false;
                    if (((ContactsBaseFragment) AlphabetFriendFragment.this).C != null) {
                        ((ContactsBaseFragment) AlphabetFriendFragment.this).C.c(AlphabetFriendFragment.this.th(), z16, null);
                    }
                }
                AlphabetFriendFragment alphabetFriendFragment2 = AlphabetFriendFragment.this;
                if (alphabetFriendFragment2.N) {
                    j3 = 0;
                } else {
                    j3 = 1400;
                }
                alphabetFriendFragment2.Th(j3, true);
            }
            if (!z19 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateGatherFriendList(boolean z16, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            } else if (z16 && z17 && z18) {
                AlphabetFriendFragment.this.Th(0L, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateHotFriendLevel(boolean z16, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                AlphabetFriendFragment.this.Th(1400L, false);
            } else {
                iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), arrayList);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateLastLoginInfo(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16) {
                AlphabetFriendFragment.this.Th(1400L, false);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateMoveGroup(String str, byte b16, byte b17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, str, Byte.valueOf(b16), Byte.valueOf(b17));
            } else if (str != null && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateOlympicTorchList(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, z16);
            } else if (z16) {
                AlphabetFriendFragment.this.Th(1400L, false);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateOnlineFriend(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), strArr);
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSignature(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), strArr);
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, false);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSpecialCareList(boolean z16, boolean z17, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), arrayList, arrayList2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateSpecialCareList isSucess= " + z16 + ",isComplete=" + z17);
            }
            AlphabetFriendFragment alphabetFriendFragment = AlphabetFriendFragment.this;
            if (alphabetFriendFragment.H && z16 && alphabetFriendFragment.V != null) {
                AlphabetFriendFragment.this.V.r();
                AlphabetFriendFragment.this.Th(0L, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphabetFriendFragment.this);
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
                QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onUpdateAddFriend isSucess= " + z16 + ",addSuccess=" + z17 + " addDirect=" + z18);
            }
            if (z16 && z17 && z18) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends bs {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphabetFriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onUpdateFriendsList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class f extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphabetFriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else if (z16 && AlphabetFriendFragment.this.N) {
                AlphabetFriendFragment.this.Th(1400L, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements com.tencent.mobileqq.richstatus.e {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlphabetFriendFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            } else if (AlphabetFriendFragment.this.N && bitmap != null && i16 == 200) {
                AlphabetFriendFragment.this.Th(1400L, false);
            }
        }
    }

    public AlphabetFriendFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.N = true;
        this.P = false;
        this.W = new c();
        this.X = new d();
        this.Y = new a();
        this.Z = new b();
        this.f181420a0 = new f();
        this.f181421b0 = new e();
        this.f181422c0 = new g();
        this.f181423d0 = new MqqHandler(Looper.getMainLooper(), this);
        this.f181424e0 = true;
        this.f181426g0 = new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlphabetFriendFragment.this);
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
                    if (AlphabetFriendFragment.this.f181425f0 == null) {
                        AlphabetFriendFragment alphabetFriendFragment = AlphabetFriendFragment.this;
                        alphabetFriendFragment.f181425f0 = (Vibrator) alphabetFriendFragment.getActivity().getSystemService("vibrator");
                    }
                    AlphabetFriendFragment.this.f181425f0.vibrate(20L);
                } catch (Exception e16) {
                    QLog.e("contacts.fragment.AlphabetFriendFragment", 2, "Vibrator exception.");
                    e16.printStackTrace();
                }
            }
        };
        this.f181427h0 = "";
    }

    private void Qh() {
        PinnedDividerListView pinnedDividerListView = this.R;
        if (pinnedDividerListView != null && pinnedDividerListView.getFooterViewsCount() <= 0) {
            if (this.U == null) {
                if (getActivity() == null) {
                    QLog.e("contacts.fragment.AlphabetFriendFragment", 1, "refreshUnusualContactsFooter getActivity return null");
                    return;
                }
                this.U = LayoutInflater.from(getActivity()).inflate(QUITokenResUtil.getResId(R.layout.f167782hb, R.layout.e3d), (ViewGroup) this.R, false);
            }
            this.R.addFooterView(this.U);
        }
    }

    private void Rh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "<<--doRefreshBuddyList, load=" + z16 + ", mIsTabSelected=" + this.H + ",needTabRefresh =" + this.f181424e0);
        }
        if (!this.H) {
            if (QLog.isColorLevel()) {
                QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "<<--doRefreshBuddyList, return mIsTabSelected =" + this.H);
            }
            this.f181424e0 = true;
            return;
        }
        AlphabetFriendAdapter alphabetFriendAdapter = this.V;
        if (alphabetFriendAdapter != null) {
            if (z16) {
                alphabetFriendAdapter.r();
            } else {
                alphabetFriendAdapter.notifyDataSetChanged();
            }
        }
    }

    private boolean Sh(Object obj) {
        if (obj instanceof Friends) {
            Friends friends = (Friends) obj;
            if (QLog.isColorLevel()) {
                QLog.d("Hyim", 2, "onItemClick:" + friends.name + friends.uin + "--[" + ((int) friends.detalStatusFlag) + "] [" + friends.iTermType + "] [" + friends.getLastLoginType() + "] [" + friends.showLoginClient + "]");
            }
            AllInOne allInOne = new AllInOne(friends.uin, 1);
            allInOne.profileEntryType = 59;
            allInOne.chatEntrance = 2;
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 52);
            ProfileUtils.openProfileCard(this.K, allInOne);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th(long j3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "refreshBuddyList, delay=" + j3 + ", load=" + z16);
        }
        int i3 = 4;
        this.f181423d0.removeMessages(4);
        if (z16) {
            this.f181423d0.removeMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION);
        } else if (this.f181423d0.hasMessages(ActivityResultManager.ACTION_REQUEST_PERMISSION)) {
            return;
        }
        if (j3 == 0) {
            Rh(z16);
            return;
        }
        MqqHandler mqqHandler = this.f181423d0;
        if (z16) {
            i3 = 9527;
        }
        mqqHandler.sendEmptyMessageDelayed(i3, j3);
    }

    private void Uh() {
        if (this.T != null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_alphabet_friend_index_view_token_refresh", false)) {
            this.T.b();
        }
    }

    private void Vh() {
        QQAppInterface qQAppInterface;
        int i3;
        if (this.S != null && (qQAppInterface = this.E) != null) {
            if (ThemeUtil.isNowThemeIsSimple(qQAppInterface, false, null)) {
                IndexBar indexBar = this.S;
                if (ThemeUtil.isNowThemeIsNight(this.E, false, null)) {
                    i3 = -1;
                } else {
                    i3 = -16777216;
                }
                indexBar.setSelectPaintColor(i3, Color.parseColor("#CCCCCC"));
                return;
            }
            this.S.setSelectPaintColor(Color.parseColor("#0099FF"), Color.parseColor("#b0b3bf"));
        }
    }

    private void Wh() {
        Resources resources = getResources();
        IndexBar indexBar = this.S;
        if (indexBar != null && resources != null) {
            indexBar.setSelectPaintColor(resources.getColor(R.color.qui_common_brand_standard, null), resources.getColor(R.color.qui_common_text_secondary, null));
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.E.removeObserver(this.W);
        this.E.removeObserver(this.X);
        this.E.removeObserver(this.Y);
        this.E.removeObserver(this.Z);
        this.E.removeObserver(this.f181420a0);
        this.E.removeObserver(this.f181421b0);
        StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager != null) {
            statusManager.b0(this.f181422c0);
        }
        ((IPhoneContactService) this.E.getRuntimeService(IPhoneContactService.class, "")).removeListener(this);
    }

    @Override // od2.a
    public void B7(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        }
    }

    @Override // od2.a
    public void L1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void T2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
    }

    @Override // od2.a
    public void Ug(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "onBindStateChanged bindState=" + i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnDestroy.");
        }
        this.f181423d0.removeCallbacksAndMessages(null);
        Ah();
        AlphabetFriendAdapter alphabetFriendAdapter = this.V;
        if (alphabetFriendAdapter != null) {
            alphabetFriendAdapter.destroy();
        }
    }

    @Override // od2.a
    public void e7(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.activity.contacts.base.h.a
    public View getScrollableView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.R;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 4) {
            if (i3 != 5) {
                if (i3 == 9527) {
                    Th(0L, true);
                }
            } else if (this.N) {
                Th(0L, false);
            }
        } else if (this.N) {
            Th(0L, false);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
    public void m(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (!z16) {
            this.f181427h0 = "";
        }
        IndexBarTipsLayout indexBarTipsLayout = this.T;
        if (indexBarTipsLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            indexBarTipsLayout.setVisibility(i3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.C7154c c7154c;
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else {
            view.getId();
            if (!Utils.p(SwipTextViewMenuBuilder.TAG_SWIP_ICON_MENU_ITEM, view.getTag()) && (c7154c = (c.C7154c) view.getTag()) != null && (obj = c7154c.f181513m) != null) {
                Sh(obj);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a
    public void p1(String str, int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        ContactsBaseFragment.c cVar = this.C;
        if (cVar != null && i3 == 0) {
            cVar.b();
        }
        ReportController.o(null, "dc00898", "", "", "0X800A1F8", "0X800A1F8", 0, 0, "", "", "", "");
        IndexBarTipsLayout indexBarTipsLayout = this.T;
        if (indexBarTipsLayout != null) {
            indexBarTipsLayout.setText(str, f16);
        }
        if (!this.f181427h0.equals(str)) {
            this.f181427h0 = str;
            if ("\u2605".equals(str)) {
                this.R.setSelection(0);
            } else {
                int p16 = this.V.p(str);
                if (p16 != -1) {
                    PinnedDividerListView pinnedDividerListView = this.R;
                    pinnedDividerListView.setSelection(p16 + pinnedDividerListView.getHeaderViewsCount());
                }
            }
            if (this.f181426g0 != null) {
                ThreadManager.getSubThreadHandler().removeCallbacks(this.f181426g0);
                ThreadManager.getSubThreadHandler().post(this.f181426g0);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.E.addObserver(this.W);
        this.E.addObserver(this.X);
        this.E.addObserver(this.Y);
        this.E.addObserver(this.Z);
        this.E.addObserver(this.f181420a0);
        this.E.addObserver(this.f181421b0);
        StatusManager statusManager = (StatusManager) this.E.getManager(QQManagerFactory.STATUS_MANAGER);
        if (statusManager != null) {
            statusManager.C(this.f181422c0);
        }
        ((IPhoneContactService) this.E.getRuntimeService(IPhoneContactService.class, "")).addListener(this);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnPause.");
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "refresh");
        }
        if (this.N) {
            ((FriendListHandler) this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, true);
        }
        this.P = true;
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "updateBuddyList succeeded");
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "resetData");
        }
        IndexBar indexBar = this.S;
        if (indexBar != null) {
            indexBar.setLetters(null);
        }
        this.f181423d0.removeCallbacksAndMessages(null);
        AlphabetFriendAdapter alphabetFriendAdapter = this.V;
        if (alphabetFriendAdapter != null) {
            alphabetFriendAdapter.k();
            this.V.x();
            this.V.destroy();
            if (this.R != null) {
                this.V = new AlphabetFriendAdapter(getActivity(), this.E, this.R, this.S, this);
                Qh();
                this.V.v(this.U);
                this.R.setAdapter((ListAdapter) this.V);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "doOnResume. tabChange:" + z16 + ",mListView=" + this.R + ", mAdapter=" + this.V + ", needTabRefresh=" + this.f181424e0);
        }
        if (this.R == null) {
            return;
        }
        if (QUITokenResUtil.useQUIToken()) {
            Wh();
            Uh();
        } else {
            Vh();
        }
        if (this.V == null) {
            this.V = new AlphabetFriendAdapter(getActivity(), this.E, this.R, this.S, this);
            Qh();
            this.V.v(this.U);
            this.R.setAdapter((ListAdapter) this.V);
        }
        if (this.f181424e0) {
            Th(300L, true);
            this.f181424e0 = false;
        }
        ((FriendListHandler) this.E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineFriend(this.E.getCurrentAccountUin(), (byte) 1);
        if (!this.f181423d0.hasMessages(5)) {
            this.f181423d0.sendEmptyMessageDelayed(5, com.tencent.mobileqq.mutualmark.oldlogic.a.h() * 1000);
        }
        ((FriendsManager) this.E.getManager(QQManagerFactory.FRIENDS_MANAGER)).E(true);
        ReportController.o(null, "dc00898", "", "", "0X800A1F7", "0X800A1F7", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater layoutInflater, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this, (Object) layoutInflater, (Object) bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.AlphabetFriendFragment", 2, "getView ");
        }
        View view = this.Q;
        if (view == null) {
            View inflate = layoutInflater.inflate(QUITokenResUtil.getResId(R.layout.f167791hm, R.layout.e3w), (ViewGroup) null, false);
            this.Q = inflate;
            PinnedDividerListView pinnedDividerListView = (PinnedDividerListView) inflate.findViewById(R.id.f164304rm);
            this.R = pinnedDividerListView;
            pinnedDividerListView.mForContacts = true;
            this.S = (IndexBar) this.Q.findViewById(R.id.djh);
            this.T = (IndexBarTipsLayout) this.Q.findViewById(R.id.dji);
            this.S.setOnIndexBarTouchListener(this);
        } else {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Q);
            }
        }
        return this.Q;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void xh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
