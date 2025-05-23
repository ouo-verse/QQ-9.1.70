package g32;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lg32/l;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "key", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "Ljava/lang/Class;", "()Ljava/lang/Class;", "componentClazz", "<init>", "(Ljava/lang/String;Ljava/lang/Class;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends com.tencent.mobileqq.icgame.framework.component.e> componentClazz;

    public l(@NotNull String key, @NotNull Class<? extends com.tencent.mobileqq.icgame.framework.component.e> componentClazz) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(componentClazz, "componentClazz");
        this.key = key;
        this.componentClazz = componentClazz;
    }

    @NotNull
    public final Class<? extends com.tencent.mobileqq.icgame.framework.component.e> a() {
        return this.componentClazz;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getKey() {
        return this.key;
    }
}
