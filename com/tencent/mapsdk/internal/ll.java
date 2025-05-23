package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ll {

    /* renamed from: a, reason: collision with root package name */
    private static final String f149205a = "PoolUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f149206b = 20;

    /* renamed from: c, reason: collision with root package name */
    private static final k<Object> f149207c = new k<Object>() { // from class: com.tencent.mapsdk.internal.ll.1
        @Override // com.tencent.mapsdk.internal.ll.k
        public final void a(@NonNull Object obj) {
        }
    };

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ll$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    static class AnonymousClass3<T> implements e<List<T>> {
        AnonymousClass3() {
        }

        @NonNull
        private static List<T> b() {
            return new ArrayList();
        }

        @Override // com.tencent.mapsdk.internal.ll.e
        @NonNull
        public final /* synthetic */ Object a() {
            return new ArrayList();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f149208a = 256;

        /* renamed from: b, reason: collision with root package name */
        public int f149209b = 256;

        /* renamed from: c, reason: collision with root package name */
        public Bitmap.Config f149210c;

        public a(Bitmap.Config config) {
            this.f149210c = config;
        }

        private void a(a aVar) {
            if (aVar != null) {
                this.f149208a = aVar.f149208a;
                this.f149209b = aVar.f149209b;
                this.f149210c = aVar.f149210c;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static abstract class b<T> implements e<T> {

        /* renamed from: a, reason: collision with root package name */
        a f149211a;

        b(a aVar) {
            this.f149211a = aVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e<T> {
        T a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface g<T> {
        @Nullable
        T a();

        boolean a(@NonNull T t16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface h {
        @NonNull
        l a();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class i<T> implements h {

        /* renamed from: a, reason: collision with root package name */
        public final T f149217a;

        /* renamed from: b, reason: collision with root package name */
        private l f149218b = new d();

        public i(T t16) {
            this.f149217a = t16;
        }

        private T b() {
            return this.f149217a;
        }

        @Override // com.tencent.mapsdk.internal.ll.h
        @NonNull
        public final l a() {
            return this.f149218b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface k<T> {
        void a(@NonNull T t16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        private static final boolean f149222a = false;

        @NonNull
        private static l b() {
            return new d();
        }

        public abstract void a();

        public abstract void a(boolean z16);
    }

    ll() {
    }

    public static g<i<Bitmap>> a(@NonNull a aVar) {
        return a(10, new b<i<Bitmap>>(aVar) { // from class: com.tencent.mapsdk.internal.ll.2
            private i<Bitmap> b() {
                a aVar2 = this.f149211a;
                return new i<>(Bitmap.createBitmap(aVar2.f149208a, aVar2.f149209b, aVar2.f149210c));
            }

            @Override // com.tencent.mapsdk.internal.ll.e
            public final /* synthetic */ Object a() {
                a aVar2 = this.f149211a;
                return new i(Bitmap.createBitmap(aVar2.f149208a, aVar2.f149209b, aVar2.f149210c));
            }
        });
    }

    @NonNull
    private static <T extends h> g<T> b(int i3, @NonNull e<T> eVar) {
        return a(new j.a(i3), eVar);
    }

    @NonNull
    private static <T> k<T> c() {
        return (k<T>) f149207c;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ll$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    static class AnonymousClass4<T> implements k<List<T>> {
        AnonymousClass4() {
        }

        @Override // com.tencent.mapsdk.internal.ll.k
        public final /* synthetic */ void a(@NonNull Object obj) {
            ((List) obj).clear();
        }

        private static void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class c extends l {

        /* renamed from: a, reason: collision with root package name */
        private volatile RuntimeException f149212a;

        c() {
        }

        @Override // com.tencent.mapsdk.internal.ll.l
        public final void a() {
            if (this.f149212a != null) {
                throw new IllegalStateException("Already released", this.f149212a);
            }
        }

        @Override // com.tencent.mapsdk.internal.ll.l
        public final void a(boolean z16) {
            if (z16) {
                this.f149212a = new RuntimeException("Released");
            } else {
                this.f149212a = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d extends l {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f149213a;

        @Override // com.tencent.mapsdk.internal.ll.l
        public final void a() {
            if (this.f149213a) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.tencent.mapsdk.internal.ll.l
        public final void a(boolean z16) {
            this.f149213a = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class j {
        j() {
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class b<T> extends a<T> {

            /* renamed from: a, reason: collision with root package name */
            private final Object f149221a;

            public b(int i3) {
                super(i3);
                this.f149221a = new Object();
            }

            @Override // com.tencent.mapsdk.internal.ll.j.a, com.tencent.mapsdk.internal.ll.g
            public final T a() {
                T t16;
                synchronized (this.f149221a) {
                    t16 = (T) super.a();
                }
                return t16;
            }

            @Override // com.tencent.mapsdk.internal.ll.j.a, com.tencent.mapsdk.internal.ll.g
            public final boolean a(@NonNull T t16) {
                boolean a16;
                synchronized (this.f149221a) {
                    a16 = super.a(t16);
                }
                return a16;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class a<T> implements g<T> {

            /* renamed from: a, reason: collision with root package name */
            private final Object[] f149219a;

            /* renamed from: b, reason: collision with root package name */
            private int f149220b;

            public a(int i3) {
                if (i3 > 0) {
                    this.f149219a = new Object[i3];
                    return;
                }
                throw new IllegalArgumentException("The max pool size must be > 0");
            }

            private boolean b(@NonNull T t16) {
                for (int i3 = 0; i3 < this.f149220b; i3++) {
                    if (this.f149219a[i3] == t16) {
                        return true;
                    }
                }
                return false;
            }

            @Override // com.tencent.mapsdk.internal.ll.g
            public T a() {
                int i3 = this.f149220b;
                if (i3 <= 0) {
                    return null;
                }
                int i16 = i3 - 1;
                Object[] objArr = this.f149219a;
                T t16 = (T) objArr[i16];
                objArr[i16] = null;
                this.f149220b = i3 - 1;
                return t16;
            }

            @Override // com.tencent.mapsdk.internal.ll.g
            public boolean a(@NonNull T t16) {
                int i3;
                boolean z16;
                int i16 = 0;
                while (true) {
                    i3 = this.f149220b;
                    if (i16 >= i3) {
                        z16 = false;
                        break;
                    }
                    if (this.f149219a[i16] == t16) {
                        z16 = true;
                        break;
                    }
                    i16++;
                }
                if (!z16) {
                    Object[] objArr = this.f149219a;
                    if (i3 >= objArr.length) {
                        return false;
                    }
                    objArr[i3] = t16;
                    this.f149220b = i3 + 1;
                    return true;
                }
                throw new IllegalStateException("Already in the pool!");
            }
        }
    }

    @NonNull
    private static <T> g<List<T>> b() {
        return a(new j.b(20), new AnonymousClass3(), new AnonymousClass4());
    }

    @NonNull
    public static <T extends h> g<T> a(int i3, @NonNull e<T> eVar) {
        return a(new j.b(i3), eVar);
    }

    @NonNull
    private static <T extends h> g<T> a(int i3, @NonNull e<T> eVar, k<T> kVar) {
        return a(new j.b(i3), eVar, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f<T> implements g<T> {

        /* renamed from: a, reason: collision with root package name */
        private final e<T> f149214a;

        /* renamed from: b, reason: collision with root package name */
        private final k<T> f149215b;

        /* renamed from: c, reason: collision with root package name */
        private final g<T> f149216c;

        f(@NonNull g<T> gVar, @NonNull e<T> eVar, @NonNull k<T> kVar) {
            this.f149216c = gVar;
            this.f149214a = eVar;
            this.f149215b = kVar;
        }

        @Override // com.tencent.mapsdk.internal.ll.g
        public final T a() {
            T a16 = this.f149216c.a();
            if (a16 == null) {
                a16 = this.f149214a.a();
                LogUtil.a(ll.f149205a, "Created new ".concat(String.valueOf(a16)));
            }
            if (a16 instanceof h) {
                a16.a().a(false);
            }
            return (T) a16;
        }

        @Override // com.tencent.mapsdk.internal.ll.g
        public final boolean a(@NonNull T t16) {
            if (t16 instanceof h) {
                ((h) t16).a().a(true);
            }
            this.f149215b.a(t16);
            return this.f149216c.a(t16);
        }
    }

    @NonNull
    private static <T> g<T> a(@NonNull g<T> gVar, @NonNull e<T> eVar, @NonNull k<T> kVar) {
        return new f(gVar, eVar, kVar);
    }

    @NonNull
    private static <T> g<List<T>> a() {
        return a(new j.b(20), new AnonymousClass3(), new AnonymousClass4());
    }

    @NonNull
    private static <T extends h> g<T> a(@NonNull g<T> gVar, @NonNull e<T> eVar) {
        return a(gVar, eVar, f149207c);
    }
}
