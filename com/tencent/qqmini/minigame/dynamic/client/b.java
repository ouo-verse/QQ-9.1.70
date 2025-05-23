package com.tencent.qqmini.minigame.dynamic.client;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JI\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0016JI\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqmini/minigame/dynamic/client/b;", "", "", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/qqmini/minigame/dynamic/client/ClientCallback;", "callback", "call", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public interface b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class a {
        @Nullable
        public static Object a(b bVar, @NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            if (obj != null && !(obj instanceof String)) {
                return null;
            }
            if (!(obj instanceof String)) {
                obj = null;
            }
            return bVar.call(method, (String) obj, function1);
        }

        @Nullable
        public static Object b(b bVar, @NotNull String method, @Nullable String str, @Nullable Function1<Object, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            return null;
        }
    }

    @Nullable
    Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback);

    @Nullable
    Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback);
}
