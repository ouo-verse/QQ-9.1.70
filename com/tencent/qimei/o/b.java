package com.tencent.qimei.o;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes22.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray<WeakReference<Activity>> f343354a;

    /* renamed from: b, reason: collision with root package name */
    public static int f343355b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16880);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f343354a = new SparseArray<>();
            f343355b = 0;
        }
    }
}
