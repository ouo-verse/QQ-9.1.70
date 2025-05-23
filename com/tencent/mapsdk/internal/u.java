package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.internal.tf;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class u implements tc, td, te {

    /* renamed from: c, reason: collision with root package name */
    private static final u f151143c = new u();

    /* renamed from: b, reason: collision with root package name */
    s f151145b;

    /* renamed from: a, reason: collision with root package name */
    public td f151144a = new td() { // from class: com.tencent.mapsdk.internal.u.1
        @Override // com.tencent.mapsdk.internal.tf.a
        public final void a(Context context, String str) {
        }

        @Override // com.tencent.mapsdk.internal.td
        public final Object b(String str) {
            return Util.newInstance(a(str), new Object[0]);
        }

        @Override // com.tencent.mapsdk.internal.td
        public final int c() {
            return 0;
        }

        @Override // com.tencent.mapsdk.internal.td
        public final File d() {
            return null;
        }

        @Override // com.tencent.mapsdk.internal.td
        public final <T> T a(Class<T> cls, Object... objArr) {
            return (T) Util.newInstance(cls, objArr);
        }

        @Override // com.tencent.mapsdk.internal.td
        public final ClassLoader b() {
            return AnonymousClass1.class.getClassLoader();
        }

        @Override // com.tencent.mapsdk.internal.td
        public final Object a(Object obj, String str, Object... objArr) {
            return Util.invokeMethod(obj, str, objArr);
        }

        @Override // com.tencent.mapsdk.internal.td
        public final Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
            return Util.invokeMethod(obj, str, clsArr, objArr);
        }

        @Override // com.tencent.mapsdk.internal.td
        public final Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
            return Util.invokeStaticMethod(cls, str, clsArr, objArr);
        }

        @Override // com.tencent.mapsdk.internal.td
        public final Class a(String str) {
            return Util.findClass(str, AnonymousClass1.class.getClassLoader());
        }

        @Override // com.tencent.mapsdk.internal.td
        public final <T> Class<? extends T> a(String str, Class<T> cls) {
            return Util.findClass(str, cls, AnonymousClass1.class.getClassLoader());
        }

        @Override // com.tencent.mapsdk.internal.tf.a
        public final void i() {
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private tc f151146d = new tc() { // from class: com.tencent.mapsdk.internal.u.2
        @Override // com.tencent.mapsdk.internal.tc
        public final void h() {
        }

        @Override // com.tencent.mapsdk.internal.tf.a
        public final void i() {
        }

        @Override // com.tencent.mapsdk.internal.tf.a
        public final void a(Context context, String str) {
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private te f151147e = new te() { // from class: com.tencent.mapsdk.internal.u.3
        @Override // com.tencent.mapsdk.internal.te
        public final void e() {
        }

        @Override // com.tencent.mapsdk.internal.te
        public final void f() {
        }

        @Override // com.tencent.mapsdk.internal.te
        public final void g() {
        }

        @Override // com.tencent.mapsdk.internal.tf.a
        public final void i() {
        }

        @Override // com.tencent.mapsdk.internal.tf.a
        public final void a(Context context, String str) {
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.u$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f151151a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f151152b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Handler f151153c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Callback f151154d;

        public AnonymousClass4(Context context, String str, Handler handler, Callback callback) {
            this.f151151a = context;
            this.f151152b = str;
            this.f151153c = handler;
            this.f151154d = callback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u.this.a(this.f151151a, this.f151152b);
            this.f151153c.post(new Runnable() { // from class: com.tencent.mapsdk.internal.u.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    Callback callback = AnonymousClass4.this.f151154d;
                    if (callback != null) {
                        callback.callback(null);
                    }
                }
            });
        }
    }

    u() {
    }

    public static u a() {
        return f151143c;
    }

    private s j() {
        return this.f151145b;
    }

    private File k() {
        return this.f151144a.d();
    }

    @Override // com.tencent.mapsdk.internal.td
    public final Object b(String str) {
        return this.f151144a.b(str);
    }

    @Override // com.tencent.mapsdk.internal.td
    public final int c() {
        return this.f151144a.c();
    }

    @Override // com.tencent.mapsdk.internal.td
    public final File d() {
        return this.f151144a.d();
    }

    private void a(Context context, String str, Callback<Void> callback) {
        new BaseThread(new AnonymousClass4(context, str, new Handler(Looper.getMainLooper()), callback), "tms-plugin").start();
    }

    @Override // com.tencent.mapsdk.internal.td
    public final ClassLoader b() {
        return this.f151144a.b();
    }

    @Override // com.tencent.mapsdk.internal.tf.a
    public final void a(Context context, String str) {
        tf.a(context);
        if (!tf.f150449p.isEmpty()) {
            Iterator<tf.b> it = tf.f150449p.iterator();
            while (it.hasNext()) {
                String str2 = "com.tencent.mapsdk." + it.next().f150454d;
                Object b16 = Util.findClass(str2, u.class.getClassLoader()) != null ? this.f151144a.b(str2) : null;
                if (b16 instanceof tf.a) {
                    ((tf.a) b16).a(context, str);
                }
                if (b16 instanceof td) {
                    this.f151144a = (td) b16;
                } else if (b16 instanceof te) {
                    this.f151147e = (te) b16;
                } else if (b16 instanceof tc) {
                    this.f151146d = (tc) b16;
                }
            }
        }
        this.f151145b = (s) this.f151144a.b("com.tencent.mapsdk.core.MapDelegateFactoryImpl");
    }

    @Override // com.tencent.mapsdk.internal.td
    public final Class a(String str) {
        return this.f151144a.a(str);
    }

    @Override // com.tencent.mapsdk.internal.td
    public final <T> Class<? extends T> a(String str, Class<T> cls) {
        return this.f151144a.a(str, cls);
    }

    @Override // com.tencent.mapsdk.internal.td
    public final <T> T a(Class<T> cls, Object... objArr) {
        return (T) this.f151144a.a(cls, objArr);
    }

    @Override // com.tencent.mapsdk.internal.td
    public final Object a(Object obj, String str, Object... objArr) {
        return this.f151144a.a(obj, str, objArr);
    }

    @Override // com.tencent.mapsdk.internal.td
    public final Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        return this.f151144a.a(obj, str, clsArr, objArr);
    }

    @Override // com.tencent.mapsdk.internal.td
    public final Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        return this.f151144a.a(cls, str, clsArr, objArr);
    }

    @Override // com.tencent.mapsdk.internal.te
    public final void e() {
    }

    @Override // com.tencent.mapsdk.internal.te
    public final void f() {
    }

    @Override // com.tencent.mapsdk.internal.te
    public final void g() {
    }

    @Override // com.tencent.mapsdk.internal.tc
    public final void h() {
    }

    @Override // com.tencent.mapsdk.internal.tf.a
    public final void i() {
    }
}
