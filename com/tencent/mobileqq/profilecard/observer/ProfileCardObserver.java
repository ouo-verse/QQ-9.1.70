package com.tencent.mobileqq.profilecard.observer;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileCardObserver implements ICardObserver {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_GET_PROFILE_CARD = 1001;
    public static final int TYPE_GET_PROFILE_DETAIL = 1002;
    public static final int TYPE_SET_PROFILE_DETAIL = 1003;
    public static final int TYPE_SET_TEMPLATE_ID = 41;
    private static final int TYPE_START_DEFINE = 1000;

    public ProfileCardObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void onGetProfileCard(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGetProfileDetail(boolean z16, String str, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, card);
        }
    }

    protected void onSetCardTemplateReturn(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void onSetProfileDetail(boolean z16, int i3, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), card);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 41) {
            switch (i3) {
                case 1001:
                    onGetProfileCard(z16, obj);
                    return;
                case 1002:
                    if (z16) {
                        Card card = (Card) obj;
                        onGetProfileDetail(z16, card.uin, card);
                        return;
                    }
                    return;
                case 1003:
                    Object[] objArr = (Object[]) obj;
                    onSetProfileDetail(z16, ((Integer) objArr[0]).intValue(), (Card) objArr[1]);
                    return;
                default:
                    return;
            }
        }
        onSetCardTemplateReturn(z16, obj);
    }
}
