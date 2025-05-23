package cooperation.vip.vipcomponent.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QzonePreDownloadManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.MultiHashMap;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ZipResDownloadManager {

    /* renamed from: f, reason: collision with root package name */
    private static ZipResDownloadManager f391381f;

    /* renamed from: g, reason: collision with root package name */
    private static String f391382g;

    /* renamed from: h, reason: collision with root package name */
    private static String f391383h;

    /* renamed from: i, reason: collision with root package name */
    public static final ArrayList<String> f391384i;

    /* renamed from: d, reason: collision with root package name */
    private LruCache<String, Bitmap> f391388d;

    /* renamed from: a, reason: collision with root package name */
    private QzonePreDownloadManager f391385a = null;

    /* renamed from: b, reason: collision with root package name */
    private Context f391386b = BaseApplication.getContext();

    /* renamed from: c, reason: collision with root package name */
    private final MultiHashMap<String, d> f391387c = new MultiHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private Downloader.DownloadListener f391389e = new a();

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f391384i = arrayList;
        arrayList.add("https://tianquan.gtimg.cn/shoal/qqgxh/2f25bfa8-efb0-451f-af0b-1c1fcd2578ab.zip");
        arrayList.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip");
        arrayList.add("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip");
    }

    public ZipResDownloadManager() {
        f391382g = z("qzonereszip");
        f391383h = z("qzoneres");
        this.f391388d = new LruCache<>((int) (sy3.b.a() / 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String B(String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && str.endsWith("zip")) {
            if (f391384i.contains(str)) {
                str2 = l15.b.c(str) + ".zip";
            } else {
                str2 = l15.b.d(str) + ".zip";
            }
            return f391382g + str2;
        }
        return str;
    }

    public static ZipResDownloadManager C() {
        if (f391381f == null) {
            synchronized (ZipResDownloadManager.class) {
                if (f391381f == null) {
                    f391381f = new ZipResDownloadManager();
                }
            }
        }
        return f391381f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(File file) {
        if (file != null && file.isDirectory()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean F(File file) {
        if (file != null && file.isFile() && file.length() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(d dVar) {
        if (URLUtil.isNetworkUrl(dVar.f391406b)) {
            t().download(dVar.f391406b, B(dVar.f391406b), true, this.f391389e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(r(str));
            p(file);
            FileUtils.unzip(new File(str), file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(String str, d dVar) {
        boolean z16;
        synchronized (this.f391387c) {
            int sizeOf = this.f391387c.sizeOf(str);
            this.f391387c.add(str, dVar);
            if (sizeOf == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<d> n(String str, boolean z16) {
        return o(str, z16, null);
    }

    private Collection<d> o(String str, boolean z16, Collection<d> collection) {
        Object obj;
        synchronized (this.f391387c) {
            if (z16) {
                obj = this.f391387c.remove(str);
            } else {
                obj = this.f391387c.get(str);
            }
            Collection<d> collection2 = (Collection) obj;
            if (collection != null) {
                collection.clear();
                if (collection2 != null) {
                    collection.addAll(collection2);
                }
                return collection;
            }
            return collection2;
        }
    }

    private static void p(File file) {
        if (!file.exists()) {
            file.mkdir();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
            return;
        }
        file.mkdir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d q(String str, int i3, String str2, e eVar) {
        return d.b(str, i3, str2, new WeakReference(eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String r(String str) {
        return f391383h + str.substring(str.lastIndexOf("/") + 1, str.length() - 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File s(String str) {
        String str2;
        if (f391384i.contains(str)) {
            str2 = f391383h + l15.b.c(str);
        } else {
            str2 = f391383h + l15.b.d(str);
        }
        return new File(str2);
    }

    private synchronized QzonePreDownloadManager t() {
        QzonePreDownloadManager qzonePreDownloadManager = this.f391385a;
        if (qzonePreDownloadManager != null) {
            return qzonePreDownloadManager;
        }
        QzonePreDownloadManager qzonePreDownloadManager2 = QzonePreDownloadManager.getInstance();
        this.f391385a = qzonePreDownloadManager2;
        return qzonePreDownloadManager2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File w(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (f391384i.contains(str)) {
                str3 = f391383h + l15.b.c(str) + File.separator + str2 + ".png";
            } else {
                str3 = f391383h + l15.b.d(str) + File.separator + str2 + ".png";
            }
            return new File(str3);
        }
        return null;
    }

    private static String z(String str) {
        String absolutePath = BaseApplication.getContext().getCacheDir().getAbsolutePath();
        String str2 = File.separator;
        if (!str.startsWith(str2)) {
            str = str2 + str;
        }
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath2 = file.getAbsolutePath();
        if (!absolutePath2.endsWith(str2)) {
            return absolutePath2 + str2;
        }
        return absolutePath2;
    }

    public String A(String str, e eVar) {
        String r16 = r(B(str));
        File file = new File(r16);
        if (file.exists() && file.listFiles().length != 0) {
            return r16;
        }
        d q16 = q(str, 999, r16, eVar);
        if (m(str, q16)) {
            H(q16);
            return null;
        }
        return null;
    }

    public boolean E(String str) {
        String str2;
        if (f391384i.contains(str)) {
            str2 = f391383h + l15.b.c(str) + File.separator;
        } else {
            str2 = f391383h + l15.b.d(str) + File.separator;
        }
        try {
            File file = new File(str2);
            if (!file.exists() || !file.isDirectory() || file.list() == null) {
                return false;
            }
            if (file.list().length <= 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QZLog.w("test", " file exception " + e16.toString());
            return false;
        }
    }

    public void G(final String str) {
        if (!URLUtil.isNetworkUrl(str)) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: cooperation.vip.vipcomponent.util.ZipResDownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (!ZipResDownloadManager.this.E(str2)) {
                    d q16 = ZipResDownloadManager.this.q(str2, -1, null, null);
                    if (ZipResDownloadManager.this.m(str2, q16)) {
                        ZipResDownloadManager.this.H(q16);
                    }
                }
            }
        });
    }

    public Drawable u(String str, int i3, String str2, e eVar) {
        return v(str, i3, str2, false, eVar);
    }

    public Drawable v(String str, int i3, String str2, boolean z16, e eVar) {
        if (z16) {
            ArrayList<String> arrayList = f391384i;
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        Bitmap y16 = y(str, i3, str2, eVar);
        if (y16 != null) {
            y16.setDensity(320);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(y16);
            bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
            return bitmapDrawable;
        }
        if (eVar != null) {
            synchronized (eVar) {
                eVar.mCount++;
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap x(String str, int i3, String str2, e eVar) {
        d q16;
        Bitmap bitmap;
        OutOfMemoryError e16;
        Exception e17;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap bitmap2 = this.f391388d.get(str + " " + str2);
        if (bitmap2 != null) {
            return bitmap2;
        }
        File w3 = w(str, str2);
        if (F(w3)) {
            synchronized (this) {
                try {
                    bitmap = this.f391388d.get(str + " " + str2);
                } catch (Exception e18) {
                    bitmap = bitmap2;
                    e17 = e18;
                } catch (OutOfMemoryError e19) {
                    bitmap = bitmap2;
                    e16 = e19;
                }
                if (bitmap != null) {
                    return bitmap;
                }
                try {
                    bitmap2 = l15.b.a(w3.getAbsolutePath(), null);
                } catch (Exception e26) {
                    e17 = e26;
                    QZLog.e("crash", e17.toString());
                    bitmap2 = bitmap;
                    if (bitmap2 != null) {
                    }
                    q16 = q(str, i3, str2, eVar);
                    if (m(str, q16)) {
                    }
                    return bitmap2;
                } catch (OutOfMemoryError e27) {
                    e16 = e27;
                    QZLog.e("crash", e16.toString());
                    bitmap2 = bitmap;
                    if (bitmap2 != null) {
                    }
                    q16 = q(str, i3, str2, eVar);
                    if (m(str, q16)) {
                    }
                    return bitmap2;
                }
                if (bitmap2 != null) {
                    this.f391388d.put(str + " " + str2, bitmap2);
                    return bitmap2;
                }
            }
        }
        q16 = q(str, i3, str2, eVar);
        if (m(str, q16)) {
            H(q16);
        }
        return bitmap2;
    }

    public Bitmap y(final String str, final int i3, final String str2, final e eVar) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Bitmap bitmap = this.f391388d.get(str + " " + str2);
        if (bitmap != null) {
            return bitmap;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: cooperation.vip.vipcomponent.util.ZipResDownloadManager.2
            /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
            /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Bitmap bitmap2;
                Bitmap bitmap3;
                String str3 = str;
                if (ZipResDownloadManager.D(ZipResDownloadManager.s(str3))) {
                    File w3 = ZipResDownloadManager.w(str3, str2);
                    if (ZipResDownloadManager.F(w3)) {
                        synchronized (this) {
                            Bitmap bitmap4 = null;
                            try {
                                bitmap3 = (Bitmap) ZipResDownloadManager.this.f391388d.get(str3 + " " + str2);
                                try {
                                } catch (Exception e16) {
                                    e = e16;
                                    bitmap4 = bitmap3;
                                    QZLog.e("crash", e.toString());
                                    bitmap2 = bitmap4;
                                    if (bitmap2 != null) {
                                    }
                                } catch (OutOfMemoryError e17) {
                                    e = e17;
                                    bitmap4 = bitmap3;
                                    QZLog.e("crash", e.toString());
                                    bitmap2 = bitmap4;
                                    if (bitmap2 != null) {
                                    }
                                }
                            } catch (Exception e18) {
                                e = e18;
                            } catch (OutOfMemoryError e19) {
                                e = e19;
                            }
                            if (bitmap3 != null) {
                                e eVar2 = eVar;
                                if (eVar2 != null) {
                                    synchronized (eVar2) {
                                        e eVar3 = eVar;
                                        eVar3.mCount--;
                                    }
                                    bitmap3.setDensity(320);
                                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap3);
                                    bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
                                    eVar.onDownloaded(str3, i3, str2, bitmapDrawable);
                                }
                                return;
                            }
                            bitmap2 = l15.b.a(w3.getAbsolutePath(), null);
                            if (bitmap2 != null) {
                                ZipResDownloadManager.this.f391388d.put(str3 + " " + str2, bitmap2);
                                e eVar4 = eVar;
                                if (eVar4 != null) {
                                    synchronized (eVar4) {
                                        e eVar5 = eVar;
                                        eVar5.mCount--;
                                    }
                                    bitmap2.setDensity(320);
                                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmap2);
                                    bitmapDrawable2.setTargetDensity((int) ViewUtils.getDensityDpi());
                                    eVar.onDownloaded(str3, i3, str2, bitmapDrawable2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    e eVar6 = eVar;
                    if (eVar6 != null) {
                        eVar6.onFailed(str3, i3, str2);
                        return;
                    }
                    return;
                }
                d q16 = ZipResDownloadManager.this.q(str3, i3, str2, eVar);
                if (ZipResDownloadManager.this.m(str3, q16)) {
                    ZipResDownloadManager.this.H(q16);
                }
            }
        }, 400L);
        return bitmap;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements Downloader.DownloadListener {
        a() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            for (d dVar : ZipResDownloadManager.this.n(str, true)) {
                e eVar = dVar.f391410f.get();
                if (eVar != null) {
                    eVar.onFailed(dVar.f391406b, dVar.f391407c, dVar.f391409e);
                }
                dVar.c();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            Bitmap bitmap;
            String B = ZipResDownloadManager.B(str);
            ZipResDownloadManager.I(B);
            for (d dVar : ZipResDownloadManager.this.n(str, true)) {
                e eVar = dVar.f391410f.get();
                if (eVar != null) {
                    int i3 = dVar.f391407c;
                    Bitmap bitmap2 = null;
                    if (i3 != 999) {
                        File w3 = ZipResDownloadManager.w(dVar.f391406b, dVar.f391409e);
                        if (ZipResDownloadManager.F(w3)) {
                            synchronized (this) {
                                try {
                                    bitmap = (Bitmap) ZipResDownloadManager.this.f391388d.get(dVar.f391405a);
                                    if (bitmap == null) {
                                        try {
                                            bitmap = l15.b.a(w3.getAbsolutePath(), null);
                                        } catch (Exception e16) {
                                            e = e16;
                                            bitmap2 = bitmap;
                                            QZLog.e("crash", e.toString());
                                            bitmap = bitmap2;
                                            if (bitmap != null) {
                                            }
                                            dVar.c();
                                        } catch (OutOfMemoryError e17) {
                                            e = e17;
                                            bitmap2 = bitmap;
                                            QZLog.e("crash", e.toString());
                                            bitmap = bitmap2;
                                            if (bitmap != null) {
                                            }
                                            dVar.c();
                                        }
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                } catch (OutOfMemoryError e19) {
                                    e = e19;
                                }
                            }
                            if (bitmap != null) {
                                ZipResDownloadManager.this.f391388d.put(dVar.f391405a, bitmap);
                                synchronized (eVar) {
                                    eVar.mCount--;
                                }
                                bitmap.setDensity(320);
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                                bitmapDrawable.setTargetDensity((int) ViewUtils.getDensityDpi());
                                eVar.onDownloaded(dVar.f391406b, dVar.f391407c, dVar.f391409e, bitmapDrawable);
                            } else {
                                eVar.onFailed(dVar.f391406b, dVar.f391407c, dVar.f391409e);
                            }
                        } else {
                            eVar.onFailed(dVar.f391406b, dVar.f391407c, dVar.f391409e);
                        }
                    } else {
                        eVar.onDownloaded(dVar.f391406b, i3, ZipResDownloadManager.r(B), null);
                    }
                }
                dVar.c();
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}
