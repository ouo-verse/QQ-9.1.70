package com.tencent.mobileqq.splashad.slopeslide;

import android.graphics.Path;
import com.tencent.gdtad.basics.adshake.animatorview.layer.PathShapeLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends PathShapeLayer {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private float f288923d;

    /* renamed from: e, reason: collision with root package name */
    private float f288924e;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Path a(float f16) {
        Path path = new Path();
        float f17 = this.f288923d;
        float width = getWidth() + f17;
        float height = getHeight() + this.f288924e;
        float height2 = height - (getHeight() * f16);
        path.moveTo(f17, height);
        path.lineTo(width, height);
        path.lineTo(width, height2);
        path.lineTo(f17, height2);
        path.transform(getMatrix());
        return path;
    }

    public void b(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f288923d = f16;
            this.f288924e = f17;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r5 > 1.0f) goto L10;
     */
    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.PathShapeLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        float f17 = 0.0f;
        if (f16 >= 0.0f) {
            f17 = 1.0f;
        }
        f16 = f17;
        super.postProgress(f16);
        setPath(a(f16));
    }
}
