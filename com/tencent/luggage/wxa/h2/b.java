package com.tencent.luggage.wxa.h2;

import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f126847a = new HashMap();

    public static void a(a aVar) {
        w.d("MicroMsg.WMPFToClientEventCenter", "register WMPFToClientEvent.appId:%s, WMPFToClientEvent.hash:%d", aVar.f126836d, Integer.valueOf(aVar.hashCode()));
        if (aVar.f126836d == null) {
            w.b("MicroMsg.WMPFToClientEventCenter", "register WMPFToClientEvent.appId is null!!!");
            return;
        }
        HashMap hashMap = f126847a;
        synchronized (hashMap) {
            if (hashMap.get(aVar.f126836d) == null) {
                hashMap.put(aVar.f126836d, aVar);
            } else {
                w.a("MicroMsg.WMPFToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                hashMap.remove(aVar.f126836d);
                hashMap.put(aVar.f126836d, aVar);
            }
        }
    }

    public static void b(a aVar) {
        w.d("MicroMsg.WMPFToClientEventCenter", "unregister WMPFToClientEvent.appId:%s", aVar.f126836d);
        HashMap hashMap = f126847a;
        synchronized (hashMap) {
            hashMap.remove(aVar.f126836d);
        }
    }

    public static void a(String str, Parcelable parcelable) {
        a aVar;
        HashMap hashMap = f126847a;
        synchronized (hashMap) {
            aVar = (a) hashMap.get(str);
        }
        if (aVar == null) {
            w.b("MicroMsg.WMPFToClientEventCenter", "notify failed, appId[%s] data[%s]");
        } else if (parcelable != null) {
            aVar.a(parcelable);
        }
    }
}
