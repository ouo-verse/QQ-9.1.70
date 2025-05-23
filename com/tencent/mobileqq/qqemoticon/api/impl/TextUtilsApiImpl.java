package com.tencent.mobileqq.qqemoticon.api.impl;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.text.TextUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TextUtilsApiImpl implements ITextUtilsApi {
    static IPatchRedirector $redirector_;

    public TextUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi
    public String emoticonToTextForTalkBack(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return TextUtils.emoticonToTextForTalkBack(str);
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi
    public Drawable getResourceDrawableThroughImageCache(Resources resources, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources, i3);
        }
        return TextUtils.getResourceDrawableThroughImageCache(resources, i3);
    }
}
