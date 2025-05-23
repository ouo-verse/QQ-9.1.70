package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.simpleui.NormalNightModeHandler;
import com.tencent.mobileqq.vas.theme.api.INormalNightModeHandler;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NormalNightModeHandlerImpl implements INormalNightModeHandler {
    @Override // com.tencent.mobileqq.vas.theme.api.INormalNightModeHandler
    public void reqGetNormalNightModeSwitch(BaseQQAppInterface baseQQAppInterface, String str) {
        ((NormalNightModeHandler) baseQQAppInterface.getBusinessHandler(NormalNightModeHandler.class.getName())).I2(str);
    }

    @Override // com.tencent.mobileqq.vas.theme.api.INormalNightModeHandler
    public void reqSetNormalNightModeSwitch(AppRuntime appRuntime, boolean z16) {
        if (appRuntime instanceof BaseQQAppInterface) {
            ((NormalNightModeHandler) ((BaseQQAppInterface) appRuntime).getBusinessHandler(NormalNightModeHandler.class.getName())).J2(z16);
        }
    }
}
