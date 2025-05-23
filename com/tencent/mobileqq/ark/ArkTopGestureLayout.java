package com.tencent.mobileqq.ark;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.StickerDismissGestureDetector;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.utils.ah;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkTopGestureLayout extends TopGestureLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f198878d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    protected class a extends TopGestureLayout.TopGestureDetector {
        public a(Context context) {
            super(context);
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (!ArkTopGestureLayout.this.isGestureIdle() && !ArkTopGestureLayout.this.isGestureEnd()) {
                float x16 = motionEvent.getX() - motionEvent2.getX();
                float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
                if (ArkTopGestureLayout.this.hasGestureFlag(1)) {
                    if (x16 < 0.0f && abs < 0.5f) {
                        ArkTopGestureLayout arkTopGestureLayout = ArkTopGestureLayout.this;
                        if (arkTopGestureLayout.mOnFlingGesture != null) {
                            arkTopGestureLayout.setGestureFlag(-1);
                            if (!ArkTopGestureLayout.this.isInTwoFingerMode()) {
                                ArkTopGestureLayout.this.mOnFlingGesture.flingLToR();
                            }
                        }
                    }
                } else if (ArkTopGestureLayout.this.hasGestureFlag(2) && x16 > 0.0f && abs < 0.5f) {
                    ArkTopGestureLayout arkTopGestureLayout2 = ArkTopGestureLayout.this;
                    if (arkTopGestureLayout2.mOnFlingGesture != null) {
                        arkTopGestureLayout2.setGestureFlag(-1);
                        if (!ArkTopGestureLayout.this.isInTwoFingerMode()) {
                            ArkTopGestureLayout.this.mOnFlingGesture.flingRToL();
                        }
                    }
                }
            }
            return false;
        }
    }

    public ArkTopGestureLayout(Context context) {
        super(context);
        this.f198878d = 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout
    public void init(Context context) {
        this.gestureListener = new a(context);
        StickerDismissGestureDetector stickerDismissGestureDetector = new StickerDismissGestureDetector(this, context, this.gestureListener);
        this.mTopGestureDetector = stickerDismissGestureDetector;
        this.defaultGestureDetector = stickerDismissGestureDetector;
    }

    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (motionEvent.getX() <= (this.f198878d / 100.0f) * ((float) ah.M())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
