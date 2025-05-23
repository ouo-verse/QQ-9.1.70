package com.tencent.tavcut.render.audio.extractor;

import com.tencent.map.geolocation.TencentLocation;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes26.dex */
final class TavAudioExtractor$extractAudioFromClipSources$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f374348d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ List f374349e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f374350f;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public final void run() {
        b b16 = c.b(null);
        if (b16 != null) {
            b16.onExtractStart();
        }
        c.c(null, c.a(null, this.f374348d, this.f374349e), this.f374350f);
    }
}
