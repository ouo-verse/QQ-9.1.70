package com.tencent.biz.qqcircle.immersive.views.search.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.richframework.text.rich.parser.Patterns;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.regex.Matcher;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchCommentAsyncTextView extends QCircleAsyncTextView {
    private int E;
    private int F;

    public QFSSearchCommentAsyncTextView(Context context) {
        super(context);
    }

    private CharSequence h(CharSequence charSequence, ImageSpan[] imageSpanArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (imageSpanArr.length > 0) {
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.setSpan(imageSpanArr[0], spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    private SpannableStringBuilder i(SpannableStringBuilder spannableStringBuilder) {
        BoldClickableSpan[] boldClickableSpanArr = (BoldClickableSpan[]) spannableStringBuilder.getSpans(this.E, this.F, BoldClickableSpan.class);
        if (boldClickableSpanArr.length == 0) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder.subSequence(this.E, this.F));
        spannableStringBuilder2.setSpan(boldClickableSpanArr[0], 0, spannableStringBuilder2.length(), 33);
        return spannableStringBuilder2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public CharSequence cutLastLineEndDot(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        if (charSequence.toString().endsWith("\u2026")) {
            if (charSequence.length() <= 0) {
                charSequence = "";
            } else {
                charSequence = charSequence.subSequence(0, charSequence.length() - 1);
            }
        }
        ensureInitDotTextWidth();
        ensureInitSysDotTextWidth();
        return charSequence;
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    protected CharSequence cutTextForNeedCutWidth(CharSequence charSequence, int i3, int i16, int i17) {
        float textSize = getTextSize();
        int i18 = 0;
        while (i17 < i3) {
            if (charSequence.toString().endsWith(QzoneEmotionUtils.EMO_TAIL)) {
                Matcher matcher = Patterns.PATTERN_EMO.matcher(charSequence);
                while (true) {
                    if (!matcher.find()) {
                        break;
                    }
                    int start = matcher.start();
                    int end = matcher.end();
                    if (start < i16 && end == i16) {
                        i17 = (int) (i17 + textSize);
                        i16 = start;
                        break;
                    }
                }
            } else if (i16 > 0) {
                i17 += (int) Math.floor(getPaint().measureText(charSequence.subSequence(i16 - 1, i16).toString()));
                i16--;
            }
            if (i16 >= 0) {
                charSequence = charSequence.subSequence(0, i16);
            }
            i18++;
            if (i18 > 1000) {
                break;
            }
        }
        return charSequence;
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    protected CharSequence fixMultiLineEndImageSpan(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        if (!TextUtils.isEmpty(charSequence2) && charSequence2.contains("\n")) {
            return charSequence2.substring(0, charSequence2.indexOf("\n"));
        }
        return charSequence;
    }

    public void j(int i3, int i16) {
        this.E = i3;
        this.F = i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public CharSequence truncatedShowEndImageSpan(CharSequence charSequence) {
        CharSequence fixMultiLineEndImageSpan = fixMultiLineEndImageSpan(charSequence);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
        ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ImageSpan.class);
        SpannableStringBuilder i3 = i(spannableStringBuilder);
        int needCutWidth = (int) (getNeedCutWidth(imageSpanArr) + Math.ceil(getPaint().measureText(i3.toString())));
        if (needCutWidth > 0) {
            CharSequence cutLastLineEndDot = cutLastLineEndDot(fixMultiLineEndImageSpan);
            int a16 = needCutWidth + ((int) (this.mDotTextWidth - this.mSysDotTextWidth)) + cx.a(5.0f);
            int length = cutLastLineEndDot.length();
            double ceil = Math.ceil(getPaint().measureText(cutLastLineEndDot.toString()));
            int width = (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - ceil);
            QLog.i("QFSSearchCommentAsyncTextView", 1, "nowFreeWidth = " + width + " , needCutWidth = " + a16 + " , nowStringLength = " + ceil + " , lastLine = " + ((Object) cutLastLineEndDot));
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(cutTextForNeedCutWidth(cutLastLineEndDot, a16, length, width));
            spannableStringBuilder2.append((CharSequence) MiniBoxNoticeInfo.APPNAME_SUFFIX);
            spannableStringBuilder2.append((CharSequence) i3);
            return h(spannableStringBuilder2, imageSpanArr);
        }
        return fixMultiLineEndImageSpan;
    }

    public QFSSearchCommentAsyncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSearchCommentAsyncTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
