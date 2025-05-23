package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class DescTextView extends TextView {
    public static final String TAG = "DescTextView";
    private boolean enableTextScroll;
    private GestureDetector gestureDetector;
    private b listener;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            PlayerUtils.log(3, DescTextView.TAG, "[onSingleTapUp]");
            if (DescTextView.this.listener != null) {
                return DescTextView.this.listener.a();
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    interface b {
        boolean a();
    }

    public DescTextView(Context context, String str) {
        super(context);
        this.enableTextScroll = false;
        this.gestureDetector = null;
        setContentDescription(str);
    }

    public void enableTextScroll(boolean z16) {
        if (this.enableTextScroll == z16) {
            PlayerUtils.log(3, TAG, "[enableTextScroll] no need set");
            return;
        }
        this.enableTextScroll = z16;
        if (z16) {
            setVerticalScrollBarEnabled(true);
            setHorizontalScrollBarEnabled(true);
            setMaxLines(1000);
            setMovementMethod(ScrollingMovementMethod.getInstance());
            this.gestureDetector = new GestureDetector(getContext(), new a());
            return;
        }
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setHorizontallyScrolling(false);
        setMovementMethod(null);
        this.gestureDetector = null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.enableTextScroll) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        GestureDetector gestureDetector = this.gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnSingleTapConfirmedListener(b bVar) {
        this.listener = bVar;
    }

    public DescTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableTextScroll = false;
        this.gestureDetector = null;
    }

    public DescTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.enableTextScroll = false;
        this.gestureDetector = null;
    }
}
