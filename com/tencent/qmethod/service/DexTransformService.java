package com.tencent.qmethod.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.dextransform.c;
import com.tencent.mobileqq.dextransform.d;
import com.tencent.mobileqq.dextransform.e;
import com.tencent.mobileqq.dextransform.h;
import com.tencent.qmethod.base.TransformTask;
import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DexTransformService extends Service {

    /* renamed from: d, reason: collision with root package name */
    protected static ThreadPoolExecutor f344172d = new BaseThreadPoolExecutor(1, 1, 120, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

    /* renamed from: e, reason: collision with root package name */
    private static String f344173e = null;

    /* renamed from: f, reason: collision with root package name */
    private static List<String> f344174f = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f344175a;

        a(Context context) {
            this.f344175a = context;
        }

        @Override // com.tencent.mobileqq.dextransform.c
        public void a(String str, e eVar) {
            if (!r.c(this.f344175a, str).booleanValue()) {
                r.p(this.f344175a, str, DexTransformService.f());
            }
            DexTransformService.a(str);
        }

        @Override // com.tencent.mobileqq.dextransform.c
        public void b(String str, d dVar) {
            if (!r.c(this.f344175a, str).booleanValue()) {
                r.p(this.f344175a, str, DexTransformService.f());
            }
            DexTransformService.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements TransformTask.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f344177a;

        b(String str) {
            this.f344177a = str;
        }

        @Override // com.tencent.qmethod.base.TransformTask.a
        public void a(String str, File file) {
            o.a("DexTransformService", str + " TransformTask onEnd.");
            if (er3.a.c() != null) {
                er3.a.c().c(str, file);
            }
            if (DexTransformService.f344172d.getQueue().isEmpty()) {
                DexTransformService.this.stopSelf();
            }
            r.q(DexTransformService.this.getApplicationContext(), "className." + DexTransformService.f(), DexTransformService.g());
            DexTransformService.b();
            DexTransformService.h(null);
        }

        @Override // com.tencent.qmethod.base.TransformTask.a
        public void onError(Exception exc) {
            if (er3.a.c() != null) {
                er3.a.c().b(this.f344177a, exc);
            }
        }

        @Override // com.tencent.qmethod.base.TransformTask.a
        public void onStart() {
            DexTransformService.h(this.f344177a);
        }
    }

    public static void a(String str) {
        f344174f.add(str);
    }

    public static void b() {
        f344174f.clear();
    }

    private static void c(Context context) {
        List f16;
        if (!r.c(context, "key_transformed_list").booleanValue() || (f16 = r.f(context, "key_transformed_list", String.class)) == null) {
            return;
        }
        ListIterator listIterator = f16.listIterator();
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            if (!new File(str).exists()) {
                o.a("DexTransformService", str + " is not exist. do clean\uff01");
                listIterator.remove();
                r.k(context, str);
                r.k(context, "length." + str);
                r.k(context, "lastModified." + str);
                if (r.c(context, "className." + str).booleanValue()) {
                    for (String str2 : r.f(context, "className." + str, String.class)) {
                        if (r.c(context, str2).booleanValue()) {
                            r.k(context, str2);
                        }
                    }
                    r.k(context, "className." + str);
                }
            }
        }
        r.q(context, "key_transformed_list", f16);
    }

    private void d(String str) {
        r.m(this, str, Boolean.FALSE);
        e(new TransformTask(this, str, new b(str)));
    }

    private static synchronized void e(TransformTask transformTask) {
        synchronized (DexTransformService.class) {
            try {
                if (f344172d.getQueue().contains(transformTask)) {
                    o.a("DexTransformService", transformTask.f343442e + " transformTask is exist");
                } else {
                    o.a("DexTransformService", transformTask.f343442e + " transformTask add queue");
                    f344172d.execute(transformTask);
                }
            } catch (Exception e16) {
                o.d("DexTransformService", "executeTask error", e16);
            }
        }
    }

    public static String f() {
        return f344173e;
    }

    public static List<String> g() {
        return f344174f;
    }

    public static void h(String str) {
        f344173e = str;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        o.a("DexTransformService", "DexTransformService onCreate");
        h.c(new a(getApplicationContext()));
    }

    @Override // android.app.Service
    public void onDestroy() {
        o.a("DexTransformService", "DexTransformService onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        List f16;
        o.a("DexTransformService", "DexTransformService onStartCommand");
        if (intent == null) {
            o.a("DexTransformService", "DexTransformService onStartCommand intent is null");
            return super.onStartCommand(intent, i3, i16);
        }
        if (r.c(this, "key_transform_list").booleanValue() && (f16 = r.f(this, "key_transform_list", String.class)) != null) {
            Iterator it = f16.iterator();
            while (it.hasNext()) {
                d((String) it.next());
            }
        }
        c(this);
        return super.onStartCommand(intent, i3, i16);
    }
}
