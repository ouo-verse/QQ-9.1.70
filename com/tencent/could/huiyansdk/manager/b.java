package com.tencent.could.huiyansdk.manager;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.fragments.BaseFragment;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f100128a;

    /* renamed from: b, reason: collision with root package name */
    public FragmentManager f100129b;

    /* renamed from: c, reason: collision with root package name */
    public FragmentTransaction f100130c;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f100131a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18899);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100131a = new b();
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100128a = "";
        }
    }

    public void a(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        if (this.f100129b == null) {
            activity.finish();
            return;
        }
        BaseFragment a16 = a();
        if (a16 != null) {
            a16.a();
        }
        FragmentManager fragmentManager = this.f100129b;
        if (fragmentManager == null) {
            return;
        }
        if (fragmentManager.getBackStackEntryCount() <= 1) {
            activity.finish();
        } else {
            this.f100129b.popBackStack();
        }
    }

    public void b(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fragment);
            return;
        }
        if (this.f100129b != null && fragment != null) {
            if (HuiYanSdkImp.getInstance().isExitDoNeedShow()) {
                k.a.f100197a.a(2, "AuthFragmentManager", "Activity is exit, do can not change fragment");
                return;
            }
            this.f100130c = this.f100129b.beginTransaction();
            this.f100129b.findFragmentById(R.id.f113586r1);
            this.f100130c.replace(R.id.f113586r1, fragment).commitAllowingStateLoss();
        }
    }

    public void a(Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragment);
            return;
        }
        FragmentManager fragmentManager = this.f100129b;
        if (fragmentManager == null || fragment == null) {
            return;
        }
        this.f100130c = fragmentManager.beginTransaction();
        this.f100129b.findFragmentById(R.id.f113586r1);
        this.f100130c.replace(R.id.f113586r1, fragment).addToBackStack(null).commit();
    }

    public BaseFragment a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseFragment) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        FragmentManager fragmentManager = this.f100129b;
        if (fragmentManager == null) {
            return null;
        }
        Fragment findFragmentById = fragmentManager.findFragmentById(R.id.f113586r1);
        if (findFragmentById instanceof BaseFragment) {
            return (BaseFragment) findFragmentById;
        }
        return null;
    }
}
