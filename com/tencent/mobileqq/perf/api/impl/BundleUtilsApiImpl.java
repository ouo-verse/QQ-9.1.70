package com.tencent.mobileqq.perf.api.impl;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.perf.api.IBundleUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BundleUtilsApiImpl implements IBundleUtilsApi {
    static IPatchRedirector $redirector_;

    public BundleUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.perf.api.IBundleUtilsApi
    public String dumpAllFragmentBundleInfo(FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) fragmentActivity);
        }
        if (fragmentActivity == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("dumpAllFragmentBundleInfo with " + fragmentActivity);
        List<Fragment> fragments = fragmentActivity.getSupportFragmentManager().getFragments();
        if (fragments != null) {
            sb5.append(" has " + fragments.size() + " Fragments");
            Iterator<Fragment> it = fragments.iterator();
            while (it.hasNext()) {
                Bundle bundle = (Bundle) ly3.c.e(it.next(), "mSavedFragmentState");
                if (bundle != null) {
                    sb5.append("\n" + com.tencent.qqperf.tools.a.b(bundle));
                }
            }
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.perf.api.IBundleUtilsApi
    public String dumpOfAll(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        }
        return com.tencent.qqperf.tools.a.b(bundle);
    }

    @Override // com.tencent.mobileqq.perf.api.IBundleUtilsApi
    public String dumpOfSelf(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        }
        return com.tencent.qqperf.tools.a.c(bundle);
    }

    @Override // com.tencent.mobileqq.perf.api.IBundleUtilsApi
    public String dumpSize(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        }
        return "" + com.tencent.qqperf.tools.a.a(com.tencent.qqperf.tools.a.d(bundle));
    }

    @Override // com.tencent.mobileqq.perf.api.IBundleUtilsApi
    public long sizeOfParcel(Parcelable parcelable) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcelable)).longValue();
        }
        if (parcelable instanceof Bundle) {
            bundle = (Bundle) parcelable;
        } else {
            bundle = null;
        }
        if (bundle != null) {
            return com.tencent.qqperf.tools.a.d(bundle);
        }
        return com.tencent.qqperf.tools.a.e(parcelable);
    }
}
