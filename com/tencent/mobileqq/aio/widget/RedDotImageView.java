package com.tencent.mobileqq.aio.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RedDotImageView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Paint f194215d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f194216e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f194217f;

    public RedDotImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    private void a(Canvas canvas) {
        if (this.f194215d == null) {
            Paint paint = new Paint();
            this.f194215d = paint;
            paint.setAntiAlias(true);
            this.f194216e = BitmapFactory.decodeResource(getResources(), R.drawable.skin_tips_dot);
        }
        canvas.drawBitmap(this.f194216e, getMeasuredWidth() - this.f194216e.getWidth(), 0.0f, this.f194215d);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f194217f) {
            a(canvas);
        }
    }

    public void setShowRedDot(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f194217f = z16;
            invalidate();
        }
    }
}
