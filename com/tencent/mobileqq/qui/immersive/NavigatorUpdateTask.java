package com.tencent.mobileqq.qui.immersive;

import android.R;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class NavigatorUpdateTask extends c implements Runnable {
    static IPatchRedirector $redirector_;

    public NavigatorUpdateTask(Window window, WeakReference<View> weakReference) {
        super(window, weakReference);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) window, (Object) weakReference);
        }
    }

    public static void p(Window window, int i3) {
        boolean z16;
        if (c.c(i3) > c.f276883h) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImmersiveUtils.setNavigationBarIconColor(window, z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4 A[Catch: Exception -> 0x0123, TryCatch #0 {Exception -> 0x0123, blocks: (B:10:0x0013, B:13:0x001e, B:15:0x0026, B:16:0x002e, B:18:0x0043, B:21:0x004a, B:23:0x004e, B:24:0x0086, B:26:0x00e4, B:28:0x00f3, B:30:0x00fb, B:31:0x0106, B:35:0x0066, B:38:0x006d), top: B:9:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        View view;
        Pair<Boolean, Integer> f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            Window window = this.f276884d.get();
            if (window == null) {
                return;
            }
            long nanoTime = System.nanoTime();
            WeakReference<View> weakReference = this.f276885e;
            if (weakReference != null) {
                view = weakReference.get();
            } else {
                view = null;
            }
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(R.id.content);
            if (view != null && k(view)) {
                if (view instanceof ViewGroup) {
                    arrayList.add(view);
                    arrayList.addAll(c.o((ViewGroup) view, 1, view.getHeight() - 1, 0, 0, true));
                } else {
                    arrayList.add(view);
                }
                ArrayList arrayList2 = new ArrayList();
                f16 = c.f(arrayList, IColorFetcher.Area.BOTTOM, arrayList2);
                int navigationBarColor = window.getNavigationBarColor();
                c.m("QUIImmersiveHelper-NavigatorUpdateTask", "navigation backgroundColorResult " + f16 + " color:" + Integer.toHexString(((Integer) f16.second).intValue()) + " current navigationBar color" + Integer.toHexString(navigationBarColor) + " costTime: " + (System.nanoTime() - nanoTime));
                if (!((Boolean) f16.first).booleanValue()) {
                    RFWImmersiveUtils.addFlags(window, Integer.MIN_VALUE);
                    if (navigationBarColor != ((Integer) f16.second).intValue() && !com.tencent.mobileqq.qui.b.f276860a.j(window)) {
                        window.setNavigationBarColor(((Integer) f16.second).intValue());
                    }
                    p(window, ((Integer) f16.second).intValue());
                    a l3 = QUIImmersiveHelper.l(window);
                    l3.f276874a = new WeakReference<>(window);
                    l3.f276878e = true;
                    l3.f276880g = f16;
                    l3.f276879f = arrayList2;
                    return;
                }
                return;
            }
            arrayList.add(viewGroup);
            arrayList.addAll(c.o(viewGroup, viewGroup.getWidth() / 2, viewGroup.getHeight() - 1, 0, 0, true));
            ArrayList arrayList22 = new ArrayList();
            f16 = c.f(arrayList, IColorFetcher.Area.BOTTOM, arrayList22);
            int navigationBarColor2 = window.getNavigationBarColor();
            c.m("QUIImmersiveHelper-NavigatorUpdateTask", "navigation backgroundColorResult " + f16 + " color:" + Integer.toHexString(((Integer) f16.second).intValue()) + " current navigationBar color" + Integer.toHexString(navigationBarColor2) + " costTime: " + (System.nanoTime() - nanoTime));
            if (!((Boolean) f16.first).booleanValue()) {
            }
        } catch (Exception e16) {
            QLog.e("QUIImmersiveHelper-NavigatorUpdateTask", 1, e16, new Object[0]);
        }
    }
}
