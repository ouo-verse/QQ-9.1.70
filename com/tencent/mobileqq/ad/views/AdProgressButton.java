package com.tencent.mobileqq.ad.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes10.dex */
public final class AdProgressButton extends TextView {
    static IPatchRedirector $redirector_;
    private final int C;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private a f186979d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f186980e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f186981f;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private Rect f186982h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private RectF f186983i;

    /* renamed from: m, reason: collision with root package name */
    private volatile float f186984m;

    /* loaded from: classes10.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f186985a;

        /* renamed from: b, reason: collision with root package name */
        public int f186986b;

        /* renamed from: c, reason: collision with root package name */
        public int f186987c;

        /* renamed from: d, reason: collision with root package name */
        public int f186988d;

        /* renamed from: e, reason: collision with root package name */
        public int f186989e;

        /* renamed from: f, reason: collision with root package name */
        public int f186990f;

        /* renamed from: g, reason: collision with root package name */
        public int f186991g;

        /* renamed from: h, reason: collision with root package name */
        public int f186992h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f186985a = 0;
            this.f186986b = -16776961;
            this.f186987c = -1;
            this.f186988d = -7829368;
            this.f186989e = -16777216;
            this.f186990f = 0;
            this.f186991g = 0;
            this.f186992h = -16776961;
        }
    }

    public AdProgressButton(@NotNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f186982h = new Rect();
        this.f186983i = new RectF();
        this.f186984m = 100.0f;
        this.C = 100;
    }

    @NonNull
    private static Drawable a(@NonNull a aVar, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i3);
        int i16 = aVar.f186990f;
        if (i16 > 0) {
            gradientDrawable.setCornerRadius(i16);
        }
        int i17 = aVar.f186991g;
        if (i17 > 0) {
            gradientDrawable.setStroke(i17, aVar.f186992h);
        }
        return gradientDrawable;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f186982h.set(0, 0, width, height);
        this.f186983i.set(0.0f, 0.0f, width * (this.f186984m / 100.0f), height);
        canvas.save();
        canvas.clipRect(this.f186983i);
        this.f186980e.setBounds(this.f186982h);
        this.f186980e.draw(canvas);
        setTextColor(this.f186979d.f186987c);
        super.onDraw(canvas);
        canvas.restore();
        if (this.f186984m < 100.0f) {
            canvas.save();
            canvas.clipRect(this.f186983i, Region.Op.DIFFERENCE);
            this.f186981f.setBounds(this.f186982h);
            this.f186981f.draw(canvas);
            setTextColor(this.f186979d.f186989e);
            super.onDraw(canvas);
            canvas.restore();
        }
    }

    public void setParams(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            AdLog.e("AdProgressButton", "init error");
            return;
        }
        this.f186979d = aVar;
        try {
            setSingleLine(false);
            setLines(1);
            setGravity(17);
            setEllipsize(TextUtils.TruncateAt.END);
            int dp2px = AdUIUtils.dp2px(5.0f, getContext().getResources());
            setPadding(dp2px, 0, dp2px, 0);
            int i3 = aVar.f186985a;
            if (i3 > 0) {
                setTextSize(0, i3);
            }
            setTextColor(aVar.f186987c);
            this.f186980e = a(aVar, aVar.f186986b);
            this.f186981f = a(aVar, aVar.f186988d);
        } catch (Exception e16) {
            AdLog.e("AdProgressButton", "init error:", e16);
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        float min = Math.min(Math.max(0, i3), 100);
        if (min != this.f186984m) {
            this.f186984m = min;
            invalidate();
        }
    }

    public AdProgressButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f186982h = new Rect();
        this.f186983i = new RectF();
        this.f186984m = 100.0f;
        this.C = 100;
    }

    public AdProgressButton(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f186982h = new Rect();
        this.f186983i = new RectF();
        this.f186984m = 100.0f;
        this.C = 100;
    }
}
