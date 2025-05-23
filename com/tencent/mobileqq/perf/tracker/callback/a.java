package com.tencent.mobileqq.perf.tracker.callback;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.QActivityLifecycleCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/callback/a;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "Lmqq/app/QActivityLifecycleCallbacks;", "", "", "stage", "", "delay", "", "traceStart", "traceEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "onProcessBackground", "onProcessForeground", "Landroidx/fragment/app/Fragment;", "fragment", "onQFragmentResumed", "onQFragmentPaused", "onQFragmentDestroy", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class a extends FragmentManager.FragmentLifecycleCallbacks implements QActivityLifecycleCallbacks {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    public void onActivityPaused(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    public void onActivityResumed(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity, (Object) outState);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }
    }

    public void onActivityStarted(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    public void onActivityStopped(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    public void onProcessBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void onProcessForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public void onQFragmentDestroy(@NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fragment);
        } else {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }
    }

    public void onQFragmentPaused(@NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) fragment);
        } else {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }
    }

    public void onQFragmentResumed(@NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) fragment);
        } else {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }
    }

    public void traceEnd(@NotNull String stage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) stage);
        } else {
            Intrinsics.checkNotNullParameter(stage, "stage");
        }
    }

    public void traceStart(@NotNull String stage, boolean delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, stage, Boolean.valueOf(delay));
        } else {
            Intrinsics.checkNotNullParameter(stage, "stage");
        }
    }
}
