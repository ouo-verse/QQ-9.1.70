package nd4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private String f419984a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private String f419985b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private String f419986a;

        /* renamed from: b, reason: collision with root package name */
        private String f419987b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public f c() {
            return new f(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b d(@Nullable String str) {
            this.f419986a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b e(@Nullable String str) {
            this.f419987b = str;
            return this;
        }
    }

    @NonNull
    public String a() {
        return this.f419985b;
    }

    public String toString() {
        return "TabAggregateDimensionItem{mDimensionName='" + this.f419984a + "', mDimensionValue='" + this.f419985b + "'}";
    }

    f(b bVar) {
        this.f419984a = bVar.f419986a;
        this.f419985b = bVar.f419987b;
    }
}
