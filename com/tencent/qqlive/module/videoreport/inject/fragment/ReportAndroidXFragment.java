package com.tencent.qqlive.module.videoreport.inject.fragment;

import androidx.fragment.app.Fragment;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportAndroidXFragment extends Fragment {
    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AndroidXFragmentCollector.onDestroyView(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
        AndroidXFragmentCollector.onHiddenChanged(this, z16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AndroidXFragmentCollector.onPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AndroidXFragmentCollector.onResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        AndroidXFragmentCollector.setUserVisibleHint(this, z16);
    }
}
