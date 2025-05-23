package com.tencent.shadow.core.runtime;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.shadow.core.runtime.qcircle.container.HostActivityDelegator;
import com.tencent.shadow.core.runtime.skin.entity.SkinItem;
import com.tencent.shadow.core.runtime.skin.listener.ISkinUpdate;
import com.tencent.shadow.core.runtime.skin.loader.SkinManager;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes25.dex */
public abstract class PluginActivity extends ShadowContext implements Window.Callback, KeyEvent.Callback, ISkinUpdate {
    private static final String TAG = "PluginActivity";
    HostActivityDelegator mHostActivityDelegator;
    ShadowApplication mPluginApplication;

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mHostActivityDelegator.superDispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            Object obj = this.mHostActivityDelegator;
            if (obj instanceof Activity) {
                ((Activity) obj).onBackPressed();
                return true;
            }
        }
        return this.mHostActivityDelegator.superDispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mHostActivityDelegator.superDispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mHostActivityDelegator.superDispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mHostActivityDelegator.superDispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mHostActivityDelegator.superDispatchTrackballEvent(motionEvent);
    }

    public void finish() {
        this.mHostActivityDelegator.superFinish();
    }

    public HostActivityDelegator getHostActivityDelegator() {
        return this.mHostActivityDelegator;
    }

    public LayoutInflater getLayoutInflater() {
        return ShadowLayoutInflater.build(this.mHostActivityDelegator.getWindow().getLayoutInflater(), this, this.mPartKey, this.mSkinMap);
    }

    public boolean isChangingConfigurations() {
        return this.mHostActivityDelegator.superIsChangingConfigurations();
    }

    public boolean moveTaskToBack(boolean z16) {
        return this.mHostActivityDelegator.superMoveTaskToBack(z16);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.mHostActivityDelegator.superOnActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.mHostActivityDelegator.superOnActionModeStarted(actionMode);
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        this.mHostActivityDelegator.superOnActivityResult(i3, i16, intent);
    }

    public void onAttachFragment(Fragment fragment) {
        this.mHostActivityDelegator.superOnAttachFragment(fragment);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mHostActivityDelegator.superOnAttachedToWindow();
    }

    public void onBackPressed() {
        this.mHostActivityDelegator.superOnBackPressed();
    }

    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.mHostActivityDelegator.superOnChildTitleChanged(activity, charSequence);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mHostActivityDelegator.superOnConfigurationChanged(configuration);
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.mHostActivityDelegator.superOnContentChanged();
    }

    public void onCreate(Bundle bundle) {
        this.mHostActivityDelegator.superOnCreate(bundle);
        SkinManager.getsInstance().attach(this);
    }

    public CharSequence onCreateDescription() {
        return this.mHostActivityDelegator.superOnCreateDescription();
    }

    public Dialog onCreateDialog(int i3) {
        return this.mHostActivityDelegator.superOnCreateDialog(i3);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return this.mHostActivityDelegator.superOnCreateOptionsMenu(menu);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 == 0) {
            return onCreateOptionsMenu(menu);
        }
        return this.mHostActivityDelegator.superOnCreatePanelMenu(i3, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i3) {
        return this.mHostActivityDelegator.superOnCreatePanelView(i3);
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mHostActivityDelegator.superOnCreateThumbnail(bitmap, canvas);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mHostActivityDelegator.superOnCreateView(str, context, attributeSet);
    }

    public void onDestroy() {
        this.mHostActivityDelegator.superOnDestroy();
        SkinManager.getsInstance().detach(this);
        this.mSkinMap.clear();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mHostActivityDelegator.superOnDetachedFromWindow();
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        return this.mHostActivityDelegator.superOnKeyDown(i3, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i3, KeyEvent keyEvent) {
        return this.mHostActivityDelegator.superOnKeyLongPress(i3, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        return this.mHostActivityDelegator.superOnKeyMultiple(i3, i16, keyEvent);
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        return this.mHostActivityDelegator.superOnKeyUp(i3, keyEvent);
    }

    public void onLowMemory() {
        this.mHostActivityDelegator.superOnLowMemory();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        return this.mHostActivityDelegator.superOnMenuItemSelected(i3, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i3, Menu menu) {
        return this.mHostActivityDelegator.superOnMenuOpened(i3, menu);
    }

    public void onMultiWindowModeChanged(boolean z16) {
        this.mHostActivityDelegator.superOnMultiWindowModeChanged(z16);
    }

    public void onNewIntent(Intent intent) {
        this.mHostActivityDelegator.superOnNewIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mHostActivityDelegator.superOnOptionsItemSelected(menuItem);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        this.mHostActivityDelegator.superOnPanelClosed(i3, menu);
    }

    public void onPause() {
        this.mHostActivityDelegator.superOnPause();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z16) {
        this.mHostActivityDelegator.superOnPointerCaptureChanged(z16);
    }

    public void onPostCreate(Bundle bundle) {
        this.mHostActivityDelegator.superOnPostCreate(bundle);
    }

    public void onPostResume() {
        this.mHostActivityDelegator.superOnPostResume();
    }

    public void onPrepareDialog(int i3, Dialog dialog) {
        this.mHostActivityDelegator.superOnPrepareDialog(i3, dialog);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        return this.mHostActivityDelegator.superOnPreparePanel(i3, view, menu);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3) {
        this.mHostActivityDelegator.superOnProvideKeyboardShortcuts(list, menu, i3);
    }

    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.mHostActivityDelegator.superOnRequestPermissionsResult(i3, strArr, iArr);
    }

    public void onRestart() {
        this.mHostActivityDelegator.superOnRestart();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.mHostActivityDelegator.superOnRestoreInstanceState(bundle);
    }

    public void onResume() {
        this.mHostActivityDelegator.superOnResume();
    }

    public Object onRetainNonConfigurationInstance() {
        return this.mHostActivityDelegator.superOnRetainNonConfigurationInstance();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mHostActivityDelegator.superOnSaveInstanceState(bundle);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mHostActivityDelegator.superOnSearchRequested();
    }

    public void onStart() {
        this.mHostActivityDelegator.superOnStart();
    }

    public void onStop() {
        this.mHostActivityDelegator.superOnStop();
    }

    @Override // com.tencent.shadow.core.runtime.skin.listener.ISkinUpdate
    public void onThemeUpdate() {
        Log.d(TAG, "onThemeUpdate: " + this.mSkinMap.size());
        if (this.mSkinMap.isEmpty()) {
            return;
        }
        Iterator<SkinItem> it = this.mSkinMap.values().iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mHostActivityDelegator.superOnTrackballEvent(motionEvent);
    }

    public void onUserInteraction() {
        this.mHostActivityDelegator.superOnUserInteraction();
    }

    public void onUserLeaveHint() {
        this.mHostActivityDelegator.superOnUserLeaveHint();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mHostActivityDelegator.superOnWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        this.mHostActivityDelegator.superOnWindowFocusChanged(z16);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mHostActivityDelegator.superOnWindowStartingActionMode(callback);
    }

    public void recreate() {
        this.mHostActivityDelegator.recreate();
    }

    public void setHostActivityDelegator(HostActivityDelegator hostActivityDelegator) {
        this.mHostActivityDelegator = hostActivityDelegator;
    }

    public final void setHostContextAsBase(Context context) {
        attachBaseContext(context);
    }

    public void setPluginApplication(ShadowApplication shadowApplication) {
        this.mPluginApplication = shadowApplication;
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i3) {
        this.mHostActivityDelegator.superStartActivityFromChild(activity, intent, i3);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mHostActivityDelegator.superOnCreateView(view, str, context, attributeSet);
    }

    public void onMultiWindowModeChanged(boolean z16, Configuration configuration) {
        this.mHostActivityDelegator.superOnMultiWindowModeChanged(z16, configuration);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.mHostActivityDelegator.superOnSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        return this.mHostActivityDelegator.superOnWindowStartingActionMode(callback, i3);
    }

    @Override // android.view.ContextThemeWrapper
    public void onApplyThemeResource(Resources.Theme theme, int i3, boolean z16) {
    }
}
