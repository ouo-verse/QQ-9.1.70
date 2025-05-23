package com.tencent.qmethod.pandoraex.core.ext.file;

import android.annotation.SuppressLint;
import android.database.ContentObserver;
import android.net.Uri;

/* compiled from: P */
/* loaded from: classes22.dex */
class MediaURIHelper$MonitorContentObserver$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ContentObserver f344063d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f344064e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Uri f344065f;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        this.f344063d.onChange(this.f344064e, this.f344065f);
    }
}
