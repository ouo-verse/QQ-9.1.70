package com.tencent.mobileqq.troopshare;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troopshare/g;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f303348a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u001f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u001c\u0010\"\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J$\u0010%\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020#H\u0016J\u001c\u0010*\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010,\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010.\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006/"}, d2 = {"com/tencent/mobileqq/troopshare/g$a", "Lcom/tencent/mobileqq/app/lifecycle/BaseActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnActivityPreCreated", "doOnActivityCreate", "savedInstance", "doOnActivityPostCreated", "doOnActivityPreResumed", "doOnActivityResume", "doOnActivityPostResumed", "doOnActivityOnStart", "doOnActivityPrePaused", "doOnActivityPause", "doOnActivityPostPaused", "doOnActivityStopped", "", HippyTextInputController.COMMAND_IS_FOCUSED, "doOnWindowFocusChanged", "Landroid/view/KeyEvent;", "event", "doOnDispatchKeyEvent", "Landroid/content/Intent;", "intent", "doOnNewIntent", "onPostThemeChanged", "onAccountChanged", "isInMultiWindowMode", "onMultiWindowModeChanged", "Landroid/content/res/Configuration;", "newConfig", "doOnConfigurationChanged", "", "requestCode", "onPreHandleStartActivityForResult", "Landroid/view/View;", "view", "onPreSetContentView", "layoutId", "onRestoreInstanceState", "outState", "onSaveInstanceState", EventKey.ACT, "doOnActivityDestroyed", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements BaseActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f303349d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f303350e;

        a(Function0<Unit> function0, QBaseActivity qBaseActivity) {
            this.f303349d = function0;
            this.f303350e = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0, (Object) qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityDestroyed(@Nullable Activity act) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, (Object) act);
            } else {
                this.f303349d.invoke();
                this.f303350e.unregisterActivityLifecycleCallbacks(this);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityOnStart(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPause(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPostCreated(@Nullable Activity activity, @Nullable Bundle savedInstance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstance);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPostPaused(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPostResumed(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPreCreated(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPrePaused(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityPreResumed(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityResume(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityStopped(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnConfigurationChanged(@Nullable Activity activity, @Nullable Configuration newConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity, (Object) newConfig);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public boolean doOnDispatchKeyEvent(@Nullable KeyEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) event)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnNewIntent(@Nullable Activity activity, @Nullable Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity, (Object) intent);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnWindowFocusChanged(@Nullable Activity activity, boolean isFocused) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, activity, Boolean.valueOf(isFocused));
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onAccountChanged(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onMultiWindowModeChanged(@Nullable Activity activity, boolean isInMultiWindowMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, this, activity, Boolean.valueOf(isInMultiWindowMode));
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onPostThemeChanged(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onPreHandleStartActivityForResult(@Nullable Activity activity, @Nullable Intent intent, int requestCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, this, activity, intent, Integer.valueOf(requestCode));
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onPreSetContentView(int layoutId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                return;
            }
            iPatchRedirector.redirect((short) 22, (Object) this, layoutId);
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onRestoreInstanceState(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) activity, (Object) savedInstanceState);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onSaveInstanceState(@Nullable Activity activity, @Nullable Bundle outState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, (Object) activity, (Object) outState);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void onPreSetContentView(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
                return;
            }
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63084);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f303348a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull QBaseActivity activity, @NotNull Function0<Unit> onDestroy) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onDestroy, "onDestroy");
        activity.registerActivityLifecycleCallbacks(new a(onDestroy, activity));
    }
}
