package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils;

import android.content.Context;
import android.graphics.Point;
import android.text.DynamicLayout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.TextInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a&\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b\u001a\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b\u00a8\u0006\u0013"}, d2 = {"", "text", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/anim/o;", "b", "Landroid/text/SpannableString;", "a", "", "sizeType", "imageWidth", "imageHeight", "Landroid/graphics/Point;", "f", "d", "e", "width", "height", "c", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {
    private static final SpannableString a(Context context) {
        SpannableString spannableString = new SpannableString("\u67e5\u770b\u5168\u90e8");
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.qui_common_text_link)), 0, spannableString.length(), 17);
        return spannableString;
    }

    public static final TextInfo b(String text, Context context) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(context, "context");
        QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(text, 16);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setBreakStrategy(0);
        textView.setTextSize(0, com.tencent.mobileqq.utils.ViewUtils.spToPx(16.0f));
        textView.setPadding(textView.getResources().getDimensionPixelSize(R.dimen.f104928), 0, textView.getResources().getDimensionPixelSize(R.dimen.f104827), 0);
        try {
            int dimensionPixelSize = (context.getResources().getDisplayMetrics().widthPixels - context.getResources().getDimensionPixelSize(R.dimen.f104928)) - context.getResources().getDimensionPixelSize(R.dimen.f104827);
            DynamicLayout f16 = o.f(textView, text, dimensionPixelSize);
            if (f16.getLineCount() <= 8) {
                return new TextInfo(text.length() > 0 ? f16.getHeight() : 0, dimensionPixelSize, qQText);
            }
            int lineEnd = f16.getLineEnd(7) - 6;
            String substring = text.substring(0, lineEnd);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            SpannableStringBuilder result = new SpannableStringBuilder(substring).append((CharSequence) "... ").append((CharSequence) a(context));
            Intrinsics.checkNotNullExpressionValue(result, "result");
            DynamicLayout f17 = o.f(textView, result, dimensionPixelSize);
            while (f17.getLineCount() > 8) {
                lineEnd--;
                String substring2 = text.substring(0, lineEnd);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                result.clear();
                result.append((CharSequence) substring2).append((CharSequence) "... ").append((CharSequence) a(context));
                f17 = o.f(textView, result, dimensionPixelSize);
            }
            return new TextInfo(f17.getHeight(), dimensionPixelSize, result);
        } catch (Exception e16) {
            QLog.e("FeedViewUtil", 1, "getFoldText error ", e16);
            return new TextInfo(0, 0, qQText);
        }
    }

    public static final int c(Context context, int i3, int i16) {
        Intrinsics.checkNotNullParameter(context, "context");
        int e16 = e(context);
        if (i3 < e16 && i16 < e16) {
            return 4;
        }
        if (i3 / i16 >= 3) {
            return 2;
        }
        return i16 / i3 >= 3 ? 3 : 1;
    }

    private static final int d(Context context) {
        return (context.getResources().getDisplayMetrics().widthPixels - context.getResources().getDimensionPixelSize(R.dimen.f104928)) - context.getResources().getDimensionPixelSize(R.dimen.f104827);
    }

    private static final int e(Context context) {
        return (int) (d(context) * 0.42f);
    }

    public static final Point f(Context context, int i3, int i16, int i17) {
        int coerceAtLeast;
        int coerceAtLeast2;
        Intrinsics.checkNotNullParameter(context, "context");
        int d16 = d(context);
        int e16 = e(context);
        if (i3 == 2) {
            return new Point(d16, e16);
        }
        if (i3 == 3) {
            return new Point(e16, d16);
        }
        if (i3 == 4) {
            return new Point(e16, e16);
        }
        if (i16 >= i17) {
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast((i17 * d16) / i16, e16);
            return new Point(d16, coerceAtLeast2);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((i16 * d16) / i17, e16);
        return new Point(coerceAtLeast, d16);
    }
}
