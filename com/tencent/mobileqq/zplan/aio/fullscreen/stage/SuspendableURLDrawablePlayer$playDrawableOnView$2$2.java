package com.tencent.mobileqq.zplan.aio.fullscreen.stage;

import android.widget.ImageView;
import com.tencent.image.SharpDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.zplan.aio.fullscreen.stage.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class SuspendableURLDrawablePlayer$playDrawableOnView$2$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ImageView f331013d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ URLDrawable f331014e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<Unit> f331015f;
    final /* synthetic */ d this$0;

    @Override // java.lang.Runnable
    public final void run() {
        d.a aVar;
        ImageView imageView = this.f331013d;
        URLDrawable uRLDrawable = this.f331014e;
        d dVar = this.this$0;
        CancellableContinuation<Unit> cancellableContinuation = this.f331015f;
        e.b();
        SharpDrawable a16 = f.a(uRLDrawable);
        if (a16 != null) {
            aVar = dVar.playEndContWrapper;
            aVar.a(cancellableContinuation);
            a16.setOnPlayRepeatListener(aVar);
        }
        imageView.setImageDrawable(uRLDrawable);
    }
}
