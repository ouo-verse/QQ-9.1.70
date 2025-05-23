package com.huawei.hms.hihealth;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hms.health.aabz;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class aabb implements OnFailureListener {
    final /* synthetic */ HuaweiIdAuthService aab;
    final /* synthetic */ HiHealthKitClient aaba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aabb(HiHealthKitClient hiHealthKitClient, HuaweiIdAuthService huaweiIdAuthService) {
        this.aaba = hiHealthKitClient;
        this.aab = huaweiIdAuthService;
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Activity activity;
        aabz.aabb("HiHealthKitClient", "silentSignIn failed, begin sign in");
        Intent signInIntent = this.aab.getSignInIntent();
        activity = this.aaba.aabd;
        activity.startActivityForResult(signInIntent, 1);
    }
}
