package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.res.Configuration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class FlingHandler {
    static IPatchRedirector $redirector_;
    WeakReference<Activity> mWrappedActivity;

    public FlingHandler(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.mWrappedActivity = new WeakReference<>(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (getFlingCode() != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFlingCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        Activity activity = this.mWrappedActivity.get();
        if (activity == null) {
            return 0;
        }
        return activity.getIntent().getIntExtra(FlingConstant.FLING_CODE_KEY, 0);
    }

    protected abstract boolean isWrapped();

    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
        }
    }

    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            wrap();
        }
    }

    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            unwrap();
        }
    }

    protected abstract void unwrap();

    protected abstract void wrap();
}
