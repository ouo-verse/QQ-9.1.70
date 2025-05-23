package com.tencent.mobileqq.qwallet.hb.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qwallet.hb.view.RollTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RollNumberView extends LinearLayout implements RollTextView.b {
    private int C;
    private int D;
    private a E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private Context f277894d;

    /* renamed from: e, reason: collision with root package name */
    private int f277895e;

    /* renamed from: f, reason: collision with root package name */
    private int f277896f;

    /* renamed from: h, reason: collision with root package name */
    private int f277897h;

    /* renamed from: i, reason: collision with root package name */
    private int f277898i;

    /* renamed from: m, reason: collision with root package name */
    private int f277899m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void complete();
    }

    public RollNumberView(Context context) {
        super(context);
        this.f277896f = 0;
        this.D = 0;
        this.F = true;
        this.f277894d = context;
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, gj2.a.f402226i5);
        this.f277899m = (int) obtainStyledAttributes.getDimension(gj2.a.f402238k5, 12.0f);
        this.C = obtainStyledAttributes.getColor(gj2.a.f402232j5, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.view.RollTextView.b
    public void a() {
        a aVar;
        if (QLog.isColorLevel()) {
            QLog.d("RollNumberView", 2, "onRollTextComplete---");
        }
        if (this.D == this.f277895e - 2 && (aVar = this.E) != null) {
            aVar.complete();
        }
        this.D++;
    }

    public int d(int i3) throws Exception {
        if (i3 >= 0) {
            int i16 = i3 % 10;
            RollTextView rollTextView = new RollTextView(this.f277894d, this.f277899m, this.C, this.F);
            rollTextView.setListener(this);
            int i17 = this.f277897h;
            this.f277897h = i17 + 1;
            rollTextView.setFactor(i17);
            addView(rollTextView, 0);
            int nextInt = 4 - new Random().nextInt(3);
            rollTextView.setScope(i16 + nextInt, i16);
            int i18 = 0;
            for (int i19 = i3 / 10; i19 > 0; i19 /= 10) {
                i18++;
                RollTextView rollTextView2 = new RollTextView(this.f277894d, this.f277899m, this.C, this.F);
                rollTextView2.setListener(this);
                int i26 = this.f277897h;
                this.f277897h = i26 + 1;
                rollTextView2.setFactor(i26);
                int i27 = i19 % 10;
                rollTextView2.setScope(i27 + nextInt + i18, i27);
                addView(rollTextView2, 0);
            }
            return nextInt;
        }
        throw new Exception("no must be positive");
    }

    public void e(double d16) throws Exception {
        if (d16 > 0.0d) {
            TextView textView = new TextView(this.f277894d);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            textView.setIncludeFontPadding(false);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(80);
            textView.setTextSize(0, this.f277899m);
            textView.setTextColor(this.C);
            int i3 = (int) d16;
            int round = ((int) Math.round((d16 - i3) * 1000.0d)) / 10;
            this.f277898i = d(round);
            if (round < 10) {
                d(0);
            }
            textView.setText(".");
            textView.setContentDescription(HardCodeUtil.qqStr(R.string.f172652t33));
            addView(textView, 0);
            int d17 = d(i3);
            int i16 = this.f277898i;
            if (d17 <= i16) {
                d17 = i16;
            }
            this.f277898i = d17;
            return;
        }
        throw new Exception("no must be positive");
    }

    public void f(double d16) {
        for (int i3 = 0; i3 < this.f277895e; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && (childAt instanceof RollTextView)) {
                ((RollTextView) childAt).o();
            }
        }
        this.f277897h = 0;
        removeAllViews();
        try {
            this.D = 0;
            e(d16);
        } catch (Exception e16) {
            QLog.e("RollNumberView", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    public void g() {
        this.f277895e = getChildCount();
        for (int i3 = 0; i3 < this.f277895e; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && (childAt instanceof RollTextView)) {
                ((RollTextView) childAt).n();
            }
        }
    }

    public void setFactor(int i3) {
        if (i3 >= 0) {
            this.f277897h = i3;
        }
    }

    public void setIsRool(boolean z16) {
        this.F = z16;
    }

    public void setLisener(a aVar) {
        if (aVar != null) {
            this.E = aVar;
        }
    }

    public RollNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f277896f = 0;
        this.D = 0;
        this.F = true;
        this.f277894d = context;
        c(context, attributeSet);
    }

    public RollNumberView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f277896f = 0;
        this.D = 0;
        this.F = true;
        this.f277894d = context;
        c(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.view.RollTextView.b
    public void b(Bitmap bitmap) {
    }
}
