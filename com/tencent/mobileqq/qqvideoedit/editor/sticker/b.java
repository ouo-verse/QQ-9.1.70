package com.tencent.mobileqq.qqvideoedit.editor.sticker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\u001a\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u001a\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "", "Rotation", "scaleFactor", "b", "curX", "curY", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    @NotNull
    public static final VideoStickerModel a(@NotNull VideoStickerModel videoStickerModel, float f16, float f17) {
        Intrinsics.checkNotNullParameter(videoStickerModel, "<this>");
        return VideoStickerModel.copyAndUpdate$default(videoStickerModel, null, null, 0L, 0L, 0, 0.0f, 0.0f, f16, f17, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, videoStickerModel.getInitStickerScale(), videoStickerModel.getDownScaleRecord(), null, null, null, null, null, null, -1610613121, 31, null);
    }

    @NotNull
    public static final VideoStickerModel b(@NotNull VideoStickerModel videoStickerModel, float f16, float f17) {
        Intrinsics.checkNotNullParameter(videoStickerModel, "<this>");
        return VideoStickerModel.copyAndUpdate$default(videoStickerModel, null, null, 0L, 0L, 0, f17, f16, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, videoStickerModel.getInitStickerScale(), videoStickerModel.getDownScaleRecord(), null, null, null, null, null, null, -1610612833, 31, null);
    }
}
