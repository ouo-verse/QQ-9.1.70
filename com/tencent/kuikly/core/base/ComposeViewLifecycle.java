package com.tencent.kuikly.core.base;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R,\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/base/ComposeViewLifecycle;", "", "Lcom/tencent/kuikly/core/base/ComposeViewLifecycle$Stage;", "stage", "", "a", "", "", "Lkotlin/Function0;", "Ljava/util/Map;", "map", "<init>", "()V", "Stage", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ComposeViewLifecycle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Stage, Set<Function0<Unit>>> map = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/base/ComposeViewLifecycle$Stage;", "", "(Ljava/lang/String;I)V", DebugCoroutineInfoImplKt.CREATED, "VIEW_WILL_LOAD", "VIEW_DID_LOAD", "VIEW_DID_LAYOUT", "VIEW_WILL_UNLOAD", "VIEW_DID_UNLOAD", "VIEW_DESTROYED", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public enum Stage {
        CREATED,
        VIEW_WILL_LOAD,
        VIEW_DID_LOAD,
        VIEW_DID_LAYOUT,
        VIEW_WILL_UNLOAD,
        VIEW_DID_UNLOAD,
        VIEW_DESTROYED
    }

    public final void a(Stage stage) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        Set<Function0<Unit>> set = this.map.get(stage);
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }
    }
}
