package com.tencent.luggage.wxa.ic;

import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Iterator f129717a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final Map f129718b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map f129719c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tk.h f129720d = new com.tencent.luggage.wxa.tk.h();

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tk.h f129721e = new com.tencent.luggage.wxa.tk.h();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Iterator {
        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c next() {
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum b {
        INIT,
        ON_CREATE,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum d {
        CLOSE,
        BACK,
        HIDE,
        HANG,
        HOME_PRESSED,
        RECENT_APPS_PRESSED,
        LAUNCH_NATIVE_PAGE,
        LAUNCH_MINI_PROGRAM
    }

    public static void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        f129720d.b(str, cVar);
    }

    public static void b(String str, c cVar) {
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        f129720d.c(str, cVar);
    }

    public static Iterator c(String str) {
        Set a16 = f129720d.a(str);
        if (a16 != null) {
            return a16.iterator();
        }
        return f129717a;
    }

    public static d d(String str) {
        d dVar = (d) f129719c.get(str);
        if (dVar == null) {
            return d.HIDE;
        }
        return dVar;
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator c16 = c(str);
        while (c16.hasNext()) {
            ((c) c16.next()).onCreate();
        }
    }

    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator c16 = c(str);
        while (c16.hasNext()) {
            ((c) c16.next()).onDestroy();
        }
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator c16 = c(str);
        while (c16.hasNext()) {
            ((c) c16.next()).onDetachFromContainerStack();
        }
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator c16 = c(str);
        while (c16.hasNext()) {
            ((c) c16.next()).onPause(d(str));
        }
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator c16 = c(str);
        while (c16.hasNext()) {
            ((c) c16.next()).onReconnected();
        }
    }

    public static void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator c16 = c(str);
        while (c16.hasNext()) {
            ((c) c16.next()).onResume();
        }
    }

    public static void k(String str) {
        a(str, d.HIDE);
    }

    public static boolean a(String str, Intent intent) {
        Set a16 = f129721e.a(str);
        if (a16 == null) {
            return false;
        }
        Iterator it = a16.iterator();
        if (!it.hasNext()) {
            return false;
        }
        com.tencent.luggage.wxa.k0.d.a(it.next());
        throw null;
    }

    public static b b(String str) {
        b bVar = (b) f129718b.get(str);
        return bVar == null ? b.INIT : bVar;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f129720d.b(str);
        f129721e.b(str);
    }

    public static void a(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandLifeCycle", "setPauseType, appId: %s, type: %s", str, dVar);
        f129719c.put(str, dVar);
    }

    public static void a(String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f129718b.put(str, bVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class c {
        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void onDetachFromContainerStack() {
        }

        public void onReconnected() {
        }

        public void onResume() {
        }

        public void onPause(d dVar) {
        }
    }
}
