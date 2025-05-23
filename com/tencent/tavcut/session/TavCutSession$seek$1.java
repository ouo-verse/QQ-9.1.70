package com.tencent.tavcut.session;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.tavcut.render.player.IPlayer;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes26.dex */
final class TavCutSession$seek$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f374463d;
    final /* synthetic */ TavCutSession this$0;

    @Override // java.lang.Runnable
    public final void run() {
        IPlayer iPlayer;
        iPlayer = this.this$0.player;
        if (iPlayer != null) {
            iPlayer.seek(this.f374463d);
        }
    }
}
