package com.tencent.qqnt.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.base.lifecycle.a;
import com.tencent.qqnt.base.lifecycle.c;
import com.tencent.qqnt.base.lifecycle.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J'\u0010\u000f\u001a\u00028\u0000\"\n\b\u0000\u0010\f*\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "initViewModel", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "initStatusBar", "", "isNeedTranslucentStatus", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "getActivityScopeViewModel", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Lcom/tencent/qqnt/base/lifecycle/c;", "getLifecycleObserverProvider", "Lcom/tencent/qqnt/base/lifecycle/a;", "getLifecycleConfigProvider", "Landroidx/lifecycle/ViewModelProvider;", "mActivityProvider", "Landroidx/lifecycle/ViewModelProvider;", "Lmqq/app/MobileQQ;", "mqq", "Lmqq/app/MobileQQ;", "Lcom/tencent/qqnt/base/lifecycle/f;", "lifecycleHelper", "Lcom/tencent/qqnt/base/lifecycle/f;", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BaseActivity extends AppCompatActivity {
    static IPatchRedirector $redirector_;

    @Nullable
    private f lifecycleHelper;

    @Nullable
    private ViewModelProvider mActivityProvider;

    @Nullable
    private MobileQQ mqq;

    public BaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public final <T extends ViewModel> T getActivityScopeViewModel(@NotNull Class<T> modelClass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) modelClass);
        }
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (this.mActivityProvider == null) {
            this.mActivityProvider = new ViewModelProvider(this);
        }
        ViewModelProvider viewModelProvider = this.mActivityProvider;
        Intrinsics.checkNotNull(viewModelProvider);
        return (T) viewModelProvider.get(modelClass);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.lifecycleHelper == null) {
            this.lifecycleHelper = new f();
        }
        f fVar = this.lifecycleHelper;
        Intrinsics.checkNotNull(fVar);
        Lifecycle lifecycle = super.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "super.getLifecycle()");
        return fVar.a(this, lifecycle, getLifecycleObserverProvider(), getLifecycleConfigProvider());
    }

    @NotNull
    public a getLifecycleConfigProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return a.INSTANCE.a();
    }

    @NotNull
    public c getLifecycleObserverProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return c.INSTANCE.a();
    }

    public void initStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (isNeedTranslucentStatus()) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(8192);
            window.setStatusBarColor(0);
        }
    }

    public abstract void initViewModel();

    public boolean isNeedTranslucentStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        initStatusBar();
        super.onCreate(savedInstanceState);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        this.mqq = mobileQQ;
        if (mobileQQ != null) {
            mobileQQ.addCommonActivity(this);
        }
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        MobileQQ mobileQQ = this.mqq;
        if (mobileQQ != null) {
            mobileQQ.removeCommonActivity(this);
        }
        this.mqq = null;
    }
}
