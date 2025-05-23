package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_intimate", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes10.dex */
public class IntimateInfoFragment extends PublicBaseFragment {
    private MainIntimateView C;
    private h61.d D;

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        MainIntimateView mainIntimateView = this.C;
        if (mainIntimateView != null) {
            mainIntimateView.w();
        }
        h61.d dVar = this.D;
        if (dVar != null) {
            dVar.q();
        }
        setStatusBar();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        MainIntimateView mainIntimateView = this.C;
        if (mainIntimateView instanceof IntimateInfoView) {
            ((IntimateInfoView) mainIntimateView).d0(i3, i16, intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View rootView;
        String stringExtra = getBaseActivity().getIntent().getStringExtra(AppConstants.Key.FORWARD_PEER_UIN);
        if (com.tencent.mobileqq.activity.aio.intimate.header.n.d()) {
            MainIntimateView a16 = com.tencent.mobileqq.activity.aio.intimate.f.a(getBaseActivity(), getBaseActivity(), stringExtra);
            this.C = a16;
            if (a16.r() == null) {
                rootView = null;
            } else {
                rootView = this.C.r();
            }
        } else {
            h61.d dVar = new h61.d(getQBaseActivity(), stringExtra, getLifecycleOwner());
            this.D = dVar;
            rootView = dVar.getRootView();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MainIntimateView mainIntimateView = this.C;
        if (mainIntimateView != null) {
            mainIntimateView.C();
            this.C.B();
        }
        h61.d dVar = this.D;
        if (dVar != null) {
            dVar.t();
            this.D.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MainIntimateView mainIntimateView = this.C;
        if (mainIntimateView instanceof IntimateInfoView) {
            ((IntimateInfoView) mainIntimateView).F();
        }
        h61.d dVar = this.D;
        if (dVar != null) {
            dVar.w();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MainIntimateView mainIntimateView = this.C;
        if (mainIntimateView != null) {
            mainIntimateView.M();
            this.C.p();
            MainIntimateView mainIntimateView2 = this.C;
            if (mainIntimateView2 instanceof IntimateInfoView) {
                ((IntimateInfoView) mainIntimateView2).G();
            }
        }
        h61.d dVar = this.D;
        if (dVar != null) {
            dVar.A();
            this.D.x();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainIntimateView mainIntimateView = this.C;
        if (mainIntimateView != null) {
            mainIntimateView.D();
            this.C.Q(true);
            this.C.M();
        }
        h61.d dVar = this.D;
        if (dVar != null) {
            dVar.v();
            this.D.u();
        }
    }

    public void setStatusBar() {
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) getBaseActivity());
        if (systemBarComp != null) {
            systemBarComp.setStatusDrawable(null);
            systemBarComp.setStatusBarColor(0);
            systemBarComp.setStatusColor(0);
            if (!ThemeUtil.isNowThemeIsNight(getBaseActivity().app, true, null)) {
                ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
            }
        }
    }
}
