package com.tencent.guild.aio.input.at.hashtag.ui;

import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J,\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/input/at/hashtag/ui/l;", "", "Landroid/widget/TextView;", "textView", "Landroid/text/Spanned;", "spannable", "Landroid/view/MotionEvent;", "event", "Landroid/text/style/ClickableSpan;", "b", "", HippyTKDListViewAdapter.X, "y", "Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "", "charSequence", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f110969a = new l();

    l() {
    }

    @Nullable
    public final ClickableSpan a(int x16, int y16, @Nullable Layout layout, @Nullable CharSequence charSequence) {
        boolean z16;
        ClickableSpan[] clickableSpanArr;
        boolean z17;
        if (layout == null || charSequence == null || !(charSequence instanceof Spanned)) {
            return null;
        }
        int lineForVertical = layout.getLineForVertical(y16);
        Spanned spanned = (Spanned) charSequence;
        c[] cVarArr = (c[]) spanned.getSpans(layout.getLineStart(lineForVertical), layout.getLineEnd(lineForVertical), c.class);
        if (cVarArr != null) {
            if (cVarArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (c cVar : cVarArr) {
                    RectF mTextBackgroundRectF = cVar.getMTextBackgroundRectF();
                    float f16 = x16;
                    if (f16 >= mTextBackgroundRectF.left && f16 <= mTextBackgroundRectF.right && (clickableSpanArr = (ClickableSpan[]) spanned.getSpans(spanned.getSpanStart(cVar), spanned.getSpanEnd(cVar), ClickableSpan.class)) != null) {
                        if (clickableSpanArr.length == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            return clickableSpanArr[0];
                        }
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public final ClickableSpan b(@NotNull TextView textView, @NotNull Spanned spannable, @NotNull MotionEvent event) {
        boolean z16;
        ClickableSpan clickableSpan;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(event, "event");
        int x16 = (int) event.getX();
        int y16 = (int) event.getY();
        int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y16 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        ClickableSpan a16 = a(scrollX, scrollY, textView.getLayout(), textView.getText());
        if (a16 != null) {
            return a16;
        }
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        float f16 = scrollX;
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f16);
        if (f16 - layout.getSecondaryHorizontal(offsetForHorizontal) > textView.getTextSize()) {
            return null;
        }
        ClickableSpan[] link = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        Intrinsics.checkNotNullExpressionValue(link, "link");
        if (link.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            clickableSpan = link[0];
        } else {
            QLog.w("LinkTouchUtils", 1, "span is null, line=" + lineForVertical + " off=" + offsetForHorizontal + " x=" + scrollX);
            clickableSpan = null;
        }
        if (clickableSpan instanceof b) {
            return null;
        }
        return clickableSpan;
    }
}
