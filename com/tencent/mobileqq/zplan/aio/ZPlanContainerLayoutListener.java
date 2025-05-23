package com.tencent.mobileqq.zplan.aio;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes35.dex */
public class ZPlanContainerLayoutListener implements View.OnLayoutChangeListener, Runnable {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<a61.c> f330907d;

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        this.f330907d.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f330907d.get();
    }
}
