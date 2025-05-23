package oz4;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class k {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicInteger f424775h = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    public int f424778c;

    /* renamed from: e, reason: collision with root package name */
    public int f424780e;

    /* renamed from: f, reason: collision with root package name */
    public int f424781f;

    /* renamed from: a, reason: collision with root package name */
    public final String f424776a = UUID.randomUUID().toString();

    /* renamed from: b, reason: collision with root package name */
    public final long f424777b = System.currentTimeMillis() + 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f424779d = f424775h.getAndIncrement();

    /* renamed from: g, reason: collision with root package name */
    public HashMap f424782g = new HashMap();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f424783a;

        /* renamed from: b, reason: collision with root package name */
        public int f424784b;

        /* renamed from: c, reason: collision with root package name */
        public int f424785c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f424786d = new HashMap();

        public final a a(String str, String str2) {
            this.f424786d.put(str, str2);
            return this;
        }
    }

    public final String toString() {
        return "TrackerEventDetail{eventId='" + this.f424776a + "', eventTime=" + this.f424777b + ", eventType=" + l.b(this.f424778c) + ", eventSeq=" + this.f424779d + ", pointId=" + this.f424780e + ", eventKey='null', bizPageName='null', bizModule='null', bizAction=" + e05.a.b(this.f424781f) + ", dataMap=" + this.f424782g + '}';
    }
}
