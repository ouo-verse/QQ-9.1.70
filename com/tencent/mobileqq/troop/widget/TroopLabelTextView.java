package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopLabelTextView extends TextView implements ThemeImageWrapper.DrawInterface {
    static IPatchRedirector $redirector_;
    private Paint C;
    private PorterDuffXfermode D;
    private Bitmap E;
    private Canvas F;
    public ThemeImageWrapper G;

    /* renamed from: d, reason: collision with root package name */
    protected int f302452d;

    /* renamed from: e, reason: collision with root package name */
    private Context f302453e;

    /* renamed from: f, reason: collision with root package name */
    private int f302454f;

    /* renamed from: h, reason: collision with root package name */
    public int f302455h;

    /* renamed from: i, reason: collision with root package name */
    private int f302456i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f302457m;

    public TroopLabelTextView(Context context, int i3, int i16, int i17) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f302452d = i3;
        setTextColor(i16);
        setMaxLines(1);
        setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(16.0f));
        layoutParams.rightMargin = 4;
        int dip2px = ViewUtils.dip2px(4.0f);
        int dip2px2 = ViewUtils.dip2px(4.0f);
        int dip2px3 = ViewUtils.dip2px(0.0f);
        int dip2px4 = ViewUtils.dip2px(0.0f);
        setTextSize(1, 10.0f);
        if (i17 == 2) {
            dip2px = ViewUtils.dip2px(10.0f);
        } else if (i17 != 1 && i17 != 4) {
            if (i17 == 3) {
                setIncludeFontPadding(false);
                dip2px = ViewUtils.dip2px(6.0f);
                dip2px2 = ViewUtils.dip2px(6.0f);
                dip2px4 = ViewUtils.dip2px(3.0f);
                dip2px3 = ViewUtils.dip2px(3.0f);
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.rightMargin = ViewUtils.dpToPx(4.0f);
            }
        } else {
            setIncludeFontPadding(false);
            layoutParams.height = ViewUtils.dip2px(14.0f);
        }
        setLayoutParams(layoutParams);
        setPadding(dip2px, dip2px3, dip2px2, dip2px4);
        this.f302453e = context;
        this.f302454f = i17;
        this.f302455h = ViewUtils.dip2px(2.0f);
        this.f302456i = ViewUtils.dip2px(5.0f);
        a();
        if (i17 == 4) {
            this.G.setThirtyTransparencyMask();
        }
    }

    private void a() {
        ThemeImageWrapper themeImageWrapper = new ThemeImageWrapper();
        this.G = themeImageWrapper;
        themeImageWrapper.setSupportMaskView(true);
        this.G.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else {
            super.draw(canvas);
            this.G.onDraw(canvas, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.f302454f == 2 && this.f302457m != null) {
            this.C.setXfermode(this.D);
            this.F.drawColor(this.f302452d);
            this.F.drawBitmap(this.f302457m, 0.0f, 0.0f, this.C);
            this.C.setXfermode(null);
            canvas.drawBitmap(this.E, 0.0f, 0.0f, this.C);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int color = ContextCompat.getColor(this.f302453e, R.color.qui_common_fill_standard_primary);
        super.onLayout(z16, i3, i16, i17 + getPaddingLeft() + getPaddingRight(), i18);
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i26 = this.f302454f;
        if (i26 != 1 && i26 != 4) {
            if (i26 == 0) {
                gradientDrawable.setStroke(2, color);
                i19 = getHeight() / 2;
            } else if (i26 == 3) {
                gradientDrawable.setColor(color);
                i19 = ViewUtils.dip2px(4.0f);
            }
        } else {
            gradientDrawable.setColor(color);
            i19 = this.f302455h;
        }
        gradientDrawable.setCornerRadius(i19);
        setBackgroundDrawable(gradientDrawable);
    }

    public void setColor(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f302452d = i3;
            setTextColor(i16);
        }
    }

    public void setMaskImage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i3);
            this.f302457m = decodeResource;
            this.E = Bitmap.createBitmap(decodeResource.getWidth(), this.f302457m.getHeight(), Bitmap.Config.ARGB_8888);
            this.F = new Canvas(this.E);
            this.C = new Paint(1);
            this.D = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopLabelTextView", 2, "TroopLabelTextView setMaskImage OOM");
            }
        }
    }

    @Override // com.tencent.widget.ThemeImageWrapper.DrawInterface
    public void superOnDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
        } else {
            super.draw(canvas);
        }
    }
}
