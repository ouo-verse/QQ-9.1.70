package com.tencent.aelight.camera.aioeditor.takevideo.artfilter;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.f;
import com.tencent.qphone.base.util.QLog;
import lr.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ArtFilterBridgeActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    int f67941a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    volatile int f67942b0 = 200;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class DownloadFilterRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final QQAppInterface f67943d;

        public DownloadFilterRunnable(QQAppInterface qQAppInterface) {
            this.f67943d = qQAppInterface;
        }

        @Override // java.lang.Runnable
        public void run() {
            QQAppInterface qQAppInterface = this.f67943d;
            f.j(qQAppInterface, qQAppInterface.getApplication());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doOnCreate createElseRestore: ");
        sb5.append(bundle == null);
        QLog.e("ArtFilterBridgeActivity", 1, sb5.toString());
        super.doOnCreate(bundle);
        if (bundle == null) {
            a.a(this, getIntent());
            startActivityForResult(getIntent(), 88);
        }
        ThreadManagerV2.excute(new DownloadFilterRunnable(this.app), 64, null, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QLog.e("ArtFilterBridgeActivity", 1, "onActivityResult requestCode: " + i3 + " resultCode: " + i16);
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("mark_from_artfilter_bridge_activity", true);
        super.setResult(i16, intent);
        finish();
    }
}
