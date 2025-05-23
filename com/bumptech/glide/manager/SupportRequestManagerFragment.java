package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.RequestManager;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends ReportAndroidXFragment {
    private final com.bumptech.glide.manager.a C;
    private final b0.i D;
    private final Set<SupportRequestManagerFragment> E;

    @Nullable
    private SupportRequestManagerFragment F;

    @Nullable
    private RequestManager G;

    @Nullable
    private Fragment H;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class a implements b0.i {
        a() {
        }

        @Override // b0.i
        @NonNull
        public Set<RequestManager> a() {
            Set<SupportRequestManagerFragment> qh5 = SupportRequestManagerFragment.this.qh();
            HashSet hashSet = new HashSet(qh5.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : qh5) {
                if (supportRequestManagerFragment.th() != null) {
                    hashSet.add(supportRequestManagerFragment.th());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void Bh() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.F;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.yh(this);
            this.F = null;
        }
    }

    private void ph(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.E.add(supportRequestManagerFragment);
    }

    @Nullable
    private Fragment sh() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            return this.H;
        }
        return parentFragment;
    }

    @Nullable
    private static FragmentManager vh(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean wh(@NonNull Fragment fragment) {
        Fragment sh5 = sh();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment.equals(sh5)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void xh(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        Bh();
        SupportRequestManagerFragment s16 = com.bumptech.glide.b.c(context).k().s(fragmentManager);
        this.F = s16;
        if (!equals(s16)) {
            this.F.ph(this);
        }
    }

    private void yh(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.E.remove(supportRequestManagerFragment);
    }

    public void Ah(@Nullable RequestManager requestManager) {
        this.G = requestManager;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager vh5 = vh(this);
        if (vh5 == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                xh(getContext(), vh5);
            } catch (IllegalStateException e16) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e16);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.C.c();
        Bh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.H = null;
        Bh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.C.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.C.e();
    }

    @NonNull
    Set<SupportRequestManagerFragment> qh() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.F;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.E);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.F.qh()) {
            if (wh(supportRequestManagerFragment2.sh())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.bumptech.glide.manager.a rh() {
        return this.C;
    }

    @Nullable
    public RequestManager th() {
        return this.G;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + sh() + "}";
    }

    @NonNull
    public b0.i uh() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zh(@Nullable Fragment fragment) {
        FragmentManager vh5;
        this.H = fragment;
        if (fragment == null || fragment.getContext() == null || (vh5 = vh(fragment)) == null) {
            return;
        }
        xh(fragment.getContext(), vh5);
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.D = new a();
        this.E = new HashSet();
        this.C = aVar;
    }
}
