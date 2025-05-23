package com.qq.e.comm.plugin.i;

import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private File f39493a;

    /* renamed from: b, reason: collision with root package name */
    private int f39494b;

    /* renamed from: c, reason: collision with root package name */
    private int f39495c;

    /* renamed from: d, reason: collision with root package name */
    private int f39496d;

    /* renamed from: e, reason: collision with root package name */
    private int f39497e;

    /* renamed from: f, reason: collision with root package name */
    private List<File> f39498f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private File f39501a;

        /* renamed from: b, reason: collision with root package name */
        private int f39502b;

        /* renamed from: c, reason: collision with root package name */
        private int f39503c;

        /* renamed from: d, reason: collision with root package name */
        private int f39504d;

        /* renamed from: e, reason: collision with root package name */
        private int f39505e;

        public a a(File file) {
            this.f39501a = file;
            return this;
        }

        public a b(int i3) {
            this.f39503c = i3;
            return this;
        }

        public a c(int i3) {
            this.f39504d = i3;
            return this;
        }

        public a d(int i3) {
            this.f39505e = i3;
            return this;
        }

        public a a(int i3) {
            this.f39502b = i3;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.a(this.f39501a);
            bVar.a(this.f39502b);
            bVar.b(this.f39503c);
            bVar.c(this.f39504d);
            bVar.d(this.f39505e);
            return bVar;
        }
    }

    public List<File> e() {
        return this.f39498f;
    }

    public int f() {
        return this.f39497e;
    }

    public int b() {
        return this.f39494b;
    }

    public int c() {
        return this.f39495c;
    }

    public int d() {
        return this.f39496d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3) {
        this.f39495c = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3) {
        this.f39496d = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3) {
        this.f39497e = i3;
    }

    public File a() {
        return this.f39493a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        this.f39493a = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        this.f39494b = i3;
    }

    public void a(List<File> list) {
        this.f39498f = list;
    }
}
