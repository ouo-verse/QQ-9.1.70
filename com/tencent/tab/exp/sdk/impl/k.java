package com.tencent.tab.exp.sdk.impl;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.tab.exp.sdk.pbdata.Experiment;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class k {

    /* renamed from: i, reason: collision with root package name */
    static final Experiment f374117i = null;

    /* renamed from: j, reason: collision with root package name */
    static final Map<String, String> f374118j = null;

    /* renamed from: a, reason: collision with root package name */
    private final Experiment f374119a;

    /* renamed from: b, reason: collision with root package name */
    private final String f374120b;

    /* renamed from: c, reason: collision with root package name */
    private final String f374121c;

    /* renamed from: d, reason: collision with root package name */
    private final String f374122d;

    /* renamed from: e, reason: collision with root package name */
    private final String f374123e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, String> f374124f;

    /* renamed from: g, reason: collision with root package name */
    private volatile long f374125g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f374126h;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Experiment f374127a = k.f374117i;

        /* renamed from: b, reason: collision with root package name */
        private String f374128b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f374129c = "";

        /* renamed from: d, reason: collision with root package name */
        private String f374130d = "";

        /* renamed from: e, reason: collision with root package name */
        private String f374131e = EmoticonPackage.MAGIC_FACE_EPID;

        /* renamed from: f, reason: collision with root package name */
        private Map<String, String> f374132f = k.f374118j;

        public b g(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f374130d = str;
            }
            return this;
        }

        public k h() {
            return new k(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b i(Experiment experiment) {
            this.f374127a = experiment;
            return this;
        }

        public b j(String str) {
            this.f374131e = str;
            return this;
        }

        public b k(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f374129c = str;
            }
            return this;
        }

        public b l(Map<String, String> map) {
            this.f374132f = map;
            return this;
        }

        public b m(String str) {
            this.f374128b = str;
            return this;
        }
    }

    public String a() {
        return this.f374121c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Experiment b() {
        return this.f374119a;
    }

    public String c() {
        return this.f374122d;
    }

    public String d() {
        return this.f374120b;
    }

    public Map<String, String> e() {
        return this.f374124f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (x.g(this.f374119a, kVar.f374119a) && x.g(this.f374120b, kVar.f374120b) && x.g(this.f374121c, kVar.f374121c) && x.g(this.f374122d, kVar.f374122d) && x.g(this.f374123e, kVar.f374123e)) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f374123e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(@NonNull int i3) {
        if (i3 <= 0) {
            this.f374125g = SystemClock.elapsedRealtime();
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = i3 * 1000;
        if (elapsedRealtime - this.f374125g < j3) {
            return false;
        }
        synchronized (this.f374126h) {
            if (elapsedRealtime - this.f374125g < j3) {
                return false;
            }
            this.f374125g = SystemClock.elapsedRealtime();
            return true;
        }
    }

    public int hashCode() {
        return x.h(this.f374119a, this.f374120b, this.f374121c, this.f374122d, this.f374123e);
    }

    public String toString() {
        return "TabExpInfo{mData=" + this.f374119a + ", mLayerName='" + this.f374123e + "', mExpName='" + this.f374120b + "', mAssignment='" + this.f374121c + "', mExpGrayId='" + this.f374122d + "', mExpParams='" + this.f374124f.toString() + "'}\n";
    }

    k(@NonNull b bVar) {
        this.f374119a = bVar.f374127a;
        this.f374120b = bVar.f374129c;
        this.f374121c = bVar.f374130d;
        this.f374122d = bVar.f374131e;
        this.f374123e = bVar.f374128b;
        this.f374124f = bVar.f374132f;
        this.f374126h = new Object();
    }
}
