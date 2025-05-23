package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cs {

    /* renamed from: a, reason: collision with root package name */
    private final long f265939a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<ct> f265940b;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f265941a = 0;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<ct> f265942b = null;

        public cs c() {
            return new cs(this);
        }

        public a d(long j3) {
            this.f265941a = j3;
            return this;
        }

        public a e(ArrayList<ct> arrayList) {
            this.f265942b = arrayList;
            return this;
        }
    }

    public cs() {
        this.f265939a = 0L;
        this.f265940b = null;
    }

    public long a() {
        return this.f265939a;
    }

    public ArrayList<ct> b() {
        return this.f265940b;
    }

    cs(a aVar) {
        this.f265939a = aVar.f265941a;
        this.f265940b = aVar.f265942b;
    }
}
