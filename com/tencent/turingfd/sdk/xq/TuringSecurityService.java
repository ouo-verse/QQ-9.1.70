package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuringSecurityService {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.TuringSecurityService$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo implements Perseus {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IteApkInfoRespCallback f383169a;

        public Cdo(IteApkInfoRespCallback iteApkInfoRespCallback) {
            this.f383169a = iteApkInfoRespCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iteApkInfoRespCallback);
            }
        }

        public void a(long j3, Map<Integer, Cygnus> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), map);
                return;
            }
            HashMap hashMap = new HashMap();
            for (Integer num : map.keySet()) {
                hashMap.put(num, new d(map.get(num)));
            }
            this.f383169a.onResult(j3, hashMap);
        }
    }

    public TuringSecurityService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkApk(Map<Integer, IteApkInfoReq> map, IteApkInfoRespCallback iteApkInfoRespCallback) {
        HashMap hashMap = new HashMap();
        for (Integer num : map.keySet()) {
            hashMap.put(num, map.get(num));
        }
        Cdo cdo = new Cdo(iteApkInfoRespCallback);
        int a16 = i.a();
        if (a16 != 0) {
            cdo.a(a16, new HashMap());
        } else {
            new h(hashMap, cdo).start();
        }
    }
}
