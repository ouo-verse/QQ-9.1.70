package com.tencent.luggage.wxa.dm;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.ic.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public String f124383a;

    /* renamed from: b, reason: collision with root package name */
    public l f124384b;

    /* renamed from: c, reason: collision with root package name */
    public d f124385c;

    /* renamed from: d, reason: collision with root package name */
    public a f124386d;

    /* renamed from: e, reason: collision with root package name */
    public int f124387e = -1;

    /* renamed from: f, reason: collision with root package name */
    public volatile f f124388f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void b(int i3);
    }

    public e(String str, d dVar, l lVar) {
        this.f124383a = str;
        this.f124384b = lVar;
        this.f124385c = dVar;
    }

    public void a(f fVar) {
        this.f124388f = fVar;
    }

    public a b() {
        return this.f124386d;
    }

    public String c() {
        String str = this.f124383a;
        if (str != null && !str.isEmpty()) {
            return this.f124383a;
        }
        return null;
    }

    public int d() {
        return this.f124387e;
    }

    public abstract void e();

    public void a(a aVar) {
        this.f124386d = aVar;
    }

    public void a(int i3) {
        this.f124387e = i3;
    }

    public void a() {
        this.f124388f = null;
    }

    public void a(Bitmap bitmap) {
        f fVar = this.f124388f;
        if (fVar != null) {
            fVar.a(bitmap, this);
        }
    }

    public e(String str, d dVar) {
        this.f124383a = str;
        this.f124385c = dVar;
    }
}
