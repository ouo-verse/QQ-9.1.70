package com.tencent.tavcut.core.render.rendernode;

import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.report.IReportable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "Lcom/tencent/tavkit/report/IReportable;", "()V", "effectId", "", "getEffectId", "()Ljava/lang/String;", "nodeIndex", "", "getNodeIndex", "()I", "setNodeIndex", "(I)V", "createFilter", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode$Filter;", "release", "", "Companion", "Filter", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public abstract class BaseEffectNode implements IReportable {
    public static final int DEFAULT_NODE_INDEX = -1;
    private int nodeIndex = -1;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode$Filter;", "", "apply", "", "imageParams", "Lcom/tencent/tavcut/core/render/rendernode/ImageParams;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "isNeedApply", "", "release", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public interface Filter {
        void apply(@NotNull ImageParams imageParams, @NotNull RenderInfo renderInfo);

        boolean isNeedApply(@Nullable RenderInfo renderInfo);

        void release();
    }

    @NotNull
    public abstract Filter createFilter();

    @NotNull
    public final String getEffectId() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

    public final int getNodeIndex() {
        return this.nodeIndex;
    }

    public final void setNodeIndex(int i3) {
        this.nodeIndex = i3;
    }

    public void release() {
    }
}
