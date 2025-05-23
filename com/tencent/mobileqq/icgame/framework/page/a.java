package com.tencent.mobileqq.icgame.framework.page;

import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.framework.component.h;
import com.tencent.mobileqq.icgame.framework.pagefacotry.ComponentNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/a;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/h;", "componentClazz", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "parentComponentClazz", "", "parentKey", "Lcom/tencent/mobileqq/icgame/framework/pagefacotry/ComponentNode;", "b", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.icgame.framework.page.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C7924a {
        public static /* synthetic */ ComponentNode a(a aVar, Class cls, Class cls2, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str = cls2.getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(str, "parentComponentClazz.simpleName");
                }
                return aVar.b(cls, cls2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerSingleComponent");
        }
    }

    @Nullable
    ComponentNode b(@NotNull Class<? extends h> componentClazz, @NotNull Class<? extends e> parentComponentClazz, @NotNull String parentKey);
}
