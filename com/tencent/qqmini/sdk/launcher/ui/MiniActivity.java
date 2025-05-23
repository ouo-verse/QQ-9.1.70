package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniActivity extends Activity {
    protected static final String TAG = "MiniActivity";
    private Intent mIntent;
    private IUIProxy mUIProxy;

    private static MiniAppInfo getMiniAppInfoFromIntent(Intent intent) {
        try {
            return (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        } catch (Exception e16) {
            QMLog.e(TAG, "Failed to getMiniAppInfoFromIntent", e16);
            return null;
        }
    }

    private void initUIProxy(Intent intent) {
        if (intent == null) {
            QMLog.e(TAG, "Failed to initUIProxy, intent is null");
            return;
        }
        MiniAppInfo miniAppInfoFromIntent = getMiniAppInfoFromIntent(intent);
        this.mIntent = intent;
        this.mUIProxy = AppLoaderFactory.g().getMiniAppEnv().getUIProxy(miniAppInfoFromIntent);
    }

    public static void setActivityFullScreen(Activity activity) {
        Window window;
        if (activity != null && !activity.isFinishing() && (window = activity.getWindow()) != null) {
            window.getDecorView().setSystemUiVisibility(23075586);
            window.addFlags(67108864);
            window.addFlags(134218752);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onActivityResult(this, i3, i16, intent);
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z16;
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            z16 = iUIProxy.onBackPressed(this);
        } else {
            z16 = false;
        }
        if (!z16 && !moveTaskToBack(false)) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QMLog.e(TAG, "onConfigurationChanged screenWidthDp=" + configuration.screenWidthDp + ", screenHeightDp=" + configuration.screenHeightDp);
        this.mUIProxy.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Uri uri;
        QMLog.i(TAG, this + " onCreate(). " + getIntent());
        super.onCreate(bundle);
        MiniSDK.init(getApplicationContext());
        Intent intent = getIntent();
        if (intent != null) {
            MiniAppInfo miniAppInfoFromIntent = getMiniAppInfoFromIntent(intent);
            if (miniAppInfoFromIntent != null && miniAppInfoFromIntent.isEngineTypeMiniGame()) {
                DisplayUtil.setActivityTransparent(this);
            } else {
                requestWindowFeature(1);
                getWindow().addFlags(1);
                getWindow().addFlags(67108864);
            }
        }
        RelativeLayout relativeLayout = new RelativeLayout(this);
        setContentView(relativeLayout);
        FrameLayout frameLayout = new FrameLayout(this);
        relativeLayout.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        AppLoaderFactory.g().getMiniAppEnv().setupWithIntent(intent);
        initUIProxy(getIntent());
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy == null) {
            QMLog.e(TAG, "onCreate(). Failed to start MiniActivity, UIProxy is null!");
            finish();
            return;
        }
        iUIProxy.onAttachActivity(this, bundle, frameLayout);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this);
        sb5.append(" onCreate(). ");
        if (intent != null) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        sb5.append(uri);
        QMLog.e(TAG, sb5.toString());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        QMLog.i(TAG, this + " onDestroy(). " + getIntent());
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onDetachActivity(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        boolean z16;
        if (i3 == 4) {
            IUIProxy iUIProxy = this.mUIProxy;
            if (iUIProxy != null) {
                z16 = iUIProxy.onBackPressed(this);
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
            if (!moveTaskToBack(false)) {
                finish();
            }
            return false;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        QMLog.i(TAG, this + " onNewIntent(). " + intent);
        initUIProxy(intent);
        if (this.mUIProxy == null) {
            QMLog.e(TAG, "onNewIntent(). Failed to start MiniActivity, UIProxy is null!");
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        QMLog.i(TAG, this + " onPause(). " + getIntent());
        super.onPause();
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniPause();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onRequestPermissionsResult(this, i3, strArr, iArr);
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        QMLog.i(TAG, this + " onResume(). " + getIntent());
        super.onResume();
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            Intent intent = this.mIntent;
            if (intent != null) {
                iUIProxy.onIntentUpdate(intent);
                this.mIntent = null;
            }
            this.mUIProxy.onMiniResume();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        QMLog.i(TAG, this + " onStart(). " + getIntent());
        super.onStart();
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniStart();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        QMLog.i(TAG, this + " onStop(). " + getIntent());
        super.onStop();
        IUIProxy iUIProxy = this.mUIProxy;
        if (iUIProxy != null) {
            iUIProxy.onMiniStop();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        setActivityFullScreen(this);
        super.onWindowFocusChanged(z16);
    }
}
