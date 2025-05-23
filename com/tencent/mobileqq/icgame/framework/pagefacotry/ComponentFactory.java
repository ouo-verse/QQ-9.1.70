package com.tencent.mobileqq.icgame.framework.pagefacotry;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.framework.exception.QQLiveException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J-\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tRW\u0010\u0010\u001a>\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b0\nj\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b`\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentFactory;", "", "Lcom/tencent/mobileqq/icgame/framework/component/e;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Class;", "clazz", "Lf32/a;", "componentContext", "a", "(Ljava/lang/Class;Lf32/a;)Lcom/tencent/mobileqq/icgame/framework/component/e;", "Ljava/util/HashMap;", "Ljava/lang/reflect/Constructor;", "Lkotlin/collections/HashMap;", "b", "Lkotlin/Lazy;", "()Ljava/util/HashMap;", "componentClassMap", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ComponentFactory f237355a = new ComponentFactory();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy componentClassMap;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Class<? extends e>, Constructor<? extends e>>>() { // from class: com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentFactory$componentClassMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<Class<? extends e>, Constructor<? extends e>> invoke() {
                return new HashMap<>();
            }
        });
        componentClassMap = lazy;
    }

    ComponentFactory() {
    }

    private final HashMap<Class<? extends e>, Constructor<? extends e>> b() {
        return (HashMap) componentClassMap.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <C extends e> C a(@NotNull Class<C> clazz, @NotNull f32.a componentContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        try {
            Constructor<? extends e> constructor = b().get(clazz);
            if (constructor != null) {
                e newInstance = constructor.newInstance(componentContext);
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type C of com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentFactory.createComponent");
                return (C) newInstance;
            }
            Constructor<? extends e> constructor2 = clazz.getConstructor(f32.a.class);
            HashMap<Class<? extends e>, Constructor<? extends e>> b16 = b();
            Intrinsics.checkNotNullExpressionValue(constructor2, "constructor");
            b16.put(clazz, constructor2);
            e newInstance2 = constructor2.newInstance(componentContext);
            Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type C of com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentFactory.createComponent");
            return (C) newInstance2;
        } catch (NoSuchMethodException e16) {
            throw new QQLiveException("\u6ca1\u6709\u627e\u5230\u5bf9\u5e94\u7684\u6784\u9020\u65b9\u6cd5,\u8bf7\u68c0\u67e5" + clazz.getSimpleName() + "\u7684\u6784\u9020\u5668\u662f\u5426\u6b63\u786e", e16);
        }
    }
}
