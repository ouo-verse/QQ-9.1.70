package com.bumptech.glide.manager;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.c;
import com.bumptech.glide.load.resource.bitmap.v;
import h0.j;
import h0.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class i implements Handler.Callback {
    private static final b F = new a();
    private final g E;

    /* renamed from: d, reason: collision with root package name */
    private volatile RequestManager f31885d;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f31888h;

    /* renamed from: i, reason: collision with root package name */
    private final b f31889i;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    final Map<FragmentManager, h> f31886e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f31887f = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private final ArrayMap<View, Fragment> f31890m = new ArrayMap<>();
    private final ArrayMap<View, android.app.Fragment> C = new ArrayMap<>();
    private final Bundle D = new Bundle();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.manager.i.b
        @NonNull
        public RequestManager a(@NonNull com.bumptech.glide.b bVar, @NonNull b0.e eVar, @NonNull b0.i iVar, @NonNull Context context) {
            return new RequestManager(bVar, eVar, iVar, context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        @NonNull
        RequestManager a(@NonNull com.bumptech.glide.b bVar, @NonNull b0.e eVar, @NonNull b0.i iVar, @NonNull Context context);
    }

    public i(@Nullable b bVar, com.bumptech.glide.e eVar) {
        this.f31889i = bVar == null ? F : bVar;
        this.f31888h = new Handler(Looper.getMainLooper(), this);
        this.E = b(eVar);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (!activity.isDestroyed()) {
        } else {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static g b(com.bumptech.glide.e eVar) {
        if (v.f31854h && v.f31853g) {
            if (eVar.a(c.d.class)) {
                return new e();
            }
            return new f();
        }
        return new c();
    }

    @Nullable
    private static Activity c(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        List<android.app.Fragment> fragments;
        if (Build.VERSION.SDK_INT >= 26) {
            fragments = fragmentManager.getFragments();
            for (android.app.Fragment fragment : fragments) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    d(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        e(fragmentManager, arrayMap);
    }

    @Deprecated
    private void e(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        android.app.Fragment fragment;
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            this.D.putInt("key", i3);
            try {
                fragment = fragmentManager.getFragment(this.D, "key");
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                d(fragment.getChildFragmentManager(), arrayMap);
            }
            i3 = i16;
        }
    }

    private static void f(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                f(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    private android.app.Fragment g(@NonNull View view, @NonNull Activity activity) {
        this.C.clear();
        d(activity.getFragmentManager(), this.C);
        View findViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.C.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.C.clear();
        return fragment;
    }

    @Nullable
    private Fragment h(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f31890m.clear();
        f(fragmentActivity.getSupportFragmentManager().getFragments(), this.f31890m);
        View findViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f31890m.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f31890m.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private RequestManager i(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z16) {
        h r16 = r(fragmentManager, fragment);
        RequestManager i3 = r16.i();
        if (i3 == null) {
            i3 = this.f31889i.a(com.bumptech.glide.b.c(context), r16.g(), r16.j(), context);
            if (z16) {
                i3.onStart();
            }
            r16.o(i3);
        }
        return i3;
    }

    @NonNull
    private RequestManager p(@NonNull Context context) {
        if (this.f31885d == null) {
            synchronized (this) {
                if (this.f31885d == null) {
                    this.f31885d = this.f31889i.a(com.bumptech.glide.b.c(context.getApplicationContext()), new com.bumptech.glide.manager.b(), new d(), context.getApplicationContext());
                }
            }
        }
        return this.f31885d;
    }

    @NonNull
    private h r(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment) {
        h hVar = (h) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (hVar == null) {
            h hVar2 = this.f31886e.get(fragmentManager);
            if (hVar2 == null) {
                h hVar3 = new h();
                hVar3.n(fragment);
                this.f31886e.put(fragmentManager, hVar3);
                fragmentManager.beginTransaction().add(hVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f31888h.obtainMessage(1, fragmentManager).sendToTarget();
                return hVar3;
            }
            return hVar2;
        }
        return hVar;
    }

    @NonNull
    private SupportRequestManagerFragment t(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            SupportRequestManagerFragment supportRequestManagerFragment2 = this.f31887f.get(fragmentManager);
            if (supportRequestManagerFragment2 == null) {
                SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
                supportRequestManagerFragment3.zh(fragment);
                this.f31887f.put(fragmentManager, supportRequestManagerFragment3);
                fragmentManager.beginTransaction().add(supportRequestManagerFragment3, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f31888h.obtainMessage(2, fragmentManager).sendToTarget();
                return supportRequestManagerFragment3;
            }
            return supportRequestManagerFragment2;
        }
        return supportRequestManagerFragment;
    }

    private static boolean u(Context context) {
        Activity c16 = c(context);
        if (c16 != null && c16.isFinishing()) {
            return false;
        }
        return true;
    }

    @NonNull
    private RequestManager v(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z16) {
        SupportRequestManagerFragment t16 = t(fragmentManager, fragment);
        RequestManager th5 = t16.th();
        if (th5 == null) {
            th5 = this.f31889i.a(com.bumptech.glide.b.c(context), t16.rh(), t16.uh(), context);
            if (z16) {
                th5.onStart();
            }
            t16.Ah(th5);
        }
        return th5;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        ComponentCallbacks remove;
        Object obj2;
        ComponentCallbacks componentCallbacks;
        int i3 = message.what;
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                componentCallbacks = null;
                z16 = false;
                obj2 = null;
                if (z16 && componentCallbacks == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z16;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f31887f.remove(obj);
        } else {
            obj = (FragmentManager) message.obj;
            remove = this.f31886e.remove(obj);
        }
        ComponentCallbacks componentCallbacks2 = remove;
        obj2 = obj;
        componentCallbacks = componentCallbacks2;
        if (z16) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z16;
    }

    @NonNull
    public RequestManager j(@NonNull Activity activity) {
        if (k.p()) {
            return l(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return o((FragmentActivity) activity);
        }
        a(activity);
        this.E.a(activity);
        return i(activity, activity.getFragmentManager(), null, u(activity));
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public RequestManager k(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!k.p()) {
                if (fragment.getActivity() != null) {
                    this.E.a(fragment.getActivity());
                }
                return i(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return l(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    public RequestManager l(@NonNull Context context) {
        if (context != null) {
            if (k.q() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return o((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return j((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return l(contextWrapper.getBaseContext());
                    }
                }
            }
            return p(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public RequestManager m(@NonNull View view) {
        if (k.p()) {
            return l(view.getContext().getApplicationContext());
        }
        j.d(view);
        j.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity c16 = c(view.getContext());
        if (c16 == null) {
            return l(view.getContext().getApplicationContext());
        }
        if (c16 instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) c16;
            Fragment h16 = h(view, fragmentActivity);
            if (h16 != null) {
                return n(h16);
            }
            return o(fragmentActivity);
        }
        android.app.Fragment g16 = g(view, c16);
        if (g16 == null) {
            return j(c16);
        }
        return k(g16);
    }

    @NonNull
    public RequestManager n(@NonNull Fragment fragment) {
        j.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (k.p()) {
            return l(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.E.a(fragment.getActivity());
        }
        return v(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public RequestManager o(@NonNull FragmentActivity fragmentActivity) {
        if (k.p()) {
            return l(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.E.a(fragmentActivity);
        return v(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, u(fragmentActivity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    public h q(Activity activity) {
        return r(activity.getFragmentManager(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public SupportRequestManagerFragment s(androidx.fragment.app.FragmentManager fragmentManager) {
        return t(fragmentManager, null);
    }
}
