package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class r extends t {

    /* renamed from: j, reason: collision with root package name */
    static final r f35937j = new r(true);

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f35938k = 0;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, b> f35939f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, b> f35940g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<a, b> f35941h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<a, b> f35942i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Descriptors.b f35943a;

        /* renamed from: b, reason: collision with root package name */
        private final int f35944b;

        a(Descriptors.b bVar, int i3) {
            this.f35943a = bVar;
            this.f35944b = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f35943a != aVar.f35943a || this.f35944b != aVar.f35944b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f35943a.hashCode() * 65535) + this.f35944b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Descriptors.FieldDescriptor f35945a;

        /* renamed from: b, reason: collision with root package name */
        public final ar f35946b;
    }

    r() {
        this.f35939f = new HashMap();
        this.f35940g = new HashMap();
        this.f35941h = new HashMap();
        this.f35942i = new HashMap();
    }

    public static r f() {
        return f35937j;
    }

    public static r g() {
        return new r();
    }

    @Deprecated
    public b d(Descriptors.b bVar, int i3) {
        return e(bVar, i3);
    }

    public b e(Descriptors.b bVar, int i3) {
        return this.f35941h.get(new a(bVar, i3));
    }

    r(boolean z16) {
        super(t.f35951e);
        this.f35939f = Collections.emptyMap();
        this.f35940g = Collections.emptyMap();
        this.f35941h = Collections.emptyMap();
        this.f35942i = Collections.emptyMap();
    }
}
