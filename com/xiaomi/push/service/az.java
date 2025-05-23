package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.xiaomi.push.fi;
import com.xiaomi.push.ij;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, byte[]> f389689a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<Pair<String, byte[]>> f389690b = new ArrayList<>();

    public static void a(Context context, int i3, String str) {
        Map<String, byte[]> map = f389689a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                jz4.c.m("notify registration error. " + str2);
                b(context, str2, f389689a.get(str2), i3, str);
            }
            f389689a.clear();
        }
    }

    public static void b(Context context, String str, byte[] bArr, int i3, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i3);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, w.g(str));
    }

    public static void c(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f389690b) {
                arrayList = f389690b;
                f389690b = new ArrayList<>();
            }
            boolean c16 = ij.c();
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                w.l(xMPushService, (String) next.first, (byte[]) next.second);
                if (!c16) {
                    try {
                        LockMethodProxy.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (fi e16) {
            jz4.c.B("meet error when process pending message. " + e16);
            xMPushService.a(10, e16);
        }
    }

    public static void d(XMPushService xMPushService, boolean z16) {
        try {
            Map<String, byte[]> map = f389689a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    jz4.c.m("processing pending registration request. " + str);
                    w.l(xMPushService, str, f389689a.get(str));
                    if (z16 && !ij.c()) {
                        try {
                            LockMethodProxy.sleep(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                f389689a.clear();
            }
        } catch (fi e16) {
            jz4.c.B("fail to deal with pending register request. " + e16);
            xMPushService.a(10, e16);
        }
    }

    public static void e(String str, byte[] bArr) {
        Map<String, byte[]> map = f389689a;
        synchronized (map) {
            jz4.c.m("pending registration request. " + str);
            map.put(str, bArr);
        }
    }

    public static void f(String str, byte[] bArr) {
        synchronized (f389690b) {
            f389690b.add(new Pair<>(str, bArr));
            if (f389690b.size() > 50) {
                f389690b.remove(0);
            }
        }
    }
}
