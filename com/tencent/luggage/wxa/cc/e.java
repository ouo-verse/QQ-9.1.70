package com.tencent.luggage.wxa.cc;

import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public int f123468a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public int f123469b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f123470c;

    /* renamed from: d, reason: collision with root package name */
    public final WheelView f123471d;

    public e(WheelView wheelView, int i3) {
        this.f123471d = wheelView;
        this.f123470c = i3;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f123468a == Integer.MAX_VALUE) {
            this.f123468a = this.f123470c;
        }
        int i3 = this.f123468a;
        int i16 = (int) (i3 * 0.1f);
        this.f123469b = i16;
        if (i16 == 0) {
            if (i3 < 0) {
                this.f123469b = -1;
            } else {
                this.f123469b = 1;
            }
        }
        if (Math.abs(i3) <= 1) {
            this.f123471d.b();
            this.f123471d.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f123471d;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f123469b);
        if (!this.f123471d.d()) {
            float itemHeight = this.f123471d.getItemHeight();
            float itemsCount = ((this.f123471d.getItemsCount() - 1) - this.f123471d.getInitPosition()) * itemHeight;
            if (this.f123471d.getTotalScrollY() <= (-this.f123471d.getInitPosition()) * itemHeight || this.f123471d.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f123471d;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f123469b);
                this.f123471d.b();
                this.f123471d.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f123471d.getHandler().sendEmptyMessage(1000);
        this.f123468a -= this.f123469b;
    }
}
