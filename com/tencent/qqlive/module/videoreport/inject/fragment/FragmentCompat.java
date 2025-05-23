package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.app.Activity;
import android.view.View;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FragmentCompat {
    private Activity mActivity;
    private View mView;

    public Activity getActivity() {
        return this.mActivity;
    }

    public View getView() {
        return this.mView;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void setView(View view) {
        this.mView = view;
    }
}
