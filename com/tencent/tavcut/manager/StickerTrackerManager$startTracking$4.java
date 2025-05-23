package com.tencent.tavcut.manager;

import android.graphics.Bitmap;
import android.util.Log;
import com.gyailib.library.GYTrackSticker;
import com.gyailib.library.GYTrackStickerInfo;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.manager.StickerTrackerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import le4.e;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes26.dex */
final class StickerTrackerManager$startTracking$4 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScreenTransform f374341d;
    final /* synthetic */ StickerTrackerManager this$0;

    @Override // java.lang.Runnable
    public final void run() {
        Float f16;
        Float f17;
        Float f18;
        Float f19;
        long j3 = 0;
        while (true) {
            boolean z16 = true;
            if (StickerTrackerManager.c(null) != StickerTrackerManager.StickerTrackerManagerState.Working && !(!StickerTrackerManager.g(null).isEmpty())) {
                return;
            }
            if (!StickerTrackerManager.g(null).isEmpty()) {
                StickerTrackerManager.a b16 = StickerTrackerManager.b(null);
                if (StickerTrackerManager.h(null)) {
                    if (b16.a() != null) {
                        StickerTrackerManager.i(null, false);
                        ScreenTransform screenTransform = this.f374341d;
                        Bitmap a16 = b16.a();
                        if (a16 == null) {
                            Intrinsics.throwNpe();
                        }
                        int width = a16.getWidth();
                        Bitmap a17 = b16.a();
                        if (a17 == null) {
                            Intrinsics.throwNpe();
                        }
                        StickerTrackerManager.j(null, e.c(screenTransform, width, a17.getHeight(), b16.b()));
                        String e16 = StickerTrackerManager.e(null);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("detect first frame:");
                        sb5.append(((float) b16.b()) / 1000.0f);
                        sb5.append(',');
                        if (b16.a() != null) {
                            z16 = false;
                        }
                        sb5.append(z16);
                        sb5.append(',');
                        sb5.append("x:");
                        GYTrackStickerInfo f26 = StickerTrackerManager.f(null);
                        if (f26 != null) {
                            f16 = Float.valueOf(f26.f35992x);
                        } else {
                            f16 = null;
                        }
                        sb5.append(f16);
                        sb5.append(",y:");
                        GYTrackStickerInfo f27 = StickerTrackerManager.f(null);
                        if (f27 != null) {
                            f17 = Float.valueOf(f27.f35993y);
                        } else {
                            f17 = null;
                        }
                        sb5.append(f17);
                        sb5.append(",w:");
                        GYTrackStickerInfo f28 = StickerTrackerManager.f(null);
                        if (f28 != null) {
                            f18 = Float.valueOf(f28.f35991w);
                        } else {
                            f18 = null;
                        }
                        sb5.append(f18);
                        sb5.append(",h:");
                        GYTrackStickerInfo f29 = StickerTrackerManager.f(null);
                        if (f29 != null) {
                            f19 = Float.valueOf(f29.f35990h);
                        } else {
                            f19 = null;
                        }
                        sb5.append(f19);
                        sb5.append(" imageW:");
                        Bitmap a18 = b16.a();
                        if (a18 == null) {
                            Intrinsics.throwNpe();
                        }
                        sb5.append(a18.getWidth());
                        sb5.append(" imageW:");
                        Bitmap a19 = b16.a();
                        if (a19 == null) {
                            Intrinsics.throwNpe();
                        }
                        sb5.append(a19.getHeight());
                        Log.i(e16, sb5.toString());
                        GYTrackSticker d16 = StickerTrackerManager.d(null);
                        if (d16 != null) {
                            d16.detect(b16.a(), StickerTrackerManager.f(null));
                        }
                        j3 = b16.b();
                    }
                } else {
                    new GYTrackStickerInfo().timestamp = b16.b();
                    if (j3 < StickerTrackerManager.a(null)) {
                        if (b16.b() >= StickerTrackerManager.a(null)) {
                            StickerTrackerManager.a(null);
                            GYTrackSticker d17 = StickerTrackerManager.d(null);
                            if (d17 != null) {
                                d17.resetToAnchorFrame();
                            }
                            Log.i(StickerTrackerManager.e(null), "resetToAnchorFrame " + b16.b());
                            throw null;
                        }
                        throw null;
                    }
                    throw null;
                }
            }
        }
    }
}
