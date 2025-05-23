package com.epicgames.ue4;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.epicgames.ue4.GameActivityBase;
import com.epicgames.ue4.UE4;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameActivityExt extends FragmentActivity implements SurfaceHolder.Callback2, GameActivityBase.SurfaceListener, View.OnKeyListener, View.OnTouchListener {
    static {
        UE4.loadLibraries(false, true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GameActivity.Get().onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (GameActivityBase.singletonListener == null) {
            GameActivityBase.singletonListener = new GameActivityBase.SingletonListener() { // from class: com.epicgames.ue4.GameActivityExt.1
                @Override // com.epicgames.ue4.GameActivityBase.SingletonListener
                public GameActivityBase create(Context context) {
                    return GameActivity.CreateSingleton(context);
                }
            };
        }
        UE4.InitEngineParams initEngineParams = new UE4.InitEngineParams();
        initEngineParams.context = this;
        initEngineParams.state = bundle;
        initEngineParams.surfaceListener = GetSurfaceListener();
        initEngineParams.bLoadModulesInDLL = true;
        UE4.initEngine(initEngineParams);
        UE4.setEngineAutoPurgeEnabled(false);
        GameActivity.Get().GetMainView().setOnKeyListener(this);
        GameActivity.Get().GetMainView().setOnTouchListener(this);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        UE4.inputEvent(i3, keyEvent);
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        GameActivity.Get().onNewIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        UE4.pauseEngine(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        GameActivity.Get().onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestart() {
        UE4.restartEngine(this);
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        UE4.setEngineAutoPurgeEnabled(false);
        UE4.resumeEngine(this, GetSurfaceListener());
        super.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
        GameActivity.Get().onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        UE4.startEngine(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        UE4.stopEngine(this);
        super.onStop();
    }

    @Override // com.epicgames.ue4.GameActivityBase.SurfaceListener
    public void onSurfaceChanged(Surface surface) {
        UE4.resizeWindow(this, surface);
    }

    @Override // com.epicgames.ue4.GameActivityBase.SurfaceListener
    public void onSurfaceCreated(Surface surface) {
        UE4.initWindow(surface);
    }

    @Override // com.epicgames.ue4.GameActivityBase.SurfaceListener
    public void onSurfaceDestroyed(Surface surface) {
        UE4.terminateWindow(surface);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        UE4.inputEvent(motionEvent);
        return true;
    }

    public void refreshEngine() {
        UE4.refreshEngine((Context) this, true);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        GameActivity.Get().surfaceChanged(surfaceHolder, i3, i16, i17);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        GameActivity.Get().surfaceCreated(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        GameActivity.Get().surfaceDestroyed(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        GameActivity.Get().surfaceRedrawNeeded(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        GameActivity.Get().surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    public GameActivityBase.SurfaceListener GetSurfaceListener() {
        return this;
    }

    @Override // com.epicgames.ue4.GameActivityBase.SurfaceListener
    public void onSurfaceRedrawNeeded(Surface surface) {
    }
}
