package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundFillMode;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model.RatioTypeEnum;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\b\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u001a \u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0000\u001a\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004\"\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"", "ratio", "", "maxSize", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "b", "f", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "videos", "e", "fillScale", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "c", "renderSizeF", "sourceSize", "a", "", "Ljava/lang/String;", "getDEFAULT_COLOR_BACKGROUND_ID", "()Ljava/lang/String;", "DEFAULT_COLOR_BACKGROUND_ID", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f276134a;

    static {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        f276134a = uuid;
    }

    @NotNull
    public static final SizeF a(@NotNull SizeF renderSizeF, @NotNull SizeF sourceSize) {
        Intrinsics.checkNotNullParameter(renderSizeF, "renderSizeF");
        Intrinsics.checkNotNullParameter(sourceSize, "sourceSize");
        float f16 = renderSizeF.width;
        float f17 = renderSizeF.height;
        float f18 = f16 / f17;
        float f19 = sourceSize.width;
        float f26 = sourceSize.height;
        if (f19 / f26 >= f18) {
            return new SizeF(renderSizeF.width, sourceSize.height * (f16 / f19), null, 4, null);
        }
        return new SizeF(sourceSize.width * (f17 / f26), renderSizeF.height, null, 4, null);
    }

    @NotNull
    public static final SizeF b(float f16, int i3) {
        if (f16 <= 0.0f) {
            float f17 = i3;
            return new SizeF(f17, f17, null, 4, null);
        }
        if (f16 > 1.0f) {
            float f18 = i3;
            return new SizeF(f18, f18 / f16, null, 4, null);
        }
        float f19 = i3;
        return new SizeF(f19 * f16, f19, null, 4, null);
    }

    @Nullable
    public static final BackgroundModel c(@NotNull List<MediaClip> videos, float f16) {
        Intrinsics.checkNotNullParameter(videos, "videos");
        SizeF e16 = e(videos);
        if (e16 != null) {
            return new BackgroundModel(f276134a, e16, BackgroundFillMode.SOLID_COLOR, "#ff000000", null, RatioTypeEnum.ORIGINAL.getType(), null, null, f16, null, 720, null);
        }
        return null;
    }

    public static /* synthetic */ BackgroundModel d(List list, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 1.0f;
        }
        return c(list, f16);
    }

    @Nullable
    public static final SizeF e(@NotNull List<MediaClip> videos) {
        Object firstOrNull;
        ResourceModel resourceModel;
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(videos, "videos");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) videos);
        MediaClip mediaClip = (MediaClip) firstOrNull;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (sizeF = resourceModel.size) != null) {
            float f16 = sizeF.height;
            if (f16 > 0.0f) {
                return b(sizeF.width / f16, f());
            }
            return null;
        }
        return null;
    }

    private static final int f() {
        return Math.max(720, 1280);
    }
}
