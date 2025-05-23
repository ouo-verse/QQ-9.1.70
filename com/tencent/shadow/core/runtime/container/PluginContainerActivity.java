package com.tencent.shadow.core.runtime.container;

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
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.shadow.core.container.BuildConfig;
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

/* loaded from: classes25.dex */
public class PluginContainerActivity extends GeneratedPluginContainerActivity implements HostActivity, HostActivityDelegator {
    private static final String TAG = "ShadowTag.Container";
    HostActivityDelegate hostActivityDelegate;
    private boolean isBeforeOnCreate = true;
    private Resources.Theme mHostTheme;

    /* JADX WARN: Multi-variable type inference failed */
    public PluginContainerActivity() {
        HostActivityDelegate hostActivityDelegate;
        Log.e(TAG, "PluginContainerActivity");
        DelegateProvider delegateProvider = DelegateProviderHolder.getDelegateProvider(getDelegateProviderKey());
        if (delegateProvider != 0) {
            hostActivityDelegate = delegateProvider.getHostActivityDelegate(getClass());
            hostActivityDelegate.setDelegator(this);
        } else {
            Log.e(TAG, "PluginContainerActivity: DelegateProviderHolder\u6ca1\u6709\u521d\u59cb\u5316");
            hostActivityDelegate = null;
        }
        super.hostActivityDelegate = hostActivityDelegate;
        this.hostActivityDelegate = hostActivityDelegate;
        Log.e(TAG, "PluginContainerActivity end");
    }

