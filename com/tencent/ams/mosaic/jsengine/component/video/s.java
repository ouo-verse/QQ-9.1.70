package com.tencent.ams.mosaic.jsengine.component.video;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f71414a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58735);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f71414a = -1;
        }
    }

    private static void a(Activity activity) {
        boolean z16;
        int i3 = Build.VERSION.SDK_INT;
        if (activity != null) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if ((attributes.flags & 1024) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.ams.mosaic.utils.f.a("VideoUtils", "enterFullScreen, isCurrentFullscreen: " + z16);
            if (i3 >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            attributes.flags |= 67110400;
            window.setAttributes(attributes);
        }
    }

    public static void b(Context context, View view, a aVar, ViewGroup viewGroup, ViewGroup viewGroup2, boolean z16) {
        if (context != null && view != null && viewGroup != null && viewGroup2 != null) {
            Activity e16 = e(context);
            if (e16 == null) {
                com.tencent.ams.mosaic.utils.f.h("VideoUtils", "enterFullScreen failed: null activity");
                return;
            }
            a(e16);
            if (z16) {
                f71414a = e16.getRequestedOrientation();
                e16.setRequestedOrientation(0);
                com.tencent.ams.mosaic.utils.f.e("VideoUtils", "enterFullScreen set orientation from " + f71414a + " to 0");
            }
            com.tencent.ams.mosaic.utils.k.c(view);
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
            if (aVar != null) {
                com.tencent.ams.mosaic.utils.k.c(aVar.getView());
                viewGroup.addView(aVar.getView(), new FrameLayout.LayoutParams(-1, -1));
                aVar.setFullScreen(true, z16);
            }
            com.tencent.ams.mosaic.utils.f.a("VideoUtils", "enterFullScreen success");
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("VideoUtils", "enterFullScreen failed: invalid params");
    }

    private static void c(Activity activity) {
        com.tencent.ams.mosaic.utils.f.a("VideoUtils", "exitFullScreen");
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.flags &= -1025;
        activity.getWindow().setAttributes(attributes);
        activity.getWindow().clearFlags(512);
        activity.getWindow().clearFlags(67108864);
    }

    public static void d(Context context, View view, a aVar, ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (context != null && view != null && viewGroup != null && viewGroup2 != null) {
            Activity e16 = e(context);
            if (e16 == null) {
                com.tencent.ams.mosaic.utils.f.h("VideoUtils", "exitFullScreen failed: null activity");
                return;
            }
            c(e16);
            if (e16.getRequestedOrientation() == 0) {
                e16.setRequestedOrientation(f71414a);
                com.tencent.ams.mosaic.utils.f.e("VideoUtils", "exitFullScreen set orientation to " + f71414a);
            }
            com.tencent.ams.mosaic.utils.k.c(view);
            viewGroup2.addView(view, new FrameLayout.LayoutParams(-1, -1));
            if (aVar != null) {
                com.tencent.ams.mosaic.utils.k.c(aVar.getView());
                viewGroup2.addView(aVar.getView(), new FrameLayout.LayoutParams(-1, -1));
                aVar.setFullScreen(false, false);
            }
            com.tencent.ams.mosaic.utils.f.a("VideoUtils", "exitFullScreen success");
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("VideoUtils", "exitFullScreen failed: invalid params");
    }

    public static Activity e(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
