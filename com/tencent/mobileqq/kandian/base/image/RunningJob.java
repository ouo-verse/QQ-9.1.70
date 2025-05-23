package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import com.tencent.sharpP.SharpPUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RunningJob implements Runnable {
    public static final String G = ImageManager.TAG_PREFIX + RunningJob.class.getSimpleName();
    File F;

    /* renamed from: d, reason: collision with root package name */
    b f238952d;

    /* renamed from: e, reason: collision with root package name */
    ImageManager f238953e;

    /* renamed from: f, reason: collision with root package name */
    IBitmapCache f238954f;

    /* renamed from: m, reason: collision with root package name */
    HttpDownloader f238957m;

    /* renamed from: i, reason: collision with root package name */
    Handler f238956i = new Handler(Looper.getMainLooper());
    Set<WeakReference<k52.a>> C = new HashSet();
    int E = 0;

    /* renamed from: h, reason: collision with root package name */
    DiskCache f238955h = new DiskCache(URLDrawableHelper.diskCachePath);
    long D = System.currentTimeMillis();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.base.image.RunningJob$6, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f238962d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f238963e;
        final /* synthetic */ RunningJob this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f238952d.f239007d || this.f238962d.get() == null) {
                return;
            }
            ((k52.a) this.f238962d.get()).c(this.this$0.f238952d, this.f238963e);
        }
    }

    public RunningJob(ImageManager imageManager, b bVar) {
        this.f238953e = imageManager;
        this.f238952d = bVar;
        this.f238954f = imageManager.mBitmapCache;
    }

    private void B(final Throwable th5, int i3) {
        String str;
        QLog.d(G, 1, "[job fail] failCode:" + i3 + this.f238952d + " " + th5 + " retryCount:" + this.E);
        b bVar = this.f238952d;
        if (bVar.f239020q == -2) {
            bVar.f239020q = i3;
        }
        this.f238953e.removeJob(bVar);
        if (this.f238952d.f239007d) {
            RIJImageOptReport.f(6, this.f238952d);
            RIJImageOptReport.h(this.f238952d, false, "cancelled");
            return;
        }
        b bVar2 = this.f238952d;
        if (bVar2.f239024u == b.f239003y) {
            if (th5 != null) {
                str = th5.getMessage();
            } else {
                str = "";
            }
            RIJImageOptReport.h(bVar2, false, str);
        }
        if (J()) {
            O(th5);
            return;
        }
        for (final WeakReference<k52.a> weakReference : this.C) {
            if (weakReference.get() != null) {
                this.f238956i.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.RunningJob.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RunningJob.this.f238952d.f239007d) {
                            RIJImageOptReport.f(6, RunningJob.this.f238952d);
                            RIJImageOptReport.h(RunningJob.this.f238952d, false, "cancelled");
                        } else if (weakReference.get() != null) {
                            ((k52.a) weakReference.get()).b(RunningJob.this.f238952d, th5);
                        }
                    }
                });
            }
        }
    }

    private void C(Bitmap bitmap) {
        this.f238953e.removeJob(this.f238952d);
        final com.tencent.mobileqq.kandian.base.image.imageloader.a aVar = new com.tencent.mobileqq.kandian.base.image.imageloader.a(E(bitmap), this.f238954f.getReleaser());
        this.f238954f.cacheBitmap(this.f238952d, aVar);
        if (this.f238952d.f239007d) {
            RIJImageOptReport.f(6, this.f238952d);
            RIJImageOptReport.h(this.f238952d, false, "cancelled");
            aVar.close();
        } else {
            RIJImageOptReport.f(5, this.f238952d);
            if (RIJImageOptConfig.INSTANCE.isRenderFirst()) {
                this.f238956i.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.RunningJob.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RunningJob.this.D(aVar);
                    }
                });
            } else {
                this.f238956i.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.RunningJob.3
                    @Override // java.lang.Runnable
                    public void run() {
                        RunningJob.this.D(aVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(com.tencent.mobileqq.kandian.base.image.imageloader.a aVar) {
        if (this.f238952d.f239007d) {
            RIJImageOptReport.f(6, this.f238952d);
            RIJImageOptReport.h(this.f238952d, false, "cancelled");
            aVar.close();
        } else {
            for (WeakReference<k52.a> weakReference : this.C) {
                if (weakReference.get() != null) {
                    weakReference.get().a(this.f238952d, aVar.mo197clone());
                }
            }
            aVar.close();
        }
    }

    private Bitmap E(Bitmap bitmap) {
        b bVar = this.f238952d;
        return bVar.f239010g == 1 ? BaseImageUtil.getRoundFaceBitmap(bitmap, bVar.f239005b, bVar.f239006c) : bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        b bVar = this.f238952d;
        if (bVar.f239019p == 0) {
            RIJImageOptReport.e(2, bVar);
        }
    }

    private static void H(boolean z16, long j3, int i3, boolean z17) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("showUseTime", Long.toString(j3));
        String str2 = "1";
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("cached", str);
        if (!z17) {
            str2 = "0";
        }
        hashMap.put("success", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actKandianImageShow", z17, j3, i3, hashMap, "", true);
    }

    private boolean I() {
        try {
            if (u()) {
                return true;
            }
            this.f238957m = new PublicAccountHttpDownloaderImpl().getHttpDownloader();
            DownloadParams p16 = p();
            boolean hasDiskFile = this.f238957m.hasDiskFile(p16);
            long currentTimeMillis = System.currentTimeMillis();
            this.F = r(p16, new StringBuilder());
            M();
            long currentTimeMillis2 = System.currentTimeMillis();
            long j3 = currentTimeMillis2 - currentTimeMillis;
            y(j3);
            L();
            if (K()) {
                return true;
            }
            j(hasDiskFile, currentTimeMillis2, j3);
            return false;
        } catch (Throwable th5) {
            e(th5);
            return false;
        }
    }

    private boolean J() {
        return this.f238952d.f239024u < b.f239003y;
    }

    private boolean K() {
        if (!this.f238952d.f239008e || !this.C.isEmpty()) {
            return false;
        }
        this.f238953e.removeJob(this.f238952d);
        QLog.d(G, 2, "[preload request]" + this.f238952d + " no callback, give up decode");
        ImageManager.get().removeExecuteJob(this.f238952d);
        return true;
    }

    private void L() {
        if (this.f238952d.f239007d) {
            throw new RuntimeException("cancel");
        }
    }

    private void M() throws IOException {
        if (this.F == null) {
            throw new IOException("downloader fail");
        }
    }

    private void N(Throwable th5) {
        QLog.d(G, 1, th5.getMessage() + " " + this.f238952d + " retryCount:" + this.E);
        int i3 = this.E;
        if (i3 == 0) {
            this.E = i3 + 1;
            File file = this.F;
            if (file != null) {
                file.delete();
            }
            run();
            return;
        }
        B(th5, -3);
    }

    private void O(Throwable th5) {
        this.f238952d.f239024u++;
        String str = G;
        QLog.d(str, 1, "try count: " + this.f238952d.f239024u + " " + this.f238952d);
        if ((th5 != null && th5.getMessage() != null && th5.getMessage().equals("sharpP decode fail")) || this.f238952d.f239020q == 400) {
            QLog.d(str, 1, "before convert: " + this.f238952d.f239004a);
            try {
                this.f238952d.f239004a = new URL(e.f239030a.b(this.f238952d.f239004a.toString(), this.f238952d.f239025v));
            } catch (Exception e16) {
                QLog.d(G, 1, e16.getMessage());
            }
            QLog.d(G, 1, "after convert: " + this.f238952d.f239004a);
        }
        if (this.f238952d.f239024u == b.f239003y && RIJImageOptConfig.INSTANCE.isRollbackToDomainConnect()) {
            b bVar = this.f238952d;
            bVar.f239026w = false;
            bVar.f239027x = false;
            f(bVar.f239004a);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.RunningJob.5
            @Override // java.lang.Runnable
            public void run() {
                RunningJob runningJob;
                ImageManager imageManager;
                for (WeakReference<k52.a> weakReference : RunningJob.this.C) {
                    if (weakReference.get() != null && (imageManager = (runningJob = RunningJob.this).f238953e) != null) {
                        imageManager.loadImage(runningJob.f238952d, weakReference.get());
                    }
                }
            }
        });
    }

    private void e(Throwable th5) {
        try {
            if (w(th5)) {
                B(th5, -3);
            } else if (s(th5)) {
                G(th5);
            } else if (t(th5)) {
                N(th5);
            } else {
                A(th5);
            }
        } catch (Exception e16) {
            A(e16);
        }
    }

    private synchronized void f(URL url) {
        try {
            HashMap hashMap = (HashMap) Reflect.on(InnerDns.getInstance()).get("mNetMap");
            if (hashMap != null) {
                Iterator it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    HashMap hashMap2 = (HashMap) ((Map.Entry) it.next()).getValue();
                    if (hashMap2.containsKey(url.getHost())) {
                        hashMap2.remove(url.getHost());
                        QLog.d(G, 2, " cleanHookInnerIps success!");
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.d(G, 1, th5.getMessage() + "  clean hook inner ips fail");
        }
    }

    private void j(boolean z16, long j3, long j16) {
        Bitmap m3 = m();
        long currentTimeMillis = System.currentTimeMillis();
        long j17 = currentTimeMillis - j3;
        x(m3, currentTimeMillis, j17);
        int i3 = 0;
        boolean z17 = m3 != null;
        if (z17 && m3 != null) {
            i3 = m3.getByteCount();
        }
        H(z16, j16 + j17, i3, z17);
        z(m3, z17);
    }

    private Bitmap l(boolean z16) {
        File file;
        Bitmap bitmap = null;
        if (z16 && (file = this.F) != null && this.f238952d != null) {
            try {
                e eVar = e.f239030a;
                BitmapFactory.Options f16 = eVar.f(file.getPath());
                if (f16.outWidth != -1 && f16.outHeight != -1) {
                    b bVar = this.f238952d;
                    int d16 = d(f16, bVar.f239005b, bVar.f239006c);
                    int i3 = f16.outWidth / d16;
                    int i16 = f16.outHeight / d16;
                    f16.outWidth = i3;
                    f16.outHeight = i16;
                    f16.inSampleSize = 1;
                    f16.inMutable = true;
                    Bitmap reusableBitmap = this.f238954f.getReusableBitmap(f16);
                    if (reusableBitmap != null) {
                        QLog.d(G, 2, "origin bitmap: " + reusableBitmap.getWidth() + " " + reusableBitmap.getHeight() + " after: " + i3 + " " + i16);
                        reusableBitmap.reconfigure(i3, i16, Bitmap.Config.ARGB_8888);
                    }
                    bitmap = eVar.e(this.F.getPath(), i3, i16, reusableBitmap);
                    if (reusableBitmap != null && bitmap != reusableBitmap) {
                        QLog.d(G, 2, "reuse failed");
                    }
                }
            } catch (Error e16) {
                QLog.d(G, 1, e16.getMessage());
            }
            if (bitmap == null) {
                QLog.d(G, 1, "sharpP bitmap is null");
            }
        }
        return bitmap;
    }

    private Rect o(BitmapFactory.Options options) {
        int min = Math.min(options.outWidth, 2048);
        int min2 = Math.min(options.outHeight, 2048);
        int i3 = (options.outWidth - min) / 2;
        int i16 = (options.outHeight - min2) / 2;
        return new Rect(i3, i16, min + i3, min2 + i16);
    }

    private DownloadParams p() {
        c cVar = new c();
        URL url = this.f238952d.f239004a;
        cVar.url = url;
        cVar.urlStr = url.toString();
        b bVar = this.f238952d;
        cVar.retryCount = bVar.f239024u;
        cVar.f239028a = bVar.f239026w;
        cVar.f239029b = bVar.f239027x;
        return cVar;
    }

    private BitmapFactory.Options q(InputStream inputStream) throws Exception {
        byte[] removeTempBuffer;
        BitmapFactory.Options options = new BitmapFactory.Options();
        synchronized (RunningJob.class) {
            removeTempBuffer = this.f238954f.getTempBufferSize() > 0 ? this.f238954f.removeTempBuffer(0) : null;
        }
        if (removeTempBuffer == null) {
            removeTempBuffer = new byte[16384];
            if (QLog.isColorLevel()) {
                com.tencent.mobileqq.kandian.base.image.imageloader.c.e(G, "allocate temp storage");
            }
        }
        options.inTempStorage = removeTempBuffer;
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(new BufferedInputStream(inputStream), null, options);
            if (options.outWidth != -1 && options.outHeight != -1) {
                options.inJustDecodeBounds = false;
                options.inDither = true;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inMutable = true;
                b bVar = this.f238952d;
                options.inSampleSize = d(options, bVar.f239005b, bVar.f239006c);
                return options;
            }
            throw new IllegalArgumentException("decode bounds fail");
        } catch (Exception e16) {
            this.f238954f.addTempBuffer(options.inTempStorage);
            throw e16;
        } catch (OutOfMemoryError e17) {
            this.f238954f.addTempBuffer(options.inTempStorage);
            throw e17;
        }
    }

    private File r(DownloadParams downloadParams, StringBuilder sb5) throws Exception {
        return this.f238957m.loadImageFile(downloadParams, new a(sb5));
    }

    private boolean s(Throwable th5) {
        return ((th5 instanceof RuntimeException) || (th5 instanceof IOException)) && th5.getMessage() != null && th5.getMessage().contains("cancel");
    }

    private boolean t(Throwable th5) {
        return th5.getMessage() != null && (((th5 instanceof RuntimeException) && th5.getMessage().contains("decode fail")) || ((th5 instanceof IOException) && th5.getMessage().contains("write 0 length file or null File")));
    }

    private boolean u() {
        if (!this.f238952d.f239007d) {
            return false;
        }
        RIJImageOptReport.f(6, this.f238952d);
        ImageManager.get().removeExecuteJob(this.f238952d);
        return true;
    }

    private boolean w(Throwable th5) {
        return (th5 instanceof RuntimeException) && th5.getMessage() != null && th5.getMessage().equals("sharpP decode fail");
    }

    private void x(Bitmap bitmap, long j3, long j16) {
        b bVar = this.f238952d;
        if (bVar != null) {
            bVar.f239016m = j16;
        }
    }

    private void y(long j3) {
        b bVar = this.f238952d;
        if (bVar != null) {
            bVar.f239015l = j3;
        }
    }

    public synchronized void c(k52.a aVar) {
        if (aVar != null) {
            this.C.add(new WeakReference<>(aVar));
        }
    }

    public void cancel() {
        if (QLog.isColorLevel()) {
            com.tencent.mobileqq.kandian.base.image.imageloader.c.e(G, "[cancel request]" + this.f238952d);
        }
        this.f238952d.f239007d = true;
        HttpDownloader httpDownloader = this.f238957m;
        if (httpDownloader != null) {
            httpDownloader.cancel();
        }
    }

    public Bitmap h(InputStream inputStream, InputStream inputStream2, long j3) throws Exception {
        if (com.tencent.mobileqq.kandian.base.image.imageloader.c.d()) {
            return i(inputStream, inputStream2, j3);
        }
        return k(inputStream, inputStream2, j3);
    }

    public Bitmap i(InputStream inputStream, InputStream inputStream2, long j3) throws Exception {
        boolean z16;
        Bitmap decodeStream;
        BitmapFactory.Options q16 = q(inputStream2);
        Bitmap reusableBitmap = this.f238954f.getReusableBitmap(q16);
        if (reusableBitmap != null) {
            q16.inBitmap = reusableBitmap;
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                if (com.tencent.mobileqq.kandian.base.image.imageloader.c.g(q16)) {
                    decodeStream = BitmapRegionDecoder.newInstance((InputStream) bufferedInputStream, false).decodeRegion(o(q16), q16);
                } else {
                    decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, q16);
                }
                if (!z16 || reusableBitmap == decodeStream) {
                    return decodeStream;
                }
                decodeStream.recycle();
                throw new IllegalStateException();
            } catch (OutOfMemoryError e16) {
                throw e16;
            } catch (RuntimeException e17) {
                throw e17;
            }
        } finally {
            this.f238954f.addTempBuffer(q16.inTempStorage);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap k(InputStream inputStream, InputStream inputStream2, long j3) throws Exception {
        Bitmap decodeByteArray;
        BitmapFactory.Options q16 = q(inputStream2);
        ?? r06 = NativeBitmap.f238949a;
        q16.inPurgeable = r06;
        int i3 = (int) j3;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    byte[] b16 = this.f238954f.getBytePool().b(i3);
                    bufferedInputStream.read(b16, 0, i3);
                    if (com.tencent.mobileqq.kandian.base.image.imageloader.c.g(q16)) {
                        decodeByteArray = BitmapRegionDecoder.newInstance(b16, 0, i3, false).decodeRegion(o(q16), q16);
                    } else {
                        decodeByteArray = BitmapFactory.decodeByteArray(b16, 0, i3, q16);
                    }
                    if (NativeBitmap.f238949a) {
                        NativeBitmap.nativePinBitmap(decodeByteArray);
                    }
                    if (b16 != null) {
                        this.f238954f.getBytePool().c(b16);
                    }
                    this.f238954f.addTempBuffer(q16.inTempStorage);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return decodeByteArray;
                } catch (Exception e17) {
                    throw e17;
                } catch (OutOfMemoryError e18) {
                    throw e18;
                }
            } catch (Exception e19) {
                throw e19;
            } catch (OutOfMemoryError e26) {
                throw e26;
            } catch (Throwable th5) {
                th = th5;
                r06 = 0;
                if (0 != 0) {
                }
                this.f238954f.addTempBuffer(q16.inTempStorage);
                if (r06 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                this.f238954f.getBytePool().c(null);
            }
            this.f238954f.addTempBuffer(q16.inTempStorage);
            if (r06 != 0) {
                try {
                    r06.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            }
            throw th;
        }
    }

    protected Bitmap n(InputStream inputStream, InputStream inputStream2, long j3, boolean z16) throws Exception {
        Bitmap l3 = l(z16);
        return l3 == null ? h(inputStream, inputStream2, j3) : l3;
    }

    private void A(Throwable th5) {
        B(th5, -1);
    }

    private void G(Throwable th5) {
        RIJImageOptReport.f(6, this.f238952d);
        RIJImageOptReport.h(this.f238952d, false, th5.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.tencent.mobileqq.kandian.base.image.RunningJob] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private Bitmap m() {
        InputStream inputStream;
        Throwable th5;
        ?? r16;
        Exception e16;
        Throwable th6;
        Exception exc;
        long length;
        boolean v3;
        boolean z16;
        InputStream inputStream2 = null;
        try {
            try {
                r16 = this.F instanceof RIJImageOptBitmapFile;
            } catch (Exception e17) {
                inputStream = null;
                e16 = e17;
                r16 = 0;
            } catch (Throwable th7) {
                inputStream = null;
                th5 = th7;
                r16 = 0;
            }
            try {
                try {
                    if (r16 != 0) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(((RIJImageOptBitmapFile) this.F).getBytes());
                        inputStream = new ByteArrayInputStream(((RIJImageOptBitmapFile) this.F).getBytes());
                        length = ((RIJImageOptBitmapFile) this.F).getLength();
                        v3 = false;
                        r16 = byteArrayInputStream;
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(this.F);
                        inputStream = new FileInputStream(this.F);
                        length = this.F.length();
                        v3 = v();
                        r16 = fileInputStream;
                    }
                    z16 = v3;
                    inputStream2 = r16;
                } catch (Exception e18) {
                    exc = e18;
                    inputStream = inputStream2;
                    r16 = r16;
                } catch (Throwable th8) {
                    th6 = th8;
                    inputStream = inputStream2;
                    r16 = r16;
                }
                try {
                    Bitmap n3 = n(inputStream2, inputStream, length, z16);
                    g(inputStream2);
                    g(inputStream);
                    return n3;
                } catch (Exception e19) {
                    exc = e19;
                    r16 = inputStream2;
                    e16 = exc;
                    throw new RuntimeException("[decode fail]" + e16.toString());
                } catch (Throwable th9) {
                    th6 = th9;
                    r16 = inputStream2;
                    th5 = th6;
                    g(r16);
                    g(inputStream);
                    throw th5;
                }
            } catch (Exception e26) {
                e16 = e26;
                throw new RuntimeException("[decode fail]" + e16.toString());
            }
        } catch (Throwable th10) {
            th5 = th10;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        RIJImageOptReport.f(4, this.f238952d);
        ImageManager.get().putExecuteJob(this.f238952d);
        if (I()) {
            return;
        }
        ImageManager.get().removeExecuteJob(this.f238952d);
    }

    private void g(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                QLog.d(G, 1, e16.getMessage());
            }
        }
    }

    private void z(Bitmap bitmap, boolean z16) {
        if (z16) {
            C(bitmap);
        } else {
            A(new RuntimeException("bitmap null"));
        }
    }

    protected boolean v() {
        String str;
        try {
            if (!com.tencent.qqsharpP.a.e() || !RIJImageOptConfig.INSTANCE.useSharpP()) {
                return false;
            }
            e eVar = e.f239030a;
            URL url = this.f238952d.f239004a;
            if (url != null) {
                str = url.toString();
            } else {
                str = "";
            }
            if (eVar.h(str)) {
                return SharpPUtil.isSharpPFile(this.F);
            }
            return false;
        } catch (Throwable th5) {
            QLog.d(G, 1, th5.getMessage());
            return false;
        }
    }

    public static int d(BitmapFactory.Options options, int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 && i16 != 0 && i3 != -1 && i16 != -1) {
            int min = Math.min(options.outHeight, 2048);
            int min2 = Math.min(options.outWidth, 2048);
            while (min > i16 && min2 > i3) {
                int round = Math.round(min / i16);
                int round2 = Math.round(min2 / i3);
                if (round <= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                min2 >>= 1;
                min >>= 1;
                i17 <<= 1;
            }
        }
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ StringBuilder f238964d;

        a(StringBuilder sb5) {
            this.f238964d = sb5;
        }

        @Override // com.tencent.mobileqq.kandian.base.image.d
        public void a(String str) {
            RunningJob.this.f238952d.f239022s = str;
        }

        @Override // com.tencent.image.URLDrawableHandler
        public boolean isCancelled() {
            return false;
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadFailed(int i3) {
            QLog.d(RunningJob.G, 1, "receive image data error: " + i3 + " progress: " + ((Object) this.f238964d));
            RunningJob.this.f238952d.f239020q = i3;
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadStarted() {
            RIJImageOptReport.e(3, RunningJob.this.f238952d);
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadSucceed(long j3) {
            RunningJob.this.F();
            RunningJob.this.f238952d.f239023t = j3;
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void publishProgress(int i3) {
            this.f238964d.append(System.currentTimeMillis() + " " + i3 + " ");
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void doCancel() {
        }
    }
}
