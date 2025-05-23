package com.tencent.mobileqq.nativememorymonitor.library;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class Result {
    static IPatchRedirector $redirector_;
    private boolean mBoolean;
    private byte mByte;
    private char mChar;
    private double mDouble;
    private float mFloat;
    private int mInt;
    private long mLong;
    private Object mObject;
    private short mShort;

    public Result() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public Result(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mBoolean = z16;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
    }

    public Result(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mByte = b16;
        } else {
            iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
        }
    }

    public Result(char c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.mChar = c16;
        } else {
            iPatchRedirector.redirect((short) 4, this, Character.valueOf(c16));
        }
    }

    public Result(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.mDouble = d16;
        } else {
            iPatchRedirector.redirect((short) 5, this, Double.valueOf(d16));
        }
    }

    public Result(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.mFloat = f16;
        } else {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        }
    }

    public Result(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.mInt = i3;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }

    public Result(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.mLong = j3;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        }
    }

    public Result(short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.mShort = s16;
        } else {
            iPatchRedirector.redirect((short) 9, this, Short.valueOf(s16));
        }
    }

    public Result(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.mObject = obj;
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, obj);
        }
    }
}
