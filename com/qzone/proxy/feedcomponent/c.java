package com.qzone.proxy.feedcomponent;

import com.qzone.module.Proxy;
import com.qzone.module.feedcomponent.FeedcomponentModule;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends Proxy<i, h> {

    /* renamed from: a, reason: collision with root package name */
    public static final c f50143a = new c();

    @Override // com.qzone.module.Proxy
    public String getModuleClassName() {
        return "com.qzone.module.feedcomponent.FeedcomponentModule";
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    public h getServiceInterface() {
        return FeedcomponentModule.g().getServiceInterface();
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    public i getUiInterface() {
        return FeedcomponentModule.g().getUiInterface();
    }
}
