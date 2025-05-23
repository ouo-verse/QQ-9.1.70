package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SnowView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static final Random f205700m;

    /* renamed from: d, reason: collision with root package name */
    int f205701d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f205702e;

    /* renamed from: f, reason: collision with root package name */
    private h[] f205703f;

    /* renamed from: h, reason: collision with root package name */
    private Point f205704h;

    /* renamed from: i, reason: collision with root package name */
    int f205705i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71850);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f205700m = new Random();
        }
    }

    public SnowView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f205701d = 40;
        this.f205702e = new Paint();
        this.f205703f = new h[this.f205701d];
        this.f205705i = 10;
    }

    private void c(h hVar) {
        Random random = f205700m;
        float nextFloat = random.nextFloat() - 0.45f;
        hVar.f205767e = nextFloat;
        float f16 = hVar.f205766d + nextFloat;
        hVar.f205766d = f16;
        if (f16 > 10.0f && nextFloat > 0.0f) {
            hVar.f205767e = 0.0f;
            hVar.f205766d = 10.0f;
        }
        float f17 = hVar.f205766d;
        if (f17 < 2.0f && hVar.f205767e < 0.0f) {
            hVar.f205767e = 0.0f;
        }
        hVar.f205764b += f17 + (random.nextFloat() * 10.0f);
        float nextFloat2 = hVar.f205765c + ((random.nextFloat() - 0.5f) * 0.5f);
        hVar.f205765c = nextFloat2;
        if (Math.abs(nextFloat2) > 3.0f) {
            hVar.f205765c *= 0.96f;
        }
        float f18 = hVar.f205763a + hVar.f205765c;
        hVar.f205763a = f18;
        int i3 = this.f205704h.x;
        if (f18 > i3) {
            hVar.f205763a = 5.0f;
        }
        if (hVar.f205763a < 5.0f) {
            hVar.f205763a = i3;
        }
        if (hVar.f205764b > r1.y) {
            a(hVar);
        }
    }

    public void a(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) hVar);
            return;
        }
        Random random = f205700m;
        hVar.f205763a = random.nextInt(this.f205704h.x) + 5.0f;
        hVar.f205764b = 0.0f;
        hVar.f205766d = (random.nextFloat() * 5.0f) + 2.0f;
        hVar.f205768f = random.nextInt(255);
        hVar.f205769g = random.nextFloat() - 0.5f;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.f205701d; i3++) {
            h[] hVarArr = this.f205703f;
            Random random = f205700m;
            hVarArr[i3] = new h(random.nextInt(this.f205704h.x), random.nextInt(this.f205704h.y), random.nextInt(this.f205705i), random.nextInt(this.f205705i), 0, 0.0f);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        for (int i3 = 0; i3 < this.f205701d; i3++) {
            c(this.f205703f[i3]);
            if (i3 % 2 == 0) {
                this.f205702e.setAlpha(127);
            } else {
                this.f205702e.setAlpha(51);
            }
            h hVar = this.f205703f[i3];
            canvas.drawCircle(hVar.f205763a, hVar.f205764b, BaseAIOUtils.f(1.0f, getResources()), this.f205702e);
        }
    }

    public void setSnowView(Point point) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) point);
            return;
        }
        this.f205704h = point;
        b();
        this.f205702e.setColor(-1);
        this.f205702e.setDither(true);
        this.f205702e.setAntiAlias(true);
    }

    public SnowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f205701d = 40;
        this.f205702e = new Paint();
        this.f205703f = new h[this.f205701d];
        this.f205705i = 10;
    }

    public SnowView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f205701d = 40;
        this.f205702e = new Paint();
        this.f205703f = new h[this.f205701d];
        this.f205705i = 10;
    }
}
