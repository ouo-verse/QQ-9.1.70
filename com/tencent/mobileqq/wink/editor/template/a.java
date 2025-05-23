package com.tencent.mobileqq.wink.editor.template;

import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a \u0010\t\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "", "max", "c", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "videos", "", "modify", "b", "", "outputWidth", "outputHeight", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    public static final boolean a(@NotNull LAKRenderModel lAKRenderModel, int i3, int i16) {
        int i17;
        Intrinsics.checkNotNullParameter(lAKRenderModel, "<this>");
        if (i16 * i3 < 1.0E-5d) {
            ms.a.f("RenderModel Ext", "checkAndCorrectRenderSize:Failed : the width or height is zero or negative.");
            return false;
        }
        Size renderSize = lAKRenderModel.getPainting().getRenderSize();
        if (renderSize == null) {
            return false;
        }
        float f16 = (i3 * 1.0f) / i16;
        int i18 = renderSize.width;
        int i19 = renderSize.height;
        if (i18 * i19 >= 1.0E-5d && Math.abs((i18 / i19) - f16) <= 0.01f && ((i17 = renderSize.width) != i3 || renderSize.height != i16)) {
            ms.a.f("RenderModel Ext", "checkAndCorrectRenderSize:successful :  renderSize:(" + i17 + "," + renderSize.height + ") correct to render size(" + i3 + "," + i16 + ").");
            return true;
        }
        ms.a.f("RenderModel Ext", "checkAndCorrectRenderSize:Failed : the ratio is not equal OR the width or height is zero or negative OR size is same. renderSize:{" + renderSize.width + "," + renderSize.height + "}, outputSize:{" + i3 + ", " + i16 + "}");
        return false;
    }

    @NotNull
    public static final LAKRenderModel b(@NotNull LAKRenderModel lAKRenderModel, @NotNull List<ClipSource> videos, boolean z16) {
        LAKRenderModel copy;
        Intrinsics.checkNotNullParameter(lAKRenderModel, "<this>");
        Intrinsics.checkNotNullParameter(videos, "videos");
        copy = lAKRenderModel.copy((r37 & 1) != 0 ? lAKRenderModel.renderScene : null, (r37 & 2) != 0 ? lAKRenderModel.root : null, (r37 & 4) != 0 ? lAKRenderModel.jsonData : null, (r37 & 8) != 0 ? lAKRenderModel.inputSources : null, (r37 & 16) != 0 ? lAKRenderModel.painting : null, (r37 & 32) != 0 ? lAKRenderModel.clipsAssets : videos, (r37 & 64) != 0 ? lAKRenderModel.modifyClipsDuration : z16, (r37 & 128) != 0 ? lAKRenderModel.seekTolerance : 0, (r37 & 256) != 0 ? lAKRenderModel.properties : null, (r37 & 512) != 0 ? lAKRenderModel.audioAssets : null, (r37 & 1024) != 0 ? lAKRenderModel.timeLines : null, (r37 & 2048) != 0 ? lAKRenderModel.maxDuration : 0L, (r37 & 4096) != 0 ? lAKRenderModel.componentLevel : 0, (r37 & 8192) != 0 ? lAKRenderModel.voiceChangerConfig : null, (r37 & 16384) != 0 ? lAKRenderModel.customRenderConfig : null, (r37 & 32768) != 0 ? lAKRenderModel.exportMode : false, (r37 & 65536) != 0 ? lAKRenderModel.stickerValue : null, (r37 & 131072) != 0 ? lAKRenderModel.watermarkConfig : null);
        return copy;
    }

    @NotNull
    public static final LAKRenderModel c(@NotNull LAKRenderModel lAKRenderModel, long j3) {
        LAKRenderModel copy;
        Intrinsics.checkNotNullParameter(lAKRenderModel, "<this>");
        copy = lAKRenderModel.copy((r37 & 1) != 0 ? lAKRenderModel.renderScene : null, (r37 & 2) != 0 ? lAKRenderModel.root : null, (r37 & 4) != 0 ? lAKRenderModel.jsonData : null, (r37 & 8) != 0 ? lAKRenderModel.inputSources : null, (r37 & 16) != 0 ? lAKRenderModel.painting : null, (r37 & 32) != 0 ? lAKRenderModel.clipsAssets : null, (r37 & 64) != 0 ? lAKRenderModel.modifyClipsDuration : false, (r37 & 128) != 0 ? lAKRenderModel.seekTolerance : 0, (r37 & 256) != 0 ? lAKRenderModel.properties : null, (r37 & 512) != 0 ? lAKRenderModel.audioAssets : null, (r37 & 1024) != 0 ? lAKRenderModel.timeLines : null, (r37 & 2048) != 0 ? lAKRenderModel.maxDuration : j3, (r37 & 4096) != 0 ? lAKRenderModel.componentLevel : 0, (r37 & 8192) != 0 ? lAKRenderModel.voiceChangerConfig : null, (r37 & 16384) != 0 ? lAKRenderModel.customRenderConfig : null, (r37 & 32768) != 0 ? lAKRenderModel.exportMode : false, (r37 & 65536) != 0 ? lAKRenderModel.stickerValue : null, (r37 & 131072) != 0 ? lAKRenderModel.watermarkConfig : null);
        return copy;
    }
}
