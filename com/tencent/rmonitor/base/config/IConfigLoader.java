package com.tencent.rmonitor.base.config;

import com.tencent.rmonitor.base.config.data.l;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IConfigLoader {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public enum LoadReason {
        LAUNCH,
        CONFIG_CHANGE,
        APPLY_PARAM_CHANGE
    }

    void a(@NotNull l lVar, LoadReason loadReason);
}
