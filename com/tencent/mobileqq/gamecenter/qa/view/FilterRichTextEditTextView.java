package com.tencent.mobileqq.gamecenter.qa.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes12.dex */
public class FilterRichTextEditTextView extends EditText {
    public FilterRichTextEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a(int i3) {
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        CharSequence text = ClipboardMonitor.getText(clipboardManager);
        if (text != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("Label", text.toString().replaceAll("\\{\\{pic:.*\\}\\}", "").replaceAll("\\{\\{video:.*\\}\\}", "").replaceAll("\\{\\{link:.*\\}\\}", "")));
        }
        return super.onTextContextMenuItem(i3);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if (i3 != 16908322 && i3 != 16908337) {
            return super.onTextContextMenuItem(i3);
        }
        return a(i3);
    }

    public FilterRichTextEditTextView(Context context) {
        super(context);
    }
}
