package com.tencent.mobileqq.ark.share.api.impl;

import com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService;
import mqq.app.AppRuntime;
import p91.a;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAsyncShareMsgServiceImpl implements IArkAsyncShareMsgService {
    a asyncShareMsgManager;
    o91.a messagePreprocessorMgr;

    @Override // com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService
    public a getAsyncShareMsgManager() {
        return this.asyncShareMsgManager;
    }

    @Override // com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService
    public o91.a getMessagePreprocessorMgr() {
        return this.messagePreprocessorMgr;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.messagePreprocessorMgr = new o91.a();
        this.asyncShareMsgManager = new a(appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
