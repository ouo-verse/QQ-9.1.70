package com.qzone.feed.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.titlebuilder.QzoneBaseTitle;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneMyFeedActivity extends BaseFragment implements com.qzone.common.activities.titlebuilder.f {
    QZoneMyFeedFragment C;

    private void sh() {
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag("QZoneMyFeedFragment");
        if (findFragmentByTag != null && (findFragmentByTag instanceof QZoneMyFeedFragment)) {
            QLog.i(BaseFragment.TAG, 1, "QZoneMyFeedFragment \u5df2\u7ecf\u6dfb\u52a0\u65e0\u9700\u91cd\u590d\u6dfb\u52a0");
            this.C = (QZoneMyFeedFragment) findFragmentByTag;
        } else {
            this.C = new QZoneMyFeedFragment();
            getParentFragmentManager().beginTransaction().add(R.id.elo, this.C, "QZoneMyFeedFragment").commitAllowingStateLoss();
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.qzone.common.activities.titlebuilder.f
    public Handler getMainHandler() {
        return getHandler();
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public Activity getRealActivity() {
        return getActivity();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        sh();
        QzoneBaseTitle qzoneBaseTitle = new QzoneBaseTitle(this);
        this.C.Vh(qzoneBaseTitle);
        qzoneBaseTitle.K3(getIntent());
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public ViewGroup Kd() {
        return (ViewGroup) findViewById(R.id.jqh);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.blq, viewGroup, false);
    }
}
