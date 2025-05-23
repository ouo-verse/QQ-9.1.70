package com.tencent.mobileqq.aio.utils;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ay {
    static IPatchRedirector $redirector_;

    @RequiresApi(api = 23)
    private static StaticLayout a(TextView textView, int i3) {
        int maxLines;
        int justificationMode;
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(textView.getText(), 0, textView.getText().length(), textView.getPaint(), i3).setAlignment(Layout.Alignment.ALIGN_NORMAL).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
        if (textView.getMaxLines() == -1) {
            maxLines = Integer.MAX_VALUE;
        } else {
            maxLines = textView.getMaxLines();
        }
        StaticLayout.Builder maxLines2 = hyphenationFrequency.setMaxLines(maxLines);
        if (Build.VERSION.SDK_INT >= 26) {
            justificationMode = textView.getJustificationMode();
            maxLines2.setJustificationMode(justificationMode);
        }
        if (textView.getEllipsize() != null && textView.getKeyListener() == null) {
            maxLines2.setEllipsize(textView.getEllipsize()).setEllipsizedWidth(i3);
        }
        return maxLines2.build();
    }

    public static int b(TextView textView, int i3) {
        int lineCount = a(textView, (i3 - textView.getCompoundPaddingLeft()) - textView.getCompoundPaddingRight()).getLineCount();
        int maxLines = textView.getMaxLines();
        if (maxLines > lineCount) {
            return lineCount;
        }
        return maxLines;
    }
}
