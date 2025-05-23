package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.map.geolocation.TencentLocation;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/guild/media/core/logic/AudioNotifyHelper$runOnUiThread$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class AudioNotifyHelper$notifyUIForSelfRoleTypeChange$$inlined$runOnUiThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f228145d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f228146e;
    final /* synthetic */ AudioNotifyHelper this$0;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.this$0.observers.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).d(this.f228145d, this.f228146e);
        }
    }
}
