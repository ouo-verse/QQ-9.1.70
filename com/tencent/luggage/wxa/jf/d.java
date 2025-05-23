package com.tencent.luggage.wxa.jf;

import com.tencent.luggage.wxa.fd.x;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f130988a;

        /* renamed from: b, reason: collision with root package name */
        public int f130989b;

        /* renamed from: c, reason: collision with root package name */
        public String f130990c;

        /* renamed from: d, reason: collision with root package name */
        public int f130991d;

        /* renamed from: e, reason: collision with root package name */
        public String f130992e;

        /* renamed from: f, reason: collision with root package name */
        public String f130993f;

        /* renamed from: g, reason: collision with root package name */
        public int f130994g;

        /* renamed from: h, reason: collision with root package name */
        public String f130995h;

        /* renamed from: i, reason: collision with root package name */
        public String f130996i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f130997j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f130998k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f130999l;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum a {
            PROCEED,
            IGNORE,
            CANCEL
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(com.tencent.luggage.wxa.fd.i iVar);

        void a(boolean z16, String str);
    }

    void a(com.tencent.luggage.wxa.ic.d dVar, String str, int i3, String str2, a aVar, JSONObject jSONObject, x xVar, c cVar);

    void a(com.tencent.luggage.wxa.ic.d dVar, String str, int i3, String str2, a aVar, JSONObject jSONObject, c cVar);
}
