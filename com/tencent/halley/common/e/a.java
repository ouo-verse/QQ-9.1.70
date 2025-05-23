package com.tencent.halley.common.e;

import com.tencent.halley.common.a.c;
import com.tencent.halley.common.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.standard.report.BaseEvent;
import com.tencent.raft.standard.report.IRReport;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public IRReport f113532a;

    /* compiled from: P */
    /* renamed from: com.tencent.halley.common.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1242a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f113533a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16499);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f113533a = new a((byte) 0);
            }
        }

        public static /* synthetic */ a a() {
            return f113533a;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f113532a = null;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("qddQua1", com.tencent.halley.downloader.a.a.f113578a);
        hashMap.put("qddQua2", com.tencent.halley.downloader.a.a.f113579b);
        hashMap.put("qddAppId", String.valueOf(com.tencent.halley.common.a.c()));
        hashMap.put("qddGuid", com.tencent.halley.downloader.a.a.f113580c);
        hashMap.put("qddAppPkgName", com.tencent.halley.common.a.a().getPackageName());
        hashMap.put("qddSdkVersion", com.tencent.halley.common.a.e());
        hashMap.put("qddNetType", String.valueOf(c.h()));
        return hashMap;
    }

    /* synthetic */ a(byte b16) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
    }

    public final void a(String str, boolean z16, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), map);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(a());
        if (com.tencent.halley.common.a.b()) {
            d.c("BeaconReportWrapper", "reportToSelf eventName: " + str + " reportParam: " + new JSONObject(hashMap));
        }
        IRReport iRReport = this.f113532a;
        if (iRReport != null) {
            iRReport.reportToBeacon("0M300ETNJA170G1M", new BaseEvent(str, str, z16, hashMap));
        }
    }
}
