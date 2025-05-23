package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "", "id", "a", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "c", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "b", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "e", "()Lcom/tencent/tavcut/composition/model/component/InputSource;", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "<init>", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Lcom/tencent/tavcut/composition/model/component/InputSource;Ljava/lang/String;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.q, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class RenderData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Entity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final InputSource inputSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    public RenderData(@NotNull Entity entity, @NotNull InputSource inputSource, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(inputSource, "inputSource");
        Intrinsics.checkNotNullParameter(id5, "id");
        this.entity = entity;
        this.inputSource = inputSource;
        this.id = id5;
    }

    public static /* synthetic */ RenderData b(RenderData renderData, Entity entity, InputSource inputSource, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            entity = renderData.entity;
        }
        if ((i3 & 2) != 0) {
            inputSource = renderData.inputSource;
        }
        if ((i3 & 4) != 0) {
            str = renderData.id;
        }
        return renderData.a(entity, inputSource, str);
    }

    @NotNull
    public final RenderData a(@NotNull Entity entity, @NotNull InputSource inputSource, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(inputSource, "inputSource");
        Intrinsics.checkNotNullParameter(id5, "id");
        return new RenderData(entity, inputSource, id5);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Entity getEntity() {
        return this.entity;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final InputSource getInputSource() {
        return this.inputSource;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenderData)) {
            return false;
        }
        RenderData renderData = (RenderData) other;
        if (Intrinsics.areEqual(this.entity, renderData.entity) && Intrinsics.areEqual(this.inputSource, renderData.inputSource) && Intrinsics.areEqual(this.id, renderData.id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.entity.hashCode() * 31) + this.inputSource.hashCode()) * 31) + this.id.hashCode();
    }

    @NotNull
    public String toString() {
        return "RenderData(entity=" + this.entity + ", inputSource=" + this.inputSource + ", id=" + this.id + ")";
    }

    public /* synthetic */ RenderData(Entity entity, InputSource inputSource, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(entity, inputSource, (i3 & 4) != 0 ? "" : str);
    }
}
