package nd4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    protected final ld4.a f420010a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    protected final md4.a f420011b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    protected final c f420012c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        private md4.a f420014b;

        /* renamed from: a, reason: collision with root package name */
        private ld4.a f420013a = new q();

        /* renamed from: c, reason: collision with root package name */
        private c f420015c = new k();

        @NonNull
        public m d() {
            return new m(this);
        }

        @NonNull
        public b e(md4.a aVar) {
            this.f420014b = aVar;
            return this;
        }
    }

    @Nullable
    public ld4.a a() {
        return this.f420010a;
    }

    @NonNull
    public md4.a b() {
        return this.f420011b;
    }

    m(b bVar) {
        this.f420010a = bVar.f420013a;
        this.f420011b = bVar.f420014b;
        this.f420012c = bVar.f420015c;
    }
}
