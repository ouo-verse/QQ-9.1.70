package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class ConfessProgressView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Paint f202154d;

    /* renamed from: e, reason: collision with root package name */
    private float f202155e;

    /* renamed from: f, reason: collision with root package name */
    private float f202156f;

    /* renamed from: h, reason: collision with root package name */
    private float f202157h;

    /* renamed from: i, reason: collision with root package name */
    private float f202158i;

    /* renamed from: m, reason: collision with root package name */
    private float f202159m;

    public ConfessProgressView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f202154d = new Paint();
        this.f202155e = 0.0f;
        a();
    }

    private void a() {
        this.f202154d.setColor(Color.argb(255, 252, 228, 80));
        this.f202154d.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else {
            canvas.drawCircle((this.f202156f / 2.0f) + this.f202158i, ((this.f202157h / 2.0f) * 1.08f) + this.f202159m, this.f202155e, this.f202154d);
        }
    }

    public void setSize(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.f202156f = f16;
        this.f202157h = f17;
        this.f202158i = f18;
        this.f202159m = f19;
    }

    public ConfessProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f202154d = new Paint();
        this.f202155e = 0.0f;
        a();
    }

    public ConfessProgressView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f202154d = new Paint();
        this.f202155e = 0.0f;
        a();
    }
}
