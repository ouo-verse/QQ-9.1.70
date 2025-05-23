package com.tencent.gamematrix.gmcg.sdk.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.base.utils.CGDisplayUtil;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes6.dex */
public class GmCgExtraOverlayView extends TextView {
    public GmCgExtraOverlayView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        int dip2px = CGDisplayUtil.dip2px(context, 5.0f);
        setPadding(dip2px, dip2px, dip2px, dip2px);
        setBackgroundColor(Color.parseColor("#3f000000"));
        setTextColor(Color.parseColor("#f1f1f1"));
        setTextSize(1, 10.0f);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public GmCgExtraOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public GmCgExtraOverlayView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
