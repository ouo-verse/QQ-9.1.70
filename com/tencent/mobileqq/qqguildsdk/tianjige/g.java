package com.tencent.mobileqq.qqguildsdk.tianjige;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f268518a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f268519b;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f268520a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, String> f268521b = new HashMap();

        public g a() {
            return new g(this.f268520a, this.f268521b);
        }

        public a b(String str) {
            this.f268520a = str;
            return this;
        }

        public a c(Map<String, String> map) {
            if (map != null) {
                this.f268521b.putAll(map);
            }
            return this;
        }
    }

    g(String str, Map<String, String> map) {
        this.f268518a = str;
        this.f268519b = map;
    }

    public static a a() {
        return new a();
    }

    public String b() {
        return this.f268518a;
    }

    public Map<String, String> c() {
        return this.f268519b;
    }
}
