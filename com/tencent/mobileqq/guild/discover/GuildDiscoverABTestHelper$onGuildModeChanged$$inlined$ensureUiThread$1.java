package com.tencent.mobileqq.guild.discover;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.openentrance.eventbus.GuildFrameUpdateEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/guild/util/ThreadUtils$ensureUiThread$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildDiscoverABTestHelper$onGuildModeChanged$$inlined$ensureUiThread$1 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFrameUpdateEvent());
    }
}
