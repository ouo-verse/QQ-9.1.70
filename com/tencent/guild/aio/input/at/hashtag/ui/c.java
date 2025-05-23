package com.tencent.guild.aio.input.at.hashtag.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001\u000fBg\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\n\u0012\u0006\u0010$\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\n\u0012\u0006\u0010(\u001a\u00020\n\u0012\u0006\u0010*\u001a\u00020\n\u0012\u0006\u0010,\u001a\u00020\n\u0012\u0006\u0010.\u001a\u00020\n\u0012\u0006\u00100\u001a\u00020\n\u0012\u0006\u00102\u001a\u00020\n\u0012\u0006\u00104\u001a\u00020\n\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J*\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002JV\u0010\u0017\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016J8\u0010\u001a\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\nR\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R\u0014\u0010#\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u0014\u0010$\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010(\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010!R\u0014\u0010,\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010!R\u0014\u0010.\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010!R\u0014\u00100\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010!R\u0014\u00102\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010!R\u0014\u00104\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010!R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010!R\u0016\u00107\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00101R\u0016\u0010:\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/guild/aio/input/at/hashtag/ui/c;", "Landroid/text/style/ImageSpan;", "Lbq0/g;", "Landroid/graphics/Paint;", "paint", "", "e", "d", "", "text", "", "start", "end", "", "b", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "draw", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/RectF;", "c", "color", "setBackgroundColor", "newColor", "f", "I", "mImgSize", "mTextSize", "mMarginLeft", tl.h.F, "mMarginRight", "i", "mMarginBetweenIconText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTextColor", BdhLogUtil.LogTag.Tag_Conn, "mBgColor", "D", "imageTextLength", "E", "mRadius", UserInfo.SEX_FEMALE, "mTopBottomPadding", "G", "mLeftRightPadding", "H", "oldColor", "oldTextSize", "J", "Landroid/graphics/RectF;", "mTextBackgroundRectF", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;IIIIIIIIIII)V", "K", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends ImageSpan implements bq0.g {

    /* renamed from: C, reason: from kotlin metadata */
    private final int mBgColor;

    /* renamed from: D, reason: from kotlin metadata */
    private final int imageTextLength;

    /* renamed from: E, reason: from kotlin metadata */
    private final int mRadius;

    /* renamed from: F, reason: from kotlin metadata */
    private final int mTopBottomPadding;

    /* renamed from: G, reason: from kotlin metadata */
    private final int mLeftRightPadding;

    /* renamed from: H, reason: from kotlin metadata */
    private int oldColor;

    /* renamed from: I, reason: from kotlin metadata */
    private float oldTextSize;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private RectF mTextBackgroundRectF;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mImgSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mTextSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mMarginLeft;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mMarginRight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mMarginBetweenIconText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mTextColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Drawable drawable, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mImgSize = i3;
        this.mTextSize = i16;
        this.mMarginLeft = i17;
        this.mMarginRight = i18;
        this.mMarginBetweenIconText = i19;
        this.mTextColor = i26;
        this.mBgColor = i27;
        this.imageTextLength = i28;
        this.mRadius = i29;
        this.mTopBottomPadding = i36;
        this.mLeftRightPadding = i37;
        this.mTextBackgroundRectF = new RectF();
    }

    private final int a(Paint paint, CharSequence text, int start, int end) {
        String b16;
        int i3 = 0;
        if (text != null && (b16 = b(text, start, end)) != null) {
            paint.setTextSize(this.mTextSize);
            i3 = MathKt__MathJVMKt.roundToInt(paint.measureText(b16));
        }
        return this.mMarginLeft + this.mImgSize + this.mMarginBetweenIconText + i3 + this.mMarginRight + (this.mLeftRightPadding * 2);
    }

    private final String b(CharSequence text, int start, int end) {
        if (text == null) {
            return null;
        }
        String obj = text.subSequence(start + this.imageTextLength, end).toString();
        if (obj.length() > 9) {
            String substring = obj.substring(0, 9);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return obj;
    }

    private final void d(Paint paint) {
        paint.setColor(this.oldColor);
        paint.setTextSize(this.oldTextSize);
    }

    private final void e(Paint paint) {
        this.oldColor = paint.getColor();
        this.oldTextSize = paint.getTextSize();
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RectF getMTextBackgroundRectF() {
        return this.mTextBackgroundRectF;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull @NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NonNull @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        e(paint);
        paint.setColor(this.mBgColor);
        paint.setAntiAlias(true);
        float f16 = top;
        this.mTextBackgroundRectF.set(x16, this.mTopBottomPadding + f16, (a(paint, text, start, end) + x16) - this.mLeftRightPadding, bottom - this.mTopBottomPadding);
        RectF rectF = this.mTextBackgroundRectF;
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        d(paint);
        e(paint);
        paint.setTextSize(this.mImgSize);
        Drawable drawable = getDrawable();
        int i16 = this.mMarginLeft;
        int i17 = this.mImgSize;
        drawable.setBounds(i16, 0, i16 + i17, i17);
        Intrinsics.checkNotNullExpressionValue(paint.getFontMetricsInt(), "paint.fontMetricsInt");
        canvas.save();
        canvas.translate(x16, (((bottom - top) / 2.0f) - (this.mImgSize / 2.0f)) + f16);
        getDrawable().draw(canvas);
        canvas.restore();
        d(paint);
        e(paint);
        paint.setColor(this.mTextColor);
        paint.setTextSize(this.mTextSize);
        Intrinsics.checkNotNullExpressionValue(paint.getFontMetricsInt(), "paint.fontMetricsInt");
        float f17 = ((bottom + top) / 2.0f) - ((r12.descent + r12.ascent) / 2.0f);
        String b16 = b(text, start, end);
        if (b16 != null) {
            canvas.drawText(b16, x16 + this.mMarginLeft + this.mImgSize + this.mMarginBetweenIconText, f17, paint);
        }
        d(paint);
    }

    public final void f(int newColor) {
        this.mTextColor = newColor;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull @NotNull Paint paint, @Nullable CharSequence text, int start, int end, @androidx.annotation.Nullable @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        e(paint);
        int a16 = a(paint, text, start, end);
        d(paint);
        return a16;
    }

    @Override // bq0.g
    public void setBackgroundColor(int color) {
    }
}
