package com.tencent.mtgpa.haptic;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtgpa.haptic.android.PatternPlayer;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mtgpa.haptic.base.a f336875a;

    /* renamed from: b, reason: collision with root package name */
    private int f336876b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f336876b = 2;
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            b(str, 1, 50, 255, 100);
        }
    }

    public void b(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (str == null) {
            Log.e("MTGPA_HapticPlayer", "parameter is invalid, he json is null!");
            return;
        }
        if (i3 < 1) {
            Log.w("MTGPA_HapticPlayer", "parameter is invalid, loop should >= 1! loop: " + i3);
            return;
        }
        if (i16 <= 1000 && i16 >= 0) {
            if (i17 >= 0 && i17 <= 255) {
                if (i18 >= 0 && i18 <= 100) {
                    com.tencent.mtgpa.haptic.base.a aVar = this.f336875a;
                    if (aVar != null) {
                        aVar.a(str, i3, i16, i17, i18);
                        return;
                    } else {
                        Log.e("MTGPA_HapticPlayer", "prepare first, before playing haptic effect!");
                        return;
                    }
                }
                Log.e("MTGPA_HapticPlayer", "parameter is invalid, frequency should in [0, 100], now is " + i18 + " !");
                return;
            }
            Log.e("MTGPA_HapticPlayer", "parameter is invalid, amplitude should in [0, 255], now is " + i17 + " !");
            return;
        }
        Log.e("MTGPA_HapticPlayer", "parameter is invalid, interval should in [0, 1000].");
    }

    public void c(Context context) {
        com.tencent.mtgpa.haptic.base.a patternPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        if (this.f336876b == 2 && com.tencent.mtgpa.haptic.vendor.a.c()) {
            Log.i("MTGPA_HapticPlayer", "this device support standard haptic player!");
            this.f336876b = 2;
            patternPlayer = new com.tencent.mtgpa.haptic.vendor.a();
        } else {
            Log.w("MTGPA_HapticPlayer", "this device don't support standard haptic player! start to use android pattern player!");
            this.f336876b = 1;
            patternPlayer = new PatternPlayer();
        }
        this.f336875a = patternPlayer;
        this.f336875a.b(context);
    }
}
