package ae4;

import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavkit.composition.TAVComposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lae4/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lzd4/b;", "a", "Lzd4/b;", "c", "()Lzd4/b;", "renderChainManager", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "b", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "d", "()Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "Lcom/tencent/tavkit/composition/TAVComposition;", "Lcom/tencent/tavkit/composition/TAVComposition;", "()Lcom/tencent/tavkit/composition/TAVComposition;", "composition", "", "J", "()J", "durationUs", "<init>", "(Lzd4/b;Lcom/tencent/tavcut/rendermodel/RenderModel;Lcom/tencent/tavkit/composition/TAVComposition;J)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: ae4.c, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class MediaBuilderOutput {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final zd4.b renderChainManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RenderModel renderModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TAVComposition composition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long durationUs;

    public MediaBuilderOutput(@NotNull zd4.b renderChainManager, @NotNull RenderModel renderModel, @NotNull TAVComposition composition, long j3) {
        Intrinsics.checkParameterIsNotNull(renderChainManager, "renderChainManager");
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        Intrinsics.checkParameterIsNotNull(composition, "composition");
        this.renderChainManager = renderChainManager;
        this.renderModel = renderModel;
        this.composition = composition;
        this.durationUs = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final TAVComposition getComposition() {
        return this.composition;
    }

    /* renamed from: b, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final zd4.b getRenderChainManager() {
        return this.renderChainManager;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RenderModel getRenderModel() {
        return this.renderModel;
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

    public int hashCode() {
        int i3;
        int i16;
        zd4.b bVar = this.renderChainManager;
        int i17 = 0;
        if (bVar != null) {
            i3 = bVar.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        RenderModel renderModel = this.renderModel;
        if (renderModel != null) {
            i16 = renderModel.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        TAVComposition tAVComposition = this.composition;
        if (tAVComposition != null) {
            i17 = tAVComposition.hashCode();
        }
        return ((i19 + i17) * 31) + androidx.fragment.app.a.a(this.durationUs);
    }

    @NotNull
    public String toString() {
        return "MediaBuilderOutput(renderChainManager=" + this.renderChainManager + ", renderModel=" + this.renderModel + ", composition=" + this.composition + ", durationUs=" + this.durationUs + ")";
    }
}
