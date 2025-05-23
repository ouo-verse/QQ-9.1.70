package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IGuildAudioChannelApi;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildAudioChannelApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildAudioChannelApi;", "()V", "getMediaChannelLoadBeanBundle", "Landroid/os/Bundle;", "registerAudioRoomQIPCModule", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildAudioChannelApiImpl implements IGuildAudioChannelApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildAudioChannelApi
    @Nullable
    public Bundle getMediaChannelLoadBeanBundle() {
        return com.tencent.mobileqq.guild.media.core.j.a().getLoadBeanBundle();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildAudioChannelApi
    public void registerAudioRoomQIPCModule() {
        com.tencent.mobileqq.guild.media.core.logic.trtc.w.b().register();
    }
}
