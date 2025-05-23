package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CameraGridView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f254855d;

    /* renamed from: e, reason: collision with root package name */
    private int f254856e;

    /* renamed from: f, reason: collision with root package name */
    private int f254857f;

    /* renamed from: h, reason: collision with root package name */
    private int f254858h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f254859i;

    public CameraGridView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a() {
        Paint paint = new Paint();
        this.f254859i = paint;
        paint.setColor(-1);
        this.f254859i.setStyle(Paint.Style.FILL);
        this.f254859i.setStrokeWidth(x.c(getContext(), 0.5f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        int i3 = this.f254857f / (this.f254855d + 1);
        int i16 = this.f254858h / (this.f254856e + 1);
        for (int i17 = 1; i17 <= this.f254855d; i17++) {
            float f16 = i3 * i17;
            canvas.drawLine(f16, 0.0f, f16, this.f254858h, this.f254859i);
        }
        for (int i18 = 1; i18 <= this.f254856e; i18++) {
            float f17 = i16 * i18;
            canvas.drawLine(0.0f, f17, this.f254857f, f17, this.f254859i);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        this.f254857f = i3;
        this.f254858h = i16;
    }

    public CameraGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CameraGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f254855d = 2;
        this.f254856e = 2;
        this.f254859i = null;
        a();
    }
}
