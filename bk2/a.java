package bk2;

import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/tavcut/rendermodel/RenderModel;", "", "max", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    @NotNull
    public static final RenderModel a(@NotNull RenderModel renderModel, long j3) {
        RenderModel copy;
        Intrinsics.checkNotNullParameter(renderModel, "<this>");
        copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : null, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : null, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : j3, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
        return copy;
    }
}
