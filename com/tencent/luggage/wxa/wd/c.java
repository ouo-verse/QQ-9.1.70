package com.tencent.luggage.wxa.wd;

import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f144187a = new HashMap();

    public static void a(b bVar) {
        w.d("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", bVar.f144176d, Integer.valueOf(bVar.hashCode()));
        if (bVar.f144176d == null) {
            w.b("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
            return;
        }
        HashMap hashMap = f144187a;
        synchronized (hashMap) {
            if (hashMap.get(bVar.f144176d) == null) {
                hashMap.put(bVar.f144176d, bVar);
            } else {
                w.a("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                hashMap.remove(bVar.f144176d);
                hashMap.put(bVar.f144176d, bVar);
            }
        }
    }

    public static void b(b bVar) {
        w.d("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", bVar.f144176d);
        HashMap hashMap = f144187a;
        synchronized (hashMap) {
            hashMap.remove(bVar.f144176d);
        }
    }

    public static void a(String str, Parcelable parcelable) {
        b bVar;
        HashMap hashMap = f144187a;
        synchronized (hashMap) {
            bVar = (b) hashMap.get(str);
        }
        if (bVar == null) {
            w.b("MicroMsg.MMToClientEventCenter", "notify failed, appId[%s] data[%s]", str, parcelable);
        } else if (parcelable != null) {
            bVar.a(parcelable);
        }
    }
}
