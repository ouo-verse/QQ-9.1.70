package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class UpdateDiscuss extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.discussion.observer.a f195378d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpdateDiscuss.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void x(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "updateDiscussionList: " + z16);
            }
            if (!z16) {
                UpdateDiscuss.this.setResult(6);
                return;
            }
            ((Automator) UpdateDiscuss.this.mAutomator).f195307f.edit().putBoolean("isDiscussionlistok", true).commit();
            ((Automator) UpdateDiscuss.this.mAutomator).notifyUI(3, true, 3);
            UpdateDiscuss.this.setResult(7);
        }
    }

    public UpdateDiscuss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g() {
        if (this.f195378d == null) {
            a aVar = new a();
            this.f195378d = aVar;
            ((Automator) this.mAutomator).E.addObserver(aVar);
        }
        ((DiscussionHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).R2(Long.valueOf(((Automator) this.mAutomator).E.getCurrentAccountUin()).longValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        boolean z16 = ((Automator) this.mAutomator).f195307f.getBoolean("isDiscussionlistok", false);
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (z16) {
            FriendListHandler friendListHandler = (FriendListHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            nVar.v();
            friendListHandler.notifyUI(1000, true, null);
            ((Automator) this.mAutomator).notifyUI(3, true, 3);
            return 7;
        }
        nVar.v();
        g();
        return 2;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.discussion.observer.a aVar = this.f195378d;
        if (aVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(aVar);
            this.f195378d = null;
        }
    }
}
