package com.tencent.mobileqq.wink.editor.sticker;

import com.tencent.videocut.model.StickerModel;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001a\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a2\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\u001a\n\u0010\r\u001a\u00020\f*\u00020\u000b\u001a\u0014\u0010\u0010\u001a\u00020\f*\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "", "curX", "curY", "a", "newCenterX", "newCenterY", "newRotate", "newScaleX", "newScaleY", "b", "Lcom/tencent/videocut/model/StickerModel;", "", "d", "", "parentFolderPath", "e", "c", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {
    @NotNull
    public static final WinkStickerModel a(@NotNull WinkStickerModel winkStickerModel, float f16, float f17) {
        Intrinsics.checkNotNullParameter(winkStickerModel, "<this>");
        return WinkStickerModel.copyAndUpdate$default(winkStickerModel, null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, f16, f17, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, winkStickerModel.getInitStickerScale(), winkStickerModel.getDownScaleRecord(), null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -769, 1048572, null);
    }

    @NotNull
    public static final WinkStickerModel b(@NotNull WinkStickerModel winkStickerModel, float f16, float f17, float f18, float f19, float f26) {
        Intrinsics.checkNotNullParameter(winkStickerModel, "<this>");
        return WinkStickerModel.copyAndUpdate$default(winkStickerModel, null, null, 0L, 0L, 0, f19, f26, f18, f16, f17, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -993, 1048575, null);
    }

    @Nullable
    public static final String c(@NotNull StickerModel stickerModel) {
        boolean z16;
        File parentFile;
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        String str = stickerModel.filePath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (parentFile = new File(stickerModel.filePath).getParentFile()) == null) {
            return null;
        }
        return parentFile.getAbsolutePath();
    }

    public static final boolean d(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        return e(stickerModel, c(stickerModel));
    }

    public static final boolean e(@NotNull StickerModel stickerModel, @Nullable String str) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        return l73.a.f413927a.m(str);
    }
}
