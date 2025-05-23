package com.tencent.mobileqq.guild.feed.util.framework.emitter;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J#\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR@\u0010\u0010\u001a.\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\rj\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/emitter/c;", "Lml3/b;", "T", "Ljava/lang/Class;", "functionClazz", "Lml3/a;", "emitter", "", "c", "clazz", "a", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "pool", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class c implements ml3.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Class<?>, ml3.a<?>> pool = new HashMap<>(4);

    @Override // ml3.b
    @NotNull
    public <T> ml3.a<T> a(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object obj = this.pool.get(clazz);
        if (obj != null) {
            return (ml3.a) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.api.business.IEmitterRegister<T>");
    }

    @Override // ml3.b
    public <T> T b(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.pool.get(clazz);
    }

    public final <T> void c(@NotNull Class<T> functionClazz, @NotNull ml3.a<T> emitter) {
        Intrinsics.checkNotNullParameter(functionClazz, "functionClazz");
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        this.pool.put(functionClazz, emitter);
    }
}
