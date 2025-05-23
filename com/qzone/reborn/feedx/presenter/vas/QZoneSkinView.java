package com.qzone.reborn.feedx.presenter.vas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import ch.l;
import com.qzone.adapter.feedcomponent.i;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneSkinView extends ImageView {
    private Drawable C;
    private Paint D;
    private Paint E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private final int f55665d;

    /* renamed from: e, reason: collision with root package name */
    private int f55666e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f55667f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f55668h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f55669i;

    /* renamed from: m, reason: collision with root package name */
    private l f55670m;

    public QZoneSkinView(Context context) {
        super(context);
        this.f55665d = ImmersiveUtils.dpToPx(55.0f);
        this.f55666e = 255;
        this.f55669i = false;
        this.D = new Paint();
        this.E = new Paint();
        this.F = 0;
        this.D.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.E.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void b(String str, ArrayList<Integer> arrayList) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f55670m == null) {
            this.f55670m = new l();
        }
        this.f55670m.g(str, arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (r1 > 0) goto L8;
     */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        int i3;
        int i16;
        int width = canvas.getWidth();
        if (this.f55668h != null) {
            i3 = (int) ((width / r1.getIntrinsicWidth()) * this.f55668h.getIntrinsicHeight());
            this.f55668h.setBounds(0, 0, width, i3);
        }
        i3 = 0;
        Drawable drawable = this.f55667f;
        if (drawable != null) {
            drawable.setBounds(0, 0, width, this.f55665d);
            int i17 = this.f55665d;
            if (i17 > i3) {
                i3 = i17;
            }
        }
        Drawable drawable2 = this.C;
        if (drawable2 != null) {
            int intrinsicHeight = drawable2.getIntrinsicHeight();
            int intrinsicWidth = this.C.getIntrinsicWidth();
            int i18 = this.f55665d;
            this.C.setBounds(width - ((int) ((i18 / intrinsicHeight) * intrinsicWidth)), 0, width, i18);
            int i19 = this.f55665d;
            if (i19 > i3) {
                i3 = i19;
            }
        }
        canvas.saveLayerAlpha(0.0f, 0.0f, width, i3, this.f55666e);
        Drawable drawable3 = this.f55668h;
        if (drawable3 != null) {
            drawable3.draw(canvas);
        }
        Drawable drawable4 = this.f55667f;
        if (drawable4 != null) {
            drawable4.draw(canvas);
        }
        Drawable drawable5 = this.C;
        if (drawable5 != null) {
            drawable5.draw(canvas);
        }
        if (this.f55667f != null || this.C != null) {
            if (!i.H().p1()) {
                canvas.drawPaint(this.D);
            } else {
                canvas.drawPaint(this.E);
            }
        }
        canvas.restore();
        l lVar = this.f55670m;
        if (lVar != null) {
            if (this.f55669i && (i16 = this.F) != 0) {
                lVar.c(canvas, i16);
            } else {
                lVar.d(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        float f16 = i3 / 2.0f;
        int i19 = this.f55665d;
        this.D.setShader(new LinearGradient(f16, i19 / 2.0f, f16, i19, Color.argb(255, 255, 255, 255), Color.argb(0, 255, 255, 255), Shader.TileMode.CLAMP));
        this.E.setShader(new LinearGradient(f16, 0.0f, f16, this.f55665d, Color.argb(150, 255, 255, 255), Color.argb(0, 255, 255, 255), Shader.TileMode.CLAMP));
    }

    public void setBigBgDrawable(Drawable drawable) {
        Drawable drawable2 = this.f55668h;
        if (drawable2 != null && drawable2.getCallback() == this) {
            this.f55668h.setCallback(null);
        }
        this.f55668h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidate();
    }

    public void setFgDrawable(Drawable drawable) {
        Drawable drawable2 = this.C;
        if (drawable2 != null && drawable2.getCallback() == this) {
            this.C.setCallback(null);
        }
        this.C = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = this.f55667f;
        if (drawable2 != null && drawable2.getCallback() == this) {
            this.f55667f.setCallback(null);
        }
        this.f55667f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidate();
    }

    public void setIsDetail(boolean z16) {
        this.f55669i = z16;
    }

    public void setLvTenDetailLocation(int i3) {
        this.F = i3;
    }

    public void setSkinAlpha(int i3) {
        this.f55666e = i3;
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f55667f || drawable == this.C || drawable == this.f55668h) {
            return true;
        }
        return super.verifyDrawable(drawable);
    }

    public void a() {
        this.f55670m = null;
    }
}
