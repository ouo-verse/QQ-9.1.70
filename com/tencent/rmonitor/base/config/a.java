package com.tencent.rmonitor.base.config;

import com.tencent.rmonitor.base.config.data.ConfigCreatorProxy;
import com.tencent.rmonitor.base.config.data.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static m a(String str) {
        m createPluginConfig = ConfigCreatorProxy.d().createPluginConfig(str);
        if (createPluginConfig == null) {
            return new m(str);
        }
        return createPluginConfig;
    }
}
