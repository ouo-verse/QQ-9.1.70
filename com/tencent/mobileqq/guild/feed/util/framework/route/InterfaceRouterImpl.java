package com.tencent.mobileqq.guild.feed.util.framework.route;

import androidx.collection.ArrayMap;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J+\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR+\u0010\u0011\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/route/InterfaceRouterImpl;", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "T", "Ljava/lang/Class;", "apiClass", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "clazz", DTConstants.TAG.API, "", "a", "(Ljava/lang/Class;Ljava/lang/Object;)V", "Landroidx/collection/ArrayMap;", "", "Lkotlin/Lazy;", "c", "()Landroidx/collection/ArrayMap;", "apiMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InterfaceRouterImpl implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy apiMap;

    public InterfaceRouterImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ArrayMap<Class<?>, Object>>() { // from class: com.tencent.mobileqq.guild.feed.util.framework.route.InterfaceRouterImpl$apiMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayMap<Class<?>, Object> invoke() {
                return new ArrayMap<>();
            }
        });
        this.apiMap = lazy;
    }

    private final ArrayMap<Class<?>, Object> c() {
        return (ArrayMap) this.apiMap.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.util.framework.route.a
    public <T> void a(@NotNull Class<T> clazz, T api) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!c().containsKey(clazz)) {
            c().put(clazz, api);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.util.framework.route.a
    @Nullable
    public <T> T b(@NotNull Class<T> apiClass) {
        Intrinsics.checkNotNullParameter(apiClass, "apiClass");
        T t16 = (T) c().get(apiClass);
        if (t16 == null) {
            return null;
        }
        return t16;
    }
}
