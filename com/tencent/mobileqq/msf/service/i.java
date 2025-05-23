package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final int f250922b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f250923c = 1;

    /* renamed from: a, reason: collision with root package name */
    private int f250924a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final i f250925a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29286);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250925a = new i(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ i(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static i a() {
        return b.f250925a;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247678d3, true, 0L, 0L, (Map<String, String>) new HashMap(), false, false);
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f250924a = h.d().c() / 1024;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(boolean z16, String str, int i3, int i16, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Long.valueOf(j3));
            return;
        }
        if (MsfService.getCore().getStatReporter() != null) {
            String valueOf = String.valueOf(!z16 ? 1 : 0);
            HashMap hashMap = new HashMap();
            hashMap.put(QzoneIPCModule.RESULT_CODE, valueOf);
            hashMap.put("failReason", str);
            hashMap.put("fromMsgLen", String.valueOf(i16 / 1024));
            hashMap.put("totalLen", String.valueOf((i3 + i16) / 1024));
            hashMap.put("packageLen", String.valueOf(this.f250924a));
            hashMap.put("cmd", str2);
            hashMap.put("sleepByIPCBlockTime", String.valueOf(j3));
            MsfService.getCore().getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247683e3, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }
}
