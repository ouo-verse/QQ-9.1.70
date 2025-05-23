package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CheckFriendsLastLoginInfo extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ar f195328d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CheckFriendsLastLoginInfo.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        
            if (r7 != false) goto L13;
         */
        @Override // com.tencent.mobileqq.app.ar
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void onUpdateLastLoginInfo(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z18 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (!z16) {
                CheckFriendsLastLoginInfo.this.setResult(6);
            }
            z18 = false;
            if (z18) {
                CheckFriendsLastLoginInfo.this.setResult(7);
            }
        }
    }

    public CheckFriendsLastLoginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (((FriendListHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getLastLoginInfo()) {
            if (this.f195328d == null) {
                a aVar = new a();
                this.f195328d = aVar;
                ((Automator) this.mAutomator).E.addObserver(aVar);
            }
            return 2;
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ar arVar = this.f195328d;
        if (arVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(arVar);
            this.f195328d = null;
        }
    }
}
