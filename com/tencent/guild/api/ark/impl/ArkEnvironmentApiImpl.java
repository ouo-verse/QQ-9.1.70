package com.tencent.guild.api.ark.impl;

import com.tencent.guild.api.ark.IArkEnvironmentApi;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/api/ark/impl/ArkEnvironmentApiImpl;", "Lcom/tencent/guild/api/ark/IArkEnvironmentApi;", "()V", "isJSCLibExist", "", "setScriptLeakCheckEnabled", "", NodeProps.ENABLED, "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ArkEnvironmentApiImpl implements IArkEnvironmentApi {
    @Override // com.tencent.guild.api.ark.IArkEnvironmentApi
    public boolean isJSCLibExist() {
        return ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isJSCLibExist();
    }

    @Override // com.tencent.guild.api.ark.IArkEnvironmentApi
    public void setScriptLeakCheckEnabled(boolean enabled) {
        ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).setScriptLeakCheckEnabled(enabled);
    }
}
