package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class o implements Handler.Callback {
    private final Map<String, SupportRequestBarManagerFragment> C;

    /* renamed from: d, reason: collision with root package name */
    private final String f36051d;

    /* renamed from: e, reason: collision with root package name */
    private final String f36052e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f36053f;

    /* renamed from: h, reason: collision with root package name */
    private final Map<FragmentManager, n> f36054h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<androidx.fragment.app.FragmentManager, SupportRequestBarManagerFragment> f36055i;

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, n> f36056m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final o f36057a = new o();
    }

    private static <T> void a(@Nullable T t16, @NonNull String str) {
        if (t16 != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    private n d(FragmentManager fragmentManager, String str) {
        return e(fragmentManager, str, false);
    }

    private n e(FragmentManager fragmentManager, String str, boolean z16) {
        List<Fragment> fragments;
        n nVar = (n) fragmentManager.findFragmentByTag(str);
        if (nVar == null && (nVar = this.f36054h.get(fragmentManager)) == null) {
            if (z16) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                fragments = fragmentManager.getFragments();
                for (Fragment fragment : fragments) {
                    if (fragment instanceof n) {
                        String tag = fragment.getTag();
                        if (tag == null) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        } else if (tag.contains(".tag.notOnly.")) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        }
                    }
                }
            }
            nVar = new n();
            this.f36054h.put(fragmentManager, nVar);
            fragmentManager.beginTransaction().add(nVar, str).commitAllowingStateLoss();
            this.f36053f.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (z16) {
            if (this.f36056m.get(str) == null) {
                this.f36056m.put(str, nVar);
                fragmentManager.beginTransaction().remove(nVar).commitAllowingStateLoss();
                this.f36053f.obtainMessage(3, str).sendToTarget();
            }
            return null;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o f() {
        return b.f36057a;
    }

    private SupportRequestBarManagerFragment g(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return h(fragmentManager, str, false);
    }

    private SupportRequestBarManagerFragment h(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z16) {
        SupportRequestBarManagerFragment supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestBarManagerFragment == null && (supportRequestBarManagerFragment = this.f36055i.get(fragmentManager)) == null) {
            if (z16) {
                return null;
            }
            for (androidx.fragment.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment instanceof SupportRequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    }
                }
            }
            supportRequestBarManagerFragment = new SupportRequestBarManagerFragment();
            this.f36055i.put(fragmentManager, supportRequestBarManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestBarManagerFragment, str).commitAllowingStateLoss();
            this.f36053f.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (z16) {
            if (this.C.get(str) == null) {
                this.C.put(str, supportRequestBarManagerFragment);
                fragmentManager.beginTransaction().remove(supportRequestBarManagerFragment).commitAllowingStateLoss();
                this.f36053f.obtainMessage(4, str).sendToTarget();
            }
            return null;
        }
        return supportRequestBarManagerFragment;
    }

    public ImmersionBar b(Activity activity, boolean z16) {
        a(activity, "activity is null");
        String str = this.f36051d + activity.getClass().getName();
        if (!z16) {
            str = str + System.identityHashCode(activity) + ".tag.notOnly.";
        }
        if (activity instanceof FragmentActivity) {
            return g(((FragmentActivity) activity).getSupportFragmentManager(), str).ph(activity);
        }
        return d(activity.getFragmentManager(), str).e(activity);
    }

    public ImmersionBar c(androidx.fragment.app.Fragment fragment, boolean z16) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f36051d + fragment.getClass().getName();
        if (!z16) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return g(fragment.getChildFragmentManager(), str).ph(fragment);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return false;
                    }
                    this.C.remove((String) message.obj);
                    return true;
                }
                this.f36056m.remove((String) message.obj);
                return true;
            }
            this.f36055i.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
        this.f36054h.remove((FragmentManager) message.obj);
        return true;
    }

    o() {
        this.f36051d = ImmersionBar.class.getName() + ".";
        this.f36052e = ".tag.notOnly.";
        this.f36054h = new HashMap();
        this.f36055i = new HashMap();
        this.f36056m = new HashMap();
        this.C = new HashMap();
        this.f36053f = new Handler(Looper.getMainLooper(), this);
    }
}
