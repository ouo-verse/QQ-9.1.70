package com.tencent.luggage.wxa.ho;

import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map f129167a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f129168b = false;

    /* renamed from: c, reason: collision with root package name */
    public static ThreadLocal f129169c = new ThreadLocal();

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f129170d = "xiaomi".equalsIgnoreCase(Build.BRAND);

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f129171e = new byte[0];

    /* renamed from: f, reason: collision with root package name */
    public static TypedValue f129172f = new TypedValue();

    /* renamed from: g, reason: collision with root package name */
    public static Method f129173g = null;

    /* renamed from: h, reason: collision with root package name */
    public static Method f129174h = null;

    public static void a(Resources resources, Map map) {
        boolean z16 = false;
        com.tencent.luggage.wxa.io.a.a("MicroMsg.SVGResourceLoader", "addFilterResources:" + resources, new Object[0]);
        Iterator it = f129167a.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((WeakReference) it.next()).get() == resources) {
                z16 = true;
                break;
            }
        }
        if (!z16) {
            f129167a.put(new WeakReference(resources), map);
        }
    }
}
