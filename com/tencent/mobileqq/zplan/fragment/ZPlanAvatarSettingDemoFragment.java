package com.tencent.mobileqq.zplan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.zplan.view.ZPlanAvatarSettingLoadingView;

/* loaded from: classes34.dex */
public class ZPlanAvatarSettingDemoFragment extends QPublicBaseFragment {
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final ZPlanAvatarSettingLoadingView zPlanAvatarSettingLoadingView = (ZPlanAvatarSettingLoadingView) view.findViewById(R.id.f163625r44);
        zPlanAvatarSettingLoadingView.g();
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.fragment.ZPlanAvatarSettingDemoFragment.1
            @Override // java.lang.Runnable
            public void run() {
                zPlanAvatarSettingLoadingView.b();
            }
        }, 12000L);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.d2x, viewGroup, false);
    }
}
