package com.tencent.crossengine.log;

import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/crossengine/log/LogDelegate;", "", "Level", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes32.dex */
public interface LogDelegate {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/crossengine/log/LogDelegate$Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", RLog.ERROR, "library_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes32.dex */
    public enum Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }
}
