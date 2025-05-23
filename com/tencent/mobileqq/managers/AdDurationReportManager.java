package com.tencent.mobileqq.managers;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import cooperation.vip.tianshu.TianShuManager;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AdDurationReportManager {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static volatile AdDurationReportManager f243596f;

    /* renamed from: a, reason: collision with root package name */
    private final String f243597a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, c> f243598b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f243599c;

    /* renamed from: d, reason: collision with root package name */
    QActivityLifecycleCallbacks f243600d;

    /* renamed from: e, reason: collision with root package name */
    IProcessStateChangeCallback f243601e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements QActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdDurationReportManager.this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
                return;
            }
            ComponentName componentName = activity.getComponentName();
            if (componentName != null) {
                String className = componentName.getClassName();
                if (AdDurationReportManager.this.e(className)) {
                    AdDurationReportManager.this.i(className);
                    AdDurationReportManager.this.h(className);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements IProcessStateChangeCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdDurationReportManager.this);
            }
        }

        @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
        public void onProcessBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("AdDurationReportManager", 1, "onProcessBackground");
            if (AdDurationReportManager.this.f243598b != null && AdDurationReportManager.this.f243598b.size() != 0) {
                Iterator it = AdDurationReportManager.this.f243598b.keySet().iterator();
                while (it.hasNext()) {
                    AdDurationReportManager.this.i((String) it.next());
                }
            }
        }

        @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d("AdDurationReportManager", 1, "onProcessForeground");
            if (AdDurationReportManager.this.f243598b != null && AdDurationReportManager.this.f243598b.size() != 0) {
                Iterator it = AdDurationReportManager.this.f243598b.values().iterator();
                while (it.hasNext()) {
                    ((c) it.next()).f243610f = System.currentTimeMillis();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f243605a;

        /* renamed from: b, reason: collision with root package name */
        public String f243606b;

        /* renamed from: c, reason: collision with root package name */
        public String f243607c;

        /* renamed from: d, reason: collision with root package name */
        public String f243608d;

        /* renamed from: e, reason: collision with root package name */
        public int f243609e;

        /* renamed from: f, reason: collision with root package name */
        public long f243610f;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private String f243611a;

            /* renamed from: b, reason: collision with root package name */
            private String f243612b;

            /* renamed from: c, reason: collision with root package name */
            private String f243613c;

            /* renamed from: d, reason: collision with root package name */
            private String f243614d;

            /* renamed from: e, reason: collision with root package name */
            private int f243615e;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public c a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (c) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                return new c(this.f243611a, this.f243612b, this.f243613c, this.f243614d, this.f243615e);
            }

            public a b(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (a) iPatchRedirector.redirect((short) 6, (Object) this, i3);
                }
                this.f243615e = i3;
                return this;
            }

            public a c(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                }
                this.f243611a = str;
                return this;
            }

            public a d(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
                this.f243612b = str;
                return this;
            }

            public a e(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                }
                this.f243613c = str;
                return this;
            }

            public a f(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                }
                this.f243614d = str;
                return this;
            }
        }

        public c(String str, String str2, String str3, String str4, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, Integer.valueOf(i3));
                return;
            }
            this.f243605a = str;
            this.f243606b = str2;
            this.f243607c = str3;
            this.f243608d = str4;
            this.f243609e = i3;
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return !TextUtils.isEmpty(this.f243605a);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "mAppId=" + this.f243605a + ",mItemId=" + this.f243606b + ",mTraceId=" + this.f243607c + ",mTriggerInfo=" + this.f243608d + ",mActionAttr=" + this.f243609e;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f243596f = null;
        }
    }

    AdDurationReportManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243597a = "AdDurationReportManager";
        this.f243599c = false;
        this.f243600d = new a();
        this.f243601e = new b();
        this.f243598b = new HashMap<>();
    }

    public static AdDurationReportManager d() {
        if (f243596f == null) {
            synchronized (AdDurationReportManager.class) {
                if (f243596f == null) {
                    f243596f = new AdDurationReportManager();
                }
            }
        }
        return f243596f;
    }

    private void f() {
        if (!this.f243599c) {
            Foreground.addActivityLifeCallback(this.f243600d);
            RFWLifecycleHelper.getInstance().registerProcessChangeListener(this.f243601e);
            this.f243599c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(String str) {
        this.f243598b.remove(str);
        QLog.i("AdDurationReportManager", 1, "stop tracking, activity=" + str + ", size=" + this.f243598b.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        c cVar = this.f243598b.get(str);
        if (cVar == null) {
            QLog.i("AdDurationReportManager", 1, "triggerReport info == null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - cVar.f243610f;
        TianShuReportData tianShuReportData = new TianShuReportData();
        String str2 = cVar.f243605a;
        tianShuReportData.mAppId = str2;
        tianShuReportData.mPageId = str2;
        tianShuReportData.mItemId = cVar.f243606b;
        tianShuReportData.mTraceId = cVar.f243607c;
        tianShuReportData.mActionAttr = cVar.f243609e;
        tianShuReportData.mTriggerInfo = cVar.f243608d;
        tianShuReportData.mActionId = 133;
        tianShuReportData.mActionValue = (int) currentTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mOperTime = NetConnInfoCenter.getServerTimeMillis() / 1000;
        ThreadManager.getSubThreadHandler().post(new Runnable(tianShuReportData) { // from class: com.tencent.mobileqq.managers.AdDurationReportManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TianShuReportData f243602d;

            {
                this.f243602d = tianShuReportData;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdDurationReportManager.this, (Object) tianShuReportData);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    TianShuManager.getInstance().report(this.f243602d);
                }
            }
        });
        QLog.i("AdDurationReportManager", 1, "triggerReport time = " + currentTimeMillis + ", class name " + str);
    }

    public boolean e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        return this.f243598b.containsKey(str);
    }

    public synchronized boolean g(c cVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar)).booleanValue();
        }
        if (cVar != null && cVar.a()) {
            cVar.f243610f = System.currentTimeMillis();
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                str = topActivity.getClass().getName();
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                QLog.e("AdDurationReportManager", 1, "this activity is null ");
                return false;
            }
            if (!TextUtils.isEmpty(str) && this.f243598b.containsKey(str)) {
                QLog.w("AdDurationReportManager", 1, "this activity is tracking, will be covered " + str);
            }
            this.f243598b.put(str, cVar);
            QLog.i("AdDurationReportManager", 1, "start tracking, activity=" + str + ", time=" + System.currentTimeMillis());
            f();
            return true;
        }
        QLog.w("AdDurationReportManager", 1, "invalid info, " + cVar);
        return false;
    }
}
