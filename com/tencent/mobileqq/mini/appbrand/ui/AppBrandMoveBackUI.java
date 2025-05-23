package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandMoveBackUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBrandMoveBackUI extends MiniBaseActivity {
    protected static final String TAG = "AppBrandMoveBackUI";

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        finish();
        super.onEnterAnimationComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        QLog.d(TAG, 1, "finish");
        setResult(-1);
        super.finish();
        overridePendingTransition(R.anim.f154698q7, R.anim.f154699q8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        super.onCreate(bundle);
        QLog.d(TAG, 1, this + " onCreate(). " + getIntent() + "Task ID:" + getTaskId());
        Intent intent = getIntent();
        if (intent != null) {
            Bitmap shotBitmap = AppBrandMoveBackUtil.getShotBitmap(intent);
            if (shotBitmap != null) {
                QLog.d(TAG, 1, this + "setBackground shot Bitmap");
                getWindow().getDecorView().setBackground(new BitmapDrawable(shotBitmap));
                return;
            }
            QLog.d(TAG, 1, this + "binder bitmap is null.");
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.qui_common_bg_bottom_light));
        }
    }
}
