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
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public interface IActivityDelegate {
    boolean dispatchKeyEvent(KeyEvent keyEvent);

    void finish();

    ComponentName getCallingActivity();

    ClassLoader getClassLoader();

    LayoutInflater getLayoutInflater();

    Resources getResources();

    boolean isChangingConfigurations();

    void onActivityResult(int i3, int i16, Intent intent);

    void onApplyThemeResource(Resources.Theme theme, int i3, boolean z16);

    void onAttachFragment(Fragment fragment);

    void onAttachedToWindow();

    void onBackPressed();

    void onChildTitleChanged(Activity activity, CharSequence charSequence);

    void onConfigurationChanged(Configuration configuration);

    void onContentChanged();

    void onCreate(Bundle bundle);

    CharSequence onCreateDescription();

    Dialog onCreateDialog(int i3);

    boolean onCreatePanelMenu(int i3, Menu menu);

    View onCreatePanelView(int i3);

    boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas);

    View onCreateView(View view, String str, Context context, AttributeSet attributeSet);

    View onCreateView(String str, Context context, AttributeSet attributeSet);

    void onDestroy();

    void onDetachedFromWindow();

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    boolean onKeyUp(int i3, KeyEvent keyEvent);

    void onLowMemory();

    void onMultiWindowModeChanged(boolean z16);

    void onMultiWindowModeChanged(boolean z16, Configuration configuration);

    void onNewIntent(Intent intent);

    boolean onOptionsItemSelected(MenuItem menuItem);

    void onPanelClosed(int i3, Menu menu);

    void onPause();

    void onPictureInPictureModeChanged(boolean z16);

    void onPictureInPictureModeChanged(boolean z16, Configuration configuration);

    void onPostCreate(Bundle bundle);

    void onPostResume();

    void onPrepareDialog(int i3, Dialog dialog);

    boolean onPreparePanel(int i3, View view, Menu menu);

    void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    void onRestart();

    void onRestoreInstanceState(Bundle bundle);

    void onResume();

    Object onRetainNonConfigurationInstance();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStateNotSaved();

    void onStop();

    void onTitleChanged(CharSequence charSequence, int i3);

    boolean onTrackballEvent(MotionEvent motionEvent);

    void onUserInteraction();

    void onUserLeaveHint();

    void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams);

    void onWindowFocusChanged(boolean z16);

    void recreate();

    void startActivityFromChild(Activity activity, Intent intent, int i3);
}
