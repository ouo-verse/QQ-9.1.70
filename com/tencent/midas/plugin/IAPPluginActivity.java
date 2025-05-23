package com.tencent.midas.plugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes9.dex */
public interface IAPPluginActivity {
    boolean IDispatchTouchEvent(MotionEvent motionEvent);

    void IFinish();

    View IGetContentView();

    Handler IGetInHandler();

    Resources IGetResource();

    void IInit(String str, String str2, Activity activity, ClassLoader classLoader, PackageInfo packageInfo);

    boolean IIsWrapContent();

    void IOnActivityResult(int i3, int i16, Intent intent);

    void IOnConfigurationChanged(Configuration configuration);

    void IOnCreate(Bundle bundle);

    boolean IOnCreateOptionsMenu(Menu menu);

    void IOnDestroy();

    boolean IOnKeyDown(int i3, KeyEvent keyEvent);

    boolean IOnKeyMultiple(int i3, int i16, KeyEvent keyEvent);

    boolean IOnKeyUp(int i3, KeyEvent keyEvent);

    boolean IOnMenuItemSelected(int i3, MenuItem menuItem);

    void IOnNewIntent(Intent intent);

    boolean IOnOptionsItemSelected(MenuItem menuItem);

    void IOnPause();

    boolean IOnPrepareOptionsMenu(Menu menu);

    @TargetApi(23)
    void IOnRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    void IOnRestart();

    void IOnRestoreInstanceState(Bundle bundle);

    void IOnResume();

    void IOnSaveInstanceState(Bundle bundle);

    void IOnStart();

    void IOnStop();

    boolean IOnTouchEvent(MotionEvent motionEvent);

    void IOnUserInteraction();

    void IOnWindowFocusChanged(boolean z16);

    @TargetApi(23)
    void IRequestPermissions(String[] strArr, int i3);

    void ISetIntent(Intent intent);

    void ISetOutHandler(Handler handler);
}
