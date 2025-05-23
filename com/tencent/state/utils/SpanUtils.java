package com.tencent.state.utils;

import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/utils/SpanUtils;", "", "()V", "clickPosition", "", "parentTextView", "Landroid/widget/TextView;", "clickableSpan", "Landroid/text/style/ClickableSpan;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SpanUtils {
    public static final SpanUtils INSTANCE = new SpanUtils();

    SpanUtils() {
    }

    public final int[] clickPosition(TextView parentTextView, ClickableSpan clickableSpan) {
        Intrinsics.checkNotNullParameter(parentTextView, "parentTextView");
        Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
        Rect rect = new Rect();
        CharSequence text = parentTextView.getText();
        if (text != null) {
            SpannableString spannableString = (SpannableString) text;
            Layout layout = parentTextView.getLayout();
            double spanStart = spannableString.getSpanStart(clickableSpan);
            double spanEnd = spannableString.getSpanEnd(clickableSpan);
            int i3 = (int) spanStart;
            double primaryHorizontal = layout.getPrimaryHorizontal(i3);
            int i16 = (int) spanEnd;
            double primaryHorizontal2 = layout.getPrimaryHorizontal(i16);
            int lineForOffset = layout.getLineForOffset(i3);
            boolean z16 = lineForOffset != layout.getLineForOffset(i16);
            layout.getLineBounds(lineForOffset, rect);
            parentTextView.getLocationOnScreen(new int[]{0, 0});
            rect.top += r11;
            rect.bottom += r11;
            int compoundPaddingLeft = rect.left + ((int) (((r4[0] + primaryHorizontal) + parentTextView.getCompoundPaddingLeft()) - parentTextView.getScrollX()));
            rect.left = compoundPaddingLeft;
            int i17 = (int) ((compoundPaddingLeft + primaryHorizontal2) - primaryHorizontal);
            rect.right = i17;
            int i18 = (i17 + compoundPaddingLeft) / 2;
            int i19 = rect.top;
            if (!z16) {
                compoundPaddingLeft = i18;
            }
            return new int[]{compoundPaddingLeft, i19};
        }
        throw new NullPointerException("null cannot be cast to non-null type android.text.SpannableString");
    }
}
