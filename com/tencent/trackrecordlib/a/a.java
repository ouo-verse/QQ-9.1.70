package com.tencent.trackrecordlib.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.trackrecordlib.c.c;
import com.tencent.trackrecordlib.core.a;
import com.tencent.trackrecordlib.core.c;
import com.tencent.trackrecordlib.g.h;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f380920a = "LifecycleCollector";

    /* renamed from: b, reason: collision with root package name */
    private static final String f380921b = "#";

    /* renamed from: c, reason: collision with root package name */
    private static final String f380922c = "_background_";

    /* renamed from: d, reason: collision with root package name */
    private static int f380923d;

    /* renamed from: e, reason: collision with root package name */
    private static int f380924e;

    /* renamed from: f, reason: collision with root package name */
    private static int f380925f;

    /* renamed from: g, reason: collision with root package name */
    private static int f380926g;

    /* renamed from: h, reason: collision with root package name */
    private static int f380927h;

    /* renamed from: i, reason: collision with root package name */
    private static String f380928i;

    /* renamed from: j, reason: collision with root package name */
    private static String f380929j;

    /* renamed from: k, reason: collision with root package name */
    private static String f380930k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f380931l;

    /* renamed from: m, reason: collision with root package name */
    private static String f380932m;

    /* renamed from: n, reason: collision with root package name */
    private static String f380933n;

    /* renamed from: o, reason: collision with root package name */
    private static String f380934o;

    /* renamed from: p, reason: collision with root package name */
    private static String f380935p;

    /* renamed from: q, reason: collision with root package name */
    private static String f380936q;

    /* renamed from: r, reason: collision with root package name */
    private static String f380937r;

    /* renamed from: s, reason: collision with root package name */
    private static String f380938s;

    /* renamed from: t, reason: collision with root package name */
    private static a.InterfaceC10017a f380939t;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.trackrecordlib.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C10016a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static a f380940a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9824);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f380940a = new a();
            }
        }

        C10016a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        f380929j = "";
        f380930k = "";
        f380931l = false;
        f380932m = f380922c;
        f380933n = f380922c;
        String a16 = h.a();
        f380934o = a16;
        f380935p = a16;
        f380936q = a16;
        f380937r = a16;
        f380938s = a16;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean g() {
        return f380927h < f380925f;
    }

    private static boolean h() {
        return f380925f > f380926g;
    }

    private static boolean i() {
        if (f380923d > f380924e) {
            return true;
        }
        return false;
    }

    private void j() {
        Log.d(f380920a, "isApplicationVisible: " + h() + ", isApplicationInForeground: " + i());
        Log.d(f380920a, String.format("[start, stop]: [%d, %d], [resumed, paused]: [%d, %d]", Integer.valueOf(f380925f), Integer.valueOf(f380926g), Integer.valueOf(f380923d), Integer.valueOf(f380924e)));
    }

    private void k() {
        c.a().a(new c.a().a(f380932m).b(f380932m + f380921b + f380929j).c(f380933n).d(f380933n + f380921b + f380930k).e(f380935p).f(f380936q).g(f380937r).a());
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? f380928i : (String) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? f380933n : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f380933n + f380921b + f380930k;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f380928i + f380921b + f380929j;
    }

    @Override // com.tencent.trackrecordlib.a.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            j();
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void f(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity);
            return;
        }
        f380925f++;
        Log.d(f380920a, "activity start: " + activity.getClass().getName());
    }

    private void h(Activity activity) {
        if (f380939t == null || !activity.getClass().getName().equals(f().a())) {
            return;
        }
        f380939t.a(activity.getWindow().getDecorView());
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            str = "";
        }
        f380930k = str;
    }

    public void b(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        if (g()) {
            Log.d(f380920a, "Listener & Resume plus");
            f380927h++;
            h(activity);
            if (f380924e > f380923d) {
                d(activity);
            }
        }
    }

    public void c(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            return;
        }
        Log.d(f380920a, "activity destroyed: " + activity.getClass().getName());
        com.tencent.trackrecordlib.d.a.b().a();
    }

    public void d(Activity activity) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            return;
        }
        f380923d++;
        Log.d(f380920a, "activity resumed: " + activity.getClass().getName());
        f380929j = f380930k;
        f380930k = "";
        f380932m = f380933n;
        f380935p = f380937r;
        f380933n = activity.getClass().getName();
        f380937r = h.a();
        if (!g() || (i3 = f380927h) >= 2) {
            return;
        }
        f380927h = i3 + 1;
        Log.d(f380920a, "activitychanged but not created,need add" + activity.getClass().getName());
        Log.d(f380920a, String.format("LAKE [start, stop]: [%d, %d], [resumed, paused]: [%d, %d]", Integer.valueOf(f380925f), Integer.valueOf(f380926g), Integer.valueOf(f380923d), Integer.valueOf(f380924e)));
        h(activity);
    }

    public void e(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
            return;
        }
        f380924e++;
        Log.d(f380920a, "activity paused: " + activity.getClass().getName());
        f380936q = f380938s;
        f380938s = h.a();
        k();
    }

    public void g(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity);
            return;
        }
        f380926g++;
        Log.d(f380920a, "activity stop: " + activity.getClass().getName());
        j();
        if (!h()) {
            Log.d(f380920a, "enter background");
            f380932m = f380933n;
            f380935p = f380937r;
            f380936q = f380938s;
            f380929j = f380930k;
            f380930k = "";
            f380933n = f380922c;
            f380937r = h.a();
            f380938s = h.a();
            k();
        }
        com.tencent.trackrecordlib.d.a.b().a();
    }

    public static a f() {
        return C10016a.f380940a;
    }

    public void a(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        if (activity == null || f380928i == activity.getClass().getName()) {
            return;
        }
        f380925f++;
        Log.d(f380920a, "fake activitycreated:" + activity.getClass().getName());
        Log.d(f380920a, String.format("Now start:[%d]", Integer.valueOf(f380925f)));
        f380928i = activity.getClass().getName();
    }

    public void b(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Log.d(f380920a, "activity save instance state: " + activity.getClass().getName());
    }

    private boolean b(Context context) {
        int i3;
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            i3 = activityManager.getRunningTasks(1).get(0).numActivities;
            return i3 > 1;
        }
        Log.e(f380920a, "get ActivityManager failed");
        return false;
    }

    public void a(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        f380927h++;
        Log.d(f380920a, "activity created: " + activity.getClass().getName());
        f380928i = activity.getClass().getName();
    }

    private String a(Context context) {
        ComponentName componentName;
        if (context == null) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            componentName = activityManager.getRunningTasks(1).get(0).topActivity;
            return componentName.getClassName();
        }
        Log.e(f380920a, "get ActivityManager failed");
        return "";
    }
}
