package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

/* loaded from: classes20.dex */
public class NestViewPager extends QQViewPager {

    /* renamed from: d, reason: collision with root package name */
    private int f315864d;

    /* renamed from: e, reason: collision with root package name */
    private int f315865e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315866f;

    public NestViewPager(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.widget.QQViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int action = motionEvent.getAction();
        boolean z17 = true;
        if (action == 0) {
            this.f315864d = (int) (motionEvent.getX() + 0.5f);
            this.f315865e = (int) (motionEvent.getY() + 0.5f);
            this.f315866f = true;
        } else if (action == 2) {
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int abs = Math.abs(x16 - this.f315864d);
            int abs2 = Math.abs(y16 - this.f315865e);
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            if (this.f315866f && abs > scaledTouchSlop) {
                if (abs2 / abs < 0.6f && this.f315864d > ((int) (ScreenUtil.SCREEN_WIDTH * 0.1f))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f315866f = false;
                if (!z16) {
                    try {
                        if (!super.onInterceptTouchEvent(motionEvent)) {
                            z17 = false;
                        }
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return z17;
            }
        } else if (action == 1 || action == 3) {
            this.f315866f = false;
        }
        z16 = false;
        if (!z16) {
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.widget.QQViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && (action == 1 || action == 3)) {
            this.f315866f = false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public NestViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
