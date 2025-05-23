package com.qzone.proxy.vipcomponent.ui;

import android.os.Bundle;
import com.qzone.common.activities.base.BaseActivity;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class QzoneOpenBaseActivity extends BaseActivity {
    protected abstract boolean Q2();

    protected void R2() {
        waitAppRuntime();
    }

    public abstract void checkLock();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public int getFeedListBackgroundId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Q2()) {
            finish();
            return;
        }
        checkLock();
        if (MobileQQ.getMobileQQ().isRuntimeReady()) {
            R2();
        }
        registerEvents();
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterEvents();
    }

    public abstract void registerEvents();

    public abstract void unregisterEvents();
}
