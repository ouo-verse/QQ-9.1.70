package com.tencent.mobileqq.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Dialog;
import android.app.DirectAction;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.PictureInPictureUiState;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.anim.IUnitedAnimSetter;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QBaseActivityWrapper extends QBaseActivity {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QBaseActivityWrapper";
    private static Field sAutofillClientField;
    private static Field sContentCaptureOptionsField;
    private static Method sGetThemeResIdMethod;
    private static final AtomicBoolean sGetThemeResIdMethodReflected;
    private FragmentActivity mBase;
    private Context mContextImpl;
    private QBaseActivity mQBase;
    private int mThemeResId;
    private final RFWThreadLocal<Resources.Theme> mThreadLocalTheme;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42239);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 328)) {
            redirector.redirect((short) 328);
        } else {
            sGetThemeResIdMethodReflected = new AtomicBoolean(false);
        }
    }

    public QBaseActivityWrapper(FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentActivity);
            return;
        }
        this.mThreadLocalTheme = new RFWThreadLocal<>();
        this.mBase = fragmentActivity;
        if (fragmentActivity instanceof QBaseActivity) {
            this.mQBase = (QBaseActivity) fragmentActivity;
        } else {
            this.mQBase = null;
        }
        Pair<Boolean, Object> autofillClient = getAutofillClient();
        Pair<Boolean, Object> contentCaptureOptions = getContentCaptureOptions();
        attachBaseContext(fragmentActivity);
        if (((Boolean) autofillClient.first).booleanValue()) {
            setAutoFillClient(autofillClient.second);
        }
        if (((Boolean) contentCaptureOptions.first).booleanValue()) {
            setContentCaptureOptions(contentCaptureOptions.second);
        }
    }

    private Pair<Boolean, Object> getAutofillClient() {
        if (sAutofillClientField == null) {
            try {
                Field declaredField = getContextImpl().getClass().getDeclaredField("mAutofillClient");
                sAutofillClientField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "mAutofillClientField reflect failed", th5);
                return new Pair<>(Boolean.FALSE, null);
            }
        }
        try {
            return new Pair<>(Boolean.TRUE, sAutofillClientField.get(getContextImpl()));
        } catch (Throwable th6) {
            QLog.e(TAG, 1, "mAutofillClientField get failed", th6);
            return new Pair<>(Boolean.FALSE, null);
        }
    }

    private FragmentActivity getBase() {
        if (this.mBase == null) {
            this.mBase = new FragmentActivity();
        }
        return this.mBase;
    }

    private Pair<Boolean, Object> getContentCaptureOptions() {
        if (sContentCaptureOptionsField == null) {
            try {
                Field declaredField = getContextImpl().getClass().getDeclaredField("mContentCaptureOptions");
                sContentCaptureOptionsField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "mContentCaptureOptionsField reflect failed", th5);
                return new Pair<>(Boolean.FALSE, null);
            }
        }
        try {
            return new Pair<>(Boolean.TRUE, sContentCaptureOptionsField.get(getContextImpl()));
        } catch (Throwable th6) {
            QLog.e(TAG, 1, "mContentCaptureOptionsField get failed", th6);
            return new Pair<>(Boolean.FALSE, null);
        }
    }

    private Context getContextImpl() {
        Context context = this.mContextImpl;
        if (context != null) {
            return context;
        }
        Context context2 = this.mBase;
        while (context2 instanceof ContextWrapper) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        this.mContextImpl = context2;
        return context2;
    }

    private QBaseActivity getQBase() {
        if (this.mQBase == null) {
            this.mQBase = new QBaseActivity();
        }
        return this.mQBase;
    }

    public static Method getSetThemeResIdMethod() throws NoSuchMethodException {
        if (!sGetThemeResIdMethodReflected.getAndSet(true)) {
            Method declaredMethod = ContextThemeWrapper.class.getDeclaredMethod("getThemeResId", new Class[0]);
            declaredMethod.setAccessible(true);
            sGetThemeResIdMethod = declaredMethod;
        }
        return sGetThemeResIdMethod;
    }

    private void initializeTheme() {
        if (this.mThreadLocalTheme.get() == null) {
            Resources.Theme newTheme = getResources().newTheme();
            Resources.Theme theme = getBase().getTheme();
            int themeResId = getThemeResId();
            if (themeResId != 0) {
                newTheme.applyStyle(themeResId, true);
                this.mThreadLocalTheme.set(newTheme);
            } else {
                this.mThreadLocalTheme.set(theme);
                QLog.e(TAG, 1, "getThemeResId() == 0\uff0c\u4f7f\u7528\u539f\u59cb\u7684theme");
            }
        }
    }

    private void setAutoFillClient(Object obj) {
        try {
            Field field = sAutofillClientField;
            if (field != null) {
                field.set(getContextImpl(), obj);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "mAutofillClientField set failed", th5);
        }
    }

    private void setContentCaptureOptions(Object obj) {
        try {
            Field field = sContentCaptureOptionsField;
            if (field != null) {
                field.set(getContextImpl(), obj);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "mContentCaptureOptionsField set failed", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void activityCloseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this);
        } else {
            getQBase().activityCloseAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void activityOpenAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this);
        } else {
            getQBase().activityOpenAnimation();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            iPatchRedirector.redirect((short) 133, (Object) this, (Object) view, (Object) layoutParams);
        } else {
            getBase().addContentView(view, layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void addObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 50)) {
            getQBase().addObserver(businessObserver);
        } else {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) businessObserver);
        }
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 322)) {
            iPatchRedirector.redirect((short) 322, (Object) this, (Object) configuration);
        } else {
            getBase().applyOverrideConfiguration(configuration);
        }
    }

    @Override // mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return ((Boolean) iPatchRedirector.redirect((short) 93, this, intent, serviceConnection, Integer.valueOf(i3))).booleanValue();
        }
        return getQBase().bindService(intent, serviceConnection, i3);
    }

    @Override // mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return ((Integer) iPatchRedirector.redirect((short) 91, (Object) this, (Object) str)).intValue();
        }
        return getQBase().checkSelfPermission(str);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void checkUnlockForSpecial() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            getQBase().checkUnlockForSpecial();
        }
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 232)) {
            iPatchRedirector.redirect((short) 232, (Object) this);
        } else {
            getBase().closeContextMenu();
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 227)) {
            iPatchRedirector.redirect((short) 227, (Object) this);
        } else {
            getBase().closeOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i3, @NonNull Intent intent, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 279)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 279, this, Integer.valueOf(i3), intent, Integer.valueOf(i16));
        }
        return getBase().createPendingResult(i3, intent, i16);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 213)) {
            return ((Boolean) iPatchRedirector.redirect((short) 213, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return getBase().dispatchGenericMotionEvent(motionEvent);
    }

    @Override // mqq.app.AppActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return ((Boolean) iPatchRedirector.redirect((short) 84, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return getQBase().dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void dispatchOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            getQBase().dispatchOnBackPressed();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 214)) {
            return ((Boolean) iPatchRedirector.redirect((short) 214, (Object) this, (Object) accessibilityEvent)).booleanValue();
        }
        return getBase().dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 211)) {
            dispatchTouchEvent = ((Boolean) iPatchRedirector.redirect((short) 211, (Object) this, (Object) motionEvent)).booleanValue();
        } else {
            dispatchTouchEvent = getBase().dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 212)) {
            return ((Boolean) iPatchRedirector.redirect((short) 212, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return getBase().dispatchTrackballEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return getQBase().doDispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void doInMultiWindowModeStatusBarVisibilityChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, i3);
        } else {
            getQBase().doInMultiWindowModeStatusBarVisibilityChange(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            getQBase().doOnBackPressed();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) configuration);
        } else {
            getQBase().doOnConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) bundle)).booleanValue();
        }
        return getQBase().doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            getQBase().doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) intent);
        } else {
            getQBase().doOnNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            getQBase().doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) bundle);
        } else {
            getQBase().doOnRestoreInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            getQBase().doOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) bundle);
        } else {
            getQBase().doOnSaveInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            getQBase().doOnStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            getQBase().doOnStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            getQBase().doOnWindowFocusChanged(z16);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, this, str, fileDescriptor, printWriter, strArr);
        } else {
            getBase().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean enableCheckDensity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Boolean) iPatchRedirector.redirect((short) 73, (Object) this)).booleanValue();
        }
        return getQBase().enableCheckDensity();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public void enterPictureInPictureMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 177)) {
            getBase().enterPictureInPictureMode();
        } else {
            iPatchRedirector.redirect((short) 177, (Object) this);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof QBaseActivityWrapper) {
            return Objects.equals(this.mBase, ((QBaseActivityWrapper) obj).mBase);
        }
        return Objects.equals(this.mBase, obj);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 189)) {
            return (T) iPatchRedirector.redirect((short) 189, (Object) this, i3);
        }
        return (T) getBase().findViewById(i3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 270)) {
            iPatchRedirector.redirect((short) 270, (Object) this);
        } else {
            getBase().finish();
        }
    }

    @Override // android.app.Activity
    public void finishActivity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 274)) {
            iPatchRedirector.redirect((short) 274, (Object) this, i3);
        } else {
            getBase().finishActivity(i3);
        }
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(@NonNull Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 275)) {
            iPatchRedirector.redirect((short) 275, (Object) this, (Object) activity, i3);
        } else {
            getBase().finishActivityFromChild(activity, i3);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 271)) {
            iPatchRedirector.redirect((short) 271, (Object) this);
        } else {
            getBase().finishAffinity();
        }
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 273)) {
            iPatchRedirector.redirect((short) 273, (Object) this);
        } else {
            getBase().finishAfterTransition();
        }
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 276)) {
            iPatchRedirector.redirect((short) 276, (Object) this);
        } else {
            getBase().finishAndRemoveTask();
        }
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 272)) {
            iPatchRedirector.redirect((short) 272, (Object) this, (Object) activity);
        } else {
            getBase().finishFromChild(activity);
        }
    }

    @Override // mqq.app.AppActivity
    public void fixAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this);
        } else {
            getQBase().fixAppRuntime();
        }
    }

    @Override // android.app.Activity
    @Nullable
    public ActionBar getActionBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 190)) {
            return (ActionBar) iPatchRedirector.redirect((short) 190, (Object) this);
        }
        return getBase().getActionBar();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Activity) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return getQBase().getActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (IActivityModuleProvider) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        return getQBase().getActivityModuleProvider();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return getQBase().getActivityName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public QBaseActivity.ActivityPropertyProvider getActivityPropertyProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (QBaseActivity.ActivityPropertyProvider) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        return getQBase().getActivityPropertyProvider();
    }

    @Override // mqq.app.AppActivity
    public AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 80, (Object) this);
        }
        return getQBase().getAppRuntime();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 323)) {
            return (AssetManager) iPatchRedirector.redirect((short) 323, (Object) this);
        }
        return getBase().getAssets();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getCIOPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (String) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        return getQBase().getCIOPageName();
    }

    @Override // android.app.Activity
    @Nullable
    public ComponentName getCallingActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 264)) {
            return (ComponentName) iPatchRedirector.redirect((short) 264, (Object) this);
        }
        return getBase().getCallingActivity();
    }

    @Override // android.app.Activity
    @Nullable
    public String getCallingPackage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 263)) {
            return (String) iPatchRedirector.redirect((short) 263, (Object) this);
        }
        return getBase().getCallingPackage();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean getCanLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return getQBase().getCanLock();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 182)) {
            return ((Integer) iPatchRedirector.redirect((short) 182, (Object) this)).intValue();
        }
        return getBase().getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 286)) {
            return (ComponentName) iPatchRedirector.redirect((short) 286, (Object) this);
        }
        return getBase().getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 194)) {
            return (Scene) iPatchRedirector.redirect((short) 194, (Object) this);
        }
        return getBase().getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 192)) {
            return (TransitionManager) iPatchRedirector.redirect((short) 192, (Object) this);
        }
        return getBase().getContentTransitionManager();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getCurrentAccountUinFromRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (String) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        return getQBase().getCurrentAccountUinFromRuntime();
    }

    @Override // android.app.Activity
    @Nullable
    public View getCurrentFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            return (View) iPatchRedirector.redirect((short) 149, (Object) this);
        }
        return getBase().getCurrentFocus();
    }

    @Override // mqq.app.AppActivity
    public String getCurrentFragments() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return (String) iPatchRedirector.redirect((short) 83, (Object) this);
        }
        return getQBase().getCurrentFragments();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public BroadcastReceiver getDebugUiHierarchyBroadcastReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BroadcastReceiver) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return getQBase().getDebugUiHierarchyBroadcastReceiver();
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            return (ViewModelProvider.Factory) iPatchRedirector.redirect((short) 129, (Object) this);
        }
        return getBase().getDefaultViewModelProviderFactory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public float getDensity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Float) iPatchRedirector.redirect((short) 70, (Object) this)).floatValue();
        }
        return getQBase().getDensity();
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 185)) {
            return (FragmentManager) iPatchRedirector.redirect((short) 185, (Object) this);
        }
        return getBase().getFragmentManager();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            return (Intent) iPatchRedirector.redirect((short) 143, (Object) this);
        }
        return getBase().getIntent();
    }

    @Override // androidx.activity.ComponentActivity
    @Nullable
    public Object getLastCustomNonConfigurationInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            return iPatchRedirector.redirect((short) 137, (Object) this);
        }
        return getBase().getLastCustomNonConfigurationInstance();
    }

    @Override // android.app.Activity
    @Nullable
    public Object getLastNonConfigurationInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 183)) {
            return iPatchRedirector.redirect((short) 183, (Object) this);
        }
        return getBase().getLastNonConfigurationInstance();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    @NonNull
    public LayoutInflater getLayoutInflater() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 240)) {
            return (LayoutInflater) iPatchRedirector.redirect((short) 240, (Object) this);
        }
        return getBase().getLayoutInflater();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 131, (Object) this);
        }
        return getBase().getLifecycle();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 148)) {
            return (LoaderManager) iPatchRedirector.redirect((short) 148, (Object) this);
        }
        return getBase().getLoaderManager();
    }

    @Override // android.app.Activity
    @NonNull
    public String getLocalClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 285)) {
            return (String) iPatchRedirector.redirect((short) 285, (Object) this);
        }
        return getBase().getLocalClassName();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    public int getMaxNumPictureInPictureActions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 180)) {
            return ((Integer) iPatchRedirector.redirect((short) 180, (Object) this)).intValue();
        }
        return getBase().getMaxNumPictureInPictureActions();
    }

    @Override // android.app.Activity
    @NonNull
    public MenuInflater getMenuInflater() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 241)) {
            return (MenuInflater) iPatchRedirector.redirect((short) 241, (Object) this);
        }
        return getBase().getMenuInflater();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.activitymodule.IActivityModuleHub
    public <T extends IActivityModule> T getModule(Class<? extends IActivityModule> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (T) iPatchRedirector.redirect((short) 60, (Object) this, (Object) cls);
        }
        return (T) getQBase().getModule(cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public Runnable getNFCResumeRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Runnable) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return getQBase().getNFCResumeRunnable();
    }

    @Override // android.app.Activity
    @Nullable
    public Intent getParentActivityIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 310)) {
            return (Intent) iPatchRedirector.redirect((short) 310, (Object) this);
        }
        return getBase().getParentActivityIntent();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getPreProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return getQBase().getPreProcess();
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 287)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 287, (Object) this, i3);
        }
        return getBase().getPreferences(i3);
    }

    @Override // android.app.Activity
    @Nullable
    public Uri getReferrer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 261)) {
            return (Uri) iPatchRedirector.redirect((short) 261, (Object) this);
        }
        return getBase().getReferrer();
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 281)) {
            return ((Integer) iPatchRedirector.redirect((short) 281, (Object) this)).intValue();
        }
        return getBase().getRequestedOrientation();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return (Resources) iPatchRedirector.redirect((short) 75, (Object) this);
        }
        return getQBase().getResources();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public Runnable getRunnableRemoveNotification() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Runnable) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return getQBase().getRunnableRemoveNotification();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 53, (Object) this, (Object) str, i3);
        }
        return getBase().getSharedPreferences(str, i3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public int getStopFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return getQBase().getStopFlag();
    }

    @Override // androidx.fragment.app.FragmentActivity
    @NonNull
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return (androidx.fragment.app.FragmentManager) iPatchRedirector.redirect((short) 103, (Object) this);
        }
        return getBase().getSupportFragmentManager();
    }

    @Override // androidx.fragment.app.FragmentActivity
    @NonNull
    public androidx.loader.app.LoaderManager getSupportLoaderManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            return (androidx.loader.app.LoaderManager) iPatchRedirector.redirect((short) 102, (Object) this);
        }
        return getBase().getSupportLoaderManager();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 289)) {
            return iPatchRedirector.redirect((short) 289, (Object) this, (Object) str);
        }
        return getBase().getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 282)) {
            return ((Integer) iPatchRedirector.redirect((short) 282, (Object) this)).intValue();
        }
        return getBase().getTaskId();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 327)) {
            return (Resources.Theme) iPatchRedirector.redirect((short) 327, (Object) this);
        }
        getBase().getTheme();
        initializeTheme();
        return this.mThreadLocalTheme.get();
    }

    @Keep
    public int getThemeResId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 326)) {
            return ((Integer) iPatchRedirector.redirect((short) 326, (Object) this)).intValue();
        }
        int i3 = this.mThemeResId;
        if (i3 != 0) {
            return i3;
        }
        FragmentActivity base = getBase();
        try {
            this.mThemeResId = getPackageManager().getActivityInfo(base.getComponentName(), 0).getThemeResource();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getPackageManager().getActivityInfo failed", th5);
        }
        if (this.mThemeResId == 0) {
            try {
                this.mThemeResId = ((Integer) getSetThemeResIdMethod().invoke(base, new Object[0])).intValue();
            } catch (Throwable th6) {
                QLog.e(TAG, 1, "refection getThemeResId failed", th6);
            }
        }
        return this.mThemeResId;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return getQBase().getTitleBarHeight();
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            return (ViewModelStore) iPatchRedirector.redirect((short) 130, (Object) this);
        }
        return getBase().get_viewModelStore();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 157)) {
            return (VoiceInteractor) iPatchRedirector.redirect((short) 157, (Object) this);
        }
        return getBase().getVoiceInteractor();
    }

    @Override // android.app.Activity
    public Window getWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 147)) {
            return (Window) iPatchRedirector.redirect((short) 147, (Object) this);
        }
        return getBase().getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            return (WindowManager) iPatchRedirector.redirect((short) 146, (Object) this);
        }
        return getBase().getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 210)) {
            return ((Boolean) iPatchRedirector.redirect((short) 210, (Object) this)).booleanValue();
        }
        return getBase().hasWindowFocus();
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Objects.hashCode(this.mBase);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 217)) {
            iPatchRedirector.redirect((short) 217, (Object) this);
        } else {
            getBase().invalidateOptionsMenu();
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    public boolean isActivityTransitionRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 243)) {
            return ((Boolean) iPatchRedirector.redirect((short) 243, (Object) this)).booleanValue();
        }
        return getBase().isActivityTransitionRunning();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        return getQBase().isAttachedToWindow();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isCanLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return getQBase().isCanLock();
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 268)) {
            return ((Boolean) iPatchRedirector.redirect((short) 268, (Object) this)).booleanValue();
        }
        return getBase().isChangingConfigurations();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isCloneInflaterInSubThreadEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Boolean) iPatchRedirector.redirect((short) 71, (Object) this)).booleanValue();
        }
        return getQBase().isCloneInflaterInSubThreadEnabled();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateLayoutInflaterEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, (Object) this)).booleanValue();
        }
        return getQBase().isDelegateLayoutInflaterEnabled();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateResourceEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Boolean) iPatchRedirector.redirect((short) 74, (Object) this)).booleanValue();
        }
        return getQBase().isDelegateResourceEnabled();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 267)) {
            return ((Boolean) iPatchRedirector.redirect((short) 267, (Object) this)).booleanValue();
        }
        return getBase().isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 266)) {
            return ((Boolean) iPatchRedirector.redirect((short) 266, (Object) this)).booleanValue();
        }
        return getBase().isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 294)) {
            return ((Boolean) iPatchRedirector.redirect((short) 294, (Object) this)).booleanValue();
        }
        return getBase().isImmersive();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isInMultiWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this)).booleanValue();
        }
        return getQBase().isInMultiWindow();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public boolean isInMultiWindowMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 173)) {
            return ((Boolean) iPatchRedirector.redirect((short) 173, (Object) this)).booleanValue();
        }
        return getBase().isInMultiWindowMode();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public boolean isInPictureInPictureMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 176)) {
            return ((Boolean) iPatchRedirector.redirect((short) 176, (Object) this)).booleanValue();
        }
        return getBase().isInPictureInPictureMode();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 31)
    public boolean isLaunchedFromBubble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 288)) {
            return ((Boolean) iPatchRedirector.redirect((short) 288, (Object) this)).booleanValue();
        }
        return getBase().isLaunchedFromBubble();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public boolean isLocalVoiceInteractionSupported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 158)) {
            return ((Boolean) iPatchRedirector.redirect((short) 158, (Object) this)).booleanValue();
        }
        return getBase().isLocalVoiceInteractionSupported();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isNeedInterruptDoMultiWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this)).booleanValue();
        }
        return getQBase().isNeedInterruptDoMultiWindow();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isNeedMiniMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this)).booleanValue();
        }
        return getQBase().isNeedMiniMsg();
    }

    @Override // mqq.app.AppActivity
    public boolean isResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Boolean) iPatchRedirector.redirect((short) 78, (Object) this)).booleanValue();
        }
        return getQBase().isResume();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isShowOnFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return getQBase().isShowOnFirst();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isSupportScreenShot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return getQBase().isSupportScreenShot();
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 283)) {
            return ((Boolean) iPatchRedirector.redirect((short) 283, (Object) this)).booleanValue();
        }
        return getBase().isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 155)) {
            return ((Boolean) iPatchRedirector.redirect((short) 155, (Object) this)).booleanValue();
        }
        return getBase().isVoiceInteraction();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 156)) {
            return ((Boolean) iPatchRedirector.redirect((short) 156, (Object) this)).booleanValue();
        }
        return getBase().isVoiceInteractionRoot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return getQBase().getNeedGestureBack();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 284)) {
            return ((Boolean) iPatchRedirector.redirect((short) 284, (Object) this, z16)).booleanValue();
        }
        return getBase().moveTaskToBack(z16);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 308)) {
            return ((Boolean) iPatchRedirector.redirect((short) 308, (Object) this, (Object) intent)).booleanValue();
        }
        return getBase().navigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 309)) {
            return ((Boolean) iPatchRedirector.redirect((short) 309, (Object) this, (Object) activity, (Object) intent)).booleanValue();
        }
        return getBase().navigateUpToFromChild(activity, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        } else {
            getQBase().onAccountChanged();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 306)) {
            iPatchRedirector.redirect((short) 306, (Object) this, (Object) actionMode);
        } else {
            super.onActionModeFinished(actionMode);
            getBase().onActionModeFinished(actionMode);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 305)) {
            iPatchRedirector.redirect((short) 305, (Object) this, (Object) actionMode);
        } else {
            super.onActionModeStarted(actionMode);
            getBase().onActionModeStarted(actionMode);
        }
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 278)) {
            iPatchRedirector.redirect((short) 278, (Object) this, i3, (Object) intent);
        } else {
            getBase().onActivityReenter(i3, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(@NonNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 104)) {
            getBase().onAttachFragment(fragment);
        } else {
            iPatchRedirector.redirect((short) 104, (Object) this, (Object) fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 208)) {
            iPatchRedirector.redirect((short) 208, (Object) this);
        } else {
            getBase().onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return getQBase().onBackEvent();
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            iPatchRedirector.redirect((short) 128, (Object) this);
        } else {
            getBase().onBackPressed();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            iPatchRedirector.redirect((short) 115, (Object) this, (Object) configuration);
        } else {
            getBase().onConfigurationChanged(configuration);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 206)) {
            iPatchRedirector.redirect((short) 206, (Object) this);
        } else {
            getBase().onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(@NonNull MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 233)) {
            return ((Boolean) iPatchRedirector.redirect((short) 233, (Object) this, (Object) menuItem)).booleanValue();
        }
        return getBase().onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(@NonNull Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 234)) {
            iPatchRedirector.redirect((short) 234, (Object) this, (Object) menu);
        } else {
            getBase().onContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            iPatchRedirector.redirect((short) 152, (Object) this, (Object) bundle, (Object) persistableBundle);
        } else {
            getBase().onCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 228)) {
            iPatchRedirector.redirect((short) 228, this, contextMenu, view, contextMenuInfo);
        } else {
            getBase().onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    @Nullable
    public CharSequence onCreateDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 165)) {
            return (CharSequence) iPatchRedirector.redirect((short) 165, (Object) this);
        }
        return getBase().onCreateDescription();
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 223)) {
            iPatchRedirector.redirect((short) 223, (Object) this, (Object) taskStackBuilder);
        } else {
            getBase().onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 218)) {
            return ((Boolean) iPatchRedirector.redirect((short) 218, (Object) this, (Object) menu)).booleanValue();
        }
        return getBase().onCreateOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, @NonNull Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            return ((Boolean) iPatchRedirector.redirect((short) 114, (Object) this, i3, (Object) menu)).booleanValue();
        }
        return getBase().onCreatePanelMenu(i3, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    @Nullable
    public View onCreatePanelView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 215)) {
            return (View) iPatchRedirector.redirect((short) 215, (Object) this, i3);
        }
        return getBase().onCreatePanelView(i3);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 164)) {
            return ((Boolean) iPatchRedirector.redirect((short) 164, (Object) this, (Object) bitmap, (Object) canvas)).booleanValue();
        }
        return getBase().onCreateThumbnail(bitmap, canvas);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 112)) ? getBase().onCreateView(str, context, attributeSet) : (View) iPatchRedirector.redirect((short) 112, this, str, context, attributeSet);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 209)) {
            iPatchRedirector.redirect((short) 209, (Object) this);
        } else {
            getBase().onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 298)) {
            iPatchRedirector.redirect((short) 298, (Object) this);
        } else {
            getBase().onEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 203)) {
            return ((Boolean) iPatchRedirector.redirect((short) 203, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return getBase().onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 29)
    public void onGetDirectActions(@NonNull CancellationSignal cancellationSignal, @NonNull Consumer<List<DirectAction>> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 168)) {
            iPatchRedirector.redirect((short) 168, (Object) this, (Object) cancellationSignal, (Object) consumer);
        } else {
            getBase().onGetDirectActions(cancellationSignal, consumer);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 196)) {
            return ((Boolean) iPatchRedirector.redirect((short) 196, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return getBase().onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 197)) {
            return ((Boolean) iPatchRedirector.redirect((short) 197, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return getBase().onKeyLongPress(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 199)) {
            return ((Boolean) iPatchRedirector.redirect((short) 199, this, Integer.valueOf(i3), Integer.valueOf(i16), keyEvent)).booleanValue();
        }
        return getBase().onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 200)) {
            return ((Boolean) iPatchRedirector.redirect((short) 200, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return getBase().onKeyShortcut(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 198)) {
            return ((Boolean) iPatchRedirector.redirect((short) 198, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return getBase().onKeyUp(i3, keyEvent);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public void onLocalVoiceInteractionStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 160)) {
            iPatchRedirector.redirect((short) 160, (Object) this);
        } else {
            getBase().onLocalVoiceInteractionStarted();
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public void onLocalVoiceInteractionStopped() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 161)) {
            iPatchRedirector.redirect((short) 161, (Object) this);
        } else {
            getBase().onLocalVoiceInteractionStopped();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            iPatchRedirector.redirect((short) 111, (Object) this);
        } else {
            getBase().onLowMemory();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, @NonNull MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            return ((Boolean) iPatchRedirector.redirect((short) 110, (Object) this, i3, (Object) menuItem)).booleanValue();
        }
        return getBase().onMenuItemSelected(i3, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i3, @NonNull Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 216)) {
            return ((Boolean) iPatchRedirector.redirect((short) 216, (Object) this, i3, (Object) menu)).booleanValue();
        }
        return getBase().onMenuOpened(i3, menu);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            iPatchRedirector.redirect((short) 117, (Object) this, z16);
        } else {
            super.onMultiWindowModeChanged(z16);
            getBase().onMultiWindowModeChanged(z16);
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 221)) {
            return ((Boolean) iPatchRedirector.redirect((short) 221, (Object) this)).booleanValue();
        }
        return getBase().onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 222)) {
            return ((Boolean) iPatchRedirector.redirect((short) 222, (Object) this, (Object) activity)).booleanValue();
        }
        return getBase().onNavigateUpFromChild(activity);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 220)) {
            return ((Boolean) iPatchRedirector.redirect((short) 220, (Object) this, (Object) menuItem)).booleanValue();
        }
        return getBase().onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 225)) {
            iPatchRedirector.redirect((short) 225, (Object) this, (Object) menu);
        } else {
            getBase().onOptionsMenuClosed(menu);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, @NonNull Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, (Object) this, i3, (Object) menu);
        } else {
            getBase().onPanelClosed(i3, menu);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 29)
    public void onPerformDirectAction(@NonNull String str, @NonNull Bundle bundle, @NonNull CancellationSignal cancellationSignal, @NonNull Consumer<Bundle> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 169)) {
            iPatchRedirector.redirect((short) 169, this, str, bundle, cancellationSignal, consumer);
        } else {
            getBase().onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            iPatchRedirector.redirect((short) 116, (Object) this, z16);
        } else {
            super.onPictureInPictureModeChanged(z16);
            getBase().onPictureInPictureModeChanged(z16);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 30)
    public boolean onPictureInPictureRequested() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 181)) {
            return ((Boolean) iPatchRedirector.redirect((short) 181, (Object) this)).booleanValue();
        }
        return getBase().onPictureInPictureRequested();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 31)
    public void onPictureInPictureUiStateChanged(@NonNull PictureInPictureUiState pictureInPictureUiState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 175)) {
            iPatchRedirector.redirect((short) 175, (Object) this, (Object) pictureInPictureUiState);
        } else {
            getBase().onPictureInPictureUiStateChanged(pictureInPictureUiState);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 154)) {
            iPatchRedirector.redirect((short) 154, (Object) this, (Object) bundle, (Object) persistableBundle);
        } else {
            getBase().onPostCreate(bundle, persistableBundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
        } else {
            getQBase().onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
        } else {
            getQBase().onPreThemeChanged();
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 224)) {
            iPatchRedirector.redirect((short) 224, (Object) this, (Object) taskStackBuilder);
        } else {
            getBase().onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 219)) {
            return ((Boolean) iPatchRedirector.redirect((short) 219, (Object) this, (Object) menu)).booleanValue();
        }
        return getBase().onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, @Nullable View view, @NonNull Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return ((Boolean) iPatchRedirector.redirect((short) 107, this, Integer.valueOf(i3), view, menu)).booleanValue();
        }
        return getBase().onPreparePanel(i3, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 167)) {
            iPatchRedirector.redirect((short) 167, (Object) this, (Object) assistContent);
        } else {
            getBase().onProvideAssistContent(assistContent);
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 166)) {
            iPatchRedirector.redirect((short) 166, (Object) this, (Object) bundle);
        } else {
            getBase().onProvideAssistData(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    @RequiresApi(api = 24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 170)) {
            iPatchRedirector.redirect((short) 170, this, list, menu, Integer.valueOf(i3));
        } else {
            getBase().onProvideKeyboardShortcuts(list, menu, i3);
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 262)) {
            return (Uri) iPatchRedirector.redirect((short) 262, (Object) this);
        }
        return getBase().onProvideReferrer();
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, this, Integer.valueOf(i3), strArr, iArr);
        } else {
            super.onRequestPermissionsResult(i3, strArr, iArr);
            getBase().onRequestPermissionsResult(i3, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 153)) {
            iPatchRedirector.redirect((short) 153, (Object) this, (Object) bundle, (Object) persistableBundle);
        } else {
            getBase().onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    @Override // androidx.activity.ComponentActivity
    @Nullable
    public Object onRetainCustomNonConfigurationInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            return iPatchRedirector.redirect((short) 138, (Object) this);
        }
        return getBase().onRetainCustomNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle, @NonNull PersistableBundle persistableBundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 163)) {
            iPatchRedirector.redirect((short) 163, (Object) this, (Object) bundle, (Object) persistableBundle);
        } else {
            getBase().onSaveInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 235)) ? getBase().onSearchRequested(searchEvent) : ((Boolean) iPatchRedirector.redirect((short) 235, (Object) this, (Object) searchEvent)).booleanValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this);
        } else {
            getBase().onStateNotSaved();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void onTopResumedActivityChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, z16);
        } else {
            getQBase().onTopResumedActivityChanged(z16);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 201)) {
            return ((Boolean) iPatchRedirector.redirect((short) 201, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return getBase().onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 202)) {
            return ((Boolean) iPatchRedirector.redirect((short) 202, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return getBase().onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 184)) {
            iPatchRedirector.redirect((short) 184, (Object) this, i3);
        } else {
            getBase().onTrimMemory(i3);
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 204)) {
            iPatchRedirector.redirect((short) 204, (Object) this);
        } else {
            getBase().onUserInteraction();
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 297)) {
            iPatchRedirector.redirect((short) 297, (Object) this);
        } else {
            super.onVisibleBehindCanceled();
            getBase().onVisibleBehindCanceled();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 205)) {
            iPatchRedirector.redirect((short) 205, (Object) this, (Object) layoutParams);
        } else {
            getBase().onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 207)) {
            iPatchRedirector.redirect((short) 207, (Object) this, z16);
        } else {
            getBase().onWindowFocusChanged(z16);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 303)) ? getBase().onWindowStartingActionMode(callback) : (ActionMode) iPatchRedirector.redirect((short) 303, (Object) this, (Object) callback);
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 231)) {
            iPatchRedirector.redirect((short) 231, (Object) this, (Object) view);
        } else {
            getBase().openContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 226)) {
            iPatchRedirector.redirect((short) 226, (Object) this);
        } else {
            getBase().openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 260)) {
            iPatchRedirector.redirect((short) 260, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            getBase().overridePendingTransition(i3, i16);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.activity.contextaware.ContextAware
    @Nullable
    public Context peekAvailableContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            return (Context) iPatchRedirector.redirect((short) 132, (Object) this);
        }
        return getBase().peekAvailableContext();
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 313)) {
            iPatchRedirector.redirect((short) 313, (Object) this);
        } else {
            getBase().postponeEnterTransition();
        }
    }

    @Override // mqq.app.AppActivity
    public boolean preloadData(AppRuntime appRuntime, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return ((Boolean) iPatchRedirector.redirect((short) 87, this, appRuntime, Boolean.valueOf(z16))).booleanValue();
        }
        return getQBase().preloadData(appRuntime, z16);
    }

    @Override // mqq.app.AppActivity
    public void preloadUi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 88)) {
            getQBase().preloadUi();
        } else {
            iPatchRedirector.redirect((short) 88, (Object) this);
        }
    }

    @Override // mqq.app.AppActivity
    public void realOnCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this);
        } else {
            getQBase().realOnCreate();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void receiveScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        } else {
            getQBase().receiveScreenOff();
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 269)) {
            iPatchRedirector.redirect((short) 269, (Object) this);
        } else {
            getBase().recreate();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    @RequiresApi(api = 29)
    public void registerActivityLifecycleCallbacks(BaseActivityLifecycleCallbacks baseActivityLifecycleCallbacks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            getQBase().registerActivityLifecycleCallbacks(baseActivityLifecycleCallbacks);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) baseActivityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 229)) {
            iPatchRedirector.redirect((short) 229, (Object) this, (Object) view);
        } else {
            getBase().registerForContextMenu(view);
        }
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 277)) {
            return ((Boolean) iPatchRedirector.redirect((short) 277, (Object) this)).booleanValue();
        }
        return getBase().releaseInstance();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void removeObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) businessObserver);
        } else {
            getQBase().removeObserver(businessObserver);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void reportFullyDrawn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            iPatchRedirector.redirect((short) 123, (Object) this);
        } else {
            getBase().reportFullyDrawn();
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 315)) {
            return (DragAndDropPermissions) iPatchRedirector.redirect((short) 315, (Object) this, (Object) dragEvent);
        }
        return getBase().requestDragAndDropPermissions(dragEvent);
    }

    @Override // mqq.app.AppActivity, mqq.app.IPermissionRequester
    public void requestPermissions(Object obj, int i3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, this, obj, Integer.valueOf(i3), strArr);
        } else {
            getQBase().requestPermissions(obj, i3, strArr);
        }
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 296)) {
            return ((Boolean) iPatchRedirector.redirect((short) 296, (Object) this, z16)).booleanValue();
        }
        return getBase().requestVisibleBehind(z16);
    }

    @Override // mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 94)) {
            getQBase().sendBroadcast(intent);
        } else {
            iPatchRedirector.redirect((short) 94, (Object) this, (Object) intent);
        }
    }

    @Override // mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 96)) {
            getQBase().sendOrderedBroadcast(intent, str);
        } else {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) intent, (Object) str);
        }
    }

    @Override // android.app.Activity
    public void setActionBar(@Nullable Toolbar toolbar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 191)) {
            iPatchRedirector.redirect((short) 191, (Object) this, (Object) toolbar);
        } else {
            getBase().setActionBar(toolbar);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setAttachedToWindow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
        } else {
            getQBase().setAttachedToWindow(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setCanLock(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
        } else {
            getQBase().setCanLock(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setContentBackgroundResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, i3);
        } else {
            getQBase().setContentBackgroundResource(i3);
        }
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 193)) {
            iPatchRedirector.redirect((short) 193, (Object) this, (Object) transitionManager);
        } else {
            getBase().setContentTransitionManager(transitionManager);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 134)) {
            getBase().setContentView(view, layoutParams);
        } else {
            iPatchRedirector.redirect((short) 134, (Object) this, (Object) view, (Object) layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setDebugUiHierarchyBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) broadcastReceiver);
        } else {
            getQBase().setDebugUiHierarchyBroadcastReceiver(broadcastReceiver);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void setEnterSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 121)) {
            getBase().setEnterSharedElementCallback(sharedElementCallback);
        } else {
            iPatchRedirector.redirect((short) 121, (Object) this, (Object) sharedElementCallback);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void setExitSharedElementCallback(@Nullable SharedElementCallback sharedElementCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 120)) {
            getBase().setExitSharedElementCallback(sharedElementCallback);
        } else {
            iPatchRedirector.redirect((short) 120, (Object) this, (Object) sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 195)) {
            iPatchRedirector.redirect((short) 195, (Object) this, z16);
        } else {
            getBase().setFinishOnTouchOutside(z16);
        }
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 299)) {
            iPatchRedirector.redirect((short) 299, (Object) this, z16);
        } else {
            getBase().setImmersive(z16);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 29)
    public void setInheritShowWhenLocked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 320)) {
            iPatchRedirector.redirect((short) 320, (Object) this, z16);
        } else {
            getBase().setInheritShowWhenLocked(z16);
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            iPatchRedirector.redirect((short) 144, (Object) this, (Object) intent);
        } else {
            getBase().setIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setJumpDialog(Dialog dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) dialog);
        } else {
            getQBase().setJumpDialog(dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return getQBase().setLastActivityName();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 30)
    public void setLocusContext(@Nullable LocusId locusId, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            iPatchRedirector.redirect((short) 145, (Object) this, (Object) locusId, (Object) bundle);
        } else {
            getBase().setLocusContext(locusId, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setNFCResumeRunnable(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable);
        } else {
            getQBase().setNFCResumeRunnable(runnable);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    public void setPictureInPictureParams(@NonNull PictureInPictureParams pictureInPictureParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 179)) {
            iPatchRedirector.redirect((short) 179, (Object) this, (Object) pictureInPictureParams);
        } else {
            getBase().setPictureInPictureParams(pictureInPictureParams);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity
    public void setRequestedOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 280)) {
            iPatchRedirector.redirect((short) 280, (Object) this, i3);
        } else {
            getBase().setRequestedOrientation(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setRunnableRemoveNotification(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) runnable);
        } else {
            getQBase().setRunnableRemoveNotification(runnable);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setShowOnFirst(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            getQBase().setShowOnFirst(z16);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 27)
    public void setShowWhenLocked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 319)) {
            iPatchRedirector.redirect((short) 319, (Object) this, z16);
        } else {
            getBase().setShowWhenLocked(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setStopFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            getQBase().setStopFlag(i3);
        }
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 293)) {
            iPatchRedirector.redirect((short) 293, (Object) this, (Object) taskDescription);
        } else {
            getBase().setTaskDescription(taskDescription);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 324)) {
            iPatchRedirector.redirect((short) 324, (Object) this, i3);
            return;
        }
        this.mThemeResId = i3;
        getBase().setTheme(i3);
        initializeTheme();
        this.mThreadLocalTheme.get().applyStyle(i3, true);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 290)) {
            getBase().setTitle(charSequence);
        } else {
            iPatchRedirector.redirect((short) 290, (Object) this, (Object) charSequence);
        }
    }

    @Override // android.app.Activity
    public void setTitleColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 292)) {
            iPatchRedirector.redirect((short) 292, (Object) this, i3);
        } else {
            getBase().setTitleColor(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setTopResumedActivityListener(QBaseActivity.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) aVar);
        } else {
            getQBase().setTopResumedActivityListener(aVar);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 30)
    public boolean setTranslucent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 295)) {
            return ((Boolean) iPatchRedirector.redirect((short) 295, (Object) this, z16)).booleanValue();
        }
        return getBase().setTranslucent(z16);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 27)
    public void setTurnScreenOn(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 321)) {
            iPatchRedirector.redirect((short) 321, (Object) this, z16);
        } else {
            getBase().setTurnScreenOn(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void setUnitedAnimSetter(IUnitedAnimSetter iUnitedAnimSetter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iUnitedAnimSetter);
        } else {
            getQBase().setUnitedAnimSetter(iUnitedAnimSetter);
        }
    }

    @Override // android.app.Activity
    public void setVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 265)) {
            iPatchRedirector.redirect((short) 265, (Object) this, z16);
        } else {
            getBase().setVisible(z16);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public void setVrModeEnabled(boolean z16, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 300)) {
            iPatchRedirector.redirect((short) 300, this, Boolean.valueOf(z16), componentName);
        } else {
            getBase().setVrModeEnabled(z16, componentName);
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 242)) {
            return ((Boolean) iPatchRedirector.redirect((short) 242, (Object) this, (Object) str)).booleanValue();
        }
        return getBase().shouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 307)) {
            return ((Boolean) iPatchRedirector.redirect((short) 307, (Object) this, (Object) intent)).booleanValue();
        }
        return getBase().shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 171)) {
            return ((Boolean) iPatchRedirector.redirect((short) 171, (Object) this, (Object) bundle)).booleanValue();
        }
        return getBase().showAssist(bundle);
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 318)) {
            iPatchRedirector.redirect((short) 318, (Object) this);
        } else {
            getBase().showLockTaskEscapeMessage();
        }
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return ((Boolean) iPatchRedirector.redirect((short) 86, (Object) this)).booleanValue();
        }
        return getQBase().showPreview();
    }

    @Override // android.app.Activity
    @Nullable
    public ActionMode startActionMode(ActionMode.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 301)) ? getBase().startActionMode(callback) : (ActionMode) iPatchRedirector.redirect((short) 301, (Object) this, (Object) callback);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 246)) {
            getBase().startActivities(intentArr);
        } else {
            iPatchRedirector.redirect((short) 246, (Object) this, (Object) intentArr);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 244)) {
            getBase().startActivity(intent);
        } else {
            iPatchRedirector.redirect((short) 244, (Object) this, (Object) intent);
        }
    }

    @Keep
    public void startActivityAsCaller(Intent intent, @Nullable Bundle bundle, IBinder iBinder, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 142)) {
            iPatchRedirector.redirect((short) 142, this, intent, bundle, iBinder, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            QLog.w(TAG, 1, "startActivityAsUser permissionToken", new Throwable());
            getBase().startActivity(intent, bundle);
        }
    }

    @Keep
    public void startActivityAsUser(Intent intent, Bundle bundle, UserHandle userHandle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 141)) {
            iPatchRedirector.redirect((short) 141, this, intent, bundle, userHandle);
        } else {
            QLog.w(TAG, 1, "startActivityAsUser", new Throwable());
            getBase().startActivity(intent, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 126)) {
            getBase().startActivityForResult(intent, i3, bundle);
        } else {
            iPatchRedirector.redirect((short) 126, this, intent, Integer.valueOf(i3), bundle);
        }
    }

    @Keep
    public void startActivityForResultAsUser(Intent intent, String str, int i3, @Nullable Bundle bundle, UserHandle userHandle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            iPatchRedirector.redirect((short) 140, this, intent, str, Integer.valueOf(i3), bundle, userHandle);
            return;
        }
        QLog.w(TAG, 1, "startActivityForResultAsUser resultWho: " + str, new Throwable());
        getBase().startActivityForResult(intent, i3, bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void startActivityForResultOriginal(Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) {
            getQBase().startActivityForResultOriginal(intent, i3, bundle);
        } else {
            iPatchRedirector.redirect((short) 48, this, intent, Integer.valueOf(i3), bundle);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(@NonNull Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 254)) {
            getBase().startActivityFromChild(activity, intent, i3);
        } else {
            iPatchRedirector.redirect((short) 254, this, activity, intent, Integer.valueOf(i3));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 99)) {
            getBase().startActivityFromFragment(fragment, intent, i3, bundle);
        } else {
            iPatchRedirector.redirect((short) 99, this, fragment, intent, Integer.valueOf(i3), bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(@NonNull Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 250)) ? getBase().startActivityIfNeeded(intent, i3) : ((Boolean) iPatchRedirector.redirect((short) 250, (Object) this, (Object) intent, i3)).booleanValue();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, @Nullable Intent intent, int i3, int i16, int i17) throws IntentSender.SendIntentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 248)) {
            getBase().startIntentSender(intentSender, intent, i3, i16, i17);
        } else {
            iPatchRedirector.redirect((short) 248, this, intentSender, intent, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i3, @Nullable Intent intent, int i16, int i17, int i18, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 124)) {
            getBase().startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18, bundle);
        } else {
            iPatchRedirector.redirect((short) 124, this, intentSender, Integer.valueOf(i3), intent, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), bundle);
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 258)) {
            getBase().startIntentSenderFromChild(activity, intentSender, i3, intent, i16, i17, i18);
        } else {
            iPatchRedirector.redirect((short) 258, this, activity, intentSender, Integer.valueOf(i3), intent, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startIntentSenderFromFragment(@NonNull Fragment fragment, IntentSender intentSender, int i3, @Nullable Intent intent, int i16, int i17, int i18, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, this, fragment, intentSender, Integer.valueOf(i3), intent, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), bundle);
        } else {
            getBase().startIntentSenderFromFragment(fragment, intentSender, i3, intent, i16, i17, i18, bundle);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public void startLocalVoiceInteraction(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 159)) {
            iPatchRedirector.redirect((short) 159, (Object) this, (Object) bundle);
        } else {
            getBase().startLocalVoiceInteraction(bundle);
        }
    }

    @Override // android.app.Activity
    public void startLockTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 316)) {
            iPatchRedirector.redirect((short) 316, (Object) this);
        } else {
            getBase().startLockTask();
        }
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 187)) {
            iPatchRedirector.redirect((short) 187, (Object) this, (Object) cursor);
        } else {
            getBase().startManagingCursor(cursor);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(@NonNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 252)) ? getBase().startNextMatchingActivity(intent) : ((Boolean) iPatchRedirector.redirect((short) 252, (Object) this, (Object) intent)).booleanValue();
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 314)) {
            iPatchRedirector.redirect((short) 314, (Object) this);
        } else {
            getBase().startPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void startSearch(@Nullable String str, boolean z16, @Nullable Bundle bundle, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 237)) {
            iPatchRedirector.redirect((short) 237, this, str, Boolean.valueOf(z16), bundle, Boolean.valueOf(z17));
        } else {
            getBase().startSearch(str, z16, bundle, z17);
        }
    }

    @Override // mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            return (ComponentName) iPatchRedirector.redirect((short) 92, (Object) this, (Object) intent);
        }
        return getQBase().startService(intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void startUnlockActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        } else {
            getQBase().startUnlockActivity();
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 24)
    public void stopLocalVoiceInteraction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 162)) {
            iPatchRedirector.redirect((short) 162, (Object) this);
        } else {
            getBase().stopLocalVoiceInteraction();
        }
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 317)) {
            iPatchRedirector.redirect((short) 317, (Object) this);
        } else {
            getBase().stopLockTask();
        }
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 188)) {
            iPatchRedirector.redirect((short) 188, (Object) this, (Object) cursor);
        } else {
            getBase().stopManagingCursor(cursor);
        }
    }

    @Override // mqq.app.AppActivity
    public void superFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this);
        } else {
            getQBase().superFinish();
        }
    }

    @Override // mqq.app.AppActivity
    public void superSetRequestedOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, i3);
        } else {
            getQBase().superSetRequestedOrientation(i3);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportFinishAfterTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            iPatchRedirector.redirect((short) 122, (Object) this);
        } else {
            getBase().supportFinishAfterTransition();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this);
        } else {
            getBase().supportInvalidateOptionsMenu();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportPostponeEnterTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            iPatchRedirector.redirect((short) 119, (Object) this);
        } else {
            getBase().supportPostponeEnterTransition();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportStartPostponedEnterTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            iPatchRedirector.redirect((short) 118, (Object) this);
        } else {
            getBase().supportStartPostponedEnterTransition();
        }
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 239)) {
            iPatchRedirector.redirect((short) 239, (Object) this, z16);
        } else {
            getBase().takeKeyEvents(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean themeChangeRightNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Boolean) iPatchRedirector.redirect((short) 65, (Object) this)).booleanValue();
        }
        return getQBase().themeChangeRightNow();
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 238)) {
            iPatchRedirector.redirect((short) 238, (Object) this, (Object) str, (Object) bundle);
        } else {
            getBase().triggerSearch(str, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    @RequiresApi(api = 29)
    public void unregisterActivityLifecycleCallbacks(BaseActivityLifecycleCallbacks baseActivityLifecycleCallbacks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            getQBase().unregisterActivityLifecycleCallbacks(baseActivityLifecycleCallbacks);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) baseActivityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 230)) {
            iPatchRedirector.redirect((short) 230, (Object) this, (Object) view);
        } else {
            getBase().unregisterForContextMenu(view);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void addObserver(BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) {
            getQBase().addObserver(businessObserver, z16);
        } else {
            iPatchRedirector.redirect((short) 51, this, businessObserver, Boolean.valueOf(z16));
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    public boolean enterPictureInPictureMode(@NonNull PictureInPictureParams pictureInPictureParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 178)) ? getBase().enterPictureInPictureMode(pictureInPictureParams) : ((Boolean) iPatchRedirector.redirect((short) 178, (Object) this, (Object) pictureInPictureParams)).booleanValue();
    }

    @Override // android.app.Activity
    public void onAttachFragment(android.app.Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 186)) {
            getBase().onAttachFragment(fragment);
        } else {
            iPatchRedirector.redirect((short) 186, (Object) this, (Object) fragment);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 113)) ? getBase().onCreateView(view, str, context, attributeSet) : (View) iPatchRedirector.redirect((short) 113, this, view, str, context, attributeSet);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 236)) ? getBase().onSearchRequested() : ((Boolean) iPatchRedirector.redirect((short) 236, (Object) this)).booleanValue();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 304)) ? getBase().onWindowStartingActionMode(callback, i3) : (ActionMode) iPatchRedirector.redirect((short) 304, (Object) this, (Object) callback, i3);
    }

    @Override // mqq.app.AppActivity
    public HashMap<String, Runnable> preloadUi(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 89)) ? getQBase().preloadUi(z16) : (HashMap) iPatchRedirector.redirect((short) 89, (Object) this, z16);
    }

    @Override // android.app.Activity
    @RequiresApi(api = 29)
    public void registerActivityLifecycleCallbacks(@NonNull Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 150)) {
            getBase().registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            iPatchRedirector.redirect((short) 150, (Object) this, (Object) activityLifecycleCallbacks);
        }
    }

    @Override // mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 95)) {
            getQBase().sendBroadcast(intent, str);
        } else {
            iPatchRedirector.redirect((short) 95, (Object) this, (Object) intent, (Object) str);
        }
    }

    @Override // mqq.app.AppActivity, android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 97)) {
            getQBase().sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
        } else {
            iPatchRedirector.redirect((short) 97, this, intent, str, broadcastReceiver, handler, Integer.valueOf(i3), str2, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 135)) {
            getBase().setContentView(view);
        } else {
            iPatchRedirector.redirect((short) 135, (Object) this, (Object) view);
        }
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 311)) {
            getBase().setEnterSharedElementCallback(sharedElementCallback);
        } else {
            iPatchRedirector.redirect((short) 311, (Object) this, (Object) sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(android.app.SharedElementCallback sharedElementCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 312)) {
            getBase().setExitSharedElementCallback(sharedElementCallback);
        } else {
            iPatchRedirector.redirect((short) 312, (Object) this, (Object) sharedElementCallback);
        }
    }

    @Override // android.app.Activity
    public void setTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 291)) {
            getBase().setTitle(i3);
        } else {
            iPatchRedirector.redirect((short) 291, (Object) this, i3);
        }
    }

    @Override // android.app.Activity
    @Nullable
    public ActionMode startActionMode(ActionMode.Callback callback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 302)) ? getBase().startActionMode(callback, i3) : (ActionMode) iPatchRedirector.redirect((short) 302, (Object) this, (Object) callback, i3);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 247)) {
            getBase().startActivities(intentArr, bundle);
        } else {
            iPatchRedirector.redirect((short) 247, (Object) this, (Object) intentArr, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 245)) {
            getBase().startActivity(intent, bundle);
        } else {
            iPatchRedirector.redirect((short) 245, (Object) this, (Object) intent, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 127)) {
            getBase().startActivityForResult(intent, i3);
        } else {
            iPatchRedirector.redirect((short) 127, (Object) this, (Object) intent, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void startActivityForResultOriginal(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) {
            getQBase().startActivityForResultOriginal(intent, i3);
        } else {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) intent, i3);
        }
    }

    @Override // android.app.Activity
    public void startActivityFromChild(@NonNull Activity activity, Intent intent, int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 255)) {
            getBase().startActivityFromChild(activity, intent, i3, bundle);
        } else {
            iPatchRedirector.redirect((short) 255, this, activity, intent, Integer.valueOf(i3), bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 100)) {
            getBase().startActivityFromFragment(fragment, intent, i3);
        } else {
            iPatchRedirector.redirect((short) 100, this, fragment, intent, Integer.valueOf(i3));
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(@NonNull Intent intent, int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 251)) ? getBase().startActivityIfNeeded(intent, i3, bundle) : ((Boolean) iPatchRedirector.redirect((short) 251, this, intent, Integer.valueOf(i3), bundle)).booleanValue();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, @Nullable Intent intent, int i3, int i16, int i17, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 249)) {
            getBase().startIntentSender(intentSender, intent, i3, i16, i17, bundle);
        } else {
            iPatchRedirector.redirect((short) 249, this, intentSender, intent, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bundle);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i3, @Nullable Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 125)) {
            getBase().startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18);
        } else {
            iPatchRedirector.redirect((short) 125, this, intentSender, Integer.valueOf(i3), intent, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 259)) {
            getBase().startIntentSenderFromChild(activity, intentSender, i3, intent, i16, i17, i18, bundle);
        } else {
            iPatchRedirector.redirect((short) 259, this, activity, intentSender, Integer.valueOf(i3), intent, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), bundle);
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(@NonNull Intent intent, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 253)) ? getBase().startNextMatchingActivity(intent, bundle) : ((Boolean) iPatchRedirector.redirect((short) 253, (Object) this, (Object) intent, (Object) bundle)).booleanValue();
    }

    @Override // android.app.Activity
    @RequiresApi(api = 29)
    public void unregisterActivityLifecycleCallbacks(@NonNull Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 151)) {
            getBase().unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            iPatchRedirector.redirect((short) 151, (Object) this, (Object) activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    public void onMultiWindowModeChanged(boolean z16, Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 172)) {
            getBase().onMultiWindowModeChanged(z16, configuration);
        } else {
            iPatchRedirector.redirect((short) 172, this, Boolean.valueOf(z16), configuration);
        }
    }

    @Override // android.app.Activity
    @RequiresApi(api = 26)
    public void onPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 174)) {
            getBase().onPictureInPictureModeChanged(z16, configuration);
        } else {
            iPatchRedirector.redirect((short) 174, this, Boolean.valueOf(z16), configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 136)) {
            getBase().setContentView(i3);
        } else {
            iPatchRedirector.redirect((short) 136, (Object) this, i3);
        }
    }

    @Keep
    public void startActivityForResult(String str, Intent intent, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            iPatchRedirector.redirect((short) 139, this, str, intent, Integer.valueOf(i3), bundle);
            return;
        }
        QLog.w(TAG, 1, "startActivityForResult who: " + str, new Throwable());
        getBase().startActivityForResult(intent, i3, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 256)) {
            getBase().startActivityFromFragment(fragment, intent, i3);
        } else {
            iPatchRedirector.redirect((short) 256, this, fragment, intent, Integer.valueOf(i3));
        }
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(@NonNull android.app.Fragment fragment, Intent intent, int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 257)) {
            getBase().startActivityFromFragment(fragment, intent, i3, bundle);
        } else {
            iPatchRedirector.redirect((short) 257, this, fragment, intent, Integer.valueOf(i3), bundle);
        }
    }

    @Override // android.view.ContextThemeWrapper
    @RequiresApi(api = 29)
    public void setTheme(@Nullable Resources.Theme theme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 325)) {
            iPatchRedirector.redirect((short) 325, (Object) this, (Object) theme);
            return;
        }
        getBase().setTheme(theme);
        Resources.Theme theme2 = this.mThreadLocalTheme.get();
        if (theme2 == null) {
            initializeTheme();
        } else {
            theme2.setTo(theme);
        }
    }
}
