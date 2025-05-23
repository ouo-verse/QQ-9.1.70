package com.tencent.tavcut.core.operator;

import com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/tavcut/core/operator/a;", "Lcom/tencent/tavcut/core/operator/d;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "a", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "dataDispatcher", "<init>", "(Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RenderDataDispatcher dataDispatcher;

    public a(@NotNull RenderDataDispatcher dataDispatcher) {
        Intrinsics.checkParameterIsNotNull(dataDispatcher, "dataDispatcher");
        this.dataDispatcher = dataDispatcher;
    }
}
