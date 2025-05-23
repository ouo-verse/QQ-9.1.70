package com.tencent.trackrecordlib.g;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381145a;

    /* renamed from: b, reason: collision with root package name */
    private static int f381146b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11697);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381145a = g.class.getSimpleName();
            f381146b = -1;
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int a(Context context) {
        WindowManager windowManager;
        if (context == null) {
            return -1;
        }
        if (f381146b == -1 && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f381146b = point.y;
        }
        return f381146b;
    }
}
