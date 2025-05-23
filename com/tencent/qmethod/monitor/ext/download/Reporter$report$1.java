package com.tencent.qmethod.monitor.ext.download;

import android.graphics.Bitmap;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes22.dex */
final class Reporter$report$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f343630d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f343631e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f343632f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f343633h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ Bitmap f343634i;

    @Override // java.lang.Runnable
    public final void run() {
        Reporter reporter = Reporter.f343628d;
        DownloadInfo downloadInfo = new DownloadInfo(this.f343630d, 0L, 2, null);
        String d16 = com.tencent.qmethod.pandoraex.core.a.d();
        Intrinsics.checkExpressionValueIsNotNull(d16, "ActivityDetector.getTopActivityName()");
        downloadInfo.u(d16);
        downloadInfo.t(this.f343631e);
        downloadInfo.s(this.f343632f);
        downloadInfo.x(this.f343633h);
        downloadInfo.w(this.f343634i);
        reporter.d(downloadInfo);
    }
}
