package m32;

import com.tencent.mobileqq.icgame.framework.component.e;
import g32.k;
import g32.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u000e"}, d2 = {"Lm32/c;", "Lg32/k;", "Lg32/l;", "c", "Lg32/l;", "()Lg32/l;", "requestComponentTag", "", "key", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "componentClazz", "<init>", "(Ljava/lang/String;Ljava/lang/Class;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends k {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l requestComponentTag;

    public c(@NotNull String key, @NotNull Class<e> componentClazz) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(componentClazz, "componentClazz");
        this.requestComponentTag = new l(key, componentClazz);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final l getRequestComponentTag() {
        return this.requestComponentTag;
    }
}
