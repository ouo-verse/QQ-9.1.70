package com.tencent.gamematrix.gmcg.base.lifecycle;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGSupportLifecycleManagerFragment extends ReportFragment {
    private static final String TAG = "SupportRMFragment";
    private final CGActivityFragmentLifecycle lifecycle;

    public CGSupportLifecycleManagerFragment() {
        this(new CGActivityFragmentLifecycle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CGActivityFragmentLifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CGLog.i("CGSupportLifecycleManagerFragment onDestroy");
        this.lifecycle.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        CGLog.i("CGSupportLifecycleManagerFragment onPause");
        this.lifecycle.onPause();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        CGLog.i("CGSupportLifecycleManagerFragment onResume");
        this.lifecycle.onResume();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        CGLog.i("CGSupportLifecycleManagerFragment onStart");
        this.lifecycle.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        CGLog.i("CGSupportLifecycleManagerFragment onStop");
        this.lifecycle.onStop();
    }

    @SuppressLint({"ValidFragment"})
    public CGSupportLifecycleManagerFragment(@NonNull CGActivityFragmentLifecycle cGActivityFragmentLifecycle) {
        this.lifecycle = cGActivityFragmentLifecycle;
    }
}
