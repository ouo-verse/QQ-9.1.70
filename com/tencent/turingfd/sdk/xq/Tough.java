package com.tencent.turingfd.sdk.xq;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Tough extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f383134a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f383135b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ITuringDeviceInfoProvider f383136c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f383137d;

    public Tough(Vermillion vermillion, AtomicBoolean atomicBoolean, HashMap hashMap, ITuringDeviceInfoProvider iTuringDeviceInfoProvider, long j3, Object obj) {
        this.f383134a = atomicBoolean;
        this.f383135b = hashMap;
        this.f383136c = iTuringDeviceInfoProvider;
        this.f383137d = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, vermillion, atomicBoolean, hashMap, iTuringDeviceInfoProvider, Long.valueOf(j3), obj);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.run();
        if (this.f383134a.get()) {
            return;
        }
        try {
            HashMap hashMap = this.f383135b;
            String imei = this.f383136c.getImei();
            if (imei == null) {
                imei = "";
            }
            hashMap.put("274", imei);
            HashMap hashMap2 = this.f383135b;
            String imsi = this.f383136c.getImsi();
            if (imsi == null) {
                imsi = "";
            }
            hashMap2.put("276", imsi);
            HashMap hashMap3 = this.f383135b;
            String androidId = this.f383136c.getAndroidId();
            if (androidId == null) {
                androidId = "";
            }
            hashMap3.put("275", androidId);
        } catch (Throwable unused) {
            Log.w("Turing", "invoke info impl exception");
        }
        synchronized (this.f383137d) {
            this.f383137d.notify();
        }
    }
}
