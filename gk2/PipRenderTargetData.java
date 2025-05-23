package gk2;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lgk2/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "a", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "c", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "renderTargetEntity", "b", "imageEntity", "", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "Ljava/util/List;", "()Ljava/util/List;", "inputSource", "<init>", "(Lcom/tencent/tavcut/rendermodel/entity/Entity;Lcom/tencent/tavcut/rendermodel/entity/Entity;Ljava/util/List;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gk2.g, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class PipRenderTargetData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Entity renderTargetEntity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Entity imageEntity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<InputSource> inputSource;

    public PipRenderTargetData(@NotNull Entity renderTargetEntity, @NotNull Entity imageEntity, @NotNull List<InputSource> inputSource) {
        Intrinsics.checkNotNullParameter(renderTargetEntity, "renderTargetEntity");
        Intrinsics.checkNotNullParameter(imageEntity, "imageEntity");
        Intrinsics.checkNotNullParameter(inputSource, "inputSource");
        this.renderTargetEntity = renderTargetEntity;
        this.imageEntity = imageEntity;
        this.inputSource = inputSource;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Entity getImageEntity() {
        return this.imageEntity;
    }

    @NotNull
    public final List<InputSource> b() {
        return this.inputSource;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Entity getRenderTargetEntity() {
        return this.renderTargetEntity;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PipRenderTargetData)) {
            return false;
        }
        PipRenderTargetData pipRenderTargetData = (PipRenderTargetData) other;
        if (Intrinsics.areEqual(this.renderTargetEntity, pipRenderTargetData.renderTargetEntity) && Intrinsics.areEqual(this.imageEntity, pipRenderTargetData.imageEntity) && Intrinsics.areEqual(this.inputSource, pipRenderTargetData.inputSource)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.renderTargetEntity.hashCode() * 31) + this.imageEntity.hashCode()) * 31) + this.inputSource.hashCode();
    }

    @NotNull
    public String toString() {
        return "PipRenderTargetData(renderTargetEntity=" + this.renderTargetEntity + ", imageEntity=" + this.imageEntity + ", inputSource=" + this.inputSource + ")";
    }
}
