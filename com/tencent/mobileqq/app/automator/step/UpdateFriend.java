package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class UpdateFriend extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ar f195380d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpdateFriend.this);
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
            int i3 = UpdateFriend.this.mStepId;
            if (i3 == 6 || i3 == 3) {
                if (!z16) {
                    QLog.i("IAutomator", 1, "onUpdateFriendList put PREF_ISFRIENDLIST_OK false");
                    UpdateFriend.this.setResult(6);
                } else if (z16 && z17) {
                    com.tencent.mobileqq.friend.utils.b.d().i(true);
                    if (QLog.isColorLevel()) {
                        QLog.d("IAutomator", 2, "onUpdateFriendList put PREF_ISFRIENDLIST_OK true");
                    }
                    ((Automator) UpdateFriend.this.mAutomator).notifyUI(3, true, 1);
                    UpdateFriend.this.setResult(7);
                }
            }
            UpdateFriend.this.removeObserver();
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateGatherFriendList(boolean z16, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
                return;
            }
            UpdateFriend updateFriend = UpdateFriend.this;
            if (updateFriend.mStepId == 7) {
                if (!z16) {
                    updateFriend.setResult(6);
                } else if (z17) {
                    updateFriend.setResult(7);
                }
            }
            UpdateFriend.this.removeObserver();
        }
    }

    public UpdateFriend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g() {
        if (this.f195380d == null) {
            a aVar = new a();
            this.f195380d = aVar;
            ((Automator) this.mAutomator).E.addObserver(aVar);
        }
        ((FriendListHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true);
    }

    private void h() {
        if (this.f195380d == null) {
            a aVar = new a();
            this.f195380d = aVar;
            ((Automator) this.mAutomator).E.addObserver(aVar);
        }
        ((FriendListHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getGatheredContactsList(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeObserver() {
        ar arVar = this.f195380d;
        if (arVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(arVar);
            this.f195380d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int i3 = this.mStepId;
        if (i3 == 3) {
            boolean e16 = com.tencent.mobileqq.friend.utils.b.d().e();
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "doStep PREF_ISFRIENDLIST_OK=" + e16);
            }
            FriendsManager friendsManager = (FriendsManager) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (e16) {
                FriendListHandler friendListHandler = (FriendListHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                boolean T = friendsManager.T();
                friendsManager.a0();
                friendListHandler.notifyUI(1, T, Boolean.valueOf(T));
                ((Automator) this.mAutomator).notifyUI(3, true, 1);
                return 7;
            }
            friendsManager.T();
            friendsManager.a0();
            g();
            return 7;
        }
        if (i3 == 6) {
            g();
        } else {
            h();
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.mStepId == 3) {
            ((IPhoneContactService) ((Automator) this.mAutomator).E.getRuntimeService(IPhoneContactService.class, "")).initContactCache();
        }
        if (this.mStepId == 7) {
            i3 = 0;
        }
        this.mCountRetry = i3;
    }
}
