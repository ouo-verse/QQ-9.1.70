package com.tencent.biz.qqcircle.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBannerRoundCorneredFrameLayout extends RoundCorneredFrameLayout {
    private a C;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        boolean f(View view, MotionEvent motionEvent);
    }

    public QFSBannerRoundCorneredFrameLayout(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getActionMasked() == 0 && (aVar = this.C) != null && aVar.f(this, motionEvent)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setChildTouchEventDelegate(a aVar) {
        this.C = aVar;
    }

    public QFSBannerRoundCorneredFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
