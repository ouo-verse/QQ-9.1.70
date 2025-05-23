package com.qzone.feed.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.common.activities.base.BaseFragment;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.SystemUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EmptyFragment extends BaseFragment {
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimensionPixelSize;
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setBackgroundResource(R.drawable.ate);
        View view = new View(getActivity());
        view.setBackgroundResource(R.drawable.qq_title_immersive_bar);
        int notchHeight = SystemUtil.getNotchHeight(BaseApplication.getContext(), getActivity());
        if (notchHeight > 0) {
            dimensionPixelSize = notchHeight + getActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        } else {
            dimensionPixelSize = getActivity().getResources().getDimensionPixelSize(R.dimen.azw);
        }
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, dimensionPixelSize));
        return frameLayout;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public void onBackPressed() {
    }
}
