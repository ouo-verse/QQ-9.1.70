package com.tencent.luggage.wxa.cc;

import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public float f123464a = 2.14748365E9f;

    /* renamed from: b, reason: collision with root package name */
    public final float f123465b;

    /* renamed from: c, reason: collision with root package name */
    public final WheelView f123466c;

    public c(WheelView wheelView, float f16) {
        this.f123466c = wheelView;
        this.f123465b = f16;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f123464a == 2.14748365E9f) {
            float f16 = 2000.0f;
            if (Math.abs(this.f123465b) > 2000.0f) {
                if (this.f123465b <= 0.0f) {
                    f16 = -2000.0f;
                }
                this.f123464a = f16;
            } else {
                this.f123464a = this.f123465b;
            }
        }
        if (Math.abs(this.f123464a) >= 0.0f && Math.abs(this.f123464a) <= 20.0f) {
            this.f123466c.b();
            this.f123466c.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i3 = (int) (this.f123464a / 100.0f);
        WheelView wheelView = this.f123466c;
        float f17 = i3;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f17);
        if (!this.f123466c.d()) {
            float itemHeight = this.f123466c.getItemHeight();
            float f18 = (-this.f123466c.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f123466c.getItemsCount() - 1) - this.f123466c.getInitPosition()) * itemHeight;
            double d16 = itemHeight * 0.25d;
            if (this.f123466c.getTotalScrollY() - d16 < f18) {
                f18 = this.f123466c.getTotalScrollY() + f17;
            } else if (this.f123466c.getTotalScrollY() + d16 > itemsCount) {
                itemsCount = this.f123466c.getTotalScrollY() + f17;
            }
            if (this.f123466c.getTotalScrollY() <= f18) {
                this.f123464a = 40.0f;
                this.f123466c.setTotalScrollY((int) f18);
            } else if (this.f123466c.getTotalScrollY() >= itemsCount) {
                this.f123466c.setTotalScrollY((int) itemsCount);
                this.f123464a = -40.0f;
            }
        }
        float f19 = this.f123464a;
        if (f19 < 0.0f) {
            this.f123464a = f19 + 20.0f;
        } else {
            this.f123464a = f19 - 20.0f;
        }
        this.f123466c.getHandler().sendEmptyMessage(1000);
    }
}
