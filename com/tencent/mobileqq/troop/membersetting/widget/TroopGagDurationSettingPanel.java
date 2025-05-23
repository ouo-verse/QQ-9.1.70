package com.tencent.mobileqq.troop.membersetting.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.troop.membersetting.widget.NumberWheelView;
import com.tencent.mobileqq.utils.al;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes35.dex */
public class TroopGagDurationSettingPanel extends LinearLayout implements NumberWheelView.b {
    private int C;
    private final Context D;
    private LayoutInflater E;
    private NumberWheelView F;
    private NumberWheelView G;
    private NumberWheelView H;

    /* renamed from: d, reason: collision with root package name */
    private int f297971d;

    /* renamed from: e, reason: collision with root package name */
    public int f297972e;

    /* renamed from: f, reason: collision with root package name */
    public int f297973f;

    /* renamed from: h, reason: collision with root package name */
    public int f297974h;

    /* renamed from: i, reason: collision with root package name */
    private int f297975i;

    /* renamed from: m, reason: collision with root package name */
    private int f297976m;

    public TroopGagDurationSettingPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = context;
    }

    private void d() {
        if (this.E == null || this.F == null || this.G == null || this.H == null) {
            LayoutInflater from = LayoutInflater.from(this.D);
            this.E = from;
            from.inflate(R.layout.f167255s2, this);
            this.F = (NumberWheelView) findViewById(R.id.f17510h);
            this.G = (NumberWheelView) findViewById(R.id.f17630t);
            this.H = (NumberWheelView) findViewById(R.id.f17851e);
            e(this.F);
            e(this.G);
            e(this.H);
            this.F.setScrollStateListener(this);
            this.G.setScrollStateListener(this);
            this.H.setScrollStateListener(this);
            this.F.setmMaxRotationAngle(120);
            this.G.setmMaxRotationAngle(120);
            this.H.setmMaxRotationAngle(120);
            this.F.setRange(0, this.f297971d - 1);
            this.G.setRange(0, 23);
            this.H.setRange(0, 59);
        }
        f(true);
    }

    private void e(NumberWheelView numberWheelView) {
        float fontLevel = FontSettingManager.getFontLevel();
        if (fontLevel > 16.0f) {
            ViewGroup.LayoutParams layoutParams = numberWheelView.getLayoutParams();
            float f16 = 140.0f - (fontLevel * 5.0f);
            if (f16 < 40.0f || f16 > 60.0f) {
                return;
            }
            layoutParams.width = (int) al.a(getContext(), f16);
        }
    }

    private void f(boolean z16) {
        if (this.f297975i == 1 && this.f297976m == 1 && this.C == 1) {
            if (this.f297972e == 0 && this.f297973f == 0 && this.f297974h == 0) {
                this.f297974h = 1;
                this.H.setValue(1);
            }
            if (z16) {
                this.F.setValue(this.f297972e);
                this.G.setValue(this.f297973f);
                this.H.setValue(this.f297974h);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.membersetting.widget.NumberWheelView.b
    public void a(VerticalGallery verticalGallery) {
        this.f297972e = this.F.D();
        this.f297973f = this.G.D();
        this.f297974h = this.H.D();
        f(false);
    }

    public int b() {
        return ((((this.f297972e * 24) + this.f297973f) * 60) + this.f297974h) * 60;
    }

    public void c(int i3, int i16, int i17, int i18) {
        if (i18 <= 0) {
            i18 = 30;
        }
        this.f297971d = i18;
        if (i3 < 0 || i3 >= i18) {
            i3 = 0;
        }
        if (i16 < 0 || i16 >= 24) {
            i16 = 0;
        }
        if (i17 < 0 || i17 >= 60) {
            i17 = 0;
        }
        this.f297972e = i3;
        this.f297973f = i16;
        this.f297974h = i17;
        this.f297975i = 1;
        this.f297976m = 1;
        this.C = 1;
        d();
    }
}
