package com.tencent.mobileqq.qqexpand.flutter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandFlutterFrameLayout extends FrameLayout {
    public ExpandFlutterFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public ExpandFlutterFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandFlutterFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
