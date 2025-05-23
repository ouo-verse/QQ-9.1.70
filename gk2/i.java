package gk2;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PointF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Transform;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u001c\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\"\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Transform;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "clipSize", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "b", "c", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PointF;", "anchorPoint", "Lcom/tencent/tavcut/composition/model/component/Rect;", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i {
    private static final Rect a(PointF pointF, SizeF sizeF, SizeF sizeF2) {
        boolean z16;
        boolean z17 = false;
        if (0.0f == sizeF2.width) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (0.0f == sizeF2.height) {
                z17 = true;
            }
            if (!z17 && sizeF != null) {
                SizeF a16 = com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.i.a(sizeF, sizeF2);
                float f16 = -1;
                float f17 = pointF.x;
                float f18 = sizeF.width;
                float f19 = a16.width;
                float f26 = f16 + ((f17 * f18) / f19);
                float f27 = 1;
                float f28 = f27 + ((f17 * f18) / f19);
                float f29 = pointF.y;
                float f36 = sizeF.height;
                float f37 = a16.height;
                return new Rect(f26, f27 + ((f29 * f36) / f37), f28, f16 + ((f29 * f36) / f37), null, 16, null);
            }
        }
        return new Rect(-1.0f, 1.0f, 1.0f, -1.0f, null, 16, null);
    }

    @NotNull
    public static final ScreenTransform b(@NotNull Transform transform, @Nullable SizeF sizeF, @NotNull SizeF clipSize) {
        float f16;
        float f17;
        Intrinsics.checkNotNullParameter(transform, "<this>");
        Intrinsics.checkNotNullParameter(clipSize, "clipSize");
        xd4.e n3 = od4.b.f422509e.n();
        PointF pointF = transform.anchorPoint;
        if (pointF != null) {
            f16 = pointF.x;
        } else {
            f16 = 0.0f;
        }
        if (pointF != null) {
            f17 = pointF.y;
        } else {
            f17 = 0.0f;
        }
        return n3.r(f16, f17, clipSize.width, clipSize.height, transform.scale, transform.rotate);
    }

    @NotNull
    public static final ScreenTransform c(@NotNull Transform transform, @Nullable SizeF sizeF, @NotNull SizeF clipSize) {
        Intrinsics.checkNotNullParameter(transform, "<this>");
        Intrinsics.checkNotNullParameter(clipSize, "clipSize");
        xd4.e n3 = od4.b.f422509e.n();
        float f16 = transform.scale;
        float f17 = transform.rotate;
        PointF pointF = transform.anchorPoint;
        if (pointF == null) {
            pointF = new PointF(0.0f, 0.0f, null, 7, null);
        }
        return n3.i(f16, f17, a(pointF, sizeF, clipSize));
    }
}
