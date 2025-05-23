package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class t {

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f35948b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f35949c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile t f35950d;

    /* renamed from: e, reason: collision with root package name */
    static final t f35951e = new t(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map<a, GeneratedMessageLite.e<?, ?>> f35952a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f35953a;

        /* renamed from: b, reason: collision with root package name */
        private final int f35954b;

        a(Object obj, int i3) {
            this.f35953a = obj;
            this.f35954b = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f35953a != aVar.f35953a || this.f35954b != aVar.f35954b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f35953a) * 65535) + this.f35954b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t() {
        this.f35952a = new HashMap();
    }

    public static t b() {
        t tVar = f35950d;
        if (tVar == null) {
            synchronized (t.class) {
                tVar = f35950d;
                if (tVar == null) {
                    if (f35949c) {
                        tVar = s.a();
                    } else {
                        tVar = f35951e;
                    }
                    f35950d = tVar;
                }
            }
        }
        return tVar;
    }

    public static boolean c() {
        return f35948b;
    }

    public <ContainingType extends au> GeneratedMessageLite.e<ContainingType, ?> a(ContainingType containingtype, int i3) {
        return (GeneratedMessageLite.e) this.f35952a.get(new a(containingtype, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(t tVar) {
        if (tVar == f35951e) {
            this.f35952a = Collections.emptyMap();
        } else {
            this.f35952a = Collections.unmodifiableMap(tVar.f35952a);
        }
    }

    t(boolean z16) {
        this.f35952a = Collections.emptyMap();
    }
}
