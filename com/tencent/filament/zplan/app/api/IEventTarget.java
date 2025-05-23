package com.tencent.filament.zplan.app.api;

import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk0.b;
import tk0.a;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/filament/zplan/app/api/IEventTarget;", "", "", "type", "Lsk0/b;", "listener", "", "addEventListener", "removeEventListener", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "data", "dispatchEvent", "Ltk0/a;", "action", "register", "unregister", "Ltk0/b;", "event", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface IEventTarget {
    void addEventListener(@NotNull String type, @NotNull b listener);

    void dispatchEvent(@Nullable c spanContext, @NotNull String type, @Nullable String data);

    void dispatchEvent(@NotNull tk0.b event);

    void register(@NotNull String type, @NotNull a action);

    void removeEventListener(@NotNull String type);

    void removeEventListener(@NotNull String type, @NotNull b listener);

    void unregister(@NotNull String type, @NotNull a action);
}
