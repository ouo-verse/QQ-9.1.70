package g03;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lg03/b;", "Lg03/a;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "reversed", "Landroid/graphics/Rect;", "l", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends a {
    @TargetApi(11)
    @Nullable
    public final Rect l(@NotNull Canvas canvas, boolean reversed) {
        boolean endsWith$default;
        boolean endsWith$default2;
        int i3;
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect clipBounds = canvas.getClipBounds();
        Intrinsics.checkNotNullExpressionValue(clipBounds, "canvas.clipBounds");
        int i16 = getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[2];
        int i17 = getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[3];
        int i18 = 0;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(getAlign(), "L", false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(getAlign(), BdhLogUtil.LogTag.Tag_Req, false, 2, null);
            if (endsWith$default2) {
                i3 = clipBounds.right - i16;
            } else {
                i3 = 0;
            }
        } else {
            i3 = getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[0];
        }
        if (reversed && getIsMirror()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = (clipBounds.width() - i3) - i16;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(getAlign(), "T", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(getAlign(), "B", false, 2, null);
            if (startsWith$default2) {
                i18 = clipBounds.bottom - i17;
            }
        } else {
            i18 = getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[1];
        }
        return new Rect(i3, i18, i16 + i3, i17 + i18);
    }
}
