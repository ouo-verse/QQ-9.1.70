package com.tencent.filament.zplanservice.util.log;

import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/filament/zplanservice/util/log/ILogDelegate;", "", "Lcom/tencent/filament/zplanservice/util/log/ILogDelegate$Level;", "level", "", "tag", "msg", "", "throwable", "", "a", "Level", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface ILogDelegate {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplanservice/util/log/ILogDelegate$Level;", "", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", RLog.ERROR, "zplan-service_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public enum Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    void a(@NotNull Level level, @NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable);
}
