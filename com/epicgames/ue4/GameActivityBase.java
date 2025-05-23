package com.epicgames.ue4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameActivityBase extends GameActivityContext {
    private static Handler _UIHandler = null;
    public static boolean bAllowDisplayConfigurationRequest = false;
    public static Activity clientActivity;
    public static GameActivityBase singleton;
    public static SingletonListener singletonListener;
    public static SurfaceListener surfaceListener;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface SingletonListener {
        GameActivityBase create(Context context);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface SurfaceListener {
        void onSurfaceChanged(Surface surface);

        void onSurfaceCreated(Surface surface);

        void onSurfaceDestroyed(Surface surface);

        void onSurfaceRedrawNeeded(Surface surface);
    }

    public GameActivityBase(Context context) {
        super(context);
    }

    public static void AcquireSensors() {
        GetSingleton().acquireSensors();
    }

    public static GameActivityBase Get() {
        UE4.ensureNotNull(singleton);
        return singleton;
    }

    public static Activity GetActivity() {
        Context GetContext = GetContext();
        if (GetContext != null && (GetContext instanceof Activity)) {
            return (Activity) GetContext;
        }
        return null;
    }

    public static Context GetContext() {
        GameActivityBase gameActivityBase = singleton;
        if (gameActivityBase != null) {
            return gameActivityBase.getContext();
        }
        return null;
    }

    public static GameActivityBase GetSingleton() {
        UE4.ensureNotNull(singleton);
        return singleton;
    }

    public static SurfaceListener GetSurfaceListener() {
        UE4.ensureNotNull(surfaceListener);
        return surfaceListener;
    }

    @Deprecated
    public static void Init(Context context) {
        InitSingleton(context);
    }

    public static void InitSingleton(Context context) {
        UE4.ensureNotNull(singletonListener);
        singleton = singletonListener.create(context);
    }

    public static boolean IsShippingBuild() {
        return GetSingleton().isShippingBuild();
    }

    public static void OnConfigurationChanged(Configuration configuration) {
        GetSingleton().onConfigurationChanged(configuration);
    }

    public static void OnCreate(Bundle bundle, boolean z16) {
        GetSingleton().onCreate(bundle, z16);
    }

    public static void OnDestroy() {
        GetSingleton().onDestroy();
    }

    public static boolean OnKeyDown(int i3, KeyEvent keyEvent) {
        return GetSingleton().onKeyDown(i3, keyEvent);
    }

    public static void OnPause() {
        GetSingleton().onPause();
    }

    public static void OnRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        GetSingleton().onRequestPermissionsResult(i3, strArr, iArr);
    }

    public static void OnRestart() {
        GetSingleton().onRestart();
    }

    public static void OnResume() {
        GetSingleton().onResume();
    }

    public static void OnSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        GetSingleton().onSaveInstanceState(bundle, persistableBundle);
    }

    public static void OnStart() {
        GetSingleton().onStart();
    }

    public static void OnStop() {
        GetSingleton().onStop();
    }

    public static void ReleaseSensors() {
        GetSingleton().releaseSensors();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void RunOnUiThread(Runnable runnable) {
        Activity GetActivity = GetActivity();
        if (GetActivity != null) {
            GetActivity.runOnUiThread(runnable);
            return;
        }
        if (_UIHandler == null) {
            _UIHandler = new Handler(Looper.getMainLooper());
        }
        _UIHandler.post(runnable);
    }

    public static void SetContext(Context context) {
        if (context == null) {
            context = UE4.getDefaultContext();
            UE4.logMessage("GameActivityBase.SetContext: use DefaultContext " + context);
        }
        UE4.lockOrUnlockDeviceOrientation(context);
        GameActivityBase gameActivityBase = singleton;
        if (gameActivityBase != null) {
            gameActivityBase.setContext(context);
        }
    }

    public static void ensure(boolean z16, String str) {
        UE4.ensure(z16, str);
    }

    public static void ensureNotNull(Object obj) {
        UE4.ensure(obj);
    }

    public static void throwError(String str) {
        UE4.throwError(str);
    }

    public Context getContext() {
        return null;
    }

    public boolean isShippingBuild() {
        UE4.unimplemented();
        return true;
    }

    public void onCreate(Bundle bundle) {
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        return false;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        GetSurfaceListener().onSurfaceChanged(surfaceHolder.getSurface());
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        GetSurfaceListener().onSurfaceCreated(surfaceHolder.getSurface());
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        GetSurfaceListener().onSurfaceDestroyed(surfaceHolder.getSurface());
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        GetSurfaceListener().onSurfaceRedrawNeeded(surfaceHolder.getSurface());
    }

    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        surfaceRedrawNeeded(surfaceHolder);
        runnable.run();
    }

    public static void OnCreate(Bundle bundle, FrameLayout frameLayout) {
        GetSingleton().onCreate(bundle, frameLayout);
    }

    public static void ensure(boolean z16) {
        UE4.ensure(z16);
    }

    public void onCreate(Bundle bundle, FrameLayout frameLayout) {
    }

    public static void ensure(Object obj) {
        UE4.ensure(obj);
    }

    public void onCreate(Bundle bundle, boolean z16) {
    }

    public void acquireSensors() {
    }

    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPause() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void releaseSensors() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onSurfaceChanged(Surface surface) {
    }

    public void onSurfaceCreated(Surface surface) {
    }

    public void onSurfaceDestroyed(Surface surface) {
    }

    public void onSurfaceRedrawNeeded(Surface surface) {
    }

    public void setContext(Context context) {
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i3, int i16, Intent intent) {
    }

    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
    }
}
