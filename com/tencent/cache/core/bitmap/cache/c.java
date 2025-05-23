package com.tencent.cache.core.bitmap.cache;

import android.util.Pair;
import android.view.View;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.Priority;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.engine.QEffectType;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c<K, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f98669a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f98670b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.cache.core.bitmap.base.lrucache.b<K, b<K, V>>[] f98671c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap<K, b<K, V>>[] f98672d;

    /* renamed from: e, reason: collision with root package name */
    public int f98673e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet<K> f98674f;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a extends com.tencent.cache.core.bitmap.base.lrucache.b<K, b<K, V>> {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f98675i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ c f98676j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i3, int i16, c cVar) {
            super(i16);
            this.f98675i = i3;
            this.f98676j = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), cVar);
            }
        }

        @Override // com.tencent.cache.core.bitmap.base.lrucache.b
        public void c(boolean z16, Object obj, Object obj2, Object obj3) {
            V v3;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj, obj2, obj3);
                return;
            }
            b oldValue = (b) obj2;
            b bVar = (b) obj3;
            Intrinsics.checkNotNullParameter(oldValue, "oldValue");
            if (z16 && this.f98675i > Priority.Low.ordinal()) {
                this.f98676j.f98672d[this.f98675i].put(obj, oldValue);
            } else {
                if (oldValue.f98662d != com.tencent.cache.core.bitmap.cache.a.f98657c) {
                    z17 = false;
                }
                if (z17) {
                    c cVar = this.f98676j;
                    V v16 = oldValue.f98664f;
                    if (bVar != null) {
                        v3 = bVar.f98664f;
                    } else {
                        v3 = null;
                    }
                    cVar.i(z16, obj, v16, v3);
                }
                if (z16 && this.f98675i == Priority.Low.ordinal()) {
                    com.tencent.cache.core.util.b.f98833f.e("ImageCacheHelper", "entryRemoved, " + obj + ", " + oldValue, d.f98677a);
                }
            }
            this.f98676j.f98674f.remove(obj);
        }

        @Override // com.tencent.cache.core.bitmap.base.lrucache.b
        public int o(Object obj, Object obj2, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, obj, obj2, Boolean.valueOf(z16))).intValue();
            }
            b<K, V> value = (b) obj2;
            Intrinsics.checkNotNullParameter(value, "value");
            int a16 = this.f98676j.a(obj, value, z16, this);
            c cVar = this.f98676j;
            int i3 = cVar.f98673e;
            if (1 <= i3 && a16 >= i3 && !cVar.f98674f.contains(obj)) {
                this.f98676j.f98674f.add(obj);
                this.f98676j.getClass();
            }
            return a16;
        }
    }

    public c(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f98669a = 3;
        this.f98673e = -1;
        this.f98674f = new HashSet<>();
        g(i3, i16);
        ConcurrentHashMap<K, b<K, V>>[] concurrentHashMapArr = new ConcurrentHashMap[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            concurrentHashMapArr[i17] = new ConcurrentHashMap<>();
        }
        this.f98672d = concurrentHashMapArr;
        com.tencent.cache.core.bitmap.base.lrucache.b<K, b<K, V>>[] bVarArr = new com.tencent.cache.core.bitmap.base.lrucache.b[i16];
        for (int i18 = 0; i18 < i16; i18++) {
            int[] iArr = this.f98670b;
            if (iArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxSizes");
            }
            bVarArr[i18] = new a(i18, iArr[i18], this);
        }
        this.f98671c = bVarArr;
    }

    public int a(K k3, @NotNull b<K, V> bVar, boolean z16, @NotNull com.tencent.cache.core.bitmap.base.lrucache.b<?, ?> bVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, k3, bVar, Boolean.valueOf(z16), bVar2)).intValue();
        }
        throw null;
    }

    @NotNull
    public Pair<Integer, Integer> b(int i3, @NotNull Set<String> businessStack) {
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Pair) iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) businessStack);
        }
        Intrinsics.checkNotNullParameter(businessStack, "businessStack");
        int k3 = k();
        if (k3 <= i3) {
            return new Pair<>(0, -1);
        }
        int i16 = k3 - i3;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        do {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.f98671c[i18].n() - (i16 - i17), 0);
            Pair<Integer, Integer> q16 = this.f98671c[i18].q(coerceAtLeast, businessStack);
            Object obj = q16.first;
            Intrinsics.checkNotNullExpressionValue(obj, "result.first");
            i17 += ((Number) obj).intValue();
            Object obj2 = q16.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "result.second");
            i19 += ((Number) obj2).intValue();
            i18++;
            if (i17 >= i16) {
                break;
            }
        } while (i18 < this.f98669a);
        for (ConcurrentHashMap<K, b<K, V>> concurrentHashMap : this.f98672d) {
            concurrentHashMap.clear();
        }
        return new Pair<>(Integer.valueOf(i17), Integer.valueOf(i19));
    }

    @Nullable
    public final b<K, V> c(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) k3);
        }
        int i3 = this.f98669a - 1;
        b<K, V> bVar = null;
        while (true) {
            if (i3 < 0) {
                break;
            }
            bVar = this.f98671c[i3].e(k3);
            if (bVar != null) {
                int i16 = bVar.f98659a + 1;
                bVar.f98659a = i16;
                bVar.f98660b++;
                if (i16 >= 128 && bVar.f98668j.ordinal() < Priority.High.ordinal()) {
                    this.f98671c[i3].j(k3);
                    Priority inc = bVar.f98668j.inc();
                    Intrinsics.checkNotNullParameter(inc, "<set-?>");
                    bVar.f98668j = inc;
                    bVar.f98659a = 0;
                    d(k3, bVar);
                }
            } else {
                i3--;
            }
        }
        return bVar;
    }

    public final V d(K k3, b<K, V> bVar) {
        b<K, V> j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3, (Object) bVar);
        }
        if (k3 != null) {
            int ordinal = bVar.f98668j.ordinal();
            com.tencent.cache.core.bitmap.base.lrucache.b<K, b<K, V>>[] bVarArr = this.f98671c;
            int length = bVarArr.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                com.tencent.cache.core.bitmap.base.lrucache.b<K, b<K, V>> bVar2 = bVarArr[i3];
                int i17 = i16 + 1;
                if (i16 != ordinal && (j3 = bVar2.j(k3)) != null) {
                    bVar.a(j3);
                }
                i3++;
                i16 = i17;
            }
            for (ConcurrentHashMap<K, b<K, V>> concurrentHashMap : this.f98672d) {
                b<K, V> removed = concurrentHashMap.remove(k3);
                if (removed != null) {
                    Intrinsics.checkNotNullExpressionValue(removed, "removed");
                    bVar.a(removed);
                }
            }
            b<K, V> i18 = this.f98671c[ordinal].i(k3, bVar);
            if (i18 != null) {
                bVar.a(i18);
            }
            ConcurrentHashMap<K, b<K, V>>[] concurrentHashMapArr = this.f98672d;
            int length2 = concurrentHashMapArr.length;
            int i19 = 0;
            int i26 = 0;
            while (i19 < length2) {
                int i27 = i26 + 1;
                for (Map.Entry<K, b<K, V>> entry : concurrentHashMapArr[i19].entrySet()) {
                    try {
                        b<K, V> value = entry.getValue();
                        Priority dec = value.f98668j.dec();
                        Intrinsics.checkNotNullParameter(dec, "<set-?>");
                        value.f98668j = dec;
                    } catch (Exception unused) {
                        com.tencent.cache.core.util.b bVar3 = com.tencent.cache.core.util.b.f98833f;
                        StringBuilder a16 = com.tencent.cache.api.collection.c.a("oldValues size: ");
                        a16.append(this.f98672d.length);
                        a16.append(", ");
                        a16.append("priority: ");
                        a16.append(ordinal);
                        a16.append(", valuePriority:");
                        a16.append(entry.getValue().f98668j);
                        a16.append(", index:");
                        a16.append(i26);
                        bVar3.h("SteppedLruCache", 1, a16.toString());
                    }
                    entry.getValue().f98659a = 0;
                    this.f98671c[entry.getValue().f98668j.ordinal()].i(entry.getKey(), entry.getValue());
                }
                this.f98672d[i26].clear();
                i19++;
                i26 = i27;
            }
            return bVar.f98664f;
        }
        return bVar.f98664f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0066, code lost:
    
        if (r2 != false) goto L18;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V e(K k3, V v3, @NotNull Business business, @Nullable String str, @NotNull Priority priority, @Nullable View view) {
        boolean startsWith$default;
        boolean contains$default;
        boolean contains$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (V) iPatchRedirector.redirect((short) 6, this, k3, v3, business, str, priority, view);
        }
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(priority, "priority");
        String name = business.name();
        if (k3 instanceof String) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) k3, "LibraRequestKey", false, 2, null);
            if (!startsWith$default) {
                CharSequence charSequence = (CharSequence) k3;
                contains$default = StringsKt__StringsKt.contains$default(charSequence, (CharSequence) "dynamic_cache", false, 2, (Object) null);
                if (!contains$default) {
                    contains$default2 = StringsKt__StringsKt.contains$default(charSequence, (CharSequence) QEffectType.LOTTIE_TAG, false, 2, (Object) null);
                }
                z16 = true;
            }
        }
        b<K, V> bVar = new b<>(v3, name, str, z16, priority);
        if (view != null) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(this, "imageCache");
            view.setTag(R.id.f924457w, k3);
            view.addOnAttachStateChangeListener(new e(this));
            bVar.f98661c.add(new SoftReference<>(view));
        }
        return d(k3, bVar);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int i3 = this.f98669a;
        for (int i16 = 0; i16 < i3; i16++) {
            this.f98671c[i16].d();
            this.f98672d[i16].clear();
        }
    }

    public final void g(int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (1 <= i16 && 3 >= i16) {
                z17 = true;
            }
            if (z17) {
                this.f98669a = i16;
                int[] iArr = new int[i16];
                if (i16 != 2) {
                    if (i16 != 3) {
                        iArr[Priority.Low.ordinal()] = i3;
                    } else {
                        iArr[Priority.Low.ordinal()] = (i3 * 5) / 10;
                        iArr[Priority.Normal.ordinal()] = (i3 * 4) / 10;
                        iArr[Priority.High.ordinal()] = (i3 * 1) / 10;
                    }
                } else {
                    int i17 = (i3 * 5) / 10;
                    iArr[Priority.Low.ordinal()] = i17;
                    iArr[Priority.Normal.ordinal()] = i17;
                }
                this.f98670b = iArr;
                return;
            }
            throw new IllegalArgumentException("stepCount not in 1...3".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public final void h(@NotNull Priority priority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) priority);
            return;
        }
        Intrinsics.checkNotNullParameter(priority, "priority");
        for (int i3 = 0; i3 <= priority.ordinal() && i3 < this.f98669a; i3++) {
            this.f98671c[i3].d();
            this.f98672d[i3].clear();
        }
    }

    public void i(boolean z16, K k3, V v3, @Nullable V v16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), k3, v3, v16);
            return;
        }
        throw null;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        int i3 = this.f98669a;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 += this.f98671c[i17].n();
        }
        return i16;
    }

    public /* synthetic */ c(int i3, int i16, int i17) {
        this(i3, (i17 & 2) != 0 ? 3 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }
}
