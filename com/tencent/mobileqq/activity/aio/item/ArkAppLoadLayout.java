package com.tencent.mobileqq.activity.aio.item;

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
/* loaded from: classes10.dex */
public class ArkAppLoadLayout extends RelativeLayout {
    public static Paint C = new Paint(1);

    /* renamed from: d, reason: collision with root package name */
    private Path f179272d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f179273e;

    /* renamed from: f, reason: collision with root package name */
    private ArkViewImplement f179274f;

    /* renamed from: h, reason: collision with root package name */
    int f179275h;

    /* renamed from: i, reason: collision with root package name */
    int f179276i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f179277m;

    public ArkAppLoadLayout(Context context) {
        super(context);
        this.f179272d = new Path();
        this.f179273e = new RectF();
        this.f179275h = -1644826;
        this.f179276i = MiniChatConstants.COLOR_NIGHT;
        this.f179277m = false;
    }

    protected int a() {
        if (QQTheme.isNowThemeIsNight()) {
            return this.f179276i;
        }
        return this.f179275h;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.f179277m) {
            C.setColor(a());
            canvas.drawPath(this.f179272d, C);
        }
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (!this.f179277m) {
            this.f179273e.set(0.0f, 0.0f, View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
            this.f179272d.reset();
            this.f179274f.makePath(this.f179273e, this.f179272d);
        }
    }

    public void setArkView(ArkViewImplement arkViewImplement) {
        this.f179274f = arkViewImplement;
        setWillNotDraw(false);
    }

    public void setBkgColorNormal(int i3) {
        this.f179275h = i3;
    }

    public ArkAppLoadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179272d = new Path();
        this.f179273e = new RectF();
        this.f179275h = -1644826;
        this.f179276i = MiniChatConstants.COLOR_NIGHT;
        this.f179277m = false;
    }

    public ArkAppLoadLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f179272d = new Path();
        this.f179273e = new RectF();
        this.f179275h = -1644826;
        this.f179276i = MiniChatConstants.COLOR_NIGHT;
        this.f179277m = false;
    }
}
