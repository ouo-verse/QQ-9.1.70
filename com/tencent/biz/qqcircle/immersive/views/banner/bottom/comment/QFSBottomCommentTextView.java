package com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomCommentTextView extends QCircleAsyncTextView {
    public QFSBottomCommentTextView(Context context) {
        super(context);
    }

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    protected CharSequence addDotTextAndLastImageSpan(CharSequence charSequence, ImageSpan[] imageSpanArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.append((CharSequence) MiniBoxNoticeInfo.APPNAME_SUFFIX);
        return spannableStringBuilder;
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

    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    @RequiresApi(api = 16)
    protected void showEllipseView() {
        SpannableStringBuilder addFrontText;
        if (this.mIsEllipsizeEnd && getLayout() != null && getMaxLines() > 0) {
            int maxLines = getMaxLines() - 1;
            int lineStart = getLayout().getLineStart(maxLines);
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int lineWidth = (((int) getLayout().getLineWidth(maxLines)) - getPaddingLeft()) - getPaddingRight();
            ensureInitDotTextWidth();
            if (width <= lineWidth + this.mDotTextWidth) {
                addFrontText = new SpannableStringBuilder(cutLastLineEndDot(TextUtils.ellipsize(new SpannableStringBuilder(getText()), getPaint(), width, TextUtils.TruncateAt.END)));
                addFrontText.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            } else {
                addFrontText = addFrontText(lineStart, charSequence2SpannableStringBuilder(TextUtils.ellipsize(new SpannableStringBuilder(getText()).subSequence(lineStart, getText().length()), getPaint(), width, TextUtils.TruncateAt.END)), getText());
            }
            setTextWhenShowEllipseView(addFrontText);
            RFWLog.d("QFSBottomCommentTextView", RFWLog.USR, "[showEllipseView]  stringBuilder: " + ((Object) addFrontText) + " | lastLineIndex: " + maxLines + " | startOfLastLine: " + lineStart + " | width: " + width + " | lastLineWidth: " + lineWidth + " | mDotTextWidth: " + this.mDotTextWidth);
            RFWAsyncRichTextView.OnTriggerEllipseListener onTriggerEllipseListener = this.mOnTriggerEllipseListener;
            if (onTriggerEllipseListener != null) {
                onTriggerEllipseListener.triggerEllipse();
            }
        }
    }

    public QFSBottomCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSBottomCommentTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
