package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0014J\b\u0010\u0016\u001a\u00020\u0004H\u0014R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/FeedRichTextView;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/GestureTextView;", "", "widthSize", "", "P", "lineIndex", "Landroid/text/SpannableStringBuilder;", "textSpan", "L", "lastCharPos", "", "M", "O", "", "c", "N", "setCheckItalicText", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "a0", "Z", "checkItalicText", "b0", "textSelectableOnDetach", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "c0", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedRichTextView extends GestureTextView {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean checkItalicText;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean textSelectableOnDetach;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedRichTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int L(int lineIndex, SpannableStringBuilder textSpan) {
        Character orNull;
        int lineEnd = getLayout().getLineEnd(lineIndex) - 1;
        orNull = StringsKt___StringsKt.getOrNull(textSpan, lineEnd);
        if (orNull != null && orNull.charValue() == '\n') {
            return lineEnd - 1;
        }
        return lineEnd;
    }

    private final boolean M(SpannableStringBuilder textSpan, int lastCharPos) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (getLayout().getAlignment() == Layout.Alignment.ALIGN_OPPOSITE) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object[] spans = textSpan.getSpans(lastCharPos, lastCharPos + 1, AlignmentSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        AlignmentSpan[] alignmentSpanArr = (AlignmentSpan[]) spans;
        if (alignmentSpanArr.length == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((!z17) && alignmentSpanArr[0].getAlignment() == Layout.Alignment.ALIGN_OPPOSITE) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z16 && !z18) {
            return false;
        }
        return true;
    }

    private final boolean N(char c16) {
        if ('\u4e00' > c16 || c16 >= '\u9fbc') {
            return false;
        }
        return true;
    }

    private final boolean O(SpannableStringBuilder textSpan, int lastCharPos) {
        Character orNull;
        boolean z16;
        orNull = StringsKt___StringsKt.getOrNull(textSpan, lastCharPos);
        if (orNull == null || !N(orNull.charValue())) {
            return false;
        }
        Object[] spans = textSpan.getSpans(lastCharPos, lastCharPos + 1, StyleSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        StyleSpan[] styleSpanArr = (StyleSpan[]) spans;
        if (styleSpanArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16) || (styleSpanArr[0].getStyle() & 2) == 0) {
            return false;
        }
        return true;
    }

    private final void P(int widthSize) {
        boolean z16;
        boolean z17;
        List list;
        try {
            SpannableStringBuilder textSpan = new SpannableStringBuilder().append(getText());
            int lineCount = getLayout().getLineCount();
            boolean z18 = false;
            for (int i3 = 0; i3 < lineCount; i3++) {
                Intrinsics.checkNotNullExpressionValue(textSpan, "textSpan");
                int L = L(i3, textSpan);
                float lineWidth = getLayout().getLineWidth(i3);
                float f16 = widthSize;
                if (lineWidth >= f16 - getPaint().getTextSize()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (f16 - lineWidth > 5.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                boolean M = M(textSpan, L);
                boolean O = O(textSpan, L);
                if ((M || z16) && O && z17) {
                    QLog.i("FeedRichTextView", 1, "Adding ItalicSpan. lastCharPos: " + L + ", maxWidth: " + widthSize + ", lineWidth: " + lineWidth + ", isFullLine: " + z16 + ", isAlignToRight: " + M);
                    int i16 = L + 1;
                    Object[] spans = textSpan.getSpans(L, i16, CharacterStyle.class);
                    Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
                    list = ArraysKt___ArraysKt.toList((CharacterStyle[]) spans);
                    textSpan.setSpan(new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.a(list), L, i16, 33);
                    z18 = true;
                }
            }
            this.checkItalicText = false;
            if (z18) {
                setText(textSpan);
            }
        } catch (Exception e16) {
            QLog.i("FeedRichTextView", 1, "replaceLineEndItalic exception: " + e16.getMessage());
            this.checkItalicText = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.GestureTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.textSelectableOnDetach) {
            try {
                if (!(getText() instanceof Spannable)) {
                    setText(getText(), TextView.BufferType.SPANNABLE);
                }
                setTextIsSelectable(true);
                QLog.i("FeedRichTextView", 1, "[onAttachedToWindow] isTextSelectable: " + isTextSelectable());
            } catch (Exception e16) {
                QLog.e("FeedRichTextView", 1, "[onAttachedToWindow] exception " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.GestureTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isTextSelectable()) {
            try {
                this.textSelectableOnDetach = true;
                setTextIsSelectable(false);
                QLog.i("FeedRichTextView", 1, "[onDetachedFromWindow] isTextSelectable: " + isTextSelectable());
            } catch (Exception e16) {
                QLog.e("FeedRichTextView", 1, "[onDetachedFromWindow] exception " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.checkItalicText) {
            P(View.MeasureSpec.getSize(widthMeasureSpec));
        }
    }

    public final void setCheckItalicText() {
        this.checkItalicText = true;
    }
}
