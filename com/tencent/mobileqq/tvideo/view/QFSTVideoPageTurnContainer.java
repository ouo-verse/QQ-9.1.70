package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;

/* loaded from: classes19.dex */
public class QFSTVideoPageTurnContainer extends QFSPageTurnContainer {
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f304779a0;

    public QFSTVideoPageTurnContainer(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer
    protected int A() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int i3 = x16 - this.W;
            int abs = (int) (Math.abs(i3) * 0.5f);
            int abs2 = Math.abs(y16 - this.f304779a0);
            int i16 = this.P;
            if ((abs >= i16 || abs2 >= i16) && abs2 < abs) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            this.W = (int) (motionEvent.getX() + 0.5f);
            this.f304779a0 = (int) (motionEvent.getY() + 0.5f);
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public QFSTVideoPageTurnContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSTVideoPageTurnContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
