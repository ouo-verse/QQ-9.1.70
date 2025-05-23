package com.tencent.mobileqq.ptt;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes16.dex */
public class j implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f261240a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f261241b;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f261240a = 0L;
            this.f261241b = new int[]{0, 500, 700, 1000, 1500, 2100, 2800, QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES, 4200, 4800, 5000};
        }
    }

    @Override // com.tencent.mobileqq.ptt.a
    public int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        int i16 = 0;
        while (true) {
            int[] iArr = this.f261241b;
            if (i16 < iArr.length) {
                if (i3 >= iArr[i16]) {
                    i16++;
                } else {
                    return i16;
                }
            } else {
                return 1;
            }
        }
    }

    @Override // com.tencent.mobileqq.ptt.a
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return c(SystemClock.uptimeMillis());
    }

    protected boolean c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, j3)).booleanValue();
        }
        long j16 = this.f261240a;
        if (j16 == 0) {
            this.f261240a = j3;
        } else if (j3 - j16 < 75) {
            return false;
        }
        this.f261240a = j3;
        return true;
    }
}
