package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.aio.doodle.k;
import com.tencent.mobileqq.activity.aio.doodle.m;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g implements k {

    /* renamed from: g, reason: collision with root package name */
    public static final k.a<g> f178540g = new a();

    /* renamed from: a, reason: collision with root package name */
    private Rect f178541a;

    /* renamed from: b, reason: collision with root package name */
    private float f178542b;

    /* renamed from: c, reason: collision with root package name */
    private float f178543c;

    /* renamed from: d, reason: collision with root package name */
    private float f178544d;

    /* renamed from: e, reason: collision with root package name */
    private float f178545e;

    /* renamed from: f, reason: collision with root package name */
    private int f178546f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements k.a<g> {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.k.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(j jVar) {
            return new g(jVar);
        }
    }

    public g() {
        this.f178541a = new Rect();
        this.f178542b = 0.0f;
        this.f178543c = 0.0f;
        this.f178544d = 0.0f;
        this.f178545e = 0.0f;
        this.f178546f = 0;
        BaseApplication context = BaseApplication.getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f178546f = min;
        float f16 = min / 750.0f;
        this.f178542b = 12.0f * f16;
        this.f178543c = f16 * 6.0f;
        this.f178544d = Utils.o(50.0f, context.getResources()) / 1000.0f;
        this.f178545e = Utils.o(0.4f, context.getResources()) / 1000.0f;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.k
    public void a(j jVar, int i3) {
        jVar.l(1);
        jVar.p(this.f178541a);
        jVar.k(this.f178542b);
        jVar.k(this.f178543c);
        jVar.k(this.f178544d);
        jVar.k(this.f178545e);
    }

    public void b(m mVar) {
        ArrayList<m.a> h16;
        if (mVar != null && (h16 = mVar.h()) != null) {
            int size = h16.size();
            int i3 = 1;
            if (size == 1) {
                h16.get(0).i(f());
                return;
            }
            if (size > 1) {
                h16.get(0).i(f());
                m.a aVar = h16.get(0);
                while (i3 < size) {
                    m.a aVar2 = h16.get(i3);
                    aVar2.i(c(aVar2.b() - aVar.b(), aVar.d(), aVar.e(), aVar2.d(), aVar2.e()));
                    i3++;
                    aVar = aVar2;
                }
            }
        }
    }

    public float c(long j3, float f16, float f17, float f18, float f19) {
        int i3;
        float f26 = ((float) j3) / 1000.0f;
        float f27 = f18 - f16;
        float f28 = f19 - f17;
        float sqrt = (float) Math.sqrt((f27 * f27) + (f28 * f28));
        if (sqrt <= 0.0f) {
            return f();
        }
        BaseApplication context = BaseApplication.getContext();
        float f29 = f26 / sqrt;
        if (this.f178541a.width() > 0) {
            i3 = this.f178541a.width();
        } else {
            i3 = this.f178546f;
        }
        float R = f29 * Utils.R(i3, context.getResources());
        float e16 = e();
        float g16 = g();
        float h16 = h();
        float f36 = f();
        if (R > e16) {
            return f36;
        }
        if (R >= g16) {
            return h16 + (((R - g16) * (f() - h16)) / (e16 - g16));
        }
        return h16;
    }

    public Rect d() {
        return this.f178541a;
    }

    public float e() {
        return this.f178544d;
    }

    public float f() {
        return this.f178542b;
    }

    public float g() {
        return this.f178545e;
    }

    public float h() {
        return this.f178543c;
    }

    public void i(g gVar) {
        this.f178544d = gVar.e();
        this.f178545e = gVar.g();
        this.f178542b = gVar.f();
        this.f178543c = gVar.h();
        this.f178541a.set(gVar.d());
    }

    public void j(int i3, int i16) {
        this.f178541a.set(0, 0, i3, i16);
    }

    public void k(float f16) {
        this.f178544d = f16;
    }

    public void l(float f16) {
        this.f178542b = f16;
    }

    public void m(float f16) {
        this.f178545e = f16;
    }

    public void n(float f16) {
        this.f178543c = f16;
    }

    public g(j jVar) {
        this.f178541a = new Rect();
        this.f178542b = 0.0f;
        this.f178543c = 0.0f;
        this.f178544d = 0.0f;
        this.f178545e = 0.0f;
        this.f178546f = 0;
        jVar.d();
        this.f178541a = jVar.h();
        this.f178542b = jVar.c();
        this.f178543c = jVar.c();
        this.f178544d = jVar.c();
        this.f178545e = jVar.c();
    }
}
