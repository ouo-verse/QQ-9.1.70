package com.tencent.guild.aio.msglist.ark;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ArkAppLoadLayout extends RelativeLayout {
    public static Paint C = new Paint(1);

    /* renamed from: d, reason: collision with root package name */
    private Path f111182d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f111183e;

    /* renamed from: f, reason: collision with root package name */
    private ArkViewImplement f111184f;

    /* renamed from: h, reason: collision with root package name */
    int f111185h;

    /* renamed from: i, reason: collision with root package name */
    int f111186i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f111187m;

    public ArkAppLoadLayout(Context context) {
        super(context);
        this.f111182d = new Path();
        this.f111183e = new RectF();
        this.f111185h = -1644826;
        this.f111186i = MiniChatConstants.COLOR_NIGHT;
        this.f111187m = false;
    }

    protected int a() {
        if (QQTheme.isNowThemeIsNight()) {
            return this.f111186i;
        }
        return this.f111185h;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.f111187m) {
            C.setColor(a());
            canvas.drawPath(this.f111182d, C);
        }
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (!this.f111187m) {
            this.f111183e.set(0.0f, 0.0f, View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
            this.f111182d.reset();
            this.f111184f.makePath(this.f111183e, this.f111182d);
        }
    }

    public void setArkView(ArkViewImplement arkViewImplement) {
        this.f111184f = arkViewImplement;
        setWillNotDraw(false);
    }

    public void setBkgColorNormal(int i3) {
        this.f111185h = i3;
    }

    public ArkAppLoadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f111182d = new Path();
        this.f111183e = new RectF();
        this.f111185h = -1644826;
        this.f111186i = MiniChatConstants.COLOR_NIGHT;
        this.f111187m = false;
    }

    public ArkAppLoadLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f111182d = new Path();
        this.f111183e = new RectF();
        this.f111185h = -1644826;
        this.f111186i = MiniChatConstants.COLOR_NIGHT;
        this.f111187m = false;
    }
}
