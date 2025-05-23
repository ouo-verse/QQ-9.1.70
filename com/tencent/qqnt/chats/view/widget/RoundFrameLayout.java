package com.tencent.qqnt.chats.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes24.dex */
public class RoundFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f355661m;

    /* renamed from: d, reason: collision with root package name */
    private Path f355662d;

    /* renamed from: e, reason: collision with root package name */
    private int f355663e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f355664f;

    /* renamed from: h, reason: collision with root package name */
    private int f355665h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f355666i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57714);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f355661m = new int[]{1, 2, 4, 8};
        }
    }

    public RoundFrameLayout(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(Canvas canvas) {
        int i3 = 0;
        while (true) {
            float[] fArr = this.f355666i;
            if (i3 < fArr.length) {
                if ((f355661m[i3 / 2] & this.f355665h) != 0) {
                    fArr[i3] = this.f355663e;
                } else {
                    fArr[i3] = 0.0f;
                }
                i3++;
            } else {
                this.f355662d.reset();
                this.f355662d.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f355666i, Path.Direction.CW);
                canvas.drawPath(this.f355662d, this.f355664f);
                return;
            }
        }
    }

    private void b() {
        Path path = new Path();
        this.f355662d = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Paint paint = new Paint(1);
        this.f355664f = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f355664f.setColor(0);
        this.f355664f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        if (this.f355663e != 0 && this.f355665h != 0) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
            super.draw(canvas);
            try {
                try {
                    a(canvas);
                } catch (Exception e16) {
                    QLog.i("RoundFrameLayout", 1, "checkPathChanged", e16);
                    this.f355663e = 0;
                }
                return;
            } finally {
                canvas.restoreToCount(saveLayer);
            }
        }
        super.draw(canvas);
    }

    public void setCorners(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f355665h = i3;
        }
    }

    public void setRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f355663e = i3;
        }
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f355663e = 0;
        this.f355665h = 15;
        this.f355666i = new float[8];
        b();
    }
}
