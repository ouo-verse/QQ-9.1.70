package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GlobalLifecycleCallbacks {
    static IPatchRedirector $redirector_;
    private final ArrayList<BaseActivityLifecycleCallbacks> mActivityLifecycleCallbacks;

    public GlobalLifecycleCallbacks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mActivityLifecycleCallbacks = new ArrayList<>();
        }
    }

    private Object[] collectActivityLifecycleCallbacks() {
        Object[] objArr;
        synchronized (this.mActivityLifecycleCallbacks) {
            if (this.mActivityLifecycleCallbacks.size() > 0) {
                objArr = this.mActivityLifecycleCallbacks.toArray();
            } else {
                objArr = null;
            }
        }
        return objArr;
    }

    public void dispatchAccountChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onAccountChanged(activity);
            }
        }
    }

    public void dispatchActivityConfigurationChanged(Activity activity, Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity, (Object) configuration);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnConfigurationChanged(activity, configuration);
            }
        }
    }

    public void dispatchActivityDestroyed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityDestroyed(activity);
            }
        }
    }

    public void dispatchActivityOnCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityCreate(qBaseActivity, bundle);
            }
        }
    }

    public void dispatchActivityOnPause(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPause(activity);
            }
        }
    }

    public void dispatchActivityOnResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityResume(activity);
            }
        }
    }

    public void dispatchActivityOnStart(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityOnStart(activity);
            }
        }
    }

    public void dispatchActivityPostCreated(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPostCreated(activity, bundle);
            }
        }
    }

    public void dispatchActivityPostPaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPostPaused(activity);
            }
        }
    }

    public void dispatchActivityPostResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPostResumed(activity);
            }
        }
    }

    public void dispatchActivityPreCreated(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPreCreated(qBaseActivity, bundle);
            }
        }
    }

    public void dispatchActivityPrePaused(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPrePaused(activity);
            }
        }
    }

    public void dispatchActivityPreResumed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityPreResumed(activity);
            }
        }
    }

    public void dispatchActivityStopped(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnActivityStopped(activity);
            }
        }
    }

    public void dispatchActivityWindowFocusChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, activity, Boolean.valueOf(z16));
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnWindowFocusChanged(activity, z16);
            }
        }
    }

    public void dispatchNewInstant(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) activity, (Object) intent);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).doOnNewIntent(activity, intent);
            }
        }
    }

    public void dispatchOnMultiWindowModeChanged(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, activity, Boolean.valueOf(z16));
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onMultiWindowModeChanged(activity, z16);
            }
        }
    }

    public void dispatchPreHandlerStartActivityForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, activity, intent, Integer.valueOf(i3));
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onPreHandleStartActivityForResult(activity, intent, i3);
            }
        }
    }

    public void dispatchThemeChanged(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity);
            return;
        }
        Object[] collectActivityLifecycleCallbacks = collectActivityLifecycleCallbacks();
        if (collectActivityLifecycleCallbacks != null) {
            for (Object obj : collectActivityLifecycleCallbacks) {
                ((BaseActivityLifecycleCallbacks) obj).onPostThemeChanged(activity);
            }
        }
    }

    public void registerActivityLifecycleCallbacks(BaseActivityLifecycleCallbacks baseActivityLifecycleCallbacks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseActivityLifecycleCallbacks);
            return;
        }
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.add(baseActivityLifecycleCallbacks);
        }
    }

    public void unregisterActivityLifecycleCallbacks(BaseActivityLifecycleCallbacks baseActivityLifecycleCallbacks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseActivityLifecycleCallbacks);
            return;
        }
        synchronized (this.mActivityLifecycleCallbacks) {
            this.mActivityLifecycleCallbacks.remove(baseActivityLifecycleCallbacks);
        }
    }
}
