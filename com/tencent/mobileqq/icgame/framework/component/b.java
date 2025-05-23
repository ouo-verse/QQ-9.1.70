package com.tencent.mobileqq.icgame.framework.component;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/component/b;", "Lcom/tencent/mobileqq/icgame/framework/component/h;", "", "getKey", "Lf32/a;", "d", "Lf32/a;", "e", "()Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class b implements h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f32.a componentContext;

    public b(@NotNull f32.a componentContext) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        this.componentContext = componentContext;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    @NotNull
    /* renamed from: e, reason: from getter */
    public f32.a getComponentContext() {
        return this.componentContext;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    @NotNull
    public String getKey() {
        return getComponentContext().getKey();
    }
}
