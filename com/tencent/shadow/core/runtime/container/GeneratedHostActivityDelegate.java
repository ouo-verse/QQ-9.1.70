package com.tencent.shadow.core.runtime.container;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface GeneratedHostActivityDelegate {
    boolean dispatchGenericMotionEvent(MotionEvent motionEvent);

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    boolean dispatchKeyShortcutEvent(KeyEvent keyEvent);

    boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    boolean dispatchTrackballEvent(MotionEvent motionEvent);

    void finish();

    ComponentName getCallingActivity();

    ClassLoader getClassLoader();

    LayoutInflater getLayoutInflater();

    Resources getResources();

    boolean isChangingConfigurations();

    void onActionModeFinished(ActionMode actionMode);

    void onActionModeStarted(ActionMode actionMode);

    void onActivityReenter(int i3, Intent intent);

    void onActivityResult(int i3, int i16, Intent intent);

    void onApplyThemeResource(Resources.Theme theme, int i3, boolean z16);

    void onAttachFragment(Fragment fragment);

    void onAttachedToWindow();

    void onBackPressed();

    void onChildTitleChanged(Activity activity, CharSequence charSequence);

    void onConfigurationChanged(Configuration configuration);

    void onContentChanged();

    boolean onContextItemSelected(MenuItem menuItem);

    void onContextMenuClosed(Menu menu);

    void onCreate(Bundle bundle);

    void onCreate(Bundle bundle, Object obj);

    void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    CharSequence onCreateDescription();

    Dialog onCreateDialog(int i3);

    Dialog onCreateDialog(int i3, Bundle bundle);

    void onCreateNavigateUpTaskStack(Object obj);

    boolean onCreateOptionsMenu(Menu menu);

    boolean onCreatePanelMenu(int i3, Menu menu);

    View onCreatePanelView(int i3);

    boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas);

    View onCreateView(View view, String str, Context context, AttributeSet attributeSet);

    View onCreateView(String str, Context context, AttributeSet attributeSet);

    void onDestroy();

    void onDetachedFromWindow();

    void onEnterAnimationComplete();

    boolean onGenericMotionEvent(MotionEvent motionEvent);

    void onGetDirectActions(Object obj, Object obj2);

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    boolean onKeyLongPress(int i3, KeyEvent keyEvent);

    boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent);

    boolean onKeyShortcut(int i3, KeyEvent keyEvent);

    boolean onKeyUp(int i3, KeyEvent keyEvent);

    void onLocalVoiceInteractionStarted();

    void onLocalVoiceInteractionStopped();

    void onLowMemory();

    boolean onMenuItemSelected(int i3, MenuItem menuItem);

    boolean onMenuOpened(int i3, Menu menu);

    void onMultiWindowModeChanged(boolean z16);

    void onMultiWindowModeChanged(boolean z16, Configuration configuration);

    boolean onNavigateUp();

    boolean onNavigateUpFromChild(Activity activity);

    void onNewIntent(Intent intent);

    boolean onOptionsItemSelected(MenuItem menuItem);

    void onOptionsMenuClosed(Menu menu);

    void onPanelClosed(int i3, Menu menu);

    void onPause();

    void onPerformDirectAction(String str, Bundle bundle, Object obj, Object obj2);

    void onPictureInPictureModeChanged(boolean z16);

    void onPictureInPictureModeChanged(boolean z16, Configuration configuration);

    boolean onPictureInPictureRequested();

    void onPictureInPictureUiStateChanged(Object obj);

    void onPointerCaptureChanged(boolean z16);

    void onPostCreate(Bundle bundle);

    void onPostCreate(Bundle bundle, Object obj);

    void onPostResume();

    void onPrepareDialog(int i3, Dialog dialog);

    void onPrepareDialog(int i3, Dialog dialog, Bundle bundle);

    void onPrepareNavigateUpTaskStack(Object obj);

    boolean onPrepareOptionsMenu(Menu menu);

    boolean onPreparePanel(int i3, View view, Menu menu);

    void onProvideAssistContent(Object obj);

    void onProvideAssistData(Bundle bundle);

    void onProvideKeyboardShortcuts(Object obj, Menu menu, int i3);

    Uri onProvideReferrer();

    void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    void onRestart();

    void onRestoreInstanceState(Bundle bundle);

    void onRestoreInstanceState(Bundle bundle, Object obj);

    void onResume();

    Object onRetainNonConfigurationInstance();

    void onSaveInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle, Object obj);

    boolean onSearchRequested();

    boolean onSearchRequested(Object obj);

    void onStart();

    void onStateNotSaved();

    void onStop();

    void onTitleChanged(CharSequence charSequence, int i3);

    void onTopResumedActivityChanged(boolean z16);

    boolean onTouchEvent(MotionEvent motionEvent);

    boolean onTrackballEvent(MotionEvent motionEvent);

    void onTrimMemory(int i3);

    void onUserInteraction();

    void onUserLeaveHint();

    void onVisibleBehindCanceled();

    void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams);

    void onWindowFocusChanged(boolean z16);

    ActionMode onWindowStartingActionMode(ActionMode.Callback callback);

    ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3);

    void recreate();
}
