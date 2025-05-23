package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import com.tencent.mobileqq.mini.fake.FakeSdkBrandUI;
import com.tencent.mobileqq.mini.fake.IFakeBrandUI;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBrandUI3 extends AppBrandUI {
    private static final String COOKIE_DOMAIN = "qzone.qq.com";
    private static volatile boolean mHasOKHttpClientInit = false;

    @Override // com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI
    public IFakeBrandUI getFakeBrandUI() {
        IFakeBrandUI iFakeBrandUI = this.mFakeBrandUI;
        if (iFakeBrandUI != null) {
            return iFakeBrandUI;
        }
        FakeSdkBrandUI fakeSdkBrandUI = new FakeSdkBrandUI();
        this.mFakeBrandUI = fakeSdkBrandUI;
        return fakeSdkBrandUI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
