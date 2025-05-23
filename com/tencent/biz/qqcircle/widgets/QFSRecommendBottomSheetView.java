package com.tencent.biz.qqcircle.widgets;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSRecommendBottomSheetView extends CoordinatorLayout {
    private static final int I = cx.a(30.0f);
    private final int C;
    private final int D;
    private float E;
    private int F;
    private boolean G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f93398d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f93399e;

    /* renamed from: f, reason: collision with root package name */
    private View f93400f;

    /* renamed from: h, reason: collision with root package name */
    private final BottomSheetBehavior<View> f93401h;

    /* renamed from: i, reason: collision with root package name */
    private int f93402i;

    /* renamed from: m, reason: collision with root package name */
    private final int f93403m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends BottomSheetBehavior.e {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            QLog.d("QFSRecommendBottomSheetView", 4, "onSlide slideOffset: " + f16);
            QFSRecommendBottomSheetView.this.J(f16);
            QFSRecommendBottomSheetView.this.G(f16);
            QFSRecommendBottomSheetView.this.r(f16);
            QFSRecommendBottomSheetView.this.w(f16);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            int i16;
            QLog.d("QFSRecommendBottomSheetView", 4, "onStateChanged newState: " + i3);
            FrameLayout frameLayout = QFSRecommendBottomSheetView.this.f93398d;
            int i17 = 8;
            if (i3 == 5) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            frameLayout.setVisibility(i16);
            FrameLayout frameLayout2 = QFSRecommendBottomSheetView.this.f93399e;
            if (i3 != 5) {
                i17 = 0;
            }
            frameLayout2.setVisibility(i17);
            QFSRecommendBottomSheetView.this.H(i3);
            QFSRecommendBottomSheetView.this.s(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
    }

    public QFSRecommendBottomSheetView(@NonNull Context context) {
        super(context, null);
        this.f93401h = new BottomSheetBehavior<>();
        this.f93403m = -DisplayUtil.dip2px(getContext(), 14.0f);
        this.C = DisplayUtil.dip2px(getContext(), 90.0f);
        this.D = DisplayUtil.dip2px(getContext(), 140.0f);
        this.E = 2.0f;
        this.F = 0;
    }

    private void A() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.enc);
        this.f93398d = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.bn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSRecommendBottomSheetView.this.E(view);
            }
        });
    }

    private void B() {
        this.f93399e = (FrameLayout) findViewById(R.id.jo9);
        this.f93400f = findViewById(R.id.f165390vs4);
        findViewById(R.id.a47).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.bo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSRecommendBottomSheetView.this.F(view);
            }
        });
    }

    private void C() {
        B();
        A();
        y();
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean D(View view, MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.f93399e.getGlobalVisibleRect(rect);
        rect.bottom -= this.f93403m;
        rect.offset(0, -this.C);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        this.f93398d.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f93401h.getState() == 4) {
            t();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(float f16) {
        if (f16 > 0.0f) {
            return;
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i3) {
        if (i3 == 3 && this.F == 0) {
            this.G = true;
        }
        if (i3 == 3 || i3 == 5 || i3 == 4) {
            this.F = 0;
            this.E = 2.0f;
            this.H = false;
        }
        if (i3 == 1) {
            this.H = true;
        }
    }

    private void I(boolean z16) {
        RFWImmersiveUtils.setStatusBarTextColor(((Activity) getContext()).getWindow(), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(float f16) {
        if (f16 < 0.0f) {
            return;
        }
        float measuredHeight = (1.0f - f16) * (getMeasuredHeight() - u());
        int i3 = this.D;
        if (measuredHeight < i3) {
            this.f93399e.setTranslationY(this.C * (measuredHeight / i3));
            this.f93400f.setAlpha(measuredHeight / this.D);
        } else {
            this.f93399e.setTranslationY(this.C);
            this.f93400f.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(float f16) {
        if (this.f93401h.getState() == 2) {
            float f17 = this.E;
            if (f17 == 2.0f) {
                this.E = f16;
                return;
            }
            if (this.F == 0) {
                float f18 = f16 - f17;
                if (f18 > 0.0f && f16 > 0.0f) {
                    QLog.d("QFSRecommendBottomSheetView", 1, "[calculateNextState] next state: expanded");
                    this.F = 3;
                } else if (f18 < 0.0f && f16 > 0.0f) {
                    QLog.d("QFSRecommendBottomSheetView", 1, "[calculateNextState] next state: collapsed");
                    this.F = 4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3) {
        if (i3 == 3) {
            this.f93399e.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.qui_common_bg_middle_light_bg));
            I(true);
        }
        if (i3 == 1) {
            this.f93399e.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.qui_common_bg_middle_light_bg_corner_8_top));
            I(false);
        }
    }

    private void t() {
        this.f93401h.setState(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(float f16) {
        if (f16 <= 0.0f && this.f93401h.getState() == 2 && this.H) {
            this.H = false;
            if (u() * (-f16) > I) {
                QLog.d("QFSRecommendBottomSheetView", 4, "hideHalfPanelIfNeed ");
                t();
            }
        }
    }

    private void y() {
        this.f93401h.setHideable(true);
        this.f93401h.setDraggable(true);
        this.f93401h.setPeekHeight(u() + this.C);
        this.f93401h.setState(5);
        this.f93401h.addBottomSheetCallback(new a());
        try {
            Field declaredField = BottomSheetBehavior.class.getDeclaredField("paddingTopSystemWindowInsets");
            declaredField.setAccessible(true);
            declaredField.set(this.f93401h, Boolean.TRUE);
        } catch (IllegalAccessException | NoSuchFieldException e16) {
            QLog.e("QFSRecommendBottomSheetView", 1, "paddingTopSystemWindowInsets set error. " + e16);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void z() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.b9t);
        frameLayout.setClickable(true);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setBehavior(this.f93401h);
        layoutParams.gravity = 80;
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.biz.qqcircle.widgets.bm
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D;
                D = QFSRecommendBottomSheetView.this.D(view, motionEvent);
                return D;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && this.G) {
            this.G = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int u() {
        int i3 = this.f93402i;
        if (i3 > 0) {
            return i3;
        }
        int screenHeight = DisplayUtil.getScreenHeight();
        if (!bz.r()) {
            screenHeight = Math.max(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
        }
        int v3 = v();
        int i16 = screenHeight - v3;
        if (i16 < v3) {
            i16 = (int) (cx.b(getContext()) * 0.7d);
        }
        this.f93402i = i16;
        QLog.d("QFSRecommendBottomSheetView", 1, "[getPanelHeight] panelHeight: " + i16 + ", topSpaceHeight: " + v3 + ", screenHeight: " + DisplayUtil.getScreenHeight());
        return this.f93402i;
    }

    public int v() {
        int screenWidth = DisplayUtil.getScreenWidth();
        if (!bz.r()) {
            screenWidth = Math.min(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
        }
        return (int) (screenWidth * 0.5625f);
    }

    public void x() {
        setFitsSystemWindows(false);
        C();
    }

    public QFSRecommendBottomSheetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93401h = new BottomSheetBehavior<>();
        this.f93403m = -DisplayUtil.dip2px(getContext(), 14.0f);
        this.C = DisplayUtil.dip2px(getContext(), 90.0f);
        this.D = DisplayUtil.dip2px(getContext(), 140.0f);
        this.E = 2.0f;
        this.F = 0;
        LayoutInflater.from(context).inflate(R.layout.gpw, (ViewGroup) this, true);
        x();
    }

    public void setStateListener(b bVar) {
    }
}
