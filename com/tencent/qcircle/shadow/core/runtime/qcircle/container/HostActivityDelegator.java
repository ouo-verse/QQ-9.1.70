package com.tencent.qcircle.shadow.core.runtime.qcircle.container;

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
/* loaded from: classes22.dex */
public interface HostActivityDelegator {
    void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    void applyOverrideConfiguration(Configuration configuration);

    boolean bindService(Intent intent, ServiceConnection serviceConnection, int i3);

    int checkCallingOrSelfPermission(String str);

    int checkCallingOrSelfUriPermission(Uri uri, int i3);

    int checkCallingPermission(String str);

    int checkCallingUriPermission(Uri uri, int i3);

    int checkPermission(String str, int i3, int i16);

    int checkSelfPermission(String str);

    int checkUriPermission(Uri uri, int i3, int i16, int i17);

    int checkUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17);

    void clearWallpaper() throws IOException;

    void closeContextMenu();

    void closeOptionsMenu();

    Context createConfigurationContext(Configuration configuration);

    Context createContextForSplit(String str) throws PackageManager.NameNotFoundException;

    Context createDeviceProtectedStorageContext();

    Context createDisplayContext(Display display);

    Context createPackageContext(String str, int i3) throws PackageManager.NameNotFoundException;

    PendingIntent createPendingResult(int i3, Intent intent, int i16);

    String[] databaseList();

    boolean deleteDatabase(String str);

    boolean deleteFile(String str);

    boolean deleteSharedPreferences(String str);

    void dismissDialog(int i3);

    void dismissKeyboardShortcutsHelper();

    boolean dispatchGenericMotionEvent(MotionEvent motionEvent);

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    boolean dispatchKeyShortcutEvent(KeyEvent keyEvent);

    boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    boolean dispatchTrackballEvent(MotionEvent motionEvent);

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    void enforceCallingOrSelfPermission(String str, String str2);

    void enforceCallingOrSelfUriPermission(Uri uri, int i3, String str);

    void enforceCallingPermission(String str, String str2);

    void enforceCallingUriPermission(Uri uri, int i3, String str);

    void enforcePermission(String str, int i3, int i16, String str2);

    void enforceUriPermission(Uri uri, int i3, int i16, int i17, String str);

    void enforceUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17, String str3);

    void enterPictureInPictureMode();

    boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams);

    String[] fileList();

    <T extends View> T findViewById(int i3);

    void finish();

    void finishActivity(int i3);

    void finishActivityFromChild(Activity activity, int i3);

    void finishAffinity();

    void finishAfterTransition();

    void finishAndRemoveTask();

    void finishFromChild(Activity activity);

    ActionBar getActionBar();

    Application getApplication();

    Context getApplicationContext();

    ApplicationInfo getApplicationInfo();

    AssetManager getAssets();

    Context getBaseContext();

    File getCacheDir();

    ComponentName getCallingActivity();

    String getCallingPackage();

    int getChangingConfigurations();

    ClassLoader getClassLoader();

    File getCodeCacheDir();

    ComponentName getComponentName();

    ContentResolver getContentResolver();

    Scene getContentScene();

    TransitionManager getContentTransitionManager();

    View getCurrentFocus();

    File getDataDir();

    File getDatabasePath(String str);

    File getDir(String str, int i3);

    File getExternalCacheDir();

    File[] getExternalCacheDirs();

    File getExternalFilesDir(String str);

    File[] getExternalFilesDirs(String str);

    File[] getExternalMediaDirs();

    File getFileStreamPath(String str);

    File getFilesDir();

    FragmentManager getFragmentManager();

    HostActivity getHostActivity();

    Intent getIntent();

    Object getLastNonConfigurationInstance();

    LayoutInflater getLayoutInflater();

    LoaderManager getLoaderManager();

    String getLocalClassName();

    Looper getMainLooper();

    int getMaxNumPictureInPictureActions();

    MediaController getMediaController();

    MenuInflater getMenuInflater();

    File getNoBackupFilesDir();

    File getObbDir();

    File[] getObbDirs();

    String getPackageCodePath();

    PackageManager getPackageManager();

    String getPackageName();

    String getPackageResourcePath();

    Activity getParent();

    Intent getParentActivityIntent();

    SharedPreferences getPreferences(int i3);

    Uri getReferrer();

    int getRequestedOrientation();

    Resources getResources();

    SearchEvent getSearchEvent();

    SharedPreferences getSharedPreferences(String str, int i3);

    Object getSystemService(String str);

    String getSystemServiceName(Class<?> cls);

    int getTaskId();

    Resources.Theme getTheme();

    CharSequence getTitle();

    int getTitleColor();

    VoiceInteractor getVoiceInteractor();

    int getVolumeControlStream();

    Drawable getWallpaper();

    int getWallpaperDesiredMinimumHeight();

    int getWallpaperDesiredMinimumWidth();

    Window getWindow();

    WindowManager getWindowManager();

    void grantUriPermission(String str, Uri uri, int i3);

    boolean hasWindowFocus();

    void invalidateOptionsMenu();

    boolean isActivityTransitionRunning();

    boolean isChangingConfigurations();

    boolean isChild();

    boolean isDestroyed();

    boolean isDeviceProtectedStorage();

    boolean isFinishing();

    boolean isImmersive();

    boolean isInMultiWindowMode();

    boolean isInPictureInPictureMode();

    boolean isLocalVoiceInteractionSupported();

    boolean isRestricted();

    boolean isTaskRoot();

    boolean isVoiceInteraction();

    boolean isVoiceInteractionRoot();

    Cursor managedQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    boolean moveDatabaseFrom(Context context, String str);

    boolean moveSharedPreferencesFrom(Context context, String str);

    boolean moveTaskToBack(boolean z16);

    boolean navigateUpTo(Intent intent);

    boolean navigateUpToFromChild(Activity activity, Intent intent);

    void openContextMenu(View view);

    FileInputStream openFileInput(String str) throws FileNotFoundException;

    FileOutputStream openFileOutput(String str, int i3) throws FileNotFoundException;

    void openOptionsMenu();

    SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory);

    SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler);

    void overridePendingTransition(int i3, int i16);

    Drawable peekWallpaper();

    void postponeEnterTransition();

    void recreate();

    void registerComponentCallbacks(ComponentCallbacks componentCallbacks);

    void registerForContextMenu(View view);

    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i3);

    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler);

    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i3);

    boolean releaseInstance();

    void removeDialog(int i3);

    void removeStickyBroadcast(Intent intent);

    void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle);

    void reportFullyDrawn();

    DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent);

    void requestPermissions(String[] strArr, int i3);

    void requestShowKeyboardShortcuts();

    boolean requestVisibleBehind(boolean z16);

    boolean requestWindowFeature(int i3);

    void revokeUriPermission(Uri uri, int i3);

    void revokeUriPermission(String str, Uri uri, int i3);

    void runOnUiThread(Runnable runnable);

    void sendBroadcast(Intent intent);

    void sendBroadcast(Intent intent, String str);

    void sendBroadcastAsUser(Intent intent, UserHandle userHandle);

    void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String str);

    void sendOrderedBroadcast(Intent intent, String str);

    void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle);

    void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle);

    void sendStickyBroadcast(Intent intent);

    void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle);

    void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle);

    void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle);

    void setActionBar(Toolbar toolbar);

    void setContentTransitionManager(TransitionManager transitionManager);

    void setContentView(int i3);

    void setContentView(View view);

    void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    void setDefaultKeyMode(int i3);

    void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback);

    void setExitSharedElementCallback(SharedElementCallback sharedElementCallback);

    void setFeatureDrawable(int i3, Drawable drawable);

    void setFeatureDrawableAlpha(int i3, int i16);

    void setFeatureDrawableResource(int i3, int i16);

    void setFeatureDrawableUri(int i3, Uri uri);

    void setFinishOnTouchOutside(boolean z16);

    void setImmersive(boolean z16);

    void setIntent(Intent intent);

    void setMediaController(MediaController mediaController);

    void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams);

    void setProgress(int i3);

    void setProgressBarIndeterminate(boolean z16);

    void setProgressBarIndeterminateVisibility(boolean z16);

    void setProgressBarVisibility(boolean z16);

    void setRequestedOrientation(int i3);

    void setResult(int i3);

    void setResult(int i3, Intent intent);

    void setSecondaryProgress(int i3);

    void setShowWhenLocked(boolean z16);

    void setTaskDescription(ActivityManager.TaskDescription taskDescription);

    void setTheme(int i3);

    void setTitle(int i3);

    void setTitle(CharSequence charSequence);

    void setTitleColor(int i3);

    void setTurnScreenOn(boolean z16);

    void setVisible(boolean z16);

    void setVolumeControlStream(int i3);

    void setVrModeEnabled(boolean z16, ComponentName componentName) throws PackageManager.NameNotFoundException;

    void setWallpaper(Bitmap bitmap) throws IOException;

    void setWallpaper(InputStream inputStream) throws IOException;

    boolean shouldShowRequestPermissionRationale(String str);

    boolean shouldUpRecreateTask(Intent intent);

    boolean showAssist(Bundle bundle);

    void showDialog(int i3);

    boolean showDialog(int i3, Bundle bundle);

    void showLockTaskEscapeMessage();

    ActionMode startActionMode(ActionMode.Callback callback);

    ActionMode startActionMode(ActionMode.Callback callback, int i3);

    void startActivities(Intent[] intentArr);

    void startActivities(Intent[] intentArr, Bundle bundle);

    void startActivity(Intent intent);

    void startActivity(Intent intent, Bundle bundle);

    void startActivityForResult(Intent intent, int i3);

    void startActivityForResult(Intent intent, int i3, Bundle bundle);

    void startActivityFromChild(Activity activity, Intent intent, int i3);

    void startActivityFromChild(Activity activity, Intent intent, int i3, Bundle bundle);

    void startActivityFromFragment(Fragment fragment, Intent intent, int i3);

    void startActivityFromFragment(Fragment fragment, Intent intent, int i3, Bundle bundle);

    boolean startActivityIfNeeded(Intent intent, int i3);

    boolean startActivityIfNeeded(Intent intent, int i3, Bundle bundle);

    ComponentName startForegroundService(Intent intent);

    boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle);

    void startIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17) throws IntentSender.SendIntentException;

    void startIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17, Bundle bundle) throws IntentSender.SendIntentException;

    void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException;

    void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException;

    void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException;

    void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException;

    void startLocalVoiceInteraction(Bundle bundle);

    void startLockTask();

    void startManagingCursor(Cursor cursor);

    boolean startNextMatchingActivity(Intent intent);

    boolean startNextMatchingActivity(Intent intent, Bundle bundle);

    void startPostponedEnterTransition();

    void startSearch(String str, boolean z16, Bundle bundle, boolean z17);

    ComponentName startService(Intent intent);

    void stopLocalVoiceInteraction();

    void stopLockTask();

    void stopManagingCursor(Cursor cursor);

    boolean stopService(Intent intent);

    void superAddContentView(View view, ViewGroup.LayoutParams layoutParams);

    void superApplyOverrideConfiguration(Configuration configuration);

    void superAttachBaseContext(Context context);

    boolean superBindService(Intent intent, ServiceConnection serviceConnection, int i3);

    int superCheckCallingOrSelfPermission(String str);

    int superCheckCallingOrSelfUriPermission(Uri uri, int i3);

    int superCheckCallingPermission(String str);

    int superCheckCallingUriPermission(Uri uri, int i3);

    int superCheckPermission(String str, int i3, int i16);

    int superCheckSelfPermission(String str);

    int superCheckUriPermission(Uri uri, int i3, int i16, int i17);

    int superCheckUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17);

    void superClearWallpaper() throws IOException;

    void superCloseContextMenu();

    void superCloseOptionsMenu();

    Context superCreateConfigurationContext(Configuration configuration);

    Context superCreateContextForSplit(String str) throws PackageManager.NameNotFoundException;

    Context superCreateDeviceProtectedStorageContext();

    Context superCreateDisplayContext(Display display);

    Context superCreatePackageContext(String str, int i3) throws PackageManager.NameNotFoundException;

    PendingIntent superCreatePendingResult(int i3, Intent intent, int i16);

    String[] superDatabaseList();

    boolean superDeleteDatabase(String str);

    boolean superDeleteFile(String str);

    boolean superDeleteSharedPreferences(String str);

    void superDismissDialog(int i3);

    void superDismissKeyboardShortcutsHelper();

    boolean superDispatchGenericMotionEvent(MotionEvent motionEvent);

    boolean superDispatchKeyEvent(KeyEvent keyEvent);

    boolean superDispatchKeyShortcutEvent(KeyEvent keyEvent);

    boolean superDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    boolean superDispatchTouchEvent(MotionEvent motionEvent);

    boolean superDispatchTrackballEvent(MotionEvent motionEvent);

    void superDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    void superEnforceCallingOrSelfPermission(String str, String str2);

    void superEnforceCallingOrSelfUriPermission(Uri uri, int i3, String str);

    void superEnforceCallingPermission(String str, String str2);

    void superEnforceCallingUriPermission(Uri uri, int i3, String str);

    void superEnforcePermission(String str, int i3, int i16, String str2);

    void superEnforceUriPermission(Uri uri, int i3, int i16, int i17, String str);

    void superEnforceUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17, String str3);

    void superEnterPictureInPictureMode();

    boolean superEnterPictureInPictureMode(PictureInPictureParams pictureInPictureParams);

    String[] superFileList();

    <T extends View> T superFindViewById(int i3);

    void superFinish();

    void superFinishActivity(int i3);

    void superFinishActivityFromChild(Activity activity, int i3);

    void superFinishAffinity();

    void superFinishAfterTransition();

    void superFinishAndRemoveTask();

    void superFinishFromChild(Activity activity);

    ActionBar superGetActionBar();

    Application superGetApplication();

    Context superGetApplicationContext();

    ApplicationInfo superGetApplicationInfo();

    AssetManager superGetAssets();

    Context superGetBaseContext();

    File superGetCacheDir();

    ComponentName superGetCallingActivity();

    String superGetCallingPackage();

    int superGetChangingConfigurations();

    ClassLoader superGetClassLoader();

    File superGetCodeCacheDir();

    ComponentName superGetComponentName();

    ContentResolver superGetContentResolver();

    Scene superGetContentScene();

    TransitionManager superGetContentTransitionManager();

    View superGetCurrentFocus();

    File superGetDataDir();

    File superGetDatabasePath(String str);

    File superGetDir(String str, int i3);

    File superGetExternalCacheDir();

    File[] superGetExternalCacheDirs();

    File superGetExternalFilesDir(String str);

    File[] superGetExternalFilesDirs(String str);

    File[] superGetExternalMediaDirs();

    File superGetFileStreamPath(String str);

    File superGetFilesDir();

    FragmentManager superGetFragmentManager();

    Intent superGetIntent();

    Object superGetLastNonConfigurationInstance();

    LayoutInflater superGetLayoutInflater();

    LoaderManager superGetLoaderManager();

    String superGetLocalClassName();

    Looper superGetMainLooper();

    int superGetMaxNumPictureInPictureActions();

    MediaController superGetMediaController();

    MenuInflater superGetMenuInflater();

    File superGetNoBackupFilesDir();

    File superGetObbDir();

    File[] superGetObbDirs();

    String superGetPackageCodePath();

    PackageManager superGetPackageManager();

    String superGetPackageName();

    String superGetPackageResourcePath();

    Activity superGetParent();

    Intent superGetParentActivityIntent();

    SharedPreferences superGetPreferences(int i3);

    Uri superGetReferrer();

    int superGetRequestedOrientation();

    Resources superGetResources();

    SearchEvent superGetSearchEvent();

    SharedPreferences superGetSharedPreferences(String str, int i3);

    Object superGetSystemService(String str);

    String superGetSystemServiceName(Class<?> cls);

    int superGetTaskId();

    Resources.Theme superGetTheme();

    CharSequence superGetTitle();

    int superGetTitleColor();

    VoiceInteractor superGetVoiceInteractor();

    int superGetVolumeControlStream();

    Drawable superGetWallpaper();

    int superGetWallpaperDesiredMinimumHeight();

    int superGetWallpaperDesiredMinimumWidth();

    Window superGetWindow();

    WindowManager superGetWindowManager();

    void superGrantUriPermission(String str, Uri uri, int i3);

    boolean superHasWindowFocus();

    void superInvalidateOptionsMenu();

    boolean superIsActivityTransitionRunning();

    boolean superIsChangingConfigurations();

    boolean superIsChild();

    boolean superIsDestroyed();

    boolean superIsDeviceProtectedStorage();

    boolean superIsFinishing();

    boolean superIsImmersive();

    boolean superIsInMultiWindowMode();

    boolean superIsInPictureInPictureMode();

    boolean superIsLocalVoiceInteractionSupported();

    boolean superIsRestricted();

    boolean superIsTaskRoot();

    boolean superIsVoiceInteraction();

    boolean superIsVoiceInteractionRoot();

    boolean superMoveDatabaseFrom(Context context, String str);

    boolean superMoveSharedPreferencesFrom(Context context, String str);

    boolean superMoveTaskToBack(boolean z16);

    boolean superNavigateUpTo(Intent intent);

    boolean superNavigateUpToFromChild(Activity activity, Intent intent);

    void superOnActionModeFinished(ActionMode actionMode);

    void superOnActionModeStarted(ActionMode actionMode);

    void superOnActivityReenter(int i3, Intent intent);

    void superOnActivityResult(int i3, int i16, Intent intent);

    void superOnApplyThemeResource(Resources.Theme theme, int i3, boolean z16);

    void superOnAttachFragment(Fragment fragment);

    void superOnAttachedToWindow();

    void superOnBackPressed();

    void superOnChildTitleChanged(Activity activity, CharSequence charSequence);

    void superOnConfigurationChanged(Configuration configuration);

    void superOnContentChanged();

    boolean superOnContextItemSelected(MenuItem menuItem);

    void superOnContextMenuClosed(Menu menu);

    void superOnCreate(Bundle bundle);

    void superOnCreate(Bundle bundle, PersistableBundle persistableBundle);

    void superOnCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    CharSequence superOnCreateDescription();

    Dialog superOnCreateDialog(int i3);

    Dialog superOnCreateDialog(int i3, Bundle bundle);

    void superOnCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder);

    boolean superOnCreateOptionsMenu(Menu menu);

    boolean superOnCreatePanelMenu(int i3, Menu menu);

    View superOnCreatePanelView(int i3);

    boolean superOnCreateThumbnail(Bitmap bitmap, Canvas canvas);

    View superOnCreateView(View view, String str, Context context, AttributeSet attributeSet);

    View superOnCreateView(String str, Context context, AttributeSet attributeSet);

    void superOnDestroy();

    void superOnDetachedFromWindow();

    void superOnEnterAnimationComplete();

    boolean superOnGenericMotionEvent(MotionEvent motionEvent);

    boolean superOnKeyDown(int i3, KeyEvent keyEvent);

    boolean superOnKeyLongPress(int i3, KeyEvent keyEvent);

    boolean superOnKeyMultiple(int i3, int i16, KeyEvent keyEvent);

    boolean superOnKeyShortcut(int i3, KeyEvent keyEvent);

    boolean superOnKeyUp(int i3, KeyEvent keyEvent);

    void superOnLocalVoiceInteractionStarted();

    void superOnLocalVoiceInteractionStopped();

    void superOnLowMemory();

    boolean superOnMenuItemSelected(int i3, MenuItem menuItem);

    boolean superOnMenuOpened(int i3, Menu menu);

    void superOnMultiWindowModeChanged(boolean z16);

    void superOnMultiWindowModeChanged(boolean z16, Configuration configuration);

    boolean superOnNavigateUp();

    boolean superOnNavigateUpFromChild(Activity activity);

    void superOnNewIntent(Intent intent);

    boolean superOnOptionsItemSelected(MenuItem menuItem);

    void superOnOptionsMenuClosed(Menu menu);

    void superOnPanelClosed(int i3, Menu menu);

    void superOnPause();

    void superOnPictureInPictureModeChanged(boolean z16);

    void superOnPictureInPictureModeChanged(boolean z16, Configuration configuration);

    void superOnPointerCaptureChanged(boolean z16);

    void superOnPostCreate(Bundle bundle);

    void superOnPostCreate(Bundle bundle, PersistableBundle persistableBundle);

    void superOnPostResume();

    void superOnPrepareDialog(int i3, Dialog dialog);

    void superOnPrepareDialog(int i3, Dialog dialog, Bundle bundle);

    void superOnPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder);

    boolean superOnPrepareOptionsMenu(Menu menu);

    boolean superOnPreparePanel(int i3, View view, Menu menu);

    void superOnProvideAssistContent(AssistContent assistContent);

    void superOnProvideAssistData(Bundle bundle);

    void superOnProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3);

    Uri superOnProvideReferrer();

    void superOnRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    void superOnRestart();

    void superOnRestoreInstanceState(Bundle bundle);

    void superOnRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle);

    void superOnResume();

    Object superOnRetainNonConfigurationInstance();

    void superOnSaveInstanceState(Bundle bundle);

    void superOnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle);

    boolean superOnSearchRequested();

    boolean superOnSearchRequested(SearchEvent searchEvent);

    void superOnStart();

    void superOnStateNotSaved();

    void superOnStop();

    void superOnTitleChanged(CharSequence charSequence, int i3);

    boolean superOnTouchEvent(MotionEvent motionEvent);

    boolean superOnTrackballEvent(MotionEvent motionEvent);

    void superOnTrimMemory(int i3);

    void superOnUserInteraction();

    void superOnUserLeaveHint();

    void superOnVisibleBehindCanceled();

    void superOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams);

    void superOnWindowFocusChanged(boolean z16);

    ActionMode superOnWindowStartingActionMode(ActionMode.Callback callback);

    ActionMode superOnWindowStartingActionMode(ActionMode.Callback callback, int i3);

    void superOpenContextMenu(View view);

    FileInputStream superOpenFileInput(String str) throws FileNotFoundException;

    FileOutputStream superOpenFileOutput(String str, int i3) throws FileNotFoundException;

    void superOpenOptionsMenu();

    SQLiteDatabase superOpenOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory);

    SQLiteDatabase superOpenOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler);

    void superOverridePendingTransition(int i3, int i16);

    Drawable superPeekWallpaper();

    void superPostponeEnterTransition();

    void superRecreate();

    void superRegisterComponentCallbacks(ComponentCallbacks componentCallbacks);

    void superRegisterForContextMenu(View view);

    Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i3);

    Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler);

    Intent superRegisterReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i3);

    boolean superReleaseInstance();

    void superRemoveDialog(int i3);

    void superRemoveStickyBroadcast(Intent intent);

    void superRemoveStickyBroadcastAsUser(Intent intent, UserHandle userHandle);

    void superReportFullyDrawn();

    DragAndDropPermissions superRequestDragAndDropPermissions(DragEvent dragEvent);

    void superRequestPermissions(String[] strArr, int i3);

    void superRequestShowKeyboardShortcuts();

    boolean superRequestVisibleBehind(boolean z16);

    boolean superRequestWindowFeature(int i3);

    void superRevokeUriPermission(Uri uri, int i3);

    void superRevokeUriPermission(String str, Uri uri, int i3);

    void superRunOnUiThread(Runnable runnable);

    void superSendBroadcast(Intent intent);

    void superSendBroadcast(Intent intent, String str);

    void superSendBroadcastAsUser(Intent intent, UserHandle userHandle);

    void superSendBroadcastAsUser(Intent intent, UserHandle userHandle, String str);

    void superSendOrderedBroadcast(Intent intent, String str);

    void superSendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle);

    void superSendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle);

    void superSendStickyBroadcast(Intent intent);

    void superSendStickyBroadcastAsUser(Intent intent, UserHandle userHandle);

    void superSendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle);

    void superSendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle);

    void superSetActionBar(Toolbar toolbar);

    void superSetContentTransitionManager(TransitionManager transitionManager);

    void superSetContentView(int i3);

    void superSetContentView(View view);

    void superSetContentView(View view, ViewGroup.LayoutParams layoutParams);

    void superSetDefaultKeyMode(int i3);

    void superSetEnterSharedElementCallback(SharedElementCallback sharedElementCallback);

    void superSetExitSharedElementCallback(SharedElementCallback sharedElementCallback);

    void superSetFeatureDrawable(int i3, Drawable drawable);

    void superSetFeatureDrawableAlpha(int i3, int i16);

    void superSetFeatureDrawableResource(int i3, int i16);

    void superSetFeatureDrawableUri(int i3, Uri uri);

    void superSetFinishOnTouchOutside(boolean z16);

    void superSetImmersive(boolean z16);

    void superSetIntent(Intent intent);

    void superSetMediaController(MediaController mediaController);

    void superSetPictureInPictureParams(PictureInPictureParams pictureInPictureParams);

    void superSetProgress(int i3);

    void superSetProgressBarIndeterminate(boolean z16);

    void superSetProgressBarIndeterminateVisibility(boolean z16);

    void superSetProgressBarVisibility(boolean z16);

    void superSetRequestedOrientation(int i3);

    void superSetResult(int i3);

    void superSetResult(int i3, Intent intent);

    void superSetSecondaryProgress(int i3);

    void superSetShowWhenLocked(boolean z16);

    void superSetTaskDescription(ActivityManager.TaskDescription taskDescription);

    void superSetTheme(int i3);

    void superSetTitle(int i3);

    void superSetTitle(CharSequence charSequence);

    void superSetTitleColor(int i3);

    void superSetTurnScreenOn(boolean z16);

    void superSetVisible(boolean z16);

    void superSetVolumeControlStream(int i3);

    void superSetVrModeEnabled(boolean z16, ComponentName componentName) throws PackageManager.NameNotFoundException;

    void superSetWallpaper(Bitmap bitmap) throws IOException;

    void superSetWallpaper(InputStream inputStream) throws IOException;

    boolean superShouldShowRequestPermissionRationale(String str);

    boolean superShouldUpRecreateTask(Intent intent);

    boolean superShowAssist(Bundle bundle);

    void superShowDialog(int i3);

    boolean superShowDialog(int i3, Bundle bundle);

    void superShowLockTaskEscapeMessage();

    ActionMode superStartActionMode(ActionMode.Callback callback);

    ActionMode superStartActionMode(ActionMode.Callback callback, int i3);

    void superStartActivities(Intent[] intentArr);

    void superStartActivities(Intent[] intentArr, Bundle bundle);

    void superStartActivity(Intent intent);

    void superStartActivity(Intent intent, Bundle bundle);

    void superStartActivityForResult(Intent intent, int i3);

    void superStartActivityForResult(Intent intent, int i3, Bundle bundle);

    void superStartActivityFromChild(Activity activity, Intent intent, int i3);

    void superStartActivityFromChild(Activity activity, Intent intent, int i3, Bundle bundle);

    void superStartActivityFromFragment(Fragment fragment, Intent intent, int i3);

    void superStartActivityFromFragment(Fragment fragment, Intent intent, int i3, Bundle bundle);

    boolean superStartActivityIfNeeded(Intent intent, int i3);

    boolean superStartActivityIfNeeded(Intent intent, int i3, Bundle bundle);

    ComponentName superStartForegroundService(Intent intent);

    boolean superStartInstrumentation(ComponentName componentName, String str, Bundle bundle);

    void superStartIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17) throws IntentSender.SendIntentException;

    void superStartIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17, Bundle bundle) throws IntentSender.SendIntentException;

    void superStartIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException;

    void superStartIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException;

    void superStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18) throws IntentSender.SendIntentException;

    void superStartIntentSenderFromChild(Activity activity, IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException;

    void superStartLocalVoiceInteraction(Bundle bundle);

    void superStartLockTask();

    void superStartManagingCursor(Cursor cursor);

    boolean superStartNextMatchingActivity(Intent intent);

    boolean superStartNextMatchingActivity(Intent intent, Bundle bundle);

    void superStartPostponedEnterTransition();

    void superStartSearch(String str, boolean z16, Bundle bundle, boolean z17);

    ComponentName superStartService(Intent intent);

    void superStopLocalVoiceInteraction();

    void superStopLockTask();

    void superStopManagingCursor(Cursor cursor);

    boolean superStopService(Intent intent);

    void superTakeKeyEvents(boolean z16);

    void superTriggerSearch(String str, Bundle bundle);

    void superUnbindService(ServiceConnection serviceConnection);

    void superUnregisterComponentCallbacks(ComponentCallbacks componentCallbacks);

    void superUnregisterForContextMenu(View view);

    void superUnregisterReceiver(BroadcastReceiver broadcastReceiver);

    void takeKeyEvents(boolean z16);

    void triggerSearch(String str, Bundle bundle);

    void unbindService(ServiceConnection serviceConnection);

    void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks);

    void unregisterForContextMenu(View view);

    void unregisterReceiver(BroadcastReceiver broadcastReceiver);
}
