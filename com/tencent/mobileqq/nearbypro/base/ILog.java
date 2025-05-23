package com.tencent.mobileqq.nearbypro.base;

import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\b\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/ILog;", "", "", "isColorLevel", "", "tag", "Lcom/tencent/mobileqq/nearbypro/base/ILog$Level;", "level", "message", "", "b", "", "e", "a", "Level", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface ILog {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/ILog$Level;", "", "(Ljava/lang/String;I)V", "DEBUG", "INFO", "WARN", RLog.ERROR, "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public enum Level {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    @Nullable
    String a(@NotNull Throwable e16);

    void b(@NotNull String tag, @NotNull Level level, @Nullable String message);

    boolean isColorLevel();
}
