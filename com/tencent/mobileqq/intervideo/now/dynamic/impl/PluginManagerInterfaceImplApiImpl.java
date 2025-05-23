package com.tencent.mobileqq.intervideo.now.dynamic.impl;

import com.tencent.mobileqq.intervideo.now.dynamic.IPluginManagerInterfaceImplApi;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl;
import com.tencent.mobileqq.intervideo.now.dynamic.c;

/* loaded from: classes33.dex */
public class PluginManagerInterfaceImplApiImpl implements IPluginManagerInterfaceImplApi {
    @Override // com.tencent.mobileqq.intervideo.now.dynamic.IPluginManagerInterfaceImplApi
    public c getInstance() {
        return PluginManagerInterfaceImpl.i();
    }
}
