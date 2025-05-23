package c45;

import c45.d;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pbandk.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a<T extends d.b> extends b {

        /* renamed from: a, reason: collision with root package name */
        public final d.b.a<T> f30292a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f30293b;

        /* renamed from: c, reason: collision with root package name */
        public final d.b f30294c;

        public /* synthetic */ a() {
            this(false);
        }

        @Override // c45.b
        public final Object a() {
            return this.f30294c;
        }

        @Override // c45.b
        public final boolean b() {
            return this.f30293b;
        }

        @Override // c45.b
        public final int c() {
            return 0;
        }

        @Override // c45.b
        public final boolean d(Object obj) {
            d.b bVar = obj instanceof d.b ? (d.b) obj : null;
            return bVar != null && bVar.getValue() == 0;
        }

        @Override // c45.b
        public final boolean e() {
            return true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z16) {
            super(null);
            d.c.a aVar = d.c.f30317b;
            this.f30292a = aVar;
            this.f30293b = z16;
            this.f30294c = aVar.a(0);
        }
    }

    /* compiled from: P */
    /* renamed from: c45.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0166b<K, V> extends b {

        /* renamed from: a, reason: collision with root package name */
        public final a.c.C11000a<K, V> f30295a;

        /* renamed from: b, reason: collision with root package name */
        public final Map f30296b;

        @Override // c45.b
        public final Object a() {
            return this.f30296b;
        }

        @Override // c45.b
        public final boolean b() {
            return false;
        }

        @Override // c45.b
        public final int c() {
            return 2;
        }

        @Override // c45.b
        public final boolean d(Object obj) {
            Map map = obj instanceof Map ? (Map) obj : null;
            return map != null && map.isEmpty();
        }

        @Override // c45.b
        public final boolean e() {
            return false;
        }

        public C0166b(b bVar, b bVar2) {
            super(null);
            Map emptyMap;
            this.f30295a = new a.c.C11000a<>(bVar, bVar2);
            emptyMap = MapsKt__MapsKt.emptyMap();
            this.f30296b = emptyMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class c<T extends c45.d> extends b {

        /* renamed from: a, reason: collision with root package name */
        public final d.a<T> f30297a;

        @Override // c45.b
        public final Object a() {
            return null;
        }

        @Override // c45.b
        public final boolean b() {
            return true;
        }

        @Override // c45.b
        public final int c() {
            return 2;
        }

        @Override // c45.b
        public final boolean d(Object obj) {
            if (obj == null) {
                return true;
            }
            return false;
        }

        @Override // c45.b
        public final boolean e() {
            return false;
        }

        public c(d.a<T> aVar) {
            super(null);
            this.f30297a = aVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class d<T extends j> extends b {

        /* renamed from: a, reason: collision with root package name */
        public final T f30298a;

        @Override // c45.b
        public final Object a() {
            return null;
        }

        @Override // c45.b
        public final boolean b() {
            return true;
        }

        @Override // c45.b
        public final int c() {
            return 2;
        }

        @Override // c45.b
        public final boolean d(Object obj) {
            if (obj == null) {
                return true;
            }
            return false;
        }

        @Override // c45.b
        public final boolean e() {
            return false;
        }

        public d(T t16) {
            super(null);
            this.f30298a = t16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static abstract class e<KotlinT> extends b {

        /* renamed from: a, reason: collision with root package name */
        public final KotlinT f30299a;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public static final class a extends e<Boolean> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30300b;

            public a(boolean z16) {
                super(Boolean.FALSE, null);
                this.f30300b = z16;
            }

            @Override // c45.b
            public final boolean b() {
                return this.f30300b;
            }

            @Override // c45.b
            public final int c() {
                return 0;
            }
        }

        /* compiled from: P */
        /* renamed from: c45.b$e$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public static final class C0167b extends e<c45.a> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30301b;

            public C0167b(boolean z16) {
                super(c45.a.f30290b, null);
                this.f30301b = z16;
            }

            @Override // c45.b
            public final boolean b() {
                return this.f30301b;
            }

            @Override // c45.b
            public final int c() {
                return 2;
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public static final class d extends e<Float> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30303b;

            @Override // c45.b
            public final boolean b() {
                return this.f30303b;
            }

            @Override // c45.b
            public final int c() {
                return 5;
            }

            public d(boolean z16) {
                super(Float.valueOf(0.0f), null);
                this.f30303b = z16;
            }
        }

        /* compiled from: P */
        /* renamed from: c45.b$e$e, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public static final class C0168e extends e<Integer> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30304b;

            @Override // c45.b
            public final boolean b() {
                return this.f30304b;
            }

            @Override // c45.b
            public final int c() {
                return 0;
            }

            public C0168e(boolean z16) {
                super(0, null);
                this.f30304b = z16;
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public static final class g extends e<String> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30306b;

            public g(boolean z16) {
                super("", null);
                this.f30306b = z16;
            }

            @Override // c45.b
            public final boolean b() {
                return this.f30306b;
            }

            @Override // c45.b
            public final int c() {
                return 2;
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public static final class h extends e<Integer> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30307b;

            @Override // c45.b
            public final boolean b() {
                return this.f30307b;
            }

            @Override // c45.b
            public final int c() {
                return 0;
            }

            public h(boolean z16) {
                super(0, null);
                this.f30307b = z16;
            }
        }

        public /* synthetic */ e(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj);
        }

        @Override // c45.b
        public final KotlinT a() {
            return this.f30299a;
        }

        @Override // c45.b
        public final boolean d(Object obj) {
            if (b()) {
                return obj == null;
            }
            if (obj == null) {
                obj = null;
            }
            return Intrinsics.areEqual(obj, this.f30299a);
        }

        @Override // c45.b
        public final boolean e() {
            return !e45.k.a(c(), 2);
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public static final class c extends e<Double> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30302b;

            @Override // c45.b
            public final boolean b() {
                return this.f30302b;
            }

            @Override // c45.b
            public final int c() {
                return 1;
            }

            public c(boolean z16) {
                super(Double.valueOf(0.0d), null);
                this.f30302b = z16;
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public static final class f extends e<Long> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30305b;

            @Override // c45.b
            public final boolean b() {
                return this.f30305b;
            }

            @Override // c45.b
            public final int c() {
                return 0;
            }

            public f(boolean z16) {
                super(0L, null);
                this.f30305b = z16;
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public static final class i extends e<Long> {

            /* renamed from: b, reason: collision with root package name */
            public final boolean f30308b;

            @Override // c45.b
            public final boolean b() {
                return this.f30308b;
            }

            @Override // c45.b
            public final int c() {
                return 0;
            }

            public i(boolean z16) {
                super(0L, null);
                this.f30308b = z16;
            }
        }

        public e(KotlinT kotlint) {
            super(null);
            this.f30299a = kotlint;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class f<T> extends b {

        /* renamed from: a, reason: collision with root package name */
        public final b f30309a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f30310b;

        /* renamed from: c, reason: collision with root package name */
        public final List f30311c;

        @Override // c45.b
        public final Object a() {
            return this.f30311c;
        }

        @Override // c45.b
        public final boolean b() {
            return false;
        }

        @Override // c45.b
        public final int c() {
            return this.f30309a.c();
        }

        @Override // c45.b
        public final boolean d(Object obj) {
            List list = obj instanceof List ? (List) obj : null;
            return list != null && list.isEmpty();
        }

        @Override // c45.b
        public final boolean e() {
            return false;
        }

        public f(b bVar, boolean z16) {
            super(null);
            List emptyList;
            this.f30309a = bVar;
            this.f30310b = z16;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.f30311c = emptyList;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object a();

    public abstract boolean b();

    public abstract int c();

    public abstract boolean d(Object obj);

    public abstract boolean e();

    public b() {
    }
}
