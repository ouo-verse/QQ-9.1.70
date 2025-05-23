package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivityWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ep {
    static IPatchRedirector $redirector_;

    @Nullable
    public static Activity a(Context context) {
        while (true) {
            if ((!(context instanceof ContextWrapper) || (context instanceof Activity)) && !(context instanceof QBaseActivityWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public static Context b(Context context) {
        Activity a16 = a(context);
        if (a16 != null) {
            return a16;
        }
        return context;
    }
}
