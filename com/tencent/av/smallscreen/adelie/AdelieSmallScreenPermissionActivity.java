package com.tencent.av.smallscreen.adelie;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import aw.a;
import com.tencent.av.smallscreen.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.BaseActivity;

/* loaded from: classes3.dex */
public class AdelieSmallScreenPermissionActivity extends BaseActivity {

    /* renamed from: d, reason: collision with root package name */
    private b f74579d = null;

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
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        if (getIntent().getIntExtra("tag_model", 0) == 0) {
            this.f74579d = new a(this);
        } else {
            this.f74579d = null;
        }
        b bVar = this.f74579d;
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
        b bVar = this.f74579d;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b bVar = this.f74579d;
        if (bVar != null) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b bVar = this.f74579d;
        if (bVar != null) {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        b bVar = this.f74579d;
        if (bVar != null) {
            bVar.e();
        }
    }
}
