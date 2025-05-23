package com.tencent.qqmini.minigame.dynamic;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0011JN\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/minigame/dynamic/IDynamicEntry;", "", "delegate", "Lcom/tencent/qqmini/minigame/dynamic/IDynamicEntry$Delegate;", "getDelegate", "()Lcom/tencent/qqmini/minigame/dynamic/IDynamicEntry$Delegate;", "setDelegate", "(Lcom/tencent/qqmini/minigame/dynamic/IDynamicEntry$Delegate;)V", "callServerMethod", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "Delegate", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public interface IDynamicEntry {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqmini/minigame/dynamic/IDynamicEntry$Delegate;", "", "callClient", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public interface Delegate {
        @Nullable
        Object callClient(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5);
    }

    @Nullable
    Object callServerMethod(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5);

    @Nullable
    Delegate getDelegate();

    void setDelegate(@Nullable Delegate delegate);
}
