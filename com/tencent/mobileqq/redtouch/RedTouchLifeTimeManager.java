package com.tencent.mobileqq.redtouch;

import android.app.Activity;
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
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RedTouchLifeTimeManager implements IProcessStateChangeCallback {
    static IPatchRedirector $redirector_;
    private static RedTouchLifeTimeManager D;
    QActivityLifecycleCallbacks C;

    /* renamed from: d, reason: collision with root package name */
    private String f280246d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f280247e;

    /* renamed from: f, reason: collision with root package name */
    private String f280248f;

    /* renamed from: h, reason: collision with root package name */
    private long f280249h;

    /* renamed from: i, reason: collision with root package name */
    private String f280250i;

    /* renamed from: m, reason: collision with root package name */
    private String f280251m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements QActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchLifeTimeManager.this);
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
            if (activity.getComponentName() != null) {
                RedTouchLifeTimeManager.this.f280246d = activity.getComponentName().getClassName();
                QLog.d("RedTouchLifeTimeManager", 1, "[onActivityResumed]   | mCurrentClassName = " + RedTouchLifeTimeManager.this.f280246d + " | mRecordClassName = " + RedTouchLifeTimeManager.this.f280248f);
                if (!TextUtils.isEmpty(RedTouchLifeTimeManager.this.f280246d) && RedTouchLifeTimeManager.this.f280246d.equals(RedTouchLifeTimeManager.this.f280248f)) {
                    RedTouchLifeTimeManager.this.h();
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74520);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            D = null;
        }
    }

    RedTouchLifeTimeManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f280247e = false;
        this.C = new a();
        g();
    }

    public static RedTouchLifeTimeManager e() {
        if (D == null) {
            synchronized (RedTouchLifeTimeManager.class) {
                if (D == null) {
                    D = new RedTouchLifeTimeManager();
                }
            }
        }
        return D;
    }

    private void g() {
        Foreground.addActivityLifeCallback(this.C);
        RFWLifecycleHelper.getInstance().registerProcessChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f280247e) {
            return;
        }
        this.f280247e = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f280249h;
        QLog.i("RedTouchLifeTimeManager", 1, "triggleReport time = " + currentTimeMillis + " class name " + this.f280246d);
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mActionId = 133;
        tianShuReportData.mActionValue = (int) currentTimeMillis;
        tianShuReportData.mItemId = String.valueOf(this.f280250i);
        tianShuReportData.mTraceId = String.valueOf(this.f280251m);
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mOperTime = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = "vab_red";
        tianShuReportData.mPageId = "vab_red";
        ThreadManager.getSubThreadHandler().post(new Runnable(tianShuReportData) { // from class: com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TianShuReportData f280252d;

            {
                this.f280252d = tianShuReportData;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RedTouchLifeTimeManager.this, (Object) tianShuReportData);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    TianShuManager.getInstance().report(this.f280252d);
                }
            }
        });
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.d("RedTouchLifeTimeManager", 1, "[onDestroy]  ");
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f280250i = jSONObject.getString("ad_id");
            this.f280251m = jSONObject.getString("trace_id");
            this.f280247e = true;
            this.f280249h = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.f280246d) && Foreground.getTopActivity() != null) {
                this.f280246d = Foreground.getTopActivity().getClass().getName();
            }
            this.f280248f = this.f280246d;
            QLog.i("RedTouchLifeTimeManager", 1, " triggleWhenRedClick class name " + this.f280246d);
        } catch (Exception e16) {
            QLog.e("RedTouchLifeTimeManager", 1, "triggleWhenRedClick" + e16);
        }
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.d("RedTouchLifeTimeManager", 1, "[onProcessBackground]   | mRecordClassName = " + this.f280248f);
        h();
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public /* synthetic */ void onProcessForeground() {
        com.tencent.richframework.lifecycle.a.b(this);
    }
}
