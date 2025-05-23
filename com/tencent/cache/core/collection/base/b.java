package com.tencent.cache.core.collection.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface b extends com.tencent.cache.api.b {
    public static final IPatchRedirector $redirector_ = null;

    @JvmDefault
    @NotNull
    d getCacheInfo();

    @NotNull
    c getCollector();

    int getCount();

    @Nullable
    String getItemType();

    @JvmDefault
    @NotNull
    com.tencent.cache.core.manager.report.b getMonitorInfo();
}
