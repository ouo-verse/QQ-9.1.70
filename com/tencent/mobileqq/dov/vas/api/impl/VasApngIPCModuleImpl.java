package com.tencent.mobileqq.dov.vas.api.impl;

import com.tencent.mobileqq.dov.vas.api.IVasApngIPCModule;
import com.tencent.mobileqq.vas.an;

/* loaded from: classes10.dex */
public class VasApngIPCModuleImpl implements IVasApngIPCModule {
    @Override // com.tencent.mobileqq.dov.vas.api.IVasApngIPCModule
    public void download() {
        an.h().download();
    }

    @Override // com.tencent.mobileqq.dov.vas.api.IVasApngIPCModule
    public boolean loadSoLib() {
        return an.h().loadSoLib();
    }
}
