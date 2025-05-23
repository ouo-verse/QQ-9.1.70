package com.tencent.luggage.wxa.tm;

import android.content.Context;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static final String f141517c = "MicroMsg.Audio.AudioPlayerCoreService";

    /* renamed from: d, reason: collision with root package name */
    private static b f141518d;

    /* renamed from: a, reason: collision with root package name */
    private Context f141519a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Class<? extends a>, a> f141520b = new ConcurrentHashMap<>();

    b(Context context) {
        this.f141519a = context;
        c();
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (f141518d != null) {
                return;
            }
            w.d(f141517c, OperateCustomButton.OPERATE_CREATE);
            f141518d = new b(context);
        }
    }

    private void b() {
        this.f141520b.clear();
        this.f141519a = null;
    }

    public static synchronized void d() {
        synchronized (b.class) {
            w.d(f141517c, "release");
            f141518d.b();
            f141518d = null;
        }
    }

    public static void b(Class<? extends a> cls) {
        a().f141520b.remove(cls);
    }

    public static b a() {
        if (f141518d == null) {
            a((Context) null);
        }
        return f141518d;
    }

    public static void a(Class<? extends a> cls, a aVar) {
        if (aVar != null) {
            a().f141520b.put(cls, aVar);
        }
    }

    public static <T extends a> T a(Class<T> cls) {
        T t16 = (T) a().f141520b.get(cls);
        if (t16 != null) {
            return t16;
        }
        return null;
    }

    private void c() {
    }
}
