package com.tencent.biz.pubaccount.weishi;

import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final String f80900a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f80901b;

    /* renamed from: c, reason: collision with root package name */
    private final Fragment f80902c;

    /* renamed from: d, reason: collision with root package name */
    private final b f80903d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f80904e;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void o0(boolean z16, boolean z17);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void Ag(boolean z16);

        boolean M7();

        void o0(boolean z16, boolean z17);

        void re(boolean z16);
    }

    public j(Fragment fragment, b bVar) {
        this.f80902c = fragment;
        this.f80903d = bVar;
        this.f80900a = fragment.getClass().getSimpleName();
    }

    private void b(boolean z16, boolean z17) {
        List<a> list = this.f80904e;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<a> it = this.f80904e.iterator();
        while (it.hasNext()) {
            it.next().o0(z16, z17);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(List<Fragment> list) {
        for (Fragment fragment : list) {
            if (fragment instanceof b) {
                b bVar = (b) fragment;
                if (fragment.getUserVisibleHint()) {
                    com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": setUserVisibleHint, hidden child " + fragment.getClass().getSimpleName());
                    bVar.re(true);
                    fragment.setUserVisibleHint(false);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void j(List<Fragment> list) {
        for (Fragment fragment : list) {
            if (fragment instanceof b) {
                b bVar = (b) fragment;
                if (bVar.M7()) {
                    com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": setUserVisibleHint, show child " + fragment.getClass().getSimpleName());
                    bVar.re(false);
                    fragment.setUserVisibleHint(true);
                }
            }
        }
    }

    public void a() {
        Fragment parentFragment;
        com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": activityCreated, userVisibleHint=" + this.f80902c.getUserVisibleHint());
        if (!this.f80902c.getUserVisibleHint() || (parentFragment = this.f80902c.getParentFragment()) == null || parentFragment.getUserVisibleHint()) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": activityCreated, parent " + parentFragment.getClass().getSimpleName() + " is hidden, therefore hidden self");
        this.f80903d.re(true);
        this.f80903d.Ag(false);
    }

    public boolean d() {
        return this.f80902c.isResumed() && this.f80902c.getUserVisibleHint();
    }

    public boolean e() {
        return this.f80901b;
    }

    public void f() {
        com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": pause, userVisibleHint=" + this.f80902c.getUserVisibleHint());
        if (this.f80902c.getUserVisibleHint()) {
            this.f80903d.o0(false, true);
            b(false, true);
            com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": hiddenToUser on pause");
        }
    }

    public void g() {
        com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": resume, userVisibleHint=" + this.f80902c.getUserVisibleHint());
        if (this.f80902c.getUserVisibleHint()) {
            this.f80903d.o0(true, true);
            b(true, true);
            com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": visibleToUser on resume");
        }
    }

    public void h(boolean z16) {
        String str;
        Fragment parentFragment;
        if (z16 && (parentFragment = this.f80902c.getParentFragment()) != null && !parentFragment.getUserVisibleHint()) {
            com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", this.f80900a + ": setUserVisibleHint, parent " + parentFragment.getClass().getSimpleName() + " is hidden, therefore hidden self");
            this.f80903d.re(true);
            this.f80903d.Ag(false);
            return;
        }
        if (this.f80902c.isResumed()) {
            this.f80903d.o0(z16, false);
            b(z16, false);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f80900a);
            if (z16) {
                str = ": visibleToUser";
            } else {
                str = ": hiddenToUser";
            }
            sb5.append(str);
            sb5.append(" on setUserVisibleHint");
            com.tencent.biz.pubaccount.weishi.util.x.j("UserVisibleController", sb5.toString());
        }
        if (this.f80902c.getActivity() != null) {
            List<Fragment> fragments = this.f80902c.getChildFragmentManager().getFragments();
            if (fragments.size() <= 0) {
                return;
            }
            if (z16) {
                j(fragments);
            } else {
                c(fragments);
            }
        }
    }

    public void i(boolean z16) {
        this.f80901b = z16;
    }
}
