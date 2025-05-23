package com.tencent.mobileqq.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UpScrollHideView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f316500d;

    /* renamed from: e, reason: collision with root package name */
    private int f316501e;

    /* renamed from: f, reason: collision with root package name */
    private int f316502f;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public UpScrollHideView(Context context) {
        super(context, null);
        this.f316501e = -1;
        this.f316502f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
    
        if (r0 != 3) goto L23;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f316501e);
                    if (findPointerIndex != -1) {
                        int y16 = (int) (this.f316500d - motionEvent.getY(findPointerIndex));
                        this.f316502f = y16;
                        if (y16 > 0) {
                            scrollTo(0, y16);
                        }
                    }
                }
            }
            if (this.f316502f > getHeight()) {
                setVisibility(8);
            } else {
                scrollTo(0, 0);
            }
            this.f316501e = -1;
        } else {
            this.f316500d = motionEvent.getY();
            this.f316501e = motionEvent.getPointerId(0);
        }
        return true;
    }

    public UpScrollHideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.scrollViewStyle);
    }

    public UpScrollHideView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316501e = -1;
        this.f316502f = 0;
    }

    public void setOnViewHideListener(a aVar) {
    }
}
