package com.qq.e.comm.plugin.h;

import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<d> f39410a;

    /* renamed from: b, reason: collision with root package name */
    String f39411b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WeakReference<d> weakReference, String str) {
        this.f39410a = weakReference;
        this.f39411b = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00db A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #0 {all -> 0x00eb, blocks: (B:16:0x0067, B:29:0x00aa, B:30:0x00cb, B:31:0x00db, B:32:0x0081, B:35:0x008c, B:38:0x0097), top: B:15:0x0067 }] */
    @Override // java.lang.reflect.InvocationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Object obj, Method method, final Object[] objArr) throws Throwable {
        final d dVar;
        String name;
        int hashCode;
        char c16;
        if (method == null) {
            return null;
        }
        GDTLogger.i("PcdnSDKManager ITPPreLoadListenerHandler invoke :" + method.getName() + " params :" + Arrays.toString(objArr));
        WeakReference<d> weakReference = this.f39410a;
        if (weakReference != null) {
            dVar = weakReference.get();
        } else {
            dVar = null;
        }
        if (dVar == null) {
            GDTLogger.e("PcdnSDKManager ITPPreLoadListenerHandler pcdnsdkManager == null");
            return null;
        }
        if (g.b(dVar.f39438a.get(this.f39411b))) {
            GDTLogger.e("PcdnSDKManager ITPPreLoadListenerHandler invoke not hit url :" + this.f39411b);
            return null;
        }
        try {
            name = method.getName();
            hashCode = name.hashCode();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (hashCode != -1901919162) {
            if (hashCode != -1042207228) {
                if (hashCode == -84906816 && name.equals("onPrepareError")) {
                    c16 = 1;
                    if (c16 == 0) {
                        if (c16 != 1) {
                            if (c16 == 2) {
                                GDTLogger.d("PcdnSDKManager pcdn sdk downloading :" + this.f39411b);
                                dVar.f39439b.put(this.f39411b, Boolean.TRUE);
                            }
                        } else {
                            dVar.f39439b.remove(this.f39411b);
                            a(new Runnable() { // from class: com.qq.e.comm.plugin.h.a.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.a(dVar, objArr);
                                }
                            });
                        }
                    } else {
                        dVar.f39439b.remove(this.f39411b);
                        a(new Runnable() { // from class: com.qq.e.comm.plugin.h.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.a(dVar);
                            }
                        });
                    }
                    return null;
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
                return null;
            }
            if (name.equals("onPrepareOK")) {
                c16 = 0;
                if (c16 == 0) {
                }
                return null;
            }
            c16 = '\uffff';
            if (c16 == 0) {
            }
            return null;
        }
        if (name.equals("onPrepareDownloadProgressUpdate")) {
            c16 = 2;
            if (c16 == 0) {
            }
            return null;
        }
        c16 = '\uffff';
        if (c16 == 0) {
        }
        return null;
    }

    private void a(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (aa.a()) {
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.h.a.3
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, Object[] objArr) {
        if (dVar == null || dVar.f39438a == null || g.b(objArr)) {
            return;
        }
        dVar.a(dVar.f39438a.get(this.f39411b), ((Integer) objArr[1]).intValue(), (String) objArr[2], this.f39411b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        ConcurrentHashMap<String, List<WeakReference<c>>> concurrentHashMap;
        if (dVar == null || (concurrentHashMap = dVar.f39438a) == null) {
            return;
        }
        dVar.a(concurrentHashMap.get(this.f39411b), this.f39411b);
    }
}
