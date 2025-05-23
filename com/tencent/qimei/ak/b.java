package com.tencent.qimei.ak;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ag.e;
import com.tencent.qimei.ag.h;
import com.tencent.qimei.sdk.Qimei;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f343056a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f343057b;

    public b(String str, int i3) {
        this.f343056a = str;
        this.f343057b = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        long j3;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Build.VERSION.SDK_INT >= 24) {
            j3 = Process.getStartElapsedRealtime();
        } else {
            j3 = 0;
            elapsedRealtime = -1;
        }
        String valueOf = String.valueOf(elapsedRealtime - j3);
        Qimei a16 = com.tencent.qimei.an.a.a(this.f343056a);
        String str3 = "0";
        if (a16 == null) {
            str = "0";
        } else {
            str = "1";
            if (TextUtils.isEmpty(a16.getQimei16())) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            if (TextUtils.isEmpty(a16.getQimei36())) {
                str = "0";
            }
            str3 = str2;
        }
        String str4 = this.f343056a;
        long j16 = this.f343057b;
        h a17 = h.a();
        a17.getClass();
        e eVar = new e();
        eVar.f342975a.put("6", str3);
        eVar.f342975a.put("7", str);
        eVar.f342975a.put("8", String.valueOf(j16));
        eVar.f342975a.put("9", valueOf);
        a17.a(eVar, "v8", str4);
    }
}
