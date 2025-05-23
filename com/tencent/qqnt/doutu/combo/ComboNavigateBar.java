package com.tencent.qqnt.doutu.combo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.doutu.combo.ComboResource;

/* compiled from: P */
/* loaded from: classes24.dex */
public class ComboNavigateBar extends LinearLayout implements Animation.AnimationListener, View.OnClickListener {
    static IPatchRedirector $redirector_;
    a C;
    protected Animation D;
    protected Animation E;
    private boolean F;
    private String G;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f356060d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f356061e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f356062f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f356063h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f356064i;

    /* renamed from: m, reason: collision with root package name */
    private BaseQQAppInterface f356065m;

    public ComboNavigateBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = null;
        this.E = null;
        this.F = true;
        this.G = "";
    }

    private Drawable a(View view, ComboResource.a aVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = aVar.f356077a;
        layoutParams.height = aVar.f356078b;
        return aVar.f356079c;
    }

    private boolean d() {
        ComboResource.a d16 = ComboResource.d(this.f356065m.getApplicationContext());
        if (d16 == null) {
            this.F = false;
            return false;
        }
        ImageView imageView = this.f356064i;
        imageView.setImageDrawable(a(imageView, d16));
        return true;
    }

    private boolean e() {
        ComboResource.a g16 = ComboResource.g(this.f356065m.getApplicationContext());
        if (g16 == null) {
            this.F = false;
            return false;
        }
        ImageView imageView = this.f356060d;
        imageView.setImageDrawable(a(imageView, g16));
        return true;
    }

    private boolean f(ImageView imageView, int i3) {
        ComboResource.a h16 = ComboResource.h(i3, this.f356065m.getApplicationContext());
        if (h16 == null) {
            this.F = false;
            return false;
        }
        imageView.setImageDrawable(a(imageView, h16));
        return true;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.E != null && getVisibility() == 0) {
            clearAnimation();
            startAnimation(this.E);
        }
    }

    public void c(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.f356065m = baseQQAppInterface;
        this.f356064i = (ImageView) findViewById(R.id.f164111jx);
        this.f356060d = (ImageView) findViewById(R.id.f164105jr);
        this.f356061e = (ImageView) findViewById(R.id.f164106js);
        this.f356062f = (ImageView) findViewById(R.id.f164107jt);
        this.f356063h = (ImageView) findViewById(R.id.f164108ju);
        setVisibility(8);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.E = translateAnimation;
        translateAnimation.setDuration(500L);
        this.E.setAnimationListener(this);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) animation);
        } else if (animation.equals(this.E)) {
            setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setCountNum() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int i17 = this.C.f356081b;
        int i18 = i17 % 10;
        int i19 = i17 / 10;
        if (i19 != 0) {
            i3 = i19 % 10;
            i19 /= 10;
        } else {
            i3 = 0;
        }
        if (i19 != 0) {
            i16 = i19 % 100;
        } else {
            i16 = 0;
        }
        e();
        d();
        this.f356063h.setVisibility(0);
        f(this.f356063h, i18);
        if (i16 == 0) {
            if (i3 == 0) {
                this.f356062f.setVisibility(8);
                this.f356061e.setVisibility(8);
                return;
            } else {
                this.f356062f.setVisibility(0);
                this.f356061e.setVisibility(8);
                f(this.f356062f, i3);
                return;
            }
        }
        this.f356062f.setVisibility(0);
        this.f356061e.setVisibility(0);
        f(this.f356062f, i3);
        f(this.f356061e, i16);
    }

    public void setInfo(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.C = aVar;
        this.F = true;
        String str = aVar.f356080a;
        setCountNum();
        if (this.F) {
            setVisibility(0);
            setOnClickListener(this);
        } else {
            setVisibility(8);
        }
    }
}
