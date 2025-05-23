package com.gyf.immersionbar;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class n extends ReportFragment {

    /* renamed from: d, reason: collision with root package name */
    private ImmersionDelegate f36050d;

    public ImmersionBar e(Object obj) {
        if (this.f36050d == null) {
            this.f36050d = new ImmersionDelegate(obj);
        }
        return this.f36050d.e();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.f36050d;
        if (immersionDelegate != null) {
            immersionDelegate.f(getResources().getConfiguration());
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.f36050d;
        if (immersionDelegate != null) {
            immersionDelegate.g(configuration);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ImmersionDelegate immersionDelegate = this.f36050d;
        if (immersionDelegate != null) {
            immersionDelegate.h();
            this.f36050d = null;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersionDelegate immersionDelegate = this.f36050d;
        if (immersionDelegate != null) {
            immersionDelegate.i();
        }
    }
}
