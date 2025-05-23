package com.tencent.qui;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static QQToast a(Context context, int i3, CharSequence charSequence, int i16) {
        return QQToast.makeText(context, i3, charSequence, i16);
    }

    public static QQToast b(Context context, CharSequence charSequence, int i3) {
        return QQToast.makeText(context, 0, charSequence, i3);
    }
}
