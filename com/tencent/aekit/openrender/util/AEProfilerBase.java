package com.tencent.aekit.openrender.util;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class AEProfilerBase implements IAEProfiler {
    static IPatchRedirector $redirector_;
    private final String TAG;
    public boolean mEnableBase;
    protected long mOneFrameCost;
    protected long mStartTime;

    public AEProfilerBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "AEProfilerBase";
        this.mEnableBase = false;
        this.mStartTime = 0L;
        this.mOneFrameCost = 0L;
    }

    @Override // com.tencent.aekit.openrender.util.IAEProfiler
    @CallSuper
    public long endByTag(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).longValue();
        }
        if (this.mEnableBase && !TextUtils.isEmpty(str)) {
            str.hashCode();
            if (str.equals(IAEProfiler.TAG_CAL_FPS)) {
                if (this.mStartTime != 0) {
                    this.mOneFrameCost = System.currentTimeMillis() - this.mStartTime;
                }
                return this.mOneFrameCost;
            }
        }
        return 0L;
    }

    @Override // com.tencent.aekit.openrender.util.IAEProfiler
    public String print() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.aekit.openrender.util.IAEProfiler
    @CallSuper
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mStartTime = 0L;
            this.mOneFrameCost = 0L;
        }
    }

    @Override // com.tencent.aekit.openrender.util.IAEProfiler
    @CallSuper
    public void startByTag(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (this.mEnableBase && !TextUtils.isEmpty(str)) {
            str.hashCode();
            if (str.equals(IAEProfiler.TAG_CAL_FPS)) {
                this.mStartTime = System.currentTimeMillis();
            }
        }
    }
}
