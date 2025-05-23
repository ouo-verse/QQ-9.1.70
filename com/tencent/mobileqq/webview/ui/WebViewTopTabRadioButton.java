package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewTopTabRadioButton extends RadioButton {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    Bitmap f314836d;

    /* renamed from: e, reason: collision with root package name */
    int f314837e;

    /* renamed from: f, reason: collision with root package name */
    int f314838f;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f314839h;

    /* renamed from: i, reason: collision with root package name */
    Bitmap f314840i;

    public WebViewTopTabRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f314837e = 0;
        this.f314838f = x.c(super.getContext(), 2.0f);
        this.f314839h = false;
    }

    Bitmap a(Context context) {
        Bitmap bitmap = this.f314836d;
        if (bitmap == null || bitmap.isRecycled()) {
            try {
                this.f314836d = BitmapFactory.decodeResource(context.getResources(), R.drawable.skin_tips_dot);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
            }
        }
        return this.f314836d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f314839h) {
            Bitmap a16 = a(super.getContext());
            this.f314840i = a16;
            if (a16 != null && !a16.isRecycled()) {
                canvas.drawBitmap(this.f314840i, this.f314837e, this.f314838f, (Paint) null);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        int c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        Bitmap a16 = a(super.getContext());
        this.f314840i = a16;
        if (a16 != null && !a16.isRecycled()) {
            c16 = this.f314840i.getWidth();
        } else {
            c16 = x.c(super.getContext(), 9.0f);
        }
        this.f314837e = (i3 - c16) - x.c(super.getContext(), 3.0f);
    }
}
