package com.tencent.could.huiyansdk.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BaseFragment extends ReportAndroidXFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public View f100069a;

    public BaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (getActivity() == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        if (activity.isFinishing()) {
            return;
        }
        FragmentActivity activity2 = getActivity();
        Objects.requireNonNull(activity2);
        activity2.finish();
    }

    public Resources c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Resources) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (!isAdded()) {
            Context resContext = HuiYanSdkImp.getInstance().getResContext();
            if (resContext != null) {
                return resContext.getResources();
            }
            Context a16 = HuiYanBaseApi.b.f100031a.a();
            if (a16 != null) {
                return a16.getResources();
            }
        }
        return getResources();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else if (this.f100069a != null) {
            HuiYanSdkImp.getInstance().onMainViewCreate(this.f100069a);
            onCreateView = this.f100069a;
        } else {
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        HuiYanSdkImp.getInstance().onMainViewDestroy();
        if (this.f100069a != null) {
            this.f100069a = null;
        }
        super.onDestroy();
    }

    public void a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else {
            k.a.f100197a.a(2, "BaseFragment", "fragment attach activity is null");
        }
    }
}
