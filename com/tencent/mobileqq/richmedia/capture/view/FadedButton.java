package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.util.StateSet;
import android.widget.Button;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FadedButton extends Button {
    public FadedButton(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (StateSet.stateSetMatches(Button.PRESSED_WINDOW_FOCUSED_STATE_SET, getDrawableState())) {
            setAlpha(0.25882354f);
        } else {
            setAlpha(1.0f);
        }
    }
}
