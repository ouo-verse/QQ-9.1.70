package com.tencent.kuikly.core.render.android.scheduler;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u0005\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00020\u0004j\u0002`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/c;", "", "", "a", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "Lkotlin/jvm/functions/Function0;", "task", "", "b", "Z", "()Z", "isUpdateViewTree", "<init>", "(Lkotlin/jvm/functions/Function0;Z)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> task;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isUpdateViewTree;

    public c(@NotNull Function0<Unit> task, boolean z16) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.task = task;
        this.isUpdateViewTree = z16;
    }

    public final void a() {
        this.task.invoke();
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsUpdateViewTree() {
        return this.isUpdateViewTree;
    }
}
