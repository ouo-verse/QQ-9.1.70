package com.tencent.mobileqq.guild.quicksearch.adapter;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J(\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J,\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001b\u001a\u00020\u0004R\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/adapter/h;", "", "Landroid/widget/TextView;", "textView", "", "singleLineWidth", "", "text", "", tl.h.F, "start", "end", "textWidth", "g", "", "", "highlightWords", "c", "Landroid/view/MotionEvent;", "event", "tv", "b", "Landroid/text/TextPaint;", "paint", NodeProps.MAX_WIDTH, "maxLines", "e", "maxWidthInSingleLine", "f", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnTouchListener;", "d", "()Landroid/view/View$OnTouchListener;", "contentClickListener", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f231570a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final View.OnTouchListener contentClickListener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/adapter/h$a", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "tv", "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "d", "J", "getStartTime", "()J", "setStartTime", "(J)V", "startTime", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long startTime;

        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(@NotNull View tv5, @NotNull MotionEvent event) {
            boolean z16;
            boolean z17;
            boolean z18;
            Intrinsics.checkNotNullParameter(tv5, "tv");
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            TextView textView = (TextView) tv5;
            int b16 = h.f231570a.b(event, textView);
            CharSequence text = textView.getText();
            if (action == 0 && (text instanceof SpannedString)) {
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((SpannedString) text).getSpans(b16, b16, ClickableSpan.class);
                if (clickableSpanArr != null) {
                    if (clickableSpanArr.length == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        z17 = true;
                        if (z17) {
                            this.startTime = System.currentTimeMillis();
                            return true;
                        }
                    }
                }
                z17 = false;
                if (z17) {
                }
            }
            if (!(text instanceof SpannedString) || action != 1 || System.currentTimeMillis() - this.startTime > 300) {
                return false;
            }
            Object[] spans = ((SpannedString) text).getSpans(b16, b16, ClickableSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(\n         \u2026ava\n                    )");
            ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spans;
            if (clickableSpanArr2.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                clickableSpanArr2[0].onClick(tv5);
                return true;
            }
            return false;
        }
    }

    h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(MotionEvent event, TextView tv5) {
        int x16 = (int) event.getX();
        int y16 = (int) event.getY();
        int totalPaddingLeft = x16 - tv5.getTotalPaddingLeft();
        int totalPaddingTop = y16 - tv5.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + tv5.getScrollX();
        int scrollY = totalPaddingTop + tv5.getScrollY();
        Layout layout = tv5.getLayout();
        return layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.indexOf$default(r8, r9.next(), 0, true, 2, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int c(CharSequence text, List<String> highlightWords) {
        Iterator<String> it = highlightWords.iterator();
        int i3 = -1;
        while (it.hasNext() && i3 < 0) {
        }
        return i3;
    }

    private final int e(TextPaint paint, String text, int maxWidth, int maxLines) {
        StaticLayout build = StaticLayout.Builder.obtain(text, 0, text.length(), paint, maxWidth).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).setMaxLines(maxLines).build();
        Intrinsics.checkNotNullExpressionValue(build, "if (Build.VERSION.SDK_IN\u2026, 1f, 0f, true)\n        }");
        return build.getLineCount();
    }

    private final void g(TextView textView, CharSequence text, int start, int end, int textWidth) {
        SpannableStringBuilder spannableStringBuilder;
        if (start < end && start >= 0 && end <= text.length()) {
            String string = textView.getResources().getString(R.string.f152531_n);
            Intrinsics.checkNotNullExpressionValue(string, "textView.resources.getSt\u2026ild_quick_search_ellipse)");
            TextPaint paint = textView.getPaint();
            int i3 = start + 1;
            CharSequence subSequence = text.subSequence(start, i3);
            while (true) {
                Intrinsics.checkNotNullExpressionValue(paint, "paint");
                if (e(paint, string + ((Object) text.subSequence(start, i3)) + string, textWidth, textView.getMaxLines()) > textView.getMaxLines() || i3 >= end) {
                    break;
                }
                subSequence = text.subSequence(start, i3);
                i3++;
            }
            int i16 = 0;
            while (true) {
                if (e(paint, string + ((Object) text.subSequence(start, i3)) + string, textWidth, textView.getMaxLines()) > textView.getMaxLines()) {
                    break;
                }
                subSequence = text.subSequence(start, i3);
                if (i16 % 2 == 0) {
                    if (start > 0) {
                        start--;
                    } else {
                        start = 0;
                    }
                } else if (i3 < text.length()) {
                    i3++;
                } else {
                    i3 = text.length();
                }
                i16++;
                if (start == 0 && i3 == text.length()) {
                    break;
                }
            }
            Unit unit = null;
            if (subSequence instanceof SpannableStringBuilder) {
                spannableStringBuilder = (SpannableStringBuilder) subSequence;
            } else {
                spannableStringBuilder = null;
            }
            if (spannableStringBuilder != null) {
                spannableStringBuilder.insert(0, (CharSequence) string);
                spannableStringBuilder.append((CharSequence) string);
                textView.setText(spannableStringBuilder);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                textView.setText(string + ((Object) subSequence) + string);
            }
        }
    }

    private final void h(TextView textView, int singleLineWidth, CharSequence text) {
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtils.isEmpty(text)) {
            textView.setText("");
            return;
        }
        String string = textView.getResources().getString(R.string.f152531_n);
        Intrinsics.checkNotNullExpressionValue(string, "textView.resources.getSt\u2026ild_quick_search_ellipse)");
        TextPaint paint = textView.getPaint();
        int length = text.length() - 1;
        CharSequence subSequence = text.subSequence(length, text.length());
        while (length >= 0) {
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            if (e(paint, string + ((Object) text.subSequence(length, text.length())), singleLineWidth, textView.getMaxLines()) > textView.getMaxLines()) {
                break;
            }
            subSequence = text.subSequence(length, text.length());
            length--;
        }
        Unit unit = null;
        if (subSequence instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) subSequence;
        } else {
            spannableStringBuilder = null;
        }
        if (spannableStringBuilder != null) {
            textView.setText(spannableStringBuilder.insert(0, (CharSequence) string));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            textView.setText(string + ((Object) subSequence));
        }
    }

    @NotNull
    public final View.OnTouchListener d() {
        return contentClickListener;
    }

    public final void f(@NotNull TextView textView, @NotNull CharSequence text, @NotNull List<String> highlightWords, int maxWidthInSingleLine) {
        int coerceAtLeast;
        CharSequence subSequence;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(highlightWords, "highlightWords");
        String string = textView.getResources().getString(R.string.f152531_n);
        Intrinsics.checkNotNullExpressionValue(string, "textView.resources.getSt\u2026ild_quick_search_ellipse)");
        int c16 = c(text, highlightWords);
        if (c16 < 0) {
            textView.setText(text);
            return;
        }
        int length = c16 + highlightWords.get(0).length();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(QQGuildUIUtil.f(300.0f), maxWidthInSingleLine);
        TextPaint paint = textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        if (e(paint, text.toString(), coerceAtLeast, textView.getMaxLines()) <= textView.getMaxLines()) {
            textView.setText(text);
            return;
        }
        if (length > text.length()) {
            subSequence = text;
        } else {
            subSequence = text.subSequence(0, length);
        }
        if (e(paint, ((Object) subSequence) + string, coerceAtLeast, textView.getMaxLines()) <= textView.getMaxLines()) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(text);
            return;
        }
        if (e(paint, string + ((Object) text.subSequence(c16, text.length())), coerceAtLeast, textView.getMaxLines()) <= textView.getMaxLines()) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
            h(textView, coerceAtLeast, text);
        } else {
            g(textView, text, c16, length, coerceAtLeast);
        }
    }
}
