package nd4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private final long f420025a;

    /* renamed from: b, reason: collision with root package name */
    private final String f420026b;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private String f420027a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private long f420028b = 180000;

        @NonNull
        public t c() {
            return new t(this);
        }

        @NonNull
        public b d(String str) {
            this.f420027a = str;
            return this;
        }
    }

    @NonNull
    public String a() {
        return this.f420026b;
    }

    @NonNull
    public long b() {
        return this.f420025a;
    }

    t(@NonNull b bVar) {
        this.f420026b = bVar.f420027a;
        this.f420025a = bVar.f420028b;
    }
}
