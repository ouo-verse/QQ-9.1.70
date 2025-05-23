package com.tencent.minibox.dynamic.api;

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
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class BaseActivityDelegate implements IActivityDelegate {
    private final IActivityDelegator mDelegator;

    public BaseActivityDelegate(IActivityDelegator iActivityDelegator) {
        this.mDelegator = iActivityDelegator;
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mDelegator.superDispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void finish() {
        this.mDelegator.superFinish();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public ComponentName getCallingActivity() {
        return this.mDelegator.superGetCallingActivity();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public ClassLoader getClassLoader() {
        return this.mDelegator.superGetClassLoader();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public LayoutInflater getLayoutInflater() {
        return this.mDelegator.superGetLayoutInflater();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public Resources getResources() {
        return this.mDelegator.superGetResources();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean isChangingConfigurations() {
        return this.mDelegator.superIsChangingConfigurations();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onActivityResult(int i3, int i16, Intent intent) {
        this.mDelegator.superOnActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onApplyThemeResource(Resources.Theme theme, int i3, boolean z16) {
        this.mDelegator.superOnApplyThemeResource(theme, i3, z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onAttachFragment(Fragment fragment) {
        this.mDelegator.superOnAttachFragment(fragment);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onAttachedToWindow() {
        this.mDelegator.superOnAttachedToWindow();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onBackPressed() {
        this.mDelegator.superOnBackPressed();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        this.mDelegator.superOnChildTitleChanged(activity, charSequence);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onConfigurationChanged(Configuration configuration) {
        this.mDelegator.superOnConfigurationChanged(configuration);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onContentChanged() {
        this.mDelegator.superOnContentChanged();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onCreate(Bundle bundle) {
        this.mDelegator.superOnCreate(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public CharSequence onCreateDescription() {
        return this.mDelegator.superOnCreateDescription();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public Dialog onCreateDialog(int i3) {
        return this.mDelegator.superOnCreateDialog(i3);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return this.mDelegator.superOnCreateOptionsMenu(menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 == 0) {
            return onCreateOptionsMenu(menu);
        }
        return this.mDelegator.superOnCreatePanelMenu(i3, menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public View onCreatePanelView(int i3) {
        return this.mDelegator.superOnCreatePanelView(i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mDelegator.superOnCreateThumbnail(bitmap, canvas);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mDelegator.superOnCreateView(str, context, attributeSet);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onDestroy() {
        this.mDelegator.superOnDestroy();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onDetachedFromWindow() {
        this.mDelegator.superOnDetachedFromWindow();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        return this.mDelegator.superOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        return this.mDelegator.superOnKeyUp(i3, keyEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onLowMemory() {
        this.mDelegator.superOnLowMemory();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onMultiWindowModeChanged(boolean z16) {
        this.mDelegator.superOnMultiWindowModeChanged(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onNewIntent(Intent intent) {
        this.mDelegator.superOnNewIntent(intent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mDelegator.superOnOptionsItemSelected(menuItem);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onPanelClosed(int i3, Menu menu) {
        this.mDelegator.superOnPanelClosed(i3, menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onPause() {
        this.mDelegator.superOnPause();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onPictureInPictureModeChanged(boolean z16) {
        this.mDelegator.superOnPictureInPictureModeChanged(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onPostCreate(Bundle bundle) {
        this.mDelegator.superOnPostCreate(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onPostResume() {
        this.mDelegator.superOnPostResume();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onPrepareDialog(int i3, Dialog dialog) {
        this.mDelegator.superOnPrepareDialog(i3, dialog);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        return this.mDelegator.superOnPreparePanel(i3, view, menu);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.mDelegator.superOnRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onRestart() {
        this.mDelegator.superOnRestart();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onRestoreInstanceState(Bundle bundle) {
        this.mDelegator.superOnRestoreInstanceState(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onResume() {
        this.mDelegator.superOnResume();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public Object onRetainNonConfigurationInstance() {
        return this.mDelegator.superOnRetainNonConfigurationInstance();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onSaveInstanceState(Bundle bundle) {
        this.mDelegator.superOnSaveInstanceState(bundle);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onStart() {
        this.mDelegator.superOnStart();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onStateNotSaved() {
        this.mDelegator.superOnStateNotSaved();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onStop() {
        this.mDelegator.superOnStop();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onTitleChanged(CharSequence charSequence, int i3) {
        this.mDelegator.superOnTitleChanged(charSequence, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mDelegator.superOnTrackballEvent(motionEvent);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onUserInteraction() {
        this.mDelegator.superOnUserInteraction();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onUserLeaveHint() {
        this.mDelegator.superOnUserLeaveHint();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mDelegator.superOnWindowAttributesChanged(layoutParams);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onWindowFocusChanged(boolean z16) {
        this.mDelegator.superOnWindowFocusChanged(z16);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void recreate() {
        this.mDelegator.superRecreate();
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void startActivityFromChild(Activity activity, Intent intent, int i3) {
        this.mDelegator.superStartActivityFromChild(activity, intent, i3);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mDelegator.superOnCreateView(view, str, context, attributeSet);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onMultiWindowModeChanged(boolean z16, Configuration configuration) {
        this.mDelegator.superOnMultiWindowModeChanged(z16, configuration);
    }

    @Override // com.tencent.minibox.dynamic.api.IActivityDelegate
    public void onPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        this.mDelegator.superOnPictureInPictureModeChanged(z16, configuration);
    }
}
