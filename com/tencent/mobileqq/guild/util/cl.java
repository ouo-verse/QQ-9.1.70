package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001f\u0012\u0016\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0011\u0010\u000e\u001a\u0004\u0018\u00018\u0001H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0014R$\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/util/cl;", "T", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/concurrent/Future;", "Lcom/tencent/mobileqq/guild/util/bl;", "value", "", "complete", "(Ljava/lang/Object;)V", "", "mayInterruptIfRunning", "cancel", "isCancelled", "isDone", "get", "()Ljava/lang/Object;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", "mapFunc", "Lcom/tencent/mobileqq/guild/util/ck;", "e", "Lcom/tencent/mobileqq/guild/util/ck;", "futureImpl", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class cl<T, R> implements Future<R>, bl<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<T, R> mapFunc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ck<R> futureImpl;

    /* JADX WARN: Multi-variable type inference failed */
    public cl(@NotNull Function1<? super T, ? extends R> mapFunc) {
        Intrinsics.checkNotNullParameter(mapFunc, "mapFunc");
        this.mapFunc = mapFunc;
        this.futureImpl = new ck<>();
    }

    @Override // java.util.concurrent.Future, com.tencent.mobileqq.guild.util.bl
    public boolean cancel(boolean mayInterruptIfRunning) {
        return this.futureImpl.cancel(mayInterruptIfRunning);
    }

    @Override // com.tencent.mobileqq.guild.util.bl
    public void complete(@Nullable T value) {
        this.futureImpl.complete(this.mapFunc.invoke(value));
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public R get() {
        return this.futureImpl.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.futureImpl.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.futureImpl.isDone();
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public R get(long timeout, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.futureImpl.get(timeout, unit);
    }
}
