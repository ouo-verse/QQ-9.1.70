package com.tencent.offline.component.update;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(Context context, String str, int i3) {
        com.tencent.hy.common.store.a.f("offline_expire_" + str, i3);
    }
}
