package com.tencent.mobileqq.msfcore;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* loaded from: classes15.dex */
public class MSFPkgCompressConfig implements MSFConfig {
    static IPatchRedirector $redirector_;
    int mCompressThreshold;
    HashMap<String, Integer> mCompressThresholdMap;
    boolean mIsOpen;
    int mType;

    public MSFPkgCompressConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mCompressThresholdMap = new HashMap<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public int getCompressThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mCompressThreshold;
    }

    @NonNull
    public HashMap<String, Integer> getCompressThresholdMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mCompressThresholdMap;
    }

    public boolean getIsOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mIsOpen;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mType;
    }

    public void setCompressThreshold(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mCompressThreshold = i3;
        }
    }

    @NonNull
    public void setCompressThresholdMap(HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) hashMap);
        } else {
            this.mCompressThresholdMap = hashMap;
        }
    }

    public void setIsOpen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mIsOpen = z16;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "MSFPkgCompressConfig{mType=" + this.mType + ",mIsOpen=" + this.mIsOpen + ",mCompressThreshold=" + this.mCompressThreshold + ",mCompressThresholdMap=" + this.mCompressThresholdMap + ",}";
    }

    public MSFPkgCompressConfig(int i3, boolean z16, int i16, @NonNull HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), hashMap);
            return;
        }
        new HashMap();
        this.mType = i3;
        this.mIsOpen = z16;
        this.mCompressThreshold = i16;
        this.mCompressThresholdMap = hashMap;
    }
}
