package nd4;

import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import nd4.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private String f419988a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private List<f> f419989b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private List<j> f419990c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private long f419991d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private String f419992a;

        /* renamed from: b, reason: collision with root package name */
        private List<f> f419993b;

        /* renamed from: c, reason: collision with root package name */
        private List<j> f419994c;

        /* renamed from: d, reason: collision with root package name */
        private long f419995d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b e(@NonNull List<f> list) {
            this.f419993b = list;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b f(@NonNull List<j> list) {
            this.f419994c = list;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public g g() {
            return new g(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b h(@NonNull String str) {
            this.f419992a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public g i(@NonNull g gVar, @NonNull List<j> list, @NonNull long j3) {
            h(gVar.e()).e(gVar.b()).j(gVar.f()).f(list).j(j3);
            return new g(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b j(@NonNull long j3) {
            this.f419995d = j3;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public i a() {
        ConcurrentHashMap<String, g> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(c(), this);
        return new i.b().c(concurrentHashMap).e(this.f419988a).d();
    }

    @NonNull
    public List<f> b() {
        return this.f419989b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String c() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<f> it = this.f419989b.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().a());
            sb5.append("~");
        }
        sb5.append(this.f419989b.size());
        return sb5.toString();
    }

    @NonNull
    public List<j> d() {
        return this.f419990c;
    }

    @NonNull
    public String e() {
        return this.f419988a;
    }

    @NonNull
    public long f() {
        return this.f419991d;
    }

    public String toString() {
        return "TabAggregateLog{mMonitorName='" + this.f419988a + "', mAggregateDimensionItemList=" + this.f419989b + ", mAggregatePolicyItemList=" + this.f419990c + ", mTimestamp=" + this.f419991d + '}';
    }

    g(b bVar) {
        this.f419988a = bVar.f419992a;
        this.f419989b = bVar.f419993b;
        this.f419990c = bVar.f419994c;
        this.f419991d = bVar.f419995d;
    }
}
