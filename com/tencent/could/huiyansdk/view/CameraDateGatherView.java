package com.tencent.could.huiyansdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.could.aicamare.CameraHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.view.TuringPreviewDisplay;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CameraDateGatherView extends TuringPreviewDisplay implements com.tencent.could.huiyansdk.turing.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f100330a;

    /* renamed from: b, reason: collision with root package name */
    public int f100331b;

    /* renamed from: c, reason: collision with root package name */
    public int f100332c;

    /* renamed from: d, reason: collision with root package name */
    public Point f100333d;

    /* renamed from: e, reason: collision with root package name */
    public Path f100334e;

    /* renamed from: f, reason: collision with root package name */
    public CameraHolder f100335f;

    public CameraDateGatherView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.could.huiyansdk.turing.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        CameraHolder cameraHolder = this.f100335f;
        if (cameraHolder != null) {
            cameraHolder.closeCamera();
        }
    }

    @Override // com.tencent.could.huiyansdk.turing.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        CameraHolder cameraHolder = this.f100335f;
        if (cameraHolder != null) {
            cameraHolder.startPreview(null);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.f100333d = new Point();
            this.f100334e = new Path();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipPath(this.f100334e);
        } else {
            canvas.clipPath(this.f100334e, Region.Op.REPLACE);
        }
        super.dispatchDraw(canvas);
    }

    public int getViewHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f100331b;
    }

    public int getViewWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f100330a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        this.f100330a = View.MeasureSpec.getSize(i3);
        int size = View.MeasureSpec.getSize(i16);
        this.f100331b = size;
        Point point = this.f100333d;
        int i17 = this.f100330a >> 1;
        point.x = i17;
        int i18 = size >> 1;
        point.y = i18;
        if (i17 > i18) {
            i17 = i18;
        }
        this.f100332c = i17;
        this.f100334e.reset();
        Path path = this.f100334e;
        Point point2 = this.f100333d;
        path.addCircle(point2.x, point2.y, this.f100332c, Path.Direction.CCW);
        this.f100332c -= Math.round(getResources().getDisplayMetrics().density * 1.9f);
        setMeasuredDimension(this.f100330a, this.f100331b);
    }

    @Override // com.tencent.could.huiyansdk.turing.a
    public void setCameraHolder(CameraHolder cameraHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cameraHolder);
        } else {
            this.f100335f = cameraHolder;
        }
    }

    public CameraDateGatherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CameraDateGatherView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
