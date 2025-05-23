package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\n"}, d2 = {QQPermissionConstants.Permission.AUIDO_GROUP, "Landroid/graphics/Picture;", "width", "", "height", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class PictureKt {
    @NotNull
    public static final Picture record(@NotNull Picture record, int i3, int i16, @NotNull Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(record, "$this$record");
        Intrinsics.checkNotNullParameter(block, "block");
        Canvas beginRecording = record.beginRecording(i3, i16);
        Intrinsics.checkNotNullExpressionValue(beginRecording, "beginRecording(width, height)");
        try {
            block.invoke(beginRecording);
            return record;
        } finally {
            InlineMarker.finallyStart(1);
            record.endRecording();
            InlineMarker.finallyEnd(1);
        }
    }
}
