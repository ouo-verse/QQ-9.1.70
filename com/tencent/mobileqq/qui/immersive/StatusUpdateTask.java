package com.tencent.mobileqq.qui.immersive;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class StatusUpdateTask extends c implements Runnable {
    static IPatchRedirector $redirector_;

    public StatusUpdateTask(Window window, WeakReference<View> weakReference) {
        super(window, weakReference);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) window, (Object) weakReference);
        }
    }

    private View p() {
        WeakReference<View> weakReference = this.f276885e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            Window window = this.f276884d.get();
            if (window == null || this.f276886f) {
                return;
            }
            long nanoTime = System.nanoTime();
            ArrayList arrayList = new ArrayList();
            View p16 = p();
            if (p16 != null) {
                arrayList.add(p16);
                if (p16 instanceof ViewGroup) {
                    arrayList.addAll(c.o((ViewGroup) p16, p16.getWidth() / 2, 5, 0, 0, false));
                }
            } else {
                arrayList.addAll(c.o((ViewGroup) window.getDecorView(), window.getDecorView().getWidth() / 2, 5, 0, 0, false));
            }
            ArrayList arrayList2 = new ArrayList();
            Pair<Boolean, Integer> f16 = c.f(arrayList, IColorFetcher.Area.TOP, arrayList2);
            if (((Boolean) f16.first).booleanValue()) {
                double c16 = c.c(((Integer) f16.second).intValue());
                boolean isColorDark = QQTheme.isColorDark(((Integer) f16.second).intValue());
                if (c16 > c.f276883h) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QUIImmersiveHelper.r(new Runnable(window, f16, arrayList2, z16, c16, isColorDark, nanoTime) { // from class: com.tencent.mobileqq.qui.immersive.StatusUpdateTask.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long C;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Window f276866d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Pair f276867e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ List f276868f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ boolean f276869h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ double f276870i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ boolean f276871m;

                    {
                        this.f276866d = window;
                        this.f276867e = f16;
                        this.f276868f = arrayList2;
                        this.f276869h = z16;
                        this.f276870i = c16;
                        this.f276871m = isColorDark;
                        this.C = nanoTime;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, StatusUpdateTask.this, window, f16, arrayList2, Boolean.valueOf(z16), Double.valueOf(c16), Boolean.valueOf(isColorDark), Long.valueOf(nanoTime));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        a l3 = QUIImmersiveHelper.l(this.f276866d);
                        l3.f276874a = new WeakReference<>(this.f276866d);
                        l3.f276877d = this.f276867e;
                        l3.f276875b = true;
                        l3.f276876c = this.f276868f;
                        ImmersiveUtils.setStatusTextColorNew(this.f276869h, this.f276866d, false);
                        c.m("QUIImmersiveHelper-StatusUpdateTask", "adjust StatusBarText color: " + Integer.toHexString(((Integer) this.f276867e.second).intValue()) + " luminance" + this.f276870i + " isStatusDarkColor:" + this.f276871m + " useDarkText:" + this.f276869h + " setStatusTextColorNew costTime: " + (System.nanoTime() - this.C));
                    }
                });
                return;
            }
            QUIImmersiveHelper.r(new Runnable(window, f16) { // from class: com.tencent.mobileqq.qui.immersive.StatusUpdateTask.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Window f276872d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Pair f276873e;

                {
                    this.f276872d = window;
                    this.f276873e = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, StatusUpdateTask.this, window, f16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    a l3 = QUIImmersiveHelper.l(this.f276872d);
                    l3.f276874a = new WeakReference<>(this.f276872d);
                    l3.f276877d = this.f276873e;
                    l3.f276875b = true;
                    l3.f276876c = new ArrayList();
                    c.m("QUIImmersiveHelper-StatusUpdateTask", "adjustStatusBarTextColor fail");
                }
            });
        } catch (Exception e16) {
            QLog.e("QUIImmersiveHelper-StatusUpdateTask", 1, e16, new Object[0]);
        }
    }
}
