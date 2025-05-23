package com.tencent.mobileqq.pad;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final FragmentActivity f257100a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Fragment> f257101b;

    /* renamed from: c, reason: collision with root package name */
    private final Deque<j> f257102c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f257103d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f257104a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44430);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[LaunchMode.values().length];
            f257104a = iArr;
            try {
                iArr[LaunchMode.singleTop.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f257104a[LaunchMode.singleTask.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f257104a[LaunchMode.standard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public k(FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentActivity);
            return;
        }
        this.f257102c = new LinkedList();
        this.f257103d = new AtomicInteger();
        this.f257100a = fragmentActivity;
    }

    private String a(Intent intent, String str, FragmentTransaction fragmentTransaction, LaunchParam launchParam) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fragment fragment = (Fragment) Class.forName(str).newInstance();
        fragment.setArguments(intent.getBundleExtra("extra_argument"));
        String valueOf = String.valueOf(this.f257103d.addAndGet(1));
        fragmentTransaction.add(R.id.ve8, fragment, valueOf);
        fragmentTransaction.addToBackStack(valueOf);
        this.f257102c.addFirst(new j(str, valueOf, launchParam.c()));
        return valueOf;
    }

    private void b(@NonNull Fragment fragment) {
        if (fragment instanceof g) {
            return;
        }
        throw new IllegalArgumentException("start supreme fragment which is not a QFragmentExtraSupreme: " + fragment.getClass().getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(FragmentManager fragmentManager, @NonNull String str, boolean z16, boolean z17, String str2) {
        boolean f16 = f(str, str2);
        if (!f16 || !z17) {
            if (!f16 && z16) {
                Fragment g16 = g();
                if (g16 != 0 && !g16.isHidden()) {
                    QLog.d("QFragmentStackManager", 1, "hide supreme form clear: " + g16.getClass().getName());
                    ((g) g16).d5(2);
                    fragmentManager.beginTransaction().hide(g16).commitAllowingStateLoss();
                    h.b().a();
                    this.f257101b = null;
                }
                str = null;
                str2 = null;
            } else {
                QLog.d("QFragmentStackManager", 1, "don't need to clear: " + str);
                return;
            }
        }
        while (!this.f257102c.isEmpty() && !this.f257102c.peek().a().equals(h(str, str2))) {
            fragmentManager.popBackStack();
            this.f257102c.poll();
        }
    }

    private boolean f(String str, String str2) {
        Iterator<j> it = this.f257102c.iterator();
        while (it.hasNext()) {
            if (it.next().a().equals(h(str, str2))) {
                return true;
            }
        }
        return false;
    }

    private Fragment g() {
        WeakReference<Fragment> weakReference = this.f257101b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private String h(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        return str;
    }

    private boolean j() {
        FragmentActivity fragmentActivity = this.f257100a;
        if (fragmentActivity == null) {
            QLog.e("QFragmentStackManager", 1, "fragmentActivity is null");
            return true;
        }
        if (fragmentActivity.getSupportFragmentManager().isStateSaved()) {
            QLog.e("QFragmentStackManager", 1, "FragmentManager state has already saved after onSaveInstanceState");
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String k(Intent intent, LaunchParam launchParam, String str, FragmentManager fragmentManager) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String r16;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.setCustomAnimations(launchParam.a(), launchParam.b(), launchParam.f(), launchParam.g());
        j peek = this.f257102c.peek();
        if (peek != null && peek.a().equals(h(str, launchParam.c()))) {
            r16 = peek.c();
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(r16);
            if (findFragmentByTag != 0) {
                findFragmentByTag.setArguments(intent.getBundleExtra("extra_argument"));
                ((f) findFragmentByTag).qOnNewIntent();
            } else {
                QLog.e("QFragmentStackManager", 1, "can not find fragment " + str + " for tag: " + r16);
            }
        } else {
            r16 = r(intent, str, beginTransaction, launchParam);
        }
        beginTransaction.commitAllowingStateLoss();
        return r16;
    }

    private String l(Intent intent, LaunchParam launchParam, String str, FragmentManager fragmentManager) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        c(fragmentManager, str, launchParam.k(), true, launchParam.c());
        return k(intent, launchParam, str, fragmentManager);
    }

    private String m(Intent intent, LaunchParam launchParam, String str, FragmentManager fragmentManager) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        c(fragmentManager, str, launchParam.k(), false, launchParam.c());
        return k(intent, launchParam, str, fragmentManager);
    }

    private String n(Intent intent, LaunchParam launchParam, String str, FragmentManager fragmentManager) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String r16;
        c(fragmentManager, str, launchParam.k(), false, launchParam.c());
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.setCustomAnimations(launchParam.a(), launchParam.b(), launchParam.f(), launchParam.g());
        if (launchParam.j()) {
            r16 = a(intent, str, beginTransaction, launchParam);
        } else {
            r16 = r(intent, str, beginTransaction, launchParam);
        }
        beginTransaction.commitAllowingStateLoss();
        return r16;
    }

    private String r(Intent intent, String str, FragmentTransaction fragmentTransaction, LaunchParam launchParam) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fragment fragment = (Fragment) Class.forName(str).newInstance();
        fragment.setArguments(intent.getBundleExtra("extra_argument"));
        String valueOf = String.valueOf(this.f257103d.addAndGet(1));
        fragmentTransaction.replace(R.id.ve8, fragment, valueOf);
        fragmentTransaction.addToBackStack(valueOf);
        this.f257102c.addFirst(new j(str, valueOf, launchParam.c()));
        return valueOf;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (j()) {
            return;
        }
        FragmentManager supportFragmentManager = this.f257100a.getSupportFragmentManager();
        if (supportFragmentManager.isDestroyed()) {
            QLog.d("QFragmentStackManager", 1, "FragmentManager is destroy");
            return;
        }
        QLog.d("QFragmentStackManager", 1, "clearFunctionFragment");
        this.f257102c.clear();
        supportFragmentManager.popBackStack((String) null, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e() {
        Fragment g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!j() && (g16 = g()) != 0 && !g16.isHidden()) {
            FragmentManager supportFragmentManager = this.f257100a.getSupportFragmentManager();
            ((g) g16).d5(1);
            supportFragmentManager.beginTransaction().hide(g16).commitAllowingStateLoss();
            this.f257101b = null;
        }
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return !this.f257102c.isEmpty();
    }

    @MainThread
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (j()) {
            return false;
        }
        FragmentManager supportFragmentManager = this.f257100a.getSupportFragmentManager();
        j peekFirst = this.f257102c.peekFirst();
        if (peekFirst != null) {
            if (supportFragmentManager.findFragmentByTag(peekFirst.c()) instanceof f) {
                if (QLog.isColorLevel()) {
                    QLog.d("QFragmentStackManager", 2, "pop fragment: " + peekFirst.b());
                }
                this.f257102c.pollFirst();
                supportFragmentManager.popBackStack();
            }
            return true;
        }
        Fragment g16 = g();
        if (g16 == null || !g16.isVisible()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QFragmentStackManager", 2, "pop supreme: " + g16.getClass().getName());
        }
        if (g16.getFragmentManager() != null) {
            supportFragmentManager.beginTransaction().hide(g16).commitAllowingStateLoss();
        }
        this.f257101b = null;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (j()) {
            return false;
        }
        FragmentManager supportFragmentManager = this.f257100a.getSupportFragmentManager();
        j peekFirst = this.f257102c.peekFirst();
        if (peekFirst != null) {
            ActivityResultCaller findFragmentByTag = supportFragmentManager.findFragmentByTag(peekFirst.c());
            if (!(findFragmentByTag instanceof f) || !((f) findFragmentByTag).qOnBackPressed()) {
                if (QLog.isColorLevel()) {
                    QLog.d("QFragmentStackManager", 2, "pop fragment: " + peekFirst.b());
                }
                this.f257102c.pollFirst();
                supportFragmentManager.popBackStack();
            }
            return true;
        }
        Fragment g16 = g();
        if (g16 == 0 || !g16.isVisible()) {
            return false;
        }
        if (!((f) g16).qOnBackPressed()) {
            if (QLog.isColorLevel()) {
                QLog.d("QFragmentStackManager", 2, "pop supreme: " + g16.getClass().getName());
            }
            if (g16.getFragmentManager() != null) {
                supportFragmentManager.beginTransaction().hide(g16).commitAllowingStateLoss();
            }
            this.f257101b = null;
        }
        return true;
    }

    @MainThread
    public void q(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        QLog.d("QFragmentStackManager", 1, "remove supreme: " + str);
        FragmentManager supportFragmentManager = this.f257100a.getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag == null) {
            QLog.w("QFragmentStackManager", 1, "can not remove supreme: " + str);
            return;
        }
        supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        Fragment g16 = g();
        if (g16 != null && g16.equals(findFragmentByTag)) {
            this.f257101b = null;
        }
    }

    @Nullable
    @MainThread
    public String s(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent);
        }
        if (intent == null || j()) {
            return null;
        }
        LaunchParam launchParam = (LaunchParam) intent.getParcelableExtra(MiniAppBridgeActivity.KEY_LAUNCH_PARAM);
        if (launchParam == null) {
            QLog.e("QFragmentStackManager", 1, "launch param is null");
            return null;
        }
        if (!intent.getBooleanExtra("is_add_fragment", false)) {
            return null;
        }
        String stringExtra = intent.getStringExtra("top_fragment_class");
        if (launchParam.l()) {
            return u(stringExtra, intent, launchParam);
        }
        try {
            FragmentManager supportFragmentManager = this.f257100a.getSupportFragmentManager();
            int i3 = a.f257104a[launchParam.e().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    return n(intent, launchParam, stringExtra, supportFragmentManager);
                }
                return l(intent, launchParam, stringExtra, supportFragmentManager);
            }
            return m(intent, launchParam, stringExtra, supportFragmentManager);
        } catch (Exception e16) {
            QLog.e("QFragmentStackManager", 1, e16, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @MainThread
    public String t(@NonNull Fragment fragment, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i16, Bundle bundle, @Nullable n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, fragment, Integer.valueOf(i3), Integer.valueOf(i16), bundle, nVar);
        }
        b(fragment);
        QLog.d("QFragmentStackManager", 1, "startSupremeFragment: " + fragment.getClass().getName());
        FragmentManager supportFragmentManager = this.f257100a.getSupportFragmentManager();
        if (bundle != null && !bundle.getBoolean("retain_fragment_record", false) && !this.f257102c.isEmpty()) {
            if (j()) {
                return null;
            }
            this.f257102c.clear();
            supportFragmentManager.popBackStack((String) null, 1);
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (i3 != 0 && i16 != 0) {
            beginTransaction.setCustomAnimations(i3, i16);
        }
        String name = fragment.getClass().getName();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(name);
        if (findFragmentByTag != 0) {
            QLog.d("QFragmentStackManager", 1, "startSupremeFragment current = " + findFragmentByTag + " ,current.isVisible = " + findFragmentByTag.isVisible());
            beginTransaction.show(findFragmentByTag);
            if (!j()) {
                findFragmentByTag.setArguments(bundle);
            }
            ((f) findFragmentByTag).qOnNewIntent();
            fragment = findFragmentByTag;
        } else {
            if (!j()) {
                fragment.setArguments(bundle);
            }
            beginTransaction.add(R.id.ve_, fragment, name);
        }
        Fragment g16 = g();
        if (bundle == null || !bundle.getBoolean("retain_fragment_record", false)) {
            z16 = false;
        }
        if (!z16) {
            if (g16 != 0 && !g16.getClass().getName().equals(name) && !g16.isHidden()) {
                ((g) g16).d5(2);
                beginTransaction.hide(g16);
            }
            this.f257101b = new WeakReference<>(fragment);
        }
        if (nVar != 0) {
            nVar.a(beginTransaction);
        }
        if (bundle != null && bundle.getBoolean("commit_now", false)) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitAllowingStateLoss();
        }
        return name;
    }

    @Nullable
    @MainThread
    public String u(String str, Intent intent, LaunchParam launchParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, str, intent, launchParam);
        }
        try {
            return t((Fragment) Class.forName(str).newInstance(), launchParam.a(), launchParam.b(), intent.getBundleExtra("extra_argument"), null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e16) {
            QLog.e("QFragmentStackManager", 1, e16, new Object[0]);
            return null;
        }
    }
}
