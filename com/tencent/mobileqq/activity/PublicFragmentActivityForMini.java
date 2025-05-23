package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class PublicFragmentActivityForMini extends PublicFragmentActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        QLog.d("PublicFragmentActivityForMini", 1, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        MiniAppController.getInstance().notifyResultListener(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.PublicFragmentActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        MiniAppConfig miniAppConfig = (MiniAppConfig) getIntent().getParcelableExtra("CONFIG");
        if (miniAppConfig != null && miniAppConfig.isEngineTypeMiniGame()) {
            this.mNeedStatusTrans = false;
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
        return super.doOnCreate(bundle);
    }
}
