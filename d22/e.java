package d22;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a$\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0001\u00a8\u0006\u0006"}, d2 = {"", "Ljava/lang/Class;", "clazz", "targetClazz", "", "a", "ic-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {
    public static final boolean a(@NotNull Object obj, @Nullable Class<?> cls, @NotNull Class<?> targetClazz) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(targetClazz, "targetClazz");
        if (cls != null && !Intrinsics.areEqual(cls, SimpleBaseEvent.class)) {
            if (Intrinsics.areEqual(cls, targetClazz)) {
                return true;
            }
            return a(obj, cls.getSuperclass(), targetClazz);
        }
        return false;
    }
}
