package com.tencent.minibox.dynamic.api;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Display;
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
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class BaseDelegatorActivity extends Activity implements IActivityDelegator {
    private boolean isBeforeOnCreate = true;
    private IActivityDelegate mDelegateImpl;
    private Resources.Theme mHostTheme;

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, com.tencent.minibox.dynamic.api.IActivityDelegator
    public void finish() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity, com.tencent.minibox.dynamic.api.IActivityDelegator
    public ComponentName getCallingActivity() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.getCallingActivity();
        }
        return super.getCallingActivity();
    }

    @Override // android.content.ContextWrapper, android.content.Context, com.tencent.minibox.dynamic.api.IActivityDelegator
    public ClassLoader getClassLoader() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.getClassLoader();
        }
        return super.getClassLoader();
    }

    @Override // android.app.Activity, com.tencent.minibox.dynamic.api.IActivityDelegator
    public LayoutInflater getLayoutInflater() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.getLayoutInflater();
        }
        return super.getLayoutInflater();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context, com.tencent.minibox.dynamic.api.IActivityDelegator
    public Resources getResources() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.getResources();
        }
        return super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context, com.tencent.minibox.dynamic.api.IActivityDelegator
    public Resources.Theme getTheme() {
        if (this.isBeforeOnCreate) {
            if (this.mHostTheme == null) {
                this.mHostTheme = super.getResources().newTheme();
            }
            return this.mHostTheme;
        }
        return super.getTheme();
    }

    public void injectDelegate(IActivityDelegate iActivityDelegate) {
        this.mDelegateImpl = iActivityDelegate;
    }

    @Override // android.app.Activity, com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean isChangingConfigurations() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.isChangingConfigurations();
        }
        return super.isChangingConfigurations();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onActivityResult(i3, i16, intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i3, boolean z16) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onApplyThemeResource(theme, i3, z16);
        } else {
            super.onApplyThemeResource(theme, i3, z16);
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onChildTitleChanged(activity, charSequence);
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        this.isBeforeOnCreate = false;
        this.mHostTheme = null;
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onCreate(bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onCreateDescription();
        }
        return super.onCreateDescription();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onCreateDialog(i3);
        }
        return super.onCreateDialog(i3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onCreatePanelMenu(i3, menu);
        }
        return super.onCreatePanelMenu(i3, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i3) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onCreatePanelView(i3);
        }
        return super.onCreatePanelView(i3);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onCreateThumbnail(bitmap, canvas);
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onCreateView(str, context, attributeSet);
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onKeyDown(i3, keyEvent);
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onKeyUp(i3, keyEvent);
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onMultiWindowModeChanged(z16);
        } else {
            super.onMultiWindowModeChanged(z16);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onOptionsItemSelected(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onPanelClosed(i3, menu);
        } else {
            super.onPanelClosed(i3, menu);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z16) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onPictureInPictureModeChanged(z16);
        } else {
            super.onPictureInPictureModeChanged(z16);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onPostCreate(bundle);
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onPostResume();
        } else {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i3, Dialog dialog) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onPrepareDialog(i3, dialog);
        } else {
            super.onPrepareDialog(i3, dialog);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onPreparePanel(i3, view, menu);
        }
        return super.onPreparePanel(i3, view, menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onRequestPermissionsResult(i3, strArr, iArr);
        } else {
            super.onRequestPermissionsResult(i3, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onRestart();
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onRestoreInstanceState(bundle);
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onResume();
        } else {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onRetainNonConfigurationInstance();
        }
        return super.onRetainNonConfigurationInstance();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onSaveInstanceState(bundle);
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onStart();
        } else {
            super.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onStateNotSaved();
        } else {
            super.onStateNotSaved();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onStop();
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i3) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onTitleChanged(charSequence, i3);
        } else {
            super.onTitleChanged(charSequence, i3);
        }
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onTrackballEvent(motionEvent);
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onUserLeaveHint();
        } else {
            super.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onWindowFocusChanged(z16);
        } else {
            super.onWindowFocusChanged(z16);
        }
    }

    @Override // android.app.Activity, com.tencent.minibox.dynamic.api.IActivityDelegator
    public void recreate() {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.recreate();
        } else {
            super.recreate();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context, com.tencent.minibox.dynamic.api.IActivityDelegator
    public void setTheme(int i3) {
        if (!this.isBeforeOnCreate) {
            super.setTheme(i3);
        }
    }

    @Override // android.app.Activity, com.tencent.minibox.dynamic.api.IActivityDelegator
    public void startActivityFromChild(Activity activity, Intent intent, int i3) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.startActivityFromChild(activity, intent, i3);
        } else {
            super.startActivityFromChild(activity, intent, i3);
        }
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(17)
    public void superApplyOverrideConfiguration(Configuration configuration) {
        super.applyOverrideConfiguration(configuration);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superAttachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superBindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        return super.bindService(intent, serviceConnection, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superCheckCallingOrSelfPermission(String str) {
        return super.checkCallingOrSelfPermission(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superCheckCallingOrSelfUriPermission(Uri uri, int i3) {
        return super.checkCallingOrSelfUriPermission(uri, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superCheckCallingPermission(String str) {
        return super.checkCallingPermission(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superCheckCallingUriPermission(Uri uri, int i3) {
        return super.checkCallingUriPermission(uri, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superCheckPermission(String str, int i3, int i16) {
        return super.checkPermission(str, i3, i16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public int superCheckSelfPermission(String str) {
        return super.checkSelfPermission(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superCheckUriPermission(Uri uri, int i3, int i16, int i17) {
        return super.checkUriPermission(uri, i3, i16, i17);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superCloseContextMenu() {
        super.closeContextMenu();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(17)
    public Context superCreateConfigurationContext(Configuration configuration) {
        return super.createConfigurationContext(configuration);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public Context superCreateContextForSplit(String str) throws PackageManager.NameNotFoundException {
        return super.createContextForSplit(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public Context superCreateDeviceProtectedStorageContext() {
        return super.createDeviceProtectedStorageContext();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(17)
    public Context superCreateDisplayContext(Display display) {
        return super.createDisplayContext(display);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Context superCreatePackageContext(String str, int i3) throws PackageManager.NameNotFoundException {
        return super.createPackageContext(str, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public PendingIntent superCreatePendingResult(int i3, Intent intent, int i16) {
        return super.createPendingResult(i3, intent, i16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public String[] superDatabaseList() {
        return super.databaseList();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superDeleteDatabase(String str) {
        return super.deleteDatabase(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superDeleteFile(String str) {
        return super.deleteFile(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public boolean superDeleteSharedPreferences(String str) {
        return super.deleteSharedPreferences(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superDismissDialog(int i3) {
        super.dismissDialog(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superDismissKeyboardShortcutsHelper() {
        super.dismissKeyboardShortcutsHelper();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superDispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superEnforceCallingOrSelfPermission(String str, String str2) {
        super.enforceCallingOrSelfPermission(str, str2);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superEnforceCallingOrSelfUriPermission(Uri uri, int i3, String str) {
        super.enforceCallingOrSelfUriPermission(uri, i3, str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superEnforceCallingPermission(String str, String str2) {
        super.enforceCallingPermission(str, str2);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superEnforceCallingUriPermission(Uri uri, int i3, String str) {
        super.enforceCallingUriPermission(uri, i3, str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superEnforcePermission(String str, int i3, int i16, String str2) {
        super.enforcePermission(str, i3, i16, str2);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superEnforceUriPermission(Uri uri, int i3, int i16, int i17, String str) {
        super.enforceUriPermission(uri, i3, i16, i17, str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public String[] superFileList() {
        return super.fileList();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public <T extends View> T superFindViewById(int i3) {
        return (T) super.findViewById(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superFinish() {
        super.finish();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superFinishActivity(int i3) {
        super.finishActivity(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superFinishActivityFromChild(Activity activity, int i3) {
        super.finishActivityFromChild(activity, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superFinishAffinity() {
        super.finishAffinity();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superFinishAfterTransition() {
        super.finishAfterTransition();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superFinishFromChild(Activity activity) {
        super.finishFromChild(activity);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ActionBar superGetActionBar() {
        return super.getActionBar();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Application superGetApplication() {
        return super.getApplication();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Context superGetApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ApplicationInfo superGetApplicationInfo() {
        return super.getApplicationInfo();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public AssetManager superGetAssets() {
        return super.getAssets();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Context superGetBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public File superGetCacheDir() {
        return super.getCacheDir();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ComponentName superGetCallingActivity() {
        return super.getCallingActivity();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public String superGetCallingPackage() {
        return super.getCallingPackage();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ClassLoader superGetClassLoader() {
        return super.getClassLoader();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public File superGetCodeCacheDir() {
        return super.getCodeCacheDir();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ComponentName superGetComponentName() {
        return super.getComponentName();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ContentResolver superGetContentResolver() {
        return super.getContentResolver();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public Scene superGetContentScene() {
        return super.getContentScene();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public TransitionManager superGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public View superGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public File superGetDataDir() {
        return super.getDataDir();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public File superGetDatabasePath(String str) {
        return super.getDatabasePath(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public File superGetDir(String str, int i3) {
        return super.getDir(str, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public File superGetExternalCacheDir() {
        return super.getExternalCacheDir();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(19)
    public File[] superGetExternalCacheDirs() {
        return super.getExternalCacheDirs();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public File superGetExternalFilesDir(String str) {
        return super.getExternalFilesDir(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(19)
    public File[] superGetExternalFilesDirs(String str) {
        return super.getExternalFilesDirs(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public File[] superGetExternalMediaDirs() {
        return super.getExternalMediaDirs();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public File superGetFileStreamPath(String str) {
        return super.getFileStreamPath(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public File superGetFilesDir() {
        return super.getFilesDir();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public FragmentManager superGetFragmentManager() {
        return super.getFragmentManager();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Intent superGetIntent() {
        return super.getIntent();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Object superGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public LayoutInflater superGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public LoaderManager superGetLoaderManager() {
        return super.getLoaderManager();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public String superGetLocalClassName() {
        return super.getLocalClassName();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Looper superGetMainLooper() {
        return super.getMainLooper();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public int superGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public MediaController superGetMediaController() {
        return super.getMediaController();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public MenuInflater superGetMenuInflater() {
        return super.getMenuInflater();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public File superGetNoBackupFilesDir() {
        return super.getNoBackupFilesDir();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public File superGetObbDir() {
        return super.getObbDir();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(19)
    public File[] superGetObbDirs() {
        return super.getObbDirs();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public String superGetPackageCodePath() {
        return super.getPackageCodePath();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public PackageManager superGetPackageManager() {
        return super.getPackageManager();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public String superGetPackageName() {
        return super.getPackageName();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public String superGetPackageResourcePath() {
        return super.getPackageResourcePath();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Activity superGetParent() {
        return super.getParent();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public Intent superGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public SharedPreferences superGetPreferences(int i3) {
        return super.getPreferences(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(22)
    public Uri superGetReferrer() {
        return super.getReferrer();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Resources superGetResources() {
        return super.getResources();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public SearchEvent superGetSearchEvent() {
        return super.getSearchEvent();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public SharedPreferences superGetSharedPreferences(String str, int i3) {
        return super.getSharedPreferences(str, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Object superGetSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public String superGetSystemServiceName(Class<?> cls) {
        return super.getSystemServiceName(cls);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superGetTaskId() {
        return super.getTaskId();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Resources.Theme superGetTheme() {
        return super.getTheme();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public CharSequence superGetTitle() {
        return super.getTitle();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superGetTitleColor() {
        return super.getTitleColor();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public VoiceInteractor superGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superGetVolumeControlStream() {
        return super.getVolumeControlStream();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Drawable superGetWallpaper() {
        return super.getWallpaper();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superGetWallpaperDesiredMinimumHeight() {
        return super.getWallpaperDesiredMinimumHeight();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superGetWallpaperDesiredMinimumWidth() {
        return super.getWallpaperDesiredMinimumWidth();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Window superGetWindow() {
        return super.getWindow();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public WindowManager superGetWindowManager() {
        return super.getWindowManager();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superGrantUriPermission(String str, Uri uri, int i3) {
        super.grantUriPermission(str, uri, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superHasWindowFocus() {
        return super.hasWindowFocus();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public boolean superIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superIsChild() {
        return super.isChild();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(17)
    public boolean superIsDestroyed() {
        return super.isDestroyed();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public boolean superIsDeviceProtectedStorage() {
        return super.isDeviceProtectedStorage();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superIsFinishing() {
        return super.isFinishing();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(18)
    public boolean superIsImmersive() {
        return super.isImmersive();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public boolean superIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public boolean superIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public boolean superIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superIsRestricted() {
        return super.isRestricted();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superIsTaskRoot() {
        return super.isTaskRoot();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public boolean superIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public boolean superIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public boolean superMoveDatabaseFrom(Context context, String str) {
        return super.moveDatabaseFrom(context, str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public boolean superMoveSharedPreferencesFrom(Context context, String str) {
        return super.moveSharedPreferencesFrom(context, str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superMoveTaskToBack(boolean z16) {
        return super.moveTaskToBack(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public boolean superNavigateUpTo(Intent intent) {
        return super.navigateUpTo(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public boolean superNavigateUpToFromChild(Activity activity, Intent intent) {
        return super.navigateUpToFromChild(activity, intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superOnActivityReenter(int i3, Intent intent) {
        super.onActivityReenter(i3, intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnApplyThemeResource(Resources.Theme theme, int i3, boolean z16) {
        super.onApplyThemeResource(theme, i3, z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnContentChanged() {
        super.onContentChanged();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public CharSequence superOnCreateDescription() {
        return super.onCreateDescription();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Dialog superOnCreateDialog(int i3) {
        return super.onCreateDialog(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnCreatePanelMenu(int i3, Menu menu) {
        return super.onCreatePanelMenu(i3, menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public View superOnCreatePanelView(int i3) {
        return super.onCreatePanelView(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public View superOnCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superOnEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnKeyDown(int i3, KeyEvent keyEvent) {
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnKeyLongPress(int i3, KeyEvent keyEvent) {
        return super.onKeyLongPress(i3, keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        return super.onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnKeyShortcut(int i3, KeyEvent keyEvent) {
        return super.onKeyShortcut(i3, keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnKeyUp(int i3, KeyEvent keyEvent) {
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superOnLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superOnLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnLowMemory() {
        super.onLowMemory();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnMenuItemSelected(int i3, MenuItem menuItem) {
        return super.onMenuItemSelected(i3, menuItem);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnMenuOpened(int i3, Menu menu) {
        return super.onMenuOpened(i3, menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public void superOnMultiWindowModeChanged(boolean z16, Configuration configuration) {
        super.onMultiWindowModeChanged(z16, configuration);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public boolean superOnNavigateUp() {
        return super.onNavigateUp();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public boolean superOnNavigateUpFromChild(Activity activity) {
        return super.onNavigateUpFromChild(activity);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnPanelClosed(int i3, Menu menu) {
        super.onPanelClosed(i3, menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnPause() {
        super.onPause();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public void superOnPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        super.onPictureInPictureModeChanged(z16, configuration);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public void superOnPointerCaptureChanged(boolean z16) {
        super.onPointerCaptureChanged(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnPostResume() {
        super.onPostResume();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnPrepareDialog(int i3, Dialog dialog) {
        super.onPrepareDialog(i3, dialog);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnPreparePanel(int i3, View view, Menu menu) {
        return super.onPreparePanel(i3, view, menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public void superOnProvideAssistContent(AssistContent assistContent) {
        super.onProvideAssistContent(assistContent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(18)
    public void superOnProvideAssistData(Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3) {
        super.onProvideKeyboardShortcuts(list, menu, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public Uri superOnProvideReferrer() {
        return super.onProvideReferrer();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public void superOnRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnRestart() {
        super.onRestart();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnResume() {
        super.onResume();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Object superOnRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public boolean superOnSearchRequested(SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnStart() {
        super.onStart();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public void superOnStateNotSaved() {
        super.onStateNotSaved();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnStop() {
        super.onStop();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnTitleChanged(CharSequence charSequence, int i3) {
        super.onTitleChanged(charSequence, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnTrimMemory(int i3) {
        super.onTrimMemory(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnUserInteraction() {
        super.onUserInteraction();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superOnVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ActionMode superOnWindowStartingActionMode(ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOpenContextMenu(View view) {
        super.openContextMenu(view);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public FileInputStream superOpenFileInput(String str) throws FileNotFoundException {
        return super.openFileInput(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public FileOutputStream superOpenFileOutput(String str, int i3) throws FileNotFoundException {
        return super.openFileOutput(str, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public SQLiteDatabase superOpenOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory) {
        return super.openOrCreateDatabase(str, i3, cursorFactory);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOverridePendingTransition(int i3, int i16) {
        super.overridePendingTransition(i3, i16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Drawable superPeekWallpaper() {
        return super.peekWallpaper();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superPostponeEnterTransition() {
        super.postponeEnterTransition();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superRecreate() {
        super.recreate();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superRegisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.registerComponentCallbacks(componentCallbacks);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return super.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public boolean superReleaseInstance() {
        return super.releaseInstance();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superRemoveDialog(int i3) {
        super.removeDialog(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @SuppressLint({"MissingPermission"})
    public void superRemoveStickyBroadcast(Intent intent) {
        super.removeStickyBroadcast(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @SuppressLint({"MissingPermission"})
    @TargetApi(17)
    public void superRemoveStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.removeStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(19)
    public void superReportFullyDrawn() {
        super.reportFullyDrawn();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public DragAndDropPermissions superRequestDragAndDropPermissions(DragEvent dragEvent) {
        return super.requestDragAndDropPermissions(dragEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superRequestShowKeyboardShortcuts() {
        super.requestShowKeyboardShortcuts();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public boolean superRequestVisibleBehind(boolean z16) {
        return super.requestVisibleBehind(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superRequestWindowFeature(int i3) {
        return super.requestWindowFeature(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superRevokeUriPermission(Uri uri, int i3) {
        super.revokeUriPermission(uri, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superRunOnUiThread(Runnable runnable) {
        super.runOnUiThread(runnable);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSendBroadcast(Intent intent) {
        super.sendBroadcast(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @SuppressLint({"MissingPermission"})
    @TargetApi(17)
    public void superSendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.sendBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSendOrderedBroadcast(Intent intent, String str) {
        super.sendOrderedBroadcast(intent, str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @SuppressLint({"MissingPermission"})
    public void superSendStickyBroadcast(Intent intent) {
        super.sendStickyBroadcast(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @SuppressLint({"MissingPermission"})
    @TargetApi(17)
    public void superSendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.sendStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @SuppressLint({"MissingPermission"})
    public void superSendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
        super.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i3, str, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @SuppressLint({"MissingPermission"})
    @TargetApi(17)
    public void superSendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
        super.sendStickyOrderedBroadcastAsUser(intent, userHandle, broadcastReceiver, handler, i3, str, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superSetActionBar(Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superSetContentTransitionManager(TransitionManager transitionManager) {
        super.setContentTransitionManager(transitionManager);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetContentView(int i3) {
        super.setContentView(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetDefaultKeyMode(int i3) {
        super.setDefaultKeyMode(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superSetExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setExitSharedElementCallback(sharedElementCallback);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetFeatureDrawable(int i3, Drawable drawable) {
        super.setFeatureDrawable(i3, drawable);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetFeatureDrawableAlpha(int i3, int i16) {
        super.setFeatureDrawableAlpha(i3, i16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetFeatureDrawableResource(int i3, int i16) {
        super.setFeatureDrawableResource(i3, i16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetFeatureDrawableUri(int i3, Uri uri) {
        super.setFeatureDrawableUri(i3, uri);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetFinishOnTouchOutside(boolean z16) {
        super.setFinishOnTouchOutside(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(18)
    public void superSetImmersive(boolean z16) {
        super.setImmersive(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetIntent(Intent intent) {
        super.setIntent(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superSetMediaController(MediaController mediaController) {
        super.setMediaController(mediaController);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public void superSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        super.setPictureInPictureParams(pictureInPictureParams);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetProgress(int i3) {
        super.setProgress(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetProgressBarIndeterminate(boolean z16) {
        super.setProgressBarIndeterminate(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetProgressBarIndeterminateVisibility(boolean z16) {
        super.setProgressBarIndeterminateVisibility(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetProgressBarVisibility(boolean z16) {
        super.setProgressBarVisibility(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetRequestedOrientation(int i3) {
        super.setRequestedOrientation(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetResult(int i3) {
        super.setResult(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetSecondaryProgress(int i3) {
        super.setSecondaryProgress(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(27)
    public void superSetShowWhenLocked(boolean z16) {
        super.setShowWhenLocked(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetTheme(int i3) {
        super.setTheme(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetTitleColor(int i3) {
        super.setTitleColor(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(27)
    public void superSetTurnScreenOn(boolean z16) {
        super.setTurnScreenOn(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetVisible(boolean z16) {
        super.setVisible(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetVolumeControlStream(int i3) {
        super.setVolumeControlStream(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superSetVrModeEnabled(boolean z16, ComponentName componentName) throws PackageManager.NameNotFoundException {
        super.setVrModeEnabled(z16, componentName);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetWallpaper(Bitmap bitmap) throws IOException {
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public boolean superShouldShowRequestPermissionRationale(String str) {
        return super.shouldShowRequestPermissionRationale(str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public boolean superShouldUpRecreateTask(Intent intent) {
        return super.shouldUpRecreateTask(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public boolean superShowAssist(Bundle bundle) {
        return super.showAssist(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superShowDialog(int i3) {
        super.showDialog(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public void superShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ActionMode superStartActionMode(ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartActivityForResult(Intent intent, int i3) {
        super.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartActivityFromChild(Activity activity, Intent intent, int i3) {
        super.startActivityFromChild(activity, intent, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartActivityFromFragment(Fragment fragment, Intent intent, int i3) {
        super.startActivityFromFragment(fragment, intent, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superStartActivityIfNeeded(Intent intent, int i3) {
        return super.startActivityIfNeeded(intent, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public ComponentName superStartForegroundService(Intent intent) {
        return super.startForegroundService(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superStartInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return super.startInstrumentation(componentName, str, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17) throws IntentSender.SendIntentException {
        super.startIntentSender(intentSender, intent, i3, i16, i17);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(activity, intentSender, i3, intent, i16, i17, i18);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superStartLocalVoiceInteraction(Bundle bundle) {
        super.startLocalVoiceInteraction(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superStartLockTask() {
        super.startLockTask();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartManagingCursor(Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superStartNextMatchingActivity(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStartSearch(String str, boolean z16, Bundle bundle, boolean z17) {
        super.startSearch(str, z16, bundle, z17);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public ComponentName superStartService(Intent intent) {
        return super.startService(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superStopLockTask() {
        super.stopLockTask();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superStopManagingCursor(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superStopService(Intent intent) {
        return super.stopService(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superTakeKeyEvents(boolean z16) {
        super.takeKeyEvents(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superTriggerSearch(String str, Bundle bundle) {
        super.triggerSearch(str, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superUnbindService(ServiceConnection serviceConnection) {
        super.unbindService(serviceConnection);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superUnregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superUnregisterReceiver(BroadcastReceiver broadcastReceiver) {
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public int superCheckUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17) {
        return super.checkUriPermission(uri, str, str2, i3, i16, i17);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superEnforceUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17, String str3) {
        super.enforceUriPermission(uri, str, str2, i3, i16, i17, str3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public boolean superEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superOnCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Dialog superOnCreateDialog(int i3, Bundle bundle) {
        return super.onCreateDialog(i3, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public View superOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superOnMultiWindowModeChanged(boolean z16) {
        super.onMultiWindowModeChanged(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(24)
    public void superOnPictureInPictureModeChanged(boolean z16) {
        super.onPictureInPictureModeChanged(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superOnPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onPostCreate(bundle, persistableBundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superOnPrepareDialog(int i3, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i3, dialog, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(21)
    public void superOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superOnSearchRequested() {
        return super.onSearchRequested();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public ActionMode superOnWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        return super.onWindowStartingActionMode(callback, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public SQLiteDatabase superOpenOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return super.openOrCreateDatabase(str, i3, cursorFactory, databaseErrorHandler);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i3) {
        return super.registerReceiver(broadcastReceiver, intentFilter, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public void superRevokeUriPermission(String str, Uri uri, int i3) {
        super.revokeUriPermission(str, uri, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSendBroadcast(Intent intent, String str) {
        super.sendBroadcast(intent, str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @SuppressLint({"MissingPermission"})
    @TargetApi(17)
    public void superSendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        super.sendBroadcastAsUser(intent, userHandle, str);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        super.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetContentView(View view) {
        super.setContentView(view);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetResult(int i3, Intent intent) {
        super.setResult(i3, intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetTitle(int i3) {
        super.setTitle(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetWallpaper(InputStream inputStream) throws IOException {
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public boolean superShowDialog(int i3, Bundle bundle) {
        return super.showDialog(i3, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(23)
    public ActionMode superStartActionMode(ActionMode.Callback callback, int i3) {
        return super.startActionMode(callback, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superStartActivities(Intent[] intentArr, Bundle bundle) {
        super.startActivities(intentArr, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superStartActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superStartActivityForResult(Intent intent, int i3, Bundle bundle) {
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superStartActivityFromChild(Activity activity, Intent intent, int i3, Bundle bundle) {
        super.startActivityFromChild(activity, intent, i3, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superStartActivityFromFragment(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i3, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public boolean superStartActivityIfNeeded(Intent intent, int i3, Bundle bundle) {
        return super.startActivityIfNeeded(intent, i3, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superStartIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSender(intentSender, intent, i3, i16, i17, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superStartIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public void superStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(activity, intentSender, i3, intent, i16, i17, i18, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(16)
    public boolean superStartNextMatchingActivity(Intent intent, Bundle bundle) {
        return super.startNextMatchingActivity(intent, bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            return iActivityDelegate.onCreateView(view, str, context, attributeSet);
        }
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z16, Configuration configuration) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onMultiWindowModeChanged(z16, configuration);
        } else {
            super.onMultiWindowModeChanged(z16, configuration);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        IActivityDelegate iActivityDelegate = this.mDelegateImpl;
        if (iActivityDelegate != null) {
            iActivityDelegate.onPictureInPictureModeChanged(z16, configuration);
        } else {
            super.onPictureInPictureModeChanged(z16, configuration);
        }
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    @TargetApi(26)
    public Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i3) {
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public Activity getDelegatorActivity() {
        return this;
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superClearWallpaper() throws IOException {
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superRequestPermissions(String[] strArr, int i3) {
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegator
    public void superSendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
    }
}
