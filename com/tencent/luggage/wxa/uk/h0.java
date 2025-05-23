package com.tencent.luggage.wxa.uk;

import android.content.Context;
import android.view.OrientationEventListener;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h0 extends OrientationEventListener {

    /* renamed from: a, reason: collision with root package name */
    public a f142717a;

    /* renamed from: b, reason: collision with root package name */
    public int f142718b;

    /* renamed from: c, reason: collision with root package name */
    public b f142719c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        NONE,
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void onFourOrientationsChange(a aVar, a aVar2);
    }

    public h0(Context context, b bVar) {
        super(com.tencent.luggage.wxa.ye.c.a(context));
        this.f142717a = a.NONE;
        this.f142718b = 45;
        this.f142719c = bVar;
    }

    public void a(int i3) {
        if (i3 >= 0 && i3 <= 90) {
            this.f142718b = i3;
        } else {
            this.f142718b = 45;
        }
    }

    @Override // android.view.OrientationEventListener
    public void disable() {
        super.disable();
        this.f142717a = a.NONE;
    }

    @Override // android.view.OrientationEventListener
    public void enable() {
        super.enable();
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i3) {
        a aVar;
        if (i3 == -1) {
            return;
        }
        a aVar2 = this.f142717a;
        int i16 = this.f142718b;
        if ((i3 >= 360 - i16 && i3 < 360) || (i3 >= 0 && i3 <= i16 + 0)) {
            aVar = a.PORTRAIT;
        } else if (i3 >= 270 - i16 && i3 <= i16 + 270) {
            aVar = a.LANDSCAPE;
        } else if (i3 >= 180 - i16 && i3 <= i16 + 180) {
            aVar = a.REVERSE_PORTRAIT;
        } else if (i3 >= 90 - i16 && i3 <= i16 + 90) {
            aVar = a.REVERSE_LANDSCAPE;
        } else {
            aVar = aVar2;
        }
        if (aVar != aVar2) {
            b bVar = this.f142719c;
            if (bVar != null && aVar2 != a.NONE) {
                bVar.onFourOrientationsChange(aVar2, aVar);
            }
            this.f142717a = aVar;
        }
        com.tencent.luggage.wxa.tn.w.g("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", Integer.valueOf(i3));
    }
}
