package com.tencent.ad.tangram.views.canvas.components.keyelements;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAutoLayoutTextView extends TextView {
    public static final String FINAL_TEXT = "\u6743\u9650\u8be6\u60c5 | \u9690\u79c1\u534f\u8bae";
    private static final String MAX_APP_NAME = "\u5e94\u7528\u540d\u79f0:\u6700\u957f25\u4e2a\u5b57\u6700\u957f25\u4e2a\u5b57\u6700\u957f25\u4e2a\u5b57\u6700\u957f25\u4e2a\u5b57\u6700\u957f25\u4e2a\u5b57";
    private static final String TAG = "AdAutoLayoutTextView";
    private boolean ended;
    private boolean marked;

    public AdAutoLayoutTextView(Context context) {
        super(context);
        init(context);
    }

    @Nullable
    private String formatString(@NonNull String str, String str2, String str3) {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (str.length() > 35) {
                str4 = str.substring(0, 35) + APLogFileUtil.SEPARATOR_LOG;
            } else {
                str4 = str + APLogFileUtil.SEPARATOR_LOG;
            }
            return str4 + (str2 + APLogFileUtil.SEPARATOR_LOG) + (str3 + APLogFileUtil.SEPARATOR_LOG);
        }
        return null;
    }

    private void init(Context context) {
        setTextSize(0, 24.0f);
        setPadding(AdUIUtils.getValueDependsOnScreenWidth(context, 750, 20), AdUIUtils.getValueDependsOnScreenWidth(context, 750, 9), AdUIUtils.getValueDependsOnScreenWidth(context, 750, 20), AdUIUtils.getValueDependsOnScreenWidth(context, 750, 9));
        setGravity(17);
        setSingleLine(false);
        setMaxLines(3);
        if (Build.VERSION.SDK_INT >= 26) {
            setAutoSizeTextTypeWithDefaults(1);
            setAutoSizeTextTypeUniformWithConfiguration(1, 24, 1, 0);
        }
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.ad.tangram.views.canvas.components.keyelements.AdAutoLayoutTextView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                int lineCount = AdAutoLayoutTextView.this.getLineCount();
                AdLog.d(AdAutoLayoutTextView.TAG, "onPreDraw :line " + lineCount + " mask:" + AdAutoLayoutTextView.this.marked);
                if (lineCount == 1) {
                    AdAutoLayoutTextView.this.setTextWithSpan(((Object) AdAutoLayoutTextView.this.getText()) + "\n" + AdAutoLayoutTextView.FINAL_TEXT);
                    return false;
                }
                if (lineCount == 2) {
                    if (!AdAutoLayoutTextView.this.getText().toString().contains(AdAutoLayoutTextView.FINAL_TEXT)) {
                        AdAutoLayoutTextView.this.marked = true;
                        AdAutoLayoutTextView.this.setTextWithSpan(((Object) AdAutoLayoutTextView.this.getText()) + AdAutoLayoutTextView.FINAL_TEXT);
                        return false;
                    }
                    return true;
                }
                if (lineCount == 3) {
                    if (AdAutoLayoutTextView.this.marked) {
                        AdAutoLayoutTextView.this.setTextWithSpan(AdAutoLayoutTextView.this.getText().toString().substring(0, (r0.length() - 11) - 3) + " | \n" + AdAutoLayoutTextView.FINAL_TEXT);
                        AdAutoLayoutTextView.this.marked = false;
                        AdAutoLayoutTextView.this.ended = true;
                        return false;
                    }
                    if (!AdAutoLayoutTextView.this.ended) {
                        AdAutoLayoutTextView.this.setTextWithSpan(AdAutoLayoutTextView.this.getText().toString().substring(0, (r0.length() - 11) - 3));
                        return false;
                    }
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextWithSpan(@NonNull CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-16776961), charSequence.length() - 11, charSequence.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF7A8499")), 0, charSequence.length() - 11, 33);
        setText(spannableStringBuilder);
    }

    public void setTextContent(@NonNull String str, String str2, String str3) {
        String formatString = formatString(str, str2, str3);
        if (TextUtils.isEmpty(formatString)) {
            return;
        }
        setText(formatString);
    }

    public AdAutoLayoutTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AdAutoLayoutTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
