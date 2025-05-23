package com.tencent.mobileqq.wxmini.api.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.wxmini.api.IWxRuntimeApi;
import com.tencent.mobileqq.wxmini.wxacontainer.WxAppInterface;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wxmini/api/impl/WxRuntimeApiImpl;", "Lcom/tencent/mobileqq/wxmini/api/IWxRuntimeApi;", "()V", "createAppInterface", "Lmqq/app/AppRuntime;", "app", "Lmqq/app/MobileQQ;", "procName", "", "getWxaIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class WxRuntimeApiImpl implements IWxRuntimeApi {
    @Override // com.tencent.mobileqq.wxmini.api.IWxRuntimeApi
    public AppRuntime createAppInterface(MobileQQ app, String procName) {
        return new WxAppInterface(app, procName);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxRuntimeApi
    public QIPCModule getWxaIPCModule() {
        return mb3.a.f416521d;
    }
}
