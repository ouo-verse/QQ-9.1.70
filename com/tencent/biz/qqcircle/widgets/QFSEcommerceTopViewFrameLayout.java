package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSEcommerceTopViewFrameLayout extends FrameLayout implements QFSViewPager.b {

    /* renamed from: d, reason: collision with root package name */
    private float f93218d;

    /* renamed from: e, reason: collision with root package name */
    private float f93219e;

    /* renamed from: f, reason: collision with root package name */
    private float f93220f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f93221h;

    /* renamed from: i, reason: collision with root package name */
    private a f93222i;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public QFSEcommerceTopViewFrameLayout(@NonNull Context context) {
        super(context);
        this.f93218d = 0.0f;
        this.f93219e = 0.0f;
        this.f93221h = false;
    }

    private boolean b(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float f16 = x16 - this.f93220f;
        QLog.d("QFSEcommerceTopViewFrameLayout", 1, "[handleActionMove] -> diffX = " + f16);
        if (this.f93221h && f16 != 0.0f) {
            this.f93220f = x16;
            a aVar = this.f93222i;
            if (aVar != null) {
                aVar.a();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean c(MotionEvent motionEvent) {
        this.f93218d = motionEvent.getX();
        this.f93219e = motionEvent.getY();
        this.f93220f = motionEvent.getX();
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean d(MotionEvent motionEvent) {
        float x16 = motionEvent.getX() - this.f93220f;
        QLog.d("QFSEcommerceTopViewFrameLayout", 1, "[handleInterceptActionMove] -> diffX = " + x16);
        if (this.f93221h && x16 != 0.0f) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSViewPager.b
    public boolean a(boolean z16, int i3, int i16, int i17) {
        return this.f93221h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f93221h && motionEvent.getAction() == 0) {
            return c(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f93221h && motionEvent.getAction() == 2) {
            return d(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f93221h && motionEvent.getAction() == 2) {
            return b(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setEnableOperate(boolean z16) {
        this.f93221h = z16;
    }

    public void setOnSwipeListener(a aVar) {
        this.f93222i = aVar;
    }

    public QFSEcommerceTopViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93218d = 0.0f;
        this.f93219e = 0.0f;
        this.f93221h = false;
    }

    public QFSEcommerceTopViewFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93218d = 0.0f;
        this.f93219e = 0.0f;
        this.f93221h = false;
    }
}
