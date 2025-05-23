package com.tencent.qmethod.pandoraex.core.ext.file;

import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.h;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FileObserverHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f344056a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<wr3.a<FileObserver>> f344057b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f344058c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static wr3.b f344059d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Handler f344060e = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        wr3.b bVar = f344059d;
        if (bVar != null && bVar.b("func_screenshot_monitor", new Object[0])) {
            try {
                x.j(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.ext.file.FileObserverHelper.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!FileObserverHelper.f344058c.get()) {
                            FileObserverHelper.f344059d.a("func_screenshot_monitor", FileObserverHelper.f344057b);
                        }
                    }
                }, 1000L);
            } catch (Throwable th5) {
                o.d("FileObserverHelper", "report execute fail!", th5);
            }
        }
    }

    public static void g() {
        if (f344058c.get() && f344059d != null) {
            h.a().post(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.ext.file.FileObserverHelper.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (FileObserverHelper.f344056a) {
                        FileObserverHelper.f344058c.set(false);
                        Iterator it = FileObserverHelper.f344057b.iterator();
                        while (it.hasNext()) {
                            FileObserver fileObserver = (FileObserver) ((wr3.a) it.next()).get();
                            if (fileObserver != null) {
                                fileObserver.stopWatching();
                            }
                        }
                        FileObserverHelper.f();
                    }
                }
            });
        }
    }

    public static void h() {
        if (!f344058c.get() && f344059d != null) {
            h.a().post(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.ext.file.FileObserverHelper.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (FileObserverHelper.f344056a) {
                        FileObserverHelper.f344058c.set(true);
                        Iterator it = FileObserverHelper.f344057b.iterator();
                        while (it.hasNext()) {
                            FileObserver fileObserver = (FileObserver) ((wr3.a) it.next()).get();
                            if (fileObserver != null) {
                                fileObserver.startWatching();
                            }
                        }
                    }
                }
            });
        }
    }

    public static void i(wr3.b bVar) {
        f344059d = bVar;
    }

    public static void j(FileObserver fileObserver) {
        if (fileObserver == null) {
            return;
        }
        if (f344059d == null) {
            fileObserver.startWatching();
            return;
        }
        synchronized (f344056a) {
            f344057b.add(new wr3.a<>(fileObserver));
            if (q.a().d()) {
                fileObserver.startWatching();
            } else {
                o.c("FileObserverHelper", "startWatching at bg, ignore. class=" + fileObserver.getClass().getName());
            }
        }
    }

    public static void k(FileObserver fileObserver) {
        if (fileObserver == null) {
            return;
        }
        if (f344059d == null) {
            fileObserver.stopWatching();
            return;
        }
        synchronized (f344056a) {
            f344057b.remove(new wr3.a(fileObserver));
            fileObserver.stopWatching();
        }
    }
}
