package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.support.v4.app.Fragment;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportV4Fragment extends Fragment {
    public void onDestroyView() {
        super.onDestroyView();
        V4FragmentCollector.onDestroyView(this);
    }

    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
        V4FragmentCollector.onHiddenChanged(this, z16);
    }

    public void onPause() {
        super.onPause();
        V4FragmentCollector.onPause(this);
    }

    public void onResume() {
        super.onResume();
        V4FragmentCollector.onResume(this);
    }

    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        V4FragmentCollector.setUserVisibleHint(this, z16);
    }
}
