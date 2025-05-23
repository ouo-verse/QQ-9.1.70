package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ml.t;
import com.tencent.luggage.wxa.uk.n0;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppBrandDialogContentView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f152370a;

    /* renamed from: b, reason: collision with root package name */
    public MotionEvent f152371b;

    public AppBrandDialogContentView(@NonNull Context context) {
        super(context);
        this.f152370a = new int[]{0, 0};
        this.f152371b = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r0 != 6) goto L16;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1 && action != 3) {
                    if (action != 5) {
                    }
                }
                this.f152371b = null;
            }
            this.f152371b = MotionEvent.obtain(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public MotionEvent getLastPointerDownTouchEvent() {
        return this.f152371b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        Context context = getContext();
        if (!n0.a(context) && context.getResources().getConfiguration().orientation != 2) {
            super.onMeasure(i3, i16);
            return;
        }
        this.f152370a[0] = View.MeasureSpec.getSize(i3);
        this.f152370a[1] = View.MeasureSpec.getSize(i16);
        t.a(getContext(), this.f152370a, getContext().getResources().getDisplayMetrics());
        int[] iArr = this.f152370a;
        setMeasuredDimension(iArr[0], iArr[1]);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f152370a[0], View.MeasureSpec.getMode(i3)), View.MeasureSpec.makeMeasureSpec(this.f152370a[1], View.MeasureSpec.getMode(i16)));
    }

    public AppBrandDialogContentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152370a = new int[]{0, 0};
        this.f152371b = null;
    }

    public AppBrandDialogContentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152370a = new int[]{0, 0};
        this.f152371b = null;
    }
}
