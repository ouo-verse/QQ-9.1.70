package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenDefaultHeaderView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSHalfScreenFloatingView extends QUSHalfScreenFloatingView {

    /* renamed from: s0, reason: collision with root package name */
    private com.tencent.mobileqq.widget.qus.d f92608s0;

    /* renamed from: t0, reason: collision with root package name */
    private final List<QUSBaseHalfScreenFloatingView.l> f92609t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f92610u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f92611v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f92612w0;

    /* renamed from: x0, reason: collision with root package name */
    private a f92613x0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    public QFSHalfScreenFloatingView(@NonNull Context context) {
        super(context);
        this.f92609t0 = new ArrayList();
        this.f92611v0 = true;
        this.f92612w0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        Iterator<QUSBaseHalfScreenFloatingView.l> it = this.f92609t0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void C(@Nullable AttributeSet attributeSet, int i3) {
        super.C(attributeSet, i3);
        if (this.f92612w0) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_r8_top);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            relativeLayout.addView(new QUSHalfScreenDefaultHeaderView(getContext(), null, 0));
            setHeaderView(relativeLayout);
        }
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void L() {
        super.L();
        if (x() != null) {
            x().setY(0.0f);
        }
        this.R = false;
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void P(int i3) {
        this.f92610u0 = true;
        super.P(i3);
    }

    public void T(QUSBaseHalfScreenFloatingView.l lVar) {
        if (this.f92609t0.contains(lVar)) {
            return;
        }
        this.f92609t0.add(lVar);
        setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.biz.qqcircle.utils.br
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                QFSHalfScreenFloatingView.this.Y();
            }
        });
    }

    public void U() {
        if (this.Q != null) {
            return;
        }
        this.Q = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.Q.setBackgroundColor(Color.parseColor("#80000000"));
        addView(this.Q, 0, layoutParams);
        this.Q.setClickable(false);
        this.Q.setAlpha(0.0f);
    }

    public float V() {
        int realHeight;
        com.tencent.mobileqq.widget.qus.d dVar = this.f92608s0;
        if (dVar != null) {
            realHeight = dVar.maxHeight();
        } else {
            realHeight = (int) (DisplayUtil.getRealHeight(getContext()) * 0.7d);
        }
        return realHeight;
    }

    public float W() {
        return (getMeasuredHeight() - V()) - cx.h();
    }

    public boolean X() {
        return this.f92610u0;
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f92613x0;
        if (aVar != null && aVar.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f92611v0) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (!this.f92610u0) {
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
    }

    public void setBackgroundResource(Drawable drawable) {
        if (x() == null) {
            return;
        }
        x().setBackground(drawable);
    }

    public void setCanSlide(boolean z16) {
        this.f92611v0 = z16;
    }

    public void setHeadNeedDragIcon(boolean z16) {
        this.f92612w0 = z16;
    }

    public void setOutsideTouchEventListener(a aVar) {
        this.f92613x0 = aVar;
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void setQUSDragFloatController(com.tencent.mobileqq.widget.qus.d dVar) {
        this.f92608s0 = dVar;
        super.setQUSDragFloatController(dVar);
    }

    public QFSHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f92609t0 = new ArrayList();
        this.f92611v0 = true;
        this.f92612w0 = false;
    }

    public QFSHalfScreenFloatingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92609t0 = new ArrayList();
        this.f92611v0 = true;
        this.f92612w0 = false;
    }
}
