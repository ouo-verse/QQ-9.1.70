package com.tencent.mobileqq.chat.autoreply;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(AppRuntime.Status status) {
        if (status != AppRuntime.Status.away && status != AppRuntime.Status.dnd && status != AppRuntime.Status.busy) {
            return true;
        }
        return false;
    }
}
