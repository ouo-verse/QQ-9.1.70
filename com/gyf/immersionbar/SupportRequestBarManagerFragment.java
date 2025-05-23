package com.gyf.immersionbar;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SupportRequestBarManagerFragment extends ReportAndroidXFragment {
    private ImmersionDelegate C;

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.C;
        if (immersionDelegate != null) {
            immersionDelegate.f(getResources().getConfiguration());
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.C;
        if (immersionDelegate != null) {
            immersionDelegate.g(configuration);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ImmersionDelegate immersionDelegate = this.C;
        if (immersionDelegate != null) {
            immersionDelegate.h();
            this.C = null;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersionDelegate immersionDelegate = this.C;
        if (immersionDelegate != null) {
            immersionDelegate.i();
        }
    }

    public ImmersionBar ph(Object obj) {
        if (this.C == null) {
            this.C = new ImmersionDelegate(obj);
        }
        return this.C.e();
    }
}
