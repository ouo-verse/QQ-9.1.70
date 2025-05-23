package com.tencent.qmethod.pandoraex.core.ext.file;

import android.annotation.SuppressLint;
import android.database.ContentObserver;
import android.net.Uri;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
class MediaURIHelper$MonitorContentObserver$4 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ContentObserver f344070d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f344071e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Collection f344072f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f344073h;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        this.f344070d.onChange(this.f344071e, (Collection<Uri>) this.f344072f, this.f344073h);
    }
}
