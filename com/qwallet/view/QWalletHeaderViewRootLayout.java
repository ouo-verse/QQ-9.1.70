package com.qwallet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QWalletHeaderViewRootLayout extends RelativeLayout {
    private float C;

    /* renamed from: d, reason: collision with root package name */
    public QWalletHeaderView f41810d;

    /* renamed from: e, reason: collision with root package name */
    int f41811e;

    /* renamed from: f, reason: collision with root package name */
    private float f41812f;

    /* renamed from: h, reason: collision with root package name */
    private VelocityTracker f41813h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f41814i;

    /* renamed from: m, reason: collision with root package name */
    private float f41815m;

    public QWalletHeaderViewRootLayout(Context context) {
        super(context);
        this.f41811e = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r0 != 3) goto L29;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchWebView touchWebView;
        if (this.f41813h == null) {
            this.f41813h = VelocityTracker.obtain();
        }
        this.f41813h.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float abs = Math.abs(this.f41812f - motionEvent.getY());
                    if (QLog.isColorLevel()) {
                        QLog.i("parsons", 2, "dy: " + abs + " touchSlop: " + this.f41811e);
                    }
                    if (abs >= this.f41811e) {
                        this.f41814i = true;
                        this.f41813h.computeCurrentVelocity(1000);
                        QWalletHeaderView qWalletHeaderView = this.f41810d;
                        if (qWalletHeaderView != null && (touchWebView = qWalletHeaderView.f41802e) != null) {
                            touchWebView.flingScroll(0, -((int) this.f41813h.getYVelocity()));
                        }
                    } else {
                        this.f41814i = false;
                    }
                }
            }
            this.f41814i = false;
            VelocityTracker velocityTracker = this.f41813h;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f41813h = null;
            }
        } else {
            this.f41812f = motionEvent.getY();
            this.f41814i = false;
        }
        return this.f41814i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y16 = motionEvent.getY();
        if (action == 2) {
            float f16 = y16 - this.f41815m;
            this.C = f16;
            if (f16 > 0.0f) {
                motionEvent.setAction(0);
                dispatchTouchEvent(motionEvent);
            }
            this.f41815m = y16;
        }
        return super.onTouchEvent(motionEvent);
    }

    public QWalletHeaderViewRootLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41811e = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
