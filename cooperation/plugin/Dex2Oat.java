package cooperation.plugin;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.util.AbiUtil;
import cooperation.qzone.patch.QZonePatchService;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Dex2Oat {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f390166a = e(System.getProperty("java.vm.version"));

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class OptimizeWorker implements Runnable {
        private static String C;

        /* renamed from: d, reason: collision with root package name */
        private final File f390167d;

        /* renamed from: e, reason: collision with root package name */
        private final File f390168e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f390169f;

        /* renamed from: h, reason: collision with root package name */
        private final AtomicInteger f390170h;

        /* renamed from: i, reason: collision with root package name */
        private final CountDownLatch f390171i;

        /* renamed from: m, reason: collision with root package name */
        private final c f390172m;

        OptimizeWorker(File file, File file2, boolean z16, String str, AtomicInteger atomicInteger, CountDownLatch countDownLatch, c cVar) {
            this.f390167d = file;
            this.f390168e = file2;
            this.f390169f = z16;
            this.f390170h = atomicInteger;
            this.f390171i = countDownLatch;
            this.f390172m = cVar;
            C = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            try {
                if (!Dex2Oat.b(this.f390167d) && (cVar = this.f390172m) != null) {
                    cVar.c(this.f390167d, this.f390168e, new IOException("dex file " + this.f390167d.getAbsolutePath() + " is not exist!"));
                }
                c cVar2 = this.f390172m;
                if (cVar2 != null) {
                    cVar2.a(this.f390167d, this.f390168e);
                }
                String h16 = Dex2Oat.h(this.f390167d, this.f390168e);
                DexFile.loadDex(this.f390167d.getAbsolutePath(), h16, 0);
                this.f390170h.incrementAndGet();
                c cVar3 = this.f390172m;
                if (cVar3 != null) {
                    cVar3.b(this.f390167d, this.f390168e, new File(h16));
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new BaseThread(runnable, "PluginDex2Oat");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements Comparator<File> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long length = file.length() - file2.length();
            if (length > 0) {
                return 1;
            }
            if (length == 0) {
                return 0;
            }
            return -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface c {
        void a(File file, File file2);

        void b(File file, File file2, File file3);

        void c(File file, File file2, Throwable th5);
    }

    public static String a() throws Exception {
        String str = (String) wy2.f.e("dalvik.system.VMRuntime", "getCurrentInstructionSet");
        if (TextUtils.isEmpty(str)) {
            return AbiUtil.ARM;
        }
        return str;
    }

    public static final boolean b(File file) {
        if (file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        String h16 = f.h();
        if (str != null && !str.equals("") && h16 != null && !h16.equals("")) {
            if (str.equals(h16)) {
                Log.d("plugin_tag.Dex2Oat", "same fingerprint:" + h16);
                return false;
            }
            Log.d("plugin_tag.Dex2Oat", "system OTA,fingerprint not equal:" + str + "," + h16);
            return true;
        }
        Log.d("plugin_tag.Dex2Oat", "fingerprint empty:" + str + ",current:" + h16);
        return false;
    }

    public static boolean d() {
        return true;
    }

    private static boolean e(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt <= 2 && (parseInt != 2 || parseInt2 < 1)) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean f(Collection<File> collection, File file, boolean z16, String str, c cVar) {
        return g(collection, file, z16, str, new AtomicInteger(0), cVar, 2);
    }

    private static synchronized boolean g(Collection<File> collection, File file, boolean z16, String str, AtomicInteger atomicInteger, c cVar, int i3) {
        synchronized (Dex2Oat.class) {
            CountDownLatch countDownLatch = new CountDownLatch(collection.size());
            ExecutorService newFixedThreadPool = ProxyExecutors.newFixedThreadPool(i3, new a());
            long nanoTime = System.nanoTime();
            ArrayList arrayList = new ArrayList(collection);
            Collections.sort(arrayList, new b());
            Collections.reverse(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                newFixedThreadPool.submit(new OptimizeWorker((File) it.next(), file, z16, str, atomicInteger, countDownLatch, cVar));
            }
            try {
                try {
                    countDownLatch.await();
                    long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
                    if (atomicInteger.get() == collection.size()) {
                        Log.i("plugin_tag.Dex2Oat", "All dexes are optimized successfully, cost: " + nanoTime2 + " ms.");
                        return true;
                    }
                    Log.e("plugin_tag.Dex2Oat", "Dexes optimizing failed, some dexes are not optimized.");
                    return false;
                } catch (InterruptedException e16) {
                    Log.w("plugin_tag.Dex2Oat", "Dex optimizing was interrupted.", e16);
                    return false;
                }
            } finally {
                newFixedThreadPool.shutdown();
            }
        }
    }

    public static String h(File file, File file2) {
        String name = file.getName();
        if (!name.endsWith(QZonePatchService.PATCH_SUFFIX_DEX)) {
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf < 0) {
                name = name + QZonePatchService.PATCH_SUFFIX_DEX;
            } else {
                StringBuilder sb5 = new StringBuilder(lastIndexOf + 4);
                sb5.append((CharSequence) name, 0, lastIndexOf);
                sb5.append(QZonePatchService.PATCH_SUFFIX_DEX);
                name = sb5.toString();
            }
        }
        return new File(file2, name).getPath();
    }
}
