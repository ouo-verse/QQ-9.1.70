package com.tencent.pubaccount.publish;

import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.qzone.common.activities.base.BaseActivityForFragmentV2;
import com.qzone.common.activities.titlebuilder.f;
import com.tencent.mobileqq.R;

/* loaded from: classes34.dex */
public class QQPublicAccountPublishFeedActivity extends BaseActivityForFragmentV2 implements f {

    /* renamed from: a0, reason: collision with root package name */
    Fragment f342282a0;

    @Override // com.qzone.common.activities.titlebuilder.f
    public Handler getMainHandler() {
        return getHandler();
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean needMiniAIO() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivityForFragmentV2, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.blq);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(getMainFragmentId());
        this.f342282a0 = findFragmentById;
        if (findFragmentById == null) {
            this.f342282a0 = new QQPublicAccountPublishFeedFragment();
            getSupportFragmentManager().beginTransaction().add(getMainFragmentId(), this.f342282a0).commitAllowingStateLoss();
        }
        b bVar = new b(this);
        bVar.K3(getIntent());
        Fragment fragment = this.f342282a0;
        if (fragment instanceof QQPublicAccountPublishFeedFragment) {
            ((QQPublicAccountPublishFeedFragment) fragment).bm(bVar);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public ViewGroup Kd() {
        return (ViewGroup) findViewById(R.id.jqh);
    }
}
