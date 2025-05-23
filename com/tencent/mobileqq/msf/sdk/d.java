package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static ConcurrentHashMap<String, IMsfProxy> f250535a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f250535a = new ConcurrentHashMap<>();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static IMsfProxy a(String str, boolean z16) {
        if (z16) {
            return new i(str);
        }
        return new h(str);
    }

    public static void b(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(MsfServiceSdk.get().getMsfServiceName())) {
            MsfServiceSdk.get().initMsfService();
            return;
        }
        if (!f250535a.containsKey(str)) {
            f250535a.putIfAbsent(str, new i(str));
        }
        f250535a.get(str).initMsfService();
    }

    public static void c(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(MsfServiceSdk.get().getMsfServiceName())) {
            MsfServiceSdk.get().initMsfService();
            return;
        }
        if (!f250535a.containsKey(str)) {
            f250535a.putIfAbsent(str, new i(str));
        }
        f250535a.get(str).initMsfService();
    }

    public static boolean d(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(MsfServiceSdk.get().getMsfServiceName())) {
            MsfServiceSdk.get().stopMsfService();
            return true;
        }
        if (!f250535a.containsKey(str)) {
            return false;
        }
        f250535a.get(str).stopMsfService();
        return true;
    }

    public static boolean e(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(MsfServiceSdk.get().getMsfServiceName())) {
            MsfServiceSdk.get().unbindMsfService();
            return true;
        }
        if (!f250535a.containsKey(str)) {
            return false;
        }
        f250535a.get(str).unbindMsfService();
        return true;
    }

    public static int a(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return -1;
        }
        if (toServiceMsg.getServiceName().equals(MsfServiceSdk.get().getMsfServiceName())) {
            return MsfServiceSdk.get().sendMsg(toServiceMsg);
        }
        if (!f250535a.containsKey(toServiceMsg.getServiceName())) {
            f250535a.putIfAbsent(toServiceMsg.getServiceName(), new i(toServiceMsg.getServiceName()));
        }
        return f250535a.get(toServiceMsg.getServiceName()).sendMsg(toServiceMsg);
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(MsfServiceSdk.get().getMsfServiceName())) {
            MsfServiceSdk.get().initMsfService();
            return;
        }
        if (!f250535a.containsKey(str)) {
            f250535a.putIfAbsent(str, new i(str));
        }
        f250535a.get(str).initMsfService();
    }
}
