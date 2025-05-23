package c05;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import c05.c;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.xingin.xhssharesdk.log.IShareLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import xz4.g;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static IShareLogger f30217a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile ExecutorService f30218b;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        void a(Exception exc);

        void onSuccess(String str);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        @Nullable
        @WorkerThread
        Map<String, Object> a();
    }

    /* compiled from: P */
    /* renamed from: c05.c$c, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C0159c implements a {

        /* renamed from: a, reason: collision with root package name */
        public final a f30219a;

        public C0159c(g gVar) {
            this.f30219a = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str) {
            a aVar = this.f30219a;
            if (aVar != null) {
                aVar.onSuccess(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Exception exc) {
            a aVar = this.f30219a;
            if (aVar != null) {
                aVar.a(exc);
            }
        }

        @Override // c05.c.a
        public final void onSuccess(final String str) {
            com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: c05.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0159c.this.c(str);
                }
            });
        }

        @Override // c05.c.a
        public final void a(final Exception exc) {
            com.xingin.xhssharesdk.p.b.a(new Runnable() { // from class: c05.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0159c.this.d(exc);
                }
            });
        }
    }

    public static void a(final String str, @Nullable final b bVar, g gVar) {
        final C0159c c0159c = new C0159c(gVar);
        if (f30218b == null) {
            f30218b = ProxyExecutors.newCachedThreadPool();
        }
        final Map map = null;
        f30218b.execute(new Runnable() { // from class: c05.b
            @Override // java.lang.Runnable
            public final void run() {
                c.b(str, map, bVar, c0159c);
            }
        });
    }

    public static /* synthetic */ void b(String str, Map map, b bVar, C0159c c0159c) {
        IShareLogger iShareLogger;
        String str2;
        try {
            IShareLogger iShareLogger2 = f30217a;
            if (iShareLogger2 != null) {
                iShareLogger2.d("XhsShare_NetworkManager", "Post start, url is " + str);
            }
            HashMap hashMap = new HashMap();
            if (map == null && (bVar == null || (map = bVar.a()) == null)) {
                map = hashMap;
            }
            String a16 = f.a(str, map);
            IShareLogger iShareLogger3 = f30217a;
            if (iShareLogger3 != null) {
                iShareLogger3.d("XhsShare_NetworkManager", "Post end, response is " + a16);
            }
            c0159c.onSuccess(a16);
        } catch (com.xingin.xhssharesdk.l.b e16) {
            e = e16;
            iShareLogger = f30217a;
            if (iShareLogger != null) {
                str2 = "Network Error!";
                iShareLogger.w("XhsShare_NetworkManager", str2, e);
            }
            c0159c.a(e);
        } catch (com.xingin.xhssharesdk.l.c e17) {
            e = e17;
            iShareLogger = f30217a;
            if (iShareLogger != null) {
                str2 = "Invalid Params!";
                iShareLogger.w("XhsShare_NetworkManager", str2, e);
            }
            c0159c.a(e);
        } catch (IOException e18) {
            e = e18;
            iShareLogger = f30217a;
            if (iShareLogger != null) {
                str2 = "IOException!";
                iShareLogger.w("XhsShare_NetworkManager", str2, e);
            }
            c0159c.a(e);
        }
    }
}
