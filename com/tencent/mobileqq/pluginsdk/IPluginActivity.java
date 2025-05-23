package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.app.Fragment;
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
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;

/* loaded from: classes16.dex */
public interface IPluginActivity {
    boolean IDispatchTouchEvent(MotionEvent motionEvent);

    void IFinish();

    View IGetContentView();

    Handler IGetInHandler();

    Resources IGetResource();

    void IInit(String str, String str2, Activity activity, ClassLoader classLoader, PackageInfo packageInfo, boolean z16, int i3);

    boolean IIsWrapContent();

    void IOnActivityResult(int i3, int i16, Intent intent);

    void IOnAttachFragment(Fragment fragment);

    boolean IOnBackPressed();

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

    void IOnRestart();

    void IOnRestoreInstanceState(Bundle bundle);

    void IOnResume();

    void IOnSaveInstanceState(Bundle bundle);

    void IOnSetTheme();

    void IOnStart();

    void IOnStop();

    boolean IOnTouchEvent(MotionEvent motionEvent);

    void IOnUserInteraction();

    void IOnWindowFocusChanged(boolean z16);

    void ISetIntent(Intent intent);

    void ISetIsTab();

    void ISetOutHandler(Handler handler);

    void ISetParent(BasePluginActivity basePluginActivity);

    BasePluginActivity.ImmersiveConfig IgetImmersiveConfig();

    void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    void requestPermissions(Object obj, int i3, String... strArr);
}
