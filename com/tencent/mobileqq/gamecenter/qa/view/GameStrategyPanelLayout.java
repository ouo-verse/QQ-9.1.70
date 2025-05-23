package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes12.dex */
public class GameStrategyPanelLayout extends LinearLayout {
    private int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private Rect f212902d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f212903e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f212904f;

    /* renamed from: h, reason: collision with root package name */
    private int f212905h;

    /* renamed from: i, reason: collision with root package name */
    private int f212906i;

    /* renamed from: m, reason: collision with root package name */
    private int f212907m;

    public GameStrategyPanelLayout(Context context) {
        super(context);
        this.f212902d = new Rect();
        this.f212903e = false;
        this.f212904f = false;
        this.f212905h = 0;
        this.f212906i = 0;
        this.C = 0;
        this.D = 0;
    }

    private void a() {
        this.f212906i = ((Integer) com.tencent.mobileqq.utils.p.b(getContext(), "", "sp_key_input_height", 0)).intValue();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        boolean z18;
        if (!this.f212904f) {
            super.onLayout(z16, i3, i16, i17, i18);
            return;
        }
        getWindowVisibleDisplayFrame(this.f212902d);
        int abs = Math.abs(this.f212907m - this.f212902d.bottom);
        int height = getRootView().getHeight();
        if (Math.abs(height - this.f212902d.bottom) > height / 4) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f212903e = z17;
        if (this.f212907m > 0 && z17) {
            this.C = abs;
        } else {
            this.f212907m = this.f212902d.bottom;
        }
        int i19 = this.f212906i;
        if (i19 > 0) {
            this.C = i19;
        }
        if (!z17) {
            this.D = i18;
        }
        int i26 = this.D;
        if (i26 > 0 && i18 != i26) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameCenter StrategyBottomLayout", 1, "onLayout change:", Boolean.valueOf(z16), ", t:", Integer.valueOf(i16), ",b:", Integer.valueOf(i18), ",softInputShowing:", Boolean.valueOf(this.f212903e), ",bottomDiff:", Integer.valueOf(abs), ",inputHeight:", Integer.valueOf(this.C), ",windowHeight:", Integer.valueOf(height), ",mRect.bottom:", Integer.valueOf(this.f212902d.bottom), ",isSystemAdapter:", Boolean.valueOf(z18));
        }
        View childAt = getChildAt(0);
        if (this.f212903e && !z18) {
            childAt.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec((i18 - i16) - this.C, 1073741824));
            childAt.layout(i3, i16 - this.f212905h, i17, i18 - this.C);
        } else {
            childAt.measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i18 - i16, 1073741824));
            childAt.layout(i3, i16 - this.f212905h, i17, i18);
        }
    }

    public void setViewType(boolean z16, int i3, Window window) {
        this.f212904f = z16;
        this.f212905h = i3;
        a();
    }

    public GameStrategyPanelLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f212902d = new Rect();
        this.f212903e = false;
        this.f212904f = false;
        this.f212905h = 0;
        this.f212906i = 0;
        this.C = 0;
        this.D = 0;
    }

    public GameStrategyPanelLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f212902d = new Rect();
        this.f212903e = false;
        this.f212904f = false;
        this.f212905h = 0;
        this.f212906i = 0;
        this.C = 0;
        this.D = 0;
    }
}
