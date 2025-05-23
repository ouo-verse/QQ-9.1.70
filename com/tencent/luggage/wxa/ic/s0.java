package com.tencent.luggage.wxa.ic;

import android.app.Activity;
import android.view.View;
import com.tencent.luggage.wxa.wj.d;
import com.tencent.luggage.wxa.wj.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s0 extends com.tencent.luggage.wxa.wj.a {

    /* renamed from: l, reason: collision with root package name */
    public final com.tencent.luggage.wxa.wj.c f129992l;

    /* renamed from: m, reason: collision with root package name */
    public Activity f129993m;

    /* renamed from: n, reason: collision with root package name */
    public e.b f129994n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f129995o;

    /* renamed from: p, reason: collision with root package name */
    public e.b f129996p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(com.tencent.luggage.wxa.wj.c windowAndroid, d.a aVar, Activity activity) {
        super(windowAndroid, aVar);
        Intrinsics.checkNotNullParameter(windowAndroid, "windowAndroid");
        this.f129992l = windowAndroid;
        this.f129993m = activity;
        this.f129994n = e.b.PORTRAIT;
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public void a(int i3) {
        this.f144260k = true;
        String str = (i3 == -90 || i3 == 90) ? "landscape" : "portrait";
        this.f129996p = e.b.a(str);
        e.b a16 = this.f129992l.getOrientationHandler().a();
        Intrinsics.checkNotNullExpressionValue(a16, "windowAndroid.orientatio\u2026andler.currentOrientation");
        this.f129994n = a16;
        this.f129992l.setSoftOrientation(str);
        if (!Intrinsics.areEqual(str, "landscape") || e.b.b(this.f129992l.getOrientationHandler().a())) {
            return;
        }
        this.f129992l.getOrientationHandler().a(e.b.LANDSCAPE_SENSOR, null);
    }

    @Override // com.tencent.luggage.wxa.wj.a, com.tencent.luggage.wxa.wj.d
    public boolean c() {
        boolean z16 = this.f144260k;
        boolean z17 = false;
        if (z16) {
            this.f129995o = false;
        }
        if (super.c()) {
            if (e.b.b(this.f129994n)) {
                this.f129992l.setSoftOrientation("landscape");
            } else {
                this.f129992l.setSoftOrientation("portrait");
            }
            this.f129992l.getOrientationHandler().a(this.f129994n, null);
            e();
            z17 = true;
        } else if (z16) {
            this.f144260k = false;
            e();
            return true;
        }
        this.f129996p = null;
        return z17;
    }

    public final boolean f() {
        return this.f129995o;
    }

    @Override // com.tencent.luggage.wxa.wj.a, com.tencent.luggage.wxa.wj.d
    public void release() {
        super.release();
        this.f129993m = null;
    }

    @Override // com.tencent.luggage.wxa.wj.d
    public e.b a() {
        return this.f129996p;
    }

    @Override // com.tencent.luggage.wxa.wj.a, com.tencent.luggage.wxa.wj.d
    public void a(View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.a(view, i3);
        a(i3);
        d();
        this.f129995o = true;
    }
}
