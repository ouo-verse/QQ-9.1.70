package com.tencent.tavcut.core.render.builder;

import androidx.fragment.app.a;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavkit.composition.TAVComposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/MediaBuilderOutput;", "", "renderChainManager", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "renderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "durationUs", "", "(Lcom/tencent/tavcut/core/render/IRenderChainManager;Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;Lcom/tencent/tavkit/composition/TAVComposition;J)V", "getComposition", "()Lcom/tencent/tavkit/composition/TAVComposition;", "getDurationUs", "()J", "getRenderChainManager", "()Lcom/tencent/tavcut/core/render/IRenderChainManager;", "getRenderModel", "()Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class MediaBuilderOutput {

    @NotNull
    private final TAVComposition composition;
    private final long durationUs;

    @NotNull
    private final IRenderChainManager renderChainManager;

    @NotNull
    private final LAKRenderModel renderModel;

    public MediaBuilderOutput(@NotNull IRenderChainManager renderChainManager, @NotNull LAKRenderModel renderModel, @NotNull TAVComposition composition, long j3) {
        Intrinsics.checkParameterIsNotNull(renderChainManager, "renderChainManager");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(composition, "composition");
        this.renderChainManager = renderChainManager;
        this.renderModel = renderModel;
        this.composition = composition;
        this.durationUs = j3;
    }

    public static /* synthetic */ MediaBuilderOutput copy$default(MediaBuilderOutput mediaBuilderOutput, IRenderChainManager iRenderChainManager, LAKRenderModel lAKRenderModel, TAVComposition tAVComposition, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            iRenderChainManager = mediaBuilderOutput.renderChainManager;
        }
        if ((i3 & 2) != 0) {
            lAKRenderModel = mediaBuilderOutput.renderModel;
        }
        LAKRenderModel lAKRenderModel2 = lAKRenderModel;
        if ((i3 & 4) != 0) {
            tAVComposition = mediaBuilderOutput.composition;
        }
        TAVComposition tAVComposition2 = tAVComposition;
        if ((i3 & 8) != 0) {
            j3 = mediaBuilderOutput.durationUs;
        }
        return mediaBuilderOutput.copy(iRenderChainManager, lAKRenderModel2, tAVComposition2, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final IRenderChainManager getRenderChainManager() {
        return this.renderChainManager;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final LAKRenderModel getRenderModel() {
        return this.renderModel;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final TAVComposition getComposition() {
        return this.composition;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    @NotNull
    public final MediaBuilderOutput copy(@NotNull IRenderChainManager renderChainManager, @NotNull LAKRenderModel renderModel, @NotNull TAVComposition composition, long durationUs) {
        Intrinsics.checkParameterIsNotNull(renderChainManager, "renderChainManager");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(composition, "composition");
        return new MediaBuilderOutput(renderChainManager, renderModel, composition, durationUs);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MediaBuilderOutput) {
                MediaBuilderOutput mediaBuilderOutput = (MediaBuilderOutput) other;
                if (!Intrinsics.areEqual(this.renderChainManager, mediaBuilderOutput.renderChainManager) || !Intrinsics.areEqual(this.renderModel, mediaBuilderOutput.renderModel) || !Intrinsics.areEqual(this.composition, mediaBuilderOutput.composition) || this.durationUs != mediaBuilderOutput.durationUs) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final TAVComposition getComposition() {
        return this.composition;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    @NotNull
    public final IRenderChainManager getRenderChainManager() {
        return this.renderChainManager;
    }

    @NotNull
    public final LAKRenderModel getRenderModel() {
        return this.renderModel;
    }

    public int hashCode() {
        int i3;
        int i16;
        IRenderChainManager iRenderChainManager = this.renderChainManager;
        int i17 = 0;
        if (iRenderChainManager != null) {
            i3 = iRenderChainManager.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        LAKRenderModel lAKRenderModel = this.renderModel;
        if (lAKRenderModel != null) {
            i16 = lAKRenderModel.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        TAVComposition tAVComposition = this.composition;
        if (tAVComposition != null) {
            i17 = tAVComposition.hashCode();
        }
        return ((i19 + i17) * 31) + a.a(this.durationUs);
    }

    @NotNull
    public String toString() {
        return "MediaBuilderOutput(renderChainManager=" + this.renderChainManager + ", renderModel=" + this.renderModel + ", composition=" + this.composition + ", durationUs=" + this.durationUs + ")";
    }
}
