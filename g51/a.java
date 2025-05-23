package g51;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Printer;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile HandlerThread f401259a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f401260b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Handler f401261c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private static HashSet<HandlerThread> f401262d = new HashSet<>();

    /* renamed from: e, reason: collision with root package name */
    public static boolean f401263e = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: g51.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C10353a implements Printer, d51.a {

        /* renamed from: a, reason: collision with root package name */
        private ConcurrentHashMap<String, b> f401264a = new ConcurrentHashMap<>();

        /* renamed from: b, reason: collision with root package name */
        private boolean f401265b;

        /* compiled from: P */
        /* renamed from: g51.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class C10354a implements Comparator<b> {
            C10354a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(b bVar, b bVar2) {
                return bVar2.f401268b - bVar.f401268b;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: g51.a$a$b */
        /* loaded from: classes9.dex */
        public class b {

            /* renamed from: a, reason: collision with root package name */
            String f401267a;

            /* renamed from: b, reason: collision with root package name */
            int f401268b;

            b() {
            }

            public String toString() {
                return this.f401267a + ":" + this.f401268b;
            }
        }

        C10353a() {
            AppActiveMatrixDelegate appActiveMatrixDelegate = AppActiveMatrixDelegate.INSTANCE;
            appActiveMatrixDelegate.addListener(this);
            this.f401265b = appActiveMatrixDelegate.isAppForeground();
        }

        @Override // d51.a
        public void a(boolean z16) {
            this.f401265b = z16;
            if (z16) {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                for (b bVar : this.f401264a.values()) {
                    if (bVar.f401268b > 1) {
                        linkedList.add(bVar);
                    }
                }
                Collections.sort(linkedList, new C10354a());
                this.f401264a.clear();
                if (!linkedList.isEmpty()) {
                    g51.b.c("Matrix.HandlerThread", "matrix default thread has exec in background! %s cost:%s", linkedList, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                return;
            }
            this.f401264a.clear();
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (!this.f401265b && str.charAt(0) == '>') {
                int indexOf = str.indexOf("} ");
                int indexOf2 = str.indexOf("@", indexOf);
                if (indexOf >= 0 && indexOf2 >= 0) {
                    String substring = str.substring(indexOf, indexOf2);
                    b bVar = this.f401264a.get(substring);
                    if (bVar == null) {
                        bVar = new b();
                        bVar.f401267a = substring;
                        this.f401264a.put(substring, bVar);
                    }
                    bVar.f401268b++;
                }
            }
        }
    }

    public static HandlerThread a() {
        HandlerThread handlerThread;
        C10353a c10353a;
        synchronized (a.class) {
            if (f401259a == null) {
                f401259a = new BaseHandlerThread("default_matrix_thread");
                f401259a.start();
                f401260b = new Handler(f401259a.getLooper());
                Looper looper = f401259a.getLooper();
                if (f401263e) {
                    c10353a = new C10353a();
                } else {
                    c10353a = null;
                }
                looper.setMessageLogging(c10353a);
                b.e("Matrix.HandlerThread", "create default handler thread, we should use these thread normal, isDebug:%s", Boolean.valueOf(f401263e));
            }
            handlerThread = f401259a;
        }
        return handlerThread;
    }
}
