package com.tencent.tfd.sdk.wxa;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Cascara extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f375516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f375517b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ITuringDeviceInfoProvider f375518c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f375519d;

    public Cascara(AtomicBoolean atomicBoolean, HashMap hashMap, ITuringDeviceInfoProvider iTuringDeviceInfoProvider, Object obj) {
        this.f375516a = atomicBoolean;
        this.f375517b = hashMap;
        this.f375518c = iTuringDeviceInfoProvider;
        this.f375519d = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, atomicBoolean, hashMap, iTuringDeviceInfoProvider, obj);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.run();
        if (this.f375516a.get()) {
            return;
        }
        try {
            HashMap hashMap = this.f375517b;
            String imei = this.f375518c.getImei();
            if (imei == null) {
                imei = "";
            }
            hashMap.put("274", imei);
            HashMap hashMap2 = this.f375517b;
            String imsi = this.f375518c.getImsi();
            if (imsi == null) {
                imsi = "";
            }
            hashMap2.put("276", imsi);
            HashMap hashMap3 = this.f375517b;
            String androidId = this.f375518c.getAndroidId();
            if (androidId == null) {
                androidId = "";
            }
            hashMap3.put("275", androidId);
        } catch (Throwable unused) {
            Log.w("Turing", "invoke info impl exception");
        }
        synchronized (this.f375519d) {
            this.f375519d.notify();
        }
    }
}
