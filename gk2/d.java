package gk2;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RectF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.model.ClipSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\"\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "Lcom/tencent/tavcut/model/ClipSource;", "c", "", "a", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;)Ljava/lang/String;", "resId", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "b", "(Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "size", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {
    @NotNull
    public static final String a(@NotNull MediaClip mediaClip) {
        String str;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel == null || (str = resourceModel.id) == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final SizeF b(@NotNull MediaClip mediaClip) {
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel == null || (sizeF = resourceModel.size) == null) {
            return new SizeF(0.0f, 0.0f, null, 7, null);
        }
        return sizeF;
    }

    @Nullable
    public static final ClipSource c(@NotNull MediaClip mediaClip) {
        ClipSource.ClipType clipType;
        float f16;
        Intrinsics.checkNotNullParameter(mediaClip, "<this>");
        ResourceModel resourceModel = mediaClip.resource;
        if (resourceModel != null) {
            RectF rectF = resourceModel.picClipRect;
            if (rectF == null) {
                rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f, null, 31, null);
            }
            String str = resourceModel.id;
            String str2 = resourceModel.path;
            if (resourceModel.type == MediaType.IMAGE) {
                clipType = ClipSource.ClipType.PHOTO;
            } else {
                clipType = ClipSource.ClipType.VIDEO;
            }
            ClipSource.ClipType clipType2 = clipType;
            Rect rect = new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom, null, 16, null);
            long j3 = resourceModel.selectDuration;
            long j16 = resourceModel.scaleDuration;
            if (j16 != 0) {
                f16 = ((float) j3) / ((float) j16);
            } else {
                f16 = 1.0f;
            }
            float f17 = resourceModel.volume;
            long j17 = resourceModel.selectStart;
            return new ClipSource(str, str2, clipType2, j3, Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j17), mediaClip.matrix, null, null, rect, null, 2816, null);
        }
        return null;
    }
}
