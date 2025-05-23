package com.tencent.av.smallscreen;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.BaseActivity;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SmallScreenDialogActivity extends BaseActivity {

    /* renamed from: d, reason: collision with root package name */
    private BaseVideoAppInterface f74487d;

    /* renamed from: e, reason: collision with root package name */
    private b f74488e = null;

    @Override // mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.requestWindowFeature(1);
        super.onCreate(bundle);
        this.f74487d = (BaseVideoAppInterface) getAppRuntime();
        if (getIntent().getIntExtra("tag_model", 0) == 0) {
            this.f74488e = new c(this);
        } else {
            this.f74488e = null;
        }
        SmallScreenActivityPlugin.a(this.f74487d).h(true);
        b bVar = this.f74488e;
        if (bVar != null) {
            bVar.a(bundle);
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.f74488e;
        if (bVar != null) {
            bVar.b();
        }
        SmallScreenActivityPlugin.a(this.f74487d).h(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b bVar = this.f74488e;
        if (bVar != null) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b bVar = this.f74488e;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        b bVar = this.f74488e;
        if (bVar != null) {
            bVar.e();
        }
    }
}
