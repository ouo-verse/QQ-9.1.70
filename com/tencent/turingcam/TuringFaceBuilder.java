package com.tencent.turingcam;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingface.sdk.mfa.e;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuringFaceBuilder {
    static IPatchRedirector $redirector_;
    private int channel;
    private boolean disableGetProp;
    private String hostUrl;
    private Context mContext;
    private boolean mIsHardwareAcceleration;
    private e turingNetwork;

    TuringFaceBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsHardwareAcceleration = true;
            this.disableGetProp = false;
        }
    }

    public static TuringFaceBuilder build() {
        return new TuringFaceBuilder();
    }

    public TuringFaceBuilder disableGetProp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (TuringFaceBuilder) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        this.disableGetProp = true;
        return this;
    }

    public int getChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.channel;
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContext;
    }

    public String getHostUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.hostUrl;
    }

    public e getTuringNetwork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (e) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.turingNetwork;
    }

    public boolean isDisableGetProp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.disableGetProp;
    }

    public boolean isHardwareAcceleration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mIsHardwareAcceleration;
    }

    public TuringFaceBuilder setChannel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TuringFaceBuilder) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        this.channel = i3;
        return this;
    }

    public TuringFaceBuilder setContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TuringFaceBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        this.mContext = context.getApplicationContext();
        return this;
    }

    public TuringFaceBuilder setHostUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TuringFaceBuilder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        this.hostUrl = str;
        return this;
    }

    public TuringFaceBuilder setIsHardwareAcceleration(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TuringFaceBuilder) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        this.mIsHardwareAcceleration = z16;
        return this;
    }

    public TuringFaceBuilder setTuringNetwork(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TuringFaceBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        }
        this.turingNetwork = eVar;
        return this;
    }
}
