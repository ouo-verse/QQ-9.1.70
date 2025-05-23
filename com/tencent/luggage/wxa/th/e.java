package com.tencent.luggage.wxa.th;

import com.tencent.luggage.wxa.a8.p;
import com.tencent.luggage.wxa.th.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uc.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends i {

    /* renamed from: c, reason: collision with root package name */
    public volatile p f141337c;

    /* renamed from: a, reason: collision with root package name */
    public String f141335a = "MicroMsg.AppBrandRuntimeLiveVOIPStateManager";

    /* renamed from: b, reason: collision with root package name */
    public boolean f141336b = true;

    /* renamed from: d, reason: collision with root package name */
    public final Set f141338d = Collections.newSetFromMap(new ConcurrentHashMap());

    public e(com.tencent.luggage.wxa.ic.g gVar) {
        this.f141335a += "#" + hashCode() + "Runtime#" + gVar.hashCode();
    }

    @Override // com.tencent.luggage.wxa.uc.i
    public boolean a() {
        return (this.f141337c == null || this.f141338d.isEmpty()) ? false : true;
    }

    public void b(com.tencent.luggage.wxa.ic.g gVar, p pVar) {
        w.d(this.f141335a, "onPushEnd, runtime:%s, LivePusher:%s", gVar.getAppId(), pVar.getComponentKey());
        a(gVar, 2);
    }

    public void c(p pVar) {
        this.f141338d.remove(pVar);
        w.d(this.f141335a, "unregisterLivePlayer:%s", pVar.getComponentKey());
    }

    public void d(p pVar) {
        if (this.f141337c == pVar) {
            this.f141337c = null;
            w.d(this.f141335a, "unregisterLivePusher:%s", pVar.getComponentKey());
        }
    }

    public boolean a(p pVar, int i3) {
        boolean z16;
        if (a() && i3 != 3) {
            if (pVar instanceof LivePusherPluginHandler) {
                if (this.f141337c == pVar) {
                    z16 = true;
                }
            } else if (pVar instanceof LivePlayerPluginHandler) {
                z16 = this.f141338d.contains(pVar);
            }
            w.d(this.f141335a, "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", Boolean.valueOf(z16), Boolean.valueOf(a()), Integer.valueOf(i3));
            return z16;
        }
        z16 = false;
        w.d(this.f141335a, "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", Boolean.valueOf(z16), Boolean.valueOf(a()), Integer.valueOf(i3));
        return z16;
    }

    public void b(p pVar) {
        if (pVar != null) {
            this.f141337c = pVar;
            w.d(this.f141335a, "registerLivePusher:%s", pVar.getComponentKey());
        }
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar, p pVar) {
        w.d(this.f141335a, "onPushBegin, runtime:%s, LivePusher:%s", gVar.getAppId(), pVar.getComponentKey());
        a(gVar, 1);
    }

    public final void a(com.tencent.luggage.wxa.ic.g gVar, int i3) {
        a aVar = new a();
        aVar.f141319d.f141320a = gVar.getAppId();
        a.C6755a c6755a = aVar.f141319d;
        c6755a.f141321b = 4;
        c6755a.f141322c = i3;
        aVar.c();
    }

    public void a(p pVar) {
        this.f141338d.add(pVar);
        w.d(this.f141335a, "registerLivePlayer:%s", pVar.getComponentKey());
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar, boolean z16) {
        boolean a16 = a();
        w.d(this.f141335a, "enableMic, enable:%s, isVOIPing: %b", Boolean.valueOf(z16), Boolean.valueOf(a16));
        if (a16) {
            boolean z17 = this.f141336b;
            this.f141336b = z16;
            if (z17 != z16) {
                a(gVar, 1);
            }
        }
    }
}
