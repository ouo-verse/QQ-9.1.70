package com.tencent.mobileqq.faultreport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FaultTracker {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static volatile FaultTracker f205770m;

    /* renamed from: a, reason: collision with root package name */
    private final List<com.tencent.mobileqq.faultreport.TrackerFilter.a> f205771a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, com.tencent.mobileqq.faultreport.contextinfo.b> f205772b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, com.tencent.mobileqq.faultreport.contextinfo.a> f205773c;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f205774d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f205775e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.faultreport.contextinfo.a f205776f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.faultreport.contextinfo.b f205777g;

    /* renamed from: h, reason: collision with root package name */
    private final String f205778h;

    /* renamed from: i, reason: collision with root package name */
    private final LinkedHashMap<Long, com.tencent.mobileqq.faultreport.contextinfo.c> f205779i;

    /* renamed from: j, reason: collision with root package name */
    private String f205780j;

    /* renamed from: k, reason: collision with root package name */
    private final FragmentManager.FragmentLifecycleCallbacks f205781k;

    /* renamed from: l, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f205782l;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class FaultLifecycleObserver implements LifecycleObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FaultTracker f205783d;

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        void onAppBackground() {
            QLog.d("FaultTracker", 4, "onAppBackground");
            this.f205783d.r();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        void onAppForeground() {
            QLog.d("FaultTracker", 4, "onAppForeground");
            this.f205783d.s();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements ComponentCallbacks2 {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaultTracker.this);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NonNull Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                FaultTracker.this.w(null, "onLowMemory", "true");
            }
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            FaultTracker.this.w(null, "onTrimMemory", i3 + "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends FragmentManager.FragmentLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaultTracker.this);
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragmentManager, (Object) fragment);
            } else {
                super.onFragmentPaused(fragmentManager, fragment);
                FaultTracker.this.w(fragment.getContext(), MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "1");
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) fragmentManager, (Object) fragment);
            } else {
                super.onFragmentResumed(fragmentManager, fragment);
                FaultTracker.this.w(fragment.getContext(), MiniSDKConst.NOTIFY_EVENT_ONPAUSE, null);
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fragmentManager, (Object) fragment);
                return;
            }
            super.onFragmentStarted(fragmentManager, fragment);
            if (FaultTracker.this.f205772b.get(Integer.valueOf(fragment.hashCode())) != null) {
                FaultTracker faultTracker = FaultTracker.this;
                faultTracker.f205777g = (com.tencent.mobileqq.faultreport.contextinfo.b) faultTracker.f205772b.get(Integer.valueOf(fragment.hashCode()));
            } else {
                FaultTracker.this.f205777g = new com.tencent.mobileqq.faultreport.contextinfo.b(fragment);
            }
            FaultTracker.this.f205779i.put(Long.valueOf(System.currentTimeMillis()), FaultTracker.this.f205777g);
            FaultTracker faultTracker2 = FaultTracker.this;
            faultTracker2.f205780j = faultTracker2.f205779i.toString();
            FaultTracker.this.f205772b.put(Integer.valueOf(fragment.hashCode()), FaultTracker.this.f205777g);
            FaultTracker faultTracker3 = FaultTracker.this;
            faultTracker3.v(faultTracker3.f205777g, false);
            QLog.i("FaultTracker", 1, "[onFragmentStarted]  fragmentStack=" + FaultTracker.this.f205779i.size() + FaultTracker.this.f205780j);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) fragmentManager, (Object) fragment);
                return;
            }
            super.onFragmentStopped(fragmentManager, fragment);
            com.tencent.mobileqq.faultreport.contextinfo.b bVar = (com.tencent.mobileqq.faultreport.contextinfo.b) FaultTracker.this.f205772b.get(Integer.valueOf(fragment.hashCode()));
            FaultTracker.this.f205772b.remove(Integer.valueOf(fragment.hashCode()));
            FaultTracker.this.v(bVar, true);
            if (FaultTracker.this.f205777g != null && fragment.hashCode() == FaultTracker.this.f205777g.f205804b) {
                FaultTracker.this.f205777g = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaultTracker.this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            } else if (activity instanceof FragmentActivity) {
                ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(FaultTracker.this.f205781k, true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                try {
                    FaultTracker.this.q((ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                    if (activity instanceof FragmentActivity) {
                        ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(FaultTracker.this.f205781k);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e("FaultTracker", 1, e16, new Object[0]);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            } else {
                FaultTracker.this.w(activity, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "1");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            } else {
                FaultTracker.this.w(activity, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                return;
            }
            if (FaultTracker.this.f205773c.get(Integer.valueOf(activity.hashCode())) != null) {
                FaultTracker faultTracker = FaultTracker.this;
                faultTracker.f205776f = (com.tencent.mobileqq.faultreport.contextinfo.a) faultTracker.f205773c.get(Integer.valueOf(activity.hashCode()));
            } else {
                FaultTracker.this.f205776f = new com.tencent.mobileqq.faultreport.contextinfo.a(activity);
            }
            FaultTracker.this.f205779i.put(Long.valueOf(System.currentTimeMillis()), FaultTracker.this.f205776f);
            FaultTracker faultTracker2 = FaultTracker.this;
            faultTracker2.f205780j = faultTracker2.f205779i.toString();
            FaultTracker.this.f205773c.put(Integer.valueOf(activity.hashCode()), FaultTracker.this.f205776f);
            FaultTracker faultTracker3 = FaultTracker.this;
            faultTracker3.v(faultTracker3.f205776f, false);
            QLog.i("FaultTracker", 1, "[onActivityStarted]  activityStack=" + FaultTracker.this.f205779i.size() + FaultTracker.this.f205780j);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                return;
            }
            com.tencent.mobileqq.faultreport.contextinfo.a aVar = (com.tencent.mobileqq.faultreport.contextinfo.a) FaultTracker.this.f205773c.get(Integer.valueOf(activity.hashCode()));
            FaultTracker.this.f205773c.remove(Integer.valueOf(activity.hashCode()));
            FaultTracker.this.v(aVar, true);
            if (FaultTracker.this.f205776f != null && activity.hashCode() == FaultTracker.this.f205776f.f205804b) {
                FaultTracker.this.f205776f = null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42440);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f205770m = null;
        }
    }

    FaultTracker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205771a = new ArrayList();
        this.f205772b = new ConcurrentHashMap<>();
        this.f205773c = new ConcurrentHashMap<>();
        this.f205774d = new ConcurrentHashMap<>();
        this.f205778h = UUID.randomUUID().toString();
        this.f205779i = new LinkedHashMap<Long, com.tencent.mobileqq.faultreport.contextinfo.c>(10, 0.75f, z16) { // from class: com.tencent.mobileqq.faultreport.FaultTracker.1
            static IPatchRedirector $redirector_;

            {
                super(r6, r7, z16);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FaultTracker.this, Integer.valueOf(r6), Float.valueOf(r7), Boolean.valueOf(z16));
                }
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<Long, com.tencent.mobileqq.faultreport.contextinfo.c> entry) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) entry)).booleanValue();
                }
                if (size() > 10) {
                    return true;
                }
                return false;
            }
        };
        this.f205780j = "";
        this.f205781k = new b();
        this.f205782l = new c();
        QLog.i("FaultTracker", 1, "FaultTracker init");
        BaseApplication.getContext().registerActivityLifecycleCallbacks(this.f205782l);
        MobileQQ.sMobileQQ.getApplicationContext().registerComponentCallbacks(new a());
    }

    private String m(com.tencent.mobileqq.faultreport.contextinfo.c cVar) {
        String str = "";
        if (!this.f205771a.isEmpty()) {
            Iterator<com.tencent.mobileqq.faultreport.TrackerFilter.a> it = this.f205771a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.faultreport.TrackerFilter.a next = it.next();
                if (next != null) {
                    str = next.c(cVar);
                    if (!TextUtils.isEmpty(str)) {
                        cVar.f205803a = str;
                        break;
                    }
                }
            }
        }
        return str;
    }

    public static FaultTracker n() {
        if (f205770m == null) {
            synchronized (FaultTracker.class) {
                if (f205770m == null) {
                    f205770m = new FaultTracker();
                }
            }
        }
        return f205770m;
    }

    private com.tencent.mobileqq.faultreport.a o(com.tencent.mobileqq.faultreport.TrackerFilter.a aVar) {
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    private boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<Map.Entry<Integer, com.tencent.mobileqq.faultreport.contextinfo.b>> it = this.f205772b.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.faultreport.contextinfo.b value = it.next().getValue();
            if (value != null && str.equals(value.f205803a)) {
                return false;
            }
        }
        Iterator<Map.Entry<Integer, com.tencent.mobileqq.faultreport.contextinfo.a>> it5 = this.f205773c.entrySet().iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.faultreport.contextinfo.a value2 = it5.next().getValue();
            if (value2 != null && str.equals(value2.f205803a)) {
                return false;
            }
        }
        QLog.i("FaultTracker", 1, "isFlowEnd flowId=" + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(ActivityManager activityManager) throws Exception {
        Class<?> cls = Class.forName("android.app.ActivityManager");
        int i3 = cls.getDeclaredField("LOCK_TASK_MODE_NONE").getInt(ActivityManager.class);
        Object invoke = cls.getDeclaredMethod("getLockTaskModeState", new Class[0]).invoke(activityManager, new Object[0]);
        if (!(invoke instanceof Integer) || ((Integer) invoke).intValue() == i3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(com.tencent.mobileqq.faultreport.contextinfo.c cVar, boolean z16) {
        String str;
        com.tencent.mobileqq.faultreport.contextinfo.a aVar;
        com.tencent.mobileqq.faultreport.contextinfo.b bVar;
        boolean z17;
        if (this.f205771a.isEmpty()) {
            return;
        }
        com.tencent.mobileqq.faultreport.a aVar2 = new com.tencent.mobileqq.faultreport.a();
        aVar2.f205796c = this.f205778h;
        if (cVar == null && (cVar = this.f205776f) == null) {
            return;
        }
        if (TextUtils.isEmpty(cVar.f205803a)) {
            str = m(cVar);
        } else {
            str = cVar.f205803a;
        }
        if (!TextUtils.isEmpty(str)) {
            aVar2.f205794a = str;
        }
        aVar2.f205799f.putAll(this.f205774d);
        aVar2.f205799f.put("stack_info", this.f205780j);
        aVar2.f205800g = this.f205775e;
        if (cVar instanceof com.tencent.mobileqq.faultreport.contextinfo.a) {
            aVar = (com.tencent.mobileqq.faultreport.contextinfo.a) cVar;
        } else {
            aVar = this.f205776f;
        }
        if (aVar != null) {
            aVar2.f205797d = aVar;
            if (!aVar.f205805c.isEmpty()) {
                aVar2.f205799f.put("act_info", aVar.f205805c.toString());
            }
        }
        if (cVar instanceof com.tencent.mobileqq.faultreport.contextinfo.b) {
            bVar = (com.tencent.mobileqq.faultreport.contextinfo.b) cVar;
        } else {
            bVar = this.f205777g;
        }
        if (bVar != null) {
            aVar2.f205798e = bVar;
            if (!bVar.f205805c.isEmpty()) {
                aVar2.f205799f.put("frag_info", bVar.f205805c.toString());
            }
        }
        if (z16 && p(cVar.f205803a)) {
            z17 = true;
        } else {
            z17 = false;
        }
        for (com.tencent.mobileqq.faultreport.TrackerFilter.a aVar3 : this.f205771a) {
            if (aVar3 != null && aVar3.d(aVar2, z17)) {
                return;
            }
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f205775e = true;
        QLog.i("FaultTracker", 1, "onPeakAppRunningBackground");
        w(null, "is_back", this.f205775e + "");
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f205775e = false;
        QLog.i("FaultTracker", 1, "onPeakAppRunningForeground");
        w(null, "is_back", this.f205775e + "");
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.i("FaultTracker", 1, " [onBeforeExit] ");
        w(null, "is_proc_exit", System.currentTimeMillis() + "");
    }

    public void u(com.tencent.mobileqq.faultreport.TrackerFilter.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            QLog.e("FaultTracker", 1, "registerFaultTrackerFilter filter is null");
            return;
        }
        Iterator<com.tencent.mobileqq.faultreport.TrackerFilter.a> it = this.f205771a.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().getSimpleName().equals(aVar.getClass().getSimpleName())) {
                QLog.i("FaultTracker", 1, "registerFaultTrackerFilter filter is already exist");
                return;
            }
        }
        QLog.i("FaultTracker", 1, "registerFaultTrackerFilter = " + aVar.getClass().getSimpleName());
        this.f205771a.add(aVar);
        com.tencent.mobileqq.faultreport.a o16 = o(aVar);
        if (o16 != null && !o16.f205796c.equals(this.f205778h)) {
            aVar.b(o16);
        }
    }

    public void w(Context context, String str, String str2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2);
            return;
        }
        if (context != null) {
            i3 = context.hashCode();
        } else {
            i3 = -1;
        }
        if (this.f205773c.containsKey(Integer.valueOf(i3))) {
            com.tencent.mobileqq.faultreport.contextinfo.a aVar = this.f205773c.get(Integer.valueOf(i3));
            if (aVar != null) {
                if (str2 == null) {
                    aVar.f205805c.remove(str);
                } else {
                    aVar.f205805c.put(str, str2);
                }
                v(aVar, false);
                return;
            }
            return;
        }
        if (this.f205772b.containsKey(Integer.valueOf(i3))) {
            com.tencent.mobileqq.faultreport.contextinfo.b bVar = this.f205772b.get(Integer.valueOf(i3));
            if (bVar != null) {
                if (str2 == null) {
                    bVar.f205805c.remove(str);
                } else {
                    bVar.f205805c.put(str, str2);
                }
                v(bVar, false);
                return;
            }
            return;
        }
        if (str2 == null) {
            this.f205774d.remove(str);
        } else {
            this.f205774d.put(str, str2);
        }
        v(null, false);
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f205771a.clear();
        }
    }
}
