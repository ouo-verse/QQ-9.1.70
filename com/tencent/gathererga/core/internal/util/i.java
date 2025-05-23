package com.tencent.gathererga.core.internal.util;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f108290a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56021);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f108290a = new String[0];
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getApplicationContext() == null) {
                return false;
            }
            if (context.getApplicationContext().checkCallingOrSelfPermission(str) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            d.c("PermissionUtil checkPermission " + str + " Throwable.", th5);
            return false;
        }
    }

    public static String[] b(Context context, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (String str : strArr) {
                if (!a(context, str)) {
                    copyOnWriteArrayList.add(str);
                }
            }
            if (copyOnWriteArrayList.isEmpty()) {
                return f108290a;
            }
            return (String[]) copyOnWriteArrayList.toArray(new String[0]);
        }
        return f108290a;
    }
}
