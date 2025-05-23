package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ez;
import uy2.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class VipTagView extends TextView implements a.b {
    static IPatchRedirector $redirector_;
    private static final int[] E;
    private boolean C;
    private Bitmap D;

    /* renamed from: d, reason: collision with root package name */
    private int f260516d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f260517e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f260518f;

    /* renamed from: h, reason: collision with root package name */
    private ez<Float> f260519h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.profile.view.helper.a f260520i;

    /* renamed from: m, reason: collision with root package name */
    private float f260521m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ez.f<Float> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipTagView.this);
            }
        }

        @Override // com.tencent.mobileqq.utils.ez.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ez<Float> ezVar, float f16, Float f17, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                VipTagView.this.f260521m = f17.floatValue();
                VipTagView.this.invalidate();
            } else {
                iPatchRedirector.redirect((short) 2, this, ezVar, Float.valueOf(f16), f17, transformation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipTagView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            if (VipTagView.this.f260517e) {
                VipTagView.this.f260520i.n();
            }
            VipTagView.this.C = false;
            VipTagView.this.invalidate();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                VipTagView.this.f260521m = 0.0f;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73903);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            E = new int[]{R.dimen.ani, R.dimen.anj, R.dimen.ank, R.dimen.anl, R.dimen.anm};
        }
    }

    public VipTagView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f260516d = 0;
        this.f260517e = false;
        this.C = false;
        i();
    }

    private void i() {
        setClickable(true);
        Resources resources = getResources();
        setTextSize(0, resources.getDimensionPixelSize(R.dimen.an_));
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ane);
        Paint paint = new Paint();
        this.f260518f = paint;
        paint.setColor(-16777216);
        float f16 = dimensionPixelSize;
        this.f260518f.setTextSize(f16);
        this.f260518f.setTextAlign(Paint.Align.LEFT);
        this.D = Bitmap.createBitmap((int) this.f260518f.measureText("+1"), dimensionPixelSize, Bitmap.Config.ARGB_4444);
        new Canvas(this.D).drawText("+1", 0.0f, f16, this.f260518f);
        this.f260520i = new com.tencent.mobileqq.profile.view.helper.a(this);
        ez<Float> ezVar = new ez<>(Float.valueOf(0.0f), Float.valueOf(1.0f), new a());
        this.f260519h = ezVar;
        ezVar.setDuration(800L);
        this.f260519h.setInterpolator(new DecelerateInterpolator());
        this.f260519h.setAnimationListener(new b());
    }

    private void k(int i3) {
        setBackgroundResource(R.drawable.ap_);
        if (i3 > 0 && i3 <= 5) {
            Drawable background = getBackground();
            if (background instanceof GradientDrawable) {
                Resources resources = getResources();
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                gradientDrawable.mutate();
                int dimensionPixelSize = resources.getDimensionPixelSize(E[i3 - 1]);
                gradientDrawable.setSize(dimensionPixelSize, dimensionPixelSize);
            }
        }
    }

    private void l(Canvas canvas) {
        if (this.C) {
            int height = getHeight();
            int height2 = this.D.getHeight();
            float f16 = this.f260521m;
            canvas.save();
            float f17 = (height * 0.8f) + height2;
            canvas.translate(getWidth() - this.D.getWidth(), f17 + ((-f17) * this.f260521m));
            this.f260518f.setAlpha((int) (255.0f - (this.f260521m * 200.0f)));
            canvas.scale(f16, f16);
            canvas.drawBitmap(this.D, 0.0f, 0.0f, this.f260518f);
            canvas.restore();
        }
    }

    private void m() {
        String str;
        int i3 = this.f260516d;
        if (i3 <= 99) {
            str = String.valueOf(i3);
        } else {
            str = "99+";
        }
        if (getText() instanceof String) {
            String str2 = (String) getText();
            setText(str2.substring(0, str2.indexOf(40)) + "(" + str + ")");
        }
    }

    @Override // uy2.a.b
    public void a(a.InterfaceC11376a interfaceC11376a, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, interfaceC11376a, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // uy2.a.b
    public void b(a.InterfaceC11376a interfaceC11376a, a.c cVar, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, interfaceC11376a, cVar, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // uy2.a.b
    public boolean c(a.InterfaceC11376a interfaceC11376a, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, interfaceC11376a, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        bringToFront();
        this.f260520i.o();
        return true;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f260516d++;
        this.C = true;
        startAnimation(this.f260519h);
        m();
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f260520i.m();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
            l(canvas);
        }
    }

    public void setLabelAndPraise(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        setLabelText(str);
        this.f260516d = i3;
        m();
    }

    public void setLabelText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (str.length() > 5) {
            str = str.substring(0, 5);
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            sb5.append(charArray[i3]);
            if (str.length() > 3 && i3 == 1) {
                sb5.append('\n');
            }
        }
        sb5.append("\n(0)");
        setText(sb5);
        k(str.length());
    }

    public void setShakingState(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        this.f260517e = z16;
        if (z16) {
            this.f260520i.n();
        } else {
            this.f260520i.o();
        }
    }

    public void setTagColor(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Drawable background = getBackground();
        if (background instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            gradientDrawable.setColor(i16);
            gradientDrawable.setStroke(2, i3);
        }
    }

    public VipTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public VipTagView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f260516d = 0;
        this.f260517e = false;
        this.C = false;
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.text});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                setLabelText(string);
            }
            i();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
