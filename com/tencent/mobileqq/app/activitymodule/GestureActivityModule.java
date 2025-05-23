package com.tencent.mobileqq.app.activitymodule;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.fling.FlingAllowProvider;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GestureActivityModule extends AbsActivityModule {
    static IPatchRedirector $redirector_;
    QBaseActivity activity;
    private FlingHandler flingHandler;
    IGesturePropertyProvider propertyProvider;

    public GestureActivityModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static FlingHandler getFlingHandler(QBaseActivity qBaseActivity) {
        GestureActivityModule gestureActivityModule = (GestureActivityModule) qBaseActivity.getModule(GestureActivityModule.class);
        if (gestureActivityModule == null) {
            return null;
        }
        return gestureActivityModule.getFlingHandler();
    }

    private void preHandleStartActivityForResult(Activity activity, Intent intent, int i3, int i16) {
        int hashCode;
        String snapPath;
        if (i16 != 1) {
            if (i16 == 2) {
                int hashCode2 = activity.hashCode();
                intent.putExtra(FlingConstant.FLING_ACTION_KEY, 2);
                intent.putExtra(FlingConstant.FLING_CODE_KEY, hashCode2);
                return;
            }
            return;
        }
        if (this.propertyProvider.getAppRuntime() != null && FlingAllowProvider.contain(this.propertyProvider.getCurrentAccountUinFromRuntime()) && (snapPath = ScreenCapture.getSnapPath(activity, (hashCode = activity.hashCode()))) != null) {
            ScreenCapture.captureViewToFile(snapPath, activity.getWindow().getDecorView());
            intent.putExtra(FlingConstant.FLING_ACTION_KEY, 1);
            intent.putExtra(FlingConstant.FLING_CODE_KEY, hashCode);
        }
    }

    public static void setFlingHandler(QBaseActivity qBaseActivity, FlingHandler flingHandler) {
        GestureActivityModule gestureActivityModule = (GestureActivityModule) qBaseActivity.getModule(GestureActivityModule.class);
        if (gestureActivityModule != null) {
            gestureActivityModule.setFlingHandler(flingHandler);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(Activity activity, Bundle bundle) {
        Bundle extras;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        if (this.propertyProvider.needWrapContent() && (extras = this.propertyProvider.getIntent().getExtras()) != null) {
            try {
                i3 = extras.getInt(FlingConstant.FLING_ACTION_KEY);
            } catch (Exception unused) {
                i3 = 0;
            }
            if (i3 != 0) {
                if (1 == i3 && this.propertyProvider.getAppRuntime() != null && FlingAllowProvider.contain(this.propertyProvider.getCurrentAccountUinFromRuntime())) {
                    this.flingHandler = new FlingTrackerHandler(activity);
                } else {
                    this.flingHandler = new FlingGestureHandler(activity);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityOnStart(Activity activity) {
        FlingHandler flingHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else if (this.propertyProvider.needWrapContent() && (flingHandler = this.flingHandler) != null) {
            flingHandler.onStart();
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnConfigurationChanged(Activity activity, Configuration configuration) {
        FlingHandler flingHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) configuration);
        } else if (this.propertyProvider.needWrapContent() && (flingHandler = this.flingHandler) != null) {
            flingHandler.onConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public boolean doOnDispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return false;
    }

    protected int getFlingAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.activitymodule.IActivityModule
    public void init(IActivityPropertyProvider iActivityPropertyProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iActivityPropertyProvider);
        } else {
            this.activity = (QBaseActivity) iActivityPropertyProvider.getActivity();
            this.propertyProvider = (IGesturePropertyProvider) iActivityPropertyProvider;
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.AbsActivityModule, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onPreHandleStartActivityForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, activity, intent, Integer.valueOf(i3));
        } else {
            preHandleStartActivityForResult(activity, intent, i3, getFlingAction());
        }
    }

    public FlingHandler getFlingHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.flingHandler : (FlingHandler) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public void setFlingHandler(FlingHandler flingHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.flingHandler = flingHandler;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) flingHandler);
        }
    }
}
