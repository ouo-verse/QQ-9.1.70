package com.tencent.turingfd.sdk.xq;

import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.Cnative;

/* compiled from: P */
/* loaded from: classes27.dex */
public class n extends Cfor {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public final String f383399b;

    /* renamed from: c, reason: collision with root package name */
    public final Seedless f383400c;

    public n(Window.Callback callback, String str, Seedless seedless) {
        super(callback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, callback, str, seedless);
        } else {
            this.f383399b = str;
            this.f383400c = seedless;
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Cfor, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Apple apple;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        Seedless seedless = this.f383400c;
        String str = this.f383399b;
        Cnative.Cdo cdo = (Cnative.Cdo) seedless;
        if (!cdo.f383403a.get()) {
            synchronized (Apple.f382547i) {
                apple = Apple.f382549k;
                if (apple == null) {
                    apple = new Apple();
                } else {
                    Apple.f382549k = apple.f382550a;
                    Apple.f382548j--;
                    apple.f382550a = null;
                }
            }
            apple.f382551b = str;
            apple.f382552c = motionEvent.getAction();
            apple.f382553d = motionEvent.getDeviceId();
            apple.f382554e = motionEvent.getToolType(0);
            apple.f382555f = motionEvent.getPressure();
            apple.f382556g = motionEvent.getSize();
            apple.f382557h = System.currentTimeMillis();
            cdo.f383404b.obtainMessage(2, apple).sendToTarget();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
