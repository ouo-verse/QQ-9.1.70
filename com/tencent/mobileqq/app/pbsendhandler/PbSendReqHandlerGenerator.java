package com.tencent.mobileqq.app.pbsendhandler;

import java.util.List;

/* loaded from: classes11.dex */
public interface PbSendReqHandlerGenerator extends com.tencent.imcore.message.basic.a<IPbSendReqHandler> {
    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ List<IPbSendReqHandler> getInstances();

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ void register(Class<? extends IPbSendReqHandler> cls);

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ void unregister(Class<? extends IPbSendReqHandler> cls);

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ List<Class<? extends IPbSendReqHandler>> values();
}
