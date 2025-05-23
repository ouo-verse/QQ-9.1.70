package by0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 )2\u00020\u0001:\u0001*B#\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u00a2\u0006\u0004\b'\u0010(J4\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JR\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001a\u00a8\u0006+"}, d2 = {"Lby0/a;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "paint", "", "text", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "Landroid/graphics/Bitmap;", "d", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "e", "I", "getLeftMargin", "()I", "leftMargin", "f", "getRightMargin", "rightMargin", "Landroid/graphics/RectF;", h.F, "Landroid/graphics/RectF;", "bitmapRectF", "i", "mColor", "<init>", "(Landroid/graphics/Bitmap;II)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class a extends ReplacementSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bitmap bitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int leftMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int rightMargin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF bitmapRectF;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mColor;

    public a(@NotNull Bitmap bitmap, int i3, int i16) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.leftMargin = i3;
        this.rightMargin = i16;
        this.bitmapRectF = new RectF();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int height = ((((fontMetricsInt.descent + y16) + y16) + fontMetricsInt.ascent) / 2) - (this.bitmap.getHeight() / 2);
        canvas.save();
        canvas.translate(x16, height);
        if (this.mColor != 0) {
            paint.setColorFilter(new PorterDuffColorFilter(this.mColor, PorterDuff.Mode.SRC_ATOP));
        }
        Bitmap bitmap = this.bitmap;
        RectF rectF = this.bitmapRectF;
        rectF.set(this.leftMargin, 0.0f, bitmap.getWidth(), this.bitmap.getHeight());
        Unit unit = Unit.INSTANCE;
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return this.bitmap.getWidth() + this.leftMargin + this.rightMargin;
    }
}
