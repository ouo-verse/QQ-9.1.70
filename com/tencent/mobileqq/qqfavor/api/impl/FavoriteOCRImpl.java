package com.tencent.mobileqq.qqfavor.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfavor.api.IFavoriteOCR;
import com.tencent.mobileqq.text.AbsQQText;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.d;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FavoriteOCRImpl implements IFavoriteOCR {
    static IPatchRedirector $redirector_;

    public FavoriteOCRImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String doReplaceForIndex20(String str) {
        int i3;
        int i16;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        int length = sb5.length();
        int i17 = 0;
        while (i17 < length) {
            if (20 == sb5.charAt(i17) && (i3 = i17 + 1) < length && '\u00ff' == sb5.charAt(i3) && (i16 = i17 + 2) < length) {
                if (sb5.charAt(i16) == 20) {
                    sb5.setCharAt(i16, AbsQQText.HEAD_INDEX_REPLACE);
                }
                i17 += 4;
            }
            i17++;
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.qqfavor.api.IFavoriteOCR
    public void favorite(Activity activity, String str) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) str);
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            QfavBuilder.k0(null, doReplaceForIndex20(str)).R(qQAppInterface, null).h(activity, qQAppInterface.getAccount());
            d.e(qQAppInterface, 6, 1);
        }
    }
}
