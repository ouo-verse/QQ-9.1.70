package com.tencent.mobileqq.zplan.lite;

import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class FAssetChecker$verifyFassetSuspend$2$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f333780d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Continuation<Boolean> f333781e;

    @Override // java.lang.Runnable
    public final void run() {
        boolean e16;
        e16 = FAssetChecker.f333779a.e(this.f333780d);
        this.f333781e.resumeWith(Result.m476constructorimpl(Boolean.valueOf(e16)));
    }
}
