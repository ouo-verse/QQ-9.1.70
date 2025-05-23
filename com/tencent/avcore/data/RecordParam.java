package com.tencent.avcore.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class RecordParam {
    static IPatchRedirector $redirector_;
    public int fps;
    public int height;
    public long intervalTime;
    public int width;

    public RecordParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.intervalTime = 67L;
        }
    }

    public boolean equals(Object obj) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        boolean z18 = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordParam)) {
            return false;
        }
        RecordParam recordParam = (RecordParam) obj;
        if (this.width == recordParam.width) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.height == recordParam.height) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 || this.fps != recordParam.fps) {
            z18 = false;
        }
        return z18;
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.width != 0 && this.height != 0 && this.fps != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "RecordParam{width: " + this.width + ", height: " + this.height + ", fps: " + this.fps + "}";
    }

    public boolean update(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        if (this.width != i3) {
            this.width = i3;
            z16 = true;
        }
        if (this.height != i16) {
            this.height = i16;
        } else {
            z17 = z16;
        }
        if (this.fps != i17) {
            this.fps = i17;
            if (i17 == 0) {
                this.fps = 15;
            }
            this.intervalTime = 1000 / this.fps;
        }
        return z17;
    }

    public boolean update(RecordParam recordParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) recordParam)).booleanValue();
        }
        boolean z16 = false;
        if (recordParam == null || !recordParam.isValid()) {
            return false;
        }
        int i3 = this.width;
        int i16 = recordParam.width;
        boolean z17 = true;
        if (i3 != i16) {
            this.width = i16;
            z16 = true;
        }
        int i17 = this.height;
        int i18 = recordParam.height;
        if (i17 != i18) {
            this.height = i18;
        } else {
            z17 = z16;
        }
        int i19 = this.fps;
        int i26 = recordParam.fps;
        if (i19 != i26) {
            this.fps = i26;
            if (i26 == 0) {
                this.fps = 15;
            }
            this.intervalTime = 1000 / this.fps;
        }
        return z17;
    }
}
