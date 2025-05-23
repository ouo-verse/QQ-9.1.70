package com.tencent.icgame.api.ipc.impl;

import com.tencent.icgame.api.ipc.ITGIPCServerApi;
import com.tencent.icgame.game.liveroom.impl.ipc.TGLiveServerQIPCModule;
import com.tencent.mobileqq.qipc.QIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/icgame/api/ipc/impl/TGIPCServerApiImpl;", "Lcom/tencent/icgame/api/ipc/ITGIPCServerApi;", "()V", "getLiveServerIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class TGIPCServerApiImpl implements ITGIPCServerApi {
    @Override // com.tencent.icgame.api.ipc.ITGIPCServerApi
    @NotNull
    public QIPCModule getLiveServerIPCModule() {
        return TGLiveServerQIPCModule.INSTANCE.a();
    }
}
