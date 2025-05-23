package com.tencent.tbs.one.impl.common;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static b f374851a;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f374852a = "";

        /* renamed from: b, reason: collision with root package name */
        private int f374853b = -1;

        /* renamed from: c, reason: collision with root package name */
        private String f374854c = "";

        /* renamed from: d, reason: collision with root package name */
        private int f374855d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f374856e = -1;

        /* renamed from: f, reason: collision with root package name */
        private int f374857f = -1;

        /* renamed from: g, reason: collision with root package name */
        private int f374858g = -1;

        /* renamed from: h, reason: collision with root package name */
        private String f374859h = "";

        public void a() {
            if (h.f374851a != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("DEPS_VERSION_CODE", Integer.valueOf(this.f374857f));
                hashMap.put("DEPS_LOCAL_VERSION_CODE", Integer.valueOf(this.f374858g));
                hashMap.put("KEY_DEPS_COMPONENT_LOCV", this.f374859h);
                hashMap.put("COMPONENT_NAME", this.f374854c);
                hashMap.put("COMPONENT_VERSION_CODE", Integer.valueOf(this.f374855d));
                hashMap.put("COMPONENT_LOCAL_VERSION_CODE", Integer.valueOf(this.f374856e));
                h.f374851a.reportEvent(this.f374852a, this.f374853b, hashMap);
            }
        }

        public a b(int i3) {
            this.f374856e = i3;
            return this;
        }

        public a c(String str) {
            this.f374854c = str;
            return this;
        }

        public a d(int i3) {
            this.f374855d = i3;
            return this;
        }

        public a e(String str) {
            this.f374859h = str;
            return this;
        }

        public a f(int i3) {
            this.f374858g = i3;
            return this;
        }

        public a g(int i3) {
            this.f374857f = i3;
            return this;
        }

        public a h(int i3) {
            this.f374853b = i3;
            return this;
        }

        public a i(String str) {
            this.f374852a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void reportEvent(String str, int i3, Map<?, ?> map);

        void reportLog();
    }

    public static a b(String str, int i3) {
        return new a().i(str).h(i3);
    }

    public static void c(b bVar) {
        f374851a = bVar;
    }

    public static void d() {
        b bVar = f374851a;
        if (bVar != null) {
            bVar.reportLog();
        }
    }
}
