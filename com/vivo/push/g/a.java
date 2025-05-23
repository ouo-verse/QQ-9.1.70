package com.vivo.push.g;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f387706a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f387707b;

    /* compiled from: P */
    /* renamed from: com.vivo.push.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static class C10086a {

        /* renamed from: a, reason: collision with root package name */
        private static a f387708a = new a(0);
    }

    /* synthetic */ a(byte b16) {
        this();
    }

    public static a a() {
        return C10086a.f387708a;
    }

    public final boolean b() {
        ArrayList<String> arrayList = this.f387707b;
        if (arrayList != null && arrayList.size() != 0) {
            return true;
        }
        return false;
    }

    a() {
        this.f387707b = null;
        this.f387707b = new ArrayList<>();
    }
}
