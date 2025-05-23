package com.tencent.mobileqq.ptt;

import android.content.Context;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k extends com.tencent.wstt.SSCM.a {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.wstt.SSCM.a
    public int a(Context context, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(j3))).intValue();
        }
        this.f384868d = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        return g(j3);
    }

    protected int g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, j3)).intValue();
        }
        if (!this.f384885u) {
            int i3 = this.f384868d;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            this.f384872h = 4096;
                        } else {
                            this.f384872h = 32768;
                        }
                    } else {
                        this.f384872h = 16384;
                    }
                } else {
                    this.f384872h = 8192;
                }
            } else {
                this.f384872h = 32768;
            }
        }
        if (j3 < FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            this.f384872h *= 4;
        }
        if (j3 - this.f384872h <= r0 / 2) {
            this.f384872h = (int) j3;
        }
        return this.f384872h;
    }
}
