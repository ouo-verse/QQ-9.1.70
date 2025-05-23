package com.tencent.qmethod.pandoraex.core.ext.file;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.x;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ContentObserverHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f344052a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f344053b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private static wr3.b f344054c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<wr3.a<ContentObserver>, Boolean> f344055d = new ConcurrentHashMap(16);

    private static void d() {
        wr3.b bVar = f344054c;
        if (bVar != null && bVar.b("func_screenshot_monitor", new Object[0])) {
            try {
                x.j(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.ext.file.ContentObserverHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ContentObserverHelper.f344053b.get()) {
                            ContentObserverHelper.f344054c.a("func_screenshot_monitor", ContentObserverHelper.f344055d);
                        }
                    }
                }, 1000L);
            } catch (Throwable th5) {
                o.d("ContentObserverHelper", "report execute fail!", th5);
            }
        }
    }

    public static void e() {
        AtomicBoolean atomicBoolean = f344053b;
        if (atomicBoolean.get()) {
            synchronized (f344052a) {
                atomicBoolean.set(false);
                Iterator<Map.Entry<wr3.a<ContentObserver>, Boolean>> it = f344055d.entrySet().iterator();
                while (it.hasNext()) {
                    ContentObserver contentObserver = it.next().getKey().get();
                    if (contentObserver != null) {
                        q.b().getContentResolver().unregisterContentObserver(contentObserver);
                    }
                }
                d();
            }
        }
    }

    public static void f() {
        AtomicBoolean atomicBoolean = f344053b;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (f344052a) {
            atomicBoolean.set(true);
            for (Map.Entry<wr3.a<ContentObserver>, Boolean> entry : f344055d.entrySet()) {
                ContentObserver contentObserver = entry.getKey().get();
                if (contentObserver != null) {
                    q.b().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, entry.getValue().booleanValue(), contentObserver);
                }
            }
        }
    }

    public static void g(ContentResolver contentResolver, Uri uri, boolean z16, ContentObserver contentObserver) {
        if (q.b() != null && MediaStore.Images.Media.EXTERNAL_CONTENT_URI == uri && f344054c != null) {
            synchronized (f344052a) {
                f344055d.put(new wr3.a<>(contentObserver), Boolean.valueOf(z16));
                if (q.a().d()) {
                    contentResolver.registerContentObserver(uri, z16, contentObserver);
                }
            }
            return;
        }
        contentResolver.registerContentObserver(uri, z16, contentObserver);
    }

    public static void h(wr3.b bVar) {
        f344054c = bVar;
    }

    public static void i(ContentResolver contentResolver, ContentObserver contentObserver) {
        synchronized (f344052a) {
            f344055d.remove(new wr3.a(contentObserver));
            contentResolver.unregisterContentObserver(contentObserver);
        }
    }
}
