package com.tencent.mobileqq.qqlive.room.multichat.utils;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(Context context, String str) {
        QQToast.makeText(context, 1, str, 0).show();
    }
}