    private boolean isIllegalIntent(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null && bundle == null) {
            return true;
        }
        if (bundle == null) {
            bundle = extras;
        }
        try {
            String string = bundle.getString("LOADER_VERSION");
            long j3 = bundle.getLong("PROCESS_ID_KEY");
            Log.i(TAG, "isIllegalIntent, processVersion: " + j3 + ", DelegateProviderHolder pid: " + DelegateProviderHolder.sCustomPid);
            if (!BuildConfig.VERSION_NAME.equals(string)) {
                return true;
            }
            if (j3 != DelegateProviderHolder.sCustomPid) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return true;
        }
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ComponentName getCallingActivity() {
        return super.getCallingActivity();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.content.ContextWrapper, android.content.Context, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ClassLoader getClassLoader() {
        return super.getClassLoader();
    }

    protected String getDelegateProviderKey() {
        return DelegateProviderHolder.DEFAULT_KEY;
    }

    @Override // com.tencent.shadow.core.runtime.container.HostActivity
    public Window getImplementWindow() {
        return getWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ LayoutInflater getLayoutInflater() {
        return super.getLayoutInflater();
    }

    public final Object getPluginActivity() {
        HostActivityDelegate hostActivityDelegate = this.hostActivityDelegate;
        if (hostActivityDelegate != null) {
            return hostActivityDelegate.getPluginActivity();
        }
        return null;
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Resources getResources() {
        return super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public Resources.Theme getTheme() {
        if (this.isBeforeOnCreate) {
            if (this.mHostTheme == null) {
                this.mHostTheme = super.getResources().newTheme();
            }
            return this.mHostTheme;
        }
        return super.getTheme();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean isChangingConfigurations() {
        return super.isChangingConfigurations();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onActivityReenter(int i3, Intent intent) {
        super.onActivityReenter(i3, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onContentChanged() {
        super.onContentChanged();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.View.OnCreateContextMenuListener
    public /* bridge */ /* synthetic */ void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ CharSequence onCreateDescription() {
        return super.onCreateDescription();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean onCreatePanelMenu(int i3, Menu menu) {
        return super.onCreatePanelMenu(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ View onCreatePanelView(int i3) {
        return super.onCreatePanelView(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.onCreateThumbnail(bitmap, canvas);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        super.onGetDirectActions(cancellationSignal, consumer);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i3, KeyEvent keyEvent) {
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyLongPress(int i3, KeyEvent keyEvent) {
        return super.onKeyLongPress(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        return super.onKeyMultiple(i3, i16, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onKeyShortcut(int i3, KeyEvent keyEvent) {
        return super.onKeyShortcut(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i3, KeyEvent keyEvent) {
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onLocalVoiceInteractionStarted() {
        super.onLocalVoiceInteractionStarted();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onLocalVoiceInteractionStopped() {
        super.onLocalVoiceInteractionStopped();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        return super.onMenuItemSelected(i3, menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean onMenuOpened(int i3, Menu menu) {
        return super.onMenuOpened(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onMultiWindowModeChanged(boolean z16) {
        super.onMultiWindowModeChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onNavigateUp() {
        return super.onNavigateUp();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onNavigateUpFromChild(Activity activity) {
        return super.onNavigateUpFromChild(activity);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onPanelClosed(int i3, Menu menu) {
        super.onPanelClosed(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        super.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onPictureInPictureModeChanged(boolean z16) {
        super.onPictureInPictureModeChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onPictureInPictureRequested() {
        return super.onPictureInPictureRequested();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onPictureInPictureUiStateChanged(PictureInPictureUiState pictureInPictureUiState) {
        super.onPictureInPictureUiStateChanged(pictureInPictureUiState);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onPointerCaptureChanged(boolean z16) {
        super.onPointerCaptureChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onPostCreate(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean onPreparePanel(int i3, View view, Menu menu) {
        return super.onPreparePanel(i3, view, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onProvideAssistContent(AssistContent assistContent) {
        super.onProvideAssistContent(assistContent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onProvideAssistData(Bundle bundle) {
        super.onProvideAssistData(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onProvideKeyboardShortcuts(List list, Menu menu, int i3) {
        super.onProvideKeyboardShortcuts(list, menu, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ Uri onProvideReferrer() {
        return super.onProvideReferrer();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ Object onRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean onSearchRequested() {
        return super.onSearchRequested();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onStateNotSaved() {
        super.onStateNotSaved();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onTopResumedActivityChanged(boolean z16) {
        super.onTopResumedActivityChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onTrackballEvent(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.content.ComponentCallbacks2
    public /* bridge */ /* synthetic */ void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onUserInteraction() {
        super.onUserInteraction();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onVisibleBehindCanceled() {
        super.onVisibleBehindCanceled();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void recreate() {
        super.recreate();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public void setTheme(int i3) {
        if (!this.isBeforeOnCreate) {
            super.setTheme(i3);
        }
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superAddContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.superAddContentView(view, layoutParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superApplyOverrideConfiguration(Configuration configuration) {
        super.superApplyOverrideConfiguration(configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superAttachBaseContext(Context context) {
        super.superAttachBaseContext(context);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superBindIsolatedService(Intent intent, int i3, String str, Executor executor, ServiceConnection serviceConnection) {
        return super.superBindIsolatedService(intent, i3, str, executor, serviceConnection);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superBindService(Intent intent, int i3, Executor executor, ServiceConnection serviceConnection) {
        return super.superBindService(intent, i3, executor, serviceConnection);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superBindServiceAsUser(Intent intent, ServiceConnection serviceConnection, int i3, UserHandle userHandle) {
        return super.superBindServiceAsUser(intent, serviceConnection, i3, userHandle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superCheckCallingOrSelfPermission(String str) {
        return super.superCheckCallingOrSelfPermission(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superCheckCallingOrSelfUriPermission(Uri uri, int i3) {
        return super.superCheckCallingOrSelfUriPermission(uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int[] superCheckCallingOrSelfUriPermissions(List list, int i3) {
        return super.superCheckCallingOrSelfUriPermissions(list, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superCheckCallingPermission(String str) {
        return super.superCheckCallingPermission(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superCheckCallingUriPermission(Uri uri, int i3) {
        return super.superCheckCallingUriPermission(uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int[] superCheckCallingUriPermissions(List list, int i3) {
        return super.superCheckCallingUriPermissions(list, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superCheckPermission(String str, int i3, int i16) {
        return super.superCheckPermission(str, i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superCheckSelfPermission(String str) {
        return super.superCheckSelfPermission(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superCheckUriPermission(Uri uri, int i3, int i16, int i17) {
        return super.superCheckUriPermission(uri, i3, i16, i17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int[] superCheckUriPermissions(List list, int i3, int i16, int i17) {
        return super.superCheckUriPermissions(list, i3, i16, i17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superClearWallpaper() throws IOException {
        super.superClearWallpaper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superCloseContextMenu() {
        super.superCloseContextMenu();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superCloseOptionsMenu() {
        super.superCloseOptionsMenu();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreateAttributionContext(String str) {
        return super.superCreateAttributionContext(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreateConfigurationContext(Configuration configuration) {
        return super.superCreateConfigurationContext(configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreateContext(ContextParams contextParams) {
        return super.superCreateContext(contextParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreateContextForSplit(String str) throws PackageManager.NameNotFoundException {
        return super.superCreateContextForSplit(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreateDeviceProtectedStorageContext() {
        return super.superCreateDeviceProtectedStorageContext();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreateDisplayContext(Display display) {
        return super.superCreateDisplayContext(display);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreatePackageContext(String str, int i3) throws PackageManager.NameNotFoundException {
        return super.superCreatePackageContext(str, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ PendingIntent superCreatePendingResult(int i3, Intent intent, int i16) {
        return super.superCreatePendingResult(i3, intent, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreateWindowContext(int i3, Bundle bundle) {
        return super.superCreateWindowContext(i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String[] superDatabaseList() {
        return super.superDatabaseList();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDeleteDatabase(String str) {
        return super.superDeleteDatabase(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDeleteFile(String str) {
        return super.superDeleteFile(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDeleteSharedPreferences(String str) {
        return super.superDeleteSharedPreferences(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superDismissDialog(int i3) {
        super.superDismissDialog(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superDismissKeyboardShortcutsHelper() {
        super.superDismissKeyboardShortcutsHelper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.superDispatchGenericMotionEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.superDispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.superDispatchKeyShortcutEvent(keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.superDispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return super.superDispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superDispatchTrackballEvent(MotionEvent motionEvent) {
        return super.superDispatchTrackballEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.superDump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superEnforceCallingOrSelfPermission(String str, String str2) {
        super.superEnforceCallingOrSelfPermission(str, str2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superEnforceCallingOrSelfUriPermission(Uri uri, int i3, String str) {
        super.superEnforceCallingOrSelfUriPermission(uri, i3, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superEnforceCallingPermission(String str, String str2) {
        super.superEnforceCallingPermission(str, str2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superEnforceCallingUriPermission(Uri uri, int i3, String str) {
        super.superEnforceCallingUriPermission(uri, i3, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superEnforcePermission(String str, int i3, int i16, String str2) {
        super.superEnforcePermission(str, i3, i16, str2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superEnforceUriPermission(Uri uri, int i3, int i16, int i17, String str) {
        super.superEnforceUriPermission(uri, i3, i16, i17, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superEnterPictureInPictureMode() {
        super.superEnterPictureInPictureMode();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String[] superFileList() {
        return super.superFileList();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ View superFindViewById(int i3) {
        return super.superFindViewById(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superFinish() {
        super.superFinish();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superFinishActivity(int i3) {
        super.superFinishActivity(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superFinishActivityFromChild(Activity activity, int i3) {
        super.superFinishActivityFromChild(activity, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superFinishAffinity() {
        super.superFinishAffinity();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superFinishAfterTransition() {
        super.superFinishAfterTransition();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superFinishAndRemoveTask() {
        super.superFinishAndRemoveTask();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superFinishFromChild(Activity activity) {
        super.superFinishFromChild(activity);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ActionBar superGetActionBar() {
        return super.superGetActionBar();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Application superGetApplication() {
        return super.superGetApplication();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superGetApplicationContext() {
        return super.superGetApplicationContext();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ApplicationInfo superGetApplicationInfo() {
        return super.superGetApplicationInfo();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ AssetManager superGetAssets() {
        return super.superGetAssets();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ AttributionSource superGetAttributionSource() {
        return super.superGetAttributionSource();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String superGetAttributionTag() {
        return super.superGetAttributionTag();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superGetBaseContext() {
        return super.superGetBaseContext();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetCacheDir() {
        return super.superGetCacheDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ComponentName superGetCallingActivity() {
        return super.superGetCallingActivity();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String superGetCallingPackage() {
        return super.superGetCallingPackage();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superGetChangingConfigurations() {
        return super.superGetChangingConfigurations();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ClassLoader superGetClassLoader() {
        return super.superGetClassLoader();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetCodeCacheDir() {
        return super.superGetCodeCacheDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ComponentName superGetComponentName() {
        return super.superGetComponentName();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ContentResolver superGetContentResolver() {
        return super.superGetContentResolver();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Scene superGetContentScene() {
        return super.superGetContentScene();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ TransitionManager superGetContentTransitionManager() {
        return super.superGetContentTransitionManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ View superGetCurrentFocus() {
        return super.superGetCurrentFocus();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetDataDir() {
        return super.superGetDataDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetDatabasePath(String str) {
        return super.superGetDatabasePath(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetDir(String str, int i3) {
        return super.superGetDir(str, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Display superGetDisplay() {
        return super.superGetDisplay();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetExternalCacheDir() {
        return super.superGetExternalCacheDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File[] superGetExternalCacheDirs() {
        return super.superGetExternalCacheDirs();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetExternalFilesDir(String str) {
        return super.superGetExternalFilesDir(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File[] superGetExternalFilesDirs(String str) {
        return super.superGetExternalFilesDirs(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File[] superGetExternalMediaDirs() {
        return super.superGetExternalMediaDirs();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetFileStreamPath(String str) {
        return super.superGetFileStreamPath(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetFilesDir() {
        return super.superGetFilesDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ FragmentManager superGetFragmentManager() {
        return super.superGetFragmentManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Intent superGetIntent() {
        return super.superGetIntent();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Object superGetLastNonConfigurationInstance() {
        return super.superGetLastNonConfigurationInstance();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ LayoutInflater superGetLayoutInflater() {
        return super.superGetLayoutInflater();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ LoaderManager superGetLoaderManager() {
        return super.superGetLoaderManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String superGetLocalClassName() {
        return super.superGetLocalClassName();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Executor superGetMainExecutor() {
        return super.superGetMainExecutor();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Looper superGetMainLooper() {
        return super.superGetMainLooper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superGetMaxNumPictureInPictureActions() {
        return super.superGetMaxNumPictureInPictureActions();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ MediaController superGetMediaController() {
        return super.superGetMediaController();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ MenuInflater superGetMenuInflater() {
        return super.superGetMenuInflater();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetNoBackupFilesDir() {
        return super.superGetNoBackupFilesDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File superGetObbDir() {
        return super.superGetObbDir();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ File[] superGetObbDirs() {
        return super.superGetObbDirs();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String superGetOpPackageName() {
        return super.superGetOpPackageName();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String superGetPackageCodePath() {
        return super.superGetPackageCodePath();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ PackageManager superGetPackageManager() {
        return super.superGetPackageManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String superGetPackageName() {
        return super.superGetPackageName();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String superGetPackageResourcePath() {
        return super.superGetPackageResourcePath();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ContextParams superGetParams() {
        return super.superGetParams();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Activity superGetParent() {
        return super.superGetParent();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Intent superGetParentActivityIntent() {
        return super.superGetParentActivityIntent();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ SharedPreferences superGetPreferences(int i3) {
        return super.superGetPreferences(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Uri superGetReferrer() {
        return super.superGetReferrer();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superGetRequestedOrientation() {
        return super.superGetRequestedOrientation();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Resources superGetResources() {
        return super.superGetResources();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ SearchEvent superGetSearchEvent() {
        return super.superGetSearchEvent();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ SharedPreferences superGetSharedPreferences(String str, int i3) {
        return super.superGetSharedPreferences(str, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ SplashScreen superGetSplashScreen() {
        return super.superGetSplashScreen();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Object superGetSystemService(String str) {
        return super.superGetSystemService(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ String superGetSystemServiceName(Class cls) {
        return super.superGetSystemServiceName(cls);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superGetTaskId() {
        return super.superGetTaskId();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Resources.Theme superGetTheme() {
        return super.superGetTheme();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ CharSequence superGetTitle() {
        return super.superGetTitle();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superGetTitleColor() {
        return super.superGetTitleColor();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ VoiceInteractor superGetVoiceInteractor() {
        return super.superGetVoiceInteractor();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superGetVolumeControlStream() {
        return super.superGetVolumeControlStream();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Drawable superGetWallpaper() {
        return super.superGetWallpaper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superGetWallpaperDesiredMinimumHeight() {
        return super.superGetWallpaperDesiredMinimumHeight();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superGetWallpaperDesiredMinimumWidth() {
        return super.superGetWallpaperDesiredMinimumWidth();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Window superGetWindow() {
        return super.superGetWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ WindowManager superGetWindowManager() {
        return super.superGetWindowManager();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superGrantUriPermission(String str, Uri uri, int i3) {
        super.superGrantUriPermission(str, uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superHasWindowFocus() {
        return super.superHasWindowFocus();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superInvalidateOptionsMenu() {
        super.superInvalidateOptionsMenu();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsActivityTransitionRunning() {
        return super.superIsActivityTransitionRunning();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsChangingConfigurations() {
        return super.superIsChangingConfigurations();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsChild() {
        return super.superIsChild();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsDestroyed() {
        return super.superIsDestroyed();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsDeviceProtectedStorage() {
        return super.superIsDeviceProtectedStorage();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsFinishing() {
        return super.superIsFinishing();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsImmersive() {
        return super.superIsImmersive();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsInMultiWindowMode() {
        return super.superIsInMultiWindowMode();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsInPictureInPictureMode() {
        return super.superIsInPictureInPictureMode();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsLaunchedFromBubble() {
        return super.superIsLaunchedFromBubble();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsLocalVoiceInteractionSupported() {
        return super.superIsLocalVoiceInteractionSupported();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsRestricted() {
        return super.superIsRestricted();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsTaskRoot() {
        return super.superIsTaskRoot();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsUiContext() {
        return super.superIsUiContext();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsVoiceInteraction() {
        return super.superIsVoiceInteraction();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superIsVoiceInteractionRoot() {
        return super.superIsVoiceInteractionRoot();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Cursor superManagedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return super.superManagedQuery(uri, strArr, str, strArr2, str2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superMoveDatabaseFrom(Context context, String str) {
        return super.superMoveDatabaseFrom(context, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superMoveSharedPreferencesFrom(Context context, String str) {
        return super.superMoveSharedPreferencesFrom(context, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superMoveTaskToBack(boolean z16) {
        return super.superMoveTaskToBack(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superNavigateUpTo(Intent intent) {
        return super.superNavigateUpTo(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superNavigateUpToFromChild(Activity activity, Intent intent) {
        return super.superNavigateUpToFromChild(activity, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnActionModeFinished(ActionMode actionMode) {
        super.superOnActionModeFinished(actionMode);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnActionModeStarted(ActionMode actionMode) {
        super.superOnActionModeStarted(actionMode);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnActivityReenter(int i3, Intent intent) {
        super.superOnActivityReenter(i3, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnActivityResult(int i3, int i16, Intent intent) {
        super.superOnActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnApplyThemeResource(Resources.Theme theme, int i3, boolean z16) {
        super.superOnApplyThemeResource(theme, i3, z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnAttachFragment(Fragment fragment) {
        super.superOnAttachFragment(fragment);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnAttachedToWindow() {
        super.superOnAttachedToWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnBackPressed() {
        super.superOnBackPressed();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnChildTitleChanged(Activity activity, CharSequence charSequence) {
        super.superOnChildTitleChanged(activity, charSequence);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnConfigurationChanged(Configuration configuration) {
        super.superOnConfigurationChanged(configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnContentChanged() {
        super.superOnContentChanged();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnContextItemSelected(MenuItem menuItem) {
        return super.superOnContextItemSelected(menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnContextMenuClosed(Menu menu) {
        super.superOnContextMenuClosed(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnCreate(Bundle bundle) {
        super.superOnCreate(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.superOnCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ CharSequence superOnCreateDescription() {
        return super.superOnCreateDescription();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Dialog superOnCreateDialog(int i3) {
        return super.superOnCreateDialog(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.superOnCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnCreateOptionsMenu(Menu menu) {
        return super.superOnCreateOptionsMenu(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnCreatePanelMenu(int i3, Menu menu) {
        return super.superOnCreatePanelMenu(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ View superOnCreatePanelView(int i3) {
        return super.superOnCreatePanelView(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return super.superOnCreateThumbnail(bitmap, canvas);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ View superOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.superOnCreateView(view, str, context, attributeSet);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnDestroy() {
        super.superOnDestroy();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnDetachedFromWindow() {
        super.superOnDetachedFromWindow();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnEnterAnimationComplete() {
        super.superOnEnterAnimationComplete();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnGenericMotionEvent(MotionEvent motionEvent) {
        return super.superOnGenericMotionEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        super.superOnGetDirectActions(cancellationSignal, consumer);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnKeyDown(int i3, KeyEvent keyEvent) {
        return super.superOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnKeyLongPress(int i3, KeyEvent keyEvent) {
        return super.superOnKeyLongPress(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        return super.superOnKeyMultiple(i3, i16, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnKeyShortcut(int i3, KeyEvent keyEvent) {
        return super.superOnKeyShortcut(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnKeyUp(int i3, KeyEvent keyEvent) {
        return super.superOnKeyUp(i3, keyEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnLocalVoiceInteractionStarted() {
        super.superOnLocalVoiceInteractionStarted();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnLocalVoiceInteractionStopped() {
        super.superOnLocalVoiceInteractionStopped();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnLowMemory() {
        super.superOnLowMemory();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnMenuItemSelected(int i3, MenuItem menuItem) {
        return super.superOnMenuItemSelected(i3, menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnMenuOpened(int i3, Menu menu) {
        return super.superOnMenuOpened(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnMultiWindowModeChanged(boolean z16) {
        super.superOnMultiWindowModeChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnNavigateUp() {
        return super.superOnNavigateUp();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnNavigateUpFromChild(Activity activity) {
        return super.superOnNavigateUpFromChild(activity);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnNewIntent(Intent intent) {
        super.superOnNewIntent(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnOptionsItemSelected(MenuItem menuItem) {
        return super.superOnOptionsItemSelected(menuItem);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnOptionsMenuClosed(Menu menu) {
        super.superOnOptionsMenuClosed(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPanelClosed(int i3, Menu menu) {
        super.superOnPanelClosed(i3, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPause() {
        super.superOnPause();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        super.superOnPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPictureInPictureModeChanged(boolean z16) {
        super.superOnPictureInPictureModeChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnPictureInPictureRequested() {
        return super.superOnPictureInPictureRequested();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPictureInPictureUiStateChanged(PictureInPictureUiState pictureInPictureUiState) {
        super.superOnPictureInPictureUiStateChanged(pictureInPictureUiState);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPointerCaptureChanged(boolean z16) {
        super.superOnPointerCaptureChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPostCreate(Bundle bundle) {
        super.superOnPostCreate(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPostResume() {
        super.superOnPostResume();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPrepareDialog(int i3, Dialog dialog) {
        super.superOnPrepareDialog(i3, dialog);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        super.superOnPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnPrepareOptionsMenu(Menu menu) {
        return super.superOnPrepareOptionsMenu(menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnPreparePanel(int i3, View view, Menu menu) {
        return super.superOnPreparePanel(i3, view, menu);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnProvideAssistContent(AssistContent assistContent) {
        super.superOnProvideAssistContent(assistContent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnProvideAssistData(Bundle bundle) {
        super.superOnProvideAssistData(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnProvideKeyboardShortcuts(List list, Menu menu, int i3) {
        super.superOnProvideKeyboardShortcuts(list, menu, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Uri superOnProvideReferrer() {
        return super.superOnProvideReferrer();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.superOnRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnRestart() {
        super.superOnRestart();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnRestoreInstanceState(Bundle bundle) {
        super.superOnRestoreInstanceState(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnResume() {
        super.superOnResume();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Object superOnRetainNonConfigurationInstance() {
        return super.superOnRetainNonConfigurationInstance();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnSaveInstanceState(Bundle bundle) {
        super.superOnSaveInstanceState(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnSearchRequested() {
        return super.superOnSearchRequested();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnStart() {
        super.superOnStart();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnStateNotSaved() {
        super.superOnStateNotSaved();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnStop() {
        super.superOnStop();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnTitleChanged(CharSequence charSequence, int i3) {
        super.superOnTitleChanged(charSequence, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnTopResumedActivityChanged(boolean z16) {
        super.superOnTopResumedActivityChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnTouchEvent(MotionEvent motionEvent) {
        return super.superOnTouchEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnTrackballEvent(MotionEvent motionEvent) {
        return super.superOnTrackballEvent(motionEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnTrimMemory(int i3) {
        super.superOnTrimMemory(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnUserInteraction() {
        super.superOnUserInteraction();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnUserLeaveHint() {
        super.superOnUserLeaveHint();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnVisibleBehindCanceled() {
        super.superOnVisibleBehindCanceled();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.superOnWindowAttributesChanged(layoutParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnWindowFocusChanged(boolean z16) {
        super.superOnWindowFocusChanged(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ActionMode superOnWindowStartingActionMode(ActionMode.Callback callback) {
        return super.superOnWindowStartingActionMode(callback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOpenContextMenu(View view) {
        super.superOpenContextMenu(view);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ FileInputStream superOpenFileInput(String str) throws FileNotFoundException {
        return super.superOpenFileInput(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ FileOutputStream superOpenFileOutput(String str, int i3) throws FileNotFoundException {
        return super.superOpenFileOutput(str, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOpenOptionsMenu() {
        super.superOpenOptionsMenu();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ SQLiteDatabase superOpenOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory) {
        return super.superOpenOrCreateDatabase(str, i3, cursorFactory);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOverridePendingTransition(int i3, int i16) {
        super.superOverridePendingTransition(i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Drawable superPeekWallpaper() {
        return super.superPeekWallpaper();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superPostponeEnterTransition() {
        super.superPostponeEnterTransition();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRecreate() {
        super.superRecreate();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.superRegisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRegisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.superRegisterComponentCallbacks(componentCallbacks);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRegisterForContextMenu(View view) {
        super.superRegisterForContextMenu(view);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return super.superRegisterReceiver(broadcastReceiver, intentFilter);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superReleaseInstance() {
        return super.superReleaseInstance();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRemoveDialog(int i3) {
        super.superRemoveDialog(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRemoveStickyBroadcast(Intent intent) {
        super.superRemoveStickyBroadcast(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRemoveStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.superRemoveStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superReportFullyDrawn() {
        super.superReportFullyDrawn();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ DragAndDropPermissions superRequestDragAndDropPermissions(DragEvent dragEvent) {
        return super.superRequestDragAndDropPermissions(dragEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRequestPermissions(String[] strArr, int i3) {
        super.superRequestPermissions(strArr, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRequestShowKeyboardShortcuts() {
        super.superRequestShowKeyboardShortcuts();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superRequestVisibleBehind(boolean z16) {
        return super.superRequestVisibleBehind(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superRequestWindowFeature(int i3) {
        return super.superRequestWindowFeature(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ View superRequireViewById(int i3) {
        return super.superRequireViewById(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRevokeUriPermission(Uri uri, int i3) {
        super.superRevokeUriPermission(uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRunOnUiThread(Runnable runnable) {
        super.superRunOnUiThread(runnable);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendBroadcast(Intent intent) {
        super.superSendBroadcast(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.superSendBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendBroadcastWithMultiplePermissions(Intent intent, String[] strArr) {
        super.superSendBroadcastWithMultiplePermissions(intent, strArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendOrderedBroadcast(Intent intent, int i3, String str, String str2, BroadcastReceiver broadcastReceiver, Handler handler, String str3, Bundle bundle, Bundle bundle2) {
        super.superSendOrderedBroadcast(intent, i3, str, str2, broadcastReceiver, handler, str3, bundle, bundle2);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        super.superSendOrderedBroadcastAsUser(intent, userHandle, str, broadcastReceiver, handler, i3, str2, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendStickyBroadcast(Intent intent) {
        super.superSendStickyBroadcast(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        super.superSendStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
        super.superSendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i3, str, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
        super.superSendStickyOrderedBroadcastAsUser(intent, userHandle, broadcastReceiver, handler, i3, str, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetActionBar(Toolbar toolbar) {
        super.superSetActionBar(toolbar);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetContentTransitionManager(TransitionManager transitionManager) {
        super.superSetContentTransitionManager(transitionManager);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetContentView(int i3) {
        super.superSetContentView(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetDefaultKeyMode(int i3) {
        super.superSetDefaultKeyMode(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.superSetEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        super.superSetExitSharedElementCallback(sharedElementCallback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetFeatureDrawable(int i3, Drawable drawable) {
        super.superSetFeatureDrawable(i3, drawable);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetFeatureDrawableAlpha(int i3, int i16) {
        super.superSetFeatureDrawableAlpha(i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetFeatureDrawableResource(int i3, int i16) {
        super.superSetFeatureDrawableResource(i3, i16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetFeatureDrawableUri(int i3, Uri uri) {
        super.superSetFeatureDrawableUri(i3, uri);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetFinishOnTouchOutside(boolean z16) {
        super.superSetFinishOnTouchOutside(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetImmersive(boolean z16) {
        super.superSetImmersive(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetInheritShowWhenLocked(boolean z16) {
        super.superSetInheritShowWhenLocked(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetIntent(Intent intent) {
        super.superSetIntent(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetLocusContext(LocusId locusId, Bundle bundle) {
        super.superSetLocusContext(locusId, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetMediaController(MediaController mediaController) {
        super.superSetMediaController(mediaController);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        super.superSetPictureInPictureParams(pictureInPictureParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetProgress(int i3) {
        super.superSetProgress(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetProgressBarIndeterminate(boolean z16) {
        super.superSetProgressBarIndeterminate(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetProgressBarIndeterminateVisibility(boolean z16) {
        super.superSetProgressBarIndeterminateVisibility(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetProgressBarVisibility(boolean z16) {
        super.superSetProgressBarVisibility(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetRequestedOrientation(int i3) {
        super.superSetRequestedOrientation(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetResult(int i3) {
        super.superSetResult(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetSecondaryProgress(int i3) {
        super.superSetSecondaryProgress(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetShowWhenLocked(boolean z16) {
        super.superSetShowWhenLocked(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetTaskDescription(ActivityManager.TaskDescription taskDescription) {
        super.superSetTaskDescription(taskDescription);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetTheme(int i3) {
        super.superSetTheme(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetTitle(int i3) {
        super.superSetTitle(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetTitleColor(int i3) {
        super.superSetTitleColor(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superSetTranslucent(boolean z16) {
        return super.superSetTranslucent(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetTurnScreenOn(boolean z16) {
        super.superSetTurnScreenOn(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetVisible(boolean z16) {
        super.superSetVisible(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetVolumeControlStream(int i3) {
        super.superSetVolumeControlStream(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetVrModeEnabled(boolean z16, ComponentName componentName) throws PackageManager.NameNotFoundException {
        super.superSetVrModeEnabled(z16, componentName);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetWallpaper(Bitmap bitmap) throws IOException {
        super.superSetWallpaper(bitmap);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superShouldShowRequestPermissionRationale(String str) {
        return super.superShouldShowRequestPermissionRationale(str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superShouldUpRecreateTask(Intent intent) {
        return super.superShouldUpRecreateTask(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superShowAssist(Bundle bundle) {
        return super.superShowAssist(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superShowDialog(int i3) {
        super.superShowDialog(i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superShowLockTaskEscapeMessage() {
        super.superShowLockTaskEscapeMessage();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ActionMode superStartActionMode(ActionMode.Callback callback) {
        return super.superStartActionMode(callback);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivities(Intent[] intentArr) {
        super.superStartActivities(intentArr);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivity(Intent intent) {
        super.superStartActivity(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivityForResult(Intent intent, int i3) {
        super.superStartActivityForResult(intent, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivityFromChild(Activity activity, Intent intent, int i3) {
        super.superStartActivityFromChild(activity, intent, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivityFromFragment(Fragment fragment, Intent intent, int i3) {
        super.superStartActivityFromFragment(fragment, intent, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superStartActivityIfNeeded(Intent intent, int i3) {
        return super.superStartActivityIfNeeded(intent, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ComponentName superStartForegroundService(Intent intent) {
        return super.superStartForegroundService(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superStartInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return super.superStartInstrumentation(componentName, str, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17) throws IntentSender.SendIntentException {
        super.superStartIntentSender(intentSender, intent, i3, i16, i17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        super.superStartIntentSenderForResult(intentSender, i3, intent, i16, i17, i18);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException {
        super.superStartIntentSenderFromChild(activity, intentSender, i3, intent, i16, i17, i18);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartLocalVoiceInteraction(Bundle bundle) {
        super.superStartLocalVoiceInteraction(bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartLockTask() {
        super.superStartLockTask();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartManagingCursor(Cursor cursor) {
        super.superStartManagingCursor(cursor);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superStartNextMatchingActivity(Intent intent) {
        return super.superStartNextMatchingActivity(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartPostponedEnterTransition() {
        super.superStartPostponedEnterTransition();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartSearch(String str, boolean z16, Bundle bundle, boolean z17) {
        super.superStartSearch(str, z16, bundle, z17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ComponentName superStartService(Intent intent) {
        return super.superStartService(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStopLocalVoiceInteraction() {
        super.superStopLocalVoiceInteraction();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStopLockTask() {
        super.superStopLockTask();
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStopManagingCursor(Cursor cursor) {
        super.superStopManagingCursor(cursor);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superStopService(Intent intent) {
        return super.superStopService(intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superTakeKeyEvents(boolean z16) {
        super.superTakeKeyEvents(z16);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superTriggerSearch(String str, Bundle bundle) {
        super.superTriggerSearch(str, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superUnbindService(ServiceConnection serviceConnection) {
        super.superUnbindService(serviceConnection);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.superUnregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superUnregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.superUnregisterComponentCallbacks(componentCallbacks);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superUnregisterForContextMenu(View view) {
        super.superUnregisterForContextMenu(view);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superUnregisterReceiver(BroadcastReceiver broadcastReceiver) {
        super.superUnregisterReceiver(broadcastReceiver);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superUpdateServiceGroup(ServiceConnection serviceConnection, int i3, int i16) {
        super.superUpdateServiceGroup(serviceConnection, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Log.e(TAG, "onCreate");
        this.isBeforeOnCreate = false;
        this.mHostTheme = null;
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        if (isIllegalIntent(bundle)) {
            super.hostActivityDelegate = null;
            this.hostActivityDelegate = null;
            Log.e(TAG, "illegalIntent savedInstanceState==" + bundle + " getIntent().getExtras()==" + getIntent().getExtras());
        }
        if (this.hostActivityDelegate != null) {
            Log.e(TAG, "hostActivityDelegate onCreate");
            this.hostActivityDelegate.onCreate(bundle);
        } else {
            super.onCreate(null);
            Log.e(TAG, "onCreate: hostActivityDelegate==null finish activity");
            finish();
            System.exit(0);
        }
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onMultiWindowModeChanged(boolean z16, Configuration configuration) {
        super.onMultiWindowModeChanged(z16, configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        super.onPictureInPictureModeChanged(z16, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        HostActivityDelegate hostActivityDelegate = this.hostActivityDelegate;
        if (hostActivityDelegate != null) {
            hostActivityDelegate.onSaveInstanceState(bundle);
        } else {
            super.onSaveInstanceState(bundle);
        }
        bundle.putString("LOADER_VERSION", BuildConfig.VERSION_NAME);
        bundle.putLong("PROCESS_ID_KEY", DelegateProviderHolder.sCustomPid);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean onSearchRequested(SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        return super.onWindowStartingActionMode(callback, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superBindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        return super.superBindService(intent, serviceConnection, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ int superCheckUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17) {
        return super.superCheckUriPermission(uri, str, str2, i3, i16, i17);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Context superCreateWindowContext(Display display, int i3, Bundle bundle) {
        return super.superCreateWindowContext(display, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superEnforceUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17, String str3) {
        super.superEnforceUriPermission(uri, str, str2, i3, i16, i17, str3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        return super.superEnterPictureInPictureMode(pictureInPictureParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.superOnCreate(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Dialog superOnCreateDialog(int i3, Bundle bundle) {
        return super.superOnCreateDialog(i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ View superOnCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.superOnCreateView(str, context, attributeSet);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnMultiWindowModeChanged(boolean z16, Configuration configuration) {
        super.superOnMultiWindowModeChanged(z16, configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        super.superOnPictureInPictureModeChanged(z16, configuration);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.superOnPostCreate(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnPrepareDialog(int i3, Dialog dialog, Bundle bundle) {
        super.superOnPrepareDialog(i3, dialog, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.superOnRestoreInstanceState(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.superOnSaveInstanceState(bundle, persistableBundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superOnSearchRequested(SearchEvent searchEvent) {
        return super.superOnSearchRequested(searchEvent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ActionMode superOnWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        return super.superOnWindowStartingActionMode(callback, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ SQLiteDatabase superOpenOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return super.superOpenOrCreateDatabase(str, i3, cursorFactory, databaseErrorHandler);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i3) {
        return super.superRegisterReceiver(broadcastReceiver, intentFilter, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superRevokeUriPermission(String str, Uri uri, int i3) {
        super.superRevokeUriPermission(str, uri, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendBroadcast(Intent intent, String str) {
        super.superSendBroadcast(intent, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        super.superSendBroadcastAsUser(intent, userHandle, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendOrderedBroadcast(Intent intent, String str) {
        super.superSendOrderedBroadcast(intent, str);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendStickyBroadcast(Intent intent, Bundle bundle) {
        super.superSendStickyBroadcast(intent, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetContentView(View view) {
        super.superSetContentView(view);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetResult(int i3, Intent intent) {
        super.superSetResult(i3, intent);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetTheme(Resources.Theme theme) {
        super.superSetTheme(theme);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetTitle(CharSequence charSequence) {
        super.superSetTitle(charSequence);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetWallpaper(InputStream inputStream) throws IOException {
        super.superSetWallpaper(inputStream);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superShowDialog(int i3, Bundle bundle) {
        return super.superShowDialog(i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ ActionMode superStartActionMode(ActionMode.Callback callback, int i3) {
        return super.superStartActionMode(callback, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivities(Intent[] intentArr, Bundle bundle) {
        super.superStartActivities(intentArr, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivity(Intent intent, Bundle bundle) {
        super.superStartActivity(intent, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivityForResult(Intent intent, int i3, Bundle bundle) {
        super.superStartActivityForResult(intent, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivityFromChild(Activity activity, Intent intent, int i3, Bundle bundle) {
        super.superStartActivityFromChild(activity, intent, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartActivityFromFragment(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        super.superStartActivityFromFragment(fragment, intent, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superStartActivityIfNeeded(Intent intent, int i3, Bundle bundle) {
        return super.superStartActivityIfNeeded(intent, i3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17, Bundle bundle) throws IntentSender.SendIntentException {
        super.superStartIntentSender(intentSender, intent, i3, i16, i17, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
        super.superStartIntentSenderForResult(intentSender, i3, intent, i16, i17, i18, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
        super.superStartIntentSenderFromChild(activity, intentSender, i3, intent, i16, i17, i18, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ boolean superStartNextMatchingActivity(Intent intent, Bundle bundle) {
        return super.superStartNextMatchingActivity(intent, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return super.superRegisterReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        super.superSendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSetContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.superSetContentView(view, layoutParams);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i3) {
        return super.superRegisterReceiver(broadcastReceiver, intentFilter, str, handler, i3);
    }

    @Override // com.tencent.shadow.core.runtime.container.GeneratedPluginContainerActivity, com.tencent.shadow.core.runtime.container.GeneratedHostActivityDelegator
    public /* bridge */ /* synthetic */ void superSendOrderedBroadcast(Intent intent, String str, String str2, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str3, Bundle bundle) {
        super.superSendOrderedBroadcast(intent, str, str2, broadcastReceiver, handler, i3, str3, bundle);
    }

    @Override // com.tencent.shadow.core.runtime.container.HostActivityDelegator
    public HostActivity getHostActivity() {
        return this;
    }

    @Override // com.tencent.shadow.core.runtime.container.HostActivity
    public Activity getImplementActivity() {
        return this;
    }
}
