package com.qq.e.tg.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ViewStatusListener f40596a;

    /* renamed from: b, reason: collision with root package name */
    private int f40597b;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    private @interface ViewStatus {
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f40597b = 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f40596a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.f40597b = 2;
        ViewStatusListener viewStatusListener = this.f40596a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.f40597b = 3;
        ViewStatusListener viewStatusListener = this.f40596a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z16);
        ViewStatusListener viewStatusListener = this.f40596a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z16);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i3);
        ViewStatusListener viewStatusListener = this.f40596a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i3);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f40596a = viewStatusListener;
        if (viewStatusListener != null) {
            int i3 = this.f40597b;
            if (i3 != 2) {
                if (i3 == 3) {
                    viewStatusListener.onDetachFromWindow();
                    return;
                }
                return;
            }
            viewStatusListener.onAttachToWindow();
        }
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40597b = 1;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f40597b = 1;
    }
}
