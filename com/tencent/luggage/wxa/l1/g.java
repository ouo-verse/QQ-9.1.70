package com.tencent.luggage.wxa.l1;

import android.content.Context;
import android.util.Size;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.luggage.wxa.l1.a;
import com.tencent.luggage.wxa.qh.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.l1.b implements com.tencent.luggage.wxa.re.f {

    /* renamed from: l0, reason: collision with root package name */
    public Surface f132946l0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.f {
        @Override // com.tencent.luggage.wxa.qh.a.f
        public com.tencent.luggage.wxa.re.e a(Context context) {
            return new g(context);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends a.i {
        public b() {
            super();
        }

        @Override // com.tencent.luggage.wxa.l1.a.i
        public com.tencent.luggage.wxa.n1.b d() {
            return new com.tencent.luggage.wxa.n1.b();
        }

        @Override // com.tencent.luggage.wxa.l1.a.i, com.tencent.luggage.wxa.l1.a.g
        public void init() {
            a(1);
            super.init();
        }
    }

    public g(Context context) {
        super(context);
    }

    public static void u() {
        com.tencent.luggage.wxa.qh.a.a(new a());
    }

    @Override // com.tencent.luggage.wxa.l1.b, com.tencent.luggage.wxa.l1.a
    public d a(Context context, int i3, int i16) {
        return new h(context, this.f132946l0, i3, i16);
    }

    @Override // com.tencent.luggage.wxa.re.f
    public void handlePluginTouch(MotionEvent motionEvent) {
        if (getRecordView() == null) {
            return;
        }
        getRecordView().handlePluginTouch(motionEvent);
    }

    @Override // com.tencent.luggage.wxa.re.f
    public void setCustomSurface(Surface surface) {
        w.d("MicroMsg.SameLayerCameraView", "setCustomSurface:%s", surface);
        this.f132946l0 = surface;
    }

    @Override // com.tencent.luggage.wxa.l1.b, com.tencent.luggage.wxa.l1.a
    public a.g a(String str) {
        if (!w0.c(str) && str.equals("scanCode") && com.tencent.luggage.wxa.y3.a.f145414a.a()) {
            return new b();
        }
        return super.a(str);
    }

    @Override // com.tencent.luggage.wxa.l1.a, com.tencent.luggage.wxa.re.e
    public void setDisplayScreenSize(Size size) {
    }
}
