package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildRuntimeApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildRuntimeApiImpl implements IGuildRuntimeApi {
    public static final String TAG = "GuildRuntimeApiImpl";

    private void handleAudioRoomAccountRelease() {
        if (com.tencent.mobileqq.guild.media.core.j.f()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.api.impl.v
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRuntimeApiImpl.lambda$handleAudioRoomAccountRelease$0();
                }
            });
        }
    }

    private void handleGuildInfoManagerRelease() {
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).releaseGuildInfoManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleAudioRoomAccountRelease$0() {
        com.tencent.mobileqq.guild.media.core.j.a().I();
        GuildFloatWindowUtils.o();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildRuntimeApi
    public void handleAccountRelease() {
        handleAudioRoomAccountRelease();
        handleGuildInfoManagerRelease();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildRuntimeApi
    public void handleAfterAccountLogin() {
        com.tencent.mobileqq.guild.media.core.data.b.d();
    }
}
