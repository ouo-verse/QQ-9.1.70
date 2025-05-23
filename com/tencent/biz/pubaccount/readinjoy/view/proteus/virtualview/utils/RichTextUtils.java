package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.RichTextParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RichTextUtils {
    private static final String TAG = "RichNativeText";
    private static final String ellipsis = "\u2026";

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class ClickSpan extends ClickableSpan {
        private String href;
        int textColor;

        public ClickSpan(String str, int i3) {
            this.href = str;
            this.textColor = i3;
        }

        private void doHyperLinkClick(View view, String str) {
            if (view instanceof NativeTextImp) {
                ((NativeTextImp) view).setHyperLinkClick(true);
            }
            CustomMethodsRegister.CustomMethodInterface customMethodInterface = CustomMethodsRegister.customMethodInterface;
            if (customMethodInterface != null) {
                customMethodInterface.invoke(CustomMethodsRegister.CMD_HYPER_LINK_CLICK, str, view);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            doHyperLinkClick(view, this.href);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.textColor);
            textPaint.setUnderlineText(false);
        }
    }

    public static void addClickSpan(TextView textView, SpannableStringBuilder spannableStringBuilder, String str, int i3, int i16, int i17) {
        spannableStringBuilder.setSpan(new ClickSpan(str, i3), i16, i17, 33);
        textView.setMovementMethod(a.getInstance());
    }

    public static void addEllipsis2Text(TextView textView, TruncateAttr truncateAttr) {
        addEllipsis2Text(textView, textView.getText(), truncateAttr);
    }

    public static void addFontSizeSpan(SpannableStringBuilder spannableStringBuilder, int i3, int i16, int i17) {
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i3), i16, i17, 33);
    }

    public static void addFontWeightSpan(SpannableStringBuilder spannableStringBuilder, String str, int i3, int i16) {
        if ("bold".equals(str)) {
            spannableStringBuilder.setSpan(new StyleSpan(1), i3, i16, 33);
        }
    }

    public static void addMore2Text(final TextView textView, final TruncateAttr truncateAttr) {
        if (textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                textView.getViewTreeObserver().removeOnPreDrawListener(this);
                RichTextUtils.addEllipsis2Text(textView, truncateAttr);
                return false;
            }
        });
    }

    private static void addMoreText(TextView textView, SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, int i3, TruncateAttr truncateAttr) {
        spannableStringBuilder.append(charSequence.subSequence(0, i3));
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append("\u2026").append((CharSequence) truncateAttr.text);
        addMoreTextSpan(textView, spannableStringBuilder, truncateAttr, length, spannableStringBuilder.length());
    }

    private static void addMoreTextSpan(TextView textView, SpannableStringBuilder spannableStringBuilder, TruncateAttr truncateAttr, int i3, int i16) {
        addClickSpan(textView, spannableStringBuilder, truncateAttr.href, truncateAttr.color, i3, i16);
        addFontSizeSpan(spannableStringBuilder, (int) (truncateAttr.fontSize * truncateAttr.nodeRatio), i3, i16);
        addFontWeightSpan(spannableStringBuilder, truncateAttr.fontWeight, i3, i16);
    }

    public static void addTagSpan(SpannableStringBuilder spannableStringBuilder, int i3, int i16, int i17, int i18, float f16, float f17, float f18, float f19, float f26, float f27) {
        spannableStringBuilder.setSpan(new b(i17, i18, f16, f17, f18, f19, f26, f27), i3, i16, 33);
    }

    public static void adjustImageSpan(TextView textView, TruncateAttr truncateAttr) {
        boolean z16 = true;
        if (textView.getLineCount() > 1) {
            z16 = false;
        }
        for (RichTextParser.CustomImageSpan customImageSpan : truncateAttr.imageSpans) {
            if (customImageSpan != null) {
                customImageSpan.isSingleLine = z16;
            }
        }
    }

    private static boolean isBeyondMaxLines(TextView textView, int i3, CharSequence charSequence, CharSequence charSequence2, int i16, int i17) {
        CharSequence subSequence = charSequence.subSequence(i16, i17);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(subSequence).append((CharSequence) "\u2026").append(charSequence2);
        textView.setText(spannableStringBuilder);
        if (textView.getLineCount() > i3) {
            return true;
        }
        return false;
    }

    private static void addEllipsis2Text(TextView textView, CharSequence charSequence, TruncateAttr truncateAttr) {
        try {
            int i3 = truncateAttr.maxLines;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(truncateAttr.text);
            addMoreTextSpan(textView, spannableStringBuilder, truncateAttr, 0, spannableStringBuilder.length());
            if (textView.getLineCount() > i3) {
                int lineEnd = textView.getLayout().getLineEnd(i3 - 1);
                if (isBeyondMaxLines(textView, i3, charSequence, spannableStringBuilder, 0, lineEnd)) {
                    while (isBeyondMaxLines(textView, i3, charSequence, spannableStringBuilder, 0, lineEnd)) {
                        lineEnd--;
                    }
                } else {
                    while (!isBeyondMaxLines(textView, i3, charSequence, spannableStringBuilder, 0, lineEnd)) {
                        lineEnd++;
                    }
                    lineEnd--;
                }
                spannableStringBuilder.clear();
                addMoreText(textView, spannableStringBuilder, charSequence, lineEnd, truncateAttr);
                textView.setText(spannableStringBuilder);
            }
        } catch (Exception e16) {
            LogUtil.QLog.e(TAG, 1, "getBlockText error! msg=" + e16);
        }
    }
}
