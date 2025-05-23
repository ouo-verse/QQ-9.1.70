package com.tencent.luggage.wxa.id;

import android.content.Context;
import com.tencent.luggage.wxa.hn.hc;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static int f130083a = -1;

    public static void a(hc hcVar, d dVar) {
        if (dVar != null) {
            ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(15190, Integer.valueOf((int) (System.currentTimeMillis() - dVar.f130024b)), Integer.valueOf(dVar.f130023a), Integer.valueOf(hcVar.a()), 0, "", "", Integer.valueOf(a()), Integer.valueOf(b()));
        }
    }

    public static int b() {
        Context c16 = z.c();
        if (!h0.j(c16)) {
            return 0;
        }
        if (h0.f(c16)) {
            return 1;
        }
        if (h0.g(c16)) {
            return 2;
        }
        if (h0.h(c16)) {
            return 3;
        }
        if (h0.l(c16)) {
            return 4;
        }
        return 5;
    }

    public static void a(a aVar, int i3) {
        ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(15190, Integer.valueOf((int) (System.currentTimeMillis() - aVar.f130020b)), Integer.valueOf(aVar.f130022d), Integer.valueOf(i3), 1, "", w0.d(aVar.f130021c), Integer.valueOf(a()), Integer.valueOf(b()));
    }

    public static void a(String str, LinkedList linkedList, long j3, int i3, int i16) {
        ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(15190, Integer.valueOf((int) (System.currentTimeMillis() - j3)), Integer.valueOf(i3), Integer.valueOf(i16), 2, str, ((str.equals(DebugUtils.Method.INVOKEHANDLER) || str.equals(DebugUtils.Method.PUBLISHHANDLER)) && linkedList.size() > 0) ? (String) linkedList.get(0) : "", Integer.valueOf(a()), Integer.valueOf(b()));
    }

    public static String a(String str) {
        Matcher matcher = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(str);
        return matcher.find() ? matcher.group(1) : "";
    }

    public static int a() {
        int i3 = f130083a;
        if (i3 >= 0) {
            return i3;
        }
        int b16 = h0.b(z.c());
        f130083a = b16;
        return b16;
    }
}
