package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;

/* loaded from: classes10.dex */
class DoodlePanel$5$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f178404d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ f f178405e;

    @Override // java.lang.Runnable
    public void run() {
        a61.b bVar;
        this.f178405e.f178539a.d();
        if (this.f178404d == com.tencent.mobileqq.scribble.e.f282561d) {
            this.f178405e.f178539a.h();
            return;
        }
        QQToast makeText = QQToast.makeText(this.f178405e.f178539a.getContext(), R.string.j3, 0);
        bVar = this.f178405e.f178539a.D;
        makeText.show(bVar.e());
    }
}
