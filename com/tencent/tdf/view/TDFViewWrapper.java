package com.tencent.tdf.view;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.TDFEngine;
import com.tencent.tdf.TDFHostDelegate;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFViewWrapper extends FrameLayout implements TDFHostDelegate.HostCallback {
    static IPatchRedirector $redirector_;
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
    private Activity attachActivity;
    private TDFHostDelegate hostDelegate;
    private View tdfView;

    public TDFViewWrapper(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.attachActivity = activity;
        this.hostDelegate = new TDFHostDelegate(this);
        this.activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks(activity) { // from class: com.tencent.tdf.view.TDFViewWrapper.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity val$attachActivity;

            {
                this.val$attachActivity = activity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TDFViewWrapper.this, (Object) activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity2, @Nullable Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) activity2, (Object) bundle);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    iPatchRedirector2.redirect((short) 8, (Object) this, (Object) activity2);
                } else if (this.val$attachActivity == activity2) {
                    TDFViewWrapper.this.hostDelegate.onDestroyed();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull Activity activity2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) activity2);
                } else if (this.val$attachActivity == activity2) {
                    TDFViewWrapper.this.hostDelegate.onPause();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull Activity activity2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) activity2);
                } else if (this.val$attachActivity == activity2) {
                    TDFViewWrapper.this.hostDelegate.onResume();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull Activity activity2, @NonNull Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, (Object) this, (Object) activity2, (Object) bundle);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull Activity activity2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) activity2);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, (Object) activity2);
                } else if (this.val$attachActivity == activity2) {
                    TDFViewWrapper.this.hostDelegate.onStop();
                }
            }
        };
    }

    @Override // com.tencent.tdf.TDFHostDelegate.HostCallback
    public TDFEngine createEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TDFEngine) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.tdf.TDFHostDelegate.HostCallback
    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.attachActivity;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hostDelegate.onCreate(this.attachActivity, null);
        View contentView = this.hostDelegate.getContentView();
        this.tdfView = contentView;
        addView(contentView, layoutParams);
        this.attachActivity.getApplication().registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        removeView(this.tdfView);
        this.tdfView = null;
        this.attachActivity.getApplication().unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }
}
