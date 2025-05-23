package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.parser.Patterns;
import java.util.regex.Matcher;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSImageSpanAndTextView extends QCircleAsyncTextView {
    private a E;
    private ImageSpan F;
    private ImageSpan G;
    private ClickableSpan H;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        int c();

        int d();
    }

    public QFSImageSpanAndTextView(Context context) {
        this(context, null);
    }

    private double h(CharSequence charSequence) {
        int i3;
        if (charSequence == null) {
            return 0.0d;
        }
        StringBuilder sb5 = new StringBuilder();
        Matcher matcher = Patterns.PATTERN_EMO.matcher(charSequence);
        int i16 = 0;
        int i17 = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (start >= 0 && end >= start && end <= charSequence.length()) {
                sb5.append(charSequence.subSequence(i16, start));
            }
            i17++;
            i16 = end;
        }
        if (i16 >= 0 && i16 <= charSequence.length()) {
            sb5.append(charSequence.subSequence(i16, charSequence.length()));
        }
        double ceil = Math.ceil(getPaint().measureText(sb5.toString()));
        RichTextPreloadParserInfo richTextPreloadParserInfo = this.mPreloadParserInfo;
        if (richTextPreloadParserInfo != null && richTextPreloadParserInfo.getConfig() != null && this.mPreloadParserInfo.getConfig().getImageSpanConfig() != null) {
            i3 = this.mPreloadParserInfo.getConfig().getImageSpanConfig().getIconSize();
        } else {
            i3 = 32;
        }
        double dip2px = ViewUtils.dip2px(i3);
        if (QLog.isDevelopLevel()) {
            QLog.d("QFSImageSpanAndTextView", 1, "[calculateTextWidthIncludeEmoji] originText:" + ((Object) charSequence) + ", plainText:" + sb5.toString() + ", emojiCount:" + i17 + ", iconSize:" + i3 + ", singleEmojiWidth:" + dip2px + ", plainTextWidth:" + ceil + ", totalEmojiWidth:" + (i17 * dip2px));
        }
        return ceil + (dip2px * i17);
    }

    private void i() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) new SpannableStringBuilder(getText()).getSpans(0, 1, ImageSpan.class);
        if (imageSpanArr.length == 0) {
            this.F = null;
        } else {
            this.F = imageSpanArr[0];
        }
    }

    private void j() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableStringBuilder.getSpans(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ClickableSpan.class);
        if (clickableSpanArr.length == 0) {
            this.H = null;
        } else {
            this.H = clickableSpanArr[0];
        }
    }

    private void k() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
        ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ImageSpan.class);
        if (imageSpanArr.length == 0) {
            this.G = null;
        } else {
            this.G = imageSpanArr[0];
        }
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    protected double getLastLineWidth(CharSequence charSequence) {
        return h(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public int getNeedCutWidth(ImageSpan[] imageSpanArr) {
        if (this.E == null) {
            return super.getNeedCutWidth(imageSpanArr);
        }
        if (getMaxLines() == 1) {
            return this.E.d() + this.E.c();
        }
        return this.E.c();
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView, android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == TextUtils.TruncateAt.END) {
            this.mIsEllipsizeEnd = true;
        } else {
            this.mIsEllipsizeEnd = false;
            super.setEllipsize(truncateAt);
        }
    }

    public void setImageSpanWidthDelegate(a aVar) {
        this.E = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public void setTextWhenShowEllipseView(SpannableStringBuilder spannableStringBuilder) {
        Spannable parserText = parserText(spannableStringBuilder);
        if (parserText != null) {
            ImageSpan imageSpan = this.G;
            if (imageSpan != null) {
                parserText.setSpan(imageSpan, parserText.length() - 1, parserText.length(), 33);
            }
            ClickableSpan clickableSpan = this.H;
            if (clickableSpan != null) {
                parserText.setSpan(clickableSpan, parserText.length() - 1, parserText.length(), 33);
            }
            ImageSpan imageSpan2 = this.F;
            if (imageSpan2 != null) {
                parserText.setSpan(imageSpan2, 0, 1, 33);
            }
        }
        setTextDirectly(parserText, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public CharSequence truncatedShowEndImageSpan(CharSequence charSequence) {
        i();
        k();
        j();
        return super.truncatedShowEndImageSpan(charSequence);
    }

    public QFSImageSpanAndTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public QFSImageSpanAndTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
