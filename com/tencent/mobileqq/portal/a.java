package com.tencent.mobileqq.portal;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;
    public float C;
    public float D;
    public int E;
    public ArrayList<Animation> F;

    /* renamed from: d, reason: collision with root package name */
    public Transformation f259359d;

    /* renamed from: e, reason: collision with root package name */
    public int f259360e;

    /* renamed from: f, reason: collision with root package name */
    public int f259361f;

    /* renamed from: h, reason: collision with root package name */
    public int f259362h;

    /* renamed from: i, reason: collision with root package name */
    public int f259363i;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f259364m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f259359d = new Transformation();
        this.f259360e = 0;
        this.f259361f = 0;
        this.f259364m = null;
        this.C = 1.0f;
        this.D = 1.0f;
        this.E = 255;
        this.F = new ArrayList<>();
    }

    public boolean b(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas)).booleanValue();
        }
        if (this.E != 0 && this.f259364m != null) {
            canvas.save();
            canvas.translate(this.f259360e, this.f259361f);
            this.f259364m.setAlpha(this.E);
            this.f259364m.setBounds(0, 0, this.f259362h, this.f259363i);
            canvas.scale(this.C, this.D, this.f259362h / 2, this.f259363i / 2);
            this.f259364m.draw(canvas);
            canvas.restore();
        }
        Iterator<Animation> it = this.F.iterator();
        while (true) {
            boolean z16 = false;
            while (it.hasNext()) {
                Animation next = it.next();
                if (z16 || next.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f259359d)) {
                    z16 = true;
                }
            }
            return z16;
        }
    }

    public void c(int i3, int i16, int i17, int i18, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
            return;
        }
        this.f259360e = i3;
        this.f259361f = i16;
        this.f259362h = i17;
        this.f259363i = i18;
    }

    public void d(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.E != 0 && this.f259364m != null) {
            canvas.save();
            canvas.translate(this.f259360e, this.f259361f);
            this.f259364m.setAlpha(this.E);
            this.f259364m.setBounds(0, 0, this.f259362h, this.f259363i);
            canvas.scale(this.C, this.D, this.f259362h / 2, this.f259363i / 2);
            this.f259364m.draw(canvas);
            canvas.restore();
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        Iterator<Animation> it = this.F.iterator();
        while (true) {
            boolean z16 = false;
            while (it.hasNext()) {
                Animation next = it.next();
                if (z16 || next.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f259359d)) {
                    z16 = true;
                }
            }
            return z16;
        }
    }
}
