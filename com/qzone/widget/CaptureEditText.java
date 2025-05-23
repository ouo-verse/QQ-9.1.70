package com.qzone.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.text.QQTextBuilder;

/* compiled from: P */
/* loaded from: classes37.dex */
public class CaptureEditText extends ExtendEditText {
    private EmoEditPanel Q;

    public CaptureEditText(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (getText() instanceof QQTextBuilder) {
            QQTextBuilder qQTextBuilder = (QQTextBuilder) getText();
            if (qQTextBuilder != null && !TextUtils.isEmpty(qQTextBuilder.toPlainText())) {
                accessibilityNodeInfo.setText(qQTextBuilder.toPlainText());
                accessibilityNodeInfo.setContentDescription(qQTextBuilder.toPlainText());
            } else {
                if (TextUtils.isEmpty(getHint())) {
                    return;
                }
                accessibilityNodeInfo.setText(getHint());
                accessibilityNodeInfo.setContentDescription(getHint());
            }
        }
    }

    public void setContainer(EmoEditPanel emoEditPanel) {
        this.Q = emoEditPanel;
    }

    public CaptureEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.qzone.widget.ExtendEditText, android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && this.Q != null && keyEvent.getAction() == 0) {
            if (!this.Q.t1() && this.Q.q1()) {
                this.Q.Y0(false, false);
                return true;
            }
            if (this.Q.t1()) {
                this.Q.a1();
                return true;
            }
        }
        return super.onKeyPreIme(i3, keyEvent);
    }
}
