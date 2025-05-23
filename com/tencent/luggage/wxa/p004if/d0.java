package com.tencent.luggage.wxa.p004if;

import com.tencent.luggage.wxa.p004if.p;
import com.tencent.luggage.wxa.tn.w;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d0 implements p {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f130191a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f130192b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public Set f130193c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements p.b {

        /* renamed from: a, reason: collision with root package name */
        public final long f130194a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f130195b;

        /* renamed from: c, reason: collision with root package name */
        public final p.a f130196c;

        /* renamed from: d, reason: collision with root package name */
        public volatile boolean f130197d;

        public a(long j3, boolean z16, p.a aVar) {
            this.f130194a = j3;
            this.f130195b = z16;
            this.f130196c = aVar;
        }

        @Override // com.tencent.luggage.wxa.if.p.b
        public boolean a() {
            return this.f130195b;
        }

        public final p.a b() {
            return this.f130196c;
        }

        public long c() {
            return this.f130194a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (c() == aVar.c() && a() == aVar.a() && Intrinsics.areEqual(this.f130196c, aVar.f130196c)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int hashCode;
            int a16 = androidx.fragment.app.a.a(c()) * 31;
            boolean a17 = a();
            ?? r16 = a17;
            if (a17) {
                r16 = 1;
            }
            int i3 = (a16 + r16) * 31;
            p.a aVar = this.f130196c;
            if (aVar == null) {
                hashCode = 0;
            } else {
                hashCode = aVar.hashCode();
            }
            return i3 + hashCode;
        }

        public String toString() {
            return "Session(sessionId=" + c() + ", gainFocus=" + a() + ", onAudioFocusChange=" + this.f130196c + ')';
        }

        public final void a(boolean z16) {
            this.f130197d = z16;
        }
    }

    @Override // com.tencent.luggage.wxa.p004if.p
    public final p.b a(p.a aVar) {
        if (this.f130191a) {
            return a(this, true, aVar, false, 4, null);
        }
        if (i()) {
            this.f130191a = true;
            return a(this, true, aVar, false, 4, null);
        }
        return a(false, aVar, false);
    }

    public abstract boolean a();

    public final void b() {
        synchronized (this.f130192b) {
            Set set = this.f130193c;
            if (set != null) {
                set.clear();
            }
            this.f130193c = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public abstract String c();

    public final void d() {
        Set sessionSetSnapshot;
        w.d(c(), "onAudioFocusPause");
        this.f130191a = false;
        synchronized (this.f130192b) {
            Set set = this.f130193c;
            if (set == null) {
                sessionSetSnapshot = Collections.emptySet();
            } else {
                sessionSetSnapshot = new HashSet(set);
            }
        }
        Intrinsics.checkNotNullExpressionValue(sessionSetSnapshot, "sessionSetSnapshot");
        Iterator it = sessionSetSnapshot.iterator();
        while (it.hasNext()) {
            p.a b16 = ((a) it.next()).b();
            if (b16 != null) {
                b16.onPause();
            }
        }
    }

    public final void f() {
        Set sessionSetSnapshot;
        w.d(c(), "onAudioFocusResume");
        this.f130191a = true;
        synchronized (this.f130192b) {
            Set set = this.f130193c;
            if (set == null) {
                sessionSetSnapshot = Collections.emptySet();
            } else {
                sessionSetSnapshot = new HashSet(set);
            }
        }
        Intrinsics.checkNotNullExpressionValue(sessionSetSnapshot, "sessionSetSnapshot");
        Iterator it = sessionSetSnapshot.iterator();
        while (it.hasNext()) {
            p.a b16 = ((a) it.next()).b();
            if (b16 != null) {
                b16.onResume();
            }
        }
    }

    public final void h() {
        Set sessionSetSnapshot;
        w.d(c(), "onAudioFocusStop");
        this.f130191a = false;
        synchronized (this.f130192b) {
            Set set = this.f130193c;
            if (set == null) {
                sessionSetSnapshot = Collections.emptySet();
            } else {
                sessionSetSnapshot = new HashSet(set);
            }
        }
        Intrinsics.checkNotNullExpressionValue(sessionSetSnapshot, "sessionSetSnapshot");
        Iterator it = sessionSetSnapshot.iterator();
        while (it.hasNext()) {
            p.a b16 = ((a) it.next()).b();
            if (b16 != null) {
                b16.onStop();
            }
        }
    }

    public abstract boolean i();

    @Override // com.tencent.luggage.wxa.p004if.p
    public final boolean a(p.b session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (!(session instanceof a)) {
            w.b(c(), "abandonFocus, unknown session");
            return false;
        }
        if (!a((a) session)) {
            return true;
        }
        if (!a()) {
            return false;
        }
        this.f130191a = false;
        b();
        return true;
    }

    public static /* synthetic */ a a(d0 d0Var, boolean z16, p.a aVar, boolean z17, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSession");
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        return d0Var.a(z16, aVar, z17);
    }

    public final a a(boolean z16, p.a aVar, boolean z17) {
        a aVar2;
        synchronized (this.f130192b) {
            aVar2 = new a(aVar != null ? aVar.hashCode() : 0, z16, aVar);
            if (z17) {
                Set set = this.f130193c;
                if (set == null) {
                    set = new HashSet();
                    this.f130193c = set;
                }
                set.add(aVar2);
            }
        }
        return aVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x000e, B:9:0x0013, B:14:0x001f), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(a aVar) {
        boolean z16;
        boolean z17 = true;
        aVar.a(true);
        synchronized (this.f130192b) {
            Set set = this.f130193c;
            if (set != null) {
                set.remove(aVar);
            }
            Set set2 = this.f130193c;
            if (set2 != null && !set2.isEmpty()) {
                z16 = false;
                if (z16) {
                    z17 = false;
                } else {
                    this.f130193c = null;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        w.d(c(), "abandonFocusForSession, need do real abandonFocus: " + z17);
        return z17;
    }
}
