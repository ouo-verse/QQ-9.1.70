package com.tencent.mobileqq.ui.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.ui.api.IQQTextApi;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QQTextApiImpl implements IQQTextApi {
    static IPatchRedirector $redirector_;

    public QQTextApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ui.api.IQQTextApi
    public CharSequence buildQQText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
        }
        return new QQText(charSequence, 3, 16);
    }

    @Override // com.tencent.mobileqq.ui.api.IQQTextApi
    public int getEmojiTypeEmoji() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.ui.api.IQQTextApi
    public int getEmojiTypeSmall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.ui.api.IQQTextApi
    public int getEmojiTypeSystem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.ui.api.IQQTextApi
    public int getGrabEmotcation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return 3;
        }
        return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }
}
