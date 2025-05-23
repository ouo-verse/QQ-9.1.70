package com.tencent.tbs.one;

import com.tencent.tbs.one.impl.a.g;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final d f374518a = new d();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a extends d {

        /* renamed from: b, reason: collision with root package name */
        private final String f374519b;

        /* synthetic */ a(String str, byte b16) {
            this(str);
        }

        @Override // com.tencent.tbs.one.b.d
        public void b(String str) {
            super.b(b.b(this.f374519b, str));
        }

        @Override // com.tencent.tbs.one.b.d
        public void c(String str) {
            super.c(b.b(this.f374519b, str));
        }

        public C9883b d(String str) {
            return new C9883b(this.f374519b, str, (byte) 0);
        }

        a(String str) {
            this.f374519b = str;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9883b extends d {

        /* renamed from: b, reason: collision with root package name */
        private final String f374520b;

        /* renamed from: c, reason: collision with root package name */
        private final String f374521c;

        /* synthetic */ C9883b(String str, String str2, byte b16) {
            this(str, str2);
        }

        @Override // com.tencent.tbs.one.b.d
        public void b(String str) {
            super.b(b.b(this.f374520b, this.f374521c, str));
        }

        @Override // com.tencent.tbs.one.b.d
        public void c(String str) {
            super.c(b.b(this.f374520b, this.f374521c, str));
        }

        C9883b(String str, String str2) {
            this.f374520b = str;
            this.f374521c = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicLong f374522a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicLong f374523b;

        /* renamed from: c, reason: collision with root package name */
        private final String f374524c;

        /* synthetic */ c(String str, byte b16) {
            this(str);
        }

        public final void a() {
            if (this.f374522a.get() < 0) {
                g.c("[timing] " + this.f374524c + " has not start yet!", new Object[0]);
                return;
            }
            if (this.f374523b.get() > 0) {
                g.c("[timing] " + this.f374524c + " has ended before, duplicated calling is not permitted!", new Throwable());
                return;
            }
            this.f374523b.set(new Date().getTime());
        }

        public final void b() {
            if (this.f374522a.get() > 0) {
                g.c("[timing] " + this.f374524c + " has started before, duplicated calling is not permitted!", new Throwable());
                return;
            }
            this.f374522a.set(new Date().getTime());
        }

        c(String str) {
            this.f374522a = new AtomicLong(-1L);
            this.f374523b = new AtomicLong(-1L);
            this.f374524c = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final Map<String, c> f374525a = new ConcurrentHashMap();

        private static c a(String str) {
            Map<String, c> map = f374525a;
            byte b16 = 0;
            if (!map.containsKey(str)) {
                map.put(str, new c(str, b16));
            }
            if (map.get(str) == null) {
                map.put(str, new c(str, b16));
            }
            return map.get(str);
        }

        public void b(String str) {
            a(str).a();
        }

        public void c(String str) {
            a(str).b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String... strArr) {
        StringBuilder sb5 = new StringBuilder();
        if (strArr.length == 1) {
            return strArr[0];
        }
        for (int i3 = 0; i3 < strArr.length - 1; i3++) {
            sb5.append(strArr[i3]);
            sb5.append("-");
        }
        sb5.append(strArr[strArr.length - 1]);
        return sb5.toString();
    }

    public static a c(String str) {
        return new a(str, (byte) 0);
    }
}
