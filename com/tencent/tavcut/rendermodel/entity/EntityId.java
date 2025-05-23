package com.tencent.tavcut.rendermodel.entity;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/tavcut/rendermodel/entity/EntityId;", "", "id", "", "name", "", NodeProps.ENABLED, "", "(ILjava/lang/String;Z)V", "getEnabled", "()Z", "getId", "()I", "getName", "()Ljava/lang/String;", "lib_tavcut_model_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class EntityId {
    private final boolean enabled;
    private final int id;

    @NotNull
    private final String name;

    public EntityId(int i3, @NotNull String name, boolean z16) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.id = i3;
        this.name = name;
        this.enabled = z16;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
