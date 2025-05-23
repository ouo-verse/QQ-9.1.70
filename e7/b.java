package e7;

import com.qzone.util.f;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f395812a;

    /* renamed from: b, reason: collision with root package name */
    public final String f395813b;

    /* renamed from: c, reason: collision with root package name */
    public final List<a> f395814c;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f395815a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f395816b;

        public String toString() {
            return "StepOnZoneAction{animType='" + this.f395815a + "', isTap=" + this.f395816b + '}';
        }
    }

    public b(long j3, String str, List<a> list) {
        this.f395812a = j3;
        this.f395813b = str;
        this.f395814c = f.a(list);
    }
}
