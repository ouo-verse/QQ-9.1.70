package com.tencent.biz.qui.quicommon;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes5.dex */
class QUIImmersiveUtil$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f95154d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ View f95155e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f95156f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Integer f95157h;

    @Override // java.lang.Runnable
    public void run() {
        this.f95154d.height = (this.f95155e.getHeight() + this.f95156f) - this.f95157h.intValue();
        View view = this.f95155e;
        view.setPadding(view.getPaddingLeft(), (this.f95155e.getPaddingTop() + this.f95156f) - this.f95157h.intValue(), this.f95155e.getPaddingRight(), this.f95155e.getPaddingBottom());
        this.f95155e.setLayoutParams(this.f95154d);
    }
}
