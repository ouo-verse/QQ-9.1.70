package com.tencent.mobileqq.intervideo.od;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl;
import com.tencent.mobileqq.intervideo.huayang.Monitor;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ODLoadingActivity extends Activity {

    /* renamed from: d, reason: collision with root package name */
    private ODQShadowLoad f238387d;

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        IVCommonInterfaceImpl.getInstance().onHostActivityResult(i3, i16, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finish();
        Monitor.b("33669910");
        IVCommonInterfaceImpl.getInstance().onHostActivityBackPress();
        this.f238387d.I();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        if (getIntent().getBooleanExtra("show_status_bar", false)) {
            setTheme(R.style.Theme.Translucent.NoTitleBar);
        }
        super.onCreate(bundle);
        ODQShadowLoad oDQShadowLoad = new ODQShadowLoad(this);
        this.f238387d = oDQShadowLoad;
        oDQShadowLoad.J(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        IVCommonInterfaceImpl.getInstance().onHostActivityDestroy();
        this.f238387d.K();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        IVCommonInterfaceImpl.getInstance().onHostActivityNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        IVCommonInterfaceImpl.getInstance().onHostActivityPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        IVCommonInterfaceImpl.getInstance().onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        IVCommonInterfaceImpl.getInstance().onHostActivityResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        IVCommonInterfaceImpl.getInstance().onHostActivityStop();
    }
}
