package com.tencent.qne.delegate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qne/delegate/d;", "", "", "resourceId", "", "specificTaskId", "Lcom/tencent/qne/delegate/e;", "a", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class a {
        public static /* synthetic */ Object a(d dVar, String str, Long l3, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    l3 = null;
                }
                return dVar.a(str, l3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadResource");
        }
    }

    @Nullable
    Object a(@NotNull String str, @Nullable Long l3, @NotNull Continuation<? super e> continuation);
}
