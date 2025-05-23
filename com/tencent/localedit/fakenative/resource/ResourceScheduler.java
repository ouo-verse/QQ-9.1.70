package com.tencent.localedit.fakenative.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/localedit/fakenative/resource/ResourceScheduler;", "Lcom/tencent/localedit/fakenative/resource/b;", "Lcom/tencent/localedit/fakenative/resource/c;", "task", "", "c", "", "d", "(Lcom/tencent/localedit/fakenative/resource/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "e", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/tencent/localedit/fakenative/resource/TaskLooper;", "Lcom/tencent/localedit/fakenative/resource/TaskLooper;", "loop", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class ResourceScheduler extends b<c> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineDispatcher dispatcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TaskLooper loop;

    public ResourceScheduler(@NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.loop = new TaskLooper(dispatcher);
    }

    private final void c(c task) {
        x11.b.f446855a.d("ResourceScheduler", Intrinsics.stringPlus("dispatch in: ", Thread.currentThread()));
        this.loop.d(new ResourceScheduler$dispatch$1(task, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(c cVar, Continuation<Object> continuation) {
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ResourceScheduler$execTask$2(this, cVar, CompletableDeferred$default, null), 3, null);
        return CompletableDeferred$default.await(continuation);
    }

    public void b(@NotNull c task) {
        Intrinsics.checkNotNullParameter(task, "task");
        c(task);
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public /* synthetic */ ResourceScheduler(CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
