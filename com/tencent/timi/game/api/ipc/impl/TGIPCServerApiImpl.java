package com.tencent.timi.game.api.ipc.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.timi.game.api.ipc.ITGIPCServerApi;
import com.tencent.timi.game.expand.hall.impl.ipc.HallServerIpcModule;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveServerQIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/api/ipc/impl/TGIPCServerApiImpl;", "Lcom/tencent/timi/game/api/ipc/ITGIPCServerApi;", "()V", "getHallServerIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getLiveServerIPCModule", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class TGIPCServerApiImpl implements ITGIPCServerApi {
    @Override // com.tencent.timi.game.api.ipc.ITGIPCServerApi
    @NotNull
    public QIPCModule getHallServerIPCModule() {
        return HallServerIpcModule.INSTANCE.b();
    }

    @Override // com.tencent.timi.game.api.ipc.ITGIPCServerApi
    @NotNull
    public QIPCModule getLiveServerIPCModule() {
        return TGLiveServerQIPCModule.INSTANCE.b();
    }
}
