package com.tencent.mobileqq.icgame.framework.connector;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004H\u0016R\u001a\u0010\u000b\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/connector/a;", "Lcom/tencent/mobileqq/icgame/framework/connector/b;", "", "a", "", "Li32/a;", "c", "Lf32/b;", "Lf32/b;", "b", "()Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f32.b connectorContext;

    public a(@NotNull f32.b connectorContext) {
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
        this.connectorContext = connectorContext;
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.b
    @NotNull
    /* renamed from: b, reason: from getter */
    public f32.b getConnectorContext() {
        return this.connectorContext;
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.b
    @Nullable
    public List<i32.a<?>> c() {
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.b
    public void a() {
    }
}
