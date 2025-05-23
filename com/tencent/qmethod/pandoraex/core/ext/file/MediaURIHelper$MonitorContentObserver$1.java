package com.tencent.qmethod.pandoraex.core.ext.file;

import android.database.ContentObserver;

/* compiled from: P */
/* loaded from: classes22.dex */
class MediaURIHelper$MonitorContentObserver$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ContentObserver f344061d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f344062e;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public void run() {
        this.f344061d.onChange(this.f344062e);
    }
}
