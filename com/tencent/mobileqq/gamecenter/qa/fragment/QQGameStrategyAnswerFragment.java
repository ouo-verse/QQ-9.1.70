package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyAnswerControl;
import com.tencent.mobileqq.gamecenter.qa.view.bh;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyAnswerFragment extends QPublicBaseFragment {
    private QQGameStrategyAnswerControl C;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements bh.x {
        a() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.bh.x
        public void a(boolean z16) {
            QQGameStrategyAnswerFragment.this.getActivity().finish();
        }
    }

    public static Intent ph(int i3, long j3, String str, String str2, String str3, int i16, int i17) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putLong("questionId", j3);
        bundle.putString("questionContent", str);
        bundle.putString(WadlProxyConsts.KEY_JUMP_URL, str2);
        bundle.putString("data", str3);
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
        Bundle arguments = getArguments();
        com.tencent.mobileqq.gamecenter.qa.model.h hVar = new com.tencent.mobileqq.gamecenter.qa.model.h();
        if (arguments != null) {
            hVar.f212650a = arguments.getInt("appId");
            hVar.f212651b = arguments.getLong("questionId");
            hVar.f212652c = arguments.getString("questionContent");
            hVar.f212653d = arguments.getString(WadlProxyConsts.KEY_JUMP_URL);
            hVar.f212656g = arguments.getString("data");
            hVar.f212657h = arguments.getInt("scene");
        }
        QQGameStrategyAnswerControl qQGameStrategyAnswerControl = new QQGameStrategyAnswerControl(getQBaseActivity(), getContext(), hVar, 0, ThemeUtil.isNowThemeIsNight(null, false, null));
        this.C = qQGameStrategyAnswerControl;
        qQGameStrategyAnswerControl.f2(new a());
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
