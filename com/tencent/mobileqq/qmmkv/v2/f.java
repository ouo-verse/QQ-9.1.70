package com.tencent.mobileqq.qmmkv.v2;

import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f<T, Y> {

    /* renamed from: e, reason: collision with root package name */
    private long f262044e;

    /* renamed from: f, reason: collision with root package name */
    private long f262045f;

    /* renamed from: d, reason: collision with root package name */
    private final Map<T, a<Y>> f262043d = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: h, reason: collision with root package name */
    private SparseLongArray f262046h = new SparseLongArray(8);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class a<Y> {

        /* renamed from: a, reason: collision with root package name */
        final Y f262047a;

        /* renamed from: b, reason: collision with root package name */
        final int f262048b;

        a(Y y16, int i3) {
            this.f262047a = y16;
            this.f262048b = i3;
        }
    }

    public f(long j3) {
        this.f262044e = j3;
    }

    private synchronized void i(int i3, int i16) {
        long j3 = 0;
        long j16 = this.f262046h.get(i3, 0L) - i16;
        if (j16 >= 0) {
            j3 = j16;
        }
        this.f262046h.put(i3, j3);
    }

    private void j() {
        t(this.f262044e);
    }

    private synchronized void o(int i3, int i16) {
        this.f262046h.put(i3, this.f262046h.get(i3, 0L) + i16);
    }

    protected boolean f(@NonNull T t16, @NotNull Y y16, int i3, long j3) {
        throw null;
    }

    public void g() {
        t(0L);
    }

    public synchronized boolean h(@NonNull T t16) {
        return this.f262043d.containsKey(t16);
    }

    @Nullable
    public synchronized Y k(@NonNull T t16) {
        Y y16;
        a<Y> aVar = this.f262043d.get(t16);
        if (aVar != null) {
            y16 = aVar.f262047a;
        } else {
            y16 = null;
        }
        return y16;
    }

    public synchronized long l() {
        return this.f262045f;
    }

    public synchronized long m() {
        return this.f262044e;
    }

    protected int n(@NotNull Y y16) {
        return 1;
    }

    protected void p(@NonNull T t16, @NotNull Y y16, int i3, boolean z16) {
        throw null;
    }

    @Nullable
    public synchronized Y q(@NonNull T t16, @NotNull Y y16) {
        Y y17;
        a<Y> aVar;
        int n3 = n(y16);
        this.f262045f++;
        o(n3, 1);
        Map<T, a<Y>> map = this.f262043d;
        y17 = null;
        if (y16 == null) {
            aVar = null;
        } else {
            aVar = new a<>(y16, n3);
        }
        a<Y> put = map.put(t16, aVar);
        if (put != null) {
            this.f262045f--;
            i(put.f262048b, 1);
        }
        j();
        if (put != null) {
            y17 = put.f262047a;
        }
        return y17;
    }

    @Nullable
    public synchronized Y r(@NonNull T t16) {
        a<Y> remove = this.f262043d.remove(t16);
        if (remove == null) {
            return null;
        }
        this.f262045f--;
        i(remove.f262048b, 1);
        p(t16, remove.f262047a, remove.f262048b, false);
        return remove.f262047a;
    }

    public synchronized void s(long j3) {
        this.f262044e = j3;
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void t(long j3) {
        if (this.f262045f <= j3) {
            return;
        }
        Iterator<Map.Entry<T, a<Y>>> it = this.f262043d.entrySet().iterator();
        while (this.f262045f > j3 && it.hasNext()) {
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            T key = next.getKey();
            int i3 = value.f262048b;
            if (f(key, value.f262047a, i3, this.f262046h.get(i3))) {
                this.f262045f--;
                i(i3, 1);
                it.remove();
                p(key, value.f262047a, value.f262048b, true);
            }
        }
    }
}
