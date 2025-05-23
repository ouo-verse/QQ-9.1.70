package com.qzone.publish.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.qzone.common.activities.base.BaseActivityForFragmentV2;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes39.dex */
public class QZoneUploadPhotoRealActivity extends BaseActivityForFragmentV2 implements com.qzone.common.activities.titlebuilder.f {

    /* renamed from: a0, reason: collision with root package name */
    QZoneUploadPhotoActivity f51803a0;

    private void initFragment() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("QZoneNewFriendFeedFragment");
        if (findFragmentByTag != null && (findFragmentByTag instanceof QZoneUploadPhotoActivity)) {
            QLog.i(this.TAG, 1, "QZonePublishMoodActivity \u5df2\u7ecf\u6dfb\u52a0\u65e0\u9700\u91cd\u590d\u6dfb\u52a0");
            this.f51803a0 = (QZoneUploadPhotoActivity) findFragmentByTag;
        } else {
            this.f51803a0 = new QZoneUploadPhotoActivity();
            getSupportFragmentManager().beginTransaction().add(R.id.elo, this.f51803a0, "QZoneNewFriendFeedFragment").commitAllowingStateLoss();
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public void IOnSetTheme() {
        getActivity().setTheme(R.style.f173580gi);
        com.tencent.mobileqq.theme.a.f(getWindow());
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public Handler getMainHandler() {
        return getHandler();
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean needMiniAIO() {
        return false;
    }

    @Override // com.qzone.common.activities.base.BaseActivityForFragmentV2, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.blq);
        initFragment();
        vl.a aVar = new vl.a(this);
        aVar.b5(true);
        aVar.K3(getIntent());
        this.f51803a0.bm(aVar);
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected boolean shouldReportUsage() {
        return false;
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public ViewGroup Kd() {
        return (ViewGroup) findViewById(R.id.jqh);
    }
}
