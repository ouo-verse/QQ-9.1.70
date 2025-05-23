package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LyricView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected LyricViewInternal f243180d;

    /* renamed from: e, reason: collision with root package name */
    protected LyricViewScroll f243181e;

    /* renamed from: f, reason: collision with root package name */
    protected b f243182f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f243183h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f243184i;

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f243184i = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ModuleLyricView, 0, 0);
        b bVar = new b();
        this.f243182f = bVar;
        bVar.a(obtainStyledAttributes);
        this.f243183h = obtainStyledAttributes.getBoolean(R.styleable.ModuleLyricView_lyricScrollable, false);
        obtainStyledAttributes.recycle();
    }

    public LyricViewInternal a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LyricViewInternal) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f243180d;
    }

    public LyricViewScroll b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LyricViewScroll) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f243181e;
    }

    public boolean c(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f243181e.c(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onLayout(z16, i3, i16, i17, i18);
            this.f243180d.h(i18 - i16);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f243184i) {
            c(motionEvent);
            return true;
        }
        return false;
    }

    public void setIsDealTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f243184i = z16;
        }
    }
}
