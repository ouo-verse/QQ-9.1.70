package com.tencent.mobileqq.activity.aio;

import android.view.View;
import com.tencent.image.URLDrawable;

/* compiled from: P */
/* loaded from: classes10.dex */
class AIOUtils$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ URLDrawable f178030d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ View f178031e;

    @Override // java.lang.Runnable
    public void run() {
        if (this.f178030d.getStatus() == 0 || this.f178030d.getStatus() == 4) {
            this.f178031e.setVisibility(0);
        }
    }
}
