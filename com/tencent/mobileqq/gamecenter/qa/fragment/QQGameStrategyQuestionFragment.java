package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyQuestionControl;
import com.tencent.mobileqq.gamecenter.qa.view.bh;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyQuestionFragment extends QPublicBaseFragment {
    private QQGameStrategyQuestionControl C;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements bh.x {
        a() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.bh.x
        public void a(boolean z16) {
            QQGameStrategyQuestionFragment.this.getActivity().finish();
        }
    }

    public static Intent ph(int i3, String str, String str2, int i16, int i17) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putString(WadlProxyConsts.KEY_JUMP_URL, str);
        bundle.putString("data", str2);
        bundle.putInt("scene", i16);
        bundle.putInt("miniGameAppId", i17);
        intent.putExtras(bundle);
        return intent;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        this.C.m0(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return this.C.n0();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        com.tencent.mobileqq.gamecenter.qa.model.i iVar = new com.tencent.mobileqq.gamecenter.qa.model.i();
        if (arguments != null) {
            iVar.f212658a = arguments.getInt("appId");
            iVar.f212659b = arguments.getString(WadlProxyConsts.KEY_JUMP_URL);
            iVar.f212660c = arguments.getString("data");
            iVar.f212661d = arguments.getInt("scene");
        }
        QQGameStrategyQuestionControl qQGameStrategyQuestionControl = new QQGameStrategyQuestionControl(getQBaseActivity(), getContext(), iVar, 0, ThemeUtil.isNowThemeIsNight(null, false, null));
        this.C = qQGameStrategyQuestionControl;
        qQGameStrategyQuestionControl.f2(new a());
        View o06 = this.C.o0(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, o06);
        return o06;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.C.q0();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.C.r0();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.C.t0();
    }
}
