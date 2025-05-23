package g03;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014\u00a8\u0006$"}, d2 = {"Lg03/c;", "Lg03/a;", "Landroid/graphics/Paint;", "paint", "", "text", "", DomainData.DOMAIN_NAME, "Landroid/graphics/Canvas;", PM.CANVAS, "", "reversed", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "I", "l", "()I", "p", "(I)V", "textColor", "getTextSize", "r", "textSize", "Ljava/lang/String;", "getTextAlign", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "textAlign", "getTextMaxCount", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "textMaxCount", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c extends a {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int textColor = -1;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int textSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String textAlign;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int textMaxCount;

    private final float n(Paint paint, String text) {
        if (!TextUtils.isEmpty(text) && paint != null) {
            return paint.measureText(text);
        }
        return 0.0f;
    }

    /* renamed from: l, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f2  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Rect m(@NotNull Canvas canvas, @NotNull Paint paint, boolean reversed) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        int i3;
        boolean endsWith$default;
        boolean endsWith$default2;
        float f16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Rect clipBounds = canvas.getClipBounds();
        Intrinsics.checkNotNullExpressionValue(clipBounds, "canvas.clipBounds");
        if (getSBubbleMinHeight() == -1) {
            j(x.a(getMIN_HEIGHT_EXCLUDE_PADDING()));
        }
        int i16 = 0;
        if (reversed && getIsMirror()) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i17 = getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[3];
        int i18 = getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[2];
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(getAlign(), "T", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(getAlign(), "B", false, 2, null);
            if (startsWith$default2) {
                i3 = (clipBounds.bottom - getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[1]) - i17;
            } else {
                i3 = 0;
            }
        } else {
            i3 = getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[1];
        }
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(getAlign(), "L", false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(getAlign(), BdhLogUtil.LogTag.Tag_Req, false, 2, null);
            if (endsWith$default2) {
                i16 = (clipBounds.right - getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[0]) - i18;
            }
        } else {
            i16 = getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String()[0];
        }
        paint.setAntiAlias(true);
        paint.setFakeBoldText(true);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float n3 = n(paint, "\u4f60\u597d");
        float f17 = fontMetrics.bottom;
        float f18 = fontMetrics.top;
        float f19 = 2;
        int i19 = (int) (((i3 + (i17 / 2)) - ((f17 - f18) / f19)) - f18);
        if (Intrinsics.areEqual(this.textAlign, "center")) {
            f16 = i16 + ((i18 - n3) / f19);
        } else {
            if (Intrinsics.areEqual(this.textAlign, "right")) {
                f16 = (i16 + i18) - n3;
            }
            if (!z16) {
                float width = (clipBounds.width() - i16) - n3;
                return new Rect((int) width, i19, (int) (width + i18), i17 + i19);
            }
            return new Rect(i16, i19, i18 + i16, i17 + i19);
        }
        i16 = (int) f16;
        if (!z16) {
        }
    }

    public final void o(@Nullable String str) {
        this.textAlign = str;
    }

    public final void p(int i3) {
        this.textColor = i3;
    }

    public final void q(int i3) {
        this.textMaxCount = i3;
    }

    public final void r(int i3) {
        this.textSize = i3;
    }
}
