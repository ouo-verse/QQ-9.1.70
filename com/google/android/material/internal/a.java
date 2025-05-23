package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.google.android.material.internal.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@UiThread
/* loaded from: classes2.dex */
public class a<T extends g<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, T> f33797a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set<Integer> f33798b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private b f33799c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33800d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33801e;

    /* compiled from: P */
    /* renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0234a implements g.a<T> {
        C0234a() {
        }

        @Override // com.google.android.material.internal.g.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(T t16, boolean z16) {
            if (z16) {
                if (!a.this.g(t16)) {
                    return;
                }
            } else {
                a aVar = a.this;
                if (!aVar.r(t16, aVar.f33801e)) {
                    return;
                }
            }
            a.this.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {
        void a(@NonNull Set<Integer> set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(@NonNull g<T> gVar) {
        int id5 = gVar.getId();
        if (this.f33798b.contains(Integer.valueOf(id5))) {
            return false;
        }
        T t16 = this.f33797a.get(Integer.valueOf(k()));
        if (t16 != null) {
            r(t16, false);
        }
        boolean add = this.f33798b.add(Integer.valueOf(id5));
        if (!gVar.isChecked()) {
            gVar.setChecked(true);
        }
        return add;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        b bVar = this.f33799c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(@NonNull g<T> gVar, boolean z16) {
        int id5 = gVar.getId();
        if (!this.f33798b.contains(Integer.valueOf(id5))) {
            return false;
        }
        if (z16 && this.f33798b.size() == 1 && this.f33798b.contains(Integer.valueOf(id5))) {
            gVar.setChecked(true);
            return false;
        }
        boolean remove = this.f33798b.remove(Integer.valueOf(id5));
        if (gVar.isChecked()) {
            gVar.setChecked(false);
        }
        return remove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(T t16) {
        this.f33797a.put(Integer.valueOf(t16.getId()), t16);
        if (t16.isChecked()) {
            g(t16);
        }
        t16.setInternalOnCheckedChangeListener(new C0234a());
    }

    public void f(@IdRes int i3) {
        T t16 = this.f33797a.get(Integer.valueOf(i3));
        if (t16 != null && g(t16)) {
            m();
        }
    }

    public void h() {
        boolean z16 = !this.f33798b.isEmpty();
        Iterator<T> it = this.f33797a.values().iterator();
        while (it.hasNext()) {
            r(it.next(), false);
        }
        if (z16) {
            m();
        }
    }

    @NonNull
    public Set<Integer> i() {
        return new HashSet(this.f33798b);
    }

    @NonNull
    public List<Integer> j(@NonNull ViewGroup viewGroup) {
        Set<Integer> i3 = i();
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < viewGroup.getChildCount(); i16++) {
            View childAt = viewGroup.getChildAt(i16);
            if ((childAt instanceof g) && i3.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    @IdRes
    public int k() {
        if (this.f33800d && !this.f33798b.isEmpty()) {
            return this.f33798b.iterator().next().intValue();
        }
        return -1;
    }

    public boolean l() {
        return this.f33800d;
    }

    public void n(T t16) {
        t16.setInternalOnCheckedChangeListener(null);
        this.f33797a.remove(Integer.valueOf(t16.getId()));
        this.f33798b.remove(Integer.valueOf(t16.getId()));
    }

    public void o(@Nullable b bVar) {
        this.f33799c = bVar;
    }

    public void p(boolean z16) {
        this.f33801e = z16;
    }

    public void q(boolean z16) {
        if (this.f33800d != z16) {
            this.f33800d = z16;
            h();
        }
    }
}
