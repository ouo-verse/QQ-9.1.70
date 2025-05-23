package com.tencent.mobileqq.vas.message;

import com.tencent.mobileqq.vas.message.ptt.j;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquareMiniAioServiceProvider;
import com.tencent.state.square.api.ISquarePttMessageService;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/message/d;", "Lcom/tencent/state/square/api/ISquareMiniAioServiceProvider;", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "createService", "Lcom/tencent/state/square/api/ISquarePttMessageService;", "createPttMessageService", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d implements ISquareMiniAioServiceProvider {
    @Override // com.tencent.state.square.api.ISquareMiniAioServiceProvider
    public ISquarePttMessageService createPttMessageService() {
        return new j();
    }

    @Override // com.tencent.state.square.api.ISquareMiniAioServiceProvider
    public ISquareBaseMessageService createService() {
        return new SquareAioService();
    }
}
