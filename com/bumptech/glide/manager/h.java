package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.RequestManager;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public class h extends ReportFragment {

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f31878d;

    /* renamed from: e, reason: collision with root package name */
    private final b0.i f31879e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<h> f31880f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private RequestManager f31881h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private h f31882i;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private Fragment f31883m;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class a implements b0.i {
        a() {
        }

        @Override // b0.i
        @NonNull
        public Set<RequestManager> a() {
            Set<h> f16 = h.this.f();
            HashSet hashSet = new HashSet(f16.size());
            for (h hVar : f16) {
                if (hVar.i() != null) {
                    hashSet.add(hVar.i());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + h.this + "}";
        }
    }

    public h() {
        this(new com.bumptech.glide.manager.a());
    }

    private void e(h hVar) {
        this.f31880f.add(hVar);
    }

    @Nullable
    @TargetApi(17)
    private Fragment h() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            return this.f31883m;
        }
        return parentFragment;
    }

    @TargetApi(17)
    private boolean k(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 != null) {
                if (parentFragment2.equals(parentFragment)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void l(@NonNull Activity activity) {
        p();
        h q16 = com.bumptech.glide.b.c(activity).k().q(activity);
        this.f31882i = q16;
        if (!equals(q16)) {
            this.f31882i.e(this);
        }
    }

    private void m(h hVar) {
        this.f31880f.remove(hVar);
    }

    private void p() {
        h hVar = this.f31882i;
        if (hVar != null) {
            hVar.m(this);
            this.f31882i = null;
        }
    }

    @NonNull
    @TargetApi(17)
    Set<h> f() {
        if (equals(this.f31882i)) {
            return Collections.unmodifiableSet(this.f31880f);
        }
        if (this.f31882i != null) {
            HashSet hashSet = new HashSet();
            for (h hVar : this.f31882i.f()) {
                if (k(hVar.getParentFragment())) {
                    hashSet.add(hVar);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.bumptech.glide.manager.a g() {
        return this.f31878d;
    }

    @Nullable
    public RequestManager i() {
        return this.f31881h;
    }

    @NonNull
    public b0.i j() {
        return this.f31879e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(@Nullable Fragment fragment) {
        this.f31883m = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            l(fragment.getActivity());
        }
    }

    public void o(@Nullable RequestManager requestManager) {
        this.f31881h = requestManager;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            l(activity);
        } catch (IllegalStateException e16) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e16);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f31878d.c();
        p();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        p();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f31878d.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f31878d.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + h() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    h(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f31879e = new a();
        this.f31880f = new HashSet();
        this.f31878d = aVar;
    }
}
