package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* compiled from: P */
/* loaded from: classes20.dex */
public class x implements com.tencent.mobileqq.webview.util.k {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    w f314835d;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        public static w a(QQBrowserActivity qQBrowserActivity) {
            int intExtra = qQBrowserActivity.getIntent().getIntExtra(QQWinkConstants.WEB_COLOR_NOTE_TYPE, 0);
            qQBrowserActivity.getIntent().removeExtra(QQWinkConstants.WEB_COLOR_NOTE_TYPE);
            if (intExtra == 1) {
                return new o(qQBrowserActivity);
            }
            if (intExtra == 2) {
                return new m(qQBrowserActivity);
            }
            if (intExtra == 3) {
                return new n(qQBrowserActivity);
            }
            if (intExtra == 4) {
                return new b(qQBrowserActivity);
            }
            return new w(qQBrowserActivity);
        }
    }

    public x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314835d = null;
        }
    }

    @Override // com.tencent.mobileqq.webview.util.k
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str)).booleanValue();
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            return wVar.p(str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.util.k
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            return wVar.n();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.util.k
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            return wVar.h();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.util.k
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) bundle);
        } else if (activity instanceof QQBrowserActivity) {
            w a16 = a.a((QQBrowserActivity) activity);
            this.f314835d = a16;
            a16.i(bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
            return;
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            wVar.j();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityOnStart(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            wVar.k();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostPaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPostResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPrePaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityPreResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            wVar.l();
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityStopped(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnConfigurationChanged(Activity activity, Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) activity, (Object) configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public boolean doOnDispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnNewIntent(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnWindowFocusChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, activity, Boolean.valueOf(z16));
        }
    }

    public void e(com.tencent.mobileqq.colornote.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) fVar);
            return;
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            wVar.m(fVar);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.k
    public boolean isColorNoteExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        w wVar = this.f314835d;
        if (wVar != null) {
            return wVar.g();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onAccountChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onMultiWindowModeChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, activity, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPostThemeChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreHandleStartActivityForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, activity, intent, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreSetContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            return;
        }
        iPatchRedirector.redirect((short) 24, (Object) this, i3);
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onRestoreInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) activity, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onSaveInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) activity, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreSetContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
    }
}
