package com.tencent.shadow.core.runtime.container;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Dialog;
import android.app.DirectAction;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.PictureInPictureUiState;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.AttributionSource;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextParams;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.LocusId;
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
import android.os.CancellationSignal;
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
import android.window.SplashScreen;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
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
import java.util.concurrent.Executor;
import java.util.function.Consumer;

@SuppressLint({"NewApi", "MissingPermission"})
/* loaded from: classes25.dex */
abstract class GeneratedPluginContainerActivity extends Activity implements GeneratedHostActivityDelegator {
    GeneratedHostActivityDelegate hostActivityDelegate;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.dispatchGenericMotionEvent(motionEvent);
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.dispatchKeyShortcutEvent(keyEvent);
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            dispatchTouchEvent = generatedHostActivityDelegate.dispatchTouchEvent(motionEvent);
        } else {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.dispatchTrackballEvent(motionEvent);
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void finish() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.finish();
        } else {
            super.finish();
        }
    }

    @Override // android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ComponentName getCallingActivity() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.getCallingActivity();
        }
        return super.getCallingActivity();
    }

    @Override // android.content.ContextWrapper, android.content.Context, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ClassLoader getClassLoader() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.getClassLoader();
        }
        return super.getClassLoader();
    }

    @Override // android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public LayoutInflater getLayoutInflater() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.getLayoutInflater();
        }
        return super.getLayoutInflater();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Resources getResources() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.getResources();
        }
        return super.getResources();
    }

    @Override // android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean isChangingConfigurations() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.isChangingConfigurations();
        }
        return super.isChangingConfigurations();
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onActionModeFinished(ActionMode actionMode) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onActionModeFinished(actionMode);
        } else {
            super.onActionModeFinished(actionMode);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onActionModeStarted(ActionMode actionMode) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onActionModeStarted(actionMode);
        } else {
            super.onActionModeStarted(actionMode);
        }
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i3, Intent intent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onActivityReenter(i3, intent);
        } else {
            super.onActivityReenter(i3, intent);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onActivityResult(i3, i16, intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme theme, int i3, boolean z16) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onApplyThemeResource(theme, i3, z16);
        } else {
            super.onApplyThemeResource(theme, i3, z16);
        }
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onAttachFragment(fragment);
        } else {
            super.onAttachFragment(fragment);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onAttachedToWindow() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onChildTitleChanged(activity, charSequence);
        } else {
            super.onChildTitleChanged(activity, charSequence);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onContentChanged() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onContentChanged();
        } else {
            super.onContentChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onContextItemSelected(menuItem);
        }
        return super.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onContextMenuClosed(menu);
        } else {
            super.onContextMenuClosed(menu);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onCreate(bundle, persistableBundle);
        } else {
            super.onCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreateDescription();
        }
        return super.onCreateDescription();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3, Bundle bundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreateDialog(i3, bundle);
        }
        return super.onCreateDialog(i3, bundle);
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onCreateNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onCreateNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreateOptionsMenu(menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreatePanelMenu(i3, menu);
        }
        return super.onCreatePanelMenu(i3, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public View onCreatePanelView(int i3) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreatePanelView(i3);
        }
        return super.onCreatePanelView(i3);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreateThumbnail(bitmap, canvas);
        }
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreateView(view, str, context, attributeSet);
        }
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onDetachedFromWindow() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onEnterAnimationComplete();
        } else {
            super.onEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onGenericMotionEvent(motionEvent);
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer<List<DirectAction>> consumer) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onGetDirectActions(cancellationSignal, consumer);
        } else {
            super.onGetDirectActions(cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onKeyDown(i3, keyEvent);
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i3, KeyEvent keyEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onKeyLongPress(i3, keyEvent);
        }
        return super.onKeyLongPress(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onKeyMultiple(i3, i16, keyEvent);
        }
        return super.onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i3, KeyEvent keyEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onKeyShortcut(i3, keyEvent);
        }
        return super.onKeyShortcut(i3, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onKeyUp(i3, keyEvent);
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onLocalVoiceInteractionStarted();
        } else {
            super.onLocalVoiceInteractionStarted();
        }
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onLocalVoiceInteractionStopped();
        } else {
            super.onLocalVoiceInteractionStopped();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onMenuItemSelected(i3, menuItem);
        }
        return super.onMenuItemSelected(i3, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean onMenuOpened(int i3, Menu menu) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onMenuOpened(i3, menu);
        }
        return super.onMenuOpened(i3, menu);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z16, Configuration configuration) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onMultiWindowModeChanged(z16, configuration);
        } else {
            super.onMultiWindowModeChanged(z16, configuration);
        }
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onNavigateUp();
        }
        return super.onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onNavigateUpFromChild(activity);
        }
        return super.onNavigateUpFromChild(activity);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onNewIntent(intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onOptionsItemSelected(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onOptionsMenuClosed(menu);
        } else {
            super.onOptionsMenuClosed(menu);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onPanelClosed(int i3, Menu menu) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPanelClosed(i3, menu);
        } else {
            super.onPanelClosed(i3, menu);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPause();
        } else {
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer<Bundle> consumer) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        } else {
            super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPictureInPictureModeChanged(z16, configuration);
        } else {
            super.onPictureInPictureModeChanged(z16, configuration);
        }
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onPictureInPictureRequested();
        }
        return super.onPictureInPictureRequested();
    }

    @Override // android.app.Activity
    public void onPictureInPictureUiStateChanged(PictureInPictureUiState pictureInPictureUiState) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPictureInPictureUiStateChanged(pictureInPictureUiState);
        } else {
            super.onPictureInPictureUiStateChanged(pictureInPictureUiState);
        }
    }

    @Override // android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onPointerCaptureChanged(boolean z16) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPointerCaptureChanged(z16);
        } else {
            super.onPointerCaptureChanged(z16);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPostCreate(bundle, persistableBundle);
        } else {
            super.onPostCreate(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPostResume();
        } else {
            super.onPostResume();
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i3, Dialog dialog, Bundle bundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPrepareDialog(i3, dialog, bundle);
        } else {
            super.onPrepareDialog(i3, dialog, bundle);
        }
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPrepareNavigateUpTaskStack(taskStackBuilder);
        } else {
            super.onPrepareNavigateUpTaskStack(taskStackBuilder);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onPrepareOptionsMenu(menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onPreparePanel(i3, view, menu);
        }
        return super.onPreparePanel(i3, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onProvideAssistContent(assistContent);
        } else {
            super.onProvideAssistContent(assistContent);
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onProvideAssistData(bundle);
        } else {
            super.onProvideAssistData(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onProvideKeyboardShortcuts(list, menu, i3);
        } else {
            super.onProvideKeyboardShortcuts(list, menu, i3);
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onProvideReferrer();
        }
        return super.onProvideReferrer();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onRequestPermissionsResult(i3, strArr, iArr);
        } else {
            super.onRequestPermissionsResult(i3, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onRestart();
        } else {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onRestoreInstanceState(bundle, persistableBundle);
        } else {
            super.onRestoreInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onResume();
        } else {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onRetainNonConfigurationInstance();
        }
        return super.onRetainNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onSaveInstanceState(bundle, persistableBundle);
        } else {
            super.onSaveInstanceState(bundle, persistableBundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean onSearchRequested(SearchEvent searchEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onSearchRequested(searchEvent);
        }
        return super.onSearchRequested(searchEvent);
    }

    @Override // android.app.Activity
    protected void onStart() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onStart();
        } else {
            super.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onStateNotSaved();
        } else {
            super.onStateNotSaved();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onStop();
        } else {
            super.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i3) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onTitleChanged(charSequence, i3);
        } else {
            super.onTitleChanged(charSequence, i3);
        }
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z16) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onTopResumedActivityChanged(z16);
        } else {
            super.onTopResumedActivityChanged(z16);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onTrackballEvent(motionEvent);
        }
        return super.onTrackballEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onTrimMemory(i3);
        } else {
            super.onTrimMemory(i3);
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onUserLeaveHint();
        } else {
            super.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onVisibleBehindCanceled();
        } else {
            super.onVisibleBehindCanceled();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onWindowAttributesChanged(layoutParams);
        } else {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void onWindowFocusChanged(boolean z16) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onWindowFocusChanged(z16);
        } else {
            super.onWindowFocusChanged(z16);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onWindowStartingActionMode(callback);
        }
        return super.onWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void recreate() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.recreate();
        } else {
            super.recreate();
        }
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superApplyOverrideConfiguration(Configuration configuration) {
        super.applyOverrideConfiguration(configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superAttachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superBindIsolatedService(Intent intent, int i3, String str, Executor executor, ServiceConnection serviceConnection) {
        return super.bindIsolatedService(intent, i3, str, executor, serviceConnection);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superBindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        return super.bindService(intent, serviceConnection, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superBindServiceAsUser(Intent intent, ServiceConnection serviceConnection, int i3, UserHandle userHandle) {
        return super.bindServiceAsUser(intent, serviceConnection, i3, userHandle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superCheckCallingOrSelfPermission(String str) {
        return super.checkCallingOrSelfPermission(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superCheckCallingOrSelfUriPermission(Uri uri, int i3) {
        return super.checkCallingOrSelfUriPermission(uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int[] superCheckCallingOrSelfUriPermissions(List<Uri> list, int i3) {
        return super.checkCallingOrSelfUriPermissions(list, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superCheckCallingPermission(String str) {
        return super.checkCallingPermission(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superCheckCallingUriPermission(Uri uri, int i3) {
        return super.checkCallingUriPermission(uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int[] superCheckCallingUriPermissions(List<Uri> list, int i3) {
        return super.checkCallingUriPermissions(list, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superCheckPermission(String str, int i3, int i16) {
        return super.checkPermission(str, i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superCheckSelfPermission(String str) {
        return super.checkSelfPermission(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superCheckUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17) {
        return super.checkUriPermission(uri, str, str2, i3, i16, i17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int[] superCheckUriPermissions(List<Uri> list, int i3, int i16, int i17) {
        return super.checkUriPermissions(list, i3, i16, i17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superClearWallpaper() throws IOException {
        super.clearWallpaper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superCloseContextMenu() {
        super.closeContextMenu();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superCloseOptionsMenu() {
        super.closeOptionsMenu();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreateAttributionContext(String str) {
        return super.createAttributionContext(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreateConfigurationContext(Configuration configuration) {
        return super.createConfigurationContext(configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreateContext(ContextParams contextParams) {
        return super.createContext(contextParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreateContextForSplit(String str) throws PackageManager.NameNotFoundException {
        return super.createContextForSplit(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreateDeviceProtectedStorageContext() {
        return super.createDeviceProtectedStorageContext();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreateDisplayContext(Display display) {
        return super.createDisplayContext(display);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreatePackageContext(String str, int i3) throws PackageManager.NameNotFoundException {
        return super.createPackageContext(str, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public PendingIntent superCreatePendingResult(int i3, Intent intent, int i16) {
        return super.createPendingResult(i3, intent, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreateWindowContext(Display display, int i3, Bundle bundle) {
        return super.createWindowContext(display, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String[] superDatabaseList() {
        return super.databaseList();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDeleteDatabase(String str) {
        return super.deleteDatabase(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDeleteFile(String str) {
        return super.deleteFile(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDeleteSharedPreferences(String str) {
        return super.deleteSharedPreferences(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superDismissDialog(int i3) {
        super.dismissDialog(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superDismissKeyboardShortcutsHelper() {
        super.dismissKeyboardShortcutsHelper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superDispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superEnforceCallingOrSelfPermission(String str, String str2) {
        super.enforceCallingOrSelfPermission(str, str2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superEnforceCallingOrSelfUriPermission(Uri uri, int i3, String str) {
        super.enforceCallingOrSelfUriPermission(uri, i3, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superEnforceCallingPermission(String str, String str2) {
        super.enforceCallingPermission(str, str2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superEnforceCallingUriPermission(Uri uri, int i3, String str) {
        super.enforceCallingUriPermission(uri, i3, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superEnforcePermission(String str, int i3, int i16, String str2) {
        super.enforcePermission(str, i3, i16, str2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superEnforceUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17, String str3) {
        super.enforceUriPermission(uri, str, str2, i3, i16, i17, str3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        return super.enterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String[] superFileList() {
        return super.fileList();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public <T extends View> T superFindViewById(int i3) {
        return (T) super.findViewById(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superFinish() {
        super.finish();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superFinishActivity(int i3) {
        super.finishActivity(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superFinishActivityFromChild(Activity activity, int i3) {
        super.finishActivityFromChild(activity, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superFinishAffinity() {
        super.finishAffinity();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superFinishAfterTransition() {
        super.finishAfterTransition();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superFinishAndRemoveTask() {
        super.finishAndRemoveTask();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superFinishFromChild(Activity activity) {
        super.finishFromChild(activity);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ActionBar superGetActionBar() {
        return super.getActionBar();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Application superGetApplication() {
        return super.getApplication();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superGetApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ApplicationInfo superGetApplicationInfo() {
        return super.getApplicationInfo();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public AssetManager superGetAssets() {
        return super.getAssets();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public AttributionSource superGetAttributionSource() {
        return super.getAttributionSource();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String superGetAttributionTag() {
        return super.getAttributionTag();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superGetBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetCacheDir() {
        return super.getCacheDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ComponentName superGetCallingActivity() {
        return super.getCallingActivity();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String superGetCallingPackage() {
        return super.getCallingPackage();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superGetChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ClassLoader superGetClassLoader() {
        return super.getClassLoader();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetCodeCacheDir() {
        return super.getCodeCacheDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ComponentName superGetComponentName() {
        return super.getComponentName();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ContentResolver superGetContentResolver() {
        return super.getContentResolver();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Scene superGetContentScene() {
        return super.getContentScene();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public TransitionManager superGetContentTransitionManager() {
        return super.getContentTransitionManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public View superGetCurrentFocus() {
        return super.getCurrentFocus();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetDataDir() {
        return super.getDataDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetDatabasePath(String str) {
        return super.getDatabasePath(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetDir(String str, int i3) {
        return super.getDir(str, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Display superGetDisplay() {
        return super.getDisplay();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetExternalCacheDir() {
        return super.getExternalCacheDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File[] superGetExternalCacheDirs() {
        return super.getExternalCacheDirs();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetExternalFilesDir(String str) {
        return super.getExternalFilesDir(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File[] superGetExternalFilesDirs(String str) {
        return super.getExternalFilesDirs(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File[] superGetExternalMediaDirs() {
        return super.getExternalMediaDirs();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetFileStreamPath(String str) {
        return super.getFileStreamPath(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetFilesDir() {
        return super.getFilesDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public FragmentManager superGetFragmentManager() {
        return super.getFragmentManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Intent superGetIntent() {
        return super.getIntent();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Object superGetLastNonConfigurationInstance() {
        return super.getLastNonConfigurationInstance();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public LayoutInflater superGetLayoutInflater() {
        return super.getLayoutInflater();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public LoaderManager superGetLoaderManager() {
        return super.getLoaderManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String superGetLocalClassName() {
        return super.getLocalClassName();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Executor superGetMainExecutor() {
        return super.getMainExecutor();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Looper superGetMainLooper() {
        return super.getMainLooper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superGetMaxNumPictureInPictureActions() {
        return super.getMaxNumPictureInPictureActions();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public MediaController superGetMediaController() {
        return super.getMediaController();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public MenuInflater superGetMenuInflater() {
        return super.getMenuInflater();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetNoBackupFilesDir() {
        return super.getNoBackupFilesDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File superGetObbDir() {
        return super.getObbDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public File[] superGetObbDirs() {
        return super.getObbDirs();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String superGetOpPackageName() {
        return super.getOpPackageName();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String superGetPackageCodePath() {
        return super.getPackageCodePath();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public PackageManager superGetPackageManager() {
        return super.getPackageManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String superGetPackageName() {
        return super.getPackageName();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String superGetPackageResourcePath() {
        return super.getPackageResourcePath();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ContextParams superGetParams() {
        return super.getParams();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Activity superGetParent() {
        return super.getParent();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Intent superGetParentActivityIntent() {
        return super.getParentActivityIntent();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public SharedPreferences superGetPreferences(int i3) {
        return super.getPreferences(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Uri superGetReferrer() {
        return super.getReferrer();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superGetRequestedOrientation() {
        return super.getRequestedOrientation();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Resources superGetResources() {
        return super.getResources();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public SearchEvent superGetSearchEvent() {
        return super.getSearchEvent();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public SharedPreferences superGetSharedPreferences(String str, int i3) {
        return super.getSharedPreferences(str, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public SplashScreen superGetSplashScreen() {
        return super.getSplashScreen();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Object superGetSystemService(String str) {
        return super.getSystemService(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public String superGetSystemServiceName(Class<?> cls) {
        return super.getSystemServiceName(cls);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superGetTaskId() {
        return super.getTaskId();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Resources.Theme superGetTheme() {
        return super.getTheme();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public CharSequence superGetTitle() {
        return super.getTitle();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superGetTitleColor() {
        return super.getTitleColor();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public VoiceInteractor superGetVoiceInteractor() {
        return super.getVoiceInteractor();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superGetVolumeControlStream() {
        return super.getVolumeControlStream();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Drawable superGetWallpaper() {
        return super.getWallpaper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superGetWallpaperDesiredMinimumHeight() {
        return super.getWallpaperDesiredMinimumHeight();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superGetWallpaperDesiredMinimumWidth() {
        return super.getWallpaperDesiredMinimumWidth();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Window superGetWindow() {
        return super.getWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public WindowManager superGetWindowManager() {
        return super.getWindowManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superGrantUriPermission(String str, Uri uri, int i3) {
        super.grantUriPermission(str, uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superHasWindowFocus() {
        return super.hasWindowFocus();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superInvalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsActivityTransitionRunning() {
        return super.isActivityTransitionRunning();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsChild() {
        return super.isChild();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsDestroyed() {
        return super.isDestroyed();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsDeviceProtectedStorage() {
        return super.isDeviceProtectedStorage();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsFinishing() {
        return super.isFinishing();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsImmersive() {
        return super.isImmersive();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsInPictureInPictureMode() {
        return super.isInPictureInPictureMode();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsLaunchedFromBubble() {
        return super.isLaunchedFromBubble();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsLocalVoiceInteractionSupported() {
        return super.isLocalVoiceInteractionSupported();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsRestricted() {
        return super.isRestricted();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsTaskRoot() {
        return super.isTaskRoot();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsUiContext() {
        return super.isUiContext();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsVoiceInteraction() {
        return super.isVoiceInteraction();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superIsVoiceInteractionRoot() {
        return super.isVoiceInteractionRoot();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Cursor superManagedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return super.managedQuery(uri, strArr, str, strArr2, str2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superMoveDatabaseFrom(Context context, String str) {
        return super.moveDatabaseFrom(context, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superMoveSharedPreferencesFrom(Context context, String str) {
        return super.moveSharedPreferencesFrom(context, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superMoveTaskToBack(boolean z16) {
        return super.moveTaskToBack(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superNavigateUpTo(Intent intent) {
        return super.navigateUpTo(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superNavigateUpToFromChild(Activity activity, Intent intent) {
        return super.navigateUpToFromChild(activity, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnActivityReenter(int i3, Intent intent) {
        super.onActivityReenter(i3, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnApplyThemeResource(Resources.Theme theme, int i3, boolean z16) {
        super.onApplyThemeResource(theme, i3, z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.onChildTitleChanged(activity, charSequence);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnContentChanged() {
        super.onContentChanged();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public CharSequence superOnCreateDescription() {
        return super.onCreateDescription();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Dialog superOnCreateDialog(int i3, Bundle bundle) {
        return super.onCreateDialog(i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnCreatePanelMenu(int i3, Menu menu) {
        return super.onCreatePanelMenu(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public View superOnCreatePanelView(int i3) {
        return super.onCreatePanelView(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public View superOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnGetDirectActions(CancellationSignal cancellationSignal, Consumer<List<DirectAction>> consumer) {
        super.onGetDirectActions(cancellationSignal, consumer);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnKeyDown(int i3, KeyEvent keyEvent) {
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnKeyLongPress(int i3, KeyEvent keyEvent) {
        return super.onKeyLongPress(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        return super.onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnKeyShortcut(int i3, KeyEvent keyEvent) {
        return super.onKeyShortcut(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnKeyUp(int i3, KeyEvent keyEvent) {
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnLowMemory() {
        super.onLowMemory();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnMenuItemSelected(int i3, MenuItem menuItem) {
        return super.onMenuItemSelected(i3, menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnMenuOpened(int i3, Menu menu) {
        return super.onMenuOpened(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnMultiWindowModeChanged(boolean z16, Configuration configuration) {
        super.onMultiWindowModeChanged(z16, configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnNavigateUp() {
        return super.onNavigateUp();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnNavigateUpFromChild(Activity activity) {
        return super.onNavigateUpFromChild(activity);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPanelClosed(int i3, Menu menu) {
        super.onPanelClosed(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPause() {
        super.onPause();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer<Bundle> consumer) {
        super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        super.onPictureInPictureModeChanged(z16, configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnPictureInPictureRequested() {
        return super.onPictureInPictureRequested();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPictureInPictureUiStateChanged(PictureInPictureUiState pictureInPictureUiState) {
        super.onPictureInPictureUiStateChanged(pictureInPictureUiState);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPointerCaptureChanged(boolean z16) {
        super.onPointerCaptureChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onPostCreate(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPostResume() {
        super.onPostResume();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPrepareDialog(int i3, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i3, dialog, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnPreparePanel(int i3, View view, Menu menu) {
        return super.onPreparePanel(i3, view, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnProvideAssistContent(AssistContent assistContent) {
        super.onProvideAssistContent(assistContent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnProvideAssistData(Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3) {
        super.onProvideKeyboardShortcuts(list, menu, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Uri superOnProvideReferrer() {
        return super.onProvideReferrer();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnRestart() {
        super.onRestart();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnResume() {
        super.onResume();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Object superOnRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnSearchRequested(SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnStart() {
        super.onStart();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnStateNotSaved() {
        super.onStateNotSaved();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnStop() {
        super.onStop();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnTitleChanged(CharSequence charSequence, int i3) {
        super.onTitleChanged(charSequence, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnTopResumedActivityChanged(boolean z16) {
        super.onTopResumedActivityChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnTrimMemory(int i3) {
        super.onTrimMemory(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnUserInteraction() {
        super.onUserInteraction();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ActionMode superOnWindowStartingActionMode(ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOpenContextMenu(View view) {
        super.openContextMenu(view);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public FileInputStream superOpenFileInput(String str) throws FileNotFoundException {
        return super.openFileInput(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public FileOutputStream superOpenFileOutput(String str, int i3) throws FileNotFoundException {
        return super.openFileOutput(str, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOpenOptionsMenu() {
        super.openOptionsMenu();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public SQLiteDatabase superOpenOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return super.openOrCreateDatabase(str, i3, cursorFactory, databaseErrorHandler);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOverridePendingTransition(int i3, int i16) {
        super.overridePendingTransition(i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Drawable superPeekWallpaper() {
        return super.peekWallpaper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superPostponeEnterTransition() {
        super.postponeEnterTransition();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRecreate() {
        super.recreate();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRegisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.registerComponentCallbacks(componentCallbacks);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRegisterForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return super.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superReleaseInstance() {
        return super.releaseInstance();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRemoveDialog(int i3) {
        super.removeDialog(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRemoveStickyBroadcast(Intent intent) {
        super.removeStickyBroadcast(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRemoveStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.removeStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superReportFullyDrawn() {
        super.reportFullyDrawn();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public DragAndDropPermissions superRequestDragAndDropPermissions(DragEvent dragEvent) {
        return super.requestDragAndDropPermissions(dragEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRequestPermissions(String[] strArr, int i3) {
        PermissionMonitor.requestPermissions(this, strArr, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRequestShowKeyboardShortcuts() {
        super.requestShowKeyboardShortcuts();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superRequestVisibleBehind(boolean z16) {
        return super.requestVisibleBehind(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superRequestWindowFeature(int i3) {
        return super.requestWindowFeature(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public <T extends View> T superRequireViewById(int i3) {
        return (T) super.requireViewById(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRevokeUriPermission(String str, Uri uri, int i3) {
        super.revokeUriPermission(str, uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRunOnUiThread(Runnable runnable) {
        super.runOnUiThread(runnable);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendBroadcast(Intent intent, String str) {
        super.sendBroadcast(intent, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        super.sendBroadcastAsUser(intent, userHandle, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendBroadcastWithMultiplePermissions(Intent intent, String[] strArr) {
        super.sendBroadcastWithMultiplePermissions(intent, strArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendOrderedBroadcast(Intent intent, String str, String str2, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str3, Bundle bundle) {
        super.sendOrderedBroadcast(intent, str, str2, broadcastReceiver, handler, i3, str3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        super.sendOrderedBroadcastAsUser(intent, userHandle, str, broadcastReceiver, handler, i3, str2, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendStickyBroadcast(Intent intent) {
        super.sendStickyBroadcast(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.sendStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
        super.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i3, str, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
        super.sendStickyOrderedBroadcastAsUser(intent, userHandle, broadcastReceiver, handler, i3, str, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetActionBar(Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetContentTransitionManager(TransitionManager transitionManager) {
        super.setContentTransitionManager(transitionManager);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetDefaultKeyMode(int i3) {
        super.setDefaultKeyMode(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.setExitSharedElementCallback(sharedElementCallback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetFeatureDrawable(int i3, Drawable drawable) {
        super.setFeatureDrawable(i3, drawable);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetFeatureDrawableAlpha(int i3, int i16) {
        super.setFeatureDrawableAlpha(i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetFeatureDrawableResource(int i3, int i16) {
        super.setFeatureDrawableResource(i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetFeatureDrawableUri(int i3, Uri uri) {
        super.setFeatureDrawableUri(i3, uri);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetFinishOnTouchOutside(boolean z16) {
        super.setFinishOnTouchOutside(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetImmersive(boolean z16) {
        super.setImmersive(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetInheritShowWhenLocked(boolean z16) {
        super.setInheritShowWhenLocked(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetIntent(Intent intent) {
        super.setIntent(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetLocusContext(LocusId locusId, Bundle bundle) {
        super.setLocusContext(locusId, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetMediaController(MediaController mediaController) {
        super.setMediaController(mediaController);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        super.setPictureInPictureParams(pictureInPictureParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetProgress(int i3) {
        super.setProgress(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetProgressBarIndeterminate(boolean z16) {
        super.setProgressBarIndeterminate(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetProgressBarIndeterminateVisibility(boolean z16) {
        super.setProgressBarIndeterminateVisibility(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetProgressBarVisibility(boolean z16) {
        super.setProgressBarVisibility(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetRequestedOrientation(int i3) {
        super.setRequestedOrientation(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetResult(int i3) {
        super.setResult(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetSecondaryProgress(int i3) {
        super.setSecondaryProgress(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetShowWhenLocked(boolean z16) {
        super.setShowWhenLocked(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.setTaskDescription(taskDescription);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetTheme(int i3) {
        super.setTheme(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetTitleColor(int i3) {
        super.setTitleColor(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superSetTranslucent(boolean z16) {
        return super.setTranslucent(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetTurnScreenOn(boolean z16) {
        super.setTurnScreenOn(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetVisible(boolean z16) {
        super.setVisible(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetVolumeControlStream(int i3) {
        super.setVolumeControlStream(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetVrModeEnabled(boolean z16, ComponentName componentName) throws PackageManager.NameNotFoundException {
        super.setVrModeEnabled(z16, componentName);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetWallpaper(Bitmap bitmap) throws IOException {
        super.setWallpaper(bitmap);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superShouldShowRequestPermissionRationale(String str) {
        return super.shouldShowRequestPermissionRationale(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superShouldUpRecreateTask(Intent intent) {
        return super.shouldUpRecreateTask(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superShowAssist(Bundle bundle) {
        return super.showAssist(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superShowDialog(int i3, Bundle bundle) {
        return super.showDialog(i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superShowLockTaskEscapeMessage() {
        super.showLockTaskEscapeMessage();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ActionMode superStartActionMode(ActionMode.Callback callback, int i3) {
        return super.startActionMode(callback, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivityForResult(Intent intent, int i3, Bundle bundle) {
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivityFromChild(Activity activity, Intent intent, int i3, Bundle bundle) {
        super.startActivityFromChild(activity, intent, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivityFromFragment(Fragment fragment, Intent intent, int i3) {
        super.startActivityFromFragment(fragment, intent, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superStartActivityIfNeeded(Intent intent, int i3, Bundle bundle) {
        return super.startActivityIfNeeded(intent, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ComponentName superStartForegroundService(Intent intent) {
        return super.startForegroundService(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superStartInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return super.startInstrumentation(componentName, str, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17) throws IntentSender.SendIntentException {
        super.startIntentSender(intentSender, intent, i3, i16, i17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(activity, intentSender, i3, intent, i16, i17, i18);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartLocalVoiceInteraction(Bundle bundle) {
        super.startLocalVoiceInteraction(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartLockTask() {
        super.startLockTask();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartManagingCursor(Cursor cursor) {
        super.startManagingCursor(cursor);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superStartNextMatchingActivity(Intent intent) {
        return super.startNextMatchingActivity(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartPostponedEnterTransition() {
        super.startPostponedEnterTransition();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartSearch(String str, boolean z16, Bundle bundle, boolean z17) {
        super.startSearch(str, z16, bundle, z17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ComponentName superStartService(Intent intent) {
        return super.startService(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStopLocalVoiceInteraction() {
        super.stopLocalVoiceInteraction();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStopLockTask() {
        super.stopLockTask();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStopManagingCursor(Cursor cursor) {
        super.stopManagingCursor(cursor);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superStopService(Intent intent) {
        return super.stopService(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superTakeKeyEvents(boolean z16) {
        super.takeKeyEvents(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superTriggerSearch(String str, Bundle bundle) {
        super.triggerSearch(str, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superUnbindService(ServiceConnection serviceConnection) {
        super.unbindService(serviceConnection);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superUnregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superUnregisterForContextMenu(View view) {
        super.unregisterForContextMenu(view);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superUnregisterReceiver(BroadcastReceiver broadcastReceiver) {
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superUpdateServiceGroup(ServiceConnection serviceConnection, int i3, int i16) {
        super.updateServiceGroup(serviceConnection, i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superBindService(Intent intent, int i3, Executor executor, ServiceConnection serviceConnection) {
        return super.bindService(intent, i3, executor, serviceConnection);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public int superCheckUriPermission(Uri uri, int i3, int i16, int i17) {
        return super.checkUriPermission(uri, i3, i16, i17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Context superCreateWindowContext(int i3, Bundle bundle) {
        return super.createWindowContext(i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superEnforceUriPermission(Uri uri, int i3, int i16, int i17, String str) {
        super.enforceUriPermission(uri, i3, i16, i17, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superEnterPictureInPictureMode() {
        super.enterPictureInPictureMode();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Dialog superOnCreateDialog(int i3) {
        return super.onCreateDialog(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public View superOnCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnMultiWindowModeChanged(boolean z16) {
        super.onMultiWindowModeChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPictureInPictureModeChanged(boolean z16) {
        super.onPictureInPictureModeChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnPrepareDialog(int i3, Dialog dialog) {
        super.onPrepareDialog(i3, dialog);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superOnSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superOnSearchRequested() {
        return super.onSearchRequested();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ActionMode superOnWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        return super.onWindowStartingActionMode(callback, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public SQLiteDatabase superOpenOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory) {
        return super.openOrCreateDatabase(str, i3, cursorFactory);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superRevokeUriPermission(Uri uri, int i3) {
        super.revokeUriPermission(uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendBroadcast(Intent intent) {
        super.sendBroadcast(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.sendBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        super.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendStickyBroadcast(Intent intent, Bundle bundle) {
        super.sendStickyBroadcast(intent, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetContentView(View view) {
        super.setContentView(view);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetResult(int i3, Intent intent) {
        super.setResult(i3, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetTheme(Resources.Theme theme) {
        super.setTheme(theme);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetTitle(int i3) {
        super.setTitle(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetWallpaper(InputStream inputStream) throws IOException {
        super.setWallpaper(inputStream);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superShowDialog(int i3) {
        super.showDialog(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ActionMode superStartActionMode(ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivities(Intent[] intentArr, Bundle bundle) {
        super.startActivities(intentArr, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivityForResult(Intent intent, int i3) {
        super.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivityFromChild(Activity activity, Intent intent, int i3) {
        super.startActivityFromChild(activity, intent, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartActivityFromFragment(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superStartActivityIfNeeded(Intent intent, int i3) {
        return super.startActivityIfNeeded(intent, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSender(intentSender, intent, i3, i16, i17, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderFromChild(activity, intentSender, i3, intent, i16, i17, i18, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean superStartNextMatchingActivity(Intent intent, Bundle bundle) {
        return super.startNextMatchingActivity(intent, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i3) {
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendOrderedBroadcast(Intent intent, String str) {
        super.sendOrderedBroadcast(intent, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSetContentView(int i3) {
        super.setContentView(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onCreate(bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreateDialog(i3);
        }
        return super.onCreateDialog(i3);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onCreateView(str, context, attributeSet);
        }
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onMultiWindowModeChanged(z16);
        } else {
            super.onMultiWindowModeChanged(z16);
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z16) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPictureInPictureModeChanged(z16);
        } else {
            super.onPictureInPictureModeChanged(z16);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPostCreate(bundle);
        } else {
            super.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i3, Dialog dialog) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onPrepareDialog(i3, dialog);
        } else {
            super.onPrepareDialog(i3, dialog);
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onRestoreInstanceState(bundle);
        } else {
            super.onRestoreInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            generatedHostActivityDelegate.onSaveInstanceState(bundle);
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public boolean onSearchRequested() {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onSearchRequested();
        }
        return super.onSearchRequested();
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        GeneratedHostActivityDelegate generatedHostActivityDelegate = this.hostActivityDelegate;
        if (generatedHostActivityDelegate != null) {
            return generatedHostActivityDelegate.onWindowStartingActionMode(callback, i3);
        }
        return super.onWindowStartingActionMode(callback, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i3) {
        return super.registerReceiver(broadcastReceiver, intentFilter, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void superSendOrderedBroadcast(Intent intent, int i3, String str, String str2, BroadcastReceiver broadcastReceiver, Handler handler, String str3, Bundle bundle, Bundle bundle2) {
        super.sendOrderedBroadcast(intent, i3, str, str2, broadcastReceiver, handler, str3, bundle, bundle2);
    }
}
