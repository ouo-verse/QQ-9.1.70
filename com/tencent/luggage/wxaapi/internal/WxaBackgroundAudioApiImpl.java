package com.tencent.luggage.wxaapi.internal;

import com.tencent.luggage.wxa.e5.j;
import com.tencent.luggage.wxa.p9.g;
import com.tencent.luggage.wxa.rb.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z8.b;
import com.tencent.luggage.wxaapi.o;
import com.tencent.luggage.wxaapi.p;
import com.tencent.mm.sdk.event.IListener;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class WxaBackgroundAudioApiImpl implements o {

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f146884c;

    /* renamed from: d, reason: collision with root package name */
    public static final j f146885d;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f146883b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(WxaBackgroundAudioApiImpl.class, "IS_BACKGROUND_AUDIO_ENABLED", "getIS_BACKGROUND_AUDIO_ENABLED()Z", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final WxaBackgroundAudioApiImpl f146882a = new WxaBackgroundAudioApiImpl();

    static {
        new IListener<g>(b.f146383a) { // from class: com.tencent.luggage.wxaapi.internal.WxaBackgroundAudioApiImpl.1
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(g event) {
                int a16;
                Intrinsics.checkNotNullParameter(event, "event");
                g.a aVar = event.f137457d;
                if (aVar != null && (a16 = WxaBackgroundAudioApiImpl.f146882a.a(aVar.f137459a)) > 0) {
                    d dVar = aVar.f137460b;
                    if (dVar == null) {
                        w.b("Luggage.WxaBackgroundAudioApiImpl", "on event:" + aVar.f137459a + ", get NULL musicWrapper");
                        return false;
                    }
                    String str = dVar.E;
                    String str2 = dVar.f139443e;
                    String str3 = dVar.f139444f;
                    Iterator it = WxaBackgroundAudioApiImpl.f146884c.entrySet().iterator();
                    while (it.hasNext()) {
                        ((p) ((Map.Entry) it.next()).getKey()).a(a16, str, str2, str3);
                    }
                }
                return false;
            }
        }.alive();
        f146884c = new ConcurrentHashMap();
        f146885d = new j("WxaBackgroundAudioApi", Boolean.FALSE);
    }

    public final int a(int i3) {
        if (i3 == -1) {
            return 2;
        }
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            return i3 != 2 ? 0 : 3;
        }
        return 4;
    }

    public void addEventListener(p pVar) {
        if (pVar == null) {
            return;
        }
        f146884c.put(pVar, Boolean.TRUE);
    }

    public final boolean b() {
        return ((Boolean) f146885d.a(this, f146883b[0])).booleanValue();
    }

    public boolean isBackgroundAudioEnabled() {
        return b();
    }

    public void removeEventListener(p pVar) {
        if (pVar == null) {
            return;
        }
        f146884c.remove(pVar);
    }

    public void setBackgroundAudioEnabled(boolean z16) {
        a(z16);
    }

    public final void a(boolean z16) {
        f146885d.a(this, f146883b[0], Boolean.valueOf(z16));
    }
}
