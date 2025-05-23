package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.app.Fragment;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportFragment extends Fragment {
    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentCollector.onDestroyView(this);
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
        FragmentCollector.onHiddenChanged(this, z16);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentCollector.onPause(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentCollector.onResume(this);
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        FragmentCollector.setUserVisibleHint(this, z16);
    }
}
