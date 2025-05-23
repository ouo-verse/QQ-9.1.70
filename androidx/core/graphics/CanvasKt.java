package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001a3\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001aG\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001a)\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001aQ\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001a=\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u001a=\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001e"}, d2 = {"withClip", "", "Landroid/graphics/Canvas;", "clipPath", "Landroid/graphics/Path;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", HippyTKDListViewAdapter.X, "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(@NotNull Canvas withClip, @NotNull Rect clipRect, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withClip, "$this$withClip");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withMatrix(@NotNull Canvas withMatrix, @NotNull Matrix matrix, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withMatrix, "$this$withMatrix");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            InlineMarker.finallyStart(1);
            withMatrix.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas withMatrix, Matrix matrix, Function1 block, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            matrix = new Matrix();
        }
        Intrinsics.checkNotNullParameter(withMatrix, "$this$withMatrix");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            InlineMarker.finallyStart(1);
            withMatrix.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withRotation(@NotNull Canvas withRotation, float f16, float f17, float f18, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withRotation, "$this$withRotation");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f16, f17, f18);
        try {
            block.invoke(withRotation);
        } finally {
            InlineMarker.finallyStart(1);
            withRotation.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas withRotation, float f16, float f17, float f18, Function1 block, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            f18 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(withRotation, "$this$withRotation");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f16, f17, f18);
        try {
            block.invoke(withRotation);
        } finally {
            InlineMarker.finallyStart(1);
            withRotation.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withSave(@NotNull Canvas withSave, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withSave, "$this$withSave");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withSave.save();
        try {
            block.invoke(withSave);
        } finally {
            InlineMarker.finallyStart(1);
            withSave.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withScale(@NotNull Canvas withScale, float f16, float f17, float f18, float f19, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withScale, "$this$withScale");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withScale.save();
        withScale.scale(f16, f17, f18, f19);
        try {
            block.invoke(withScale);
        } finally {
            InlineMarker.finallyStart(1);
            withScale.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas withScale, float f16, float f17, float f18, float f19, Function1 block, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 1.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 1.0f;
        }
        if ((i3 & 4) != 0) {
            f18 = 0.0f;
        }
        if ((i3 & 8) != 0) {
            f19 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(withScale, "$this$withScale");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withScale.save();
        withScale.scale(f16, f17, f18, f19);
        try {
            block.invoke(withScale);
        } finally {
            InlineMarker.finallyStart(1);
            withScale.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withSkew(@NotNull Canvas withSkew, float f16, float f17, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withSkew, "$this$withSkew");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withSkew.save();
        withSkew.skew(f16, f17);
        try {
            block.invoke(withSkew);
        } finally {
            InlineMarker.finallyStart(1);
            withSkew.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas withSkew, float f16, float f17, Function1 block, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(withSkew, "$this$withSkew");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withSkew.save();
        withSkew.skew(f16, f17);
        try {
            block.invoke(withSkew);
        } finally {
            InlineMarker.finallyStart(1);
            withSkew.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withTranslation(@NotNull Canvas withTranslation, float f16, float f17, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withTranslation, "$this$withTranslation");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f16, f17);
        try {
            block.invoke(withTranslation);
        } finally {
            InlineMarker.finallyStart(1);
            withTranslation.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas withTranslation, float f16, float f17, Function1 block, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(withTranslation, "$this$withTranslation");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f16, f17);
        try {
            block.invoke(withTranslation);
        } finally {
            InlineMarker.finallyStart(1);
            withTranslation.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withClip(@NotNull Canvas withClip, @NotNull RectF clipRect, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withClip, "$this$withClip");
        Intrinsics.checkNotNullParameter(clipRect, "clipRect");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withClip(@NotNull Canvas withClip, int i3, int i16, int i17, int i18, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withClip, "$this$withClip");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withClip.save();
        withClip.clipRect(i3, i16, i17, i18);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withClip(@NotNull Canvas withClip, float f16, float f17, float f18, float f19, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withClip, "$this$withClip");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withClip.save();
        withClip.clipRect(f16, f17, f18, f19);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withClip(@NotNull Canvas withClip, @NotNull Path clipPath, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(withClip, "$this$withClip");
        Intrinsics.checkNotNullParameter(clipPath, "clipPath");
        Intrinsics.checkNotNullParameter(block, "block");
        int save = withClip.save();
        withClip.clipPath(clipPath);
        try {
            block.invoke(withClip);
        } finally {
            InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            InlineMarker.finallyEnd(1);
        }
    }
}
