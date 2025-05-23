package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Value {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG;
    private static final int TYPE_CONST = 0;
    private static final int TYPE_EXPRESSION = 1;
    private double mConstVal;
    private long mNativeExpression;
    private int mType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12931);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            TAG = Value.class.getSimpleName();
        }
    }

    public Value(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
            return;
        }
        this.mType = 0;
        this.mConstVal = 0.0d;
        this.mNativeExpression = -1L;
        if (obj instanceof Number) {
            this.mType = 0;
            this.mConstVal = ((Number) obj).doubleValue();
            this.mNativeExpression = -1L;
        } else if (obj instanceof String) {
            this.mType = 1;
            this.mNativeExpression = ParticleSystem.compile((String) obj);
        }
    }

    public long expression() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.mNativeExpression;
    }

    public double value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        if (this.mType == 0) {
            return this.mConstVal;
        }
        return 0.0d;
    }
}
