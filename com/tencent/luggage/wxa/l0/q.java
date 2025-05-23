package com.tencent.luggage.wxa.l0;

import com.tencent.luggage.wxa.l0.g;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface q extends g {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public final e f132831a = new e();

        @Override // com.tencent.luggage.wxa.l0.g.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q createDataSource() {
            return a(this.f132831a);
        }

        public abstract q a(e eVar);

        @Override // com.tencent.luggage.wxa.l0.q.b
        public final void a(String str, String str2) {
            this.f132831a.a(str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends g.a {
        void a(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends c {

        /* renamed from: c, reason: collision with root package name */
        public final int f132834c;

        /* renamed from: d, reason: collision with root package name */
        public final Map f132835d;

        public d(int i3, Map map, j jVar) {
            super("Response code: " + i3, jVar, 1);
            this.f132834c = i3;
            this.f132835d = map;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final Map f132836a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public Map f132837b;

        public synchronized void a(String str, String str2) {
            this.f132837b = null;
            this.f132836a.put(str, str2);
        }

        public synchronized Map a() {
            if (this.f132837b == null) {
                this.f132837b = Collections.unmodifiableMap(new HashMap(this.f132836a));
            }
            return this.f132837b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final int f132832a;

        /* renamed from: b, reason: collision with root package name */
        public final j f132833b;

        public c(String str, j jVar, int i3) {
            super(str);
            this.f132833b = jVar;
            this.f132832a = i3;
        }

        public c(IOException iOException, j jVar, int i3) {
            super(iOException);
            this.f132833b = jVar;
            this.f132832a = i3;
        }

        public c(String str, IOException iOException, j jVar, int i3) {
            super(str, iOException);
            this.f132833b = jVar;
            this.f132832a = i3;
        }
    }
}
