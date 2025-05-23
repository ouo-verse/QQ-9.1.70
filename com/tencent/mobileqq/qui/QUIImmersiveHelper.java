package com.tencent.mobileqq.qui;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.immersive.NavigatorUpdateTask;
import com.tencent.mobileqq.qui.immersive.StatusUpdateTask;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;
import com.tencent.mobileqq.qui.immersive.color.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QUIImmersiveHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final List<Class<? extends Activity>> f276837a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, StatusUpdateTask> f276838b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Integer, NavigatorUpdateTask> f276839c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<Integer, com.tencent.mobileqq.qui.immersive.a> f276840d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set<Integer> f276841e;

    /* renamed from: f, reason: collision with root package name */
    public static final Handler f276842f;

    /* renamed from: g, reason: collision with root package name */
    public static WeakReference<Window> f276843g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f276844h;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private static class AttachWindowRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Activity> f276845d;

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            WeakReference<Activity> weakReference = this.f276845d;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (activity != null) {
                QUIImmersiveHelper.u(activity.getWindow(), true, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class InnerOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener, Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Window> f276846d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<View> f276847e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f276848f;

        /* renamed from: h, reason: collision with root package name */
        private final WeakReference<View> f276849h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f276850i;

        /* renamed from: m, reason: collision with root package name */
        private final WeakReference<View> f276851m;

        InnerOnPreDrawListener(Window window, View view, boolean z16, View view2, boolean z17, View view3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, window, view, Boolean.valueOf(z16), view2, Boolean.valueOf(z17), view3);
                return;
            }
            this.f276846d = new WeakReference<>(window);
            this.f276847e = new WeakReference<>(view);
            this.f276848f = z16;
            this.f276850i = z17;
            this.f276849h = new WeakReference<>(view2);
            this.f276851m = new WeakReference<>(view3);
        }

        private void a(Window window) {
            if (this.f276850i) {
                QUIImmersiveHelper.g(window, this.f276851m);
            }
            if (this.f276848f) {
                QUIImmersiveHelper.h(window, this.f276849h);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            Window window = this.f276846d.get();
            if (window == null) {
                return true;
            }
            View view = this.f276847e.get();
            if (view != null && view.getViewTreeObserver() != null && view.getViewTreeObserver().isAlive()) {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            a(window);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Window window = this.f276846d.get();
            if (window == null) {
                return;
            }
            a(window);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class ThemeBroadcastReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        public ThemeBroadcastReceiver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Window window;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            for (com.tencent.mobileqq.qui.immersive.a aVar : QUIImmersiveHelper.f276840d.values()) {
                WeakReference<Window> weakReference = aVar.f276874a;
                if (weakReference != null && (window = weakReference.get()) != null) {
                    QUIImmersiveHelper.u(window, aVar.f276875b, aVar.f276878e);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qui.QUIImmersiveHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        class C8445a implements FragmentManager.OnBackStackChangedListener {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f276852a;

            C8445a(Activity activity) {
                this.f276852a = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) activity);
                }
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public void onBackStackChanged() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QUIImmersiveHelper.s(this.f276852a, true, true);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            } else if (!QUIImmersiveHelper.o(activity) && (activity instanceof FragmentActivity)) {
                FragmentActivity fragmentActivity = (FragmentActivity) activity;
                fragmentActivity.getSupportFragmentManager().addOnBackStackChangedListener(new C8445a(activity));
                fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new c(), true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                QUIImmersiveHelper.k(activity.getWindow());
            } else {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            Activity activity2;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                return;
            }
            if (QUIImmersiveHelper.o(activity)) {
                return;
            }
            if (activity.getParent() != null) {
                activity2 = activity.getParent();
            } else {
                activity2 = activity;
            }
            QLog.i("QUIImmersiveHelper", 1, "onActivityResumed activity:" + activity.getClass().getSimpleName());
            if (QUIImmersiveHelper.f276843g.get() != null) {
                com.tencent.mobileqq.qui.immersive.a l3 = QUIImmersiveHelper.l(QUIImmersiveHelper.f276843g.get());
                if (l3.f276875b && ((Boolean) l3.f276877d.first).booleanValue()) {
                    if (com.tencent.mobileqq.qui.immersive.c.c(((Integer) l3.f276877d.second).intValue()) > 0.800000011920929d) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    ImmersiveUtils.setStatusTextColorNew(z16, activity2.getWindow(), false);
                }
            }
            QUIImmersiveHelper.f276843g = new WeakReference<>(activity2.getWindow());
            QUIImmersiveHelper.s(activity2, true, true);
            QUIImmersiveHelper.d(activity2.getWindow());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b implements ViewTreeObserver.OnDrawListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Window> f276854d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<View> f276855e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f276856f;

        /* renamed from: h, reason: collision with root package name */
        private int f276857h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f276858i;

        b(Window window) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) window);
                return;
            }
            this.f276858i = com.tencent.mobileqq.immersive.a.e();
            this.f276854d = new WeakReference<>(window);
            this.f276855e = new WeakReference<>(b());
        }

        private void a(View view) {
            if (view != null && view.isLayoutRequested() && view.getParent() != null && !view.getParent().isLayoutRequested()) {
                int i3 = this.f276857h + 1;
                this.f276857h = i3;
                if (i3 <= 3) {
                    QLog.e("QUIImmersiveHelper", 1, "find requestLayout chain error, fix use requestLayout");
                    view.requestLayout();
                }
            }
        }

        private View b() {
            View peekDecorView;
            Window window = this.f276854d.get();
            if (window == null || (peekDecorView = window.peekDecorView()) == null) {
                return null;
            }
            return peekDecorView.findViewById(R.id.content);
        }

        public View c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (this.f276856f) {
                return null;
            }
            View view = this.f276855e.get();
            if (view == null || view.getParent() == null) {
                view = b();
                this.f276855e = new WeakReference<>(view);
                if (view == null) {
                    this.f276856f = true;
                }
            }
            return view;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Window window = this.f276854d.get();
            if (window == null || window.peekDecorView() == null) {
                return;
            }
            if (this.f276858i) {
                a(c());
            }
            com.tencent.mobileqq.qui.immersive.a l3 = QUIImmersiveHelper.l(window);
            if (l3.f276875b && QUIImmersiveHelper.j(l3.f276876c)) {
                QUIImmersiveHelper.u(window, true, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class c extends FragmentManager.FragmentLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fragmentManager, (Object) fragment);
                return;
            }
            super.onFragmentResumed(fragmentManager, fragment);
            View view = fragment.getView();
            FragmentActivity activity = fragment.getActivity();
            if (view != null && activity != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onFragmentResumed fragment:");
                sb5.append(fragment.getClass().getSimpleName());
                sb5.append(" view now is not draw?:");
                if (view.getWidth() != 0 && view.getHeight() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.i("QUIImmersiveHelper", 1, sb5.toString());
                InnerOnPreDrawListener innerOnPreDrawListener = new InnerOnPreDrawListener(activity.getWindow(), view, true, null, true, null);
                if ((view.getWidth() == 0 || view.getHeight() == 0) && com.tencent.mobileqq.immersive.a.h().booleanValue()) {
                    QUIImmersiveHelper.e(view, innerOnPreDrawListener);
                } else {
                    innerOnPreDrawListener.run();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50573);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f276837a = new ArrayList();
        f276838b = new ConcurrentHashMap();
        f276839c = new ConcurrentHashMap();
        f276840d = new ConcurrentHashMap();
        f276841e = new HashSet();
        f276842f = new Handler(Looper.getMainLooper());
        f276843g = new WeakReference<>(null);
        f276844h = false;
    }

    public static void d(Window window) {
        View peekDecorView = window.peekDecorView();
        if (peekDecorView == null) {
            return;
        }
        Set<Integer> set = f276841e;
        if (!set.contains(Integer.valueOf(peekDecorView.hashCode()))) {
            set.add(Integer.valueOf(peekDecorView.hashCode()));
            peekDecorView.getViewTreeObserver().addOnDrawListener(new b(window));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(View view, InnerOnPreDrawListener innerOnPreDrawListener) {
        if (view != null && view.getViewTreeObserver() != null && view.getViewTreeObserver().isAlive()) {
            view.getViewTreeObserver().addOnPreDrawListener(innerOnPreDrawListener);
        }
    }

    public static void f(List<Class<? extends Activity>> list) {
        f276837a.addAll(list);
    }

    public static void g(Window window, WeakReference<View> weakReference) {
        if (!com.tencent.mobileqq.immersive.a.l()) {
            return;
        }
        boolean j3 = com.tencent.mobileqq.qui.b.f276860a.j(window);
        if (!n(window) && !j3) {
            QLog.e("QUIImmersiveHelper", 1, "adjustNavigatorBarColor but navigatorBar is not exist");
        } else {
            new NavigatorUpdateTask(window, weakReference).run();
        }
    }

    public static void h(Window window, WeakReference<View> weakReference) {
        if (!p(window)) {
            return;
        }
        Map<Integer, StatusUpdateTask> map = f276838b;
        StatusUpdateTask statusUpdateTask = map.get(Integer.valueOf(window.hashCode()));
        if (statusUpdateTask != null) {
            window.getDecorView().removeCallbacks(statusUpdateTask);
            statusUpdateTask.f276886f = true;
        }
        StatusUpdateTask statusUpdateTask2 = new StatusUpdateTask(window, weakReference);
        statusUpdateTask2.run();
        map.put(Integer.valueOf(window.hashCode()), statusUpdateTask2);
    }

    public static boolean i() {
        if (com.tencent.mobileqq.immersive.a.a() && MobileQQ.sProcessId != 7) {
            return true;
        }
        return false;
    }

    public static boolean j(List<WeakReference<View>> list) {
        IColorFetcher b16;
        Iterator<WeakReference<View>> it = list.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view == null || view.getVisibility() != 0 || view.getAlpha() == 0.0f || view.getParent() == null || (b16 = f.b(view)) == null || !b16.canHandle(view)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(Window window) {
        if (window == null) {
            return;
        }
        int hashCode = window.hashCode();
        f276838b.remove(Integer.valueOf(hashCode));
        f276839c.remove(Integer.valueOf(hashCode));
        f276840d.remove(Integer.valueOf(hashCode));
    }

    @NonNull
    @UiThread
    public static com.tencent.mobileqq.qui.immersive.a l(Window window) {
        Map<Integer, com.tencent.mobileqq.qui.immersive.a> map = f276840d;
        com.tencent.mobileqq.qui.immersive.a aVar = map.get(Integer.valueOf(window.hashCode()));
        if (aVar == null) {
            com.tencent.mobileqq.qui.immersive.a aVar2 = new com.tencent.mobileqq.qui.immersive.a();
            map.put(Integer.valueOf(window.hashCode()), aVar2);
            return aVar2;
        }
        return aVar;
    }

    public static void m(Application application) {
        if (!i()) {
            return;
        }
        com.tencent.mobileqq.qui.a.c();
        f276844h = OSUtils.isMIUI();
        application.registerReceiver(new ThemeBroadcastReceiver(), new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
        application.registerActivityLifecycleCallbacks(new a());
    }

    public static boolean n(Window window) {
        int id5;
        boolean z16;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (viewGroup == null) {
            QLog.e("QUIImmersiveHelper", 1, "isNavigationBarExist false decorView is not attach");
            return false;
        }
        if (q(window.getContext())) {
            return true;
        }
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            try {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0 && (id5 = childAt.getId()) != -1) {
                    if (id5 != 16908336 && !"navigationBarBackground".equals(viewGroup.getResources().getResourceEntryName(id5))) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        return true;
                    }
                }
            } catch (Exception e16) {
                QLog.e("QUIImmersiveHelper", 1, "isNavigationBarExist error" + e16);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Activity activity) {
        String name = activity.getClass().getName();
        Iterator<Class<? extends Activity>> it = f276837a.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(activity)) {
                return true;
            }
        }
        return name.equals("com.tencent.biz.qqcircle.activity.QCircleFolderActivity");
    }

    public static boolean p(Window window) {
        if ((window.getDecorView().getSystemUiVisibility() & 4) == 0) {
            return true;
        }
        return false;
    }

    public static boolean q(Context context) {
        if (!f276844h || context == null || Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
            return false;
        }
        return true;
    }

    public static void r(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f276842f.post(runnable);
        }
    }

    public static void s(Activity activity, boolean z16, boolean z17) {
        if (activity == null) {
            QLog.e("QUIImmersiveHelper", 1, " updateColor activity is empty");
        } else {
            u(activity.getWindow(), z16, z17);
        }
    }

    public static void t(Window window, boolean z16, View view, boolean z17, View view2) {
        if (window == null) {
            QLog.e("QUIImmersiveHelper", 1, " updateColor windows is empty");
            return;
        }
        View peekDecorView = window.peekDecorView();
        if (peekDecorView == null) {
            QLog.e("QUIImmersiveHelper", 1, " updateColor but decorView is empty");
            return;
        }
        InnerOnPreDrawListener innerOnPreDrawListener = new InnerOnPreDrawListener(window, peekDecorView, z16, view, z17, view2);
        if (peekDecorView.getWidth() != 0 && peekDecorView.getHeight() != 0) {
            innerOnPreDrawListener.run();
        } else {
            e(peekDecorView, innerOnPreDrawListener);
        }
    }

    public static void u(Window window, boolean z16, boolean z17) {
        t(window, z16, null, z17, null);
    }
}
