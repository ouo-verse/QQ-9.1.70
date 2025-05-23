package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class FlowActivity extends PeakActivity {
    protected ViewGroup P;
    protected int Q;
    protected boolean R = true;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.R) {
            overridePendingTransition(0, R.anim.f154458a7);
        } else {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            this.Q = (int) getResources().getDimension(R.dimen.f158869r6);
        }
        x0(extras);
        setContentView(R.layout.f167545ac);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.cg9);
        this.P = viewGroup;
        if (viewGroup != null) {
            y0(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        if (w0() == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getY() < r0.getTop()) {
            onBackPressed();
        }
        return super.onTouchEvent(motionEvent);
    }

    public View w0() {
        return this.P;
    }

    protected abstract void y0(ViewGroup viewGroup);

    protected void x0(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.Q = bundle.getInt(AECameraConstants.DATA_KEY_HEIGHT, (int) getResources().getDimension(R.dimen.f158869r6));
    }
}
