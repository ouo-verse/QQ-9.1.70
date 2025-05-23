package nd4;

import android.support.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private String f419997a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, g> f419998b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private String f419999a;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<String, g> f420000b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b c(@NonNull ConcurrentHashMap<String, g> concurrentHashMap) {
            this.f420000b = concurrentHashMap;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public i d() {
            return new i(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public b e(@NonNull String str) {
            this.f419999a = str;
            return this;
        }
    }

    public ConcurrentHashMap<String, g> a() {
        return this.f419998b;
    }

    public String b() {
        return this.f419997a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (u.f(this.f419997a, iVar.f419997a) && u.f(this.f419998b, iVar.f419998b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return u.g(this.f419997a, this.f419998b);
    }

    public String toString() {
        return "TabAggregateMonitorItem{mMonitorName='" + this.f419997a + "', mAggregateLogMap=" + this.f419998b + '}';
    }

    i(b bVar) {
        this.f419997a = bVar.f419999a;
        this.f419998b = bVar.f420000b;
    }
}
