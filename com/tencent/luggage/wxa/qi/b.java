package com.tencent.luggage.wxa.qi;

import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.t9.x;
import com.tencent.luggage.wxa.tn.a1;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static Map f138828a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList f138829b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f138830c = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            b.c();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qi.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6646b implements r {
        C6646b() {
        }

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.va.d invoke(com.tencent.luggage.wxa.va.e eVar) {
            return new com.tencent.luggage.wxa.va.d("");
        }
    }

    public static void b() {
        if (f138830c) {
            w.d("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
        } else {
            com.tencent.luggage.wxa.co.a.a(new a(), "record_update_device_info");
        }
    }

    public static void c() {
        String str;
        if (f138830c) {
            w.d("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
            return;
        }
        w.d("MicroMsg.Record.AppBrandRecordClientService", "to do update device info!");
        f138830c = true;
        com.tencent.luggage.wxa.va.d dVar = (com.tencent.luggage.wxa.va.d) com.tencent.luggage.wxa.qa.f.a(a1.f141525b, null, C6646b.class);
        if (dVar != null && (str = dVar.f143315a) != null) {
            x.a(str);
            w.d("MicroMsg.Record.AppBrandRecordClientService", "update device info success!");
        }
    }

    public static void a(String str, IListener iListener) {
        if (f138828a.containsKey(str)) {
            w.b("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", str);
            return;
        }
        if (iListener == null) {
            w.b("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
            return;
        }
        w.d("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", str);
        f138828a.put(str, iListener);
        if (!f138829b.contains(str)) {
            f138829b.add(str);
        }
        iListener.alive();
    }

    public static void a(String str) {
        if (!f138828a.containsKey(str)) {
            w.b("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", str);
            return;
        }
        w.d("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", str);
        f138829b.remove(str);
        IListener iListener = (IListener) f138828a.remove(str);
        if (iListener != null) {
            iListener.dead();
        }
    }
}
