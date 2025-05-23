package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: classes5.dex */
public class QFSPressEffectMaskImageView extends ImageView {
    public QFSPressEffectMaskImageView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
    
        if (r0 != 3) goto L16;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() && isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                setAlpha(1.0f);
                return super.onTouchEvent(motionEvent);
            }
            setAlpha(0.85f);
            super.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public QFSPressEffectMaskImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPressEffectMaskImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
