package com.tencent.state.square;

import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquareMiniAioServiceProvider;
import com.tencent.state.square.api.ISquarePttMessageService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/DefaultSquareMiniAioServiceProvider;", "Lcom/tencent/state/square/api/ISquareMiniAioServiceProvider;", "()V", "createPttMessageService", "Lcom/tencent/state/square/api/ISquarePttMessageService;", "createService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public class DefaultSquareMiniAioServiceProvider implements ISquareMiniAioServiceProvider {
    @Override // com.tencent.state.square.api.ISquareMiniAioServiceProvider
    @NotNull
    public ISquarePttMessageService createPttMessageService() {
        return new DefaultSquarePttMessageService();
    }

    @Override // com.tencent.state.square.api.ISquareMiniAioServiceProvider
    @NotNull
    public ISquareBaseMessageService createService() {
        return new DefaultSquareBaseAioService();
    }
}
