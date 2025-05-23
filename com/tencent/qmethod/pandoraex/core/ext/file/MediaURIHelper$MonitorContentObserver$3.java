package com.tencent.qmethod.pandoraex.core.ext.file;

import android.annotation.SuppressLint;
import android.database.ContentObserver;
import android.net.Uri;

/* compiled from: P */
/* loaded from: classes22.dex */
class MediaURIHelper$MonitorContentObserver$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ContentObserver f344066d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f344067e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Uri f344068f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f344069h;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        this.f344066d.onChange(this.f344067e, this.f344068f, this.f344069h);
    }
}
