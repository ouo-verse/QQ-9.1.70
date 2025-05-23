package com.tencent.luggage.wxa.oi;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map f136526a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map f136527b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList f136528c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static Map f136529d = new ConcurrentHashMap();

    public static void a(String str, c cVar) {
        f136526a.put(str, cVar);
    }

    public static boolean b(String str) {
        if (!f136529d.containsKey(str)) {
            return false;
        }
        return ((Boolean) f136529d.get(str)).booleanValue();
    }

    public static void c(String str) {
        w.d("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
        f136526a.clear();
        com.tencent.luggage.wxa.zd.b.a(str);
        f136529d.put(str, Boolean.TRUE);
    }

    public static void d(String str) {
        w.d("MicroMsg.Audio.AppBrandAudioClientService", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        com.tencent.luggage.wxa.zd.b.b(str);
        f136526a.clear();
        Iterator it = f136528c.iterator();
        while (it.hasNext()) {
            IListener iListener = (IListener) f136527b.remove((String) it.next());
            if (iListener != null) {
                iListener.dead();
            }
        }
        f136527b.clear();
        f136528c.clear();
        f136529d.remove(str);
    }

    public static void e(String str) {
        if (!f136527b.containsKey(str)) {
            w.b("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", str);
            return;
        }
        w.a("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", str);
        f136528c.remove(str);
        IListener iListener = (IListener) f136527b.remove(str);
        if (iListener != null) {
            iListener.dead();
        }
    }

    public static c a(String str) {
        return (c) f136526a.get(str);
    }

    public static void a(String str, IListener iListener) {
        if (TextUtils.isEmpty(str)) {
            w.b("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
            return;
        }
        if (iListener == null) {
            w.b("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
            return;
        }
        if (f136527b.containsKey(str)) {
            e(str);
        }
        w.a("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", str);
        f136527b.put(str, iListener);
        if (!f136528c.contains(str)) {
            f136528c.add(str);
        }
        iListener.alive();
    }

    public static void a(String str, boolean z16) {
        f136529d.put(str, Boolean.valueOf(z16));
    }
}
