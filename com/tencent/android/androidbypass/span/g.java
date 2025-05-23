package com.tencent.android.androidbypass.span;

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
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\u0006\u0010,\u001a\u00020\u0007\u0012\u0006\u0010.\u001a\u00020\u0007\u0012\u0006\u0010/\u001a\u00020\u0007\u0012\u0006\u00101\u001a\u00020\u0007\u0012\u0006\u00103\u001a\u00020\u0007\u00a2\u0006\u0004\b4\u00105J4\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016JR\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010!\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010,\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u0019R\u0014\u0010.\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\u0019R\u0014\u0010/\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u00101\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010\u0019R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u0019\u00a8\u00066"}, d2 = {"Lcom/tencent/android/androidbypass/span/g;", "Landroid/text/style/ReplacementSpan;", "Lcom/tencent/android/androidbypass/span/f;", "Landroid/graphics/Paint;", "paint", "", "text", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "Landroid/graphics/RectF;", "a", "d", "I", "mTextWidth", "e", "mBadgeWidth", "f", "mBadgeHeight", tl.h.F, UserInfo.SEX_FEMALE, "mRadius", "i", "Landroid/graphics/RectF;", "mLocation", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "badgeText", BdhLogUtil.LogTag.Tag_Conn, "textColor", "D", "bgColor", "E", "badgeTextSize", NodeProps.PADDING_VERTICAL, "G", NodeProps.PADDING_HORIZONTAL, "H", "horizontaltMargin", "<init>", "(Ljava/lang/String;IIIIII)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class g extends ReplacementSpan implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final int textColor;

    /* renamed from: D, reason: from kotlin metadata */
    private final int bgColor;

    /* renamed from: E, reason: from kotlin metadata */
    private final int badgeTextSize;

    /* renamed from: F, reason: from kotlin metadata */
    private final int paddingVertical;

    /* renamed from: G, reason: from kotlin metadata */
    private final int paddingHorizontal;

    /* renamed from: H, reason: from kotlin metadata */
    private int horizontaltMargin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mTextWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mBadgeWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mBadgeHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RectF mLocation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String badgeText;

    public g(@NotNull String badgeText, int i3, int i16, int i17, int i18, int i19, int i26) {
        Intrinsics.checkNotNullParameter(badgeText, "badgeText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, badgeText, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            return;
        }
        this.badgeText = badgeText;
        this.textColor = i3;
        this.bgColor = i16;
        this.badgeTextSize = i17;
        this.paddingVertical = i18;
        this.paddingHorizontal = i19;
        this.horizontaltMargin = i26;
        int i27 = i17 + (i18 * 2);
        this.mBadgeHeight = i27;
        this.mRadius = i27 / 2.0f;
        this.mLocation = new RectF();
    }

    @NotNull
    public final RectF a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RectF) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mLocation;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, text, Integer.valueOf(start), Integer.valueOf(end), Float.valueOf(x16), Integer.valueOf(top), Integer.valueOf(y16), Integer.valueOf(bottom), paint);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f16 = y16;
        float f17 = fontMetrics.descent + fontMetrics.ascent;
        float f18 = 2;
        float f19 = (f17 / f18) + f16;
        float f26 = x16 + this.horizontaltMargin;
        int i3 = this.mBadgeHeight;
        this.mLocation = new RectF(f26, f19 - (i3 / 2), this.mBadgeWidth + f26, (i3 / 2) + f19);
        paint.setColor(this.bgColor);
        RectF rectF = this.mLocation;
        float f27 = this.mRadius;
        canvas.drawRoundRect(rectF, f27, f27, paint);
        paint.setTextSize(this.badgeTextSize);
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        int i16 = (this.mBadgeWidth - this.mTextWidth) / 2;
        float f28 = (((fontMetrics2.descent + fontMetrics2.ascent) / f18) + f16) - f19;
        paint.setColor(this.textColor);
        canvas.drawText(this.badgeText, f26 + i16, f16 - f28, paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, this, paint, text, Integer.valueOf(start), Integer.valueOf(end), fm5)).intValue();
        }
        Intrinsics.checkNotNullParameter(paint, "paint");
        float textSize = paint.getTextSize();
        paint.setTextSize(this.badgeTextSize);
        int measureText = (int) paint.measureText(this.badgeText);
        this.mTextWidth = measureText;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(measureText + (this.paddingHorizontal * 2), this.mBadgeHeight);
        this.mBadgeWidth = coerceAtLeast;
        paint.setTextSize(textSize);
        return this.mBadgeWidth + (this.horizontaltMargin * 2);
    }
}
