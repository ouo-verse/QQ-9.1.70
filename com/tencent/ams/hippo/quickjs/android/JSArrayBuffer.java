package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JSArrayBuffer extends JSObject {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSArrayBuffer(long j3, JSContext jSContext) {
        super(j3, jSContext, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext);
        }
    }

    public int getByteLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return ((JSNumber) getProperty("byteLength").cast(JSNumber.class)).getInt();
    }

    public boolean[] toBooleanArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (boolean[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return QuickJS.toBooleanArray(this.jsContext.pointer, this.pointer);
    }

    public byte[] toByteArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return QuickJS.toByteArray(this.jsContext.pointer, this.pointer);
    }

    public char[] toCharArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (char[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return QuickJS.toCharArray(this.jsContext.pointer, this.pointer);
    }

    public double[] toDoubleArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (double[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return QuickJS.toDoubleArray(this.jsContext.pointer, this.pointer);
    }

    public float[] toFloatArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (float[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return QuickJS.toFloatArray(this.jsContext.pointer, this.pointer);
    }

    public int[] toIntArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return QuickJS.toIntArray(this.jsContext.pointer, this.pointer);
    }

    public long[] toLongArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (long[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return QuickJS.toLongArray(this.jsContext.pointer, this.pointer);
    }

    public short[] toShortArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (short[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return QuickJS.toShortArray(this.jsContext.pointer, this.pointer);
    }
}
