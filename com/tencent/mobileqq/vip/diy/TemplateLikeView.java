package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dating.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.VoteViewV2;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TemplateLikeView extends VoteViewV2 {
    static IPatchRedirector $redirector_;

    /* renamed from: d0, reason: collision with root package name */
    protected ViewGroup f312938d0;

    /* renamed from: e0, reason: collision with root package name */
    protected ViewGroup f312939e0;

    /* renamed from: f0, reason: collision with root package name */
    protected TextView f312940f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f312941g0;

    /* renamed from: h0, reason: collision with root package name */
    protected int f312942h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f312943i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f312944j0;

    /* renamed from: k0, reason: collision with root package name */
    protected URLDrawable f312945k0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TemplateLikeView.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            } else {
                TemplateLikeView.this.f312938d0.invalidate();
                TemplateLikeView.this.f312939e0.invalidate();
            }
        }
    }

    public TemplateLikeView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        super.d(i3);
        if (this.C == 1) {
            TextView textView = this.f312940f0;
            if (textView != null) {
                textView.setTextColor(getContext().getResources().getColor(R.color.skin_gray2));
                this.f316537m.setTextColor(getContext().getResources().getColor(R.color.skin_gray2));
                return;
            }
            return;
        }
        TextView textView2 = this.f312940f0;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getResources().getColor(R.color.skin_white));
            this.f316537m.setTextColor(getContext().getResources().getColor(R.color.skin_white));
        }
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return R.layout.f168966bf2;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) drawable);
        } else {
            super.invalidateDrawable(drawable);
            hd0.c.g("zhiqiang", "invalidateDrawable");
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
            hd0.c.a("zhiqiang", "draw +++++++++++");
        }
    }

    @Override // com.tencent.mobileqq.widget.VoteViewV2
    public void r(boolean z16, boolean z17, int i3, int i16, j jVar, boolean z18, int i17, Boolean bool, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), jVar, Boolean.valueOf(z18), Integer.valueOf(i17), bool, str);
            return;
        }
        super.r(z16, z17, i3, i16, jVar, z18, i17, bool, str);
        ViewGroup.LayoutParams layoutParams = this.f312938d0.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f312939e0.getLayoutParams();
        int measureText = (int) (this.f312941g0 + this.f312942h0 + this.f312940f0.getPaint().measureText(HardCodeUtil.qqStr(R.string.u1t) + this.f316535h.getText().toString()) + UIUtils.b(getContext(), 30.0f));
        this.f312943i0 = measureText;
        layoutParams.width = measureText;
        layoutParams2.width = measureText;
        this.f312938d0.setLayoutParams(layoutParams);
        this.f312939e0.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = super.getLayoutParams();
        layoutParams3.width = this.f312943i0;
        if (x.f(getContext()).f185860a <= 1080 && FontSettingManager.getFontLevel() > 17.0f) {
            setScaleX(0.65f);
            setScaleY(0.65f);
        }
        super.setLayoutParams(layoutParams3);
        URLDrawable uRLDrawable = this.f312945k0;
        if (uRLDrawable != null) {
            uRLDrawable.invalidateSelf();
        }
    }

    public void setContainerLayoutParams(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f312942h0 = i18;
        this.f312941g0 = i17;
        ViewGroup.LayoutParams layoutParams = this.f312938d0.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f312939e0.getLayoutParams();
        int measureText = (int) (this.f312941g0 + this.f312942h0 + this.f312940f0.getPaint().measureText(HardCodeUtil.qqStr(R.string.u1v) + this.f316533e) + UIUtils.b(getContext(), 30.0f));
        this.f312943i0 = measureText;
        this.f312944j0 = i16;
        layoutParams.width = measureText;
        layoutParams.height = i16;
        layoutParams2.width = measureText;
        layoutParams2.height = i16;
        this.f312938d0.setLayoutParams(layoutParams);
        this.f312939e0.setLayoutParams(layoutParams2);
    }

    public void setVoteContainerBackground(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable);
            return;
        }
        URLDrawable uRLDrawable2 = this.f312945k0;
        if (uRLDrawable2 != null) {
            uRLDrawable2.setURLDrawableListener(null);
        }
        this.f312945k0 = uRLDrawable;
        if (uRLDrawable != null && uRLDrawable.getStatus() != 1) {
            uRLDrawable.setURLDrawableListener(new a());
        }
        this.f312938d0.setBackgroundDrawable(uRLDrawable);
        this.f312939e0.setBackgroundDrawable(uRLDrawable);
    }

    public TemplateLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TemplateLikeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f312941g0 = 0;
        this.f312942h0 = 0;
        this.f312938d0 = (ViewGroup) findViewById(R.id.l0c);
        this.f312939e0 = (ViewGroup) findViewById(R.id.e2d);
        this.f312940f0 = (TextView) findViewById(R.id.l0m);
    }
}
