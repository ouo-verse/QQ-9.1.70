package com.tencent.turingcam;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.turingface.sdk.mfa.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes27.dex */
public class M7T4N extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f381947a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f381948b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f381949c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f381950d;

    public M7T4N(AtomicBoolean atomicBoolean, HashMap hashMap, d dVar, Object obj) {
        this.f381947a = atomicBoolean;
        this.f381948b = hashMap;
        this.f381949c = dVar;
        this.f381950d = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, atomicBoolean, hashMap, dVar, obj);
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
        if (this.f381947a.get()) {
            return;
        }
        try {
            HashMap hashMap = this.f381948b;
            String imei = this.f381949c.getImei();
            if (imei == null) {
                imei = "";
            }
            hashMap.put("274", imei);
            HashMap hashMap2 = this.f381948b;
            String imsi = this.f381949c.getImsi();
            if (imsi == null) {
                imsi = "";
            }
            hashMap2.put("276", imsi);
            HashMap hashMap3 = this.f381948b;
            String androidId = this.f381949c.getAndroidId();
            if (androidId == null) {
                androidId = "";
            }
            hashMap3.put("275", androidId);
        } catch (Throwable unused) {
            Log.w("Turing", "invoke info impl exception");
        }
        synchronized (this.f381950d) {
            this.f381950d.notify();
        }
    }
}
