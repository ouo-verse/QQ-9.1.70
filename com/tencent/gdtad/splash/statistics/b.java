package com.tencent.gdtad.splash.statistics;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.splash.p;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f109422a;

    /* renamed from: b, reason: collision with root package name */
    private p f109423b;

    /* renamed from: c, reason: collision with root package name */
    private int f109424c;

    /* renamed from: d, reason: collision with root package name */
    private long f109425d;

    /* renamed from: e, reason: collision with root package name */
    private long f109426e;

    /* renamed from: f, reason: collision with root package name */
    private String f109427f;

    public b(int i3) {
        this.f109424c = Integer.MIN_VALUE;
        this.f109425d = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f109426e = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f109422a = i3;
    }

    public String a() {
        return this.f109427f;
    }

    public long b() {
        return this.f109425d;
    }

    public int c() {
        int i3;
        p pVar = this.f109423b;
        int i16 = Integer.MIN_VALUE;
        if (pVar != null) {
            i3 = pVar.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        p pVar2 = this.f109423b;
        if (pVar2 != null) {
            i16 = pVar2.c();
        }
        p pVar3 = this.f109423b;
        if (pVar3 != null) {
            pVar3.b();
        }
        if (i3 == 2000100) {
            return i16;
        }
        return i3;
    }

    public int d() {
        return this.f109422a;
    }

    public long e() {
        return this.f109426e;
    }

    public int f() {
        int i3;
        int i16;
        p pVar = this.f109423b;
        int i17 = Integer.MIN_VALUE;
        if (pVar != null) {
            i3 = pVar.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        p pVar2 = this.f109423b;
        if (pVar2 != null) {
            i16 = pVar2.c();
        } else {
            i16 = Integer.MIN_VALUE;
        }
        p pVar3 = this.f109423b;
        if (pVar3 != null) {
            i17 = pVar3.b();
        }
        if (i3 == 2000100) {
            return i17;
        }
        return i16;
    }

    public int g() {
        return this.f109424c;
    }

    public void h(String str) {
        this.f109427f = str;
    }

    public void i(p pVar) {
        this.f109423b = pVar;
    }

    public void j(long j3) {
        this.f109426e = j3;
    }

    public void k(int i3) {
        this.f109424c = i3;
    }

    public b(int i3, long j3) {
        this.f109424c = Integer.MIN_VALUE;
        this.f109426e = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f109422a = i3;
        this.f109425d = j3;
    }
}
