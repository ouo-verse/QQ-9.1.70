package com.qzone.widget.eventwidget;

import com.qzone.common.account.LoginData;

/* compiled from: P */
/* loaded from: classes37.dex */
class QZoneEventWidgetService$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f60843d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        QZoneEventWidgetData E = this.this$0.E(this.f60843d);
        if (E != null) {
            if (this.f60843d == LoginData.getInstance().getUin()) {
                this.this$0.f60845d = E;
            }
            this.this$0.J(this.f60843d, E, false);
        }
    }
}
