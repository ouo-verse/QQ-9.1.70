package com.tencent.mobileqq.onlinestatus.olympic.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.olympic.helper.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OlympicShareFragment extends QPublicBaseFragment {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements c.a {
        a() {
        }
    }

    public static void ph(Activity activity, Intent intent) {
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, OlympicShareFragment.class);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        if ((i16 == -1 || i16 == 0) && getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.e(getActivity().getIntent().getLongExtra("KEY_OLYMPIC_RANK", 0L), getActivity(), (AppInterface) getQBaseActivity().getAppRuntime(), new a());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
    }
}
