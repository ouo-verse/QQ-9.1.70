package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;

/* loaded from: classes5.dex */
public class QCircleBasePolymerizationHeadView extends QCircleBaseWidgetView {

    /* loaded from: classes5.dex */
    private static class BoldStyleSpan extends StyleSpan {
        @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setFakeBoldText(true);
        }
    }

    public QCircleBasePolymerizationHeadView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleBasePolymerizationHeadView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SpannableStringBuilder k0(List<FeedCloudCommon$Entry> list) {
        if (list != null && list.size() != 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = list.get(i3);
                if (i3 != 0) {
                    spannableStringBuilder.append((CharSequence) "  /  ");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary)), spannableStringBuilder.length() - 5, spannableStringBuilder.length(), 17);
                }
                spannableStringBuilder.append((CharSequence) feedCloudCommon$Entry.value.get());
                spannableStringBuilder.append((CharSequence) feedCloudCommon$Entry.key.get());
            }
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
