package com.tencent.rmonitor.looper;

import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rmonitor/looper/a;", "", "", "pluginName", "", "b", "Lcom/tencent/rmonitor/base/config/data/m;", "a", "<init>", "()V", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f365658a = new a();

    a() {
    }

    @Nullable
    public final m a(@NotNull String pluginName) {
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        try {
            return ConfigProxy.INSTANCE.getConfig().k(pluginName);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final boolean b(@NotNull String pluginName) {
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        return PluginController.f365404b.b(pluginName);
    }
}
