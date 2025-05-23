package com.tencent.turingcam;

import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.AExmx;

/* loaded from: classes27.dex */
public class OViPc extends CTNYx {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public final String f382013b;

    /* renamed from: c, reason: collision with root package name */
    public final eDqyI f382014c;

    public OViPc(Window.Callback callback, String str, eDqyI edqyi) {
        super(callback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, callback, str, edqyi);
        } else {
            this.f382013b = str;
            this.f382014c = edqyi;
        }
    }

    @Override // com.tencent.turingcam.CTNYx, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        di6n2 di6n2Var;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        eDqyI edqyi = this.f382014c;
        String str = this.f382013b;
        AExmx.spXPg spxpg = (AExmx.spXPg) edqyi;
        if (!spxpg.f381721a.get()) {
            synchronized (di6n2.f382189i) {
                di6n2Var = di6n2.f382191k;
                if (di6n2Var == null) {
                    di6n2Var = new di6n2();
                } else {
                    di6n2.f382191k = di6n2Var.f382192a;
                    di6n2.f382190j--;
                    di6n2Var.f382192a = null;
                }
            }
            di6n2Var.f382193b = str;
            di6n2Var.f382194c = motionEvent.getAction();
            di6n2Var.f382195d = motionEvent.getDeviceId();
            di6n2Var.f382196e = motionEvent.getToolType(0);
            di6n2Var.f382197f = motionEvent.getPressure();
            di6n2Var.f382198g = motionEvent.getSize();
            di6n2Var.f382199h = System.currentTimeMillis();
            spxpg.f381722b.obtainMessage(2, di6n2Var).sendToTarget();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
