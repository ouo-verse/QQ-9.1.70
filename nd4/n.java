package nd4;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final String f420016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private String f420017a = "";

        /* JADX INFO: Access modifiers changed from: package-private */
        public n b() {
            return new n(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b c(@NonNull String str) {
            this.f420017a = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            return u.f(this.f420016a, ((n) obj).f420016a);
        }
        return false;
    }

    public int hashCode() {
        return u.g(this.f420016a);
    }

    n(@NonNull b bVar) {
        this.f420016a = bVar.f420017a;
    }
}
