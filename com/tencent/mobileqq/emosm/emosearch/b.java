package com.tencent.mobileqq.emosm.emosearch;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchBoundingBox;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchPoint;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchRGBAColor;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextComposeInfo;
import com.tencent.util.Pair;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0018\u0010%\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020#J\u001a\u0010&\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020#J8\u0010,\u001a\u00020+2\u0006\u0010'\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\rJ0\u00101\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\rJ\u000e\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u000202\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/emosm/emosearch/b;", "", "", "text", "", "i", TtmlNode.ATTR_TTS_ORIGIN, "", "textList", "Lcom/tencent/util/Pair;", DomainData.DOMAIN_NAME, "Landroid/graphics/Rect;", "textArea", "Landroid/graphics/Paint;", "paint", "", "l", "firstLine", "secondLine", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "textWidth", "textHeight", "j", WidgetCacheConstellationData.NUM, "d", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchRGBAColor;", "color", "", "b", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchBoundingBox;", "box", "Landroid/graphics/RectF;", "f", "Landroid/graphics/Typeface;", "compositeTypeface", "e", "g", "rectF", "width", "height", "strokePaint", "Lcom/tencent/mobileqq/emosm/emosearch/a;", "k", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/PointF;", "point", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchTextComposeInfo;", "info", h.F, "<init>", "()V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f204292a = new b();

    b() {
    }

    private final int b(EmojiHotPicSearchRGBAColor color) {
        if (color != null) {
            return Color.argb(color.alpha, color.red, color.green, color.blue);
        }
        return -16777216;
    }

    private final String c(int color) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%06X", Arrays.copyOf(new Object[]{Integer.valueOf(color & 16777215)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final String d(float num) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf((int) (num * 100))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final boolean i(String text) {
        if (text.length() <= 7) {
            return true;
        }
        return false;
    }

    private final boolean j(float textWidth, float textHeight, Rect textArea) {
        if (textWidth < textArea.width() && textHeight < textArea.height()) {
            return true;
        }
        return false;
    }

    private final void l(String text, Rect textArea, Paint paint) {
        float f16 = 6.5f;
        do {
            paint.setTextSize(textArea.width() / f16);
            float measureText = paint.measureText(text);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            f16 += 0.5f;
            if (j(measureText, fontMetrics.descent - fontMetrics.ascent, textArea)) {
                return;
            }
        } while (f16 < 8.1f);
    }

    private final void m(String firstLine, String secondLine, Rect textArea, Paint paint) {
        float measureText;
        float f16;
        float measureText2;
        Paint.FontMetrics fontMetrics;
        Rect rect = new Rect(textArea);
        int i3 = rect.top;
        rect.bottom = i3 + ((rect.bottom - i3) / 2);
        float f17 = 6.0f;
        do {
            paint.setTextSize(textArea.width() / f17);
            measureText = paint.measureText(firstLine);
            Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
            f16 = fontMetrics2.descent - fontMetrics2.ascent;
            measureText2 = paint.measureText(secondLine);
            fontMetrics = paint.getFontMetrics();
            f17 += 0.5f;
        } while (!j(Math.max(measureText, measureText2), Math.max(f16, fontMetrics.descent - fontMetrics.ascent), rect));
    }

    private final Pair<String, String> n(String origin, List<String> textList) {
        String str;
        if (origin.length() > 20) {
            str = origin.substring(0, 20);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        } else {
            str = origin;
        }
        String substring = str.substring(0, str.length() / 2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String substring2 = origin.substring(str.length() / 2, str.length());
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return new Pair<>(substring, substring2);
    }

    public final void a(@NotNull Canvas canvas, @NotNull String text, @NotNull PointF point, @NotNull Paint paint, @Nullable Paint strokePaint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (strokePaint != null) {
            canvas.drawText(text, point.x, point.y, strokePaint);
        }
        canvas.drawText(text, point.x, point.y, paint);
    }

    @NotNull
    public final Paint e(@Nullable EmojiHotPicSearchRGBAColor color, @NotNull Typeface compositeTypeface) {
        Intrinsics.checkNotNullParameter(compositeTypeface, "compositeTypeface");
        Paint paint = new Paint(1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(compositeTypeface);
        paint.setColor(f204292a.b(color));
        paint.setLetterSpacing(0.05f);
        return paint;
    }

    @NotNull
    public final RectF f(@Nullable EmojiHotPicSearchBoundingBox box) {
        EmojiHotPicSearchPoint emojiHotPicSearchPoint;
        EmojiHotPicSearchPoint emojiHotPicSearchPoint2;
        if (box != null && (emojiHotPicSearchPoint = box.topLeft) != null && (emojiHotPicSearchPoint2 = box.bottomRight) != null) {
            float f16 = emojiHotPicSearchPoint.f359168x;
            float f17 = emojiHotPicSearchPoint2.f359168x;
            if (f16 < f17) {
                float f18 = emojiHotPicSearchPoint.f359169y;
                float f19 = emojiHotPicSearchPoint2.f359169y;
                if (f18 < f19 && f16 >= 0.0f && f16 <= 1.0f && f18 >= 0.0f && f18 <= 1.0f && f17 >= 0.0f && f17 <= 1.0f && f19 >= 0.0f && f19 <= 1.0f) {
                    EmojiHotPicSearchPoint emojiHotPicSearchPoint3 = box.topLeft;
                    float f26 = emojiHotPicSearchPoint3.f359168x;
                    float f27 = emojiHotPicSearchPoint3.f359169y;
                    EmojiHotPicSearchPoint emojiHotPicSearchPoint4 = box.bottomRight;
                    return new RectF(f26, f27, emojiHotPicSearchPoint4.f359168x, emojiHotPicSearchPoint4.f359169y);
                }
            }
        }
        return new RectF(0.05f, 0.6f, 0.95f, 0.95f);
    }

    @Nullable
    public final Paint g(@Nullable EmojiHotPicSearchRGBAColor color, @NotNull Typeface compositeTypeface) {
        Intrinsics.checkNotNullParameter(compositeTypeface, "compositeTypeface");
        if (color == null) {
            return null;
        }
        Paint paint = new Paint(1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ViewUtils.dpToPx(1.0f));
        paint.setTypeface(compositeTypeface);
        paint.setColor(f204292a.b(color));
        paint.setLetterSpacing(0.05f);
        return paint;
    }

    @NotNull
    public final String h(@NotNull EmojiHotPicSearchTextComposeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        StringBuilder sb5 = new StringBuilder();
        RectF f16 = f(info.bBox);
        sb5.append(d(f16.left));
        sb5.append(d(f16.top));
        sb5.append(d(f16.right));
        sb5.append(d(f16.bottom));
        int b16 = b(info.textColor);
        sb5.append("_");
        sb5.append(c(b16));
        EmojiHotPicSearchRGBAColor emojiHotPicSearchRGBAColor = info.shadowColor;
        if (emojiHotPicSearchRGBAColor != null) {
            b bVar = f204292a;
            int b17 = bVar.b(emojiHotPicSearchRGBAColor);
            sb5.append("_");
            sb5.append(bVar.c(b17));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @NotNull
    public final CompositeDrawTextParam k(@NotNull RectF rectF, @NotNull String text, int width, int height, @NotNull Paint paint, @Nullable Paint strokePaint) {
        PointF[] pointFArr;
        String[] strArr;
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f16 = width;
        float f17 = height;
        Rect rect = new Rect((int) (rectF.left * f16), (int) (rectF.top * f17), (int) (rectF.right * f16), (int) (rectF.bottom * f17));
        if (i(text)) {
            l(text, rect, paint);
            strArr = new String[]{text};
            pointFArr = new PointF[]{new PointF(rect.centerX(), rect.top - paint.getFontMetrics().ascent)};
        } else {
            Pair<String, String> n3 = n(text, null);
            String str = n3.first;
            Intrinsics.checkNotNullExpressionValue(str, "split.first");
            String str2 = n3.second;
            Intrinsics.checkNotNullExpressionValue(str2, "split.second");
            m(str, str2, rect, paint);
            String str3 = n3.first;
            Intrinsics.checkNotNullExpressionValue(str3, "split.first");
            String str4 = n3.second;
            Intrinsics.checkNotNullExpressionValue(str4, "split.second");
            String[] strArr2 = {str3, str4};
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f18 = rect.top - fontMetrics.ascent;
            pointFArr = new PointF[]{new PointF(rect.centerX(), f18), new PointF(rect.centerX(), (f18 + fontMetrics.descent) - fontMetrics.ascent)};
            strArr = strArr2;
        }
        if (strokePaint != null) {
            strokePaint.setTextSize(paint.getTextSize());
        }
        return new CompositeDrawTextParam(strArr, pointFArr, paint, strokePaint);
    }
}
