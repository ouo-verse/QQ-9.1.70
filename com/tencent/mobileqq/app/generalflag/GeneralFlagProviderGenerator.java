package com.tencent.mobileqq.app.generalflag;

import java.util.List;

/* loaded from: classes11.dex */
public interface GeneralFlagProviderGenerator extends com.tencent.imcore.message.basic.a<IGeneralFlagProvider> {
    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ List<IGeneralFlagProvider> getInstances();

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ void register(Class<? extends IGeneralFlagProvider> cls);

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ void unregister(Class<? extends IGeneralFlagProvider> cls);

    @Override // com.tencent.imcore.message.basic.a
    /* synthetic */ List<Class<? extends IGeneralFlagProvider>> values();
}
