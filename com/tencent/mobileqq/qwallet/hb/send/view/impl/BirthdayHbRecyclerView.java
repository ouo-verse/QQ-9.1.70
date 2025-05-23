package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BirthdayHbRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private Scroller f277786f;

    /* renamed from: h, reason: collision with root package name */
    private int f277787h;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends RecyclerView.OnFlingListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i3, int i16) {
            int height;
            if (i16 < 0) {
                height = 0 - BirthdayHbRecyclerView.this.f277787h;
            } else {
                height = BirthdayHbRecyclerView.this.getHeight() - BirthdayHbRecyclerView.this.f277787h;
            }
            BirthdayHbRecyclerView.this.f277786f.startScroll(0, BirthdayHbRecyclerView.this.f277787h, 0, height, 500);
            BirthdayHbRecyclerView.this.invalidate();
            return true;
        }
    }

    public BirthdayHbRecyclerView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f277786f.computeScrollOffset()) {
            int currY = this.f277786f.getCurrY();
            scrollBy(0, currY - this.f277787h);
            this.f277787h = currY;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f277787h = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public BirthdayHbRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BirthdayHbRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setOnFlingListener(new a());
        this.f277786f = new Scroller(context);
    }
}
