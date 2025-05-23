package com.tencent.localedit.fakenative.resource;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \b2\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00020\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J0\u0010\b\u001a\u00020\u00042\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/localedit/fakenative/resource/TaskLooper;", "Lcom/tencent/localedit/fakenative/resource/d;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "c", "task", "d", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "", "Z", "stop", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class TaskLooper extends d<Function1<? super Continuation<? super Unit>, ? extends Object>> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineDispatcher dispatcher;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean stop;

    public TaskLooper(@NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        x11.b.f446855a.d("TaskLooper", Intrinsics.stringPlus("loop in: ", Thread.currentThread()));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), this.dispatcher, null, new TaskLooper$loop$1(this, null), 2, null);
    }

    public synchronized void d(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.stop = false;
        a().offer(task);
        c();
    }
}
