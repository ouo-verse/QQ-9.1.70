package com.tencent.mobileqq.qqlive.widget.chat.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010'\u001a\u00020\u0006\u0012\u0006\u0010(\u001a\u00020\u0006\u0012\u0006\u0010)\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u00a2\u0006\u0004\b*\u0010+J4\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JP\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001d\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/span/f;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "paint", "", "text", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "", "d", "Z", "bold", "e", UserInfo.SEX_FEMALE, "textSize", "f", "I", "paddingY", h.F, "mSize", "i", "mBgColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTextColor", BdhLogUtil.LogTag.Tag_Conn, "mRadius", "bgColor", "textColor", "radius", "<init>", "(IIIZFI)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f extends ReplacementSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int mRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean bold;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float textSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int paddingY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mBgColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mTextColor;

    public /* synthetic */ f(int i3, int i16, int i17, boolean z16, float f16, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, (i19 & 8) != 0 ? false : z16, (i19 & 16) != 0 ? -1.0f : f16, (i19 & 32) != 0 ? 0 : i18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i18), Integer.valueOf(i19), defaultConstructorMarker);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @NotNull CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, text, Integer.valueOf(start), Integer.valueOf(end), Float.valueOf(x16), Integer.valueOf(top), Integer.valueOf(y16), Integer.valueOf(bottom), paint);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int color = paint.getColor();
        paint.setColor(this.mBgColor);
        float textSize = paint.getTextSize();
        Paint.Style style = paint.getStyle();
        float strokeWidth = paint.getStrokeWidth();
        float f16 = this.textSize;
        if (f16 > 0.0f) {
            paint.setTextSize(f16);
        }
        if (this.bold) {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(0.5f);
        }
        paint.setAntiAlias(true);
        float f17 = y16;
        float descent = ((this.mRadius * 2) - (paint.descent() - paint.ascent())) / 2;
        RectF rectF = new RectF(x16, ((paint.ascent() + f17) - descent) + this.paddingY, this.mSize + x16, ((f17 + paint.descent()) + descent) - this.paddingY);
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        paint.setColor(this.mTextColor);
        canvas.drawText(text, start, end, x16 + ((this.mRadius * 2) / 3), f17, paint);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(style);
        paint.setColor(color);
        paint.setTextSize(textSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, paint, text, Integer.valueOf(start), Integer.valueOf(end), fm5)).intValue();
        }
        Intrinsics.checkNotNullParameter(paint, "paint");
        float textSize = paint.getTextSize();
        paint.setTextSize(this.textSize);
        this.mSize = (int) (paint.measureText(text, start, end) + (((this.mRadius * 2) * 2) / 3));
        paint.setTextSize(textSize);
        return this.mSize;
    }

    public f(int i3, int i16, int i17, boolean z16, float f16, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Float.valueOf(f16), Integer.valueOf(i18));
            return;
        }
        this.bold = z16;
        this.textSize = f16;
        this.paddingY = i18;
        this.mBgColor = i3;
        this.mTextColor = i16;
        this.mRadius = i17;
    }
}
