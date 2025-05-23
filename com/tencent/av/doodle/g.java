package com.tencent.av.doodle;

import android.graphics.Canvas;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g extends f {

    /* renamed from: l, reason: collision with root package name */
    private h f73632l = new h();

    public g(int i3) {
        i(i3);
    }

    private void i(int i3) {
        this.f73632l.b(BaseApplication.getContext(), R.raw.f169418p, i3);
        this.f73632l.c(this.f73631k);
    }

    @Override // com.tencent.av.doodle.b
    public void a(Canvas canvas, MySurfaceView mySurfaceView, boolean z16) {
        this.f73632l.a(canvas);
    }

    @Override // com.tencent.av.doodle.b
    public void d(long j3) {
        this.f73632l.d(((float) j3) / 1000.0f);
    }

    @Override // com.tencent.av.doodle.f, com.tencent.av.doodle.b
    public void g(float f16, float f17) {
        super.g(f16, f17);
        this.f73632l.c(null);
    }

    @Override // com.tencent.av.doodle.f
    public void h() {
    }
}
