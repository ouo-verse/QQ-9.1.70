package com.tencent.mobileqq.profilecard.bussiness.anonymous.handler;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AnonymousObserver implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    protected static final int NOTIFY_BROWSE_ASK_ANONYMOUSLY_REPORT = 2;
    protected static final int NOTIFY_GET_LATEST_ANONYMOUS_INFO = 3;
    protected static final int NOTIFY_LIKE_ANONYMOUS_ANSWER = 1;
    protected static final int NOTIFY_REPLY_TROOP_ASK_ANONYMOUSLY = 4;
    public static final int TYPE_ANONYMOUS_SETTING_ME_RED_POINT = 5;

    public AnonymousObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void onUpdate_onAnonymousSettingMeRedPoint(int i3, boolean z16, Object obj) {
        boolean z17;
        if (i3 != 5) {
            return;
        }
        if (obj instanceof Boolean) {
            z17 = ((Boolean) obj).booleanValue();
        } else {
            z17 = false;
        }
        onAnonymousSettingMeRedPoint(z16, z17);
    }

    public void onAnonymousSettingMeRedPoint(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    public void onBrowseAskAnonymouslyReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    public void onGetLatestAnonymousInfo(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), obj);
        }
    }

    public void onLikeAnonymousAnswer(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
    }

    public void onReplyTroopAskAnonymously(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 == 1) {
            onLikeAnonymousAnswer(z16);
        } else if (i3 == 2) {
            onBrowseAskAnonymouslyReport(z16);
        } else if (i3 == 3) {
            onGetLatestAnonymousInfo(z16, obj);
        } else if (i3 == 4) {
            onReplyTroopAskAnonymously(z16, obj);
        }
        onUpdate_onAnonymousSettingMeRedPoint(i3, z16, obj);
    }
}
