package com.tencent.luggage.wxa.cc;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.picker.base.view.WheelView;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WheelView f123467a;

    public d(WheelView wheelView) {
        this.f123467a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1000) {
            if (i3 != 2000) {
                if (i3 == 3000) {
                    this.f123467a.i();
                    return;
                }
                return;
            }
            this.f123467a.a(WheelView.b.FLING);
            return;
        }
        this.f123467a.invalidate();
    }
}
