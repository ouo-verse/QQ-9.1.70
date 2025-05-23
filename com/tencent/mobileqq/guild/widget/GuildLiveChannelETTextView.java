package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildLiveChannelETTextView extends ETTextView implements s02.a {
    private final GestureDetector O0;
    private View.OnClickListener P0;
    private float Q0;
    private float R0;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    protected class a extends GestureDetector.SimpleOnGestureListener {
        protected a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (GuildLiveChannelETTextView.this.d0(motionEvent.getX(), motionEvent.getY())) {
                GuildLiveChannelETTextView.this.e0();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    public GuildLiveChannelETTextView(Context context) {
        super(context);
        this.O0 = new GestureDetector(context, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d0(float f16, float f17) {
        return f17 <= this.R0 && f16 <= this.Q0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        View.OnClickListener onClickListener = this.P0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // com.etrump.mixlayout.ETTextView, com.tencent.mobileqq.widget.AnimationTextView, com.tencent.mobileqq.widget.PatchedTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.O0.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    @Override // s02.a
    public void setNickClickListener(View.OnClickListener onClickListener) {
        this.P0 = onClickListener;
    }

    @Override // s02.a
    public void setNickName(String str) {
        this.R0 = getLineHeight() + getPaddingTop();
        this.Q0 = getPaint().measureText(str);
    }

    @Override // s02.a
    public TextView d() {
        return this;
    }
}
