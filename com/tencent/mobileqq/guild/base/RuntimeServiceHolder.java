package com.tencent.mobileqq.guild.base;

import com.tencent.mobileqq.guild.base.extension.r;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ.\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\u0006\u0010\u000f\u001a\u00020\u000eR0\u0010\u0013\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R(\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "", "Lmqq/app/api/IRuntimeService;", "T", "Ljava/lang/Class;", "clazz", "d", "(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;", "", "tag", "b", "(Ljava/lang/String;Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;", "Lkotlin/Lazy;", "a", "", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/guild/base/f;", "Ljava/util/concurrent/ConcurrentHashMap;", "holders", "Lcom/tencent/mobileqq/guild/base/e;", "resettableHolders", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RuntimeServiceHolder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Class<? extends IRuntimeService>, f<? extends IRuntimeService>> holders = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Class<? extends IRuntimeService>, e> resettableHolders = new ConcurrentHashMap<>();

    @NotNull
    public final <T extends IRuntimeService> Lazy<T> a(@NotNull String tag, @NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return new RuntimeServiceHolder$_lazy$1(this, tag, clazz);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [mqq.app.api.IRuntimeService] */
    @NotNull
    public final <T extends IRuntimeService> T b(@NotNull final String tag, @NotNull final Class<T> clazz) {
        T t16;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        f<? extends IRuntimeService> fVar = this.holders.get(clazz);
        T t17 = null;
        if (fVar != null) {
            t16 = fVar.getValue();
        } else {
            t16 = null;
        }
        if (t16 instanceof IRuntimeService) {
            t17 = t16;
        }
        if (t17 == null) {
            this.holders.putIfAbsent(clazz, new f<T>(tag, clazz) { // from class: com.tencent.mobileqq.guild.base.RuntimeServiceHolder$_obtain$lambda$2$$inlined$newPlainServiceHolder$1

                /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final Lazy value;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f214699e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Class f214700f;

                {
                    Lazy lazy;
                    this.f214699e = tag;
                    this.f214700f = clazz;
                    lazy = LazyKt__LazyJVMKt.lazy(new Function0<T>() { // from class: com.tencent.mobileqq.guild.base.RuntimeServiceHolder$_obtain$lambda$2$$inlined$newPlainServiceHolder$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final T invoke() {
                            boolean z16;
                            if (tag.length() == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                return (T) r.b(r.f214743a, clazz, null, 2, null);
                            }
                            return (T) r.d(r.f214743a, clazz, tag, null, 4, null);
                        }
                    });
                    this.value = lazy;
                }

                @Override // com.tencent.mobileqq.guild.base.f
                public T getValue() {
                    return (T) this.value.getValue();
                }
            });
            f<? extends IRuntimeService> fVar2 = this.holders.get(clazz);
            Intrinsics.checkNotNull(fVar2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.base.ServiceHolder<T of com.tencent.mobileqq.guild.base.RuntimeServiceHolder._obtain$lambda$2>");
            return (T) fVar2.getValue();
        }
        return t17;
    }

    @NotNull
    public final <T extends IRuntimeService> T d(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) b("", clazz);
    }

    public final void e() {
        Iterator<Map.Entry<Class<? extends IRuntimeService>, e>> it = this.resettableHolders.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().reset();
        }
        this.holders.clear();
        this.resettableHolders.clear();
    }
}
