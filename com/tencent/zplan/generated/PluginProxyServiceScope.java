package com.tencent.zplan.generated;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import yx4.e;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/zplan/generated/PluginProxyServiceScope;", "", "()V", "PROXY_SERVICES", "", "Ljava/lang/Class;", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class PluginProxyServiceScope {

    @NotNull
    public static final PluginProxyServiceScope INSTANCE = new PluginProxyServiceScope();

    @JvmField
    @NotNull
    public static final Map<Class<?>, Class<?>> PROXY_SERVICES;

    static {
        HashMap hashMap = new HashMap();
        PROXY_SERVICES = hashMap;
        hashMap.put(d.class, e.class);
    }

    PluginProxyServiceScope() {
    }
}
